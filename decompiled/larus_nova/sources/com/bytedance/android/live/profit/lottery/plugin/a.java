package com.bytedance.android.live.profit.lottery.plugin;

import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.lottery.g;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f88174a;

    public a(b r100) {
        this.f88174a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        g r101 = (g) sh6.c.b((sh6.b) r100);
        LotteryState r102 = null;
        if (r101 == null) goto L5;
        LotteryState r103 = r101.getState();
    L7:
        if ((r103 instanceof LotteryState.g) == false) goto L10;
        r102 = r103;
    L10:
        LotteryState.g r104 = (LotteryState.g) r102;
        if (r104 == null) goto L15;
        this.f88174a.getClass();
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r105 = ((mz0.c) f.a(mz0.c.class)).W2(LogCommon.ROOM);
        if (r105 == null) goto L19;
        r105.i("lottery_id", String.valueOf(r104.f88032a.f88194a));
        return;
    L19:
        return;
    L15:
        this.f88174a.getClass();
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r106 = ((mz0.c) f.a(mz0.c.class)).W2(LogCommon.ROOM);
        if (r106 == null) goto L21;
        r106.n();
        return;
    L21:
        return;
    L5:
        r103 = null;
        goto L7
    }
}
