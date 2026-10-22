package com.bytedance.android.livesdk.gamesticker.layoutstrategy;

import com.bytedance.android.livesdkapi.view.IRenderView;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements IRenderView.LayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveFoldScreenFullLandscapeLayoutStrategy f125687a;

    public a(LiveFoldScreenFullLandscapeLayoutStrategy r100) {
        this.f125687a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView.LayoutListener
    public final void onLayoutReady(int r100, int r101, int r102, int r103) {
        this.f125687a.c("on render layout change");
        LiveFoldScreenFullLandscapeLayoutStrategy.a(this.f125687a);
    }
}
