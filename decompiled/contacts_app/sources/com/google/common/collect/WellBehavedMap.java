package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class WellBehavedMap<K, V> extends ForwardingMap<K, V> {
    private final Map<K, V> delegate;
    private Set<Map.Entry<K, V>> entrySet;

    /* JADX INFO: renamed from: com.google.common.collect.WellBehavedMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class EntrySet extends Maps.EntrySet<K, V> {
        final /* synthetic */ WellBehavedMap this$0;

        private EntrySet(WellBehavedMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ EntrySet(WellBehavedMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.Maps.EntrySet
        Map<K, V> map() {
            return this.this$0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            final Iterator<K> r1 = this.this$0.keySet().iterator();
            return new AnonymousClass1(this, r1);
        }
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    private WellBehavedMap(Map<K, V> r1) {
        this.delegate = r1;
    }

    static <K, V> WellBehavedMap<K, V> wrap(Map<K, V> r1) {
        return new WellBehavedMap(r1);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected Map<K, V> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r0 = this.entrySet;
        if (r0 == null) goto L5;
        return r0;
    L5:
        EntrySet r1 = new EntrySet(this, null);
        this.entrySet = r1;
        return r1;
    }
}
