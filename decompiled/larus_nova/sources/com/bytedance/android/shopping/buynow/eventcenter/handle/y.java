package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.shopping.buynow.monitor.param.BuyNowOrderNode;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class y extends com.bytedance.kmp.ec.yata.event.common.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pa3.a f170986a;

    public static final class a {
    }

    static {
    }

    public y(pa3.a r100) {
        this.f170986a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.b
    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        BuyNowLog.d("selfSubmitBtnClick", "selfSubmitBtnClick starts");
        pa3.a r101 = this.f170986a;
        if (r101 == null) goto L7;
        com.bytedance.android.shopping.buynow.monitor.order.a r102 = r101.f528358b;
        if (r102 == null) goto L7;
        r102.a(BuyNowOrderNode.INITIAL, System.currentTimeMillis());
    L7:
        pa3.a r103 = this.f170986a;
        if (r103 == null) goto L12;
        com.bytedance.android.shopping.buynow.monitor.order.a r104 = r103.f528358b;
        if (r104 == null) goto L12;
        r104.a(BuyNowOrderNode.ORDER_SUBMIT, System.currentTimeMillis());
    L12:
        BuyNowLog.d("selfSubmitBtnClick", "selfSubmitBtnClick finishes");
        int r105 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
