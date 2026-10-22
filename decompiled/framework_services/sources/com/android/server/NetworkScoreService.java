package com.android.server;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.database.ContentObserver;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.INetworkRecommendationProvider;
import android.net.INetworkScoreCache;
import android.net.INetworkScoreService;
import android.net.NetworkKey;
import android.net.NetworkScorerAppData;
import android.net.ScoredNetwork;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiScanner;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import com.android.internal.content.PackageMonitor;
import com.android.internal.util.DumpUtils;
import com.android.server.pm.permission.LegacyPermissionManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/* JADX INFO: loaded from: classes.dex */
public class NetworkScoreService extends INetworkScoreService.Stub {
    private static final boolean DBG = false;
    private static final String TAG = "NetworkScoreService";
    private static final boolean VERBOSE = false;
    private final Context mContext;
    private final Handler mHandler;
    private BroadcastReceiver mLocationModeReceiver;
    private final NetworkScorerAppManager mNetworkScorerAppManager;
    private NetworkScorerPackageMonitor mPackageMonitor;
    private final Object mPackageMonitorLock;
    private final DispatchingContentObserver mRecommendationSettingsObserver;
    private final Map<Integer, RemoteCallbackList<INetworkScoreCache>> mScoreCaches;
    private final Function<NetworkScorerAppData, ScoringServiceConnection> mServiceConnProducer;
    private ScoringServiceConnection mServiceConnection;
    private final Object mServiceConnectionLock;
    private final ContentObserver mUseOpenWifiPackageObserver;
    private BroadcastReceiver mUserIntentReceiver;

    static class CurrentNetworkScoreCacheFilter implements UnaryOperator<List<ScoredNetwork>> {
        private final NetworkKey mCurrentNetwork;

        @Override // java.util.function.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply((List) r1);
        }

        CurrentNetworkScoreCacheFilter(Supplier<WifiInfo> wifiInfoSupplier) {
            this.mCurrentNetwork = NetworkKey.createFromWifiInfo(wifiInfoSupplier.get());
        }

        public List<ScoredNetwork> apply(List<ScoredNetwork> scoredNetworks) {
            if (this.mCurrentNetwork == null) goto L18;
            if (scoredNetworks.isEmpty() == true) goto L18;
            int i = 0;
        L9:
            if (i >= scoredNetworks.size()) goto L16;
            ScoredNetwork scoredNetwork = scoredNetworks.get(i);
            if (scoredNetwork.networkKey.equals(this.mCurrentNetwork) == true) goto L13;
            i = i + 1;
            goto L9
        L13:
            return Collections.singletonList(scoredNetwork);
        L16:
            return Collections.emptyList();
        L18:
            return Collections.emptyList();
        }
    }

    public static class DispatchingContentObserver extends ContentObserver {
        private final Context mContext;
        private final Handler mHandler;
        private final Map<Uri, Integer> mUriEventMap;

        public DispatchingContentObserver(Context context, Handler handler) {
            super(handler);
            this.mContext = context;
            this.mHandler = handler;
            this.mUriEventMap = new ArrayMap();
        }

        void observe(Uri uri, int what) {
            this.mUriEventMap.put(uri, Integer.valueOf(what));
            ContentResolver resolver = this.mContext.getContentResolver();
            resolver.registerContentObserver(uri, false, this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            onChange(selfChange, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            if (NetworkScoreService.m289$$Nest$sfgetDBG() == false) goto L5;
            Log.d(NetworkScoreService.TAG, String.format("onChange(%s, %s)", new Object[]{Boolean.valueOf(selfChange), uri}));
        L5:
            Integer what = this.mUriEventMap.get(uri);
            if (what == null) goto L8;
            this.mHandler.obtainMessage(what.intValue()).sendToTarget();
            return;
        L8:
            Log.w(NetworkScoreService.TAG, "No matching event to send for URI = " + uri);
        }
    }

    static class FilteringCacheUpdatingConsumer implements BiConsumer<INetworkScoreCache, Object> {
        private final Context mContext;
        private UnaryOperator<List<ScoredNetwork>> mCurrentNetworkFilter;
        private final int mNetworkType;
        private UnaryOperator<List<ScoredNetwork>> mScanResultsFilter;
        private final List<ScoredNetwork> mScoredNetworkList;

        @Override // java.util.function.BiConsumer
        public /* bridge */ /* synthetic */ void accept(INetworkScoreCache r1, Object r2) {
            accept2(r1, r2);
        }

        static FilteringCacheUpdatingConsumer create(Context context, List<ScoredNetwork> scoredNetworkList, int networkType) {
            return new FilteringCacheUpdatingConsumer(context, scoredNetworkList, networkType, null, null);
        }

        FilteringCacheUpdatingConsumer(Context context, List<ScoredNetwork> scoredNetworkList, int networkType, UnaryOperator<List<ScoredNetwork>> currentNetworkFilter, UnaryOperator<List<ScoredNetwork>> scanResultsFilter) {
            this.mContext = context;
            this.mScoredNetworkList = scoredNetworkList;
            this.mNetworkType = networkType;
            this.mCurrentNetworkFilter = currentNetworkFilter;
            this.mScanResultsFilter = scanResultsFilter;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(INetworkScoreCache networkScoreCache, Object cookie) {
            int filterType = 0;
            if ((cookie instanceof Integer) == false) goto L16;
            filterType = ((Integer) cookie).intValue();
        L16:
            List<ScoredNetwork> filteredNetworkList = filterScores(this.mScoredNetworkList, filterType);     // Catch: RemoteException -> L9
            if (filteredNetworkList.isEmpty() == true) goto L19;
            networkScoreCache.updateScores(filteredNetworkList);     // Catch: RemoteException -> L9
            return;
        L19:
            return;
        L9:
            e = move-exception;
            if (NetworkScoreService.m290$$Nest$sfgetVERBOSE() == false) goto L18;
            Log.v(NetworkScoreService.TAG, "Unable to update scores of type " + this.mNetworkType, e);
            return;
        }

        private List<ScoredNetwork> filterScores(List<ScoredNetwork> scoredNetworkList, int filterType) {
            switch(filterType) {
                case 0: goto L15;
                case 1: goto L11;
                case 2: goto L6;
                default: goto L3;
            };
        L3:
            Log.w(NetworkScoreService.TAG, "Unknown filter type: " + filterType);
            return scoredNetworkList;
        L15:
            return scoredNetworkList;
        L6:
            if (this.mScanResultsFilter != null) goto L9;
            this.mScanResultsFilter = new ScanResultsScoreCacheFilter(new ScanResultsSupplier(this.mContext));
        L9:
            return (List) this.mScanResultsFilter.apply(scoredNetworkList);
        L11:
            if (this.mCurrentNetworkFilter != null) goto L14;
            this.mCurrentNetworkFilter = new CurrentNetworkScoreCacheFilter(new WifiInfoSupplier(this.mContext));
        L14:
            return (List) this.mCurrentNetworkFilter.apply(scoredNetworkList);
        }
    }

    public static final class Lifecycle extends SystemService {
        private final NetworkScoreService mService;

        public Lifecycle(Context context) {
            super(context);
            this.mService = new NetworkScoreService(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            Log.i(NetworkScoreService.TAG, "Registering network_score");
            publishBinderService("network_score", this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 500) goto L6;
            this.mService.systemReady();
            return;
        L6:
            if (phase != 1000) goto L10;
            this.mService.systemRunning();
            return;
        }
    }

    private class NetworkScorerPackageMonitor extends PackageMonitor {
        final String mPackageToWatch;
        final /* synthetic */ NetworkScoreService this$0;

        /* synthetic */ NetworkScorerPackageMonitor(NetworkScoreService r1, String r2, NetworkScoreServiceIA r3) {
            this(r1, r2);
        }

        private NetworkScorerPackageMonitor(NetworkScoreService r1, String packageToWatch) {
            this.this$0 = r1;
            this.mPackageToWatch = packageToWatch;
        }

        public void onPackageAdded(String packageName, int uid) {
            evaluateBinding(packageName, true);
        }

        public void onPackageRemoved(String packageName, int uid) {
            evaluateBinding(packageName, true);
        }

        public void onPackageModified(String packageName) {
            evaluateBinding(packageName, false);
        }

        public boolean onHandleForceStop(Intent intent, String[] packages, int uid, boolean doit) {
            if (doit == false) goto L8;
            int r0 = packages.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L8;
            String packageName = packages[r1];
            evaluateBinding(packageName, true);
            r1 = r1 + 1;
        L8:
            return super.onHandleForceStop(intent, packages, uid, doit);
        }

        public void onPackageUpdateFinished(String packageName, int uid) {
            evaluateBinding(packageName, true);
        }

        private void evaluateBinding(String changedPackageName, boolean forceUnbind) {
            if (this.mPackageToWatch.equals(changedPackageName) == true) goto L6;
            return;
        L6:
            if (NetworkScoreService.m289$$Nest$sfgetDBG() == false) goto L8;
            Log.d(NetworkScoreService.TAG, "Evaluating binding for: " + changedPackageName + ", forceUnbind=" + forceUnbind);
        L8:
            NetworkScorerAppData activeScorer = NetworkScoreService.m285$$Nest$fgetmNetworkScorerAppManager(this.this$0).getActiveScorer();
            if (activeScorer == null) goto L11;
            if (forceUnbind == false) goto L17;
            NetworkScoreService.m288$$Nest$munbindFromScoringServiceIfNeeded(this.this$0);
        L17:
            if (NetworkScoreService.m289$$Nest$sfgetDBG() == false) goto L19;
            Log.d(NetworkScoreService.TAG, "Binding to " + activeScorer.getRecommendationServiceComponent() + " if needed.");
        L19:
            NetworkScoreService.m286$$Nest$mbindToScoringServiceIfNeeded(this.this$0, activeScorer);
            return;
        L11:
            if (NetworkScoreService.m289$$Nest$sfgetDBG() == false) goto L13;
            Log.d(NetworkScoreService.TAG, "No active scorers available.");
        L13:
            NetworkScoreService.m287$$Nest$mrefreshBinding(this.this$0);
        }
    }

    static class ScanResultsScoreCacheFilter implements UnaryOperator<List<ScoredNetwork>> {
        private final Set<NetworkKey> mScanResultKeys;

        @Override // java.util.function.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply((List) r1);
        }

        ScanResultsScoreCacheFilter(Supplier<List<ScanResult>> resultsSupplier) {
            List<ScanResult> scanResults = resultsSupplier.get();
            int size = scanResults.size();
            this.mScanResultKeys = new ArraySet(size);
            int i = 0;
        L3:
            if (i >= size) goto L9;
            ScanResult scanResult = scanResults.get(i);
            NetworkKey key = NetworkKey.createFromScanResult(scanResult);
            if (key == null) goto L7;
            this.mScanResultKeys.add(key);
        L7:
            i = i + 1;
            goto L3
        }

        public List<ScoredNetwork> apply(List<ScoredNetwork> scoredNetworks) {
            if (this.mScanResultKeys.isEmpty() == true) goto L17;
            if (scoredNetworks.isEmpty() == true) goto L17;
            List<ScoredNetwork> filteredScores = new ArrayList();
            int i = 0;
        L9:
            if (i >= scoredNetworks.size()) goto L15;
            ScoredNetwork scoredNetwork = scoredNetworks.get(i);
            if (this.mScanResultKeys.contains(scoredNetwork.networkKey) == false) goto L13;
            filteredScores.add(scoredNetwork);
        L13:
            i = i + 1;
            goto L9
        L15:
            return filteredScores;
        L17:
            return Collections.emptyList();
        }
    }

    private static class ScanResultsSupplier implements Supplier<List<ScanResult>> {
        private final Context mContext;

        @Override // java.util.function.Supplier
        public /* bridge */ /* synthetic */ List<ScanResult> get() {
            return get2();
        }

        ScanResultsSupplier(Context context) {
            this.mContext = context;
        }

        @Override // java.util.function.Supplier
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public List<ScanResult> get2() {
            WifiScanner wifiScanner = (WifiScanner) this.mContext.getSystemService(WifiScanner.class);
            if (wifiScanner != null) goto L5;
            Log.w(NetworkScoreService.TAG, "WifiScanner is null, failed to return scan results.");
            return Collections.emptyList();
        L5:
            return wifiScanner.getSingleScanResults();
        }
    }

    public static class ScoringServiceConnection implements ServiceConnection {
        private final NetworkScorerAppData mAppData;
        private volatile boolean mBound;
        private volatile boolean mConnected;
        private volatile INetworkRecommendationProvider mRecommendationProvider;

        ScoringServiceConnection(NetworkScorerAppData appData) {
            this.mBound = false;
            this.mConnected = false;
            this.mAppData = appData;
        }

        public void bind(Context context) {
            if (this.mBound == true) goto L11;
            Intent service = new Intent("android.net.action.RECOMMEND_NETWORKS");
            service.setComponent(this.mAppData.getRecommendationServiceComponent());
            this.mBound = context.bindServiceAsUser(service, this, AudioFormat.AAC_MAIN, UserHandle.SYSTEM);
            if (this.mBound == true) goto L8;
            Log.w(NetworkScoreService.TAG, "Bind call failed for " + service);
            context.unbindService(this);
            return;
        L8:
            if (NetworkScoreService.m289$$Nest$sfgetDBG() == false) goto L13;
            Log.d(NetworkScoreService.TAG, "ScoringServiceConnection bound.");
            return;
        L13:
            return;
        }

        public void unbind(Context context) {
        L9:
            e = move-exception;
            Log.e(NetworkScoreService.TAG, "Unbind failed.", e);
        L13:
            this.mConnected = false;
            this.mRecommendationProvider = null;
            return;
        L4:
            if (this.mBound == false) goto L13;
            this.mBound = false;     // Catch: RuntimeException -> L9
            context.unbindService(this);     // Catch: RuntimeException -> L9
            if (NetworkScoreService.m289$$Nest$sfgetDBG() == false) goto L13;
            Log.d(NetworkScoreService.TAG, "ScoringServiceConnection unbound.");     // Catch: RuntimeException -> L9
            goto L13
        }

        public NetworkScorerAppData getAppData() {
            return this.mAppData;
        }

        public INetworkRecommendationProvider getRecommendationProvider() {
            return this.mRecommendationProvider;
        }

        public String getPackageName() {
            return this.mAppData.getRecommendationServiceComponent().getPackageName();
        }

        public boolean isAlive() {
            if (this.mBound == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mConnected == false) goto L7;
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            if (NetworkScoreService.m289$$Nest$sfgetDBG() == false) goto L5;
            Log.d(NetworkScoreService.TAG, "ScoringServiceConnection: " + name.flattenToString());
        L5:
            this.mConnected = true;
            this.mRecommendationProvider = INetworkRecommendationProvider.Stub.asInterface(service);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            if (NetworkScoreService.m289$$Nest$sfgetDBG() == false) goto L5;
            Log.d(NetworkScoreService.TAG, "ScoringServiceConnection, disconnected: " + name.flattenToString());
        L5:
            this.mConnected = false;
            this.mRecommendationProvider = null;
        }

        public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
            writer.println("ScoringServiceConnection: " + this.mAppData.getRecommendationServiceComponent() + ", bound: " + this.mBound + ", connected: " + this.mConnected);
        }
    }

    public final class ServiceHandler extends Handler {
        public static final int MSG_RECOMMENDATIONS_PACKAGE_CHANGED = 1;
        public static final int MSG_RECOMMENDATION_ENABLED_SETTING_CHANGED = 2;
        final /* synthetic */ NetworkScoreService this$0;

        public ServiceHandler(NetworkScoreService this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int what = msg.what;
            switch(what) {
                case 1: goto L5;
                case 2: goto L5;
                default: goto L4;
            };
        L4:
            Log.w(NetworkScoreService.TAG, "Unknown message: " + what);
            return;
        L5:
            NetworkScoreService.m287$$Nest$mrefreshBinding(this.this$0);
        }
    }

    private static class WifiInfoSupplier implements Supplier<WifiInfo> {
        private final Context mContext;

        @Override // java.util.function.Supplier
        public /* bridge */ /* synthetic */ WifiInfo get() {
            return get();
        }

        WifiInfoSupplier(Context context) {
            this.mContext = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.function.Supplier
        public WifiInfo get() {
            WifiManager wifiManager = (WifiManager) this.mContext.getSystemService(WifiManager.class);
            if (wifiManager != null) goto L5;
            Log.w(NetworkScoreService.TAG, "WifiManager is null, failed to return the WifiInfo.");
            return null;
        L5:
            return wifiManager.getConnectionInfo();
        }
    }

    public static /* synthetic */ String[] $r8$lambda$Y0o2HBV9B2B3w4dg71qG1th9Qc8(NetworkScoreService r0, int r1) {
        return r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m284$$Nest$fgetmContext(NetworkScoreService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNetworkScorerAppManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ NetworkScorerAppManager m285$$Nest$fgetmNetworkScorerAppManager(NetworkScoreService r0) {
        return r0.mNetworkScorerAppManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mbindToScoringServiceIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m286$$Nest$mbindToScoringServiceIfNeeded(NetworkScoreService r0, NetworkScorerAppData r1) {
        r0.bindToScoringServiceIfNeeded(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mrefreshBinding, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m287$$Nest$mrefreshBinding(NetworkScoreService r0) {
        r0.refreshBinding();
    }

    /* JADX INFO: renamed from: -$$Nest$munbindFromScoringServiceIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m288$$Nest$munbindFromScoringServiceIfNeeded(NetworkScoreService r0) {
        r0.unbindFromScoringServiceIfNeeded();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDBG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m289$$Nest$sfgetDBG() {
        return DBG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetVERBOSE, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m290$$Nest$sfgetVERBOSE() {
        return VERBOSE;
    }

    static {
        boolean r1 = false;
        if (Build.IS_DEBUGGABLE == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        DBG = r0;
        if (Build.IS_DEBUGGABLE == true) goto L11;
    L13:
        VERBOSE = r1;
        return;
    L11:
        if (Log.isLoggable(TAG, 2) == false) goto L13;
        r1 = true;
        goto L13
    L5:
        if (Log.isLoggable(TAG, 3) == false) goto L7;
        r0 = true;
        goto L8
    }

    public NetworkScoreService(Context context) {
        this(context, new NetworkScorerAppManager(context), new NetworkScoreService$$ExternalSyntheticLambda1(), Looper.myLooper());
    }

    NetworkScoreService(Context context, NetworkScorerAppManager networkScoreAppManager, Function<NetworkScorerAppData, ScoringServiceConnection> serviceConnProducer, Looper looper) {
        this.mPackageMonitorLock = new Object();
        this.mServiceConnectionLock = new Object();
        this.mUserIntentReceiver = new AnonymousClass1(this);
        this.mLocationModeReceiver = new AnonymousClass2(this);
        this.mContext = context;
        this.mNetworkScorerAppManager = networkScoreAppManager;
        this.mScoreCaches = new ArrayMap();
        IntentFilter filter = new IntentFilter("android.intent.action.USER_UNLOCKED");
        this.mContext.registerReceiverAsUser(this.mUserIntentReceiver, UserHandle.SYSTEM, filter, null, null);
        this.mHandler = new ServiceHandler(this, looper);
        IntentFilter locationModeFilter = new IntentFilter("android.location.MODE_CHANGED");
        this.mContext.registerReceiverAsUser(this.mLocationModeReceiver, UserHandle.SYSTEM, locationModeFilter, null, this.mHandler);
        this.mRecommendationSettingsObserver = new DispatchingContentObserver(context, this.mHandler);
        this.mServiceConnProducer = serviceConnProducer;
        final Handler r4 = this.mHandler;
        this.mUseOpenWifiPackageObserver = new AnonymousClass3(this, r4);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("use_open_wifi_package"), false, this.mUseOpenWifiPackageObserver);
        ((LegacyPermissionManagerInternal) LocalServices.getService(LegacyPermissionManagerInternal.class)).setUseOpenWifiAppPackagesProvider(new NetworkScoreService$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ String[] lambda$new$0(int userId) {
        String useOpenWifiPackage = Settings.Global.getString(this.mContext.getContentResolver(), "use_open_wifi_package");
        if (TextUtils.isEmpty(useOpenWifiPackage) == false) goto L5;
        return null;
    L5:
        return new String[]{useOpenWifiPackage};
    }

    void systemReady() {
        if (DBG == false) goto L5;
        Log.d(TAG, "systemReady");
    L5:
        registerRecommendationSettingsObserver();
    }

    void systemRunning() {
        if (DBG == false) goto L6;
        Log.d(TAG, "systemRunning");
        return;
    }

    void onUserUnlocked(int userId) {
        if (DBG == false) goto L5;
        Log.d(TAG, "onUserUnlocked(" + userId + ")");
    L5:
        refreshBinding();
    }

    private void refreshBinding() {
        if (DBG == false) goto L5;
        Log.d(TAG, "refreshBinding()");
    L5:
        this.mNetworkScorerAppManager.updateState();
        this.mNetworkScorerAppManager.migrateNetworkScorerAppSettingIfNeeded();
        registerPackageMonitorIfNeeded();
        bindToScoringServiceIfNeeded();
    }

    private void registerRecommendationSettingsObserver() {
        Uri packageNameUri = Settings.Global.getUriFor("network_recommendations_package");
        this.mRecommendationSettingsObserver.observe(packageNameUri, 1);
        Uri settingUri = Settings.Global.getUriFor("network_recommendations_enabled");
        this.mRecommendationSettingsObserver.observe(settingUri, 2);
    }

    private void registerPackageMonitorIfNeeded() {
        if (DBG == false) goto L5;
        Log.d(TAG, "registerPackageMonitorIfNeeded()");
    L5:
        NetworkScorerAppData appData = this.mNetworkScorerAppManager.getActiveScorer();
        Object r1 = this.mPackageMonitorLock;
        monitor-enter(r1);
        NetworkScoreServiceIA r3 = null;
        if (this.mPackageMonitor == null) goto L19;
        if (appData == null) goto L16;
        if (appData.getRecommendationServicePackageName().equals(this.mPackageMonitor.mPackageToWatch) == true) goto L19;
    L16:
        if (DBG == false) goto L18;
        Log.d(TAG, "Unregistering package monitor for " + this.mPackageMonitor.mPackageToWatch);     // Catch: Throwable -> L13
    L18:
        this.mPackageMonitor.unregister();     // Catch: Throwable -> L13
        this.mPackageMonitor = null;     // Catch: Throwable -> L13
    L19:
        if (appData != null) goto L21;
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L21:
        if (this.mPackageMonitor != null) goto L25;
        this.mPackageMonitor = new NetworkScorerPackageMonitor(this, appData.getRecommendationServicePackageName(), r3);     // Catch: Throwable -> L13
        this.mPackageMonitor.register(this.mContext, null, UserHandle.SYSTEM, false);     // Catch: Throwable -> L13
        if (DBG == false) goto L25;
        Log.d(TAG, "Registered package monitor for " + this.mPackageMonitor.mPackageToWatch);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void bindToScoringServiceIfNeeded() {
        if (DBG == false) goto L5;
        Log.d(TAG, "bindToScoringServiceIfNeeded");
    L5:
        NetworkScorerAppData scorerData = this.mNetworkScorerAppManager.getActiveScorer();
        bindToScoringServiceIfNeeded(scorerData);
    }

    private void bindToScoringServiceIfNeeded(NetworkScorerAppData appData) {
        if (DBG == false) goto L5;
        Log.d(TAG, "bindToScoringServiceIfNeeded(" + appData + ")");
    L5:
        if (appData == null) goto L23;
        Object r0 = this.mServiceConnectionLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mServiceConnection == null) goto L16;
        if (this.mServiceConnection.getAppData().equals(appData) == true) goto L16;
        unbindFromScoringServiceIfNeeded();     // Catch: Throwable -> L13
    L16:
        if (this.mServiceConnection != null) goto L18;
        this.mServiceConnection = this.mServiceConnProducer.apply(appData);     // Catch: Throwable -> L13
    L18:
        this.mServiceConnection.bind(this.mContext);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L23:
        unbindFromScoringServiceIfNeeded();
    }

    private void unbindFromScoringServiceIfNeeded() {
        if (DBG == false) goto L5;
        Log.d(TAG, "unbindFromScoringServiceIfNeeded");
    L5:
        Object r0 = this.mServiceConnectionLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mServiceConnection == null) goto L14;
        this.mServiceConnection.unbind(this.mContext);     // Catch: Throwable -> L12
        if (DBG == false) goto L14;
        Log.d(TAG, "Disconnected from: " + this.mServiceConnection.getAppData().getRecommendationServiceComponent());     // Catch: Throwable -> L12
    L14:
        this.mServiceConnection = null;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        clearInternal();
    }

    public boolean updateScores(ScoredNetwork[] networks) {
        if (isCallerActiveScorer(INetworkScoreService.Stub.getCallingUid()) == false) goto L42;
        long token = Binder.clearCallingIdentity();
        Map<Integer, List<ScoredNetwork>> networksByType = new ArrayMap();     // Catch: Throwable -> L10
        int r3 = networks.length;     // Catch: Throwable -> L10
        int r5 = 0;
    L6:
        if (r5 >= r3) goto L13;
        ScoredNetwork network = networks[r5];     // Catch: Throwable -> L10
        List<ScoredNetwork> networkList = networksByType.get(Integer.valueOf(network.networkKey.type));     // Catch: Throwable -> L10
        if (networkList != null) goto L12;
        networkList = new ArrayList();     // Catch: Throwable -> L10
        networksByType.put(Integer.valueOf(network.networkKey.type), networkList);     // Catch: Throwable -> L10
    L12:
        networkList.add(network);     // Catch: Throwable -> L10
        r5 = r5 + 1;     // Catch: Throwable -> L10
        goto L6
    L13:
        Iterator<Map.Entry<Integer, List<ScoredNetwork>>> r4 = networksByType.entrySet().iterator();     // Catch: Throwable -> L10
    L14:
        boolean isEmpty = true;
        if (r4.hasNext() == false) goto L37;
        Map.Entry<Integer, List<ScoredNetwork>> entry = r4.next();     // Catch: Throwable -> L10
        Map<Integer, RemoteCallbackList<INetworkScoreCache>> r7 = this.mScoreCaches;     // Catch: Throwable -> L10
        monitor-enter(r7);     // Catch: Throwable -> L10
        RemoteCallbackList<INetworkScoreCache> callbackList = this.mScoreCaches.get(entry.getKey());     // Catch: Throwable -> L24
        if (callbackList != null) goto L21;
    L28:
        monitor-exit(r7);     // Catch: Throwable -> L24
        if (isEmpty == true) goto L31;
        BiConsumer<INetworkScoreCache, Object> consumer = FilteringCacheUpdatingConsumer.create(this.mContext, entry.getValue(), entry.getKey().intValue());     // Catch: Throwable -> L10
        sendCacheUpdateCallback(consumer, Collections.singleton(callbackList));     // Catch: Throwable -> L10
        goto L14
    L31:
        if (Log.isLoggable(TAG, 2) == false) goto L14;
        Log.v(TAG, "No scorer registered for type " + entry.getKey() + ", discarding");     // Catch: Throwable -> L10
        goto L14
    L21:
        if (callbackList.getRegisteredCallbackCount() == 0) goto L28;
        isEmpty = false;
        goto L28
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L37:
        Binder.restoreCallingIdentity(token);
        return true;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L42:
        throw new SecurityException("Caller with UID " + INetworkScoreService.Stub.getCallingUid() + " is not the active scorer.");
    }

    public boolean clearScores() {
        enforceSystemOrIsActiveScorer(INetworkScoreService.Stub.getCallingUid());
        long token = Binder.clearCallingIdentity();
        clearInternal();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return true;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean setActiveScorer(String packageName) {
        enforceSystemOrHasScoreNetworks();
        return this.mNetworkScorerAppManager.setActiveScorer(packageName);
    }

    public boolean isCallerActiveScorer(int callingUid) {
        Object r0 = this.mServiceConnectionLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mServiceConnection != null) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mServiceConnection.getAppData().packageUid != callingUid) goto L11;
        r1 = true;
        goto L12
    }

    private void enforceSystemOnly() throws SecurityException {
        this.mContext.enforceCallingOrSelfPermission("android.permission.REQUEST_NETWORK_SCORES", "Caller must be granted REQUEST_NETWORK_SCORES.");
    }

    private void enforceSystemOrHasScoreNetworks() throws SecurityException {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.REQUEST_NETWORK_SCORES") != 0) goto L5;
        return;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.SCORE_NETWORKS") != 0) goto L8;
        return;
    L8:
        throw new SecurityException("Caller is neither the system process or a network scorer.");
    }

    private void enforceSystemOrIsActiveScorer(int callingUid) throws SecurityException {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.REQUEST_NETWORK_SCORES") != 0) goto L5;
        return;
    L5:
        if (isCallerActiveScorer(callingUid) == false) goto L8;
        return;
    L8:
        throw new SecurityException("Caller is neither the system process or the active network scorer.");
    }

    public String getActiveScorerPackage() {
        enforceSystemOrHasScoreNetworks();
        NetworkScorerAppData appData = this.mNetworkScorerAppManager.getActiveScorer();
        if (appData != null) goto L7;
        return null;
    L7:
        return appData.getRecommendationServicePackageName();
    }

    public NetworkScorerAppData getActiveScorer() {
        enforceSystemOnly();
        return this.mNetworkScorerAppManager.getActiveScorer();
    }

    public List<NetworkScorerAppData> getAllValidScorers() {
        enforceSystemOnly();
        return this.mNetworkScorerAppManager.getAllValidScorers();
    }

    public void disableScoring() {
        enforceSystemOrIsActiveScorer(INetworkScoreService.Stub.getCallingUid());
    }

    private void clearInternal() {
        sendCacheUpdateCallback(new AnonymousClass4(this), getScoreCacheLists());
    }

    public void registerNetworkScoreCache(int networkType, INetworkScoreCache scoreCache, int filterType) {
        enforceSystemOnly();
        long token = Binder.clearCallingIdentity();
        Map<Integer, RemoteCallbackList<INetworkScoreCache>> r2 = this.mScoreCaches;     // Catch: Throwable -> L23
        monitor-enter(r2);     // Catch: Throwable -> L23
        RemoteCallbackList<INetworkScoreCache> callbackList = this.mScoreCaches.get(Integer.valueOf(networkType));     // Catch: Throwable -> L8
        if (callbackList != null) goto L11;
        callbackList = new RemoteCallbackList();     // Catch: Throwable -> L8
        this.mScoreCaches.put(Integer.valueOf(networkType), callbackList);     // Catch: Throwable -> L8
    L11:
        if (callbackList.register(scoreCache, Integer.valueOf(filterType)) == false) goto L13;
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(token);
        return;
    L13:
        if (callbackList.getRegisteredCallbackCount() != 0) goto L16;
        this.mScoreCaches.remove(Integer.valueOf(networkType));     // Catch: Throwable -> L8
    L16:
        if (Log.isLoggable(TAG, 2) == false) goto L18;
        Log.v(TAG, "Unable to register NetworkScoreCache for type " + networkType);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void unregisterNetworkScoreCache(int networkType, INetworkScoreCache scoreCache) {
        enforceSystemOnly();
        long token = Binder.clearCallingIdentity();
        Map<Integer, RemoteCallbackList<INetworkScoreCache>> r2 = this.mScoreCaches;     // Catch: Throwable -> L23
        monitor-enter(r2);     // Catch: Throwable -> L23
        RemoteCallbackList<INetworkScoreCache> callbackList = this.mScoreCaches.get(Integer.valueOf(networkType));     // Catch: Throwable -> L13
        if (callbackList == null) goto L16;
        if (callbackList.unregister(scoreCache) == false) goto L16;
        if (callbackList.getRegisteredCallbackCount() != 0) goto L18;
        this.mScoreCaches.remove(Integer.valueOf(networkType));     // Catch: Throwable -> L13
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(token);
        return;
    L16:
        if (Log.isLoggable(TAG, 2) == false) goto L18;
        Log.v(TAG, "Unable to unregister NetworkScoreCache for type " + networkType);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean requestScores(NetworkKey[] networks) {
        enforceSystemOnly();
        long token = Binder.clearCallingIdentity();
        INetworkRecommendationProvider provider = getRecommendationProvider();     // Catch: Throwable -> L8
        if (provider != null) goto L17;
    L12:
        Binder.restoreCallingIdentity(token);
        return false;
    L17:
        provider.requestScores(networks);     // Catch: Throwable -> L8 RemoteException -> L10
        Binder.restoreCallingIdentity(token);
        return true;
    L10:
        e = move-exception;
        Log.w(TAG, "Failed to request scores.", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, writer) == true) goto L5;
        return;
    L5:
        long token = Binder.clearCallingIdentity();
        NetworkScorerAppData currentScorer = this.mNetworkScorerAppManager.getActiveScorer();     // Catch: Throwable -> L11
        if (currentScorer != null) goto L13;
        writer.println("Scoring is disabled.");     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return;
    L13:
        writer.println("Current scorer: " + currentScorer);     // Catch: Throwable -> L11
        Object r3 = this.mServiceConnectionLock;     // Catch: Throwable -> L11
        monitor-enter(r3);     // Catch: Throwable -> L11
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L16:
        if (this.mServiceConnection == null) goto L20;
        this.mServiceConnection.dump(fd, writer, args);     // Catch: Throwable -> L18
    L21:
        monitor-exit(r3);     // Catch: Throwable -> L18
        writer.flush();     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return;
    L20:
        writer.println("ScoringServiceConnection: null");     // Catch: Throwable -> L18
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private Collection<RemoteCallbackList<INetworkScoreCache>> getScoreCacheLists() {
        Map<Integer, RemoteCallbackList<INetworkScoreCache>> r0 = this.mScoreCaches;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mScoreCaches.values());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void sendCacheUpdateCallback(BiConsumer<INetworkScoreCache, Object> consumer, Collection<RemoteCallbackList<INetworkScoreCache>> remoteCallbackLists) {
        Iterator<RemoteCallbackList<INetworkScoreCache>> r0 = remoteCallbackLists.iterator();
    L4:
        if (r0.hasNext() == false) goto L22;
        RemoteCallbackList<INetworkScoreCache> callbackList = r0.next();
        monitor-enter(callbackList);
        int count = callbackList.beginBroadcast();     // Catch: Throwable -> L15
        int i = 0;
    L9:
        if (i >= count) goto L17;
        consumer.accept((INetworkScoreCache) callbackList.getBroadcastItem(i), callbackList.getBroadcastCookie(i));     // Catch: Throwable -> L12
        i = i + 1;
        goto L9
    L12:
        th = move-exception;
        callbackList.finishBroadcast();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L17:
        callbackList.finishBroadcast();     // Catch: Throwable -> L15
        monitor-exit(callbackList);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private INetworkRecommendationProvider getRecommendationProvider() {
        Object r0 = this.mServiceConnectionLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mServiceConnection == null) goto L11;
        INetworkRecommendationProvider r1 = this.mServiceConnection.getRecommendationProvider();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    }
}
