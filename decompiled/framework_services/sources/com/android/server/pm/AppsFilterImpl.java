package com.android.server.pm;

import android.R;
import android.app.ApplicationPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.SigningDetails;
import android.content.pm.UserInfo;
import android.os.Handler;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.SparseSetArray;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.pm.pkg.component.ParsedInstrumentation;
import com.android.internal.pm.pkg.component.ParsedPermission;
import com.android.internal.pm.pkg.component.ParsedUsesPermission;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.FgThread;
import com.android.server.am.ProcessList;
import com.android.server.compat.CompatChange;
import com.android.server.job.controllers.JobStatus;
import com.android.server.om.OverlayReferenceMapper;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.SharedUserApi;
import com.android.server.utils.Snappable;
import com.android.server.utils.SnapshotCache;
import com.android.server.utils.Watchable;
import com.android.server.utils.WatchableImpl;
import com.android.server.utils.WatchedArraySet;
import com.android.server.utils.WatchedSparseBooleanMatrix;
import com.android.server.utils.WatchedSparseSetArray;
import com.android.server.utils.Watcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class AppsFilterImpl extends AppsFilterLocked implements Watchable, Snappable {
    private final ArrayMap<String, ArraySet<Integer>> mPermissionToUids;
    private final SnapshotCache<AppsFilterSnapshot> mSnapshot;
    private final ArrayMap<String, ArraySet<Integer>> mUsesPermissionToUids;
    private final WatchableImpl mWatchable;

    private static class FeatureConfigImpl implements FeatureConfig, CompatChange.ChangeListener {
        private static final String FILTERING_ENABLED_NAME = "package_query_filtering_enabled";
        private AppsFilterImpl mAppsFilter;
        private final ArraySet<String> mDisabledPackages;
        private volatile boolean mFeatureEnabled;
        private final PackageManagerServiceInjector mInjector;
        private SparseBooleanArray mLoggingEnabled;
        private final PackageManagerInternal mPmInternal;

        /* JADX INFO: renamed from: $r8$lambda$nEuQ-D-WL9NkIzaT2rbijpElj8Q, reason: not valid java name */
        public static /* synthetic */ void m6605$r8$lambda$nEuQDWL9NkIzaT2rbijpElj8Q(FeatureConfigImpl r0, DeviceConfig.Properties r1) {
            r0.lambda$onSystemReady$0(r1);
        }

        /* synthetic */ FeatureConfigImpl(PackageManagerInternal r1, PackageManagerServiceInjector r2, AppsFilterImplIA r3) {
            this(r1, r2);
        }

        private FeatureConfigImpl(PackageManagerInternal pmInternal, PackageManagerServiceInjector injector) {
            this.mFeatureEnabled = true;
            this.mDisabledPackages = new ArraySet();
            this.mLoggingEnabled = null;
            this.mPmInternal = pmInternal;
            this.mInjector = injector;
        }

        FeatureConfigImpl(FeatureConfigImpl orig) {
            this.mFeatureEnabled = true;
            this.mDisabledPackages = new ArraySet();
            this.mLoggingEnabled = null;
            this.mInjector = null;
            this.mPmInternal = null;
            this.mFeatureEnabled = orig.mFeatureEnabled;
            ArraySet<String> r0 = orig.mDisabledPackages;
            monitor-enter(r0);
            this.mDisabledPackages.addAll(orig.mDisabledPackages);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            this.mLoggingEnabled = orig.mLoggingEnabled;
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void setAppsFilter(AppsFilterImpl filter) {
            this.mAppsFilter = filter;
        }

        @Override // com.android.server.pm.FeatureConfig
        public void onSystemReady() {
            this.mFeatureEnabled = DeviceConfig.getBoolean("package_manager_service", FILTERING_ENABLED_NAME, true);
            DeviceConfig.addOnPropertiesChangedListener("package_manager_service", FgThread.getExecutor(), new AppsFilterImpl$FeatureConfigImpl$$ExternalSyntheticLambda0(this));
            this.mInjector.getCompatibility().registerListener(135549675, this);
        }

        private /* synthetic */ void lambda$onSystemReady$0(DeviceConfig.Properties properties) {
            if (properties.getKeyset().contains(FILTERING_ENABLED_NAME) == false) goto L11;
            monitor-enter(this);
            this.mFeatureEnabled = properties.getBoolean(FILTERING_ENABLED_NAME, true);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.FeatureConfig
        public boolean isGloballyEnabled() {
            return this.mFeatureEnabled;
        L4:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.FeatureConfig
        public boolean packageIsEnabled(AndroidPackage pkg) {
            ArraySet<String> r0 = this.mDisabledPackages;     // Catch: Throwable -> L13
            monitor-enter(r0);     // Catch: Throwable -> L13
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L5:
            if (this.mDisabledPackages.contains(pkg.getPackageName()) == true) goto L7;
            boolean r1 = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = false;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.FeatureConfig
        public boolean isLoggingEnabled(int uid) {
            if (this.mLoggingEnabled != null) goto L5;
        L7:
            return false;
        L5:
            if (this.mLoggingEnabled.indexOfKey(uid) < 0) goto L7;
            return true;
        }

        @Override // com.android.server.pm.FeatureConfig
        public void enableLogging(int appId, boolean enable) {
            if (enable == false) goto L8;
            if (this.mLoggingEnabled != null) goto L6;
            this.mLoggingEnabled = new SparseBooleanArray();
        L6:
            this.mLoggingEnabled.put(appId, true);
            return;
        L8:
            if (this.mLoggingEnabled == null) goto L16;
            int index = this.mLoggingEnabled.indexOfKey(appId);
            if (index < 0) goto L17;
            this.mLoggingEnabled.removeAt(index);
            if (this.mLoggingEnabled.size() != 0) goto L18;
            this.mLoggingEnabled = null;
            return;
        L18:
            return;
        L17:
            return;
        }

        @Override // com.android.server.compat.CompatChange.ChangeListener
        public void onCompatChange(String packageName) {
            Computer snapshot = (Computer) this.mPmInternal.snapshot();
            AndroidPackage pkg = snapshot.getPackage(packageName);
            if (pkg != null) goto L5;
            return;
        L5:
            long currentTimeUs = SystemClock.currentTimeMicro();
            updateEnabledState(pkg);
            AppsFilterImpl.m6604$$Nest$mupdateShouldFilterCacheForPackage(this.mAppsFilter, snapshot, packageName);
            AppsFilterImpl.m6602$$Nest$mlogCacheUpdated(this.mAppsFilter, 4, SystemClock.currentTimeMicro() - currentTimeUs, snapshot.getUserInfos().length, snapshot.getPackageStates().size(), pkg.getUid());
        }

        private void updateEnabledState(AndroidPackage pkg) {
            boolean enabled = this.mInjector.getCompatibility().isChangeEnabledInternalNoLogging(135549675, AndroidPackageUtils.generateAppInfoWithoutState(pkg));
            ArraySet<String> r1 = this.mDisabledPackages;
            monitor-enter(r1);
            if (enabled == false) goto L8;
            this.mDisabledPackages.remove(pkg.getPackageName());     // Catch: Throwable -> L6
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L6
            if (this.mAppsFilter == null) goto L18;
            AppsFilterImpl.m6603$$Nest$monChanged(this.mAppsFilter);
            return;
        L18:
            return;
        L8:
            this.mDisabledPackages.add(pkg.getPackageName());     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.FeatureConfig
        public void updatePackageState(PackageStateInternal setting, boolean removed) {
            if (setting.getPkg() == null) goto L10;
            if (removed == true) goto L10;
            if (setting.getPkg().isTestOnly() == false) goto L8;
        L9:
            boolean enableLogging = true;
        L11:
            enableLogging(setting.getAppId(), enableLogging);
            if (removed == false) goto L24;
            ArraySet<String> r1 = this.mDisabledPackages;
            monitor-enter(r1);
            this.mDisabledPackages.remove(setting.getPackageName());     // Catch: Throwable -> L20
            monitor-exit(r1);     // Catch: Throwable -> L20
            if (this.mAppsFilter == null) goto L29;
            AppsFilterImpl.m6603$$Nest$monChanged(this.mAppsFilter);
            return;
        L29:
            return;
        L20:
            th = move-exception;
            throw th;
        L24:
            if (setting.getPkg() == null) goto L31;
            updateEnabledState(setting.getPkg());
            return;
        L31:
            return;
        L8:
            if (setting.getPkg().isDebuggable() == true) goto L9;
        L10:
            enableLogging = false;
            goto L11
        }

        @Override // com.android.server.pm.FeatureConfig
        public FeatureConfig snapshot() {
            return new FeatureConfigImpl(this);
        }
    }

    public static /* synthetic */ void $r8$lambda$upIZkL_ivpfWJ2brYK92CfeE4eM(AppsFilterImpl r0) {
        r0.readCacheEnabledSysProp();
    }

    public static /* synthetic */ void $r8$lambda$z8pKsxG_4fqX35js78wjP4SRLPM(AppsFilterImpl r0, PackageManagerInternal r1, int r2, long r3) {
        r0.lambda$updateEntireShouldFilterCacheAsync$0(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mlogCacheUpdated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6602$$Nest$mlogCacheUpdated(AppsFilterImpl r0, int r1, long r2, int r4, int r5, int r6) {
        r0.logCacheUpdated(r1, r2, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$monChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6603$$Nest$monChanged(AppsFilterImpl r0) {
        r0.onChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateShouldFilterCacheForPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6604$$Nest$mupdateShouldFilterCacheForPackage(AppsFilterImpl r0, Computer r1, String r2) {
        r0.updateShouldFilterCacheForPackage(r1, r2);
    }

    @Override // com.android.server.utils.Snappable
    public /* bridge */ /* synthetic */ Object snapshot() {
        return snapshot();
    }

    @Override // com.android.server.utils.Watchable
    public void registerObserver(Watcher observer) {
        this.mWatchable.registerObserver(observer);
    }

    @Override // com.android.server.utils.Watchable
    public void unregisterObserver(Watcher observer) {
        this.mWatchable.unregisterObserver(observer);
    }

    @Override // com.android.server.utils.Watchable
    public boolean isRegisteredObserver(Watcher observer) {
        return this.mWatchable.isRegisteredObserver(observer);
    }

    @Override // com.android.server.utils.Watchable
    public void dispatchChange(Watchable what) {
        this.mWatchable.dispatchChange(what);
    }

    private void onChanged() {
        PackageManager.invalidatePackageInfoCache();
        ApplicationPackageManager.invalidateGetPackagesForUidCache();
        dispatchChange(this);
    }

    private void invalidateCache(String reason) {
        if (this.mCacheValid.compareAndSet(true, false) == false) goto L6;
        Slog.i("AppsFilter", "Invalidating cache: " + reason);
        return;
    }

    AppsFilterImpl(FeatureConfig featureConfig, String[] forceQueryableList, boolean systemAppsQueryable, OverlayReferenceMapper.Provider overlayProvider, Handler handler) {
        this.mWatchable = new WatchableImpl();
        this.mFeatureConfig = featureConfig;
        this.mForceQueryableByDevicePackageNames = forceQueryableList;
        this.mSystemAppsQueryable = systemAppsQueryable;
        this.mOverlayReferenceMapper = new OverlayReferenceMapper(true, overlayProvider);
        this.mHandler = handler;
        this.mShouldFilterCache = new WatchedSparseBooleanMatrix();
        this.mShouldFilterCacheSnapshot = new SnapshotCache.Auto(this.mShouldFilterCache, this.mShouldFilterCache, "AppsFilter.mShouldFilterCache");
        this.mImplicitlyQueryable = new WatchedSparseSetArray();
        this.mImplicitQueryableSnapshot = new SnapshotCache.Auto(this.mImplicitlyQueryable, this.mImplicitlyQueryable, "AppsFilter.mImplicitlyQueryable");
        this.mRetainedImplicitlyQueryable = new WatchedSparseSetArray();
        this.mRetainedImplicitlyQueryableSnapshot = new SnapshotCache.Auto(this.mRetainedImplicitlyQueryable, this.mRetainedImplicitlyQueryable, "AppsFilter.mRetainedImplicitlyQueryable");
        this.mQueriesViaPackage = new WatchedSparseSetArray();
        this.mQueriesViaPackageSnapshot = new SnapshotCache.Auto(this.mQueriesViaPackage, this.mQueriesViaPackage, "AppsFilter.mQueriesViaPackage");
        this.mQueriesViaComponent = new WatchedSparseSetArray();
        this.mQueriesViaComponentSnapshot = new SnapshotCache.Auto(this.mQueriesViaComponent, this.mQueriesViaComponent, "AppsFilter.mQueriesViaComponent");
        this.mQueryableViaUsesLibrary = new WatchedSparseSetArray();
        this.mQueryableViaUsesLibrarySnapshot = new SnapshotCache.Auto(this.mQueryableViaUsesLibrary, this.mQueryableViaUsesLibrary, "AppsFilter.mQueryableViaUsesLibrary");
        this.mQueryableViaUsesPermission = new WatchedSparseSetArray();
        this.mQueryableViaUsesPermissionSnapshot = new SnapshotCache.Auto(this.mQueryableViaUsesPermission, this.mQueryableViaUsesPermission, "AppsFilter.mQueryableViaUsesPermission");
        this.mForceQueryable = new WatchedArraySet();
        this.mForceQueryableSnapshot = new SnapshotCache.Auto(this.mForceQueryable, this.mForceQueryable, "AppsFilter.mForceQueryable");
        this.mProtectedBroadcasts = new WatchedArraySet();
        this.mProtectedBroadcastsSnapshot = new SnapshotCache.Auto(this.mProtectedBroadcasts, this.mProtectedBroadcasts, "AppsFilter.mProtectedBroadcasts");
        this.mPermissionToUids = new ArrayMap();
        this.mUsesPermissionToUids = new ArrayMap();
        this.mSnapshot = new AnonymousClass1(this, this, this);
        readCacheEnabledSysProp();
        SystemProperties.addChangeCallback(new AppsFilterImpl$$ExternalSyntheticLambda1(this));
    }

    private void readCacheEnabledSysProp() {
        this.mCacheEnabled = SystemProperties.getBoolean("debug.pm.use_app_filter_cache", true);
    }

    @Override // com.android.server.utils.Snappable
    public AppsFilterSnapshot snapshot() {
        return this.mSnapshot.snapshot();
    }

    public static AppsFilterImpl create(PackageManagerServiceInjector injector, PackageManagerInternal pmInt) {
        boolean forceSystemAppsQueryable = injector.getContext().getResources().getBoolean(R.bool.config_goToSleepOnButtonPressTheaterMode);
        FeatureConfigImpl featureConfig = new FeatureConfigImpl(pmInt, injector, null);
        if (forceSystemAppsQueryable == false) goto L5;
        String[] forcedQueryablePackageNames = new String[0];
    L10:
        AppsFilterImpl appsFilter = new AppsFilterImpl(featureConfig, forcedQueryablePackageNames, forceSystemAppsQueryable, null, injector.getHandler());
        featureConfig.setAppsFilter(appsFilter);
        return appsFilter;
    L5:
        String[] forcedQueryablePackageNames2 = injector.getContext().getResources().getStringArray(R.array.config_loggable_dream_prefixes);
        int i = 0;
    L7:
        if (i >= forcedQueryablePackageNames2.length) goto L9;
        forcedQueryablePackageNames2[i] = forcedQueryablePackageNames2[i].intern();
        i = i + 1;
        goto L7
    L9:
        forcedQueryablePackageNames = forcedQueryablePackageNames2;
        goto L10
    }

    public FeatureConfig getFeatureConfig() {
        return this.mFeatureConfig;
    }

    public boolean grantImplicitAccess(int recipientUid, int visibleUid, boolean retainOnUpdate) {
        if (recipientUid != visibleUid) goto L5;
        return false;
    L5:
        PackageManagerTracedLock r1 = this.mImplicitlyQueryableLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        if (retainOnUpdate == false) goto L11;
        boolean changed = this.mRetainedImplicitlyQueryable.add(recipientUid, Integer.valueOf(visibleUid));     // Catch: Throwable -> L9
    L13:
        if (this.mCacheReady == true) goto L16;
        if (changed == false) goto L16;
        this.mNeedToUpdateCacheForImplicitAccess = true;     // Catch: Throwable -> L9
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (this.mCacheReady == false) goto L28;
        PackageManagerTracedLock r2 = this.mCacheLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        this.mShouldFilterCache.put(recipientUid, visibleUid, false);     // Catch: Throwable -> L24
        monitor-exit(r2);     // Catch: Throwable -> L24
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L24:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L28:
        if (changed == false) goto L30;
        onChanged();
    L30:
        return changed;
    L11:
        changed = this.mImplicitlyQueryable.add(recipientUid, Integer.valueOf(visibleUid));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void onSystemReady(PackageManagerInternal pmInternal) {
        this.mOverlayReferenceMapper.rebuildIfDeferred();
        this.mFeatureConfig.onSystemReady();
        updateEntireShouldFilterCacheAsync(pmInternal, 1);
    }

    public void addPackage(Computer snapshot, PackageStateInternal newPkgSetting, boolean isReplace, boolean retainImplicitGrantOnReplace) {
        AppsFilterImpl r1 = this;
        long currentTimeUs = SystemClock.currentTimeMicro();
        if (isReplace == false) goto L5;
        int r2 = 3;
    L6:
        int logType = r2;
        if (isReplace == false) goto L13;
        Computer r3 = snapshot;
        r1.removePackageInternal(r3, newPkgSetting, true, retainImplicitGrantOnReplace);     // Catch: Throwable -> L11
    L66:
        ArrayMap<String, ? extends PackageStateInternal> settings = r3.getPackageStates();     // Catch: Throwable -> L53
        UserInfo[] users = r3.getUserInfos();     // Catch: Throwable -> L53
        ArraySet<String> additionalChangedPackages = r1.addPackageInternal(newPkgSetting, settings);     // Catch: Throwable -> L53
        if (r1.mCacheReady == false) goto L55;
        PackageManagerTracedLock r14 = r1.mCacheLock;     // Catch: Throwable -> L53
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L53
        monitor-enter(r14);     // Catch: Throwable -> L53
        r1.updateShouldFilterCacheForPackage(r3, null, newPkgSetting, settings, users, -1, settings.size());     // Catch: Throwable -> L46
        if (additionalChangedPackages == null) goto L33;
        int index = 0;
    L64:
    L30:
        th = th;
    L60:
        monitor-exit(r14);     // Catch: Throwable -> L51
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L51:
        th = th;
        goto L60
    L23:
        if (index >= additionalChangedPackages.size()) goto L32;
        String changedPackage = additionalChangedPackages.valueAt(index);     // Catch: Throwable -> L30
        PackageStateInternal changedPkgSetting = settings.get(changedPackage);     // Catch: Throwable -> L30
        if (changedPkgSetting == null) goto L29;
        updateShouldFilterCacheForPackage(snapshot, null, changedPkgSetting, settings, users, -1, settings.size());     // Catch: Throwable -> L30
    L29:
        index = index + 1;
        users = users;
        settings = settings;
        goto L64
    L32:
        ArrayMap<String, ? extends PackageStateInternal> settings2 = settings;
        UserInfo[] users2 = users;
    L62:
        monitor-exit(r14);     // Catch: Throwable -> L44
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L41
        long r4 = SystemClock.currentTimeMicro() - currentTimeUs;     // Catch: Throwable -> L41
        int r5 = users2.length;     // Catch: Throwable -> L41
        r1 = this;
        r1.logCacheUpdated(logType, r4, r5, settings2.size(), newPkgSetting.getAppId());     // Catch: Throwable -> L39
    L56:
        r1.onChanged();
        return;
    L41:
        Throwable th = th;
        r1 = this;
    L58:
        r1.onChanged();
        throw th;
    L44:
        th = th;
        goto L60
    L33:
        settings2 = settings;
        users2 = users;
    L46:
        th = th;
        goto L60
    L55:
        r1.invalidateCache("addPackage: " + newPkgSetting.getPackageName());     // Catch: Throwable -> L39
    L39:
        th = th;
    L53:
        th = th;
    L11:
        th = th;
        goto L58
    L13:
        r3 = snapshot;
        goto L66
    L5:
        r2 = 1;
        goto L6
    }

    private ArraySet<String> addPackageInternal(PackageStateInternal newPkgSetting, ArrayMap<String, ? extends PackageStateInternal> existingSettings) {
        if (Objects.equals(PackageManagerService.PLATFORM_PACKAGE_NAME, newPkgSetting.getPackageName()) == false) goto L19;
        this.mSystemSigningDetails = newPkgSetting.getSigningDetails();
        Iterator<? extends PackageStateInternal> r0 = existingSettings.values().iterator();
    L6:
        if (r0.hasNext() == false) goto L19;
        PackageStateInternal setting = r0.next();
        if (isSystemSigned(this.mSystemSigningDetails, setting) == false) goto L6;
        PackageManagerTracedLock r5 = this.mForceQueryableLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        this.mForceQueryable.add(Integer.valueOf(setting.getAppId()));     // Catch: Throwable -> L14
        monitor-exit(r5);     // Catch: Throwable -> L14
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L14:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L19:
        AndroidPackageInternal r4 = newPkgSetting.getPkg();
        if (r4 != null) goto L23;
        return null;
    L23:
        List<String> newBroadcasts = r4.getProtectedBroadcasts();
        boolean r7 = true;
        if (newBroadcasts.size() == 0) goto L39;
        PackageManagerTracedLock r8 = this.mProtectedBroadcastsLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r8);
        int oldSize = this.mProtectedBroadcasts.size();     // Catch: Throwable -> L35
        this.mProtectedBroadcasts.addAll(newBroadcasts);     // Catch: Throwable -> L35
        if (this.mProtectedBroadcasts.size() == oldSize) goto L30;
        boolean protectedBroadcastsChanged = true;
    L31:
        monitor-exit(r8);     // Catch: Throwable -> L35
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (protectedBroadcastsChanged == false) goto L39;
        this.mQueriesViaComponentRequireRecompute.set(true);
        goto L39
    L30:
        protectedBroadcastsChanged = false;
    L35:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L39:
        PackageManagerTracedLock r9 = this.mForceQueryableLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r9);
    L54:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L42:
        if (this.mForceQueryable.contains(Integer.valueOf(newPkgSetting.getAppId())) == false) goto L44;
    L57:
        boolean r1 = true;
    L58:
        boolean newIsForceQueryable = r1;
        if (newIsForceQueryable == false) goto L61;
    L66:
        this.mForceQueryable.add(Integer.valueOf(newPkgSetting.getAppId()));     // Catch: Throwable -> L54
    L67:
        monitor-exit(r9);     // Catch: Throwable -> L54
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (r4.getUsesPermissions().isEmpty() == true) goto L101;
        PackageManagerTracedLock r10 = this.mQueryableViaUsesPermissionLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r10);
        Iterator r2 = r4.getUsesPermissions().iterator();     // Catch: Throwable -> L83
    L74:
        if (r2.hasNext() == false) goto L94;
        ParsedUsesPermission usesPermission = (ParsedUsesPermission) r2.next();     // Catch: Throwable -> L83
        String usesPermissionName = usesPermission.getName();     // Catch: Throwable -> L83
        if (this.mPermissionToUids.containsKey(usesPermissionName) == false) goto L88;
        ArraySet<Integer> permissionDefiners = this.mPermissionToUids.get(usesPermissionName);     // Catch: Throwable -> L83
        int j = 0;
    L79:
        if (j >= permissionDefiners.size()) goto L87;
        int targetAppId = permissionDefiners.valueAt(j).intValue();     // Catch: Throwable -> L83
        if (targetAppId == newPkgSetting.getAppId()) goto L86;
        this.mQueryableViaUsesPermission.add(newPkgSetting.getAppId(), Integer.valueOf(targetAppId));     // Catch: Throwable -> L83
    L86:
        j = j + 1;     // Catch: Throwable -> L83
        r7 = r7;
        goto L79
    L87:
        boolean r16 = r7;
    L90:
        if (this.mUsesPermissionToUids.containsKey(usesPermissionName) == true) goto L92;
        this.mUsesPermissionToUids.put(usesPermissionName, new ArraySet());     // Catch: Throwable -> L83
    L92:
        this.mUsesPermissionToUids.get(usesPermissionName).add(Integer.valueOf(newPkgSetting.getAppId()));     // Catch: Throwable -> L83
        r7 = r16;
        goto L74
    L88:
        r16 = r7;
        goto L90
    L94:
        monitor-exit(r10);     // Catch: Throwable -> L83
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L83:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L101:
        if (r4.getPermissions().isEmpty() == true) goto L127;
        PackageManagerTracedLock r6 = this.mQueryableViaUsesPermissionLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r6);
        Iterator r3 = r4.getPermissions().iterator();     // Catch: Throwable -> L115
    L106:
        if (r3.hasNext() == false) goto L122;
        ParsedPermission permission = (ParsedPermission) r3.next();     // Catch: Throwable -> L115
        String permissionName = permission.getName();     // Catch: Throwable -> L115
        if (this.mUsesPermissionToUids.containsKey(permissionName) == false) goto L119;
        ArraySet<Integer> permissionUsers = this.mUsesPermissionToUids.get(permissionName);     // Catch: Throwable -> L115
        int j2 = 0;
    L111:
        if (j2 >= permissionUsers.size()) goto L119;
        int queryingAppId = permissionUsers.valueAt(j2).intValue();     // Catch: Throwable -> L115
        if (queryingAppId == newPkgSetting.getAppId()) goto L117;
        this.mQueryableViaUsesPermission.add(queryingAppId, Integer.valueOf(newPkgSetting.getAppId()));     // Catch: Throwable -> L115
    L117:
        j2 = j2 + 1;     // Catch: Throwable -> L115
    L119:
        if (this.mPermissionToUids.containsKey(permissionName) == true) goto L121;
        this.mPermissionToUids.put(permissionName, new ArraySet());     // Catch: Throwable -> L115
    L121:
        this.mPermissionToUids.get(permissionName).add(Integer.valueOf(newPkgSetting.getAppId()));     // Catch: Throwable -> L115
        goto L106
    L122:
        monitor-exit(r6);     // Catch: Throwable -> L115
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L115:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L127:
        int i = existingSettings.size() - 1;
    L128:
        if (i < 0) goto L242;
        PackageStateInternal existingSetting = existingSettings.valueAt(i);
        if (existingSetting.getAppId() == newPkgSetting.getAppId()) goto L241;
        if (existingSetting.getPkg() == null) goto L241;
        AndroidPackageInternal r11 = existingSetting.getPkg();
        if (newIsForceQueryable == false) goto L137;
    L175:
        PackageManagerTracedLock r12 = this.mForceQueryableLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r12);
        boolean existingIsForceQueryable = this.mForceQueryable.contains(Integer.valueOf(existingSetting.getAppId()));     // Catch: Throwable -> L237
        monitor-exit(r12);     // Catch: Throwable -> L237
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (existingIsForceQueryable == true) goto L221;
        if (this.mQueriesViaComponentRequireRecompute.get() == true) goto L195;
        if (AppsFilterUtils.canQueryViaComponents(r4, r11, this.mProtectedBroadcasts) == false) goto L195;
        PackageManagerTracedLock r13 = this.mQueriesViaComponentLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r13);
        this.mQueriesViaComponent.add(newPkgSetting.getAppId(), Integer.valueOf(existingSetting.getAppId()));     // Catch: Throwable -> L190
        monitor-exit(r13);     // Catch: Throwable -> L190
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L190:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L195:
        if (AppsFilterUtils.canQueryViaPackage(r4, r11) == false) goto L197;
    L200:
        PackageManagerTracedLock r14 = this.mQueriesViaPackageLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r14);
        this.mQueriesViaPackage.add(newPkgSetting.getAppId(), Integer.valueOf(existingSetting.getAppId()));     // Catch: Throwable -> L216
        monitor-exit(r14);     // Catch: Throwable -> L216
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L206:
        if (AppsFilterUtils.canQueryViaUsesLibrary(r4, r11) == false) goto L221;
        PackageManagerTracedLock r15 = this.mQueryableViaUsesLibraryLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r15);
        this.mQueryableViaUsesLibrary.add(newPkgSetting.getAppId(), Integer.valueOf(existingSetting.getAppId()));     // Catch: Throwable -> L212
        monitor-exit(r15);     // Catch: Throwable -> L212
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L212:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L216:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L197:
        if (AppsFilterUtils.canQueryAsInstaller(newPkgSetting, r11) == true) goto L200;
        if (AppsFilterUtils.canQueryAsUpdateOwner(newPkgSetting, r11) == false) goto L206;
    L221:
        if (newPkgSetting.getPkg() == null) goto L241;
        if (existingSetting.getPkg() == null) goto L241;
        if (pkgInstruments(newPkgSetting.getPkg(), existingSetting.getPkg()) == false) goto L227;
    L228:
        PackageManagerTracedLock r17 = this.mQueriesViaPackageLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r17);
        this.mQueriesViaPackage.add(newPkgSetting.getAppId(), Integer.valueOf(existingSetting.getAppId()));     // Catch: Throwable -> L233
        this.mQueriesViaPackage.add(existingSetting.getAppId(), Integer.valueOf(newPkgSetting.getAppId()));     // Catch: Throwable -> L233
        monitor-exit(r17);     // Catch: Throwable -> L233
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L233:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L227:
        if (pkgInstruments(existingSetting.getPkg(), newPkgSetting.getPkg()) == false) goto L241;
    L237:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L137:
        if (this.mQueriesViaComponentRequireRecompute.get() == true) goto L150;
        if (AppsFilterUtils.canQueryViaComponents(r11, r4, this.mProtectedBroadcasts) == false) goto L150;
        PackageManagerTracedLock r18 = this.mQueriesViaComponentLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r18);
        this.mQueriesViaComponent.add(existingSetting.getAppId(), Integer.valueOf(newPkgSetting.getAppId()));     // Catch: Throwable -> L145
        monitor-exit(r18);     // Catch: Throwable -> L145
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L145:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L150:
        if (AppsFilterUtils.canQueryViaPackage(r11, r4) == false) goto L152;
    L155:
        PackageManagerTracedLock r19 = this.mQueriesViaPackageLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r19);
        this.mQueriesViaPackage.add(existingSetting.getAppId(), Integer.valueOf(newPkgSetting.getAppId()));     // Catch: Throwable -> L171
        monitor-exit(r19);     // Catch: Throwable -> L171
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L161:
        if (AppsFilterUtils.canQueryViaUsesLibrary(r11, r4) == false) goto L175;
        PackageManagerTracedLock r110 = this.mQueryableViaUsesLibraryLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r110);
        this.mQueryableViaUsesLibrary.add(existingSetting.getAppId(), Integer.valueOf(newPkgSetting.getAppId()));     // Catch: Throwable -> L167
        monitor-exit(r110);     // Catch: Throwable -> L167
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L167:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L171:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L152:
        if (AppsFilterUtils.canQueryAsInstaller(existingSetting, r4) == true) goto L155;
        if (AppsFilterUtils.canQueryAsUpdateOwner(existingSetting, r4) == false) goto L161;
    L241:
        i = i - 1;
        goto L128
    L242:
        int existingSize = existingSettings.size();
        ArrayMap<String, AndroidPackage> existingPkgs = new ArrayMap(existingSize);
        int index = 0;
    L243:
        if (index >= existingSize) goto L248;
        PackageStateInternal pkgSetting = existingSettings.valueAt(index);
        if (pkgSetting.getPkg() == null) goto L247;
        existingPkgs.put(pkgSetting.getPackageName(), pkgSetting.getPkg());
    L247:
        index = index + 1;
        goto L243
    L248:
        ArraySet<String> changedPackages = this.mOverlayReferenceMapper.addPkg(newPkgSetting.getPkg(), existingPkgs);
        this.mFeatureConfig.updatePackageState(newPkgSetting, false);
        return changedPackages;
    L61:
        if (this.mSystemSigningDetails == null) goto L65;
        if (isSystemSigned(this.mSystemSigningDetails, newPkgSetting) == true) goto L66;
    L65:
        if (AppsFilterImplZteHook.shouldForceQueryableZTE(newPkgSetting) == false) goto L67;
    L44:
        if (newPkgSetting.isForceQueryableOverride() == true) goto L57;
        if (newPkgSetting.isSystem() == true) goto L48;
    L56:
        r1 = false;
        goto L58
    L48:
        if (this.mSystemAppsQueryable == true) goto L57;
        if (r4.isForceQueryable() == true) goto L57;
        if (ArrayUtils.contains(this.mForceQueryableByDevicePackageNames, r4.getPackageName()) == false) goto L56;
        goto L56
    }

    private void removeAppIdFromVisibilityCache(int appId) {
        PackageManagerTracedLock r0 = this.mCacheLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        int i = 0;
    L20:
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L6:
        if (i >= this.mShouldFilterCache.size()) goto L14;
        if (UserHandle.getAppId(this.mShouldFilterCache.keyAt(i)) != appId) goto L12;
        this.mShouldFilterCache.removeAt(i);     // Catch: Throwable -> L10
        i = i - 1;     // Catch: Throwable -> L10
    L12:
        i = i + 1;     // Catch: Throwable -> L10
        goto L20
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    }

    private void updateEntireShouldFilterCache(Computer snapshot, int subjectUserId) {
        ArrayMap<String, ? extends PackageStateInternal> settings = snapshot.getPackageStates();
        UserInfo[] users = snapshot.getUserInfos();
        int userId = ProcessList.INVALID_ADJ;
        int u = 0;
    L4:
        if (u >= users.length) goto L10;
        if (subjectUserId == users[u].id) goto L7;
        u = u + 1;
        goto L4
    L7:
        userId = subjectUserId;
    L10:
        if (userId != (-10000)) goto L12;
        Slog.e("AppsFilter", "We encountered a new user that isn't a member of known users, updating the whole cache");
        userId = -1;
    L12:
        updateEntireShouldFilterCacheInner(snapshot, settings, users, userId);
        onChanged();
    }

    private void updateEntireShouldFilterCacheInner(Computer snapshot, ArrayMap<String, ? extends PackageStateInternal> settings, UserInfo[] users, int subjectUserId) {
        PackageManagerTracedLock r1 = this.mCacheLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        if (subjectUserId == (-1)) goto L29;
    L27:
        this.mShouldFilterCache.setCapacity(users.length * settings.size());     // Catch: Throwable -> L17
        int i = settings.size() - 1;     // Catch: Throwable -> L17
    L11:
        if (i < 0) goto L20;
        Computer snapshot2 = snapshot;
        ArrayMap<String, ? extends PackageStateInternal> settings2 = settings;
        UserInfo[] users2 = users;
        int subjectUserId2 = subjectUserId;
        updateShouldFilterCacheForPackage(snapshot2, null, settings.valueAt(i), settings2, users2, subjectUserId2, i);     // Catch: Throwable -> L15
        i = i - 1;     // Catch: Throwable -> L15
        snapshot = snapshot2;
        settings = settings2;
        users = users2;
        subjectUserId = subjectUserId2;
        goto L11
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L15
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L17:
        th = th;
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L15
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L29:
        this.mShouldFilterCache.clear();     // Catch: Throwable -> L8
    L8:
        th = th;
    L15:
        th = th;
        goto L23
    }

    private void updateEntireShouldFilterCacheAsync(PackageManagerInternal pmInternal, int reason) {
        updateEntireShouldFilterCacheAsync(pmInternal, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY, reason);
    }

    private void updateEntireShouldFilterCacheAsync(final PackageManagerInternal pmInternal, final long delayMs, final int reason) {
        this.mHandler.postDelayed(new AppsFilterImpl$$ExternalSyntheticLambda0(this, pmInternal, reason, delayMs), delayMs);
    }

    private /* synthetic */ void lambda$updateEntireShouldFilterCacheAsync$0(PackageManagerInternal pmInternal, int reason, long delayMs) {
        if (this.mCacheValid.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        long currentTimeUs = SystemClock.currentTimeMicro();
        ArrayMap<String, AndroidPackage> packagesCache = new ArrayMap();
        Computer snapshot = (Computer) pmInternal.snapshot();
        ArrayMap<String, ? extends PackageStateInternal> settings = snapshot.getPackageStates();
        UserInfo[] users = snapshot.getUserInfos();
        packagesCache.ensureCapacity(settings.size());
        UserInfo[][] usersRef = {users};
        int i = 0;
        int max = settings.size();
    L6:
        if (i >= max) goto L8;
        packagesCache.put(settings.keyAt(i), settings.valueAt(i).getPkg());
        i = i + 1;
        goto L6
    L8:
        updateEntireShouldFilterCacheInner(snapshot, settings, usersRef[0], -1);
        logCacheRebuilt(reason, SystemClock.currentTimeMicro() - currentTimeUs, users.length, settings.size());
        if (this.mCacheValid.compareAndSet(true, true) == true) goto L12;
        Slog.i("AppsFilter", "Cache invalidated while building, retrying.");
        updateEntireShouldFilterCacheAsync(pmInternal, Math.min(2 * delayMs, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY), reason);
        return;
    L12:
        PackageManagerTracedLock r2 = this.mImplicitlyQueryableLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
    L17:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L15:
        if (this.mNeedToUpdateCacheForImplicitAccess == false) goto L19;
        updateShouldFilterCacheForImplicitAccess();     // Catch: Throwable -> L17
        this.mNeedToUpdateCacheForImplicitAccess = false;     // Catch: Throwable -> L17
    L19:
        this.mCacheReady = true;     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L17
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        onChanged();
    }

    public void onUserCreated(Computer snapshot, int newUserId) {
        if (this.mCacheReady == true) goto L5;
        return;
    L5:
        long currentTimeUs = SystemClock.currentTimeMicro();
        updateEntireShouldFilterCache(snapshot, newUserId);
        logCacheRebuilt(2, SystemClock.currentTimeMicro() - currentTimeUs, snapshot.getUserInfos().length, snapshot.getPackageStates().size());
    }

    public void onUserDeleted(Computer snapshot, int userId) {
        if (this.mCacheReady == true) goto L5;
        return;
    L5:
        long currentTimeUs = SystemClock.currentTimeMicro();
        removeShouldFilterCacheForUser(userId);
        onChanged();
        logCacheRebuilt(3, SystemClock.currentTimeMicro() - currentTimeUs, snapshot.getUserInfos().length, snapshot.getPackageStates().size());
    }

    private void updateShouldFilterCacheForImplicitAccess() {
        updateShouldFilterCacheForImplicitAccess(this.mRetainedImplicitlyQueryable);
        updateShouldFilterCacheForImplicitAccess(this.mImplicitlyQueryable);
    }

    private void updateShouldFilterCacheForImplicitAccess(WatchedSparseSetArray<Integer> queriesMap) {
        PackageManagerTracedLock r0 = this.mCacheLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        int i = 0;
    L21:
    L11:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L6:
        if (i >= queriesMap.size()) goto L15;
        Integer callingUid = Integer.valueOf(queriesMap.keyAt(i));     // Catch: Throwable -> L11
        ArraySet<Integer> targetUids = queriesMap.get(callingUid.intValue());     // Catch: Throwable -> L11
        Iterator<Integer> r4 = targetUids.iterator();     // Catch: Throwable -> L11
    L9:
        if (r4.hasNext() == false) goto L13;
        Integer targetUid = r4.next();     // Catch: Throwable -> L11
        this.mShouldFilterCache.put(callingUid.intValue(), targetUid.intValue(), false);     // Catch: Throwable -> L11
        goto L9
    L13:
        i = i + 1;     // Catch: Throwable -> L11
        goto L21
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    }

    private void updateShouldFilterCacheForPackage(Computer snapshot, String packageName) {
        if (this.mCacheReady == true) goto L5;
        return;
    L5:
        ArrayMap<String, ? extends PackageStateInternal> settings = snapshot.getPackageStates();
        UserInfo[] users = snapshot.getUserInfos();
        PackageManagerTracedLock r9 = this.mCacheLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r9);
        updateShouldFilterCacheForPackage(snapshot, null, settings.get(packageName), settings, users, -1, settings.size());     // Catch: Throwable -> L13
        monitor-exit(r9);     // Catch: Throwable -> L13
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        onChanged();
        return;
    L15:
        th = move-exception;
        Throwable r11 = th;
    L17:
        monitor-exit(r9);     // Catch: Throwable -> L13
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw r11;
    L13:
        th = move-exception;
        r11 = th;
        goto L17
    }

    private void updateShouldFilterCacheForPackage(Computer snapshot, String skipPackageName, PackageStateInternal subjectSetting, ArrayMap<String, ? extends PackageStateInternal> allSettings, UserInfo[] allUsers, int subjectUserId, int maxIndex) {
        int i = Math.min(maxIndex, allSettings.size() - 1);
    L3:
        if (i < 0) goto L23;
        PackageStateInternal otherSetting = allSettings.valueAt(i);
        if (subjectSetting.getAppId() != otherSetting.getAppId()) goto L8;
        Computer snapshot2 = snapshot;
        PackageStateInternal subjectSetting2 = subjectSetting;
        UserInfo[] allUsers2 = allUsers;
        int subjectUserId2 = subjectUserId;
    L21:
        i = i - 1;
        snapshot = snapshot2;
        subjectSetting = subjectSetting2;
        allUsers = allUsers2;
        subjectUserId = subjectUserId2;
        goto L3
    L8:
        if (subjectSetting.getPackageName() != skipPackageName) goto L10;
        snapshot2 = snapshot;
        subjectSetting2 = subjectSetting;
        allUsers2 = allUsers;
        subjectUserId2 = subjectUserId;
        goto L21
    L10:
        if (otherSetting.getPackageName() != skipPackageName) goto L13;
        snapshot2 = snapshot;
        subjectSetting2 = subjectSetting;
        allUsers2 = allUsers;
        subjectUserId2 = subjectUserId;
        goto L21
    L13:
        if (subjectUserId != (-1)) goto L19;
        int su = 0;
    L16:
        if (su >= allUsers.length) goto L18;
        updateShouldFilterCacheForUser(snapshot, subjectSetting, allUsers, otherSetting, allUsers[su].id);
        su = su + 1;
        goto L16
    L18:
        snapshot2 = snapshot;
        subjectSetting2 = subjectSetting;
        allUsers2 = allUsers;
        subjectUserId2 = subjectUserId;
        goto L21
    L19:
        snapshot2 = snapshot;
        subjectSetting2 = subjectSetting;
        allUsers2 = allUsers;
        subjectUserId2 = subjectUserId;
        updateShouldFilterCacheForUser(snapshot2, subjectSetting2, allUsers2, otherSetting, subjectUserId2);
        goto L21
    }

    private void updateShouldFilterCacheForUser(Computer snapshot, PackageStateInternal subjectSetting, UserInfo[] allUsers, PackageStateInternal otherSetting, int subjectUserId) {
        int ou = 0;
    L4:
        if (ou >= allUsers.length) goto L7;
        int otherUser = allUsers[ou].id;
        int subjectUid = UserHandle.getUid(subjectUserId, subjectSetting.getAppId());
        int otherUid = UserHandle.getUid(otherUser, otherSetting.getAppId());
        boolean shouldFilterSubjectToOther = shouldFilterApplicationInternal(snapshot, subjectUid, subjectSetting, otherSetting, otherUser);
        boolean shouldFilterOtherToSubject = shouldFilterApplicationInternal(snapshot, otherUid, otherSetting, subjectSetting, subjectUserId);
        this.mShouldFilterCache.put(subjectUid, otherUid, shouldFilterSubjectToOther);
        this.mShouldFilterCache.put(otherUid, subjectUid, shouldFilterOtherToSubject);
        ou = ou + 1;
        goto L4
    }

    private void removeShouldFilterCacheForUser(int userId) {
        PackageManagerTracedLock r0 = this.mCacheLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        int[] cacheUids = this.mShouldFilterCache.keys();     // Catch: Throwable -> L24
        int size = cacheUids.length;     // Catch: Throwable -> L24
        int pos = Arrays.binarySearch(cacheUids, UserHandle.getUid(userId, 0));     // Catch: Throwable -> L24
        if (pos < 0) goto L7;
        int fromIndex = pos;
    L8:
        if (fromIndex >= size) goto L30;
        if (UserHandle.getUserId(cacheUids[fromIndex]) != userId) goto L30;
        int pos2 = Arrays.binarySearch(cacheUids, UserHandle.getUid(userId + 1, 0) - 1);     // Catch: Throwable -> L24
        if (pos2 < 0) goto L15;
        int toIndex = pos2 + 1;     // Catch: Throwable -> L24
    L16:
        if (fromIndex >= toIndex) goto L26;
        if (UserHandle.getUserId(cacheUids[toIndex - 1]) != userId) goto L26;
        this.mShouldFilterCache.removeRange(fromIndex, toIndex);     // Catch: Throwable -> L24
        this.mShouldFilterCache.compact();     // Catch: Throwable -> L24
        monitor-exit(r0);     // Catch: Throwable -> L24
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L26:
        Slog.w("AppsFilter", "Failed to remove should filter cache for user " + userId + ", fromIndex=" + fromIndex + ", toIndex=" + toIndex);     // Catch: Throwable -> L24
        monitor-exit(r0);     // Catch: Throwable -> L24
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L15:
        toIndex = ~pos2;     // Catch: Throwable -> L24
    L30:
        Slog.w("AppsFilter", "Failed to remove should filter cache for user " + userId + ", fromIndex=" + fromIndex);     // Catch: Throwable -> L24
        monitor-exit(r0);     // Catch: Throwable -> L24
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L7:
        fromIndex = ~pos;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private static boolean isSystemSigned(SigningDetails sysSigningDetails, PackageStateInternal pkgSetting) {
        if (pkgSetting.isSystem() == true) goto L5;
    L7:
        return false;
    L5:
        if (pkgSetting.getSigningDetails().signaturesMatchExactly(sysSigningDetails) == false) goto L7;
        return true;
    }

    private void collectProtectedBroadcasts(ArrayMap<String, ? extends PackageStateInternal> existingSettings, String excludePackage) {
        PackageManagerTracedLock r0 = this.mProtectedBroadcastsLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        this.mProtectedBroadcasts.clear();     // Catch: Throwable -> L14
        int i = existingSettings.size() - 1;     // Catch: Throwable -> L14
    L5:
        if (i < 0) goto L18;
        PackageStateInternal setting = existingSettings.valueAt(i);     // Catch: Throwable -> L14
        if (setting.getPkg() == null) goto L16;
        if (setting.getPkg().getPackageName().equals(excludePackage) == true) goto L16;
        List<String> protectedBroadcasts = setting.getPkg().getProtectedBroadcasts();     // Catch: Throwable -> L14
        if (protectedBroadcasts.isEmpty() == true) goto L16;
        this.mProtectedBroadcasts.addAll(protectedBroadcasts);     // Catch: Throwable -> L14
    L16:
        i = i - 1;     // Catch: Throwable -> L14
        goto L5
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L14
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L14:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.AppsFilterBase
    protected boolean isQueryableViaComponentWhenRequireRecompute(ArrayMap<String, ? extends PackageStateInternal> existingSettings, PackageStateInternal callingPkgSetting, ArraySet<PackageStateInternal> callingSharedPkgSettings, AndroidPackage targetPkg, int callingAppId, int targetAppId) {
        recomputeComponentVisibility(existingSettings);
        return isQueryableViaComponent(callingAppId, targetAppId);
    }

    private void recomputeComponentVisibility(ArrayMap<String, ? extends PackageStateInternal> existingSettings) {
        PackageManagerTracedLock r0 = this.mProtectedBroadcastsLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        WatchedArraySet<String> protectedBroadcasts = new WatchedArraySet(this.mProtectedBroadcasts);     // Catch: Throwable -> L24
        monitor-exit(r0);     // Catch: Throwable -> L24
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        PackageManagerTracedLock r2 = this.mForceQueryableLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        ArraySet<Integer> forceQueryable = new ArraySet(this.mForceQueryable.untrackedStorage());     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        AppsFilterUtils.ParallelComputeComponentVisibility computer = new AppsFilterUtils.ParallelComputeComponentVisibility(existingSettings, forceQueryable, protectedBroadcasts);
        SparseSetArray<Integer> queriesViaComponent = computer.execute();
        PackageManagerTracedLock r5 = this.mQueriesViaComponentLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        this.mQueriesViaComponent = new WatchedSparseSetArray(queriesViaComponent);     // Catch: Throwable -> L16
        this.mQueriesViaComponentSnapshot = new SnapshotCache.Auto(this.mQueriesViaComponent, this.mQueriesViaComponent, "AppsFilter.mQueriesViaComponent");     // Catch: Throwable -> L16
        monitor-exit(r5);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mQueriesViaComponentRequireRecompute.set(false);
        onChanged();
        return;
    L16:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L20:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L24:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void addPackage(Computer snapshot, PackageStateInternal newPkgSetting) {
        addPackage(snapshot, newPkgSetting, false, false);
    }

    public void removePackage(Computer snapshot, PackageStateInternal setting) {
        long currentTimeUs = SystemClock.currentTimeMicro();
        removePackageInternal(snapshot, setting, false, false);
        logCacheUpdated(2, SystemClock.currentTimeMicro() - currentTimeUs, snapshot.getUserInfos().length, snapshot.getPackageStates().size(), setting.getAppId());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:197:? -> B:164:0x0334). Please report as a decompilation issue!!! */
    private void removePackageInternal(Computer snapshot, PackageStateInternal setting, boolean isReplace, boolean retainImplicitGrantOnReplace) {
        ArrayMap<String, ? extends PackageStateInternal> settings = snapshot.getPackageStates();
        UserInfo[] users = snapshot.getUserInfos();
        int userCount = users.length;
        if (isReplace == false) goto L5;
        if (retainImplicitGrantOnReplace == false) goto L5;
    L25:
        if (this.mQueriesViaComponentRequireRecompute.get() == true) goto L39;
        PackageManagerTracedLock r2 = this.mQueriesViaComponentLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        this.mQueriesViaComponent.remove(setting.getAppId());     // Catch: Throwable -> L31
        int i = this.mQueriesViaComponent.size() - 1;     // Catch: Throwable -> L31
    L29:
        if (i < 0) goto L34;
        this.mQueriesViaComponent.remove(this.mQueriesViaComponent.keyAt(i), Integer.valueOf(setting.getAppId()));     // Catch: Throwable -> L31
        i = i - 1;     // Catch: Throwable -> L31
        goto L29
    L34:
        monitor-exit(r2);     // Catch: Throwable -> L31
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L31:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L39:
        PackageManagerTracedLock r3 = this.mQueriesViaPackageLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r3);
        this.mQueriesViaPackage.remove(setting.getAppId());     // Catch: Throwable -> L44
        int i2 = this.mQueriesViaPackage.size() - 1;     // Catch: Throwable -> L44
    L42:
        if (i2 < 0) goto L47;
        this.mQueriesViaPackage.remove(this.mQueriesViaPackage.keyAt(i2), Integer.valueOf(setting.getAppId()));     // Catch: Throwable -> L44
        i2 = i2 - 1;     // Catch: Throwable -> L44
        goto L42
    L47:
        monitor-exit(r3);     // Catch: Throwable -> L44
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        PackageManagerTracedLock r4 = this.mQueryableViaUsesLibraryLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        this.mQueryableViaUsesLibrary.remove(setting.getAppId());     // Catch: Throwable -> L53
        int i3 = this.mQueryableViaUsesLibrary.size() - 1;     // Catch: Throwable -> L53
    L51:
        if (i3 < 0) goto L56;
        this.mQueryableViaUsesLibrary.remove(this.mQueryableViaUsesLibrary.keyAt(i3), Integer.valueOf(setting.getAppId()));     // Catch: Throwable -> L53
        i3 = i3 - 1;     // Catch: Throwable -> L53
        goto L51
    L56:
        monitor-exit(r4);     // Catch: Throwable -> L53
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        PackageManagerTracedLock r5 = this.mQueryableViaUsesPermissionLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
    L71:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L60:
        if (setting.getPkg() == null) goto L75;
        if (setting.getPkg().getPermissions().isEmpty() == true) goto L75;
        Iterator r6 = setting.getPkg().getPermissions().iterator();     // Catch: Throwable -> L71
    L65:
        if (r6.hasNext() == false) goto L75;
        ParsedPermission permission = (ParsedPermission) r6.next();     // Catch: Throwable -> L71
        String permissionName = permission.getName();     // Catch: Throwable -> L71
        if (this.mPermissionToUids.containsKey(permissionName) == false) goto L65;
        this.mPermissionToUids.get(permissionName).remove(Integer.valueOf(setting.getAppId()));     // Catch: Throwable -> L71
        if (this.mPermissionToUids.get(permissionName).isEmpty() == false) goto L65;
        this.mPermissionToUids.remove(permissionName);     // Catch: Throwable -> L71
    L75:
        if (setting.getPkg() != null) goto L77;
    L87:
        this.mQueryableViaUsesPermission.remove(setting.getAppId());     // Catch: Throwable -> L71
        monitor-exit(r5);     // Catch: Throwable -> L71
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        PackageManagerTracedLock r7 = this.mForceQueryableLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r7);
        this.mForceQueryable.remove(Integer.valueOf(setting.getAppId()));     // Catch: Throwable -> L180
        monitor-exit(r7);     // Catch: Throwable -> L180
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        PackageManagerTracedLock r8 = this.mProtectedBroadcastsLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r8);
    L106:
        th = th;
    L177:
        monitor-exit(r8);     // Catch: Throwable -> L106
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L96:
        if (setting.getPkg() != null) goto L98;
    L108:
        boolean protectedBroadcastsChanged = false;
    L213:
        monitor-exit(r8);     // Catch: Throwable -> L175
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (protectedBroadcastsChanged == false) goto L113;
        this.mQueriesViaComponentRequireRecompute.set(true);
    L113:
        ArraySet<String> additionalChangedPackages = this.mOverlayReferenceMapper.removePkg(setting.getPackageName());
        this.mFeatureConfig.updatePackageState(setting, true);
        if (setting.hasSharedUser() == false) goto L116;
        SharedUserApi r9 = snapshot.getSharedUser(setting.getSharedUserAppId());
    L117:
        SharedUserApi sharedUserApi = r9;
        if (sharedUserApi == null) goto L127;
        ArraySet<? extends PackageStateInternal> sharedUserPackages = sharedUserApi.getPackageStates();
        int i4 = sharedUserPackages.size() - 1;
    L120:
        if (i4 < 0) goto L127;
        if (sharedUserPackages.valueAt(i4) == setting) goto L125;
        addPackageInternal(sharedUserPackages.valueAt(i4), settings);
    L125:
        i4 = i4 - 1;
    L127:
        if (this.mCacheReady == false) goto L172;
        removeAppIdFromVisibilityCache(setting.getAppId());
        if (sharedUserApi == null) goto L149;
        ArraySet<? extends PackageStateInternal> sharedUserPackages2 = sharedUserApi.getPackageStates();
        int i5 = sharedUserPackages2.size() - 1;
    L131:
        if (i5 < 0) goto L149;
        PackageStateInternal siblingSetting = sharedUserPackages2.valueAt(i5);
        if (siblingSetting != setting) goto L135;
        i5 = i5 - 1;
        goto L131
    L135:
        PackageManagerTracedLock r10 = this.mCacheLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r10);
        updateShouldFilterCacheForPackage(snapshot, setting.getPackageName(), siblingSetting, settings, users, -1, settings.size());     // Catch: Throwable -> L142
        monitor-exit(r10);     // Catch: Throwable -> L142
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L142:
        th = th;
    L146:
        monitor-exit(r10);     // Catch: Throwable -> L142
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L144:
        th = th;
    L149:
        if (additionalChangedPackages == null) goto L173;
        int index = 0;
    L152:
        if (index >= additionalChangedPackages.size()) goto L173;
        String changedPackage = additionalChangedPackages.valueAt(index);
        PackageStateInternal changedPkgSetting = settings.get(changedPackage);
        if (changedPkgSetting == null) goto L163;
        PackageManagerTracedLock r11 = this.mCacheLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r11);
        PackageManagerTracedLock r16 = r11;
        updateShouldFilterCacheForPackage(snapshot, null, changedPkgSetting, settings, users, -1, settings.size());     // Catch: Throwable -> L164
        monitor-exit(r16);     // Catch: Throwable -> L164
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L164:
        th = th;
    L168:
        monitor-exit(r16);     // Catch: Throwable -> L164
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L166:
        th = th;
        r16 = r11;
    L163:
        index = index + 1;
    L173:
        onChanged();
        return;
    L172:
        invalidateCache("removePackage: " + setting.getPackageName());
        goto L173
    L116:
        r9 = null;
    L175:
        th = th;
        goto L177
    L98:
        if (setting.getPkg().getProtectedBroadcasts().isEmpty() == true) goto L108;
        String removingPackageName = setting.getPkg().getPackageName();     // Catch: Throwable -> L106
        ArrayList<String> protectedBroadcasts = new ArrayList(this.mProtectedBroadcasts.untrackedStorage());     // Catch: Throwable -> L106
        collectProtectedBroadcasts(settings, removingPackageName);     // Catch: Throwable -> L106
        int i6 = 0;
    L101:
        if (i6 >= protectedBroadcasts.size()) goto L108;
        if (this.mProtectedBroadcasts.contains(protectedBroadcasts.get(i6)) == false) goto L104;
        i6 = i6 + 1;
        goto L101
    L104:
        protectedBroadcastsChanged = true;
    L180:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L77:
        if (setting.getPkg().getUsesPermissions().isEmpty() == true) goto L87;
        Iterator r12 = setting.getPkg().getUsesPermissions().iterator();     // Catch: Throwable -> L71
    L80:
        if (r12.hasNext() == false) goto L87;
        ParsedUsesPermission usesPermission = (ParsedUsesPermission) r12.next();     // Catch: Throwable -> L71
        String usesPermissionName = usesPermission.getName();     // Catch: Throwable -> L71
        if (this.mUsesPermissionToUids.containsKey(usesPermissionName) == false) goto L80;
        this.mUsesPermissionToUids.get(usesPermissionName).remove(Integer.valueOf(setting.getAppId()));     // Catch: Throwable -> L71
        if (this.mUsesPermissionToUids.get(usesPermissionName).isEmpty() == false) goto L80;
        this.mUsesPermissionToUids.remove(usesPermissionName);     // Catch: Throwable -> L71
    L53:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L44:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L5:
        PackageManagerTracedLock r13 = this.mImplicitlyQueryableLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r13);
        int u = 0;
    L8:
        if (u >= userCount) goto L22;
        int userId = users[u].id;     // Catch: Throwable -> L12
        int removingUid = UserHandle.getUid(userId, setting.getAppId());     // Catch: Throwable -> L12
        this.mImplicitlyQueryable.remove(removingUid);     // Catch: Throwable -> L12
        int i7 = this.mImplicitlyQueryable.size() - 1;     // Catch: Throwable -> L12
    L10:
        if (i7 < 0) goto L15;
        this.mImplicitlyQueryable.remove(this.mImplicitlyQueryable.keyAt(i7), Integer.valueOf(removingUid));     // Catch: Throwable -> L12
        i7 = i7 - 1;     // Catch: Throwable -> L12
        goto L10
    L15:
        if (isReplace == true) goto L20;
        this.mRetainedImplicitlyQueryable.remove(removingUid);     // Catch: Throwable -> L12
        int i8 = this.mRetainedImplicitlyQueryable.size() - 1;     // Catch: Throwable -> L12
    L18:
        if (i8 < 0) goto L20;
        this.mRetainedImplicitlyQueryable.remove(this.mRetainedImplicitlyQueryable.keyAt(i8), Integer.valueOf(removingUid));     // Catch: Throwable -> L12
        i8 = i8 - 1;     // Catch: Throwable -> L12
    L20:
        u = u + 1;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L22:
        monitor-exit(r13);     // Catch: Throwable -> L12
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        goto L25
    }

    private static boolean pkgInstruments(AndroidPackage source, AndroidPackage target) {
        String packageName = target.getPackageName();     // Catch: Throwable -> L8
        List<ParsedInstrumentation> inst = source.getInstrumentations();     // Catch: Throwable -> L8
        int i = ArrayUtils.size(inst) - 1;     // Catch: Throwable -> L8
    L3:
        if (i < 0) goto L10;
        if (Objects.equals(inst.get(i).getTargetPackage(), packageName) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L10:
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    private void logCacheRebuilt(int eventId, long latency, int userCount, int packageCount) {
        FrameworkStatsLog.write(FrameworkStatsLog.PACKAGE_MANAGER_APPS_FILTER_CACHE_BUILD_REPORTED, eventId, latency, userCount, packageCount, this.mShouldFilterCache.size());
    }

    private void logCacheUpdated(int eventId, long latency, int userCount, int packageCount, int appId) {
        if (this.mCacheReady == true) goto L5;
        return;
    L5:
        FrameworkStatsLog.write(FrameworkStatsLog.PACKAGE_MANAGER_APPS_FILTER_CACHE_UPDATE_REPORTED, eventId, appId, latency, userCount, packageCount, this.mShouldFilterCache.size());
    }
}
