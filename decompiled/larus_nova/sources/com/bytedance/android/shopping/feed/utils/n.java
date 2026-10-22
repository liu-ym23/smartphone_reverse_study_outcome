package com.bytedance.android.shopping.feed.utils;

import android.content.Context;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCommentsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductServiceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f175460a = 0;

    static {
    }

    public static com.bytedance.android.shopping.feed.viewmodel.d a(PromotionProductStruct r110, Context r111) {
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.shopping.feed.viewmodel.d r100 = new com.bytedance.android.shopping.feed.viewmodel.d();
        String r101 = null;
        if (r110 == null) goto L17;
        PromotionProductCommentsStruct r102 = r110.getCommentInfo();
        if (r102 == null) goto L17;
        String r103 = r102.getGoodRatio();
        if (r103 == null) goto L17;
        if (CastDoubleProtector.parseDouble(r103) <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L17;
        String r105 = r103.concat(GXTemplateKey.GAIAX_PE);
    L18:
        if (r110 == null) goto L22;
        PromotionProductPrivilegesStruct r106 = r110.getPrivilegeInfo();
        if (r106 == null) goto L22;
        List<PromotionProductServiceStruct> r107 = r106.getServices();
    L23:
        if (r110 == null) goto L27;
        PromotionProductCommentsStruct r112 = r110.getCommentInfo();
        if (r112 == null) goto L27;
        List<String> r113 = r112.getSellingPoints();
    L28:
        if (r105 != null) goto L30;
    L35:
        if (r107 != null) goto L37;
    L42:
        if (r113 != null) goto L44;
        return r100;
    L44:
        if ((!r113.isEmpty()) != true) goto L50;
        com.bytedance.android.shopping.feed.viewmodel.d r108 = new com.bytedance.android.shopping.feed.viewmodel.d();
        r108.f175750a = (String) CollectionsKt.firstOrNull(r113);
        r108.f175751b = 2;
        return r108;
    L50:
        return r100;
    L37:
        if ((!r107.isEmpty()) != true) goto L42;
        com.bytedance.android.shopping.feed.viewmodel.d r109 = new com.bytedance.android.shopping.feed.viewmodel.d();
        PromotionProductServiceStruct r114 = (PromotionProductServiceStruct) CollectionsKt.firstOrNull(r107);
        if (r114 == null) goto L41;
        r101 = r114.getTitle();
    L41:
        r109.f175750a = r101;
        r109.f175751b = 1;
        return r109;
    L30:
        if (r105.length() <= 0) goto L32;
        boolean r115 = true;
    L33:
        if (r115 != true) goto L35;
        com.bytedance.android.shopping.feed.viewmodel.d r116 = new com.bytedance.android.shopping.feed.viewmodel.d();
        int r117 = g1.f45599a;
        r116.f175750a = g1.a.c(r111, R.string.commerce_praise_rate, new Object[]{r105});
        r116.f175751b = 0;
        return r116;
    L32:
        r115 = false;
    L27:
        r113 = null;
    L22:
        r107 = null;
        goto L23
    L11:
        r104 = false;
    L17:
        r105 = null;
        goto L18
    }
}
