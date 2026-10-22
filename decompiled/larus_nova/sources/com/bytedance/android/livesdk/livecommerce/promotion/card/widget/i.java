package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes10.dex */
public final class i implements fj2.a<TextView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECUserRightsTagWidget f150466a;

    @Override // fj2.a
    public final String type() {
        return "tag_item_split";
    }

    @Override // fj2.a
    public final TextView create() {
        TextView r100 = new TextView(this.f150466a.getContext());
        r100.setTag("text");
        r100.setText(" · ");
        r100.setMaxLines(1);
        r100.setTextSize(1, 12.0f);
        r100.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        return r100;
    }

    public i(ECUserRightsTagWidget r100) {
        this.f150466a = r100;
    }
}
