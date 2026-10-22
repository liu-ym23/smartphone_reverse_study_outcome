package com.bytedanceos.common.ui.widget.image;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
public class ImageViewPager extends ViewPager {
    public ImageViewPager(Context r10) {
        super(r10);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        return super.onInterceptTouchEvent(r10);
    L5:
        return false;
    }

    public ImageViewPager(Context r10, AttributeSet r11) {
        super(r10, r11);
    }
}
