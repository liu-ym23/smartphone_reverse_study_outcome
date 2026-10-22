package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public class F extends AbstractC0483c<String> implements G, RandomAccess {

    /* renamed from: c, reason: collision with root package name */
    private static final F f9933c;

    /* renamed from: d, reason: collision with root package name */
    public static final G f9934d;

    /* renamed from: b, reason: collision with root package name */
    private final List<Object> f9935b;

    static {
        F f5 = new F();
        f9933c = f5;
        f5.b();
        f9934d = f5;
    }

    public F() {
        this(10);
    }

    private static String f(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof AbstractC0488h ? ((AbstractC0488h) obj).B() : A.j((byte[]) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i5, String str) {
        a();
        this.f9935b.add(i5, str);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        a();
        this.f9935b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.G
    public void e(AbstractC0488h abstractC0488h) {
        a();
        this.f9935b.add(abstractC0488h);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // androidx.datastore.preferences.protobuf.G
    public List<?> g() {
        return Collections.unmodifiableList(this.f9935b);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public String get(int i5) {
        Object obj = this.f9935b.get(i5);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC0488h) {
            AbstractC0488h abstractC0488h = (AbstractC0488h) obj;
            String strB = abstractC0488h.B();
            if (abstractC0488h.q()) {
                this.f9935b.set(i5, strB);
            }
            return strB;
        }
        byte[] bArr = (byte[]) obj;
        String strJ = A.j(bArr);
        if (A.g(bArr)) {
            this.f9935b.set(i5, strJ);
        }
        return strJ;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // androidx.datastore.preferences.protobuf.A.i
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public F d(int i5) {
        if (i5 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i5);
        arrayList.addAll(this.f9935b);
        return new F((ArrayList<Object>) arrayList);
    }

    @Override // androidx.datastore.preferences.protobuf.G
    public G j() {
        return l() ? new r0(this) : this;
    }

    @Override // androidx.datastore.preferences.protobuf.G
    public Object k(int i5) {
        return this.f9935b.get(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, androidx.datastore.preferences.protobuf.A.i
    public /* bridge */ /* synthetic */ boolean l() {
        return super.l();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public String remove(int i5) {
        a();
        Object objRemove = this.f9935b.remove(i5);
        ((AbstractList) this).modCount++;
        return f(objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public String set(int i5, String str) {
        a();
        return f(this.f9935b.set(i5, str));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f9935b.size();
    }

    public F(int i5) {
        this((ArrayList<Object>) new ArrayList(i5));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.List
    public boolean addAll(int i5, Collection<? extends String> collection) {
        a();
        if (collection instanceof G) {
            collection = ((G) collection).g();
        }
        boolean zAddAll = this.f9935b.addAll(i5, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    private F(ArrayList<Object> arrayList) {
        this.f9935b = arrayList;
    }
}
