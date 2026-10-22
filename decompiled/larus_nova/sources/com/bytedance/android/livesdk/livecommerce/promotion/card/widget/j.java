package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements fj2.a<TextView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECUserRightsTagWidget f150467a;

    @Override // fj2.a
    public final String type() {
        return "tag_item_text";
    }

    @Override // fj2.a
    public final TextView create() {
        TextView r100 = new TextView(this.f150467a.getContext());
        r100.setTag("text");
        r100.setMaxLines(1);
        r100.setTextSize(12.0f);
        r100.setTextColor(th.a.a(r100.getContext(), R.color.shopping_std_text_black_2));
        return r100;
    }

    public j(ECUserRightsTagWidget r100) {
        this.f150467a = r100;
    }
}
