package u0;

import java.util.Arrays;
import java.util.HashMap;
import p.g0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: o, reason: collision with root package name */
    public b f13646o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f13647p;

    @Override // u0.b, u0.f
    public final void c() {
        if (this.f13654c) {
            return;
        }
        super.c();
        if (this.f13647p) {
            return;
        }
        this.f13647p = true;
        this.f13646o.l();
    }

    @Override // u0.b
    public final r w() {
        c cVar;
        b bVar = this.f13646o;
        if (bVar.f13645m || bVar.f13654c) {
            return new g();
        }
        g0 g0Var = this.f13641h;
        long j10 = this.f13653b;
        HashMap mapC = g0Var != null ? m.c(bVar.g(), this, this.f13646o.d()) : null;
        Object obj = m.f13676c;
        synchronized (obj) {
            try {
                m.d(this);
                if (g0Var == null || g0Var.f9563d == 0) {
                    cVar = this;
                    cVar.a();
                } else {
                    cVar = this;
                    r rVarZ = cVar.z(this.f13646o.g(), g0Var, mapC, this.f13646o.d());
                    if (!rVarZ.equals(h.f13656b)) {
                        return rVarZ;
                    }
                    g0 g0VarX = cVar.f13646o.x();
                    if (g0VarX != null) {
                        g0VarX.j(g0Var);
                    } else {
                        cVar.f13646o.B(g0Var);
                        cVar.f13641h = null;
                    }
                }
                if (yb.k.c(cVar.f13646o.g(), j10) < 0) {
                    cVar.f13646o.v();
                }
                b bVar2 = cVar.f13646o;
                bVar2.r(bVar2.d().b(j10).a(cVar.f13642j));
                cVar.f13646o.A(j10);
                b bVar3 = cVar.f13646o;
                int i = cVar.f13655d;
                cVar.f13655d = -1;
                if (i >= 0) {
                    int[] iArr = bVar3.f13643k;
                    iArr.getClass();
                    int length = iArr.length;
                    int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
                    iArrCopyOf[length] = i;
                    bVar3.f13643k = iArrCopyOf;
                } else {
                    bVar3.getClass();
                }
                b bVar4 = cVar.f13646o;
                k kVar = cVar.f13642j;
                bVar4.getClass();
                synchronized (obj) {
                    bVar4.f13642j = bVar4.f13642j.d(kVar);
                    b bVar5 = cVar.f13646o;
                    int[] iArr2 = cVar.f13643k;
                    bVar5.getClass();
                    if (iArr2.length != 0) {
                        int[] iArr3 = bVar5.f13643k;
                        if (iArr3.length != 0) {
                            int length2 = iArr3.length;
                            int length3 = iArr2.length;
                            int[] iArrCopyOf2 = Arrays.copyOf(iArr3, length2 + length3);
                            System.arraycopy(iArr2, 0, iArrCopyOf2, length2, length3);
                            iArr2 = iArrCopyOf2;
                        }
                        bVar5.f13643k = iArr2;
                    }
                }
                cVar.f13645m = true;
                if (!cVar.f13647p) {
                    cVar.f13647p = true;
                    cVar.f13646o.l();
                }
                return h.f13656b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
