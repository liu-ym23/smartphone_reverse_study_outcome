package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import com.bytedance.android.live.effect.sticker.ui.StickerSearchBox;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class v0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickerSearchPageView f68779a;

    public v0(StickerSearchPageView r100) {
        this.f68779a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        StickerSearchBox r102 = StickerSearchPageView.T5(this.f68779a);
        if (r102 == null) goto L6;
        r102.T5(r101);
        return;
    }
}
