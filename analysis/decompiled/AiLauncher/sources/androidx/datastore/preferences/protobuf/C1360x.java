package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1360x extends C1361y {

    /* renamed from: f, reason: collision with root package name */
    public final K f13647f;

    /* renamed from: androidx.datastore.preferences.protobuf.x$b */
    public static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Map.Entry<K, C1360x> f13648a;

        public C1360x a() {
            return this.f13648a.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f13648a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            C1360x value = this.f13648a.getValue();
            if (value == null) {
                return null;
            }
            return value.f();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof K) {
                return this.f13648a.getValue().d((K) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        public b(Map.Entry<K, C1360x> entry) {
            this.f13648a = entry;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.x$c */
    public static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a, reason: collision with root package name */
        public Iterator<Map.Entry<K, Object>> f13649a;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f13649a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f13649a.next();
            return next.getValue() instanceof C1360x ? new b(next) : next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13649a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f13649a.remove();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.C1361y
    public boolean equals(Object obj) {
        return f().equals(obj);
    }

    public K f() {
        return c(this.f13647f);
    }

    @Override // androidx.datastore.preferences.protobuf.C1361y
    public int hashCode() {
        return f().hashCode();
    }

    public String toString() {
        return f().toString();
    }
}
