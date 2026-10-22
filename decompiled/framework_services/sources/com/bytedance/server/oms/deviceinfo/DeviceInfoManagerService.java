package com.bytedance.server.oms.deviceinfo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.android.internal.os.BackgroundThread;
import com.bytedance.internal.oms.connector.OmsFrameworkMonitor;
import com.bytedance.internal.oms.connector.strategies.IdleTimeoutStrategy;
import com.bytedance.os.oms.connector.DisconnectStrategy;
import com.bytedance.os.oms.deviceinfo.IDeviceInfoBackend;
import com.bytedance.os.oms.deviceinfo.IDeviceInfoCallback;
import com.bytedance.os.oms.deviceinfo.IDeviceInfoManager;
import com.bytedance.server.oms.OceanMobileBackendConnector;
import com.bytedance.server.oms.OceanMobileSystemService;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class DeviceInfoManagerService extends OceanMobileSystemService<IDeviceInfoBackend> {
    private static final long BACKEND_IDLE_TIMEOUT_MS = 60000;
    private static final int MAX_APP_LISTENERS = 128;
    private static final ComponentName PROVIDER_COMPONENT = null;
    private static final String TAG = "OmsDeviceInfoService";
    private final IDeviceInfoManager.Stub mBinder;
    private String mCachedDeviceId;
    private String mCachedInstallId;
    private final Handler mCallbackHandler;
    private boolean mDeviceIdRefreshInFlight;
    private boolean mInstallIdRefreshInFlight;
    private final Object mListenerLock;
    private final ArrayMap<ListenerKey, ListenerRecord> mListeners;
    private final Object mLock;
    private final IDeviceInfoCallback mProviderCallback;
    private boolean mProviderCallbackRegistered;
    private final RemoteCallbackList<IDeviceInfoCallback> mRemoteCallbacks;

    private final class BackendConnector extends OceanMobileBackendConnector<IDeviceInfoBackend> {
        private final Context mContext;
        private final Intent mIntent;
        final /* synthetic */ DeviceInfoManagerService this$0;

        protected /* bridge */ /* synthetic */ void onInstrumentedServiceConnectionStatusChanged(IInterface r1, boolean r2) {
            onInstrumentedServiceConnectionStatusChanged((IDeviceInfoBackend) r1, r2);
        }

        BackendConnector(DeviceInfoManagerService r8, Context context) {
            this.this$0 = r8;
            super(context, new Intent().setComponent(DeviceInfoManagerService.m10531$$Nest$sfgetPROVIDER_COMPONENT()), AudioFormat.AAC_MAIN, new DeviceInfoManagerService$BackendConnector$$ExternalSyntheticLambda0(), "oms_device_info");
            this.mContext = context;
            this.mIntent = new Intent().setComponent(DeviceInfoManagerService.m10531$$Nest$sfgetPROVIDER_COMPONENT());
        }

        boolean isProviderInstalled() {
            if (this.mContext.getPackageManager().resolveService(this.mIntent, 0) == null) goto L6;
            return true;
        L6:
            return false;
        }

        protected void onInstrumentedServiceConnectionStatusChanged(IDeviceInfoBackend service, boolean isConnected) {
            DeviceInfoManagerService.m10524$$Nest$monBackendConnectionChanged(this.this$0, isConnected);
        }

        protected void onInstrumentedBinderDied() {
            DeviceInfoManagerService.m10519$$Nest$mclearCachedDeviceInfo(this.this$0, "backend_binder_died");
        }
    }

    private static final class ListenerKey {
        final String packageName;
        final int userId;

        ListenerKey(String packageName, int userId) {
            this.packageName = packageName;
            this.userId = userId;
        }

        public boolean equals(Object other) {
            if (this != other) goto L6;
            return true;
        L6:
            if ((other instanceof ListenerKey) == true) goto L8;
            return false;
        L8:
            ListenerKey key = (ListenerKey) other;
            if (this.userId != key.userId) goto L14;
            if (this.packageName.equals(key.packageName) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.packageName, Integer.valueOf(this.userId)});
        }

        public String toString() {
            return this.packageName + "@" + this.userId;
        }
    }

    private static final class ListenerRecord {
        final IDeviceInfoCallback callback;
        final ListenerKey key;
        private String mLastDeviceId;
        private String mLastInstallId;

        ListenerRecord(ListenerKey key, IDeviceInfoCallback callback) {
            this.key = key;
            this.callback = callback;
        }

        synchronized boolean shouldDispatchDeviceId(String deviceId) {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (Objects.equals(this.mLastDeviceId, deviceId) == false) goto L8;
            monitor-exit(this);
            return false;
        L8:
            this.mLastDeviceId = deviceId;     // Catch: Throwable -> L12
            monitor-exit(this);
            return true;
        }

        synchronized boolean shouldDispatchInstallId(String installId) {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (Objects.equals(this.mLastInstallId, installId) == false) goto L8;
            monitor-exit(this);
            return false;
        L8:
            this.mLastInstallId = installId;     // Catch: Throwable -> L12
            monitor-exit(this);
            return true;
        }
    }

    public static /* synthetic */ void $r8$lambda$4W3LYaVCEUlD1TahdCedfviKpeg(DeviceInfoManagerService r0, IDeviceInfoBackend r1) {
        r0.lambda$unregisterProviderCallback$6(r1);
    }

    public static /* synthetic */ void $r8$lambda$9BtkU1tfGKxHv2oD14N1zxBpdog(DeviceInfoManagerService r0, Void r1, Throwable r2) {
        r0.lambda$registerProviderCallback$5(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$DGrZ2DxS-WYA5bLEmibMRlq9OCM, reason: not valid java name */
    public static /* synthetic */ void m10506$r8$lambda$DGrZ2DxSWYA5bLEmibMRlq9OCM(DeviceInfoManagerService r0, String r1) {
        r0.lambda$dispatchInstallIdToAppListeners$9(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$V3-Ud7X4DKYc2jUrY_2tFvXWUCI, reason: not valid java name */
    public static /* synthetic */ void m10507$r8$lambda$V3Ud7X4DKYc2jUrY_2tFvXWUCI(DeviceInfoManagerService r0, Void r1, Throwable r2) {
        r0.lambda$requestInstallIdRefresh$3(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$_19C56vCE4nRY6d1bgU1MJOH1xI(DeviceInfoManagerService r0, IDeviceInfoBackend r1) {
        r0.lambda$registerProviderCallback$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$jgoXLfPmwXfWXeZfPJfjyAb2x9c(Void r0, Throwable r1) {
        lambda$unregisterProviderCallback$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$jm2ydREjwK0Oc2ccSMIDp6AlM60(DeviceInfoManagerService r0, IDeviceInfoBackend r1) {
        r0.lambda$requestDeviceIdRefresh$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$tHvlaHjxWa-zbRCR_yiaduu-94Q, reason: not valid java name */
    public static /* synthetic */ void m10508$r8$lambda$tHvlaHjxWazbRCR_yiaduu94Q(DeviceInfoManagerService r0, Void r1, Throwable r2) {
        r0.lambda$requestDeviceIdRefresh$1(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$yghwSqWfR_QeGTelrRA-sxIMaaU, reason: not valid java name */
    public static /* synthetic */ void m10509$r8$lambda$yghwSqWfR_QeGTelrRAsxIMaaU(DeviceInfoManagerService r0, String r1) {
        r0.lambda$dispatchDeviceIdToAppListeners$8(r1);
    }

    public static /* synthetic */ void $r8$lambda$z6Ofqujgu7nSiSEcqMI3rdiLGak(DeviceInfoManagerService r0, IDeviceInfoBackend r1) {
        r0.lambda$requestInstallIdRefresh$2(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCachedDeviceId, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m10510$$Nest$fgetmCachedDeviceId(DeviceInfoManagerService r0) {
        return r0.mCachedDeviceId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCachedInstallId, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m10511$$Nest$fgetmCachedInstallId(DeviceInfoManagerService r0) {
        return r0.mCachedInstallId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceIdRefreshInFlight, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10512$$Nest$fgetmDeviceIdRefreshInFlight(DeviceInfoManagerService r0) {
        return r0.mDeviceIdRefreshInFlight;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInstallIdRefreshInFlight, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10513$$Nest$fgetmInstallIdRefreshInFlight(DeviceInfoManagerService r0) {
        return r0.mInstallIdRefreshInFlight;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m10514$$Nest$fgetmLock(DeviceInfoManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDeviceIdRefreshInFlight, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10515$$Nest$fputmDeviceIdRefreshInFlight(DeviceInfoManagerService r0, boolean r1) {
        r0.mDeviceIdRefreshInFlight = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInstallIdRefreshInFlight, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10516$$Nest$fputmInstallIdRefreshInFlight(DeviceInfoManagerService r0, boolean r1) {
        r0.mInstallIdRefreshInFlight = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcacheDeviceId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10517$$Nest$mcacheDeviceId(DeviceInfoManagerService r0, String r1) {
        r0.cacheDeviceId(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcacheInstallId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10518$$Nest$mcacheInstallId(DeviceInfoManagerService r0, String r1) {
        r0.cacheInstallId(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mclearCachedDeviceInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10519$$Nest$mclearCachedDeviceInfo(DeviceInfoManagerService r0, String r1) {
        r0.clearCachedDeviceInfo(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateListenerKey, reason: not valid java name */
    static /* bridge */ /* synthetic */ ListenerKey m10520$$Nest$mcreateListenerKey(DeviceInfoManagerService r0, String r1) {
        return r0.createListenerKey(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchDeviceIdToAppListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10521$$Nest$mdispatchDeviceIdToAppListeners(DeviceInfoManagerService r0, String r1) {
        r0.dispatchDeviceIdToAppListeners(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchInstallIdToAppListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10522$$Nest$mdispatchInstallIdToAppListeners(DeviceInfoManagerService r0, String r1) {
        r0.dispatchInstallIdToAppListeners(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monAppListenerDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10523$$Nest$monAppListenerDied(DeviceInfoManagerService r0, ListenerRecord r1, IDeviceInfoCallback r2) {
        r0.onAppListenerDied(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monBackendConnectionChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10524$$Nest$monBackendConnectionChanged(DeviceInfoManagerService r0, boolean r1) {
        r0.onBackendConnectionChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterAppListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ ListenerRecord m10525$$Nest$mregisterAppListener(DeviceInfoManagerService r0, ListenerKey r1, IDeviceInfoCallback r2) {
        return r0.registerAppListener(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mreplayCachedDeviceInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10526$$Nest$mreplayCachedDeviceInfo(DeviceInfoManagerService r0, ListenerRecord r1) {
        r0.replayCachedDeviceInfo(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mrequestDeviceIdRefresh, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10527$$Nest$mrequestDeviceIdRefresh(DeviceInfoManagerService r0) {
        r0.requestDeviceIdRefresh();
    }

    /* JADX INFO: renamed from: -$$Nest$mrequestInstallIdRefresh, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10528$$Nest$mrequestInstallIdRefresh(DeviceInfoManagerService r0) {
        r0.requestInstallIdRefresh();
    }

    /* JADX INFO: renamed from: -$$Nest$mrequestMissingDeviceInfoRefresh, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10529$$Nest$mrequestMissingDeviceInfoRefresh(DeviceInfoManagerService r0) {
        r0.requestMissingDeviceInfoRefresh();
    }

    /* JADX INFO: renamed from: -$$Nest$munregisterAppListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10530$$Nest$munregisterAppListener(DeviceInfoManagerService r0, ListenerKey r1, IDeviceInfoCallback r2) {
        r0.unregisterAppListener(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPROVIDER_COMPONENT, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName m10531$$Nest$sfgetPROVIDER_COMPONENT() {
        return PROVIDER_COMPONENT;
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10532$$Nest$smisValidLocked(String r0) {
        return isValidLocked(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smlog, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10533$$Nest$smlog(int r0, String r1, Throwable r2) {
        log(r0, r1, r2);
    }

    static {
        PROVIDER_COMPONENT = new ComponentName("com.obric.matrix", "com.obric.matrix.deviceinfo.DeviceInfoBackendService");
    }

    public DeviceInfoManagerService(Context context) {
        super(context);
        this.mLock = new Object();
        this.mListenerLock = new Object();
        this.mCallbackHandler = BackgroundThread.getHandler();
        this.mListeners = new ArrayMap();
        this.mRemoteCallbacks = new AnonymousClass1(this);
        this.mProviderCallback = new AnonymousClass2(this);
        this.mBinder = new AnonymousClass3(this);
    }

    @Override // com.bytedance.server.oms.OceanMobileSystemService
    protected String getOmsServiceName() {
        return "oms_device_info";
    }

    @Override // com.bytedance.server.oms.OceanMobileSystemService
    protected OceanMobileBackendConnector<IDeviceInfoBackend> createBackendConnector(Context context) {
        return new BackendConnector(this, context);
    }

    @Override // com.bytedance.server.oms.OceanMobileSystemService
    protected IBinder createBinderService() {
        return this.mBinder;
    }

    @Override // com.bytedance.server.oms.OceanMobileSystemService
    protected Class<?> getBinderStubClass() {
        return IDeviceInfoManager.Stub.class;
    }

    @Override // com.bytedance.server.oms.OceanMobileSystemService
    protected List<DisconnectStrategy> createDisconnectStrategies() {
        return List.of(new IdleTimeoutStrategy(60000));
    }

    @Override // com.bytedance.server.oms.OceanMobileSystemService
    protected void onOmsServiceStarted() {
        log(4, "DeviceInfoManagerService published as oms_device_info", null);
    }

    @Override // com.bytedance.server.oms.OceanMobileSystemService
    protected boolean shouldKeepBackendConnected() {
        Object r0 = this.mListenerLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mListeners.isEmpty() == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    private static void sendDeviceInfoIfValid(ListenerRecord record, String deviceId, String installId) {
        if (isValid(deviceId) == false) goto L10;
        if (record.shouldDispatchDeviceId(deviceId) == false) goto L10;
        record.callback.onDeviceId(deviceId);     // Catch: RemoteException -> L7
    L10:
        if (isValid(installId) == true) goto L12;
        return;
    L12:
        if (record.shouldDispatchInstallId(installId) == false) goto L20;
        record.callback.onInstallId(installId);     // Catch: RemoteException -> L7
        return;
    L20:
        return;
    }

    private void requestDeviceIdRefresh() {
        getBackendConnector().post(new DeviceInfoManagerService$$ExternalSyntheticLambda3(this)).whenComplete(new DeviceInfoManagerService$$ExternalSyntheticLambda4(this));
    }

    private /* synthetic */ void lambda$requestDeviceIdRefresh$0(IDeviceInfoBackend backend) throws Exception {
        String deviceId = backend.getDeviceId();
        cacheDeviceId(deviceId);
        dispatchDeviceIdToAppListeners(deviceId);
    }

    private /* synthetic */ void lambda$requestDeviceIdRefresh$1(Void result, Throwable error) {
        if (error == null) goto L5;
        clearDeviceIdRefreshInFlight();
        log(5, "requestDeviceIdRefresh failed", error);
        return;
    }

    private void requestInstallIdRefresh() {
        getBackendConnector().post(new DeviceInfoManagerService$$ExternalSyntheticLambda7(this)).whenComplete(new DeviceInfoManagerService$$ExternalSyntheticLambda8(this));
    }

    private /* synthetic */ void lambda$requestInstallIdRefresh$2(IDeviceInfoBackend backend) throws Exception {
        String installId = backend.getInstallId();
        cacheInstallId(installId);
        dispatchInstallIdToAppListeners(installId);
    }

    private /* synthetic */ void lambda$requestInstallIdRefresh$3(Void result, Throwable error) {
        if (error == null) goto L5;
        clearInstallIdRefreshInFlight();
        log(5, "requestInstallIdRefresh failed", error);
        return;
    }

    private void cacheDeviceId(String deviceId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (isValid(deviceId) == false) goto L9;
        this.mCachedDeviceId = deviceId;     // Catch: Throwable -> L7
    L9:
        this.mDeviceIdRefreshInFlight = false;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void cacheInstallId(String installId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (isValid(installId) == false) goto L9;
        this.mCachedInstallId = installId;     // Catch: Throwable -> L7
    L9:
        this.mInstallIdRefreshInFlight = false;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void clearDeviceIdRefreshInFlight() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDeviceIdRefreshInFlight = false;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void clearInstallIdRefreshInFlight() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mInstallIdRefreshInFlight = false;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void clearCachedDeviceInfo(String reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCachedDeviceId = null;     // Catch: Throwable -> L9
        this.mCachedInstallId = null;     // Catch: Throwable -> L9
        this.mDeviceIdRefreshInFlight = false;     // Catch: Throwable -> L9
        this.mInstallIdRefreshInFlight = false;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        log(4, "clear cached device info, reason=" + reason, null);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private static boolean isValid(String value) {
        if (value != null) goto L4;
    L10:
        return false;
    L4:
        if (value.isEmpty() == true) goto L10;
        if ("0".equals(value) == true) goto L10;
        if ("-1".equals(value) == true) goto L10;
        return true;
    }

    private static boolean isValidLocked(String value) {
        return isValid(value);
    }

    private ListenerKey createListenerKey(String packageName) {
        int callingUid = Binder.getCallingUid();
        int userId = UserHandle.getUserId(callingUid);
        if (TextUtils.isEmpty(packageName) == true) goto L18;
        String[] packages = getContext().getPackageManager().getPackagesForUid(callingUid);
        if (packages == null) goto L16;
        int r3 = packages.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L14;
        String candidate = packages[r4];
        if (packageName.equals(candidate) == true) goto L11;
        r4 = r4 + 1;
        goto L7
    L11:
        return new ListenerKey(packageName, userId);
    L14:
        throw new SecurityException(packageName + " does not belong to uid " + callingUid);
    L16:
        throw new SecurityException("No packages for uid " + callingUid);
    L18:
        throw new IllegalArgumentException("packageName is empty");
    }

    private ListenerRecord registerAppListener(ListenerKey key, IDeviceInfoCallback callback) {
        Object r1 = this.mListenerLock;
        monitor-enter(r1);
        ListenerRecord oldRecord = this.mListeners.get(key);     // Catch: Throwable -> L11
        if (oldRecord == null) goto L7;
    L13:
        if (oldRecord == null) goto L15;
        this.mRemoteCallbacks.unregister(oldRecord.callback);     // Catch: Throwable -> L11
    L15:
        ListenerRecord record = new ListenerRecord(key, callback);     // Catch: Throwable -> L11
        if (this.mRemoteCallbacks.register(callback, record) == true) goto L22;
        log(5, "registerDeviceInfoListener failed for " + key, null);     // Catch: Throwable -> L11
        if (oldRecord == null) goto L20;
        this.mRemoteCallbacks.register(oldRecord.callback, oldRecord);     // Catch: Throwable -> L11
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return null;
    L22:
        this.mListeners.put(key, record);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        ensureProviderCallbackRegistered();
        return record;
    L7:
        if (this.mListeners.size() < 128) goto L13;
        log(5, "registerDeviceInfoListener rejected, too many listeners: " + this.mListeners.size(), null);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    private void replayCachedDeviceInfo(ListenerRecord record) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String cachedDeviceId = this.mCachedDeviceId;     // Catch: Throwable -> L8
        String cachedInstallId = this.mCachedInstallId;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        sendDeviceInfoIfValid(record, cachedDeviceId, cachedInstallId);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void requestMissingDeviceInfoRefresh() {
        boolean shouldRefreshDeviceId = false;
        boolean shouldRefreshInstallId = false;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isValidLocked(this.mCachedDeviceId) == true) goto L12;
        if (this.mDeviceIdRefreshInFlight == true) goto L12;
        this.mDeviceIdRefreshInFlight = true;     // Catch: Throwable -> L9
        shouldRefreshDeviceId = true;
    L12:
        if (isValidLocked(this.mCachedInstallId) == false) goto L14;
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L9
        if (shouldRefreshDeviceId == false) goto L19;
        requestDeviceIdRefresh();
    L19:
        if (shouldRefreshInstallId == false) goto L26;
        requestInstallIdRefresh();
        return;
    L26:
        return;
    L14:
        if (this.mInstallIdRefreshInFlight == true) goto L16;
        this.mInstallIdRefreshInFlight = true;     // Catch: Throwable -> L9
        shouldRefreshInstallId = true;
        goto L16
    }

    private void unregisterAppListener(ListenerKey key, IDeviceInfoCallback callback) {
        boolean shouldUnregisterProviderCallback = false;
        Object r1 = this.mListenerLock;
        monitor-enter(r1);
        ListenerRecord record = this.mListeners.get(key);     // Catch: Throwable -> L14
        if (record == null) goto L20;
        if (record.callback.asBinder() != callback.asBinder()) goto L20;
        this.mListeners.remove(key);     // Catch: Throwable -> L14
        this.mRemoteCallbacks.unregister(record.callback);     // Catch: Throwable -> L14
        if (this.mListeners.isEmpty() == true) goto L12;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L14
        if (shouldUnregisterProviderCallback == false) goto L25;
        unregisterProviderCallback();
        return;
    L25:
        return;
    L12:
        if (this.mProviderCallbackRegistered == false) goto L16;
        this.mProviderCallbackRegistered = false;     // Catch: Throwable -> L14
        shouldUnregisterProviderCallback = true;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void onAppListenerDied(ListenerRecord deadRecord, IDeviceInfoCallback callback) {
        boolean shouldUnregisterProviderCallback = false;
        Object r1 = this.mListenerLock;
        monitor-enter(r1);
        ListenerRecord record = this.mListeners.get(deadRecord.key);     // Catch: Throwable -> L14
        if (record == null) goto L20;
        if (record.callback.asBinder() != callback.asBinder()) goto L20;
        this.mListeners.remove(deadRecord.key);     // Catch: Throwable -> L14
        if (this.mListeners.isEmpty() == true) goto L12;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L14
        if (shouldUnregisterProviderCallback == false) goto L25;
        unregisterProviderCallback();
        return;
    L25:
        return;
    L12:
        if (this.mProviderCallbackRegistered == false) goto L16;
        this.mProviderCallbackRegistered = false;     // Catch: Throwable -> L14
        shouldUnregisterProviderCallback = true;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void onBackendConnectionChanged(boolean isConnected) {
        if (isConnected == false) goto L5;
        ensureProviderCallbackRegistered();
        return;
    L5:
        boolean shouldReconnect = false;
        Object r1 = this.mListenerLock;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mListeners.isEmpty() == true) goto L12;
        this.mProviderCallbackRegistered = false;     // Catch: Throwable -> L10
        shouldReconnect = true;
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (shouldReconnect == false) goto L20;
        ensureProviderCallbackRegistered();
        return;
    }

    private void ensureProviderCallbackRegistered() {
        boolean shouldRegisterProviderCallback = false;
        Object r1 = this.mListenerLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mListeners.isEmpty() == false) goto L7;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        if (shouldRegisterProviderCallback == false) goto L19;
        registerProviderCallback();
        return;
    L19:
        return;
    L7:
        if (this.mProviderCallbackRegistered == true) goto L11;
        this.mProviderCallbackRegistered = true;     // Catch: Throwable -> L9
        shouldRegisterProviderCallback = true;
        goto L11
    }

    private /* synthetic */ void lambda$registerProviderCallback$4(IDeviceInfoBackend backend) throws Exception {
        backend.registerDeviceInfoListener(this.mProviderCallback);
    }

    private void registerProviderCallback() {
        getBackendConnector().post(new DeviceInfoManagerService$$ExternalSyntheticLambda5(this)).whenComplete(new DeviceInfoManagerService$$ExternalSyntheticLambda6(this));
    }

    private /* synthetic */ void lambda$registerProviderCallback$5(Void result, Throwable error) {
        if (error == null) goto L14;
        Object r0 = this.mListenerLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (this.mListeners.isEmpty() == true) goto L10;
        this.mProviderCallbackRegistered = false;     // Catch: Throwable -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        log(5, "register provider listener failed", error);
        return;
    }

    private /* synthetic */ void lambda$unregisterProviderCallback$6(IDeviceInfoBackend backend) throws Exception {
        backend.unregisterDeviceInfoListener(this.mProviderCallback);
    }

    private void unregisterProviderCallback() {
        getBackendConnector().post(new DeviceInfoManagerService$$ExternalSyntheticLambda1(this)).whenComplete(new DeviceInfoManagerService$$ExternalSyntheticLambda2());
    }

    private static /* synthetic */ void lambda$unregisterProviderCallback$7(Void result, Throwable error) {
        if (error == null) goto L5;
        log(5, "unregister provider listener failed", error);
        return;
    }

    private static void log(int priority, String message, Throwable throwable) {
        OmsFrameworkMonitor.log("oms_device_info", priority, TAG, message, throwable);
    }

    private void dispatchDeviceIdToAppListeners(final String deviceId) {
        if (isValid(deviceId) == true) goto L5;
        return;
    L5:
        this.mCallbackHandler.post(new DeviceInfoManagerService$$ExternalSyntheticLambda0(this, deviceId));
    }

    private /* synthetic */ void lambda$dispatchDeviceIdToAppListeners$8(String deviceId) {
        int count = this.mRemoteCallbacks.beginBroadcast();
        int i = 0;
    L3:
        if (i >= count) goto L14;
        ListenerRecord record = (ListenerRecord) this.mRemoteCallbacks.getBroadcastCookie(i);     // Catch: Throwable -> L8
        if (record.shouldDispatchDeviceId(deviceId) == false) goto L11;
        this.mRemoteCallbacks.getBroadcastItem(i).onDeviceId(deviceId);     // Catch: Throwable -> L8 RemoteException -> L10
    L11:
        i = i + 1;
    L8:
        th = move-exception;
        this.mRemoteCallbacks.finishBroadcast();
        throw th;
    L14:
        this.mRemoteCallbacks.finishBroadcast();
    }

    private void dispatchInstallIdToAppListeners(final String installId) {
        if (isValid(installId) == true) goto L5;
        return;
    L5:
        this.mCallbackHandler.post(new DeviceInfoManagerService$$ExternalSyntheticLambda9(this, installId));
    }

    private /* synthetic */ void lambda$dispatchInstallIdToAppListeners$9(String installId) {
        int count = this.mRemoteCallbacks.beginBroadcast();
        int i = 0;
    L3:
        if (i >= count) goto L14;
        ListenerRecord record = (ListenerRecord) this.mRemoteCallbacks.getBroadcastCookie(i);     // Catch: Throwable -> L8
        if (record.shouldDispatchInstallId(installId) == false) goto L11;
        this.mRemoteCallbacks.getBroadcastItem(i).onInstallId(installId);     // Catch: Throwable -> L8 RemoteException -> L10
    L11:
        i = i + 1;
    L8:
        th = move-exception;
        this.mRemoteCallbacks.finishBroadcast();
        throw th;
    L14:
        this.mRemoteCallbacks.finishBroadcast();
    }
}
