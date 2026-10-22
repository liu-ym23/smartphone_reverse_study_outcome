package com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/container/helper/BaseHeadPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseHeadPagerSnapHelper extends PagerSnapHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OrientationHelper f169167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OrientationHelper f169168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f169169c;

    public static final class a {
    }

    static {
    }

    public final int c() {
        return this.f169169c.W4();
    }

    public final boolean e() {
        if (this.f169169c.n0() == false) goto L5;
    L10:
        return true;
    L5:
        if (this.f169169c.isExpanded() == true) goto L10;
        if (c() <= 0) goto L10;
        return false;
    }

    public BaseHeadPagerSnapHelper(s r100) {
        Intrinsics.checkNotNullParameter(r100, "headAbility");
        this.f169169c = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(RecyclerView.LayoutManager r100) {
        int r101 = r100.getItemCount();
        if ((r100 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == false) goto L12;
        PointF r102 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r100).computeScrollVectorForPosition(r101 - 1);
        if (r102 == null) goto L13;
        float r103 = 0;
        if (r102.x >= r103) goto L9;
    L10:
        return true;
    L9:
        if (r102.y < r103) goto L10;
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    public final View a(RecyclerView.LayoutManager r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        return super.findSnapView(r100);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final void attachToRecyclerView(RecyclerView r100) {
        super.attachToRecyclerView(r100);
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        if (e() == false) goto L7;
        return super.findSnapView(r100);
    L7:
        if (r100.canScrollVertically() == false) goto L11;
        return b(r100, getVerticalHelper(r100));
    L11:
        if (r100.canScrollHorizontally() == true) goto L13;
        return null;
    L13:
        return b(r100, getHorizontalHelper(r100));
    }

    public final OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager r100) {
        if (this.f169168b != null) goto L5;
        this.f169168b = OrientationHelper.createHorizontalHelper(r100);
    L5:
        OrientationHelper r101 = this.f169168b;
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    public final OrientationHelper getOrientationHelper(RecyclerView.LayoutManager r100) {
        if (r100.canScrollVertically() == false) goto L6;
        return getVerticalHelper(r100);
    L6:
        if (r100.canScrollHorizontally() == true) goto L11;
        return null;
    L11:
        return getHorizontalHelper(r100);
    }

    public final OrientationHelper getVerticalHelper(RecyclerView.LayoutManager r100) {
        if (this.f169167a != null) goto L5;
        this.f169167a = OrientationHelper.createVerticalHelper(r100);
    L5:
        OrientationHelper r101 = this.f169167a;
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    public static View b(RecyclerView.LayoutManager r100, OrientationHelper r101) {
        int r102 = r100.getChildCount();
        View r103 = null;
        if (r102 != 0) goto L5;
        return null;
    L5:
        int r104 = r101.getStartAfterPadding() + (r101.getTotalSpace() / 2);
        int r105 = Integer.MAX_VALUE;
        int r106 = 0;
    L6:
        if (r106 >= r102) goto L11;
        View r107 = r100.getChildAt(r106);
        int r108 = (int) Math.abs((r101.getDecoratedStart(r107) + (r101.getDecoratedMeasurement(r107) / 2)) - r104);
        if (r108 >= r105) goto L10;
        r103 = r107;
        r105 = r108;
    L10:
        r106 = r106 + 1;
        goto L6
    L11:
        return r103;
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        if (e() == false) goto L7;
        return super.calculateDistanceToFinalSnap(r100, r101);
    L7:
        if (r100.getPosition(r101) < (c() - 1)) goto L15;
        int[] r102 = new int[2];
        if (r100.canScrollHorizontally() == false) goto L11;
        OrientationHelper r103 = getHorizontalHelper(r100);
        r102[0] = (r103.getDecoratedStart(r101) + r103.getDecoratedMeasurement(r101)) - (r103.getStartAfterPadding() + r103.getTotalSpace());
    L12:
        r102[1] = 0;
        return r102;
    L11:
        r102[0] = 0;
        goto L12
    L15:
        return new int[2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final int findTargetSnapPosition(RecyclerView.LayoutManager r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "layoutManager");
        int r100 = 1;
        int r101 = 0;
        if (e() == false) goto L47;
        int r102 = r110.getItemCount();
        if (r102 == 0) goto L115;
        OrientationHelper r103 = getOrientationHelper(r110);
        if (r103 == null) goto L116;
        int r104 = r110.getChildCount();
        View r105 = null;
        View r106 = null;
        int r113 = Integer.MIN_VALUE;
        int r114 = Integer.MAX_VALUE;
    L11:
        if (r101 >= r104) goto L26;
        View r115 = r110.getChildAt(r101);
        if (r115 == null) goto L25;
        if (r115.getWidth() <= 0) goto L25;
        int r116 = (r103.getDecoratedStart(r115) + (r103.getDecoratedMeasurement(r115) / 2)) - (r103.getStartAfterPadding() + (r103.getTotalSpace() / 2));
        if (r116 > 0) goto L22;
        if (r116 <= r113) goto L22;
        r106 = r115;
        r113 = r116;
    L22:
        if (r116 < 0) goto L25;
        if (r116 >= r114) goto L25;
        r105 = r115;
        r114 = r116;
    L25:
        r101 = r101 + 1;
        goto L11
    L26:
        boolean r107 = isForwardFling(r110, r111, r112);
        if (r107 == false) goto L30;
        if (r105 == null) goto L30;
        return r110.getPosition(r105);
    L30:
        if (r107 == true) goto L33;
        if (r106 == null) goto L33;
        return r110.getPosition(r106);
    L33:
        if (r107 == false) goto L35;
        r105 = r106;
    L35:
        if (r105 == null) goto L117;
        int r108 = r110.getPosition(r105);
        if (d(r110) != r107) goto L40;
        r100 = -1;
    L40:
        int r109 = r108 + r100;
        if (r109 < 0) goto L114;
        if (r109 < r102) goto L45;
        return -1;
    L45:
        return r109;
    L114:
        return -1;
    L117:
        return -1;
    L116:
        return -1;
    L115:
        return -1;
    L47:
        if ((r110 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L49;
        return -1;
    L49:
        int r117 = r110.getItemCount();
        if (r117 != 0) goto L52;
        return -1;
    L52:
        View r118 = findSnapView(r110);
        if (r118 != null) goto L55;
        return -1;
    L55:
        int r119 = r110.getPosition(r118);
        if (r119 < c()) goto L60;
        return super.findTargetSnapPosition(r110, r111, r112);
    L60:
        if (r119 == (c() - 1)) goto L62;
    L65:
        if (r119 != (-1)) goto L67;
        return -1;
    L67:
        int r120 = r117 - 1;
        PointF r121 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r110).computeScrollVectorForPosition(r120);
        if (r121 != null) goto L71;
        return -1;
    L71:
        if (r110.canScrollHorizontally() == false) goto L75;
        int r122 = estimateNextPositionDiffForFling(r110, getHorizontalHelper(r110), r111, 0);
        if (r121.x >= 0) goto L77;
        r122 = -r122;
    L77:
        if (r110.canScrollVertically() == false) goto L81;
        int r123 = estimateNextPositionDiffForFling(r110, getVerticalHelper(r110), 0, r112);
        if (r121.y >= 0) goto L83;
        r123 = -r123;
    L83:
        if (r110.canScrollVertically() == false) goto L85;
        r122 = r123;
    L85:
        if (r122 != 0) goto L87;
        return -1;
    L87:
        int r124 = r122 + r119;
        if (r124 < 0) goto L91;
        r101 = r124;
    L91:
        if (r101 >= r117) goto L95;
        r120 = r101;
    L95:
        if (r119 >= c()) goto L100;
        if (r120 >= c()) goto L100;
        return -1;
    L100:
        if (r119 >= c()) goto L105;
        if (r120 < c()) goto L105;
        return (-1) + c();
    L105:
        return super.findTargetSnapPosition(r110, r111, r112);
    L81:
        r123 = 0;
        goto L83
    L75:
        r122 = 0;
        goto L77
    L62:
        if (isForwardFling(r110, r111, r112) == false) goto L65;
        return super.findTargetSnapPosition(r110, r111, r112);
    }

    public final boolean isForwardFling(RecyclerView.LayoutManager r100, int r101, int r102) {
        if (r100.canScrollHorizontally() == false) goto L6;
        if (r101 > 0) goto L10;
    L8:
        return false;
    L10:
        return true;
    L6:
        if (r102 <= 0) goto L8;
        return true;
    }

    public final int estimateNextPositionDiffForFling(RecyclerView.LayoutManager r110, OrientationHelper r111, int r112, int r113) {
        int[] r114 = calculateScrollDistance(r112, r113);
        int r115 = r110.getChildCount();
        float r100 = 1.0f;
        if (r115 == 0) goto L23;
        View r101 = null;
        View r102 = null;
        int r103 = Integer.MAX_VALUE;
        int r104 = Integer.MIN_VALUE;
        int r105 = 0;
    L6:
        if (r105 >= r115) goto L15;
        View r106 = r110.getChildAt(r105);
        Intrinsics.checkNotNull(r106);
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
        int r116 = ((int) Math.max(r111.getDecoratedEnd(r101), r111.getDecoratedEnd(r102))) - ((int) Math.min(r111.getDecoratedStart(r101), r111.getDecoratedStart(r102)));
        if (r116 == 0) goto L23;
        r100 = (r116 * 1.0f) / ((r104 - r103) + 1);
    L23:
        if (r100 > 0) goto L26;
        return 0;
    L26:
        if (Math.abs(r114[0]) <= Math.abs(r114[1])) goto L28;
        int r117 = r114[0];
    L30:
        return Math.round(r117 / r100);
    L28:
        r117 = r114[1];
        goto L30
    }
}
