package com.bytedanceos.appstore.buss.widget.recyclerview;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.core.text.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.i;
import java.util.Locale;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes2.dex */
public class GravitySnapHelper extends i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9330g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9331h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9332i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9333j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f9334k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f9335l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9336m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f9337n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f9338o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f9339p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public OrientationHelper f9340q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OrientationHelper f9341r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SnapListener f9342s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public RecyclerView f9343t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RecyclerView.OnScrollListener f9344u;

    public interface SnapListener {
        void onSnap(int r10);
    }

    public class a extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GravitySnapHelper f9345a;

        public a(GravitySnapHelper r10) {
            this.f9345a = r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView r10, int r11) {
            super.onScrollStateChanged(r10, r11);
            if (r11 == 0) goto L5;
        L11:
            GravitySnapHelper r12 = this.f9345a;
            if (r11 == 0) goto L14;
            boolean r13 = true;
        L15:
            GravitySnapHelper.t(r12, r13);
            return;
        L14:
            r13 = false;
            goto L15
        L5:
            if (GravitySnapHelper.q(this.f9345a) == null) goto L11;
            if (GravitySnapHelper.r(this.f9345a) == (-1)) goto L11;
            if (GravitySnapHelper.s(this.f9345a) == false) goto L11;
            GravitySnapHelper.q(this.f9345a).onSnap(GravitySnapHelper.r(this.f9345a));
            goto L11
        }
    }

    public class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f9346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GravitySnapHelper f9348c;

        public b(GravitySnapHelper r10, Context r11, float r12, int r13) {
            this.f9348c = r10;
            super(r11);
            this.f9346a = r12;
            this.f9347b = r13;
        }

        @Override // androidx.recyclerview.widget.h
        public float calculateSpeedPerPixel(DisplayMetrics r10) {
            return this.f9346a / r10.densityDpi;
        }

        @Override // androidx.recyclerview.widget.h
        public int calculateTimeForScrolling(int r10) {
            return Math.min(this.f9347b, super.calculateTimeForScrolling(r10));
        }

        @Override // androidx.recyclerview.widget.h, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(View r10, RecyclerView.State r11, RecyclerView.SmoothScroller.a r12) {
            if (GravitySnapHelper.u(this.f9348c) != null) goto L5;
            return;
        L5:
            if (GravitySnapHelper.u(this.f9348c).getLayoutManager() == null) goto L13;
            GravitySnapHelper r13 = this.f9348c;
            int[] r14 = r13.c(GravitySnapHelper.u(r13).getLayoutManager(), r10);
            int r15 = r14[0];
            int r16 = r14[1];
            int r17 = calculateTimeForDeceleration(Math.max(Math.abs(r15), Math.abs(r16)));
            if (r17 <= 0) goto L12;
            r12.d(r15, r16, r17, this.mDecelerateInterpolator);
            return;
        L12:
            return;
        }
    }

    public GravitySnapHelper(int r10) {
        this(r10, false, null);
    }

    public static /* synthetic */ SnapListener q(GravitySnapHelper r10) {
        return r10.f9342s;
    }

    public static /* synthetic */ int r(GravitySnapHelper r10) {
        return r10.f9332i;
    }

    public static /* synthetic */ boolean s(GravitySnapHelper r10) {
        return r10.f9333j;
    }

    public static /* synthetic */ boolean t(GravitySnapHelper r10, boolean r11) {
        r10.f9333j = r11;
        return r11;
    }

    public static /* synthetic */ RecyclerView u(GravitySnapHelper r10) {
        return r10.f9343t;
    }

    public final int A(View r10, OrientationHelper r11) {
        if (this.f9334k == true) goto L7;
        int r12 = r11.g(r10);
        if (r12 < (r11.n() / 2)) goto L10;
        int r13 = r11.n();
    L9:
        return r12 - r13;
    L10:
        return r12;
    L7:
        r12 = r11.g(r10);
        r13 = r11.n();
        goto L9
    }

    public final int B() {
        if (this.f9337n != (-1.0f)) goto L5;
        int r10 = this.f9336m;
        if (r10 == (-1)) goto L16;
        return r10;
    L16:
        return Channel.UNLIMITED;
    L5:
        if (this.f9340q == null) goto L10;
        float r11 = this.f9343t.getHeight();
        float r12 = this.f9337n;
    L8:
        return (int) (r11 * r12);
    L10:
        if (this.f9341r == null) goto L12;
        r11 = this.f9343t.getWidth();
        r12 = this.f9337n;
        goto L8
    L12:
        return Channel.UNLIMITED;
    }

    public final boolean C(LinearLayoutManager r10) {
        if (r10.getReverseLayout() == true) goto L7;
        if (this.f9329f != 8388611) goto L7;
    L19:
        if (r10.findLastCompletelyVisibleItemPosition() == (r10.getItemCount() - 1)) goto L21;
        return false;
    L21:
        return true;
    L7:
        if (r10.getReverseLayout() == false) goto L11;
        if (this.f9329f == 8388613) goto L19;
    L11:
        if (r10.getReverseLayout() == true) goto L15;
        if (this.f9329f == 48) goto L19;
    L15:
        if (r10.getReverseLayout() == false) goto L23;
        if (this.f9329f == 80) goto L19;
    L23:
        if (this.f9329f != 17) goto L31;
        if (r10.findFirstCompletelyVisibleItemPosition() == 0) goto L29;
        if (r10.findLastCompletelyVisibleItemPosition() == (r10.getItemCount() - 1)) goto L29;
        return false;
    L29:
        return true;
    L31:
        if (r10.findFirstCompletelyVisibleItemPosition() == 0) goto L33;
        return false;
    L33:
        return true;
    }

    public final boolean D(int r10, boolean r11) {
        if (this.f9343t.getLayoutManager() != null) goto L5;
    L14:
        return false;
    L5:
        if (r11 == false) goto L10;
        RecyclerView.SmoothScroller r12 = v(this.f9343t.getLayoutManager());
        if (r12 == null) goto L14;
        r12.setTargetPosition(r10);
        this.f9343t.getLayoutManager().startSmoothScroll(r12);
        return true;
    L10:
        RecyclerView.ViewHolder r13 = this.f9343t.findViewHolderForAdapterPosition(r10);
        if (r13 == null) goto L14;
        int[] r14 = c(this.f9343t.getLayoutManager(), r13.itemView);
        this.f9343t.scrollBy(r14[0], r14[1]);
        return true;
    }

    public boolean E(int r10) {
        if (r10 != (-1)) goto L6;
        return false;
    L6:
        return D(r10, false);
    }

    public void F(int r10) {
        this.f9339p = r10;
    }

    public void G(float r10) {
        this.f9336m = -1;
        this.f9337n = r10;
    }

    public void H(int r10) {
        this.f9338o = r10;
    }

    public void I(float r10) {
        this.f9335l = r10;
    }

    public void J(boolean r10) {
        this.f9331h = r10;
    }

    public void K(SnapListener r10) {
        this.f9342s = r10;
    }

    public void L(boolean r10) {
        this.f9334k = r10;
    }

    public boolean M(int r10) {
        if (r10 != (-1)) goto L7;
        return false;
    L7:
        return D(r10, true);
    }

    @Override // androidx.recyclerview.widget.n
    public void b(RecyclerView r10) {
        RecyclerView r11 = this.f9343t;
        if (r11 == null) goto L6;
        r11.removeOnScrollListener(this.f9344u);
    L6:
        if (r10 == null) goto L17;
        r10.setOnFlingListener(null);
        int r12 = this.f9329f;
        if (r12 != 8388611) goto L10;
    L11:
        boolean r13 = true;
        if (d.a(Locale.getDefault()) == 1) goto L15;
        r13 = false;
    L15:
        this.f9330g = r13;
    L16:
        r10.addOnScrollListener(this.f9344u);
        this.f9343t = r10;
    L18:
        super.b(r10);
        return;
    L10:
        if (r12 != 8388613) goto L16;
    L17:
        this.f9343t = null;
        goto L18
    }

    @Override // androidx.recyclerview.widget.i, androidx.recyclerview.widget.n
    public int[] c(RecyclerView.LayoutManager r10, View r11) {
        if (this.f9329f == 17) goto L5;
        int[] r12 = new int[2];
        if ((r10 instanceof LinearLayoutManager) == true) goto L9;
        return r12;
    L9:
        LinearLayoutManager r13 = (LinearLayoutManager) r10;
        if (r13.canScrollHorizontally() == false) goto L21;
        boolean r14 = this.f9330g;
        if (r14 == true) goto L14;
    L15:
        if (r14 == false) goto L17;
    L19:
        r12[0] = z(r11, o(r13));
    L26:
        return r12;
    L17:
        if (this.f9329f != 8388611) goto L19;
    L18:
        r12[0] = A(r11, o(r13));
        goto L26
    L14:
        if (this.f9329f == 8388613) goto L18;
    L21:
        if (r13.canScrollVertically() == false) goto L26;
        if (this.f9329f != 48) goto L25;
        r12[1] = A(r11, p(r13));
        goto L26
    L25:
        r12[1] = z(r11, p(r13));
        goto L26
    L5:
        return super.c(r10, r11);
    }

    @Override // androidx.recyclerview.widget.n
    public int[] d(int r11, int r12) {
        if (this.f9343t == null) goto L16;
        if (this.f9340q != null) goto L9;
        if (this.f9341r == null) goto L16;
    L9:
        if (this.f9336m == (-1)) goto L11;
    L13:
        Scroller r10 = new Scroller(this.f9343t.getContext(), new DecelerateInterpolator());
        int r13 = B();
        int r14 = -r13;
        r10.fling(0, 0, r11, r12, r14, r13, r14, r13);
        return new int[]{r10.getFinalX(), r10.getFinalY()};
    L11:
        if (this.f9337n != (-1.0f)) goto L13;
    L16:
        return super.d(r11, r12);
    }

    @Override // androidx.recyclerview.widget.n
    public RecyclerView.SmoothScroller e(RecyclerView.LayoutManager r10) {
        if ((r10 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == false) goto L9;
        RecyclerView r11 = this.f9343t;
        if (r11 != null) goto L8;
        return null;
    L8:
        return new b(this, r11.getContext(), this.f9335l, this.f9338o);
    L9:
        return null;
    }

    @Override // androidx.recyclerview.widget.i, androidx.recyclerview.widget.n
    public View g(RecyclerView.LayoutManager r10) {
        return w(r10, true);
    }

    public final OrientationHelper o(RecyclerView.LayoutManager r10) {
        OrientationHelper r11 = this.f9341r;
        if (r11 != null) goto L5;
    L6:
        this.f9341r = OrientationHelper.a(r10);
    L8:
        return this.f9341r;
    L5:
        if (r11.k() == r10) goto L8;
        goto L6
    }

    public final OrientationHelper p(RecyclerView.LayoutManager r10) {
        OrientationHelper r11 = this.f9340q;
        if (r11 != null) goto L5;
    L6:
        this.f9340q = OrientationHelper.c(r10);
    L8:
        return this.f9340q;
    L5:
        if (r11.k() == r10) goto L8;
        goto L6
    }

    public RecyclerView.SmoothScroller v(RecyclerView.LayoutManager r10) {
        if ((r10 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == false) goto L9;
        RecyclerView r11 = this.f9343t;
        if (r11 != null) goto L8;
        return null;
    L8:
        return new b(this, r11.getContext(), this.f9335l, this.f9339p);
    L9:
        return null;
    }

    public View w(RecyclerView.LayoutManager r10, boolean r11) {
        int r12 = this.f9329f;
        if (r12 == 17) goto L16;
        if (r12 != 48) goto L7;
        View r13 = x(r10, p(r10), 8388611, r11);
    L19:
        if (r13 == null) goto L21;
        this.f9332i = this.f9343t.getChildAdapterPosition(r13);
    L22:
        return r13;
    L21:
        this.f9332i = -1;
        goto L22
    L7:
        if (r12 == 80) goto L13;
        if (r12 == 8388611) goto L12;
        if (r12 == 8388613) goto L11;
        r13 = null;
        goto L19
    L11:
        r13 = x(r10, o(r10), 8388613, r11);
        goto L19
    L12:
        r13 = x(r10, o(r10), 8388611, r11);
        goto L19
    L13:
        r13 = x(r10, p(r10), 8388613, r11);
        goto L19
    L16:
        if (r10.canScrollHorizontally() == false) goto L18;
        r13 = x(r10, o(r10), 17, r11);
        goto L19
    L18:
        r13 = x(r10, p(r10), 17, r11);
        goto L19
    }

    public final View x(RecyclerView.LayoutManager r10, OrientationHelper r11, int r12, boolean r13) {
        View r14 = null;
        if (r10.getChildCount() != 0) goto L5;
    L53:
        return r14;
    L5:
        if ((r10 instanceof LinearLayoutManager) == false) goto L53;
        LinearLayoutManager r15 = (LinearLayoutManager) r10;
        if (r13 == false) goto L15;
        if (C(r15) == false) goto L15;
        if (this.f9331h == true) goto L15;
        return null;
    L15:
        if (r10.getClipToPadding() == false) goto L17;
        int r16 = r11.n() + (r11.o() / 2);
    L18:
        int r17 = 0;
        boolean r18 = true;
        if (r12 == 8388611) goto L21;
    L22:
        if (r12 == 8388613) goto L24;
    L26:
        boolean r19 = false;
    L27:
        if (r12 == 8388611) goto L29;
    L30:
        if (r12 == 8388613) goto L32;
    L34:
        r18 = false;
    L35:
        int r110 = Channel.UNLIMITED;
    L37:
        if (r17 >= r15.getChildCount()) goto L53;
        View r111 = r15.getChildAt(r17);
        if (r19 == true) goto L41;
        if (r18 == true) goto L46;
        int r20 = Math.abs((r11.g(r111) + (r11.e(r111) / 2)) - r16);
    L50:
        if (r20 >= r110) goto L52;
        r14 = r111;
        r110 = r20;
    L52:
        r17 = r17 + 1;
        goto L37
    L46:
        if (this.f9334k == true) goto L48;
        r20 = Math.abs(r11.d(r111) - r11.h());
        goto L50
    L48:
        r20 = Math.abs(r11.i() - r11.d(r111));
        goto L50
    L41:
        if (this.f9334k == true) goto L43;
        r20 = Math.abs(r11.g(r111));
        goto L50
    L43:
        r20 = Math.abs(r11.n() - r11.g(r111));
        goto L50
    L32:
        if (this.f9330g == true) goto L34;
    L29:
        if (this.f9330g == true) goto L35;
    L24:
        if (this.f9330g == false) goto L26;
    L25:
        r19 = true;
        goto L27
    L21:
        if (this.f9330g == false) goto L25;
    L17:
        r16 = r11.h() / 2;
        goto L18
    }

    public int y() {
        RecyclerView r10 = this.f9343t;
        if (r10 != null) goto L5;
        return -1;
    L5:
        if (r10.getLayoutManager() == null) goto L12;
        View r11 = g(this.f9343t.getLayoutManager());
        if (r11 != null) goto L9;
        return -1;
    L9:
        return this.f9343t.getChildAdapterPosition(r11);
    L12:
        return -1;
    }

    public final int z(View r10, OrientationHelper r11) {
        if (this.f9334k == true) goto L8;
        int r12 = r11.d(r10);
        if (r12 < (r11.h() - ((r11.h() - r11.i()) / 2))) goto L7;
        r12 = r11.d(r10);
        int r13 = r11.h();
    L10:
        return r12 - r13;
    L7:
        r13 = r11.i();
        goto L10
    L8:
        r12 = r11.d(r10);
        r13 = r11.i();
        goto L10
    }

    public GravitySnapHelper(int r10, boolean r11, SnapListener r12) {
        this.f9333j = false;
        this.f9334k = false;
        this.f9335l = 100.0f;
        this.f9336m = -1;
        this.f9337n = -1.0f;
        this.f9338o = 100;
        this.f9339p = 100;
        this.f9344u = new a(this);
        if (r10 != 8388611) goto L5;
    L15:
        this.f9331h = r11;
        this.f9329f = r10;
        this.f9342s = r12;
        return;
    L5:
        if (r10 == 8388613) goto L15;
        if (r10 == 80) goto L15;
        if (r10 == 48) goto L15;
        if (r10 == 17) goto L15;
        throw new IllegalArgumentException("Invalid mGravity value. Use START | END | BOTTOM | TOP | CENTER constants");
    }
}
