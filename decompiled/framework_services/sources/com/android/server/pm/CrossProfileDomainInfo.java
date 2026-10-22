package com.android.server.pm;

import android.content.pm.ResolveInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class CrossProfileDomainInfo {
    int mHighestApprovalLevel;
    final ResolveInfo mResolveInfo;
    final int mTargetUserId;

    CrossProfileDomainInfo(ResolveInfo resolveInfo, int highestApprovalLevel, int targetUserId) {
        this.mResolveInfo = resolveInfo;
        this.mHighestApprovalLevel = highestApprovalLevel;
        this.mTargetUserId = targetUserId;
    }

    CrossProfileDomainInfo(ResolveInfo resolveInfo, int highestApprovalLevel) {
        this.mResolveInfo = resolveInfo;
        this.mHighestApprovalLevel = highestApprovalLevel;
        this.mTargetUserId = -2;
    }

    public String toString() {
        return "CrossProfileDomainInfo{resolveInfo=" + this.mResolveInfo + ", highestApprovalLevel=" + this.mHighestApprovalLevel + ", targetUserId= " + this.mTargetUserId + '}';
    }
}
