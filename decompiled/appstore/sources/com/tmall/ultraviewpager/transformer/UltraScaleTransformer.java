package com.tmall.ultraviewpager.transformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes4.dex */
public class UltraScaleTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;

    public UltraScaleTransformer() {
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer, androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View r10, float r11) {
        r10.getWidth();
        float r12 = ((1.0f - Math.abs(r11)) * 0.25f) + MIN_SCALE;
        if (r11 >= 0.0f) goto L6;
        r10.setScaleX(r12);
        r10.setScaleY(r12);
        return;
    L6:
        if (r11 != 0.0f) goto L9;
        r10.setScaleX(1.0f);
        r10.setScaleY(1.0f);
        return;
    L9:
        if (r11 > 1.0f) goto L14;
        r10.setScaleX(r12);
        r10.setScaleY(r12);
        return;
    }
}
