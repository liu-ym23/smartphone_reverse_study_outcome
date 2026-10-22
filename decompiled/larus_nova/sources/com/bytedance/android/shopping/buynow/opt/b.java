package com.bytedance.android.shopping.buynow.opt;

import com.bytedance.android.shopping.model.buynow.BuyNowPrefetchType;
import io.reactivex.functions.Action;
import tf3.l;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ql.a f171028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f171029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BuyNowPrefetchType f171030c;

    public b(ql.a r100, l r101, BuyNowPrefetchType r102) {
        this.f171028a = r100;
        this.f171029b = r101;
        this.f171030c = r102;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        dm.a.a("BuyNowPrefetchPitayaJudger").a("prefetchIfNeedWithDelay after 1s");
        int r100 = d.f171032a;
        d.d(this.f171028a, this.f171029b, this.f171030c);
    }
}
