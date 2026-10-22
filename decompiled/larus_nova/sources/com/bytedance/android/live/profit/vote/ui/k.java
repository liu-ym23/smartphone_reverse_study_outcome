package com.bytedance.android.live.profit.vote.ui;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoteViewModel f89356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.profit.vote.model.b.d f89357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.profit.vote.b f89358c;

    public k(VoteViewModel r100, com.bytedance.android.live.profit.vote.model.b.d r101, com.bytedance.android.live.profit.vote.b r102) {
        this.f89356a = r100;
        this.f89357b = r101;
        this.f89358c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f89357b.f89241b.onNext(r101);
        long r102 = VoteViewModel.f89326h;
        if (r101 == null) goto L9;
        if (r101.longValue() != r102) goto L9;
        this.f89356a.f89331d.a(new com.bytedance.android.live.profit.vote.model.b.a(this.f89358c));
        return;
    L9:
        if (r101.longValue() > 0) goto L13;
        this.f89356a.f89331d.a(new com.bytedance.android.live.profit.vote.model.b.e(this.f89358c));
        return;
    }
}
