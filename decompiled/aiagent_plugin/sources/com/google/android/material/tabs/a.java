package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: compiled from: ElasticTabIndicatorInterpolator.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends c {
    a() {
    }

    private static float a(float r4) {
        return (float) Math.sin((((double) r4) * 3.141592653589793d) / 2.0d);
    }

    private static float b(float r4) {
        return (float) (1.0d - Math.cos((((double) r4) * 3.141592653589793d) / 2.0d));
    }

    @Override // com.google.android.material.tabs.c
    void a(TabLayout r2, View r3, View r4, float r5, Drawable r6) {
        RectF r1 = a(r2, r3);
        RectF r7 = a(r2, r4);
        if (r1.left >= r7.left) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L8;
        float r9 = b(r5);
        float r10 = a(r5);
    L9:
        r6.setBounds(com.google.android.material.animation.a.a((int) r1.left, (int) r7.left, r9), r6.getBounds().top, com.google.android.material.animation.a.a((int) r1.right, (int) r7.right, r10), r6.getBounds().bottom);
        return;
    L8:
        r9 = a(r5);
        r10 = b(r5);
        goto L9
    L5:
        r8 = false;
        goto L6
    }
}
