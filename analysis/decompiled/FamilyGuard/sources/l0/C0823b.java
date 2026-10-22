package l0;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import u0.o;

/* renamed from: l0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0823b extends AbstractC0822a implements List<Object>, Cloneable, RandomAccess, Serializable {

    /* renamed from: k, reason: collision with root package name */
    private final List<Object> f18026k;

    /* renamed from: l, reason: collision with root package name */
    protected transient Object f18027l;

    /* renamed from: m, reason: collision with root package name */
    protected transient Type f18028m;

    public C0823b() {
        this.f18026k = new ArrayList();
    }

    public Type L() {
        return this.f18028m;
    }

    public Integer M(int i5) {
        return o.t(get(i5));
    }

    public Long N(int i5) {
        return o.v(get(i5));
    }

    public Object O() {
        return this.f18027l;
    }

    public void P(Type type) {
        this.f18028m = type;
    }

    public void Q(Object obj) {
        this.f18027l = obj;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        return this.f18026k.add(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<?> collection) {
        return this.f18026k.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f18026k.clear();
    }

    public Object clone() {
        return new C0823b(new ArrayList(this.f18026k));
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f18026k.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.f18026k.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof C0823b ? this.f18026k.equals(((C0823b) obj).f18026k) : this.f18026k.equals(obj);
    }

    @Override // java.util.List
    public Object get(int i5) {
        return this.f18026k.get(i5);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f18026k.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f18026k.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f18026k.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return this.f18026k.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f18026k.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        return this.f18026k.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.f18026k.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.f18026k.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.f18026k.retainAll(collection);
    }

    @Override // java.util.List
    public Object set(int i5, Object obj) {
        if (i5 == -1) {
            this.f18026k.add(obj);
            return null;
        }
        if (this.f18026k.size() > i5) {
            return this.f18026k.set(i5, obj);
        }
        for (int size = this.f18026k.size(); size < i5; size++) {
            this.f18026k.add(null);
        }
        this.f18026k.add(obj);
        return null;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f18026k.size();
    }

    @Override // java.util.List
    public List<Object> subList(int i5, int i6) {
        return this.f18026k.subList(i5, i6);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f18026k.toArray();
    }

    @Override // java.util.List
    public void add(int i5, Object obj) {
        this.f18026k.add(i5, obj);
    }

    @Override // java.util.List
    public boolean addAll(int i5, Collection<? extends Object> collection) {
        return this.f18026k.addAll(i5, collection);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int i5) {
        return this.f18026k.listIterator(i5);
    }

    @Override // java.util.List
    public Object remove(int i5) {
        return this.f18026k.remove(i5);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f18026k.toArray(tArr);
    }

    public C0823b(List<Object> list) {
        if (list != null) {
            this.f18026k = list;
            return;
        }
        throw new IllegalArgumentException("list is null.");
    }

    public C0823b(int i5) {
        this.f18026k = new ArrayList(i5);
    }
}
