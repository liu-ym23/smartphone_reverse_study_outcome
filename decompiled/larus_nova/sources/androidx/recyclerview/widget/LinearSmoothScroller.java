package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes17.dex */
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

    private int clampApplyScroll(int r100, int r101) {
        int r102 = r100 - r101;
        if ((r100 * r102) > 0) goto L6;
        return 0;
    L6:
        return r102;
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

    private float getSpeedPerPixel() {
        if (this.mHasCalculatedMillisPerPixel == true) goto L6;
        this.mMillisPerPixel = calculateSpeedPerPixel(this.mDisplayMetrics);
        this.mHasCalculatedMillisPerPixel = true;
    L6:
        return this.mMillisPerPixel;
    }

    public int getHorizontalSnapPreference() {
        PointF r100 = this.mTargetVector;
        if (r100 == null) goto L11;
        float r101 = r100.x;
        if (r101 == 0.0f) goto L11;
        if (r101 <= 0.0f) goto L10;
        return 1;
    L10:
        return -1;
    L11:
        return 0;
    }

    public int getVerticalSnapPreference() {
        PointF r100 = this.mTargetVector;
        if (r100 == null) goto L11;
        float r101 = r100.y;
        if (r101 == 0.0f) goto L11;
        if (r101 <= 0.0f) goto L10;
        return 1;
    L10:
        return -1;
    L11:
        return 0;
    }

    public LinearSmoothScroller(Context r100) {
        this.mLinearInterpolator = new LinearInterpolator();
        this.mDecelerateInterpolator = new DecelerateInterpolator();
        this.mHasCalculatedMillisPerPixel = false;
        this.mInterimTargetDx = 0;
        this.mInterimTargetDy = 0;
        this.mDisplayMetrics = INVOKEVIRTUAL_androidx_recyclerview_widget_LinearSmoothScroller_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_recyclerview_widget_LinearSmoothScroller_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public float calculateSpeedPerPixel(DisplayMetrics r100) {
        return 25.0f / r100.densityDpi;
    }

    public int calculateTimeForDeceleration(int r100) {
        return (int) Math.ceil(((double) calculateTimeForScrolling(r100)) / 0.3356d);
    }

    public int calculateTimeForScrolling(int r100) {
        return (int) Math.ceil(Math.abs(r100) * getSpeedPerPixel());
    }

    public void updateActionForInterimTarget(RecyclerView.SmoothScroller.Action r100) {
        PointF r101 = computeScrollVectorForPosition(getTargetPosition());
        if (r101 != null) goto L5;
    L11:
        r100.jumpTo(getTargetPosition());
        stop();
        return;
    L5:
        if (r101.x == 0.0f) goto L7;
    L9:
        normalize(r101);
        this.mTargetVector = r101;
        this.mInterimTargetDx = (int) (r101.x * 10000.0f);
        this.mInterimTargetDy = (int) (r101.y * 10000.0f);
        r100.update((int) (this.mInterimTargetDx * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (this.mInterimTargetDy * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (calculateTimeForScrolling(10000) * TARGET_SEEK_EXTRA_SCROLL_RATIO), this.mLinearInterpolator);
        return;
    L7:
        if (r101.y != 0.0f) goto L9;
        goto L9
    }

    public int calculateDxToMakeVisible(View r110, int r111) {
        RecyclerView.LayoutManager r100 = getLayoutManager();
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (r100.canScrollHorizontally() == false) goto L11;
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r110.getLayoutParams();
        return calculateDtToFit(r100.getDecoratedLeft(r110) - ((ViewGroup.MarginLayoutParams) r101).leftMargin, r100.getDecoratedRight(r110) + ((ViewGroup.MarginLayoutParams) r101).rightMargin, r100.getPaddingLeft(), r100.getWidth() - r100.getPaddingRight(), r111);
    L11:
        return 0;
    }

    public int calculateDyToMakeVisible(View r110, int r111) {
        RecyclerView.LayoutManager r100 = getLayoutManager();
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (r100.canScrollVertically() == false) goto L11;
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r110.getLayoutParams();
        return calculateDtToFit(r100.getDecoratedTop(r110) - ((ViewGroup.MarginLayoutParams) r101).topMargin, r100.getDecoratedBottom(r110) + ((ViewGroup.MarginLayoutParams) r101).bottomMargin, r100.getPaddingTop(), r100.getHeight() - r100.getPaddingBottom(), r111);
    L11:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onTargetFound(View r100, RecyclerView.State r101, RecyclerView.SmoothScroller.Action r102) {
        int r103 = calculateDxToMakeVisible(r100, getHorizontalSnapPreference());
        int r104 = calculateDyToMakeVisible(r100, getVerticalSnapPreference());
        int r105 = calculateTimeForDeceleration((int) Math.sqrt((r103 * r103) + (r104 * r104)));
        if (r105 <= 0) goto L6;
        r102.update(-r103, -r104, r105, this.mDecelerateInterpolator);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onSeekTargetStep(int r100, int r101, RecyclerView.State r102, RecyclerView.SmoothScroller.Action r103) {
        if (getChildCount() != 0) goto L6;
        stop();
        return;
    L6:
        this.mInterimTargetDx = clampApplyScroll(this.mInterimTargetDx, r100);
        int r104 = clampApplyScroll(this.mInterimTargetDy, r101);
        this.mInterimTargetDy = r104;
        if (this.mInterimTargetDx != 0) goto L11;
        if (r104 != 0) goto L12;
        updateActionForInterimTarget(r103);
        return;
    L12:
        return;
    }

    public int calculateDtToFit(int r100, int r101, int r102, int r103, int r104) {
        if (r104 == (-1)) goto L20;
        if (r104 != 0) goto L6;
        int r105 = r102 - r100;
        if (r105 <= 0) goto L14;
        return r105;
    L14:
        int r106 = r103 - r101;
        if (r106 >= 0) goto L17;
        return r106;
    L17:
        return 0;
    L6:
        if (r104 != 1) goto L10;
        return r103 - r101;
    L10:
        throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
    L20:
        return r102 - r100;
    }
}
