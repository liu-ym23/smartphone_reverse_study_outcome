package com.android.server.pm;

import android.content.pm.IPackageInstallObserver2;
import android.content.pm.SigningDetails;
import android.os.UserHandle;
import android.util.ArrayMap;
import com.android.internal.util.Preconditions;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class InstallArgs {
    final String mAbiOverride;
    final List<String> mAllowlistedRestrictedPermissions;
    final boolean mApplicationEnabledSettingPersistent;
    final int mAutoRevokePermissionsMode;
    File mCodeFile;
    final int mDataLoaderType;
    final int mDevelopmentInstallFlags;
    final String mDexoptCompilerFilter;
    final boolean mForceQueryableOverride;
    final int mInstallFlags;
    final int mInstallReason;
    final int mInstallScenario;
    final InstallSource mInstallSource;
    final String[] mInstructionSets;
    final MoveInfo mMoveInfo;
    final IPackageInstallObserver2 mObserver;
    final OriginInfo mOriginInfo;
    final int mPackageSource;
    final ArrayMap<String, Integer> mPermissionStates;
    final SigningDetails mSigningDetails;
    final int mTraceCookie;
    final String mTraceMethod;
    final UserHandle mUser;
    final String mVolumeUuid;

    InstallArgs(OriginInfo originInfo, MoveInfo moveInfo, IPackageInstallObserver2 observer, int installFlags, int developmentInstallFlags, InstallSource installSource, String volumeUuid, UserHandle user, String[] instructionSets, String abiOverride, ArrayMap<String, Integer> permissionStates, List<String> allowlistedRestrictedPermissions, int autoRevokePermissionsMode, String traceMethod, int traceCookie, SigningDetails signingDetails, int installReason, int installScenario, boolean forceQueryableOverride, int dataLoaderType, int packageSource, boolean applicationEnabledSettingPersistent, String dexoptCompilerFilter) {
        this.mOriginInfo = originInfo;
        this.mMoveInfo = moveInfo;
        this.mInstallFlags = installFlags;
        this.mDevelopmentInstallFlags = developmentInstallFlags;
        this.mObserver = observer;
        this.mInstallSource = (InstallSource) Preconditions.checkNotNull(installSource);
        this.mVolumeUuid = volumeUuid;
        this.mUser = user;
        this.mInstructionSets = instructionSets;
        this.mAbiOverride = abiOverride;
        this.mPermissionStates = permissionStates;
        this.mAllowlistedRestrictedPermissions = allowlistedRestrictedPermissions;
        this.mAutoRevokePermissionsMode = autoRevokePermissionsMode;
        this.mTraceMethod = traceMethod;
        this.mTraceCookie = traceCookie;
        this.mSigningDetails = signingDetails;
        this.mInstallReason = installReason;
        this.mInstallScenario = installScenario;
        this.mForceQueryableOverride = forceQueryableOverride;
        this.mDataLoaderType = dataLoaderType;
        this.mPackageSource = packageSource;
        this.mApplicationEnabledSettingPersistent = applicationEnabledSettingPersistent;
        this.mDexoptCompilerFilter = dexoptCompilerFilter;
    }
}
