package p;

import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ boolean f9593c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ long[] f9594f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object[] f9595g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ int f9596h;

    public n(int i) {
        if (i == 0) {
            this.f9594f = q.a.f10065b;
            this.f9595g = q.a.f10066c;
            return;
        }
        int i3 = i * 8;
        int i10 = 4;
        while (true) {
            if (i10 >= 32) {
                break;
            }
            int i11 = (1 << i10) - 12;
            if (i3 <= i11) {
                i3 = i11;
                break;
            }
            i10++;
        }
        int i12 = i3 / 8;
        this.f9594f = new long[i12];
        this.f9595g = new Object[i12];
    }

    public final void a() {
        int i = this.f9596h;
        Object[] objArr = this.f9595g;
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = null;
        }
        this.f9596h = 0;
        this.f9593c = false;
    }

    public final void b(long j10) {
        int iB = q.a.b(this.f9594f, this.f9596h, j10);
        if (iB >= 0) {
            Object[] objArr = this.f9595g;
            Object obj = objArr[iB];
            Object obj2 = o.f9598a;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f9593c = true;
            }
        }
    }

    public final Object c(long j10) {
        Object obj;
        int iB = q.a.b(this.f9594f, this.f9596h, j10);
        if (iB < 0 || (obj = this.f9595g[iB]) == o.f9598a) {
            return null;
        }
        return obj;
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        objClone.getClass();
        n nVar = (n) objClone;
        nVar.f9594f = (long[]) this.f9594f.clone();
        nVar.f9595g = (Object[]) this.f9595g.clone();
        return nVar;
    }

    public final long d(int i) {
        int i3;
        if (i < 0 || i >= (i3 = this.f9596h)) {
            g5.f.s(k0.a.j(i, "Expected index to be within 0..size()-1, but was "));
            return 0L;
        }
        if (this.f9593c) {
            long[] jArr = this.f9594f;
            Object[] objArr = this.f9595g;
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                Object obj = objArr[i11];
                if (obj != o.f9598a) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.f9593c = false;
            this.f9596h = i10;
        }
        return this.f9594f[i];
    }

    public final void e(Object obj, long j10) {
        Object obj2 = o.f9598a;
        int iB = q.a.b(this.f9594f, this.f9596h, j10);
        if (iB >= 0) {
            this.f9595g[iB] = obj;
            return;
        }
        int i = ~iB;
        int i3 = this.f9596h;
        if (i < i3) {
            Object[] objArr = this.f9595g;
            if (objArr[i] == obj2) {
                this.f9594f[i] = j10;
                objArr[i] = obj;
                return;
            }
        }
        if (this.f9593c) {
            long[] jArr = this.f9594f;
            if (i3 >= jArr.length) {
                Object[] objArr2 = this.f9595g;
                int i10 = 0;
                for (int i11 = 0; i11 < i3; i11++) {
                    Object obj3 = objArr2[i11];
                    if (obj3 != obj2) {
                        if (i11 != i10) {
                            jArr[i10] = jArr[i11];
                            objArr2[i10] = obj3;
                            objArr2[i11] = null;
                        }
                        i10++;
                    }
                }
                this.f9593c = false;
                this.f9596h = i10;
                i = ~q.a.b(this.f9594f, i10, j10);
            }
        }
        int i12 = this.f9596h;
        if (i12 >= this.f9594f.length) {
            int i13 = (i12 + 1) * 8;
            int i14 = 4;
            while (true) {
                if (i14 >= 32) {
                    break;
                }
                int i15 = (1 << i14) - 12;
                if (i13 <= i15) {
                    i13 = i15;
                    break;
                }
                i14++;
            }
            int i16 = i13 / 8;
            this.f9594f = Arrays.copyOf(this.f9594f, i16);
            this.f9595g = Arrays.copyOf(this.f9595g, i16);
        }
        int i17 = this.f9596h;
        if (i17 - i != 0) {
            long[] jArr2 = this.f9594f;
            int i18 = i + 1;
            kb.k.h0(jArr2, jArr2, i18, i, i17);
            Object[] objArr3 = this.f9595g;
            kb.k.i0(objArr3, objArr3, i18, i, this.f9596h);
        }
        this.f9594f[i] = j10;
        this.f9595g[i] = obj;
        this.f9596h++;
    }

    public final void f(long j10) {
        int iB = q.a.b(this.f9594f, this.f9596h, j10);
        if (iB >= 0) {
            Object[] objArr = this.f9595g;
            Object obj = objArr[iB];
            Object obj2 = o.f9598a;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f9593c = true;
            }
        }
    }

    public final int h() {
        if (this.f9593c) {
            int i = this.f9596h;
            long[] jArr = this.f9594f;
            Object[] objArr = this.f9595g;
            int i3 = 0;
            for (int i10 = 0; i10 < i; i10++) {
                Object obj = objArr[i10];
                if (obj != o.f9598a) {
                    if (i10 != i3) {
                        jArr[i3] = jArr[i10];
                        objArr[i3] = obj;
                        objArr[i10] = null;
                    }
                    i3++;
                }
            }
            this.f9593c = false;
            this.f9596h = i3;
        }
        return this.f9596h;
    }

    public final Object j(int i) {
        int i3;
        if (i < 0 || i >= (i3 = this.f9596h)) {
            g5.f.s(k0.a.j(i, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        if (this.f9593c) {
            long[] jArr = this.f9594f;
            Object[] objArr = this.f9595g;
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                Object obj = objArr[i11];
                if (obj != o.f9598a) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.f9593c = false;
            this.f9596h = i10;
        }
        return this.f9595g[i];
    }

    public final String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f9596h * 28);
        sb2.append('{');
        int i = this.f9596h;
        for (int i3 = 0; i3 < i; i3++) {
            if (i3 > 0) {
                sb2.append(", ");
            }
            sb2.append(d(i3));
            sb2.append('=');
            Object objJ = j(i3);
            if (objJ != sb2) {
                sb2.append(objJ);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public /* synthetic */ n(Object obj) {
        this(10);
    }
}
