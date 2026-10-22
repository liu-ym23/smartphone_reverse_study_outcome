package androidx.recyclerview.widget;

import a2.g;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.emoji2.text.p;
import androidx.fragment.app.b;
import j.i;
import java.util.ArrayList;
import java.util.BitSet;
import k4.z;
import v0.b0;
import v0.c0;
import v0.h0;
import v0.k0;
import v0.n;
import v0.o;
import v0.q0;
import v0.s0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends b0 {

    /* renamed from: k, reason: collision with root package name */
    public final int f790k;

    /* renamed from: l, reason: collision with root package name */
    public final i[] f791l;

    /* renamed from: m, reason: collision with root package name */
    public final g f792m;

    /* renamed from: n, reason: collision with root package name */
    public final g f793n;

    /* renamed from: o, reason: collision with root package name */
    public final int f794o;

    /* renamed from: p, reason: collision with root package name */
    public final n f795p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f796q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f797r = false;

    /* renamed from: s, reason: collision with root package name */
    public final BitSet f798s;

    /* renamed from: t, reason: collision with root package name */
    public final p f799t;

    /* renamed from: u, reason: collision with root package name */
    public final int f800u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f801v;

    /* renamed from: w, reason: collision with root package name */
    public final Rect f802w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f803x;
    public final b y;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i8, int i9) {
        this.f790k = -1;
        this.f796q = false;
        p pVar = new p(20, false);
        this.f799t = pVar;
        this.f800u = 2;
        this.f802w = new Rect();
        new p0.b(this);
        this.f803x = true;
        this.y = new b(11, this);
        o oVarB = b0.B(context, attributeSet, i8, i9);
        int i10 = oVarB.f5900b;
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        b(null);
        if (i10 != this.f794o) {
            this.f794o = i10;
            g gVar = this.f792m;
            this.f792m = this.f793n;
            this.f793n = gVar;
            W();
        }
        int i11 = oVarB.f5901c;
        b(null);
        if (i11 != this.f790k) {
            pVar.h();
            W();
            this.f790k = i11;
            this.f798s = new BitSet(this.f790k);
            this.f791l = new i[this.f790k];
            for (int i12 = 0; i12 < this.f790k; i12++) {
                this.f791l[i12] = new i(this, i12);
            }
            W();
        }
        boolean z = oVarB.d;
        b(null);
        this.f796q = z;
        W();
        n nVar = new n();
        nVar.f5885a = true;
        nVar.f5889f = 0;
        nVar.f5890g = 0;
        this.f795p = nVar;
        this.f792m = g.a(this, this.f794o);
        this.f793n = g.a(this, 1 - this.f794o);
    }

    public static int n0(int i8, int i9, int i10) {
        int mode;
        return (!(i9 == 0 && i10 == 0) && ((mode = View.MeasureSpec.getMode(i8)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i8) - i9) - i10), mode) : i8;
    }

    @Override // v0.b0
    public final boolean E() {
        return this.f800u != 0;
    }

    @Override // v0.b0
    public final void H(int i8) {
        super.H(i8);
        for (int i9 = 0; i9 < this.f790k; i9++) {
            i iVar = this.f791l[i9];
            int i10 = iVar.f3299b;
            if (i10 != Integer.MIN_VALUE) {
                iVar.f3299b = i10 + i8;
            }
            int i11 = iVar.f3300c;
            if (i11 != Integer.MIN_VALUE) {
                iVar.f3300c = i11 + i8;
            }
        }
    }

    @Override // v0.b0
    public final void I(int i8) {
        super.I(i8);
        for (int i9 = 0; i9 < this.f790k; i9++) {
            i iVar = this.f791l[i9];
            int i10 = iVar.f3299b;
            if (i10 != Integer.MIN_VALUE) {
                iVar.f3299b = i10 + i8;
            }
            int i11 = iVar.f3300c;
            if (i11 != Integer.MIN_VALUE) {
                iVar.f3300c = i11 + i8;
            }
        }
    }

    @Override // v0.b0
    public final void J() {
        this.f799t.h();
        for (int i8 = 0; i8 < this.f790k; i8++) {
            this.f791l[i8].b();
        }
    }

    @Override // v0.b0
    public final void L(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f5793b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.y);
        }
        for (int i8 = 0; i8 < this.f790k; i8++) {
            this.f791l[i8].b();
        }
        recyclerView.requestLayout();
    }

    @Override // v0.b0
    public final void M(AccessibilityEvent accessibilityEvent) {
        super.M(accessibilityEvent);
        if (q() > 0) {
            View viewF0 = f0(false);
            View viewE0 = e0(false);
            if (viewF0 == null || viewE0 == null) {
                return;
            }
            int iA = b0.A(viewF0);
            int iA2 = b0.A(viewE0);
            if (iA < iA2) {
                accessibilityEvent.setFromIndex(iA);
                accessibilityEvent.setToIndex(iA2);
            } else {
                accessibilityEvent.setFromIndex(iA2);
                accessibilityEvent.setToIndex(iA);
            }
        }
    }

    @Override // v0.b0
    public final Parcelable P() {
        int iE;
        int iM;
        int[] iArr;
        s0 s0Var = new s0();
        s0Var.f5933h = this.f796q;
        s0Var.f5934j = this.f801v;
        s0Var.f5935k = false;
        p pVar = this.f799t;
        if (pVar == null || (iArr = (int[]) pVar.f623b) == null) {
            s0Var.f5930e = 0;
        } else {
            s0Var.f5931f = iArr;
            s0Var.f5930e = iArr.length;
            s0Var.f5932g = (ArrayList) pVar.f624c;
        }
        if (q() <= 0) {
            s0Var.f5927a = -1;
            s0Var.f5928b = -1;
            s0Var.f5929c = 0;
            return s0Var;
        }
        s0Var.f5927a = this.f801v ? h0() : g0();
        View viewE0 = this.f797r ? e0(true) : f0(true);
        s0Var.f5928b = viewE0 != null ? b0.A(viewE0) : -1;
        int i8 = this.f790k;
        s0Var.f5929c = i8;
        s0Var.d = new int[i8];
        for (int i9 = 0; i9 < this.f790k; i9++) {
            if (this.f801v) {
                iE = this.f791l[i9].d(Integer.MIN_VALUE);
                if (iE != Integer.MIN_VALUE) {
                    iM = this.f792m.i();
                    iE -= iM;
                }
            } else {
                iE = this.f791l[i9].e(Integer.MIN_VALUE);
                if (iE != Integer.MIN_VALUE) {
                    iM = this.f792m.m();
                    iE -= iM;
                }
            }
            s0Var.d[i9] = iE;
        }
        return s0Var;
    }

    @Override // v0.b0
    public final void Q(int i8) {
        if (i8 == 0) {
            c0();
        }
    }

    @Override // v0.b0
    public final int X(int i8, h0 h0Var, k0 k0Var) {
        return m0(i8, h0Var, k0Var);
    }

    @Override // v0.b0
    public final int Y(int i8, h0 h0Var, k0 k0Var) {
        return m0(i8, h0Var, k0Var);
    }

    @Override // v0.b0
    public final void b(String str) {
        super.b(str);
    }

    @Override // v0.b0
    public final boolean c() {
        return this.f794o == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0113  */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c0() {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c0():boolean");
    }

    @Override // v0.b0
    public final boolean d() {
        return this.f794o == 1;
    }

    public final int d0(k0 k0Var) {
        if (q() == 0) {
            return 0;
        }
        boolean z = !this.f803x;
        return z.k(k0Var, this.f792m, f0(z), e0(z), this, this.f803x, this.f797r);
    }

    @Override // v0.b0
    public final boolean e(c0 c0Var) {
        return c0Var instanceof q0;
    }

    public final View e0(boolean z) {
        int iM = this.f792m.m();
        int i8 = this.f792m.i();
        View view = null;
        for (int iQ = q() - 1; iQ >= 0; iQ--) {
            View viewP = p(iQ);
            int iG = this.f792m.g(viewP);
            int iD = this.f792m.d(viewP);
            if (iD > iM && iG < i8) {
                if (iD <= i8 || !z) {
                    return viewP;
                }
                if (view == null) {
                    view = viewP;
                }
            }
        }
        return view;
    }

    public final View f0(boolean z) {
        int iM = this.f792m.m();
        int i8 = this.f792m.i();
        int iQ = q();
        View view = null;
        for (int i9 = 0; i9 < iQ; i9++) {
            View viewP = p(i9);
            int iG = this.f792m.g(viewP);
            if (this.f792m.d(viewP) > iM && iG < i8) {
                if (iG >= iM || !z) {
                    return viewP;
                }
                if (view == null) {
                    view = viewP;
                }
            }
        }
        return view;
    }

    @Override // v0.b0
    public final int g(k0 k0Var) {
        if (q() == 0) {
            return 0;
        }
        boolean z = !this.f803x;
        return z.j(k0Var, this.f792m, f0(z), e0(z), this, this.f803x);
    }

    public final int g0() {
        if (q() == 0) {
            return 0;
        }
        return b0.A(p(0));
    }

    @Override // v0.b0
    public final int h(k0 k0Var) {
        return d0(k0Var);
    }

    public final int h0() {
        int iQ = q();
        if (iQ == 0) {
            return 0;
        }
        return b0.A(p(iQ - 1));
    }

    @Override // v0.b0
    public final int i(k0 k0Var) {
        if (q() == 0) {
            return 0;
        }
        boolean z = !this.f803x;
        return z.l(k0Var, this.f792m, f0(z), e0(z), this, this.f803x);
    }

    public final void i0(View view, int i8, int i9) {
        RecyclerView recyclerView = this.f5793b;
        Rect rect = this.f802w;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.t(view));
        }
        q0 q0Var = (q0) view.getLayoutParams();
        int iN0 = n0(i8, ((ViewGroup.MarginLayoutParams) q0Var).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) q0Var).rightMargin + rect.right);
        int iN02 = n0(i9, ((ViewGroup.MarginLayoutParams) q0Var).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) q0Var).bottomMargin + rect.bottom);
        if (a0(view, iN0, iN02, q0Var)) {
            view.measure(iN0, iN02);
        }
    }

    @Override // v0.b0
    public final int j(k0 k0Var) {
        if (q() == 0) {
            return 0;
        }
        boolean z = !this.f803x;
        return z.j(k0Var, this.f792m, f0(z), e0(z), this, this.f803x);
    }

    public final void j0(h0 h0Var, n nVar) {
        if (!nVar.f5885a || nVar.f5892i) {
            return;
        }
        if (nVar.f5886b == 0) {
            if (nVar.f5888e == -1) {
                k0(h0Var, nVar.f5890g);
                return;
            } else {
                l0(h0Var, nVar.f5889f);
                return;
            }
        }
        int i8 = 1;
        if (nVar.f5888e == -1) {
            int i9 = nVar.f5889f;
            int iE = this.f791l[0].e(i9);
            while (i8 < this.f790k) {
                int iE2 = this.f791l[i8].e(i9);
                if (iE2 > iE) {
                    iE = iE2;
                }
                i8++;
            }
            int i10 = i9 - iE;
            k0(h0Var, i10 < 0 ? nVar.f5890g : nVar.f5890g - Math.min(i10, nVar.f5886b));
            return;
        }
        int i11 = nVar.f5890g;
        int iD = this.f791l[0].d(i11);
        while (i8 < this.f790k) {
            int iD2 = this.f791l[i8].d(i11);
            if (iD2 < iD) {
                iD = iD2;
            }
            i8++;
        }
        int i12 = iD - nVar.f5890g;
        l0(h0Var, i12 < 0 ? nVar.f5889f : Math.min(i12, nVar.f5886b) + nVar.f5889f);
    }

    @Override // v0.b0
    public final int k(k0 k0Var) {
        return d0(k0Var);
    }

    public final void k0(h0 h0Var, int i8) {
        int iQ = q() - 1;
        if (iQ >= 0) {
            View viewP = p(iQ);
            if (this.f792m.g(viewP) < i8 || this.f792m.p(viewP) < i8) {
                return;
            }
            q0 q0Var = (q0) viewP.getLayoutParams();
            q0Var.getClass();
            if (((ArrayList) q0Var.d.f3302f).size() == 1) {
                return;
            }
            ArrayList arrayList = (ArrayList) q0Var.d.f3302f;
            ((q0) ((View) arrayList.remove(arrayList.size() - 1)).getLayoutParams()).d = null;
            throw null;
        }
    }

    @Override // v0.b0
    public final int l(k0 k0Var) {
        if (q() == 0) {
            return 0;
        }
        boolean z = !this.f803x;
        return z.l(k0Var, this.f792m, f0(z), e0(z), this, this.f803x);
    }

    public final void l0(h0 h0Var, int i8) {
        if (q() > 0) {
            View viewP = p(0);
            if (this.f792m.d(viewP) > i8 || this.f792m.o(viewP) > i8) {
                return;
            }
            q0 q0Var = (q0) viewP.getLayoutParams();
            q0Var.getClass();
            if (((ArrayList) q0Var.d.f3302f).size() == 1) {
                return;
            }
            i iVar = q0Var.d;
            ArrayList arrayList = (ArrayList) iVar.f3302f;
            ((q0) ((View) arrayList.remove(0)).getLayoutParams()).d = null;
            if (arrayList.size() == 0) {
                iVar.f3300c = Integer.MIN_VALUE;
            }
            throw null;
        }
    }

    @Override // v0.b0
    public final c0 m() {
        return this.f794o == 0 ? new q0(-2, -1) : new q0(-1, -2);
    }

    public final int m0(int i8, h0 h0Var, k0 k0Var) {
        int iG0;
        int i9;
        int i10;
        if (q() == 0 || i8 == 0) {
            return 0;
        }
        if (i8 > 0) {
            iG0 = h0();
            i9 = 1;
        } else {
            iG0 = g0();
            i9 = -1;
        }
        n nVar = this.f795p;
        nVar.f5885a = true;
        n nVar2 = this.f795p;
        boolean z = false;
        nVar2.f5886b = 0;
        nVar2.f5887c = iG0;
        RecyclerView recyclerView = this.f5793b;
        if (recyclerView == null || !recyclerView.f767f) {
            nVar2.f5890g = this.f792m.h();
            nVar2.f5889f = 0;
        } else {
            nVar2.f5889f = this.f792m.m();
            nVar2.f5890g = this.f792m.i();
        }
        nVar2.f5891h = false;
        nVar2.f5885a = true;
        if (this.f792m.k() == 0 && this.f792m.h() == 0) {
            z = true;
        }
        nVar2.f5892i = z;
        n nVar3 = this.f795p;
        nVar3.f5888e = i9;
        nVar3.d = this.f797r != (i9 == -1) ? -1 : 1;
        nVar.f5887c = iG0 + nVar.d;
        nVar.f5886b = Math.abs(i8);
        this.f798s.set(0, this.f790k, true);
        n nVar4 = this.f795p;
        boolean z2 = nVar4.f5892i;
        n nVar5 = this.f795p;
        int i11 = z2 ? nVar5.f5888e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : nVar5.f5888e == 1 ? nVar5.f5890g + nVar5.f5886b : nVar5.f5889f - nVar5.f5886b;
        int i12 = nVar5.f5888e;
        for (int i13 = 0; i13 < this.f790k; i13++) {
            if (!((ArrayList) this.f791l[i13].f3302f).isEmpty()) {
                i iVar = this.f791l[i13];
                int i14 = iVar.d;
                int i15 = iVar.f3301e;
                if (i12 == -1) {
                    int i16 = iVar.f3299b;
                    if (i16 == Integer.MIN_VALUE) {
                        View view = (View) ((ArrayList) iVar.f3302f).get(0);
                        q0 q0Var = (q0) view.getLayoutParams();
                        iVar.f3299b = ((StaggeredGridLayoutManager) iVar.f3303g).f792m.g(view);
                        q0Var.getClass();
                        i16 = iVar.f3299b;
                    }
                    if (i16 + i14 <= i11) {
                        this.f798s.set(i15, false);
                    }
                } else {
                    int i17 = iVar.f3300c;
                    if (i17 == Integer.MIN_VALUE) {
                        iVar.a();
                        i17 = iVar.f3300c;
                    }
                    if (i17 - i14 >= i11) {
                        this.f798s.set(i15, false);
                    }
                }
            }
        }
        if (this.f797r) {
            this.f792m.i();
        } else {
            this.f792m.m();
        }
        int i18 = nVar5.f5887c;
        if (i18 >= 0 && i18 < k0Var.a() && (nVar4.f5892i || !this.f798s.isEmpty())) {
            View viewD = h0Var.d(nVar5.f5887c);
            nVar5.f5887c += nVar5.d;
            ((q0) viewD.getLayoutParams()).getClass();
            throw null;
        }
        j0(h0Var, nVar4);
        if (nVar4.f5888e == -1) {
            int iM = this.f792m.m();
            int iE = this.f791l[0].e(iM);
            for (int i19 = 1; i19 < this.f790k; i19++) {
                int iE2 = this.f791l[i19].e(iM);
                if (iE2 < iE) {
                    iE = iE2;
                }
            }
            i10 = this.f792m.m() - iE;
        } else {
            int i20 = this.f792m.i();
            int iD = this.f791l[0].d(i20);
            for (int i21 = 1; i21 < this.f790k; i21++) {
                int iD2 = this.f791l[i21].d(i20);
                if (iD2 > iD) {
                    iD = iD2;
                }
            }
            i10 = iD - this.f792m.i();
        }
        int iMin = i10 > 0 ? Math.min(nVar5.f5886b, i10) : 0;
        int i22 = nVar5.f5886b < iMin ? i8 : i8 < 0 ? -iMin : iMin;
        this.f792m.s(-i22);
        this.f801v = this.f797r;
        nVar5.f5886b = 0;
        j0(h0Var, nVar5);
        return i22;
    }

    @Override // v0.b0
    public final c0 n(Context context, AttributeSet attributeSet) {
        return new q0(context, attributeSet);
    }

    @Override // v0.b0
    public final c0 o(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new q0((ViewGroup.MarginLayoutParams) layoutParams) : new q0(layoutParams);
    }
}
