package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import com.bytedance.android.live.effect.sticker.ui.StickerSearchBox;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class u0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickerSearchPageView f68777a;

    public u0(StickerSearchPageView r100) {
        this.f68777a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        StickerSearchBox r102 = StickerSearchPageView.T5(this.f68777a);
        if (r102 == null) goto L6;
        r102.Z5();
        return;
    }
}
