package com.android.server.pm.pkg;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.UserPackage;
import android.content.pm.overlay.OverlayPaths;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pair;
import com.android.internal.util.AnnotationValidations;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.server.utils.Snappable;
import com.android.server.utils.SnapshotCache;
import com.android.server.utils.Watchable;
import com.android.server.utils.WatchableImpl;
import com.android.server.utils.WatchedArrayMap;
import com.android.server.utils.WatchedArraySet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class PackageUserStateImpl extends WatchableImpl implements PackageUserStateInternal, Snappable {
    private ArchiveState mArchiveState;
    private int mBooleans;
    private long mCeDataInode;
    private WatchedArrayMap<ComponentName, Pair<String, Integer>> mComponentLabelIconOverrideMap;
    private long mDeDataInode;
    protected WatchedArraySet<String> mDisabledComponentsWatched;
    private int mDistractionFlags;
    protected WatchedArraySet<String> mEnabledComponentsWatched;
    private int mEnabledState;
    private long mFirstInstallTimeMillis;
    private String mHarmfulAppWarning;
    private int mInstallReason;
    private String mLastDisableAppCaller;
    private int mMinAspectRatio;
    private OverlayPaths mOverlayPaths;
    protected WatchedArrayMap<String, OverlayPaths> mSharedLibraryOverlayPaths;
    private PackageUserStateImplSmtEx mSmtEx;
    final SnapshotCache<PackageUserStateImpl> mSnapshot;
    private String mSplashScreenTheme;
    private WatchedArrayMap<UserPackage, SuspendParams> mSuspendParams;
    private int mUninstallReason;
    private Watchable mWatchable;

    private static class Booleans {
        private static final int HIDDEN = 8;
        private static final int INSTALLED = 1;
        private static final int INSTANT_APP = 16;
        private static final int NOT_LAUNCHED = 4;
        private static final int STOPPED = 2;
        private static final int VIRTUAL_PRELOADED = 32;

        public @interface Flags {
        }

        private Booleans() {
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWatchable, reason: not valid java name */
    static /* bridge */ /* synthetic */ Watchable m7111$$Nest$fgetmWatchable(PackageUserStateImpl r0) {
        return r0.mWatchable;
    }

    /* JADX INFO: renamed from: getDisabledComponents, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Set m7112getDisabledComponents() {
        return getDisabledComponents();
    }

    /* JADX INFO: renamed from: getEnabledComponents, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Set m7113getEnabledComponents() {
        return getEnabledComponents();
    }

    @Override // com.android.server.utils.Snappable
    public /* bridge */ /* synthetic */ Object snapshot() {
        return snapshot();
    }

    private void setBoolean(int flag, boolean value) {
        if (value == false) goto L4;
        this.mBooleans |= flag;
        return;
    L4:
        this.mBooleans &= ~flag;
    }

    private boolean getBoolean(int flag) {
        if ((this.mBooleans & flag) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private SnapshotCache<PackageUserStateImpl> makeCache() {
        return new AnonymousClass1(this, this, this);
    }

    public PackageUserStateImpl() {
        this.mEnabledState = 0;
        this.mInstallReason = 0;
        this.mUninstallReason = 0;
        this.mMinAspectRatio = 0;
        this.mSmtEx = new PackageUserStateImplSmtEx(this);
        this.mWatchable = null;
        this.mSnapshot = makeCache();
        setBoolean(1, true);
    }

    public PackageUserStateImpl(Watchable watchable) {
        this.mEnabledState = 0;
        this.mInstallReason = 0;
        this.mUninstallReason = 0;
        this.mMinAspectRatio = 0;
        this.mSmtEx = new PackageUserStateImplSmtEx(this);
        this.mWatchable = watchable;
        this.mSnapshot = makeCache();
        setBoolean(1, true);
    }

    public PackageUserStateImpl(Watchable watchable, PackageUserStateImpl other) {
        this.mEnabledState = 0;
        this.mInstallReason = 0;
        this.mUninstallReason = 0;
        this.mMinAspectRatio = 0;
        this.mSmtEx = new PackageUserStateImplSmtEx(this);
        this.mWatchable = watchable;
        this.mBooleans = other.mBooleans;
        WatchedArrayMap<ComponentName, Pair<String, Integer>> r1 = null;
        if (other.mDisabledComponentsWatched != null) goto L5;
        WatchedArraySet<String> r0 = null;
    L6:
        this.mDisabledComponentsWatched = r0;
        if (other.mEnabledComponentsWatched != null) goto L9;
        WatchedArraySet<String> r2 = null;
    L10:
        this.mEnabledComponentsWatched = r2;
        this.mOverlayPaths = other.mOverlayPaths;
        if (other.mSharedLibraryOverlayPaths != null) goto L13;
        WatchedArrayMap<String, OverlayPaths> r3 = null;
    L14:
        this.mSharedLibraryOverlayPaths = r3;
        this.mCeDataInode = other.mCeDataInode;
        this.mDeDataInode = other.mDeDataInode;
        this.mDistractionFlags = other.mDistractionFlags;
        this.mEnabledState = other.mEnabledState;
        this.mInstallReason = other.mInstallReason;
        this.mUninstallReason = other.mUninstallReason;
        this.mHarmfulAppWarning = other.mHarmfulAppWarning;
        this.mLastDisableAppCaller = other.mLastDisableAppCaller;
        this.mSplashScreenTheme = other.mSplashScreenTheme;
        this.mMinAspectRatio = other.mMinAspectRatio;
        if (other.mSuspendParams != null) goto L17;
        WatchedArrayMap<UserPackage, SuspendParams> r4 = null;
    L18:
        this.mSuspendParams = r4;
        if (other.mComponentLabelIconOverrideMap == null) goto L22;
        r1 = other.mComponentLabelIconOverrideMap.snapshot();
    L22:
        this.mComponentLabelIconOverrideMap = r1;
        this.mFirstInstallTimeMillis = other.mFirstInstallTimeMillis;
        this.mArchiveState = other.mArchiveState;
        this.mSnapshot = new SnapshotCache.Sealed();
        return;
    L17:
        r4 = other.mSuspendParams.snapshot();
        goto L18
    L13:
        r3 = other.mSharedLibraryOverlayPaths.snapshot();
        goto L14
    L9:
        r2 = other.mEnabledComponentsWatched.snapshot();
        goto L10
    L5:
        r0 = other.mDisabledComponentsWatched.snapshot();
        goto L6
    }

    private void onChanged() {
        if (this.mWatchable == null) goto L5;
        this.mWatchable.dispatchChange(this.mWatchable);
    L5:
        dispatchChange(this);
    }

    @Override // com.android.server.utils.Snappable
    public PackageUserStateImpl snapshot() {
        return this.mSnapshot.snapshot();
    }

    public boolean setOverlayPaths(OverlayPaths paths) {
        if (Objects.equals(paths, this.mOverlayPaths) == false) goto L6;
        return false;
    L6:
        if (this.mOverlayPaths == null) goto L8;
    L10:
        if (paths == null) goto L12;
    L14:
        this.mOverlayPaths = paths;
        onChanged();
        return true;
    L12:
        if (this.mOverlayPaths.isEmpty() == false) goto L14;
    L13:
        return false;
    L8:
        if (paths.isEmpty() == true) goto L13;
        goto L10
    }

    public boolean setSharedLibraryOverlayPaths(String library, OverlayPaths paths) {
        if (this.mSharedLibraryOverlayPaths != null) goto L5;
        this.mSharedLibraryOverlayPaths = new WatchedArrayMap();
        this.mSharedLibraryOverlayPaths.registerObserver(this.mSnapshot);
    L5:
        OverlayPaths currentPaths = this.mSharedLibraryOverlayPaths.get(library);
        boolean returnValue = false;
        if (Objects.equals(paths, currentPaths) == false) goto L9;
        return false;
    L9:
        if (paths == null) goto L16;
        if (paths.isEmpty() == true) goto L16;
        this.mSharedLibraryOverlayPaths.put(library, paths);
        onChanged();
        return true;
    L16:
        if (this.mSharedLibraryOverlayPaths.remove(library) == null) goto L18;
        returnValue = true;
    L18:
        onChanged();
        return returnValue;
    }

    @Override // com.android.server.pm.pkg.PackageUserStateInternal
    public WatchedArraySet<String> getDisabledComponentsNoCopy() {
        return this.mDisabledComponentsWatched;
    }

    @Override // com.android.server.pm.pkg.PackageUserStateInternal
    public WatchedArraySet<String> getEnabledComponentsNoCopy() {
        return this.mEnabledComponentsWatched;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public ArraySet<String> getDisabledComponents() {
        if (this.mDisabledComponentsWatched != null) goto L6;
        return new ArraySet();
    L6:
        return this.mDisabledComponentsWatched.untrackedStorage();
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public ArraySet<String> getEnabledComponents() {
        if (this.mEnabledComponentsWatched != null) goto L6;
        return new ArraySet();
    L6:
        return this.mEnabledComponentsWatched.untrackedStorage();
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public boolean isComponentEnabled(String componentName) {
        if (this.mEnabledComponentsWatched != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mEnabledComponentsWatched.contains(componentName) == false) goto L7;
        return true;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public boolean isComponentDisabled(String componentName) {
        if (this.mDisabledComponentsWatched != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mDisabledComponentsWatched.contains(componentName) == false) goto L7;
        return true;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public OverlayPaths getAllOverlayPaths() {
        if (this.mOverlayPaths != null) goto L9;
        if (this.mSharedLibraryOverlayPaths != null) goto L9;
        return null;
    L9:
        if (this.mOverlayPaths != null) goto L11;
        OverlayPaths.Builder newPaths = new OverlayPaths.Builder();
    L13:
        if (this.mSharedLibraryOverlayPaths == null) goto L19;
        Iterator<OverlayPaths> r1 = this.mSharedLibraryOverlayPaths.values().iterator();
    L16:
        if (r1.hasNext() == false) goto L19;
        OverlayPaths libOverlayPaths = r1.next();
        newPaths.addAll(libOverlayPaths);
    L19:
        return newPaths.build();
    L11:
        newPaths = new OverlayPaths.Builder(this.mOverlayPaths);
        goto L13
    }

    public boolean overrideLabelAndIcon(ComponentName component, String nonLocalizedLabel, Integer icon) {
        String existingLabel = null;
        Integer existingIcon = null;
        if (this.mComponentLabelIconOverrideMap == null) goto L8;
        Pair<String, Integer> pair = this.mComponentLabelIconOverrideMap.get(component);
        if (pair == null) goto L8;
        existingLabel = (String) pair.first;
        existingIcon = (Integer) pair.second;
    L8:
        if (TextUtils.equals(existingLabel, nonLocalizedLabel) == true) goto L10;
    L13:
        boolean changed = true;
    L15:
        if (changed == false) goto L26;
        if (nonLocalizedLabel != null) goto L22;
        if (icon != null) goto L22;
        this.mComponentLabelIconOverrideMap.remove(component);
        if (this.mComponentLabelIconOverrideMap.isEmpty() == false) goto L25;
        this.mComponentLabelIconOverrideMap = null;
    L25:
        onChanged();
    L22:
        if (this.mComponentLabelIconOverrideMap != null) goto L24;
        this.mComponentLabelIconOverrideMap = new WatchedArrayMap(1);
        this.mComponentLabelIconOverrideMap.registerObserver(this.mSnapshot);
    L24:
        this.mComponentLabelIconOverrideMap.put(component, Pair.create(nonLocalizedLabel, icon));
    L26:
        return changed;
    L10:
        if (Objects.equals(existingIcon, icon) == false) goto L13;
        changed = false;
        goto L15
    }

    public void resetOverrideComponentLabelIcon() {
        this.mComponentLabelIconOverrideMap = null;
    }

    @Override // com.android.server.pm.pkg.PackageUserStateInternal
    public Pair<String, Integer> getOverrideLabelIconForComponent(ComponentName componentName) {
        if (ArrayUtils.isEmpty(this.mComponentLabelIconOverrideMap) == false) goto L7;
        return null;
    L7:
        return this.mComponentLabelIconOverrideMap.get(componentName);
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public boolean isSuspended() {
        return !CollectionUtils.isEmpty(this.mSuspendParams);
    }

    public PackageUserStateImpl putSuspendParams(UserPackage suspendingPackage, SuspendParams suspendParams) {
        if (this.mSuspendParams != null) goto L6;
        this.mSuspendParams = new WatchedArrayMap();
        this.mSuspendParams.registerObserver(this.mSnapshot);
    L6:
        if (this.mSuspendParams.containsKey(suspendingPackage) == true) goto L8;
    L9:
        this.mSuspendParams.put(suspendingPackage, suspendParams);
        onChanged();
    L10:
        return this;
    L8:
        if (Objects.equals(this.mSuspendParams.get(suspendingPackage), suspendParams) == true) goto L10;
        goto L9
    }

    public PackageUserStateImpl removeSuspension(UserPackage suspendingPackage) {
        if (this.mSuspendParams == null) goto L5;
        this.mSuspendParams.remove(suspendingPackage);
        onChanged();
    L5:
        return this;
    }

    public PackageUserStateImpl setDisabledComponents(ArraySet<String> value) {
        if (this.mDisabledComponentsWatched != null) goto L5;
        this.mDisabledComponentsWatched = new WatchedArraySet();
        this.mDisabledComponentsWatched.registerObserver(this.mSnapshot);
    L5:
        this.mDisabledComponentsWatched.clear();
        if (value == null) goto L8;
        this.mDisabledComponentsWatched.addAll(value);
    L8:
        onChanged();
        return this;
    }

    public PackageUserStateImpl setEnabledComponents(ArraySet<String> value) {
        if (this.mEnabledComponentsWatched != null) goto L5;
        this.mEnabledComponentsWatched = new WatchedArraySet();
        this.mEnabledComponentsWatched.registerObserver(this.mSnapshot);
    L5:
        this.mEnabledComponentsWatched.clear();
        if (value == null) goto L8;
        this.mEnabledComponentsWatched.addAll(value);
    L8:
        onChanged();
        return this;
    }

    public PackageUserStateImpl setEnabledComponents(WatchedArraySet<String> value) {
        this.mEnabledComponentsWatched = value;
        if (this.mEnabledComponentsWatched == null) goto L5;
        this.mEnabledComponentsWatched.registerObserver(this.mSnapshot);
    L5:
        onChanged();
        return this;
    }

    public PackageUserStateImpl setDisabledComponents(WatchedArraySet<String> value) {
        this.mDisabledComponentsWatched = value;
        if (this.mDisabledComponentsWatched == null) goto L5;
        this.mDisabledComponentsWatched.registerObserver(this.mSnapshot);
    L5:
        onChanged();
        return this;
    }

    public PackageUserStateImpl setCeDataInode(long value) {
        this.mCeDataInode = value;
        onChanged();
        return this;
    }

    public PackageUserStateImpl setDeDataInode(long value) {
        this.mDeDataInode = value;
        onChanged();
        return this;
    }

    public PackageUserStateImpl setInstalled(boolean value) {
        setBoolean(1, value);
        onChanged();
        return this;
    }

    public PackageUserStateImpl setStopped(boolean value) {
        setBoolean(2, value);
        onChanged();
        return this;
    }

    public PackageUserStateImpl setNotLaunched(boolean value) {
        setBoolean(4, value);
        onChanged();
        return this;
    }

    public PackageUserStateImpl setHidden(boolean value) {
        setBoolean(8, value);
        onChanged();
        return this;
    }

    public PackageUserStateImpl setDistractionFlags(int value) {
        this.mDistractionFlags = value;
        onChanged();
        return this;
    }

    public PackageUserStateImpl setInstantApp(boolean value) {
        setBoolean(16, value);
        onChanged();
        return this;
    }

    public PackageUserStateImpl setVirtualPreload(boolean value) {
        setBoolean(32, value);
        onChanged();
        return this;
    }

    public PackageUserStateImpl setEnabledState(int value) {
        this.mEnabledState = value;
        onChanged();
        return this;
    }

    public PackageUserStateImpl setInstallReason(int value) {
        this.mInstallReason = value;
        AnnotationValidations.validate(PackageManager.InstallReason.class, null, this.mInstallReason);
        onChanged();
        return this;
    }

    public PackageUserStateImpl setUninstallReason(int value) {
        this.mUninstallReason = value;
        AnnotationValidations.validate(PackageManager.UninstallReason.class, null, this.mUninstallReason);
        onChanged();
        return this;
    }

    public PackageUserStateImpl setHarmfulAppWarning(String value) {
        this.mHarmfulAppWarning = value;
        onChanged();
        return this;
    }

    public PackageUserStateImpl setLastDisableAppCaller(String value) {
        this.mLastDisableAppCaller = value;
        onChanged();
        return this;
    }

    public PackageUserStateImpl setSharedLibraryOverlayPaths(ArrayMap<String, OverlayPaths> value) {
        if (value != null) goto L5;
        return this;
    L5:
        if (this.mSharedLibraryOverlayPaths != null) goto L7;
        this.mSharedLibraryOverlayPaths = new WatchedArrayMap();
        registerObserver(this.mSnapshot);
    L7:
        this.mSharedLibraryOverlayPaths.clear();
        this.mSharedLibraryOverlayPaths.putAll(value);
        onChanged();
        return this;
    }

    public PackageUserStateImpl setSplashScreenTheme(String value) {
        this.mSplashScreenTheme = value;
        onChanged();
        return this;
    }

    public PackageUserStateImpl setMinAspectRatio(int value) {
        this.mMinAspectRatio = value;
        AnnotationValidations.validate(PackageManager.UserMinAspectRatio.class, null, this.mMinAspectRatio);
        onChanged();
        return this;
    }

    public PackageUserStateImpl setSuspendParams(ArrayMap<UserPackage, SuspendParams> value) {
        if (value != null) goto L5;
        return this;
    L5:
        if (this.mSuspendParams != null) goto L7;
        this.mSuspendParams = new WatchedArrayMap();
        registerObserver(this.mSnapshot);
    L7:
        this.mSuspendParams.clear();
        this.mSuspendParams.putAll(value);
        onChanged();
        return this;
    }

    public PackageUserStateImpl setComponentLabelIconOverrideMap(ArrayMap<ComponentName, Pair<String, Integer>> value) {
        if (value != null) goto L5;
        return this;
    L5:
        if (this.mComponentLabelIconOverrideMap != null) goto L7;
        this.mComponentLabelIconOverrideMap = new WatchedArrayMap();
        registerObserver(this.mSnapshot);
    L7:
        this.mComponentLabelIconOverrideMap.clear();
        this.mComponentLabelIconOverrideMap.putAll(value);
        onChanged();
        return this;
    }

    public PackageUserStateImpl setFirstInstallTimeMillis(long value) {
        this.mFirstInstallTimeMillis = value;
        onChanged();
        return this;
    }

    public PackageUserStateImpl setArchiveState(ArchiveState archiveState) {
        this.mArchiveState = archiveState;
        onChanged();
        return this;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public Map<String, OverlayPaths> getSharedLibraryOverlayPaths() {
        if (this.mSharedLibraryOverlayPaths != null) goto L6;
        return Collections.emptyMap();
    L6:
        return this.mSharedLibraryOverlayPaths;
    }

    public PackageUserStateImpl setWatchable(Watchable watchable) {
        this.mWatchable = watchable;
        return this;
    }

    private boolean watchableEquals(Watchable other) {
        return true;
    }

    private int watchableHashCode() {
        return 0;
    }

    private boolean snapshotEquals(SnapshotCache<PackageUserStateImpl> other) {
        return true;
    }

    private int snapshotHashCode() {
        return 0;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public boolean isInstalled() {
        return getBoolean(1);
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public boolean isStopped() {
        return getBoolean(2);
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public boolean isNotLaunched() {
        return getBoolean(4);
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public boolean isHidden() {
        return getBoolean(8);
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public boolean isInstantApp() {
        return getBoolean(16);
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public boolean isVirtualPreload() {
        return getBoolean(32);
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public boolean isQuarantined() {
        if (isSuspended() == true) goto L5;
        return false;
    L5:
        WatchedArrayMap<UserPackage, SuspendParams> suspendParams = this.mSuspendParams;
        int i = 0;
        int size = suspendParams.size();
    L6:
        if (i >= size) goto L13;
        SuspendParams params = suspendParams.valueAt(i);
        if (params.isQuarantined() == true) goto L9;
        i = i + 1;
        goto L6
    L9:
        return true;
    L13:
        return false;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public boolean dataExists() {
        if (getCeDataInode() <= 0) goto L5;
    L8:
        return true;
    L5:
        if (getDeDataInode() > 0) goto L8;
        return false;
    }

    public WatchedArraySet<String> getDisabledComponentsWatched() {
        return this.mDisabledComponentsWatched;
    }

    public WatchedArraySet<String> getEnabledComponentsWatched() {
        return this.mEnabledComponentsWatched;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public long getCeDataInode() {
        return this.mCeDataInode;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public long getDeDataInode() {
        return this.mDeDataInode;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public int getDistractionFlags() {
        return this.mDistractionFlags;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public int getEnabledState() {
        return this.mEnabledState;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public int getInstallReason() {
        return this.mInstallReason;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public int getUninstallReason() {
        return this.mUninstallReason;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public String getHarmfulAppWarning() {
        return this.mHarmfulAppWarning;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public String getLastDisableAppCaller() {
        return this.mLastDisableAppCaller;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public OverlayPaths getOverlayPaths() {
        return this.mOverlayPaths;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public String getSplashScreenTheme() {
        return this.mSplashScreenTheme;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public int getMinAspectRatio() {
        return this.mMinAspectRatio;
    }

    @Override // com.android.server.pm.pkg.PackageUserStateInternal
    public WatchedArrayMap<UserPackage, SuspendParams> getSuspendParams() {
        return this.mSuspendParams;
    }

    public WatchedArrayMap<ComponentName, Pair<String, Integer>> getComponentLabelIconOverrideMap() {
        return this.mComponentLabelIconOverrideMap;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public long getFirstInstallTimeMillis() {
        return this.mFirstInstallTimeMillis;
    }

    @Override // com.android.server.pm.pkg.PackageUserState
    public ArchiveState getArchiveState() {
        return this.mArchiveState;
    }

    public SnapshotCache<PackageUserStateImpl> getSnapshot() {
        return this.mSnapshot;
    }

    public PackageUserStateImpl setBooleans(int value) {
        this.mBooleans = value;
        return this;
    }

    public PackageUserStateImpl setDisabledComponentsWatched(WatchedArraySet<String> value) {
        this.mDisabledComponentsWatched = value;
        return this;
    }

    public PackageUserStateImpl setEnabledComponentsWatched(WatchedArraySet<String> value) {
        this.mEnabledComponentsWatched = value;
        return this;
    }

    public PackageUserStateImpl setSharedLibraryOverlayPaths(WatchedArrayMap<String, OverlayPaths> value) {
        this.mSharedLibraryOverlayPaths = value;
        return this;
    }

    public PackageUserStateImpl setSuspendParams(WatchedArrayMap<UserPackage, SuspendParams> value) {
        this.mSuspendParams = value;
        return this;
    }

    public PackageUserStateImpl setComponentLabelIconOverrideMap(WatchedArrayMap<ComponentName, Pair<String, Integer>> value) {
        this.mComponentLabelIconOverrideMap = value;
        return this;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L55:
        return false;
    L8:
        if (getClass() != o.getClass()) goto L55;
        PackageUserStateImpl that = (PackageUserStateImpl) o;
        if (this.mBooleans != that.mBooleans) goto L54;
        if (Objects.equals(this.mDisabledComponentsWatched, that.mDisabledComponentsWatched) == false) goto L54;
        if (Objects.equals(this.mEnabledComponentsWatched, that.mEnabledComponentsWatched) == false) goto L54;
        if (this.mCeDataInode != that.mCeDataInode) goto L54;
        if (this.mDeDataInode != that.mDeDataInode) goto L54;
        if (this.mDistractionFlags != that.mDistractionFlags) goto L54;
        if (this.mEnabledState != that.mEnabledState) goto L54;
        if (this.mInstallReason != that.mInstallReason) goto L54;
        if (this.mUninstallReason != that.mUninstallReason) goto L54;
        if (Objects.equals(this.mHarmfulAppWarning, that.mHarmfulAppWarning) == false) goto L54;
        if (Objects.equals(this.mLastDisableAppCaller, that.mLastDisableAppCaller) == false) goto L54;
        if (Objects.equals(this.mOverlayPaths, that.mOverlayPaths) == false) goto L54;
        if (Objects.equals(this.mSharedLibraryOverlayPaths, that.mSharedLibraryOverlayPaths) == false) goto L54;
        if (Objects.equals(this.mSplashScreenTheme, that.mSplashScreenTheme) == false) goto L54;
        if (this.mMinAspectRatio != that.mMinAspectRatio) goto L54;
        if (Objects.equals(this.mSuspendParams, that.mSuspendParams) == false) goto L54;
        if (Objects.equals(this.mComponentLabelIconOverrideMap, that.mComponentLabelIconOverrideMap) == false) goto L54;
        if (this.mFirstInstallTimeMillis != that.mFirstInstallTimeMillis) goto L54;
        if (watchableEquals(that.mWatchable) == false) goto L54;
        if (Objects.equals(this.mArchiveState, that.mArchiveState) == false) goto L54;
        if (snapshotEquals(that.mSnapshot) == false) goto L54;
        return true;
    L54:
        return false;
    }

    public int hashCode() {
        int _hash = (1 * 31) + this.mBooleans;
        return (((((((((((((((((((((((((((((((((((((((_hash * 31) + Objects.hashCode(this.mDisabledComponentsWatched)) * 31) + Objects.hashCode(this.mEnabledComponentsWatched)) * 31) + Long.hashCode(this.mCeDataInode)) * 31) + Long.hashCode(this.mDeDataInode)) * 31) + this.mDistractionFlags) * 31) + this.mEnabledState) * 31) + this.mInstallReason) * 31) + this.mUninstallReason) * 31) + Objects.hashCode(this.mHarmfulAppWarning)) * 31) + Objects.hashCode(this.mLastDisableAppCaller)) * 31) + Objects.hashCode(this.mOverlayPaths)) * 31) + Objects.hashCode(this.mSharedLibraryOverlayPaths)) * 31) + Objects.hashCode(this.mSplashScreenTheme)) * 31) + this.mMinAspectRatio) * 31) + Objects.hashCode(this.mSuspendParams)) * 31) + Objects.hashCode(this.mComponentLabelIconOverrideMap)) * 31) + Long.hashCode(this.mFirstInstallTimeMillis)) * 31) + watchableHashCode()) * 31) + Objects.hashCode(this.mArchiveState)) * 31) + snapshotHashCode();
    }

    @Deprecated
    private void __metadata() {
    }

    @Override // com.android.server.pm.pkg.PackageUserStateInternal
    public PackageUserStateImplSmtEx getSmtEx() {
        return this.mSmtEx;
    }
}
