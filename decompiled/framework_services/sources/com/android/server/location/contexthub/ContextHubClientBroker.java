package com.android.server.location.contexthub;

import android.app.AppOpsManager;
import android.app.PendingIntent;
import android.compat.Compatibility;
import android.content.Context;
import android.content.Intent;
import android.hardware.contexthub.HostEndpointInfo;
import android.hardware.contexthub.MessageDeliveryStatus;
import android.hardware.location.ContextHubInfo;
import android.hardware.location.IContextHubClient;
import android.hardware.location.IContextHubClientCallback;
import android.hardware.location.IContextHubTransactionCallback;
import android.hardware.location.NanoAppMessage;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.WorkSource;
import android.util.Log;
import android.util.proto.ProtoOutputStream;
import java.util.Base64;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class ContextHubClientBroker extends IContextHubClient.Stub implements IBinder.DeathRecipient, AppOpsManager.OnOpChangedListener, PendingIntent.OnFinished {
    private static final int AUTHORIZATION_UNKNOWN = -1;
    private static final long CHANGE_ID_AUTH_STATE_DENIED = 181350407;
    private static final String RECEIVE_MSG_NOTE = "NanoappMessageDelivery ";
    private static final String TAG = "ContextHubClientBroker";
    private static final long WAKELOCK_TIMEOUT_MILLIS = 5000;
    private final AppOpsManager mAppOpsManager;
    private final ContextHubInfo mAttachedContextHubInfo;
    private String mAttributionTag;
    private final ContextHubClientManager mClientManager;
    private final Context mContext;
    private IContextHubClientCallback mContextHubClientCallback;
    private final IContextHubWrapper mContextHubProxy;
    private final Set<Long> mForceDeniedNapps;
    private final short mHostEndPointId;
    private final AtomicBoolean mIsPendingIntentCancelled;
    private final AtomicBoolean mIsPermQueryIssued;
    private AtomicBoolean mIsWakelockUsable;
    private final Map<Long, Integer> mMessageChannelNanoappIdMap;
    private final Map<Long, AuthStateDenialTimer> mNappToAuthTimerMap;
    private final String mPackage;
    private final PendingIntentRequest mPendingIntentRequest;
    private final int mPid;
    private final IContextHubTransactionCallback mQueryPermsCallback;
    private boolean mRegistered;
    private final ContextHubTransactionManager mTransactionManager;
    private final int mUid;
    private final PowerManager.WakeLock mWakeLock;

    interface CallbackConsumer {
        void accept(IContextHubClientCallback r1) throws RemoteException;
    }

    private static class PendingIntentRequest {
        private long mNanoAppId;
        private PendingIntent mPendingIntent;
        private boolean mValid;

        PendingIntentRequest() {
            this.mValid = false;
        }

        PendingIntentRequest(PendingIntent pendingIntent, long nanoAppId) {
            this.mValid = false;
            this.mPendingIntent = pendingIntent;
            this.mNanoAppId = nanoAppId;
            this.mValid = true;
        }

        public long getNanoAppId() {
            return this.mNanoAppId;
        }

        public PendingIntent getPendingIntent() {
            return this.mPendingIntent;
        }

        public boolean hasPendingIntent() {
            if (this.mPendingIntent == null) goto L5;
            return true;
        L5:
            return false;
        }

        public void clear() {
            this.mPendingIntent = null;
        }

        public boolean isValid() {
            return this.mValid;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$2s0Uo-bKcYW50DntaGwWtoAYALM, reason: not valid java name */
    public static /* synthetic */ void m5156$r8$lambda$2s0UobKcYW50DntaGwWtoAYALM(long r0, IContextHubClientCallback r2) {
        lambda$onNanoAppUnloaded$5(r0, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$5LN1r8kQkqBv9B8howzlawnr-GI, reason: not valid java name */
    public static /* synthetic */ void m5157$r8$lambda$5LN1r8kQkqBv9B8howzlawnrGI(NanoAppMessage r0, IContextHubClientCallback r1) {
        lambda$sendMessageToClient$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$5NIXhCVA4VhSgwflJ-dV8OT4jsk, reason: not valid java name */
    public static /* synthetic */ Intent m5158$r8$lambda$5NIXhCVA4VhSgwflJdV8OT4jsk(ContextHubClientBroker r0, long r1, int r3) {
        return r0.lambda$onNanoAppAborted$9(r1, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$681F4A4Rw6HIBZ-W1cnA_UimUkA, reason: not valid java name */
    public static /* synthetic */ void m5159$r8$lambda$681F4A4Rw6HIBZW1cnA_UimUkA(long r0, IContextHubClientCallback r2) {
        lambda$onNanoAppLoaded$3(r0, r2);
    }

    public static /* synthetic */ void $r8$lambda$7GaKk9ODLn9h9dIT1DAjkZFa4iM(ContextHubClientBroker r0) {
        r0.lambda$releaseWakeLock$13();
    }

    public static /* synthetic */ Intent $r8$lambda$8sNz7ZvFVHUHWU9J0d7z49uPt4Q(ContextHubClientBroker r0, long r1) {
        return r0.lambda$onNanoAppLoaded$4(r1);
    }

    public static /* synthetic */ Intent $r8$lambda$CpfiRa0Zz_8mVJfdif37pr_NZ6A(ContextHubClientBroker r0, long r1, int r3) {
        return r0.lambda$sendAuthStateCallback$11(r1, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$ILnN8vk5-WpxaAwvuV43zlxBSUs, reason: not valid java name */
    public static /* synthetic */ Intent m5160$r8$lambda$ILnN8vk5WpxaAwvuV43zlxBSUs(ContextHubClientBroker r0, long r1) {
        return r0.lambda$onNanoAppUnloaded$6(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$QjaJyLv-rQuyhtluWSnqhPk-eIU, reason: not valid java name */
    public static /* synthetic */ void m5161$r8$lambda$QjaJyLvrQuyhtluWSnqhPkeIU(ContextHubClientBroker r0) {
        r0.lambda$acquireWakeLock$12();
    }

    public static /* synthetic */ void $r8$lambda$Zu1QHvg1AenGCS8KjTx02VlsIxE(ContextHubClientBroker r0, NanoAppMessage r1, Byte r2) {
        r0.lambda$sendMessageToClient$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$_514VloU4I_f3jcd_merkncFFPg(long r0, int r2, IContextHubClientCallback r3) {
        lambda$onNanoAppAborted$8(r0, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$ahBzeyv7fFYSmK4rFMm3QoYECH8(long r0, int r2, IContextHubClientCallback r3) {
        lambda$sendAuthStateCallback$10(r0, r2, r3);
    }

    public static /* synthetic */ Intent $r8$lambda$bCClfpweAsRrfPAGme_k2SsgRNM(ContextHubClientBroker r0) {
        return r0.lambda$onHubReset$7();
    }

    public static /* synthetic */ void $r8$lambda$ePtUO3zyFt4xzp4VerSXlIAHOtk(ContextHubClientBroker r0) {
        r0.lambda$releaseWakeLockOnExit$14();
    }

    public static /* synthetic */ Intent $r8$lambda$sgL02r5loG_cZwA7hYdldQh6nwE(ContextHubClientBroker r0, long r1, NanoAppMessage r3) {
        return r0.lambda$sendMessageToClient$1(r1, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsPermQueryIssued, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m5162$$Nest$fgetmIsPermQueryIssued(ContextHubClientBroker r0) {
        return r0.mIsPermQueryIssued;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMessageChannelNanoappIdMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m5163$$Nest$fgetmMessageChannelNanoappIdMap(ContextHubClientBroker r0) {
        return r0.mMessageChannelNanoappIdMap;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateNanoAppAuthState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5164$$Nest$mupdateNanoAppAuthState(ContextHubClientBroker r0, long r1, List r3, boolean r4) {
        return r0.updateNanoAppAuthState(r1, r3, r4);
    }

    private ContextHubClientBroker(Context context, IContextHubWrapper contextHubProxy, ContextHubClientManager clientManager, ContextHubInfo contextHubInfo, short hostEndPointId, IContextHubClientCallback callback, String attributionTag, ContextHubTransactionManager transactionManager, PendingIntent pendingIntent, long nanoAppId, String packageName) {
        this.mRegistered = true;
        this.mIsWakelockUsable = new AtomicBoolean(true);
        this.mIsPendingIntentCancelled = new AtomicBoolean(false);
        this.mIsPermQueryIssued = new AtomicBoolean(false);
        this.mMessageChannelNanoappIdMap = new ConcurrentHashMap();
        this.mForceDeniedNapps = new HashSet();
        this.mNappToAuthTimerMap = new ConcurrentHashMap();
        this.mQueryPermsCallback = new AnonymousClass1(this);
        this.mContext = context;
        this.mContextHubProxy = contextHubProxy;
        this.mClientManager = clientManager;
        this.mAttachedContextHubInfo = contextHubInfo;
        this.mHostEndPointId = hostEndPointId;
        this.mContextHubClientCallback = callback;
        if (pendingIntent != null) goto L5;
        this.mPendingIntentRequest = new PendingIntentRequest();
    L7:
        if (packageName != null) goto L15;
        String[] packages = this.mContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (packages != null) goto L11;
    L13:
        String packageName2 = packageName;
    L14:
        Log.e(TAG, "createClient: Provided package name null. Using first package name " + packageName2);
    L16:
        this.mPackage = packageName2;
        this.mAttributionTag = attributionTag;
        this.mTransactionManager = transactionManager;
        this.mPid = Binder.getCallingPid();
        this.mUid = Binder.getCallingUid();
        this.mAppOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        PowerManager powerManager = (PowerManager) context.getSystemService(PowerManager.class);
        this.mWakeLock = powerManager.newWakeLock(1, TAG);
        this.mWakeLock.setWorkSource(new WorkSource(this.mUid, this.mPackage));
        this.mWakeLock.setReferenceCounted(true);
        startMonitoringOpChanges();
        sendHostEndpointConnectedEvent();
        return;
    L11:
        if (packages.length <= 0) goto L13;
        packageName2 = packages[0];
        goto L14
    L15:
        packageName2 = packageName;
        goto L16
    L5:
        this.mPendingIntentRequest = new PendingIntentRequest(pendingIntent, nanoAppId);
        goto L7
    }

    ContextHubClientBroker(Context context, IContextHubWrapper contextHubProxy, ContextHubClientManager clientManager, ContextHubInfo contextHubInfo, short hostEndPointId, IContextHubClientCallback callback, String attributionTag, ContextHubTransactionManager transactionManager, String packageName) {
        this(context, contextHubProxy, clientManager, contextHubInfo, hostEndPointId, callback, attributionTag, transactionManager, null, 0, packageName);
    }

    ContextHubClientBroker(Context context, IContextHubWrapper contextHubProxy, ContextHubClientManager clientManager, ContextHubInfo contextHubInfo, short hostEndPointId, PendingIntent pendingIntent, long nanoAppId, String attributionTag, ContextHubTransactionManager transactionManager) {
        this(context, contextHubProxy, clientManager, contextHubInfo, hostEndPointId, null, attributionTag, transactionManager, pendingIntent, nanoAppId, pendingIntent.getCreatorPackage());
    }

    private void startMonitoringOpChanges() {
        this.mAppOpsManager.startWatchingMode(-1, this.mPackage, this);
    }

    public int sendMessageToNanoApp(NanoAppMessage message) {
        return doSendMessageToNanoApp(message, null);
    }

    public int sendReliableMessageToNanoApp(NanoAppMessage message, IContextHubTransactionCallback transactionCallback) {
        return doSendMessageToNanoApp(message, transactionCallback);
    }

    private int doSendMessageToNanoApp(NanoAppMessage message, IContextHubTransactionCallback transactionCallback) {
        ContextHubServiceUtil.checkPermissions(this.mContext);
        boolean r1 = false;
        message.setIsReliable(false);
        message.setMessageSequenceNumber(0);
        if (isRegistered() == false) goto L28;
        int authState = this.mMessageChannelNanoappIdMap.getOrDefault(Long.valueOf(message.getNanoAppId()), -1).intValue();
        if (authState == 0) goto L7;
        if (authState != (-1)) goto L14;
        checkNanoappPermsAsync();
    L14:
        if (transactionCallback == null) goto L30;
        NanoAppMessage message2 = message;
        ContextHubServiceTransaction transaction = this.mTransactionManager.createMessageTransaction(this.mHostEndPointId, this.mAttachedContextHubInfo.getId(), message2, transactionCallback, getPackageName());
        this.mTransactionManager.addTransaction(transaction);     // Catch: IllegalStateException -> L22
        int result = 0;
    L24:
        ContextHubEventLogger r14 = ContextHubEventLogger.getInstance();
        int r15 = this.mAttachedContextHubInfo.getId();
        if (result != 0) goto L27;
        r1 = true;
    L27:
        r14.logMessageToNanoapp(r15, message2, r1);
        return result;
    L22:
        e = move-exception;
        Log.e(TAG, "Unable to add a transaction in sendMessageToNanoApp (target hub ID = " + this.mAttachedContextHubInfo.getId() + ")", e);
        result = 7;
        goto L24
    L30:
        result = this.mContextHubProxy.sendMessageToContextHub(this.mHostEndPointId, this.mAttachedContextHubInfo.getId(), message);     // Catch: RemoteException -> L17
    L16:
        message2 = message;
    L17:
        e = move-exception;
        Log.e(TAG, "RemoteException in sendMessageToNanoApp (target hub ID = " + this.mAttachedContextHubInfo.getId() + ")", e);
        result = 1;
        goto L16
    L7:
        if (Compatibility.isChangeEnabled(CHANGE_ID_AUTH_STATE_DENIED) == true) goto L10;
        return 1;
    L10:
        throw new SecurityException("Client doesn't have valid permissions to send message to " + message.getNanoAppId());
    L28:
        String messageString = Base64.getEncoder().encodeToString(message.getMessageBody());
        Log.e(TAG, String.format("Failed to send message (connection closed): hostEndpointId= %1$d payload %2$s", new Object[]{Short.valueOf(this.mHostEndPointId), messageString}));
        return 1;
    }

    public void close() {
        monitor-enter(this);
        this.mPendingIntentRequest.clear();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        onClientExit();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int getId() {
        return this.mHostEndPointId;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        onClientExit();
    }

    @Override // android.app.AppOpsManager.OnOpChangedListener
    public void onOpChanged(String op, String packageName) {
        if (packageName.equals(this.mPackage) == true) goto L5;
        return;
    L5:
        if (this.mMessageChannelNanoappIdMap.isEmpty() == true) goto L9;
        checkNanoappPermsAsync();
        return;
    }

    String getPackageName() {
        return this.mPackage;
    }

    boolean isWakelockUsable() {
        PowerManager.WakeLock r0 = this.mWakeLock;
        monitor-enter(r0);
        boolean r1 = this.mIsWakelockUsable.get();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    PowerManager.WakeLock getWakeLock() {
        PowerManager.WakeLock r0 = this.mWakeLock;
        monitor-enter(r0);
        PowerManager.WakeLock r1 = this.mWakeLock;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setAttributionTag(String attributionTag) {
        this.mAttributionTag = attributionTag;
    }

    String getAttributionTag() {
        return this.mAttributionTag;
    }

    int getAttachedContextHubId() {
        return this.mAttachedContextHubInfo.getId();
    }

    short getHostEndPointId() {
        return this.mHostEndPointId;
    }

    byte sendMessageToClient(final NanoAppMessage message, List<String> nanoappPermissions, List<String> messagePermissions) {
        final long nanoAppId = message.getNanoAppId();
        int authState = updateNanoAppAuthState(nanoAppId, nanoappPermissions, false);
        if (authState == 1) goto L5;
    L9:
        if (authState != 0) goto L11;
    L22:
        Log.e(TAG, "Dropping message from " + Long.toHexString(nanoAppId) + ". " + this.mPackage + " doesn't have permission");
        return 3;
    L11:
        if (ContextHubServiceUtil.notePermissions(this.mAppOpsManager, this.mUid, this.mPackage, this.mAttributionTag, messagePermissions, RECEIVE_MSG_NOTE + nanoAppId) == false) goto L22;
        byte errorCode = invokeCallback(new ContextHubClientBroker$$ExternalSyntheticLambda1(message));
        if (errorCode == 0) goto L16;
        return errorCode;
    L16:
        Supplier<Intent> supplier = new ContextHubClientBroker$$ExternalSyntheticLambda2(this, nanoAppId, message);
        Consumer<Byte> onFinishedCallback = new ContextHubClientBroker$$ExternalSyntheticLambda3(this, message);
        if (message.isReliable() == false) goto L19;
        Consumer<Byte> r9 = onFinishedCallback;
    L21:
        return sendPendingIntent(supplier, nanoAppId, r9);
    L19:
        r9 = null;
        goto L21
    L5:
        if (messagePermissions.isEmpty() == true) goto L9;
        Log.e(TAG, "Dropping message from " + Long.toHexString(nanoAppId) + ". " + this.mPackage + " in grace period and napp msg has permissions");
        return 3;
    }

    private static /* synthetic */ void lambda$sendMessageToClient$0(NanoAppMessage message, IContextHubClientCallback callback) throws RemoteException {
        callback.onMessageFromNanoApp(message);
    }

    private /* synthetic */ Intent lambda$sendMessageToClient$1(long nanoAppId, NanoAppMessage message) {
        return createIntent(5, nanoAppId).putExtra("android.hardware.location.extra.MESSAGE", message);
    }

    private /* synthetic */ void lambda$sendMessageToClient$2(NanoAppMessage message, Byte error) {
        sendMessageDeliveryStatusToContextHub(message.getMessageSequenceNumber(), error.byteValue());
    }

    void onNanoAppLoaded(final long nanoAppId) {
        checkNanoappPermsAsync();
        invokeCallback(new ContextHubClientBroker$$ExternalSyntheticLambda4(nanoAppId));
        sendPendingIntent(new ContextHubClientBroker$$ExternalSyntheticLambda5(this, nanoAppId), nanoAppId);
    }

    private static /* synthetic */ void lambda$onNanoAppLoaded$3(long nanoAppId, IContextHubClientCallback callback) throws RemoteException {
        callback.onNanoAppLoaded(nanoAppId);
    }

    private /* synthetic */ Intent lambda$onNanoAppLoaded$4(long nanoAppId) {
        return createIntent(0, nanoAppId);
    }

    private static /* synthetic */ void lambda$onNanoAppUnloaded$5(long nanoAppId, IContextHubClientCallback callback) throws RemoteException {
        callback.onNanoAppUnloaded(nanoAppId);
    }

    void onNanoAppUnloaded(final long nanoAppId) {
        invokeCallback(new ContextHubClientBroker$$ExternalSyntheticLambda14(nanoAppId));
        sendPendingIntent(new ContextHubClientBroker$$ExternalSyntheticLambda15(this, nanoAppId), nanoAppId);
    }

    private /* synthetic */ Intent lambda$onNanoAppUnloaded$6(long nanoAppId) {
        return createIntent(1, nanoAppId);
    }

    void onHubReset() {
        invokeCallback(new ContextHubClientBroker$$ExternalSyntheticLambda7());
        sendPendingIntent(new ContextHubClientBroker$$ExternalSyntheticLambda8(this));
        sendHostEndpointConnectedEvent();
    }

    private /* synthetic */ Intent lambda$onHubReset$7() {
        return createIntent(6);
    }

    private static /* synthetic */ void lambda$onNanoAppAborted$8(long nanoAppId, int abortCode, IContextHubClientCallback callback) throws RemoteException {
        callback.onNanoAppAborted(nanoAppId, abortCode);
    }

    void onNanoAppAborted(final long nanoAppId, final int abortCode) {
        invokeCallback(new ContextHubClientBroker$$ExternalSyntheticLambda11(nanoAppId, abortCode));
        Supplier<Intent> supplier = new ContextHubClientBroker$$ExternalSyntheticLambda12(this, nanoAppId, abortCode);
        sendPendingIntent(supplier, nanoAppId);
    }

    private /* synthetic */ Intent lambda$onNanoAppAborted$9(long nanoAppId, int abortCode) {
        return createIntent(4, nanoAppId).putExtra("android.hardware.location.extra.NANOAPP_ABORT_CODE", abortCode);
    }

    boolean hasPendingIntent(PendingIntent intent, long nanoAppId) {
        monitor-enter(this);
        PendingIntent pendingIntent = this.mPendingIntentRequest.getPendingIntent();     // Catch: Throwable -> L13
        long intentNanoAppId = this.mPendingIntentRequest.getNanoAppId();     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        if (pendingIntent != null) goto L7;
    L11:
        return false;
    L7:
        if (pendingIntent.equals(intent) == false) goto L11;
        if (intentNanoAppId != nanoAppId) goto L11;
        return true;
    L13:
        th = move-exception;
        throw th;
    }

    void attachDeathRecipient() throws RemoteException {
        if (this.mContextHubClientCallback == null) goto L6;
        this.mContextHubClientCallback.asBinder().linkToDeath(this, 0);
        return;
    }

    boolean isPendingIntentCancelled() {
        return this.mIsPendingIntentCancelled.get();
    }

    void handleAuthStateTimerExpiry(long nanoAppId) {
        Map<Long, Integer> r0 = this.mMessageChannelNanoappIdMap;
        monitor-enter(r0);
        AuthStateDenialTimer timer = this.mNappToAuthTimerMap.remove(Long.valueOf(nanoAppId));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (timer == null) goto L14;
        updateNanoAppAuthState(nanoAppId, Collections.emptyList(), true);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void checkNanoappPermsAsync() {
        if (this.mIsPermQueryIssued.getAndSet(true) == true) goto L6;
        ContextHubServiceTransaction transaction = this.mTransactionManager.createQueryTransaction(this.mAttachedContextHubInfo.getId(), this.mQueryPermsCallback, this.mPackage);
        this.mTransactionManager.addTransaction(transaction);
        return;
    }

    private int updateNanoAppAuthState(long nanoAppId, List<String> nanoappPermissions, boolean gracePeriodExpired) {
        return updateNanoAppAuthState(nanoAppId, nanoappPermissions, gracePeriodExpired, false);
    }

    int updateNanoAppAuthState(long nanoAppId, List<String> nanoappPermissions, boolean gracePeriodExpired, boolean forceDenied) {
        Map<Long, Integer> r0 = this.mMessageChannelNanoappIdMap;
        monitor-enter(r0);
        boolean hasPermissions = ContextHubServiceUtil.hasPermissions(this.mContext, this.mPid, this.mUid, nanoappPermissions);     // Catch: Throwable -> L7
        int curAuthState = this.mMessageChannelNanoappIdMap.getOrDefault(Long.valueOf(nanoAppId), -1).intValue();     // Catch: Throwable -> L7
        if (curAuthState != (-1)) goto L9;
        curAuthState = 2;
        this.mMessageChannelNanoappIdMap.put(Long.valueOf(nanoAppId), 2);     // Catch: Throwable -> L7
    L9:
        int newAuthState = curAuthState;
        if (forceDenied == true) goto L23;
        if (this.mForceDeniedNapps.contains(Long.valueOf(nanoAppId)) == true) goto L23;
        if (gracePeriodExpired == false) goto L17;
        if (curAuthState != 1) goto L24;
        newAuthState = 0;
    L24:
        if (newAuthState == 1) goto L29;
        AuthStateDenialTimer timer = this.mNappToAuthTimerMap.remove(Long.valueOf(nanoAppId));     // Catch: Throwable -> L7
        if (timer == null) goto L31;
        timer.cancel();     // Catch: Throwable -> L7
    L31:
        if (curAuthState == newAuthState) goto L33;
        this.mMessageChannelNanoappIdMap.put(Long.valueOf(nanoAppId), Integer.valueOf(newAuthState));     // Catch: Throwable -> L7
    L33:
        monitor-exit(r0);     // Catch: Throwable -> L7
        if (curAuthState == newAuthState) goto L39;
        if (newAuthState == 0) goto L37;
        if (newAuthState == 1) goto L37;
    L38:
        sendAuthStateCallback(nanoAppId, newAuthState);
    L37:
        Log.e(TAG, "updateNanoAppAuthState auth error: " + Long.toHexString(nanoAppId) + ", " + nanoappPermissions + ", " + gracePeriodExpired + ", " + forceDenied);
    L39:
        return newAuthState;
    L29:
        if (curAuthState != 2) goto L31;
        AuthStateDenialTimer timer2 = new AuthStateDenialTimer(this, nanoAppId, Looper.getMainLooper());     // Catch: Throwable -> L7
        this.mNappToAuthTimerMap.put(Long.valueOf(nanoAppId), timer2);     // Catch: Throwable -> L7
        timer2.start();     // Catch: Throwable -> L7
        goto L31
    L17:
        if (curAuthState != 2) goto L20;
        if (hasPermissions == true) goto L20;
        newAuthState = 1;
    L20:
        if (curAuthState == 2) goto L24;
        if (hasPermissions == false) goto L24;
        newAuthState = 2;
    L23:
        newAuthState = 0;
        this.mForceDeniedNapps.add(Long.valueOf(nanoAppId));     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$sendAuthStateCallback$10(long nanoAppId, int authState, IContextHubClientCallback callback) throws RemoteException {
        callback.onClientAuthorizationChanged(nanoAppId, authState);
    }

    private void sendAuthStateCallback(final long nanoAppId, final int authState) {
        invokeCallback(new ContextHubClientBroker$$ExternalSyntheticLambda9(nanoAppId, authState));
        Supplier<Intent> supplier = new ContextHubClientBroker$$ExternalSyntheticLambda10(this, nanoAppId, authState);
        sendPendingIntent(supplier, nanoAppId);
    }

    private /* synthetic */ Intent lambda$sendAuthStateCallback$11(long nanoAppId, int authState) {
        return createIntent(7, nanoAppId).putExtra("android.hardware.location.extra.CLIENT_AUTHORIZATION_STATE", authState);
    }

    private synchronized byte invokeCallback(CallbackConsumer consumer) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mContextHubClientCallback != null) goto L19;
    L14:
        monitor-exit(this);
        return 0;
    L19:
        acquireWakeLock();     // Catch: Throwable -> L7 RemoteException -> L9
        consumer.accept(this.mContextHubClientCallback);     // Catch: Throwable -> L7 RemoteException -> L9
    L9:
        e = move-exception;
        Log.e(TAG, "RemoteException while invoking client callback (host endpoint ID = " + this.mHostEndPointId + ")", e);     // Catch: Throwable -> L7
        return 2;
    }

    private Intent createIntent(int eventType) {
        Intent intent = new Intent();
        intent.putExtra("android.hardware.location.extra.EVENT_TYPE", eventType);
        intent.putExtra("android.hardware.location.extra.CONTEXT_HUB_INFO", this.mAttachedContextHubInfo);
        return intent;
    }

    private Intent createIntent(int eventType, long nanoAppId) {
        Intent intent = createIntent(eventType);
        intent.putExtra("android.hardware.location.extra.NANOAPP_ID", nanoAppId);
        return intent;
    }

    private synchronized byte sendPendingIntent(Supplier<Intent> supplier) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mPendingIntentRequest.hasPendingIntent() == false) goto L10;
        byte r0 = doSendPendingIntent(this.mPendingIntentRequest.getPendingIntent(), supplier.get(), this);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r0;
    L10:
        monitor-exit(this);
        return 0;
    }

    private synchronized byte sendPendingIntent(Supplier<Intent> supplier, long nanoAppId) {
        monitor-enter(this);
        byte r0 = sendPendingIntent(supplier, nanoAppId, null);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    private synchronized byte sendPendingIntent(Supplier<Intent> supplier, long nanoAppId, final Consumer<Byte> onFinishedCallback) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mPendingIntentRequest.hasPendingIntent() == true) goto L6;
    L12:
        monitor-exit(this);
        return 0;
    L6:
        if (this.mPendingIntentRequest.getNanoAppId() != nanoAppId) goto L12;
        PendingIntent.OnFinished onFinished = new AnonymousClass2(this, onFinishedCallback, this);     // Catch: Throwable -> L10
        byte r2 = doSendPendingIntent(this.mPendingIntentRequest.getPendingIntent(), supplier.get(), onFinished);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r2;
    }

    byte doSendPendingIntent(PendingIntent pendingIntent, Intent intent, PendingIntent.OnFinished onFinishedCallback) {
        acquireWakeLock();     // Catch: PendingIntent.CanceledException -> L9
        pendingIntent.send(this.mContext, 0, intent, onFinishedCallback, null, "android.permission.ACCESS_CONTEXT_HUB", null);     // Catch: PendingIntent.CanceledException -> L7
        return 0;
    L11:
        this.mIsPendingIntentCancelled.set(true);
        Log.w(TAG, "PendingIntent has been canceled, unregistering from client (host endpoint ID " + this.mHostEndPointId + ")");
        close();
        return 2;
    }

    private synchronized boolean isRegistered() {
        monitor-enter(this);
        boolean r0 = this.mRegistered;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void onClientExit() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mContextHubClientCallback == null) goto L9;
        this.mContextHubClientCallback.asBinder().unlinkToDeath(this, 0);     // Catch: Throwable -> L6
        this.mContextHubClientCallback = null;     // Catch: Throwable -> L6
    L9:
        if (this.mPendingIntentRequest.hasPendingIntent() == false) goto L11;
    L13:
        monitor-exit(this);
        return;
    L11:
        if (this.mRegistered == false) goto L13;
        this.mClientManager.unregisterClient(this.mHostEndPointId);     // Catch: Throwable -> L6
        this.mRegistered = false;     // Catch: Throwable -> L6
        this.mAppOpsManager.stopWatchingMode(this);     // Catch: Throwable -> L6
        this.mContextHubProxy.onHostEndpointDisconnected(this.mHostEndPointId);     // Catch: Throwable -> L6
        releaseWakeLockOnExit();     // Catch: Throwable -> L6
        goto L13
    }

    private String authStateToString(int state) {
        switch(state) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return "UNKNOWN";
    L5:
        return "GRANTED";
    L7:
        return "DENIED_GRACE_PERIOD";
    L9:
        return "DENIED";
    }

    void sendHostEndpointConnectedEvent() {
        HostEndpointInfo info = new HostEndpointInfo();
        info.hostEndpointId = (char) this.mHostEndPointId;
        info.packageName = this.mPackage;
        info.attributionTag = this.mAttributionTag;
        if (this.mUid != 1000) goto L5;
        int r1 = 1;
    L6:
        info.type = r1;
        this.mContextHubProxy.onHostEndpointConnected(info);
        return;
    L5:
        r1 = 2;
        goto L6
    }

    void dump(ProtoOutputStream proto) {
        proto.write(1120986464257L, getHostEndPointId());
        proto.write(1120986464258L, getAttachedContextHubId());
        proto.write(1138166333443L, this.mPackage);
        if (this.mPendingIntentRequest.isValid() == false) goto L5;
        proto.write(1133871366149L, true);
        proto.write(1112396529668L, this.mPendingIntentRequest.getNanoAppId());
    L5:
        proto.write(1133871366150L, this.mPendingIntentRequest.hasPendingIntent());
        proto.write(1133871366151L, isPendingIntentCancelled());
        proto.write(1133871366152L, this.mRegistered);
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("endpointID: ");
        out.append(getHostEndPointId());
        out.append(", ");
        out.append("contextHub: ");
        out.append(getAttachedContextHubId());
        out.append(", ");
        if (this.mAttributionTag == null) goto L6;
        out.append("attributionTag: ");
        out.append(getAttributionTag());
        out.append(", ");
    L6:
        if (this.mPendingIntentRequest.isValid() == false) goto L8;
        out.append("intentCreatorPackage: ");
        out.append(this.mPackage);
        out.append(", ");
        out.append("nanoAppId: 0x");
        out.append(Long.toHexString(this.mPendingIntentRequest.getNanoAppId()));
        out.append(", ");
    L10:
        if (this.mMessageChannelNanoappIdMap.size() <= 0) goto L19;
        out.append("messageChannelNanoappSet: (");
        Iterator<Map.Entry<Long, Integer>> it = this.mMessageChannelNanoappIdMap.entrySet().iterator();
    L13:
        if (it.hasNext() == false) goto L18;
        Map.Entry<Long, Integer> entry = it.next();
        out.append("Nanoapp 0x");
        out.append(Long.toHexString(entry.getKey().longValue()));
        out.append(": Auth state: ");
        out.append(authStateToString(entry.getValue().intValue()));
        if (it.hasNext() == false) goto L13;
        out.append(", ");
        goto L13
    L18:
        out.append(")");
        out.append(", ");
    L19:
        PowerManager.WakeLock r1 = this.mWakeLock;
        monitor-enter(r1);
        out.append("wakelock: ");     // Catch: Throwable -> L25
        out.append(this.mWakeLock);     // Catch: Throwable -> L25
        monitor-exit(r1);     // Catch: Throwable -> L25
        out.append("]");
        return out.toString();
    L25:
        th = move-exception;
        throw th;
    L8:
        out.append("package: ");
        out.append(this.mPackage);
        out.append(", ");
        goto L10
    }

    public void callbackFinished() {
        releaseWakeLock();
    }

    public void reliableMessageCallbackFinished(int messageSequenceNumber, byte errorCode) {
        sendMessageDeliveryStatusToContextHub(messageSequenceNumber, errorCode);
        callbackFinished();
    }

    @Override // android.app.PendingIntent.OnFinished
    public void onSendFinished(PendingIntent pendingIntent, Intent intent, int resultCode, String resultData, Bundle resultExtras) {
        releaseWakeLock();
    }

    private void acquireWakeLock() {
        Binder.withCleanCallingIdentity(new ContextHubClientBroker$$ExternalSyntheticLambda13(this));
    }

    private /* synthetic */ void lambda$acquireWakeLock$12() throws Exception {
        if (this.mIsWakelockUsable.get() == false) goto L6;
        this.mWakeLock.acquire(WAKELOCK_TIMEOUT_MILLIS);
        return;
    }

    private void releaseWakeLock() {
        Binder.withCleanCallingIdentity(new ContextHubClientBroker$$ExternalSyntheticLambda6(this));
    }

    private /* synthetic */ void lambda$releaseWakeLock$13() throws Exception {
        if (this.mWakeLock.isHeld() == false) goto L11;
        this.mWakeLock.release();     // Catch: RuntimeException -> L6
        return;
    L6:
        e = move-exception;
        Log.e(TAG, "Releasing the wakelock fails - ", e);
        return;
    }

    private void releaseWakeLockOnExit() {
        Binder.withCleanCallingIdentity(new ContextHubClientBroker$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$releaseWakeLockOnExit$14() throws Exception {
        this.mIsWakelockUsable.set(false);
    L4:
        if (this.mWakeLock.isHeld() == false) goto L14;
        this.mWakeLock.release();     // Catch: RuntimeException -> L7
    L7:
        e = move-exception;
        Log.e(TAG, "Releasing the wakelock for all acquisitions fails - ", e);
        return;
    }

    private void sendMessageDeliveryStatusToContextHub(int messageSequenceNumber, byte errorCode) {
        MessageDeliveryStatus status = new MessageDeliveryStatus();
        status.messageSequenceNumber = messageSequenceNumber;
        status.errorCode = errorCode;
        if (this.mContextHubProxy.sendMessageDeliveryStatusToContextHub(this.mAttachedContextHubInfo.getId(), status) == 0) goto L6;
        Log.e(TAG, "Failed to send the reliable message status");
        return;
    }
}
