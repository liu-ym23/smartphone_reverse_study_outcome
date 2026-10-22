package q;

import W3.C0396g;
import java.util.Arrays;
import r.C0990a;

/* loaded from: classes.dex */
public class f<E> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f19629a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ long[] f19630b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f19631c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f19632d;

    public f() {
        this(0, 1, null);
    }

    public void b() {
        int i5 = this.f19632d;
        Object[] objArr = this.f19631c;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        this.f19632d = 0;
        this.f19629a = false;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public f<E> clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        j4.k.e(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        f<E> fVar = (f) objClone;
        fVar.f19630b = (long[]) this.f19630b.clone();
        fVar.f19631c = (Object[]) this.f19631c.clone();
        return fVar;
    }

    public void e(long j5) {
        int iB = C0990a.b(this.f19630b, this.f19632d, j5);
        if (iB < 0 || this.f19631c[iB] == g.f19633a) {
            return;
        }
        this.f19631c[iB] = g.f19633a;
        this.f19629a = true;
    }

    public E g(long j5) {
        int iB = C0990a.b(this.f19630b, this.f19632d, j5);
        if (iB < 0 || this.f19631c[iB] == g.f19633a) {
            return null;
        }
        return (E) this.f19631c[iB];
    }

    public int h(long j5) {
        if (this.f19629a) {
            int i5 = this.f19632d;
            long[] jArr = this.f19630b;
            Object[] objArr = this.f19631c;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != g.f19633a) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.f19629a = false;
            this.f19632d = i6;
        }
        return C0990a.b(this.f19630b, this.f19632d, j5);
    }

    public long i(int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this.f19632d)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
        }
        if (this.f19629a) {
            long[] jArr = this.f19630b;
            Object[] objArr = this.f19631c;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != g.f19633a) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            this.f19629a = false;
            this.f19632d = i7;
        }
        return this.f19630b[i5];
    }

    public void j(long j5, E e6) {
        int iB = C0990a.b(this.f19630b, this.f19632d, j5);
        if (iB >= 0) {
            this.f19631c[iB] = e6;
            return;
        }
        int i5 = ~iB;
        if (i5 < this.f19632d && this.f19631c[i5] == g.f19633a) {
            this.f19630b[i5] = j5;
            this.f19631c[i5] = e6;
            return;
        }
        if (this.f19629a) {
            int i6 = this.f19632d;
            long[] jArr = this.f19630b;
            if (i6 >= jArr.length) {
                Object[] objArr = this.f19631c;
                int i7 = 0;
                for (int i8 = 0; i8 < i6; i8++) {
                    Object obj = objArr[i8];
                    if (obj != g.f19633a) {
                        if (i8 != i7) {
                            jArr[i7] = jArr[i8];
                            objArr[i7] = obj;
                            objArr[i8] = null;
                        }
                        i7++;
                    }
                }
                this.f19629a = false;
                this.f19632d = i7;
                i5 = ~C0990a.b(this.f19630b, i7, j5);
            }
        }
        int i9 = this.f19632d;
        if (i9 >= this.f19630b.length) {
            int iF = C0990a.f(i9 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.f19630b, iF);
            j4.k.f(jArrCopyOf, "copyOf(this, newSize)");
            this.f19630b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f19631c, iF);
            j4.k.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f19631c = objArrCopyOf;
        }
        int i10 = this.f19632d;
        if (i10 - i5 != 0) {
            long[] jArr2 = this.f19630b;
            int i11 = i5 + 1;
            C0396g.e(jArr2, jArr2, i11, i5, i10);
            Object[] objArr2 = this.f19631c;
            C0396g.f(objArr2, objArr2, i11, i5, this.f19632d);
        }
        this.f19630b[i5] = j5;
        this.f19631c[i5] = e6;
        this.f19632d++;
    }

    public void k(long j5) {
        int iB = C0990a.b(this.f19630b, this.f19632d, j5);
        if (iB < 0 || this.f19631c[iB] == g.f19633a) {
            return;
        }
        this.f19631c[iB] = g.f19633a;
        this.f19629a = true;
    }

    public void l(int i5) {
        if (this.f19631c[i5] != g.f19633a) {
            this.f19631c[i5] = g.f19633a;
            this.f19629a = true;
        }
    }

    public void n(int i5, E e6) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this.f19632d)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
        }
        if (this.f19629a) {
            long[] jArr = this.f19630b;
            Object[] objArr = this.f19631c;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != g.f19633a) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            this.f19629a = false;
            this.f19632d = i7;
        }
        this.f19631c[i5] = e6;
    }

    public int p() {
        if (this.f19629a) {
            int i5 = this.f19632d;
            long[] jArr = this.f19630b;
            Object[] objArr = this.f19631c;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != g.f19633a) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.f19629a = false;
            this.f19632d = i6;
        }
        return this.f19632d;
    }

    public E q(int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this.f19632d)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
        }
        if (this.f19629a) {
            long[] jArr = this.f19630b;
            Object[] objArr = this.f19631c;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != g.f19633a) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            this.f19629a = false;
            this.f19632d = i7;
        }
        return (E) this.f19631c[i5];
    }

    public String toString() {
        if (p() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f19632d * 28);
        sb.append('{');
        int i5 = this.f19632d;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(i(i6));
            sb.append('=');
            E eQ = q(i6);
            if (eQ != sb) {
                sb.append(eQ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        j4.k.f(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public f(int i5) {
        if (i5 == 0) {
            this.f19630b = C0990a.f19952b;
            this.f19631c = C0990a.f19953c;
        } else {
            int iF = C0990a.f(i5);
            this.f19630b = new long[iF];
            this.f19631c = new Object[iF];
        }
    }

    public /* synthetic */ f(int i5, int i6, j4.g gVar) {
        this((i6 & 1) != 0 ? 10 : i5);
    }
}
