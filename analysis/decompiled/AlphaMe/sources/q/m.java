package q;

import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import r.AbstractC0827a;

/* loaded from: classes.dex */
public final class m implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ int[] f13971a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object[] f13972b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ int f13973c;

    public m() {
        int i4;
        int i5 = 4;
        while (true) {
            i4 = 40;
            if (i5 >= 32) {
                break;
            }
            int i6 = (1 << i5) - 12;
            if (40 <= i6) {
                i4 = i6;
                break;
            }
            i5++;
        }
        int i7 = i4 / 4;
        this.f13971a = new int[i7];
        this.f13972b = new Object[i7];
    }

    public final void a(int i4, Object obj) {
        int i5 = this.f13973c;
        if (i5 != 0 && i4 <= this.f13971a[i5 - 1]) {
            d(i4, obj);
            return;
        }
        if (i5 >= this.f13971a.length) {
            int i6 = (i5 + 1) * 4;
            int i7 = 4;
            while (true) {
                if (i7 >= 32) {
                    break;
                }
                int i8 = (1 << i7) - 12;
                if (i6 <= i8) {
                    i6 = i8;
                    break;
                }
                i7++;
            }
            int i9 = i6 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f13971a, i9);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.f13971a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f13972b, i9);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.f13972b = objArrCopyOf;
        }
        this.f13971a[i5] = i4;
        this.f13972b[i5] = obj;
        this.f13973c = i5 + 1;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final m clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        m mVar = (m) objClone;
        mVar.f13971a = (int[]) this.f13971a.clone();
        mVar.f13972b = (Object[]) this.f13972b.clone();
        return mVar;
    }

    public final Object c(int i4) {
        Object obj;
        Object obj2 = n.f13974a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        int iA = AbstractC0827a.a(this.f13973c, i4, this.f13971a);
        if (iA < 0 || (obj = this.f13972b[iA]) == n.f13974a) {
            return null;
        }
        return obj;
    }

    public final void d(int i4, Object obj) {
        int iA = AbstractC0827a.a(this.f13973c, i4, this.f13971a);
        if (iA >= 0) {
            this.f13972b[iA] = obj;
            return;
        }
        int i5 = ~iA;
        int i6 = this.f13973c;
        if (i5 < i6) {
            Object[] objArr = this.f13972b;
            if (objArr[i5] == n.f13974a) {
                this.f13971a[i5] = i4;
                objArr[i5] = obj;
                return;
            }
        }
        if (i6 >= this.f13971a.length) {
            int i7 = (i6 + 1) * 4;
            int i8 = 4;
            while (true) {
                if (i8 >= 32) {
                    break;
                }
                int i9 = (1 << i8) - 12;
                if (i7 <= i9) {
                    i7 = i9;
                    break;
                }
                i8++;
            }
            int i10 = i7 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f13971a, i10);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.f13971a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f13972b, i10);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.f13972b = objArrCopyOf;
        }
        int i11 = this.f13973c;
        if (i11 - i5 != 0) {
            int[] iArr = this.f13971a;
            int i12 = i5 + 1;
            ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i12, i5, i11);
            Object[] objArr2 = this.f13972b;
            ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, i12, i5, this.f13973c);
        }
        this.f13971a[i5] = i4;
        this.f13972b[i5] = obj;
        this.f13973c++;
    }

    public final String toString() {
        int i4 = this.f13973c;
        if (i4 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i4 * 28);
        sb.append('{');
        int i5 = this.f13973c;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(this.f13971a[i6]);
            sb.append('=');
            Object obj = this.f13972b[i6];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "buffer.toString()");
        return string;
    }
}
