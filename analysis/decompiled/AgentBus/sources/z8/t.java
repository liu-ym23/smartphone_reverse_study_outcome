package z8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class t extends f9.j implements f9.v {

    /* renamed from: g, reason: collision with root package name */
    public int f12369g;

    /* renamed from: h, reason: collision with root package name */
    public int f12370h;

    /* renamed from: i, reason: collision with root package name */
    public int f12371i;

    /* renamed from: j, reason: collision with root package name */
    public u f12372j;

    /* renamed from: k, reason: collision with root package name */
    public p0 f12373k;

    /* renamed from: l, reason: collision with root package name */
    public int f12374l;

    /* renamed from: m, reason: collision with root package name */
    public List f12375m;

    /* renamed from: n, reason: collision with root package name */
    public List f12376n;

    public static t e() {
        t tVar = new t();
        tVar.f12372j = u.TRUE;
        tVar.f12373k = p0.f12298y;
        List list = Collections.EMPTY_LIST;
        tVar.f12375m = list;
        tVar.f12376n = list;
        return tVar;
    }

    @Override // f9.j
    public final f9.a a() {
        v vVarD = d();
        if (vVarD.isInitialized()) {
            return vVarD;
        }
        throw new a4.u(4);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    @Override // f9.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.j b(f9.e r3, f9.h r4) throws java.lang.Throwable {
        /*
            r2 = this;
            r0 = 0
            c9.a r1 = z8.v.f12401r     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.v r1 = new z8.v     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.f(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.v r4 = (z8.v) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.f(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.t.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        f((v) oVar);
        return this;
    }

    public final Object clone() {
        t tVarE = e();
        tVarE.f(d());
        return tVarE;
    }

    public final v d() {
        v vVar = new v(this);
        int i2 = this.f12369g;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        vVar.f12404h = this.f12370h;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        vVar.f12405i = this.f12371i;
        if ((i2 & 4) == 4) {
            i10 |= 4;
        }
        vVar.f12406j = this.f12372j;
        if ((i2 & 8) == 8) {
            i10 |= 8;
        }
        vVar.f12407k = this.f12373k;
        if ((i2 & 16) == 16) {
            i10 |= 16;
        }
        vVar.f12408l = this.f12374l;
        if ((i2 & 32) == 32) {
            this.f12375m = Collections.unmodifiableList(this.f12375m);
            this.f12369g &= -33;
        }
        vVar.f12409m = this.f12375m;
        if ((this.f12369g & 64) == 64) {
            this.f12376n = Collections.unmodifiableList(this.f12376n);
            this.f12369g &= -65;
        }
        vVar.f12410n = this.f12376n;
        vVar.f12403g = i10;
        return vVar;
    }

    public final void f(v vVar) {
        p0 p0Var;
        if (vVar == v.f12400q) {
            return;
        }
        int i2 = vVar.f12403g;
        if ((i2 & 1) == 1) {
            int i10 = vVar.f12404h;
            this.f12369g = 1 | this.f12369g;
            this.f12370h = i10;
        }
        if ((i2 & 2) == 2) {
            int i11 = vVar.f12405i;
            this.f12369g = 2 | this.f12369g;
            this.f12371i = i11;
        }
        if ((i2 & 4) == 4) {
            u uVar = vVar.f12406j;
            uVar.getClass();
            this.f12369g = 4 | this.f12369g;
            this.f12372j = uVar;
        }
        if ((vVar.f12403g & 8) == 8) {
            p0 p0Var2 = vVar.f12407k;
            if ((this.f12369g & 8) != 8 || (p0Var = this.f12373k) == p0.f12298y) {
                this.f12373k = p0Var2;
            } else {
                o0 o0VarP = p0.p(p0Var);
                o0VarP.g(p0Var2);
                this.f12373k = o0VarP.e();
            }
            this.f12369g |= 8;
        }
        if ((vVar.f12403g & 16) == 16) {
            int i12 = vVar.f12408l;
            this.f12369g = 16 | this.f12369g;
            this.f12374l = i12;
        }
        if (!vVar.f12409m.isEmpty()) {
            if (this.f12375m.isEmpty()) {
                this.f12375m = vVar.f12409m;
                this.f12369g &= -33;
            } else {
                if ((this.f12369g & 32) != 32) {
                    this.f12375m = new ArrayList(this.f12375m);
                    this.f12369g |= 32;
                }
                this.f12375m.addAll(vVar.f12409m);
            }
        }
        if (!vVar.f12410n.isEmpty()) {
            if (this.f12376n.isEmpty()) {
                this.f12376n = vVar.f12410n;
                this.f12369g &= -65;
            } else {
                if ((this.f12369g & 64) != 64) {
                    this.f12376n = new ArrayList(this.f12376n);
                    this.f12369g |= 64;
                }
                this.f12376n.addAll(vVar.f12410n);
            }
        }
        this.f3565f = this.f3565f.f(vVar.f12402f);
    }
}
