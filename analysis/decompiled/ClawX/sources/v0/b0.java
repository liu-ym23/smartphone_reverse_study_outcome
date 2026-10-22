package v0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    public a4.d f5792a;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f5793b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.emoji2.text.p f5794c;
    public final androidx.emoji2.text.p d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5795e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f5796f;

    /* renamed from: g, reason: collision with root package name */
    public int f5797g;

    /* renamed from: h, reason: collision with root package name */
    public int f5798h;

    /* renamed from: i, reason: collision with root package name */
    public int f5799i;

    /* renamed from: j, reason: collision with root package name */
    public int f5800j;

    public b0() {
        a0 a0Var = new a0(this, 0);
        a0 a0Var2 = new a0(this, 1);
        this.f5794c = new androidx.emoji2.text.p(a0Var);
        this.d = new androidx.emoji2.text.p(a0Var2);
        this.f5795e = false;
        this.f5796f = true;
    }

    public static int A(View view) {
        ((c0) view.getLayoutParams()).getClass();
        throw null;
    }

    public static o B(Context context, AttributeSet attributeSet, int i8, int i9) {
        o oVar = new o(1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u0.a.f5615a, i8, i9);
        oVar.f5900b = typedArrayObtainStyledAttributes.getInt(0, 1);
        oVar.f5901c = typedArrayObtainStyledAttributes.getInt(10, 1);
        oVar.d = typedArrayObtainStyledAttributes.getBoolean(9, false);
        oVar.f5902e = typedArrayObtainStyledAttributes.getBoolean(11, false);
        typedArrayObtainStyledAttributes.recycle();
        return oVar;
    }

    public static boolean F(int i8, int i9, int i10) {
        int mode = View.MeasureSpec.getMode(i9);
        int size = View.MeasureSpec.getSize(i9);
        if (i10 > 0 && i8 != i10) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i8;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i8;
        }
        return true;
    }

    public static void G(View view, int i8, int i9, int i10, int i11) {
        c0 c0Var = (c0) view.getLayoutParams();
        Rect rect = c0Var.f5804a;
        view.layout(i8 + rect.left + ((ViewGroup.MarginLayoutParams) c0Var).leftMargin, i9 + rect.top + ((ViewGroup.MarginLayoutParams) c0Var).topMargin, (i10 - rect.right) - ((ViewGroup.MarginLayoutParams) c0Var).rightMargin, (i11 - rect.bottom) - ((ViewGroup.MarginLayoutParams) c0Var).bottomMargin);
    }

    public static int f(int i8, int i9, int i10) {
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i9, i10) : size : Math.min(size, Math.max(i9, i10));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int r(boolean r4, int r5, int r6, int r7, int r8) {
        /*
            int r5 = r5 - r7
            r7 = 0
            int r5 = java.lang.Math.max(r7, r5)
            r0 = -2
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r4 == 0) goto L1d
            if (r8 < 0) goto L12
        L10:
            r6 = r3
            goto L30
        L12:
            if (r8 != r1) goto L1a
            if (r6 == r2) goto L22
            if (r6 == 0) goto L1a
            if (r6 == r3) goto L22
        L1a:
            r6 = r7
            r8 = r6
            goto L30
        L1d:
            if (r8 < 0) goto L20
            goto L10
        L20:
            if (r8 != r1) goto L24
        L22:
            r8 = r5
            goto L30
        L24:
            if (r8 != r0) goto L1a
            if (r6 == r2) goto L2e
            if (r6 != r3) goto L2b
            goto L2e
        L2b:
            r8 = r5
            r6 = r7
            goto L30
        L2e:
            r8 = r5
            r6 = r2
        L30:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.b0.r(boolean, int, int, int, int):int");
    }

    public static int u(View view) {
        Rect rect = ((c0) view.getLayoutParams()).f5804a;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public static int v(View view) {
        Rect rect = ((c0) view.getLayoutParams()).f5804a;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public int C(h0 h0Var, k0 k0Var) {
        return -1;
    }

    public final void D(View view, Rect rect) {
        Matrix matrix;
        Rect rect2 = ((c0) view.getLayoutParams()).f5804a;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.f5793b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.f5793b.f774j;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public abstract boolean E();

    public void H(int i8) {
        RecyclerView recyclerView = this.f5793b;
        if (recyclerView != null) {
            int iR = recyclerView.d.r();
            for (int i9 = 0; i9 < iR; i9++) {
                recyclerView.d.q(i9).offsetLeftAndRight(i8);
            }
        }
    }

    public void I(int i8) {
        RecyclerView recyclerView = this.f5793b;
        if (recyclerView != null) {
            int iR = recyclerView.d.r();
            for (int i9 = 0; i9 < iR; i9++) {
                recyclerView.d.q(i9).offsetTopAndBottom(i8);
            }
        }
    }

    public abstract void L(RecyclerView recyclerView);

    public void M(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f5793b;
        h0 h0Var = recyclerView.f758a;
        if (accessibilityEvent == null) {
            return;
        }
        boolean z = true;
        if (!recyclerView.canScrollVertically(1) && !this.f5793b.canScrollVertically(-1) && !this.f5793b.canScrollHorizontally(-1) && !this.f5793b.canScrollHorizontally(1)) {
            z = false;
        }
        accessibilityEvent.setScrollable(z);
        this.f5793b.getClass();
    }

    public final void N(View view, f0.g gVar) {
        RecyclerView.s(view);
    }

    public Parcelable P() {
        return null;
    }

    public final void R(h0 h0Var) {
        for (int iQ = q() - 1; iQ >= 0; iQ--) {
            if (!RecyclerView.s(p(iQ)).n()) {
                View viewP = p(iQ);
                U(iQ);
                h0Var.g(viewP);
            }
        }
    }

    public final void S(h0 h0Var) {
        ArrayList arrayList = h0Var.f5829a;
        int size = arrayList.size();
        for (int i8 = size - 1; i8 >= 0; i8--) {
            ((n0) arrayList.get(i8)).getClass();
            n0 n0VarS = RecyclerView.s(null);
            if (!n0VarS.n()) {
                n0VarS.m(false);
                if (n0VarS.j()) {
                    this.f5793b.removeDetachedView(null, false);
                }
                y yVar = this.f5793b.G;
                if (yVar != null) {
                    yVar.b(n0VarS);
                }
                n0VarS.m(true);
                n0 n0VarS2 = RecyclerView.s(null);
                n0VarS2.f5895c = null;
                n0VarS2.d = false;
                n0VarS2.f5894b &= -33;
                h0Var.h(n0VarS2);
            }
        }
        arrayList.clear();
        ArrayList arrayList2 = h0Var.f5830b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.f5793b.invalidate();
        }
    }

    public final void T(View view, h0 h0Var) {
        a4.d dVar = this.f5792a;
        u uVar = (u) dVar.f96b;
        int iIndexOfChild = uVar.f5940a.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            if (((t6.a) dVar.f97c).g(iIndexOfChild)) {
                dVar.L(view);
            }
            uVar.a(iIndexOfChild);
        }
        h0Var.g(view);
    }

    public final void U(int i8) {
        if (p(i8) != null) {
            a4.d dVar = this.f5792a;
            int iV = dVar.v(i8);
            u uVar = (u) dVar.f96b;
            View childAt = uVar.f5940a.getChildAt(iV);
            if (childAt == null) {
                return;
            }
            if (((t6.a) dVar.f97c).g(iV)) {
                dVar.L(childAt);
            }
            uVar.a(iV);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean V(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.x()
            int r1 = r8.z()
            int r2 = r8.f5799i
            int r3 = r8.y()
            int r2 = r2 - r3
            int r3 = r8.f5800j
            int r4 = r8.w()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            androidx.recyclerview.widget.RecyclerView r3 = r8.f5793b
            int[] r7 = e0.a0.f2285a
            int r3 = r3.getLayoutDirection()
            r7 = 1
            if (r3 != r7) goto L60
            if (r2 == 0) goto L5b
            goto L68
        L5b:
            int r2 = java.lang.Math.max(r6, r10)
            goto L68
        L60:
            if (r6 == 0) goto L63
            goto L67
        L63:
            int r6 = java.lang.Math.min(r4, r2)
        L67:
            r2 = r6
        L68:
            if (r1 == 0) goto L6b
            goto L6f
        L6b:
            int r1 = java.lang.Math.min(r5, r11)
        L6f:
            int[] r10 = new int[]{r2, r1}
            r11 = r10[r0]
            r10 = r10[r7]
            if (r13 == 0) goto Lb2
            android.view.View r13 = r9.getFocusedChild()
            if (r13 != 0) goto L80
            goto Lb7
        L80:
            int r1 = r8.x()
            int r2 = r8.z()
            int r3 = r8.f5799i
            int r4 = r8.y()
            int r3 = r3 - r4
            int r4 = r8.f5800j
            int r5 = r8.w()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.f5793b
            android.graphics.Rect r5 = r5.f769g
            r8.t(r13, r5)
            int r8 = r5.left
            int r8 = r8 - r11
            if (r8 >= r3) goto Lb7
            int r8 = r5.right
            int r8 = r8 - r11
            if (r8 <= r1) goto Lb7
            int r8 = r5.top
            int r8 = r8 - r10
            if (r8 >= r4) goto Lb7
            int r8 = r5.bottom
            int r8 = r8 - r10
            if (r8 > r2) goto Lb2
            goto Lb7
        Lb2:
            if (r11 != 0) goto Lb8
            if (r10 == 0) goto Lb7
            goto Lb8
        Lb7:
            return r0
        Lb8:
            if (r12 == 0) goto Lbe
            r9.scrollBy(r11, r10)
            return r7
        Lbe:
            r9.E(r11, r10, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.b0.V(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public final void W() {
        RecyclerView recyclerView = this.f5793b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public abstract int X(int i8, h0 h0Var, k0 k0Var);

    public abstract int Y(int i8, h0 h0Var, k0 k0Var);

    public final void Z(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f5793b = null;
            this.f5792a = null;
            this.f5799i = 0;
            this.f5800j = 0;
        } else {
            this.f5793b = recyclerView;
            this.f5792a = recyclerView.d;
            this.f5799i = recyclerView.getWidth();
            this.f5800j = recyclerView.getHeight();
        }
        this.f5797g = 1073741824;
        this.f5798h = 1073741824;
    }

    public final void a(View view, int i8, boolean z) {
        n0 n0VarS = RecyclerView.s(view);
        if (z || n0VarS.h()) {
            j.j jVar = (j.j) this.f5793b.f765e.f623b;
            u0 u0VarA = (u0) jVar.get(n0VarS);
            if (u0VarA == null) {
                u0VarA = u0.a();
                jVar.put(n0VarS, u0VarA);
            }
            u0VarA.f5942a |= 1;
        } else {
            this.f5793b.f765e.v(n0VarS);
        }
        c0 c0Var = (c0) view.getLayoutParams();
        if (n0VarS.o() || n0VarS.i()) {
            if (n0VarS.i()) {
                n0VarS.f5895c.j(n0VarS);
            } else {
                n0VarS.f5894b &= -33;
            }
            this.f5792a.f(view, i8, view.getLayoutParams(), false);
        } else if (view.getParent() == this.f5793b) {
            a4.d dVar = this.f5792a;
            t6.a aVar = (t6.a) dVar.f97c;
            int iIndexOfChild = ((u) dVar.f96b).f5940a.indexOfChild(view);
            int iB = (iIndexOfChild == -1 || aVar.d(iIndexOfChild)) ? -1 : iIndexOfChild - aVar.b(iIndexOfChild);
            if (i8 == -1) {
                i8 = this.f5792a.r();
            }
            if (iB == -1) {
                throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f5793b.indexOfChild(view) + this.f5793b.p());
            }
            if (iB != i8) {
                b0 b0Var = this.f5793b.f776k;
                View viewP = b0Var.p(iB);
                if (viewP == null) {
                    throw new IllegalArgumentException("Cannot move a child from non-existing index:" + iB + b0Var.f5793b.toString());
                }
                b0Var.p(iB);
                b0Var.f5792a.n(iB);
                c0 c0Var2 = (c0) viewP.getLayoutParams();
                n0 n0VarS2 = RecyclerView.s(viewP);
                if (n0VarS2.h()) {
                    j.j jVar2 = (j.j) b0Var.f5793b.f765e.f623b;
                    u0 u0VarA2 = (u0) jVar2.get(n0VarS2);
                    if (u0VarA2 == null) {
                        u0VarA2 = u0.a();
                        jVar2.put(n0VarS2, u0VarA2);
                    }
                    u0VarA2.f5942a = 1 | u0VarA2.f5942a;
                } else {
                    b0Var.f5793b.f765e.v(n0VarS2);
                }
                b0Var.f5792a.f(viewP, i8, c0Var2, n0VarS2.h());
            }
        } else {
            a4.d dVar2 = this.f5792a;
            RecyclerView recyclerView = ((u) dVar2.f96b).f5940a;
            int childCount = i8 < 0 ? recyclerView.getChildCount() : dVar2.v(i8);
            ((t6.a) dVar2.f97c).e(childCount, false);
            recyclerView.addView(view, childCount);
            RecyclerView.s(view);
            c0Var.f5805b = true;
        }
        if (c0Var.f5806c) {
            throw null;
        }
    }

    public final boolean a0(View view, int i8, int i9, c0 c0Var) {
        return (!view.isLayoutRequested() && this.f5796f && F(view.getWidth(), i8, ((ViewGroup.MarginLayoutParams) c0Var).width) && F(view.getHeight(), i9, ((ViewGroup.MarginLayoutParams) c0Var).height)) ? false : true;
    }

    public void b(String str) {
        RecyclerView recyclerView = this.f5793b;
        if (recyclerView != null) {
            recyclerView.d(str);
        }
    }

    public final boolean b0(View view, int i8, int i9, c0 c0Var) {
        return (this.f5796f && F(view.getMeasuredWidth(), i8, ((ViewGroup.MarginLayoutParams) c0Var).width) && F(view.getMeasuredHeight(), i9, ((ViewGroup.MarginLayoutParams) c0Var).height)) ? false : true;
    }

    public abstract boolean c();

    public abstract boolean d();

    public boolean e(c0 c0Var) {
        return c0Var != null;
    }

    public abstract int g(k0 k0Var);

    public abstract int h(k0 k0Var);

    public abstract int i(k0 k0Var);

    public abstract int j(k0 k0Var);

    public abstract int k(k0 k0Var);

    public abstract int l(k0 k0Var);

    public abstract c0 m();

    public c0 n(Context context, AttributeSet attributeSet) {
        return new c0(context, attributeSet);
    }

    public c0 o(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c0 ? new c0((c0) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new c0((ViewGroup.MarginLayoutParams) layoutParams) : new c0(layoutParams);
    }

    public final View p(int i8) {
        a4.d dVar = this.f5792a;
        if (dVar != null) {
            return dVar.q(i8);
        }
        return null;
    }

    public final int q() {
        a4.d dVar = this.f5792a;
        if (dVar != null) {
            return dVar.r();
        }
        return 0;
    }

    public int s(h0 h0Var, k0 k0Var) {
        return -1;
    }

    public void t(View view, Rect rect) {
        int[] iArr = RecyclerView.f755l0;
        c0 c0Var = (c0) view.getLayoutParams();
        Rect rect2 = c0Var.f5804a;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) c0Var).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) c0Var).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) c0Var).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) c0Var).bottomMargin);
    }

    public final int w() {
        RecyclerView recyclerView = this.f5793b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final int x() {
        RecyclerView recyclerView = this.f5793b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final int y() {
        RecyclerView recyclerView = this.f5793b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int z() {
        RecyclerView recyclerView = this.f5793b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public void J() {
    }

    public void K(RecyclerView recyclerView) {
    }

    public void Q(int i8) {
    }

    public void O(h0 h0Var, k0 k0Var, View view, f0.g gVar) {
    }
}
