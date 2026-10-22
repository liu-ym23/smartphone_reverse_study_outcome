package com.bytedance.android.live.effect.common;

import androidx.lifecycle.Observer;
import com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.StickerLoadingStatus;

/* JADX INFO: loaded from: classes45.dex */
public final class s<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCommonStickerListView f67873a;

    public s(LiveCommonStickerListView r100) {
        this.f67873a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        LiveCommonStickerListView r101 = this.f67873a;
        LiveCommonStickerListView.Z5(r101, (StickerLoadingStatus) r100);
    }
}
