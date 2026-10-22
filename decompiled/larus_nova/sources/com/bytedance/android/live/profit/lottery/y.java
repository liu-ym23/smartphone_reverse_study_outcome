package com.bytedance.android.live.profit.lottery;

/* JADX INFO: loaded from: classes47.dex */
public final class y<T1, T2> implements ttc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g f88246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f88247b;

    public y(com.bytedance.android.live.revenue.common.g r100, long r101) {
        this.f88246a = r100;
        this.f88247b = r101;
    }

    @Override // ttc.a
    public final void accept(Object r100, Object r101) {
        Throwable r102 = (Throwable) r101;
        if (((s) r100) == null) goto L5;
        this.f88246a.a("lotteryId=" + this.f88247b);
        return;
    L5:
        this.f88246a.c(r102);
    }
}
