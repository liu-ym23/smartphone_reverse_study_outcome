package com.bytedance.android.live.profit.lottery.plugin;

import com.bytedance.android.live.profit.lottery.LotteryContext;
import com.bytedance.android.live.profit.lottery.g;
import com.bytedance.android.live.profit.lottery.n;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements n {
    @Override // com.bytedance.android.live.profit.lottery.n
    public final void onUnload() {
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void a(LotteryContext r100) {
        Intrinsics.checkNotNullParameter(r100, "lotteryContext");
        r100.getOnToolbarButtonClick().b().d(new VCDLotteryPlugin$onLoad$1(this));
        r100.getOnIconClick().b().d(new VCDLotteryPlugin$onLoad$2(this));
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        Intrinsics.checkNotNullParameter(r100, "extra");
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final boolean c(g r100) {
        Intrinsics.checkNotNullParameter(r100, "lottery");
        Intrinsics.checkNotNullParameter(r100, "lottery");
        return false;
    }
}
