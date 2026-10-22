package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.bytedance.commerce.base.json.JsonDslUtilKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class u {
    public static final String a(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, boolean r110, String r111, String r112) {
        com.bytedance.commerce.base.json.a[] r107 = new com.bytedance.commerce.base.json.a[9];
        String r108 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r107[0] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r100);
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r107[1] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r101);
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        r107[2] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, r102);
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        r107[3] = JsonDslUtilKt.d("enter_from", r103);
        if (r104 != null) goto L17;
        r104 = "";
    L17:
        r107[4] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_TEMP_ID, r104);
        if (r105 != null) goto L20;
        r105 = "";
    L20:
        r107[5] = JsonDslUtilKt.d("customer_id", r105);
        if (r106 == false) goto L23;
        String r109 = "single_product";
    L24:
        r107[6] = JsonDslUtilKt.d("product_form", r109);
        if (r110 == false) goto L27;
        String r113 = "1";
    L28:
        r107[7] = JsonDslUtilKt.d("is_discount_selected", r113);
        if (Intrinsics.areEqual(r111, "shop") == false) goto L31;
        r112 = "share_alert";
    L31:
        if (r112 == null) goto L34;
        r108 = r112;
    L34:
        r107[8] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, r108);
        return JsonDslUtilKt.a(r107).toString();
    L27:
        r113 = "0";
        goto L28
    L23:
        r109 = "double_product";
        goto L24
    }
}
