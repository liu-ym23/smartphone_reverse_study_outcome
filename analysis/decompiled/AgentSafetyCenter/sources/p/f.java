package p;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements Collection, Set, zb.b, zb.d {

    /* renamed from: c, reason: collision with root package name */
    public int[] f9549c = q.a.f10064a;

    /* renamed from: f, reason: collision with root package name */
    public Object[] f9550f = q.a.f10066c;

    /* renamed from: g, reason: collision with root package name */
    public int f9551g;

    public f(int i) {
    }

    public final Object a(int i) {
        int i3 = this.f9551g;
        Object[] objArr = this.f9550f;
        Object obj = objArr[i];
        if (i3 <= 1) {
            clear();
            return obj;
        }
        int i10 = i3 - 1;
        int[] iArr = this.f9549c;
        if (iArr.length <= 8 || i3 >= iArr.length / 3) {
            if (i < i10) {
                int i11 = i + 1;
                kb.k.f0(i, i11, iArr, iArr, i3);
                Object[] objArr2 = this.f9550f;
                kb.k.i0(objArr2, objArr2, i, i11, i3);
            }
            this.f9550f[i10] = null;
        } else {
            int i12 = i3 > 8 ? i3 + (i3 >> 1) : 8;
            int[] iArr2 = new int[i12];
            this.f9549c = iArr2;
            this.f9550f = new Object[i12];
            if (i > 0) {
                kb.k.j0(0, i, iArr, iArr2, 6);
                kb.k.k0(objArr, this.f9550f, 0, i, 6);
            }
            if (i < i10) {
                int i13 = i + 1;
                kb.k.f0(i, i13, iArr, this.f9549c, i3);
                kb.k.i0(objArr, this.f9550f, i, i13, i3);
            }
        }
        if (i3 != this.f9551g) {
            throw new ConcurrentModificationException();
        }
        this.f9551g = i10;
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i;
        int iA;
        int i3 = this.f9551g;
        if (obj == null) {
            iA = o.a(this, null, 0);
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iA = o.a(this, obj, iHashCode);
        }
        if (iA >= 0) {
            return false;
        }
        int i10 = ~iA;
        int[] iArr = this.f9549c;
        if (i3 >= iArr.length) {
            int i11 = 8;
            if (i3 >= 8) {
                i11 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i11 = 4;
            }
            Object[] objArr = this.f9550f;
            int[] iArr2 = new int[i11];
            this.f9549c = iArr2;
            this.f9550f = new Object[i11];
            if (i3 != this.f9551g) {
                throw new ConcurrentModificationException();
            }
            if (iArr2.length != 0) {
                kb.k.j0(0, iArr.length, iArr, iArr2, 6);
                kb.k.k0(objArr, this.f9550f, 0, objArr.length, 6);
            }
        }
        if (i10 < i3) {
            int[] iArr3 = this.f9549c;
            int i12 = i10 + 1;
            kb.k.f0(i12, i10, iArr3, iArr3, i3);
            Object[] objArr2 = this.f9550f;
            kb.k.i0(objArr2, objArr2, i12, i10, i3);
        }
        int i13 = this.f9551g;
        if (i3 == i13) {
            int[] iArr4 = this.f9549c;
            if (i10 < iArr4.length) {
                iArr4[i10] = i;
                this.f9550f[i10] = obj;
                this.f9551g = i13 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        collection.getClass();
        int size = collection.size() + this.f9551g;
        int i = this.f9551g;
        int[] iArr = this.f9549c;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f9550f;
            int[] iArr2 = new int[size];
            this.f9549c = iArr2;
            this.f9550f = new Object[size];
            if (i > 0) {
                kb.k.j0(0, i, iArr, iArr2, 6);
                kb.k.k0(objArr, this.f9550f, 0, this.f9551g, 6);
            }
        }
        if (this.f9551g != i) {
            throw new ConcurrentModificationException();
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.f9551g != 0) {
            this.f9549c = q.a.f10064a;
            this.f9550f = q.a.f10066c;
            this.f9551g = 0;
        }
        if (this.f9551g != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? o.a(this, null, 0) : o.a(this, obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        collection.getClass();
        Iterator it = collection.iterator();
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
        if (!(obj instanceof Set) || this.f9551g != ((Set) obj).size()) {
            return false;
        }
        try {
            int i = this.f9551g;
            for (int i3 = 0; i3 < i; i3++) {
                if (!((Set) obj).contains(this.f9550f[i3])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f9549c;
        int i = this.f9551g;
        int i3 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            i3 += iArr[i10];
        }
        return i3;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f9551g <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new a(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iA = obj == null ? o.a(this, null, 0) : o.a(this, obj, obj.hashCode());
        if (iA < 0) {
            return false;
        }
        a(iA);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        collection.getClass();
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        boolean z10 = false;
        for (int i = this.f9551g - 1; -1 < i; i--) {
            if (!kb.l.s0(collection, this.f9550f[i])) {
                a(i);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f9551g;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int i = this.f9551g;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        } else if (objArr.length > i) {
            objArr[i] = null;
        }
        kb.k.i0(this.f9550f, objArr, 0, 0, this.f9551g);
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f9551g * 14);
        sb2.append('{');
        int i = this.f9551g;
        for (int i3 = 0; i3 < i; i3++) {
            if (i3 > 0) {
                sb2.append(", ");
            }
            Object obj = this.f9550f[i3];
            if (obj != this) {
                sb2.append(obj);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return kb.k.l0(this.f9550f, 0, this.f9551g);
    }
}
