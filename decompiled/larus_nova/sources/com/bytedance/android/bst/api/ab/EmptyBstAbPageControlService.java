package com.bytedance.android.bst.api.ab;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/bst/api/ab/EmptyBstAbPageControlService;", "Lcom/bytedance/android/bst/api/ab/IBstAbPageControl;", "()V", "isBstBindEnable", "", "page", "", "isOriginReportEnable", "api_cnRelease"}, k = 1, mv = {1, 1, 16})
public final class EmptyBstAbPageControlService implements IBstAbPageControl {
    public EmptyBstAbPageControlService() {
    }

    @Override // com.bytedance.android.bst.api.ab.IBstAbPageControl
    public boolean isBstBindEnable(String r100) {
        return false;
    }

    @Override // com.bytedance.android.bst.api.ab.IBstAbPageControl
    public boolean isOriginReportEnable(String r100) {
        return true;
    }
}
