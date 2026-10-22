package com.tmall.ultraviewpager.transformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes4.dex */
public class UltraDepthScaleTransformer implements ViewPager.PageTransformer {
    private static final float MAX_ROTATION = 30.0f;
    private static final float MIN_SCALE = 0.5f;

    public UltraDepthScaleTransformer() {
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer, androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View r10, float r11) {
        float r12 = ((1.0f - Math.abs(r11)) * MIN_SCALE) + MIN_SCALE;
        float r13 = Math.abs(r11) * MAX_ROTATION;
        if (r11 > 0.0f) goto L6;
        r10.setTranslationX((r10.getWidth() * (-r11)) * 0.19f);
        r10.setPivotY(r10.getHeight() * MIN_SCALE);
        r10.setPivotX(r10.getWidth() * MIN_SCALE);
        r10.setScaleX(r12);
        r10.setScaleY(r12);
        r10.setRotationY(r13);
        return;
    L6:
        if (r11 > 1.0f) goto L10;
        r10.setTranslationX((r10.getWidth() * (-r11)) * 0.19f);
        r10.setPivotY(r10.getHeight() * MIN_SCALE);
        r10.setPivotX(r10.getWidth() * MIN_SCALE);
        r10.setScaleX(r12);
        r10.setScaleY(r12);
        r10.setRotationY(-r13);
        return;
    }
}
