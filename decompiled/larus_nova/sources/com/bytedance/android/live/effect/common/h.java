package com.bytedance.android.live.effect.common;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: classes45.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCommonStickerAdjustBarView f67857a;

    public h(LiveCommonStickerAdjustBarView r100) {
        this.f67857a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        LiveCommonStickerAdjustBarView r101 = this.f67857a;
        LiveCommonStickerAdjustBarView.S5(r101, (Sticker) r100);
    }
}
