package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes3.dex */
class TabIndicatorInterpolator {

    @Dimension(unit = 0)
    private static final int MIN_INDICATOR_WIDTH = 24;

    public TabIndicatorInterpolator() {
    }

    public static RectF calculateIndicatorWidthForTab(TabLayout r10, @Nullable View r11) {
        if (r11 != null) goto L6;
        return new RectF();
    L6:
        if (r10.isTabIndicatorFullWidth() == true) goto L12;
        if ((r11 instanceof TabLayout.TabView) == false) goto L12;
        return calculateTabViewContentBounds((TabLayout.TabView) r11, 24);
    L12:
        return new RectF(r11.getLeft(), r11.getTop(), r11.getRight(), r11.getBottom());
    }

    public static RectF calculateTabViewContentBounds(@NonNull TabLayout.TabView r10, @Dimension(unit = 0) int r11) {
        int r12 = r10.getContentWidth();
        int r13 = r10.getContentHeight();
        int r14 = (int) ViewUtils.dpToPx(r10.getContext(), r11);
        if (r12 >= r14) goto L5;
        r12 = r14;
    L5:
        int r15 = (r10.getLeft() + r10.getRight()) / 2;
        int r16 = (r10.getTop() + r10.getBottom()) / 2;
        int r17 = r12 / 2;
        return new RectF(r15 - r17, r16 - (r13 / 2), r17 + r15, r16 + (r15 / 2));
    }

    public void setIndicatorBoundsForOffset(TabLayout r10, View r11, View r12, @FloatRange(from = 0.0d, to = 1.0d) float r13, @NonNull Drawable r14) {
        RectF r15 = calculateIndicatorWidthForTab(r10, r11);
        RectF r16 = calculateIndicatorWidthForTab(r10, r12);
        r14.setBounds(AnimationUtils.lerp((int) r15.left, (int) r16.left, r13), r14.getBounds().top, AnimationUtils.lerp((int) r15.right, (int) r16.right, r13), r14.getBounds().bottom);
    }

    public void setIndicatorBoundsForTab(TabLayout r10, View r11, @NonNull Drawable r12) {
        RectF r13 = calculateIndicatorWidthForTab(r10, r11);
        r12.setBounds((int) r13.left, r12.getBounds().top, (int) r13.right, r12.getBounds().bottom);
    }
}
