package c1;

import java.util.List;
import k.g0;
import k.z;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final g1.k f1771a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1772b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1773c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1774d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1775e;

    /* renamed from: f, reason: collision with root package name */
    public final z f1776f = new z();

    /* renamed from: g, reason: collision with root package name */
    public final e f1777g = new e();

    /* renamed from: h, reason: collision with root package name */
    public final k.w f1778h;

    public b(g1.k kVar) {
        this.f1771a = kVar;
        k.w wVar = new k.w();
        wVar.f5539a = g0.f5491a;
        wVar.f5540b = k.m.f5506a;
        wVar.f5541c = l.a.f5726c;
        wVar.c(g0.d(10));
        this.f1778h = wVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    public final void a(long j2, List list, boolean z4) {
        long j4;
        long[] jArr;
        int i2;
        char c10;
        long j10;
        d dVar;
        d dVar2;
        k.w wVar = this.f1778h;
        wVar.f5543e = 0;
        long[] jArr2 = wVar.f5539a;
        char c11 = 7;
        if (jArr2 != g0.f5491a) {
            d7.n.e0(jArr2);
            long[] jArr3 = wVar.f5539a;
            int i10 = wVar.f5542d;
            int i11 = i10 >> 3;
            long j11 = 255 << ((i10 & 7) << 3);
            j4 = 255;
            jArr3[i11] = (jArr3[i11] & (~j11)) | j11;
        } else {
            j4 = 255;
        }
        d7.n.d0(wVar.f5541c, 0, wVar.f5542d);
        wVar.f5544f = g0.a(wVar.f5542d) - wVar.f5543e;
        int size = list.size();
        e eVar = this.f1777g;
        int i12 = 0;
        boolean z10 = true;
        e eVar2 = eVar;
        while (i12 < size) {
            n0.l lVar = (n0.l) list.get(i12);
            if (lVar.f6810s) {
                lVar.f6809r = new a8.e(1, this, lVar);
                if (z10) {
                    d0.e eVar3 = eVar2.f1793a;
                    ?? r14 = eVar3.f2749f;
                    int i13 = eVar3.f2751h;
                    c10 = c11;
                    int i14 = 0;
                    while (true) {
                        if (i14 >= i13) {
                            j10 = j4;
                            dVar2 = 0;
                            break;
                        }
                        dVar2 = r14[i14];
                        j10 = j4;
                        if (q7.k.a(((d) dVar2).f1785c, lVar)) {
                            break;
                        }
                        i14++;
                        j4 = j10;
                    }
                    dVar = dVar2;
                    if (dVar != null) {
                        dVar.f1791i = true;
                        dVar.f1786d.b(j2);
                        Object objB = wVar.b(j2);
                        Object obj = objB;
                        if (objB == null) {
                            z zVar = new z();
                            wVar.d(j2, zVar);
                            obj = zVar;
                        }
                        ((z) obj).a(dVar);
                        eVar2 = dVar;
                    } else {
                        z10 = false;
                    }
                } else {
                    c10 = c11;
                    j10 = j4;
                }
                dVar = new d(lVar);
                dVar.f1786d.b(j2);
                Object objB2 = wVar.b(j2);
                Object obj2 = objB2;
                if (objB2 == null) {
                    z zVar2 = new z();
                    wVar.d(j2, zVar2);
                    obj2 = zVar2;
                }
                ((z) obj2).a(dVar);
                eVar2.f1793a.b(dVar);
                eVar2 = dVar;
            } else {
                c10 = c11;
                j10 = j4;
            }
            i12++;
            c11 = c10;
            j4 = j10;
        }
        char c12 = c11;
        long j12 = j4;
        if (!z4) {
            return;
        }
        long[] jArr4 = wVar.f5540b;
        Object[] objArr = wVar.f5541c;
        long[] jArr5 = wVar.f5539a;
        int length = jArr5.length - 2;
        if (length < 0) {
            return;
        }
        int i15 = 0;
        while (true) {
            long j13 = jArr5[i15];
            if ((((~j13) << c12) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i16 = 8;
                int i17 = 8 - ((~(i15 - length)) >>> 31);
                int i18 = 0;
                while (i18 < i17) {
                    if ((j13 & j12) < 128) {
                        int i19 = (i15 << 3) + i18;
                        long j14 = jArr4[i19];
                        z zVar3 = (z) objArr[i19];
                        d0.e eVar4 = eVar.f1793a;
                        Object[] objArr2 = eVar4.f2749f;
                        int i20 = eVar4.f2751h;
                        i2 = i16;
                        int i21 = 0;
                        while (i21 < i20) {
                            ((d) objArr2[i21]).f(j14, zVar3);
                            i21++;
                            jArr4 = jArr4;
                        }
                    } else {
                        i2 = i16;
                    }
                    j13 >>= i2;
                    i18++;
                    i16 = i2;
                    jArr4 = jArr4;
                }
                jArr = jArr4;
                if (i17 != i16) {
                    return;
                }
            } else {
                jArr = jArr4;
            }
            if (i15 == length) {
                return;
            }
            i15++;
            jArr4 = jArr;
        }
    }

    public final boolean b(q6.b bVar, boolean z4) {
        k.n nVar = (k.n) bVar.f8788h;
        g1.k kVar = this.f1771a;
        e eVar = this.f1777g;
        boolean zA = eVar.a(nVar, kVar, bVar, z4);
        d0.e eVar2 = eVar.f1793a;
        if (!zA) {
            return false;
        }
        boolean z10 = true;
        this.f1772b = true;
        Object[] objArr = eVar2.f2749f;
        int i2 = eVar2.f2751h;
        boolean z11 = false;
        for (int i10 = 0; i10 < i2; i10++) {
            z11 = ((d) objArr[i10]).e(bVar, z4) || z11;
        }
        Object[] objArr2 = eVar2.f2749f;
        int i11 = eVar2.f2751h;
        boolean z12 = false;
        for (int i12 = 0; i12 < i11; i12++) {
            z12 = ((d) objArr2[i12]).d(bVar) || z12;
        }
        eVar.b(bVar);
        if (!z12 && !z11) {
            z10 = false;
        }
        this.f1772b = false;
        if (this.f1775e) {
            this.f1775e = false;
            z zVar = this.f1776f;
            int i13 = zVar.f5557b;
            for (int i14 = 0; i14 < i13; i14++) {
                d((n0.l) zVar.e(i14));
            }
            zVar.c();
        }
        if (this.f1773c) {
            this.f1773c = false;
            c();
        }
        if (this.f1774d) {
            this.f1774d = false;
            eVar.f1793a.g();
        }
        return z10;
    }

    public final void c() {
        if (this.f1772b) {
            this.f1773c = true;
            return;
        }
        e eVar = this.f1777g;
        d0.e eVar2 = eVar.f1793a;
        Object[] objArr = eVar2.f2749f;
        int i2 = eVar2.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            ((d) objArr[i10]).c();
        }
        if (this.f1774d) {
            this.f1774d = true;
        } else {
            eVar.f1793a.g();
        }
    }

    public final void d(n0.l lVar) {
        if (this.f1772b) {
            this.f1775e = true;
            this.f1776f.a(lVar);
            return;
        }
        e eVar = this.f1777g;
        z zVar = eVar.f1794b;
        zVar.c();
        zVar.a(eVar);
        while (zVar.h()) {
            e eVar2 = (e) zVar.j(zVar.f5557b - 1);
            int i2 = 0;
            while (true) {
                d0.e eVar3 = eVar2.f1793a;
                if (i2 < eVar3.f2751h) {
                    d dVar = (d) eVar3.f2749f[i2];
                    if (q7.k.a(dVar.f1785c, lVar)) {
                        eVar2.f1793a.i(dVar);
                        dVar.c();
                    } else {
                        zVar.a(dVar);
                        i2++;
                    }
                }
            }
        }
    }
}
