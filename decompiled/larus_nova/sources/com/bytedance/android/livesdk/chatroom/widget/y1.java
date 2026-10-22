package com.bytedance.android.livesdk.chatroom.widget;

import android.graphics.Bitmap;
import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public final class y1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f119263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PortraitQuickShotLayerWidget f119264b;

    public y1(Bitmap r100, PortraitQuickShotLayerWidget r101) {
        this.f119263a = r100;
        this.f119264b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PortraitQuickShotLayerWidget.xq(this.f119264b, this.f119263a);
    }
}
