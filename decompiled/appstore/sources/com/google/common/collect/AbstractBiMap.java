package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
abstract class AbstractBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    @MonotonicNonNullDecl
    private transient Map<K, V> delegate;

    @MonotonicNonNullDecl
    private transient Set<Map.Entry<K, V>> entrySet;

    @RetainedWith
    @MonotonicNonNullDecl
    transient AbstractBiMap<V, K> inverse;

    @MonotonicNonNullDecl
    private transient Set<K> keySet;

    @MonotonicNonNullDecl
    private transient Set<V> valueSet;

    public class BiMapEntry extends ForwardingMapEntry<K, V> {
        private final Map.Entry<K, V> delegate;
        final /* synthetic */ AbstractBiMap this$0;

        public BiMapEntry(AbstractBiMap r10, Map.Entry<K, V> r11) {
            this.this$0 = r10;
            this.delegate = r11;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
        public V setValue(V r10) {
            this.this$0.checkValue(r10);
            Preconditions.checkState(this.this$0.entrySet().contains(this), "entry no longer in map");
            if (Objects.equal(r10, getValue()) == false) goto L5;
            return r10;
        L5:
            Preconditions.checkArgument(!this.this$0.containsValue(r10), "value already present: %s", r10);
            V r11 = this.delegate.setValue(r10);
            Preconditions.checkState(Objects.equal(r10, this.this$0.get(getKey())), "entry no longer in map");
            AbstractBiMap.access$500(this.this$0, getKey(), true, r11, r10);
            return r11;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        public Map.Entry<K, V> delegate() {
            return this.delegate;
        }
    }

    public class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
        final Set<Map.Entry<K, V>> esDelegate;
        final /* synthetic */ AbstractBiMap this$0;

        private EntrySet(AbstractBiMap r10) {
            this.this$0 = r10;
            this.esDelegate = AbstractBiMap.access$100(r10).entrySet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            return Maps.containsEntryImpl(delegate(), r10);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r10) {
            return standardContainsAll(r10);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.this$0.entrySetIterator();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            if (this.esDelegate.contains(r10) == true) goto L6;
            return false;
        L6:
            Map.Entry r11 = (Map.Entry) r10;
            AbstractBiMap.access$100(this.this$0.inverse).remove(r11.getValue());
            this.esDelegate.remove(r11);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r10) {
            return standardRemoveAll(r10);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r10) {
            return standardRetainAll(r10);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r10) {
            return (T[]) standardToArray(r10);
        }

        public /* synthetic */ EntrySet(AbstractBiMap r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<Map.Entry<K, V>> delegate() {
            return this.esDelegate;
        }
    }

    public static class Inverse<K, V> extends AbstractBiMap<K, V> {

        @GwtIncompatible
        private static final long serialVersionUID = 0;

        public Inverse(Map<K, V> r10, AbstractBiMap<V, K> r11) {
            super(r10, r11, null);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
            r10.defaultReadObject();
            setInverse((AbstractBiMap) r10.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream r10) throws IOException {
            r10.defaultWriteObject();
            r10.writeObject(inverse());
        }

        @Override // com.google.common.collect.AbstractBiMap
        public K checkKey(K r10) {
            return this.inverse.checkValue(r10);
        }

        @Override // com.google.common.collect.AbstractBiMap
        public V checkValue(V r10) {
            return this.inverse.checkKey(r10);
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return super.delegate();
        }

        @GwtIncompatible
        public Object readResolve() {
            return inverse().inverse();
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    public class KeySet extends ForwardingSet<K> {
        final /* synthetic */ AbstractBiMap this$0;

        private KeySet(AbstractBiMap r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.keyIterator(this.this$0.entrySet().iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            if (contains(r10) == true) goto L6;
            return false;
        L6:
            AbstractBiMap.access$200(this.this$0, r10);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r10) {
            return standardRemoveAll(r10);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r10) {
            return standardRetainAll(r10);
        }

        public /* synthetic */ KeySet(AbstractBiMap r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<K> delegate() {
            return AbstractBiMap.access$100(this.this$0).keySet();
        }
    }

    public class ValueSet extends ForwardingSet<V> {
        final /* synthetic */ AbstractBiMap this$0;
        final Set<V> valuesDelegate;

        private ValueSet(AbstractBiMap r10) {
            this.this$0 = r10;
            this.valuesDelegate = r10.inverse.keySet();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return Maps.valueIterator(this.this$0.entrySet().iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r10) {
            return (T[]) standardToArray(r10);
        }

        public /* synthetic */ ValueSet(AbstractBiMap r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<V> delegate() {
            return this.valuesDelegate;
        }
    }

    public /* synthetic */ AbstractBiMap(Map r10, AbstractBiMap r11, AnonymousClass1 r12) {
        this(r10, r11);
    }

    public static /* synthetic */ Map access$100(AbstractBiMap r10) {
        return r10.delegate;
    }

    public static /* synthetic */ Object access$200(AbstractBiMap r10, Object r11) {
        return r10.removeFromBothMaps(r11);
    }

    public static /* synthetic */ void access$500(AbstractBiMap r10, Object r11, boolean r12, Object r13, Object r14) {
        r10.updateInverseMap(r11, r12, r13, r14);
    }

    public static /* synthetic */ void access$600(AbstractBiMap r10, Object r11) {
        r10.removeFromInverseMap(r11);
    }

    private V putInBothMaps(@NullableDecl K r10, @NullableDecl V r11, boolean r12) {
        checkKey(r10);
        checkValue(r11);
        boolean r13 = containsKey(r10);
        if (r13 == true) goto L5;
    L7:
        if (r12 == false) goto L9;
        inverse().remove(r11);
    L10:
        V r14 = this.delegate.put(r10, r11);
        updateInverseMap(r10, r13, r14, r11);
        return r14;
    L9:
        Preconditions.checkArgument(!containsValue(r11), "value already present: %s", r11);
        goto L10
    L5:
        if (Objects.equal(r11, get(r10)) == false) goto L7;
        return r11;
    }

    @CanIgnoreReturnValue
    private V removeFromBothMaps(Object r10) {
        V r11 = this.delegate.remove(r10);
        removeFromInverseMap(r11);
        return r11;
    }

    private void removeFromInverseMap(V r10) {
        this.inverse.delegate.remove(r10);
    }

    private void updateInverseMap(K r10, boolean r11, V r12, V r13) {
        if (r11 == false) goto L4;
        removeFromInverseMap(r12);
    L4:
        this.inverse.delegate.put(r13, r10);
    }

    @CanIgnoreReturnValue
    public K checkKey(@NullableDecl K r10) {
        return r10;
    }

    @CanIgnoreReturnValue
    public V checkValue(@NullableDecl V r10) {
        return r10;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public boolean containsValue(@NullableDecl Object r10) {
        return this.inverse.containsKey(r10);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r10 = this.entrySet;
        if (r10 != null) goto L6;
        EntrySet r11 = new EntrySet(this, null);
        this.entrySet = r11;
        return r11;
    L6:
        return r10;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        final Iterator<Map.Entry<K, V>> r10 = this.delegate.entrySet().iterator();
        return new AnonymousClass1(this, r10);
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V forcePut(@NullableDecl K r10, @NullableDecl V r11) {
        return putInBothMaps(r10, r11, true);
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        return this.inverse;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<K> keySet() {
        Set<K> r10 = this.keySet;
        if (r10 != null) goto L6;
        KeySet r11 = new KeySet(this, null);
        this.keySet = r11;
        return r11;
    L6:
        return r10;
    }

    public AbstractBiMap<V, K> makeInverse(Map<V, K> r10) {
        return new Inverse(r10, this);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V put(@NullableDecl K r10, @NullableDecl V r11) {
        return putInBothMaps(r10, r11, false);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public void putAll(Map<? extends K, ? extends V> r10) {
        Iterator<Map.Entry<? extends K, ? extends V>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r12 = r11.next();
        put(r12.getKey(), r12.getValue());
        goto L4
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object r10) {
        if (containsKey(r10) == true) goto L7;
        return null;
    L7:
        return removeFromBothMaps(r10);
    }

    public void setDelegates(Map<K, V> r10, Map<V, K> r11) {
        boolean r12 = false;
        if (this.delegate != null) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkState(r13);
        if (this.inverse != null) goto L9;
        boolean r14 = true;
    L10:
        Preconditions.checkState(r14);
        Preconditions.checkArgument(r10.isEmpty());
        Preconditions.checkArgument(r11.isEmpty());
        if (r10 == r11) goto L13;
        r12 = true;
    L13:
        Preconditions.checkArgument(r12);
        this.delegate = r10;
        this.inverse = makeInverse(r11);
        return;
    L9:
        r14 = false;
        goto L10
    L5:
        r13 = false;
        goto L6
    }

    public void setInverse(AbstractBiMap<V, K> r10) {
        this.inverse = r10;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public AbstractBiMap(Map<K, V> r10, Map<V, K> r11) {
        setDelegates(r10, r11);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<K, V> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<V> values() {
        Set<V> r10 = this.valueSet;
        if (r10 != null) goto L6;
        ValueSet r11 = new ValueSet(this, null);
        this.valueSet = r11;
        return r11;
    L6:
        return r10;
    }

    private AbstractBiMap(Map<K, V> r10, AbstractBiMap<V, K> r11) {
        this.delegate = r10;
        this.inverse = r11;
    }
}
