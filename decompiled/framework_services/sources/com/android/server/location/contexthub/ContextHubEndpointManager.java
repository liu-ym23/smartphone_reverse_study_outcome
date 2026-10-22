package com.android.server.location.contexthub;

import android.content.Context;
import android.hardware.contexthub.ContextHubInfo;
import android.hardware.contexthub.HubEndpointInfo;
import android.hardware.contexthub.HubInfo;
import android.hardware.contexthub.HubMessage;
import android.hardware.contexthub.IContextHubEndpoint;
import android.hardware.contexthub.IContextHubEndpointCallback;
import android.hardware.contexthub.IEndpointCommunication;
import android.hardware.contexthub.MessageDeliveryStatus;
import android.os.RemoteException;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class ContextHubEndpointManager implements ContextHubHalEndpointCallback.IEndpointSessionCallback {
    public static final int ACTION_REGISTERED = 0;
    public static final int ACTION_UNREGISTERED = 1;
    private static final int NUM_CLIENT_RECORDS = 20;
    private static final long SERVICE_HUB_ID = 4714816302561715200L;
    public static final int SERVICE_SESSION_RANGE = 1024;
    private static final int SERVICE_SESSION_RANGE_LENGTH = 2;
    private static final String TAG = "ContextHubEndpointManager";
    private final Context mContext;
    private final IContextHubWrapper mContextHubProxy;
    private final Object mEndpointLock;
    private final Map<Long, ContextHubEndpointBroker> mEndpointMap;
    private final HubInfoRegistry mHubInfoRegistry;
    private IEndpointCommunication mHubInterface;
    private int mMaxSessionId;
    private int mMinSessionId;
    private long mNextEndpointId;
    private int mNextSessionId;
    private final ConcurrentLinkedEvictingDeque<RegistrationRecord> mRegistrationRecordDeque;
    private final Set<Integer> mReservedSessionIds;
    private final Object mSessionIdLock;
    private boolean mSessionIdsValid;
    private final ScheduledExecutorService mSessionTimeoutExecutor;
    private final ContextHubTransactionManager mTransactionManager;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Action {
    }

    private class RegistrationRecord {
        private final int mAction;
        private final String mBroker;
        private final long mTimestamp;

        RegistrationRecord(ContextHubEndpointManager r3, String broker, int action) {
            this.mBroker = broker;
            this.mAction = action;
            this.mTimestamp = System.currentTimeMillis();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ContextHubServiceUtil.formatDateFromTimestamp(this.mTimestamp));
            sb.append(" ");
            if (this.mAction != 0) goto L5;
            String r1 = "+ ";
        L6:
            sb.append(r1);
            sb.append(this.mBroker);
            return sb.toString();
        L5:
            r1 = "- ";
            goto L6
        }
    }

    public static /* synthetic */ void $r8$lambda$OWRa1Jn5HYJRDs5lF1mTT5O2FIg(int r0, int r1, byte r2, ContextHubEndpointBroker r3) {
        lambda$onMessageDeliveryStatusReceived$4(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$YzNH-jeYrQeazVxITaZzjFNUp8U, reason: not valid java name */
    public static /* synthetic */ void m5172$r8$lambda$YzNHjeYrQeazVxITaZzjFNUp8U(int r0, byte r1, ContextHubEndpointBroker r2) {
        lambda$onCloseEndpointSession$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$lJGOhns4Ixacuy38h8vf778rRUE(ContextHubEndpointManager r0, int r1, Byte r2) {
        r0.lambda$onEndpointSessionOpenRequest$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$uzVmXdCoL_V7elGjwTC8L0QiIMY(int r0, ContextHubEndpointBroker r1) {
        lambda$onEndpointSessionOpenComplete$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$xkdvg5qEIF2gVUNpPPsZavfkKmc(int r0, HubMessage r1, ContextHubEndpointBroker r2) {
        lambda$onMessageReceived$3(r0, r1, r2);
    }

    ContextHubEndpointManager(Context context, IContextHubWrapper contextHubProxy, HubInfoRegistry hubInfoRegistry, ContextHubTransactionManager transactionManager, ScheduledExecutorService scheduledExecutorService) {
        this.mEndpointMap = new ConcurrentHashMap();
        this.mEndpointLock = new Object();
        this.mNextEndpointId = -2;
        this.mMinSessionId = -1;
        this.mMaxSessionId = -1;
        this.mSessionIdLock = new Object();
        this.mReservedSessionIds = Collections.newSetFromMap(new HashMap());
        this.mNextSessionId = 0;
        this.mSessionIdsValid = false;
        this.mHubInterface = null;
        this.mRegistrationRecordDeque = new ConcurrentLinkedEvictingDeque(20);
        this.mContext = context;
        this.mContextHubProxy = contextHubProxy;
        this.mHubInfoRegistry = hubInfoRegistry;
        this.mTransactionManager = transactionManager;
        this.mSessionTimeoutExecutor = scheduledExecutorService;
    }

    ContextHubEndpointManager(Context context, IContextHubWrapper contextHubProxy, HubInfoRegistry hubInfoRegistry, ContextHubTransactionManager transactionManager) {
        this(context, contextHubProxy, hubInfoRegistry, transactionManager, new ScheduledThreadPoolExecutor(1));
    }

    void init() throws InstantiationException, UnsupportedOperationException {
        if (this.mSessionIdsValid == true) goto L37;
        HubInfo info = new HubInfo();     // Catch: Throwable -> L33
        info.hubId = SERVICE_HUB_ID;     // Catch: Throwable -> L33
        ContextHubInfo contextHubInfo = new ContextHubInfo();     // Catch: Throwable -> L33
        contextHubInfo.name = "";     // Catch: Throwable -> L33
        contextHubInfo.vendor = "";     // Catch: Throwable -> L33
        contextHubInfo.toolchain = "";     // Catch: Throwable -> L33
        contextHubInfo.supportedPermissions = new String[0];     // Catch: Throwable -> L33
        info.hubDetails = HubInfo.HubDetails.contextHubInfo(contextHubInfo);     // Catch: Throwable -> L33
        this.mHubInterface = this.mContextHubProxy.registerEndpointHub(new ContextHubHalEndpointCallback(this.mHubInfoRegistry, this), info);     // Catch: Throwable -> L33
        if (this.mHubInterface == null) goto L32;
        int[] range = this.mHubInterface.requestSessionIdRange(1024);     // Catch: Throwable -> L14
        if (range == null) goto L16;
        if (range.length >= 2) goto L16;
        String error = "Invalid session ID range: range array size = " + range.length;     // Catch: Throwable -> L14
        Log.e(TAG, error);     // Catch: Throwable -> L14
        unregisterHub();     // Catch: Throwable -> L14
        throw new InstantiationException(error);     // Catch: Throwable -> L14
    L16:
        this.mMinSessionId = range[0];
        this.mMaxSessionId = range[1];
        if (isSessionIdRangeValid(this.mMinSessionId, this.mMaxSessionId) == false) goto L27;
        Object r2 = this.mSessionIdLock;
        monitor-enter(r2);
        this.mNextSessionId = this.mMinSessionId;     // Catch: Throwable -> L24
        monitor-exit(r2);     // Catch: Throwable -> L24
        this.mSessionIdsValid = true;
        return;
    L24:
        th = move-exception;
        throw th;
    L27:
        String error2 = "Invalid session ID range: max=" + this.mMaxSessionId + " min=" + this.mMinSessionId;
        Log.e(TAG, error2);
        unregisterHub();
        throw new InstantiationException(error2);
    L14:
        e = move-exception;
        Log.e(TAG, "Exception while calling HAL requestSessionIdRange", e);
        unregisterHub();
        throw new InstantiationException("Exception while calling HAL requestSessionIdRange");
    L32:
        throw new IllegalStateException("Received null IEndpointCommunication");     // Catch: Throwable -> L33 Throwable -> L33 Throwable -> L33
    L33:
        e = move-exception;
        Log.e(TAG, "Failed to register ContextHubService as message hub", e);
        throw new InstantiationException("Failed to register ContextHubService as message hub");
    L37:
        throw new IllegalStateException("Already initialized");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IBinder, com.android.server.location.contexthub.ContextHubEndpointBroker, java.lang.Object] */
    IContextHubEndpoint registerEndpoint(HubEndpointInfo r14, IContextHubEndpointCallback r15, String r16, String r17) throws RemoteException {
        if (this.mSessionIdsValid == false) goto L12;
        long r11 = getNewEndpointId();
        ?? r0 = new ContextHubEndpointBroker(this.mContext, this.mHubInterface, this, ContextHubServiceUtil.createHalEndpointInfo(r14, r11, SERVICE_HUB_ID), r15, r16, r17, this.mTransactionManager, this.mSessionTimeoutExecutor);
        r0.register();
        this.mEndpointMap.put(Long.valueOf(r11), (ContextHubEndpointBroker) r0);
        r0.attachDeathRecipient();     // Catch: RemoteException -> L8
        this.mRegistrationRecordDeque.add(new RegistrationRecord(this, r0.toString(), 0));
        Log.d(TAG, "Registered endpoint with ID = " + r11);
        return IContextHubEndpoint.Stub.asInterface(r0);
    L8:
        e = move-exception;
        Log.e(TAG, "Failed to attach death recipient to client", e);
        r0.unregister();
        return null;
    L12:
        throw new IllegalStateException("ContextHubEndpointManager failed to initialize");
    }

    int reserveSessionId() {
        Object r1 = this.mSessionIdLock;
        monitor-enter(r1);
        int maxCapacity = (this.mMaxSessionId - this.mMinSessionId) + 1;     // Catch: Throwable -> L14
        if (this.mReservedSessionIds.size() >= maxCapacity) goto L27;
        int id = this.mNextSessionId;     // Catch: Throwable -> L14
        int i = this.mMinSessionId;     // Catch: Throwable -> L14
    L8:
        if (i > this.mMaxSessionId) goto L23;
        if (this.mReservedSessionIds.contains(Integer.valueOf(id)) == false) goto L12;
        if (id != this.mMaxSessionId) goto L21;
        int r4 = this.mMinSessionId;     // Catch: Throwable -> L14
    L22:
        id = r4;
        i = i + 1;     // Catch: Throwable -> L14
        goto L8
    L21:
        r4 = id + 1;     // Catch: Throwable -> L14
        goto L22
    L12:
        if (id != this.mMaxSessionId) goto L16;
        int r5 = this.mMinSessionId;     // Catch: Throwable -> L14
    L17:
        this.mNextSessionId = r5;     // Catch: Throwable -> L14
        goto L23
    L16:
        r5 = id + 1;     // Catch: Throwable -> L14
    L23:
        this.mReservedSessionIds.add(Integer.valueOf(id));     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return id;
    L27:
        throw new IllegalStateException("Too many sessions reserved");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    void returnSessionId(int sessionId) {
        Object r0 = this.mSessionIdLock;
        monitor-enter(r0);
        this.mReservedSessionIds.remove(Integer.valueOf(sessionId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isSessionIdAllocatedForService(int sessionId) {
        if (sessionId <= this.mMaxSessionId) goto L5;
    L8:
        return true;
    L5:
        if (sessionId < this.mMinSessionId) goto L8;
        return false;
    }

    void unregisterEndpoint(long endpointId) {
        ContextHubEndpointBroker broker = this.mEndpointMap.remove(Long.valueOf(endpointId));
        if (broker == null) goto L6;
        this.mRegistrationRecordDeque.add(new RegistrationRecord(this, broker.toString(), 1));
        return;
    }

    void onHalRestart() {
        Iterator<ContextHubEndpointBroker> r0 = this.mEndpointMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ContextHubEndpointBroker broker = r0.next();
        broker.onHalRestart();
        goto L4
    }

    private Optional<Byte> onEndpointSessionOpenRequestInternal(int sessionId, HubEndpointInfo.HubEndpointIdentifier destination, HubEndpointInfo.HubEndpointIdentifier initiator, String serviceDescriptor) {
        if (destination.getHub() == SERVICE_HUB_ID) goto L6;
        Log.e(TAG, "onEndpointSessionOpenRequest: invalid destination hub ID: " + destination.getHub());
        return Optional.of((byte) 5);
    L6:
        ContextHubEndpointBroker broker = this.mEndpointMap.get(Long.valueOf(destination.getEndpoint()));
        if (broker != null) goto L10;
        Log.e(TAG, "onEndpointSessionOpenRequest: unknown destination endpoint ID: " + destination.getEndpoint());
        return Optional.of((byte) 5);
    L10:
        HubEndpointInfo initiatorInfo = this.mHubInfoRegistry.getEndpointInfo(initiator);
        if (initiatorInfo != null) goto L15;
        Log.e(TAG, "onEndpointSessionOpenRequest: unknown initiator endpoint ID: " + initiator.getEndpoint());
        return Optional.of((byte) 5);
    L15:
        if (isSessionIdAllocatedForService(sessionId) == true) goto L19;
        Log.e(TAG, "onEndpointSessionOpenRequest: invalid session ID, rejected: sessionId=" + sessionId);
        return Optional.of((byte) 3);
    L19:
        return broker.onEndpointSessionOpenRequest(sessionId, initiatorInfo, serviceDescriptor);
    }

    @Override // com.android.server.location.contexthub.ContextHubHalEndpointCallback.IEndpointSessionCallback
    public void onEndpointSessionOpenRequest(final int sessionId, HubEndpointInfo.HubEndpointIdentifier destination, HubEndpointInfo.HubEndpointIdentifier initiator, String serviceDescriptor) {
        Optional<Byte> errorOptional = onEndpointSessionOpenRequestInternal(sessionId, destination, initiator, serviceDescriptor);
        errorOptional.ifPresent(new ContextHubEndpointManager$$ExternalSyntheticLambda2(this, sessionId));
    }

    private /* synthetic */ void lambda$onEndpointSessionOpenRequest$0(int sessionId, Byte error) {
        halCloseEndpointSessionNoThrow(sessionId, error.byteValue());
    }

    @Override // com.android.server.location.contexthub.ContextHubHalEndpointCallback.IEndpointSessionCallback
    public void onCloseEndpointSession(final int sessionId, final byte reason) {
        boolean callbackInvoked = invokeCallbackForMatchingSession(sessionId, new ContextHubEndpointManager$$ExternalSyntheticLambda4(sessionId, reason));
        if (callbackInvoked == true) goto L6;
        Log.w(TAG, "onCloseEndpointSession: unknown session ID " + sessionId);
        return;
    }

    private static /* synthetic */ void lambda$onCloseEndpointSession$1(int sessionId, byte reason, ContextHubEndpointBroker broker) {
        broker.onCloseEndpointSession(sessionId, reason);
    }

    @Override // com.android.server.location.contexthub.ContextHubHalEndpointCallback.IEndpointSessionCallback
    public void onEndpointSessionOpenComplete(final int sessionId) {
        boolean callbackInvoked = invokeCallbackForMatchingSession(sessionId, new ContextHubEndpointManager$$ExternalSyntheticLambda1(sessionId));
        if (callbackInvoked == true) goto L6;
        Log.w(TAG, "onEndpointSessionOpenComplete: unknown session ID " + sessionId);
        return;
    }

    private static /* synthetic */ void lambda$onEndpointSessionOpenComplete$2(int sessionId, ContextHubEndpointBroker broker) {
        broker.onEndpointSessionOpenComplete(sessionId);
    }

    @Override // com.android.server.location.contexthub.ContextHubHalEndpointCallback.IEndpointSessionCallback
    public void onMessageReceived(final int sessionId, final HubMessage message) {
        boolean callbackInvoked = invokeCallbackForMatchingSession(sessionId, new ContextHubEndpointManager$$ExternalSyntheticLambda0(sessionId, message));
        if (callbackInvoked == true) goto L8;
        Log.w(TAG, "onMessageReceived: unknown session ID " + sessionId);
        if (message.isResponseRequired() == false) goto L9;
        sendMessageDeliveryStatus(sessionId, message.getMessageSequenceNumber(), (byte) 4);
        return;
    L9:
        return;
    }

    private static /* synthetic */ void lambda$onMessageReceived$3(int sessionId, HubMessage message, ContextHubEndpointBroker broker) {
        broker.onMessageReceived(sessionId, message);
    }

    @Override // com.android.server.location.contexthub.ContextHubHalEndpointCallback.IEndpointSessionCallback
    public void onMessageDeliveryStatusReceived(final int sessionId, final int sequenceNumber, final byte errorCode) {
        boolean callbackInvoked = invokeCallbackForMatchingSession(sessionId, new ContextHubEndpointManager$$ExternalSyntheticLambda3(sessionId, sequenceNumber, errorCode));
        if (callbackInvoked == true) goto L6;
        Log.w(TAG, "onMessageDeliveryStatusReceived: unknown session ID " + sessionId);
        return;
    }

    private static /* synthetic */ void lambda$onMessageDeliveryStatusReceived$4(int sessionId, int sequenceNumber, byte errorCode, ContextHubEndpointBroker broker) {
        broker.onMessageDeliveryStatusReceived(sessionId, sequenceNumber, errorCode);
    }

    void halCloseEndpointSession(int sessionId, byte halReason) throws RemoteException {
        this.mHubInterface.closeEndpointSession(sessionId, halReason);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        throw e;
    }

    void halCloseEndpointSessionNoThrow(int sessionId, byte halReason) {
        halCloseEndpointSession(sessionId, halReason);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Exception while calling HAL closeEndpointSession", e);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        Iterator<ContextHubEndpointBroker> r2 = this.mEndpointMap.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ContextHubEndpointBroker broker = r2.next();
        sb.append(count + ". " + broker);
        sb.append(System.lineSeparator());
        count = count + 1;
        goto L4
    L6:
        sb.append(System.lineSeparator());
        sb.append("Registration History:");
        sb.append(System.lineSeparator());
        Iterator<RegistrationRecord> it = this.mRegistrationRecordDeque.descendingIterator();
    L8:
        if (it.hasNext() == false) goto L11;
        sb.append(it.next());
        sb.append(System.lineSeparator());
        goto L8
    L11:
        return sb.toString();
    }

    private boolean invokeCallbackForMatchingSession(int sessionId, Consumer<ContextHubEndpointBroker> callback) {
        Iterator<ContextHubEndpointBroker> r0 = this.mEndpointMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        ContextHubEndpointBroker broker = r0.next();
        if (broker.hasSessionId(sessionId) == false) goto L4;
        callback.accept(broker);     // Catch: RuntimeException -> L9
        return true;
    L9:
        e = move-exception;
        Log.e(TAG, "Exception while invoking callback", e);
        return true;
    L14:
        return false;
    }

    private void unregisterHub() {
        this.mHubInterface.unregister();     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Failed to unregister from HAL on init failure", e);
    }

    private long getNewEndpointId() {
        Object r0 = this.mEndpointLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mNextEndpointId >= 0) goto L12;
        long r1 = this.mNextEndpointId;     // Catch: Throwable -> L9
        this.mNextEndpointId = r1 - 1;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L12:
        throw new IllegalStateException("Too many endpoints connected");     // Catch: Throwable -> L9
    }

    private boolean isSessionIdRangeValid(int minId, int maxId) {
        if (minId > maxId) goto L6;
        if (minId < 0) goto L6;
        if (maxId < 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void sendMessageDeliveryStatus(int sessionId, int messageSequenceNumber, byte errorCode) {
        MessageDeliveryStatus status = new MessageDeliveryStatus();
        status.messageSequenceNumber = messageSequenceNumber;
        status.errorCode = errorCode;
        this.mHubInterface.sendMessageDeliveryStatusToEndpoint(sessionId, status);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Log.w(TAG, "Exception while sending message delivery status on session " + sessionId, e);
    }

    int getNumAvailableSessions() {
        Object r0 = this.mSessionIdLock;
        monitor-enter(r0);
        int r1 = ((this.mMaxSessionId - this.mMinSessionId) + 1) - this.mReservedSessionIds.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    int getNumRegisteredClients() {
        return this.mEndpointMap.size();
    }
}
