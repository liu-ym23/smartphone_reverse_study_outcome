package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: FadeThroughProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f13756a;

    public e() {
        this.f13756a = 0.35f;
    }

    @Override // com.google.android.material.transition.platform.m
    public Animator a(ViewGroup r7, View r8) {
        if (r8.getAlpha() != 0.0f) goto L5;
        float r9 = 1.0f;
    L6:
        float r5 = r9;
        return a(r8, 0.0f, r5, this.f13756a, 1.0f, r5);
    L5:
        r9 = r8.getAlpha();
        goto L6
    }

    @Override // com.google.android.material.transition.platform.m
    public Animator b(ViewGroup r7, View r8) {
        if (r8.getAlpha() != 0.0f) goto L5;
        float r9 = 1.0f;
    L6:
        float r5 = r9;
        return a(r8, r5, 0.0f, 0.0f, this.f13756a, r5);
    L5:
        r9 = r8.getAlpha();
        goto L6
    }

    private static Animator a(final View r8, final float r9, final float r10, final float r11, final float r12, final float r13) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.addUpdateListener(new FadeThroughProvider$1(r8, r9, r10, r11, r12));
        r0.addListener(new FadeThroughProvider$2(r8, r13));
        return r0;
    }
}
