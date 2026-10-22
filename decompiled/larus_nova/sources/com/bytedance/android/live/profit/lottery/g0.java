package com.bytedance.android.live.profit.lottery;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes47.dex */
public final class g0<T1, T2> implements ttc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g f88075a;

    public g0(com.bytedance.android.live.revenue.common.g r100) {
        this.f88075a = r100;
    }

    @Override // ttc.a
    public final void accept(Object r100, Object r101) {
        sh6.b r102 = (sh6.b) r100;
        Throwable r103 = (Throwable) r101;
        if (r102 == null) goto L13;
        LinkedHashMap<String, String> r104 = LotteryTraceMonitor.f88034a;
        LotteryTraceMonitor.EventName r105 = LotteryTraceMonitor.EventName.lottery_init_api_success;
        StringBuilder r106 = new StringBuilder("success lotteryid = ");
        t r107 = (t) sh6.c.b(r102);
        if (r107 == null) goto L7;
        long r108 = r107.f88194a;
    L8:
        r106.append(String.valueOf(r108));
        LotteryTraceMonitor.a(r105, r106.toString());
        com.bytedance.android.live.revenue.common.g r109 = this.f88075a;
        StringBuilder r110 = new StringBuilder("lotteryId=");
        t r111 = (t) sh6.c.b(r102);
        if (r111 == null) goto L11;
        Long r112 = Long.valueOf(r111.f88194a);
    L12:
        r110.append(r112);
        r109.a(r110.toString());
        return;
    L11:
        r112 = null;
        goto L12
    L7:
        r108 = 0;
        goto L8
    L13:
        LinkedHashMap<String, String> r113 = LotteryTraceMonitor.f88034a;
        LotteryTraceMonitor.EventName r114 = LotteryTraceMonitor.EventName.lottery_init_api_fail;
        if (r103 == null) goto L16;
        Object r115 = r103;
    L17:
        LotteryTraceMonitor.a(r114, "fail lotteryid = ".concat(String.valueOf(r115)));
        this.f88075a.c(r103);
        return;
    L16:
        r115 = "";
        goto L17
    }
}
