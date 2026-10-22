package o1;

import java.lang.invoke.VarHandle;
import java.util.List;
import p.n0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public s1.q f9008a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9009b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9010c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9011d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9012e;

    /* renamed from: f, reason: collision with root package name */
    public p.a0 f9013f;

    /* renamed from: g, reason: collision with root package name */
    public i f9014g;

    /* renamed from: h, reason: collision with root package name */
    public p.x f9015h;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r23v2 */
    public final void a(long j10, List list, boolean z10) {
        long j11;
        long j12;
        long[] jArr;
        int i;
        char c9;
        h hVar;
        h hVar2;
        i iVar = this.f9014g;
        p.x xVar = this.f9015h;
        xVar.f9643e = 0;
        long[] jArr2 = xVar.f9639a;
        char c10 = 7;
        if (jArr2 != n0.f9597a) {
            kb.k.n0(jArr2, -9187201950435737472L);
            long[] jArr3 = xVar.f9639a;
            int i3 = xVar.f9642d;
            int i10 = i3 >> 3;
            j11 = -9187201950435737472L;
            long j13 = 255 << ((i3 & 7) << 3);
            j12 = 255;
            jArr3[i10] = ((~j13) & jArr3[i10]) | j13;
        } else {
            j11 = -9187201950435737472L;
            j12 = 255;
        }
        kb.k.m0(null, 0, xVar.f9641c, xVar.f9642d);
        xVar.f9644f = n0.a(xVar.f9642d) - xVar.f9643e;
        int size = list.size();
        i iVar2 = iVar;
        int i11 = 0;
        boolean z11 = true;
        while (i11 < size) {
            w0.l lVar = (w0.l) list.get(i11);
            if (lVar.f15126r) {
                lVar.f15125q = new a1.b(6, this, lVar);
                if (z11) {
                    m0.e eVar = iVar2.f9046a;
                    c9 = c10;
                    ?? r12 = eVar.f8158c;
                    int i12 = eVar.f8160g;
                    int i13 = 0;
                    while (true) {
                        if (i13 >= i12) {
                            hVar2 = 0;
                            break;
                        }
                        hVar2 = r12[i13];
                        if (yb.k.a(((h) hVar2).f9034c, lVar)) {
                            break;
                        } else {
                            i13++;
                        }
                    }
                    hVar = hVar2;
                    if (hVar != null) {
                        hVar.i = true;
                        hVar.f9035d.a(j10);
                        Object objB = xVar.b(j10);
                        Object obj = objB;
                        if (objB == null) {
                            p.a0 a0Var = new p.a0();
                            xVar.d(j10, a0Var);
                            obj = a0Var;
                        }
                        ((p.a0) obj).a(hVar);
                        iVar2 = hVar;
                    } else {
                        z11 = false;
                    }
                } else {
                    c9 = c10;
                }
                hVar = new h();
                hVar.f9034c = lVar;
                wd.a aVar = new wd.a(6);
                aVar.f15390g = new long[2];
                hVar.f9035d = aVar;
                hVar.f9036e = new p.n(2);
                hVar.i = true;
                hVar.f9040j = true;
                VarHandle.storeStoreFence();
                aVar.a(j10);
                Object objB2 = xVar.b(j10);
                Object obj2 = objB2;
                if (objB2 == null) {
                    p.a0 a0Var2 = new p.a0();
                    xVar.d(j10, a0Var2);
                    obj2 = a0Var2;
                }
                ((p.a0) obj2).a(hVar);
                iVar2.f9046a.b(hVar);
                iVar2 = hVar;
            } else {
                c9 = c10;
            }
            i11++;
            c10 = c9;
        }
        char c11 = c10;
        if (!z10) {
            return;
        }
        long[] jArr4 = xVar.f9640b;
        Object[] objArr = xVar.f9641c;
        long[] jArr5 = xVar.f9639a;
        int length = jArr5.length - 2;
        if (length < 0) {
            return;
        }
        int i14 = 0;
        while (true) {
            long j14 = jArr5[i14];
            if ((((~j14) << c11) & j14 & j11) != j11) {
                int i15 = 8;
                int i16 = 8 - ((~(i14 - length)) >>> 31);
                int i17 = 0;
                while (i17 < i16) {
                    if ((j14 & j12) < 128) {
                        int i18 = (i14 << 3) + i17;
                        long j15 = jArr4[i18];
                        p.a0 a0Var3 = (p.a0) objArr[i18];
                        m0.e eVar2 = iVar.f9046a;
                        Object[] objArr2 = eVar2.f8158c;
                        int i19 = eVar2.f8160g;
                        i = i15;
                        int i20 = 0;
                        while (i20 < i19) {
                            ((h) objArr2[i20]).f(j15, a0Var3);
                            i20++;
                            jArr4 = jArr4;
                        }
                    } else {
                        i = i15;
                    }
                    j14 >>= i;
                    i17++;
                    i15 = i;
                    jArr4 = jArr4;
                }
                jArr = jArr4;
                if (i16 != i15) {
                    return;
                }
            } else {
                jArr = jArr4;
            }
            if (i14 == length) {
                return;
            }
            i14++;
            jArr4 = jArr;
        }
    }

    public final boolean b(ma.a aVar, boolean z10) {
        p.a0 a0Var = this.f9013f;
        i iVar = this.f9014g;
        boolean zA = iVar.a((p.n) aVar.f8533b, this.f9008a, aVar, z10);
        m0.e eVar = iVar.f9046a;
        if (!zA) {
            return false;
        }
        boolean z11 = true;
        this.f9009b = true;
        Object[] objArr = eVar.f8158c;
        int i = eVar.f8160g;
        boolean z12 = false;
        for (int i3 = 0; i3 < i; i3++) {
            z12 = ((h) objArr[i3]).e(aVar, z10) || z12;
        }
        Object[] objArr2 = eVar.f8158c;
        int i10 = eVar.f8160g;
        boolean z13 = false;
        for (int i11 = 0; i11 < i10; i11++) {
            z13 = ((h) objArr2[i11]).d(aVar) || z13;
        }
        iVar.b(aVar);
        if (!z13 && !z12) {
            z11 = false;
        }
        this.f9009b = false;
        if (this.f9012e) {
            this.f9012e = false;
            int i12 = a0Var.f9517b;
            for (int i13 = 0; i13 < i12; i13++) {
                d((w0.l) a0Var.e(i13));
            }
            a0Var.c();
        }
        if (this.f9010c) {
            this.f9010c = false;
            c();
        }
        if (this.f9011d) {
            this.f9011d = false;
            iVar.f9046a.g();
        }
        return z11;
    }

    public final void c() {
        i iVar = this.f9014g;
        if (this.f9009b) {
            this.f9010c = true;
            return;
        }
        m0.e eVar = iVar.f9046a;
        Object[] objArr = eVar.f8158c;
        int i = eVar.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            ((h) objArr[i3]).c();
        }
        if (this.f9011d) {
            this.f9011d = true;
        } else {
            iVar.f9046a.g();
        }
    }

    public final void d(w0.l lVar) {
        if (this.f9009b) {
            this.f9012e = true;
            this.f9013f.a(lVar);
            return;
        }
        i iVar = this.f9014g;
        p.a0 a0Var = iVar.f9047b;
        a0Var.c();
        a0Var.a(iVar);
        while (a0Var.h()) {
            i iVar2 = (i) a0Var.j(a0Var.f9517b - 1);
            int i = 0;
            while (true) {
                m0.e eVar = iVar2.f9046a;
                if (i < eVar.f8160g) {
                    h hVar = (h) eVar.f8158c[i];
                    if (yb.k.a(hVar.f9034c, lVar)) {
                        iVar2.f9046a.j(hVar);
                        hVar.c();
                    } else {
                        a0Var.a(hVar);
                        i++;
                    }
                }
            }
        }
    }
}
