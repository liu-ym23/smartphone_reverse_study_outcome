package com.bytedance.android.shopping.buynow.opt;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tf3.l;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class BuyNowPrefetcher$prefetchByPitaya$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ l $extraParams;
    final /* synthetic */ ql.a $targetPromotion;

    public BuyNowPrefetcher$prefetchByPitaya$1(ql.a r100, l r101) {
        this.$targetPromotion = r100;
        this.$extraParams = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        dm.a.a("BuyNowPrefetcher").a("judgeToPrefetch successCallback");
        int r100 = d.f171032a;
        d.b(this.$targetPromotion, this.$extraParams);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
