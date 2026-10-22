package p;

import androidx.datastore.preferences.protobuf.b1;
import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e<E> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f11360a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ long[] f11361b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f11362c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f11363d;

    public e(int i10) {
        if (i10 == 0) {
            this.f11361b = q.a.f11483b;
            this.f11362c = q.a.f11484c;
            return;
        }
        int i11 = i10 * 8;
        int i12 = 4;
        while (true) {
            if (i12 >= 32) {
                break;
            }
            int i13 = (1 << i12) - 12;
            if (i11 <= i13) {
                i11 = i13;
                break;
            }
            i12++;
        }
        int i14 = i11 / 8;
        this.f11361b = new long[i14];
        this.f11362c = new Object[i14];
    }

    public final void b() {
        int i10 = this.f11363d;
        Object[] objArr = this.f11362c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f11363d = 0;
        this.f11360a = false;
    }

    public final void c(long j10) {
        int iB = q.a.b(this.f11361b, this.f11363d, j10);
        if (iB >= 0) {
            Object[] objArr = this.f11362c;
            Object obj = objArr[iB];
            Object obj2 = f.f11364a;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f11360a = true;
            }
        }
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        kotlin.jvm.internal.g.d(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        e eVar = (e) objClone;
        eVar.f11361b = (long[]) this.f11361b.clone();
        eVar.f11362c = (Object[]) this.f11362c.clone();
        return eVar;
    }

    public final E d(long j10) {
        E e10;
        int iB = q.a.b(this.f11361b, this.f11363d, j10);
        if (iB < 0 || (e10 = (E) this.f11362c[iB]) == f.f11364a) {
            return null;
        }
        return e10;
    }

    public final long e(int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.f11363d)) {
            q.a.c("Expected index to be within 0..size()-1, but was " + i10);
            throw null;
        }
        if (this.f11360a) {
            long[] jArr = this.f11361b;
            Object[] objArr = this.f11362c;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj = objArr[i13];
                if (obj != f.f11364a) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            this.f11360a = false;
            this.f11363d = i12;
        }
        return this.f11361b[i10];
    }

    public final void f(long j10, E e10) {
        Object obj = f.f11364a;
        int iB = q.a.b(this.f11361b, this.f11363d, j10);
        if (iB >= 0) {
            this.f11362c[iB] = e10;
            return;
        }
        int i10 = ~iB;
        int i11 = this.f11363d;
        if (i10 < i11) {
            Object[] objArr = this.f11362c;
            if (objArr[i10] == obj) {
                this.f11361b[i10] = j10;
                objArr[i10] = e10;
                return;
            }
        }
        if (this.f11360a) {
            long[] jArr = this.f11361b;
            if (i11 >= jArr.length) {
                Object[] objArr2 = this.f11362c;
                int i12 = 0;
                for (int i13 = 0; i13 < i11; i13++) {
                    Object obj2 = objArr2[i13];
                    if (obj2 != obj) {
                        if (i13 != i12) {
                            jArr[i12] = jArr[i13];
                            objArr2[i12] = obj2;
                            objArr2[i13] = null;
                        }
                        i12++;
                    }
                }
                this.f11360a = false;
                this.f11363d = i12;
                i10 = ~q.a.b(this.f11361b, i12, j10);
            }
        }
        int i14 = this.f11363d;
        if (i14 >= this.f11361b.length) {
            int i15 = (i14 + 1) * 8;
            int i16 = 4;
            while (true) {
                if (i16 >= 32) {
                    break;
                }
                int i17 = (1 << i16) - 12;
                if (i15 <= i17) {
                    i15 = i17;
                    break;
                }
                i16++;
            }
            int i18 = i15 / 8;
            long[] jArrCopyOf = Arrays.copyOf(this.f11361b, i18);
            kotlin.jvm.internal.g.e(jArrCopyOf, "copyOf(...)");
            this.f11361b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11362c, i18);
            kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            this.f11362c = objArrCopyOf;
        }
        int i19 = this.f11363d;
        if (i19 - i10 != 0) {
            long[] jArr2 = this.f11361b;
            int i20 = i10 + 1;
            b1.p(jArr2, jArr2, i20, i10, i19);
            Object[] objArr3 = this.f11362c;
            b1.q(objArr3, objArr3, i20, i10, this.f11363d);
        }
        this.f11361b[i10] = j10;
        this.f11362c[i10] = e10;
        this.f11363d++;
    }

    public final int g() {
        if (this.f11360a) {
            int i10 = this.f11363d;
            long[] jArr = this.f11361b;
            Object[] objArr = this.f11362c;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != f.f11364a) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.f11360a = false;
            this.f11363d = i11;
        }
        return this.f11363d;
    }

    public final E h(int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.f11363d)) {
            q.a.c("Expected index to be within 0..size()-1, but was " + i10);
            throw null;
        }
        if (this.f11360a) {
            long[] jArr = this.f11361b;
            Object[] objArr = this.f11362c;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj = objArr[i13];
                if (obj != f.f11364a) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            this.f11360a = false;
            this.f11363d = i12;
        }
        return (E) this.f11362c[i10];
    }

    public final String toString() {
        if (g() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f11363d * 28);
        sb2.append('{');
        int i10 = this.f11363d;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            sb2.append(e(i11));
            sb2.append('=');
            E eH = h(i11);
            if (eH != sb2) {
                sb2.append(eH);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public e() {
        this(10);
    }
}
