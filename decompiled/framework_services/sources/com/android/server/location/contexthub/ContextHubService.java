package com.android.server.location.contexthub;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.UserInfo;
import android.hardware.SensorPrivacyManagerInternal;
import android.hardware.contexthub.HubEndpointInfo;
import android.hardware.contexthub.IContextHubEndpoint;
import android.hardware.contexthub.IContextHubEndpointCallback;
import android.hardware.contexthub.IContextHubEndpointDiscoveryCallback;
import android.hardware.contexthub.MessageDeliveryStatus;
import android.hardware.location.ContextHubInfo;
import android.hardware.location.ContextHubMessage;
import android.hardware.location.ContextHubTransaction;
import android.hardware.location.HubInfo;
import android.hardware.location.IContextHubCallback;
import android.hardware.location.IContextHubClient;
import android.hardware.location.IContextHubClientCallback;
import android.hardware.location.IContextHubService;
import android.hardware.location.IContextHubTransactionCallback;
import android.hardware.location.NanoApp;
import android.hardware.location.NanoAppBinary;
import android.hardware.location.NanoAppFilter;
import android.hardware.location.NanoAppInstanceInfo;
import android.hardware.location.NanoAppMessage;
import android.hardware.location.NanoAppState;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Handler;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Pair;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.DumpUtils;
import com.android.server.LocalServices;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class ContextHubService extends IContextHubService.Stub {
    public static final int CONTEXT_HUB_EVENT_RESTARTED = 1;
    public static final int CONTEXT_HUB_EVENT_UNKNOWN = 0;
    private static final boolean DEBUG_LOG_ENABLED = false;
    public static final int MSG_DISABLE_NANO_APP = 2;
    public static final int MSG_ENABLE_NANO_APP = 1;
    public static final int MSG_HUB_RESET = 7;
    public static final int MSG_LOAD_NANO_APP = 3;
    public static final int MSG_QUERY_MEMORY = 6;
    public static final int MSG_QUERY_NANO_APPS = 5;
    public static final int MSG_UNLOAD_NANO_APP = 4;
    private static final int OS_APP_INSTANCE = -1;
    private static final int PERIOD_METRIC_QUERY_DAYS = 1;
    private static final String TAG = "ContextHubService";
    private final RemoteCallbackList<IContextHubCallback> mCallbacksList;
    private ContextHubClientManager mClientManager;
    private final Context mContext;
    private Map<Integer, ContextHubInfo> mContextHubIdToInfoMap;
    private List<ContextHubInfo> mContextHubInfoList;
    private final IContextHubWrapper mContextHubWrapper;
    private final ScheduledThreadPoolExecutor mDailyMetricTimer;
    private Map<Integer, IContextHubClient> mDefaultClientMap;
    private ContextHubEndpointManager mEndpointManager;
    private final HubInfoRegistry mHubInfoRegistry;
    private boolean mIsBtMainEnabled;
    private boolean mIsBtScanningEnabled;
    private final AtomicBoolean mIsTestModeEnabled;
    private boolean mIsWifiAvailable;
    private boolean mIsWifiMainEnabled;
    private boolean mIsWifiScanningEnabled;
    private final Map<Integer, AtomicLong> mLastRestartTimestampMap;
    private final Set<Integer> mMetricQueryPendingContextHubIds;
    private final NanoAppStateManager mNanoAppStateManager;
    private final PriorityQueue<ReliableMessageRecord> mReliableMessageRecordQueue;
    private final Object mSendWifiSettingUpdateLock;
    private SensorPrivacyManagerInternal mSensorPrivacyManagerInternal;
    private List<String> mSupportedContextHubPerms;
    private final ContextHubTestModeManager mTestModeManager;
    private ContextHubTransactionManager mTransactionManager;
    private UserManager mUserManager;

    private class ContextHubServiceCallback implements IContextHubWrapper.ICallback {
        private final int mContextHubId;
        final /* synthetic */ ContextHubService this$0;

        /* JADX INFO: renamed from: $r8$lambda$ZZDPhxMtDLA-yjsYmjJcmGd2XOM, reason: not valid java name */
        public static /* synthetic */ void m5197$r8$lambda$ZZDPhxMtDLAyjsYmjJcmGd2XOM(ContextHubServiceCallback r0, short r1, NanoAppMessage r2, List r3, List r4) {
            r0.lambda$handleNanoappMessage$0(r1, r2, r3, r4);
        }

        ContextHubServiceCallback(ContextHubService r1, int contextHubId) {
            this.this$0 = r1;
            this.mContextHubId = contextHubId;
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper.ICallback
        public void handleTransactionResult(int transactionId, boolean success) {
            ContextHubService.m5188$$Nest$mhandleTransactionResultCallback(this.this$0, this.mContextHubId, transactionId, success);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper.ICallback
        public void handleContextHubEvent(int eventType) {
            ContextHubService.m5184$$Nest$mhandleHubEventCallback(this.this$0, this.mContextHubId, eventType);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper.ICallback
        public void handleNanoappAbort(long nanoappId, int abortCode) {
            ContextHubService.m5182$$Nest$mhandleAppAbortCallback(this.this$0, this.mContextHubId, nanoappId, abortCode);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper.ICallback
        public void handleNanoappInfo(List<NanoAppState> nanoappStateList) {
            ContextHubService.m5187$$Nest$mhandleQueryAppsCallback(this.this$0, this.mContextHubId, nanoappStateList);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper.ICallback
        public void handleNanoappMessage(short hostEndpointId, NanoAppMessage message, List<String> nanoappPermissions, List<String> messagePermissions) {
            if (0 == 0) goto L7;
            final ContextHubServiceCallback r3 = this;
            final short hostEndpointId2 = hostEndpointId;
            final NanoAppMessage message2 = message;
            final List<String> nanoappPermissions2 = nanoappPermissions;
            final List<String> messagePermissions2 = messagePermissions;
            if (ContextHubService.m5181$$Nest$fgetmTestModeManager(this.this$0).handleNanoappMessage(new ContextHubService$ContextHubServiceCallback$$ExternalSyntheticLambda1(r3, hostEndpointId2, message2, nanoappPermissions2, messagePermissions2), message2) == true) goto L10;
        L8:
            List<String> nanoappPermissions3 = nanoappPermissions2;
            short hostEndpointId3 = hostEndpointId2;
            List<String> messagePermissions3 = messagePermissions2;
            NanoAppMessage message3 = message2;
            ContextHubService.m5183$$Nest$mhandleClientMessageCallback(r3.this$0, r3.mContextHubId, hostEndpointId3, message3, nanoappPermissions3, messagePermissions3);
            return;
        L10:
            return;
        L7:
            r3 = this;
            hostEndpointId2 = hostEndpointId;
            message2 = message;
            nanoappPermissions2 = nanoappPermissions;
            messagePermissions2 = messagePermissions;
            goto L8
        }

        private /* synthetic */ void lambda$handleNanoappMessage$0(short hostEndpointId, NanoAppMessage message, List nanoappPermissions, List messagePermissions) {
            ContextHubService.m5183$$Nest$mhandleClientMessageCallback(this.this$0, this.mContextHubId, hostEndpointId, message, nanoappPermissions, messagePermissions);
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper.ICallback
        public void handleServiceRestart() {
            Log.i(ContextHubService.TAG, "Recovering from Context Hub HAL restart...");
            ContextHubService.m5190$$Nest$minitExistingCallbacks(this.this$0);
            if (ContextHubService.m5179$$Nest$fgetmHubInfoRegistry(this.this$0) == null) goto L6;
            ContextHubService.m5179$$Nest$fgetmHubInfoRegistry(this.this$0).onHalRestart();
        L6:
            if (ContextHubService.m5178$$Nest$fgetmEndpointManager(this.this$0) == null) goto L8;
            ContextHubService.m5178$$Nest$fgetmEndpointManager(this.this$0).onHalRestart();
        L8:
            ContextHubService.m5192$$Nest$mresetSettings(this.this$0);
            ContextHubService.m5176$$Nest$fgetmClientManager(this.this$0).forEachClientOfHub(this.mContextHubId, new ContextHubService$ContextHubServiceCallback$$ExternalSyntheticLambda0());
            Log.i(ContextHubService.TAG, "Finished recovering from Context Hub HAL restart");
        }

        @Override // com.android.server.location.contexthub.IContextHubWrapper.ICallback
        public void handleMessageDeliveryStatus(MessageDeliveryStatus messageDeliveryStatus) {
            ContextHubService.m5186$$Nest$mhandleMessageDeliveryStatusCallback(this.this$0, messageDeliveryStatus);
        }
    }

    private static class ReliableMessageRecord {
        public int mContextHubId;
        byte mErrorCode;
        public int mMessageSequenceNumber;
        public long mTimestamp;

        ReliableMessageRecord(int contextHubId, long timestamp, int messageSequenceNumber, byte errorCode) {
            this.mContextHubId = contextHubId;
            this.mTimestamp = timestamp;
            this.mMessageSequenceNumber = messageSequenceNumber;
            this.mErrorCode = errorCode;
        }

        public int getContextHubId() {
            return this.mContextHubId;
        }

        public long getTimestamp() {
            return this.mTimestamp;
        }

        public int getMessageSequenceNumber() {
            return this.mMessageSequenceNumber;
        }

        public byte getErrorCode() {
            return this.mErrorCode;
        }

        public void setErrorCode(byte errorCode) {
            this.mErrorCode = errorCode;
        }

        public boolean isExpired() {
            if ((this.mTimestamp + ContextHubTransactionManager.RELIABLE_MESSAGE_DUPLICATE_DETECTION_TIMEOUT.toNanos()) >= SystemClock.elapsedRealtimeNanos()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    /* JADX INFO: renamed from: $r8$lambda$5GSozA6c48-Bh-6EVaeMfCxFKQw, reason: not valid java name */
    public static /* synthetic */ void m5173$r8$lambda$5GSozA6c48Bh6EVaeMfCxFKQw(String r0, long r1, ContextHubClientBroker r3) {
        lambda$denyClientAuthState$2(r0, r1, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$TB7eVzf-rARmrgzh4SrZkX7lAhM, reason: not valid java name */
    public static /* synthetic */ void m5174$r8$lambda$TB7eVzfrARmrgzh4SrZkX7lAhM(ContextHubService r0) {
        r0.lambda$scheduleDailyMetricSnapshot$4();
    }

    public static /* synthetic */ void $r8$lambda$bctfr7Wm6zM1mt5FwQ_kHaH8yCA(ContextHubService r0, int r1, boolean r2) {
        r0.lambda$initMicrophoneSettingNotifications$0(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$oZBCHNRjaf6Cw4wdWNHDMe-IVbc, reason: not valid java name */
    public static /* synthetic */ void m5175$r8$lambda$oZBCHNRjaf6Cw4wdWNHDMeIVbc(NanoAppFilter r0, ArrayList r1, NanoAppInstanceInfo r2) {
        lambda$findNanoAppOnHub$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$zC9jl1nDfno9HebZ0ZkC3fCokaw(ProtoOutputStream r0, ContextHubInfo r1) {
        lambda$dump$3(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClientManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ContextHubClientManager m5176$$Nest$fgetmClientManager(ContextHubService r0) {
        return r0.mClientManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultClientMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m5177$$Nest$fgetmDefaultClientMap(ContextHubService r0) {
        return r0.mDefaultClientMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEndpointManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ContextHubEndpointManager m5178$$Nest$fgetmEndpointManager(ContextHubService r0) {
        return r0.mEndpointManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHubInfoRegistry, reason: not valid java name */
    static /* bridge */ /* synthetic */ HubInfoRegistry m5179$$Nest$fgetmHubInfoRegistry(ContextHubService r0) {
        return r0.mHubInfoRegistry;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNanoAppStateManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ NanoAppStateManager m5180$$Nest$fgetmNanoAppStateManager(ContextHubService r0) {
        return r0.mNanoAppStateManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTestModeManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ContextHubTestModeManager m5181$$Nest$fgetmTestModeManager(ContextHubService r0) {
        return r0.mTestModeManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleAppAbortCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5182$$Nest$mhandleAppAbortCallback(ContextHubService r0, int r1, long r2, int r4) {
        r0.handleAppAbortCallback(r1, r2, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleClientMessageCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5183$$Nest$mhandleClientMessageCallback(ContextHubService r0, int r1, short r2, NanoAppMessage r3, List r4, List r5) {
        r0.handleClientMessageCallback(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleHubEventCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5184$$Nest$mhandleHubEventCallback(ContextHubService r0, int r1, int r2) {
        r0.handleHubEventCallback(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLoadResponseOldApi, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5185$$Nest$mhandleLoadResponseOldApi(ContextHubService r0, int r1, int r2, NanoAppBinary r3) {
        r0.handleLoadResponseOldApi(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleMessageDeliveryStatusCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5186$$Nest$mhandleMessageDeliveryStatusCallback(ContextHubService r0, MessageDeliveryStatus r1) {
        r0.handleMessageDeliveryStatusCallback(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleQueryAppsCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5187$$Nest$mhandleQueryAppsCallback(ContextHubService r0, int r1, List r2) {
        r0.handleQueryAppsCallback(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleTransactionResultCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5188$$Nest$mhandleTransactionResultCallback(ContextHubService r0, int r1, int r2, boolean r3) {
        r0.handleTransactionResultCallback(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleUnloadResponseOldApi, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5189$$Nest$mhandleUnloadResponseOldApi(ContextHubService r0, int r1, int r2) {
        r0.handleUnloadResponseOldApi(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$minitExistingCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5190$$Nest$minitExistingCallbacks(ContextHubService r0) {
        r0.initExistingCallbacks();
    }

    /* JADX INFO: renamed from: -$$Nest$monMessageReceiptOldApi, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5191$$Nest$monMessageReceiptOldApi(ContextHubService r0, int r1, int r2, int r3, byte[] r4) {
        return r0.onMessageReceiptOldApi(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mresetSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5192$$Nest$mresetSettings(ContextHubService r0) {
        r0.resetSettings();
    }

    /* JADX INFO: renamed from: -$$Nest$msendAirplaneModeSettingUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5193$$Nest$msendAirplaneModeSettingUpdate(ContextHubService r0) {
        r0.sendAirplaneModeSettingUpdate();
    }

    /* JADX INFO: renamed from: -$$Nest$msendBtSettingUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5194$$Nest$msendBtSettingUpdate(ContextHubService r0, boolean r1) {
        r0.sendBtSettingUpdate(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msendLocationSettingUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5195$$Nest$msendLocationSettingUpdate(ContextHubService r0) {
        r0.sendLocationSettingUpdate();
    }

    /* JADX INFO: renamed from: -$$Nest$msendWifiSettingUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5196$$Nest$msendWifiSettingUpdate(ContextHubService r0, boolean r1) {
        r0.sendWifiSettingUpdate(r1);
    }

    public ContextHubService(Context context, IContextHubWrapper contextHubWrapper) {
        this.mCallbacksList = new RemoteCallbackList();
        this.mNanoAppStateManager = new NanoAppStateManager();
        this.mDailyMetricTimer = new ScheduledThreadPoolExecutor(1);
        this.mReliableMessageRecordQueue = new PriorityQueue(Comparator.comparingLong(new ContextHubService$$ExternalSyntheticLambda2()));
        this.mTestModeManager = new ContextHubTestModeManager();
        this.mIsWifiAvailable = false;
        this.mIsWifiScanningEnabled = false;
        this.mIsWifiMainEnabled = false;
        this.mIsBtScanningEnabled = false;
        this.mIsBtMainEnabled = false;
        this.mIsTestModeEnabled = new AtomicBoolean(false);
        this.mMetricQueryPendingContextHubIds = Collections.newSetFromMap(new ConcurrentHashMap());
        this.mSendWifiSettingUpdateLock = new Object();
        this.mUserManager = null;
        this.mLastRestartTimestampMap = new HashMap();
        Log.i(TAG, "Starting Context Hub Service init");
        this.mContext = context;
        long startTimeNs = SystemClock.elapsedRealtimeNanos();
        this.mContextHubWrapper = contextHubWrapper;
        if (initContextHubServiceState(startTimeNs) == true) goto L16;
        Log.e(TAG, "Failed to initialize the Context Hub Service");
        this.mHubInfoRegistry = null;
        return;
    L16:
        HubInfoRegistry registry = new HubInfoRegistry(this.mContext, this.mContextHubWrapper);     // Catch: Throwable -> L9
        this.mEndpointManager = new ContextHubEndpointManager(this.mContext, this.mContextHubWrapper, registry, this.mTransactionManager);     // Catch: Throwable -> L9
        this.mEndpointManager.init();     // Catch: Throwable -> L9
        Log.d(TAG, "Enabling generic offload API");     // Catch: Throwable -> L9
    L14:
        this.mHubInfoRegistry = registry;
        initDefaultClientMap();
        initLocationSettingNotifications();
        initWifiSettingNotifications();
        initAirplaneModeSettingNotifications();
        initMicrophoneSettingNotifications();
        initBtSettingNotifications();
        scheduleDailyMetricSnapshot();
        Log.i(TAG, "Finished Context Hub Service init");
        return;
    L9:
        e = move-exception;
        this.mEndpointManager = null;
        if ((e instanceof UnsupportedOperationException) == false) goto L13;
        Log.d(TAG, "Generic offload API not supported by HAL");
    L13:
        registry = null;
        goto L14
    }

    private IContextHubClientCallback createDefaultClientCallback(final int contextHubId) {
        return new AnonymousClass1(this, contextHubId);
    }

    private boolean initContextHubServiceState(long startTimeNs) {
        if (this.mContextHubWrapper != null) goto L12;
        this.mTransactionManager = null;
        this.mClientManager = null;
        this.mSensorPrivacyManagerInternal = null;
        this.mDefaultClientMap = Collections.emptyMap();
        this.mContextHubIdToInfoMap = Collections.emptyMap();
        this.mSupportedContextHubPerms = Collections.emptyList();
        this.mContextHubInfoList = Collections.emptyList();
        return false;
    L12:
        Pair<List<ContextHubInfo>, List<String>> hubInfo = this.mContextHubWrapper.getContextHubs();     // Catch: RemoteException -> L8
    L10:
        long bootTimeNs = SystemClock.elapsedRealtimeNanos() - startTimeNs;
        int numContextHubs = ((List) hubInfo.first).size();
        ContextHubStatsLog.write(ContextHubStatsLog.CONTEXT_HUB_BOOTED, bootTimeNs, numContextHubs);
        this.mContextHubIdToInfoMap = Collections.unmodifiableMap(ContextHubServiceUtil.createContextHubInfoMap((List) hubInfo.first));
        this.mSupportedContextHubPerms = (List) hubInfo.second;
        this.mContextHubInfoList = new ArrayList(this.mContextHubIdToInfoMap.values());
        this.mClientManager = new ContextHubClientManager(this.mContext, this.mContextHubWrapper);
        this.mTransactionManager = new ContextHubTransactionManager(this.mContextHubWrapper, this.mClientManager, this.mNanoAppStateManager);
        this.mSensorPrivacyManagerInternal = (SensorPrivacyManagerInternal) LocalServices.getService(SensorPrivacyManagerInternal.class);
        return true;
    L8:
        e = move-exception;
        Log.e(TAG, "RemoteException while getting Context Hub info", e);
        hubInfo = new Pair(Collections.emptyList(), Collections.emptyList());
        goto L10
    }

    private void initDefaultClientMap() {
        HashMap<Integer, IContextHubClient> defaultClientMap = new HashMap();
        Iterator<Map.Entry<Integer, ContextHubInfo>> r2 = this.mContextHubIdToInfoMap.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Map.Entry<Integer, ContextHubInfo> entry = r2.next();
        int contextHubId = entry.getKey().intValue();
        ContextHubInfo contextHubInfo = entry.getValue();
        this.mLastRestartTimestampMap.put(Integer.valueOf(contextHubId), new AtomicLong(SystemClock.elapsedRealtimeNanos()));
        this.mContextHubWrapper.registerCallback(contextHubId, new ContextHubServiceCallback(this, contextHubId));     // Catch: RemoteException -> L8
    L10:
        IContextHubClient client = this.mClientManager.registerClient(contextHubInfo, createDefaultClientCallback(contextHubId), null, this.mTransactionManager, this.mContext.getPackageName());
        defaultClientMap.put(Integer.valueOf(contextHubId), client);
        queryNanoAppsInternal(contextHubId);
    L8:
        e = move-exception;
        Log.e(TAG, "RemoteException while registering service callback for hub (ID = " + contextHubId + ")", e);
        goto L10
    L11:
        this.mDefaultClientMap = Collections.unmodifiableMap(defaultClientMap);
    }

    private void initExistingCallbacks() {
        Iterator<Integer> r1 = this.mContextHubIdToInfoMap.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        int contextHubId = r1.next().intValue();
        this.mContextHubWrapper.registerExistingCallback(contextHubId);     // Catch: RemoteException -> L8
        Log.i(TAG, "Re-registered callback to context hub " + contextHubId);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Log.e(TAG, "RemoteException while registering existing service callback for hub (ID = " + contextHubId + ")", e);
        goto L4
    }

    private void initLocationSettingNotifications() {
        if (this.mContextHubWrapper != null) goto L5;
        return;
    L5:
        if (this.mContextHubWrapper.supportsLocationSettingNotifications() == false) goto L10;
        sendLocationSettingUpdate();
        final Handler r3 = null;
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("location_mode"), true, new AnonymousClass2(this, r3), -1);
        return;
    }

    private void initWifiSettingNotifications() {
        if (this.mContextHubWrapper != null) goto L5;
        return;
    L5:
        if (this.mContextHubWrapper.supportsWifiSettingNotifications() == false) goto L10;
        sendWifiSettingUpdate(true);
        BroadcastReceiver wifiReceiver = new AnonymousClass3(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        filter.addAction("android.net.wifi.action.WIFI_SCAN_AVAILABILITY_CHANGED");
        this.mContext.registerReceiver(wifiReceiver, filter);
        final Handler r6 = null;
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("wifi_scan_always_enabled"), true, new AnonymousClass4(this, r6), -1);
        return;
    }

    private void initAirplaneModeSettingNotifications() {
        if (this.mContextHubWrapper != null) goto L5;
        return;
    L5:
        if (this.mContextHubWrapper.supportsAirplaneModeSettingNotifications() == false) goto L10;
        sendAirplaneModeSettingUpdate();
        final Handler r3 = null;
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("airplane_mode_on"), true, new AnonymousClass5(this, r3), -1);
        return;
    }

    private void initMicrophoneSettingNotifications() {
        if (this.mContextHubWrapper != null) goto L5;
        return;
    L5:
        if (this.mContextHubWrapper.supportsMicrophoneSettingNotifications() == true) goto L8;
        return;
    L8:
        if (this.mUserManager != null) goto L13;
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        if (this.mUserManager != null) goto L13;
        Log.e(TAG, "Unable to get the UserManager service");
        return;
    L13:
        sendMicrophoneDisableSettingUpdateForCurrentUser();
        if (this.mSensorPrivacyManagerInternal != null) goto L17;
        Log.e(TAG, "Unable to add a sensor privacy listener for all users");
        return;
    L17:
        this.mSensorPrivacyManagerInternal.addSensorPrivacyListenerForAllUsers(1, new ContextHubService$$ExternalSyntheticLambda6(this));
    }

    private /* synthetic */ void lambda$initMicrophoneSettingNotifications$0(int userId, boolean enabled) {
        if (UserManager.isHeadlessSystemUserMode() == false) goto L5;
    L6:
        Log.d(TAG, "User: " + userId + " mic privacy: " + enabled);
        sendMicrophoneDisableSettingUpdate(enabled);
        return;
    L5:
        if (userId == getCurrentUserId()) goto L6;
    }

    private void initBtSettingNotifications() {
        if (this.mContextHubWrapper != null) goto L5;
        return;
    L5:
        if (this.mContextHubWrapper.supportsBtSettingNotifications() == false) goto L10;
        sendBtSettingUpdate(true);
        BroadcastReceiver btReceiver = new AnonymousClass6(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.mContext.registerReceiver(btReceiver, filter);
        final Handler r5 = null;
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("ble_scan_always_enabled"), false, new AnonymousClass7(this, r5), -1);
        return;
    }

    private void resetSettings() {
        this.mIsTestModeEnabled.set(false);
        sendLocationSettingUpdate();
        sendWifiSettingUpdate(true);
        sendAirplaneModeSettingUpdate();
        sendMicrophoneDisableSettingUpdateForCurrentUser();
        sendBtSettingUpdate(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver result) {
        new ContextHubShellCommand(this.mContext, this).exec(this, in, out, err, args, callback, result);
    }

    public int registerCallback(IContextHubCallback callback) throws RemoteException {
        super.registerCallback_enforcePermission();
        this.mCallbacksList.register(callback);
        Log.d(TAG, "Added callback, total callbacks " + this.mCallbacksList.getRegisteredCallbackCount());
        return 0;
    }

    public int[] getContextHubHandles() {
        super.getContextHubHandles_enforcePermission();
        return ContextHubServiceUtil.createPrimitiveIntArray(this.mContextHubIdToInfoMap.keySet());
    }

    public ContextHubInfo getContextHubInfo(int contextHubHandle) {
        super.getContextHubInfo_enforcePermission();
        if (this.mContextHubIdToInfoMap.containsKey(Integer.valueOf(contextHubHandle)) == true) goto L7;
        Log.e(TAG, "Invalid Context Hub handle " + contextHubHandle + " in getContextHubInfo");
        return null;
    L7:
        return this.mContextHubIdToInfoMap.get(Integer.valueOf(contextHubHandle));
    }

    public List<ContextHubInfo> getContextHubs() {
        super.getContextHubs_enforcePermission();
        return this.mContextHubInfoList;
    }

    public List<HubInfo> getHubs() throws RemoteException {
        super.getHubs_enforcePermission();
        checkHubDiscoveryPreconditions();
        return this.mHubInfoRegistry.getHubs();
    }

    public List<HubEndpointInfo> findEndpoints(long endpointId) {
        super.findEndpoints_enforcePermission();
        checkEndpointDiscoveryPreconditions();
        return this.mHubInfoRegistry.findEndpoints(endpointId);
    }

    public List<HubEndpointInfo> findEndpointsWithService(String serviceDescriptor) {
        super.findEndpointsWithService_enforcePermission();
        checkEndpointDiscoveryPreconditions();
        return this.mHubInfoRegistry.findEndpointsWithService(serviceDescriptor);
    }

    public IContextHubEndpoint registerEndpoint(HubEndpointInfo pendingHubEndpointInfo, IContextHubEndpointCallback callback, String packageName, String attributionTag) throws RemoteException {
        super.registerEndpoint_enforcePermission();
        if (this.mEndpointManager == null) goto L9;
        if (callback != null) goto L6;
        Log.e(TAG, "Endpoint callback is invalid");
        throw new IllegalArgumentException("registerEndpoint must have a non-null callback");
    L6:
        return this.mEndpointManager.registerEndpoint(pendingHubEndpointInfo, callback, packageName, attributionTag);
    L9:
        Log.e(TAG, "Endpoint manager failed to initialize");
        throw new UnsupportedOperationException("Endpoint registration is not supported");
    }

    public void registerEndpointDiscoveryCallbackId(long endpointId, IContextHubEndpointDiscoveryCallback callback) throws RemoteException {
        super.registerEndpointDiscoveryCallbackId_enforcePermission();
        checkEndpointDiscoveryPreconditions();
        this.mHubInfoRegistry.registerEndpointDiscoveryCallback(endpointId, callback);
    }

    public void registerEndpointDiscoveryCallbackDescriptor(String serviceDescriptor, IContextHubEndpointDiscoveryCallback callback) throws RemoteException {
        super.registerEndpointDiscoveryCallbackDescriptor_enforcePermission();
        checkEndpointDiscoveryPreconditions();
        this.mHubInfoRegistry.registerEndpointDiscoveryCallback(serviceDescriptor, callback);
    }

    public void unregisterEndpointDiscoveryCallback(IContextHubEndpointDiscoveryCallback callback) throws RemoteException {
        super.unregisterEndpointDiscoveryCallback_enforcePermission();
        checkEndpointDiscoveryPreconditions();
        this.mHubInfoRegistry.unregisterEndpointDiscoveryCallback(callback);
    }

    public void onDiscoveryCallbackFinished() throws RemoteException {
        super.onDiscoveryCallbackFinished_enforcePermission();
        this.mHubInfoRegistry.onDiscoveryCallbackFinished();
    }

    private void checkEndpointDiscoveryPreconditions() {
        if (this.mHubInfoRegistry == null) goto L5;
        return;
    L5:
        Log.e(TAG, "Hub endpoint registry failed to initialize");
        throw new UnsupportedOperationException("Endpoint discovery is not supported");
    }

    private void checkHubDiscoveryPreconditions() {
        if (this.mHubInfoRegistry == null) goto L5;
        return;
    L5:
        Log.e(TAG, "Hub registry failed to initialize");
        throw new UnsupportedOperationException("Hub discovery is not supported");
    }

    private IContextHubTransactionCallback createLoadTransactionCallback(final int contextHubId, final NanoAppBinary nanoAppBinary) {
        return new AnonymousClass8(this, contextHubId, nanoAppBinary);
    }

    private IContextHubTransactionCallback createUnloadTransactionCallback(final int contextHubId) {
        return new AnonymousClass9(this, contextHubId);
    }

    private IContextHubTransactionCallback createQueryTransactionCallback(final int contextHubId) {
        return new AnonymousClass10(this, contextHubId);
    }

    public int loadNanoApp(int contextHubHandle, NanoApp nanoApp) {
        super.loadNanoApp_enforcePermission();
        if (this.mContextHubWrapper != null) goto L6;
        return -1;
    L6:
        if (isValidContextHubId(contextHubHandle) == true) goto L9;
        Log.e(TAG, "Invalid Context Hub handle " + contextHubHandle + " in loadNanoApp");
        return -1;
    L9:
        if (nanoApp != null) goto L12;
        Log.e(TAG, "NanoApp cannot be null in loadNanoApp");
        return -1;
    L12:
        NanoAppBinary nanoAppBinary = new NanoAppBinary(nanoApp.getAppBinary());
        IContextHubTransactionCallback onCompleteCallback = createLoadTransactionCallback(contextHubHandle, nanoAppBinary);
        ContextHubServiceTransaction transaction = this.mTransactionManager.createLoadTransaction(contextHubHandle, nanoAppBinary, onCompleteCallback, getCallingPackageName());
        this.mTransactionManager.addTransaction(transaction);
        return 0;
    }

    public int unloadNanoApp(int nanoAppHandle) {
        super.unloadNanoApp_enforcePermission();
        if (this.mContextHubWrapper != null) goto L5;
        return -1;
    L5:
        NanoAppInstanceInfo info = this.mNanoAppStateManager.getNanoAppInstanceInfo(nanoAppHandle);
        if (info != null) goto L9;
        Log.e(TAG, "Invalid nanoapp handle " + nanoAppHandle + " in unloadNanoApp");
        return -1;
    L9:
        int contextHubId = info.getContexthubId();
        long nanoAppId = info.getAppId();
        IContextHubTransactionCallback onCompleteCallback = createUnloadTransactionCallback(contextHubId);
        ContextHubServiceTransaction transaction = this.mTransactionManager.createUnloadTransaction(contextHubId, nanoAppId, onCompleteCallback, getCallingPackageName());
        this.mTransactionManager.addTransaction(transaction);
        return 0;
    }

    public NanoAppInstanceInfo getNanoAppInstanceInfo(int nanoAppHandle) {
        super.getNanoAppInstanceInfo_enforcePermission();
        return this.mNanoAppStateManager.getNanoAppInstanceInfo(nanoAppHandle);
    }

    public int[] findNanoAppOnHub(int contextHubHandle, final NanoAppFilter filter) {
        super.findNanoAppOnHub_enforcePermission();
        final ArrayList<Integer> foundInstances = new ArrayList();
        if (filter == null) goto L5;
        this.mNanoAppStateManager.foreachNanoAppInstanceInfo(new ContextHubService$$ExternalSyntheticLambda3(filter, foundInstances));
    L5:
        int[] retArray = new int[foundInstances.size()];
        int i = 0;
    L7:
        if (i >= foundInstances.size()) goto L10;
        retArray[i] = foundInstances.get(i).intValue();
        i = i + 1;
        goto L7
    L10:
        return retArray;
    }

    private static /* synthetic */ void lambda$findNanoAppOnHub$1(NanoAppFilter filter, ArrayList foundInstances, NanoAppInstanceInfo info) {
        if (filter.testMatch(info) == false) goto L6;
        foundInstances.add(Integer.valueOf(info.getHandle()));
        return;
    }

    private boolean queryNanoAppsInternal(int contextHubId) {
        if (this.mContextHubWrapper != null) goto L6;
        return false;
    L6:
        IContextHubTransactionCallback onCompleteCallback = createQueryTransactionCallback(contextHubId);
        ContextHubServiceTransaction transaction = this.mTransactionManager.createQueryTransaction(contextHubId, onCompleteCallback, getCallingPackageName());
        this.mTransactionManager.addTransaction(transaction);
        return true;
    }

    public int sendMessage(int contextHubHandle, int nanoAppHandle, ContextHubMessage msg) throws RemoteException {
        super.sendMessage_enforcePermission();
        if (this.mContextHubWrapper != null) goto L6;
        return -1;
    L6:
        if (msg != null) goto L10;
        Log.e(TAG, "ContextHubMessage cannot be null in sendMessage");
        return -1;
    L10:
        if (msg.getData() != null) goto L14;
        Log.e(TAG, "ContextHubMessage message body cannot be null in sendMessage");
        return -1;
    L14:
        if (isValidContextHubId(contextHubHandle) == true) goto L17;
        Log.e(TAG, "Invalid Context Hub handle " + contextHubHandle + " in sendMessage");
        return -1;
    L17:
        boolean success = false;
        if (nanoAppHandle == (-1)) goto L20;
        NanoAppInstanceInfo info = getNanoAppInstanceInfo(nanoAppHandle);
        if (info == null) goto L30;
        NanoAppMessage message = NanoAppMessage.createMessageToNanoApp(info.getAppId(), msg.getMsgType(), msg.getData());
        IContextHubClient client = this.mDefaultClientMap.get(Integer.valueOf(contextHubHandle));
        if (client.sendMessageToNanoApp(message) != 0) goto L28;
        boolean r6 = true;
    L29:
        success = r6;
    L31:
        if (success == true) goto L33;
        return -1;
    L33:
        return 0;
    L28:
        r6 = false;
        goto L29
    L30:
        Log.e(TAG, "Failed to send nanoapp message - nanoapp with handle " + nanoAppHandle + " does not exist.");
        goto L31
    L20:
        if (msg.getMsgType() != 5) goto L22;
        success = queryNanoAppsInternal(contextHubHandle);
        goto L31
    L22:
        Log.e(TAG, "Invalid OS message params of type " + msg.getMsgType());
        goto L31
    }

    private void handleClientMessageCallback(int contextHubId, short hostEndpointId, NanoAppMessage message, List<String> nanoappPermissions, List<String> messagePermissions) {
        if (message.isReliable() == true) goto L6;
        this.mClientManager.onMessageFromNanoApp(contextHubId, hostEndpointId, message, nanoappPermissions, messagePermissions);
        cleanupReliableMessageRecordQueue();
        return;
    L6:
        NanoAppMessage message2 = message;
        PriorityQueue<ReliableMessageRecord> r10 = this.mReliableMessageRecordQueue;
        monitor-enter(r10);
        Optional<ReliableMessageRecord> record = findReliableMessageRecord(contextHubId, message2.getMessageSequenceNumber());     // Catch: Throwable -> L25
        if (record.isPresent() == true) goto L32;
        byte errorCode = this.mClientManager.onMessageFromNanoApp(contextHubId, hostEndpointId, message2, nanoappPermissions, messagePermissions);     // Catch: Throwable -> L25
        message2 = message2;
        this.mReliableMessageRecordQueue.add(new ReliableMessageRecord(contextHubId, SystemClock.elapsedRealtimeNanos(), message2.getMessageSequenceNumber(), errorCode));     // Catch: Throwable -> L23
        byte errorCode2 = errorCode;
    L20:
        monitor-exit(r10);     // Catch: Throwable -> L23
        sendMessageDeliveryStatusToContextHub(contextHubId, message2.getMessageSequenceNumber(), errorCode2);
        cleanupReliableMessageRecordQueue();
        return;
    L32:
        errorCode2 = record.get().getErrorCode();     // Catch: Throwable -> L13
        if (errorCode2 != 1) goto L15;
        Log.w(TAG, "Found duplicate reliable message with message sequence number: " + record.get().getMessageSequenceNumber() + ": retrying");     // Catch: Throwable -> L13
        errorCode2 = this.mClientManager.onMessageFromNanoApp(contextHubId, hostEndpointId, message2, nanoappPermissions, messagePermissions);     // Catch: Throwable -> L13
        record.get().setErrorCode(errorCode2);     // Catch: Throwable -> L13
    L31:
        goto L20
    L15:
        Log.w(TAG, "Found duplicate reliable message with message sequence number: " + record.get().getMessageSequenceNumber());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Throwable r11 = th;
    L27:
        monitor-exit(r10);     // Catch: Throwable -> L23
        throw r11;
    L23:
        th = move-exception;
        r11 = th;
    L25:
        th = move-exception;
        r11 = th;
        goto L27
    }

    private Optional<ReliableMessageRecord> findReliableMessageRecord(int contextHubId, int messageSequenceNumber) {
        Iterator<ReliableMessageRecord> r0 = this.mReliableMessageRecordQueue.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        ReliableMessageRecord record = r0.next();
        if (record.getContextHubId() != contextHubId) goto L4;
        if (record.getMessageSequenceNumber() != messageSequenceNumber) goto L4;
        return Optional.of(record);
    L13:
        return Optional.empty();
    }

    private void cleanupReliableMessageRecordQueue() {
        PriorityQueue<ReliableMessageRecord> r0 = this.mReliableMessageRecordQueue;
        monitor-enter(r0);
    L15:
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mReliableMessageRecordQueue.peek() == null) goto L11;
        if (this.mReliableMessageRecordQueue.peek().isExpired() == false) goto L11;
        this.mReliableMessageRecordQueue.poll();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void sendMessageDeliveryStatusToContextHub(int contextHubId, int messageSequenceNumber, byte errorCode) {
        MessageDeliveryStatus status = new MessageDeliveryStatus();
        status.messageSequenceNumber = messageSequenceNumber;
        status.errorCode = errorCode;
        if (this.mContextHubWrapper.sendMessageDeliveryStatusToContextHub(contextHubId, status) == 0) goto L6;
        Log.e(TAG, "Failed to send the reliable message status for message sequence number: " + messageSequenceNumber + " with error code: " + errorCode);
        return;
    }

    private void handleLoadResponseOldApi(int contextHubId, int result, NanoAppBinary nanoAppBinary) {
        if (nanoAppBinary != null) goto L5;
        Log.e(TAG, "Nanoapp binary field was null for a load transaction");
        return;
    L5:
        byte[] data = new byte[5];
        data[0] = (byte) result;
        int nanoAppHandle = this.mNanoAppStateManager.getNanoAppHandle(contextHubId, nanoAppBinary.getNanoAppId());
        ByteBuffer.wrap(data, 1, 4).order(ByteOrder.nativeOrder()).putInt(nanoAppHandle);
        onMessageReceiptOldApi(3, contextHubId, -1, data);
    }

    private void handleUnloadResponseOldApi(int contextHubId, int result) {
        byte[] data = {(byte) result};
        onMessageReceiptOldApi(4, contextHubId, -1, data);
    }

    private void handleTransactionResultCallback(int contextHubId, int transactionId, boolean success) {
        this.mTransactionManager.onTransactionResponse(transactionId, success);
    }

    private void handleMessageDeliveryStatusCallback(MessageDeliveryStatus messageDeliveryStatus) {
        ContextHubEventLogger.getInstance().logReliableMessageToNanoappStatus(messageDeliveryStatus.messageSequenceNumber, messageDeliveryStatus.errorCode);
        ContextHubTransactionManager r0 = this.mTransactionManager;
        int r1 = messageDeliveryStatus.messageSequenceNumber;
        if (messageDeliveryStatus.errorCode != 0) goto L5;
        boolean r2 = true;
    L6:
        r0.onMessageDeliveryResponse(r1, r2);
        return;
    L5:
        r2 = false;
        goto L6
    }

    private void handleHubEventCallback(int contextHubId, int eventType) {
        if (eventType != 1) goto L5;
        long now = SystemClock.elapsedRealtimeNanos();
        long lastRestartTimeNs = this.mLastRestartTimestampMap.get(Integer.valueOf(contextHubId)).getAndSet(now);
        ContextHubStatsLog.write(ContextHubStatsLog.CONTEXT_HUB_RESTARTED, TimeUnit.NANOSECONDS.toMillis(now - lastRestartTimeNs), contextHubId);
        ContextHubEventLogger.getInstance().logContextHubRestart(contextHubId);
        resetSettings();
        this.mTransactionManager.onHubReset();
        queryNanoAppsInternal(contextHubId);
        this.mClientManager.onHubReset(contextHubId);
        return;
    L5:
        Log.i(TAG, "Received unknown hub event (hub ID = " + contextHubId + ", type = " + eventType + ")");
    }

    private void handleAppAbortCallback(int contextHubId, long nanoAppId, int abortCode) {
        this.mClientManager.onNanoAppAborted(contextHubId, nanoAppId, abortCode);
    }

    private void handleQueryAppsCallback(int contextHubId, List<NanoAppState> nanoappStateList) {
        if (this.mMetricQueryPendingContextHubIds.contains(Integer.valueOf(contextHubId)) == false) goto L11;
        Iterator<NanoAppState> r0 = nanoappStateList.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        NanoAppState nanoappState = r0.next();
        ContextHubStatsLog.write(400, contextHubId, nanoappState.getNanoAppId(), (int) nanoappState.getNanoAppVersion());
        goto L6
    L8:
        this.mMetricQueryPendingContextHubIds.remove(Integer.valueOf(contextHubId));
        if (this.mMetricQueryPendingContextHubIds.isEmpty() == false) goto L11;
        scheduleDailyMetricSnapshot();
    L11:
        this.mNanoAppStateManager.updateCache(contextHubId, nanoappStateList);
        this.mTransactionManager.onQueryResponse(nanoappStateList);
    }

    private boolean isValidContextHubId(int contextHubId) {
        return this.mContextHubIdToInfoMap.containsKey(Integer.valueOf(contextHubId));
    }

    public IContextHubClient createClient(int contextHubId, IContextHubClientCallback clientCallback, String attributionTag, String packageName) {
        super.createClient_enforcePermission();
        if (isValidContextHubId(contextHubId) == false) goto L10;
        if (clientCallback == null) goto L8;
        ContextHubInfo contextHubInfo = this.mContextHubIdToInfoMap.get(Integer.valueOf(contextHubId));
        return this.mClientManager.registerClient(contextHubInfo, clientCallback, attributionTag, this.mTransactionManager, packageName);
    L8:
        throw new NullPointerException("Cannot register client with null callback");
    L10:
        throw new IllegalArgumentException("Invalid context hub ID " + contextHubId);
    }

    public IContextHubClient createPendingIntentClient(int contextHubId, PendingIntent pendingIntent, long nanoAppId, String attributionTag) {
        super.createPendingIntentClient_enforcePermission();
        if (isValidContextHubId(contextHubId) == false) goto L7;
        ContextHubInfo contextHubInfo = this.mContextHubIdToInfoMap.get(Integer.valueOf(contextHubId));
        return this.mClientManager.registerClient(contextHubInfo, pendingIntent, nanoAppId, attributionTag, this.mTransactionManager);
    L7:
        throw new IllegalArgumentException("Invalid context hub ID " + contextHubId);
    }

    public void loadNanoAppOnHub(int contextHubId, IContextHubTransactionCallback transactionCallback, NanoAppBinary nanoAppBinary) throws RemoteException {
        super.loadNanoAppOnHub_enforcePermission();
        if (checkHalProxyAndContextHubId(contextHubId, transactionCallback, 0) == true) goto L5;
        return;
    L5:
        if (nanoAppBinary != null) goto L8;
        Log.e(TAG, "NanoAppBinary cannot be null in loadNanoAppOnHub");
        transactionCallback.onTransactionComplete(2);
        return;
    L8:
        ContextHubServiceTransaction transaction = this.mTransactionManager.createLoadTransaction(contextHubId, nanoAppBinary, transactionCallback, getCallingPackageName());
        this.mTransactionManager.addTransaction(transaction);
    }

    public void unloadNanoAppFromHub(int contextHubId, IContextHubTransactionCallback transactionCallback, long nanoAppId) throws RemoteException {
        super.unloadNanoAppFromHub_enforcePermission();
        if (checkHalProxyAndContextHubId(contextHubId, transactionCallback, 1) == true) goto L5;
        return;
    L5:
        ContextHubServiceTransaction transaction = this.mTransactionManager.createUnloadTransaction(contextHubId, nanoAppId, transactionCallback, getCallingPackageName());
        this.mTransactionManager.addTransaction(transaction);
    }

    public void enableNanoApp(int contextHubId, IContextHubTransactionCallback transactionCallback, long nanoAppId) {
        super.enableNanoApp_enforcePermission();
        if (checkHalProxyAndContextHubId(contextHubId, transactionCallback, 2) == true) goto L5;
        return;
    L5:
        ContextHubServiceTransaction transaction = this.mTransactionManager.createEnableTransaction(contextHubId, nanoAppId, transactionCallback, getCallingPackageName());
        this.mTransactionManager.addTransaction(transaction);
    }

    public void disableNanoApp(int contextHubId, IContextHubTransactionCallback transactionCallback, long nanoAppId) {
        super.disableNanoApp_enforcePermission();
        if (checkHalProxyAndContextHubId(contextHubId, transactionCallback, 3) == true) goto L5;
        return;
    L5:
        ContextHubServiceTransaction transaction = this.mTransactionManager.createDisableTransaction(contextHubId, nanoAppId, transactionCallback, getCallingPackageName());
        this.mTransactionManager.addTransaction(transaction);
    }

    public void queryNanoApps(int contextHubId, IContextHubTransactionCallback transactionCallback) {
        super.queryNanoApps_enforcePermission();
        if (checkHalProxyAndContextHubId(contextHubId, transactionCallback, 4) == true) goto L5;
        return;
    L5:
        ContextHubServiceTransaction transaction = this.mTransactionManager.createQueryTransaction(contextHubId, transactionCallback, getCallingPackageName());
        this.mTransactionManager.addTransaction(transaction);
    }

    public long[] getPreloadedNanoAppIds(ContextHubInfo hubInfo) {
        super.getPreloadedNanoAppIds_enforcePermission();
        hubInfo.getClass();
        long[] nanoappIds = this.mContextHubWrapper.getPreloadedNanoappIds(hubInfo.getId());
        if (nanoappIds == null) goto L5;
        return nanoappIds;
    L5:
        return new long[0];
    }

    public boolean setTestMode(boolean enable) {
        super.setTestMode_enforcePermission();
        boolean status = this.mContextHubWrapper.setTestMode(enable);
        if (status == false) goto L5;
        this.mIsTestModeEnabled.set(enable);
    L5:
        Iterator<Integer> r1 = this.mDefaultClientMap.keySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        int contextHubId = r1.next().intValue();
        queryNanoAppsInternal(contextHubId);
        goto L7
    L9:
        return status;
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        int r0 = args.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L12;
        String arg = args[r1];
        if ("--proto".equals(arg) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        dump(new ProtoOutputStream(fd));
        return;
    L12:
        final IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");
        ipw.println("Dumping ContextHub Service");
        ipw.println("");
        ipw.println("=================== CONTEXT HUBS ====================");
        Iterator<ContextHubInfo> r2 = this.mContextHubIdToInfoMap.values().iterator();
    L14:
        if (r2.hasNext() == false) goto L16;
        ContextHubInfo hubInfo = r2.next();
        ipw.println(hubInfo);
        goto L14
    L16:
        ipw.println("Supported permissions: " + Arrays.toString(this.mSupportedContextHubPerms.toArray()));
        ipw.println("");
        if (this.mHubInfoRegistry == null) goto L19;
        this.mHubInfoRegistry.dump(ipw);
    L19:
        ipw.println("=================== NANOAPPS ====================");
        this.mNanoAppStateManager.foreachNanoAppInstanceInfo(new ContextHubService$$ExternalSyntheticLambda4(ipw));
        ipw.println("");
        ipw.println("=================== PRELOADED NANOAPPS ====================");
        dumpPreloadedNanoapps(ipw);
        ipw.println("");
        ipw.println("=================== CLIENTS ====================");
        ipw.println(this.mClientManager);
        if (this.mEndpointManager == null) goto L22;
        ipw.println("");
        ipw.println("=================== ENDPOINTS ====================");
        ipw.println(this.mEndpointManager);
    L22:
        ipw.println("");
        ipw.println("=================== TRANSACTIONS ====================");
        ipw.println(this.mTransactionManager);
        ipw.println("");
        ipw.println("=================== EVENTS ====================");
        ipw.println(ContextHubEventLogger.getInstance());
    }

    void denyClientAuthState(int contextHubId, final String packageName, final long nanoAppId) {
        Log.i(TAG, "Denying " + packageName + " access to " + Long.toHexString(nanoAppId) + " on context hub # " + contextHubId);
        this.mClientManager.forEachClientOfHub(contextHubId, new ContextHubService$$ExternalSyntheticLambda1(packageName, nanoAppId));
    }

    private static /* synthetic */ void lambda$denyClientAuthState$2(String packageName, long nanoAppId, ContextHubClientBroker client) {
        if (client.getPackageName().equals(packageName) == false) goto L6;
        client.updateNanoAppAuthState(nanoAppId, Collections.emptyList(), false, true);
        return;
    }

    private void dump(final ProtoOutputStream proto) {
        this.mContextHubIdToInfoMap.values().forEach(new ContextHubService$$ExternalSyntheticLambda5(proto));
        long token = proto.start(1146756268034L);
        this.mClientManager.dump(proto);
        proto.end(token);
        proto.flush();
    }

    private static /* synthetic */ void lambda$dump$3(ProtoOutputStream proto, ContextHubInfo hubInfo) {
        long token = proto.start(2246267895809L);
        hubInfo.dump(proto);
        proto.end(token);
    }

    private void dumpPreloadedNanoapps(PrintWriter pw) {
        if (this.mContextHubWrapper != null) goto L5;
        return;
    L5:
        Iterator<Integer> r0 = this.mContextHubIdToInfoMap.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L16;
        int contextHubId = r0.next().intValue();
        long[] preloadedNanoappIds = this.mContextHubWrapper.getPreloadedNanoappIds(contextHubId);
        if (preloadedNanoappIds == null) goto L10;
        pw.print("Context Hub (id=");
        pw.print(contextHubId);
        pw.println("):");
        int r3 = preloadedNanoappIds.length;
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L7;
        long preloadedNanoappId = preloadedNanoappIds[r4];
        pw.print("  ID: 0x");
        pw.println(Long.toHexString(preloadedNanoappId));
        r4 = r4 + 1;
        goto L13
    L10:
        return;
    }

    private int onMessageReceiptOldApi(int msgType, int contextHubHandle, int appInstance, byte[] data) {
        if (data != null) goto L5;
        return -1;
    L5:
        RemoteCallbackList<IContextHubCallback> r1 = this.mCallbacksList;
        monitor-enter(r1);
        int callbacksCount = this.mCallbacksList.beginBroadcast();     // Catch: Throwable -> L11
        if (callbacksCount >= 1) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L11
        return 0;
    L13:
        ContextHubMessage msg = new ContextHubMessage(msgType, 0, data);     // Catch: Throwable -> L11
        int i = 0;
    L14:
        if (i >= callbacksCount) goto L21;
        IContextHubCallback callback = this.mCallbacksList.getBroadcastItem(i);     // Catch: Throwable -> L11
        callback.onMessageReceipt(contextHubHandle, appInstance, msg);     // Catch: Throwable -> L11 RemoteException -> L18
    L20:
        i = i + 1;     // Catch: Throwable -> L11
    L18:
        e = move-exception;
        Log.i(TAG, "Exception (" + e + ") calling remote callback (" + callback + ").");     // Catch: Throwable -> L11
        goto L20
    L21:
        this.mCallbacksList.finishBroadcast();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return 0;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean checkHalProxyAndContextHubId(int contextHubId, IContextHubTransactionCallback callback, int transactionType) {
        if (this.mContextHubWrapper != null) goto L11;
        callback.onTransactionComplete(8);     // Catch: RemoteException -> L7
    L9:
        return false;
    L7:
        e = move-exception;
        Log.e(TAG, "RemoteException while calling onTransactionComplete", e);
        goto L9
    L11:
        if (isValidContextHubId(contextHubId) == true) goto L18;
        Log.e(TAG, "Cannot start " + ContextHubTransaction.typeToString(transactionType, false) + " transaction for invalid hub ID " + contextHubId);
        callback.onTransactionComplete(2);     // Catch: RemoteException -> L15
    L17:
        return false;
    L15:
        e = move-exception;
        Log.e(TAG, "RemoteException while calling onTransactionComplete", e);
        goto L17
    L18:
        return true;
    }

    private void sendLocationSettingUpdate() {
        boolean enabled = ((LocationManager) this.mContext.getSystemService(LocationManager.class)).isLocationEnabledForUser(UserHandle.CURRENT);
        this.mContextHubWrapper.onLocationSettingChanged(enabled);
    }

    private void sendWifiSettingUpdate(boolean forceUpdate) {
        Object r0 = this.mSendWifiSettingUpdateLock;
        monitor-enter(r0);
        WifiManager wifiManager = (WifiManager) this.mContext.getSystemService(WifiManager.class);     // Catch: Throwable -> L14
        boolean wifiEnabled = wifiManager.isWifiEnabled();     // Catch: Throwable -> L14
        boolean wifiScanEnabled = wifiManager.isScanAlwaysAvailable();     // Catch: Throwable -> L14
        if (wifiEnabled == true) goto L9;
        if (wifiScanEnabled == true) goto L9;
        boolean wifiAvailable = false;
    L10:
        if (forceUpdate == true) goto L16;
        if (this.mIsWifiAvailable != wifiAvailable) goto L16;
    L17:
        if (forceUpdate == false) goto L19;
    L20:
        this.mIsWifiScanningEnabled = wifiScanEnabled;     // Catch: Throwable -> L14
        this.mContextHubWrapper.onWifiScanningSettingChanged(wifiScanEnabled);     // Catch: Throwable -> L14
    L21:
        if (forceUpdate == false) goto L23;
    L24:
        this.mIsWifiMainEnabled = wifiEnabled;     // Catch: Throwable -> L14
        this.mContextHubWrapper.onWifiMainSettingChanged(wifiEnabled);     // Catch: Throwable -> L14
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L23:
        if (this.mIsWifiMainEnabled == wifiEnabled) goto L25;
    L19:
        if (this.mIsWifiScanningEnabled == wifiScanEnabled) goto L21;
    L16:
        this.mIsWifiAvailable = wifiAvailable;     // Catch: Throwable -> L14
        this.mContextHubWrapper.onWifiSettingChanged(wifiAvailable);     // Catch: Throwable -> L14
    L9:
        wifiAvailable = true;
    L14:
        th = move-exception;
        throw th;
    }

    private void sendBtSettingUpdate(boolean forceUpdate) {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter == null) goto L14;
        boolean btEnabled = adapter.isEnabled();
        boolean btScanEnabled = adapter.isBleScanAlwaysAvailable();
        if (forceUpdate == false) goto L7;
    L8:
        this.mIsBtScanningEnabled = btScanEnabled;
        this.mContextHubWrapper.onBtScanningSettingChanged(btScanEnabled);
    L9:
        if (forceUpdate == false) goto L11;
    L12:
        this.mIsBtMainEnabled = btEnabled;
        this.mContextHubWrapper.onBtMainSettingChanged(btEnabled);
        return;
    L11:
        if (this.mIsBtMainEnabled != btEnabled) goto L12;
        return;
    L7:
        if (this.mIsBtScanningEnabled == btScanEnabled) goto L9;
    L14:
        Log.d(TAG, "BT adapter not available. Getting permissions from user settings");
        boolean btScanEnabled2 = false;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "bluetooth_on", 0) != 1) goto L17;
        boolean btEnabled2 = true;
    L19:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "ble_scan_always_enabled", 0) != 1) goto L21;
        btScanEnabled2 = true;
    L21:
        if (forceUpdate == false) goto L23;
    L24:
        this.mIsBtMainEnabled = btEnabled2;
        this.mContextHubWrapper.onBtMainSettingChanged(this.mIsBtMainEnabled);
    L25:
        if (forceUpdate == false) goto L27;
    L28:
        this.mIsBtScanningEnabled = btScanEnabled2;
        this.mContextHubWrapper.onBtScanningSettingChanged(this.mIsBtScanningEnabled);
        return;
    L27:
        if (this.mIsBtScanningEnabled != btScanEnabled2) goto L28;
        return;
    L23:
        if (this.mIsBtMainEnabled == btEnabled2) goto L25;
    L17:
        btEnabled2 = false;
        goto L19
    }

    private void sendAirplaneModeSettingUpdate() {
        boolean enabled = false;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "airplane_mode_on", 0) != 1) goto L5;
        enabled = true;
    L5:
        this.mContextHubWrapper.onAirplaneModeSettingChanged(enabled);
    }

    private void sendMicrophoneDisableSettingUpdate(boolean enabled) {
        Log.d(TAG, "Mic Disabled Setting: " + enabled);
        this.mContextHubWrapper.onMicrophoneSettingChanged(enabled ^ true);
    }

    private void sendMicrophoneDisableSettingUpdateForCurrentUser() {
        if (this.mSensorPrivacyManagerInternal == null) goto L7;
        boolean isEnabled = true;
        if (this.mSensorPrivacyManagerInternal.isSensorPrivacyEnabled(getCurrentUserId(), 1) == false) goto L7;
    L8:
        sendMicrophoneDisableSettingUpdate(isEnabled);
        return;
    L7:
        isEnabled = false;
        goto L8
    }

    private void scheduleDailyMetricSnapshot() {
        Runnable queryAllContextHub = new ContextHubService$$ExternalSyntheticLambda0(this);
        this.mDailyMetricTimer.schedule(queryAllContextHub, 1, TimeUnit.DAYS);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Error when schedule a timer", e);
    }

    private /* synthetic */ void lambda$scheduleDailyMetricSnapshot$4() {
        Iterator<Integer> r0 = this.mContextHubIdToInfoMap.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        int contextHubId = r0.next().intValue();
        this.mMetricQueryPendingContextHubIds.add(Integer.valueOf(contextHubId));
        queryNanoAppsInternal(contextHubId);
        goto L4
    }

    private String getCallingPackageName() {
        return this.mContext.getPackageManager().getNameForUid(Binder.getCallingUid());
    }

    private int getCurrentUserId() {
        long id = Binder.clearCallingIdentity();
        UserInfo currentUser = ActivityManager.getService().getCurrentUser();     // Catch: Throwable -> L6 RemoteException -> L8
        int r3 = currentUser.id;     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(id);
        return r3;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(id);
        throw th;
    L12:
        Binder.restoreCallingIdentity(id);
        return 0;
    }

    public void onUserChanged() {
        Log.d(TAG, "User changed to id: " + getCurrentUserId());
        sendLocationSettingUpdate();
        sendMicrophoneDisableSettingUpdateForCurrentUser();
    }
}
