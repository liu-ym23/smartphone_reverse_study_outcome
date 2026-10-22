package com.bytedance.android.shopping.anchorv4.data;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionAutoApplyCouponResponse;
import io.reactivex.functions.Consumer;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f166459a;

    public p(Function2 r100) {
        this.f166459a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PromotionAutoApplyCouponResponse r101 = (PromotionAutoApplyCouponResponse) r100;
        this.f166459a.invoke(r101.getToast(), r101.getCouponIds());
        Set<String> r102 = ECProcessMonitor.f45118a;
        com.bytedance.android.ec.core.monitor.listener.c r103 = ECProcessMonitor.c("ec_product_detail", "/aweme/v2/shop/coupon/apply/auto/");
        r103.b(new Pair[]{TuplesKt.to("toast", r101.getToast()), TuplesKt.to("coupon_ids", r101.getCouponIds())});
        if (r101.getStatusCode() != 0) goto L5;
        r103.g();
        return;
    L5:
        int r104 = r101.getStatusCode();
        String r105 = r101.getStatusMsg();
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        Intrinsics.checkNotNullParameter(r105, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        r103.k(r104, r105, r103.f45167b);
    }
}
