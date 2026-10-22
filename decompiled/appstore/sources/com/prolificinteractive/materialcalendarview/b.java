package com.prolificinteractive.materialcalendarview;

import android.content.Context;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes4.dex */
public class b extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17757a;

    public b(Context r10) {
        super(r10);
        this.f17757a = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int r10) {
        if (this.f17757a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r10) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r10) {
        if (this.f17757a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically(r10) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.f17757a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r10) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.f17757a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r10) == false) goto L7;
        return true;
    }

    public void u(boolean r10) {
        this.f17757a = r10;
    }
}
