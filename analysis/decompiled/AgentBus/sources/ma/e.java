package ma;

import b0.f2;
import ia.b0;
import ia.c0;
import ia.d0;
import java.util.ArrayList;
import ka.x;

/* loaded from: classes.dex */
public abstract class e implements o {

    /* renamed from: f, reason: collision with root package name */
    public final g7.l f6482f;

    /* renamed from: g, reason: collision with root package name */
    public final int f6483g;

    /* renamed from: h, reason: collision with root package name */
    public final ka.a f6484h;

    public e(g7.l lVar, int i2, ka.a aVar) {
        this.f6482f = lVar;
        this.f6483g = i2;
        this.f6484h = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    @Override // ma.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final la.j E(g7.l r5, int r6, ka.a r7) {
        /*
            r4 = this;
            g7.l r0 = r4.f6482f
            g7.l r5 = r5.Q(r0)
            ka.a r1 = ka.a.f5661f
            ka.a r2 = r4.f6484h
            int r3 = r4.f6483g
            if (r7 == r1) goto Lf
            goto L26
        Lf:
            r7 = -3
            if (r3 != r7) goto L13
            goto L25
        L13:
            if (r6 != r7) goto L17
        L15:
            r6 = r3
            goto L25
        L17:
            r7 = -2
            if (r3 != r7) goto L1b
            goto L25
        L1b:
            if (r6 != r7) goto L1e
            goto L15
        L1e:
            int r6 = r6 + r3
            if (r6 < 0) goto L22
            goto L25
        L22:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L25:
            r7 = r2
        L26:
            boolean r0 = q7.k.a(r5, r0)
            if (r0 == 0) goto L31
            if (r6 != r3) goto L31
            if (r7 != r2) goto L31
            return r4
        L31:
            ma.e r4 = r4.c(r5, r6, r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ma.e.E(g7.l, int, ka.a):la.j");
    }

    public String a() {
        return null;
    }

    public abstract Object b(ka.t tVar, g7.d dVar);

    public abstract e c(g7.l lVar, int i2, ka.a aVar);

    public la.j d() {
        return null;
    }

    public x e(b0 b0Var) {
        int i2 = this.f6483g;
        if (i2 == -3) {
            i2 = -2;
        }
        c0 c0Var = c0.f4928h;
        p7.n bVar = new a5.b(this, null, 13);
        ka.s sVar = new ka.s(d0.t(b0Var, this.f6482f), a.a.b(i2, 4, this.f6484h));
        sVar.n0(c0Var, sVar, bVar);
        return sVar;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strA = a();
        if (strA != null) {
            arrayList.add(strA);
        }
        g7.m mVar = g7.m.f3866f;
        g7.l lVar = this.f6482f;
        if (lVar != mVar) {
            arrayList.add("context=" + lVar);
        }
        int i2 = this.f6483g;
        if (i2 != -3) {
            arrayList.add("capacity=" + i2);
        }
        ka.a aVar = ka.a.f5661f;
        ka.a aVar2 = this.f6484h;
        if (aVar2 != aVar) {
            arrayList.add("onBufferOverflow=" + aVar2);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append('[');
        return a1.a.l(sb2, d7.r.U0(arrayList, ", ", null, null, null, 62), ']');
    }

    @Override // la.j
    public Object x(la.k kVar, g7.d dVar) throws Throwable {
        Object objF = d0.f(new f2(kVar, this, (g7.d) null, 9), dVar);
        return objF == h7.a.f4212f ? objF : c7.r.f1986a;
    }
}
