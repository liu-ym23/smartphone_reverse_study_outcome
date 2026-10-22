package j;

import c5.l;
import java.util.Arrays;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f3293a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ long[] f3294b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f3295c;
    public /* synthetic */ int d;

    public g() {
        int i8;
        int i9 = 4;
        while (true) {
            i8 = 80;
            if (i9 >= 32) {
                break;
            }
            int i10 = (1 << i9) - 12;
            if (80 <= i10) {
                i8 = i10;
                break;
            }
            i9++;
        }
        int i11 = i8 / 8;
        this.f3294b = new long[i11];
        this.f3295c = new Object[i11];
    }

    public final void a() {
        int i8 = this.d;
        Object[] objArr = this.f3295c;
        for (int i9 = 0; i9 < i8; i9++) {
            objArr[i9] = null;
        }
        this.d = 0;
        this.f3293a = false;
    }

    public final Object b(long j4) {
        Object obj;
        int iB = k.a.b(this.d, j4, this.f3294b);
        if (iB < 0 || (obj = this.f3295c[iB]) == h.f3296a) {
            return null;
        }
        return obj;
    }

    public final long c(int i8) {
        int i9;
        if (i8 < 0 || i8 >= (i9 = this.d)) {
            throw new IllegalArgumentException(a8.b.j(i8, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (this.f3293a) {
            long[] jArr = this.f3294b;
            Object[] objArr = this.f3295c;
            int i10 = 0;
            for (int i11 = 0; i11 < i9; i11++) {
                Object obj = objArr[i11];
                if (obj != h.f3296a) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.f3293a = false;
            this.d = i10;
        }
        return this.f3294b[i8];
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        p.c(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        g gVar = (g) objClone;
        gVar.f3294b = (long[]) this.f3294b.clone();
        gVar.f3295c = (Object[]) this.f3295c.clone();
        return gVar;
    }

    public final void d(Object obj, long j4) {
        Object obj2 = h.f3296a;
        int iB = k.a.b(this.d, j4, this.f3294b);
        if (iB >= 0) {
            this.f3295c[iB] = obj;
            return;
        }
        int i8 = ~iB;
        int i9 = this.d;
        if (i8 < i9) {
            Object[] objArr = this.f3295c;
            if (objArr[i8] == obj2) {
                this.f3294b[i8] = j4;
                objArr[i8] = obj;
                return;
            }
        }
        if (this.f3293a) {
            long[] jArr = this.f3294b;
            if (i9 >= jArr.length) {
                Object[] objArr2 = this.f3295c;
                int i10 = 0;
                for (int i11 = 0; i11 < i9; i11++) {
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
                this.f3293a = false;
                this.d = i10;
                i8 = ~k.a.b(i10, j4, this.f3294b);
            }
        }
        int i12 = this.d;
        if (i12 >= this.f3294b.length) {
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
            long[] jArrCopyOf = Arrays.copyOf(this.f3294b, i16);
            p.d(jArrCopyOf, "copyOf(this, newSize)");
            this.f3294b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f3295c, i16);
            p.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f3295c = objArrCopyOf;
        }
        int i17 = this.d - i8;
        if (i17 != 0) {
            long[] jArr2 = this.f3294b;
            int i18 = i8 + 1;
            p.e(jArr2, "<this>");
            System.arraycopy(jArr2, i8, jArr2, i18, i17);
            Object[] objArr3 = this.f3295c;
            l.W(objArr3, objArr3, i18, i8, this.d);
        }
        this.f3294b[i8] = j4;
        this.f3295c[i8] = obj;
        this.d++;
    }

    public final int e() {
        if (this.f3293a) {
            int i8 = this.d;
            long[] jArr = this.f3294b;
            Object[] objArr = this.f3295c;
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                Object obj = objArr[i10];
                if (obj != h.f3296a) {
                    if (i10 != i9) {
                        jArr[i9] = jArr[i10];
                        objArr[i9] = obj;
                        objArr[i10] = null;
                    }
                    i9++;
                }
            }
            this.f3293a = false;
            this.d = i9;
        }
        return this.d;
    }

    public final Object f(int i8) {
        int i9;
        if (i8 < 0 || i8 >= (i9 = this.d)) {
            throw new IllegalArgumentException(a8.b.j(i8, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (this.f3293a) {
            long[] jArr = this.f3294b;
            Object[] objArr = this.f3295c;
            int i10 = 0;
            for (int i11 = 0; i11 < i9; i11++) {
                Object obj = objArr[i11];
                if (obj != h.f3296a) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.f3293a = false;
            this.d = i10;
        }
        return this.f3295c[i8];
    }

    public final String toString() {
        if (e() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        int i8 = this.d;
        for (int i9 = 0; i9 < i8; i9++) {
            if (i9 > 0) {
                sb.append(", ");
            }
            sb.append(c(i9));
            sb.append('=');
            Object objF = f(i9);
            if (objF != sb) {
                sb.append(objF);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        String string = sb.toString();
        p.d(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }
}
