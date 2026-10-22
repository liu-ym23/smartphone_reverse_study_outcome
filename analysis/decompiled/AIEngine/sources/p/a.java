package p;

import androidx.datastore.preferences.protobuf.b1;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a<K, V> extends o<K, V> implements Map<K, V> {

    /* renamed from: d, reason: collision with root package name */
    public a<K, V>.C0124a f11341d;

    /* renamed from: e, reason: collision with root package name */
    public a<K, V>.c f11342e;
    public a<K, V>.e h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: p.a$a, reason: collision with other inner class name */
    public final class C0124a extends AbstractSet<Map.Entry<K, V>> {
        public C0124a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return a.this.f11385c;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class b extends p.c<K> {
        public b() {
            super(a.this.f11385c);
        }

        @Override // p.c
        public final K a(int i10) {
            return a.this.g(i10);
        }

        @Override // p.c
        public final void b(int i10) {
            a.this.h(i10);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public int f11346a;

        /* renamed from: b, reason: collision with root package name */
        public int f11347b = -1;

        /* renamed from: c, reason: collision with root package name */
        public boolean f11348c;

        public d() {
            this.f11346a = a.this.f11385c - 1;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!this.f11348c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            int i10 = this.f11347b;
            a aVar = a.this;
            return kotlin.jvm.internal.g.b(key, aVar.g(i10)) && kotlin.jvm.internal.g.b(entry.getValue(), aVar.j(this.f11347b));
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            if (this.f11348c) {
                return a.this.g(this.f11347b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            if (this.f11348c) {
                return a.this.j(this.f11347b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f11347b < this.f11346a;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            if (!this.f11348c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            int i10 = this.f11347b;
            a aVar = a.this;
            K kG = aVar.g(i10);
            V vJ = aVar.j(this.f11347b);
            return (kG == null ? 0 : kG.hashCode()) ^ (vJ != null ? vJ.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f11347b++;
            this.f11348c = true;
            return this;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.f11348c) {
                throw new IllegalStateException();
            }
            a.this.h(this.f11347b);
            this.f11347b--;
            this.f11346a--;
            this.f11348c = false;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v3) {
            if (this.f11348c) {
                return a.this.i(this.f11347b, v3);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class f extends p.c<V> {
        public f() {
            super(a.this.f11385c);
        }

        @Override // p.c
        public final V a(int i10) {
            return a.this.j(i10);
        }

        @Override // p.c
        public final void b(int i10) {
            a.this.h(i10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(o oVar) {
        super(0);
        if (oVar != null) {
            int i10 = oVar.f11385c;
            b(this.f11385c + i10);
            if (this.f11385c != 0) {
                for (int i11 = 0; i11 < i10; i11++) {
                    put(oVar.g(i11), oVar.j(i11));
                }
            } else if (i10 > 0) {
                b1.o(0, 0, oVar.f11383a, this.f11383a, i10);
                b1.q(oVar.f11384b, this.f11384b, 0, 0, i10 << 1);
                this.f11385c = i10;
            }
        }
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        a<K, V>.C0124a c0124a = this.f11341d;
        if (c0124a != null) {
            return c0124a;
        }
        a<K, V>.C0124a c0124a2 = new C0124a();
        this.f11341d = c0124a2;
        return c0124a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean k(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        a<K, V>.c cVar = this.f11342e;
        if (cVar != null) {
            return cVar;
        }
        a<K, V>.c cVar2 = new c();
        this.f11342e = cVar2;
        return cVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean l(Collection<?> collection) {
        int i10 = this.f11385c;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i10 != this.f11385c;
    }

    public final boolean m(Collection<?> collection) {
        int i10 = this.f11385c;
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (!collection.contains(g(i11))) {
                h(i11);
            }
        }
        return i10 != this.f11385c;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        b(map.size() + this.f11385c);
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        a<K, V>.e eVar = this.h;
        if (eVar != null) {
            return eVar;
        }
        a<K, V>.e eVar2 = new e();
        this.h = eVar2;
        return eVar2;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class c implements Set<K> {
        public c() {
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(K k9) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            a.this.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            return a.this.containsKey(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            return a.this.k(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object obj) {
            a aVar = a.this;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Set)) {
                return false;
            }
            Set set = (Set) obj;
            try {
                if (aVar.f11385c == set.size()) {
                    return aVar.k(set);
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            a aVar = a.this;
            int iHashCode = 0;
            for (int i10 = aVar.f11385c - 1; i10 >= 0; i10--) {
                K kG = aVar.g(i10);
                iHashCode += kG == null ? 0 : kG.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            return a.this.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator<K> iterator() {
            return new b();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            a aVar = a.this;
            int iE = aVar.e(obj);
            if (iE < 0) {
                return false;
            }
            aVar.h(iE);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            return a.this.l(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            return a.this.m(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return a.this.f11385c;
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            a aVar = a.this;
            int i10 = aVar.f11385c;
            Object[] objArr = new Object[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                objArr[i11] = aVar.g(i11);
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            a aVar = a.this;
            int i10 = aVar.f11385c;
            if (tArr.length < i10) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10));
            }
            for (int i11 = 0; i11 < i10; i11++) {
                tArr[i11] = aVar.g(i11);
            }
            if (tArr.length > i10) {
                tArr[i10] = null;
            }
            return tArr;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class e implements Collection<V> {
        public e() {
        }

        @Override // java.util.Collection
        public final boolean add(V v3) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final void clear() {
            a.this.clear();
        }

        @Override // java.util.Collection
        public final boolean contains(Object obj) {
            return a.this.a(obj) >= 0;
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return a.this.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return new f();
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            a aVar = a.this;
            int iA = aVar.a(obj);
            if (iA < 0) {
                return false;
            }
            aVar.h(iA);
            return true;
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            a aVar = a.this;
            int i10 = aVar.f11385c;
            int i11 = 0;
            boolean z = false;
            while (i11 < i10) {
                if (collection.contains(aVar.j(i11))) {
                    aVar.h(i11);
                    i11--;
                    i10--;
                    z = true;
                }
                i11++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            a aVar = a.this;
            int i10 = aVar.f11385c;
            int i11 = 0;
            boolean z = false;
            while (i11 < i10) {
                if (!collection.contains(aVar.j(i11))) {
                    aVar.h(i11);
                    i11--;
                    i10--;
                    z = true;
                }
                i11++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final int size() {
            return a.this.f11385c;
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            a aVar = a.this;
            int i10 = aVar.f11385c;
            Object[] objArr = new Object[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                objArr[i11] = aVar.j(i11);
            }
            return objArr;
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            a aVar = a.this;
            int i10 = aVar.f11385c;
            if (tArr.length < i10) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10));
            }
            for (int i11 = 0; i11 < i10; i11++) {
                tArr[i11] = aVar.j(i11);
            }
            if (tArr.length > i10) {
                tArr[i10] = null;
            }
            return tArr;
        }
    }

    public a() {
    }
}
