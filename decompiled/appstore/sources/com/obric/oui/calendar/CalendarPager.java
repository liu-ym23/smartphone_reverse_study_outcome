package com.obric.oui.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes4.dex */
class CalendarPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12545a;

    public CalendarPager(Context r10) {
        super(r10);
        this.f12545a = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int r10) {
        if (this.f12545a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r10) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r10) {
        if (this.f12545a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically(r10) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.f12545a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r10) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.f12545a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r10) == false) goto L7;
        return true;
    }

    public void u(boolean r10) {
        this.f12545a = r10;
    }

    public CalendarPager(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.f12545a = true;
    }
}
