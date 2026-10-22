package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;
import l0.C4855a;
import l0.C4856b;

/* loaded from: classes.dex */
public class c {

    /* renamed from: s, reason: collision with root package name */
    public static boolean f11873s = false;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f11874t = true;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f11875u = true;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f11876v = true;

    /* renamed from: w, reason: collision with root package name */
    public static boolean f11877w = false;

    /* renamed from: x, reason: collision with root package name */
    public static long f11878x;

    /* renamed from: y, reason: collision with root package name */
    public static long f11879y;

    /* renamed from: e, reason: collision with root package name */
    public a f11884e;

    /* renamed from: o, reason: collision with root package name */
    public final C4855a f11894o;

    /* renamed from: r, reason: collision with root package name */
    public a f11897r;

    /* renamed from: a, reason: collision with root package name */
    public int f11880a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11881b = false;

    /* renamed from: c, reason: collision with root package name */
    public int f11882c = 0;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, SolverVariable> f11883d = null;

    /* renamed from: f, reason: collision with root package name */
    public int f11885f = 32;

    /* renamed from: g, reason: collision with root package name */
    public int f11886g = 32;

    /* renamed from: i, reason: collision with root package name */
    public boolean f11888i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f11889j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean[] f11890k = new boolean[32];

    /* renamed from: l, reason: collision with root package name */
    public int f11891l = 1;

    /* renamed from: m, reason: collision with root package name */
    public int f11892m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f11893n = 32;

    /* renamed from: p, reason: collision with root package name */
    public SolverVariable[] f11895p = new SolverVariable[1000];

    /* renamed from: q, reason: collision with root package name */
    public int f11896q = 0;

    /* renamed from: h, reason: collision with root package name */
    public androidx.constraintlayout.core.b[] f11887h = new androidx.constraintlayout.core.b[32];

    public interface a {
        void a(a aVar);

        SolverVariable b(c cVar, boolean[] zArr);

        void c(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        boolean isEmpty();
    }

    public static class b extends androidx.constraintlayout.core.b {
        public b(C4855a c4855a) {
            this.f11871e = new e(this, c4855a);
        }
    }

    public c() {
        D();
        C4855a c4855a = new C4855a();
        this.f11894o = c4855a;
        this.f11884e = new d(c4855a);
        if (f11877w) {
            this.f11897r = new b(c4855a);
        } else {
            this.f11897r = new androidx.constraintlayout.core.b(c4855a);
        }
    }

    public static androidx.constraintlayout.core.b s(c cVar, SolverVariable solverVariable, SolverVariable solverVariable2, float f10) {
        return cVar.r().j(solverVariable, solverVariable2, f10);
    }

    public static C4856b x() {
        return null;
    }

    public void A() throws Exception {
        if (this.f11884e.isEmpty()) {
            n();
            return;
        }
        if (!this.f11888i && !this.f11889j) {
            B(this.f11884e);
            return;
        }
        for (int i10 = 0; i10 < this.f11892m; i10++) {
            if (!this.f11887h[i10].f11872f) {
                B(this.f11884e);
                return;
            }
        }
        n();
    }

    public void B(a aVar) throws Exception {
        u(aVar);
        C(aVar, false);
        n();
    }

    public final int C(a aVar, boolean z10) {
        for (int i10 = 0; i10 < this.f11891l; i10++) {
            this.f11890k[i10] = false;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            i11++;
            if (i11 < this.f11891l * 2) {
                if (aVar.getKey() != null) {
                    this.f11890k[aVar.getKey().f11840c] = true;
                }
                SolverVariable solverVariableB = aVar.b(this, this.f11890k);
                if (solverVariableB != null) {
                    boolean[] zArr = this.f11890k;
                    int i12 = solverVariableB.f11840c;
                    if (!zArr[i12]) {
                        zArr[i12] = true;
                    }
                }
                if (solverVariableB != null) {
                    float f10 = Float.MAX_VALUE;
                    int i13 = -1;
                    for (int i14 = 0; i14 < this.f11892m; i14++) {
                        androidx.constraintlayout.core.b bVar = this.f11887h[i14];
                        if (bVar.f11867a.f11847j != SolverVariable.Type.UNRESTRICTED && !bVar.f11872f && bVar.t(solverVariableB)) {
                            float fI = bVar.f11871e.i(solverVariableB);
                            if (fI < 0.0f) {
                                float f11 = (-bVar.f11868b) / fI;
                                if (f11 < f10) {
                                    i13 = i14;
                                    f10 = f11;
                                }
                            }
                        }
                    }
                    if (i13 > -1) {
                        androidx.constraintlayout.core.b bVar2 = this.f11887h[i13];
                        bVar2.f11867a.f11841d = -1;
                        bVar2.x(solverVariableB);
                        SolverVariable solverVariable = bVar2.f11867a;
                        solverVariable.f11841d = i13;
                        solverVariable.l(this, bVar2);
                    }
                } else {
                    z11 = true;
                }
            }
            return i11;
        }
        return i11;
    }

    public final void D() {
        int i10 = 0;
        if (f11877w) {
            while (i10 < this.f11892m) {
                androidx.constraintlayout.core.b bVar = this.f11887h[i10];
                if (bVar != null) {
                    this.f11894o.f36868a.release(bVar);
                }
                this.f11887h[i10] = null;
                i10++;
            }
            return;
        }
        while (i10 < this.f11892m) {
            androidx.constraintlayout.core.b bVar2 = this.f11887h[i10];
            if (bVar2 != null) {
                this.f11894o.f36869b.release(bVar2);
            }
            this.f11887h[i10] = null;
            i10++;
        }
    }

    public void E() {
        C4855a c4855a;
        int i10 = 0;
        while (true) {
            c4855a = this.f11894o;
            SolverVariable[] solverVariableArr = c4855a.f36871d;
            if (i10 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i10];
            if (solverVariable != null) {
                solverVariable.i();
            }
            i10++;
        }
        c4855a.f36870c.a(this.f11895p, this.f11896q);
        this.f11896q = 0;
        Arrays.fill(this.f11894o.f36871d, (Object) null);
        HashMap<String, SolverVariable> map = this.f11883d;
        if (map != null) {
            map.clear();
        }
        this.f11882c = 0;
        this.f11884e.clear();
        this.f11891l = 1;
        for (int i11 = 0; i11 < this.f11892m; i11++) {
            androidx.constraintlayout.core.b bVar = this.f11887h[i11];
            if (bVar != null) {
                bVar.f11869c = false;
            }
        }
        D();
        this.f11892m = 0;
        if (f11877w) {
            this.f11897r = new b(this.f11894o);
        } else {
            this.f11897r = new androidx.constraintlayout.core.b(this.f11894o);
        }
    }

    public final SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable solverVariableAcquire = this.f11894o.f36870c.acquire();
        if (solverVariableAcquire == null) {
            solverVariableAcquire = new SolverVariable(type, str);
            solverVariableAcquire.k(type, str);
        } else {
            solverVariableAcquire.i();
            solverVariableAcquire.k(type, str);
        }
        int i10 = this.f11896q;
        int i11 = this.f11880a;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            this.f11880a = i12;
            this.f11895p = (SolverVariable[]) Arrays.copyOf(this.f11895p, i12);
        }
        SolverVariable[] solverVariableArr = this.f11895p;
        int i13 = this.f11896q;
        this.f11896q = i13 + 1;
        solverVariableArr[i13] = solverVariableAcquire;
        return solverVariableAcquire;
    }

    public void b(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f10, int i10) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable solverVariableQ = q(constraintWidget.q(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable solverVariableQ2 = q(constraintWidget.q(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable solverVariableQ3 = q(constraintWidget.q(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable solverVariableQ4 = q(constraintWidget.q(type4));
        SolverVariable solverVariableQ5 = q(constraintWidget2.q(type));
        SolverVariable solverVariableQ6 = q(constraintWidget2.q(type2));
        SolverVariable solverVariableQ7 = q(constraintWidget2.q(type3));
        SolverVariable solverVariableQ8 = q(constraintWidget2.q(type4));
        androidx.constraintlayout.core.b bVarR = r();
        double d10 = f10;
        double d11 = i10;
        bVarR.q(solverVariableQ2, solverVariableQ4, solverVariableQ6, solverVariableQ8, (float) (Math.sin(d10) * d11));
        d(bVarR);
        androidx.constraintlayout.core.b bVarR2 = r();
        bVarR2.q(solverVariableQ, solverVariableQ3, solverVariableQ5, solverVariableQ7, (float) (Math.cos(d10) * d11));
        d(bVarR2);
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, float f10, SolverVariable solverVariable3, SolverVariable solverVariable4, int i11, int i12) {
        androidx.constraintlayout.core.b bVarR = r();
        bVarR.h(solverVariable, solverVariable2, i10, f10, solverVariable3, solverVariable4, i11);
        if (i12 != 8) {
            bVarR.d(this, i12);
        }
        d(bVarR);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(androidx.constraintlayout.core.b r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L4
            goto L8a
        L4:
            int r0 = r5.f11892m
            r1 = 1
            int r0 = r0 + r1
            int r2 = r5.f11893n
            if (r0 >= r2) goto L13
            int r0 = r5.f11891l
            int r0 = r0 + r1
            int r2 = r5.f11886g
            if (r0 < r2) goto L16
        L13:
            r5.z()
        L16:
            boolean r0 = r6.f11872f
            r2 = 0
            if (r0 != 0) goto L85
            r6.D(r5)
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L25
            goto L8a
        L25:
            r6.r()
            boolean r0 = r6.f(r5)
            if (r0 == 0) goto L7c
            androidx.constraintlayout.core.SolverVariable r0 = r5.p()
            r6.f11867a = r0
            int r3 = r5.f11892m
            r5.l(r6)
            int r4 = r5.f11892m
            int r3 = r3 + r1
            if (r4 != r3) goto L7c
            androidx.constraintlayout.core.c$a r2 = r5.f11897r
            r2.a(r6)
            androidx.constraintlayout.core.c$a r2 = r5.f11897r
            r5.C(r2, r1)
            int r2 = r0.f11841d
            r3 = -1
            if (r2 != r3) goto L7d
            androidx.constraintlayout.core.SolverVariable r2 = r6.f11867a
            if (r2 != r0) goto L5a
            androidx.constraintlayout.core.SolverVariable r0 = r6.v(r0)
            if (r0 == 0) goto L5a
            r6.x(r0)
        L5a:
            boolean r0 = r6.f11872f
            if (r0 != 0) goto L63
            androidx.constraintlayout.core.SolverVariable r0 = r6.f11867a
            r0.l(r5, r6)
        L63:
            boolean r0 = androidx.constraintlayout.core.c.f11877w
            if (r0 == 0) goto L6f
            l0.a r0 = r5.f11894o
            l0.c<androidx.constraintlayout.core.b> r0 = r0.f36868a
            r0.release(r6)
            goto L76
        L6f:
            l0.a r0 = r5.f11894o
            l0.c<androidx.constraintlayout.core.b> r0 = r0.f36869b
            r0.release(r6)
        L76:
            int r0 = r5.f11892m
            int r0 = r0 - r1
            r5.f11892m = r0
            goto L7d
        L7c:
            r1 = r2
        L7d:
            boolean r0 = r6.s()
            if (r0 != 0) goto L84
            goto L8a
        L84:
            r2 = r1
        L85:
            if (r2 != 0) goto L8a
            r5.l(r6)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.c.d(androidx.constraintlayout.core.b):void");
    }

    public androidx.constraintlayout.core.b e(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        if (f11874t && i11 == 8 && solverVariable2.f11844g && solverVariable.f11841d == -1) {
            solverVariable.j(this, solverVariable2.f11843f + i10);
            return null;
        }
        androidx.constraintlayout.core.b bVarR = r();
        bVarR.n(solverVariable, solverVariable2, i10);
        if (i11 != 8) {
            bVarR.d(this, i11);
        }
        d(bVarR);
        return bVarR;
    }

    public void f(SolverVariable solverVariable, int i10) {
        if (f11874t && solverVariable.f11841d == -1) {
            float f10 = i10;
            solverVariable.j(this, f10);
            for (int i11 = 0; i11 < this.f11882c + 1; i11++) {
                SolverVariable solverVariable2 = this.f11894o.f36871d[i11];
                if (solverVariable2 != null && solverVariable2.f11851n && solverVariable2.f11852o == solverVariable.f11840c) {
                    solverVariable2.j(this, solverVariable2.f11853p + f10);
                }
            }
            return;
        }
        int i12 = solverVariable.f11841d;
        if (i12 == -1) {
            androidx.constraintlayout.core.b bVarR = r();
            bVarR.i(solverVariable, i10);
            d(bVarR);
            return;
        }
        androidx.constraintlayout.core.b bVar = this.f11887h[i12];
        if (bVar.f11872f) {
            bVar.f11868b = i10;
            return;
        }
        if (bVar.f11871e.getCurrentSize() == 0) {
            bVar.f11872f = true;
            bVar.f11868b = i10;
        } else {
            androidx.constraintlayout.core.b bVarR2 = r();
            bVarR2.m(solverVariable, i10);
            d(bVarR2);
        }
    }

    public void g(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z10) {
        androidx.constraintlayout.core.b bVarR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.f11842e = 0;
        bVarR.o(solverVariable, solverVariable2, solverVariableT, i10);
        d(bVarR);
    }

    public void h(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        androidx.constraintlayout.core.b bVarR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.f11842e = 0;
        bVarR.o(solverVariable, solverVariable2, solverVariableT, i10);
        if (i11 != 8) {
            m(bVarR, (int) (bVarR.f11871e.i(solverVariableT) * (-1.0f)), i11);
        }
        d(bVarR);
    }

    public void i(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z10) {
        androidx.constraintlayout.core.b bVarR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.f11842e = 0;
        bVarR.p(solverVariable, solverVariable2, solverVariableT, i10);
        d(bVarR);
    }

    public void j(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        androidx.constraintlayout.core.b bVarR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.f11842e = 0;
        bVarR.p(solverVariable, solverVariable2, solverVariableT, i10);
        if (i11 != 8) {
            m(bVarR, (int) (bVarR.f11871e.i(solverVariableT) * (-1.0f)), i11);
        }
        d(bVarR);
    }

    public void k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10, int i10) {
        androidx.constraintlayout.core.b bVarR = r();
        bVarR.k(solverVariable, solverVariable2, solverVariable3, solverVariable4, f10);
        if (i10 != 8) {
            bVarR.d(this, i10);
        }
        d(bVarR);
    }

    public final void l(androidx.constraintlayout.core.b bVar) {
        int i10;
        if (f11875u && bVar.f11872f) {
            bVar.f11867a.j(this, bVar.f11868b);
        } else {
            androidx.constraintlayout.core.b[] bVarArr = this.f11887h;
            int i11 = this.f11892m;
            bVarArr[i11] = bVar;
            SolverVariable solverVariable = bVar.f11867a;
            solverVariable.f11841d = i11;
            this.f11892m = i11 + 1;
            solverVariable.l(this, bVar);
        }
        if (f11875u && this.f11881b) {
            int i12 = 0;
            while (i12 < this.f11892m) {
                if (this.f11887h[i12] == null) {
                    System.out.println("WTF");
                }
                androidx.constraintlayout.core.b bVar2 = this.f11887h[i12];
                if (bVar2 != null && bVar2.f11872f) {
                    bVar2.f11867a.j(this, bVar2.f11868b);
                    if (f11877w) {
                        this.f11894o.f36868a.release(bVar2);
                    } else {
                        this.f11894o.f36869b.release(bVar2);
                    }
                    this.f11887h[i12] = null;
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        i10 = this.f11892m;
                        if (i13 >= i10) {
                            break;
                        }
                        androidx.constraintlayout.core.b[] bVarArr2 = this.f11887h;
                        int i15 = i13 - 1;
                        androidx.constraintlayout.core.b bVar3 = bVarArr2[i13];
                        bVarArr2[i15] = bVar3;
                        SolverVariable solverVariable2 = bVar3.f11867a;
                        if (solverVariable2.f11841d == i13) {
                            solverVariable2.f11841d = i15;
                        }
                        i14 = i13;
                        i13++;
                    }
                    if (i14 < i10) {
                        this.f11887h[i14] = null;
                    }
                    this.f11892m = i10 - 1;
                    i12--;
                }
                i12++;
            }
            this.f11881b = false;
        }
    }

    public void m(androidx.constraintlayout.core.b bVar, int i10, int i11) {
        bVar.e(o(i11, null), i10);
    }

    public final void n() {
        for (int i10 = 0; i10 < this.f11892m; i10++) {
            androidx.constraintlayout.core.b bVar = this.f11887h[i10];
            bVar.f11867a.f11843f = bVar.f11868b;
        }
    }

    public SolverVariable o(int i10, String str) {
        if (this.f11891l + 1 >= this.f11886g) {
            z();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.ERROR, str);
        int i11 = this.f11882c + 1;
        this.f11882c = i11;
        this.f11891l++;
        solverVariableA.f11840c = i11;
        solverVariableA.f11842e = i10;
        this.f11894o.f36871d[i11] = solverVariableA;
        this.f11884e.c(solverVariableA);
        return solverVariableA;
    }

    public SolverVariable p() {
        if (this.f11891l + 1 >= this.f11886g) {
            z();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.SLACK, null);
        int i10 = this.f11882c + 1;
        this.f11882c = i10;
        this.f11891l++;
        solverVariableA.f11840c = i10;
        this.f11894o.f36871d[i10] = solverVariableA;
        return solverVariableA;
    }

    public SolverVariable q(Object obj) {
        SolverVariable solverVariableI = null;
        if (obj == null) {
            return null;
        }
        if (this.f11891l + 1 >= this.f11886g) {
            z();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariableI = constraintAnchor.i();
            if (solverVariableI == null) {
                constraintAnchor.s(this.f11894o);
                solverVariableI = constraintAnchor.i();
            }
            int i10 = solverVariableI.f11840c;
            if (i10 != -1 && i10 <= this.f11882c && this.f11894o.f36871d[i10] != null) {
                return solverVariableI;
            }
            if (i10 != -1) {
                solverVariableI.i();
            }
            int i11 = this.f11882c + 1;
            this.f11882c = i11;
            this.f11891l++;
            solverVariableI.f11840c = i11;
            solverVariableI.f11847j = SolverVariable.Type.UNRESTRICTED;
            this.f11894o.f36871d[i11] = solverVariableI;
        }
        return solverVariableI;
    }

    public androidx.constraintlayout.core.b r() {
        androidx.constraintlayout.core.b bVarAcquire;
        if (f11877w) {
            bVarAcquire = this.f11894o.f36868a.acquire();
            if (bVarAcquire == null) {
                bVarAcquire = new b(this.f11894o);
                f11879y++;
            } else {
                bVarAcquire.y();
            }
        } else {
            bVarAcquire = this.f11894o.f36869b.acquire();
            if (bVarAcquire == null) {
                bVarAcquire = new androidx.constraintlayout.core.b(this.f11894o);
                f11878x++;
            } else {
                bVarAcquire.y();
            }
        }
        SolverVariable.c();
        return bVarAcquire;
    }

    public SolverVariable t() {
        if (this.f11891l + 1 >= this.f11886g) {
            z();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.SLACK, null);
        int i10 = this.f11882c + 1;
        this.f11882c = i10;
        this.f11891l++;
        solverVariableA.f11840c = i10;
        this.f11894o.f36871d[i10] = solverVariableA;
        return solverVariableA;
    }

    public final int u(a aVar) throws Exception {
        float f10;
        float f11;
        for (int i10 = 0; i10 < this.f11892m; i10++) {
            androidx.constraintlayout.core.b bVar = this.f11887h[i10];
            if (bVar.f11867a.f11847j != SolverVariable.Type.UNRESTRICTED) {
                float f12 = 0.0f;
                if (bVar.f11868b < 0.0f) {
                    boolean z10 = false;
                    int i11 = 0;
                    while (!z10) {
                        i11++;
                        float f13 = Float.MAX_VALUE;
                        int i12 = 0;
                        int i13 = -1;
                        int i14 = -1;
                        int i15 = 0;
                        while (true) {
                            if (i12 >= this.f11892m) {
                                break;
                            }
                            androidx.constraintlayout.core.b bVar2 = this.f11887h[i12];
                            if (bVar2.f11867a.f11847j == SolverVariable.Type.UNRESTRICTED || bVar2.f11872f || bVar2.f11868b >= f12) {
                                f10 = f12;
                            } else if (f11876v) {
                                int currentSize = bVar2.f11871e.getCurrentSize();
                                int i16 = 0;
                                while (i16 < currentSize) {
                                    SolverVariable solverVariableB = bVar2.f11871e.b(i16);
                                    float fI = bVar2.f11871e.i(solverVariableB);
                                    if (fI <= f12) {
                                        f11 = f12;
                                    } else {
                                        f11 = f12;
                                        for (int i17 = 0; i17 < 9; i17++) {
                                            float f14 = solverVariableB.f11845h[i17] / fI;
                                            if ((f14 < f13 && i17 == i15) || i17 > i15) {
                                                i15 = i17;
                                                i14 = solverVariableB.f11840c;
                                                i13 = i12;
                                                f13 = f14;
                                            }
                                        }
                                    }
                                    i16++;
                                    f12 = f11;
                                }
                                f10 = f12;
                            } else {
                                f10 = f12;
                                for (int i18 = 1; i18 < this.f11891l; i18++) {
                                    SolverVariable solverVariable = this.f11894o.f36871d[i18];
                                    float fI2 = bVar2.f11871e.i(solverVariable);
                                    if (fI2 > f10) {
                                        for (int i19 = 0; i19 < 9; i19++) {
                                            float f15 = solverVariable.f11845h[i19] / fI2;
                                            if ((f15 < f13 && i19 == i15) || i19 > i15) {
                                                i15 = i19;
                                                i13 = i12;
                                                i14 = i18;
                                                f13 = f15;
                                            }
                                        }
                                    }
                                }
                            }
                            i12++;
                            f12 = f10;
                        }
                        float f16 = f12;
                        if (i13 != -1) {
                            androidx.constraintlayout.core.b bVar3 = this.f11887h[i13];
                            bVar3.f11867a.f11841d = -1;
                            bVar3.x(this.f11894o.f36871d[i14]);
                            SolverVariable solverVariable2 = bVar3.f11867a;
                            solverVariable2.f11841d = i13;
                            solverVariable2.l(this, bVar3);
                        } else {
                            z10 = true;
                        }
                        if (i11 > this.f11891l / 2) {
                            z10 = true;
                        }
                        f12 = f16;
                    }
                    return i11;
                }
            }
        }
        return 0;
    }

    public void v(C4856b c4856b) {
    }

    public C4855a w() {
        return this.f11894o;
    }

    public int y(Object obj) {
        SolverVariable solverVariableI = ((ConstraintAnchor) obj).i();
        if (solverVariableI != null) {
            return (int) (solverVariableI.f11843f + 0.5f);
        }
        return 0;
    }

    public final void z() {
        int i10 = this.f11885f * 2;
        this.f11885f = i10;
        this.f11887h = (androidx.constraintlayout.core.b[]) Arrays.copyOf(this.f11887h, i10);
        C4855a c4855a = this.f11894o;
        c4855a.f36871d = (SolverVariable[]) Arrays.copyOf(c4855a.f36871d, this.f11885f);
        int i11 = this.f11885f;
        this.f11890k = new boolean[i11];
        this.f11886g = i11;
        this.f11893n = i11;
    }
}
