package com.android.server.permission.access.appop;

import android.app.AppOpsManager;
import android.util.Slog;
import com.android.server.permission.access.GetStateScope;
import com.android.server.permission.access.MutableAccessState;
import com.android.server.permission.access.MutableUserState;
import com.android.server.permission.access.MutateStateScope;
import com.android.server.permission.access.UserState;
import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.access.immutable.IndexedListSet;
import com.android.server.permission.access.immutable.IndexedListSetExtensionsKt;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.IndexedMapExtensionsKt;
import com.android.server.permission.access.immutable.IndexedReferenceMap;
import com.android.server.permission.access.immutable.IntReferenceMap;
import com.android.server.permission.access.immutable.MutableIndexedListSet;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIndexedReferenceMap;
import com.android.server.permission.jarjar.kotlin.Unit;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.pm.Settings;
import com.android.server.pm.pkg.PackageState;

/* JADX INFO: compiled from: PackageAppOpPolicy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PackageAppOpPolicy extends BaseAppOpPolicy {
    public static final Companion Companion = null;
    private static final String LOG_TAG = null;
    private final PackageAppOpMigration migration;
    private volatile IndexedListSet<OnAppOpModeChangedListener> onAppOpModeChangedListeners;
    private final Object onAppOpModeChangedListenersLock;
    private final PackageAppOpUpgrade upgrade;

    /* JADX INFO: compiled from: PackageAppOpPolicy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: PackageAppOpPolicy.kt */
    public static abstract class OnAppOpModeChangedListener {
        public abstract void onAppOpModeChanged(String r1, int r2, String r3, int r4, int r5);

        public abstract void onStateMutated();

        public OnAppOpModeChangedListener() {
        }
    }

    public PackageAppOpPolicy() {
        super(new PackageAppOpPersistence());
        this.migration = new PackageAppOpMigration();
        this.upgrade = new PackageAppOpUpgrade(this);
        this.onAppOpModeChangedListeners = new MutableIndexedListSet(null, 1, null);
        this.onAppOpModeChangedListenersLock = new Object();
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public String getSubjectScheme() {
        return Settings.ATTR_PACKAGE;
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onStateMutated(GetStateScope $this$onStateMutated) {
        IndexedListSet<OnAppOpModeChangedListener> r0 = this.onAppOpModeChangedListeners;
        int index$iv = 0;
        int r3 = r0.getSize();
    L3:
        if (index$iv >= r3) goto L6;
        OnAppOpModeChangedListener it = r0.elementAt(index$iv);
        it.onStateMutated();
        index$iv = index$iv + 1;
        goto L3
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onPackageRemoved(MutateStateScope $this$onPackageRemoved, String packageName, int appId) {
        IntReferenceMap<UserState, MutableUserState> r0 = $this$onPackageRemoved.getNewState().getUserStates();
        int index$iv = 0;
        int r3 = r0.getSize();
    L3:
        if (index$iv >= r3) goto L9;
        r0.keyAt(index$iv);
        UserState userState = (UserState) r0.valueAt(index$iv);
        int userStateIndex = index$iv;
        int packageNameIndex = userState.getPackageAppOpModes().indexOfKey(packageName);
        if (packageNameIndex < 0) goto L7;
        MutableAccessState.mutateUserStateAt$default($this$onPackageRemoved.getNewState(), userStateIndex, 0, 2, null).mutatePackageAppOpModes().removeAt(packageNameIndex);
    L7:
        index$iv = index$iv + 1;
        goto L3
    }

    public final IndexedMap<String, Integer> getAppOpModes(GetStateScope $this$getAppOpModes, String packageName, int userId) {
        UserState r0 = (UserState) $this$getAppOpModes.getState().getUserStates().get(userId);
        if (r0 == null) goto L7;
        IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r1 = r0.getPackageAppOpModes();
        if (r1 == null) goto L7;
        return (IndexedMap) r1.get(packageName);
    L7:
        return null;
    }

    public final boolean removeAppOpModes(MutateStateScope $this$removeAppOpModes, String packageName, int userId) {
        int userStateIndex = $this$removeAppOpModes.getNewState().getUserStates().indexOfKey(userId);
        if (userStateIndex >= 0) goto L5;
        return false;
    L5:
        int packageNameIndex = ((UserState) $this$removeAppOpModes.getNewState().getUserStates().valueAt(userStateIndex)).getPackageAppOpModes().indexOfKey(packageName);
        if (packageNameIndex >= 0) goto L8;
        return false;
    L8:
        MutableAccessState.mutateUserStateAt$default($this$removeAppOpModes.getNewState(), userStateIndex, 0, 2, null).mutatePackageAppOpModes().removeAt(packageNameIndex);
        return true;
    }

    public final int getAppOpMode(GetStateScope $this$getAppOpMode, String packageName, int userId, String appOpName) {
        UserState r0 = (UserState) $this$getAppOpMode.getState().getUserStates().get(userId);
        if (r0 == null) goto L7;
        IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r1 = r0.getPackageAppOpModes();
        if (r1 == null) goto L7;
        IndexedMap r2 = (IndexedMap) r1.get(packageName);
    L9:
        return ((Number) IndexedMapExtensionsKt.getWithDefault(r2, appOpName, Integer.valueOf(AppOpsManager.opToDefaultMode(appOpName)))).intValue();
    L7:
        r2 = null;
        goto L9
    }

    public final boolean setAppOpMode(MutateStateScope $this$setAppOpMode, String packageName, int userId, String appOpName, int mode) {
        String r1 = packageName;
        int r2 = userId;
        String r3 = appOpName;
        if ($this$setAppOpMode.getNewState().getUserStates().contains(r2) == true) goto L6;
        Slog.e(LOG_TAG, "Unable to set app op mode for missing user " + r2);
        return false;
    L6:
        int defaultMode = AppOpsManager.opToDefaultMode(r3);
        Immutable r0 = $this$setAppOpMode.getNewState().getUserStates().get(r2);
        Intrinsics.checkNotNull(r0);
        int oldMode = ((Number) IndexedMapExtensionsKt.getWithDefault((IndexedMap) ((UserState) r0).getPackageAppOpModes().get(r1), r3, Integer.valueOf(defaultMode))).intValue();
        int r5 = mode;
        if (oldMode != r5) goto L9;
        return false;
    L9:
        MutableUserState r4 = MutableAccessState.mutateUserState$default($this$setAppOpMode.getNewState(), r2, 0, 2, null);
        Intrinsics.checkNotNull(r4);
        MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r7 = r4.mutatePackageAppOpModes();
        Immutable r10 = r7.mutate(r1);
        if (r10 != null) goto L13;
        Immutable it$iv = new MutableIndexedMap(null, 1, null);
        r7.put(r1, it$iv);
        r10 = it$iv;
    L13:
        MutableIndexedMap appOpModes = (MutableIndexedMap) r10;
        IndexedMapExtensionsKt.putWithDefault(appOpModes, r3, Integer.valueOf(r5), Integer.valueOf(defaultMode));
        if (appOpModes.isEmpty() == false) goto L16;
        r7.remove(r1);
    L16:
        IndexedListSet<OnAppOpModeChangedListener> r11 = this.onAppOpModeChangedListeners;
        int r13 = r11.getSize();
        int index$iv = 0;
    L17:
        if (index$iv >= r13) goto L20;
        OnAppOpModeChangedListener it = r11.elementAt(index$iv);
        int oldMode2 = oldMode;
        it.onAppOpModeChanged(r1, r2, r3, oldMode2, r5);
        index$iv = index$iv + 1;
        r1 = packageName;
        r2 = userId;
        r3 = appOpName;
        r5 = mode;
        oldMode = oldMode2;
        goto L17
    L20:
        return true;
    }

    public final void addOnAppOpModeChangedListener(OnAppOpModeChangedListener listener) {
        Object r0 = this.onAppOpModeChangedListenersLock;
        monitor-enter(r0);
        this.onAppOpModeChangedListeners = IndexedListSetExtensionsKt.plus(this.onAppOpModeChangedListeners, listener);     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void migrateUserState(MutableAccessState state, int userId) {
        PackageAppOpMigration $this$migrateUserState_u24lambda_u246 = this.migration;
        $this$migrateUserState_u24lambda_u246.migrateUserState(state, userId);
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void upgradePackageState(MutateStateScope $this$upgradePackageState, PackageState packageState, int userId, int version) {
        PackageAppOpUpgrade $this$upgradePackageState_u24lambda_u247 = this.upgrade;
        $this$upgradePackageState_u24lambda_u247.upgradePackageState($this$upgradePackageState, packageState, userId, version);
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = PackageAppOpPolicy.class.getSimpleName();
    }
}
