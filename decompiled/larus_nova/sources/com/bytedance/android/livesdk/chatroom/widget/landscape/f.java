package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.graphics.Bitmap;
import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeQuickShotLayerWidget f119072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f119073b;

    public f(LandscapeQuickShotLayerWidget r100, Bitmap r101) {
        this.f119072a = r100;
        this.f119073b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LandscapeQuickShotLayerWidget.wq(this.f119072a, this.f119073b);
    }
}
