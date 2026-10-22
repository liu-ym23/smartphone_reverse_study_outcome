package com.android.server.pm;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.android.internal.util.ArrayUtils;

/* JADX INFO: loaded from: classes2.dex */
final class PackageRemovedInfo {
    private static final int[] EMPTY_INT_ARRAY = null;
    CleanUpArgs mArgs;
    SparseArray<int[]> mBroadcastAllowList;
    int[] mBroadcastUsers;
    boolean mDataRemoved;
    SparseIntArray mInstallReasons;
    String mInstallerPackageName;
    int[] mInstantUserIds;
    boolean mIsAppIdRemoved;
    boolean mIsExternal;
    boolean mIsRemovedPackageSystemUpdate;
    boolean mIsStaticSharedLib;
    boolean mIsUpdate;
    int[] mOrigUsers;
    boolean mRemovedForAllUsers;
    String mRemovedPackage;
    long mRemovedPackageVersionCode;
    int[] mRemovedUsers;
    int mUid;
    SparseIntArray mUninstallReasons;

    PackageRemovedInfo() {
        this.mUid = -1;
        this.mIsAppIdRemoved = false;
        this.mRemovedUsers = null;
        this.mBroadcastUsers = null;
        this.mInstantUserIds = null;
        this.mIsRemovedPackageSystemUpdate = false;
        this.mArgs = null;
    }

    static {
        EMPTY_INT_ARRAY = new int[0];
    }

    public void populateBroadcastUsers(PackageSetting deletedPackageSetting) {
        if (this.mRemovedUsers != null) goto L6;
        this.mBroadcastUsers = null;
        return;
    L6:
        this.mBroadcastUsers = EMPTY_INT_ARRAY;
        this.mInstantUserIds = EMPTY_INT_ARRAY;
        int i = this.mRemovedUsers.length - 1;
    L7:
        if (i < 0) goto L14;
        int userId = this.mRemovedUsers[i];
        if (deletedPackageSetting.getInstantApp(userId) == false) goto L11;
        this.mInstantUserIds = ArrayUtils.appendInt(this.mInstantUserIds, userId);
    L12:
        i = i - 1;
        goto L7
    L11:
        this.mBroadcastUsers = ArrayUtils.appendInt(this.mBroadcastUsers, userId);
        goto L12
    }
}
