package com.tmall.ultraviewpager.transformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes4.dex */
public class UltraVerticalTransformer implements ViewPager.PageTransformer {
    private float yPosition;

    public UltraVerticalTransformer() {
    }

    public float getPosition() {
        return this.yPosition;
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer, androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View r10, float r11) {
        r10.setTranslationX(r10.getWidth() * (-r11));
        float r12 = r11 * r10.getHeight();
        this.yPosition = r12;
        r10.setTranslationY(r12);
    }
}
