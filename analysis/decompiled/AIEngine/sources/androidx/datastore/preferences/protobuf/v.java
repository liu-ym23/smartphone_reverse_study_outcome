package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class v extends w {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a<K> implements Map.Entry<K, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Map.Entry<K, v> f1894a;

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f1894a.getKey();
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            v value = this.f1894a.getValue();
            if (value == null) {
                return null;
            }
            return value.a(null);
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            if (!(obj instanceof i0)) {
                throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
            }
            v value = this.f1894a.getValue();
            i0 i0Var = value.f1896a;
            value.f1897b = null;
            value.f1896a = (i0) obj;
            return i0Var;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a, reason: collision with root package name */
        public Iterator<Map.Entry<K, Object>> f1895a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f1895a.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            Map.Entry<K, Object> next = this.f1895a.next();
            if (!(next.getValue() instanceof v)) {
                return next;
            }
            a aVar = new a();
            aVar.f1894a = next;
            return aVar;
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.f1895a.remove();
        }
    }

    public final boolean equals(Object obj) {
        return a(null).equals(obj);
    }

    public final int hashCode() {
        return a(null).hashCode();
    }

    public final String toString() {
        return a(null).toString();
    }
}
