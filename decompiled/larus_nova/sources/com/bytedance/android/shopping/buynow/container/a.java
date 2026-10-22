package com.bytedance.android.shopping.buynow.container;

import android.net.Uri;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f170774a = 0;

    static {
    }

    public static String a(UltimateBuyParams r100, Uri r101, boolean r102, nl.c r103) {
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getQueryParam("is_single_sku");
    L6:
        boolean r106 = false;
        boolean r107 = com.bytedance.android.shopping.extensions.k.n(r105, false);
        if (r103 == null) goto L9;
        String r108 = r103.getQueryParam("ultimate_buy_ab");
    L11:
        if (com.bytedance.android.shopping.extensions.k.r(r108, 0) <= 0) goto L13;
        boolean r109 = true;
    L14:
        if (r103 == null) goto L17;
        r104 = r103.getQueryParam("ultimate_buy_version");
    L17:
        if (com.bytedance.android.shopping.extensions.k.r(r104, 0) > 0) goto L19;
    L21:
        if (r106 == false) goto L25;
        if (r107 == false) goto L25;
        if (r109 == false) goto L25;
        String r110 = "单sku\n极致提单\nschema升级";
    L43:
        if (r102 == true) goto L45;
        return r110;
    L45:
        return r110 + "\n命中过缓存";
    L25:
        if (r106 == false) goto L29;
        if (r107 == true) goto L29;
        if (r109 == false) goto L29;
        r110 = "多sku\n极致提单\nschema升级";
    L29:
        if (r100 != null) goto L32;
        r110 = "组件化NA\n提单";
        goto L43
    L32:
        if (r100.isSingleSku() != 1) goto L36;
        if (r101 == null) goto L36;
        r110 = "单sku\n极致提单\nschema重构\ntype:" + r100.getUltimateBuyType();
    L36:
        if (r100.isSingleSku() == 1) goto L40;
        if (r101 == null) goto L40;
        r110 = "多sku\n极致提单\nschema重构\ntype:" + r100.getUltimateBuyType();
    L40:
        if (r100.isSingleSku() != 1) goto L42;
        r110 = "单sku\n极致提单\n非schema重构\ntype:" + r100.getUltimateBuyType();
        goto L43
    L42:
        r110 = "多sku\n极致提单\n非schema重构\ntype:" + r100.getUltimateBuyType();
        goto L43
    L19:
        if ((r103 instanceof IOrderSchema) == false) goto L21;
        r106 = true;
        goto L21
    L13:
        r109 = false;
        goto L14
    L9:
        r108 = null;
        goto L11
    L5:
        r105 = null;
        goto L6
    }
}
