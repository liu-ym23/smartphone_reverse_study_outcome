package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f17513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OverScroller f17514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f17515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f17516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public VelocityTracker f17519j;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoordinatorLayout f17520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f17521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HeaderBehavior f17522c;

        public a(HeaderBehavior r10, CoordinatorLayout r11, View r12) {
            this.f17522c = r10;
            this.f17520a = r11;
            this.f17521b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17521b != null) goto L5;
            return;
        L5:
            if (this.f17522c.f17514e == null) goto L12;
            Log.i("djd ", "FlingRunnable: " + this.f17521b.getClass().getName() + "  scroller.getCurrY：" + this.f17522c.f17514e.getCurrY());
            if (this.f17522c.f17514e.computeScrollOffset() == false) goto L9;
            HeaderBehavior r10 = this.f17522c;
            r10.setHeaderTopBottomOffset(this.f17520a, this.f17521b, r10.f17514e.getCurrY());
            ViewCompat.h0(this.f17521b, this);
            return;
        L9:
            this.f17522c.onFlingFinished(this.f17520a, this.f17521b);
            return;
        }
    }

    public HeaderBehavior() {
        this.f17516g = -1;
        this.f17518i = -1;
    }

    public void a() {
        OverScroller r10 = this.f17514e;
        if (r10 == null) goto L6;
        r10.abortAnimation();
        return;
    }

    public boolean canDragView(View r10) {
        return false;
    }

    public final void ensureVelocityTracker() {
        if (this.f17519j != null) goto L6;
        this.f17519j = VelocityTracker.obtain();
        return;
    }

    public boolean fling(CoordinatorLayout r14, View r15, int r16, int r17, float r18) {
        Runnable r10 = this.f17513d;
        if (r10 == null) goto L6;
        r15.removeCallbacks(r10);
        this.f17513d = null;
    L6:
        if (this.f17514e != null) goto L8;
        this.f17514e = new OverScroller(r15.getContext());
    L8:
        this.f17514e.fling(0, getTopAndBottomOffset(), 0, Math.round(r18), 0, 0, r16, r17);
        if (this.f17514e.computeScrollOffset() == false) goto L12;
        a r11 = new a(this, r14, r15);
        this.f17513d = r11;
        ViewCompat.h0(r15, r11);
        return true;
    L12:
        onFlingFinished(r14, r15);
        return false;
    }

    public int getMaxDragOffset(View r10) {
        return -r10.getHeight();
    }

    public int getScrollRangeForDragFling(View r10) {
        return r10.getHeight();
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior
    public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
        return super.getTopAndBottomOffset();
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    public void onFlingFinished(CoordinatorLayout r10, View r11) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r10, View r11, MotionEvent r12) {
        if (this.f17518i >= 0) goto L6;
        this.f17518i = ViewConfiguration.get(r10.getContext()).getScaledTouchSlop();
    L6:
        if (r12.getActionMasked() != 2) goto L20;
        if (this.f17515f == false) goto L20;
        int r13 = this.f17516g;
        if (r13 != (-1)) goto L12;
        return false;
    L12:
        int r14 = r12.findPointerIndex(r13);
        if (r14 != (-1)) goto L15;
        return false;
    L15:
        int r15 = (int) r12.getY(r14);
        if (Math.abs(r15 - this.f17517h) <= this.f17518i) goto L20;
        this.f17517h = r15;
        return true;
    L20:
        if (r12.getActionMasked() != 0) goto L35;
        this.f17516g = -1;
        int r16 = (int) r12.getX();
        int r17 = (int) r12.getY();
        if (canDragView(r11) == true) goto L24;
    L26:
        boolean r18 = false;
    L27:
        this.f17515f = r18;
        if (r18 == false) goto L35;
        this.f17517h = r17;
        this.f17516g = r12.getPointerId(0);
        ensureVelocityTracker();
        OverScroller r19 = this.f17514e;
        if (r19 == null) goto L35;
        if (r19.isFinished() == true) goto L35;
        this.f17514e.abortAnimation();
        return true;
    L24:
        if (r10.isPointInChildBounds(r11, r16, r17) == false) goto L26;
        r18 = true;
    L35:
        VelocityTracker r20 = this.f17519j;
        if (r20 == null) goto L38;
        r20.addMovement(r12);
    L38:
        return false;
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r10, View r11, int r12) {
        return super.onLayoutChild(r10, r11, r12);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r12, View r13, MotionEvent r14) {
        int r10 = r14.getActionMasked();
        if (r10 != 1) goto L5;
        VelocityTracker r11 = this.f17519j;
        if (r11 == null) goto L24;
        r11.addMovement(r14);
        this.f17519j.computeCurrentVelocity(1000);
        fling(r12, r13, -getScrollRangeForDragFling(r13), 0, this.f17519j.getYVelocity(this.f17516g));
        boolean r15 = true;
    L25:
        this.f17515f = false;
        this.f17516g = -1;
        VelocityTracker r16 = this.f17519j;
        if (r16 == null) goto L28;
        r16.recycle();
        this.f17519j = null;
    L28:
        VelocityTracker r17 = this.f17519j;
        if (r17 == null) goto L32;
        r17.addMovement(r14);
    L32:
        if (this.f17515f == true) goto L37;
        if (r15 == false) goto L36;
        return true;
    L36:
        return false;
    L37:
        return true;
    L24:
        r15 = false;
        goto L25
    L5:
        if (r10 != 2) goto L7;
        int r18 = r14.findPointerIndex(this.f17516g);
        if (r18 != (-1)) goto L19;
        return false;
    L19:
        int r19 = (int) r14.getY(r18);
        int r20 = this.f17517h - r19;
        this.f17517h = r19;
        scroll(r12, r13, r20, getMaxDragOffset(r13), 0);
    L20:
        r15 = false;
        goto L28
    L7:
        if (r10 == 3) goto L24;
        if (r10 != 6) goto L20;
        if (r14.getActionIndex() != 0) goto L14;
        int r110 = 1;
    L15:
        this.f17516g = r14.getPointerId(r110);
        this.f17517h = (int) (r14.getY(r110) + 0.5f);
        goto L20
    L14:
        r110 = 0;
        goto L15
    }

    public int scroll(CoordinatorLayout r10, View r11, int r12, int r13, int r14) {
        return setHeaderTopBottomOffset(r10, r11, getTopBottomOffsetForScrollingSibling() - r12, r13, r14);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r10, View r11, int r12) {
        return setHeaderTopBottomOffset(r10, r11, r12, Integer.MIN_VALUE, Channel.UNLIMITED);
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior
    public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r10) {
        return super.setTopAndBottomOffset(r10);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r10, View r11, int r12, int r13, int r14) {
        int r15 = getTopAndBottomOffset();
        if (r13 == 0) goto L9;
        if (r15 < r13) goto L9;
        if (r15 > r14) goto L9;
        int r16 = p.a.b(r12, r13, r14);
        if (r15 == r16) goto L9;
        setTopAndBottomOffset(r16);
        return r15 - r16;
    L9:
        return 0;
    }

    public HeaderBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f17516g = -1;
        this.f17518i = -1;
    }
}
