package j;

import c5.l;
import java.util.Arrays;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ int[] f3307a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object[] f3308b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ int f3309c;

    public k() {
        int i8;
        int i9 = 4;
        while (true) {
            i8 = 40;
            if (i9 >= 32) {
                break;
            }
            int i10 = (1 << i9) - 12;
            if (40 <= i10) {
                i8 = i10;
                break;
            }
            i9++;
        }
        int i11 = i8 / 4;
        this.f3307a = new int[i11];
        this.f3308b = new Object[i11];
    }

    public final void a(int i8, Object obj) {
        int i9 = this.f3309c;
        if (i9 != 0 && i8 <= this.f3307a[i9 - 1]) {
            c(i8, obj);
            return;
        }
        if (i9 >= this.f3307a.length) {
            int i10 = (i9 + 1) * 4;
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
            int i13 = i10 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f3307a, i13);
            p.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f3307a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f3308b, i13);
            p.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f3308b = objArrCopyOf;
        }
        this.f3307a[i9] = i8;
        this.f3308b[i9] = obj;
        this.f3309c = i9 + 1;
    }

    public final Object b(int i8) {
        Object obj;
        int iA = k.a.a(this.f3309c, i8, this.f3307a);
        if (iA < 0 || (obj = this.f3308b[iA]) == h.f3297b) {
            return null;
        }
        return obj;
    }

    public final void c(int i8, Object obj) {
        int iA = k.a.a(this.f3309c, i8, this.f3307a);
        if (iA >= 0) {
            this.f3308b[iA] = obj;
            return;
        }
        int i9 = ~iA;
        int i10 = this.f3309c;
        if (i9 < i10) {
            Object[] objArr = this.f3308b;
            if (objArr[i9] == h.f3297b) {
                this.f3307a[i9] = i8;
                objArr[i9] = obj;
                return;
            }
        }
        if (i10 >= this.f3307a.length) {
            int i11 = (i10 + 1) * 4;
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
            int i14 = i11 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f3307a, i14);
            p.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f3307a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f3308b, i14);
            p.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f3308b = objArrCopyOf;
        }
        int i15 = this.f3309c;
        if (i15 - i9 != 0) {
            int[] iArr = this.f3307a;
            int i16 = i9 + 1;
            l.V(i16, iArr, i9, iArr, i15);
            Object[] objArr2 = this.f3308b;
            l.W(objArr2, objArr2, i16, i9, this.f3309c);
        }
        this.f3307a[i9] = i8;
        this.f3308b[i9] = obj;
        this.f3309c++;
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        p.c(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        k kVar = (k) objClone;
        kVar.f3307a = (int[]) this.f3307a.clone();
        kVar.f3308b = (Object[]) this.f3308b.clone();
        return kVar;
    }

    public final String toString() {
        int i8 = this.f3309c;
        if (i8 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i8 * 28);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        int i9 = this.f3309c;
        for (int i10 = 0; i10 < i9; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            sb.append(this.f3307a[i10]);
            sb.append('=');
            Object obj = this.f3308b[i10];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        String string = sb.toString();
        p.d(string, "buffer.toString()");
        return string;
    }
}
