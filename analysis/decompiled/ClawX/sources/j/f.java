package j;

import c5.l;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f implements Collection, Set, q5.b {

    /* renamed from: a, reason: collision with root package name */
    public int[] f3290a = k.a.f3538a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f3291b = k.a.f3539b;

    /* renamed from: c, reason: collision with root package name */
    public int f3292c;

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i8;
        int iA;
        int i9 = this.f3292c;
        if (obj == null) {
            iA = h.a(this, null, 0);
            i8 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i8 = iHashCode;
            iA = h.a(this, obj, iHashCode);
        }
        if (iA >= 0) {
            return false;
        }
        int i10 = ~iA;
        int[] iArr = this.f3290a;
        if (i9 >= iArr.length) {
            int i11 = 8;
            if (i9 >= 8) {
                i11 = (i9 >> 1) + i9;
            } else if (i9 < 4) {
                i11 = 4;
            }
            Object[] objArr = this.f3291b;
            int[] iArr2 = new int[i11];
            this.f3290a = iArr2;
            this.f3291b = new Object[i11];
            if (i9 != this.f3292c) {
                throw new ConcurrentModificationException();
            }
            if (iArr2.length != 0) {
                l.X(iArr.length, 6, iArr, iArr2);
                l.Y(objArr, this.f3291b, 0, objArr.length, 6);
            }
        }
        if (i10 < i9) {
            int[] iArr3 = this.f3290a;
            int i12 = i10 + 1;
            l.V(i12, iArr3, i10, iArr3, i9);
            Object[] objArr2 = this.f3291b;
            l.W(objArr2, objArr2, i12, i10, i9);
        }
        int i13 = this.f3292c;
        if (i9 == i13) {
            int[] iArr4 = this.f3290a;
            if (i10 < iArr4.length) {
                iArr4[i10] = i8;
                this.f3291b[i10] = obj;
                this.f3292c = i13 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection elements) {
        p.e(elements, "elements");
        int size = elements.size() + this.f3292c;
        int i8 = this.f3292c;
        int[] iArr = this.f3290a;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f3291b;
            int[] iArr2 = new int[size];
            this.f3290a = iArr2;
            this.f3291b = new Object[size];
            if (i8 > 0) {
                l.X(i8, 6, iArr, iArr2);
                l.Y(objArr, this.f3291b, 0, this.f3292c, 6);
            }
        }
        if (this.f3292c != i8) {
            throw new ConcurrentModificationException();
        }
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.f3292c != 0) {
            this.f3290a = k.a.f3538a;
            this.f3291b = k.a.f3539b;
            this.f3292c = 0;
        }
        if (this.f3292c != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? h.a(this, null, 0) : h.a(this, obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection elements) {
        p.e(elements, "elements");
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
        if (!(obj instanceof Set) || this.f3292c != ((Set) obj).size()) {
            return false;
        }
        try {
            int i8 = this.f3292c;
            for (int i9 = 0; i9 < i8; i9++) {
                if (!((Set) obj).contains(this.f3291b[i9])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final Object f(int i8) {
        int i9 = this.f3292c;
        Object[] objArr = this.f3291b;
        Object obj = objArr[i8];
        if (i9 <= 1) {
            clear();
            return obj;
        }
        int i10 = i9 - 1;
        int[] iArr = this.f3290a;
        if (iArr.length <= 8 || i9 >= iArr.length / 3) {
            if (i8 < i10) {
                int i11 = i8 + 1;
                l.V(i8, iArr, i11, iArr, i9);
                Object[] objArr2 = this.f3291b;
                l.W(objArr2, objArr2, i8, i11, i9);
            }
            this.f3291b[i10] = null;
        } else {
            int i12 = i9 > 8 ? i9 + (i9 >> 1) : 8;
            int[] iArr2 = new int[i12];
            this.f3290a = iArr2;
            this.f3291b = new Object[i12];
            if (i8 > 0) {
                l.X(i8, 6, iArr, iArr2);
                l.Y(objArr, this.f3291b, 0, i8, 6);
            }
            if (i8 < i10) {
                int i13 = i8 + 1;
                l.V(i8, iArr, i13, this.f3290a, i9);
                l.W(objArr, this.f3291b, i8, i13, i9);
            }
        }
        if (i9 != this.f3292c) {
            throw new ConcurrentModificationException();
        }
        this.f3292c = i10;
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f3290a;
        int i8 = this.f3292c;
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            i9 += iArr[i10];
        }
        return i9;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f3292c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new a(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iA = obj == null ? h.a(this, null, 0) : h.a(this, obj, obj.hashCode());
        if (iA < 0) {
            return false;
        }
        f(iA);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection elements) {
        p.e(elements, "elements");
        Iterator it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection elements) {
        p.e(elements, "elements");
        boolean z = false;
        for (int i8 = this.f3292c - 1; -1 < i8; i8--) {
            if (!elements.contains(this.f3291b[i8])) {
                f(i8);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f3292c;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return l.a0(this.f3291b, 0, this.f3292c);
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3292c * 14);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        int i8 = this.f3292c;
        for (int i9 = 0; i9 < i8; i9++) {
            if (i9 > 0) {
                sb.append(", ");
            }
            Object obj = this.f3291b[i9];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        String string = sb.toString();
        p.d(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] array) {
        p.e(array, "array");
        int i8 = this.f3292c;
        if (array.length < i8) {
            array = (Object[]) Array.newInstance(array.getClass().getComponentType(), i8);
        } else if (array.length > i8) {
            array[i8] = null;
        }
        l.W(this.f3291b, array, 0, 0, this.f3292c);
        return array;
    }
}
