package com.bytedance.android.live.profit.lottery;

/* JADX INFO: loaded from: classes47.dex */
public final class a0<T1, T2> implements ttc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g f88038a;

    public a0(com.bytedance.android.live.revenue.common.g r100) {
        this.f88038a = r100;
    }

    @Override // ttc.a
    public final void accept(Object r100, Object r101) {
        Boolean r102 = (Boolean) r100;
        Throwable r103 = (Throwable) r101;
        if (r102 == null) goto L5;
        this.f88038a.a(String.valueOf(r102.booleanValue()));
        return;
    L5:
        this.f88038a.c(r103);
    }
}
