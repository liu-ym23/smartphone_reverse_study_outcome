package com.bytedance.android.live.profit.vote.ui;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoteViewModel f89350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.profit.vote.model.b f89351b;

    public g(VoteViewModel r100, com.bytedance.android.live.profit.vote.model.b r101) {
        this.f89350a = r100;
        this.f89351b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f89350a.f89331d.a(new com.bytedance.android.live.profit.vote.model.b.e(((com.bytedance.android.live.profit.vote.model.b.a) this.f89351b).f89237a));
    }
}
