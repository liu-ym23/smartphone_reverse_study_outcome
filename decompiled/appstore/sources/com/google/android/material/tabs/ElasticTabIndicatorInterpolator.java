package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes3.dex */
class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    public ElasticTabIndicatorInterpolator() {
    }

    private static float accInterp(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        return (float) (1.0d - Math.cos((((double) r10) * 3.141592653589793d) / 2.0d));
    }

    private static float decInterp(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        return (float) Math.sin((((double) r10) * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.TabIndicatorInterpolator
    public void setIndicatorBoundsForOffset(TabLayout r10, View r11, View r12, float r13, @NonNull Drawable r14) {
        RectF r15 = TabIndicatorInterpolator.calculateIndicatorWidthForTab(r10, r11);
        RectF r16 = TabIndicatorInterpolator.calculateIndicatorWidthForTab(r10, r12);
        if (r15.left >= r16.left) goto L5;
        float r17 = accInterp(r13);
        float r18 = decInterp(r13);
    L6:
        r14.setBounds(AnimationUtils.lerp((int) r15.left, (int) r16.left, r17), r14.getBounds().top, AnimationUtils.lerp((int) r15.right, (int) r16.right, r18), r14.getBounds().bottom);
        return;
    L5:
        r17 = decInterp(r13);
        r18 = accInterp(r13);
        goto L6
    }
}
