package z8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class n extends f9.j implements f9.v {

    /* renamed from: g, reason: collision with root package name */
    public int f12259g;

    /* renamed from: h, reason: collision with root package name */
    public o f12260h;

    /* renamed from: i, reason: collision with root package name */
    public List f12261i;

    /* renamed from: j, reason: collision with root package name */
    public v f12262j;

    /* renamed from: k, reason: collision with root package name */
    public p f12263k;

    public static n e() {
        n nVar = new n();
        nVar.f12260h = o.RETURNS_CONSTANT;
        nVar.f12261i = Collections.EMPTY_LIST;
        nVar.f12262j = v.f12400q;
        nVar.f12263k = p.AT_MOST_ONCE;
        return nVar;
    }

    @Override // f9.j
    public final f9.a a() {
        q qVarD = d();
        if (qVarD.isInitialized()) {
            return qVarD;
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
            c9.a r1 = z8.q.f12319o     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            z8.q r1 = new z8.q     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf f9.r -> L11
            r2.f(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            f9.a r4 = r3.f3597f     // Catch: java.lang.Throwable -> Lf
            z8.q r4 = (z8.q) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: z8.n.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(f9.o oVar) {
        f((q) oVar);
        return this;
    }

    public final Object clone() {
        n nVarE = e();
        nVarE.f(d());
        return nVarE;
    }

    public final q d() {
        q qVar = new q(this);
        int i2 = this.f12259g;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        qVar.f12322h = this.f12260h;
        if ((i2 & 2) == 2) {
            this.f12261i = Collections.unmodifiableList(this.f12261i);
            this.f12259g &= -3;
        }
        qVar.f12323i = this.f12261i;
        if ((i2 & 4) == 4) {
            i10 |= 2;
        }
        qVar.f12324j = this.f12262j;
        if ((i2 & 8) == 8) {
            i10 |= 4;
        }
        qVar.f12325k = this.f12263k;
        qVar.f12321g = i10;
        return qVar;
    }

    public final void f(q qVar) {
        v vVar;
        if (qVar == q.f12318n) {
            return;
        }
        if ((qVar.f12321g & 1) == 1) {
            o oVar = qVar.f12322h;
            oVar.getClass();
            this.f12259g = 1 | this.f12259g;
            this.f12260h = oVar;
        }
        if (!qVar.f12323i.isEmpty()) {
            if (this.f12261i.isEmpty()) {
                this.f12261i = qVar.f12323i;
                this.f12259g &= -3;
            } else {
                if ((this.f12259g & 2) != 2) {
                    this.f12261i = new ArrayList(this.f12261i);
                    this.f12259g |= 2;
                }
                this.f12261i.addAll(qVar.f12323i);
            }
        }
        if ((qVar.f12321g & 2) == 2) {
            v vVar2 = qVar.f12324j;
            if ((this.f12259g & 4) != 4 || (vVar = this.f12262j) == v.f12400q) {
                this.f12262j = vVar2;
            } else {
                t tVarE = t.e();
                tVarE.f(vVar);
                tVarE.f(vVar2);
                this.f12262j = tVarE.d();
            }
            this.f12259g |= 4;
        }
        if ((qVar.f12321g & 4) == 4) {
            p pVar = qVar.f12325k;
            pVar.getClass();
            this.f12259g |= 8;
            this.f12263k = pVar;
        }
        this.f3565f = this.f3565f.f(qVar.f12320f);
    }
}
