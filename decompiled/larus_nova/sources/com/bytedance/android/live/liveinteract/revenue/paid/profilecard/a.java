package com.bytedance.android.live.liveinteract.revenue.paid.profilecard;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidProfileCardControlWidget f78568a;

    public a(PaidProfileCardControlWidget r100) {
        this.f78568a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f78568a.n7();
    }
}
