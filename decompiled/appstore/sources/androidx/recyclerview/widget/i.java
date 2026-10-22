package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OrientationHelper f4422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OrientationHelper f4423e;

    public i() {
    }

    private OrientationHelper o(RecyclerView.LayoutManager r10) {
        OrientationHelper r11 = this.f4423e;
        if (r11 != null) goto L5;
    L6:
        this.f4423e = OrientationHelper.a(r10);
    L8:
        return this.f4423e;
    L5:
        if (r11.f4184a == r10) goto L8;
        goto L6
    }

    private OrientationHelper p(RecyclerView.LayoutManager r10) {
        OrientationHelper r11 = this.f4422d;
        if (r11 != null) goto L5;
    L6:
        this.f4422d = OrientationHelper.c(r10);
    L8:
        return this.f4422d;
    L5:
        if (r11.f4184a == r10) goto L8;
        goto L6
    }

    @Override // androidx.recyclerview.widget.n
    public int[] c(RecyclerView.LayoutManager r10, View r11) {
        int[] r12 = new int[2];
        if (r10.canScrollHorizontally() == false) goto L5;
        r12[0] = m(r11, o(r10));
    L7:
        if (r10.canScrollVertically() == false) goto L9;
        r12[1] = m(r11, p(r10));
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
    public abstract View g(RecyclerView.LayoutManager r10);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.n
    public int h(RecyclerView.LayoutManager r10, int r11, int r12) {
        if ((r10 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L5;
        return -1;
    L5:
        int r13 = r10.getItemCount();
        if (r13 != 0) goto L8;
        return -1;
    L8:
        View r14 = g(r10);
        if (r14 != null) goto L11;
        return -1;
    L11:
        int r15 = r10.getPosition(r14);
        if (r15 != (-1)) goto L14;
        return -1;
    L14:
        int r16 = r13 - 1;
        PointF r17 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r10).computeScrollVectorForPosition(r16);
        if (r17 != null) goto L17;
        return -1;
    L17:
        int r18 = 0;
        if (r10.canScrollHorizontally() == false) goto L22;
        int r19 = n(r10, o(r10), r11, 0);
        if (r17.x >= 0.0f) goto L24;
        r19 = -r19;
    L24:
        if (r10.canScrollVertically() == false) goto L28;
        int r20 = n(r10, p(r10), 0, r12);
        if (r17.y >= 0.0f) goto L30;
        r20 = -r20;
    L30:
        if (r10.canScrollVertically() == false) goto L32;
        r19 = r20;
    L32:
        if (r19 != 0) goto L34;
        return -1;
    L34:
        int r21 = r15 + r19;
        if (r21 < 0) goto L38;
        r18 = r21;
    L38:
        if (r18 < r13) goto L41;
        return r16;
    L41:
        return r18;
    L28:
        r20 = 0;
        goto L30
    L22:
        r19 = 0;
        goto L24
    }

    public final float l(RecyclerView.LayoutManager r10, OrientationHelper r11) {
        int r12 = r10.getChildCount();
        if (r12 != 0) goto L5;
        return 1.0f;
    L5:
        View r13 = null;
        int r14 = 0;
        int r15 = Integer.MIN_VALUE;
        int r16 = Integer.MAX_VALUE;
        View r17 = null;
    L6:
        if (r14 >= r12) goto L15;
        View r18 = r10.getChildAt(r14);
        int r19 = r10.getPosition(r18);
        if (r19 == (-1)) goto L14;
        if (r19 >= r16) goto L12;
        r13 = r18;
        r16 = r19;
    L12:
        if (r19 <= r15) goto L14;
        r17 = r18;
        r15 = r19;
    L14:
        r14 = r14 + 1;
        goto L6
    L15:
        if (r13 == null) goto L23;
        if (r17 == null) goto L23;
        int r110 = Math.max(r11.d(r13), r11.d(r17)) - Math.min(r11.g(r13), r11.g(r17));
        if (r110 != 0) goto L22;
        return 1.0f;
    L22:
        return (r110 * 1.0f) / ((r15 - r16) + 1);
    L23:
        return 1.0f;
    }

    public final int m(View r10, OrientationHelper r11) {
        return (r11.g(r10) + (r11.e(r10) / 2)) - (r11.n() + (r11.o() / 2));
    }

    public final int n(RecyclerView.LayoutManager r10, OrientationHelper r11, int r12, int r13) {
        int[] r14 = d(r12, r13);
        float r15 = l(r10, r11);
        if (r15 > 0.0f) goto L6;
        return 0;
    L6:
        if (Math.abs(r14[0]) <= Math.abs(r14[1])) goto L8;
        int r16 = r14[0];
    L10:
        return Math.round(r16 / r15);
    L8:
        r16 = r14[1];
        goto L10
    }
}
