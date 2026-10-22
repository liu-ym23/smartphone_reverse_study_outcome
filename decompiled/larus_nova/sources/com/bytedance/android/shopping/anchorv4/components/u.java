package com.bytedance.android.shopping.anchorv4.components;

import android.view.View;

/* JADX INFO: loaded from: classes12.dex */
public final class u implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f166160a;

    public u(o r100) {
        this.f166160a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        w r109 = this.f166160a.f166113d;
        if (r109 == null) goto L5;
        r109.setAlpha(1.0f);
    L5:
        r100.setTranslationX(r100.getWidth() + com.bytedance.android.shopping.extensions.b.a(12));
        r100.animate().translationX(0.0f).setDuration(1000).start();
    }
}
