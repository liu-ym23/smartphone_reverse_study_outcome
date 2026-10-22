package com.android.server.location.contexthub;

import android.app.AppOpsManager;
import android.content.Context;
import android.hardware.contexthub.EndpointInfo;
import android.hardware.contexthub.HubEndpointInfo;
import android.hardware.contexthub.HubMessage;
import android.hardware.contexthub.IContextHubEndpoint;
import android.hardware.contexthub.IContextHubEndpointCallback;
import android.hardware.contexthub.IEndpointCommunication;
import android.hardware.contexthub.Message;
import android.hardware.contexthub.MessageDeliveryStatus;
import android.hardware.location.IContextHubTransactionCallback;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.WorkSource;
import android.util.Log;
import android.util.SparseArray;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class ContextHubEndpointBroker extends IContextHubEndpoint.Stub implements IBinder.DeathRecipient, AppOpsManager.OnOpChangedListener {
    static final long OPEN_SESSION_REQUEST_TIMEOUT_SECONDS = 10;
    private static final String RECEIVE_MSG_NOTE = "ContextHubEndpointMessageDelivery";
    private static final String TAG = "ContextHubEndpointBroker";
    private static final long WAKELOCK_TIMEOUT_MILLIS = 5000;
    private final AppOpsManager mAppOpsManager;
    private final String mAttributionTag;
    private final Context mContext;
    private final IContextHubEndpointCallback mContextHubEndpointCallback;
    private final HubEndpointInfo mEndpointInfo;
    private final ContextHubEndpointManager mEndpointManager;
    private final EndpointInfo mHalEndpointInfo;
    private final IEndpointCommunication mHubInterface;
    private boolean mIsRegistered;
    private final Object mOpenSessionLock;
    private final String mPackageName;
    private final int mPid;
    private final Object mRegistrationLock;
    private final SparseArray<Session> mSessionMap;
    private final ScheduledExecutorService mSessionTimeoutExecutor;
    private final ContextHubTransactionManager mTransactionManager;
    private final int mUid;
    private final PowerManager.WakeLock mWakeLock;

    interface CallbackConsumer {
        void accept(IContextHubEndpointCallback r1) throws RemoteException;
    }

    static class Session {
        private final Set<Integer> mPendingSequenceNumbers;
        private final HubEndpointInfo mRemoteEndpointInfo;
        private final boolean mRemoteInitiated;
        private final LinkedHashMap<Integer, Long> mRxMessageHistoryMap;
        private ScheduledFuture<?> mSessionOpenTimeoutFuture;
        private SessionState mSessionState;

        static final enum SessionState extends Enum<SessionState> {
            private static final /* synthetic */ SessionState[] $VALUES = null;
            public static final SessionState ACTIVE = null;
            public static final SessionState PENDING = null;

            private static /* synthetic */ SessionState[] $values() {
                return new SessionState[]{PENDING, ACTIVE};
            }

            private SessionState(String r1, int r2) {
                super(r1, r2);
            }

            public static SessionState valueOf(String name) {
                return (SessionState) Enum.valueOf(SessionState.class, name);
            }

            public static SessionState[] values() {
                return (SessionState[]) $VALUES.clone();
            }

            static {
                PENDING = new SessionState("PENDING", 0);
                ACTIVE = new SessionState("ACTIVE", 1);
                $VALUES = $values();
            }
        }

        Session(HubEndpointInfo remoteEndpointInfo, boolean remoteInitiated) {
            this.mSessionState = SessionState.PENDING;
            this.mPendingSequenceNumbers = new HashSet();
            this.mRxMessageHistoryMap = new LinkedHashMap();
            this.mRemoteEndpointInfo = remoteEndpointInfo;
            this.mRemoteInitiated = remoteInitiated;
        }

        public boolean isRemoteInitiated() {
            return this.mRemoteInitiated;
        }

        public HubEndpointInfo getRemoteEndpointInfo() {
            return this.mRemoteEndpointInfo;
        }

        public void setSessionState(SessionState state) {
            this.mSessionState = state;
        }

        public void setSessionOpenTimeoutFuture(ScheduledFuture<?> future) {
            this.mSessionOpenTimeoutFuture = future;
        }

        public void cancelSessionOpenTimeoutFuture() {
            if (this.mSessionOpenTimeoutFuture == null) goto L5;
            this.mSessionOpenTimeoutFuture.cancel(false);
        L5:
            this.mSessionOpenTimeoutFuture = null;
        }

        public boolean isActive() {
            if (this.mSessionState != SessionState.ACTIVE) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isReliableMessagePending(int sequenceNumber) {
            return this.mPendingSequenceNumbers.contains(Integer.valueOf(sequenceNumber));
        }

        public void setReliableMessagePending(int sequenceNumber) {
            this.mPendingSequenceNumbers.add(Integer.valueOf(sequenceNumber));
        }

        public void setReliableMessageCompleted(int sequenceNumber) {
            this.mPendingSequenceNumbers.remove(Integer.valueOf(sequenceNumber));
        }

        public void forEachPendingReliableMessage(Consumer<Integer> consumer) {
            Iterator<Integer> r0 = this.mPendingSequenceNumbers.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            int sequenceNumber = r0.next().intValue();
            consumer.accept(Integer.valueOf(sequenceNumber));
            goto L4
        }

        public boolean isInReliableMessageHistory(HubMessage message) {
            if (message.isResponseRequired() == true) goto L6;
            return false;
        L6:
            Iterator<Map.Entry<Integer, Long>> iterator = this.mRxMessageHistoryMap.entrySet().iterator();
            long nowMillis = System.currentTimeMillis();
        L8:
            if (iterator.hasNext() == false) goto L13;
            Map.Entry<Integer, Long> nextEntry = iterator.next();
            long expiryMillis = ContextHubTransactionManager.RELIABLE_MESSAGE_DUPLICATE_DETECTION_TIMEOUT.toMillis();
            if (nowMillis < (nextEntry.getValue().longValue() + expiryMillis)) goto L13;
            iterator.remove();
        L13:
            return this.mRxMessageHistoryMap.containsKey(Integer.valueOf(message.getMessageSequenceNumber()));
        }

        public void addReliableMessageToHistory(HubMessage message) {
            if (message.isResponseRequired() == true) goto L6;
            return;
        L6:
            if (this.mRxMessageHistoryMap.containsKey(Integer.valueOf(message.getMessageSequenceNumber())) == false) goto L9;
            long value = this.mRxMessageHistoryMap.get(Integer.valueOf(message.getMessageSequenceNumber())).longValue();
            Log.w(ContextHubEndpointBroker.TAG, "Message already exists in history (inserted @ " + value + " ms): " + message);
            return;
        L9:
            this.mRxMessageHistoryMap.put(Integer.valueOf(message.getMessageSequenceNumber()), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static /* synthetic */ void $r8$lambda$0MnjOblYAsLSXxetld0kGl6KqD4(int r0, byte r1, IContextHubEndpointCallback r2) {
        lambda$onCloseEndpointSession$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$1_Sq13Ax0iPDidth5a-st16Jipc, reason: not valid java name */
    public static /* synthetic */ void m5168$r8$lambda$1_Sq13Ax0iPDidth5ast16Jipc(ContextHubEndpointBroker r0) {
        r0.lambda$releaseWakeLockOnExit$9();
    }

    public static /* synthetic */ void $r8$lambda$7jQ2OuD3AqF04vtbBmMuuxwpJzk(int r0, HubEndpointInfo r1, String r2, IContextHubEndpointCallback r3) {
        lambda$onEndpointSessionOpenRequest$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$FdieIogE4BxLJhZ3eM5ccTTj9EE(ContextHubEndpointBroker r0, HubEndpointInfo r1) {
        r0.lambda$onMessageReceivedInternal$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$HWcxAELH4hGbJZpFXLx8FYELM3Q(ContextHubEndpointBroker r0) {
        r0.lambda$releaseWakeLock$8();
    }

    public static /* synthetic */ void $r8$lambda$TeYeitRpnVnL937nMEKSkrgZI9k(int r0, HubMessage r1, IContextHubEndpointCallback r2) {
        lambda$onMessageReceivedInternal$5(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$gd_1mLftwue2U8OmWWZr7GtiZ-g, reason: not valid java name */
    public static /* synthetic */ void m5169$r8$lambda$gd_1mLftwue2U8OmWWZr7GtiZg(ContextHubEndpointBroker r0, Integer r1) {
        r0.lambda$cleanupSessionResources$6(r1);
    }

    public static /* synthetic */ void $r8$lambda$qD2YtMhpFVreMM0IbmGZFywGCTM(int r0, IContextHubEndpointCallback r1) {
        lambda$onEndpointSessionOpenComplete$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$uRha1yE4ml5y8xm29Co7CNs2W3g(ContextHubEndpointBroker r0) {
        r0.lambda$acquireWakeLock$7();
    }

    /* JADX INFO: renamed from: $r8$lambda$uZ6Y8HfPFXazSN-7Ce-TtTUzIB0, reason: not valid java name */
    public static /* synthetic */ void m5170$r8$lambda$uZ6Y8HfPFXazSN7CeTtTUzIB0(ContextHubEndpointBroker r0, int r1) {
        r0.lambda$onEndpointSessionOpenRequest$2(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifySessionClosedToBoth, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5171$$Nest$mnotifySessionClosedToBoth(ContextHubEndpointBroker r0, int r1, byte r2) {
        r0.notifySessionClosedToBoth(r1, r2);
    }

    ContextHubEndpointBroker(Context context, IEndpointCommunication hubInterface, ContextHubEndpointManager endpointManager, EndpointInfo halEndpointInfo, IContextHubEndpointCallback callback, String packageName, String attributionTag, ContextHubTransactionManager transactionManager, ScheduledExecutorService sessionTimeoutExecutor) {
        this.mIsRegistered = false;
        this.mRegistrationLock = new Object();
        this.mOpenSessionLock = new Object();
        this.mSessionMap = new SparseArray();
        this.mContext = context;
        this.mHubInterface = hubInterface;
        this.mEndpointManager = endpointManager;
        this.mEndpointInfo = new HubEndpointInfo(halEndpointInfo);
        this.mHalEndpointInfo = halEndpointInfo;
        this.mContextHubEndpointCallback = callback;
        this.mPackageName = packageName;
        this.mAttributionTag = attributionTag;
        this.mTransactionManager = transactionManager;
        this.mSessionTimeoutExecutor = sessionTimeoutExecutor;
        this.mPid = Binder.getCallingPid();
        this.mUid = Binder.getCallingUid();
        this.mAppOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        this.mAppOpsManager.startWatchingMode(-1, this.mPackageName, this);
        PowerManager powerManager = (PowerManager) context.getSystemService(PowerManager.class);
        this.mWakeLock = powerManager.newWakeLock(1, TAG);
        this.mWakeLock.setWorkSource(new WorkSource(this.mUid, this.mPackageName));
        this.mWakeLock.setReferenceCounted(true);
    }

    public HubEndpointInfo getAssignedHubEndpointInfo() {
        return this.mEndpointInfo;
    }

    public int openSession(HubEndpointInfo destination, String serviceDescriptor) throws RemoteException {
        super.openSession_enforcePermission();
        if (isRegistered() == false) goto L21;
        if (hasEndpointPermissions(destination) == false) goto L19;
        int sessionId = this.mEndpointManager.reserveSessionId();
        EndpointInfo halEndpointInfo = ContextHubServiceUtil.convertHalEndpointInfo(destination);
        Log.d(TAG, "openSession: sessionId=" + sessionId);
        Object r2 = this.mOpenSessionLock;
        monitor-enter(r2);
        this.mSessionMap.put(sessionId, new Session(destination, false));     // Catch: Throwable -> L11 Throwable -> L13
        this.mHubInterface.openEndpointSession(sessionId, halEndpointInfo.id, this.mHalEndpointInfo.id, serviceDescriptor);     // Catch: Throwable -> L11 Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L11
        return sessionId;
    L13:
        e = move-exception;
        Log.e(TAG, "Exception while calling HAL openEndpointSession", e);     // Catch: Throwable -> L11
        cleanupSessionResources(sessionId);     // Catch: Throwable -> L11
        throw e;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L19:
        throw new SecurityException("Insufficient permission to open a session with endpoint: " + destination);
    L21:
        throw new IllegalStateException("Endpoint is not registered");
    }

    public void closeSession(int sessionId, int reason) throws RemoteException {
        super.closeSession_enforcePermission();
        if (isRegistered() == false) goto L11;
        if (cleanupSessionResources(sessionId) == false) goto L9;
        Log.d(TAG, "closeSession: sessionId=" + sessionId + " reason=" + reason);
        this.mEndpointManager.halCloseEndpointSession(sessionId, ContextHubServiceUtil.toHalReason(reason));
        return;
    L9:
        throw new IllegalArgumentException("Unknown session ID in closeSession: id=" + sessionId);
    L11:
        throw new IllegalStateException("Endpoint is not registered");
    }

    public void unregister() {
        super.unregister_enforcePermission();
        Object r0 = this.mOpenSessionLock;
        monitor-enter(r0);
        int i = this.mSessionMap.size() - 1;     // Catch: Throwable -> L7
    L5:
        if (i < 0) goto L10;
        int id = this.mSessionMap.keyAt(i);     // Catch: Throwable -> L7
        this.mEndpointManager.halCloseEndpointSessionNoThrow(id, (byte) 6);     // Catch: Throwable -> L7
        cleanupSessionResources(id);     // Catch: Throwable -> L7
        i = i - 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        Object r1 = this.mRegistrationLock;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (isRegistered() == true) goto L20;
        Log.w(TAG, "Attempting to unregister when already unregistered");     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L20:
        this.mIsRegistered = false;     // Catch: Throwable -> L18
        this.mHubInterface.unregisterEndpoint(this.mHalEndpointInfo);     // Catch: Throwable -> L18 RemoteException -> L23
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L18
        this.mEndpointManager.unregisterEndpoint(this.mEndpointInfo.getIdentifier().getEndpoint());
        releaseWakeLockOnExit();
        return;
    L23:
        e = move-exception;
        Log.e(TAG, "RemoteException while calling HAL unregisterEndpoint", e);     // Catch: Throwable -> L18
    L7:
        th = move-exception;
        throw th;
    }

    public void openSessionRequestComplete(int sessionId) {
        super.openSessionRequestComplete_enforcePermission();
        Object r0 = this.mOpenSessionLock;
        monitor-enter(r0);
        Session info = this.mSessionMap.get(sessionId);     // Catch: Throwable -> L8
        if (info == null) goto L15;
        this.mHubInterface.endpointSessionOpenComplete(sessionId);     // Catch: Throwable -> L8 Throwable -> L10
        info.cancelSessionOpenTimeoutFuture();     // Catch: Throwable -> L8 Throwable -> L10
        info.setSessionState(Session.SessionState.ACTIVE);     // Catch: Throwable -> L8 Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "Exception while calling endpointSessionOpenComplete", e);     // Catch: Throwable -> L8
        goto L12
    L15:
        throw new IllegalArgumentException("openSessionRequestComplete for invalid session id=" + sessionId);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void sendMessage(final int sessionId, final HubMessage message, final IContextHubTransactionCallback callback) {
        super.sendMessage_enforcePermission();
        Object r1 = this.mOpenSessionLock;
        monitor-enter(r1);
        Session info = this.mSessionMap.get(sessionId);     // Catch: Throwable -> L29
        if (info == null) goto L34;
        if (info.isActive() == false) goto L32;
        Message halMessage = ContextHubServiceUtil.createHalMessage(message);     // Catch: Throwable -> L29
        if (callback == null) goto L40;
        IContextHubTransactionCallback wrappedCallback = new AnonymousClass1(this, callback, message, sessionId);     // Catch: Throwable -> L29
        ContextHubServiceTransaction transaction = this.mTransactionManager.createSessionMessageTransaction(this.mHubInterface, sessionId, halMessage, this.mPackageName, wrappedCallback);     // Catch: Throwable -> L23
        this.mTransactionManager.addTransaction(transaction);     // Catch: Throwable -> L23 IllegalStateException -> L25
        info.setReliableMessagePending(transaction.getMessageSequenceNumber());     // Catch: Throwable -> L23 IllegalStateException -> L25
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L23
        return;
    L25:
        e = move-exception;
        Log.e(TAG, "Unable to add a transaction in sendMessageToEndpoint (session ID = " + sessionId + ")", e);     // Catch: Throwable -> L23
        transaction.onTransactionComplete(7);     // Catch: Throwable -> L23
        goto L27
    L40:
        this.mHubInterface.sendMessageToEndpoint(sessionId, halMessage);     // Catch: Throwable -> L13 RemoteException -> L15
    L12:
        goto L27
    L15:
        e = move-exception;
        Log.e(TAG, "Exception while sending message on session " + sessionId + ", closing session", e);     // Catch: Throwable -> L13
        notifySessionClosedToBoth(sessionId, (byte) 0);     // Catch: Throwable -> L13
    L13:
        th = th;
    L35:
        monitor-exit(r1);     // Catch: Throwable -> L23
        throw th;
    L32:
        throw new SecurityException("sendMessage called on inactive session (id= " + sessionId + ")");     // Catch: Throwable -> L23
    L34:
        throw new IllegalArgumentException("sendMessage for invalid session id=" + sessionId);     // Catch: Throwable -> L23
    L23:
        th = th;
    L29:
        th = th;
        goto L35
    }

    public void sendMessageDeliveryStatus(int sessionId, int messageSeqNumber, byte errorCode) {
        super.sendMessageDeliveryStatus_enforcePermission();
        MessageDeliveryStatus status = new MessageDeliveryStatus();
        status.messageSequenceNumber = messageSeqNumber;
        status.errorCode = errorCode;
        this.mHubInterface.sendMessageDeliveryStatusToEndpoint(sessionId, status);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Log.w(TAG, "Exception while sending message delivery status on session " + sessionId, e);
    }

    public void onCallbackFinished() {
        super.onCallbackFinished_enforcePermission();
        releaseWakeLock();
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        if (isRegistered() == false) goto L6;
        unregister();
        return;
    }

    @Override // android.app.AppOpsManager.OnOpChangedListener
    public void onOpChanged(String op, String packageName) {
        if (packageName.equals(this.mPackageName) == true) goto L5;
        Log.w(TAG, "onOpChanged called with invalid package " + packageName + " expected " + this.mPackageName);
        return;
    L5:
        Object r0 = this.mOpenSessionLock;
        monitor-enter(r0);
        int i = this.mSessionMap.size() - 1;     // Catch: Throwable -> L12
    L8:
        if (i < 0) goto L16;
        int id = this.mSessionMap.keyAt(i);     // Catch: Throwable -> L12
        HubEndpointInfo target = this.mSessionMap.get(id).getRemoteEndpointInfo();     // Catch: Throwable -> L12
        if (hasEndpointPermissions(target) == true) goto L14;
        notifySessionClosedToBoth(id, (byte) 9);     // Catch: Throwable -> L12
    L14:
        i = i - 1;     // Catch: Throwable -> L12
        goto L8
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mEndpointInfo);
        sb.append(", ");
        sb.append("package: ");
        sb.append(this.mPackageName);
        sb.append(", ");
        PowerManager.WakeLock r1 = this.mWakeLock;
        monitor-enter(r1);
        sb.append("wakelock: ");     // Catch: Throwable -> L23
        sb.append(this.mWakeLock);     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
        Object r2 = this.mOpenSessionLock;
        monitor-enter(r2);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (this.mSessionMap.size() == 0) goto L13;
        sb.append(System.lineSeparator());     // Catch: Throwable -> L11
        sb.append(" sessions: ");     // Catch: Throwable -> L11
        sb.append(System.lineSeparator());     // Catch: Throwable -> L11
    L13:
        int i = 0;
    L15:
        if (i >= this.mSessionMap.size()) goto L18;
        int id = this.mSessionMap.keyAt(i);     // Catch: Throwable -> L11
        int count = i + 1;     // Catch: Throwable -> L11
        sb.append("  " + count + ". id=" + id + ", remote:" + this.mSessionMap.get(id).getRemoteEndpointInfo());     // Catch: Throwable -> L11
        sb.append(System.lineSeparator());     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L15
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L11
        return sb.toString();
    L23:
        th = move-exception;
        throw th;
    }

    void register() throws RemoteException {
        Object r0 = this.mRegistrationLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (isRegistered() == false) goto L9;
        Log.w(TAG, "Attempting to register when already registered");     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mHubInterface.registerEndpoint(this.mHalEndpointInfo);     // Catch: Throwable -> L7
        this.mIsRegistered = true;     // Catch: Throwable -> L7
        goto L10
    }

    void attachDeathRecipient() throws RemoteException {
        this.mContextHubEndpointCallback.asBinder().linkToDeath(this, 0);
    }

    void onCloseEndpointSession(final int sessionId, final byte reason) {
        if (cleanupSessionResources(sessionId) == true) goto L6;
        Log.w(TAG, "Unknown session ID in onCloseEndpointSession: id=" + sessionId);
        return;
    L6:
        invokeCallback(new ContextHubEndpointBroker$$ExternalSyntheticLambda4(sessionId, reason));
    }

    private static /* synthetic */ void lambda$onCloseEndpointSession$0(int sessionId, byte reason, IContextHubEndpointCallback consumer) throws RemoteException {
        consumer.onSessionClosed(sessionId, ContextHubServiceUtil.toAppHubEndpointReason(reason));
    }

    void onEndpointSessionOpenComplete(final int sessionId) {
        Object r0 = this.mOpenSessionLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (hasSessionId(sessionId) == true) goto L11;
        Log.w(TAG, "Unknown session ID in onEndpointSessionOpenComplete: id=" + sessionId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mSessionMap.get(sessionId).setSessionState(Session.SessionState.ACTIVE);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        invokeCallback(new ContextHubEndpointBroker$$ExternalSyntheticLambda9(sessionId));
    }

    private static /* synthetic */ void lambda$onEndpointSessionOpenComplete$1(int sessionId, IContextHubEndpointCallback consumer) throws RemoteException {
        consumer.onSessionOpenComplete(sessionId);
    }

    void onMessageReceived(int sessionId, HubMessage message) {
        byte errorCode = onMessageReceivedInternal(sessionId, message);
        if (errorCode == 0) goto L13;
        Log.e(TAG, "Failed to send message to endpoint: " + message + ", closing session");
        if (message.isResponseRequired() == false) goto L8;
        sendMessageDeliveryStatus(sessionId, message.getMessageSequenceNumber(), errorCode);
        return;
    L8:
        if (errorCode != 3) goto L10;
        byte r1 = 9;
    L11:
        notifySessionClosedToBoth(sessionId, r1);
        return;
    L10:
        r1 = 0;
        goto L11
    }

    void onMessageDeliveryStatusReceived(int sessionId, int sequenceNumber, byte errorCode) {
        Object r0 = this.mOpenSessionLock;
        monitor-enter(r0);
        Session info = this.mSessionMap.get(sessionId);     // Catch: Throwable -> L14
        if (info == null) goto L24;
        if (info.isActive() == false) goto L24;
        if (info.isReliableMessagePending(sequenceNumber) == true) goto L16;
        Log.w(TAG, "Received delivery status for unknown seq: " + sequenceNumber);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L16:
        info.setReliableMessageCompleted(sequenceNumber);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        ContextHubTransactionManager r1 = this.mTransactionManager;
        if (errorCode != 0) goto L21;
        boolean r2 = true;
    L22:
        r1.onMessageDeliveryResponse(sequenceNumber, r2);
        return;
    L21:
        r2 = false;
    L24:
        Log.w(TAG, "Received delivery status for invalid session: id=" + sessionId);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    boolean hasSessionId(int sessionId) {
        Object r0 = this.mOpenSessionLock;
        monitor-enter(r0);
        boolean r1 = this.mSessionMap.contains(sessionId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void onHalRestart() {
        Object r0 = this.mRegistrationLock;
        monitor-enter(r0);
        this.mIsRegistered = false;     // Catch: Throwable -> L8
        register();     // Catch: Throwable -> L8 RemoteException -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L8
        Object r1 = this.mOpenSessionLock;
        monitor-enter(r1);
        int i = this.mSessionMap.size() - 1;     // Catch: Throwable -> L18
    L16:
        if (i < 0) goto L21;
        int id = this.mSessionMap.keyAt(i);     // Catch: Throwable -> L18
        onCloseEndpointSession(id, (byte) 8);     // Catch: Throwable -> L18
        i = i - 1;     // Catch: Throwable -> L18
        goto L16
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        Log.e(TAG, "RemoteException while calling HAL registerEndpoint", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    Optional<Byte> onEndpointSessionOpenRequest(final int sessionId, final HubEndpointInfo initiator, final String serviceDescriptor) {
        if (hasEndpointPermissions(initiator) == true) goto L6;
        Log.e(TAG, "onEndpointSessionOpenRequest: " + initiator + " doesn't have permission for " + this.mEndpointInfo);
        onCloseEndpointSession(sessionId, (byte) 9);
        return Optional.of((byte) 9);
    L6:
        Object r0 = this.mOpenSessionLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (hasSessionId(sessionId) == false) goto L13;
        boolean existingSession = true;
        boolean existingSessionActive = this.mSessionMap.get(sessionId).isActive();     // Catch: Throwable -> L11
        Log.w(TAG, "onEndpointSessionOpenRequest: Existing session ID: " + sessionId + ", isActive: " + existingSessionActive);     // Catch: Throwable -> L11
    L14:
        if (existingSession == false) goto L21;
        if (existingSessionActive == false) goto L17;
        openSessionRequestComplete(sessionId);     // Catch: Throwable -> L11
    L17:
        Optional<Byte> r3 = Optional.empty();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r3;
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L11
        boolean success = invokeCallback(new ContextHubEndpointBroker$$ExternalSyntheticLambda1(sessionId, initiator, serviceDescriptor));
        if (success == true) goto L25;
        onCloseEndpointSession(sessionId, (byte) 0);
    L25:
        if (success == false) goto L28;
        return Optional.empty();
    L28:
        return Optional.of((byte) 0);
    L13:
        existingSession = false;
        existingSessionActive = false;
        Session pendingSession = new Session(initiator, true);     // Catch: Throwable -> L11
        pendingSession.setSessionOpenTimeoutFuture(this.mSessionTimeoutExecutor.schedule(new ContextHubEndpointBroker$$ExternalSyntheticLambda0(this, sessionId), OPEN_SESSION_REQUEST_TIMEOUT_SECONDS, TimeUnit.SECONDS));     // Catch: Throwable -> L11
        this.mSessionMap.put(sessionId, pendingSession);     // Catch: Throwable -> L11
        goto L14
    }

    private /* synthetic */ void lambda$onEndpointSessionOpenRequest$2(int sessionId) {
        onEndpointSessionOpenRequestTimeout(sessionId);
    }

    private static /* synthetic */ void lambda$onEndpointSessionOpenRequest$3(int sessionId, HubEndpointInfo initiator, String serviceDescriptor, IContextHubEndpointCallback consumer) throws RemoteException {
        consumer.onSessionOpenRequest(sessionId, initiator, serviceDescriptor);
    }

    private void onEndpointSessionOpenRequestTimeout(int sessionId) {
        Object r0 = this.mOpenSessionLock;
        monitor-enter(r0);
        Session s = this.mSessionMap.get(sessionId);     // Catch: Throwable -> L12
        if (s == null) goto L14;
        if (s.isActive() == true) goto L14;
        Log.w(TAG, "onEndpointSessionOpenRequestTimeout: clean up session, id: " + sessionId);     // Catch: Throwable -> L12
        cleanupSessionResources(sessionId);     // Catch: Throwable -> L12
        this.mEndpointManager.halCloseEndpointSessionNoThrow(sessionId, (byte) 2);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private byte onMessageReceivedInternal(final int sessionId, final HubMessage message) {
        Object r0 = this.mOpenSessionLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isSessionActive(sessionId) == true) goto L12;
        Log.e(TAG, "Dropping message for inactive session (id=" + sessionId + ") with message: " + message);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return 2;
    L12:
        final HubEndpointInfo remote = this.mSessionMap.get(sessionId).getRemoteEndpointInfo();     // Catch: Throwable -> L10
        byte r3 = 1;
        if (this.mSessionMap.get(sessionId).isInReliableMessageHistory(message) == false) goto L32;
        Log.e(TAG, "Dropping duplicate message: " + message);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return 1;
    L32:
        Binder.withCleanCallingIdentity(new ContextHubEndpointBroker$$ExternalSyntheticLambda5(this, remote));     // Catch: Throwable -> L10 RuntimeException -> L25
        boolean success = invokeCallback(new ContextHubEndpointBroker$$ExternalSyntheticLambda6(sessionId, message));     // Catch: Throwable -> L10
        if (success == false) goto L21;
        this.mSessionMap.get(sessionId).addReliableMessageToHistory(message);     // Catch: Throwable -> L10
    L21:
        if (success == false) goto L23;
        r3 = 0;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L25:
        e = move-exception;
        Log.e(TAG, e.getMessage());     // Catch: Throwable -> L10
        return 3;
    }

    private /* synthetic */ void lambda$onMessageReceivedInternal$4(HubEndpointInfo remote) throws Exception {
        if (notePermissions(remote) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Dropping message from " + remote + ". " + this.mPackageName + " doesn't have permission");
    }

    private static /* synthetic */ void lambda$onMessageReceivedInternal$5(int sessionId, HubMessage message, IContextHubEndpointCallback consumer) throws RemoteException {
        consumer.onMessageReceived(sessionId, message);
    }

    private boolean cleanupSessionResources(int sessionId) {
        Object r0 = this.mOpenSessionLock;
        monitor-enter(r0);
        Session info = this.mSessionMap.get(sessionId);     // Catch: Throwable -> L9
        if (info != null) goto L7;
    L12:
        if (info == null) goto L14;
        boolean r2 = true;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L14:
        r2 = false;
        goto L15
    L7:
        if (info.isRemoteInitiated() == true) goto L11;
        this.mEndpointManager.returnSessionId(sessionId);     // Catch: Throwable -> L9
    L11:
        info.forEachPendingReliableMessage(new ContextHubEndpointBroker$$ExternalSyntheticLambda8(this));     // Catch: Throwable -> L9
        this.mSessionMap.remove(sessionId);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$cleanupSessionResources$6(Integer sequenceNumber) {
        this.mTransactionManager.onMessageDeliveryResponse(sequenceNumber.intValue(), false);
    }

    private boolean isSessionActive(int sessionId) {
        Object r0 = this.mOpenSessionLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (hasSessionId(sessionId) == true) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mSessionMap.get(sessionId).isActive() == false) goto L11;
        r1 = true;
        goto L12
    }

    private boolean hasEndpointPermissions(HubEndpointInfo targetEndpointInfo) {
        Collection<String> requiredPermissions = targetEndpointInfo.getRequiredPermissions();
        return ContextHubServiceUtil.hasPermissions(this.mContext, this.mPid, this.mUid, requiredPermissions);
    }

    private void acquireWakeLock() {
        Binder.withCleanCallingIdentity(new ContextHubEndpointBroker$$ExternalSyntheticLambda2(this));
    }

    private /* synthetic */ void lambda$acquireWakeLock$7() throws Exception {
        if (isRegistered() == false) goto L6;
        this.mWakeLock.acquire(WAKELOCK_TIMEOUT_MILLIS);
        return;
    }

    private void releaseWakeLock() {
        Binder.withCleanCallingIdentity(new ContextHubEndpointBroker$$ExternalSyntheticLambda3(this));
    }

    private /* synthetic */ void lambda$releaseWakeLock$8() throws Exception {
        if (this.mWakeLock.isHeld() == false) goto L11;
        this.mWakeLock.release();     // Catch: RuntimeException -> L6
        return;
    L6:
        e = move-exception;
        Log.e(TAG, "Releasing the wakelock fails - ", e);
        return;
    }

    private void releaseWakeLockOnExit() {
        Binder.withCleanCallingIdentity(new ContextHubEndpointBroker$$ExternalSyntheticLambda7(this));
    }

    private /* synthetic */ void lambda$releaseWakeLockOnExit$9() throws Exception {
    L3:
        if (this.mWakeLock.isHeld() == false) goto L13;
        this.mWakeLock.release();     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        Log.e(TAG, "Releasing the wakelock for all acquisitions fails - ", e);
        return;
    }

    private boolean invokeCallback(CallbackConsumer consumer) {
        acquireWakeLock();
        consumer.accept(this.mContextHubEndpointCallback);     // Catch: RemoteException -> L6
        return true;
    L6:
        e = move-exception;
        Log.e(TAG, "RemoteException while calling endpoint callback", e);
        releaseWakeLock();
        return false;
    }

    private boolean isRegistered() {
        Object r0 = this.mRegistrationLock;
        monitor-enter(r0);
        boolean r1 = this.mIsRegistered;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean notePermissions(HubEndpointInfo endpoint) {
        return ContextHubServiceUtil.notePermissions(this.mAppOpsManager, this.mUid, this.mPackageName, this.mAttributionTag, endpoint.getRequiredPermissions(), "ContextHubEndpointMessageDelivery-0x" + Long.toHexString(endpoint.getIdentifier().getHub()) + "-0x" + Long.toHexString(endpoint.getIdentifier().getEndpoint()));
    }

    private void notifySessionClosedToBoth(int sessionId, byte halReason) {
        Log.d(TAG, "notifySessionClosedToBoth: sessionId=" + sessionId + ", reason=" + halReason);
        this.mEndpointManager.halCloseEndpointSessionNoThrow(sessionId, halReason);
        onCloseEndpointSession(sessionId, halReason);
    }
}
