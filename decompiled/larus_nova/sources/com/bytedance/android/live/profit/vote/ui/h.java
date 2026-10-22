package com.bytedance.android.live.profit.vote.ui;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoteViewModel f89352a;

    public h(VoteViewModel r100) {
        this.f89352a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f89352a.f89331d.a(com.bytedance.android.live.profit.vote.model.b.c.f89239a);
    }
}
