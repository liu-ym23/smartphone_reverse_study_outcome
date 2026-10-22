package n;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class g0 implements s {

    /* renamed from: a, reason: collision with root package name */
    public final d1.b f6620a;

    public g0(d1.b bVar) {
        this.f6620a = bVar;
    }

    @Override // n.s, n.h
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final m1 a(q6.b bVar) {
        int[] iArr;
        Object[] objArr;
        int[] iArr2;
        Object[] objArr2;
        int i2;
        d1.b bVar2 = this.f6620a;
        k.t tVar = (k.t) bVar2.f2768h;
        k.s sVar = new k.s(tVar.f5502e + 2);
        k.t tVar2 = new k.t(tVar.f5502e);
        int[] iArr3 = tVar.f5499b;
        Object[] objArr3 = tVar.f5500c;
        long[] jArr = tVar.f5498a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i10 = 0;
            while (true) {
                long j2 = jArr[i10];
                if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i10 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((255 & j2) < 128) {
                            int i14 = (i10 << 3) + i13;
                            int i15 = iArr3[i14];
                            f0 f0Var = (f0) objArr3[i14];
                            sVar.a(i15);
                            i2 = i11;
                            iArr2 = iArr3;
                            objArr2 = objArr3;
                            tVar2.g(i15, new l1((n) ((p7.k) bVar.f8788h).invoke(f0Var.f6607a), f0Var.f6608b));
                        } else {
                            iArr2 = iArr3;
                            objArr2 = objArr3;
                            i2 = i11;
                        }
                        j2 >>= i2;
                        i13++;
                        i11 = i2;
                        iArr3 = iArr2;
                        objArr3 = objArr2;
                    }
                    iArr = iArr3;
                    objArr = objArr3;
                    if (i12 != i11) {
                        break;
                    }
                } else {
                    iArr = iArr3;
                    objArr = objArr3;
                }
                if (i10 == length) {
                    break;
                }
                i10++;
                iArr3 = iArr;
                objArr3 = objArr;
            }
        }
        if (!tVar.a(0)) {
            int i16 = sVar.f5530b;
            if (i16 < 0) {
                l.a.d("Index must be between 0 and size");
                throw null;
            }
            sVar.b(i16 + 1);
            int[] iArr4 = sVar.f5529a;
            int i17 = sVar.f5530b;
            if (i17 != 0) {
                d7.n.W(iArr4, iArr4, 1, 0, i17);
            }
            iArr4[0] = 0;
            sVar.f5530b++;
        }
        if (!tVar.a(bVar2.f2767g)) {
            sVar.a(bVar2.f2767g);
        }
        int i18 = sVar.f5530b;
        if (i18 != 0) {
            int[] iArr5 = sVar.f5529a;
            q7.k.e(iArr5, "<this>");
            Arrays.sort(iArr5, 0, i18);
        }
        return new m1(sVar, tVar2, bVar2.f2767g, u.f6737b);
    }
}
