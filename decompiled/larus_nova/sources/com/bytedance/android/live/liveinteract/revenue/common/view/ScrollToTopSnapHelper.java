package com.bytedance.android.live.liveinteract.revenue.common.view;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/common/view/ScrollToTopSnapHelper;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ScrollToTopSnapHelper extends LinearSnapHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OrientationHelper f78069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OrientationHelper f78070b;

    public ScrollToTopSnapHelper() {
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final View findSnapView(RecyclerView.LayoutManager r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        if ((r100 instanceof LinearLayoutManager) == false) goto L34;
        if (r100.canScrollVertically() == false) goto L7;
        OrientationHelper r101 = getVerticalHelper(r100);
    L9:
        if ((r100 instanceof LinearLayoutManager) == false) goto L37;
        LinearLayoutManager r102 = (LinearLayoutManager) r100;
        int r103 = 0;
        if (r102.findLastCompletelyVisibleItemPosition() != (r100.getItemCount() - 1)) goto L13;
        boolean r104 = true;
    L14:
        int r105 = r102.findFirstVisibleItemPosition();
        if (r104 == false) goto L17;
    L31:
        return null;
    L17:
        if (r105 == (-1)) goto L31;
        View r106 = r100.findViewByPosition(r105);
        if (r101 == null) goto L22;
        int r107 = r101.getDecoratedEnd(r106);
    L23:
        if (r101 == null) goto L26;
        r103 = r101.getDecoratedMeasurement(r106);
    L26:
        if (r107 < (r103 / 2)) goto L29;
        if (r107 <= 0) goto L29;
        return r106;
    L29:
        if (r104 == true) goto L31;
        return r100.findViewByPosition(r105 + 1);
    L22:
        r107 = 0;
        goto L23
    L13:
        r104 = false;
        goto L14
    L37:
        return super.findSnapView(r100);
    L7:
        r101 = getHorizontalHelper(r100);
        goto L9
    L34:
        return super.findSnapView(r100);
    }

    public final OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager r100) {
        OrientationHelper r101 = this.f78070b;
        if (r101 == null) goto L9;
        if (r101 == null) goto L6;
        RecyclerView.LayoutManager r102 = r101.getLayoutManager();
    L8:
        if ((!Intrinsics.areEqual(r102, r100)) == true) goto L9;
    L11:
        return this.f78070b;
    L6:
        r102 = null;
    L9:
        this.f78070b = OrientationHelper.createHorizontalHelper(r100);
        goto L11
    }

    public final OrientationHelper getVerticalHelper(RecyclerView.LayoutManager r100) {
        OrientationHelper r101 = this.f78069a;
        if (r101 == null) goto L9;
        if (r101 == null) goto L6;
        RecyclerView.LayoutManager r102 = r101.getLayoutManager();
    L8:
        if ((!Intrinsics.areEqual(r102, r100)) == true) goto L9;
    L11:
        return this.f78069a;
    L6:
        r102 = null;
    L9:
        this.f78069a = OrientationHelper.createVerticalHelper(r100);
        goto L11
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        int[] r102 = {0, 0};
        int r103 = 0;
        if (r100.canScrollHorizontally() == false) goto L10;
        OrientationHelper r104 = getHorizontalHelper(r100);
        if (r104 == null) goto L7;
        int r105 = r104.getDecoratedStart(r101) - r104.getStartAfterPadding();
    L8:
        r102[0] = r105;
        goto L10
    L7:
        r105 = 0;
    L10:
        if (r100.canScrollVertically() == false) goto L15;
        OrientationHelper r106 = getVerticalHelper(r100);
        if (r106 == null) goto L14;
        r103 = r106.getDecoratedStart(r101) - r106.getStartAfterPadding();
    L14:
        r102[1] = r103;
    L15:
        return r102;
    }
}
