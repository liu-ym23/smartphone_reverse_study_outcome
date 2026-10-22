package com.bytedance.android.live.profit.lottery.plugin;

import com.bytedance.android.live.profit.lottery.LotteryContext;
import com.bytedance.android.live.profit.lottery.g;
import com.bytedance.android.live.profit.lottery.n;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f88175a;

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void onUnload() {
        this.f88175a.dispose();
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r100 = ((mz0.c) f.a(mz0.c.class)).W2(LogCommon.ROOM);
        if (r100 == null) goto L6;
        r100.n();
        return;
    }

    public b() {
        this.f88175a = Disposables.disposed();
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void a(LotteryContext r100) {
        Intrinsics.checkNotNullParameter(r100, "lotteryContext");
        this.f88175a = r100.getCurrentLottery().a().subscribe(new a(this));
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
