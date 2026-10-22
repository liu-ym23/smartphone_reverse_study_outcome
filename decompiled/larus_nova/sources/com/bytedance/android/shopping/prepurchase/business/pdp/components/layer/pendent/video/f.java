package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.view.View;
import com.bytedance.android.shopping.legacy.DragRelativeLayout;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f181535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DragRelativeLayout f181536b;

    public f(a r100, DragRelativeLayout r101) {
        this.f181535a = r100;
        this.f181536b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        r100.setVisibility(0);
        if (this.f181535a.f181516j.f181555d.f181587b == false) goto L5;
        r100.setTranslationX(this.f181536b.getWidth() - r100.getLeft());
    L6:
        r100.animate().translationX(0.0f).setDuration(300).start();
        return;
    L5:
        r100.setTranslationX(-r100.getRight());
        goto L6
    }
}
