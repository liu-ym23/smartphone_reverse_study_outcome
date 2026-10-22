package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes45.dex */
public final class o0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickerSearchPageView f68765a;

    public o0(StickerSearchPageView r100) {
        this.f68765a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        StickerSearchPageView r101 = this.f68765a;
        StickerSearchPageView.b6(r101, (com.bytedance.android.live.effect.sticker.viewmodel.a) r100);
    }
}
