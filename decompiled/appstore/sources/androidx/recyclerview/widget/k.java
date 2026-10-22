package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class k extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OrientationHelper f4427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OrientationHelper f4428e;

    public class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f4429a;

        public a(k r10, Context r11) {
            this.f4429a = r10;
            super(r11);
        }

        @Override // androidx.recyclerview.widget.h
        public float calculateSpeedPerPixel(DisplayMetrics r10) {
            return 100.0f / r10.densityDpi;
        }

        @Override // androidx.recyclerview.widget.h
        public int calculateTimeForScrolling(int r10) {
            return Math.min(100, super.calculateTimeForScrolling(r10));
        }

        @Override // androidx.recyclerview.widget.h, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(View r10, RecyclerView.State r11, RecyclerView.SmoothScroller.a r12) {
            k r13 = this.f4429a;
            int[] r14 = r13.c(r13.f4431a.getLayoutManager(), r10);
            int r15 = r14[0];
            int r16 = r14[1];
            int r17 = calculateTimeForDeceleration(Math.max(Math.abs(r15), Math.abs(r16)));
            if (r17 <= 0) goto L6;
            r12.d(r15, r16, r17, this.mDecelerateInterpolator);
            return;
        }
    }

    public k() {
    }

    private int l(View r10, OrientationHelper r11) {
        return (r11.g(r10) + (r11.e(r10) / 2)) - (r11.n() + (r11.o() / 2));
    }

    private OrientationHelper n(RecyclerView.LayoutManager r10) {
        OrientationHelper r11 = this.f4428e;
        if (r11 != null) goto L5;
    L6:
        this.f4428e = OrientationHelper.a(r10);
    L8:
        return this.f4428e;
    L5:
        if (r11.f4184a == r10) goto L8;
        goto L6
    }

    private OrientationHelper o(RecyclerView.LayoutManager r10) {
        if (r10.canScrollVertically() == false) goto L7;
        return p(r10);
    L7:
        if (r10.canScrollHorizontally() == true) goto L9;
        return null;
    L9:
        return n(r10);
    }

    private OrientationHelper p(RecyclerView.LayoutManager r10) {
        OrientationHelper r11 = this.f4427d;
        if (r11 != null) goto L5;
    L6:
        this.f4427d = OrientationHelper.c(r10);
    L8:
        return this.f4427d;
    L5:
        if (r11.f4184a == r10) goto L8;
        goto L6
    }

    private boolean q(RecyclerView.LayoutManager r10, int r11, int r12) {
        if (r10.canScrollHorizontally() == false) goto L7;
        if (r11 > 0) goto L6;
        return false;
    L6:
        return true;
    L7:
        if (r12 > 0) goto L9;
        return false;
    L9:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean r(RecyclerView.LayoutManager r10) {
        int r11 = r10.getItemCount();
        if ((r10 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == false) goto L12;
        PointF r12 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r10).computeScrollVectorForPosition(r11 - 1);
        if (r12 != null) goto L7;
        return false;
    L7:
        if (r12.x < 0.0f) goto L11;
        if (r12.y < 0.0f) goto L11;
        return false;
    L11:
        return true;
    L12:
        return false;
    }

    @Override // androidx.recyclerview.widget.n
    public int[] c(RecyclerView.LayoutManager r10, View r11) {
        int[] r12 = new int[2];
        if (r10.canScrollHorizontally() == false) goto L5;
        r12[0] = l(r11, n(r10));
    L7:
        if (r10.canScrollVertically() == false) goto L9;
        r12[1] = l(r11, p(r10));
    L10:
        return r12;
    L9:
        r12[1] = 0;
        goto L10
    L5:
        r12[0] = 0;
        goto L7
    }

    @Override // androidx.recyclerview.widget.n
    public RecyclerView.SmoothScroller e(RecyclerView.LayoutManager r10) {
        if ((r10 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L7;
        return null;
    L7:
        return new a(this, this.f4431a.getContext());
    }

    @Override // androidx.recyclerview.widget.n
    public View g(RecyclerView.LayoutManager r10) {
        if (r10.canScrollVertically() == false) goto L7;
        return m(r10, p(r10));
    L7:
        if (r10.canScrollHorizontally() == true) goto L9;
        return null;
    L9:
        return m(r10, n(r10));
    }

    @Override // androidx.recyclerview.widget.n
    public int h(RecyclerView.LayoutManager r12, int r13, int r14) {
        int r10 = r12.getItemCount();
        if (r10 != 0) goto L5;
        return -1;
    L5:
        OrientationHelper r11 = o(r12);
        if (r11 != null) goto L8;
        return -1;
    L8:
        int r15 = r12.getChildCount();
        View r16 = null;
        int r17 = 0;
        int r18 = Integer.MAX_VALUE;
        int r19 = Integer.MIN_VALUE;
        View r20 = null;
    L9:
        if (r17 >= r15) goto L21;
        View r21 = r12.getChildAt(r17);
        if (r21 == null) goto L20;
        int r110 = l(r21, r11);
        if (r110 > 0) goto L17;
        if (r110 <= r19) goto L17;
        r20 = r21;
        r19 = r110;
    L17:
        if (r110 < 0) goto L20;
        if (r110 >= r18) goto L20;
        r16 = r21;
        r18 = r110;
    L20:
        r17 = r17 + 1;
        goto L9
    L21:
        boolean r111 = q(r12, r13, r14);
        if (r111 == false) goto L26;
        if (r16 == null) goto L26;
        return r12.getPosition(r16);
    L26:
        if (r111 == true) goto L30;
        if (r20 == null) goto L30;
        return r12.getPosition(r20);
    L30:
        if (r111 == false) goto L32;
        r16 = r20;
    L32:
        if (r16 != null) goto L34;
        return -1;
    L34:
        int r112 = r12.getPosition(r16);
        if (r(r12) != r111) goto L37;
        int r113 = -1;
    L38:
        int r114 = r112 + r113;
        if (r114 < 0) goto L43;
        if (r114 >= r10) goto L43;
        return r114;
    L43:
        return -1;
    L37:
        r113 = 1;
        goto L38
    }

    public final View m(RecyclerView.LayoutManager r10, OrientationHelper r11) {
        int r12 = r10.getChildCount();
        View r13 = null;
        if (r12 != 0) goto L5;
        return null;
    L5:
        int r14 = r11.n() + (r11.o() / 2);
        int r15 = Channel.UNLIMITED;
        int r16 = 0;
    L6:
        if (r16 >= r12) goto L11;
        View r17 = r10.getChildAt(r16);
        int r18 = Math.abs((r11.g(r17) + (r11.e(r17) / 2)) - r14);
        if (r18 >= r15) goto L10;
        r13 = r17;
        r15 = r18;
    L10:
        r16 = r16 + 1;
        goto L6
    L11:
        return r13;
    }
}
