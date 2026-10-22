package androidx.recyclerview.widget;

import a2.g;
import a8.b;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import e0.a0;
import k4.z;
import v0.b0;
import v0.c0;
import v0.h0;
import v0.k0;
import v0.o;
import v0.p;
import v0.q;
import v0.r;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class LinearLayoutManager extends b0 {

    /* renamed from: k, reason: collision with root package name */
    public int f744k;

    /* renamed from: l, reason: collision with root package name */
    public q f745l;

    /* renamed from: m, reason: collision with root package name */
    public g f746m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f747n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f748o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f749p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f750q;

    /* renamed from: r, reason: collision with root package name */
    public final r f751r;

    /* renamed from: s, reason: collision with root package name */
    public final o f752s;

    /* renamed from: t, reason: collision with root package name */
    public final p f753t;

    /* renamed from: u, reason: collision with root package name */
    public final int[] f754u;

    public LinearLayoutManager() {
        this.f744k = 1;
        this.f747n = false;
        this.f748o = false;
        this.f749p = false;
        this.f750q = true;
        this.f751r = null;
        this.f752s = new o(0);
        this.f753t = new p();
        this.f754u = new int[2];
        q0(1);
        b(null);
        if (this.f747n) {
            this.f747n = false;
            W();
        }
    }

    @Override // v0.b0
    public final boolean E() {
        return true;
    }

    @Override // v0.b0
    public final void M(AccessibilityEvent accessibilityEvent) {
        super.M(accessibilityEvent);
        if (q() > 0) {
            View viewI0 = i0(0, q(), false);
            accessibilityEvent.setFromIndex(viewI0 == null ? -1 : b0.A(viewI0));
            View viewI02 = i0(q() - 1, -1, false);
            accessibilityEvent.setToIndex(viewI02 != null ? b0.A(viewI02) : -1);
        }
    }

    @Override // v0.b0
    public final Parcelable P() {
        r rVar = this.f751r;
        if (rVar != null) {
            r rVar2 = new r();
            rVar2.f5918a = rVar.f5918a;
            rVar2.f5919b = rVar.f5919b;
            rVar2.f5920c = rVar.f5920c;
            return rVar2;
        }
        r rVar3 = new r();
        if (q() <= 0) {
            rVar3.f5918a = -1;
            return rVar3;
        }
        f0();
        boolean z = false ^ this.f748o;
        rVar3.f5920c = z;
        if (z) {
            View viewJ0 = j0();
            rVar3.f5919b = this.f746m.i() - this.f746m.d(viewJ0);
            rVar3.f5918a = b0.A(viewJ0);
            return rVar3;
        }
        View viewK0 = k0();
        rVar3.f5918a = b0.A(viewK0);
        rVar3.f5919b = this.f746m.g(viewK0) - this.f746m.m();
        return rVar3;
    }

    @Override // v0.b0
    public int X(int i8, h0 h0Var, k0 k0Var) {
        if (this.f744k == 1) {
            return 0;
        }
        return p0(i8, h0Var, k0Var);
    }

    @Override // v0.b0
    public int Y(int i8, h0 h0Var, k0 k0Var) {
        if (this.f744k == 0) {
            return 0;
        }
        return p0(i8, h0Var, k0Var);
    }

    @Override // v0.b0
    public final void b(String str) {
        if (this.f751r == null) {
            super.b(str);
        }
    }

    @Override // v0.b0
    public final boolean c() {
        return this.f744k == 0;
    }

    public final int c0(k0 k0Var) {
        if (q() == 0) {
            return 0;
        }
        f0();
        g gVar = this.f746m;
        boolean z = !this.f750q;
        return z.j(k0Var, gVar, h0(z), g0(z), this, this.f750q);
    }

    @Override // v0.b0
    public final boolean d() {
        return this.f744k == 1;
    }

    public final int d0(k0 k0Var) {
        if (q() == 0) {
            return 0;
        }
        f0();
        g gVar = this.f746m;
        boolean z = !this.f750q;
        return z.k(k0Var, gVar, h0(z), g0(z), this, this.f750q, this.f748o);
    }

    public final int e0(k0 k0Var) {
        if (q() == 0) {
            return 0;
        }
        f0();
        g gVar = this.f746m;
        boolean z = !this.f750q;
        return z.l(k0Var, gVar, h0(z), g0(z), this, this.f750q);
    }

    public final void f0() {
        if (this.f745l == null) {
            q qVar = new q();
            qVar.f5908a = true;
            qVar.f5914h = 0;
            qVar.f5915i = 0;
            qVar.f5916j = null;
            this.f745l = qVar;
        }
    }

    @Override // v0.b0
    public final int g(k0 k0Var) {
        return c0(k0Var);
    }

    public final View g0(boolean z) {
        return this.f748o ? i0(0, q(), z) : i0(q() - 1, -1, z);
    }

    @Override // v0.b0
    public int h(k0 k0Var) {
        return d0(k0Var);
    }

    public final View h0(boolean z) {
        return this.f748o ? i0(q() - 1, -1, z) : i0(0, q(), z);
    }

    @Override // v0.b0
    public int i(k0 k0Var) {
        return e0(k0Var);
    }

    public final View i0(int i8, int i9, boolean z) {
        f0();
        int i10 = z ? 24579 : 320;
        return this.f744k == 0 ? this.f5794c.k(i8, i9, i10, 320) : this.d.k(i8, i9, i10, 320);
    }

    @Override // v0.b0
    public final int j(k0 k0Var) {
        return c0(k0Var);
    }

    public final View j0() {
        return p(this.f748o ? 0 : q() - 1);
    }

    @Override // v0.b0
    public int k(k0 k0Var) {
        return d0(k0Var);
    }

    public final View k0() {
        return p(this.f748o ? q() - 1 : 0);
    }

    @Override // v0.b0
    public int l(k0 k0Var) {
        return e0(k0Var);
    }

    public final boolean l0() {
        RecyclerView recyclerView = this.f5793b;
        int[] iArr = a0.f2285a;
        return recyclerView.getLayoutDirection() == 1;
    }

    @Override // v0.b0
    public c0 m() {
        return new c0(-2, -2);
    }

    public void m0(h0 h0Var, k0 k0Var, q qVar, p pVar) {
        int i8;
        int iF;
        int i9;
        int i10;
        int iF2;
        View viewB = qVar.b(h0Var);
        if (viewB == null) {
            pVar.f5905b = true;
            return;
        }
        c0 c0Var = (c0) viewB.getLayoutParams();
        if (qVar.f5916j == null) {
            if (this.f748o == (qVar.f5912f == -1)) {
                a(viewB, -1, false);
            } else {
                a(viewB, 0, false);
            }
        } else {
            if (this.f748o == (qVar.f5912f == -1)) {
                a(viewB, -1, true);
            } else {
                a(viewB, 0, true);
            }
        }
        c0 c0Var2 = (c0) viewB.getLayoutParams();
        Rect rectT = this.f5793b.t(viewB);
        int i11 = rectT.left + rectT.right;
        int i12 = rectT.top + rectT.bottom;
        int iR = b0.r(c(), this.f5799i, this.f5797g, y() + x() + ((ViewGroup.MarginLayoutParams) c0Var2).leftMargin + ((ViewGroup.MarginLayoutParams) c0Var2).rightMargin + i11, ((ViewGroup.MarginLayoutParams) c0Var2).width);
        int iR2 = b0.r(d(), this.f5800j, this.f5798h, w() + z() + ((ViewGroup.MarginLayoutParams) c0Var2).topMargin + ((ViewGroup.MarginLayoutParams) c0Var2).bottomMargin + i12, ((ViewGroup.MarginLayoutParams) c0Var2).height);
        if (a0(viewB, iR, iR2, c0Var2)) {
            viewB.measure(iR, iR2);
        }
        pVar.f5904a = this.f746m.e(viewB);
        if (this.f744k == 1) {
            if (l0()) {
                iF2 = this.f5799i - y();
                iF = iF2 - this.f746m.f(viewB);
            } else {
                int iX = x();
                iF2 = this.f746m.f(viewB) + iX;
                iF = iX;
            }
            if (qVar.f5912f == -1) {
                i8 = qVar.f5909b;
                i10 = i8 - pVar.f5904a;
            } else {
                int i13 = qVar.f5909b;
                int i14 = pVar.f5904a + i13;
                i10 = i13;
                i8 = i14;
            }
        } else {
            int iZ = z();
            int iF3 = this.f746m.f(viewB) + iZ;
            if (qVar.f5912f == -1) {
                int i15 = qVar.f5909b;
                int i16 = i15 - pVar.f5904a;
                i9 = i15;
                i8 = iF3;
                iF = i16;
            } else {
                int i17 = qVar.f5909b;
                int i18 = pVar.f5904a + i17;
                i8 = iF3;
                iF = i17;
                i9 = i18;
            }
            i10 = iZ;
            iF2 = i9;
        }
        b0.G(viewB, iF, i10, iF2, i8);
        c0Var.getClass();
        throw null;
    }

    public final void n0(h0 h0Var, q qVar) {
        if (!qVar.f5908a || qVar.f5917k) {
            return;
        }
        int i8 = qVar.f5913g;
        int i9 = qVar.f5915i;
        if (qVar.f5912f == -1) {
            int iQ = q();
            if (i8 < 0) {
                return;
            }
            int iH = (this.f746m.h() - i8) + i9;
            if (this.f748o) {
                for (int i10 = 0; i10 < iQ; i10++) {
                    View viewP = p(i10);
                    if (this.f746m.g(viewP) < iH || this.f746m.p(viewP) < iH) {
                        o0(h0Var, 0, i10);
                        return;
                    }
                }
                return;
            }
            int i11 = iQ - 1;
            for (int i12 = i11; i12 >= 0; i12--) {
                View viewP2 = p(i12);
                if (this.f746m.g(viewP2) < iH || this.f746m.p(viewP2) < iH) {
                    o0(h0Var, i11, i12);
                    return;
                }
            }
            return;
        }
        if (i8 < 0) {
            return;
        }
        int i13 = i8 - i9;
        int iQ2 = q();
        if (!this.f748o) {
            for (int i14 = 0; i14 < iQ2; i14++) {
                View viewP3 = p(i14);
                if (this.f746m.d(viewP3) > i13 || this.f746m.o(viewP3) > i13) {
                    o0(h0Var, 0, i14);
                    return;
                }
            }
            return;
        }
        int i15 = iQ2 - 1;
        for (int i16 = i15; i16 >= 0; i16--) {
            View viewP4 = p(i16);
            if (this.f746m.d(viewP4) > i13 || this.f746m.o(viewP4) > i13) {
                o0(h0Var, i15, i16);
                return;
            }
        }
    }

    public final void o0(h0 h0Var, int i8, int i9) {
        if (i8 == i9) {
            return;
        }
        if (i9 <= i8) {
            while (i8 > i9) {
                View viewP = p(i8);
                U(i8);
                h0Var.g(viewP);
                i8--;
            }
            return;
        }
        for (int i10 = i9 - 1; i10 >= i8; i10--) {
            View viewP2 = p(i10);
            U(i10);
            h0Var.g(viewP2);
        }
    }

    public final int p0(int i8, h0 h0Var, k0 k0Var) {
        int iM;
        int i9;
        if (q() != 0 && i8 != 0) {
            f0();
            this.f745l.f5908a = true;
            int i10 = i8 <= 0 ? -1 : 1;
            int iAbs = Math.abs(i8);
            this.f745l.f5917k = this.f746m.k() == 0 && this.f746m.h() == 0;
            this.f745l.f5912f = i10;
            int[] iArr = this.f754u;
            iArr[0] = 0;
            iArr[1] = 0;
            k0Var.getClass();
            int i11 = this.f745l.f5912f;
            iArr[0] = 0;
            iArr[1] = 0;
            int iMax = Math.max(0, iArr[0]);
            int iMax2 = Math.max(0, iArr[1]);
            boolean z = i10 == 1;
            q qVar = this.f745l;
            int i12 = z ? iMax2 : iMax;
            qVar.f5914h = i12;
            if (!z) {
                iMax = iMax2;
            }
            qVar.f5915i = iMax;
            if (z) {
                qVar.f5914h = this.f746m.j() + i12;
                View viewJ0 = j0();
                q qVar2 = this.f745l;
                qVar2.f5911e = this.f748o ? -1 : 1;
                int iA = b0.A(viewJ0);
                q qVar3 = this.f745l;
                qVar2.d = iA + qVar3.f5911e;
                qVar3.f5909b = this.f746m.d(viewJ0);
                iM = this.f746m.d(viewJ0) - this.f746m.i();
            } else {
                View viewK0 = k0();
                q qVar4 = this.f745l;
                qVar4.f5914h = this.f746m.m() + qVar4.f5914h;
                q qVar5 = this.f745l;
                qVar5.f5911e = this.f748o ? 1 : -1;
                int iA2 = b0.A(viewK0);
                q qVar6 = this.f745l;
                qVar5.d = iA2 + qVar6.f5911e;
                qVar6.f5909b = this.f746m.g(viewK0);
                iM = (-this.f746m.g(viewK0)) + this.f746m.m();
            }
            q qVar7 = this.f745l;
            qVar7.f5910c = iAbs;
            qVar7.f5910c = iAbs - iM;
            qVar7.f5913g = iM;
            q qVar8 = this.f745l;
            int i13 = qVar8.f5913g;
            int i14 = qVar8.f5910c;
            int i15 = qVar8.f5913g;
            if (i15 != Integer.MIN_VALUE) {
                if (i14 < 0) {
                    qVar8.f5913g = i15 + i14;
                }
                n0(h0Var, qVar8);
            }
            int i16 = qVar8.f5910c + qVar8.f5914h;
            while (true) {
                if ((!qVar8.f5917k && i16 <= 0) || (i9 = qVar8.d) < 0 || i9 >= k0Var.a()) {
                    break;
                }
                p pVar = this.f753t;
                pVar.f5904a = 0;
                pVar.f5905b = false;
                pVar.f5906c = false;
                pVar.d = false;
                m0(h0Var, k0Var, qVar8, pVar);
                if (pVar.f5905b) {
                    break;
                }
                int i17 = qVar8.f5909b;
                int i18 = pVar.f5904a;
                qVar8.f5909b = (qVar8.f5912f * i18) + i17;
                if (!pVar.f5906c || qVar8.f5916j != null || !k0Var.f5868e) {
                    qVar8.f5910c -= i18;
                    i16 -= i18;
                }
                int i19 = qVar8.f5913g;
                if (i19 != Integer.MIN_VALUE) {
                    int i20 = i19 + i18;
                    qVar8.f5913g = i20;
                    int i21 = qVar8.f5910c;
                    if (i21 < 0) {
                        qVar8.f5913g = i20 + i21;
                    }
                    n0(h0Var, qVar8);
                }
            }
            int i22 = (i14 - qVar8.f5910c) + i13;
            if (i22 >= 0) {
                if (iAbs > i22) {
                    i8 = i10 * i22;
                }
                this.f746m.s(-i8);
                this.f745l.getClass();
                return i8;
            }
        }
        return 0;
    }

    public final void q0(int i8) {
        if (i8 != 0 && i8 != 1) {
            throw new IllegalArgumentException(b.j(i8, "invalid orientation:"));
        }
        b(null);
        if (i8 != this.f744k || this.f746m == null) {
            this.f746m = g.a(this, i8);
            this.f752s.getClass();
            this.f744k = i8;
            W();
        }
    }

    public void r0(boolean z) {
        b(null);
        if (this.f749p == z) {
            return;
        }
        this.f749p = z;
        W();
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i8, int i9) {
        this.f744k = 1;
        this.f747n = false;
        this.f748o = false;
        this.f749p = false;
        this.f750q = true;
        this.f751r = null;
        this.f752s = new o(0);
        this.f753t = new p();
        this.f754u = new int[2];
        o oVarB = b0.B(context, attributeSet, i8, i9);
        q0(oVarB.f5900b);
        boolean z = oVarB.d;
        b(null);
        if (z != this.f747n) {
            this.f747n = z;
            W();
        }
        r0(oVarB.f5902e);
    }

    @Override // v0.b0
    public final void L(RecyclerView recyclerView) {
    }
}
