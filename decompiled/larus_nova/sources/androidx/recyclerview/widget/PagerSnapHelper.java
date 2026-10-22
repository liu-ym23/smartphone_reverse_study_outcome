package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;

/* JADX INFO: loaded from: classes17.dex */
public class PagerSnapHelper extends SnapHelper {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
    private OrientationHelper mHorizontalHelper;
    private OrientationHelper mVerticalHelper;

    public PagerSnapHelper() {
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager r100) {
        OrientationHelper r101 = this.mHorizontalHelper;
        if (r101 != null) goto L5;
    L6:
        this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(r100);
    L8:
        return this.mHorizontalHelper;
    L5:
        if (r101.mLayoutManager == r100) goto L8;
        goto L6
    }

    private OrientationHelper getOrientationHelper(RecyclerView.LayoutManager r100) {
        if (r100.canScrollVertically() == false) goto L7;
        return getVerticalHelper(r100);
    L7:
        if (r100.canScrollHorizontally() == true) goto L9;
        return null;
    L9:
        return getHorizontalHelper(r100);
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager r100) {
        OrientationHelper r101 = this.mVerticalHelper;
        if (r101 != null) goto L5;
    L6:
        this.mVerticalHelper = OrientationHelper.createVerticalHelper(r100);
    L8:
        return this.mVerticalHelper;
    L5:
        if (r101.mLayoutManager == r100) goto L8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isReverseLayout(RecyclerView.LayoutManager r100) {
        int r101 = r100.getItemCount();
        if ((r100 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == false) goto L12;
        PointF r102 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r100).computeScrollVectorForPosition(r101 - 1);
        if (r102 != null) goto L7;
        return false;
    L7:
        if (r102.x >= 0.0f) goto L9;
    L10:
        return true;
    L9:
        if (r102.y < 0.0f) goto L10;
        return false;
    L12:
        return false;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager r100) {
        if ((r100 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L6;
        return null;
    L6:
        final Context r101 = this.mRecyclerView.getContext();
        return new AnonymousClass1(this, r101);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager r100) {
        if (r100.canScrollVertically() == false) goto L7;
        return findCenterView(r100, getVerticalHelper(r100));
    L7:
        if (r100.canScrollHorizontally() == true) goto L9;
        return null;
    L9:
        return findCenterView(r100, getHorizontalHelper(r100));
    }

    private int distanceToCenter(View r100, OrientationHelper r101) {
        return (r101.getDecoratedStart(r100) + (r101.getDecoratedMeasurement(r100) / 2)) - (r101.getStartAfterPadding() + (r101.getTotalSpace() / 2));
    }

    private View findCenterView(RecyclerView.LayoutManager r100, OrientationHelper r110) {
        int r101 = r100.getChildCount();
        View r102 = null;
        if (r101 != 0) goto L5;
        return null;
    L5:
        int r103 = r110.getStartAfterPadding() + (r110.getTotalSpace() / 2);
        int r104 = Integer.MAX_VALUE;
        int r105 = 0;
    L6:
        if (r105 >= r101) goto L11;
        View r106 = r100.getChildAt(r105);
        int r107 = Math.abs((r110.getDecoratedStart(r106) + (r110.getDecoratedMeasurement(r106) / 2)) - r103);
        if (r107 >= r104) goto L10;
        r102 = r106;
        r104 = r107;
    L10:
        r105 = r105 + 1;
        goto L6
    L11:
        return r102;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r100, View r101) {
        int[] r102 = new int[2];
        if (r100.canScrollHorizontally() == false) goto L5;
        r102[0] = distanceToCenter(r101, getHorizontalHelper(r100));
    L7:
        if (r100.canScrollVertically() == false) goto L9;
        r102[1] = distanceToCenter(r101, getVerticalHelper(r100));
    L10:
        return r102;
    L9:
        r102[1] = 0;
        goto L10
    L5:
        r102[0] = 0;
        goto L7
    }

    private boolean isForwardFling(RecyclerView.LayoutManager r100, int r101, int r102) {
        if (r100.canScrollHorizontally() == false) goto L8;
        if (r101 > 0) goto L12;
        return false;
    L12:
        return true;
    L8:
        if (r102 > 0) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager r110, int r111, int r112) {
        int r100 = r110.getItemCount();
        if (r100 != 0) goto L5;
        return -1;
    L5:
        OrientationHelper r101 = getOrientationHelper(r110);
        if (r101 != null) goto L8;
        return -1;
    L8:
        int r102 = r110.getChildCount();
        View r103 = null;
        View r104 = null;
        int r105 = Integer.MIN_VALUE;
        int r106 = Integer.MAX_VALUE;
        int r107 = 0;
    L9:
        if (r107 >= r102) goto L21;
        View r108 = r110.getChildAt(r107);
        if (r108 == null) goto L20;
        int r113 = distanceToCenter(r108, r101);
        if (r113 > 0) goto L17;
        if (r113 <= r105) goto L17;
        r104 = r108;
        r105 = r113;
    L17:
        if (r113 < 0) goto L20;
        if (r113 >= r106) goto L20;
        r103 = r108;
        r106 = r113;
    L20:
        r107 = r107 + 1;
        goto L9
    L21:
        boolean r114 = isForwardFling(r110, r111, r112);
        if (r114 == false) goto L26;
        if (r103 == null) goto L26;
        return r110.getPosition(r103);
    L26:
        if (r114 == true) goto L30;
        if (r104 == null) goto L30;
        return r110.getPosition(r104);
    L30:
        if (r114 == false) goto L32;
        r103 = r104;
    L32:
        if (r103 != null) goto L34;
        return -1;
    L34:
        int r115 = r110.getPosition(r103);
        if (isReverseLayout(r110) != r114) goto L37;
        int r116 = -1;
    L38:
        int r117 = r115 + r116;
        if (r117 < 0) goto L43;
        if (r117 >= r100) goto L43;
        return r117;
    L43:
        return -1;
    L37:
        r116 = 1;
        goto L38
    }
}
