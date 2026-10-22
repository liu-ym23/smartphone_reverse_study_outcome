package u0;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k implements Iterable, zb.a {
    public static final k i = new k(0, 0, 0, null);

    /* renamed from: c, reason: collision with root package name */
    public final long f13667c;

    /* renamed from: f, reason: collision with root package name */
    public final long f13668f;

    /* renamed from: g, reason: collision with root package name */
    public final long f13669g;

    /* renamed from: h, reason: collision with root package name */
    public final long[] f13670h;

    public k(long j10, long j11, long j12, long[] jArr) {
        this.f13667c = j10;
        this.f13668f = j11;
        this.f13669g = j12;
        this.f13670h = jArr;
    }

    public final k a(k kVar) {
        long[] jArr;
        k kVarB = this;
        k kVar2 = i;
        if (kVar == kVar2) {
            return kVarB;
        }
        if (kVarB == kVar2) {
            return kVar2;
        }
        long j10 = kVar.f13669g;
        long j11 = kVar.f13669g;
        long[] jArr2 = kVar.f13670h;
        long j12 = kVar.f13668f;
        long j13 = kVar.f13667c;
        long j14 = kVarB.f13669g;
        if (j10 == j14 && jArr2 == (jArr = kVarB.f13670h)) {
            return new k(kVarB.f13667c & (~j13), kVarB.f13668f & (~j12), j14, jArr);
        }
        if (jArr2 != null) {
            for (long j15 : jArr2) {
                kVarB = kVarB.b(j15);
            }
        }
        if (j12 != 0) {
            for (int i3 = 0; i3 < 64; i3++) {
                if (((1 << i3) & j12) != 0) {
                    kVarB = kVarB.b(i3 + j11);
                }
            }
        }
        if (j13 != 0) {
            for (int i10 = 0; i10 < 64; i10++) {
                if (((1 << i10) & j13) != 0) {
                    kVarB = kVarB.b(i10 + j11 + 64);
                }
            }
        }
        return kVarB;
    }

    public final k b(long j10) {
        long[] jArr;
        int iC;
        long[] jArr2;
        long j11 = j10 - this.f13669g;
        long j12 = 0;
        if (yb.k.c(j11, j12) >= 0 && yb.k.c(j11, 64) < 0) {
            long j13 = 1 << ((int) j11);
            long j14 = this.f13668f;
            if ((j14 & j13) != 0) {
                return new k(this.f13667c, j14 & (~j13), this.f13669g, this.f13670h);
            }
        } else if (yb.k.c(j11, 64) >= 0 && yb.k.c(j11, 128) < 0) {
            long j15 = 1 << (((int) j11) - 64);
            long j16 = this.f13667c;
            if ((j16 & j15) != 0) {
                return new k(j16 & (~j15), this.f13668f, this.f13669g, this.f13670h);
            }
        } else if (yb.k.c(j11, j12) < 0 && (jArr = this.f13670h) != null && (iC = r.c(jArr, j10)) >= 0) {
            int length = jArr.length;
            int i3 = length - 1;
            if (i3 == 0) {
                jArr2 = null;
            } else {
                long[] jArr3 = new long[i3];
                if (iC > 0) {
                    kb.k.h0(jArr, jArr3, 0, 0, iC);
                }
                if (iC < i3) {
                    kb.k.h0(jArr, jArr3, iC, iC + 1, length);
                }
                jArr2 = jArr3;
            }
            return new k(this.f13667c, this.f13668f, this.f13669g, jArr2);
        }
        return this;
    }

    public final boolean c(long j10) {
        long[] jArr;
        long j11 = j10 - this.f13669g;
        long j12 = 0;
        return (yb.k.c(j11, j12) < 0 || yb.k.c(j11, (long) 64) >= 0) ? (yb.k.c(j11, (long) 64) < 0 || yb.k.c(j11, (long) 128) >= 0) ? yb.k.c(j11, j12) <= 0 && (jArr = this.f13670h) != null && r.c(jArr, j10) >= 0 : ((1 << (((int) j11) - 64)) & this.f13667c) != 0 : ((1 << ((int) j11)) & this.f13668f) != 0;
    }

    public final k d(k kVar) {
        k kVarE;
        long[] jArr;
        k kVarE2 = this;
        k kVar2 = i;
        if (kVar == kVar2) {
            return kVarE2;
        }
        if (kVarE2 == kVar2) {
            return kVar;
        }
        long j10 = kVar.f13669g;
        long j11 = kVar.f13669g;
        long[] jArr2 = kVar.f13670h;
        long j12 = kVar.f13668f;
        long j13 = kVar.f13667c;
        long j14 = kVarE2.f13669g;
        long j15 = kVarE2.f13668f;
        long j16 = kVarE2.f13667c;
        if (j10 == j14 && jArr2 == (jArr = kVarE2.f13670h)) {
            return new k(j16 | j13, j15 | j12, j14, jArr);
        }
        int i3 = 0;
        long[] jArr3 = kVarE2.f13670h;
        if (jArr3 != null) {
            if (jArr2 != null) {
                for (long j17 : jArr2) {
                    kVarE2 = kVarE2.e(j17);
                }
            }
            if (j12 != 0) {
                for (int i10 = 0; i10 < 64; i10++) {
                    if (((1 << i10) & j12) != 0) {
                        kVarE2 = kVarE2.e(i10 + j11);
                    }
                }
            }
            if (j13 != 0) {
                while (i3 < 64) {
                    if (((1 << i3) & j13) != 0) {
                        kVarE2 = kVarE2.e(i3 + j11 + 64);
                    }
                    i3++;
                }
            }
            return kVarE2;
        }
        if (jArr3 != null) {
            kVarE = kVar;
            for (long j18 : jArr3) {
                kVarE = kVarE.e(j18);
            }
        } else {
            kVarE = kVar;
        }
        long j19 = kVarE2.f13669g;
        if (j15 != 0) {
            for (int i11 = 0; i11 < 64; i11++) {
                if (((1 << i11) & j15) != 0) {
                    kVarE = kVarE.e(i11 + j19);
                }
            }
        }
        if (j16 != 0) {
            while (i3 < 64) {
                if (((1 << i3) & j16) != 0) {
                    kVarE = kVarE.e(i3 + j19 + 64);
                }
                i3++;
            }
        }
        return kVarE;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0169  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final u0.k e(long r30) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.k.e(long):u0.k");
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [pb.h, xb.p] */
    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return td.h.A((pb.h) td.h.I(new j(this, null)).f4705b);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(" [");
        ArrayList arrayList = new ArrayList(kb.m.m0(this, 10));
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).longValue()));
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append((CharSequence) "");
        int size = arrayList.size();
        int i3 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = arrayList.get(i10);
            i3++;
            if (i3 > 1) {
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
