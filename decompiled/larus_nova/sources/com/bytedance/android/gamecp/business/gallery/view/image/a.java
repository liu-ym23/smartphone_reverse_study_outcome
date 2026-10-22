package com.bytedance.android.gamecp.business.gallery.view.image;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransferImage f53360a;

    public a(TransferImage r100) {
        this.f53360a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final synchronized void onAnimationUpdate(ValueAnimator r100) {
        monitor-enter(this);
        TransferImage r101 = this.f53360a;     // Catch: Throwable -> L14
        TransferImage.b r102 = r101.f53349v1;     // Catch: Throwable -> L14
        if (r102 == null) goto L6;
        com.bytedance.android.gamecp.business.gallery.transfer.e.c r103 = (com.bytedance.android.gamecp.business.gallery.transfer.e.c) r102;     // Catch: Throwable -> L14
        r103.b(r101.W, r100.getAnimatedFraction());     // Catch: Throwable -> L14
    L6:
        TransferImage.c r104 = this.f53360a.f53348p1;     // Catch: Throwable -> L14
        if (r104 == null) goto L11;
        TransferImage.a r105 = r104.f53359f;     // Catch: Throwable -> L14
        if (r105 == null) goto L11;
        r105.f53350a = ((Float) r100.getAnimatedValue("left")).floatValue();     // Catch: Throwable -> L14
        TransferImage.a r106 = this.f53360a.f53348p1.f53359f;     // Catch: Throwable -> L14
        r106.f53351b = ((Float) r100.getAnimatedValue("top")).floatValue();     // Catch: Throwable -> L14
        TransferImage.a r107 = this.f53360a.f53348p1.f53359f;     // Catch: Throwable -> L14
        r107.f53352c = ((Float) r100.getAnimatedValue("width")).floatValue();     // Catch: Throwable -> L14
        TransferImage.a r108 = this.f53360a.f53348p1.f53359f;     // Catch: Throwable -> L14
        r108.f53353d = ((Float) r100.getAnimatedValue("height")).floatValue();     // Catch: Throwable -> L14
    L11:
        this.f53360a.invalidate();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
