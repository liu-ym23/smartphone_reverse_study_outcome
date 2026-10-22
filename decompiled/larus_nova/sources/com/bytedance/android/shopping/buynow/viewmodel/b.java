package com.bytedance.android.shopping.buynow.viewmodel;

import com.bytedance.android.shopping.buynow.data.model.PageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final String a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getCreatePath");
        String r101 = r100.f171233g;
        int r102 = r101.hashCode();
        if (r102 == (-1132693887)) goto L11;
        if (r102 == 21618209) goto L8;
    L13:
        return "/order/yata/createOrder";
    L8:
        if (r101.equals(PageType.ULTIMATEBUYNOW) == false) goto L13;
        return "/order/component/createOrder/";
    L11:
        if (r101.equals(PageType.CONTINUEPAY) == false) goto L13;
        return "/order/yata/createPay";
    }

    public static final String b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getEditPath");
        String r101 = r100.f171233g;
        int r102 = r101.hashCode();
        if (r102 == (-1132693887)) goto L11;
        if (r102 == 21618209) goto L8;
    L13:
        return "/order/yata/confirmOrderEdit";
    L8:
        if (r101.equals(PageType.ULTIMATEBUYNOW) == false) goto L13;
        return "/order/component/confirmOrderEdit/";
    L11:
        if (r101.equals(PageType.CONTINUEPAY) == false) goto L13;
        return "/order/yata/getPayMethodEdit";
    }

    public static final String c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getQueryPath");
        String r101 = r100.f171233g;
        int r102 = r101.hashCode();
        if (r102 == (-1132693887)) goto L11;
        if (r102 == 21618209) goto L8;
    L13:
        return "/order/yata/confirmOrderRender";
    L8:
        if (r101.equals(PageType.ULTIMATEBUYNOW) == false) goto L13;
        return "/order/component/confirmOrder/";
    L11:
        if (r101.equals(PageType.CONTINUEPAY) == false) goto L13;
        return "/order/yata/getPayMethod";
    }
}
