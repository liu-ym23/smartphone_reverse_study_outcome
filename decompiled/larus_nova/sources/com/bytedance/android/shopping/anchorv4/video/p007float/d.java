package com.bytedance.android.shopping.anchorv4.video.p007float;

import android.view.View;
import com.bytedance.android.shopping.legacy.DragRelativeLayout;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f167603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DragRelativeLayout f167604b;

    public d(a r100, DragRelativeLayout r101) {
        this.f167603a = r100;
        this.f167604b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        r100.setVisibility(0);
        if (this.f167603a.f167594j.f167621e.f167660b == false) goto L5;
        r100.setTranslationX(this.f167604b.getWidth() - r100.getLeft());
    L6:
        r100.animate().translationX(0.0f).setDuration(300).start();
        return;
    L5:
        r100.setTranslationX(-r100.getRight());
        goto L6
    }
}
