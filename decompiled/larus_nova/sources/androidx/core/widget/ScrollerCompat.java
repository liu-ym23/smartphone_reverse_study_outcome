package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes17.dex */
public final class ScrollerCompat {
    OverScroller mScroller;

    public void abortAnimation() {
        this.mScroller.abortAnimation();
    }

    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }

    public float getCurrVelocity() {
        return this.mScroller.getCurrVelocity();
    }

    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    public int getFinalX() {
        return this.mScroller.getFinalX();
    }

    public int getFinalY() {
        return this.mScroller.getFinalY();
    }

    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    public boolean isOverScrolled() {
        return this.mScroller.isOverScrolled();
    }

    public static ScrollerCompat create(Context r100) {
        return create(r100, null);
    }

    public ScrollerCompat(Context r100, Interpolator r101) {
        if (r101 == null) goto L5;
        OverScroller r102 = new OverScroller(r100, r101);
    L6:
        this.mScroller = r102;
        return;
    L5:
        r102 = new OverScroller(r100);
        goto L6
    }

    public static ScrollerCompat create(Context r100, Interpolator r101) {
        return new ScrollerCompat(r100, r101);
    }

    public void notifyHorizontalEdgeReached(int r100, int r101, int r102) {
        this.mScroller.notifyHorizontalEdgeReached(r100, r101, r102);
    }

    public void notifyVerticalEdgeReached(int r100, int r101, int r102) {
        this.mScroller.notifyVerticalEdgeReached(r100, r101, r102);
    }

    public void startScroll(int r100, int r101, int r102, int r103) {
        this.mScroller.startScroll(r100, r101, r102, r103);
    }

    public void startScroll(int r100, int r101, int r102, int r110, int r111) {
        this.mScroller.startScroll(r100, r101, r102, r110, r111);
    }

    public boolean springBack(int r100, int r101, int r110, int r111, int r112, int r113) {
        return this.mScroller.springBack(r100, r101, r110, r111, r112, r113);
    }

    public void fling(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117) {
        this.mScroller.fling(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public void fling(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r210, int r211, int r212) {
        this.mScroller.fling(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }
}
