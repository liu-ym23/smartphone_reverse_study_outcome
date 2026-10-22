package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u0 extends AbstractList implements RandomAccess, w {

    /* renamed from: h, reason: collision with root package name */
    public static final u0 f1210h = new u0(new Object[0], 0, false);

    /* renamed from: c, reason: collision with root package name */
    public boolean f1211c;

    /* renamed from: f, reason: collision with root package name */
    public Object[] f1212f;

    /* renamed from: g, reason: collision with root package name */
    public int f1213g;

    public u0(Object[] objArr, int i, boolean z10) {
        this.f1211c = z10;
        this.f1212f = objArr;
        this.f1213g = i;
    }

    public final void a(int i) {
        if (i < 0 || i >= this.f1213g) {
            b8.z.i(this.f1213g, k0.a.t(i, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i3;
        b();
        if (i < 0 || i > (i3 = this.f1213g)) {
            b8.z.i(this.f1213g, k0.a.t(i, "Index:", ", Size:"));
            return;
        }
        Object[] objArr = this.f1212f;
        if (i3 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i3 - i);
        } else {
            Object[] objArr2 = new Object[((i3 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.f1212f, i, objArr2, i + 1, this.f1213g - i);
            this.f1212f = objArr2;
        }
        this.f1212f[i] = obj;
        this.f1213g++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        return super.addAll(collection);
    }

    public final void b() {
        if (this.f1211c) {
            return;
        }
        b8.z.c();
    }

    public final u0 c(int i) {
        if (i >= this.f1213g) {
            return new u0(Arrays.copyOf(this.f1212f, i), this.f1213g, true);
        }
        od.f.b();
        return null;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        b();
        super.clear();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        a(i);
        return this.f1212f[i];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        b();
        a(i);
        Object[] objArr = this.f1212f;
        Object obj = objArr[i];
        if (i < this.f1213g - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.f1213g--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        b();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        b();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        b();
        a(i);
        Object[] objArr = this.f1212f;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1213g;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        b();
        return super.addAll(i, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        b();
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b();
        int i = this.f1213g;
        Object[] objArr = this.f1212f;
        if (i == objArr.length) {
            this.f1212f = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f1212f;
        int i3 = this.f1213g;
        this.f1213g = i3 + 1;
        objArr2[i3] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
