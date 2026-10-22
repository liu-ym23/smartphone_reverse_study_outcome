package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class D extends E {

    /* renamed from: f, reason: collision with root package name */
    private final S f9925f;

    static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: a, reason: collision with root package name */
        private Map.Entry<K, D> f9926a;

        public D a() {
            return this.f9926a.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f9926a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            D value = this.f9926a.getValue();
            if (value == null) {
                return null;
            }
            return value.f();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof S) {
                return this.f9926a.getValue().d((S) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private b(Map.Entry<K, D> entry) {
            this.f9926a = entry;
        }
    }

    static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a, reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f9927a;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f9927a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f9927a.next();
            return next.getValue() instanceof D ? new b(next) : next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9927a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f9927a.remove();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.E
    public boolean equals(Object obj) {
        return f().equals(obj);
    }

    public S f() {
        return c(this.f9925f);
    }

    @Override // androidx.datastore.preferences.protobuf.E
    public int hashCode() {
        return f().hashCode();
    }

    public String toString() {
        return f().toString();
    }
}
