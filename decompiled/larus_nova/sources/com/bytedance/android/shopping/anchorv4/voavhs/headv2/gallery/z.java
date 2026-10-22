package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class z implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f169569a;

    public z(t r100) {
        this.f169569a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        this.f169569a.f169396d.f169328f.setMoreVideoHeight(r100.getHeight());
        t r109 = this.f169569a;
        if (r109.f169395c == true) goto L6;
        r109.h(false);
        return;
    }
}
