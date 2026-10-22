package com.bytedance.android.gamecp.business.gallery.view.image;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransferImage f53361a;

    public b(TransferImage r100) {
        this.f53361a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final synchronized void onAnimationUpdate(ValueAnimator r100) {
        monitor-enter(this);
        TransferImage.c r101 = this.f53361a.f53348p1;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        TransferImage.a r102 = r101.f53359f;     // Catch: Throwable -> L11
        if (r102 == null) goto L8;
        r102.f53350a = ((Float) r100.getAnimatedValue("left")).floatValue();     // Catch: Throwable -> L11
        TransferImage.a r103 = this.f53361a.f53348p1.f53359f;     // Catch: Throwable -> L11
        r103.f53351b = ((Float) r100.getAnimatedValue("top")).floatValue();     // Catch: Throwable -> L11
        TransferImage.a r104 = this.f53361a.f53348p1.f53359f;     // Catch: Throwable -> L11
        r104.f53352c = ((Float) r100.getAnimatedValue("width")).floatValue();     // Catch: Throwable -> L11
        TransferImage.a r105 = this.f53361a.f53348p1.f53359f;     // Catch: Throwable -> L11
        r105.f53353d = ((Float) r100.getAnimatedValue("height")).floatValue();     // Catch: Throwable -> L11
        TransferImage.c r106 = this.f53361a.f53348p1;     // Catch: Throwable -> L11
        r106.f53356c = ((Float) r100.getAnimatedValue("scale")).floatValue();     // Catch: Throwable -> L11
    L8:
        this.f53361a.invalidate();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
