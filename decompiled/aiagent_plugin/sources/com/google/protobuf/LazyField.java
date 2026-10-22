package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class LazyField extends LazyFieldLite {
    private final MessageLite defaultInstance;

    /* JADX INFO: renamed from: com.google.protobuf.LazyField$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class LazyEntry<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, LazyField> entry;

        /* synthetic */ LazyEntry(Map.Entry r2, AnonymousClass1 r3) {
            this((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin"));
        }

        private LazyEntry(Map.Entry<K, LazyField> r3) {
            this.entry = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.entry.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField r2 = (LazyField) ZeusTransformUtils.preCheckCast(this.entry.getValue(), LazyField.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L7;
            return null;
        L7:
            return r2.getValue();
        }

        public LazyField getField() {
            return (LazyField) ZeusTransformUtils.preCheckCast(this.entry.getValue(), LazyField.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, MessageLite.class) == false) goto L7;
            return ((LazyField) ZeusTransformUtils.preCheckCast(this.entry.getValue(), LazyField.class, "com.obric.aiagent.plugin")).setValue((MessageLite) ZeusTransformUtils.preCheckCast(r3, MessageLite.class, "com.obric.aiagent.plugin"));
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

        public LazyIterator(Iterator<Map.Entry<K, Object>> r3) {
            this.iterator = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.iterator.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r2.getValue(), LazyField.class) == true) goto L5;
            return r2;
        L5:
            return new LazyEntry(r2, null);
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }
    }

    public LazyField(MessageLite r3, ExtensionRegistryLite r4, ByteString r5) {
        MessageLite r6 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.aiagent.plugin");
        super(r4, r5);
        this.defaultInstance = r6;
    }

    @Override // com.google.protobuf.LazyFieldLite
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

    @Override // com.google.protobuf.LazyFieldLite
    public int hashCode() {
        return getValue().hashCode();
    }

    @Override // com.google.protobuf.LazyFieldLite
    public boolean equals(Object r1) {
        return getValue().equals(r1);
    }

    public String toString() {
        return getValue().toString();
    }
}
