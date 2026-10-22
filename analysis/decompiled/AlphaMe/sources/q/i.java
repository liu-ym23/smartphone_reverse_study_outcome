package q;

import androidx.room.AbstractC0351g;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import r.AbstractC0827a;

/* loaded from: classes.dex */
public final class i implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f13957a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ long[] f13958b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f13959c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f13960d;

    public i() {
        this(10);
    }

    public final void a() {
        int i4 = this.f13960d;
        Object[] objArr = this.f13959c;
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = null;
        }
        this.f13960d = 0;
        this.f13957a = false;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final i clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        i iVar = (i) objClone;
        iVar.f13958b = (long[]) this.f13958b.clone();
        iVar.f13959c = (Object[]) this.f13959c.clone();
        return iVar;
    }

    public final void c(long j4) {
        int iB = AbstractC0827a.b(this.f13958b, this.f13960d, j4);
        if (iB >= 0) {
            Object[] objArr = this.f13959c;
            Object obj = objArr[iB];
            Object obj2 = j.f13961a;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f13957a = true;
            }
        }
    }

    public final Object d(long j4) {
        Object obj;
        int iB = AbstractC0827a.b(this.f13958b, this.f13960d, j4);
        if (iB < 0 || (obj = this.f13959c[iB]) == j.f13961a) {
            return null;
        }
        return obj;
    }

    public final long e(int i4) {
        int i5;
        if (i4 < 0 || i4 >= (i5 = this.f13960d)) {
            throw new IllegalArgumentException(AbstractC0351g.m("Expected index to be within 0..size()-1, but was ", i4).toString());
        }
        if (this.f13957a) {
            long[] jArr = this.f13958b;
            Object[] objArr = this.f13959c;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != j.f13961a) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.f13957a = false;
            this.f13960d = i6;
        }
        return this.f13958b[i4];
    }

    public final void f(long j4, Object obj) {
        int iB = AbstractC0827a.b(this.f13958b, this.f13960d, j4);
        if (iB >= 0) {
            this.f13959c[iB] = obj;
            return;
        }
        int i4 = ~iB;
        int i5 = this.f13960d;
        if (i4 < i5) {
            Object[] objArr = this.f13959c;
            if (objArr[i4] == j.f13961a) {
                this.f13958b[i4] = j4;
                objArr[i4] = obj;
                return;
            }
        }
        if (this.f13957a) {
            long[] jArr = this.f13958b;
            if (i5 >= jArr.length) {
                Object[] objArr2 = this.f13959c;
                int i6 = 0;
                for (int i7 = 0; i7 < i5; i7++) {
                    Object obj2 = objArr2[i7];
                    if (obj2 != j.f13961a) {
                        if (i7 != i6) {
                            jArr[i6] = jArr[i7];
                            objArr2[i6] = obj2;
                            objArr2[i7] = null;
                        }
                        i6++;
                    }
                }
                this.f13957a = false;
                this.f13960d = i6;
                i4 = ~AbstractC0827a.b(this.f13958b, i6, j4);
            }
        }
        int i8 = this.f13960d;
        if (i8 >= this.f13958b.length) {
            int i9 = (i8 + 1) * 8;
            int i10 = 4;
            while (true) {
                if (i10 >= 32) {
                    break;
                }
                int i11 = (1 << i10) - 12;
                if (i9 <= i11) {
                    i9 = i11;
                    break;
                }
                i10++;
            }
            int i12 = i9 / 8;
            long[] jArrCopyOf = Arrays.copyOf(this.f13958b, i12);
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(this, newSize)");
            this.f13958b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f13959c, i12);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.f13959c = objArrCopyOf;
        }
        int i13 = this.f13960d;
        if (i13 - i4 != 0) {
            long[] jArr2 = this.f13958b;
            int i14 = i4 + 1;
            ArraysKt___ArraysJvmKt.copyInto(jArr2, jArr2, i14, i4, i13);
            Object[] objArr3 = this.f13959c;
            ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, i14, i4, this.f13960d);
        }
        this.f13958b[i4] = j4;
        this.f13959c[i4] = obj;
        this.f13960d++;
    }

    public final int g() {
        if (this.f13957a) {
            int i4 = this.f13960d;
            long[] jArr = this.f13958b;
            Object[] objArr = this.f13959c;
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                Object obj = objArr[i6];
                if (obj != j.f13961a) {
                    if (i6 != i5) {
                        jArr[i5] = jArr[i6];
                        objArr[i5] = obj;
                        objArr[i6] = null;
                    }
                    i5++;
                }
            }
            this.f13957a = false;
            this.f13960d = i5;
        }
        return this.f13960d;
    }

    public final Object h(int i4) {
        int i5;
        if (i4 < 0 || i4 >= (i5 = this.f13960d)) {
            throw new IllegalArgumentException(AbstractC0351g.m("Expected index to be within 0..size()-1, but was ", i4).toString());
        }
        if (this.f13957a) {
            long[] jArr = this.f13958b;
            Object[] objArr = this.f13959c;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != j.f13961a) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.f13957a = false;
            this.f13960d = i6;
        }
        return this.f13959c[i4];
    }

    public final String toString() {
        if (g() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f13960d * 28);
        sb.append('{');
        int i4 = this.f13960d;
        for (int i5 = 0; i5 < i4; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            sb.append(e(i5));
            sb.append('=');
            Object objH = h(i5);
            if (objH != sb) {
                sb.append(objH);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public i(int i4) {
        if (i4 == 0) {
            this.f13958b = AbstractC0827a.f13998b;
            this.f13959c = AbstractC0827a.f13999c;
            return;
        }
        int i5 = i4 * 8;
        int i6 = 4;
        while (true) {
            if (i6 >= 32) {
                break;
            }
            int i7 = (1 << i6) - 12;
            if (i5 <= i7) {
                i5 = i7;
                break;
            }
            i6++;
        }
        int i8 = i5 / 8;
        this.f13958b = new long[i8];
        this.f13959c = new Object[i8];
    }
}
