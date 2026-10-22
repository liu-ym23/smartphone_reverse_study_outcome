package v;

import java.util.ArrayList;
import v.e;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected e f22977a;

    /* renamed from: b, reason: collision with root package name */
    protected e f22978b;

    /* renamed from: c, reason: collision with root package name */
    protected e f22979c;

    /* renamed from: d, reason: collision with root package name */
    protected e f22980d;

    /* renamed from: e, reason: collision with root package name */
    protected e f22981e;

    /* renamed from: f, reason: collision with root package name */
    protected e f22982f;

    /* renamed from: g, reason: collision with root package name */
    protected e f22983g;

    /* renamed from: h, reason: collision with root package name */
    protected ArrayList<e> f22984h;

    /* renamed from: i, reason: collision with root package name */
    protected int f22985i;

    /* renamed from: j, reason: collision with root package name */
    protected int f22986j;

    /* renamed from: k, reason: collision with root package name */
    protected float f22987k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    int f22988l;

    /* renamed from: m, reason: collision with root package name */
    int f22989m;

    /* renamed from: n, reason: collision with root package name */
    int f22990n;

    /* renamed from: o, reason: collision with root package name */
    boolean f22991o;

    /* renamed from: p, reason: collision with root package name */
    private int f22992p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f22993q;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f22994r;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f22995s;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f22996t;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f22997u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f22998v;

    public c(e eVar, int i5, boolean z5) {
        this.f22977a = eVar;
        this.f22992p = i5;
        this.f22993q = z5;
    }

    private void b() {
        int i5 = this.f22992p * 2;
        e eVar = this.f22977a;
        this.f22991o = true;
        e eVar2 = eVar;
        boolean z5 = false;
        while (!z5) {
            this.f22985i++;
            e[] eVarArr = eVar.f23031F0;
            int i6 = this.f22992p;
            e eVar3 = null;
            eVarArr[i6] = null;
            eVar.f23029E0[i6] = null;
            if (eVar.V() != 8) {
                this.f22988l++;
                e.b bVarU = eVar.u(this.f22992p);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarU != bVar) {
                    this.f22989m += eVar.E(this.f22992p);
                }
                int iF = this.f22989m + eVar.f23052W[i5].f();
                this.f22989m = iF;
                int i7 = i5 + 1;
                this.f22989m = iF + eVar.f23052W[i7].f();
                int iF2 = this.f22990n + eVar.f23052W[i5].f();
                this.f22990n = iF2;
                this.f22990n = iF2 + eVar.f23052W[i7].f();
                if (this.f22978b == null) {
                    this.f22978b = eVar;
                }
                this.f22980d = eVar;
                e.b[] bVarArr = eVar.f23055Z;
                int i8 = this.f22992p;
                if (bVarArr[i8] == bVar) {
                    int i9 = eVar.f23104y[i8];
                    if (i9 == 0 || i9 == 3 || i9 == 2) {
                        this.f22986j++;
                        float f5 = eVar.f23027D0[i8];
                        if (f5 > 0.0f) {
                            this.f22987k += f5;
                        }
                        if (c(eVar, i8)) {
                            if (f5 < 0.0f) {
                                this.f22994r = true;
                            } else {
                                this.f22995s = true;
                            }
                            if (this.f22984h == null) {
                                this.f22984h = new ArrayList<>();
                            }
                            this.f22984h.add(eVar);
                        }
                        if (this.f22982f == null) {
                            this.f22982f = eVar;
                        }
                        e eVar4 = this.f22983g;
                        if (eVar4 != null) {
                            eVar4.f23029E0[this.f22992p] = eVar;
                        }
                        this.f22983g = eVar;
                    }
                    if (this.f22992p == 0) {
                        if (eVar.f23100w != 0 || eVar.f23106z != 0 || eVar.f23020A != 0) {
                            this.f22991o = false;
                        }
                    } else if (eVar.f23102x != 0 || eVar.f23024C != 0 || eVar.f23026D != 0) {
                        this.f22991o = false;
                    }
                    if (eVar.f23063d0 != 0.0f) {
                        this.f22991o = false;
                        this.f22997u = true;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.f23031F0[this.f22992p] = eVar;
            }
            d dVar = eVar.f23052W[i5 + 1].f23004f;
            if (dVar != null) {
                e eVar5 = dVar.f23002d;
                d dVar2 = eVar5.f23052W[i5].f23004f;
                if (dVar2 != null && dVar2.f23002d == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z5 = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.f22978b;
        if (eVar6 != null) {
            this.f22989m -= eVar6.f23052W[i5].f();
        }
        e eVar7 = this.f22980d;
        if (eVar7 != null) {
            this.f22989m -= eVar7.f23052W[i5 + 1].f();
        }
        this.f22979c = eVar;
        if (this.f22992p == 0 && this.f22993q) {
            this.f22981e = eVar;
        } else {
            this.f22981e = this.f22977a;
        }
        this.f22996t = this.f22995s && this.f22994r;
    }

    private static boolean c(e eVar, int i5) {
        if (eVar.V() == 8 || eVar.f23055Z[i5] != e.b.MATCH_CONSTRAINT) {
            return false;
        }
        int i6 = eVar.f23104y[i5];
        return i6 == 0 || i6 == 3;
    }

    public void a() {
        if (!this.f22998v) {
            b();
        }
        this.f22998v = true;
    }
}
