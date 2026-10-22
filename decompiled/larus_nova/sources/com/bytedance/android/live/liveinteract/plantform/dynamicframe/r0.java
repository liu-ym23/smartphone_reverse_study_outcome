package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes46.dex */
public final class r0 implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih0.c f77102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e0 f77103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Long f77104c;

    public r0(ih0.c r100, e0 r101, Long r102) {
        this.f77102a = r100;
        this.f77103b = r101;
        this.f77104c = r102;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        e0.c(this.f77103b, this.f77102a, this.f77104c);
    }
}
