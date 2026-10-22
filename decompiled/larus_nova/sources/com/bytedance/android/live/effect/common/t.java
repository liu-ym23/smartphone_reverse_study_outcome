package com.bytedance.android.live.effect.common;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: classes45.dex */
public final class t<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCommonStickerListView f67874a;

    public t(LiveCommonStickerListView r100) {
        this.f67874a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Sticker r101 = (Sticker) r100;
        LiveCommonStickerListView.b6(this.f67874a);
    }
}
