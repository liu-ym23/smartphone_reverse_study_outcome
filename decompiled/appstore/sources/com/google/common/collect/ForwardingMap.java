package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {

    @Beta
    public abstract class StandardEntrySet extends Maps.EntrySet<K, V> {
        final /* synthetic */ ForwardingMap this$0;

        public StandardEntrySet(ForwardingMap r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.collect.Maps.EntrySet
        public Map<K, V> map() {
            return this.this$0;
        }
    }

    @Beta
    public class StandardKeySet extends Maps.KeySet<K, V> {
        final /* synthetic */ ForwardingMap this$0;

        public StandardKeySet(ForwardingMap r10) {
            this.this$0 = r10;
            super(r10);
        }
    }

    @Beta
    public class StandardValues extends Maps.Values<K, V> {
        final /* synthetic */ ForwardingMap this$0;

        public StandardValues(ForwardingMap r10) {
            this.this$0 = r10;
            super(r10);
        }
    }

    public ForwardingMap() {
    }

    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object r10) {
        return delegate().containsKey(r10);
    }

    public boolean containsValue(@NullableDecl Object r10) {
        return delegate().containsValue(r10);
    }

    @Override // com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingObject
    public abstract Map<K, V> delegate();

    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r10) == true) goto L7;
        return false;
    }

    @Override // java.util.Map
    public V get(@NullableDecl Object r10) {
        return delegate().get(r10);
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    @CanIgnoreReturnValue
    public V put(K r10, V r11) {
        return delegate().put(r10, r11);
    }

    public void putAll(Map<? extends K, ? extends V> r10) {
        delegate().putAll(r10);
    }

    @CanIgnoreReturnValue
    public V remove(Object r10) {
        return delegate().remove(r10);
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    public void standardClear() {
        Iterators.clear(entrySet().iterator());
    }

    @Beta
    public boolean standardContainsKey(@NullableDecl Object r10) {
        return Maps.containsKeyImpl(this, r10);
    }

    public boolean standardContainsValue(@NullableDecl Object r10) {
        return Maps.containsValueImpl(this, r10);
    }

    public boolean standardEquals(@NullableDecl Object r10) {
        return Maps.equalsImpl(this, r10);
    }

    public int standardHashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    public void standardPutAll(Map<? extends K, ? extends V> r10) {
        Maps.putAllImpl(this, r10);
    }

    @Beta
    public V standardRemove(@NullableDecl Object r10) {
        Iterator<Map.Entry<K, V>> r11 = entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<K, V> r12 = r11.next();
        if (Objects.equal(r12.getKey(), r10) == false) goto L4;
        V r13 = r12.getValue();
        r11.remove();
        return r13;
    L9:
        return null;
    }

    public String standardToString() {
        return Maps.toStringImpl(this);
    }

    public Collection<V> values() {
        return delegate().values();
    }
}
