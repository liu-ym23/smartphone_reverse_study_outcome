package com.tmall.ultraviewpager;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes4.dex */
interface IUltraViewPagerFeature {
    void disableAutoScroll();

    void disableIndicator();

    void disableScrollDirection(UltraViewPager.ScrollDirection r10);

    IUltraIndicatorBuilder initIndicator();

    IUltraIndicatorBuilder initIndicator(int r10, int r11, int r12);

    IUltraIndicatorBuilder initIndicator(int r10, int r11, int r12, int r13);

    IUltraIndicatorBuilder initIndicator(int r10, int r11, int r12, int r13, int r14, int r15);

    IUltraIndicatorBuilder initIndicator(Bitmap r10, Bitmap r11, int r12);

    void scrollNextPage();

    void setAutoMeasureHeight(boolean r10);

    void setAutoScroll(int r10);

    void setHGap(int r10);

    void setInfiniteLoop(boolean r10);

    void setInfiniteRatio(int r10);

    void setItemMargin(int r10, int r11, int r12, int r13);

    void setItemRatio(double r10);

    void setMaxHeight(int r10);

    void setMaxWidth(int r10);

    void setMultiScreen(float r10);

    void setRatio(float r10);

    void setScrollMargin(int r10, int r11);

    void setScrollMode(UltraViewPager.ScrollMode r10);
}
