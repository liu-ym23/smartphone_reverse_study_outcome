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
import com.google.android.flexbox.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements com.google.android.flexbox.a, RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* renamed from: A, reason: collision with root package name */
    private static final Rect f12020A = new Rect();

    /* renamed from: a, reason: collision with root package name */
    private int f12021a;

    /* renamed from: b, reason: collision with root package name */
    private int f12022b;

    /* renamed from: c, reason: collision with root package name */
    private int f12023c;

    /* renamed from: d, reason: collision with root package name */
    private int f12024d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f12026f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f12027g;

    /* renamed from: j, reason: collision with root package name */
    private RecyclerView.Recycler f12030j;

    /* renamed from: k, reason: collision with root package name */
    private RecyclerView.State f12031k;

    /* renamed from: l, reason: collision with root package name */
    private d f12032l;

    /* renamed from: n, reason: collision with root package name */
    private OrientationHelper f12034n;

    /* renamed from: o, reason: collision with root package name */
    private OrientationHelper f12035o;

    /* renamed from: p, reason: collision with root package name */
    private e f12036p;

    /* renamed from: u, reason: collision with root package name */
    private boolean f12041u;

    /* renamed from: w, reason: collision with root package name */
    private final Context f12043w;

    /* renamed from: x, reason: collision with root package name */
    private View f12044x;

    /* renamed from: e, reason: collision with root package name */
    private int f12025e = -1;

    /* renamed from: h, reason: collision with root package name */
    private List<com.google.android.flexbox.c> f12028h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private final com.google.android.flexbox.d f12029i = new com.google.android.flexbox.d(this);

    /* renamed from: m, reason: collision with root package name */
    private b f12033m = new b();

    /* renamed from: q, reason: collision with root package name */
    private int f12037q = -1;

    /* renamed from: r, reason: collision with root package name */
    private int f12038r = Integer.MIN_VALUE;

    /* renamed from: s, reason: collision with root package name */
    private int f12039s = Integer.MIN_VALUE;

    /* renamed from: t, reason: collision with root package name */
    private int f12040t = Integer.MIN_VALUE;

    /* renamed from: v, reason: collision with root package name */
    private SparseArray<View> f12042v = new SparseArray<>();

    /* renamed from: y, reason: collision with root package name */
    private int f12045y = -1;

    /* renamed from: z, reason: collision with root package name */
    private d.a f12046z = new d.a();

    private class b {

        /* renamed from: a, reason: collision with root package name */
        private int f12047a;

        /* renamed from: b, reason: collision with root package name */
        private int f12048b;

        /* renamed from: c, reason: collision with root package name */
        private int f12049c;

        /* renamed from: d, reason: collision with root package name */
        private int f12050d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f12051e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f12052f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f12053g;

        private b() {
            this.f12050d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q() {
            if (FlexboxLayoutManager.this.s() || !FlexboxLayoutManager.this.f12026f) {
                this.f12049c = this.f12051e ? FlexboxLayoutManager.this.f12034n.getEndAfterPadding() : FlexboxLayoutManager.this.f12034n.getStartAfterPadding();
            } else {
                this.f12049c = this.f12051e ? FlexboxLayoutManager.this.f12034n.getEndAfterPadding() : FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.f12034n.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(View view) {
            if (FlexboxLayoutManager.this.s() || !FlexboxLayoutManager.this.f12026f) {
                if (this.f12051e) {
                    this.f12049c = FlexboxLayoutManager.this.f12034n.getDecoratedEnd(view) + FlexboxLayoutManager.this.f12034n.getTotalSpaceChange();
                } else {
                    this.f12049c = FlexboxLayoutManager.this.f12034n.getDecoratedStart(view);
                }
            } else if (this.f12051e) {
                this.f12049c = FlexboxLayoutManager.this.f12034n.getDecoratedStart(view) + FlexboxLayoutManager.this.f12034n.getTotalSpaceChange();
            } else {
                this.f12049c = FlexboxLayoutManager.this.f12034n.getDecoratedEnd(view);
            }
            this.f12047a = FlexboxLayoutManager.this.getPosition(view);
            this.f12053g = false;
            int[] iArr = FlexboxLayoutManager.this.f12029i.f12094c;
            int i5 = this.f12047a;
            if (i5 == -1) {
                i5 = 0;
            }
            int i6 = iArr[i5];
            this.f12048b = i6 != -1 ? i6 : 0;
            if (FlexboxLayoutManager.this.f12028h.size() > this.f12048b) {
                this.f12047a = ((com.google.android.flexbox.c) FlexboxLayoutManager.this.f12028h.get(this.f12048b)).f12090o;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s() {
            this.f12047a = -1;
            this.f12048b = -1;
            this.f12049c = Integer.MIN_VALUE;
            this.f12052f = false;
            this.f12053g = false;
            if (FlexboxLayoutManager.this.s()) {
                if (FlexboxLayoutManager.this.f12022b == 0) {
                    this.f12051e = FlexboxLayoutManager.this.f12021a == 1;
                    return;
                } else {
                    this.f12051e = FlexboxLayoutManager.this.f12022b == 2;
                    return;
                }
            }
            if (FlexboxLayoutManager.this.f12022b == 0) {
                this.f12051e = FlexboxLayoutManager.this.f12021a == 3;
            } else {
                this.f12051e = FlexboxLayoutManager.this.f12022b == 2;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f12047a + ", mFlexLinePosition=" + this.f12048b + ", mCoordinate=" + this.f12049c + ", mPerpendicularCoordinate=" + this.f12050d + ", mLayoutFromEnd=" + this.f12051e + ", mValid=" + this.f12052f + ", mAssignedFromSavedState=" + this.f12053g + '}';
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        private int f12064a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f12065b;

        /* renamed from: c, reason: collision with root package name */
        private int f12066c;

        /* renamed from: d, reason: collision with root package name */
        private int f12067d;

        /* renamed from: e, reason: collision with root package name */
        private int f12068e;

        /* renamed from: f, reason: collision with root package name */
        private int f12069f;

        /* renamed from: g, reason: collision with root package name */
        private int f12070g;

        /* renamed from: h, reason: collision with root package name */
        private int f12071h;

        /* renamed from: i, reason: collision with root package name */
        private int f12072i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f12073j;

        private d() {
            this.f12071h = 1;
            this.f12072i = 1;
        }

        static /* synthetic */ int i(d dVar) {
            int i5 = dVar.f12066c;
            dVar.f12066c = i5 + 1;
            return i5;
        }

        static /* synthetic */ int j(d dVar) {
            int i5 = dVar.f12066c;
            dVar.f12066c = i5 - 1;
            return i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean w(RecyclerView.State state, List<com.google.android.flexbox.c> list) {
            int i5;
            int i6 = this.f12067d;
            return i6 >= 0 && i6 < state.getItemCount() && (i5 = this.f12066c) >= 0 && i5 < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.f12064a + ", mFlexLinePosition=" + this.f12066c + ", mPosition=" + this.f12067d + ", mOffset=" + this.f12068e + ", mScrollingOffset=" + this.f12069f + ", mLastScrollDelta=" + this.f12070g + ", mItemDirection=" + this.f12071h + ", mLayoutDirection=" + this.f12072i + '}';
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i5, int i6) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i5, i6);
        int i7 = properties.orientation;
        if (i7 != 0) {
            if (i7 == 1) {
                if (properties.reverseLayout) {
                    c0(3);
                } else {
                    c0(2);
                }
            }
        } else if (properties.reverseLayout) {
            c0(1);
        } else {
            c0(0);
        }
        d0(1);
        b0(4);
        setAutoMeasureEnabled(true);
        this.f12043w = context;
    }

    private boolean A(View view, int i5) {
        return (s() || !this.f12026f) ? this.f12034n.getDecoratedStart(view) >= this.f12034n.getEnd() - i5 : this.f12034n.getDecoratedEnd(view) <= i5;
    }

    private boolean B(View view, int i5) {
        return (s() || !this.f12026f) ? this.f12034n.getDecoratedEnd(view) <= i5 : this.f12034n.getEnd() - this.f12034n.getDecoratedStart(view) <= i5;
    }

    private void C() {
        this.f12028h.clear();
        this.f12033m.s();
        this.f12033m.f12050d = 0;
    }

    private void D() {
        if (this.f12034n != null) {
            return;
        }
        if (s()) {
            if (this.f12022b == 0) {
                this.f12034n = OrientationHelper.createHorizontalHelper(this);
                this.f12035o = OrientationHelper.createVerticalHelper(this);
                return;
            } else {
                this.f12034n = OrientationHelper.createVerticalHelper(this);
                this.f12035o = OrientationHelper.createHorizontalHelper(this);
                return;
            }
        }
        if (this.f12022b == 0) {
            this.f12034n = OrientationHelper.createVerticalHelper(this);
            this.f12035o = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.f12034n = OrientationHelper.createHorizontalHelper(this);
            this.f12035o = OrientationHelper.createVerticalHelper(this);
        }
    }

    private int E(RecyclerView.Recycler recycler, RecyclerView.State state, d dVar) {
        if (dVar.f12069f != Integer.MIN_VALUE) {
            if (dVar.f12064a < 0) {
                dVar.f12069f += dVar.f12064a;
            }
            W(recycler, dVar);
        }
        int i5 = dVar.f12064a;
        int iA = dVar.f12064a;
        boolean zS = s();
        int iT = 0;
        while (true) {
            if ((iA <= 0 && !this.f12032l.f12065b) || !dVar.w(state, this.f12028h)) {
                break;
            }
            com.google.android.flexbox.c cVar = this.f12028h.get(dVar.f12066c);
            dVar.f12067d = cVar.f12090o;
            iT += T(cVar, dVar);
            if (zS || !this.f12026f) {
                dVar.f12068e += cVar.a() * dVar.f12072i;
            } else {
                dVar.f12068e -= cVar.a() * dVar.f12072i;
            }
            iA -= cVar.a();
        }
        dVar.f12064a -= iT;
        if (dVar.f12069f != Integer.MIN_VALUE) {
            dVar.f12069f += iT;
            if (dVar.f12064a < 0) {
                dVar.f12069f += dVar.f12064a;
            }
            W(recycler, dVar);
        }
        return i5 - dVar.f12064a;
    }

    private View F(int i5) {
        View viewK = K(0, getChildCount(), i5);
        if (viewK == null) {
            return null;
        }
        int i6 = this.f12029i.f12094c[getPosition(viewK)];
        if (i6 == -1) {
            return null;
        }
        return G(viewK, this.f12028h.get(i6));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.view.View G(android.view.View r6, com.google.android.flexbox.c r7) {
        /*
            r5 = this;
            boolean r0 = r5.s()
            int r7 = r7.f12083h
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
            boolean r3 = r5.f12026f
            if (r3 == 0) goto L2d
            if (r0 != 0) goto L2d
            androidx.recyclerview.widget.OrientationHelper r3 = r5.f12034n
            int r3 = r3.getDecoratedEnd(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.f12034n
            int r4 = r4.getDecoratedEnd(r2)
            if (r3 >= r4) goto L3c
            goto L3b
        L2d:
            androidx.recyclerview.widget.OrientationHelper r3 = r5.f12034n
            int r3 = r3.getDecoratedStart(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.f12034n
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.G(android.view.View, com.google.android.flexbox.c):android.view.View");
    }

    private View H(int i5) {
        View viewK = K(getChildCount() - 1, -1, i5);
        if (viewK == null) {
            return null;
        }
        return I(viewK, this.f12028h.get(this.f12029i.f12094c[getPosition(viewK)]));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.view.View I(android.view.View r6, com.google.android.flexbox.c r7) {
        /*
            r5 = this;
            boolean r0 = r5.s()
            int r1 = r5.getChildCount()
            int r1 = r1 + (-2)
            int r2 = r5.getChildCount()
            int r7 = r7.f12083h
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
            boolean r3 = r5.f12026f
            if (r3 == 0) goto L39
            if (r0 != 0) goto L39
            androidx.recyclerview.widget.OrientationHelper r3 = r5.f12034n
            int r3 = r3.getDecoratedStart(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.f12034n
            int r4 = r4.getDecoratedStart(r7)
            if (r3 <= r4) goto L48
            goto L47
        L39:
            androidx.recyclerview.widget.OrientationHelper r3 = r5.f12034n
            int r3 = r3.getDecoratedEnd(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.f12034n
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.I(android.view.View, com.google.android.flexbox.c):android.view.View");
    }

    private View J(int i5, int i6, boolean z5) {
        int i7 = i6 > i5 ? 1 : -1;
        while (i5 != i6) {
            View childAt = getChildAt(i5);
            if (S(childAt, z5)) {
                return childAt;
            }
            i5 += i7;
        }
        return null;
    }

    private View K(int i5, int i6, int i7) {
        D();
        ensureLayoutState();
        int startAfterPadding = this.f12034n.getStartAfterPadding();
        int endAfterPadding = this.f12034n.getEndAfterPadding();
        int i8 = i6 > i5 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i5 != i6) {
            View childAt = getChildAt(i5);
            int position = getPosition(childAt);
            if (position >= 0 && position < i7) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.f12034n.getDecoratedStart(childAt) >= startAfterPadding && this.f12034n.getDecoratedEnd(childAt) <= endAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i5 += i8;
        }
        return view != null ? view : view2;
    }

    private int L(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    private int M(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    private int N(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    private int O(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    private int Q(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i5 == 0) {
            return 0;
        }
        D();
        int i6 = 1;
        this.f12032l.f12073j = true;
        boolean z5 = !s() && this.f12026f;
        if (!z5 ? i5 <= 0 : i5 >= 0) {
            i6 = -1;
        }
        int iAbs = Math.abs(i5);
        j0(i6, iAbs);
        int iE = this.f12032l.f12069f + E(recycler, state, this.f12032l);
        if (iE < 0) {
            return 0;
        }
        if (z5) {
            if (iAbs > iE) {
                i5 = (-i6) * iE;
            }
        } else if (iAbs > iE) {
            i5 = i6 * iE;
        }
        this.f12034n.offsetChildren(-i5);
        this.f12032l.f12070g = i5;
        return i5;
    }

    private int R(int i5) {
        if (getChildCount() == 0 || i5 == 0) {
            return 0;
        }
        D();
        boolean zS = s();
        View view = this.f12044x;
        int width = zS ? view.getWidth() : view.getHeight();
        int width2 = zS ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int iAbs = Math.abs(i5);
            if (i5 < 0) {
                return -Math.min((width2 + this.f12033m.f12050d) - width, iAbs);
            }
            if (this.f12033m.f12050d + i5 > 0) {
                return -this.f12033m.f12050d;
            }
        } else {
            if (i5 > 0) {
                return Math.min((width2 - this.f12033m.f12050d) - width, i5);
            }
            if (this.f12033m.f12050d + i5 < 0) {
                return -this.f12033m.f12050d;
            }
        }
        return i5;
    }

    private boolean S(View view, boolean z5) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int iM = M(view);
        int iO = O(view);
        int iN = N(view);
        int iL = L(view);
        return z5 ? (paddingLeft <= iM && width >= iN) && (paddingTop <= iO && height >= iL) : (iM >= width || iN >= paddingLeft) && (iO >= height || iL >= paddingTop);
    }

    private int T(com.google.android.flexbox.c cVar, d dVar) {
        return s() ? U(cVar, dVar) : V(cVar, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int U(com.google.android.flexbox.c r19, com.google.android.flexbox.FlexboxLayoutManager.d r20) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.U(com.google.android.flexbox.c, com.google.android.flexbox.FlexboxLayoutManager$d):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int V(com.google.android.flexbox.c r21, com.google.android.flexbox.FlexboxLayoutManager.d r22) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.V(com.google.android.flexbox.c, com.google.android.flexbox.FlexboxLayoutManager$d):int");
    }

    private void W(RecyclerView.Recycler recycler, d dVar) {
        if (dVar.f12073j) {
            if (dVar.f12072i == -1) {
                X(recycler, dVar);
            } else {
                Y(recycler, dVar);
            }
        }
    }

    private void X(RecyclerView.Recycler recycler, d dVar) {
        if (dVar.f12069f < 0) {
            return;
        }
        this.f12034n.getEnd();
        int unused = dVar.f12069f;
        int childCount = getChildCount();
        if (childCount == 0) {
            return;
        }
        int i5 = childCount - 1;
        int i6 = this.f12029i.f12094c[getPosition(getChildAt(i5))];
        if (i6 == -1) {
            return;
        }
        com.google.android.flexbox.c cVar = this.f12028h.get(i6);
        int i7 = i5;
        while (true) {
            if (i7 < 0) {
                break;
            }
            View childAt = getChildAt(i7);
            if (!A(childAt, dVar.f12069f)) {
                break;
            }
            if (cVar.f12090o == getPosition(childAt)) {
                if (i6 <= 0) {
                    childCount = i7;
                    break;
                } else {
                    i6 += dVar.f12072i;
                    cVar = this.f12028h.get(i6);
                    childCount = i7;
                }
            }
            i7--;
        }
        recycleChildren(recycler, childCount, i5);
    }

    private void Y(RecyclerView.Recycler recycler, d dVar) {
        int childCount;
        if (dVar.f12069f >= 0 && (childCount = getChildCount()) != 0) {
            int i5 = this.f12029i.f12094c[getPosition(getChildAt(0))];
            int i6 = -1;
            if (i5 == -1) {
                return;
            }
            com.google.android.flexbox.c cVar = this.f12028h.get(i5);
            int i7 = 0;
            while (true) {
                if (i7 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i7);
                if (!B(childAt, dVar.f12069f)) {
                    break;
                }
                if (cVar.f12091p == getPosition(childAt)) {
                    if (i5 >= this.f12028h.size() - 1) {
                        i6 = i7;
                        break;
                    } else {
                        i5 += dVar.f12072i;
                        cVar = this.f12028h.get(i5);
                        i6 = i7;
                    }
                }
                i7++;
            }
            recycleChildren(recycler, 0, i6);
        }
    }

    private void Z() {
        int heightMode = s() ? getHeightMode() : getWidthMode();
        this.f12032l.f12065b = heightMode == 0 || heightMode == Integer.MIN_VALUE;
    }

    private void a0() {
        int layoutDirection = getLayoutDirection();
        int i5 = this.f12021a;
        if (i5 == 0) {
            this.f12026f = layoutDirection == 1;
            this.f12027g = this.f12022b == 2;
            return;
        }
        if (i5 == 1) {
            this.f12026f = layoutDirection != 1;
            this.f12027g = this.f12022b == 2;
            return;
        }
        if (i5 == 2) {
            boolean z5 = layoutDirection == 1;
            this.f12026f = z5;
            if (this.f12022b == 2) {
                this.f12026f = !z5;
            }
            this.f12027g = false;
            return;
        }
        if (i5 != 3) {
            this.f12026f = false;
            this.f12027g = false;
            return;
        }
        boolean z6 = layoutDirection == 1;
        this.f12026f = z6;
        if (this.f12022b == 2) {
            this.f12026f = !z6;
        }
        this.f12027g = true;
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        D();
        View viewF = F(itemCount);
        View viewH = H(itemCount);
        if (state.getItemCount() == 0 || viewF == null || viewH == null) {
            return 0;
        }
        return Math.min(this.f12034n.getTotalSpace(), this.f12034n.getDecoratedEnd(viewH) - this.f12034n.getDecoratedStart(viewF));
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewF = F(itemCount);
        View viewH = H(itemCount);
        if (state.getItemCount() != 0 && viewF != null && viewH != null) {
            int position = getPosition(viewF);
            int position2 = getPosition(viewH);
            int iAbs = Math.abs(this.f12034n.getDecoratedEnd(viewH) - this.f12034n.getDecoratedStart(viewF));
            int i5 = this.f12029i.f12094c[position];
            if (i5 != 0 && i5 != -1) {
                return Math.round((i5 * (iAbs / ((r4[position2] - i5) + 1))) + (this.f12034n.getStartAfterPadding() - this.f12034n.getDecoratedStart(viewF)));
            }
        }
        return 0;
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewF = F(itemCount);
        View viewH = H(itemCount);
        if (state.getItemCount() == 0 || viewF == null || viewH == null) {
            return 0;
        }
        int iFindFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((Math.abs(this.f12034n.getDecoratedEnd(viewH) - this.f12034n.getDecoratedStart(viewF)) / ((findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1)) * state.getItemCount());
    }

    private boolean e0(RecyclerView.State state, b bVar) {
        if (getChildCount() == 0) {
            return false;
        }
        View viewH = bVar.f12051e ? H(state.getItemCount()) : F(state.getItemCount());
        if (viewH == null) {
            return false;
        }
        bVar.r(viewH);
        if (state.isPreLayout() || !supportsPredictiveItemAnimations()) {
            return true;
        }
        if (this.f12034n.getDecoratedStart(viewH) < this.f12034n.getEndAfterPadding() && this.f12034n.getDecoratedEnd(viewH) >= this.f12034n.getStartAfterPadding()) {
            return true;
        }
        bVar.f12049c = bVar.f12051e ? this.f12034n.getEndAfterPadding() : this.f12034n.getStartAfterPadding();
        return true;
    }

    private void ensureLayoutState() {
        if (this.f12032l == null) {
            this.f12032l = new d();
        }
    }

    private boolean f0(RecyclerView.State state, b bVar, e eVar) {
        int i5;
        if (!state.isPreLayout() && (i5 = this.f12037q) != -1) {
            if (i5 >= 0 && i5 < state.getItemCount()) {
                bVar.f12047a = this.f12037q;
                bVar.f12048b = this.f12029i.f12094c[bVar.f12047a];
                e eVar2 = this.f12036p;
                if (eVar2 != null && eVar2.F(state.getItemCount())) {
                    bVar.f12049c = this.f12034n.getStartAfterPadding() + eVar.f12075b;
                    bVar.f12053g = true;
                    bVar.f12048b = -1;
                    return true;
                }
                if (this.f12038r != Integer.MIN_VALUE) {
                    if (s() || !this.f12026f) {
                        bVar.f12049c = this.f12034n.getStartAfterPadding() + this.f12038r;
                    } else {
                        bVar.f12049c = this.f12038r - this.f12034n.getEndPadding();
                    }
                    return true;
                }
                View viewFindViewByPosition = findViewByPosition(this.f12037q);
                if (viewFindViewByPosition == null) {
                    if (getChildCount() > 0) {
                        bVar.f12051e = this.f12037q < getPosition(getChildAt(0));
                    }
                    bVar.q();
                } else {
                    if (this.f12034n.getDecoratedMeasurement(viewFindViewByPosition) > this.f12034n.getTotalSpace()) {
                        bVar.q();
                        return true;
                    }
                    if (this.f12034n.getDecoratedStart(viewFindViewByPosition) - this.f12034n.getStartAfterPadding() < 0) {
                        bVar.f12049c = this.f12034n.getStartAfterPadding();
                        bVar.f12051e = false;
                        return true;
                    }
                    if (this.f12034n.getEndAfterPadding() - this.f12034n.getDecoratedEnd(viewFindViewByPosition) < 0) {
                        bVar.f12049c = this.f12034n.getEndAfterPadding();
                        bVar.f12051e = true;
                        return true;
                    }
                    bVar.f12049c = bVar.f12051e ? this.f12034n.getDecoratedEnd(viewFindViewByPosition) + this.f12034n.getTotalSpaceChange() : this.f12034n.getDecoratedStart(viewFindViewByPosition);
                }
                return true;
            }
            this.f12037q = -1;
            this.f12038r = Integer.MIN_VALUE;
        }
        return false;
    }

    private int fixLayoutEndGap(int i5, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z5) {
        int iQ;
        int endAfterPadding;
        if (s() || !this.f12026f) {
            int endAfterPadding2 = this.f12034n.getEndAfterPadding() - i5;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            iQ = -Q(-endAfterPadding2, recycler, state);
        } else {
            int startAfterPadding = i5 - this.f12034n.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            iQ = Q(startAfterPadding, recycler, state);
        }
        int i6 = i5 + iQ;
        if (!z5 || (endAfterPadding = this.f12034n.getEndAfterPadding() - i6) <= 0) {
            return iQ;
        }
        this.f12034n.offsetChildren(endAfterPadding);
        return endAfterPadding + iQ;
    }

    private int fixLayoutStartGap(int i5, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z5) {
        int iQ;
        int startAfterPadding;
        if (s() || !this.f12026f) {
            int startAfterPadding2 = i5 - this.f12034n.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            iQ = -Q(startAfterPadding2, recycler, state);
        } else {
            int endAfterPadding = this.f12034n.getEndAfterPadding() - i5;
            if (endAfterPadding <= 0) {
                return 0;
            }
            iQ = Q(-endAfterPadding, recycler, state);
        }
        int i6 = i5 + iQ;
        if (!z5 || (startAfterPadding = i6 - this.f12034n.getStartAfterPadding()) <= 0) {
            return iQ;
        }
        this.f12034n.offsetChildren(-startAfterPadding);
        return iQ - startAfterPadding;
    }

    private void g0(RecyclerView.State state, b bVar) {
        if (f0(state, bVar, this.f12036p) || e0(state, bVar)) {
            return;
        }
        bVar.q();
        bVar.f12047a = 0;
        bVar.f12048b = 0;
    }

    private View getChildClosestToStart() {
        return getChildAt(0);
    }

    private void h0(int i5) {
        int iFindFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i5 >= iFindLastVisibleItemPosition) {
            return;
        }
        int childCount = getChildCount();
        this.f12029i.m(childCount);
        this.f12029i.n(childCount);
        this.f12029i.l(childCount);
        if (i5 >= this.f12029i.f12094c.length) {
            return;
        }
        this.f12045y = i5;
        View childClosestToStart = getChildClosestToStart();
        if (childClosestToStart == null) {
            return;
        }
        if (iFindFirstVisibleItemPosition > i5 || i5 > iFindLastVisibleItemPosition) {
            this.f12037q = getPosition(childClosestToStart);
            if (s() || !this.f12026f) {
                this.f12038r = this.f12034n.getDecoratedStart(childClosestToStart) - this.f12034n.getStartAfterPadding();
            } else {
                this.f12038r = this.f12034n.getDecoratedEnd(childClosestToStart) + this.f12034n.getEndPadding();
            }
        }
    }

    private void i0(int i5) {
        int i6;
        int i7;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        boolean z5 = false;
        if (s()) {
            int i8 = this.f12039s;
            if (i8 != Integer.MIN_VALUE && i8 != width) {
                z5 = true;
            }
            i6 = this.f12032l.f12065b ? this.f12043w.getResources().getDisplayMetrics().heightPixels : this.f12032l.f12064a;
        } else {
            int i9 = this.f12040t;
            if (i9 != Integer.MIN_VALUE && i9 != height) {
                z5 = true;
            }
            i6 = this.f12032l.f12065b ? this.f12043w.getResources().getDisplayMetrics().widthPixels : this.f12032l.f12064a;
        }
        int i10 = i6;
        this.f12039s = width;
        this.f12040t = height;
        int i11 = this.f12045y;
        if (i11 == -1 && (this.f12037q != -1 || z5)) {
            if (this.f12033m.f12051e) {
                return;
            }
            this.f12028h.clear();
            this.f12046z.a();
            if (s()) {
                this.f12029i.d(this.f12046z, iMakeMeasureSpec, iMakeMeasureSpec2, i10, this.f12033m.f12047a, this.f12028h);
            } else {
                this.f12029i.f(this.f12046z, iMakeMeasureSpec, iMakeMeasureSpec2, i10, this.f12033m.f12047a, this.f12028h);
            }
            this.f12028h = this.f12046z.f12097a;
            this.f12029i.i(iMakeMeasureSpec, iMakeMeasureSpec2);
            this.f12029i.N();
            b bVar = this.f12033m;
            bVar.f12048b = this.f12029i.f12094c[bVar.f12047a];
            this.f12032l.f12066c = this.f12033m.f12048b;
            return;
        }
        int iMin = i11 != -1 ? Math.min(i11, this.f12033m.f12047a) : this.f12033m.f12047a;
        this.f12046z.a();
        if (!s()) {
            i7 = iMin;
            if (this.f12028h.size() > 0) {
                this.f12029i.h(this.f12028h, i7);
                iMin = i7;
                this.f12029i.b(this.f12046z, iMakeMeasureSpec2, iMakeMeasureSpec, i10, iMin, this.f12033m.f12047a, this.f12028h);
                iMakeMeasureSpec2 = iMakeMeasureSpec2;
                iMakeMeasureSpec = iMakeMeasureSpec;
                i7 = iMin;
            } else {
                this.f12029i.l(i5);
                this.f12029i.e(this.f12046z, iMakeMeasureSpec, iMakeMeasureSpec2, i10, 0, this.f12028h);
            }
        } else if (this.f12028h.size() > 0) {
            this.f12029i.h(this.f12028h, iMin);
            this.f12029i.b(this.f12046z, iMakeMeasureSpec, iMakeMeasureSpec2, i10, iMin, this.f12033m.f12047a, this.f12028h);
            i7 = iMin;
        } else {
            i7 = iMin;
            this.f12029i.l(i5);
            this.f12029i.c(this.f12046z, iMakeMeasureSpec, iMakeMeasureSpec2, i10, 0, this.f12028h);
        }
        this.f12028h = this.f12046z.f12097a;
        this.f12029i.j(iMakeMeasureSpec, iMakeMeasureSpec2, i7);
        this.f12029i.O(i7);
    }

    private static boolean isMeasurementUpToDate(int i5, int i6, int i7) {
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        if (i7 > 0 && i5 != i7) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i5;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i5;
        }
        return true;
    }

    private void j0(int i5, int i6) {
        this.f12032l.f12072i = i5;
        boolean zS = s();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z5 = !zS && this.f12026f;
        if (i5 == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.f12032l.f12068e = this.f12034n.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View viewI = I(childAt, this.f12028h.get(this.f12029i.f12094c[position]));
            this.f12032l.f12071h = 1;
            d dVar = this.f12032l;
            dVar.f12067d = position + dVar.f12071h;
            if (this.f12029i.f12094c.length <= this.f12032l.f12067d) {
                this.f12032l.f12066c = -1;
            } else {
                d dVar2 = this.f12032l;
                dVar2.f12066c = this.f12029i.f12094c[dVar2.f12067d];
            }
            if (z5) {
                this.f12032l.f12068e = this.f12034n.getDecoratedStart(viewI);
                this.f12032l.f12069f = (-this.f12034n.getDecoratedStart(viewI)) + this.f12034n.getStartAfterPadding();
                d dVar3 = this.f12032l;
                dVar3.f12069f = dVar3.f12069f >= 0 ? this.f12032l.f12069f : 0;
            } else {
                this.f12032l.f12068e = this.f12034n.getDecoratedEnd(viewI);
                this.f12032l.f12069f = this.f12034n.getDecoratedEnd(viewI) - this.f12034n.getEndAfterPadding();
            }
            if ((this.f12032l.f12066c == -1 || this.f12032l.f12066c > this.f12028h.size() - 1) && this.f12032l.f12067d <= c()) {
                int i7 = i6 - this.f12032l.f12069f;
                this.f12046z.a();
                if (i7 > 0) {
                    if (zS) {
                        this.f12029i.c(this.f12046z, iMakeMeasureSpec, iMakeMeasureSpec2, i7, this.f12032l.f12067d, this.f12028h);
                    } else {
                        this.f12029i.e(this.f12046z, iMakeMeasureSpec, iMakeMeasureSpec2, i7, this.f12032l.f12067d, this.f12028h);
                    }
                    this.f12029i.j(iMakeMeasureSpec, iMakeMeasureSpec2, this.f12032l.f12067d);
                    this.f12029i.O(this.f12032l.f12067d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.f12032l.f12068e = this.f12034n.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View viewG = G(childAt2, this.f12028h.get(this.f12029i.f12094c[position2]));
            this.f12032l.f12071h = 1;
            int i8 = this.f12029i.f12094c[position2];
            if (i8 == -1) {
                i8 = 0;
            }
            if (i8 > 0) {
                this.f12032l.f12067d = position2 - this.f12028h.get(i8 - 1).b();
            } else {
                this.f12032l.f12067d = -1;
            }
            this.f12032l.f12066c = i8 > 0 ? i8 - 1 : 0;
            if (z5) {
                this.f12032l.f12068e = this.f12034n.getDecoratedEnd(viewG);
                this.f12032l.f12069f = this.f12034n.getDecoratedEnd(viewG) - this.f12034n.getEndAfterPadding();
                d dVar4 = this.f12032l;
                dVar4.f12069f = dVar4.f12069f >= 0 ? this.f12032l.f12069f : 0;
            } else {
                this.f12032l.f12068e = this.f12034n.getDecoratedStart(viewG);
                this.f12032l.f12069f = (-this.f12034n.getDecoratedStart(viewG)) + this.f12034n.getStartAfterPadding();
            }
        }
        d dVar5 = this.f12032l;
        dVar5.f12064a = i6 - dVar5.f12069f;
    }

    private void k0(b bVar, boolean z5, boolean z6) {
        if (z6) {
            Z();
        } else {
            this.f12032l.f12065b = false;
        }
        if (s() || !this.f12026f) {
            this.f12032l.f12064a = this.f12034n.getEndAfterPadding() - bVar.f12049c;
        } else {
            this.f12032l.f12064a = bVar.f12049c - getPaddingRight();
        }
        this.f12032l.f12067d = bVar.f12047a;
        this.f12032l.f12071h = 1;
        this.f12032l.f12072i = 1;
        this.f12032l.f12068e = bVar.f12049c;
        this.f12032l.f12069f = Integer.MIN_VALUE;
        this.f12032l.f12066c = bVar.f12048b;
        if (!z5 || this.f12028h.size() <= 1 || bVar.f12048b < 0 || bVar.f12048b >= this.f12028h.size() - 1) {
            return;
        }
        com.google.android.flexbox.c cVar = this.f12028h.get(bVar.f12048b);
        d.i(this.f12032l);
        this.f12032l.f12067d += cVar.b();
    }

    private void l0(b bVar, boolean z5, boolean z6) {
        if (z6) {
            Z();
        } else {
            this.f12032l.f12065b = false;
        }
        if (s() || !this.f12026f) {
            this.f12032l.f12064a = bVar.f12049c - this.f12034n.getStartAfterPadding();
        } else {
            this.f12032l.f12064a = (this.f12044x.getWidth() - bVar.f12049c) - this.f12034n.getStartAfterPadding();
        }
        this.f12032l.f12067d = bVar.f12047a;
        this.f12032l.f12071h = 1;
        this.f12032l.f12072i = -1;
        this.f12032l.f12068e = bVar.f12049c;
        this.f12032l.f12069f = Integer.MIN_VALUE;
        this.f12032l.f12066c = bVar.f12048b;
        if (!z5 || bVar.f12048b <= 0 || this.f12028h.size() <= bVar.f12048b) {
            return;
        }
        com.google.android.flexbox.c cVar = this.f12028h.get(bVar.f12048b);
        d.j(this.f12032l);
        this.f12032l.f12067d -= cVar.b();
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i5, int i6) {
        while (i6 >= i5) {
            removeAndRecycleViewAt(i6, recycler);
            i6--;
        }
    }

    private boolean shouldMeasureChild(View view, int i5, int i6, RecyclerView.LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i5, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i6, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
    }

    public View P(int i5) {
        View view = this.f12042v.get(i5);
        return view != null ? view : this.f12030j.getViewForPosition(i5);
    }

    public void b0(int i5) {
        int i6 = this.f12024d;
        if (i6 != i5) {
            if (i6 == 4 || i5 == 4) {
                removeAllViews();
                C();
            }
            this.f12024d = i5;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int c() {
        return this.f12031k.getItemCount();
    }

    public void c0(int i5) {
        if (this.f12021a != i5) {
            removeAllViews();
            this.f12021a = i5;
            this.f12034n = null;
            this.f12035o = null;
            C();
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return !s() || getWidth() > this.f12044x.getWidth();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return s() || getHeight() > this.f12044x.getHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        computeScrollOffset(state);
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i5) {
        if (getChildCount() == 0) {
            return null;
        }
        int i6 = i5 < getPosition(getChildAt(0)) ? -1 : 1;
        return s() ? new PointF(0.0f, i6) : new PointF(i6, 0.0f);
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
    public void d(View view, int i5, int i6, com.google.android.flexbox.c cVar) {
        calculateItemDecorationsForChild(view, f12020A);
        if (s()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            cVar.f12080e += leftDecorationWidth;
            cVar.f12081f += leftDecorationWidth;
        } else {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            cVar.f12080e += topDecorationHeight;
            cVar.f12081f += topDecorationHeight;
        }
    }

    public void d0(int i5) {
        if (i5 == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i6 = this.f12022b;
        if (i6 != i5) {
            if (i6 == 0 || i5 == 0) {
                removeAllViews();
                C();
            }
            this.f12022b = i5;
            this.f12034n = null;
            this.f12035o = null;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int e() {
        return this.f12021a;
    }

    @Override // com.google.android.flexbox.a
    public int f() {
        return this.f12025e;
    }

    public int findFirstVisibleItemPosition() {
        View viewJ = J(0, getChildCount(), false);
        if (viewJ == null) {
            return -1;
        }
        return getPosition(viewJ);
    }

    public int findLastVisibleItemPosition() {
        View viewJ = J(getChildCount() - 1, -1, false);
        if (viewJ == null) {
            return -1;
        }
        return getPosition(viewJ);
    }

    @Override // com.google.android.flexbox.a
    public int g() {
        if (this.f12028h.size() == 0) {
            return 0;
        }
        int size = this.f12028h.size();
        int iMax = Integer.MIN_VALUE;
        for (int i5 = 0; i5 < size; i5++) {
            iMax = Math.max(iMax, this.f12028h.get(i5).f12080e);
        }
        return iMax;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // com.google.android.flexbox.a
    public int h() {
        return this.f12022b;
    }

    @Override // com.google.android.flexbox.a
    public void i(com.google.android.flexbox.c cVar) {
    }

    @Override // com.google.android.flexbox.a
    public View j(int i5) {
        return P(i5);
    }

    @Override // com.google.android.flexbox.a
    public int k(int i5, int i6, int i7) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i6, i7, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.a
    public int l() {
        return this.f12024d;
    }

    @Override // com.google.android.flexbox.a
    public void m(int i5, View view) {
        this.f12042v.put(i5, view);
    }

    @Override // com.google.android.flexbox.a
    public int n(View view, int i5, int i6) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (s()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f12044x = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.f12041u) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i5, int i6) {
        super.onItemsAdded(recyclerView, i5, i6);
        h0(i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i5, int i6, int i7) {
        super.onItemsMoved(recyclerView, i5, i6, i7);
        h0(Math.min(i5, i6));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i5, int i6) {
        super.onItemsRemoved(recyclerView, i5, i6);
        h0(i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i5, int i6, Object obj) {
        super.onItemsUpdated(recyclerView, i5, i6, obj);
        h0(i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i5;
        int i6;
        this.f12030j = recycler;
        this.f12031k = state;
        int itemCount = state.getItemCount();
        if (itemCount == 0 && state.isPreLayout()) {
            return;
        }
        a0();
        D();
        ensureLayoutState();
        this.f12029i.m(itemCount);
        this.f12029i.n(itemCount);
        this.f12029i.l(itemCount);
        this.f12032l.f12073j = false;
        e eVar = this.f12036p;
        if (eVar != null && eVar.F(itemCount)) {
            this.f12037q = this.f12036p.f12074a;
        }
        if (!this.f12033m.f12052f || this.f12037q != -1 || this.f12036p != null) {
            this.f12033m.s();
            g0(state, this.f12033m);
            this.f12033m.f12052f = true;
        }
        detachAndScrapAttachedViews(recycler);
        if (this.f12033m.f12051e) {
            l0(this.f12033m, false, true);
        } else {
            k0(this.f12033m, false, true);
        }
        i0(itemCount);
        if (this.f12033m.f12051e) {
            E(recycler, state, this.f12032l);
            i6 = this.f12032l.f12068e;
            k0(this.f12033m, true, false);
            E(recycler, state, this.f12032l);
            i5 = this.f12032l.f12068e;
        } else {
            E(recycler, state, this.f12032l);
            i5 = this.f12032l.f12068e;
            l0(this.f12033m, true, false);
            E(recycler, state, this.f12032l);
            i6 = this.f12032l.f12068e;
        }
        if (getChildCount() > 0) {
            if (this.f12033m.f12051e) {
                fixLayoutStartGap(i6 + fixLayoutEndGap(i5, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i5 + fixLayoutStartGap(i6, recycler, state, true), recycler, state, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f12036p = null;
        this.f12037q = -1;
        this.f12038r = Integer.MIN_VALUE;
        this.f12045y = -1;
        this.f12033m.s();
        this.f12042v.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.f12036p = (e) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.f12036p != null) {
            return new e(this.f12036p);
        }
        e eVar = new e();
        if (getChildCount() <= 0) {
            eVar.G();
            return eVar;
        }
        View childClosestToStart = getChildClosestToStart();
        eVar.f12074a = getPosition(childClosestToStart);
        eVar.f12075b = this.f12034n.getDecoratedStart(childClosestToStart) - this.f12034n.getStartAfterPadding();
        return eVar;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.c> p() {
        return this.f12028h;
    }

    @Override // com.google.android.flexbox.a
    public int q(int i5, int i6, int i7) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i6, i7, canScrollVertically());
    }

    @Override // com.google.android.flexbox.a
    public boolean s() {
        int i5 = this.f12021a;
        return i5 == 0 || i5 == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!s()) {
            int iQ = Q(i5, recycler, state);
            this.f12042v.clear();
            return iQ;
        }
        int iR = R(i5);
        this.f12033m.f12050d += iR;
        this.f12035o.offsetChildren(-iR);
        return iR;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i5) {
        this.f12037q = i5;
        this.f12038r = Integer.MIN_VALUE;
        e eVar = this.f12036p;
        if (eVar != null) {
            eVar.G();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (s()) {
            int iQ = Q(i5, recycler, state);
            this.f12042v.clear();
            return iQ;
        }
        int iR = R(i5);
        this.f12033m.f12050d += iR;
        this.f12035o.offsetChildren(-iR);
        return iR;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i5) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i5);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // com.google.android.flexbox.a
    public int t(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (s()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    private static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private int f12074a;

        /* renamed from: b, reason: collision with root package name */
        private int f12075b;

        static class a implements Parcelable.Creator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i5) {
                return new e[i5];
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean F(int i5) {
            int i6 = this.f12074a;
            return i6 >= 0 && i6 < i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void G() {
            this.f12074a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.f12074a + ", mAnchorOffset=" + this.f12075b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeInt(this.f12074a);
            parcel.writeInt(this.f12075b);
        }

        e() {
        }

        private e(Parcel parcel) {
            this.f12074a = parcel.readInt();
            this.f12075b = parcel.readInt();
        }

        private e(e eVar) {
            this.f12074a = eVar.f12074a;
            this.f12075b = eVar.f12075b;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i5, int i6) {
        super.onItemsUpdated(recyclerView, i5, i6);
        h0(i5);
    }

    public static class c extends RecyclerView.LayoutParams implements com.google.android.flexbox.b {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private float f12055a;

        /* renamed from: b, reason: collision with root package name */
        private float f12056b;

        /* renamed from: c, reason: collision with root package name */
        private int f12057c;

        /* renamed from: d, reason: collision with root package name */
        private float f12058d;

        /* renamed from: e, reason: collision with root package name */
        private int f12059e;

        /* renamed from: f, reason: collision with root package name */
        private int f12060f;

        /* renamed from: g, reason: collision with root package name */
        private int f12061g;

        /* renamed from: h, reason: collision with root package name */
        private int f12062h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f12063i;

        static class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i5) {
                return new c[i5];
            }
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12055a = 0.0f;
            this.f12056b = 1.0f;
            this.f12057c = -1;
            this.f12058d = -1.0f;
            this.f12061g = 16777215;
            this.f12062h = 16777215;
        }

        @Override // com.google.android.flexbox.b
        public int E() {
            return this.f12061g;
        }

        @Override // com.google.android.flexbox.b
        public int d() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.b
        public int g() {
            return this.f12057c;
        }

        @Override // com.google.android.flexbox.b
        public float h() {
            return this.f12056b;
        }

        @Override // com.google.android.flexbox.b
        public int i() {
            return this.f12059e;
        }

        @Override // com.google.android.flexbox.b
        public int j() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.b
        public int k() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.b
        public int l() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.b
        public int n() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.b
        public float p() {
            return this.f12055a;
        }

        @Override // com.google.android.flexbox.b
        public float s() {
            return this.f12058d;
        }

        @Override // com.google.android.flexbox.b
        public int v() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeFloat(this.f12055a);
            parcel.writeFloat(this.f12056b);
            parcel.writeInt(this.f12057c);
            parcel.writeFloat(this.f12058d);
            parcel.writeInt(this.f12059e);
            parcel.writeInt(this.f12060f);
            parcel.writeInt(this.f12061g);
            parcel.writeInt(this.f12062h);
            parcel.writeByte(this.f12063i ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.b
        public int x() {
            return this.f12060f;
        }

        @Override // com.google.android.flexbox.b
        public boolean y() {
            return this.f12063i;
        }

        @Override // com.google.android.flexbox.b
        public int z() {
            return this.f12062h;
        }

        public c(int i5, int i6) {
            super(i5, i6);
            this.f12055a = 0.0f;
            this.f12056b = 1.0f;
            this.f12057c = -1;
            this.f12058d = -1.0f;
            this.f12061g = 16777215;
            this.f12062h = 16777215;
        }

        protected c(Parcel parcel) {
            super(-2, -2);
            this.f12055a = 0.0f;
            this.f12056b = 1.0f;
            this.f12057c = -1;
            this.f12058d = -1.0f;
            this.f12061g = 16777215;
            this.f12062h = 16777215;
            this.f12055a = parcel.readFloat();
            this.f12056b = parcel.readFloat();
            this.f12057c = parcel.readInt();
            this.f12058d = parcel.readFloat();
            this.f12059e = parcel.readInt();
            this.f12060f = parcel.readInt();
            this.f12061g = parcel.readInt();
            this.f12062h = parcel.readInt();
            this.f12063i = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
