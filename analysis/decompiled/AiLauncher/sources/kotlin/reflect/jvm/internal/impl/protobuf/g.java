package kotlin.reflect.jvm.internal.impl.protobuf;

import ia.C4183c;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes5.dex */
public class g extends C4183c {

    /* renamed from: e, reason: collision with root package name */
    public final h f35883e;

    public static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Map.Entry<K, g> f35884a;

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f35884a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            g value = this.f35884a.getValue();
            if (value == null) {
                return null;
            }
            return value.e();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof h) {
                return this.f35884a.getValue().d((h) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        public b(Map.Entry<K, g> entry) {
            this.f35884a = entry;
        }
    }

    public static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a, reason: collision with root package name */
        public Iterator<Map.Entry<K, Object>> f35885a;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f35885a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f35885a.next();
            return next.getValue() instanceof g ? new b(next) : next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35885a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f35885a.remove();
        }
    }

    public h e() {
        return c(this.f35883e);
    }

    public boolean equals(Object obj) {
        return e().equals(obj);
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return e().toString();
    }
}
