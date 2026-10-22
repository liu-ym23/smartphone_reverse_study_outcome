package com.android.server.pm;

import android.content.pm.SharedLibraryInfo;
import android.content.pm.Signature;
import android.content.pm.SigningDetails;
import android.content.pm.VersionedPackage;
import android.content.pm.parsing.PackageLite;
import android.os.storage.StorageManager;
import android.util.ArraySet;
import android.util.PackageUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.internal.util.ArrayUtils;
import com.android.server.SystemConfig;
import com.android.server.compat.PlatformCompat;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.utils.Snappable;
import com.android.server.utils.SnapshotCache;
import com.android.server.utils.Watchable;
import com.android.server.utils.WatchableImpl;
import com.android.server.utils.Watched;
import com.android.server.utils.WatchedArrayMap;
import com.android.server.utils.WatchedLongSparseArray;
import com.android.server.utils.Watcher;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import libcore.util.HexEncoding;

/* JADX INFO: loaded from: classes2.dex */
public final class SharedLibrariesImpl implements SharedLibrariesRead, Watchable, Snappable {
    private static final boolean DEBUG_SHARED_LIBRARIES = false;
    private static final long ENFORCE_NATIVE_SHARED_LIBRARY_DEPENDENCIES = 142191088;
    private static final String LIBRARY_TYPE_SDK = "sdk";
    private static final String LIBRARY_TYPE_STATIC = "static shared";
    private DeletePackageHelper mDeletePackageHelper;
    private final PackageManagerServiceInjector mInjector;
    private final Watcher mObserver;
    private final PackageManagerService mPm;

    @Watched
    private final WatchedArrayMap<String, WatchedLongSparseArray<SharedLibraryInfo>> mSharedLibraries;
    private final SnapshotCache<WatchedArrayMap<String, WatchedLongSparseArray<SharedLibraryInfo>>> mSharedLibrariesSnapshot;
    private final SnapshotCache<SharedLibrariesImpl> mSnapshot;

    @Watched
    private final WatchedArrayMap<String, WatchedLongSparseArray<SharedLibraryInfo>> mStaticLibsByDeclaringPackage;
    private final SnapshotCache<WatchedArrayMap<String, WatchedLongSparseArray<SharedLibraryInfo>>> mStaticLibsByDeclaringPackageSnapshot;
    private final WatchableImpl mWatchable;

    public static /* synthetic */ void $r8$lambda$x5pbt1IWAO8LsYjbRIDnwkV8JxE(SharedLibraryInfo r0, SharedLibraryInfo r1) {
        lambda$executeSharedLibrariesUpdateLPw$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWatchable, reason: not valid java name */
    static /* bridge */ /* synthetic */ WatchableImpl m6898$$Nest$fgetmWatchable(SharedLibrariesImpl r0) {
        return r0.mWatchable;
    }

    /* synthetic */ SharedLibrariesImpl(SharedLibrariesImpl r1, SharedLibrariesImplIA r2) {
        this(r1);
    }

    @Override // com.android.server.utils.Snappable
    public /* bridge */ /* synthetic */ Object snapshot() {
        return snapshot();
    }

    private SnapshotCache<SharedLibrariesImpl> makeCache() {
        return new AnonymousClass2(this, this, this);
    }

    SharedLibrariesImpl(PackageManagerService pm, PackageManagerServiceInjector injector) {
        this.mWatchable = new WatchableImpl();
        this.mObserver = new AnonymousClass1(this);
        this.mPm = pm;
        this.mInjector = injector;
        this.mSharedLibraries = new WatchedArrayMap();
        this.mSharedLibrariesSnapshot = new SnapshotCache.Auto(this.mSharedLibraries, this.mSharedLibraries, "SharedLibrariesImpl.mSharedLibraries");
        this.mStaticLibsByDeclaringPackage = new WatchedArrayMap();
        this.mStaticLibsByDeclaringPackageSnapshot = new SnapshotCache.Auto(this.mStaticLibsByDeclaringPackage, this.mStaticLibsByDeclaringPackage, "SharedLibrariesImpl.mStaticLibsByDeclaringPackage");
        registerObservers();
        Watchable.verifyWatchedAttributes(this, this.mObserver);
        this.mSnapshot = makeCache();
    }

    void setDeletePackageHelper(DeletePackageHelper deletePackageHelper) {
        this.mDeletePackageHelper = deletePackageHelper;
    }

    private void registerObservers() {
        this.mSharedLibraries.registerObserver(this.mObserver);
        this.mStaticLibsByDeclaringPackage.registerObserver(this.mObserver);
    }

    private SharedLibrariesImpl(SharedLibrariesImpl source) {
        this.mWatchable = new WatchableImpl();
        this.mObserver = new AnonymousClass1(this);
        this.mPm = source.mPm;
        this.mInjector = source.mInjector;
        this.mSharedLibraries = source.mSharedLibrariesSnapshot.snapshot();
        this.mSharedLibrariesSnapshot = new SnapshotCache.Sealed();
        this.mStaticLibsByDeclaringPackage = source.mStaticLibsByDeclaringPackageSnapshot.snapshot();
        this.mStaticLibsByDeclaringPackageSnapshot = new SnapshotCache.Sealed();
        this.mSnapshot = new SnapshotCache.Sealed();
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

    @Override // com.android.server.utils.Snappable
    public SharedLibrariesRead snapshot() {
        return this.mSnapshot.snapshot();
    }

    @Override // com.android.server.pm.SharedLibrariesRead
    public WatchedArrayMap<String, WatchedLongSparseArray<SharedLibraryInfo>> getAll() {
        return this.mSharedLibraries;
    }

    @Override // com.android.server.pm.SharedLibrariesRead
    public WatchedLongSparseArray<SharedLibraryInfo> getSharedLibraryInfos(String libName) {
        PackageManagerTracedLock r0 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        WatchedLongSparseArray<SharedLibraryInfo> r1 = this.mSharedLibraries.get(libName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public WatchedArrayMap<String, WatchedLongSparseArray<SharedLibraryInfo>> getSharedLibraries() {
        return this.mSharedLibraries;
    }

    @Override // com.android.server.pm.SharedLibrariesRead
    public SharedLibraryInfo getSharedLibraryInfo(String libName, long version) {
        WatchedLongSparseArray<SharedLibraryInfo> versionedLib = this.mSharedLibraries.get(libName);
        if (versionedLib != null) goto L7;
        return null;
    L7:
        return versionedLib.get(version);
    }

    @Override // com.android.server.pm.SharedLibrariesRead
    public WatchedLongSparseArray<SharedLibraryInfo> getStaticLibraryInfos(String declaringPackageName) {
        return this.mStaticLibsByDeclaringPackage.get(declaringPackageName);
    }

    private PackageStateInternal getLibraryPackage(Computer computer, SharedLibraryInfo libInfo) {
        VersionedPackage declaringPackage = libInfo.getDeclaringPackage();
        if (libInfo.isStatic() == false) goto L7;
        String internalPackageName = computer.resolveInternalPackageName(declaringPackage.getPackageName(), declaringPackage.getLongVersionCode());
        return computer.getPackageStateInternal(internalPackageName);
    L7:
        if (libInfo.isSdk() == true) goto L9;
        return null;
    L9:
        return computer.getPackageStateInternal(declaringPackage.getPackageName());
    }

    boolean pruneUnusedStaticSharedLibraries(Computer computer, long neededSpace, long maxCachePeriod) throws IOException {
        StorageManager storage = (StorageManager) this.mInjector.getSystemService(StorageManager.class);
        File volume = storage.findPathForUuid(StorageManager.UUID_PRIVATE_INTERNAL);
        ArrayList<VersionedPackage> packagesToDelete = new ArrayList();
        long now = System.currentTimeMillis();
        WatchedArrayMap<String, WatchedLongSparseArray<SharedLibraryInfo>> sharedLibraries = computer.getSharedLibraries();
        int libCount = sharedLibraries.size();
        int i = 0;
    L3:
        if (i >= libCount) goto L22;
        WatchedLongSparseArray<SharedLibraryInfo> versionedLib = sharedLibraries.valueAt(i);
        if (versionedLib == null) goto L21;
        int versionCount = versionedLib.size();
        int j = 0;
    L8:
        if (j >= versionCount) goto L21;
        SharedLibraryInfo libInfo = versionedLib.valueAt(j);
        PackageStateInternal ps = getLibraryPackage(computer, libInfo);
        if (ps != null) goto L13;
    L19:
        j = j + 1;
        storage = storage;
        now = now;
        goto L8
    L13:
        if ((now - ps.getLastUpdateTime()) < maxCachePeriod) goto L19;
        if (ps.isSystem() == true) goto L19;
        String r1 = ps.getPkg().getPackageName();
        long now2 = libInfo.getDeclaringPackage().getLongVersionCode();
        packagesToDelete.add(new VersionedPackage(r1, now2));
    L21:
        i = i + 1;
        storage = storage;
        now = now;
        goto L3
    L22:
        int packageCount = packagesToDelete.size();
        int i2 = 0;
    L23:
        if (i2 >= packageCount) goto L30;
        VersionedPackage pkgToDelete = packagesToDelete.get(i2);
        if (this.mDeletePackageHelper.deletePackageX(pkgToDelete.getPackageName(), pkgToDelete.getLongVersionCode(), 0, 2, true) != 1) goto L29;
        if (volume.getUsableSpace() < neededSpace) goto L29;
        return true;
    L29:
        i2 = i2 + 1;
        goto L23
    L30:
        return false;
    }

    SharedLibraryInfo getLatestStaticSharedLibraVersion(AndroidPackage pkg) {
        PackageManagerTracedLock r0 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        SharedLibraryInfo r1 = getLatestStaticSharedLibraVersionLPr(pkg);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private SharedLibraryInfo getLatestStaticSharedLibraVersionLPr(AndroidPackage pkg) {
        WatchedLongSparseArray<SharedLibraryInfo> versionedLib = this.mSharedLibraries.get(pkg.getStaticSharedLibraryName());
        if (versionedLib != null) goto L5;
        return null;
    L5:
        long previousLibVersion = -1;
        int versionCount = versionedLib.size();
        int i = 0;
    L6:
        if (i >= versionCount) goto L12;
        long libVersion = versionedLib.keyAt(i);
        if (libVersion >= pkg.getStaticSharedLibraryVersion()) goto L10;
        previousLibVersion = Math.max(previousLibVersion, libVersion);
    L10:
        i = i + 1;
        goto L6
    L12:
        if (previousLibVersion >= 0) goto L14;
        return null;
    L14:
        return versionedLib.get(previousLibVersion);
    }

    PackageSetting getStaticSharedLibLatestVersionSetting(InstallRequest installRequest) {
        if (installRequest.getParsedPackage() != null) goto L6;
        return null;
    L6:
        PackageSetting sharedLibPackage = null;
        PackageManagerTracedLock r1 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        SharedLibraryInfo latestSharedLibraVersionLPr = getLatestStaticSharedLibraVersionLPr(installRequest.getParsedPackage());     // Catch: Throwable -> L11
        if (latestSharedLibraVersionLPr == null) goto L13;
        sharedLibPackage = this.mPm.mSettings.getPackageLPr(latestSharedLibraVersionLPr.getPackageName());     // Catch: Throwable -> L11
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L11
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return sharedLibPackage;
    L11:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void applyDefiningSharedLibraryUpdateLPr(AndroidPackage pkg, SharedLibraryInfo libInfo, BiConsumer<SharedLibraryInfo, SharedLibraryInfo> action) {
        if (AndroidPackageUtils.isLibrary(pkg) == true) goto L5;
        return;
    L5:
        if (pkg.getSdkLibraryName() == null) goto L11;
        SharedLibraryInfo definedLibrary = getSharedLibraryInfo(pkg.getSdkLibraryName(), pkg.getSdkLibVersionMajor());
        if (definedLibrary == null) goto L30;
        action.accept(definedLibrary, libInfo);
        return;
    L30:
        return;
    L11:
        if (pkg.getStaticSharedLibraryName() == null) goto L16;
        SharedLibraryInfo definedLibrary2 = getSharedLibraryInfo(pkg.getStaticSharedLibraryName(), pkg.getStaticSharedLibraryVersion());
        if (definedLibrary2 == null) goto L32;
        action.accept(definedLibrary2, libInfo);
        return;
    L32:
        return;
    L16:
        Iterator r0 = pkg.getLibraryNames().iterator();
    L18:
        if (r0.hasNext() == false) goto L33;
        String libraryName = (String) r0.next();
        SharedLibraryInfo definedLibrary3 = getSharedLibraryInfo(libraryName, -1);
        if (definedLibrary3 == null) goto L18;
        action.accept(definedLibrary3, libInfo);
        goto L18
    }

    private void addSharedLibraryLPr(AndroidPackage pkg, Set<String> usesLibraryFiles, SharedLibraryInfo libInfo, AndroidPackage changingLib, PackageSetting changingLibSetting) {
        if (libInfo.getPath() == null) goto L6;
        usesLibraryFiles.add(libInfo.getPath());
        return;
    L6:
        AndroidPackage pkgForCodePaths = this.mPm.mPackages.get(libInfo.getPackageName());
        PackageSetting pkgSetting = this.mPm.mSettings.getPackageLPr(libInfo.getPackageName());
        if (changingLib != null) goto L9;
    L14:
        if (pkgForCodePaths == null) goto L19;
        usesLibraryFiles.addAll(AndroidPackageUtils.getAllCodePaths(pkgForCodePaths));
        applyDefiningSharedLibraryUpdateLPr(pkg, libInfo, new SharedLibrariesImpl$$ExternalSyntheticLambda1());
        if (pkgSetting == null) goto L20;
        usesLibraryFiles.addAll(pkgSetting.getPkgState().getUsesLibraryFiles());
        return;
    L20:
        return;
    L19:
        return;
    L9:
        if (changingLib.getPackageName().equals(libInfo.getPackageName()) == false) goto L14;
        if (pkgForCodePaths != null) goto L12;
    L13:
        pkgForCodePaths = changingLib;
        pkgSetting = changingLibSetting;
        goto L14
    L12:
        if (pkgForCodePaths.getPackageName().equals(changingLib.getPackageName()) == false) goto L14;
        goto L13
    }

    void updateSharedLibraries(AndroidPackage pkg, PackageSetting pkgSetting, AndroidPackage changingLib, PackageSetting changingLibSetting, Map<String, AndroidPackage> availablePackages) throws PackageManagerException {
        ArrayList<SharedLibraryInfo> sharedLibraryInfos = collectSharedLibraryInfos(pkg, availablePackages, null);
        PackageManagerTracedLock r8 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r8);
        executeSharedLibrariesUpdateLPw(pkg, pkgSetting, changingLib, changingLibSetting, sharedLibraryInfos, this.mPm.mUserManager.getUserIds());     // Catch: Throwable -> L10
        monitor-exit(r8);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L10:
        th = move-exception;
        Throwable r10 = th;
    L14:
        monitor-exit(r8);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw r10;
    L12:
        th = move-exception;
        r10 = th;
        goto L14
    }

    void executeSharedLibrariesUpdate(AndroidPackage pkg, PackageSetting pkgSetting, AndroidPackage changingLib, PackageSetting changingLibSetting, ArrayList<SharedLibraryInfo> usesLibraryInfos, int[] allUsers) {
        PackageManagerTracedLock r1 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        executeSharedLibrariesUpdateLPw(pkg, pkgSetting, changingLib, changingLibSetting, usesLibraryInfos, allUsers);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void executeSharedLibrariesUpdateLPw(AndroidPackage pkg, PackageSetting pkgSetting, AndroidPackage changingLib, PackageSetting changingLibSetting, ArrayList<SharedLibraryInfo> usesLibraryInfos, int[] allUsers) {
        applyDefiningSharedLibraryUpdateLPr(pkg, null, new SharedLibrariesImpl$$ExternalSyntheticLambda0());
        if (usesLibraryInfos == null) goto L29;
        pkgSetting.getPkgState().setUsesLibraryInfos(usesLibraryInfos);
        Set<String> usesLibraryFiles = new LinkedHashSet();
        Iterator<SharedLibraryInfo> r2 = usesLibraryInfos.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        SharedLibraryInfo libInfo = r2.next();
        addSharedLibraryLPr(pkg, usesLibraryFiles, libInfo, changingLib, changingLibSetting);
        goto L6
    L8:
        pkgSetting.setPkgStateLibraryFiles(usesLibraryFiles);
        int[] installedUsers = new int[allUsers.length];
        int installedUserCount = 0;
        int u = 0;
    L10:
        if (u >= allUsers.length) goto L15;
        if (pkgSetting.getInstalled(allUsers[u]) == false) goto L14;
        installedUsers[installedUserCount] = allUsers[u];
        installedUserCount = installedUserCount + 1;
    L14:
        u = u + 1;
        goto L10
    L15:
        Iterator<SharedLibraryInfo> r6 = usesLibraryInfos.iterator();
    L17:
        if (r6.hasNext() == false) goto L43;
        SharedLibraryInfo sharedLibraryInfo = r6.next();
        if (sharedLibraryInfo.isStatic() == false) goto L17;
        PackageSetting staticLibPkgSetting = this.mPm.getPackageSettingForMutation(sharedLibraryInfo.getPackageName());
        if (staticLibPkgSetting == null) goto L23;
        int u2 = 0;
    L25:
        if (u2 >= installedUserCount) goto L17;
        staticLibPkgSetting.setInstalled(true, installedUsers[u2]);
        u2 = u2 + 1;
        goto L25
    L23:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Shared lib without setting: " + sharedLibraryInfo);
        goto L17
    L43:
        return;
    L29:
        pkgSetting.getPkgState().setUsesLibraryInfos(Collections.emptyList()).setUsesLibraryFiles(Collections.emptyList());
    }

    private static /* synthetic */ void lambda$executeSharedLibrariesUpdateLPw$0(SharedLibraryInfo definingLibrary, SharedLibraryInfo dependency) {
        definingLibrary.clearDependencies();
    }

    private static boolean hasString(List<String> list, List<String> which) {
        if (list == null) goto L17;
        if (which == null) goto L17;
        int i = list.size() - 1;
    L7:
        if (i < 0) goto L16;
        int j = which.size() - 1;
    L9:
        if (j < 0) goto L14;
        if (which.get(j).equals(list.get(i)) == true) goto L12;
        j = j - 1;
        goto L9
    L12:
        return true;
    L14:
        i = i - 1;
        goto L7
    L16:
        return false;
    L17:
        return false;
    }

    ArrayList<AndroidPackage> commitSharedLibraryChanges(AndroidPackage pkg, PackageSetting pkgSetting, List<SharedLibraryInfo> allowedSharedLibraryInfos, Map<String, AndroidPackage> combinedSigningDetails, int scanFlags) {
        if (ArrayUtils.isEmpty(allowedSharedLibraryInfos) == false) goto L5;
        return null;
    L5:
        PackageManagerTracedLock r2 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        Iterator<SharedLibraryInfo> r0 = allowedSharedLibraryInfos.iterator();     // Catch: Throwable -> L31
    L8:
        if (r0.hasNext() == false) goto L41;
        SharedLibraryInfo info = r0.next();     // Catch: Throwable -> L12
        commitSharedLibraryInfoLPw(info);     // Catch: Throwable -> L12
    L12:
        th = th;
    L33:
        monitor-exit(r2);     // Catch: Throwable -> L17
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L41:
        updateSharedLibraries(pkg, pkgSetting, null, null, combinedSigningDetails);     // Catch: Throwable -> L17 PackageManagerException -> L19
    L23:
        if ((scanFlags & 16) != 0) goto L28;
        ArrayList<AndroidPackage> r10 = updateAllSharedLibrariesLPw(pkg, pkgSetting, combinedSigningDetails);     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L17
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r10;
    L28:
        monitor-exit(r2);     // Catch: Throwable -> L17
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return null;
    L19:
        e = move-exception;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "updateSharedLibraries failed: ", e);     // Catch: Throwable -> L17
    L31:
        th = th;
    L17:
        th = th;
        goto L33
    }

    ArrayList<AndroidPackage> updateAllSharedLibrariesLPw(AndroidPackage updatedPkg, PackageSetting updatedPkgSetting, Map<String, AndroidPackage> availablePackages) {
        ArrayList<AndroidPackage> resultList = null;
        ArraySet<String> descendants = null;
        if (updatedPkg == null) goto L6;
        if (updatedPkgSetting == null) goto L6;
        List<Pair<AndroidPackage, PackageSetting>> needsUpdating = new ArrayList(1);
        needsUpdating.add(Pair.create(updatedPkg, updatedPkgSetting));
        List<Pair<AndroidPackage, PackageSetting>> needsUpdating2 = needsUpdating;
    L7:
        PackageSetting r3 = null;
        if (needsUpdating2 != null) goto L10;
        Pair<AndroidPackage, PackageSetting> r4 = null;
    L11:
        Pair<AndroidPackage, PackageSetting> changingPkgPair = r4;
        if (changingPkgPair == null) goto L14;
        AndroidPackage changingPkg = (AndroidPackage) changingPkgPair.first;
    L15:
        if (changingPkgPair == null) goto L17;
        r3 = (PackageSetting) changingPkgPair.second;
    L17:
        PackageSetting changingPkgSetting = r3;
        int i = this.mPm.mPackages.size() - 1;
    L20:
        if (i < 0) goto L72;
        AndroidPackage pkg = this.mPm.mPackages.valueAt(i);
        PackageSetting pkgSetting = this.mPm.mSettings.getPackageLPr(pkg.getPackageName());
        if (changingPkg != null) goto L24;
    L32:
        if (resultList != null) goto L34;
        ArrayList<AndroidPackage> resultList2 = new ArrayList();
    L35:
        resultList2.add(pkg);
        if (changingPkg == null) goto L43;
        if (descendants != null) goto L40;
        descendants = new ArraySet();
    L40:
        if (descendants.contains(pkg.getPackageName()) == true) goto L42;
        descendants.add(pkg.getPackageName());
        needsUpdating2.add(Pair.create(pkg, pkgSetting));
    L42:
        ArraySet<String> descendants2 = descendants;
    L78:
        updateSharedLibraries(pkg, pkgSetting, changingPkg, changingPkgSetting, availablePackages);     // Catch: PackageManagerException -> L47
    L61:
        resultList = resultList2;
        descendants = descendants2;
    L62:
        i = i - 1;
    L47:
        e = move-exception;
        if (pkgSetting.isSystem() == false) goto L53;
        if (pkgSetting.isUpdatedSystemApp() == true) goto L53;
    L60:
        Slog.e(PackageManagerServiceMonitorEx.TAG, "updateAllSharedLibrariesLPw failed: " + e.getMessage());
    L53:
        if (pkgSetting.isUpdatedSystemApp() == false) goto L55;
        int r0 = 1;
    L56:
        int flags = r0;
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        this.mDeletePackageHelper.deletePackageLIF(pkg.getPackageName(), null, true, this.mPm.mUserManager.getUserIds(), flags, new PackageRemovedInfo(), true);     // Catch: Throwable -> L63
        if (installLock == null) goto L60;
        installLock.close();
    L63:
        th = move-exception;
        if (installLock == null) goto L89;
        installLock.close();     // Catch: Throwable -> L68
        throw th;
    L68:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L89:
        throw th;
    L55:
        r0 = 0;
        goto L56
    L43:
        descendants2 = descendants;
        goto L78
    L34:
        resultList2 = resultList;
        goto L35
    L24:
        if (hasString(pkg.getUsesLibraries(), changingPkg.getLibraryNames()) == true) goto L32;
        if (hasString(pkg.getUsesOptionalLibraries(), changingPkg.getLibraryNames()) == true) goto L32;
        if (ArrayUtils.contains(pkg.getUsesStaticLibraries(), changingPkg.getStaticSharedLibraryName()) == true) goto L32;
        if (ArrayUtils.contains(pkg.getUsesSdkLibraries(), changingPkg.getSdkLibraryName()) == true) goto L32;
    L72:
        if (needsUpdating2 == null) goto L75;
        if (needsUpdating2.size() > 0) goto L7;
    L75:
        return resultList;
    L14:
        changingPkg = null;
        goto L15
    L10:
        r4 = needsUpdating2.remove(0);
    L6:
        needsUpdating2 = null;
        goto L7
    }

    void addBuiltInSharedLibraryLPw(SystemConfig.SharedLibraryEntry entry) {
        if (getSharedLibraryInfo(entry.name, -1) == null) goto L5;
        return;
    L5:
        SharedLibraryInfo libraryInfo = new SharedLibraryInfo(entry.filename, null, null, entry.name, -1, 0, new VersionedPackage(PackageManagerService.PLATFORM_PACKAGE_NAME, 0), null, null, entry.isNative);
        commitSharedLibraryInfoLPw(libraryInfo);
    }

    void commitSharedLibraryInfoLPw(SharedLibraryInfo libraryInfo) {
        String name = libraryInfo.getName();
        WatchedLongSparseArray<SharedLibraryInfo> versionedLib = this.mSharedLibraries.get(name);
        if (versionedLib != null) goto L5;
        versionedLib = new WatchedLongSparseArray();
        this.mSharedLibraries.put(name, versionedLib);
    L5:
        String declaringPackageName = libraryInfo.getDeclaringPackage().getPackageName();
        if (libraryInfo.getType() != 2) goto L8;
        this.mStaticLibsByDeclaringPackage.put(declaringPackageName, versionedLib);
    L8:
        versionedLib.put(libraryInfo.getLongVersion(), libraryInfo);
    }

    boolean removeSharedLibrary(String libName, long version) {
        PackageManagerTracedLock r5 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        WatchedLongSparseArray<SharedLibraryInfo> versionedLib = this.mSharedLibraries.get(libName);     // Catch: Throwable -> L9
        int r6 = 0;
        if (versionedLib != null) goto L11;
        monitor-exit(r5);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return false;
    L11:
        int libIdx = versionedLib.indexOfKey(version);     // Catch: Throwable -> L9
        if (libIdx >= 0) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return false;
    L16:
        SharedLibraryInfo libraryInfo = versionedLib.valueAt(libIdx);     // Catch: Throwable -> L9
        Computer snapshot = this.mPm.snapshotComputer();     // Catch: Throwable -> L9
        int[] r8 = this.mPm.mUserManager.getUserIds();     // Catch: Throwable -> L9
        int r15 = r8.length;     // Catch: Throwable -> L9
    L17:
        if (r6 >= r15) goto L31;
        int currentUserId = r8[r6];     // Catch: Throwable -> L9
        Pair<List<VersionedPackage>, List<Boolean>> usingSharedLibraryPair = snapshot.getPackagesUsingSharedLibrary(libraryInfo, 0, 1000, currentUserId);     // Catch: Throwable -> L9
        List<VersionedPackage> dependents = (List) usingSharedLibraryPair.first;     // Catch: Throwable -> L9
        if (dependents != null) goto L21;
        int r17 = r6;
        int libIdx2 = libIdx;
        int[] r19 = r8;
    L30:
        r6 = r17 + 1;     // Catch: Throwable -> L9
        libIdx = libIdx2;
        r8 = r19;
        goto L17
    L21:
        Iterator<VersionedPackage> r13 = dependents.iterator();     // Catch: Throwable -> L9
    L23:
        if (r13.hasNext() == false) goto L29;
        VersionedPackage dependentPackage = r13.next();     // Catch: Throwable -> L9
        int r18 = r6;
        int libIdx3 = libIdx;
        PackageSetting ps = this.mPm.mSettings.getPackageLPr(dependentPackage.getPackageName());     // Catch: Throwable -> L9
        if (ps == null) goto L28;
        ps.setOverlayPathsForLibrary(libraryInfo.getName(), null, currentUserId);     // Catch: Throwable -> L9
    L28:
        r6 = r18;
        libIdx = libIdx3;
        r8 = r8;
        goto L23
    L29:
        r17 = r6;
        libIdx2 = libIdx;
        r19 = r8;
        goto L30
    L31:
        versionedLib.remove(version);     // Catch: Throwable -> L9
        if (versionedLib.size() > 0) goto L36;
        this.mSharedLibraries.remove(libName);     // Catch: Throwable -> L9
        if (libraryInfo.getType() != 2) goto L36;
        this.mStaticLibsByDeclaringPackage.remove(libraryInfo.getDeclaringPackage().getPackageName());     // Catch: Throwable -> L9
    L36:
        monitor-exit(r5);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return true;
    L9:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    List<SharedLibraryInfo> getAllowedSharedLibInfos(InstallRequest installRequest) {
        ParsedPackage parsedPackage = installRequest.getParsedPackage();
        if (installRequest.getSdkSharedLibraryInfo() != null) goto L10;
        if (installRequest.getStaticSharedLibraryInfo() != null) goto L10;
        if (installRequest.getDynamicSharedLibraryInfos() != null) goto L10;
        return null;
    L10:
        if (installRequest.getSdkSharedLibraryInfo() == null) goto L14;
        return Collections.singletonList(installRequest.getSdkSharedLibraryInfo());
    L14:
        if (installRequest.getStaticSharedLibraryInfo() != null) goto L16;
        boolean isUpdatedSystemApp = false;
        if (installRequest.getScannedPackageSetting() != null) goto L20;
    L22:
        boolean isSystemApp = false;
    L24:
        if (parsedPackage == null) goto L29;
        if (isSystemApp == false) goto L29;
        if (installRequest.getDynamicSharedLibraryInfos() == null) goto L29;
        boolean hasDynamicLibraries = true;
    L31:
        if (hasDynamicLibraries == true) goto L34;
        return null;
    L34:
        if (installRequest.getScannedPackageSetting() != null) goto L36;
    L40:
        if (isUpdatedSystemApp == true) goto L42;
        PackageSetting updatedSystemPs = null;
    L47:
        if (isUpdatedSystemApp == true) goto L49;
    L54:
        ArrayList<SharedLibraryInfo> infos = new ArrayList(installRequest.getDynamicSharedLibraryInfos().size());
        Iterator<SharedLibraryInfo> r6 = installRequest.getDynamicSharedLibraryInfos().iterator();
    L56:
        if (r6.hasNext() == false) goto L77;
        SharedLibraryInfo info = r6.next();
        String name = info.getName();
        if (isUpdatedSystemApp == false) goto L62;
        if (updatedSystemPs.getPkg().getLibraryNames().contains(name) == true) goto L62;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Package " + parsedPackage.getPackageName() + " declares library " + name + " that is not declared on system image; skipping");
    L62:
        PackageManagerTracedLock r9 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r9);
        if (getSharedLibraryInfo(name, -1) != null) goto L67;
        monitor-exit(r9);     // Catch: Throwable -> L70
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        infos.add(info);
        goto L56
    L67:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Package " + parsedPackage.getPackageName() + " declares library " + name + " that already exists; skipping");     // Catch: Throwable -> L70
        monitor-exit(r9);     // Catch: Throwable -> L70
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L70:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L77:
        return infos;
    L49:
        if (updatedSystemPs.getPkg() != null) goto L51;
    L52:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Package " + parsedPackage.getPackageName() + " declares libraries that are not declared on the system image; skipping");
        return null;
    L51:
        if (updatedSystemPs.getPkg().getLibraryNames() != null) goto L54;
    L42:
        if (installRequest.getScanRequestDisabledPackageSetting() != null) goto L44;
        updatedSystemPs = installRequest.getScanRequestOldPackageSetting();
        goto L47
    L44:
        updatedSystemPs = installRequest.getScanRequestDisabledPackageSetting();
        goto L47
    L36:
        if (installRequest.getScannedPackageSetting().isUpdatedSystemApp() == false) goto L40;
        isUpdatedSystemApp = true;
    L29:
        hasDynamicLibraries = false;
        goto L31
    L20:
        if (installRequest.getScannedPackageSetting().isSystem() == false) goto L22;
        isSystemApp = true;
        goto L24
    L16:
        return Collections.singletonList(installRequest.getStaticSharedLibraryInfo());
    }

    ArrayList<SharedLibraryInfo> collectSharedLibraryInfos(AndroidPackage pkg, Map<String, AndroidPackage> availablePackages, Map<String, WatchedLongSparseArray<SharedLibraryInfo>> newLibraries) throws PackageManagerException {
        if (pkg != null) goto L5;
        return null;
    L5:
        PlatformCompat platformCompat = this.mInjector.getCompatibility();
        if (pkg.getUsesLibraries().isEmpty() == true) goto L8;
        ArrayList<SharedLibraryInfo> usesLibraryInfos = collectSharedLibraryInfos(pkg.getUsesLibraries(), null, null, null, pkg.getPackageName(), "shared", true, pkg.getTargetSdkVersion(), null, availablePackages, newLibraries, null);
        ArrayList<SharedLibraryInfo> usesLibraryInfos2 = usesLibraryInfos;
    L10:
        if (pkg.getUsesStaticLibraries().isEmpty() == true) goto L13;
        usesLibraryInfos2 = collectSharedLibraryInfos(pkg.getUsesStaticLibraries(), pkg.getUsesStaticLibrariesVersions(), pkg.getUsesStaticLibrariesCertDigests(), null, pkg.getPackageName(), LIBRARY_TYPE_STATIC, true, pkg.getTargetSdkVersion(), usesLibraryInfos2, availablePackages, newLibraries, null);
    L13:
        if (pkg.getUsesOptionalLibraries().isEmpty() == true) goto L16;
        usesLibraryInfos2 = collectSharedLibraryInfos(pkg.getUsesOptionalLibraries(), null, null, null, pkg.getPackageName(), "shared", false, pkg.getTargetSdkVersion(), usesLibraryInfos2, availablePackages, newLibraries, null);
    L16:
        if (platformCompat.isChangeEnabledInternal(ENFORCE_NATIVE_SHARED_LIBRARY_DEPENDENCIES, pkg.getPackageName(), pkg.getTargetSdkVersion()) == false) goto L24;
        if (pkg.getUsesNativeLibraries().isEmpty() == true) goto L21;
        usesLibraryInfos2 = collectSharedLibraryInfos(pkg.getUsesNativeLibraries(), null, null, null, pkg.getPackageName(), "native shared", true, pkg.getTargetSdkVersion(), usesLibraryInfos2, availablePackages, newLibraries, null);
    L21:
        if (pkg.getUsesOptionalNativeLibraries().isEmpty() == true) goto L24;
        usesLibraryInfos2 = collectSharedLibraryInfos(pkg.getUsesOptionalNativeLibraries(), null, null, null, pkg.getPackageName(), "native shared", false, pkg.getTargetSdkVersion(), usesLibraryInfos2, availablePackages, newLibraries, null);
    L24:
        if (pkg.getUsesSdkLibraries().isEmpty() == false) goto L26;
        return usesLibraryInfos2;
    L26:
        return collectSharedLibraryInfos(pkg.getUsesSdkLibraries(), pkg.getUsesSdkLibrariesVersionsMajor(), pkg.getUsesSdkLibrariesCertDigests(), pkg.getUsesSdkLibrariesOptional(), pkg.getPackageName(), LIBRARY_TYPE_SDK, true, pkg.getTargetSdkVersion(), usesLibraryInfos2, availablePackages, newLibraries, null);
    L8:
        usesLibraryInfos2 = null;
        goto L10
    }

    List<SharedLibraryInfo> collectMissingSharedLibraryInfos(PackageLite pkgLite) throws PackageManagerException {
        ArrayList<SharedLibraryInfo> missingSharedLibrary = new ArrayList();
        PackageManagerTracedLock r14 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r14);
        collectSharedLibraryInfos(pkgLite.getUsesSdkLibraries(), pkgLite.getUsesSdkLibrariesVersionsMajor(), pkgLite.getUsesSdkLibrariesCertDigests(), null, pkgLite.getPackageName(), LIBRARY_TYPE_SDK, true, pkgLite.getTargetSdk(), null, this.mPm.mPackages, null, missingSharedLibrary);     // Catch: Throwable -> L8
        collectSharedLibraryInfos(pkgLite.getUsesStaticLibraries(), pkgLite.getUsesStaticLibrariesVersions(), pkgLite.getUsesStaticLibrariesCertDigests(), null, pkgLite.getPackageName(), LIBRARY_TYPE_STATIC, true, pkgLite.getTargetSdk(), null, this.mPm.mPackages, null, missingSharedLibrary);     // Catch: Throwable -> L8
        monitor-exit(r14);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return missingSharedLibrary;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private ArrayList<SharedLibraryInfo> collectSharedLibraryInfos(List<String> requestedLibraries, long[] requiredVersions, String[][] requiredCertDigests, boolean[] libsOptional, String packageName, String libraryType, boolean required, int targetSdk, ArrayList<SharedLibraryInfo> outUsedLibraries, Map<String, AndroidPackage> availablePackages, Map<String, WatchedLongSparseArray<SharedLibraryInfo>> newLibraries, List<SharedLibraryInfo> outMissingSharedLibraryInfos) throws PackageManagerException {
        int libCount = requestedLibraries.size();
        ArrayList<SharedLibraryInfo> outUsedLibraries2 = outUsedLibraries;
        int i = 0;
    L3:
        if (i >= libCount) goto L102;
        String libName = requestedLibraries.get(i);
        if (requiredVersions == null) goto L7;
        long libVersion = requiredVersions[i];
    L8:
        PackageManagerTracedLock r9 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r9);
        SharedLibraryInfo libraryInfo = SharedLibraryUtils.getSharedLibraryInfo(libName, libVersion, this.mSharedLibraries, newLibraries);     // Catch: Throwable -> L91
        monitor-exit(r9);     // Catch: Throwable -> L91
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        boolean isSdkOrStatic = true;
        if (libraryInfo != null) goto L45;
        if (required == false) goto L31;
        if (libraryType.equals(LIBRARY_TYPE_SDK) == false) goto L20;
    L25:
        if (isSdkOrStatic == false) goto L29;
        if (outMissingSharedLibraryInfos == 0) goto L29;
        List<String> libCertDigests = Arrays.asList(requiredCertDigests[i]);
        SharedLibraryInfo missingLibrary = new SharedLibraryInfo(libName, libVersion, 3, libCertDigests);
        outMissingSharedLibraryInfos.add(missingLibrary);
    L43:
        libCount = libCount;
    L90:
        i = i + 1;
        libCount = libCount;
    L29:
        throw new PackageManagerException(-9, "Package " + packageName + " requires unavailable " + libraryType + " library " + libName + "; failing!");
    L20:
        if (libraryType.equals(LIBRARY_TYPE_STATIC) == true) goto L25;
        isSdkOrStatic = false;
        goto L25
    L31:
        if (libsOptional != null) goto L33;
    L35:
        isSdkOrStatic = false;
    L37:
        if (LIBRARY_TYPE_SDK.equals(libraryType) == false) goto L43;
        if (isSdkOrStatic == true) goto L43;
        throw new PackageManagerException(-9, "Package " + packageName + " requires unavailable " + libraryType + " library " + libName + "; failing!");
    L33:
        if (libsOptional[i] == false) goto L35;
    L45:
        if (requiredVersions == null) goto L87;
        if (requiredCertDigests == null) goto L87;
        if (libraryInfo.getLongVersion() != requiredVersions[i]) goto L85;
        AndroidPackage pkg = availablePackages.get(libraryInfo.getPackageName());
        if (pkg != null) goto L52;
        SigningDetails libPkg = null;
    L53:
        if (libPkg == null) goto L83;
        String[] expectedCertDigests = requiredCertDigests[i];
        if (expectedCertDigests.length <= 1) goto L107;
        if (targetSdk < 27) goto L59;
        String[] libCertDigests2 = PackageUtils.computeSignaturesSha256Digests(libPkg.getSignatures());
    L61:
        if (expectedCertDigests.length != libCertDigests2.length) goto L71;
        Arrays.sort(libCertDigests2);
        Arrays.sort(expectedCertDigests);
        int certCount = libCertDigests2.length;
        int j = 0;
    L63:
        if (j >= certCount) goto L87;
        String[] libCertDigests3 = libCertDigests2;
        int certCount2 = certCount;
        if (libCertDigests3[j].equalsIgnoreCase(expectedCertDigests[j]) == false) goto L68;
        j = j + 1;
        libCertDigests2 = libCertDigests3;
        certCount = certCount2;
        goto L63
    L68:
        throw new PackageManagerException(-9, "Package " + packageName + " requires differently signed " + libraryType + " library; failing!");
    L71:
        throw new PackageManagerException(-9, "Package " + packageName + " requires differently signed " + libraryType + " library; failing!");
    L59:
        libCertDigests2 = PackageUtils.computeSignaturesSha256Digests(new Signature[]{libPkg.getSignatures()[0]});
        goto L61
    L107:
        byte[] digestBytes = HexEncoding.decode(expectedCertDigests[0], false);     // Catch: IllegalArgumentException -> L79
        if (libPkg.hasSha256Certificate(digestBytes) == true) goto L87;
        throw new PackageManagerException(-9, "Package " + packageName + " requires differently signed " + libraryType + " library; failing!");
    L81:
        throw new PackageManagerException(-130, "Package " + packageName + " declares bad certificate digest for " + libraryType + " library " + libName + "; failing!");
    L83:
        throw new PackageManagerException(-9, "Package " + packageName + " requires unavailable " + libraryType + " library; failing!");
    L52:
        libPkg = pkg.getSigningDetails();
        goto L53
    L85:
        throw new PackageManagerException(-9, "Package " + packageName + " requires unavailable " + libraryType + " library " + libName + " version " + libraryInfo.getLongVersion() + "; failing!");
    L87:
        if (outUsedLibraries2 != null) goto L89;
        outUsedLibraries2 = new ArrayList();
    L89:
        outUsedLibraries2.add(libraryInfo);
    L91:
        th = th;
    L103:
        monitor-exit(r9);     // Catch: Throwable -> L99
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L99:
        th = th;
    L94:
        th = th;
        goto L103
    L7:
        libVersion = -1;
        goto L8
    L102:
        return outUsedLibraries2;
    }

    @Override // com.android.server.pm.SharedLibrariesRead
    public void dump(PrintWriter pw, DumpState dumpState) {
        boolean checkin = dumpState.isCheckIn();
        boolean printedHeader = false;
        int numSharedLibraries = this.mSharedLibraries.size();
        int index = 0;
    L3:
        if (index >= numSharedLibraries) goto L34;
        String libName = this.mSharedLibraries.keyAt(index);
        WatchedLongSparseArray<SharedLibraryInfo> versionedLib = this.mSharedLibraries.get(libName);
        if (versionedLib == null) goto L32;
        int versionCount = versionedLib.size();
        int i = 0;
    L8:
        if (i >= versionCount) goto L32;
        SharedLibraryInfo libraryInfo = versionedLib.valueAt(i);
        if (checkin == true) goto L17;
        if (printedHeader == false) goto L13;
    L16:
        pw.print("  ");
    L18:
        pw.print(libraryInfo.getName());
        if (libraryInfo.isStatic() == false) goto L21;
        pw.print(" version=" + libraryInfo.getLongVersion());
    L21:
        if (checkin == true) goto L24;
        pw.print(" -> ");
    L24:
        if (libraryInfo.getPath() != null) goto L26;
        pw.print(" (apk) ");
        pw.print(libraryInfo.getPackageName());
    L31:
        pw.println();
        i = i + 1;
        goto L8
    L26:
        if (libraryInfo.isNative() == false) goto L28;
        pw.print(" (so) ");
    L29:
        pw.print(libraryInfo.getPath());
        goto L31
    L28:
        pw.print(" (jar) ");
        goto L29
    L13:
        if (dumpState.onTitlePrinted() == false) goto L15;
        pw.println();
    L15:
        pw.println("Libraries:");
        printedHeader = true;
        goto L16
    L17:
        pw.print("lib,");
    L32:
        index = index + 1;
        goto L3
    }

    @Override // com.android.server.pm.SharedLibrariesRead
    public void dumpProto(ProtoOutputStream proto) {
        int count = this.mSharedLibraries.size();
        int i = 0;
    L3:
        if (i >= count) goto L20;
        String libName = this.mSharedLibraries.keyAt(i);
        WatchedLongSparseArray<SharedLibraryInfo> versionedLib = this.mSharedLibraries.get(libName);
        if (versionedLib == null) goto L18;
        int versionCount = versionedLib.size();
        int j = 0;
    L8:
        if (j >= versionCount) goto L18;
        SharedLibraryInfo libraryInfo = versionedLib.valueAt(j);
        long sharedLibraryToken = proto.start(2246267895811L);
        proto.write(1138166333441L, libraryInfo.getName());
        if (libraryInfo.getPath() == null) goto L12;
        boolean isJar = true;
    L13:
        proto.write(1133871366146L, isJar);
        if (isJar == false) goto L16;
        proto.write(1138166333443L, libraryInfo.getPath());
    L17:
        proto.end(sharedLibraryToken);
        j = j + 1;
        goto L8
    L16:
        proto.write(1138166333444L, libraryInfo.getPackageName());
        goto L17
    L12:
        isJar = false;
    L18:
        i = i + 1;
        goto L3
    }
}
