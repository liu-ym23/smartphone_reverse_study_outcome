package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class y0 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f169567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w0 f169568b;

    public y0(w0 r100) {
        this.f169568b = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if (r100 == null) goto L14;
        int r109 = r100.getHeight();
        Integer r110 = this.f169567a;
        if (r110 != null) goto L7;
    L8:
        this.f169567a = Integer.valueOf(r100.getHeight());
        l r111 = this.f169568b.f169457i;
        if (r111 == null) goto L16;
        GalleryViewModel r112 = r111.f169328f;
        if (r112 == null) goto L17;
        r112.setBottomBarHeight(r100.getHeight());
        return;
    L17:
        return;
    L16:
        return;
    L7:
        if (r109 != r110.intValue()) goto L8;
        return;
    }
}
