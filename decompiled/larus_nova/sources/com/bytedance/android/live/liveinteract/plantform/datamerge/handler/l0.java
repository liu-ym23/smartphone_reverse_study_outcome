package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class l0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0 f76464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f76465b;

    public l0(j0 r100, int r101) {
        this.f76464a = r100;
        this.f76465b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        boolean r102 = gh0.b.f481244a;
        gh0.b.a("AudioAnchorGuide", "Handler finish interval, value = " + this.f76465b, false);
        this.f76464a.f76456c = true;
    }
}
