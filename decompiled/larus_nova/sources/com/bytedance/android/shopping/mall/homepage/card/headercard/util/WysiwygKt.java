package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.CampaignInfo;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECProductStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class WysiwygKt {
    public static final String b(List<ECProductStruct> r110, Integer r111) {
        ECProductStruct.SecKillProductCampaignType r100 = ECProductStruct.SecKillProductCampaignType.SECKILL;
        int r101 = r100.getValue();
        if (r111 != null) goto L6;
    L11:
        List<ECProductStruct> r102 = r110;
    L12:
        String r103 = null;
        if (r102 == null) goto L15;
        String r104 = CollectionsKt.joinToString$default(r102, ",", null, null, 0, null, WysiwygKt$getWysiwygString$wysiwygStr$1.INSTANCE, 30, null);
    L16:
        if (r110 == null) goto L18;
        ECProductStruct r112 = (ECProductStruct) CollectionsKt.firstOrNull(r110);
    L19:
        if (r112 == null) goto L23;
        ECProductStruct.Extra r105 = r112.getExtra();
        if (r105 == null) goto L23;
        r103 = r105.getNYuanMPiece();
    L23:
        if (r103 == null) goto L31;
        int r106 = r100.getValue();
        if (r111 != null) goto L28;
        return r104;
    L28:
        if (r111.intValue() == r106) goto L30;
        return r104;
    L30:
        return r112.getWysiwygParam();
    L31:
        return r104;
    L18:
        r112 = null;
        goto L19
    L15:
        r104 = null;
        goto L16
    L6:
        if (r111.intValue() != r101) goto L11;
        if (r110 == null) goto L11;
        if (r110.isEmpty() == true) goto L11;
        r102 = r110.subList(0, 1);
        goto L12
    }

    public static final String a(List<ECProductStruct> r100, Integer r101, Integer r102) {
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
    L3:
        boolean r105 = true;
        if (r104.hasNext() == false) goto L22;
        Object r106 = r104.next();
        ECProductStruct r107 = (ECProductStruct) r106;
        int r108 = ECProductStruct.SecKillProductCampaignType.SECKILL.getValue();
        if (r102 != null) goto L9;
    L10:
        if (r107 == null) goto L14;
        CampaignInfo r109 = r107.getCampaignInfo();
        if (r109 == null) goto L14;
        Integer r110 = r109.getCampaignType();
    L16:
        if (Intrinsics.areEqual(r110, r102) == true) goto L19;
        r105 = false;
    L19:
        if (r105 == false) goto L3;
        r103.add(r106);
    L14:
        r110 = null;
        goto L16
    L9:
        if (r102.intValue() == r108) goto L19;
    L22:
        if (r103.isEmpty() != true) goto L25;
        return "";
    L25:
        if (r101 == null) goto L31;
        if (r101.intValue() < 0) goto L31;
        return b(CollectionsKt.listOf((ECProductStruct) CollectionsKt.getOrNull(r103, r101.intValue())), r102);
    L31:
        return b(r103, r102);
    }
}
