package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class LinearSmoothScroller extends RecyclerView.SmoothScroller {
    private static final boolean DEBUG = false;
    private static final float MILLISECONDS_PER_INCH = 25.0f;
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;
    private static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2f;
    private static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
    protected final DecelerateInterpolator mDecelerateInterpolator;
    private final DisplayMetrics mDisplayMetrics;
    private boolean mHasCalculatedMillisPerPixel;
    protected int mInterimTargetDx;
    protected int mInterimTargetDy;
    protected final LinearInterpolator mLinearInterpolator;
    private float mMillisPerPixel;
    protected PointF mTargetVector;

    private int clampApplyScroll(int r1, int r2) {
        int r0 = r1 - r2;
        if ((r1 * r0) > 0) goto L6;
        return 0;
    L6:
        return r0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void onStart() {
    }

    public LinearSmoothScroller(Context r2) {
        this.mLinearInterpolator = new LinearInterpolator();
        this.mDecelerateInterpolator = new DecelerateInterpolator();
        this.mHasCalculatedMillisPerPixel = false;
        this.mInterimTargetDx = 0;
        this.mInterimTargetDy = 0;
        this.mDisplayMetrics = r2.getResources().getDisplayMetrics();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void onTargetFound(View r3, RecyclerView.State r4, RecyclerView.SmoothScroller.Action r5) {
        int r6 = calculateDxToMakeVisible(r3, getHorizontalSnapPreference());
        int r7 = calculateDyToMakeVisible(r3, getVerticalSnapPreference());
        int r0 = calculateTimeForDeceleration((int) Math.sqrt((r6 * r6) + (r7 * r7)));
        if (r0 <= 0) goto L6;
        r5.update(-r6, -r7, r0, this.mDecelerateInterpolator);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void onSeekTargetStep(int r1, int r2, RecyclerView.State r3, RecyclerView.SmoothScroller.Action r4) {
        if (getChildCount() != 0) goto L6;
        stop();
        return;
    L6:
        this.mInterimTargetDx = clampApplyScroll(this.mInterimTargetDx, r1);
        int r5 = clampApplyScroll(this.mInterimTargetDy, r2);
        this.mInterimTargetDy = r5;
        if (this.mInterimTargetDx != 0) goto L11;
        if (r5 != 0) goto L12;
        updateActionForInterimTarget(r4);
        return;
    L12:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void onStop() {
        this.mInterimTargetDy = 0;
        this.mInterimTargetDx = 0;
        this.mTargetVector = null;
    }

    protected float calculateSpeedPerPixel(DisplayMetrics r1) {
        return MILLISECONDS_PER_INCH / r1.densityDpi;
    }

    private float getSpeedPerPixel() {
        if (this.mHasCalculatedMillisPerPixel == true) goto L6;
        this.mMillisPerPixel = calculateSpeedPerPixel(this.mDisplayMetrics);
        this.mHasCalculatedMillisPerPixel = true;
    L6:
        return this.mMillisPerPixel;
    }

    protected int calculateTimeForDeceleration(int r3) {
        return (int) Math.ceil(((double) calculateTimeForScrolling(r3)) / 0.3356d);
    }

    protected int calculateTimeForScrolling(int r1) {
        return (int) Math.ceil(Math.abs(r1) * getSpeedPerPixel());
    }

    protected int getHorizontalSnapPreference() {
        PointF r0 = this.mTargetVector;
        if (r0 != null) goto L5;
    L11:
        return 0;
    L5:
        if (r0.x == 0.0f) goto L11;
        if (this.mTargetVector.x <= 0.0f) goto L10;
        return 1;
    L10:
        return -1;
    }

    protected int getVerticalSnapPreference() {
        PointF r0 = this.mTargetVector;
        if (r0 != null) goto L5;
    L11:
        return 0;
    L5:
        if (r0.y == 0.0f) goto L11;
        if (this.mTargetVector.y <= 0.0f) goto L10;
        return 1;
    L10:
        return -1;
    }

    protected void updateActionForInterimTarget(RecyclerView.SmoothScroller.Action r5) {
        PointF r0 = computeScrollVectorForPosition(getTargetPosition());
        if (r0 != null) goto L5;
    L11:
        r5.jumpTo(getTargetPosition());
        stop();
        return;
    L5:
        if (r0.x == 0.0f) goto L7;
    L9:
        normalize(r0);
        this.mTargetVector = r0;
        this.mInterimTargetDx = (int) (r0.x * 10000.0f);
        this.mInterimTargetDy = (int) (r0.y * 10000.0f);
        r5.update((int) (this.mInterimTargetDx * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (this.mInterimTargetDy * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (calculateTimeForScrolling(10000) * TARGET_SEEK_EXTRA_SCROLL_RATIO), this.mLinearInterpolator);
        return;
    L7:
        if (r0.y != 0.0f) goto L9;
        goto L9
    }

    public int calculateDtToFit(int r1, int r2, int r3, int r4, int r5) {
        if (r5 == (-1)) goto L20;
        if (r5 != 0) goto L6;
        int r6 = r3 - r1;
        if (r6 <= 0) goto L14;
        return r6;
    L14:
        int r7 = r4 - r2;
        if (r7 >= 0) goto L17;
        return r7;
    L17:
        return 0;
    L6:
        if (r5 != 1) goto L10;
        return r4 - r2;
    L10:
        throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
    L20:
        return r3 - r1;
    }

    public int calculateDyToMakeVisible(View r11, int r12) {
        RecyclerView.LayoutManager r0 = getLayoutManager();
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.canScrollVertically() == false) goto L11;
        RecyclerView.LayoutParams r1 = (RecyclerView.LayoutParams) r11.getLayoutParams();
        return calculateDtToFit(r0.getDecoratedTop(r11) - r1.topMargin, r0.getDecoratedBottom(r11) + r1.bottomMargin, r0.getPaddingTop(), r0.getHeight() - r0.getPaddingBottom(), r12);
    L11:
        return 0;
    }

    public int calculateDxToMakeVisible(View r11, int r12) {
        RecyclerView.LayoutManager r0 = getLayoutManager();
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.canScrollHorizontally() == false) goto L11;
        RecyclerView.LayoutParams r1 = (RecyclerView.LayoutParams) r11.getLayoutParams();
        return calculateDtToFit(r0.getDecoratedLeft(r11) - r1.leftMargin, r0.getDecoratedRight(r11) + r1.rightMargin, r0.getPaddingLeft(), r0.getWidth() - r0.getPaddingRight(), r12);
    L11:
        return 0;
    }
}
