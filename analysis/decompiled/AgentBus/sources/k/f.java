package k;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class f implements Collection, Set, r7.b, r7.e {

    /* renamed from: f, reason: collision with root package name */
    public int[] f5484f = l.a.f5724a;

    /* renamed from: g, reason: collision with root package name */
    public Object[] f5485g = l.a.f5726c;

    /* renamed from: h, reason: collision with root package name */
    public int f5486h;

    public f(int i2) {
    }

    public final Object a(int i2) {
        int i10 = this.f5486h;
        Object[] objArr = this.f5485g;
        Object obj = objArr[i2];
        if (i10 <= 1) {
            clear();
            return obj;
        }
        int i11 = i10 - 1;
        int[] iArr = this.f5484f;
        if (iArr.length <= 8 || i10 >= iArr.length / 3) {
            if (i2 < i11) {
                int i12 = i2 + 1;
                d7.n.W(iArr, iArr, i2, i12, i10);
                Object[] objArr2 = this.f5485g;
                d7.n.Y(objArr2, objArr2, i2, i12, i10);
            }
            this.f5485g[i11] = null;
        } else {
            int i13 = i10 > 8 ? i10 + (i10 >> 1) : 8;
            int[] iArr2 = new int[i13];
            this.f5484f = iArr2;
            this.f5485g = new Object[i13];
            if (i2 > 0) {
                d7.n.Z(iArr, iArr2, 0, i2, 6);
                d7.n.a0(objArr, this.f5485g, 0, i2, 6);
            }
            if (i2 < i11) {
                int i14 = i2 + 1;
                d7.n.W(iArr, this.f5484f, i2, i14, i10);
                d7.n.Y(objArr, this.f5485g, i2, i14, i10);
            }
        }
        if (i10 != this.f5486h) {
            throw new ConcurrentModificationException();
        }
        this.f5486h = i11;
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i2;
        int iA;
        int i10 = this.f5486h;
        if (obj == null) {
            iA = o.a(this, null, 0);
            i2 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i2 = iHashCode;
            iA = o.a(this, obj, iHashCode);
        }
        if (iA >= 0) {
            return false;
        }
        int i11 = ~iA;
        int[] iArr = this.f5484f;
        if (i10 >= iArr.length) {
            int i12 = 8;
            if (i10 >= 8) {
                i12 = (i10 >> 1) + i10;
            } else if (i10 < 4) {
                i12 = 4;
            }
            Object[] objArr = this.f5485g;
            int[] iArr2 = new int[i12];
            this.f5484f = iArr2;
            this.f5485g = new Object[i12];
            if (i10 != this.f5486h) {
                throw new ConcurrentModificationException();
            }
            if (iArr2.length != 0) {
                d7.n.Z(iArr, iArr2, 0, iArr.length, 6);
                d7.n.a0(objArr, this.f5485g, 0, objArr.length, 6);
            }
        }
        if (i11 < i10) {
            int[] iArr3 = this.f5484f;
            int i13 = i11 + 1;
            d7.n.W(iArr3, iArr3, i13, i11, i10);
            Object[] objArr2 = this.f5485g;
            d7.n.Y(objArr2, objArr2, i13, i11, i10);
        }
        int i14 = this.f5486h;
        if (i10 == i14) {
            int[] iArr4 = this.f5484f;
            if (i11 < iArr4.length) {
                iArr4[i11] = i2;
                this.f5485g[i11] = obj;
                this.f5486h = i14 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        q7.k.e(collection, "elements");
        int size = collection.size() + this.f5486h;
        int i2 = this.f5486h;
        int[] iArr = this.f5484f;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f5485g;
            int[] iArr2 = new int[size];
            this.f5484f = iArr2;
            this.f5485g = new Object[size];
            if (i2 > 0) {
                d7.n.Z(iArr, iArr2, 0, i2, 6);
                d7.n.a0(objArr, this.f5485g, 0, this.f5486h, 6);
            }
        }
        if (this.f5486h != i2) {
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
        if (this.f5486h != 0) {
            this.f5484f = l.a.f5724a;
            this.f5485g = l.a.f5726c;
            this.f5486h = 0;
        }
        if (this.f5486h != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? o.a(this, null, 0) : o.a(this, obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        q7.k.e(collection, "elements");
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
        if (!(obj instanceof Set) || this.f5486h != ((Set) obj).size()) {
            return false;
        }
        try {
            int i2 = this.f5486h;
            for (int i10 = 0; i10 < i2; i10++) {
                if (!((Set) obj).contains(this.f5485g[i10])) {
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
        int[] iArr = this.f5484f;
        int i2 = this.f5486h;
        int i10 = 0;
        for (int i11 = 0; i11 < i2; i11++) {
            i10 += iArr[i11];
        }
        return i10;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f5486h <= 0;
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
        q7.k.e(collection, "elements");
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        q7.k.e(collection, "elements");
        boolean z4 = false;
        for (int i2 = this.f5486h - 1; -1 < i2; i2--) {
            if (!d7.r.I0(collection, this.f5485g[i2])) {
                a(i2);
                z4 = true;
            }
        }
        return z4;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f5486h;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return d7.n.c0(this.f5485g, 0, this.f5486h);
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f5486h * 14);
        sb2.append('{');
        int i2 = this.f5486h;
        for (int i10 = 0; i10 < i2; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            Object obj = this.f5485g[i10];
            if (obj != this) {
                sb2.append(obj);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        q7.k.d(string, "toString(...)");
        return string;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        q7.k.e(objArr, "array");
        int i2 = this.f5486h;
        if (objArr.length < i2) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i2);
        } else if (objArr.length > i2) {
            objArr[i2] = null;
        }
        d7.n.Y(this.f5485g, objArr, 0, 0, this.f5486h);
        return objArr;
    }
}
