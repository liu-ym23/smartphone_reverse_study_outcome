package com.bytedance.android.shopping.store.home.presenter.preview;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f184348a;

    public e(ViewGroup r100) {
        this.f184348a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if (this.f184348a.getWidth() > 0) goto L5;
        return;
    L5:
        if (this.f184348a.getHeight() <= 0) goto L9;
        ViewGroup r109 = this.f184348a;
        r109.setPivotX(r109.getWidth());
        ViewGroup r110 = this.f184348a;
        r110.setPivotY(r110.getHeight());
        this.f184348a.setScaleX(0.95f);
        this.f184348a.setScaleY(0.95f);
        return;
    }
}
