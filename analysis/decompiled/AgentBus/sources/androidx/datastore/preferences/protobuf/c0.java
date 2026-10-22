package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class c0 extends b implements d0, RandomAccess {

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f836g;

    static {
        new c0(10).f805f = false;
    }

    public c0(int i2) {
        this(new ArrayList(i2));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        a();
        this.f836g.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.b, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f836g.size(), collection);
    }

    @Override // androidx.datastore.preferences.protobuf.b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        a();
        this.f836g.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public final void d(g gVar) {
        a();
        this.f836g.add(gVar);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        ArrayList arrayList = this.f836g;
        Object obj = arrayList.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof g)) {
            byte[] bArr = (byte[]) obj;
            String str = new String(bArr, y.f968a);
            if (v1.f961a.e(bArr, 0, bArr.length) == 0) {
                arrayList.set(i2, str);
            }
            return str;
        }
        g gVar = (g) obj;
        String str2 = gVar.size() == 0 ? "" : new String(gVar.f853g, gVar.j(), gVar.size(), y.f968a);
        int iJ = gVar.j();
        if (v1.f961a.e(gVar.f853g, iJ, gVar.size() + iJ) == 0) {
            arrayList.set(i2, str2);
        }
        return str2;
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public final Object getRaw(int i2) {
        return this.f836g.get(i2);
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.f836g);
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public final d0 getUnmodifiableView() {
        return this.f805f ? new n1(this) : this;
    }

    @Override // androidx.datastore.preferences.protobuf.x
    public final x mutableCopyWithCapacity(int i2) {
        ArrayList arrayList = this.f836g;
        if (i2 < arrayList.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList2 = new ArrayList(i2);
        arrayList2.addAll(arrayList);
        return new c0(arrayList2);
    }

    @Override // androidx.datastore.preferences.protobuf.b, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        a();
        Object objRemove = this.f836g.remove(i2);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (!(objRemove instanceof g)) {
            return new String((byte[]) objRemove, y.f968a);
        }
        g gVar = (g) objRemove;
        return gVar.size() == 0 ? "" : new String(gVar.f853g, gVar.j(), gVar.size(), y.f968a);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        a();
        Object obj2 = this.f836g.set(i2, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof g)) {
            return new String((byte[]) obj2, y.f968a);
        }
        g gVar = (g) obj2;
        return gVar.size() == 0 ? "" : new String(gVar.f853g, gVar.j(), gVar.size(), y.f968a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f836g.size();
    }

    public c0(ArrayList arrayList) {
        this.f836g = arrayList;
    }

    @Override // androidx.datastore.preferences.protobuf.b, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection collection) {
        a();
        if (collection instanceof d0) {
            collection = ((d0) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.f836g.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }
}
