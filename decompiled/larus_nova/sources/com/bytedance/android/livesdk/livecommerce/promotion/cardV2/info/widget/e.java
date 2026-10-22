package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements fj2.a<ECDraweeView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f150639a;

    @Override // fj2.a
    public final String type() {
        return "label_item_image";
    }

    @Override // fj2.a
    public final ECDraweeView create() {
        ECDraweeView r100 = new ECDraweeView(this.f150639a, null, 0, 6, null);
        r100.setScaleType(ImageView.ScaleType.FIT_XY);
        return r100;
    }

    public e(Context r100) {
        this.f150639a = r100;
    }
}
