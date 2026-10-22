package com.bytedance.location.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LazyField extends LazyFieldLite {
    private final MessageLite defaultInstance;

    /* JADX INFO: renamed from: com.bytedance.location.protobuf.LazyField$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class LazyEntry<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, LazyField> entry;

        /* synthetic */ LazyEntry(Map.Entry x0, AnonymousClass1 x1) {
            this(x0);
        }

        private LazyEntry(Map.Entry<K, LazyField> entry) {
            this.entry = entry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.entry.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField field = this.entry.getValue();
            if (field != null) goto L7;
            return null;
        L7:
            return field.getValue();
        }

        public LazyField getField() {
            return this.entry.getValue();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object value) {
            if ((value instanceof MessageLite) == false) goto L7;
            return this.entry.getValue().setValue((MessageLite) value);
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

        public LazyIterator(Iterator<Map.Entry<K, Object>> iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            Map.Entry<K, ?> entry = this.iterator.next();
            if ((entry.getValue() instanceof LazyField) == true) goto L5;
            return entry;
        L5:
            return new LazyEntry(entry, null);
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }
    }

    public LazyField(MessageLite defaultInstance, ExtensionRegistryLite extensionRegistry, ByteString bytes) {
        super(extensionRegistry, bytes);
        this.defaultInstance = defaultInstance;
    }

    @Override // com.bytedance.location.protobuf.LazyFieldLite
    public boolean containsDefaultInstance() {
        if (super.containsDefaultInstance() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.value == this.defaultInstance) goto L8;
        return false;
    }

    public MessageLite getValue() {
        return getValue(this.defaultInstance);
    }

    @Override // com.bytedance.location.protobuf.LazyFieldLite
    public int hashCode() {
        return getValue().hashCode();
    }

    @Override // com.bytedance.location.protobuf.LazyFieldLite
    public boolean equals(Object obj) {
        return getValue().equals(obj);
    }

    public String toString() {
        return getValue().toString();
    }
}
