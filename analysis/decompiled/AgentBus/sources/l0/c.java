package l0;

import java.util.Arrays;
import java.util.HashMap;
import k.b0;

/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: o, reason: collision with root package name */
    public final b f5742o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f5743p;

    public c(long j2, k kVar, p7.k kVar2, p7.k kVar3, b bVar) {
        super(j2, kVar, kVar2, kVar3);
        this.f5742o = bVar;
        bVar.k();
    }

    @Override // l0.b, l0.f
    public final void c() {
        if (this.f5750c) {
            return;
        }
        super.c();
        if (this.f5743p) {
            return;
        }
        this.f5743p = true;
        this.f5742o.l();
    }

    @Override // l0.b
    public final r w() {
        c cVar;
        b bVar = this.f5742o;
        if (bVar.f5741m || bVar.f5750c) {
            return new g();
        }
        b0 b0Var = this.f5736h;
        long j2 = this.f5749b;
        HashMap mapC = b0Var != null ? m.c(bVar.g(), this, this.f5742o.d()) : null;
        Object obj = m.f5774c;
        synchronized (obj) {
            try {
                m.d(this);
                if (b0Var == null || b0Var.f5456d == 0) {
                    cVar = this;
                    cVar.a();
                } else {
                    cVar = this;
                    r rVarZ = cVar.z(this.f5742o.g(), b0Var, mapC, this.f5742o.d());
                    if (!rVarZ.equals(h.f5752b)) {
                        return rVarZ;
                    }
                    b0 b0VarX = cVar.f5742o.x();
                    if (b0VarX != null) {
                        b0VarX.j(b0Var);
                    } else {
                        cVar.f5742o.B(b0Var);
                        cVar.f5736h = null;
                    }
                }
                if (q7.k.g(cVar.f5742o.g(), j2) < 0) {
                    cVar.f5742o.v();
                }
                b bVar2 = cVar.f5742o;
                bVar2.r(bVar2.d().f(j2).a(cVar.f5738j));
                cVar.f5742o.A(j2);
                b bVar3 = cVar.f5742o;
                int i2 = cVar.f5751d;
                cVar.f5751d = -1;
                if (i2 >= 0) {
                    int[] iArr = bVar3.f5739k;
                    q7.k.e(iArr, "<this>");
                    int length = iArr.length;
                    int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
                    iArrCopyOf[length] = i2;
                    bVar3.f5739k = iArrCopyOf;
                } else {
                    bVar3.getClass();
                }
                b bVar4 = cVar.f5742o;
                k kVar = cVar.f5738j;
                bVar4.getClass();
                synchronized (obj) {
                    bVar4.f5738j = bVar4.f5738j.i(kVar);
                    b bVar5 = cVar.f5742o;
                    int[] iArr2 = cVar.f5739k;
                    bVar5.getClass();
                    if (iArr2.length != 0) {
                        int[] iArr3 = bVar5.f5739k;
                        if (iArr3.length != 0) {
                            int length2 = iArr3.length;
                            int length3 = iArr2.length;
                            int[] iArrCopyOf2 = Arrays.copyOf(iArr3, length2 + length3);
                            System.arraycopy(iArr2, 0, iArrCopyOf2, length2, length3);
                            q7.k.b(iArrCopyOf2);
                            iArr2 = iArrCopyOf2;
                        }
                        bVar5.f5739k = iArr2;
                    }
                }
                cVar.f5741m = true;
                if (!cVar.f5743p) {
                    cVar.f5743p = true;
                    cVar.f5742o.l();
                }
                return h.f5752b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
