package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes2.dex */
public class RectEvaluator implements TypeEvaluator<Rect> {
    private final Rect rect;

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Rect evaluate(float r1, Rect r2, Rect r3) {
        return evaluate2(r1, r2, r3);
    }

    public RectEvaluator(Rect r1) {
        this.rect = r1;
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Rect evaluate2(float r6, Rect r7, Rect r8) {
        this.rect.set(r7.left + ((int) ((r8.left - r7.left) * r6)), r7.top + ((int) ((r8.top - r7.top) * r6)), r7.right + ((int) ((r8.right - r7.right) * r6)), r7.bottom + ((int) ((r8.bottom - r7.bottom) * r6)));
        return this.rect;
    }
}
