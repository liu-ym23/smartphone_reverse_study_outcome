package com.bytedance.android.live.uikit.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes7.dex */
public class SSViewPager extends ViewPager {
    public SSViewPager(Context r100) {
        super(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        return super.onInterceptTouchEvent(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public SSViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
