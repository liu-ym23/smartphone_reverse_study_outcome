package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;

/* JADX INFO: loaded from: classes17.dex */
public class LinearSnapHelper extends SnapHelper {
    private static final float INVALID_DISTANCE = 1.0f;
    private OrientationHelper mHorizontalHelper;
    private OrientationHelper mVerticalHelper;

    public LinearSnapHelper() {
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

    private float computeDistancePerChild(RecyclerView.LayoutManager r110, OrientationHelper r111) {
        int r100 = r110.getChildCount();
        if (r100 != 0) goto L5;
        return 1.0f;
    L5:
        View r101 = null;
        View r102 = null;
        int r103 = Integer.MAX_VALUE;
        int r104 = Integer.MIN_VALUE;
        int r105 = 0;
    L6:
        if (r105 >= r100) goto L15;
        View r106 = r110.getChildAt(r105);
        int r107 = r110.getPosition(r106);
        if (r107 == (-1)) goto L14;
        if (r107 >= r103) goto L12;
        r101 = r106;
        r103 = r107;
    L12:
        if (r107 <= r104) goto L14;
        r102 = r106;
        r104 = r107;
    L14:
        r105 = r105 + 1;
        goto L6
    L15:
        if (r101 == null) goto L23;
        if (r102 == null) goto L23;
        int r112 = Math.max(r111.getDecoratedEnd(r101), r111.getDecoratedEnd(r102)) - Math.min(r111.getDecoratedStart(r101), r111.getDecoratedStart(r102));
        if (r112 != 0) goto L22;
        return 1.0f;
    L22:
        return (r112 * 1.0f) / ((r104 - r103) + 1);
    L23:
        return 1.0f;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager r100, int r110, int r111) {
        if ((r100 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L5;
        return -1;
    L5:
        int r101 = r100.getItemCount();
        if (r101 != 0) goto L8;
        return -1;
    L8:
        View r102 = findSnapView(r100);
        if (r102 != null) goto L11;
        return -1;
    L11:
        int r103 = r100.getPosition(r102);
        if (r103 != (-1)) goto L14;
        return -1;
    L14:
        int r104 = r101 - 1;
        PointF r105 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r100).computeScrollVectorForPosition(r104);
        if (r105 != null) goto L17;
        return -1;
    L17:
        int r106 = 0;
        if (r100.canScrollHorizontally() == false) goto L22;
        int r112 = estimateNextPositionDiffForFling(r100, getHorizontalHelper(r100), r110, 0);
        if (r105.x >= 0.0f) goto L24;
        r112 = -r112;
    L24:
        if (r100.canScrollVertically() == false) goto L28;
        int r113 = estimateNextPositionDiffForFling(r100, getVerticalHelper(r100), 0, r111);
        if (r105.y >= 0.0f) goto L30;
        r113 = -r113;
    L30:
        if (r100.canScrollVertically() == false) goto L32;
        r112 = r113;
    L32:
        if (r112 != 0) goto L34;
        return -1;
    L34:
        int r107 = r103 + r112;
        if (r107 < 0) goto L38;
        r106 = r107;
    L38:
        if (r106 < r101) goto L41;
        return r104;
    L41:
        return r106;
    L28:
        r113 = 0;
        goto L30
    L22:
        r112 = 0;
        goto L24
    }

    private int estimateNextPositionDiffForFling(RecyclerView.LayoutManager r100, OrientationHelper r101, int r102, int r103) {
        int[] r104 = calculateScrollDistance(r102, r103);
        float r105 = computeDistancePerChild(r100, r101);
        if (r105 > 0.0f) goto L6;
        return 0;
    L6:
        if (Math.abs(r104[0]) <= Math.abs(r104[1])) goto L8;
        int r106 = r104[0];
    L10:
        return Math.round(r106 / r105);
    L8:
        r106 = r104[1];
        goto L10
    }
}
