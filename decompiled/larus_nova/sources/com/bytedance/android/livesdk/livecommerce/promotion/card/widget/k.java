package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class k implements fj2.a<TextView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECUserRightsTagWidget f150468a;

    @Override // fj2.a
    public final String type() {
        return "tag_item_background_text";
    }

    @Override // fj2.a
    public final TextView create() {
        TextView r100 = new TextView(this.f150468a.getContext());
        r100.setTag("text");
        r100.setGravity(17);
        r100.setMaxLines(1);
        r100.setTextSize(1, 10.0f);
        r100.setPadding(UtilityKotlinExtentionsKt.d(4), 0, UtilityKotlinExtentionsKt.d(4), 0);
        r100.setLayoutParams(new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(16)));
        return r100;
    }

    public k(ECUserRightsTagWidget r100) {
        this.f150468a = r100;
    }
}
