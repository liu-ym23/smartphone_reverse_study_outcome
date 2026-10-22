package com.android.server.pm;

import android.content.pm.SharedLibraryInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class ScanResult {
    public final List<String> mChangedAbiCodePath;
    public final List<SharedLibraryInfo> mDynamicSharedLibraryInfos;
    public final boolean mExistingSettingCopied;
    public final PackageSetting mPkgSetting;
    public final int mPreviousAppId;
    public final ScanRequest mRequest;
    public final SharedLibraryInfo mSdkSharedLibraryInfo;
    public final SharedLibraryInfo mStaticSharedLibraryInfo;

    ScanResult(ScanRequest request, PackageSetting pkgSetting, List<String> changedAbiCodePath, boolean existingSettingCopied, int previousAppId, SharedLibraryInfo sdkSharedLibraryInfo, SharedLibraryInfo staticSharedLibraryInfo, List<SharedLibraryInfo> dynamicSharedLibraryInfos) {
        this.mRequest = request;
        this.mPkgSetting = pkgSetting;
        this.mChangedAbiCodePath = changedAbiCodePath;
        this.mExistingSettingCopied = existingSettingCopied;
        this.mPreviousAppId = -1;
        this.mSdkSharedLibraryInfo = sdkSharedLibraryInfo;
        this.mStaticSharedLibraryInfo = staticSharedLibraryInfo;
        this.mDynamicSharedLibraryInfos = dynamicSharedLibraryInfos;
    }

    public boolean needsNewAppId() {
        if (this.mPreviousAppId == (-1)) goto L5;
        return true;
    L5:
        return false;
    }
}
