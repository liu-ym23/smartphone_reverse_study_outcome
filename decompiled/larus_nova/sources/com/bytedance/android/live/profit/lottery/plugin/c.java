package com.bytedance.android.live.profit.lottery.plugin;

import android.content.Context;
import com.bytedance.android.live.profit.lottery.LotteryContext;
import com.bytedance.android.live.profit.lottery.g;
import com.bytedance.android.live.profit.lottery.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f88176a;

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void onUnload() {
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f88176a = r100;
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void a(LotteryContext r100) {
        Intrinsics.checkNotNullParameter(r100, "lotteryContext");
        r100.getOnIconClick().b().b(new LoginLotteryPlugin$onLoad$1(this));
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
