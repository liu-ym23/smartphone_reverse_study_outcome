package com.android.server.pm;

import android.content.pm.SigningDetails;
import android.os.Binder;
import android.os.Handler;
import android.os.Process;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.util.function.QuadFunction;
import com.android.server.om.OverlayReferenceMapper;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.SharedUserApi;
import com.android.server.pm.snapshot.PackageDataSnapshot;
import com.android.server.utils.SnapshotCache;
import com.android.server.utils.Watched;
import com.android.server.utils.WatchedArrayMap;
import com.android.server.utils.WatchedArraySet;
import com.android.server.utils.WatchedSparseBooleanMatrix;
import com.android.server.utils.WatchedSparseSetArray;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppsFilterBase implements AppsFilterSnapshot {
    protected static final boolean CACHE_INVALID = false;
    protected static final int CACHE_REBUILD_DELAY_MAX_MS = 10000;
    protected static final int CACHE_REBUILD_DELAY_MIN_MS = 10000;
    protected static final boolean CACHE_VALID = true;
    protected static final boolean DEBUG_ALLOW_ALL = false;
    protected static final boolean DEBUG_LOGGING = false;
    public static final boolean DEBUG_TRACING = false;
    protected static final String TAG = "AppsFilter";
    protected volatile boolean mCacheEnabled;
    protected volatile boolean mCacheReady;
    protected final AtomicBoolean mCacheValid;
    protected FeatureConfig mFeatureConfig;

    @Watched
    protected WatchedArraySet<Integer> mForceQueryable;
    protected String[] mForceQueryableByDevicePackageNames;
    protected SnapshotCache<WatchedArraySet<Integer>> mForceQueryableSnapshot;
    protected Handler mHandler;
    protected SnapshotCache<WatchedSparseSetArray<Integer>> mImplicitQueryableSnapshot;

    @Watched
    protected WatchedSparseSetArray<Integer> mImplicitlyQueryable;
    protected volatile boolean mNeedToUpdateCacheForImplicitAccess;
    protected OverlayReferenceMapper mOverlayReferenceMapper;

    @Watched
    protected WatchedArraySet<String> mProtectedBroadcasts;
    protected SnapshotCache<WatchedArraySet<String>> mProtectedBroadcastsSnapshot;

    @Watched
    protected WatchedSparseSetArray<Integer> mQueriesViaComponent;
    protected AtomicBoolean mQueriesViaComponentRequireRecompute;
    protected SnapshotCache<WatchedSparseSetArray<Integer>> mQueriesViaComponentSnapshot;

    @Watched
    protected WatchedSparseSetArray<Integer> mQueriesViaPackage;
    protected SnapshotCache<WatchedSparseSetArray<Integer>> mQueriesViaPackageSnapshot;

    @Watched
    protected WatchedSparseSetArray<Integer> mQueryableViaUsesLibrary;
    protected SnapshotCache<WatchedSparseSetArray<Integer>> mQueryableViaUsesLibrarySnapshot;

    @Watched
    protected WatchedSparseSetArray<Integer> mQueryableViaUsesPermission;
    protected SnapshotCache<WatchedSparseSetArray<Integer>> mQueryableViaUsesPermissionSnapshot;

    @Watched
    protected WatchedSparseSetArray<Integer> mRetainedImplicitlyQueryable;
    protected SnapshotCache<WatchedSparseSetArray<Integer>> mRetainedImplicitlyQueryableSnapshot;

    @Watched
    protected WatchedSparseBooleanMatrix mShouldFilterCache;
    protected SnapshotCache<WatchedSparseBooleanMatrix> mShouldFilterCacheSnapshot;
    protected boolean mSystemAppsQueryable;
    protected SigningDetails mSystemSigningDetails;

    protected interface ToString<T> {
        String toString(T r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$EzD-3Qgs3agQ0FfI--Dk-PGWLFc, reason: not valid java name */
    public static /* synthetic */ String m6601$r8$lambda$EzD3Qgs3agQ0FfIDkPGWLFc(SparseArray r0, int[] r1, QuadFunction r2, Integer r3) {
        return lambda$dumpQueries$0(r0, r1, r2, r3);
    }

    public AppsFilterBase() {
        this.mQueriesViaComponentRequireRecompute = new AtomicBoolean(false);
        this.mCacheReady = false;
        this.mCacheEnabled = true;
        this.mNeedToUpdateCacheForImplicitAccess = false;
        this.mCacheValid = new AtomicBoolean(false);
    }

    protected boolean isForceQueryable(int callingAppId) {
        return this.mForceQueryable.contains(Integer.valueOf(callingAppId));
    }

    protected boolean isQueryableViaPackage(int callingAppId, int targetAppId) {
        return this.mQueriesViaPackage.contains(callingAppId, Integer.valueOf(targetAppId));
    }

    protected boolean isQueryableViaComponent(int callingAppId, int targetAppId) {
        return this.mQueriesViaComponent.contains(callingAppId, Integer.valueOf(targetAppId));
    }

    protected boolean isImplicitlyQueryable(int callingUid, int targetUid) {
        return this.mImplicitlyQueryable.contains(callingUid, Integer.valueOf(targetUid));
    }

    protected boolean isRetainedImplicitlyQueryable(int callingUid, int targetUid) {
        return this.mRetainedImplicitlyQueryable.contains(callingUid, Integer.valueOf(targetUid));
    }

    protected boolean isQueryableViaUsesLibrary(int callingAppId, int targetAppId) {
        return this.mQueryableViaUsesLibrary.contains(callingAppId, Integer.valueOf(targetAppId));
    }

    protected boolean isQueryableViaUsesPermission(int callingAppId, int targetAppId) {
        return this.mQueryableViaUsesPermission.contains(callingAppId, Integer.valueOf(targetAppId));
    }

    protected boolean isQueryableViaComponentWhenRequireRecompute(ArrayMap<String, ? extends PackageStateInternal> existingSettings, PackageStateInternal callingPkgSetting, ArraySet<PackageStateInternal> callingSharedPkgSettings, AndroidPackage targetPkg, int callingAppId, int targetAppId) {
        if (callingPkgSetting != null) goto L5;
        int i = callingSharedPkgSettings.size() - 1;
    L10:
        if (i < 0) goto L24;
        AndroidPackageInternal r2 = callingSharedPkgSettings.valueAt(i).getPkg();
        if (r2 == null) goto L16;
        if (AppsFilterUtils.canQueryViaComponents(r2, targetPkg, this.mProtectedBroadcasts) == false) goto L16;
        return true;
    L16:
        i = i - 1;
        goto L10
    L24:
        return false;
    L5:
        if (callingPkgSetting.getPkg() != null) goto L7;
        return false;
    L7:
        if (AppsFilterUtils.canQueryViaComponents(callingPkgSetting.getPkg(), targetPkg, this.mProtectedBroadcasts) == false) goto L23;
        return true;
    L23:
        return false;
    }

    @Override // com.android.server.pm.AppsFilterSnapshot
    public SparseArray<int[]> getVisibilityAllowList(PackageDataSnapshot snapshot, PackageStateInternal setting, int[] users, ArrayMap<String, ? extends PackageStateInternal> existingSettings) {
        int[] r0 = users;
        AppsFilterBase r2 = this;
        if (r2.isForceQueryable(setting.getAppId()) == false) goto L6;
        return null;
    L6:
        SparseArray<int[]> result = new SparseArray(r0.length);
        int u = 0;
    L8:
        if (u >= r0.length) goto L25;
        int userId = r0[u];
        int[] appIds = new int[existingSettings.size()];
        int[] buffer = null;
        int allowListSize = 0;
        int i = existingSettings.size() - 1;
    L10:
        if (i < 0) goto L23;
        PackageStateInternal existingSetting = existingSettings.valueAt(i);
        int existingAppId = existingSetting.getAppId();
        if (existingAppId < 10000) goto L22;
        int loc = Arrays.binarySearch(appIds, 0, allowListSize, existingAppId);
        if (loc >= 0) goto L22;
        int existingUid = UserHandle.getUid(userId, existingAppId);
        if (r2.shouldFilterApplication(snapshot, existingUid, existingSetting, setting, userId) == true) goto L22;
        if (buffer != null) goto L21;
        buffer = new int[appIds.length];
    L21:
        int insert = ~loc;
        System.arraycopy(appIds, insert, buffer, 0, allowListSize - insert);
        appIds[insert] = existingAppId;
        System.arraycopy(buffer, 0, appIds, insert + 1, allowListSize - insert);
        allowListSize = allowListSize + 1;
    L22:
        i = i - 1;
        r2 = this;
        goto L10
    L23:
        result.put(userId, Arrays.copyOf(appIds, allowListSize));
        u = u + 1;
        r2 = this;
        r0 = users;
        goto L8
    L25:
        return result;
    }

    SparseArray<int[]> getVisibilityAllowList(PackageDataSnapshot snapshot, PackageStateInternal setting, int[] users, WatchedArrayMap<String, ? extends PackageStateInternal> existingSettings) {
        return getVisibilityAllowList(snapshot, setting, users, existingSettings.untrackedStorage());
    }

    private static boolean isQueryableBySdkSandbox(int callingUid, int targetUid) {
        if (targetUid != Process.getAppUidForSdkSandboxUid(callingUid)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.pm.AppsFilterSnapshot
    public boolean shouldFilterApplication(PackageDataSnapshot snapshot, int callingUid, Object callingSetting, PackageStateInternal targetPkgSetting, int userId) {
        int callingAppId = UserHandle.getAppId(callingUid);     // Catch: Throwable -> L43
        if (callingAppId < 10000) goto L47;
        if (targetPkgSetting.getAppId() < 10000) goto L47;
        if (callingAppId == targetPkgSetting.getAppId()) goto L47;
        if (Process.isSdkSandboxUid(callingAppId) == false) goto L24;
        int targetAppId = targetPkgSetting.getAppId();     // Catch: Throwable -> L19
        int targetUid = UserHandle.getUid(userId, targetAppId);     // Catch: Throwable -> L19
        if (isForceQueryable(targetPkgSetting.getAppId()) == false) goto L15;
        return false;
    L15:
        if (isImplicitlyQueryable(callingUid, targetUid) == false) goto L17;
        return false;
    L17:
        if (isQueryableBySdkSandbox(callingUid, targetUid) == false) goto L22;
        return false;
    L22:
        return true;
    L24:
        if (this.mCacheReady == true) goto L26;
    L31:
        AppsFilterBase r4 = this;
        Object callingSetting2 = callingSetting;
        PackageStateInternal targetPkgSetting2 = targetPkgSetting;
    L40:
        th = move-exception;
        throw th;
    L34:
        if (r4.shouldFilterApplicationInternal((Computer) snapshot, callingUid, callingSetting2, targetPkgSetting2, userId) == true) goto L37;
        return false;
    L37:
        if (r4.mFeatureConfig.isLoggingEnabled(callingAppId) == false) goto L42;
        log(callingSetting2, targetPkgSetting2, "BLOCKED");     // Catch: Throwable -> L40
    L42:
        return true;
    L26:
        if (this.mCacheEnabled == false) goto L31;
        if (shouldFilterApplicationUsingCache(callingUid, targetPkgSetting.getAppId(), userId) == true) goto L30;
        return false;
    L30:
        r4 = this;
        callingSetting2 = callingSetting;
        targetPkgSetting2 = targetPkgSetting;
    L19:
        th = move-exception;
        throw th;
    L47:
        return false;
    L43:
        th = move-exception;
        throw th;
    }

    protected boolean shouldFilterApplicationUsingCache(int callingUid, int appId, int userId) {
        int callingIndex = this.mShouldFilterCache.indexOfKey(callingUid);
        if (callingIndex >= 0) goto L6;
        Slog.wtf(TAG, "Encountered calling uid with no cached rules: " + callingUid);
        return true;
    L6:
        int targetUid = UserHandle.getUid(userId, appId);
        int targetIndex = this.mShouldFilterCache.indexOfKey(targetUid);
        if (targetIndex >= 0) goto L11;
        Slog.w(TAG, "Encountered calling -> target with no cached rules: " + callingUid + " -> " + targetUid);
        return true;
    L11:
        return this.mShouldFilterCache.valueAt(callingIndex, targetIndex);
    }

    protected boolean shouldFilterApplicationInternal(Computer snapshot, int callingUid, Object callingSetting, PackageStateInternal targetPkgSetting, int targetUserId) {
        boolean featureEnabled = this.mFeatureConfig.isGloballyEnabled();     // Catch: Throwable -> L10
        boolean r0 = false;
        if (featureEnabled == true) goto L6;
        return false;
    L6:
        boolean r12 = true;
        if (callingSetting != null) goto L12;
        Slog.wtf(TAG, "No setting found for non system uid " + callingUid);     // Catch: Throwable -> L10
        return true;
    L12:
        int callingAppId = UserHandle.getAppId(callingUid);     // Catch: Throwable -> L10
        int targetAppId = targetPkgSetting.getAppId();     // Catch: Throwable -> L10
        if (callingAppId == targetAppId) goto L140;
        if (callingAppId < 10000) goto L140;
        if (targetAppId < 10000) goto L169;
        ArraySet<PackageStateInternal> callingSharedPkgSettings = new ArraySet();     // Catch: Throwable -> L10
        if ((callingSetting instanceof PackageStateInternal) == false) goto L32;
        PackageStateInternal packageState = (PackageStateInternal) callingSetting;     // Catch: Throwable -> L10
        if (packageState.hasSharedUser() == false) goto L30;
        PackageStateInternal callingPkgSetting = null;
        Computer r13 = snapshot;
        SharedUserApi sharedUserApi = r13.getSharedUser(packageState.getSharedUserAppId());     // Catch: Throwable -> L27
        if (sharedUserApi == null) goto L33;
        callingSharedPkgSettings.addAll(sharedUserApi.getPackageStates());     // Catch: Throwable -> L27
    L33:
        if (callingPkgSetting != null) goto L35;
        int i = callingSharedPkgSettings.size() - 1;     // Catch: Throwable -> L27
    L40:
        if (i < 0) goto L154;
        AndroidPackage pkg = callingSharedPkgSettings.valueAt(i).getPkg();     // Catch: Throwable -> L27
        if (pkg == null) goto L46;
        if (this.mFeatureConfig.packageIsEnabled(pkg) == true) goto L46;
        return false;
    L46:
        i = i - 1;
    L154:
        if (callingPkgSetting != null) goto L49;
        int i2 = callingSharedPkgSettings.size() - 1;     // Catch: Throwable -> L53
    L56:
        if (i2 < 0) goto L64;
        AndroidPackageInternal r5 = callingSharedPkgSettings.valueAt(i2).getPkg();     // Catch: Throwable -> L53
        if (r5 == null) goto L62;
        if (AppsFilterUtils.requestsQueryAllPackages(r5) == false) goto L62;
        return false;
    L62:
        i2 = i2 - 1;
    L64:
        AndroidPackageInternal r6 = targetPkgSetting.getPkg();     // Catch: Throwable -> L27
        if (r6 != null) goto L68;
        return true;
    L68:
        if (r6.isStaticSharedLibrary() == false) goto L145;
        return false;
    L145:
        if (isForceQueryable(targetAppId) == false) goto L157;
        return false;
    L157:
        if (isQueryableViaPackage(callingAppId, targetAppId) == false) goto L153;
        return false;
    L153:
    L83:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L79:
        if (this.mQueriesViaComponentRequireRecompute.get() == true) goto L86;
        if (isQueryableViaComponent(callingAppId, targetAppId) == false) goto L151;
        return false;
    L151:
        int targetUid = UserHandle.getUid(targetUserId, targetAppId);     // Catch: Throwable -> L129
        if (isImplicitlyQueryable(callingUid, targetUid) == false) goto L149;
        return false;
    L149:
        int targetUid2 = UserHandle.getUid(targetUserId, targetAppId);     // Catch: Throwable -> L127
        if (isRetainedImplicitlyQueryable(callingUid, targetUid2) == false) goto L148;
        return false;
    L148:
        String targetName = r6.getPackageName();     // Catch: Throwable -> L105
        if (callingSharedPkgSettings.isEmpty() == true) goto L108;
        int size = callingSharedPkgSettings.size();     // Catch: Throwable -> L105
        int index = 0;
    L100:
        if (index >= size) goto L107;
        PackageStateInternal pkgSetting = callingSharedPkgSettings.valueAt(index);     // Catch: Throwable -> L105
        boolean r17 = r0;
        boolean r18 = r12;
        if (this.mOverlayReferenceMapper.isValidActor(targetName, pkgSetting.getPackageName()) == true) goto L103;
        index = index + 1;     // Catch: Throwable -> L105
        r0 = r17;
        r12 = r18;
        goto L100
    L103:
        return r17;
    L107:
        boolean r19 = r0;
        boolean r110 = r12;
    L143:
        if (isQueryableViaUsesLibrary(callingAppId, targetAppId) == false) goto L155;
        return r19;
    L155:
        if (isQueryableViaUsesPermission(callingAppId, targetAppId) == false) goto L120;
        return r19;
    L120:
        return r110;
    L121:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L123:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L108:
        r19 = false;
        r110 = true;
        if (this.mOverlayReferenceMapper.isValidActor(targetName, callingPkgSetting.getPackageName()) == false) goto L143;
        return false;
    L105:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L127:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L129:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L86:
        if (isQueryableViaComponentWhenRequireRecompute(r13.getPackageStates(), callingPkgSetting, callingSharedPkgSettings, r6, callingAppId, targetAppId) == false) goto L151;
        return false;
    L133:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L135:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L49:
        if (callingPkgSetting.getPkg() == null) goto L64;
        if (AppsFilterUtils.requestsQueryAllPackages(callingPkgSetting.getPkg()) == false) goto L64;
        return false;
    L53:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L35:
        if (callingPkgSetting.getPkg() == null) goto L154;
        if (this.mFeatureConfig.packageIsEnabled(callingPkgSetting.getPkg()) == true) goto L154;
        return false;
    L30:
        r13 = snapshot;
        callingPkgSetting = packageState;
        goto L33
    L32:
        r13 = snapshot;
        callingPkgSetting = null;
        callingSharedPkgSettings.addAll(((SharedUserSetting) callingSetting).getPackageStates());     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L169:
        return false;
    L140:
        return false;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.AppsFilterSnapshot
    public boolean canQueryPackage(AndroidPackage querying, String potentialTarget) {
        int appId = UserHandle.getAppId(querying.getUid());
        if (appId >= 10000) goto L6;
        return true;
    L6:
        if (this.mFeatureConfig.packageIsEnabled(querying) == true) goto L9;
        return true;
    L9:
        if (AppsFilterUtils.requestsQueryAllPackages(querying) == false) goto L12;
        return true;
    L12:
        if (querying.getQueriesPackages().isEmpty() == false) goto L14;
    L16:
        return false;
    L14:
        if (querying.getQueriesPackages().contains(potentialTarget) == false) goto L16;
        return true;
    }

    private static void log(Object callingSetting, PackageStateInternal targetPkgSetting, String description) {
        StringBuilder r0 = new StringBuilder();
        r0.append("interaction: ");
        if (callingSetting != null) goto L5;
        Object r1 = "system";
    L6:
        r0.append(r1);
        r0.append(" -> ");
        r0.append(targetPkgSetting);
        r0.append(" ");
        r0.append(description);
        Slog.i(TAG, r0.toString());
        return;
    L5:
        r1 = callingSetting;
        goto L6
    }

    @Override // com.android.server.pm.AppsFilterSnapshot
    public void dumpQueries(PrintWriter pw, Integer filteringAppId, DumpState dumpState, final int[] users, final QuadFunction<Integer, Integer, Integer, Boolean, String[]> getPackagesForUid) {
        final SparseArray<String> cache = new SparseArray();
        ToString<Integer> expandPackages = new AppsFilterBase$$ExternalSyntheticLambda0(cache, users, getPackagesForUid);
        pw.println();
        pw.println("Queries:");
        dumpState.onTitlePrinted();
        if (this.mFeatureConfig.isGloballyEnabled() == true) goto L6;
        pw.println("  DISABLED");
        return;
    L6:
        pw.println("  system apps queryable: " + this.mSystemAppsQueryable);
        dumpForceQueryable(pw, filteringAppId, expandPackages);
        dumpQueriesViaPackage(pw, filteringAppId, expandPackages);
        dumpQueriesViaComponent(pw, filteringAppId, expandPackages);
        dumpQueriesViaImplicitlyQueryable(pw, filteringAppId, users, expandPackages);
        dumpQueriesViaUsesLibrary(pw, filteringAppId, expandPackages);
    }

    private static /* synthetic */ String lambda$dumpQueries$0(SparseArray cache, int[] users, QuadFunction getPackagesForUid, Integer input) {
        String cachedValue = (String) cache.get(input.intValue());
        if (cachedValue != null) goto L17;
        int callingUid = Binder.getCallingUid();
        int appId = UserHandle.getAppId(input.intValue());
        String[] packagesForUid = null;
        int i = 0;
        int size = users.length;
    L6:
        if (packagesForUid != null) goto L9;
        if (i >= size) goto L9;
        packagesForUid = (String[]) getPackagesForUid.apply(Integer.valueOf(callingUid), Integer.valueOf(users[i]), Integer.valueOf(appId), false);
        i = i + 1;
    L9:
        if (packagesForUid != null) goto L12;
        cachedValue = "[app id " + input + " not installed]";
    L16:
        cache.put(input.intValue(), cachedValue);
        goto L17
    L12:
        if (packagesForUid.length != 1) goto L14;
        String r4 = packagesForUid[0];
    L15:
        cachedValue = r4;
        goto L16
    L14:
        r4 = "[" + TextUtils.join(",", packagesForUid) + "]";
    L17:
        return cachedValue;
    }

    protected void dumpForceQueryable(PrintWriter pw, Integer filteringAppId, ToString<Integer> expandPackages) {
        pw.println("  queries via forceQueryable:");
        dumpPackageSet(pw, filteringAppId, this.mForceQueryable.untrackedStorage(), "forceQueryable", "  ", expandPackages);
    }

    protected void dumpQueriesViaPackage(PrintWriter pw, Integer filteringAppId, ToString<Integer> expandPackages) {
        pw.println("  queries via package name:");
        dumpQueriesMap(pw, filteringAppId, this.mQueriesViaPackage, "    ", expandPackages);
    }

    protected void dumpQueriesViaComponent(PrintWriter pw, Integer filteringAppId, ToString<Integer> expandPackages) {
        pw.println("  queries via component:");
        dumpQueriesMap(pw, filteringAppId, this.mQueriesViaComponent, "    ", expandPackages);
    }

    protected void dumpQueriesViaImplicitlyQueryable(PrintWriter pw, Integer filteringAppId, int[] users, ToString<Integer> expandPackages) {
        pw.println("  queryable via interaction:");
        int r0 = users.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        int user = users[r1];
        pw.append("    User ").append(Integer.toString(user)).println(":");
        Integer r3 = null;
        if (filteringAppId != null) goto L7;
        Integer r4 = null;
    L8:
        dumpQueriesMap(pw, r4, this.mImplicitlyQueryable, "      ", expandPackages);
        if (filteringAppId == null) goto L12;
        r3 = Integer.valueOf(UserHandle.getUid(user, filteringAppId.intValue()));
    L12:
        dumpQueriesMap(pw, r3, this.mRetainedImplicitlyQueryable, "      ", expandPackages);
        r1 = r1 + 1;
        goto L3
    L7:
        r4 = Integer.valueOf(UserHandle.getUid(user, filteringAppId.intValue()));
        goto L8
    }

    protected void dumpQueriesViaUsesLibrary(PrintWriter pw, Integer filteringAppId, ToString<Integer> expandPackages) {
        pw.println("  queryable via uses-library:");
        dumpQueriesMap(pw, filteringAppId, this.mQueryableViaUsesLibrary, "    ", expandPackages);
    }

    protected void dumpQueriesViaUsesPermission(PrintWriter pw, Integer filteringAppId, ToString<Integer> expandPackages) {
        pw.println("  queryable via uses-permission:");
        dumpQueriesMap(pw, filteringAppId, this.mQueryableViaUsesPermission, "    ", expandPackages);
    }

    private static void dumpQueriesMap(PrintWriter pw, Integer filteringId, WatchedSparseSetArray<Integer> queriesMap, String spacing, ToString<Integer> toString) {
        int i = 0;
    L4:
        if (i >= queriesMap.size()) goto L19;
        Integer callingId = Integer.valueOf(queriesMap.keyAt(i));
        if (Objects.equals(callingId, filteringId) == false) goto L12;
        ArraySet<Integer> r2 = queriesMap.get(callingId.intValue());
        if (toString != null) goto L10;
        String r3 = callingId.toString();
    L11:
        dumpPackageSet(pw, null, r2, r3, spacing, toString);
    L17:
        i = i + 1;
        goto L4
    L10:
        r3 = toString.toString(callingId);
        goto L11
    L12:
        ArraySet<Integer> r4 = queriesMap.get(callingId.intValue());
        if (toString != null) goto L15;
        String r5 = callingId.toString();
    L16:
        dumpPackageSet(pw, filteringId, r4, r5, spacing, toString);
        goto L17
    L15:
        r5 = toString.toString(callingId);
        goto L16
    }

    private static <T> void dumpPackageSet(PrintWriter pw, T filteringId, ArraySet<T> targetPkgSet, String subTitle, String spacing, ToString<T> toString) {
        if (targetPkgSet != null) goto L4;
        return;
    L4:
        if (targetPkgSet.size() <= 0) goto L28;
        if (filteringId != null) goto L7;
    L8:
        pw.append(spacing).append(subTitle).println(":");
        Iterator<T> r0 = targetPkgSet.iterator();
    L10:
        if (r0.hasNext() == false) goto L30;
        T item = r0.next();
        if (filteringId == null) goto L15;
        if (Objects.equals(filteringId, item) == false) goto L10;
    L15:
        PrintWriter r2 = pw.append(spacing).append("  ");
        if (toString != null) goto L18;
        Object r3 = item;
    L19:
        r2.println(r3);
        goto L10
    L18:
        r3 = toString.toString(item);
        goto L19
    L30:
        return;
    L7:
        if (targetPkgSet.contains(filteringId) == true) goto L8;
        return;
    }
}
