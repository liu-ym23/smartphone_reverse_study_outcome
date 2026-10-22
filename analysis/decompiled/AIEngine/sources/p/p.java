package p;

import androidx.datastore.preferences.protobuf.b1;
import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p<E> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ int[] f11386a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object[] f11387b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ int f11388c;

    public p() {
        int i10;
        int i11 = 4;
        while (true) {
            i10 = 40;
            if (i11 >= 32) {
                break;
            }
            int i12 = (1 << i11) - 12;
            if (40 <= i12) {
                i10 = i12;
                break;
            }
            i11++;
        }
        int i13 = i10 / 4;
        this.f11386a = new int[i13];
        this.f11387b = new Object[i13];
    }

    public final void b(int i10, E e10) {
        int i11 = this.f11388c;
        if (i11 != 0 && i10 <= this.f11386a[i11 - 1]) {
            d(i10, e10);
            return;
        }
        if (i11 >= this.f11386a.length) {
            int i12 = (i11 + 1) * 4;
            int i13 = 4;
            while (true) {
                if (i13 >= 32) {
                    break;
                }
                int i14 = (1 << i13) - 12;
                if (i12 <= i14) {
                    i12 = i14;
                    break;
                }
                i13++;
            }
            int i15 = i12 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f11386a, i15);
            kotlin.jvm.internal.g.e(iArrCopyOf, "copyOf(...)");
            this.f11386a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11387b, i15);
            kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            this.f11387b = objArrCopyOf;
        }
        this.f11386a[i11] = i10;
        this.f11387b[i11] = e10;
        this.f11388c = i11 + 1;
    }

    public final E c(int i10) {
        E e10;
        int iA = q.a.a(this.f11388c, i10, this.f11386a);
        if (iA < 0 || (e10 = (E) this.f11387b[iA]) == f.f11365b) {
            return null;
        }
        return e10;
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        kotlin.jvm.internal.g.d(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        p pVar = (p) objClone;
        pVar.f11386a = (int[]) this.f11386a.clone();
        pVar.f11387b = (Object[]) this.f11387b.clone();
        return pVar;
    }

    public final void d(int i10, E e10) {
        int iA = q.a.a(this.f11388c, i10, this.f11386a);
        if (iA >= 0) {
            this.f11387b[iA] = e10;
            return;
        }
        int i11 = ~iA;
        int i12 = this.f11388c;
        if (i11 < i12) {
            Object[] objArr = this.f11387b;
            if (objArr[i11] == f.f11365b) {
                this.f11386a[i11] = i10;
                objArr[i11] = e10;
                return;
            }
        }
        if (i12 >= this.f11386a.length) {
            int i13 = (i12 + 1) * 4;
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
            int i16 = i13 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f11386a, i16);
            kotlin.jvm.internal.g.e(iArrCopyOf, "copyOf(...)");
            this.f11386a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11387b, i16);
            kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            this.f11387b = objArrCopyOf;
        }
        int i17 = this.f11388c;
        if (i17 - i11 != 0) {
            int[] iArr = this.f11386a;
            int i18 = i11 + 1;
            b1.o(i18, i11, iArr, iArr, i17);
            Object[] objArr2 = this.f11387b;
            b1.q(objArr2, objArr2, i18, i11, this.f11388c);
        }
        this.f11386a[i11] = i10;
        this.f11387b[i11] = e10;
        this.f11388c++;
    }

    public final E e(int i10) {
        Object[] objArr = this.f11387b;
        if (i10 < objArr.length) {
            return (E) objArr[i10];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final String toString() {
        int i10 = this.f11388c;
        if (i10 <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(i10 * 28);
        sb2.append('{');
        int i11 = this.f11388c;
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            sb2.append(this.f11386a[i12]);
            sb2.append('=');
            E e10 = e(i12);
            if (e10 != this) {
                sb2.append(e10);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }
}
