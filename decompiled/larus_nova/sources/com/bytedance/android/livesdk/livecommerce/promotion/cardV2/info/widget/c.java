package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements fj2.a<TextView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f150637a;

    @Override // fj2.a
    public final String type() {
        return "label_item_text";
    }

    @Override // fj2.a
    public final TextView create() {
        TextView r100 = new TextView(this.f150637a);
        r100.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        r100.setGravity(17);
        return r100;
    }

    public c(Context r100) {
        this.f150637a = r100;
    }
}
