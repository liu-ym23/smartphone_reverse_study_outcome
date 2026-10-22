package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements com.google.android.flexbox.a, RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* renamed from: A, reason: collision with root package name */
    public static final Rect f19399A = new Rect();

    /* renamed from: a, reason: collision with root package name */
    public int f19400a;

    /* renamed from: b, reason: collision with root package name */
    public int f19401b;

    /* renamed from: c, reason: collision with root package name */
    public int f19402c;

    /* renamed from: d, reason: collision with root package name */
    public int f19403d;

    /* renamed from: e, reason: collision with root package name */
    public int f19404e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f19405f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f19406g;

    /* renamed from: h, reason: collision with root package name */
    public List<com.google.android.flexbox.b> f19407h;

    /* renamed from: i, reason: collision with root package name */
    public final com.google.android.flexbox.c f19408i;

    /* renamed from: j, reason: collision with root package name */
    public RecyclerView.Recycler f19409j;

    /* renamed from: k, reason: collision with root package name */
    public RecyclerView.State f19410k;

    /* renamed from: l, reason: collision with root package name */
    public c f19411l;

    /* renamed from: m, reason: collision with root package name */
    public b f19412m;

    /* renamed from: n, reason: collision with root package name */
    public OrientationHelper f19413n;

    /* renamed from: o, reason: collision with root package name */
    public OrientationHelper f19414o;

    /* renamed from: p, reason: collision with root package name */
    public SavedState f19415p;

    /* renamed from: q, reason: collision with root package name */
    public int f19416q;

    /* renamed from: r, reason: collision with root package name */
    public int f19417r;

    /* renamed from: s, reason: collision with root package name */
    public int f19418s;

    /* renamed from: t, reason: collision with root package name */
    public int f19419t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f19420u;

    /* renamed from: v, reason: collision with root package name */
    public SparseArray<View> f19421v;

    /* renamed from: w, reason: collision with root package name */
    public final Context f19422w;

    /* renamed from: x, reason: collision with root package name */
    public View f19423x;

    /* renamed from: y, reason: collision with root package name */
    public int f19424y;

    /* renamed from: z, reason: collision with root package name */
    public c.a f19425z;

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f19426a;

        /* renamed from: b, reason: collision with root package name */
        public int f19427b;

        /* renamed from: c, reason: collision with root package name */
        public int f19428c;

        /* renamed from: d, reason: collision with root package name */
        public int f19429d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f19430e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f19431f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f19432g;

        public b() {
            this.f19429d = 0;
        }

        public static /* synthetic */ int l(b bVar, int i10) {
            int i11 = bVar.f19429d + i10;
            bVar.f19429d = i11;
            return i11;
        }

        public final void r() {
            if (FlexboxLayoutManager.this.t() || !FlexboxLayoutManager.this.f19405f) {
                this.f19428c = this.f19430e ? FlexboxLayoutManager.this.f19413n.getEndAfterPadding() : FlexboxLayoutManager.this.f19413n.getStartAfterPadding();
            } else {
                this.f19428c = this.f19430e ? FlexboxLayoutManager.this.f19413n.getEndAfterPadding() : FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.f19413n.getStartAfterPadding();
            }
        }

        public final void s(View view) {
            OrientationHelper orientationHelper = FlexboxLayoutManager.this.f19401b == 0 ? FlexboxLayoutManager.this.f19414o : FlexboxLayoutManager.this.f19413n;
            if (FlexboxLayoutManager.this.t() || !FlexboxLayoutManager.this.f19405f) {
                if (this.f19430e) {
                    this.f19428c = orientationHelper.getDecoratedEnd(view) + orientationHelper.getTotalSpaceChange();
                } else {
                    this.f19428c = orientationHelper.getDecoratedStart(view);
                }
            } else if (this.f19430e) {
                this.f19428c = orientationHelper.getDecoratedStart(view) + orientationHelper.getTotalSpaceChange();
            } else {
                this.f19428c = orientationHelper.getDecoratedEnd(view);
            }
            this.f19426a = FlexboxLayoutManager.this.getPosition(view);
            this.f19432g = false;
            int[] iArr = FlexboxLayoutManager.this.f19408i.f19464c;
            int i10 = this.f19426a;
            if (i10 == -1) {
                i10 = 0;
            }
            int i11 = iArr[i10];
            this.f19427b = i11 != -1 ? i11 : 0;
            if (FlexboxLayoutManager.this.f19407h.size() > this.f19427b) {
                this.f19426a = ((com.google.android.flexbox.b) FlexboxLayoutManager.this.f19407h.get(this.f19427b)).f19458o;
            }
        }

        public final void t() {
            this.f19426a = -1;
            this.f19427b = -1;
            this.f19428c = Integer.MIN_VALUE;
            this.f19431f = false;
            this.f19432g = false;
            if (FlexboxLayoutManager.this.t()) {
                if (FlexboxLayoutManager.this.f19401b == 0) {
                    this.f19430e = FlexboxLayoutManager.this.f19400a == 1;
                    return;
                } else {
                    this.f19430e = FlexboxLayoutManager.this.f19401b == 2;
                    return;
                }
            }
            if (FlexboxLayoutManager.this.f19401b == 0) {
                this.f19430e = FlexboxLayoutManager.this.f19400a == 3;
            } else {
                this.f19430e = FlexboxLayoutManager.this.f19401b == 2;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f19426a + ", mFlexLinePosition=" + this.f19427b + ", mCoordinate=" + this.f19428c + ", mPerpendicularCoordinate=" + this.f19429d + ", mLayoutFromEnd=" + this.f19430e + ", mValid=" + this.f19431f + ", mAssignedFromSavedState=" + this.f19432g + '}';
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f19434a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f19435b;

        /* renamed from: c, reason: collision with root package name */
        public int f19436c;

        /* renamed from: d, reason: collision with root package name */
        public int f19437d;

        /* renamed from: e, reason: collision with root package name */
        public int f19438e;

        /* renamed from: f, reason: collision with root package name */
        public int f19439f;

        /* renamed from: g, reason: collision with root package name */
        public int f19440g;

        /* renamed from: h, reason: collision with root package name */
        public int f19441h;

        /* renamed from: i, reason: collision with root package name */
        public int f19442i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f19443j;

        public c() {
            this.f19441h = 1;
            this.f19442i = 1;
        }

        public static /* synthetic */ int c(c cVar, int i10) {
            int i11 = cVar.f19438e + i10;
            cVar.f19438e = i11;
            return i11;
        }

        public static /* synthetic */ int d(c cVar, int i10) {
            int i11 = cVar.f19438e - i10;
            cVar.f19438e = i11;
            return i11;
        }

        public static /* synthetic */ int i(c cVar, int i10) {
            int i11 = cVar.f19434a - i10;
            cVar.f19434a = i11;
            return i11;
        }

        public static /* synthetic */ int l(c cVar) {
            int i10 = cVar.f19436c;
            cVar.f19436c = i10 + 1;
            return i10;
        }

        public static /* synthetic */ int m(c cVar) {
            int i10 = cVar.f19436c;
            cVar.f19436c = i10 - 1;
            return i10;
        }

        public static /* synthetic */ int n(c cVar, int i10) {
            int i11 = cVar.f19436c + i10;
            cVar.f19436c = i11;
            return i11;
        }

        public static /* synthetic */ int q(c cVar, int i10) {
            int i11 = cVar.f19439f + i10;
            cVar.f19439f = i11;
            return i11;
        }

        public static /* synthetic */ int u(c cVar, int i10) {
            int i11 = cVar.f19437d + i10;
            cVar.f19437d = i11;
            return i11;
        }

        public static /* synthetic */ int v(c cVar, int i10) {
            int i11 = cVar.f19437d - i10;
            cVar.f19437d = i11;
            return i11;
        }

        public final boolean D(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            int i10;
            int i11 = this.f19437d;
            return i11 >= 0 && i11 < state.getItemCount() && (i10 = this.f19436c) >= 0 && i10 < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.f19434a + ", mFlexLinePosition=" + this.f19436c + ", mPosition=" + this.f19437d + ", mOffset=" + this.f19438e + ", mScrollingOffset=" + this.f19439f + ", mLastScrollDelta=" + this.f19440g + ", mItemDirection=" + this.f19441h + ", mLayoutDirection=" + this.f19442i + '}';
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    private void ensureLayoutState() {
        if (this.f19411l == null) {
            this.f19411l = new c();
        }
    }

    private View getChildClosestToStart() {
        return getChildAt(0);
    }

    public static boolean isMeasurementUpToDate(int i10, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (i12 > 0 && i10 != i12) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i10;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i10;
        }
        return true;
    }

    private boolean shouldMeasureChild(View view, int i10, int i11, RecyclerView.LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i10, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i11, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
    }

    public final boolean B(View view, int i10) {
        return (t() || !this.f19405f) ? this.f19413n.getDecoratedStart(view) >= this.f19413n.getEnd() - i10 : this.f19413n.getDecoratedEnd(view) <= i10;
    }

    public final boolean C(View view, int i10) {
        return (t() || !this.f19405f) ? this.f19413n.getDecoratedEnd(view) <= i10 : this.f19413n.getEnd() - this.f19413n.getDecoratedStart(view) <= i10;
    }

    public final void D() {
        this.f19407h.clear();
        this.f19412m.t();
        this.f19412m.f19429d = 0;
    }

    public final void E() {
        if (this.f19413n != null) {
            return;
        }
        if (t()) {
            if (this.f19401b == 0) {
                this.f19413n = OrientationHelper.createHorizontalHelper(this);
                this.f19414o = OrientationHelper.createVerticalHelper(this);
                return;
            } else {
                this.f19413n = OrientationHelper.createVerticalHelper(this);
                this.f19414o = OrientationHelper.createHorizontalHelper(this);
                return;
            }
        }
        if (this.f19401b == 0) {
            this.f19413n = OrientationHelper.createVerticalHelper(this);
            this.f19414o = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.f19413n = OrientationHelper.createHorizontalHelper(this);
            this.f19414o = OrientationHelper.createVerticalHelper(this);
        }
    }

    public final int F(RecyclerView.Recycler recycler, RecyclerView.State state, c cVar) {
        if (cVar.f19439f != Integer.MIN_VALUE) {
            if (cVar.f19434a < 0) {
                c.q(cVar, cVar.f19434a);
            }
            X(recycler, cVar);
        }
        int i10 = cVar.f19434a;
        int iA = cVar.f19434a;
        boolean zT = t();
        int iU = 0;
        while (true) {
            if ((iA <= 0 && !this.f19411l.f19435b) || !cVar.D(state, this.f19407h)) {
                break;
            }
            com.google.android.flexbox.b bVar = this.f19407h.get(cVar.f19436c);
            cVar.f19437d = bVar.f19458o;
            iU += U(bVar, cVar);
            if (zT || !this.f19405f) {
                c.c(cVar, bVar.a() * cVar.f19442i);
            } else {
                c.d(cVar, bVar.a() * cVar.f19442i);
            }
            iA -= bVar.a();
        }
        c.i(cVar, iU);
        if (cVar.f19439f != Integer.MIN_VALUE) {
            c.q(cVar, iU);
            if (cVar.f19434a < 0) {
                c.q(cVar, cVar.f19434a);
            }
            X(recycler, cVar);
        }
        return i10 - cVar.f19434a;
    }

    public final View G(int i10) {
        View viewL = L(0, getChildCount(), i10);
        if (viewL == null) {
            return null;
        }
        int i11 = this.f19408i.f19464c[getPosition(viewL)];
        if (i11 == -1) {
            return null;
        }
        return H(viewL, this.f19407h.get(i11));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View H(android.view.View r6, com.google.android.flexbox.b r7) {
        /*
            r5 = this;
            boolean r0 = r5.t()
            int r7 = r7.f19451h
            r1 = 1
        L7:
            if (r1 >= r7) goto L3f
            android.view.View r2 = r5.getChildAt(r1)
            if (r2 == 0) goto L3c
            int r3 = r2.getVisibility()
            r4 = 8
            if (r3 != r4) goto L18
            goto L3c
        L18:
            boolean r3 = r5.f19405f
            if (r3 == 0) goto L2d
            if (r0 != 0) goto L2d
            androidx.recyclerview.widget.OrientationHelper r3 = r5.f19413n
            int r3 = r3.getDecoratedEnd(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.f19413n
            int r4 = r4.getDecoratedEnd(r2)
            if (r3 >= r4) goto L3c
            goto L3b
        L2d:
            androidx.recyclerview.widget.OrientationHelper r3 = r5.f19413n
            int r3 = r3.getDecoratedStart(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.f19413n
            int r4 = r4.getDecoratedStart(r2)
            if (r3 <= r4) goto L3c
        L3b:
            r6 = r2
        L3c:
            int r1 = r1 + 1
            goto L7
        L3f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.H(android.view.View, com.google.android.flexbox.b):android.view.View");
    }

    public final View I(int i10) {
        View viewL = L(getChildCount() - 1, -1, i10);
        if (viewL == null) {
            return null;
        }
        return J(viewL, this.f19407h.get(this.f19408i.f19464c[getPosition(viewL)]));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View J(android.view.View r6, com.google.android.flexbox.b r7) {
        /*
            r5 = this;
            boolean r0 = r5.t()
            int r1 = r5.getChildCount()
            int r1 = r1 + (-2)
            int r2 = r5.getChildCount()
            int r7 = r7.f19451h
            int r2 = r2 - r7
            int r2 = r2 + (-1)
        L13:
            if (r1 <= r2) goto L4b
            android.view.View r7 = r5.getChildAt(r1)
            if (r7 == 0) goto L48
            int r3 = r7.getVisibility()
            r4 = 8
            if (r3 != r4) goto L24
            goto L48
        L24:
            boolean r3 = r5.f19405f
            if (r3 == 0) goto L39
            if (r0 != 0) goto L39
            androidx.recyclerview.widget.OrientationHelper r3 = r5.f19413n
            int r3 = r3.getDecoratedStart(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.f19413n
            int r4 = r4.getDecoratedStart(r7)
            if (r3 <= r4) goto L48
            goto L47
        L39:
            androidx.recyclerview.widget.OrientationHelper r3 = r5.f19413n
            int r3 = r3.getDecoratedEnd(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.f19413n
            int r4 = r4.getDecoratedEnd(r7)
            if (r3 >= r4) goto L48
        L47:
            r6 = r7
        L48:
            int r1 = r1 + (-1)
            goto L13
        L4b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.J(android.view.View, com.google.android.flexbox.b):android.view.View");
    }

    public final View K(int i10, int i11, boolean z10) {
        int i12 = i11 > i10 ? 1 : -1;
        while (i10 != i11) {
            View childAt = getChildAt(i10);
            if (T(childAt, z10)) {
                return childAt;
            }
            i10 += i12;
        }
        return null;
    }

    public final View L(int i10, int i11, int i12) {
        int position;
        E();
        ensureLayoutState();
        int startAfterPadding = this.f19413n.getStartAfterPadding();
        int endAfterPadding = this.f19413n.getEndAfterPadding();
        int i13 = i11 > i10 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i10 != i11) {
            View childAt = getChildAt(i10);
            if (childAt != null && (position = getPosition(childAt)) >= 0 && position < i12) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.f19413n.getDecoratedStart(childAt) >= startAfterPadding && this.f19413n.getDecoratedEnd(childAt) <= endAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i10 += i13;
        }
        return view != null ? view : view2;
    }

    public final int M(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    public final int N(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    public final int O(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    public final int P(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    public View Q(int i10) {
        View view = this.f19421v.get(i10);
        return view != null ? view : this.f19409j.getViewForPosition(i10);
    }

    public final int R(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        E();
        int i11 = 1;
        this.f19411l.f19443j = true;
        boolean z10 = !t() && this.f19405f;
        if (!z10 ? i10 <= 0 : i10 >= 0) {
            i11 = -1;
        }
        int iAbs = Math.abs(i10);
        l0(i11, iAbs);
        int iF = this.f19411l.f19439f + F(recycler, state, this.f19411l);
        if (iF < 0) {
            return 0;
        }
        if (z10) {
            if (iAbs > iF) {
                i10 = (-i11) * iF;
            }
        } else if (iAbs > iF) {
            i10 = i11 * iF;
        }
        this.f19413n.offsetChildren(-i10);
        this.f19411l.f19440g = i10;
        return i10;
    }

    public final int S(int i10) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        E();
        boolean zT = t();
        View view = this.f19423x;
        int width = zT ? view.getWidth() : view.getHeight();
        int width2 = zT ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int iAbs = Math.abs(i10);
            if (i10 < 0) {
                return -Math.min((width2 + this.f19412m.f19429d) - width, iAbs);
            }
            if (this.f19412m.f19429d + i10 > 0) {
                return -this.f19412m.f19429d;
            }
        } else {
            if (i10 > 0) {
                return Math.min((width2 - this.f19412m.f19429d) - width, i10);
            }
            if (this.f19412m.f19429d + i10 < 0) {
                return -this.f19412m.f19429d;
            }
        }
        return i10;
    }

    public final boolean T(View view, boolean z10) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int iN = N(view);
        int iP = P(view);
        int iO = O(view);
        int iM = M(view);
        return z10 ? (paddingLeft <= iN && width >= iO) && (paddingTop <= iP && height >= iM) : (iN >= width || iO >= paddingLeft) && (iP >= height || iM >= paddingTop);
    }

    public final int U(com.google.android.flexbox.b bVar, c cVar) {
        return t() ? V(bVar, cVar) : W(bVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int V(com.google.android.flexbox.b r19, com.google.android.flexbox.FlexboxLayoutManager.c r20) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.V(com.google.android.flexbox.b, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int W(com.google.android.flexbox.b r21, com.google.android.flexbox.FlexboxLayoutManager.c r22) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.W(com.google.android.flexbox.b, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    public final void X(RecyclerView.Recycler recycler, c cVar) {
        if (cVar.f19443j) {
            if (cVar.f19442i == -1) {
                Y(recycler, cVar);
            } else {
                Z(recycler, cVar);
            }
        }
    }

    public final void Y(RecyclerView.Recycler recycler, c cVar) {
        int childCount;
        int i10;
        View childAt;
        int i11;
        if (cVar.f19439f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(childCount - 1)) == null || (i11 = this.f19408i.f19464c[getPosition(childAt)]) == -1) {
            return;
        }
        com.google.android.flexbox.b bVar = this.f19407h.get(i11);
        int i12 = i10;
        while (true) {
            if (i12 < 0) {
                break;
            }
            View childAt2 = getChildAt(i12);
            if (childAt2 != null) {
                if (!B(childAt2, cVar.f19439f)) {
                    break;
                }
                if (bVar.f19458o != getPosition(childAt2)) {
                    continue;
                } else if (i11 <= 0) {
                    childCount = i12;
                    break;
                } else {
                    i11 += cVar.f19442i;
                    bVar = this.f19407h.get(i11);
                    childCount = i12;
                }
            }
            i12--;
        }
        recycleChildren(recycler, childCount, i10);
    }

    public final void Z(RecyclerView.Recycler recycler, c cVar) {
        int childCount;
        View childAt;
        if (cVar.f19439f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(0)) == null) {
            return;
        }
        int i10 = this.f19408i.f19464c[getPosition(childAt)];
        int i11 = -1;
        if (i10 == -1) {
            return;
        }
        com.google.android.flexbox.b bVar = this.f19407h.get(i10);
        int i12 = 0;
        while (true) {
            if (i12 >= childCount) {
                break;
            }
            View childAt2 = getChildAt(i12);
            if (childAt2 != null) {
                if (!C(childAt2, cVar.f19439f)) {
                    break;
                }
                if (bVar.f19459p != getPosition(childAt2)) {
                    continue;
                } else if (i10 >= this.f19407h.size() - 1) {
                    i11 = i12;
                    break;
                } else {
                    i10 += cVar.f19442i;
                    bVar = this.f19407h.get(i10);
                    i11 = i12;
                }
            }
            i12++;
        }
        recycleChildren(recycler, 0, i11);
    }

    public final void a0() {
        int heightMode = t() ? getHeightMode() : getWidthMode();
        this.f19411l.f19435b = heightMode == 0 || heightMode == Integer.MIN_VALUE;
    }

    public final void b0() {
        int layoutDirection = getLayoutDirection();
        int i10 = this.f19400a;
        if (i10 == 0) {
            this.f19405f = layoutDirection == 1;
            this.f19406g = this.f19401b == 2;
            return;
        }
        if (i10 == 1) {
            this.f19405f = layoutDirection != 1;
            this.f19406g = this.f19401b == 2;
            return;
        }
        if (i10 == 2) {
            boolean z10 = layoutDirection == 1;
            this.f19405f = z10;
            if (this.f19401b == 2) {
                this.f19405f = !z10;
            }
            this.f19406g = false;
            return;
        }
        if (i10 != 3) {
            this.f19405f = false;
            this.f19406g = false;
            return;
        }
        boolean z11 = layoutDirection == 1;
        this.f19405f = z11;
        if (this.f19401b == 2) {
            this.f19405f = !z11;
        }
        this.f19406g = true;
    }

    @Override // com.google.android.flexbox.a
    public int c() {
        return this.f19410k.getItemCount();
    }

    public void c0(int i10) {
        int i11 = this.f19403d;
        if (i11 != i10) {
            if (i11 == 4 || i10 == 4) {
                removeAllViews();
                D();
            }
            this.f19403d = i10;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.f19401b == 0) {
            return t();
        }
        if (!t()) {
            return true;
        }
        int width = getWidth();
        View view = this.f19423x;
        return width > (view != null ? view.getWidth() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.f19401b == 0) {
            return !t();
        }
        if (!t()) {
            int height = getHeight();
            View view = this.f19423x;
            if (height <= (view != null ? view.getHeight() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        E();
        View viewG = G(itemCount);
        View viewI = I(itemCount);
        if (state.getItemCount() == 0 || viewG == null || viewI == null) {
            return 0;
        }
        return Math.min(this.f19413n.getTotalSpace(), this.f19413n.getDecoratedEnd(viewI) - this.f19413n.getDecoratedStart(viewG));
    }

    public final int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewG = G(itemCount);
        View viewI = I(itemCount);
        if (state.getItemCount() != 0 && viewG != null && viewI != null) {
            int position = getPosition(viewG);
            int position2 = getPosition(viewI);
            int iAbs = Math.abs(this.f19413n.getDecoratedEnd(viewI) - this.f19413n.getDecoratedStart(viewG));
            int i10 = this.f19408i.f19464c[position];
            if (i10 != 0 && i10 != -1) {
                return Math.round((i10 * (iAbs / ((r4[position2] - i10) + 1))) + (this.f19413n.getStartAfterPadding() - this.f19413n.getDecoratedStart(viewG)));
            }
        }
        return 0;
    }

    public final int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewG = G(itemCount);
        View viewI = I(itemCount);
        if (state.getItemCount() == 0 || viewG == null || viewI == null) {
            return 0;
        }
        int iFindFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((Math.abs(this.f19413n.getDecoratedEnd(viewI) - this.f19413n.getDecoratedStart(viewG)) / ((findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1)) * state.getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i10) {
        View childAt;
        if (getChildCount() == 0 || (childAt = getChildAt(0)) == null) {
            return null;
        }
        int i11 = i10 < getPosition(childAt) ? -1 : 1;
        return t() ? new PointF(0.0f, i11) : new PointF(i11, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // com.google.android.flexbox.a
    public void d(View view, int i10, int i11, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, f19399A);
        if (t()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.f19448e += leftDecorationWidth;
            bVar.f19449f += leftDecorationWidth;
        } else {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            bVar.f19448e += topDecorationHeight;
            bVar.f19449f += topDecorationHeight;
        }
    }

    public void d0(int i10) {
        if (this.f19400a != i10) {
            removeAllViews();
            this.f19400a = i10;
            this.f19413n = null;
            this.f19414o = null;
            D();
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int e() {
        return this.f19400a;
    }

    public void e0(int i10) {
        if (i10 == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i11 = this.f19401b;
        if (i11 != i10) {
            if (i11 == 0 || i10 == 0) {
                removeAllViews();
                D();
            }
            this.f19401b = i10;
            this.f19413n = null;
            this.f19414o = null;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int f() {
        return this.f19404e;
    }

    public void f0(int i10) {
        if (this.f19402c != i10) {
            this.f19402c = i10;
            requestLayout();
        }
    }

    public int findFirstVisibleItemPosition() {
        View viewK = K(0, getChildCount(), false);
        if (viewK == null) {
            return -1;
        }
        return getPosition(viewK);
    }

    public int findLastVisibleItemPosition() {
        View viewK = K(getChildCount() - 1, -1, false);
        if (viewK == null) {
            return -1;
        }
        return getPosition(viewK);
    }

    public final int fixLayoutEndGap(int i10, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z10) {
        int iR;
        int endAfterPadding;
        if (t() || !this.f19405f) {
            int endAfterPadding2 = this.f19413n.getEndAfterPadding() - i10;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            iR = -R(-endAfterPadding2, recycler, state);
        } else {
            int startAfterPadding = i10 - this.f19413n.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            iR = R(startAfterPadding, recycler, state);
        }
        int i11 = i10 + iR;
        if (!z10 || (endAfterPadding = this.f19413n.getEndAfterPadding() - i11) <= 0) {
            return iR;
        }
        this.f19413n.offsetChildren(endAfterPadding);
        return endAfterPadding + iR;
    }

    public final int fixLayoutStartGap(int i10, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z10) {
        int iR;
        int startAfterPadding;
        if (t() || !this.f19405f) {
            int startAfterPadding2 = i10 - this.f19413n.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            iR = -R(startAfterPadding2, recycler, state);
        } else {
            int endAfterPadding = this.f19413n.getEndAfterPadding() - i10;
            if (endAfterPadding <= 0) {
                return 0;
            }
            iR = R(-endAfterPadding, recycler, state);
        }
        int i11 = i10 + iR;
        if (!z10 || (startAfterPadding = i11 - this.f19413n.getStartAfterPadding()) <= 0) {
            return iR;
        }
        this.f19413n.offsetChildren(-startAfterPadding);
        return iR - startAfterPadding;
    }

    @Override // com.google.android.flexbox.a
    public int g() {
        if (this.f19407h.size() == 0) {
            return 0;
        }
        int size = this.f19407h.size();
        int iMax = Integer.MIN_VALUE;
        for (int i10 = 0; i10 < size; i10++) {
            iMax = Math.max(iMax, this.f19407h.get(i10).f19448e);
        }
        return iMax;
    }

    public final boolean g0(RecyclerView.State state, b bVar) {
        if (getChildCount() == 0) {
            return false;
        }
        View viewI = bVar.f19430e ? I(state.getItemCount()) : G(state.getItemCount());
        if (viewI == null) {
            return false;
        }
        bVar.s(viewI);
        if (state.isPreLayout() || !supportsPredictiveItemAnimations()) {
            return true;
        }
        if (this.f19413n.getDecoratedStart(viewI) < this.f19413n.getEndAfterPadding() && this.f19413n.getDecoratedEnd(viewI) >= this.f19413n.getStartAfterPadding()) {
            return true;
        }
        bVar.f19428c = bVar.f19430e ? this.f19413n.getEndAfterPadding() : this.f19413n.getStartAfterPadding();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // com.google.android.flexbox.a
    public int h(int i10, int i11, int i12) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i11, i12, canScrollHorizontally());
    }

    public final boolean h0(RecyclerView.State state, b bVar, SavedState savedState) {
        int i10;
        View childAt;
        if (!state.isPreLayout() && (i10 = this.f19416q) != -1) {
            if (i10 >= 0 && i10 < state.getItemCount()) {
                bVar.f19426a = this.f19416q;
                bVar.f19427b = this.f19408i.f19464c[bVar.f19426a];
                SavedState savedState2 = this.f19415p;
                if (savedState2 != null && savedState2.hasValidAnchor(state.getItemCount())) {
                    bVar.f19428c = this.f19413n.getStartAfterPadding() + savedState.mAnchorOffset;
                    bVar.f19432g = true;
                    bVar.f19427b = -1;
                    return true;
                }
                if (this.f19417r != Integer.MIN_VALUE) {
                    if (t() || !this.f19405f) {
                        bVar.f19428c = this.f19413n.getStartAfterPadding() + this.f19417r;
                    } else {
                        bVar.f19428c = this.f19417r - this.f19413n.getEndPadding();
                    }
                    return true;
                }
                View viewFindViewByPosition = findViewByPosition(this.f19416q);
                if (viewFindViewByPosition == null) {
                    if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
                        bVar.f19430e = this.f19416q < getPosition(childAt);
                    }
                    bVar.r();
                } else {
                    if (this.f19413n.getDecoratedMeasurement(viewFindViewByPosition) > this.f19413n.getTotalSpace()) {
                        bVar.r();
                        return true;
                    }
                    if (this.f19413n.getDecoratedStart(viewFindViewByPosition) - this.f19413n.getStartAfterPadding() < 0) {
                        bVar.f19428c = this.f19413n.getStartAfterPadding();
                        bVar.f19430e = false;
                        return true;
                    }
                    if (this.f19413n.getEndAfterPadding() - this.f19413n.getDecoratedEnd(viewFindViewByPosition) < 0) {
                        bVar.f19428c = this.f19413n.getEndAfterPadding();
                        bVar.f19430e = true;
                        return true;
                    }
                    bVar.f19428c = bVar.f19430e ? this.f19413n.getDecoratedEnd(viewFindViewByPosition) + this.f19413n.getTotalSpaceChange() : this.f19413n.getDecoratedStart(viewFindViewByPosition);
                }
                return true;
            }
            this.f19416q = -1;
            this.f19417r = Integer.MIN_VALUE;
        }
        return false;
    }

    public final void i0(RecyclerView.State state, b bVar) {
        if (h0(state, bVar, this.f19415p) || g0(state, bVar)) {
            return;
        }
        bVar.r();
        bVar.f19426a = 0;
        bVar.f19427b = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> j() {
        return this.f19407h;
    }

    public final void j0(int i10) {
        if (i10 >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.f19408i.m(childCount);
        this.f19408i.n(childCount);
        this.f19408i.l(childCount);
        if (i10 >= this.f19408i.f19464c.length) {
            return;
        }
        this.f19424y = i10;
        View childClosestToStart = getChildClosestToStart();
        if (childClosestToStart == null) {
            return;
        }
        this.f19416q = getPosition(childClosestToStart);
        if (t() || !this.f19405f) {
            this.f19417r = this.f19413n.getDecoratedStart(childClosestToStart) - this.f19413n.getStartAfterPadding();
        } else {
            this.f19417r = this.f19413n.getDecoratedEnd(childClosestToStart) + this.f19413n.getEndPadding();
        }
    }

    @Override // com.google.android.flexbox.a
    public int k(int i10, int i11, int i12) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i11, i12, canScrollVertically());
    }

    public final void k0(int i10) {
        int i11;
        int i12;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        boolean z10 = false;
        if (t()) {
            int i13 = this.f19418s;
            if (i13 != Integer.MIN_VALUE && i13 != width) {
                z10 = true;
            }
            i11 = this.f19411l.f19435b ? this.f19422w.getResources().getDisplayMetrics().heightPixels : this.f19411l.f19434a;
        } else {
            int i14 = this.f19419t;
            if (i14 != Integer.MIN_VALUE && i14 != height) {
                z10 = true;
            }
            i11 = this.f19411l.f19435b ? this.f19422w.getResources().getDisplayMetrics().widthPixels : this.f19411l.f19434a;
        }
        int i15 = i11;
        this.f19418s = width;
        this.f19419t = height;
        int i16 = this.f19424y;
        if (i16 == -1 && (this.f19416q != -1 || z10)) {
            if (this.f19412m.f19430e) {
                return;
            }
            this.f19407h.clear();
            this.f19425z.a();
            if (t()) {
                this.f19408i.d(this.f19425z, iMakeMeasureSpec, iMakeMeasureSpec2, i15, this.f19412m.f19426a, this.f19407h);
            } else {
                this.f19408i.f(this.f19425z, iMakeMeasureSpec, iMakeMeasureSpec2, i15, this.f19412m.f19426a, this.f19407h);
            }
            this.f19407h = this.f19425z.f19467a;
            this.f19408i.i(iMakeMeasureSpec, iMakeMeasureSpec2);
            this.f19408i.O();
            b bVar = this.f19412m;
            bVar.f19427b = this.f19408i.f19464c[bVar.f19426a];
            this.f19411l.f19436c = this.f19412m.f19427b;
            return;
        }
        int iMin = i16 != -1 ? Math.min(i16, this.f19412m.f19426a) : this.f19412m.f19426a;
        this.f19425z.a();
        if (!t()) {
            i12 = iMin;
            if (this.f19407h.size() > 0) {
                this.f19408i.h(this.f19407h, i12);
                iMin = i12;
                this.f19408i.b(this.f19425z, iMakeMeasureSpec2, iMakeMeasureSpec, i15, iMin, this.f19412m.f19426a, this.f19407h);
                iMakeMeasureSpec2 = iMakeMeasureSpec2;
                iMakeMeasureSpec = iMakeMeasureSpec;
                i12 = iMin;
            } else {
                this.f19408i.l(i10);
                this.f19408i.e(this.f19425z, iMakeMeasureSpec, iMakeMeasureSpec2, i15, 0, this.f19407h);
            }
        } else if (this.f19407h.size() > 0) {
            this.f19408i.h(this.f19407h, iMin);
            this.f19408i.b(this.f19425z, iMakeMeasureSpec, iMakeMeasureSpec2, i15, iMin, this.f19412m.f19426a, this.f19407h);
            i12 = iMin;
        } else {
            i12 = iMin;
            this.f19408i.l(i10);
            this.f19408i.c(this.f19425z, iMakeMeasureSpec, iMakeMeasureSpec2, i15, 0, this.f19407h);
        }
        this.f19407h = this.f19425z.f19467a;
        this.f19408i.j(iMakeMeasureSpec, iMakeMeasureSpec2, i12);
        this.f19408i.P(i12);
    }

    public final void l0(int i10, int i11) {
        this.f19411l.f19442i = i10;
        boolean zT = t();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z10 = !zT && this.f19405f;
        if (i10 == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null) {
                return;
            }
            this.f19411l.f19438e = this.f19413n.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View viewJ = J(childAt, this.f19407h.get(this.f19408i.f19464c[position]));
            this.f19411l.f19441h = 1;
            c cVar = this.f19411l;
            cVar.f19437d = position + cVar.f19441h;
            if (this.f19408i.f19464c.length <= this.f19411l.f19437d) {
                this.f19411l.f19436c = -1;
            } else {
                c cVar2 = this.f19411l;
                cVar2.f19436c = this.f19408i.f19464c[cVar2.f19437d];
            }
            if (z10) {
                this.f19411l.f19438e = this.f19413n.getDecoratedStart(viewJ);
                this.f19411l.f19439f = (-this.f19413n.getDecoratedStart(viewJ)) + this.f19413n.getStartAfterPadding();
                c cVar3 = this.f19411l;
                cVar3.f19439f = Math.max(cVar3.f19439f, 0);
            } else {
                this.f19411l.f19438e = this.f19413n.getDecoratedEnd(viewJ);
                this.f19411l.f19439f = this.f19413n.getDecoratedEnd(viewJ) - this.f19413n.getEndAfterPadding();
            }
            if ((this.f19411l.f19436c == -1 || this.f19411l.f19436c > this.f19407h.size() - 1) && this.f19411l.f19437d <= c()) {
                int i12 = i11 - this.f19411l.f19439f;
                this.f19425z.a();
                if (i12 > 0) {
                    if (zT) {
                        this.f19408i.c(this.f19425z, iMakeMeasureSpec, iMakeMeasureSpec2, i12, this.f19411l.f19437d, this.f19407h);
                    } else {
                        this.f19408i.e(this.f19425z, iMakeMeasureSpec, iMakeMeasureSpec2, i12, this.f19411l.f19437d, this.f19407h);
                    }
                    this.f19408i.j(iMakeMeasureSpec, iMakeMeasureSpec2, this.f19411l.f19437d);
                    this.f19408i.P(this.f19411l.f19437d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 == null) {
                return;
            }
            this.f19411l.f19438e = this.f19413n.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View viewH = H(childAt2, this.f19407h.get(this.f19408i.f19464c[position2]));
            this.f19411l.f19441h = 1;
            int i13 = this.f19408i.f19464c[position2];
            if (i13 == -1) {
                i13 = 0;
            }
            if (i13 > 0) {
                this.f19411l.f19437d = position2 - this.f19407h.get(i13 - 1).b();
            } else {
                this.f19411l.f19437d = -1;
            }
            this.f19411l.f19436c = i13 > 0 ? i13 - 1 : 0;
            if (z10) {
                this.f19411l.f19438e = this.f19413n.getDecoratedEnd(viewH);
                this.f19411l.f19439f = this.f19413n.getDecoratedEnd(viewH) - this.f19413n.getEndAfterPadding();
                c cVar4 = this.f19411l;
                cVar4.f19439f = Math.max(cVar4.f19439f, 0);
            } else {
                this.f19411l.f19438e = this.f19413n.getDecoratedStart(viewH);
                this.f19411l.f19439f = (-this.f19413n.getDecoratedStart(viewH)) + this.f19413n.getStartAfterPadding();
            }
        }
        c cVar5 = this.f19411l;
        cVar5.f19434a = i11 - cVar5.f19439f;
    }

    @Override // com.google.android.flexbox.a
    public int m(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (t()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    public final void m0(b bVar, boolean z10, boolean z11) {
        if (z11) {
            a0();
        } else {
            this.f19411l.f19435b = false;
        }
        if (t() || !this.f19405f) {
            this.f19411l.f19434a = this.f19413n.getEndAfterPadding() - bVar.f19428c;
        } else {
            this.f19411l.f19434a = bVar.f19428c - getPaddingRight();
        }
        this.f19411l.f19437d = bVar.f19426a;
        this.f19411l.f19441h = 1;
        this.f19411l.f19442i = 1;
        this.f19411l.f19438e = bVar.f19428c;
        this.f19411l.f19439f = Integer.MIN_VALUE;
        this.f19411l.f19436c = bVar.f19427b;
        if (!z10 || this.f19407h.size() <= 1 || bVar.f19427b < 0 || bVar.f19427b >= this.f19407h.size() - 1) {
            return;
        }
        com.google.android.flexbox.b bVar2 = this.f19407h.get(bVar.f19427b);
        c.l(this.f19411l);
        c.u(this.f19411l, bVar2.b());
    }

    @Override // com.google.android.flexbox.a
    public int n() {
        return this.f19401b;
    }

    public final void n0(b bVar, boolean z10, boolean z11) {
        if (z11) {
            a0();
        } else {
            this.f19411l.f19435b = false;
        }
        if (t() || !this.f19405f) {
            this.f19411l.f19434a = bVar.f19428c - this.f19413n.getStartAfterPadding();
        } else {
            this.f19411l.f19434a = (this.f19423x.getWidth() - bVar.f19428c) - this.f19413n.getStartAfterPadding();
        }
        this.f19411l.f19437d = bVar.f19426a;
        this.f19411l.f19441h = 1;
        this.f19411l.f19442i = -1;
        this.f19411l.f19438e = bVar.f19428c;
        this.f19411l.f19439f = Integer.MIN_VALUE;
        this.f19411l.f19436c = bVar.f19427b;
        if (!z10 || bVar.f19427b <= 0 || this.f19407h.size() <= bVar.f19427b) {
            return;
        }
        com.google.android.flexbox.b bVar2 = this.f19407h.get(bVar.f19427b);
        c.m(this.f19411l);
        c.v(this.f19411l, bVar2.b());
    }

    @Override // com.google.android.flexbox.a
    public void o(com.google.android.flexbox.b bVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f19423x = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.f19420u) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsAdded(recyclerView, i10, i11);
        j0(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        super.onItemsMoved(recyclerView, i10, i11, i12);
        j0(Math.min(i10, i11));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsRemoved(recyclerView, i10, i11);
        j0(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        super.onItemsUpdated(recyclerView, i10, i11, obj);
        j0(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i10;
        int i11;
        this.f19409j = recycler;
        this.f19410k = state;
        int itemCount = state.getItemCount();
        if (itemCount == 0 && state.isPreLayout()) {
            return;
        }
        b0();
        E();
        ensureLayoutState();
        this.f19408i.m(itemCount);
        this.f19408i.n(itemCount);
        this.f19408i.l(itemCount);
        this.f19411l.f19443j = false;
        SavedState savedState = this.f19415p;
        if (savedState != null && savedState.hasValidAnchor(itemCount)) {
            this.f19416q = this.f19415p.mAnchorPosition;
        }
        if (!this.f19412m.f19431f || this.f19416q != -1 || this.f19415p != null) {
            this.f19412m.t();
            i0(state, this.f19412m);
            this.f19412m.f19431f = true;
        }
        detachAndScrapAttachedViews(recycler);
        if (this.f19412m.f19430e) {
            n0(this.f19412m, false, true);
        } else {
            m0(this.f19412m, false, true);
        }
        k0(itemCount);
        F(recycler, state, this.f19411l);
        if (this.f19412m.f19430e) {
            i11 = this.f19411l.f19438e;
            m0(this.f19412m, true, false);
            F(recycler, state, this.f19411l);
            i10 = this.f19411l.f19438e;
        } else {
            i10 = this.f19411l.f19438e;
            n0(this.f19412m, true, false);
            F(recycler, state, this.f19411l);
            i11 = this.f19411l.f19438e;
        }
        if (getChildCount() > 0) {
            if (this.f19412m.f19430e) {
                fixLayoutStartGap(i11 + fixLayoutEndGap(i10, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i10 + fixLayoutStartGap(i11, recycler, state, true), recycler, state, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f19415p = null;
        this.f19416q = -1;
        this.f19417r = Integer.MIN_VALUE;
        this.f19424y = -1;
        this.f19412m.t();
        this.f19421v.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f19415p = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.f19415p != null) {
            return new SavedState(this.f19415p);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() <= 0) {
            savedState.invalidateAnchor();
            return savedState;
        }
        View childClosestToStart = getChildClosestToStart();
        savedState.mAnchorPosition = getPosition(childClosestToStart);
        savedState.mAnchorOffset = this.f19413n.getDecoratedStart(childClosestToStart) - this.f19413n.getStartAfterPadding();
        return savedState;
    }

    @Override // com.google.android.flexbox.a
    public View p(int i10) {
        return Q(i10);
    }

    @Override // com.google.android.flexbox.a
    public int q() {
        return this.f19403d;
    }

    @Override // com.google.android.flexbox.a
    public void r(int i10, View view) {
        this.f19421v.put(i10, view);
    }

    public final void recycleChildren(RecyclerView.Recycler recycler, int i10, int i11) {
        while (i11 >= i10) {
            removeAndRecycleViewAt(i11, recycler);
            i11--;
        }
    }

    @Override // com.google.android.flexbox.a
    public int s(View view, int i10, int i11) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (t()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!t() || this.f19401b == 0) {
            int iR = R(i10, recycler, state);
            this.f19421v.clear();
            return iR;
        }
        int iS = S(i10);
        b.l(this.f19412m, iS);
        this.f19414o.offsetChildren(-iS);
        return iS;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i10) {
        this.f19416q = i10;
        this.f19417r = Integer.MIN_VALUE;
        SavedState savedState = this.f19415p;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (t() || (this.f19401b == 0 && !t())) {
            int iR = R(i10, recycler, state);
            this.f19421v.clear();
            return iR;
        }
        int iS = S(i10);
        b.l(this.f19412m, iS);
        this.f19414o.offsetChildren(-iS);
        return iS;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i10);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // com.google.android.flexbox.a
    public boolean t() {
        int i10 = this.f19400a;
        return i10 == 0 || i10 == 1;
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private int mAnchorOffset;
        private int mAnchorPosition;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasValidAnchor(int i10) {
            int i11 = this.mAnchorPosition;
            return i11 >= 0 && i11 < i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
        }

        public SavedState() {
        }

        private SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
        }

        private SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
        }
    }

    public FlexboxLayoutManager(Context context, int i10, int i11) {
        this.f19404e = -1;
        this.f19407h = new ArrayList();
        this.f19408i = new com.google.android.flexbox.c(this);
        this.f19412m = new b();
        this.f19416q = -1;
        this.f19417r = Integer.MIN_VALUE;
        this.f19418s = Integer.MIN_VALUE;
        this.f19419t = Integer.MIN_VALUE;
        this.f19421v = new SparseArray<>();
        this.f19424y = -1;
        this.f19425z = new c.a();
        d0(i10);
        e0(i11);
        c0(4);
        this.f19422w = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsUpdated(recyclerView, i10, i11);
        j0(i10);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private boolean mWrapBefore;

        public class a implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LayoutParams[] newArray(int i10) {
                return new LayoutParams[i10];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setAlignSelf(int i10) {
            this.mAlignSelf = i10;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexBasisPercent(float f10) {
            this.mFlexBasisPercent = f10;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexGrow(float f10) {
            this.mFlexGrow = f10;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexShrink(float f10) {
            this.mFlexShrink = f10;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int i10) {
            ((ViewGroup.MarginLayoutParams) this).height = i10;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int i10) {
            this.mMaxHeight = i10;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int i10) {
            this.mMaxWidth = i10;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int i10) {
            this.mMinHeight = i10;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i10) {
            this.mMinWidth = i10;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setOrder(int i10) {
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int i10) {
            ((ViewGroup.MarginLayoutParams) this).width = i10;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWrapBefore(boolean z10) {
            this.mWrapBefore = z10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((RecyclerView.LayoutParams) layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }

        public LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f19404e = -1;
        this.f19407h = new ArrayList();
        this.f19408i = new com.google.android.flexbox.c(this);
        this.f19412m = new b();
        this.f19416q = -1;
        this.f19417r = Integer.MIN_VALUE;
        this.f19418s = Integer.MIN_VALUE;
        this.f19419t = Integer.MIN_VALUE;
        this.f19421v = new SparseArray<>();
        this.f19424y = -1;
        this.f19425z = new c.a();
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i10, i11);
        int i12 = properties.orientation;
        if (i12 != 0) {
            if (i12 == 1) {
                if (properties.reverseLayout) {
                    d0(3);
                } else {
                    d0(2);
                }
            }
        } else if (properties.reverseLayout) {
            d0(1);
        } else {
            d0(0);
        }
        e0(1);
        c0(4);
        this.f19422w = context;
    }
}
