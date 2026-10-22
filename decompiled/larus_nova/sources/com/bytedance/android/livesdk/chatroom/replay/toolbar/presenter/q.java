package com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter;

import android.graphics.Bitmap;
import androidx.palette.graphics.Palette;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayPortraitVideoBottomToolbarPresenter f110171a;

    public q(ReplayPortraitVideoBottomToolbarPresenter r100) {
        this.f110171a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ReplayPortraitVideoBottomToolbarPresenter r101 = this.f110171a;
        Bitmap r102 = (Bitmap) sh6.c.b((sh6.b) r100);
        int r103 = ReplayPortraitVideoBottomToolbarPresenter.f110143v;
        r101.getClass();
        if (r102 == null) goto L6;
        new Palette.Builder(r102).generate(new p(r101));
        return;
    }
}
