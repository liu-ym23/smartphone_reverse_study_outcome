package l0;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class k implements Iterable, r7.a {

    /* renamed from: j, reason: collision with root package name */
    public static final k f5764j = new k(0, 0, 0, null);

    /* renamed from: f, reason: collision with root package name */
    public final long f5765f;

    /* renamed from: g, reason: collision with root package name */
    public final long f5766g;

    /* renamed from: h, reason: collision with root package name */
    public final long f5767h;

    /* renamed from: i, reason: collision with root package name */
    public final long[] f5768i;

    public k(long j2, long j4, long j10, long[] jArr) {
        this.f5765f = j2;
        this.f5766g = j4;
        this.f5767h = j10;
        this.f5768i = jArr;
    }

    public final k a(k kVar) {
        long[] jArr;
        k kVarF = this;
        k kVar2 = f5764j;
        if (kVar == kVar2) {
            return kVarF;
        }
        if (kVarF == kVar2) {
            return kVar2;
        }
        long j2 = kVar.f5767h;
        long j4 = kVar.f5767h;
        long[] jArr2 = kVar.f5768i;
        long j10 = kVar.f5766g;
        long j11 = kVar.f5765f;
        long j12 = kVarF.f5767h;
        if (j2 == j12 && jArr2 == (jArr = kVarF.f5768i)) {
            return new k(kVarF.f5765f & (~j11), kVarF.f5766g & (~j10), j12, jArr);
        }
        if (jArr2 != null) {
            for (long j13 : jArr2) {
                kVarF = kVarF.f(j13);
            }
        }
        if (j10 != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if (((1 << i2) & j10) != 0) {
                    kVarF = kVarF.f(i2 + j4);
                }
            }
        }
        if (j11 != 0) {
            for (int i10 = 0; i10 < 64; i10++) {
                if (((1 << i10) & j11) != 0) {
                    kVarF = kVarF.f(i10 + j4 + 64);
                }
            }
        }
        return kVarF;
    }

    public final k f(long j2) {
        long[] jArr;
        int iC;
        long[] jArr2;
        long j4 = j2 - this.f5767h;
        long j10 = 0;
        if (q7.k.g(j4, j10) >= 0 && q7.k.g(j4, 64) < 0) {
            long j11 = 1 << ((int) j4);
            long j12 = this.f5766g;
            if ((j12 & j11) != 0) {
                return new k(this.f5765f, j12 & (~j11), this.f5767h, this.f5768i);
            }
        } else if (q7.k.g(j4, 64) >= 0 && q7.k.g(j4, 128) < 0) {
            long j13 = 1 << (((int) j4) - 64);
            long j14 = this.f5765f;
            if ((j14 & j13) != 0) {
                return new k(j14 & (~j13), this.f5766g, this.f5767h, this.f5768i);
            }
        } else if (q7.k.g(j4, j10) < 0 && (jArr = this.f5768i) != null && (iC = r.c(jArr, j2)) >= 0) {
            int length = jArr.length;
            int i2 = length - 1;
            if (i2 == 0) {
                jArr2 = null;
            } else {
                long[] jArr3 = new long[i2];
                if (iC > 0) {
                    d7.n.X(jArr, jArr3, 0, 0, iC);
                }
                if (iC < i2) {
                    d7.n.X(jArr, jArr3, iC, iC + 1, length);
                }
                jArr2 = jArr3;
            }
            return new k(this.f5765f, this.f5766g, this.f5767h, jArr2);
        }
        return this;
    }

    public final boolean h(long j2) {
        long[] jArr;
        long j4 = j2 - this.f5767h;
        long j10 = 0;
        return (q7.k.g(j4, j10) < 0 || q7.k.g(j4, (long) 64) >= 0) ? (q7.k.g(j4, (long) 64) < 0 || q7.k.g(j4, (long) 128) >= 0) ? q7.k.g(j4, j10) <= 0 && (jArr = this.f5768i) != null && r.c(jArr, j2) >= 0 : ((1 << (((int) j4) - 64)) & this.f5765f) != 0 : ((1 << ((int) j4)) & this.f5766g) != 0;
    }

    public final k i(k kVar) {
        k kVarJ;
        long[] jArr;
        k kVarJ2 = this;
        k kVar2 = f5764j;
        if (kVar == kVar2) {
            return kVarJ2;
        }
        if (kVarJ2 == kVar2) {
            return kVar;
        }
        long j2 = kVar.f5767h;
        long j4 = kVar.f5767h;
        long[] jArr2 = kVar.f5768i;
        long j10 = kVar.f5766g;
        long j11 = kVar.f5765f;
        long j12 = kVarJ2.f5767h;
        long j13 = kVarJ2.f5766g;
        long j14 = kVarJ2.f5765f;
        if (j2 == j12 && jArr2 == (jArr = kVarJ2.f5768i)) {
            return new k(j14 | j11, j13 | j10, j12, jArr);
        }
        int i2 = 0;
        long[] jArr3 = kVarJ2.f5768i;
        if (jArr3 != null) {
            if (jArr2 != null) {
                for (long j15 : jArr2) {
                    kVarJ2 = kVarJ2.j(j15);
                }
            }
            if (j10 != 0) {
                for (int i10 = 0; i10 < 64; i10++) {
                    if (((1 << i10) & j10) != 0) {
                        kVarJ2 = kVarJ2.j(i10 + j4);
                    }
                }
            }
            if (j11 != 0) {
                while (i2 < 64) {
                    if (((1 << i2) & j11) != 0) {
                        kVarJ2 = kVarJ2.j(i2 + j4 + 64);
                    }
                    i2++;
                }
            }
            return kVarJ2;
        }
        if (jArr3 != null) {
            kVarJ = kVar;
            for (long j16 : jArr3) {
                kVarJ = kVarJ.j(j16);
            }
        } else {
            kVarJ = kVar;
        }
        long j17 = kVarJ2.f5767h;
        if (j13 != 0) {
            for (int i11 = 0; i11 < 64; i11++) {
                if (((1 << i11) & j13) != 0) {
                    kVarJ = kVarJ.j(i11 + j17);
                }
            }
        }
        if (j14 != 0) {
            while (i2 < 64) {
                if (((1 << i2) & j14) != 0) {
                    kVarJ = kVarJ.j(i2 + j17 + 64);
                }
                i2++;
            }
        }
        return kVarJ;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return s7.a.F(new j(this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final l0.k j(long r30) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.k.j(long):l0.k");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(" [");
        ArrayList arrayList = new ArrayList(d7.t.A0(this, 10));
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).longValue()));
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append((CharSequence) "");
        int size = arrayList.size();
        int i2 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = arrayList.get(i10);
            i2++;
            if (i2 > 1) {
                sb3.append((CharSequence) ", ");
            }
            if (obj != null ? obj instanceof CharSequence : true) {
                sb3.append((CharSequence) obj);
            } else if (obj instanceof Character) {
                sb3.append(((Character) obj).charValue());
            } else {
                sb3.append((CharSequence) obj.toString());
            }
        }
        sb3.append((CharSequence) "");
        sb2.append(sb3.toString());
        sb2.append(']');
        return sb2.toString();
    }
}
