package com.bytedance.android.gamecp.business;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class t implements com.bytedance.android.gamecp.base.core.service.depend.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.base.core.service.depend.s f56416a;

    @Override // com.bytedance.android.gamecp.base.core.service.depend.s
    public final void onCancel() {
        this.f56416a.onCancel();
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.s
    public final void onReady() {
        this.f56416a.onReady();
    }

    public t(com.bytedance.android.gamecp.base.core.service.depend.s r100) {
        this.f56416a = r100;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.s
    public final void onDownloaded(String r100) {
        this.f56416a.onDownloaded(r100);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.s
    public final void onPause(com.bytedance.android.gamecp.base.core.service.depend.x r100) {
        Intrinsics.checkNotNullParameter(r100, "progressData");
        this.f56416a.onPause(r100);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.s
    public final void onProgress(com.bytedance.android.gamecp.base.core.service.depend.x r100) {
        Intrinsics.checkNotNullParameter(r100, "progressData");
        this.f56416a.onProgress(r100);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.s
    public final void passThrough(int r100) {
        this.f56416a.passThrough(r100);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.s
    public final void onError(int r100, int r101) {
        this.f56416a.onError(r100, r101);
    }
}
