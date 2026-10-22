package com.bytedance.android.live.profit.vote.ui;

import com.bytedance.android.live.profit.vote.VoteState;
import com.bytedance.revenue.platform.api.core.rx.n;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.profit.vote.model.c f89353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoteViewModel.b f89354b;

    public i(com.bytedance.android.live.profit.vote.model.c r100, VoteViewModel.b r101) {
        this.f89353a = r100;
        this.f89354b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        VoteViewModel r101 = this.f89354b.f89335a;
        com.bytedance.android.live.profit.vote.model.c r102 = this.f89353a;
        int r103 = VoteViewModel.f89327i;
        r101.getClass();
        int r104 = f.f89348a[((VoteState) r100).ordinal()];
        if (r104 != 1) goto L5;
    L10:
        n<com.bytedance.android.live.profit.vote.model.b> r105 = r101.f89331d;
        com.bytedance.android.live.profit.vote.model.b r106 = r105.f267520d;
        if ((r106 instanceof com.bytedance.android.live.profit.vote.model.b.d) == false) goto L13;
        r105.a(new com.bytedance.android.live.profit.vote.model.b.d(r102, ((com.bytedance.android.live.profit.vote.model.b.d) r106).f89241b));
        return;
    L13:
        int r107 = com.bytedance.revenue.platform.api.core.rx.c.f267509a;
        r105.a(new com.bytedance.android.live.profit.vote.model.b.d(r102, BehaviorSubject.create()));
        return;
    L5:
        if (r104 == 2) goto L10;
        if (r104 != 3) goto L17;
        r101.f89331d.a(new com.bytedance.android.live.profit.vote.model.b.C1370b(r102));
        return;
    }
}
