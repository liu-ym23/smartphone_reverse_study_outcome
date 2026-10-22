package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1362z extends AbstractC1340c<String> implements A, RandomAccess {

    /* renamed from: c, reason: collision with root package name */
    public static final C1362z f13655c;

    /* renamed from: d, reason: collision with root package name */
    public static final A f13656d;

    /* renamed from: b, reason: collision with root package name */
    public final List<Object> f13657b;

    static {
        C1362z c1362z = new C1362z();
        f13655c = c1362z;
        c1362z.makeImmutable();
        f13656d = c1362z;
    }

    public C1362z() {
        this(10);
    }

    public static String e(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof ByteString ? ((ByteString) obj).H() : C1359w.j((byte[]) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.A
    public void F(ByteString byteString) {
        b();
        this.f13657b.add(byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i10, String str) {
        b();
        this.f13657b.add(i10, str);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        b();
        this.f13657b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public String get(int i10) {
        Object obj = this.f13657b.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String strH = byteString.H();
            if (byteString.n()) {
                this.f13657b.set(i10, strH);
            }
            return strH;
        }
        byte[] bArr = (byte[]) obj;
        String strJ = C1359w.j(bArr);
        if (C1359w.g(bArr)) {
            this.f13657b.set(i10, strJ);
        }
        return strJ;
    }

    @Override // androidx.datastore.preferences.protobuf.A
    public Object getRaw(int i10) {
        return this.f13657b.get(i10);
    }

    @Override // androidx.datastore.preferences.protobuf.A
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.f13657b);
    }

    @Override // androidx.datastore.preferences.protobuf.A
    public A getUnmodifiableView() {
        return isModifiable() ? new i0(this) : this;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // androidx.datastore.preferences.protobuf.C1359w.i
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C1362z mutableCopyWithCapacity(int i10) {
        if (i10 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i10);
        arrayList.addAll(this.f13657b);
        return new C1362z((ArrayList<Object>) arrayList);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, androidx.datastore.preferences.protobuf.C1359w.i
    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public String remove(int i10) {
        b();
        Object objRemove = this.f13657b.remove(i10);
        ((AbstractList) this).modCount++;
        return e(objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public String set(int i10, String str) {
        b();
        return e(this.f13657b.set(i10, str));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f13657b.size();
    }

    public C1362z(int i10) {
        this((ArrayList<Object>) new ArrayList(i10));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection<? extends String> collection) {
        b();
        if (collection instanceof A) {
            collection = ((A) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.f13657b.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public C1362z(ArrayList<Object> arrayList) {
        this.f13657b = arrayList;
    }
}
