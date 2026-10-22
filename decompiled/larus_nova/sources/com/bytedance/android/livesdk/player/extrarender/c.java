package com.bytedance.android.livesdk.player.extrarender;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExtraRenderView f155264a;

    public c(ExtraRenderView r100) {
        this.f155264a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Rect r102 = new Rect(0, 0, this.f155264a.getRenderViewWrapper().getWidth(), this.f155264a.getRenderViewWrapper().getHeight());
        if (r101 == null) goto L6;
        r101.setRoundRect(r102, 12.0f);
        return;
    }
}
