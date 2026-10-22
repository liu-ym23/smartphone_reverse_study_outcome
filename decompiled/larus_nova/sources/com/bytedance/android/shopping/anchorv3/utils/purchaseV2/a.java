package com.bytedance.android.shopping.anchorv3.utils.purchaseV2;

import com.bytedance.android.ec.model.response.anchorv3.InnerFlowSchema;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.ShortVideoSchema;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f165327a = 0;

    static {
    }

    public static String a(PromotionProductStruct r100, int r101, boolean r102) {
        if (r101 <= 0) goto L23;
        if (r102 == false) goto L13;
        if (r100 == null) goto L42;
        InnerFlowSchema r103 = r100.getInnerflowSchema();
        if (r103 == null) goto L43;
        ShortVideoSchema r104 = r103.getOrderSchema();
        if (r104 == null) goto L44;
        String r105 = r104.getGroupBuyUrl();
        if (r105 != null) goto L22;
        return "";
    L22:
        return r105;
    L44:
        return "";
    L43:
        return "";
    L42:
        return "";
    L13:
        if (r100 == null) goto L45;
        InnerFlowSchema r106 = r100.getInnerflowSchema();
        if (r106 == null) goto L46;
        ShortVideoSchema r107 = r106.getOrderSchema();
        if (r107 == null) goto L47;
        r105 = r107.getUrl();
        if (r105 != null) goto L22;
        return "";
    L47:
        return "";
    L46:
        return "";
    L45:
        return "";
    L23:
        if (r102 == false) goto L32;
        if (r100 == null) goto L50;
        InnerFlowSchema r108 = r100.getInnerflowSchema();
        if (r108 == null) goto L51;
        ShortVideoSchema r109 = r108.getSkuSchema();
        if (r109 == null) goto L52;
        String r110 = r109.getGroupBuyUrl();
        if (r110 != null) goto L41;
        return "";
    L41:
        return r110;
    L52:
        return "";
    L51:
        return "";
    L50:
        return "";
    L32:
        if (r100 == null) goto L53;
        InnerFlowSchema r111 = r100.getInnerflowSchema();
        if (r111 == null) goto L54;
        ShortVideoSchema r112 = r111.getSkuSchema();
        if (r112 == null) goto L55;
        r110 = r112.getUrl();
        if (r110 != null) goto L41;
        return "";
    L55:
        return "";
    L54:
        return "";
    L53:
        return "";
    }
}
