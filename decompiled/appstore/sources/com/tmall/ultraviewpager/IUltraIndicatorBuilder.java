package com.tmall.ultraviewpager;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes4.dex */
public interface IUltraIndicatorBuilder {
    void build();

    IUltraIndicatorBuilder setFocusColor(int r10);

    IUltraIndicatorBuilder setFocusIcon(Bitmap r10);

    IUltraIndicatorBuilder setFocusResId(int r10);

    IUltraIndicatorBuilder setGravity(int r10);

    IUltraIndicatorBuilder setIndicatorPadding(int r10);

    IUltraIndicatorBuilder setMargin(int r10, int r11, int r12, int r13);

    IUltraIndicatorBuilder setNormalColor(int r10);

    IUltraIndicatorBuilder setNormalIcon(Bitmap r10);

    IUltraIndicatorBuilder setNormalResId(int r10);

    IUltraIndicatorBuilder setOrientation(UltraViewPager.Orientation r10);

    IUltraIndicatorBuilder setRadius(int r10);

    IUltraIndicatorBuilder setStrokeColor(int r10);

    IUltraIndicatorBuilder setStrokeWidth(int r10);
}
