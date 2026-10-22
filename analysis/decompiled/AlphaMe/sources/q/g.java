package q;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableSet;
import r.AbstractC0827a;

/* loaded from: classes.dex */
public final class g implements Collection, Set, KMutableCollection, KMutableSet {

    /* renamed from: a, reason: collision with root package name */
    public int[] f13951a = AbstractC0827a.f13997a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f13952b = AbstractC0827a.f13999c;

    /* renamed from: c, reason: collision with root package name */
    public int f13953c;

    public g(int i4) {
        if (i4 > 0) {
            com.airbnb.lottie.h.b(this, i4);
        }
    }

    public final Object a(int i4) {
        int i5 = this.f13953c;
        Object[] objArr = this.f13952b;
        Object obj = objArr[i4];
        if (i5 <= 1) {
            clear();
        } else {
            int i6 = i5 - 1;
            int[] iArr = this.f13951a;
            if (iArr.length <= 8 || i5 >= iArr.length / 3) {
                if (i4 < i6) {
                    int i7 = i4 + 1;
                    ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i4, i7, i5);
                    Object[] objArr2 = this.f13952b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, i4, i7, i5);
                }
                this.f13952b[i6] = null;
            } else {
                com.airbnb.lottie.h.b(this, i5 > 8 ? i5 + (i5 >> 1) : 8);
                if (i4 > 0) {
                    ArraysKt___ArraysJvmKt.copyInto$default(iArr, this.f13951a, 0, 0, i4, 6, (Object) null);
                    ArraysKt___ArraysJvmKt.copyInto$default(objArr, this.f13952b, 0, 0, i4, 6, (Object) null);
                }
                if (i4 < i6) {
                    int i8 = i4 + 1;
                    ArraysKt___ArraysJvmKt.copyInto(iArr, this.f13951a, i4, i8, i5);
                    ArraysKt___ArraysJvmKt.copyInto(objArr, this.f13952b, i4, i8, i5);
                }
            }
            if (i5 != this.f13953c) {
                throw new ConcurrentModificationException();
            }
            this.f13953c = i6;
        }
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i4;
        int iR;
        int i5 = this.f13953c;
        if (obj == null) {
            Intrinsics.checkNotNullParameter(this, "<this>");
            iR = com.airbnb.lottie.h.r(this, null, 0);
            i4 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i4 = iHashCode;
            iR = com.airbnb.lottie.h.r(this, obj, iHashCode);
        }
        if (iR >= 0) {
            return false;
        }
        int i6 = ~iR;
        int[] iArr = this.f13951a;
        if (i5 >= iArr.length) {
            int i7 = 8;
            if (i5 >= 8) {
                i7 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i7 = 4;
            }
            Object[] objArr = this.f13952b;
            com.airbnb.lottie.h.b(this, i7);
            if (i5 != this.f13953c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f13951a;
            if (!(iArr2.length == 0)) {
                ArraysKt___ArraysJvmKt.copyInto$default(iArr, iArr2, 0, 0, iArr.length, 6, (Object) null);
                ArraysKt___ArraysJvmKt.copyInto$default(objArr, this.f13952b, 0, 0, objArr.length, 6, (Object) null);
            }
        }
        if (i6 < i5) {
            int[] iArr3 = this.f13951a;
            int i8 = i6 + 1;
            ArraysKt___ArraysJvmKt.copyInto(iArr3, iArr3, i8, i6, i5);
            Object[] objArr2 = this.f13952b;
            ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, i8, i6, i5);
        }
        int i9 = this.f13953c;
        if (i5 == i9) {
            int[] iArr4 = this.f13951a;
            if (i6 < iArr4.length) {
                iArr4[i6] = i4;
                this.f13952b[i6] = obj;
                this.f13953c = i9 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = elements.size() + this.f13953c;
        int i4 = this.f13953c;
        int[] iArr = this.f13951a;
        if (iArr.length < size) {
            Object[] objArr = this.f13952b;
            com.airbnb.lottie.h.b(this, size);
            int i5 = this.f13953c;
            if (i5 > 0) {
                ArraysKt___ArraysJvmKt.copyInto$default(iArr, this.f13951a, 0, 0, i5, 6, (Object) null);
                ArraysKt___ArraysJvmKt.copyInto$default(objArr, this.f13952b, 0, 0, this.f13953c, 6, (Object) null);
            }
        }
        if (this.f13953c != i4) {
            throw new ConcurrentModificationException();
        }
        Iterator it = elements.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.f13953c != 0) {
            int[] iArr = AbstractC0827a.f13997a;
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            this.f13951a = iArr;
            Object[] objArr = AbstractC0827a.f13999c;
            Intrinsics.checkNotNullParameter(objArr, "<set-?>");
            this.f13952b = objArr;
            this.f13953c = 0;
        }
        if (this.f13953c != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        int iR;
        if (obj == null) {
            Intrinsics.checkNotNullParameter(this, "<this>");
            iR = com.airbnb.lottie.h.r(this, null, 0);
        } else {
            iR = com.airbnb.lottie.h.r(this, obj, obj.hashCode());
        }
        return iR >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Set) && this.f13953c == ((Set) obj).size()) {
            try {
                int i4 = this.f13953c;
                for (int i5 = 0; i5 < i4; i5++) {
                    if (((Set) obj).contains(this.f13952b[i5])) {
                    }
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f13951a;
        int i4 = this.f13953c;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 += iArr[i6];
        }
        return i5;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f13953c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new C0818b(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iR;
        if (obj == null) {
            Intrinsics.checkNotNullParameter(this, "<this>");
            iR = com.airbnb.lottie.h.r(this, null, 0);
        } else {
            iR = com.airbnb.lottie.h.r(this, obj, obj.hashCode());
        }
        if (iR < 0) {
            return false;
        }
        a(iR);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z4 = false;
        for (int i4 = this.f13953c - 1; -1 < i4; i4--) {
            if (!CollectionsKt.contains(elements, this.f13952b[i4])) {
                a(i4);
                z4 = true;
            }
        }
        return z4;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f13953c;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] result) {
        Intrinsics.checkNotNullParameter(result, "array");
        int i4 = this.f13953c;
        if (result.length < i4) {
            result = (Object[]) Array.newInstance(result.getClass().getComponentType(), i4);
        } else if (result.length > i4) {
            result[i4] = null;
        }
        ArraysKt___ArraysJvmKt.copyInto(this.f13952b, result, 0, 0, this.f13953c);
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f13953c * 14);
        sb.append('{');
        int i4 = this.f13953c;
        for (int i5 = 0; i5 < i4; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            Object obj = this.f13952b[i5];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return ArraysKt.copyOfRange(this.f13952b, 0, this.f13953c);
    }
}
