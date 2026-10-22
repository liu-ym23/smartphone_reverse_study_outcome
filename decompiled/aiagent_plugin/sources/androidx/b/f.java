package androidx.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: MapCollections.java */
/* JADX INFO: loaded from: classes.dex */
abstract class f<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    f<K, V>.b f540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    f<K, V>.c f541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    f<K, V>.e f542d;

    /* JADX INFO: compiled from: MapCollections.java */
    final class a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f545c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f546d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f547e;

        a(f r2, int r3) {
            this.f547e = r2;
            this.f546d = false;
            this.f543a = r3;
            this.f544b = r2.a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f545c >= this.f544b) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L7;
            T r0 = (T) this.f547e.a(this.f545c, this.f543a);
            this.f545c++;
            this.f546d = true;
            return r0;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f546d == false) goto L7;
            int r0 = this.f545c - 1;
            this.f545c = r0;
            this.f544b--;
            this.f546d = false;
            this.f547e.a(r0);
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: compiled from: MapCollections.java */
    final class b implements Set<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f548a;

        b(f r1) {
            this.f548a = r1;
        }

        @Override // java.util.Set, java.util.Collection
        public /* synthetic */ boolean add(Object r3) {
            return a((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin"));
        }

        public boolean a(Map.Entry<K, V> r2) {
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> r6) {
            Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
            int r0 = this.f548a.a();
            Iterator r8 = r7.iterator();
        L4:
            if (r8.hasNext() == false) goto L7;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            this.f548a.a(r2.getKey(), r2.getValue());
            goto L4
        L7:
            if (r0 == this.f548a.a()) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            this.f548a.c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == true) goto L5;
            return false;
        L5:
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.aiagent.plugin");
            int r0 = this.f548a.a(r5.getKey());
            if (r0 >= 0) goto L9;
            return false;
        L9:
            return androidx.b.c.a(this.f548a.a(r0, 1), r5.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> r3) {
            Iterator r4 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r4.hasNext() == false) goto L9;
            if (contains(r4.next()) == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            if (this.f548a.a() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(this.f548a);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return this.f548a.a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object r1) {
            return f.a(this, r1);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int r0 = this.f548a.a() - 1;
            int r3 = 0;
        L3:
            if (r0 < 0) goto L12;
            Object r4 = this.f548a.a(r0, 0);
            Object r5 = this.f548a.a(r0, 1);
            if (r4 != null) goto L7;
            int r6 = 0;
        L8:
            if (r5 != null) goto L10;
            int r7 = 0;
        L11:
            r3 = r3 + (r6 ^ r7);
            r0 = r0 - 1;
            goto L3
        L10:
            r7 = r5.hashCode();
            goto L11
        L7:
            r6 = r4.hashCode();
            goto L8
        L12:
            return r3;
        }
    }

    /* JADX INFO: compiled from: MapCollections.java */
    final class c implements Set<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f549a;

        c(f r1) {
            this.f549a = r1;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            this.f549a.c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object r1) {
            if (this.f549a.a(r1) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
            return f.a(this.f549a.b(), r4);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            if (this.f549a.a() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(this.f549a, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object r2) {
            int r3 = this.f549a.a(r2);
            if (r3 < 0) goto L6;
            this.f549a.a(r3);
            return true;
        L6:
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
            return f.b(this.f549a.b(), r4);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
            return f.c(this.f549a.b(), r4);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return this.f549a.a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return this.f549a.b(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] r2) {
            return (T[]) this.f549a.a(r2, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object r1) {
            return f.a(this, r1);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int r0 = this.f549a.a() - 1;
            int r2 = 0;
        L3:
            if (r0 < 0) goto L9;
            Object r3 = this.f549a.a(r0, 0);
            if (r3 != null) goto L7;
            int r4 = 0;
        L8:
            r2 = r2 + r4;
            r0 = r0 - 1;
            goto L3
        L7:
            r4 = r3.hashCode();
            goto L8
        L9:
            return r2;
        }
    }

    /* JADX INFO: compiled from: MapCollections.java */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f552c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f553d;

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            return a();
        }

        d(f r2) {
            this.f553d = r2;
            this.f552c = false;
            this.f550a = r2.a() - 1;
            this.f551b = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f551b >= this.f550a) goto L5;
            return true;
        L5:
            return false;
        }

        public Map.Entry<K, V> a() {
            if (hasNext() == false) goto L7;
            this.f551b++;
            this.f552c = true;
            return this;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f552c == false) goto L7;
            this.f553d.a(this.f551b);
            this.f551b--;
            this.f550a--;
            this.f552c = false;
            return;
        L7:
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f552c == false) goto L7;
            return (K) this.f553d.a(this.f551b, 0);
        L7:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f552c == false) goto L7;
            return (V) this.f553d.a(this.f551b, 1);
        L7:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V setValue(V r2) {
            if (this.f552c == false) goto L7;
            return (V) this.f553d.a(this.f551b, r2);
        L7:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if (this.f552c == false) goto L14;
            if (ZeusTransformUtils.instanceOf(r5, Map.Entry.class) == true) goto L7;
            return false;
        L7:
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.aiagent.plugin");
            if (androidx.b.c.a(r6.getKey(), this.f553d.a(this.f551b, 0)) == true) goto L10;
            return false;
        L10:
            if (androidx.b.c.a(r6.getValue(), this.f553d.a(this.f551b, 1)) == true) goto L12;
            return false;
        L12:
            return true;
        L14:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (this.f552c == false) goto L14;
            int r2 = 0;
            Object r0 = this.f553d.a(this.f551b, 0);
            Object r4 = this.f553d.a(this.f551b, 1);
            if (r0 != null) goto L7;
            int r1 = 0;
        L8:
            if (r4 == null) goto L12;
            r2 = r4.hashCode();
        L12:
            return r1 ^ r2;
        L7:
            r1 = r0.hashCode();
            goto L8
        L14:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX INFO: compiled from: MapCollections.java */
    final class e implements Collection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f554a;

        e(f r1) {
            this.f554a = r1;
        }

        @Override // java.util.Collection
        public boolean add(V r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f554a.c();
        }

        @Override // java.util.Collection
        public boolean contains(Object r1) {
            if (this.f554a.b(r1) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> r3) {
            Iterator r4 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r4.hasNext() == false) goto L9;
            if (contains(r4.next()) == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            if (this.f554a.a() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(this.f554a, 1);
        }

        @Override // java.util.Collection
        public boolean remove(Object r2) {
            int r3 = this.f554a.b(r2);
            if (r3 < 0) goto L6;
            this.f554a.a(r3);
            return true;
        L6:
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> r6) {
            Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
            int r0 = this.f554a.a();
            int r1 = 0;
            boolean r2 = false;
        L3:
            if (r1 >= r0) goto L8;
            if (r7.contains(this.f554a.a(r1, 1)) == false) goto L7;
            this.f554a.a(r1);
            r1 = r1 - 1;
            r0 = r0 - 1;
            r2 = true;
        L7:
            r1 = r1 + 1;
            goto L3
        L8:
            return r2;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> r6) {
            Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
            int r0 = this.f554a.a();
            int r1 = 0;
            boolean r2 = false;
        L3:
            if (r1 >= r0) goto L8;
            if (r7.contains(this.f554a.a(r1, 1)) == true) goto L7;
            this.f554a.a(r1);
            r1 = r1 - 1;
            r0 = r0 - 1;
            r2 = true;
        L7:
            r1 = r1 + 1;
            goto L3
        L8:
            return r2;
        }

        @Override // java.util.Collection
        public int size() {
            return this.f554a.a();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return this.f554a.b(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] r2) {
            return (T[]) this.f554a.a(r2, 1);
        }
    }

    public abstract int a();

    public abstract int a(Object r1);

    public abstract Object a(int r1, int r2);

    public abstract V a(int r1, V r2);

    public abstract void a(int r1);

    public abstract void a(K r1, V r2);

    public abstract int b(Object r1);

    public abstract Map<K, V> b();

    public abstract void c();

    f() {
    }

    public static <K, V> boolean a(Map<K, V> r2, Collection<?> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        Iterator r5 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        if (r4.containsKey(r5.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static <K, V> boolean b(Map<K, V> r2, Collection<?> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        int r0 = r4.size();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        r4.remove(r6.next());
        goto L4
    L7:
        if (r0 == r4.size()) goto L9;
        return true;
    L9:
        return false;
    }

    public static <K, V> boolean c(Map<K, V> r3, Collection<?> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        int r0 = r5.size();
        Iterator<K> r1 = r5.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r6.contains(r1.next()) == true) goto L4;
        r1.remove();
        goto L4
    L9:
        if (r0 == r5.size()) goto L11;
        return true;
    L11:
        return false;
    }

    public Object[] b(int r5) {
        int r0 = a();
        Object[] r1 = new Object[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = a(r2, r5);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public <T> T[] a(T[] r4, int r5) {
        int r0 = a();
        if (r4.length >= r0) goto L5;
        r4 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r4.getClass().getComponentType(), r0), Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin"));
    L5:
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L9;
        T[] r6 = r4;
        r6[r1] = a(r1, r5);
        r1 = r1 + 1;
        goto L6
    L9:
        if (r4.length <= r0) goto L11;
        r4[r0] = null;
    L11:
        return r4;
    }

    public static <T> boolean a(Set<T> r4, Object r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        if (r6 != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Set.class) == false) goto L15;
        Set r7 = (Set) ZeusTransformUtils.preCheckCast(r5, Set.class, "com.obric.aiagent.plugin");
        if (r6.size() != r7.size()) goto L14;
        if (r6.containsAll(r7) == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public Set<Map.Entry<K, V>> d() {
        if (this.f540b != null) goto L6;
        this.f540b = new b(this);
    L6:
        return this.f540b;
    }

    public Set<K> e() {
        if (this.f541c != null) goto L6;
        this.f541c = new c(this);
    L6:
        return this.f541c;
    }

    public Collection<V> f() {
        if (this.f542d != null) goto L6;
        this.f542d = new e(this);
    L6:
        return this.f542d;
    }
}
