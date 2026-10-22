package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import com.bytedance.android.live.base.model.ImageModel;

/* JADX INFO: loaded from: classes8.dex */
public final class j0 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageModel f123965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DrawerSmallLiveViewHolder f123966b;

    public j0(DrawerSmallLiveViewHolder r100, ImageModel r101) {
        this.f123966b = r100;
        this.f123965a = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        DrawerSmallLiveViewHolder r109 = this.f123966b;
        int r110 = this.f123965a.getWidth();
        int r111 = this.f123965a.getHeight();
        int r112 = DrawerSmallLiveViewHolder.V;
        r109.q4(r110, r111);
    }
}
