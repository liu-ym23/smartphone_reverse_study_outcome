package com.bytedance.android.livesdk.chatroom.paidlive;

import com.bytedance.android.live.profit.lottery.LotteryContext;
import com.bytedance.android.live.profit.lottery.g;
import com.bytedance.android.live.profit.lottery.n;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f107569b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f107570a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void onUnload() {
    }

    public b(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f107570a = r100;
    }

    @Override // com.bytedance.android.live.profit.lottery.n
    public final void a(LotteryContext r100) {
        Intrinsics.checkNotNullParameter(r100, "lotteryContext");
        Intrinsics.checkNotNullParameter(r100, "lotteryContext");
        r100.getOnIconClick().b().b(new PaidLiveLotteryPlugin$onLoad$1(this));
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
