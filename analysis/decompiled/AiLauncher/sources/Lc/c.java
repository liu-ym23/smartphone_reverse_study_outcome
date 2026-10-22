package Lc;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.core.view.C1334w;
import androidx.dynamicanimation.animation.e;
import androidx.dynamicanimation.animation.i;
import androidx.dynamicanimation.animation.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: A, reason: collision with root package name */
    public final int[] f4416A;

    /* renamed from: B, reason: collision with root package name */
    public C1334w f4417B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f4418C;

    /* renamed from: D, reason: collision with root package name */
    public float f4419D;

    /* renamed from: E, reason: collision with root package name */
    public float f4420E;

    /* renamed from: F, reason: collision with root package name */
    public int f4421F;

    /* renamed from: a, reason: collision with root package name */
    public final Context f4422a;

    /* renamed from: b, reason: collision with root package name */
    public final View f4423b;

    /* renamed from: c, reason: collision with root package name */
    public final RunnableC0077c f4424c;

    /* renamed from: d, reason: collision with root package name */
    public float f4425d;

    /* renamed from: e, reason: collision with root package name */
    public OverScroller f4426e;

    /* renamed from: f, reason: collision with root package name */
    public int f4427f;

    /* renamed from: g, reason: collision with root package name */
    public int f4428g;

    /* renamed from: h, reason: collision with root package name */
    public int f4429h;

    /* renamed from: i, reason: collision with root package name */
    public int f4430i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4431j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4432k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4433l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4434m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4435n;

    /* renamed from: o, reason: collision with root package name */
    public float f4436o;

    /* renamed from: p, reason: collision with root package name */
    public float f4437p;

    /* renamed from: q, reason: collision with root package name */
    public i f4438q;

    /* renamed from: r, reason: collision with root package name */
    public int f4439r;

    /* renamed from: s, reason: collision with root package name */
    public List<Lc.a> f4440s;

    /* renamed from: t, reason: collision with root package name */
    public int f4441t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4442u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4443v;

    /* renamed from: w, reason: collision with root package name */
    public float f4444w;

    /* renamed from: x, reason: collision with root package name */
    public int f4445x;

    /* renamed from: y, reason: collision with root package name */
    public float f4446y;

    /* renamed from: z, reason: collision with root package name */
    public final int[] f4447z;

    public class a implements e.r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f4448a;

        public a(boolean z10) {
            this.f4448a = z10;
        }

        @Override // androidx.dynamicanimation.animation.e.r
        public void b(e eVar, float f10, float f11) {
            c cVar = c.this;
            cVar.A(cVar.F(), c.this.G());
            c cVar2 = c.this;
            cVar2.f4420E = this.f4448a ? cVar2.G() : cVar2.F();
        }
    }

    public class b implements e.q {
        public b() {
        }

        @Override // androidx.dynamicanimation.animation.e.q
        public void a(e eVar, boolean z10, float f10, float f11) {
            c.this.f4446y = 0.0f;
            if (z10) {
                return;
            }
            c.this.f4445x = 0;
            c.this.B();
        }
    }

    /* renamed from: Lc.c$c, reason: collision with other inner class name */
    public class RunnableC0077c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public int f4451a;

        /* renamed from: b, reason: collision with root package name */
        public int f4452b;

        public RunnableC0077c() {
            c.this.f4426e = new OverScroller(c.this.f4422a);
        }

        public void a() {
            if (c.this.f4426e.isFinished()) {
                return;
            }
            c.this.f4426e.abortAnimation();
        }

        public void b(int i10, int i11) {
            this.f4451a = i10;
            this.f4452b = i11;
            c.this.f4426e.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            c();
        }

        public void c() {
            c.this.f4423b.removeCallbacks(this);
            c.this.f4423b.postOnAnimation(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.f4426e.computeScrollOffset() || c.this.f4426e.isFinished()) {
                return;
            }
            boolean zU = c.this.u();
            boolean zX = c.this.x();
            c.this.f4426e.getCurrVelocity();
            int i10 = this.f4452b;
            if ((i10 < 0 && !zU) || (i10 > 0 && !zX)) {
                boolean z10 = c.this.f4426e.getStartY() > c.this.f4426e.getCurrY();
                float currVelocity = c.this.f4426e.getCurrVelocity();
                c cVar = c.this;
                if (!z10) {
                    currVelocity = -currVelocity;
                }
                cVar.R(currVelocity, true);
                a();
                return;
            }
            if ((this.f4451a >= 0 || c.this.w()) && (this.f4451a <= 0 || c.this.v())) {
                c();
                return;
            }
            boolean z11 = c.this.f4426e.getStartX() > c.this.f4426e.getCurrX();
            float currVelocity2 = c.this.f4426e.getCurrVelocity();
            c cVar2 = c.this;
            if (!z11) {
                currVelocity2 = -currVelocity2;
            }
            cVar2.R(currVelocity2, false);
            a();
        }
    }

    public c(Context context, View view, OverScroller overScroller) {
        this(context, view, overScroller, -1);
    }

    public void A(float f10, float f11) {
        List<Lc.a> list = this.f4440s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4440s.get(size).b(this.f4423b, f10, f11);
            }
        }
    }

    public final void B() {
        List<Lc.a> list = this.f4440s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4440s.get(size).a(this.f4423b, this.f4445x);
            }
        }
    }

    public void C(int i10, int i11) {
        if (this.f4431j) {
            if (Math.abs(i10) >= this.f4439r || Math.abs(i11) >= this.f4439r) {
                if (i11 >= 0 || this.f4432k) {
                    if (i11 <= 0 || this.f4433l) {
                        if (i10 >= 0 || this.f4434m) {
                            if (i10 <= 0 || this.f4435n) {
                                i iVar = this.f4438q;
                                if (iVar != null && iVar.i()) {
                                    Log.w("SpringAnimationHelper", "animation already running....");
                                    return;
                                }
                                RunnableC0077c runnableC0077c = this.f4424c;
                                if (runnableC0077c != null) {
                                    runnableC0077c.b(i10, i11);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final Pair<Integer, Integer> D(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }

    public final C1334w E() {
        if (this.f4417B == null) {
            C1334w c1334w = new C1334w(this.f4423b);
            this.f4417B = c1334w;
            c1334w.n(true);
        }
        return this.f4417B;
    }

    public final float F() {
        return this.f4423b.getTranslationX();
    }

    public final float G() {
        return this.f4423b.getTranslationY();
    }

    public final int H() {
        View view;
        if (this.f4421F == 0 && (view = this.f4423b) != null) {
            this.f4421F = (int) Hc.b.b(this.f4422a, this.f4441t == 1 ? view.getHeight() : view.getWidth());
        }
        return this.f4421F;
    }

    public final int I(MotionEvent motionEvent, int i10) {
        return (int) motionEvent.getRawX(i10);
    }

    public final int J(MotionEvent motionEvent, int i10) {
        return (int) motionEvent.getRawY(i10);
    }

    public final void K(int i10) {
        char c10 = i10 < 0 ? (char) 65535 : (char) 1;
        boolean zW = w();
        boolean zV = v();
        float F10 = F();
        boolean z10 = (c10 == 1 && F10 > 0.0f) || (c10 == 65535 && F10 < 0.0f);
        float fX = X(i10, z10);
        if (z10) {
            l0(c10 == 1 ? Math.max(0.0f, fX) : Math.min(0.0f, fX));
            return;
        }
        if (c10 == 65535 && !zW && this.f4434m) {
            l0(fX);
        } else if (c10 == 1 && !zV && this.f4435n) {
            l0(fX);
        } else {
            Z();
        }
    }

    public final void L(int i10) {
        if (i10 == 0) {
            return;
        }
        boolean z10 = false;
        boolean z11 = i10 < 0;
        if (!z11 || this.f4432k) {
            if (z11 || this.f4433l) {
                float fG = G();
                if ((z11 && fG < 0.0f) || (!z11 && fG > 0.0f)) {
                    z10 = true;
                }
                float fX = X(i10, z10);
                if (z11) {
                    boolean zU = u();
                    if (zU && !z10) {
                        Z();
                    }
                    if (zU || z10) {
                        fX = Math.min(0.0f, fX);
                    }
                } else {
                    boolean zX = x();
                    if (zX && !z10) {
                        Z();
                    }
                    if (zX || z10) {
                        fX = Math.max(0.0f, fX);
                    }
                }
                n0(fX);
            }
        }
    }

    public final i M(boolean z10, float f10) {
        i iVarB = new i(this.f4423b, z10 ? e.f13691o : e.f13690n).B(new j(f10).f(this.f4436o).h(this.f4437p));
        this.f4438q = iVarB;
        iVarB.c(new a(z10));
        this.f4438q.b(new b());
        this.f4445x = 2;
        B();
        return this.f4438q;
    }

    public final void N() {
        if (this.f4430i == 0) {
            Pair<Integer, Integer> pairD = D(this.f4422a);
            int i10 = this.f4441t;
            if (i10 == 1) {
                this.f4430i = ((Integer) pairD.second).intValue();
            } else if (i10 == 0) {
                this.f4430i = ((Integer) pairD.first).intValue();
            }
        }
    }

    public final void O(Context context) {
        this.f4439r = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    public boolean P() {
        int i10 = this.f4445x;
        return i10 == 1 || i10 == 2;
    }

    public boolean Q() {
        return this.f4431j;
    }

    public final void R(float f10, boolean z10) {
        if (this.f4431j) {
            if (Math.abs(f10) >= this.f4439r) {
                M(z10, 0.0f).r(f10 * this.f4425d).t();
                return;
            }
            Log.w("SpringAnimationHelper", "velocity minus minVelocity:" + this.f4439r);
        }
    }

    public final void S() {
        RunnableC0077c runnableC0077c = this.f4424c;
        if (runnableC0077c != null) {
            runnableC0077c.a();
        }
        a();
        o0(this.f4441t == 1 ? 2 : 1);
        this.f4418C = true;
    }

    public final void T(MotionEvent motionEvent) {
        if (this.f4431j) {
            a();
            RunnableC0077c runnableC0077c = this.f4424c;
            if (runnableC0077c != null) {
                runnableC0077c.a();
            }
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f4427f);
            if (iFindPointerIndex < 0) {
                Log.w("SpringAnimationHelper", "Error processing scroll, pointer index for id " + this.f4427f + " not found. Did any MotionEvent get skipped?");
                iFindPointerIndex = 0;
                this.f4427f = motionEvent.getPointerId(0);
                this.f4429h = (int) motionEvent.getRawY();
                this.f4428g = (int) motionEvent.getRawX();
            }
            N();
            if (!this.f4418C) {
                o0(this.f4441t == 1 ? 2 : 1);
            }
            int iJ = this.f4429h - J(motionEvent, iFindPointerIndex);
            int I10 = this.f4428g - I(motionEvent, iFindPointerIndex);
            int i10 = this.f4441t;
            if (i10 == 1) {
                L(iJ);
            } else if (i10 == 0) {
                K(I10);
            }
            a0(motionEvent, iFindPointerIndex);
        }
    }

    public final void U() {
        p0();
        this.f4418C = false;
        this.f4443v = false;
        if (!this.f4442u) {
            this.f4429h = 0;
            this.f4428g = 0;
            A(F(), G());
            return;
        }
        if (G() != 0.0f) {
            M(true, this.f4444w).t();
        } else if (F() != 0.0f) {
            M(false, this.f4444w).t();
        } else if (G() == 0.0f || F() == 0.0f) {
            this.f4445x = 0;
        }
        this.f4428g = 0;
        this.f4429h = 0;
    }

    public void V(MotionEvent motionEvent) {
        if (motionEvent == null || !this.f4431j) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        motionEvent.getActionIndex();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return;
                    }
                }
            }
            U();
            return;
        }
        this.f4427f = motionEvent.getPointerId(0);
        S();
        a0(motionEvent, 0);
    }

    public final void W(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f4427f) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.f4427f = motionEvent.getPointerId(i10);
            this.f4428g = I(motionEvent, i10);
            this.f4429h = J(motionEvent, i10);
        }
    }

    public final float X(float f10, boolean z10) {
        float fB = Hc.b.b(this.f4422a, f10);
        if (z10 || this.f4445x != 1) {
            this.f4419D = Lc.b.a(Math.abs(Hc.b.b(this.f4422a, this.f4420E)), H()) * Math.signum(-this.f4420E);
        }
        float f11 = this.f4419D + fB;
        this.f4419D = f11;
        float fA = Hc.b.a(this.f4422a, (-Lc.b.b(Math.abs(f11), H())) * Math.signum(f11));
        this.f4420E = fA;
        return fA;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean Y(android.view.MotionEvent r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L64
            boolean r1 = r5.f4431j
            if (r1 != 0) goto L8
            goto L64
        L8:
            int r1 = r6.getActionMasked()
            int r2 = r6.getActionIndex()
            if (r1 == 0) goto L58
            r3 = 1
            if (r1 == r3) goto L54
            r4 = 2
            if (r1 == r4) goto L33
            r3 = 3
            if (r1 == r3) goto L54
            r3 = 5
            if (r1 == r3) goto L26
            r2 = 6
            if (r1 == r2) goto L22
            goto L64
        L22:
            r5.W(r6)
            goto L64
        L26:
            int r1 = r6.getPointerId(r2)
            r5.f4427f = r1
            r5.S()
            r5.a0(r6, r2)
            goto L64
        L33:
            int r1 = r5.f4428g
            if (r1 != 0) goto L3f
            int r1 = r5.f4429h
            if (r1 != 0) goto L3f
            r5.a0(r6, r2)
            return r0
        L3f:
            r5.T(r6)
            float r6 = r5.F()
            r1 = 0
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 != 0) goto L53
            float r5 = r5.G()
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 == 0) goto L64
        L53:
            return r3
        L54:
            r5.U()
            goto L64
        L58:
            int r1 = r6.getPointerId(r0)
            r5.f4427f = r1
            r5.S()
            r5.a0(r6, r0)
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Lc.c.Y(android.view.MotionEvent):boolean");
    }

    public final void Z() {
        this.f4420E = 0.0f;
        this.f4419D = 0.0f;
    }

    public final void a() {
        i iVar = this.f4438q;
        if (iVar == null || !iVar.i()) {
            return;
        }
        this.f4438q.d();
    }

    public final void a0(MotionEvent motionEvent, int i10) {
        this.f4428g = I(motionEvent, i10);
        this.f4429h = J(motionEvent, i10);
    }

    public void b0(boolean z10) {
        this.f4433l = z10;
    }

    public void c0(float f10) {
        this.f4436o = f10;
    }

    public void d0(float f10) {
        this.f4425d = f10;
    }

    public void e0(boolean z10) {
        this.f4435n = z10;
    }

    public void f0(int i10) {
        this.f4441t = i10;
    }

    public void g0(boolean z10) {
        this.f4431j = z10;
    }

    public void h0(boolean z10) {
        this.f4434m = z10;
    }

    public void i0(float f10) {
        this.f4437p = f10;
    }

    public void j0(boolean z10) {
        this.f4432k = z10;
    }

    public final void k0(float f10) {
        this.f4423b.setTranslationX(f10);
    }

    public final void l0(float f10) {
        k0(f10);
        if (f10 != 0.0f && this.f4446y == 0.0f) {
            this.f4445x = 1;
            B();
        }
        if (f10 != 0.0f || this.f4446y != 0.0f) {
            A(f10, G());
        }
        this.f4446y = f10;
    }

    public final void m0(float f10) {
        this.f4423b.setTranslationY(f10);
    }

    public final void n0(float f10) {
        m0(f10);
        if (Float.compare(f10, 0.0f) != 0 && Float.compare(this.f4446y, 0.0f) == 0) {
            this.f4445x = 1;
            B();
        }
        if (Float.compare(f10, 0.0f) != 0 || Float.compare(this.f4446y, 0.0f) != 0) {
            A(F(), f10);
        }
        this.f4446y = f10;
    }

    public final boolean o0(int i10) {
        return E().q(i10, 0);
    }

    public final void p0() {
        E().s(0);
    }

    public void q(Lc.a aVar) {
        if (this.f4440s == null) {
            this.f4440s = new ArrayList();
        }
        this.f4440s.add(aVar);
    }

    public void r() {
        s(this.f4444w);
    }

    public void s(float f10) {
        t(f10, true);
    }

    public void t(float f10, boolean z10) {
        if (z10) {
            a();
            M(this.f4441t == 1, f10).t();
        } else {
            if (this.f4441t == 1) {
                this.f4423b.setTranslationY(f10);
            } else {
                this.f4423b.setTranslationX(f10);
            }
            A(this.f4423b.getTranslationX(), this.f4423b.getTranslationY());
        }
    }

    public final boolean u() {
        if (G() != 0.0f) {
            return false;
        }
        int[] iArr = this.f4447z;
        iArr[1] = 0;
        int[] iArr2 = this.f4416A;
        iArr2[1] = 0;
        z(-1, iArr, iArr2);
        int[] iArr3 = this.f4416A;
        boolean z10 = iArr3[1] != 0;
        if (z10) {
            int[] iArr4 = this.f4447z;
            iArr4[1] = 0;
            iArr3[1] = 0;
            y(1, iArr3, iArr4);
        }
        return this.f4423b.canScrollVertically(-1) || z10;
    }

    public final boolean v() {
        return this.f4423b.canScrollHorizontally(1);
    }

    public final boolean w() {
        return this.f4423b.canScrollHorizontally(-1);
    }

    public final boolean x() {
        int[] iArr = this.f4447z;
        iArr[1] = 0;
        int[] iArr2 = this.f4416A;
        iArr2[1] = 0;
        y(1, iArr2, iArr);
        int[] iArr3 = this.f4416A;
        boolean z10 = iArr3[1] != 0;
        if (z10) {
            int[] iArr4 = this.f4447z;
            iArr4[1] = 0;
            iArr3[1] = 0;
            z(-1, iArr4, iArr3);
        }
        return this.f4423b.canScrollVertically(1) || z10;
    }

    public final boolean y(int i10, int[] iArr, int[] iArr2) {
        return E().d(0, i10, iArr, iArr2, 0);
    }

    public final void z(int i10, int[] iArr, int[] iArr2) {
        E().e(0, 0, 0, i10, iArr, 0, iArr2);
    }

    public c(Context context, View view, OverScroller overScroller, int i10) {
        this.f4425d = 1.0f;
        this.f4431j = true;
        this.f4432k = true;
        this.f4433l = true;
        this.f4434m = true;
        this.f4435n = true;
        this.f4436o = 0.99f;
        this.f4437p = 228.0f;
        this.f4442u = true;
        this.f4444w = 0.0f;
        this.f4445x = 0;
        this.f4447z = new int[2];
        this.f4416A = new int[2];
        this.f4418C = false;
        this.f4419D = 0.0f;
        this.f4420E = 0.0f;
        this.f4421F = 0;
        this.f4422a = context;
        this.f4423b = view;
        this.f4441t = i10;
        if (overScroller == null) {
            this.f4426e = new OverScroller(context);
        } else {
            this.f4426e = overScroller;
        }
        this.f4424c = new RunnableC0077c();
        O(context);
    }
}
