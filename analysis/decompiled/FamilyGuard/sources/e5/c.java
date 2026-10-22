package e5;

import P.e;
import P.i;
import P.j;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.core.view.C0475u;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class c {

    /* renamed from: A, reason: collision with root package name */
    private final int[] f16713A;

    /* renamed from: B, reason: collision with root package name */
    private C0475u f16714B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f16715C;

    /* renamed from: D, reason: collision with root package name */
    private float f16716D;

    /* renamed from: E, reason: collision with root package name */
    private float f16717E;

    /* renamed from: F, reason: collision with root package name */
    private int f16718F;

    /* renamed from: a, reason: collision with root package name */
    private final Context f16719a;

    /* renamed from: b, reason: collision with root package name */
    private final View f16720b;

    /* renamed from: c, reason: collision with root package name */
    private final RunnableC0213c f16721c;

    /* renamed from: d, reason: collision with root package name */
    private float f16722d;

    /* renamed from: e, reason: collision with root package name */
    private OverScroller f16723e;

    /* renamed from: f, reason: collision with root package name */
    private int f16724f;

    /* renamed from: g, reason: collision with root package name */
    private int f16725g;

    /* renamed from: h, reason: collision with root package name */
    private int f16726h;

    /* renamed from: i, reason: collision with root package name */
    private int f16727i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f16728j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f16729k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f16730l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f16731m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f16732n;

    /* renamed from: o, reason: collision with root package name */
    private float f16733o;

    /* renamed from: p, reason: collision with root package name */
    private float f16734p;

    /* renamed from: q, reason: collision with root package name */
    private i f16735q;

    /* renamed from: r, reason: collision with root package name */
    private int f16736r;

    /* renamed from: s, reason: collision with root package name */
    private List<e5.a> f16737s;

    /* renamed from: t, reason: collision with root package name */
    private int f16738t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f16739u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f16740v;

    /* renamed from: w, reason: collision with root package name */
    private float f16741w;

    /* renamed from: x, reason: collision with root package name */
    private int f16742x;

    /* renamed from: y, reason: collision with root package name */
    private float f16743y;

    /* renamed from: z, reason: collision with root package name */
    private final int[] f16744z;

    class a implements e.r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f16745a;

        a(boolean z5) {
            this.f16745a = z5;
        }

        @Override // P.e.r
        public void a(e eVar, float f5, float f6) {
            c cVar = c.this;
            cVar.A(cVar.F(), c.this.G());
            c cVar2 = c.this;
            cVar2.f16717E = this.f16745a ? cVar2.G() : cVar2.F();
        }
    }

    class b implements e.q {
        b() {
        }

        @Override // P.e.q
        public void a(e eVar, boolean z5, float f5, float f6) {
            c.this.f16743y = 0.0f;
            if (z5) {
                return;
            }
            c.this.f16742x = 0;
            c.this.B();
        }
    }

    /* renamed from: e5.c$c, reason: collision with other inner class name */
    class RunnableC0213c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private int f16748a;

        /* renamed from: b, reason: collision with root package name */
        private int f16749b;

        RunnableC0213c() {
            c.this.f16723e = new OverScroller(c.this.f16719a);
        }

        void a() {
            if (c.this.f16723e.isFinished()) {
                return;
            }
            c.this.f16723e.abortAnimation();
        }

        void b(int i5, int i6) {
            this.f16748a = i5;
            this.f16749b = i6;
            c.this.f16723e.fling(0, 0, i5, i6, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            c();
        }

        void c() {
            c.this.f16720b.removeCallbacks(this);
            c.this.f16720b.postOnAnimation(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.f16723e.computeScrollOffset() || c.this.f16723e.isFinished()) {
                return;
            }
            boolean zU = c.this.u();
            boolean zX = c.this.x();
            c.this.f16723e.getCurrVelocity();
            int i5 = this.f16749b;
            if ((i5 < 0 && !zU) || (i5 > 0 && !zX)) {
                boolean z5 = c.this.f16723e.getStartY() > c.this.f16723e.getCurrY();
                float currVelocity = c.this.f16723e.getCurrVelocity();
                c cVar = c.this;
                if (!z5) {
                    currVelocity = -currVelocity;
                }
                cVar.R(currVelocity, true);
                a();
                return;
            }
            if ((this.f16748a >= 0 || c.this.w()) && (this.f16748a <= 0 || c.this.v())) {
                c();
                return;
            }
            boolean z6 = c.this.f16723e.getStartX() > c.this.f16723e.getCurrX();
            float currVelocity2 = c.this.f16723e.getCurrVelocity();
            c cVar2 = c.this;
            if (!z6) {
                currVelocity2 = -currVelocity2;
            }
            cVar2.R(currVelocity2, false);
            a();
        }
    }

    public c(Context context, View view, OverScroller overScroller) {
        this(context, view, overScroller, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        List<e5.a> list = this.f16737s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f16737s.get(size).b(this.f16720b, this.f16742x);
            }
        }
    }

    private Pair<Integer, Integer> D(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }

    private C0475u E() {
        if (this.f16714B == null) {
            C0475u c0475u = new C0475u(this.f16720b);
            this.f16714B = c0475u;
            c0475u.n(true);
        }
        return this.f16714B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float F() {
        return this.f16720b.getTranslationX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float G() {
        return this.f16720b.getTranslationY();
    }

    private int H() {
        View view;
        if (this.f16718F == 0 && (view = this.f16720b) != null) {
            this.f16718F = (int) a5.b.b(this.f16719a, this.f16738t == 1 ? view.getHeight() : view.getWidth());
        }
        return this.f16718F;
    }

    private int I(MotionEvent motionEvent, int i5) {
        return (int) motionEvent.getRawX(i5);
    }

    private int J(MotionEvent motionEvent, int i5) {
        return (int) motionEvent.getRawY(i5);
    }

    private void K(int i5) {
        char c6 = i5 < 0 ? (char) 65535 : (char) 1;
        boolean zW = w();
        boolean zV = v();
        float F5 = F();
        boolean z5 = (c6 == 1 && F5 > 0.0f) || (c6 == 65535 && F5 < 0.0f);
        float fX = X(i5, z5);
        if (z5) {
            l0(c6 == 1 ? Math.max(0.0f, fX) : Math.min(0.0f, fX));
            return;
        }
        if (c6 == 65535 && !zW && this.f16731m) {
            l0(fX);
        } else if (c6 == 1 && !zV && this.f16732n) {
            l0(fX);
        } else {
            Z();
        }
    }

    private void L(int i5) {
        if (i5 == 0) {
            return;
        }
        boolean z5 = false;
        boolean z6 = i5 < 0;
        if (!z6 || this.f16729k) {
            if (z6 || this.f16730l) {
                float fG = G();
                if ((z6 && fG < 0.0f) || (!z6 && fG > 0.0f)) {
                    z5 = true;
                }
                float fX = X(i5, z5);
                if (z6) {
                    boolean zU = u();
                    if (zU && !z5) {
                        Z();
                    }
                    if (zU || z5) {
                        fX = Math.min(0.0f, fX);
                    }
                } else {
                    boolean zX = x();
                    if (zX && !z5) {
                        Z();
                    }
                    if (zX || z5) {
                        fX = Math.max(0.0f, fX);
                    }
                }
                n0(fX);
            }
        }
    }

    private i M(boolean z5, float f5) {
        i iVarX = new i(this.f16720b, z5 ? e.f4489o : e.f4488n).x(new j(f5).f(this.f16733o).h(this.f16734p));
        this.f16735q = iVarX;
        iVarX.c(new a(z5));
        this.f16735q.b(new b());
        this.f16742x = 2;
        B();
        return this.f16735q;
    }

    private void N() {
        if (this.f16727i == 0) {
            Pair<Integer, Integer> pairD = D(this.f16719a);
            int i5 = this.f16738t;
            if (i5 == 1) {
                this.f16727i = ((Integer) pairD.second).intValue();
            } else if (i5 == 0) {
                this.f16727i = ((Integer) pairD.first).intValue();
            }
        }
    }

    private void O(Context context) {
        this.f16736r = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(float f5, boolean z5) {
        if (this.f16728j) {
            if (Math.abs(f5) >= this.f16736r) {
                M(z5, 0.0f).n(f5 * this.f16722d).p();
                return;
            }
            Log.w("SpringAnimationHelper", "velocity minus minVelocity:" + this.f16736r);
        }
    }

    private void S() {
        RunnableC0213c runnableC0213c = this.f16721c;
        if (runnableC0213c != null) {
            runnableC0213c.a();
        }
        a();
        o0(this.f16738t == 1 ? 2 : 1);
        this.f16715C = true;
    }

    private void T(MotionEvent motionEvent) {
        if (this.f16728j) {
            a();
            RunnableC0213c runnableC0213c = this.f16721c;
            if (runnableC0213c != null) {
                runnableC0213c.a();
            }
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f16724f);
            if (iFindPointerIndex < 0) {
                Log.w("SpringAnimationHelper", "Error processing scroll, pointer index for id " + this.f16724f + " not found. Did any MotionEvent get skipped?");
                iFindPointerIndex = 0;
                this.f16724f = motionEvent.getPointerId(0);
                this.f16726h = (int) motionEvent.getRawY();
                this.f16725g = (int) motionEvent.getRawX();
            }
            N();
            if (!this.f16715C) {
                o0(this.f16738t == 1 ? 2 : 1);
            }
            int iJ = this.f16726h - J(motionEvent, iFindPointerIndex);
            int I5 = this.f16725g - I(motionEvent, iFindPointerIndex);
            int i5 = this.f16738t;
            if (i5 == 1) {
                L(iJ);
            } else if (i5 == 0) {
                K(I5);
            }
            a0(motionEvent, iFindPointerIndex);
        }
    }

    private void U() {
        p0();
        this.f16715C = false;
        this.f16740v = false;
        if (!this.f16739u) {
            this.f16726h = 0;
            this.f16725g = 0;
            A(F(), G());
            return;
        }
        if (G() != 0.0f) {
            M(true, this.f16741w).p();
        } else if (F() != 0.0f) {
            M(false, this.f16741w).p();
        } else if (G() == 0.0f || F() == 0.0f) {
            this.f16742x = 0;
        }
        this.f16725g = 0;
        this.f16726h = 0;
    }

    private void W(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f16724f) {
            int i5 = actionIndex == 0 ? 1 : 0;
            this.f16724f = motionEvent.getPointerId(i5);
            this.f16725g = I(motionEvent, i5);
            this.f16726h = J(motionEvent, i5);
        }
    }

    private float X(float f5, boolean z5) {
        float fB = a5.b.b(this.f16719a, f5);
        if (z5 || this.f16742x != 1) {
            this.f16716D = e5.b.a(Math.abs(a5.b.b(this.f16719a, this.f16717E)), H()) * Math.signum(-this.f16717E);
        }
        float f6 = this.f16716D + fB;
        this.f16716D = f6;
        float fA = a5.b.a(this.f16719a, (-e5.b.b(Math.abs(f6), H())) * Math.signum(f6));
        this.f16717E = fA;
        return fA;
    }

    private void Z() {
        this.f16717E = 0.0f;
        this.f16716D = 0.0f;
    }

    private void a() {
        i iVar = this.f16735q;
        if (iVar == null || !iVar.i()) {
            return;
        }
        this.f16735q.d();
    }

    private void a0(MotionEvent motionEvent, int i5) {
        this.f16725g = I(motionEvent, i5);
        this.f16726h = J(motionEvent, i5);
    }

    private void k0(float f5) {
        this.f16720b.setTranslationX(f5);
    }

    private void l0(float f5) {
        k0(f5);
        if (f5 != 0.0f && this.f16743y == 0.0f) {
            this.f16742x = 1;
            B();
        }
        if (f5 != 0.0f || this.f16743y != 0.0f) {
            A(f5, G());
        }
        this.f16743y = f5;
    }

    private void m0(float f5) {
        this.f16720b.setTranslationY(f5);
    }

    private void n0(float f5) {
        m0(f5);
        if (Float.compare(f5, 0.0f) != 0 && Float.compare(this.f16743y, 0.0f) == 0) {
            this.f16742x = 1;
            B();
        }
        if (Float.compare(f5, 0.0f) != 0 || Float.compare(this.f16743y, 0.0f) != 0) {
            A(F(), f5);
        }
        this.f16743y = f5;
    }

    private boolean o0(int i5) {
        return E().q(i5, 0);
    }

    private void p0() {
        E().s(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        if (G() != 0.0f) {
            return false;
        }
        int[] iArr = this.f16744z;
        iArr[1] = 0;
        int[] iArr2 = this.f16713A;
        iArr2[1] = 0;
        z(-1, iArr, iArr2);
        int[] iArr3 = this.f16713A;
        boolean z5 = iArr3[1] != 0;
        if (z5) {
            int[] iArr4 = this.f16744z;
            iArr4[1] = 0;
            iArr3[1] = 0;
            y(1, iArr3, iArr4);
        }
        return this.f16720b.canScrollVertically(-1) || z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        return this.f16720b.canScrollHorizontally(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        return this.f16720b.canScrollHorizontally(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        int[] iArr = this.f16744z;
        iArr[1] = 0;
        int[] iArr2 = this.f16713A;
        iArr2[1] = 0;
        y(1, iArr2, iArr);
        int[] iArr3 = this.f16713A;
        boolean z5 = iArr3[1] != 0;
        if (z5) {
            int[] iArr4 = this.f16744z;
            iArr4[1] = 0;
            iArr3[1] = 0;
            z(-1, iArr4, iArr3);
        }
        return this.f16720b.canScrollVertically(1) || z5;
    }

    private boolean y(int i5, int[] iArr, int[] iArr2) {
        return E().d(0, i5, iArr, iArr2, 0);
    }

    private void z(int i5, int[] iArr, int[] iArr2) {
        E().e(0, 0, 0, i5, iArr, 0, iArr2);
    }

    public void A(float f5, float f6) {
        List<e5.a> list = this.f16737s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f16737s.get(size).a(this.f16720b, f5, f6);
            }
        }
    }

    public void C(int i5, int i6) {
        if (this.f16728j) {
            if (Math.abs(i5) >= this.f16736r || Math.abs(i6) >= this.f16736r) {
                if (i6 >= 0 || this.f16729k) {
                    if (i6 <= 0 || this.f16730l) {
                        if (i5 >= 0 || this.f16731m) {
                            if (i5 <= 0 || this.f16732n) {
                                i iVar = this.f16735q;
                                if (iVar != null && iVar.i()) {
                                    Log.w("SpringAnimationHelper", "animation already running....");
                                    return;
                                }
                                RunnableC0213c runnableC0213c = this.f16721c;
                                if (runnableC0213c != null) {
                                    runnableC0213c.b(i5, i6);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean P() {
        int i5 = this.f16742x;
        return i5 == 1 || i5 == 2;
    }

    public boolean Q() {
        return this.f16728j;
    }

    public void V(MotionEvent motionEvent) {
        if (motionEvent == null || !this.f16728j) {
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
        this.f16724f = motionEvent.getPointerId(0);
        S();
        a0(motionEvent, 0);
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
            boolean r1 = r5.f16728j
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
            r5.f16724f = r1
            r5.S()
            r5.a0(r6, r2)
            goto L64
        L33:
            int r1 = r5.f16725g
            if (r1 != 0) goto L3f
            int r1 = r5.f16726h
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
            r5.f16724f = r1
            r5.S()
            r5.a0(r6, r0)
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.c.Y(android.view.MotionEvent):boolean");
    }

    public void b0(boolean z5) {
        this.f16730l = z5;
    }

    public void c0(float f5) {
        this.f16733o = f5;
    }

    public void d0(float f5) {
        this.f16722d = f5;
    }

    public void e0(boolean z5) {
        this.f16732n = z5;
    }

    public void f0(int i5) {
        this.f16738t = i5;
    }

    public void g0(boolean z5) {
        this.f16728j = z5;
    }

    public void h0(boolean z5) {
        this.f16731m = z5;
    }

    public void i0(float f5) {
        this.f16734p = f5;
    }

    public void j0(boolean z5) {
        this.f16729k = z5;
    }

    public void q(e5.a aVar) {
        if (this.f16737s == null) {
            this.f16737s = new ArrayList();
        }
        this.f16737s.add(aVar);
    }

    public void r() {
        s(this.f16741w);
    }

    public void s(float f5) {
        t(f5, true);
    }

    public void t(float f5, boolean z5) {
        if (z5) {
            a();
            M(this.f16738t == 1, f5).p();
        } else {
            if (this.f16738t == 1) {
                this.f16720b.setTranslationY(f5);
            } else {
                this.f16720b.setTranslationX(f5);
            }
            A(this.f16720b.getTranslationX(), this.f16720b.getTranslationY());
        }
    }

    public c(Context context, View view, OverScroller overScroller, int i5) {
        this.f16722d = 1.0f;
        this.f16728j = true;
        this.f16729k = true;
        this.f16730l = true;
        this.f16731m = true;
        this.f16732n = true;
        this.f16733o = 0.99f;
        this.f16734p = 228.0f;
        this.f16739u = true;
        this.f16741w = 0.0f;
        this.f16742x = 0;
        this.f16744z = new int[2];
        this.f16713A = new int[2];
        this.f16715C = false;
        this.f16716D = 0.0f;
        this.f16717E = 0.0f;
        this.f16718F = 0;
        this.f16719a = context;
        this.f16720b = view;
        this.f16738t = i5;
        if (overScroller == null) {
            this.f16723e = new OverScroller(context);
        } else {
            this.f16723e = overScroller;
        }
        this.f16721c = new RunnableC0213c();
        O(context);
    }
}
