package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes46.dex */
public final class t0 implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih0.c f77112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e0 f77113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Long f77114c;

    public t0(ih0.c r100, e0 r101, Long r102) {
        this.f77112a = r100;
        this.f77113b = r101;
        this.f77114c = r102;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        e0.c(this.f77113b, this.f77112a, this.f77114c);
        e0.b(this.f77113b, this.f77112a);
    }
}
