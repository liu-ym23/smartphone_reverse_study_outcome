package com.bytedance.android.shopping.buynow.opt;

import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class BuyNowPrefetcher$prefetchOnProductDetail$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IOrderSchema $orderSchema;

    public BuyNowPrefetcher$prefetchOnProductDetail$1(IOrderSchema r100) {
        this.$orderSchema = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        dm.a.a("BuyNowPrefetcher").a("judgeToPrefetch successCallback");
        int r100 = d.f171032a;
        d.c(this.$orderSchema);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
