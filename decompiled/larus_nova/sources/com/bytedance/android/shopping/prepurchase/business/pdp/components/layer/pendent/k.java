package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MoreVideoComponent f181467a;

    public k(MoreVideoComponent r100) {
        this.f181467a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        MoreVideoComponent.b r109 = MoreVideoComponent.i2(this.f181467a);
        if (r109 == null) goto L5;
        r109.setAlpha(1.0f);
    L5:
        r100.setTranslationX(r100.getWidth() + com.bytedance.android.shopping.extensions.b.a(12));
        r100.animate().translationX(0.0f).setDuration(1000).start();
    }
}
