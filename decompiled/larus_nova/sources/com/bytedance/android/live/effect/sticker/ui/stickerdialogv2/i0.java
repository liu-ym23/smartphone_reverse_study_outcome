package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;

/* JADX INFO: loaded from: classes45.dex */
public final class i0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickerSearchPageView f68752a;

    public i0(StickerSearchPageView r100) {
        this.f68752a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LoadingStatusView r101 = StickerSearchPageView.R5(this.f68752a);
        if (r101 == null) goto L5;
        r101.showLoading();
    L5:
        StickerSearchPageView.c6(this.f68752a);
    }
}
