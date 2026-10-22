package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import io.reactivex.functions.Action;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f170961a;

    public h(Function1 r100) {
        this.f170961a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        BuyNowLog.d("selfDelay", "selfDelay finishes");
        Function1 r100 = this.f170961a;
        int r101 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r100.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
