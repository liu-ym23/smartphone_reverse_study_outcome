package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import kotlin.Unit;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements fj2.a<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECUserRightsTagWidget f150465a;

    @Override // fj2.a
    public final String type() {
        return "tag_item_divider";
    }

    @Override // fj2.a
    public final View create() {
        View r100 = new View(this.f150465a.getContext());
        r100.setTag(ItemStyle.ITEM_STYLE_DIVIDER);
        r100.setBackgroundColor(th.a.a(r100.getContext(), R.color.shopping_std_text_black_4));
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Float.valueOf(0.5f)), UtilityKotlinExtentionsKt.d(Float.valueOf(10.0f)));
        r101.leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
        r101.topMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(1.0f));
        r101.gravity = 17;
        Unit r102 = Unit.INSTANCE;
        r100.setLayoutParams(r101);
        return r100;
    }

    public h(ECUserRightsTagWidget r100) {
        this.f150465a = r100;
    }
}
