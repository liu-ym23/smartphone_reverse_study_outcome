package com.bytedance.android.livesdk.widget.pager;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.uikit.util.RTLUtil;
import mv2.b;
import mv2.c;

/* JADX INFO: loaded from: classes11.dex */
public class GridPagerSnapHelper extends SnapHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f161923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f161924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f161925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f161926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public mv2.a f161927g;

    public class a extends LinearSmoothScroller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GridPagerSnapHelper f161928a;

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public final PointF computeScrollVectorForPosition(int r100) {
            return null;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final float calculateSpeedPerPixel(DisplayMetrics r100) {
            return 100.0f / r100.densityDpi;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateTimeForScrolling(int r100) {
            return Math.min(100, super.calculateTimeForScrolling(r100));
        }

        public a(GridPagerSnapHelper r100, Context r101) {
            this.f161928a = r100;
            super(r101);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public final void onTargetFound(View r100, RecyclerView.State r101, RecyclerView.SmoothScroller.Action r102) {
            GridPagerSnapHelper r103 = this.f161928a;
            int[] r104 = r103.calculateDistanceToFinalSnap(r103.f161929a.getLayoutManager(), r100);
            int r105 = r104[0];
            int r106 = r104[1];
            int r107 = calculateTimeForDeceleration(Math.max(Math.abs(r105), Math.abs(r106)));
            if (r107 <= 0) goto L6;
            r102.update(r105, r106, r107, this.mDecelerateInterpolator);
            return;
        }
    }

    public final int f() {
        return this.f161923c * this.f161924d;
    }

    public GridPagerSnapHelper() {
        this.f161923c = 1;
        this.f161924d = 1;
        this.f161925e = 5;
    }

    @Override // com.bytedance.android.livesdk.widget.pager.SnapHelper
    public final LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager r100) {
        if ((r100 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L7;
        return null;
    L7:
        return new a(this, this.f161929a.getContext());
    }

    public final c d(RecyclerView.LayoutManager r100) {
        mv2.a r101 = this.f161927g;
        if (r101 != null) goto L5;
    L6:
        this.f161927g = new mv2.a(r100);
    L8:
        return this.f161927g;
    L5:
        if (r101.f515876a == r100) goto L8;
        goto L6
    }

    public final c e(RecyclerView.LayoutManager r100) {
        b r101 = this.f161926f;
        if (r101 != null) goto L5;
    L6:
        this.f161926f = new b(r100);
    L8:
        return this.f161926f;
    L5:
        if (r101.f515876a == r100) goto L8;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.widget.pager.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager r100) {
        if (r100.canScrollVertically() == false) goto L7;
        return b(r100, e(r100));
    L7:
        if (r100.canScrollHorizontally() == true) goto L9;
        return null;
    L9:
        return b(r100, d(r100));
    }

    public final void g(int r100) {
        if (this.f161924d <= 0) goto L7;
        this.f161924d = r100;
        return;
    L7:
        throw new IllegalArgumentException("column must be greater than zero");
    }

    public final void h(int r100) {
        if (this.f161923c <= 0) goto L7;
        this.f161923c = r100;
        return;
    L7:
        throw new IllegalArgumentException("row must be greater than zero");
    }

    public static View b(RecyclerView.LayoutManager r100, c r101) {
        int r102 = r100.getChildCount();
        View r103 = null;
        if (r102 != 0) goto L6;
        return null;
    L6:
        if (r100.getClipToPadding() == false) goto L8;
        int r104 = r101.e() + (r101.f() / 2);
    L9:
        int r105 = Integer.MAX_VALUE;
        int r106 = 0;
    L10:
        if (r106 >= r102) goto L15;
        View r107 = r100.getChildAt(r106);
        int r108 = Math.abs((r101.c(r107) + (r101.b(r107) / 2)) - r104);
        if (r108 >= r105) goto L14;
        r103 = r107;
        r105 = r108;
    L14:
        r106 = r106 + 1;
        goto L10
    L15:
        return r103;
    L8:
        r104 = r101.d() / 2;
        goto L9
    }

    public static View c(RecyclerView.LayoutManager r100, c r101) {
        int r102 = r100.getChildCount();
        View r103 = null;
        if (r102 != 0) goto L5;
        return null;
    L5:
        int r104 = Integer.MAX_VALUE;
        int r105 = 0;
    L6:
        if (r105 >= r102) goto L11;
        View r106 = r100.getChildAt(r105);
        int r107 = r101.c(r106);
        if (r107 >= r104) goto L10;
        r103 = r106;
        r104 = r107;
    L10:
        r105 = r105 + 1;
        goto L6
    L11:
        return r103;
    }

    @Override // com.bytedance.android.livesdk.widget.pager.SnapHelper
    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r100, View r101) {
        int[] r102 = new int[2];
        if (r100.canScrollHorizontally() == false) goto L5;
        r102[0] = a(r100, r101, d(r100));
    L7:
        if (r100.canScrollVertically() == false) goto L9;
        r102[1] = a(r100, r101, e(r100));
    L10:
        return r102;
    L9:
        r102[1] = 0;
        goto L10
    L5:
        r102[0] = 0;
        goto L7
    }

    public final int a(RecyclerView.LayoutManager r100, View r101, c r102) {
        Context r103 = this.f161929a.getContext();
        if (r103 == null) goto L10;
        boolean r104 = true;
        if (r103.getResources().getConfiguration().locale.getLanguage().equals(RTLUtil.ARABIA_LANG) == true) goto L12;
        if (r103.getResources().getConfiguration().getLayoutDirection() != 1) goto L10;
    L12:
        if (r100.canScrollHorizontally() == false) goto L26;
        int r105 = this.f161929a.getWidth() / this.f161924d;
        int r106 = r100.getPosition(r101);
        int r107 = (r106 / f()) * f();
        if (r104 == false) goto L16;
        int r108 = ((f() - (r106 - r107)) / this.f161923c) * r105;
    L17:
        if (r104 == false) goto L19;
        int r109 = r102.a(r101);
    L20:
        int r110 = r109 - r108;
        int r111 = this.f161925e;
        if (r110 > r111) goto L25;
        if (r110 < (-r111)) goto L25;
        return 0;
    L25:
        return r110;
    L19:
        r109 = r102.c(r101);
        goto L20
    L16:
        r108 = ((r106 - r107) / this.f161923c) * r105;
        goto L17
    L26:
        int r112 = this.f161929a.getHeight() / this.f161923c;
        int r113 = r100.getPosition(r101);
        int r114 = (r113 / f()) * f();
        if (r104 == false) goto L29;
        int r115 = ((f() - (r113 - r114)) / this.f161924d) * r112;
    L30:
        if (r104 == false) goto L32;
        int r116 = r102.a(r101);
    L33:
        int r117 = r116 - r115;
        int r118 = this.f161925e;
        if (r117 > r118) goto L38;
        if (r117 < (-r118)) goto L38;
        return 0;
    L38:
        return r117;
    L32:
        r116 = r102.c(r101);
        goto L33
    L29:
        r115 = ((r113 - r114) / this.f161924d) * r112;
    L10:
        r104 = false;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.widget.pager.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager r100, int r101, int r102) {
        int r103 = r100.getItemCount();
        if (r103 != 0) goto L6;
        return -1;
    L6:
        if (r100.canScrollVertically() == false) goto L9;
        View r104 = c(r100, e(r100));
    L12:
        if (r104 != null) goto L14;
        return -1;
    L14:
        int r105 = r100.getPosition(r104);
        if (r105 != (-1)) goto L17;
        return -1;
    L17:
        boolean r106 = false;
        if (r100.canScrollHorizontally() == false) goto L21;
        if (r101 > 0) goto L22;
    L23:
        boolean r107 = false;
    L25:
        if ((r100 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == false) goto L33;
        PointF r108 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r100).computeScrollVectorForPosition(r103 - 1);
        if (r108 == null) goto L33;
        if (r108.x >= 0.0f) goto L31;
    L32:
        r106 = true;
        goto L33
    L31:
        if (r108.y < 0.0f) goto L32;
    L33:
        int r109 = (r105 / f()) * f();
        if (r106 == false) goto L37;
        if (r107 == true) goto L43;
        return r109;
    L43:
        return r109 - f();
    L37:
        int r110 = r109 + f();
        if (r107 == false) goto L41;
        return r110;
    L41:
        return r110 - 1;
    L22:
        r107 = true;
        goto L25
    L21:
        if (r102 <= 0) goto L23;
    L9:
        if (r100.canScrollHorizontally() == false) goto L11;
        r104 = c(r100, d(r100));
        goto L12
    L11:
        r104 = null;
        goto L12
    }
}
