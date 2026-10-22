package q;

import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import r.C0990a;

/* renamed from: q.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0933a<K, V> extends i<K, V> implements Map<K, V> {

    /* renamed from: d, reason: collision with root package name */
    C0933a<K, V>.C0234a f19610d;

    /* renamed from: e, reason: collision with root package name */
    C0933a<K, V>.c f19611e;

    /* renamed from: f, reason: collision with root package name */
    C0933a<K, V>.e f19612f;

    /* renamed from: q.a$a, reason: collision with other inner class name */
    final class C0234a extends AbstractSet<Map.Entry<K, V>> {
        C0234a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C0933a.this.size();
        }
    }

    /* renamed from: q.a$b */
    final class b extends AbstractC0937e<K> {
        b() {
            super(C0933a.this.size());
        }

        @Override // q.AbstractC0937e
        protected K b(int i5) {
            return C0933a.this.f(i5);
        }

        @Override // q.AbstractC0937e
        protected void c(int i5) {
            C0933a.this.h(i5);
        }
    }

    /* renamed from: q.a$d */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        int f19616a;

        /* renamed from: b, reason: collision with root package name */
        int f19617b = -1;

        /* renamed from: c, reason: collision with root package name */
        boolean f19618c;

        d() {
            this.f19616a = C0933a.this.size() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f19617b++;
            this.f19618c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f19618c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return C0990a.c(entry.getKey(), C0933a.this.f(this.f19617b)) && C0990a.c(entry.getValue(), C0933a.this.j(this.f19617b));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f19618c) {
                return C0933a.this.f(this.f19617b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f19618c) {
                return C0933a.this.j(this.f19617b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19617b < this.f19616a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f19618c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            K kF = C0933a.this.f(this.f19617b);
            V vJ = C0933a.this.j(this.f19617b);
            return (kF == null ? 0 : kF.hashCode()) ^ (vJ != null ? vJ.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f19618c) {
                throw new IllegalStateException();
            }
            C0933a.this.h(this.f19617b);
            this.f19617b--;
            this.f19616a--;
            this.f19618c = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            if (this.f19618c) {
                return C0933a.this.i(this.f19617b, v5);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: q.a$f */
    final class f extends AbstractC0937e<V> {
        f() {
            super(C0933a.this.size());
        }

        @Override // q.AbstractC0937e
        protected V b(int i5) {
            return C0933a.this.j(i5);
        }

        @Override // q.AbstractC0937e
        protected void c(int i5) {
            C0933a.this.h(i5);
        }
    }

    public C0933a() {
    }

    static <T> boolean l(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // q.i, java.util.Map
    public boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // q.i, java.util.Map
    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        C0933a<K, V>.C0234a c0234a = this.f19610d;
        if (c0234a != null) {
            return c0234a;
        }
        C0933a<K, V>.C0234a c0234a2 = new C0234a();
        this.f19610d = c0234a2;
        return c0234a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // q.i, java.util.Map
    public V get(Object obj) {
        return (V) super.get(obj);
    }

    public boolean k(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        C0933a<K, V>.c cVar = this.f19611e;
        if (cVar != null) {
            return cVar;
        }
        C0933a<K, V>.c cVar2 = new c();
        this.f19611e = cVar2;
        return cVar2;
    }

    public boolean m(Collection<?> collection) {
        int size = size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        return size != size();
    }

    public boolean n(Collection<?> collection) {
        int size = size();
        for (int size2 = size() - 1; size2 >= 0; size2--) {
            if (!collection.contains(f(size2))) {
                h(size2);
            }
        }
        return size != size();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        b(size() + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // q.i, java.util.Map
    public V remove(Object obj) {
        return (V) super.remove(obj);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        C0933a<K, V>.e eVar = this.f19612f;
        if (eVar != null) {
            return eVar;
        }
        C0933a<K, V>.e eVar2 = new e();
        this.f19612f = eVar2;
        return eVar2;
    }

    public C0933a(int i5) {
        super(i5);
    }

    /* renamed from: q.a$c */
    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k5) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            C0933a.this.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return C0933a.this.containsKey(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return C0933a.this.k(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return C0933a.l(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int size = C0933a.this.size() - 1; size >= 0; size--) {
                K kF = C0933a.this.f(size);
                iHashCode += kF == null ? 0 : kF.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return C0933a.this.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new b();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iD = C0933a.this.d(obj);
            if (iD < 0) {
                return false;
            }
            C0933a.this.h(iD);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return C0933a.this.m(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return C0933a.this.n(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return C0933a.this.size();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            int size = C0933a.this.size();
            Object[] objArr = new Object[size];
            for (int i5 = 0; i5 < size; i5++) {
                objArr[i5] = C0933a.this.f(i5);
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            for (int i5 = 0; i5 < size; i5++) {
                tArr[i5] = C0933a.this.f(i5);
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }
    }

    /* renamed from: q.a$e */
    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v5) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            C0933a.this.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return C0933a.this.a(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return C0933a.this.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new f();
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iA = C0933a.this.a(obj);
            if (iA < 0) {
                return false;
            }
            C0933a.this.h(iA);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int size = C0933a.this.size();
            int i5 = 0;
            boolean z5 = false;
            while (i5 < size) {
                if (collection.contains(C0933a.this.j(i5))) {
                    C0933a.this.h(i5);
                    i5--;
                    size--;
                    z5 = true;
                }
                i5++;
            }
            return z5;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int size = C0933a.this.size();
            int i5 = 0;
            boolean z5 = false;
            while (i5 < size) {
                if (!collection.contains(C0933a.this.j(i5))) {
                    C0933a.this.h(i5);
                    i5--;
                    size--;
                    z5 = true;
                }
                i5++;
            }
            return z5;
        }

        @Override // java.util.Collection
        public int size() {
            return C0933a.this.size();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            int size = C0933a.this.size();
            Object[] objArr = new Object[size];
            for (int i5 = 0; i5 < size; i5++) {
                objArr[i5] = C0933a.this.j(i5);
            }
            return objArr;
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            for (int i5 = 0; i5 < size; i5++) {
                tArr[i5] = C0933a.this.j(i5);
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }
    }

    public C0933a(i iVar) {
        super(iVar);
    }
}
