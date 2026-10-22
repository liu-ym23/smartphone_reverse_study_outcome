package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4DetailImageView f168319a;

    public g(AnchorV4DetailImageView r100) {
        this.f168319a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f168319a.setContentDescription(com.bytedance.android.shopping.extensions.j.c(R.string.shopping_format_goods_image_ocr_error));
    }
}
