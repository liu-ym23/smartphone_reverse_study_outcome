package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class x extends c<String> implements y, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1898b;

    static {
        new x(10).f1793a = false;
    }

    public x(int i10) {
        this((ArrayList<Object>) new ArrayList(i10));
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public final List<?> C() {
        return Collections.unmodifiableList(this.f1898b);
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public final Object C0(int i10) {
        return this.f1898b.get(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        a();
        this.f1898b.add(i10, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(this.f1898b.size(), collection);
    }

    @Override // androidx.datastore.preferences.protobuf.u.c
    public final u.c c0(int i10) {
        ArrayList arrayList = this.f1898b;
        if (i10 < arrayList.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList2 = new ArrayList(i10);
        arrayList2.addAll(arrayList);
        return new x((ArrayList<Object>) arrayList2);
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        a();
        this.f1898b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public final void g0(ByteString byteString) {
        a();
        this.f1898b.add(byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        ArrayList arrayList = this.f1898b;
        Object obj = arrayList.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String strF = byteString.size() == 0 ? "" : byteString.f(u.f1888a);
            if (byteString.d()) {
                arrayList.set(i10, strF);
            }
            return strF;
        }
        byte[] bArr = (byte[]) obj;
        String str = new String(bArr, u.f1888a);
        if (Utf8.f1765a.c(bArr, 0, bArr.length) == 0) {
            arrayList.set(i10, str);
        }
        return str;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i10) {
        a();
        Object objRemove = this.f1898b.remove(i10);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (!(objRemove instanceof ByteString)) {
            return new String((byte[]) objRemove, u.f1888a);
        }
        ByteString byteString = (ByteString) objRemove;
        return byteString.size() == 0 ? "" : byteString.f(u.f1888a);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        a();
        Object obj2 = this.f1898b.set(i10, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof ByteString)) {
            return new String((byte[]) obj2, u.f1888a);
        }
        ByteString byteString = (ByteString) obj2;
        return byteString.size() == 0 ? "" : byteString.f(u.f1888a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1898b.size();
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public final y x0() {
        return this.f1793a ? new f1(this) : this;
    }

    public x(ArrayList<Object> arrayList) {
        this.f1898b = arrayList;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection<? extends String> collection) {
        a();
        if (collection instanceof y) {
            collection = ((y) collection).C();
        }
        boolean zAddAll = this.f1898b.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }
}
