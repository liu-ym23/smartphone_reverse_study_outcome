package com.bytedance.android.livesdk.gamesticker.layoutstrategy;

import com.bytedance.android.livesdkapi.view.IRenderView;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements IRenderView.LayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveFoldScreenLandscapeLayoutStrategy f125689a;

    public c(LiveFoldScreenLandscapeLayoutStrategy r100) {
        this.f125689a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView.LayoutListener
    public final void onLayoutReady(int r100, int r101, int r102, int r103) {
        this.f125689a.c("on render layout change");
        LiveFoldScreenLandscapeLayoutStrategy.a(this.f125689a);
    }
}
