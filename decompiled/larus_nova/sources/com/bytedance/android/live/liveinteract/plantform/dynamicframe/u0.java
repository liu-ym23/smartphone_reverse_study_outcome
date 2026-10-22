package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes46.dex */
public final class u0 implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih0.c f77116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e0 f77117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Long f77118c;

    public u0(ih0.c r100, e0 r101, Long r102) {
        this.f77116a = r100;
        this.f77117b = r101;
        this.f77118c = r102;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        e0.c(this.f77117b, this.f77116a, this.f77118c);
        e0.b(this.f77117b, this.f77116a);
    }
}
