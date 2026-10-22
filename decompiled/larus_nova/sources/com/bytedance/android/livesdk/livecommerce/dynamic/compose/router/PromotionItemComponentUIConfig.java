package com.bytedance.android.livesdk.livecommerce.dynamic.compose.router;

import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.j;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class PromotionItemComponentUIConfig {
    static {
    }

    public static void a(com.bytedance.android.livesdk.livecommerce.promotion.card.b r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "promotionCard");
        final PromotionItemComponentUIConfig$updateUI$1 r102 = new PromotionItemComponentUIConfig$updateUI$1(r101);
        r100.w2(new j(((k) IPromotionUIConfig.f150021a.getValue()).f150096a).a(PromotionCardModuleName.InfoAreaModule, new PromotionItemComponentUIConfig$updateUI$2(r102)).a(PromotionCardModuleName.BottomModule, new PromotionItemComponentUIConfig$updateUI$3(r102)).a(PromotionCardModuleName.ImageAreaBottomTip, new PromotionItemComponentUIConfig$updateUI$4(r102)).a(PromotionCardModuleName.Parent, PromotionItemComponentUIConfig$updateUI$5.INSTANCE).f150062a);
    }
}
