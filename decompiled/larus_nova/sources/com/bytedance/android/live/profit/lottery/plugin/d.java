package com.bytedance.android.live.profit.lottery.plugin;

import com.bytedance.android.live.profit.lottery.LotteryContext;
import com.bytedance.android.live.profit.lottery.g;
import com.bytedance.android.live.profit.lottery.n;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f88177a = null;

    public d() {
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void onUnload() {
    }

    static {
        f88177a = new d();
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void a(LotteryContext r100) {
        Intrinsics.checkNotNullParameter(r100, "lotteryContext");
        Intrinsics.checkNotNullParameter(r100, "lotteryContext");
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        com.bytedance.android.livesdk.revenue.service.user.c r101 = ((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).Tk();
        if (r101 != null) goto L5;
    L7:
        String r102 = "0";
    L8:
        r100.put("hide_nickname", r102);
        return;
    L5:
        if (r101.a() != true) goto L7;
        r102 = "1";
        goto L8
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final boolean c(g r100) {
        Intrinsics.checkNotNullParameter(r100, "lottery");
        Intrinsics.checkNotNullParameter(r100, "lottery");
        return false;
    }
}
