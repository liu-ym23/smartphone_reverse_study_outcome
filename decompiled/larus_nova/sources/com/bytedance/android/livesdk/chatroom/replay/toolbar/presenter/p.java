package com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter;

import android.widget.ImageView;
import androidx.palette.graphics.Palette;

/* JADX INFO: loaded from: classes7.dex */
public final class p implements Palette.PaletteAsyncListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayPortraitVideoBottomToolbarPresenter f110170a;

    public p(ReplayPortraitVideoBottomToolbarPresenter r100) {
        this.f110170a = r100;
    }

    @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
    public final void onGenerated(Palette r100) {
        ImageView r101 = this.f110170a.f110145t;
        if (r101 == null) goto L9;
        int r102 = 0;
        if (r100 == null) goto L7;
        r102 = r100.getDarkVibrantColor(0);
    L7:
        r101.setBackgroundColor(r102);
        return;
    }
}
