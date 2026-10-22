package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class s implements fj2.a<TextView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECUserRightsTagWidget f150676a;

    @Override // fj2.a
    public final String type() {
        return "tag_item_background_text";
    }

    @Override // fj2.a
    public final TextView create() {
        TextView r100 = new TextView(this.f150676a.getContext());
        r100.setTag("text");
        r100.setGravity(17);
        r100.setMaxLines(1);
        r100.setTextSize(1, 10.0f);
        r100.setPadding(UtilityKotlinExtentionsKt.d(2), 0, UtilityKotlinExtentionsKt.d(2), 0);
        r100.setLayoutParams(new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(14)));
        com.bytedance.android.livesdk.livecommerce.promotion.card.k r101 = this.f150676a.f150632c;
        if (r101 == null) goto L9;
        IPromotionUIConfig.d r102 = r101.a(PromotionCardModuleName.InfoAreaUserRightLabelModule);
        if (r102 == null) goto L9;
        IPromotionUIConfig.b r103 = r102.a();
        if (r103 == null) goto L9;
        UIConfigHelper.c(r100, r103);
    L9:
        return r100;
    }

    public s(ECUserRightsTagWidget r100) {
        this.f150676a = r100;
    }
}
