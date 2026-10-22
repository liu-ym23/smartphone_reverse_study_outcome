package com.bytedance.android.gamecp.business.gallery.view.image;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransferImage f53362a;

    public c(TransferImage r100) {
        this.f53362a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        TransferImage r101 = this.f53362a;
        int r102 = r101.f53347p0;
        if (r102 != 201) goto L10;
        TransferImage.c r103 = r101.f53348p1;
        if (r103 == null) goto L10;
        TransferImage.a r104 = r103.f53358e;
        if (r104 == null) goto L10;
        r101.P0 = (int) r104.f53350a;
        r101.V0 = (int) r104.f53351b;
        r101.H0 = (int) r104.f53352c;
        r101.L0 = (int) r104.f53353d;
    L10:
        if (r101.W == 1) goto L12;
    L14:
        TransferImage.b r105 = r101.f53349v1;
        if (r105 == null) goto L18;
        com.bytedance.android.gamecp.business.gallery.transfer.e.c r106 = (com.bytedance.android.gamecp.business.gallery.transfer.e.c) r105;
        r106.a(r101.W, r101.f53345k0, r102);
        return;
    L18:
        return;
    L12:
        if (r102 != 202) goto L14;
        r101.W = 0;
        goto L14
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        TransferImage.b r101 = this.f53362a.f53349v1;
        if (r101 == null) goto L6;
        ((com.bytedance.android.gamecp.business.gallery.transfer.e.c) r101).f53283a.f53275j = true;
        return;
    }
}
