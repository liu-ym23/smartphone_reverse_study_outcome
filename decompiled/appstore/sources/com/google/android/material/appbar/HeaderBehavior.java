package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import kotlinx.coroutines.channels.Channel;
import p.a;

/* JADX INFO: loaded from: classes3.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private static final int INVALID_POINTER = -1;
    private int activePointerId;

    @Nullable
    private Runnable flingRunnable;
    private boolean isBeingDragged;
    private int lastMotionY;
    OverScroller scroller;
    private int touchSlop;

    @Nullable
    private VelocityTracker velocityTracker;

    public class FlingRunnable implements Runnable {
        private final V layout;
        private final CoordinatorLayout parent;
        final /* synthetic */ HeaderBehavior this$0;

        public FlingRunnable(HeaderBehavior r10, CoordinatorLayout r11, V r12) {
            this.this$0 = r10;
            this.parent = r11;
            this.layout = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.layout == null) goto L11;
            OverScroller r10 = this.this$0.scroller;
            if (r10 != null) goto L7;
            return;
        L7:
            if (r10.computeScrollOffset() == false) goto L9;
            HeaderBehavior r11 = this.this$0;
            r11.setHeaderTopBottomOffset(this.parent, this.layout, r11.scroller.getCurrY());
            ViewCompat.h0(this.layout, this);
            return;
        L9:
            this.this$0.onFlingFinished(this.parent, this.layout);
            return;
        }
    }

    public HeaderBehavior() {
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker != null) goto L6;
        this.velocityTracker = VelocityTracker.obtain();
        return;
    }

    public boolean canDragView(V r10) {
        return false;
    }

    public final boolean fling(CoordinatorLayout r14, @NonNull V r15, int r16, int r17, float r18) {
        Runnable r10 = this.flingRunnable;
        if (r10 == null) goto L6;
        r15.removeCallbacks(r10);
        this.flingRunnable = null;
    L6:
        if (this.scroller != null) goto L8;
        this.scroller = new OverScroller(r15.getContext());
    L8:
        this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(r18), 0, 0, r16, r17);
        if (this.scroller.computeScrollOffset() == false) goto L12;
        FlingRunnable r11 = new FlingRunnable(this, r14, r15);
        this.flingRunnable = r11;
        ViewCompat.h0(r15, r11);
        return true;
    L12:
        onFlingFinished(r14, r15);
        return false;
    }

    public int getMaxDragOffset(@NonNull V r10) {
        return -r10.getHeight();
    }

    public int getScrollRangeForDragFling(@NonNull V r10) {
        return r10.getHeight();
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    public void onFlingFinished(CoordinatorLayout r10, V r11) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull MotionEvent r12) {
        if (this.touchSlop >= 0) goto L6;
        this.touchSlop = ViewConfiguration.get(r10.getContext()).getScaledTouchSlop();
    L6:
        if (r12.getActionMasked() != 2) goto L20;
        if (this.isBeingDragged == false) goto L20;
        int r13 = this.activePointerId;
        if (r13 != (-1)) goto L12;
        return false;
    L12:
        int r14 = r12.findPointerIndex(r13);
        if (r14 != (-1)) goto L15;
        return false;
    L15:
        int r15 = (int) r12.getY(r14);
        if (Math.abs(r15 - this.lastMotionY) <= this.touchSlop) goto L20;
        this.lastMotionY = r15;
        return true;
    L20:
        if (r12.getActionMasked() != 0) goto L35;
        this.activePointerId = -1;
        int r16 = (int) r12.getX();
        int r17 = (int) r12.getY();
        if (canDragView(r11) == true) goto L24;
    L26:
        boolean r18 = false;
    L27:
        this.isBeingDragged = r18;
        if (r18 == false) goto L35;
        this.lastMotionY = r17;
        this.activePointerId = r12.getPointerId(0);
        ensureVelocityTracker();
        OverScroller r19 = this.scroller;
        if (r19 == null) goto L35;
        if (r19.isFinished() == true) goto L35;
        this.scroller.abortAnimation();
        return true;
    L24:
        if (r10.isPointInChildBounds(r11, r16, r17) == false) goto L26;
        r18 = true;
    L35:
        VelocityTracker r20 = this.velocityTracker;
        if (r20 == null) goto L38;
        r20.addMovement(r12);
    L38:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout r12, @NonNull V r13, @NonNull MotionEvent r14) {
        int r10 = r14.getActionMasked();
        if (r10 != 1) goto L5;
        VelocityTracker r11 = this.velocityTracker;
        if (r11 == null) goto L24;
        r11.addMovement(r14);
        this.velocityTracker.computeCurrentVelocity(1000);
        fling(r12, r13, -getScrollRangeForDragFling(r13), 0, this.velocityTracker.getYVelocity(this.activePointerId));
        boolean r15 = true;
    L25:
        this.isBeingDragged = false;
        this.activePointerId = -1;
        VelocityTracker r16 = this.velocityTracker;
        if (r16 == null) goto L28;
        r16.recycle();
        this.velocityTracker = null;
    L28:
        VelocityTracker r17 = this.velocityTracker;
        if (r17 == null) goto L32;
        r17.addMovement(r14);
    L32:
        if (this.isBeingDragged == true) goto L37;
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
        int r18 = r14.findPointerIndex(this.activePointerId);
        if (r18 != (-1)) goto L19;
        return false;
    L19:
        int r19 = (int) r14.getY(r18);
        int r20 = this.lastMotionY - r19;
        this.lastMotionY = r19;
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
        this.activePointerId = r14.getPointerId(r110);
        this.lastMotionY = (int) (r14.getY(r110) + 0.5f);
        goto L20
    L14:
        r110 = 0;
        goto L15
    }

    public final int scroll(CoordinatorLayout r10, V r11, int r12, int r13, int r14) {
        return setHeaderTopBottomOffset(r10, r11, getTopBottomOffsetForScrollingSibling() - r12, r13, r14);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r10, V r11, int r12) {
        return setHeaderTopBottomOffset(r10, r11, r12, Integer.MIN_VALUE, Channel.UNLIMITED);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r10, V r11, int r12, int r13, int r14) {
        int r15 = getTopAndBottomOffset();
        if (r13 == 0) goto L9;
        if (r15 < r13) goto L9;
        if (r15 > r14) goto L9;
        int r16 = a.b(r12, r13, r14);
        if (r15 == r16) goto L9;
        setTopAndBottomOffset(r16);
        return r15 - r16;
    L9:
        return 0;
    }

    public HeaderBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.activePointerId = -1;
        this.touchSlop = -1;
    }
}
