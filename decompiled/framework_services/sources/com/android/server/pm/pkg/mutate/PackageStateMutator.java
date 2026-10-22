package com.android.server.pm.pkg.mutate;

import android.content.ComponentName;
import android.content.pm.UserPackage;
import android.content.pm.overlay.OverlayPaths;
import android.util.ArraySet;
import com.android.server.pm.PackageSetting;
import com.android.server.pm.pkg.PackageUserStateImpl;
import com.android.server.pm.pkg.SuspendParams;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class PackageStateMutator {
    private static final AtomicLong sStateChangeSequence = null;
    private final Function<String, PackageSetting> mActiveStateFunction;
    private final ArraySet<PackageSetting> mChangedStates;
    private final Function<String, PackageSetting> mDisabledStateFunction;
    private final StateWriteWrapper mStateWrite;

    public static class InitialState {
        private final int mPackageSequence;
        private final long mStateSequence;

        /* JADX INFO: renamed from: -$$Nest$fgetmPackageSequence, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7114$$Nest$fgetmPackageSequence(InitialState r0) {
            return r0.mPackageSequence;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmStateSequence, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m7115$$Nest$fgetmStateSequence(InitialState r2) {
            return r2.mStateSequence;
        }

        public InitialState(int packageSequence, long stateSequence) {
            this.mPackageSequence = packageSequence;
            this.mStateSequence = stateSequence;
        }
    }

    public static class Result {
        public static final Result PACKAGES_AND_STATE_CHANGED = null;
        public static final Result PACKAGES_CHANGED = null;
        public static final Result SPECIFIC_PACKAGE_NULL = null;
        public static final Result STATE_CHANGED = null;
        public static final Result SUCCESS = null;
        private final boolean mCommitted;
        private final boolean mPackagesChanged;
        private final boolean mSpecificPackageNull;
        private final boolean mStateChanged;

        static {
            SUCCESS = new Result(true, false, false, false);
            PACKAGES_CHANGED = new Result(false, true, false, false);
            STATE_CHANGED = new Result(false, false, true, false);
            PACKAGES_AND_STATE_CHANGED = new Result(false, true, true, false);
            SPECIFIC_PACKAGE_NULL = new Result(false, false, true, true);
        }

        public Result(boolean committed, boolean packagesChanged, boolean stateChanged, boolean specificPackageNull) {
            this.mCommitted = committed;
            this.mPackagesChanged = packagesChanged;
            this.mStateChanged = stateChanged;
            this.mSpecificPackageNull = specificPackageNull;
        }

        public boolean isCommitted() {
            return this.mCommitted;
        }

        public boolean isPackagesChanged() {
            return this.mPackagesChanged;
        }

        public boolean isStateChanged() {
            return this.mStateChanged;
        }

        public boolean isSpecificPackageNull() {
            return this.mSpecificPackageNull;
        }
    }

    private static class StateWriteWrapper implements PackageStateWrite {
        private PackageSetting mState;
        private final UserStateWriteWrapper mUserStateWrite;

        private static class UserStateWriteWrapper implements PackageUserStateWrite {
            private PackageUserStateImpl mUserState;

            /* synthetic */ UserStateWriteWrapper(PackageStateMutatorIA r1) {
                this();
            }

            private UserStateWriteWrapper() {
            }

            public UserStateWriteWrapper setStates(PackageUserStateImpl userState) {
                this.mUserState = userState;
                return this;
            }

            @Override // com.android.server.pm.pkg.mutate.PackageUserStateWrite
            public PackageUserStateWrite setInstalled(boolean installed) {
                if (this.mUserState == null) goto L5;
                this.mUserState.setInstalled(installed);
            L5:
                return this;
            }

            @Override // com.android.server.pm.pkg.mutate.PackageUserStateWrite
            public PackageUserStateWrite setUninstallReason(int reason) {
                if (this.mUserState == null) goto L5;
                this.mUserState.setUninstallReason(reason);
            L5:
                return this;
            }

            @Override // com.android.server.pm.pkg.mutate.PackageUserStateWrite
            public PackageUserStateWrite setDistractionFlags(int restrictionFlags) {
                if (this.mUserState == null) goto L5;
                this.mUserState.setDistractionFlags(restrictionFlags);
            L5:
                return this;
            }

            @Override // com.android.server.pm.pkg.mutate.PackageUserStateWrite
            public PackageUserStateWrite putSuspendParams(UserPackage suspendingPackage, SuspendParams suspendParams) {
                if (this.mUserState == null) goto L5;
                this.mUserState.putSuspendParams(suspendingPackage, suspendParams);
            L5:
                return this;
            }

            @Override // com.android.server.pm.pkg.mutate.PackageUserStateWrite
            public PackageUserStateWrite removeSuspension(UserPackage suspendingPackage) {
                if (this.mUserState == null) goto L5;
                this.mUserState.removeSuspension(suspendingPackage);
            L5:
                return this;
            }

            @Override // com.android.server.pm.pkg.mutate.PackageUserStateWrite
            public PackageUserStateWrite setHidden(boolean hidden) {
                if (this.mUserState == null) goto L5;
                this.mUserState.setHidden(hidden);
            L5:
                return this;
            }

            @Override // com.android.server.pm.pkg.mutate.PackageUserStateWrite
            public PackageUserStateWrite setStopped(boolean stopped) {
                if (this.mUserState == null) goto L5;
                this.mUserState.setStopped(stopped);
            L5:
                return this;
            }

            @Override // com.android.server.pm.pkg.mutate.PackageUserStateWrite
            public PackageUserStateWrite setNotLaunched(boolean notLaunched) {
                if (this.mUserState == null) goto L5;
                this.mUserState.setNotLaunched(notLaunched);
            L5:
                return this;
            }

            @Override // com.android.server.pm.pkg.mutate.PackageUserStateWrite
            public PackageUserStateWrite setOverlayPaths(OverlayPaths overlayPaths) {
                if (this.mUserState == null) goto L5;
                this.mUserState.setOverlayPaths(overlayPaths);
            L5:
                return this;
            }

            @Override // com.android.server.pm.pkg.mutate.PackageUserStateWrite
            public PackageUserStateWrite setOverlayPathsForLibrary(String libraryName, OverlayPaths overlayPaths) {
                if (this.mUserState == null) goto L5;
                this.mUserState.setSharedLibraryOverlayPaths(libraryName, overlayPaths);
            L5:
                return this;
            }

            @Override // com.android.server.pm.pkg.mutate.PackageUserStateWrite
            public PackageUserStateWrite setHarmfulAppWarning(String warning) {
                if (this.mUserState == null) goto L5;
                this.mUserState.setHarmfulAppWarning(warning);
            L5:
                return this;
            }

            @Override // com.android.server.pm.pkg.mutate.PackageUserStateWrite
            public PackageUserStateWrite setSplashScreenTheme(String theme) {
                if (this.mUserState == null) goto L5;
                this.mUserState.setSplashScreenTheme(theme);
            L5:
                return this;
            }

            @Override // com.android.server.pm.pkg.mutate.PackageUserStateWrite
            public PackageUserStateWrite setComponentLabelIcon(ComponentName componentName, String nonLocalizedLabel, Integer icon) {
                if (this.mUserState == null) goto L7;
                this.mUserState.overrideLabelAndIcon(componentName, nonLocalizedLabel, icon);
                return null;
            L7:
                return null;
            }

            @Override // com.android.server.pm.pkg.mutate.PackageUserStateWrite
            public PackageUserStateWrite setMinAspectRatio(int aspectRatio) {
                if (this.mUserState == null) goto L5;
                this.mUserState.setMinAspectRatio(aspectRatio);
            L5:
                return this;
            }
        }

        /* synthetic */ StateWriteWrapper(PackageStateMutatorIA r1) {
            this();
        }

        private StateWriteWrapper() {
            this.mUserStateWrite = new UserStateWriteWrapper(null);
        }

        public StateWriteWrapper setState(PackageSetting state) {
            this.mState = state;
            return this;
        }

        @Override // com.android.server.pm.pkg.mutate.PackageStateWrite
        public PackageUserStateWrite userState(int userId) {
            if (this.mState != null) goto L5;
            PackageUserStateImpl userState = null;
        L6:
            if (userState == null) goto L9;
            userState.setWatchable(this.mState);
        L9:
            return this.mUserStateWrite.setStates(userState);
        L5:
            userState = this.mState.getOrCreateUserState(userId);
            goto L6
        }

        @Override // com.android.server.pm.pkg.mutate.PackageStateWrite
        public void onChanged() {
            if (this.mState == null) goto L6;
            this.mState.onChanged();
            return;
        }

        @Override // com.android.server.pm.pkg.mutate.PackageStateWrite
        public PackageStateWrite setLastPackageUsageTime(int reason, long timeInMillis) {
            if (this.mState == null) goto L5;
            this.mState.getTransientState().setLastPackageUsageTimeInMills(reason, timeInMillis);
        L5:
            return this;
        }

        @Override // com.android.server.pm.pkg.mutate.PackageStateWrite
        public PackageStateWrite setHiddenUntilInstalled(boolean value) {
            if (this.mState == null) goto L5;
            this.mState.getTransientState().setHiddenUntilInstalled(value);
        L5:
            return this;
        }

        @Override // com.android.server.pm.pkg.mutate.PackageStateWrite
        public PackageStateWrite setRequiredForSystemUser(boolean requiredForSystemUser) {
            if (this.mState == null) goto L7;
            if (requiredForSystemUser == false) goto L6;
            this.mState.setPrivateFlags(this.mState.getPrivateFlags() | 512);
            goto L7
        L6:
            this.mState.setPrivateFlags(this.mState.getPrivateFlags() & (-513));
        L7:
            return this;
        }

        @Override // com.android.server.pm.pkg.mutate.PackageStateWrite
        public PackageStateWrite setMimeGroup(String mimeGroup, ArraySet<String> mimeTypes) {
            if (this.mState == null) goto L5;
            this.mState.setMimeGroup(mimeGroup, mimeTypes);
        L5:
            return this;
        }

        @Override // com.android.server.pm.pkg.mutate.PackageStateWrite
        public PackageStateWrite setCategoryOverride(int category) {
            if (this.mState == null) goto L5;
            this.mState.setCategoryOverride(category);
        L5:
            return this;
        }

        @Override // com.android.server.pm.pkg.mutate.PackageStateWrite
        public PackageStateWrite setPageSizeAppCompatFlags(int mode) {
            if (this.mState == null) goto L5;
            this.mState.setPageSizeAppCompatFlags(mode);
        L5:
            return this;
        }

        @Override // com.android.server.pm.pkg.mutate.PackageStateWrite
        public PackageStateWrite setUpdateAvailable(boolean updateAvailable) {
            if (this.mState == null) goto L5;
            this.mState.setUpdateAvailable(updateAvailable);
        L5:
            return this;
        }

        @Override // com.android.server.pm.pkg.mutate.PackageStateWrite
        public PackageStateWrite setLoadingProgress(float progress) {
            if (this.mState == null) goto L5;
            this.mState.setLoadingProgress(progress);
        L5:
            return this;
        }

        @Override // com.android.server.pm.pkg.mutate.PackageStateWrite
        public PackageStateWrite setLoadingCompletedTime(long loadingCompletedTime) {
            if (this.mState == null) goto L5;
            this.mState.setLoadingCompletedTime(loadingCompletedTime);
        L5:
            return this;
        }

        @Override // com.android.server.pm.pkg.mutate.PackageStateWrite
        public PackageStateWrite setOverrideSeInfo(String newSeInfo) {
            if (this.mState == null) goto L5;
            this.mState.getTransientState().setOverrideSeInfo(newSeInfo);
        L5:
            return this;
        }

        @Override // com.android.server.pm.pkg.mutate.PackageStateWrite
        public PackageStateWrite setInstaller(String installerPackageName, int installerPackageUid) {
            if (this.mState == null) goto L5;
            this.mState.setInstallerPackage(installerPackageName, installerPackageUid);
        L5:
            return this;
        }

        @Override // com.android.server.pm.pkg.mutate.PackageStateWrite
        public PackageStateWrite setUpdateOwner(String updateOwnerPackageName) {
            if (this.mState == null) goto L5;
            this.mState.setUpdateOwnerPackage(updateOwnerPackageName);
        L5:
            return this;
        }
    }

    static {
        sStateChangeSequence = new AtomicLong();
    }

    public PackageStateMutator(Function<String, PackageSetting> activeStateFunction, Function<String, PackageSetting> disabledStateFunction) {
        this.mStateWrite = new StateWriteWrapper(null);
        this.mChangedStates = new ArraySet();
        this.mActiveStateFunction = activeStateFunction;
        this.mDisabledStateFunction = disabledStateFunction;
    }

    public static void onPackageStateChanged() {
        sStateChangeSequence.incrementAndGet();
    }

    public PackageStateWrite forPackage(String packageName) {
        return setState(this.mActiveStateFunction.apply(packageName));
    }

    public PackageStateWrite forPackageNullable(String packageName) {
        PackageSetting packageState = this.mActiveStateFunction.apply(packageName);
        setState(packageState);
        if (packageState != null) goto L7;
        return null;
    L7:
        return setState(packageState);
    }

    public PackageStateWrite forDisabledSystemPackage(String packageName) {
        return setState(this.mDisabledStateFunction.apply(packageName));
    }

    public PackageStateWrite forDisabledSystemPackageNullable(String packageName) {
        PackageSetting packageState = this.mDisabledStateFunction.apply(packageName);
        if (packageState != null) goto L7;
        return null;
    L7:
        return setState(packageState);
    }

    public InitialState initialState(int changedPackagesSequenceNumber) {
        return new InitialState(changedPackagesSequenceNumber, sStateChangeSequence.get());
    }

    public Result generateResult(InitialState state, int changedPackagesSequenceNumber) {
        if (state == null) goto L4;
        boolean stateChanged = false;
        if (changedPackagesSequenceNumber == InitialState.m7114$$Nest$fgetmPackageSequence(state)) goto L8;
        boolean packagesChanged = true;
    L10:
        if (sStateChangeSequence.get() == InitialState.m7115$$Nest$fgetmStateSequence(state)) goto L12;
        stateChanged = true;
    L12:
        if (packagesChanged == false) goto L16;
        if (stateChanged == false) goto L16;
        return Result.PACKAGES_AND_STATE_CHANGED;
    L16:
        if (packagesChanged == true) goto L18;
        if (stateChanged == false) goto L23;
        return Result.STATE_CHANGED;
    L23:
        return Result.SUCCESS;
    L18:
        return Result.PACKAGES_CHANGED;
    L8:
        packagesChanged = false;
        goto L10
    L4:
        return Result.SUCCESS;
    }

    public void onFinished() {
        int index = 0;
    L4:
        if (index >= this.mChangedStates.size()) goto L7;
        this.mChangedStates.valueAt(index).onChanged();
        index = index + 1;
        goto L4
    }

    private StateWriteWrapper setState(PackageSetting state) {
        if (state == null) goto L5;
        this.mChangedStates.add(state);
    L5:
        return this.mStateWrite.setState(state);
    }
}
