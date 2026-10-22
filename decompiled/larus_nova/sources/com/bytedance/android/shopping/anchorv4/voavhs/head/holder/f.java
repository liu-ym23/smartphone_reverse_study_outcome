package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.dto.ImageOCRResponseDTO;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f168685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h83.b f168686b;

    public f(View r100, h83.b r101) {
        this.f168685a = r100;
        this.f168686b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f168685a.setContentDescription(com.bytedance.android.shopping.extensions.j.e(R.string.shopping_format_goods_image_ocr, Integer.valueOf(this.f168686b.f484071b + 1), ((ImageOCRResponseDTO) r100).getOcrTexts()));
    }
}
