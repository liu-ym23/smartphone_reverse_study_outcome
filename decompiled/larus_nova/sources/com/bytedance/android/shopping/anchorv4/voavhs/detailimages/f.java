package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import com.bytedance.android.shopping.anchorv4.dto.ImageOCRResponseDTO;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4DetailImageView f168317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f168318b;

    public f(AnchorV4DetailImageView r100, d r101) {
        this.f168317a = r100;
        this.f168318b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f168317a.setContentDescription(com.bytedance.android.shopping.extensions.j.e(R.string.shopping_format_goods_detail_image_ocr, Integer.valueOf(this.f168318b.f168309c + 1), ((ImageOCRResponseDTO) r100).getOcrTexts()));
    }
}
