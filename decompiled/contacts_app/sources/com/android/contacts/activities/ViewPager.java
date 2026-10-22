package com.android.contacts.activities;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager extends androidx.viewpager.widget.ViewPager {
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r1) {
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent r1) {
        return false;
    }

    public ViewPager(Context r1) {
        super(r1);
    }

    public ViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
