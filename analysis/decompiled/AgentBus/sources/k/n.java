package k;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class n implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ boolean f5507f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ long[] f5508g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object[] f5509h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ int f5510i;

    public n(int i2) {
        if (i2 == 0) {
            this.f5508g = l.a.f5725b;
            this.f5509h = l.a.f5726c;
            return;
        }
        int i10 = i2 * 8;
        int i11 = 4;
        while (true) {
            if (i11 >= 32) {
                break;
            }
            int i12 = (1 << i11) - 12;
            if (i10 <= i12) {
                i10 = i12;
                break;
            }
            i11++;
        }
        int i13 = i10 / 8;
        this.f5508g = new long[i13];
        this.f5509h = new Object[i13];
    }

    public final long a(int i2) {
        int i10;
        if (i2 < 0 || i2 >= (i10 = this.f5510i)) {
            l.a.c("Expected index to be within 0..size()-1, but was " + i2);
            throw null;
        }
        if (this.f5507f) {
            long[] jArr = this.f5508g;
            Object[] objArr = this.f5509h;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != o.f5511a) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.f5507f = false;
            this.f5510i = i11;
        }
        return this.f5508g[i2];
    }

    public final void b(long j2, Object obj) {
        Object obj2 = o.f5511a;
        int iB = l.a.b(this.f5508g, this.f5510i, j2);
        if (iB >= 0) {
            this.f5509h[iB] = obj;
            return;
        }
        int i2 = ~iB;
        int i10 = this.f5510i;
        if (i2 < i10) {
            Object[] objArr = this.f5509h;
            if (objArr[i2] == obj2) {
                this.f5508g[i2] = j2;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.f5507f) {
            long[] jArr = this.f5508g;
            if (i10 >= jArr.length) {
                Object[] objArr2 = this.f5509h;
                int i11 = 0;
                for (int i12 = 0; i12 < i10; i12++) {
                    Object obj3 = objArr2[i12];
                    if (obj3 != obj2) {
                        if (i12 != i11) {
                            jArr[i11] = jArr[i12];
                            objArr2[i11] = obj3;
                            objArr2[i12] = null;
                        }
                        i11++;
                    }
                }
                this.f5507f = false;
                this.f5510i = i11;
                i2 = ~l.a.b(this.f5508g, i11, j2);
            }
        }
        int i13 = this.f5510i;
        if (i13 >= this.f5508g.length) {
            int i14 = (i13 + 1) * 8;
            int i15 = 4;
            while (true) {
                if (i15 >= 32) {
                    break;
                }
                int i16 = (1 << i15) - 12;
                if (i14 <= i16) {
                    i14 = i16;
                    break;
                }
                i15++;
            }
            int i17 = i14 / 8;
            long[] jArrCopyOf = Arrays.copyOf(this.f5508g, i17);
            q7.k.d(jArrCopyOf, "copyOf(...)");
            this.f5508g = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f5509h, i17);
            q7.k.d(objArrCopyOf, "copyOf(...)");
            this.f5509h = objArrCopyOf;
        }
        int i18 = this.f5510i;
        if (i18 - i2 != 0) {
            long[] jArr2 = this.f5508g;
            int i19 = i2 + 1;
            d7.n.X(jArr2, jArr2, i19, i2, i18);
            Object[] objArr3 = this.f5509h;
            d7.n.Y(objArr3, objArr3, i19, i2, this.f5510i);
        }
        this.f5508g[i2] = j2;
        this.f5509h[i2] = obj;
        this.f5510i++;
    }

    public final int c() {
        if (this.f5507f) {
            int i2 = this.f5510i;
            long[] jArr = this.f5508g;
            Object[] objArr = this.f5509h;
            int i10 = 0;
            for (int i11 = 0; i11 < i2; i11++) {
                Object obj = objArr[i11];
                if (obj != o.f5511a) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.f5507f = false;
            this.f5510i = i10;
        }
        return this.f5510i;
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        q7.k.c(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        n nVar = (n) objClone;
        nVar.f5508g = (long[]) this.f5508g.clone();
        nVar.f5509h = (Object[]) this.f5509h.clone();
        return nVar;
    }

    public final Object d(int i2) {
        int i10;
        if (i2 < 0 || i2 >= (i10 = this.f5510i)) {
            l.a.c("Expected index to be within 0..size()-1, but was " + i2);
            throw null;
        }
        if (this.f5507f) {
            long[] jArr = this.f5508g;
            Object[] objArr = this.f5509h;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != o.f5511a) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.f5507f = false;
            this.f5510i = i11;
        }
        return this.f5509h[i2];
    }

    public final String toString() {
        if (c() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f5510i * 28);
        sb2.append('{');
        int i2 = this.f5510i;
        for (int i10 = 0; i10 < i2; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(a(i10));
            sb2.append('=');
            Object objD = d(i10);
            if (objD != sb2) {
                sb2.append(objD);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        q7.k.d(string, "toString(...)");
        return string;
    }
}
