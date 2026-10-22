package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes4.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f17528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17530c;

    public ViewOffsetBehavior() {
        this.f17529b = 0;
        this.f17530c = 0;
    }

    public int getTopAndBottomOffset() {
        a r10 = this.f17528a;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.b();
    }

    public void layoutChild(CoordinatorLayout r10, View r11, int r12) {
        r10.onLayoutChild(r11, r12);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r10, View r11, int r12) {
        layoutChild(r10, r11, r12);
        if (this.f17528a != null) goto L5;
        this.f17528a = new a(r11);
    L5:
        this.f17528a.c();
        this.f17528a.a();
        int r13 = this.f17529b;
        if (r13 == 0) goto L8;
        this.f17528a.e(r13);
        this.f17529b = 0;
    L8:
        int r14 = this.f17530c;
        if (r14 == 0) goto L13;
        this.f17528a.d(r14);
        this.f17530c = 0;
        return true;
    L13:
        return true;
    }

    public boolean setTopAndBottomOffset(int r10) {
        a r11 = this.f17528a;
        if (r11 != null) goto L5;
        this.f17529b = r10;
        return false;
    L5:
        return r11.e(r10);
    }

    public ViewOffsetBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f17529b = 0;
        this.f17530c = 0;
    }
}
