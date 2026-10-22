package com.bytedance.android.gamecp.hybrid_impl.jsb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class v5 implements com.bytedance.android.gamecp.base.core.service.depend.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u5 f57549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f57550b;

    @Override // com.bytedance.android.gamecp.base.core.service.depend.s
    public final void onCancel() {
        u5.k(this.f57549a, 4, this.f57550b, 0, 12);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.s
    public final void onReady() {
        u5.k(this.f57549a, 0, this.f57550b, 0, 12);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.s
    public final void onDownloaded(String r100) {
        u5.k(this.f57549a, 3, this.f57550b, 0, 12);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.s
    public final void onPause(com.bytedance.android.gamecp.base.core.service.depend.x r100) {
        Intrinsics.checkNotNullParameter(r100, "progressData");
        u5.k(this.f57549a, 2, this.f57550b, r100.f51437a, 8);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.s
    public final void onProgress(com.bytedance.android.gamecp.base.core.service.depend.x r100) {
        Intrinsics.checkNotNullParameter(r100, "progressData");
        u5.k(this.f57549a, 1, this.f57550b, r100.f51437a, 8);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.s
    public final void passThrough(int r100) {
        this.f57549a.getClass();
        boolean r101 = true;
        if (r100 != 1) goto L5;
    L16:
        if (r101 == false) goto L18;
        return;
    L18:
        u5.k(this.f57549a, r100, this.f57550b, 0, 12);
        return;
    L5:
        if (r100 == 2) goto L16;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L16;
        if (r100 == 5) goto L16;
        if (r100 == 6) goto L16;
        r101 = false;
        goto L16
    }

    public v5(u5 r100, int r101) {
        this.f57549a = r100;
        this.f57550b = r101;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.s
    public final void onError(int r100, int r101) {
        u5 r102 = this.f57549a;
        int r103 = this.f57550b;
        r102.getClass();
        u5.j(5, r103, r101, r100);
    }
}
