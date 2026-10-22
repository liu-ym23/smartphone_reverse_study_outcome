package com.bytedance.android.shopping.monitor;

import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.GuessULikeResponseDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f178662a = 0;

    static {
    }

    public static void a(GuessULikeResponseDTO r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        PromotionLogPbData r101 = r100.getLogPb();
        if (r101 == null) goto L5;
        String r102 = r101.getImprId();
    L6:
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        List<j63.c> r103 = r100.getProductList();
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L18;
        com.bytedance.android.ec.core.monitor.d.a("/aweme/v2/commerce/favorite/feed/", r102, "item_cards");
        return;
    L18:
        return;
    L11:
        if (r103.isEmpty() == true) goto L14;
        r104 = false;
        goto L15
    L5:
        r102 = null;
        goto L6
    }

    public static void b(PromotionPackResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        PromotionLogPbData r101 = r100.getLogPb();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getImprId();
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        List<PromotionProductStruct> r104 = r100.getPromotions();
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L16:
        if (r105 == false) goto L18;
        com.bytedance.android.ec.core.monitor.d.a("/shop/promotion/pack/", r103, "promotions");
        return;
    L18:
        List<PromotionProductStruct> r106 = r100.getPromotions();
        if (r106 == null) goto L23;
        PromotionProductStruct r107 = (PromotionProductStruct) CollectionsKt.firstOrNull(r106);
        if (r107 == null) goto L23;
        PromotionProductPriceStruct r108 = r107.getProductPrice();
    L24:
        if (r108 != null) goto L26;
        com.bytedance.android.ec.core.monitor.d.a("/shop/promotion/pack/", r103, "promotions[0].product_price");
    L26:
        List<PromotionProductStruct> r109 = r100.getPromotions();
        if (r109 == null) goto L33;
        PromotionProductStruct r110 = (PromotionProductStruct) CollectionsKt.firstOrNull(r109);
        if (r110 == null) goto L33;
        PromotionProductBaseStruct r111 = r110.getBaseInfo();
        if (r111 == null) goto L33;
        r102 = r111.getProductId();
    L33:
        if (r102 != null) goto L37;
        com.bytedance.android.ec.core.monitor.d.a("/shop/promotion/pack/", r103, "promotions[0].base_info.product_id");
        return;
    L37:
        return;
    L23:
        r108 = null;
        goto L24
    L11:
        if (r104.isEmpty() == true) goto L14;
        r105 = false;
        goto L16
    L5:
        r103 = null;
        goto L6
    }
}
