package com.bytedance.android.livesdk.player.extrarender.game;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GameExtraRenderView f155284a;

    public a(GameExtraRenderView r100) {
        this.f155284a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Rect r102 = new Rect(0, 0, this.f155284a.getRenderViewWrapper().getWidth(), this.f155284a.getRenderViewWrapper().getHeight());
        if (r101 == null) goto L6;
        r101.setRoundRect(r102, 12.0f);
        return;
    }
}
