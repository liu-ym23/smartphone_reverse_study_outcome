package com.bytedance.android.gamecp.business.floatwindow.installguide.banner;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;
import ts.a;

/* JADX INFO: loaded from: classes44.dex */
public class GuideViewPager extends ViewPager {
    public GuideViewPager(Context r100) {
        super(r100);
        addOnPageChangeListener(new a());
    }

    public GuideViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        addOnPageChangeListener(new a());
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void onPageScrolled(int r100, float r101, int r102) {
        super.onPageScrolled(r100, r101, r102);
    }
}
