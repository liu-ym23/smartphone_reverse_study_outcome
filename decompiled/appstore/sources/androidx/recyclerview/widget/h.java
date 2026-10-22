package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class h extends RecyclerView.SmoothScroller {
    private static final boolean DEBUG = false;
    private static final float MILLISECONDS_PER_INCH = 50.0f;
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;
    private static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2f;
    private static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
    protected final androidx.recyclerview.base.e mDecelerateInterpolator;
    private final DisplayMetrics mDisplayMetrics;
    private boolean mHasCalculatedMillisPerPixel;
    protected int mInterimTargetDx;
    protected int mInterimTargetDy;
    protected final LinearInterpolator mLinearInterpolator;
    private float mMillisPerPixel;

    @SuppressLint({"UnknownNullness"})
    protected PointF mTargetVector;

    public h(Context r10) {
        this.mLinearInterpolator = new LinearInterpolator();
        this.mDecelerateInterpolator = new androidx.recyclerview.base.e();
        this.mHasCalculatedMillisPerPixel = false;
        this.mInterimTargetDx = 0;
        this.mInterimTargetDy = 0;
        this.mDisplayMetrics = r10.getResources().getDisplayMetrics();
    }

    public final int a(int r10, int r11) {
        int r12 = r10 - r11;
        if ((r10 * r12) > 0) goto L6;
        return 0;
    L6:
        return r12;
    }

    public final float b() {
        if (this.mHasCalculatedMillisPerPixel == true) goto L6;
        this.mMillisPerPixel = calculateSpeedPerPixel(this.mDisplayMetrics);
        this.mHasCalculatedMillisPerPixel = true;
    L6:
        return this.mMillisPerPixel;
    }

    public int calculateDtToFit(int r10, int r11, int r12, int r13, int r14) {
        if (r14 == (-1)) goto L20;
        if (r14 != 0) goto L6;
        int r15 = r12 - r10;
        if (r15 <= 0) goto L14;
        return r15;
    L14:
        int r16 = r13 - r11;
        if (r16 >= 0) goto L17;
        return r16;
    L17:
        return 0;
    L6:
        if (r14 != 1) goto L10;
        return r13 - r11;
    L10:
        throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
    L20:
        return r12 - r10;
    }

    @SuppressLint({"UnknownNullness"})
    public int calculateDxToMakeVisible(View r11, int r12) {
        RecyclerView.LayoutManager r10 = getLayoutManager();
        if (r10 != null) goto L5;
        return 0;
    L5:
        if (r10.canScrollHorizontally() == false) goto L11;
        RecyclerView.LayoutParams r13 = (RecyclerView.LayoutParams) r11.getLayoutParams();
        return calculateDtToFit(r10.getDecoratedLeft(r11) - ((ViewGroup.MarginLayoutParams) r13).leftMargin, r10.getDecoratedRight(r11) + ((ViewGroup.MarginLayoutParams) r13).rightMargin, r10.getPaddingLeft(), r10.getWidth() - r10.getPaddingRight(), r12);
    L11:
        return 0;
    }

    @SuppressLint({"UnknownNullness"})
    public int calculateDyToMakeVisible(View r11, int r12) {
        RecyclerView.LayoutManager r10 = getLayoutManager();
        if (r10 != null) goto L5;
        return 0;
    L5:
        if (r10.canScrollVertically() == false) goto L11;
        RecyclerView.LayoutParams r13 = (RecyclerView.LayoutParams) r11.getLayoutParams();
        return calculateDtToFit(r10.getDecoratedTop(r11) - ((ViewGroup.MarginLayoutParams) r13).topMargin, r10.getDecoratedBottom(r11) + ((ViewGroup.MarginLayoutParams) r13).bottomMargin, r10.getPaddingTop(), r10.getHeight() - r10.getPaddingBottom(), r12);
    L11:
        return 0;
    }

    public float calculateSpeedPerPixel(DisplayMetrics r10) {
        return MILLISECONDS_PER_INCH / r10.densityDpi;
    }

    public int calculateTimeForDeceleration(int r10) {
        return (int) Math.ceil(((double) calculateTimeForScrolling(r10)) / 0.2d);
    }

    public int calculateTimeForScrolling(int r10) {
        return (int) Math.ceil(Math.abs(r10) * b());
    }

    public int getHorizontalSnapPreference() {
        PointF r10 = this.mTargetVector;
        if (r10 == null) goto L11;
        float r11 = r10.x;
        if (r11 == 0.0f) goto L11;
        if (r11 <= 0.0f) goto L10;
        return 1;
    L10:
        return -1;
    L11:
        return 0;
    }

    public int getVerticalSnapPreference() {
        PointF r10 = this.mTargetVector;
        if (r10 == null) goto L11;
        float r11 = r10.y;
        if (r11 == 0.0f) goto L11;
        if (r11 <= 0.0f) goto L10;
        return 1;
    L10:
        return -1;
    L11:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    @SuppressLint({"UnknownNullness"})
    public void onSeekTargetStep(int r10, int r11, RecyclerView.State r12, RecyclerView.SmoothScroller.a r13) {
        if (getChildCount() != 0) goto L6;
        stop();
        return;
    L6:
        this.mInterimTargetDx = a(this.mInterimTargetDx, r10);
        int r14 = a(this.mInterimTargetDy, r11);
        this.mInterimTargetDy = r14;
        if (this.mInterimTargetDx != 0) goto L11;
        if (r14 != 0) goto L12;
        updateActionForInterimTarget(r13);
        return;
    L12:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onStart() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onStop() {
        this.mInterimTargetDy = 0;
        this.mInterimTargetDx = 0;
        this.mTargetVector = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    @SuppressLint({"UnknownNullness"})
    public void onTargetFound(View r10, RecyclerView.State r11, RecyclerView.SmoothScroller.a r12) {
        int r13 = calculateDxToMakeVisible(r10, getHorizontalSnapPreference());
        int r14 = calculateDyToMakeVisible(r10, getVerticalSnapPreference());
        int r15 = calculateTimeForDeceleration((int) Math.sqrt((r13 * r13) + (r14 * r14)));
        if (r15 <= 0) goto L6;
        r12.d(-r13, -r14, r15, this.mDecelerateInterpolator);
        return;
    }

    @SuppressLint({"UnknownNullness"})
    public void updateActionForInterimTarget(RecyclerView.SmoothScroller.a r10) {
        PointF r11 = computeScrollVectorForPosition(getTargetPosition());
        if (r11 != null) goto L5;
    L11:
        r10.b(getTargetPosition());
        stop();
        return;
    L5:
        if (r11.x == 0.0f) goto L7;
    L9:
        normalize(r11);
        this.mTargetVector = r11;
        this.mInterimTargetDx = (int) (r11.x * 10000.0f);
        this.mInterimTargetDy = (int) (r11.y * 10000.0f);
        r10.d((int) (this.mInterimTargetDx * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (this.mInterimTargetDy * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (calculateTimeForScrolling(10000) * TARGET_SEEK_EXTRA_SCROLL_RATIO), this.mLinearInterpolator);
        return;
    L7:
        if (r11.y != 0.0f) goto L9;
        goto L9
    }
}
