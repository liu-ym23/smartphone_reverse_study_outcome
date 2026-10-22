package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelCID;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCard;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCardType;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECProductStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class UtilsKt {
    public static final Map<String, String> a(ChannelVO r100, boolean r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        String r102 = r100.getComponentId();
        LinkedHashMap r103 = new LinkedHashMap();
        if (Intrinsics.areEqual(r102, ChannelCID.BRAND.getValue()) == false) goto L94;
        String r104 = "product";
        String r105 = "none";
        String r106 = null;
        if (r101 == false) goto L36;
        ChannelVO.Data r107 = r100.getData();
        if (r107 == null) goto L11;
        List<ECCommonCard> r108 = r107.getItems();
        if (r108 == null) goto L11;
        ECCommonCard r109 = (ECCommonCard) CollectionsKt.getOrNull(r108, r110);
    L12:
        if (r109 == null) goto L14;
        Integer r111 = r109.getType();
    L15:
        int r112 = ECCommonCardType.SHOP.getValue();
        if (r111 != null) goto L19;
    L21:
        int r113 = ECCommonCardType.PRODUCT.getValue();
        if (r111 != null) goto L25;
    L27:
        r104 = null;
    L28:
        if (r109 == null) goto L34;
        ECProductStruct r114 = r109.getProduct();
        if (r114 == null) goto L34;
        ECProductStruct.Extra r115 = r114.getExtra();
        if (r115 == null) goto L34;
        r106 = r115.getResourceId();
    L34:
        if (r106 == null) goto L93;
        r105 = r104;
    L93:
        r103.put("custom_daogou_type", r105);
        goto L94
    L25:
        if (r111.intValue() != r113) goto L27;
    L19:
        if (r111.intValue() != r112) goto L21;
        r104 = "shop";
        goto L28
    L14:
        r111 = null;
    L11:
        r109 = null;
        goto L12
    L36:
        ChannelVO.Data r116 = r100.getData();
        if (r116 == null) goto L73;
        List<ECCommonCard> r117 = r116.getItems();
        if (r117 == null) goto L73;
        ArrayList r118 = new ArrayList();
        Iterator<T> r119 = r117.iterator();
    L42:
        if (r119.hasNext() == false) goto L72;
        ECCommonCard r120 = (ECCommonCard) r119.next();
        if (r120 == null) goto L46;
        Integer r121 = r120.getType();
    L47:
        int r122 = ECCommonCardType.SHOP.getValue();
        if (r121 != null) goto L51;
    L53:
        int r123 = ECCommonCardType.PRODUCT.getValue();
        if (r121 != null) goto L57;
    L59:
        Object r124 = null;
    L60:
        if (r120 == null) goto L66;
        ECProductStruct r125 = r120.getProduct();
        if (r125 == null) goto L66;
        ECProductStruct.Extra r126 = r125.getExtra();
        if (r126 == null) goto L66;
        String r127 = r126.getResourceId();
    L67:
        if (r127 != null) goto L70;
        r124 = "none";
    L70:
        if (r124 == null) goto L42;
        r118.add(r124);
    L66:
        r127 = null;
        goto L67
    L57:
        if (r121.intValue() != r123) goto L59;
        r124 = "product";
        goto L60
    L51:
        if (r121.intValue() != r122) goto L53;
        r124 = "shop";
        goto L60
    L46:
        r121 = null;
        goto L47
    L72:
        List r128 = CollectionsKt.distinct(r118);
    L74:
        if (r128 == null) goto L76;
        Integer r129 = Integer.valueOf(r128.size());
    L77:
        if (r129 != null) goto L80;
    L82:
        if (r129 != null) goto L85;
    L87:
        if (r129 != null) goto L90;
    L92:
        r105 = null;
        goto L93
    L90:
        if (r129.intValue() != 0) goto L92;
    L85:
        if (r129.intValue() != 2) goto L87;
        r105 = "both";
        goto L93
    L80:
        if (r129.intValue() != 1) goto L82;
        r105 = (String) CollectionsKt.first(r128);
        goto L93
    L76:
        r129 = null;
    L73:
        r128 = null;
    L94:
        return r103;
    }

    public static final Map<String, String> b(ChannelVO r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "channel");
        if (Intrinsics.areEqual(r110.getComponentId(), ChannelCID.SECKILL.getValue()) == false) goto L12;
        ChannelVO.Data r100 = r110.getData();
        if (r100 == null) goto L12;
        List<ECCommonCard> r101 = r100.getItems();
        if (r101 == null) goto L12;
        List r102 = t93.a.e(r101, r111, r112);
        if (r102 == null) goto L12;
        String r103 = CollectionsKt.joinToString$default(r102, ",", null, null, 0, null, UtilsKt$getSkillOrSubsideProductString$1.INSTANCE, 30, null);
        if (r103 == null) goto L12;
    L14:
        if (Intrinsics.areEqual(r110.getComponentId(), ChannelCID.SUBSIDE.getValue()) == false) goto L23;
        ChannelVO.Data r113 = r110.getData();
        if (r113 == null) goto L23;
        List<ECCommonCard> r114 = r113.getItems();
        if (r114 == null) goto L23;
        List r115 = t93.a.e(r114, r111, r112);
        if (r115 == null) goto L23;
        String r116 = CollectionsKt.joinToString$default(r115, ",", null, null, 0, null, UtilsKt$getSkillOrSubsideProductString$2.INSTANCE, 30, null);
        if (r116 == null) goto L23;
    L25:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("seckill_filters", r103), TuplesKt.to("allowance_filters", r116), TuplesKt.to("filters", "")});
    L23:
        r116 = "";
    L12:
        r103 = "";
        goto L14
    }
}
