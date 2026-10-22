package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class LazyField extends LazyFieldLite {
    private final MessageLite defaultInstance;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.LazyField$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class LazyEntry<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, LazyField> entry;

        /* synthetic */ LazyEntry(Map.Entry r1, AnonymousClass1 r2) {
            this(r1);
        }

        private LazyEntry(Map.Entry<K, LazyField> r1) {
            this.entry = r1;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.entry.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField r0 = this.entry.getValue();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getValue();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object r2) {
            if ((r2 instanceof MessageLite) == false) goto L7;
            return this.entry.getValue().setValue((MessageLite) r2);
        L7:
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> iterator;

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        public LazyIterator(Iterator<Map.Entry<K, Object>> r1) {
            this.iterator = r1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> r2 = this.iterator.next();
            if ((r2.getValue() instanceof LazyField) == true) goto L5;
            return r2;
        L5:
            return new LazyEntry(r2, null);
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }
    }

    public MessageLite getValue() {
        return getValue(this.defaultInstance);
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public boolean equals(Object r1) {
        return getValue().equals(r1);
    }

    public String toString() {
        return getValue().toString();
    }
}
