package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes10.dex */
public final class l implements fj2.a<TextView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECUserRightsTagWidget f150469a;

    @Override // fj2.a
    public final String type() {
        return "tag_item_split_text";
    }

    @Override // fj2.a
    public final TextView create() {
        TextView r100 = new TextView(this.f150469a.getContext());
        r100.setTag("text");
        r100.setMaxLines(1);
        r100.setTextSize(1, 12.0f);
        r100.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        return r100;
    }

    public l(ECUserRightsTagWidget r100) {
        this.f150469a = r100;
    }
}
