package com.bytedance.android.gamecp.business.gallery.view.image;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransferImage f53364a;

    public e(TransferImage r100) {
        this.f53364a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        TransferImage r101 = this.f53364a;
        TransferImage.b r102 = r101.f53349v1;
        if (r102 == null) goto L5;
        com.bytedance.android.gamecp.business.gallery.transfer.e.c r103 = (com.bytedance.android.gamecp.business.gallery.transfer.e.c) r102;
        r103.a(r101.W, r101.f53345k0, r101.f53347p0);
    L5:
        TransferImage r104 = this.f53364a;
        if (r104.W != 1) goto L9;
        r104.W = 0;
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        TransferImage.b r101 = this.f53364a.f53349v1;
        if (r101 == null) goto L6;
        ((com.bytedance.android.gamecp.business.gallery.transfer.e.c) r101).f53283a.f53275j = true;
        return;
    }
}
