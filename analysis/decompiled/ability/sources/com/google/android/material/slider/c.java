package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import com.google.android.material.internal.o;
import j3.C1595a;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f2521a;

    public c(f fVar) {
        this.f2521a = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        f fVar = this.f2521a;
        ViewGroup viewGroupA = o.a(fVar);
        ViewOverlay overlay = viewGroupA == null ? null : viewGroupA.getOverlay();
        if (overlay == null) {
            return;
        }
        Iterator it = fVar.l.iterator();
        while (it.hasNext()) {
            overlay.remove((C1595a) it.next());
        }
    }
}
