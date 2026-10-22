package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class Synchronized {

    /* JADX INFO: renamed from: com.google.common.collect.Synchronized$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        private static final long serialVersionUID = 0;
        transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;
        transient Collection<Collection<V>> asMapValues;

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public /* bridge */ /* synthetic */ Object get(Object r1) {
            return get(r1);
        }

        SynchronizedAsMap(Map<K, Collection<V>> r1, @Nullable Object r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<V> get(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Collection r3 = (Collection) super.get(r2);     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            Collection<V> r1 = null;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = Synchronized.access$400(r3, this.mutex);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.asMapEntrySet != null) goto L7;
            this.asMapEntrySet = new SynchronizedAsMapEntries(delegate().entrySet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<Map.Entry<K, Collection<V>>> r4 = this.asMapEntrySet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r4;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<Collection<V>> values() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.asMapValues != null) goto L7;
            this.asMapValues = new SynchronizedAsMapValues(delegate().values(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Collection<Collection<V>> r4 = this.asMapValues;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r4;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public boolean containsValue(Object r1) {
            return values().contains(r1);
        }
    }

    private static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> r1, @Nullable Object r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            final Iterator r0 = super.iterator();
            return new AnonymousClass1(this, r0);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Object[] r1 = ObjectArrays.toArrayImpl(delegate());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            T[] r1 = (T[]) ObjectArrays.toArrayImpl(delegate(), r2);
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = Maps.containsEntryImpl(delegate(), r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = Collections2.containsAllImpl(delegate(), r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, java.util.Collection, java.util.Set
        public boolean equals(Object r2) {
            if (r2 != this) goto L5;
            return true;
        L5:
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = Sets.equalsImpl(delegate(), r2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = Maps.removeEntryImpl(delegate(), r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = Iterators.removeAll(delegate().iterator(), r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = Iterators.retainAll(delegate().iterator(), r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapValues(Collection<Collection<V>> r2, @Nullable Object r3) {
            super(r2, r3, null);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Collection<V>> iterator() {
            final Iterator r0 = super.iterator();
            return new AnonymousClass1(this, r0);
        }
    }

    static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        private transient BiMap<V, K> inverse;
        private transient Set<V> valueSet;

        /* synthetic */ SynchronizedBiMap(BiMap r1, Object r2, BiMap r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        private SynchronizedBiMap(BiMap<K, V> r1, @Nullable Object r2, @Nullable BiMap<V, K> r3) {
            super(r1, r2);
            this.inverse = r3;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        BiMap<K, V> delegate() {
            return (BiMap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<V> values() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.valueSet != null) goto L7;
            this.valueSet = Synchronized.set(delegate().values(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<V> r3 = this.valueSet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(K r2, V r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().forcePut(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.inverse != null) goto L7;
            this.inverse = new SynchronizedBiMap(delegate().inverse(), this.mutex, this);     // Catch: Throwable -> L10
        L7:
            BiMap<V, K> r4 = this.inverse;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r4;
        }
    }

    static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        private static final long serialVersionUID = 0;

        /* synthetic */ SynchronizedCollection(Collection r1, Object r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        private SynchronizedCollection(Collection<E> r1, @Nullable Object r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Collection<E> delegate() {
            return (Collection) super.delegate();
        }

        @Override // java.util.Collection
        public boolean add(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().add(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends E> r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().addAll(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public void clear() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().clear();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean contains(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().contains(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean containsAll(Collection<?> r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().containsAll(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().isEmpty();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public Iterator<E> iterator() {
            return delegate().iterator();
        }

        public boolean remove(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().remove(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean removeAll(Collection<?> r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().removeAll(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean retainAll(Collection<?> r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().retainAll(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public int size() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().size();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public Object[] toArray() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Object[] r1 = delegate().toArray();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public <T> T[] toArray(T[] r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            T[] r1 = (T[]) delegate().toArray(r2);
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Queue delegate() {
            return delegate();
        }

        SynchronizedDeque(Deque<E> r1, @Nullable Object r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        Deque<E> delegate() {
            return (Deque) super.delegate();
        }

        @Override // java.util.Deque
        public void addFirst(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().addFirst(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public void addLast(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().addLast(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean offerFirst(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().offerFirst(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean offerLast(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().offerLast(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E removeFirst() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().removeFirst();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E removeLast() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().removeLast();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E pollFirst() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().pollFirst();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E pollLast() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().pollLast();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E getFirst() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().getFirst();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E getLast() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().getLast();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E peekFirst() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().peekFirst();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E peekLast() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().peekLast();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().removeFirstOccurrence(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().removeLastOccurrence(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public void push(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().push(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E pop() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().pop();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public Iterator<E> descendingIterator() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Iterator<E> r1 = delegate().descendingIterator();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        SynchronizedEntry(Map.Entry<K, V> r1, @Nullable Object r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Map.Entry<K, V> delegate() {
            return (Map.Entry) super.delegate();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().equals(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            K r1 = delegate().getKey();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().getValue();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().setValue(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        SynchronizedList(List<E> r2, @Nullable Object r3) {
            super(r2, r3, null);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        List<E> delegate() {
            return (List) super.delegate();
        }

        @Override // java.util.List
        public void add(int r2, E r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().add(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public boolean addAll(int r2, Collection<? extends E> r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().addAll(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public E get(int r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().get(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public int indexOf(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().indexOf(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public int lastIndexOf(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().lastIndexOf(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return delegate().listIterator();
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int r1) {
            return delegate().listIterator(r1);
        }

        @Override // java.util.List
        public E remove(int r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().remove(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public E set(int r2, E r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().set(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public List<E> subList(int r3, int r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            List<E> r2 = Synchronized.access$200(delegate().subList(r3, r4), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(Object r2) {
            if (r2 != this) goto L5;
            return true;
        L5:
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().equals(r2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Multimap delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
            return removeAll(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r1, Iterable r2) {
            return replaceValues(r1, r2);
        }

        SynchronizedListMultimap(ListMultimap<K, V> r1, @Nullable Object r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        ListMultimap<K, V> delegate() {
            return (ListMultimap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public List<V> get(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            List<V> r2 = Synchronized.access$200(delegate().get(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public List<V> removeAll(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            List<V> r1 = delegate().removeAll(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public List<V> replaceValues(K r2, Iterable<? extends V> r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            List<V> r1 = delegate().replaceValues(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        private static final long serialVersionUID = 0;
        transient Set<Map.Entry<K, V>> entrySet;
        transient Set<K> keySet;
        transient Collection<V> values;

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        SynchronizedMap(Map<K, V> r1, @Nullable Object r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Map<K, V> delegate() {
            return (Map) super.delegate();
        }

        @Override // java.util.Map
        public void clear() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().clear();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public boolean containsKey(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().containsKey(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean containsValue(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().containsValue(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.entrySet != null) goto L7;
            this.entrySet = Synchronized.set(delegate().entrySet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<Map.Entry<K, V>> r3 = this.entrySet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        public V get(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().get(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().isEmpty();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.keySet != null) goto L7;
            this.keySet = Synchronized.set(delegate().keySet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<K> r3 = this.keySet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // java.util.Map
        public V put(K r2, V r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().put(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().putAll(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public V remove(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().remove(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public int size() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().size();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public Collection<V> values() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.values != null) goto L7;
            this.values = Synchronized.access$500(delegate().values(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Collection<V> r3 = this.values;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // java.util.Map
        public boolean equals(Object r2) {
            if (r2 != this) goto L5;
            return true;
        L5:
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().equals(r2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public int hashCode() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedMultimap<K, V> extends SynchronizedObject implements Multimap<K, V> {
        private static final long serialVersionUID = 0;
        transient Map<K, Collection<V>> asMap;
        transient Collection<Map.Entry<K, V>> entries;
        transient Set<K> keySet;
        transient Multiset<K> keys;
        transient Collection<V> valuesCollection;

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Multimap<K, V> delegate() {
            return (Multimap) super.delegate();
        }

        SynchronizedMultimap(Multimap<K, V> r1, @Nullable Object r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().size();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public boolean isEmpty() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().isEmpty();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().containsKey(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsValue(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().containsValue(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsEntry(Object r2, Object r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().containsEntry(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public Collection<V> get(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Collection<V> r2 = Synchronized.access$400(delegate().get(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public boolean put(K r2, V r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().put(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(K r2, Iterable<? extends V> r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().putAll(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().putAll(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public Collection<V> replaceValues(K r2, Iterable<? extends V> r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Collection<V> r1 = delegate().replaceValues(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public boolean remove(Object r2, Object r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().remove(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public Collection<V> removeAll(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Collection<V> r1 = delegate().removeAll(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().clear();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public Set<K> keySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.keySet != null) goto L7;
            this.keySet = Synchronized.access$300(delegate().keySet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<K> r3 = this.keySet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // com.google.common.collect.Multimap
        public Collection<V> values() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.valuesCollection != null) goto L7;
            this.valuesCollection = Synchronized.access$500(delegate().values(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Collection<V> r3 = this.valuesCollection;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // com.google.common.collect.Multimap
        public Collection<Map.Entry<K, V>> entries() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.entries != null) goto L7;
            this.entries = Synchronized.access$400(delegate().entries(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Collection<Map.Entry<K, V>> r3 = this.entries;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Map<K, Collection<V>> asMap() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.asMap != null) goto L7;
            this.asMap = new SynchronizedAsMap(delegate().asMap(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Map<K, Collection<V>> r4 = this.asMap;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r4;
        }

        @Override // com.google.common.collect.Multimap
        public Multiset<K> keys() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.keys != null) goto L7;
            this.keys = Synchronized.multiset(delegate().keys(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Multiset<K> r3 = this.keys;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public boolean equals(Object r2) {
            if (r2 != this) goto L5;
            return true;
        L5:
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().equals(r2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public int hashCode() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements Multiset<E> {
        private static final long serialVersionUID = 0;
        transient Set<E> elementSet;
        transient Set<Multiset.Entry<E>> entrySet;

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        SynchronizedMultiset(Multiset<E> r2, @Nullable Object r3) {
            super(r2, r3, null);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        Multiset<E> delegate() {
            return (Multiset) super.delegate();
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().count(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multiset
        public int add(E r2, int r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().add(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multiset
        public int remove(Object r2, int r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().remove(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multiset
        public int setCount(E r2, int r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().setCount(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multiset
        public boolean setCount(E r2, int r3, int r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().setCount(r2, r3, r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multiset
        public Set<E> elementSet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.elementSet != null) goto L7;
            this.elementSet = Synchronized.access$300(delegate().elementSet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<E> r3 = this.elementSet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // com.google.common.collect.Multiset
        public Set<Multiset.Entry<E>> entrySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.entrySet != null) goto L7;
            this.entrySet = Synchronized.access$300(delegate().entrySet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<Multiset.Entry<E>> r3 = this.entrySet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public boolean equals(Object r2) {
            if (r2 != this) goto L5;
            return true;
        L5:
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().equals(r2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public int hashCode() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private static final long serialVersionUID = 0;
        transient NavigableSet<K> descendingKeySet;
        transient NavigableMap<K, V> descendingMap;
        transient NavigableSet<K> navigableKeySet;

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ SortedMap delegate() {
            return delegate();
        }

        SynchronizedNavigableMap(NavigableMap<K, V> r1, @Nullable Object r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        NavigableMap<K, V> delegate() {
            return (NavigableMap) super.delegate();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.access$700(delegate().ceilingEntry(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            K r1 = delegate().ceilingKey(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableSet<K> r1 = this.descendingKeySet;     // Catch: Throwable -> L11
            if (r1 != null) goto L9;
            NavigableSet<K> r2 = Synchronized.navigableSet(delegate().descendingKeySet(), this.mutex);     // Catch: Throwable -> L11
            this.descendingKeySet = r2;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableMap<K, V> r1 = this.descendingMap;     // Catch: Throwable -> L11
            if (r1 != null) goto L9;
            NavigableMap<K, V> r2 = Synchronized.navigableMap(delegate().descendingMap(), this.mutex);     // Catch: Throwable -> L11
            this.descendingMap = r2;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.access$700(delegate().firstEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.access$700(delegate().floorEntry(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            K r1 = delegate().floorKey(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K r3, boolean r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableMap<K, V> r2 = Synchronized.navigableMap(delegate().headMap(r3, r4), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.access$700(delegate().higherEntry(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            K r1 = delegate().higherKey(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.access$700(delegate().lastEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.access$700(delegate().lowerEntry(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            K r1 = delegate().lowerKey(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableSet<K> r1 = this.navigableKeySet;     // Catch: Throwable -> L11
            if (r1 != null) goto L9;
            NavigableSet<K> r2 = Synchronized.navigableSet(delegate().navigableKeySet(), this.mutex);     // Catch: Throwable -> L11
            this.navigableKeySet = r2;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.access$700(delegate().pollFirstEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.access$700(delegate().pollLastEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K r3, boolean r4, K r5, boolean r6) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableMap<K, V> r2 = Synchronized.navigableMap(delegate().subMap(r3, r4, r5, r6), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K r3, boolean r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableMap<K, V> r2 = Synchronized.navigableMap(delegate().tailMap(r3, r4), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K r2) {
            return headMap(r2, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K r3, K r4) {
            return subMap(r3, true, r4, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K r2) {
            return tailMap(r2, true);
        }
    }

    static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        private static final long serialVersionUID = 0;
        transient NavigableSet<E> descendingSet;

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ SortedSet delegate() {
            return delegate();
        }

        SynchronizedNavigableSet(NavigableSet<E> r1, @Nullable Object r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        NavigableSet<E> delegate() {
            return (NavigableSet) super.delegate();
        }

        @Override // java.util.NavigableSet
        public E ceiling(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().ceiling(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return delegate().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableSet<E> r1 = this.descendingSet;     // Catch: Throwable -> L11
            if (r1 != null) goto L9;
            NavigableSet<E> r2 = Synchronized.navigableSet(delegate().descendingSet(), this.mutex);     // Catch: Throwable -> L11
            this.descendingSet = r2;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public E floor(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().floor(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E r3, boolean r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableSet<E> r2 = Synchronized.navigableSet(delegate().headSet(r3, r4), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public E higher(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().higher(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public E lower(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().lower(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().pollFirst();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().pollLast();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E r3, boolean r4, E r5, boolean r6) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableSet<E> r2 = Synchronized.navigableSet(delegate().subSet(r3, r4, r5, r6), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E r3, boolean r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableSet<E> r2 = Synchronized.navigableSet(delegate().tailSet(r3, r4), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E r2) {
            return headSet(r2, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E r3, E r4) {
            return subSet(r3, true, r4, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E r2) {
            return tailSet(r2, true);
        }
    }

    static class SynchronizedObject implements Serializable {
        private static final long serialVersionUID = 0;
        final Object delegate;
        final Object mutex;

        SynchronizedObject(Object r1, @Nullable Object r2) {
            this.delegate = Preconditions.checkNotNull(r1);
            if (r2 != null) goto L5;
            r2 = this;
        L5:
            this.mutex = r2;
        }

        Object delegate() {
            return this.delegate;
        }

        public String toString() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            String r1 = this.delegate.toString();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        private void writeObject(ObjectOutputStream r1) throws IOException {
            Object r0 = this.mutex;
            monitor-enter(r0);
            r1.defaultWriteObject();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        SynchronizedQueue(Queue<E> r2, @Nullable Object r3) {
            super(r2, r3, null);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        Queue<E> delegate() {
            return (Queue) super.delegate();
        }

        @Override // java.util.Queue
        public E element() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().element();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Queue
        public boolean offer(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().offer(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Queue
        public E peek() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().peek();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Queue
        public E poll() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().poll();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Queue
        public E remove() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().remove();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 0;

        SynchronizedRandomAccessList(List<E> r1, @Nullable Object r2) {
            super(r1, r2);
        }
    }

    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        SynchronizedSet(Set<E> r2, @Nullable Object r3) {
            super(r2, r3, null);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        Set<E> delegate() {
            return (Set) super.delegate();
        }

        public boolean equals(Object r2) {
            if (r2 != this) goto L5;
            return true;
        L5:
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().equals(r2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient Set<Map.Entry<K, V>> entrySet;

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Multimap delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection entries() {
            return entries();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
            return removeAll(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r1, Iterable r2) {
            return replaceValues(r1, r2);
        }

        SynchronizedSetMultimap(SetMultimap<K, V> r1, @Nullable Object r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        SetMultimap<K, V> delegate() {
            return (SetMultimap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<V> get(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Set<V> r2 = Synchronized.set(delegate().get(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<V> removeAll(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Set<V> r1 = delegate().removeAll(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<V> replaceValues(K r2, Iterable<? extends V> r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Set<V> r1 = delegate().replaceValues(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<Map.Entry<K, V>> entries() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.entrySet != null) goto L7;
            this.entrySet = Synchronized.set(delegate().entries(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<Map.Entry<K, V>> r3 = this.entrySet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }
    }

    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        SynchronizedSortedMap(SortedMap<K, V> r1, @Nullable Object r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        SortedMap<K, V> delegate() {
            return (SortedMap) super.delegate();
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Comparator<? super K> r1 = delegate().comparator();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            K r1 = delegate().firstKey();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedMap<K, V> headMap(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedMap<K, V> r2 = Synchronized.sortedMap(delegate().headMap(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            K r1 = delegate().lastKey();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedMap<K, V> subMap(K r3, K r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedMap<K, V> r2 = Synchronized.sortedMap(delegate().subMap(r3, r4), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedMap<K, V> tailMap(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedMap<K, V> r2 = Synchronized.sortedMap(delegate().tailMap(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        SynchronizedSortedSet(SortedSet<E> r1, @Nullable Object r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        SortedSet<E> delegate() {
            return (SortedSet) super.delegate();
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Comparator<? super E> r1 = delegate().comparator();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedSet<E> subSet(E r3, E r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedSet<E> r2 = Synchronized.access$100(delegate().subSet(r3, r4), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedSet<E> headSet(E r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedSet<E> r2 = Synchronized.access$100(delegate().headSet(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedSet<E> tailSet(E r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedSet<E> r2 = Synchronized.access$100(delegate().tailSet(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.SortedSet
        public E first() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().first();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.SortedSet
        public E last() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().last();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Multimap delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ SetMultimap delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object r1) {
            return get(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set get(Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
            return removeAll(r1);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set removeAll(Object r1) {
            return removeAll(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r1, Iterable r2) {
            return replaceValues(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set replaceValues(Object r1, Iterable r2) {
            return replaceValues(r1, r2);
        }

        SynchronizedSortedSetMultimap(SortedSetMultimap<K, V> r1, @Nullable Object r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        SortedSetMultimap<K, V> delegate() {
            return (SortedSetMultimap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public SortedSet<V> get(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedSet<V> r2 = Synchronized.access$100(delegate().get(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public SortedSet<V> removeAll(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedSet<V> r1 = delegate().removeAll(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public SortedSet<V> replaceValues(K r2, Iterable<? extends V> r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedSet<V> r1 = delegate().replaceValues(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator<? super V> valueComparator() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Comparator<? super V> r1 = delegate().valueComparator();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static /* synthetic */ SortedSet access$100(SortedSet r0, Object r1) {
        return sortedSet(r0, r1);
    }

    static /* synthetic */ List access$200(List r0, Object r1) {
        return list(r0, r1);
    }

    static /* synthetic */ Set access$300(Set r0, Object r1) {
        return typePreservingSet(r0, r1);
    }

    static /* synthetic */ Collection access$400(Collection r0, Object r1) {
        return typePreservingCollection(r0, r1);
    }

    static /* synthetic */ Collection access$500(Collection r0, Object r1) {
        return collection(r0, r1);
    }

    static /* synthetic */ Map.Entry access$700(Map.Entry r0, Object r1) {
        return nullableSynchronizedEntry(r0, r1);
    }

    private Synchronized() {
    }

    private static <E> Collection<E> collection(Collection<E> r2, @Nullable Object r3) {
        return new SynchronizedCollection(r2, r3, null);
    }

    static <E> Set<E> set(Set<E> r1, @Nullable Object r2) {
        return new SynchronizedSet(r1, r2);
    }

    private static <E> SortedSet<E> sortedSet(SortedSet<E> r1, @Nullable Object r2) {
        return new SynchronizedSortedSet(r1, r2);
    }

    private static <E> List<E> list(List<E> r1, @Nullable Object r2) {
        if ((r1 instanceof RandomAccess) == false) goto L6;
        return new SynchronizedRandomAccessList(r1, r2);
    L6:
        return new SynchronizedList(r1, r2);
    }

    static <E> Multiset<E> multiset(Multiset<E> r1, @Nullable Object r2) {
        if ((r1 instanceof SynchronizedMultiset) == false) goto L5;
    L9:
        return r1;
    L5:
        if ((r1 instanceof ImmutableMultiset) == true) goto L9;
        return new SynchronizedMultiset(r1, r2);
    }

    static <K, V> Multimap<K, V> multimap(Multimap<K, V> r1, @Nullable Object r2) {
        if ((r1 instanceof SynchronizedMultimap) == false) goto L5;
    L9:
        return r1;
    L5:
        if ((r1 instanceof ImmutableMultimap) == true) goto L9;
        return new SynchronizedMultimap(r1, r2);
    }

    static <K, V> ListMultimap<K, V> listMultimap(ListMultimap<K, V> r1, @Nullable Object r2) {
        if ((r1 instanceof SynchronizedListMultimap) == false) goto L5;
    L9:
        return r1;
    L5:
        if ((r1 instanceof ImmutableListMultimap) == true) goto L9;
        return new SynchronizedListMultimap(r1, r2);
    }

    static <K, V> SetMultimap<K, V> setMultimap(SetMultimap<K, V> r1, @Nullable Object r2) {
        if ((r1 instanceof SynchronizedSetMultimap) == false) goto L5;
    L9:
        return r1;
    L5:
        if ((r1 instanceof ImmutableSetMultimap) == true) goto L9;
        return new SynchronizedSetMultimap(r1, r2);
    }

    static <K, V> SortedSetMultimap<K, V> sortedSetMultimap(SortedSetMultimap<K, V> r1, @Nullable Object r2) {
        if ((r1 instanceof SynchronizedSortedSetMultimap) == false) goto L6;
        return r1;
    L6:
        return new SynchronizedSortedSetMultimap(r1, r2);
    }

    private static <E> Collection<E> typePreservingCollection(Collection<E> r1, @Nullable Object r2) {
        if ((r1 instanceof SortedSet) == false) goto L7;
        return sortedSet((SortedSet) r1, r2);
    L7:
        if ((r1 instanceof Set) == false) goto L11;
        return set((Set) r1, r2);
    L11:
        if ((r1 instanceof List) == false) goto L15;
        return list((List) r1, r2);
    L15:
        return collection(r1, r2);
    }

    private static <E> Set<E> typePreservingSet(Set<E> r1, @Nullable Object r2) {
        if ((r1 instanceof SortedSet) == false) goto L7;
        return sortedSet((SortedSet) r1, r2);
    L7:
        return set(r1, r2);
    }

    static <K, V> Map<K, V> map(Map<K, V> r1, @Nullable Object r2) {
        return new SynchronizedMap(r1, r2);
    }

    static <K, V> SortedMap<K, V> sortedMap(SortedMap<K, V> r1, @Nullable Object r2) {
        return new SynchronizedSortedMap(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> BiMap<K, V> biMap(BiMap<K, V> r2, @Nullable Object r3) {
        if ((r2 instanceof SynchronizedBiMap) == false) goto L5;
    L9:
        return r2;
    L5:
        if ((r2 instanceof ImmutableBiMap) == true) goto L9;
        return new SynchronizedBiMap(r2, r3, null, 0 == true ? 1 : 0);
    }

    static <E> NavigableSet<E> navigableSet(NavigableSet<E> r1, @Nullable Object r2) {
        return new SynchronizedNavigableSet(r1, r2);
    }

    static <E> NavigableSet<E> navigableSet(NavigableSet<E> r1) {
        return navigableSet(r1, null);
    }

    static <K, V> NavigableMap<K, V> navigableMap(NavigableMap<K, V> r1) {
        return navigableMap(r1, null);
    }

    static <K, V> NavigableMap<K, V> navigableMap(NavigableMap<K, V> r1, @Nullable Object r2) {
        return new SynchronizedNavigableMap(r1, r2);
    }

    private static <K, V> Map.Entry<K, V> nullableSynchronizedEntry(@Nullable Map.Entry<K, V> r1, @Nullable Object r2) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new SynchronizedEntry(r1, r2);
    }

    static <E> Queue<E> queue(Queue<E> r1, @Nullable Object r2) {
        if ((r1 instanceof SynchronizedQueue) == false) goto L6;
        return r1;
    L6:
        return new SynchronizedQueue(r1, r2);
    }

    static <E> Deque<E> deque(Deque<E> r1, @Nullable Object r2) {
        return new SynchronizedDeque(r1, r2);
    }
}
