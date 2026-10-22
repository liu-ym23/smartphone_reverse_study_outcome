package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.j2objc.annotations.RetainedWith;
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
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
final class Synchronized {

    /* JADX INFO: renamed from: com.google.common.collect.Synchronized$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;

        @MonotonicNonNullDecl
        transient Collection<Collection<V>> asMapValues;

        public SynchronizedAsMap(Map<K, Collection<V>> r10, @NullableDecl Object r11) {
            super(r10, r11);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public boolean containsValue(Object r10) {
            return values().contains(r10);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Object r10 = this.mutex;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.asMapEntrySet != null) goto L9;
            this.asMapEntrySet = new SynchronizedAsMapEntries(delegate().entrySet(), this.mutex);     // Catch: Throwable -> L7
        L9:
            Set<Map.Entry<K, Collection<V>>> r11 = this.asMapEntrySet;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<Collection<V>> values() {
            Object r10 = this.mutex;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.asMapValues != null) goto L9;
            this.asMapValues = new SynchronizedAsMapValues(delegate().values(), this.mutex);     // Catch: Throwable -> L7
        L9:
            Collection<Collection<V>> r11 = this.asMapValues;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<V> get(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            Collection r12 = (Collection) super.get(r10);     // Catch: Throwable -> L10
            if (r12 != null) goto L7;
            Collection<V> r13 = null;
        L8:
            monitor-exit(r11);     // Catch: Throwable -> L10
            return r13;
        L7:
            r13 = Synchronized.access$400(r12, this.mutex);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }
    }

    public static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        private static final long serialVersionUID = 0;

        public SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> r10, @NullableDecl Object r11) {
            super(r10, r11);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = Maps.containsEntryImpl(delegate(), r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = Collections2.containsAllImpl(delegate(), r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, java.util.Collection, java.util.Set
        public boolean equals(Object r10) {
            if (r10 != this) goto L5;
            return true;
        L5:
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = Sets.equalsImpl(delegate(), r10);     // Catch: Throwable -> L10
            monitor-exit(r11);     // Catch: Throwable -> L10
            return r12;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            final Iterator r10 = super.iterator();
            return new AnonymousClass1(this, r10);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = Maps.removeEntryImpl(delegate(), r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = Iterators.removeAll(delegate().iterator(), r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = Iterators.retainAll(delegate().iterator(), r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Object[] r11 = ObjectArrays.toArrayImpl(delegate());     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            T[] r12 = (T[]) ObjectArrays.toArrayImpl(delegate(), r10);
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        private static final long serialVersionUID = 0;

        public SynchronizedAsMapValues(Collection<Collection<V>> r10, @NullableDecl Object r11) {
            super(r10, r11, null);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Collection<V>> iterator() {
            final Iterator r10 = super.iterator();
            return new AnonymousClass1(this, r10);
        }
    }

    @VisibleForTesting
    public static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        @RetainedWith
        @MonotonicNonNullDecl
        private transient BiMap<V, K> inverse;

        @MonotonicNonNullDecl
        private transient Set<V> valueSet;

        public /* synthetic */ SynchronizedBiMap(BiMap r10, Object r11, BiMap r12, AnonymousClass1 r13) {
            this(r10, r11, r12);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(K r10, V r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            V r13 = delegate().forcePut(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            Object r10 = this.mutex;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.inverse != null) goto L9;
            this.inverse = new SynchronizedBiMap(delegate().inverse(), this.mutex, this);     // Catch: Throwable -> L7
        L9:
            BiMap<V, K> r11 = this.inverse;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        private SynchronizedBiMap(BiMap<K, V> r10, @NullableDecl Object r11, @NullableDecl BiMap<V, K> r12) {
            super(r10, r11);
            this.inverse = r12;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<V> values() {
            Object r10 = this.mutex;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.valueSet != null) goto L9;
            this.valueSet = Synchronized.set(delegate().values(), this.mutex);     // Catch: Throwable -> L7
        L9:
            Set<V> r11 = this.valueSet;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public BiMap<K, V> delegate() {
            return (BiMap) super.delegate();
        }
    }

    @VisibleForTesting
    public static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        private static final long serialVersionUID = 0;

        public /* synthetic */ SynchronizedCollection(Collection r10, Object r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @Override // java.util.Collection
        public boolean add(E r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().add(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends E> r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().addAll(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public void clear() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            delegate().clear();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean contains(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().contains(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean containsAll(Collection<?> r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().containsAll(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            boolean r11 = delegate().isEmpty();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        public Iterator<E> iterator() {
            return delegate().iterator();
        }

        public boolean remove(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().remove(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean removeAll(Collection<?> r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().removeAll(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean retainAll(Collection<?> r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().retainAll(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public int size() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            int r11 = delegate().size();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        public Object[] toArray() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Object[] r11 = delegate().toArray();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        private SynchronizedCollection(Collection<E> r10, @NullableDecl Object r11) {
            super(r10, r11);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Collection<E> delegate() {
            return (Collection) super.delegate();
        }

        public <T> T[] toArray(T[] r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            T[] r12 = (T[]) delegate().toArray(r10);
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedDeque(Deque<E> r10, @NullableDecl Object r11) {
            super(r10, r11);
        }

        @Override // java.util.Deque
        public void addFirst(E r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            delegate().addFirst(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public void addLast(E r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            delegate().addLast(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.Deque
        public Iterator<E> descendingIterator() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Iterator<E> r11 = delegate().descendingIterator();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E getFirst() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().getFirst();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E getLast() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().getLast();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean offerFirst(E r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().offerFirst(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean offerLast(E r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().offerLast(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E peekFirst() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().peekFirst();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E peekLast() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().peekLast();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E pollFirst() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().pollFirst();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E pollLast() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().pollLast();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E pop() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().pop();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public void push(E r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            delegate().push(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E removeFirst() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().removeFirst();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().removeFirstOccurrence(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E removeLast() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().removeLast();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().removeLastOccurrence(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Queue delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Deque<E> delegate() {
            return (Deque) super.delegate();
        }
    }

    @GwtIncompatible
    public static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedEntry(Map.Entry<K, V> r10, @NullableDecl Object r11) {
            super(r10, r11);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().equals(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            K r11 = delegate().getKey();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            V r11 = delegate().getValue();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            int r11 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            V r12 = delegate().setValue(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map.Entry<K, V> delegate() {
            return (Map.Entry) super.delegate();
        }
    }

    public static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedList(List<E> r10, @NullableDecl Object r11) {
            super(r10, r11, null);
        }

        @Override // java.util.List
        public void add(int r10, E r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            delegate().add(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public boolean addAll(int r10, Collection<? extends E> r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            boolean r13 = delegate().addAll(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(Object r10) {
            if (r10 != this) goto L5;
            return true;
        L5:
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().equals(r10);     // Catch: Throwable -> L10
            monitor-exit(r11);     // Catch: Throwable -> L10
            return r12;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public E get(int r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            E r12 = delegate().get(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            int r11 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public int indexOf(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            int r12 = delegate().indexOf(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public int lastIndexOf(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            int r12 = delegate().lastIndexOf(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return delegate().listIterator();
        }

        @Override // java.util.List
        public E remove(int r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            E r12 = delegate().remove(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public E set(int r10, E r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            E r13 = delegate().set(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public List<E> subList(int r10, int r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            List<E> r13 = Synchronized.access$200(delegate().subList(r10, r11), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int r10) {
            return delegate().listIterator(r10);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public List<E> delegate() {
            return (List) super.delegate();
        }
    }

    public static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedListMultimap(ListMultimap<K, V> r10, @NullableDecl Object r11) {
            super(r10, r11);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Multimap delegate() {
            return delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection removeAll(Object r10) {
            return removeAll(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r10, Iterable r11) {
            return replaceValues(r10, r11);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public List<V> get(K r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            List<V> r12 = Synchronized.access$200(delegate().get(r10), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public List<V> removeAll(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            List<V> r12 = delegate().removeAll(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public List<V> replaceValues(K r10, Iterable<? extends V> r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            List<V> r13 = delegate().replaceValues(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public ListMultimap<K, V> delegate() {
            return (ListMultimap) super.delegate();
        }
    }

    public static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient Set<Map.Entry<K, V>> entrySet;

        @MonotonicNonNullDecl
        transient Set<K> keySet;

        @MonotonicNonNullDecl
        transient Collection<V> values;

        public SynchronizedMap(Map<K, V> r10, @NullableDecl Object r11) {
            super(r10, r11);
        }

        @Override // java.util.Map
        public void clear() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            delegate().clear();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public boolean containsKey(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().containsKey(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean containsValue(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().containsValue(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Object r10 = this.mutex;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.entrySet != null) goto L9;
            this.entrySet = Synchronized.set(delegate().entrySet(), this.mutex);     // Catch: Throwable -> L7
        L9:
            Set<Map.Entry<K, V>> r11 = this.entrySet;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        }

        @Override // java.util.Map
        public boolean equals(Object r10) {
            if (r10 != this) goto L5;
            return true;
        L5:
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().equals(r10);     // Catch: Throwable -> L10
            monitor-exit(r11);     // Catch: Throwable -> L10
            return r12;
        L10:
            th = move-exception;
            throw th;
        }

        public V get(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            V r12 = delegate().get(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public int hashCode() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            int r11 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            boolean r11 = delegate().isEmpty();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            Object r10 = this.mutex;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.keySet != null) goto L9;
            this.keySet = Synchronized.set(delegate().keySet(), this.mutex);     // Catch: Throwable -> L7
        L9:
            Set<K> r11 = this.keySet;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        }

        @Override // java.util.Map
        public V put(K r10, V r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            V r13 = delegate().put(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            delegate().putAll(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public V remove(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            V r12 = delegate().remove(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public int size() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            int r11 = delegate().size();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        public Collection<V> values() {
            Object r10 = this.mutex;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.values != null) goto L9;
            this.values = Synchronized.access$500(delegate().values(), this.mutex);     // Catch: Throwable -> L7
        L9:
            Collection<V> r11 = this.values;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map<K, V> delegate() {
            return (Map) super.delegate();
        }
    }

    public static class SynchronizedMultimap<K, V> extends SynchronizedObject implements Multimap<K, V> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient Map<K, Collection<V>> asMap;

        @MonotonicNonNullDecl
        transient Collection<Map.Entry<K, V>> entries;

        @MonotonicNonNullDecl
        transient Set<K> keySet;

        @MonotonicNonNullDecl
        transient Multiset<K> keys;

        @MonotonicNonNullDecl
        transient Collection<V> valuesCollection;

        public SynchronizedMultimap(Multimap<K, V> r10, @NullableDecl Object r11) {
            super(r10, r11);
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Map<K, Collection<V>> asMap() {
            Object r10 = this.mutex;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.asMap != null) goto L9;
            this.asMap = new SynchronizedAsMap(delegate().asMap(), this.mutex);     // Catch: Throwable -> L7
        L9:
            Map<K, Collection<V>> r11 = this.asMap;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            delegate().clear();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsEntry(Object r10, Object r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            boolean r13 = delegate().containsEntry(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().containsKey(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsValue(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().containsValue(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multimap
        public Collection<Map.Entry<K, V>> entries() {
            Object r10 = this.mutex;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.entries != null) goto L9;
            this.entries = Synchronized.access$400(delegate().entries(), this.mutex);     // Catch: Throwable -> L7
        L9:
            Collection<Map.Entry<K, V>> r11 = this.entries;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public boolean equals(Object r10) {
            if (r10 != this) goto L5;
            return true;
        L5:
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().equals(r10);     // Catch: Throwable -> L10
            monitor-exit(r11);     // Catch: Throwable -> L10
            return r12;
        L10:
            th = move-exception;
            throw th;
        }

        public Collection<V> get(K r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            Collection<V> r12 = Synchronized.access$400(delegate().get(r10), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public int hashCode() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            int r11 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public boolean isEmpty() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            boolean r11 = delegate().isEmpty();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public Set<K> keySet() {
            Object r10 = this.mutex;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.keySet != null) goto L9;
            this.keySet = Synchronized.access$300(delegate().keySet(), this.mutex);     // Catch: Throwable -> L7
        L9:
            Set<K> r11 = this.keySet;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        }

        @Override // com.google.common.collect.Multimap
        public Multiset<K> keys() {
            Object r10 = this.mutex;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.keys != null) goto L9;
            this.keys = Synchronized.multiset(delegate().keys(), this.mutex);     // Catch: Throwable -> L7
        L9:
            Multiset<K> r11 = this.keys;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        }

        @Override // com.google.common.collect.Multimap
        public boolean put(K r10, V r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            boolean r13 = delegate().put(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(K r10, Iterable<? extends V> r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            boolean r13 = delegate().putAll(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public boolean remove(Object r10, Object r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            boolean r13 = delegate().remove(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        public Collection<V> removeAll(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            Collection<V> r12 = delegate().removeAll(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        public Collection<V> replaceValues(K r10, Iterable<? extends V> r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            Collection<V> r13 = delegate().replaceValues(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            int r11 = delegate().size();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multimap
        public Collection<V> values() {
            Object r10 = this.mutex;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.valuesCollection != null) goto L9;
            this.valuesCollection = Synchronized.access$500(delegate().values(), this.mutex);     // Catch: Throwable -> L7
        L9:
            Collection<V> r11 = this.valuesCollection;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Multimap<K, V> delegate() {
            return (Multimap) super.delegate();
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().putAll(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements Multiset<E> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient Set<E> elementSet;

        @MonotonicNonNullDecl
        transient Set<Multiset.Entry<E>> entrySet;

        public SynchronizedMultiset(Multiset<E> r10, @NullableDecl Object r11) {
            super(r10, r11, null);
        }

        @Override // com.google.common.collect.Multiset
        public int add(E r10, int r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            int r13 = delegate().add(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            int r12 = delegate().count(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Multiset
        public Set<E> elementSet() {
            Object r10 = this.mutex;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.elementSet != null) goto L9;
            this.elementSet = Synchronized.access$300(delegate().elementSet(), this.mutex);     // Catch: Throwable -> L7
        L9:
            Set<E> r11 = this.elementSet;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        }

        @Override // com.google.common.collect.Multiset
        public Set<Multiset.Entry<E>> entrySet() {
            Object r10 = this.mutex;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.entrySet != null) goto L9;
            this.entrySet = Synchronized.access$300(delegate().entrySet(), this.mutex);     // Catch: Throwable -> L7
        L9:
            Set<Multiset.Entry<E>> r11 = this.entrySet;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public boolean equals(Object r10) {
            if (r10 != this) goto L5;
            return true;
        L5:
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().equals(r10);     // Catch: Throwable -> L10
            monitor-exit(r11);     // Catch: Throwable -> L10
            return r12;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public int hashCode() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            int r11 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multiset
        public int remove(Object r10, int r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            int r13 = delegate().remove(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Multiset
        public int setCount(E r10, int r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            int r13 = delegate().setCount(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Multiset<E> delegate() {
            return (Multiset) super.delegate();
        }

        @Override // com.google.common.collect.Multiset
        public boolean setCount(E r10, int r11, int r12) {
            Object r13 = this.mutex;
            monitor-enter(r13);
            boolean r14 = delegate().setCount(r10, r11, r12);     // Catch: Throwable -> L7
            monitor-exit(r13);     // Catch: Throwable -> L7
            return r14;
        L7:
            th = move-exception;
            throw th;
        }
    }

    @GwtIncompatible
    @VisibleForTesting
    public static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient NavigableSet<K> descendingKeySet;

        @MonotonicNonNullDecl
        transient NavigableMap<K, V> descendingMap;

        @MonotonicNonNullDecl
        transient NavigableSet<K> navigableKeySet;

        public SynchronizedNavigableMap(NavigableMap<K, V> r10, @NullableDecl Object r11) {
            super(r10, r11);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            Map.Entry<K, V> r12 = Synchronized.access$700(delegate().ceilingEntry(r10), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            K r12 = delegate().ceilingKey(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            NavigableSet<K> r11 = this.descendingKeySet;     // Catch: Throwable -> L9
            if (r11 != null) goto L11;
            NavigableSet<K> r12 = Synchronized.navigableSet(delegate().descendingKeySet(), this.mutex);     // Catch: Throwable -> L9
            this.descendingKeySet = r12;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return r12;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return r11;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            NavigableMap<K, V> r11 = this.descendingMap;     // Catch: Throwable -> L9
            if (r11 != null) goto L11;
            NavigableMap<K, V> r12 = Synchronized.navigableMap(delegate().descendingMap(), this.mutex);     // Catch: Throwable -> L9
            this.descendingMap = r12;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return r12;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return r11;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Map.Entry<K, V> r11 = Synchronized.access$700(delegate().firstEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            Map.Entry<K, V> r12 = Synchronized.access$700(delegate().floorEntry(r10), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            K r12 = delegate().floorKey(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K r10, boolean r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            NavigableMap<K, V> r13 = Synchronized.navigableMap(delegate().headMap(r10, r11), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            Map.Entry<K, V> r12 = Synchronized.access$700(delegate().higherEntry(r10), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            K r12 = delegate().higherKey(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Map.Entry<K, V> r11 = Synchronized.access$700(delegate().lastEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            Map.Entry<K, V> r12 = Synchronized.access$700(delegate().lowerEntry(r10), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            K r12 = delegate().lowerKey(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            NavigableSet<K> r11 = this.navigableKeySet;     // Catch: Throwable -> L9
            if (r11 != null) goto L11;
            NavigableSet<K> r12 = Synchronized.navigableSet(delegate().navigableKeySet(), this.mutex);     // Catch: Throwable -> L9
            this.navigableKeySet = r12;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return r12;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return r11;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Map.Entry<K, V> r11 = Synchronized.access$700(delegate().pollFirstEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Map.Entry<K, V> r11 = Synchronized.access$700(delegate().pollLastEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K r10, boolean r11, K r12, boolean r13) {
            Object r14 = this.mutex;
            monitor-enter(r14);
            NavigableMap<K, V> r15 = Synchronized.navigableMap(delegate().subMap(r10, r11, r12, r13), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r14);     // Catch: Throwable -> L7
            return r15;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K r10, boolean r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            NavigableMap<K, V> r13 = Synchronized.navigableMap(delegate().tailMap(r10, r11), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ SortedMap delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableMap<K, V> delegate() {
            return (NavigableMap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K r10) {
            return headMap(r10, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K r10, K r11) {
            return subMap(r10, true, r11, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K r10) {
            return tailMap(r10, true);
        }
    }

    @GwtIncompatible
    @VisibleForTesting
    public static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient NavigableSet<E> descendingSet;

        public SynchronizedNavigableSet(NavigableSet<E> r10, @NullableDecl Object r11) {
            super(r10, r11);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            E r12 = delegate().ceiling(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return delegate().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            NavigableSet<E> r11 = this.descendingSet;     // Catch: Throwable -> L9
            if (r11 != null) goto L11;
            NavigableSet<E> r12 = Synchronized.navigableSet(delegate().descendingSet(), this.mutex);     // Catch: Throwable -> L9
            this.descendingSet = r12;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return r12;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return r11;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public E floor(E r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            E r12 = delegate().floor(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E r10, boolean r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            NavigableSet<E> r13 = Synchronized.navigableSet(delegate().headSet(r10, r11), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public E higher(E r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            E r12 = delegate().higher(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public E lower(E r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            E r12 = delegate().lower(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().pollFirst();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().pollLast();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E r10, boolean r11, E r12, boolean r13) {
            Object r14 = this.mutex;
            monitor-enter(r14);
            NavigableSet<E> r15 = Synchronized.navigableSet(delegate().subSet(r10, r11, r12, r13), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r14);     // Catch: Throwable -> L7
            return r15;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E r10, boolean r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            NavigableSet<E> r13 = Synchronized.navigableSet(delegate().tailSet(r10, r11), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ SortedSet delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E r10) {
            return headSet(r10, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E r10) {
            return tailSet(r10, true);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableSet<E> delegate() {
            return (NavigableSet) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E r10, E r11) {
            return subSet(r10, true, r11, false);
        }
    }

    public static class SynchronizedObject implements Serializable {

        @GwtIncompatible
        private static final long serialVersionUID = 0;
        final Object delegate;
        final Object mutex;

        public SynchronizedObject(Object r10, @NullableDecl Object r11) {
            this.delegate = Preconditions.checkNotNull(r10);
            if (r11 != null) goto L5;
            r11 = this;
        L5:
            this.mutex = r11;
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream r10) throws IOException {
            Object r11 = this.mutex;
            monitor-enter(r11);
            r10.defaultWriteObject();     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public Object delegate() {
            return this.delegate;
        }

        public String toString() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            String r11 = this.delegate.toString();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedQueue(Queue<E> r10, @NullableDecl Object r11) {
            super(r10, r11, null);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.Queue
        public E element() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().element();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Queue
        public boolean offer(E r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().offer(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Queue
        public E peek() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().peek();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Queue
        public E poll() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().poll();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Queue
        public E remove() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().remove();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Queue<E> delegate() {
            return (Queue) super.delegate();
        }
    }

    public static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 0;

        public SynchronizedRandomAccessList(List<E> r10, @NullableDecl Object r11) {
            super(r10, r11);
        }
    }

    public static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedSet(Set<E> r10, @NullableDecl Object r11) {
            super(r10, r11, null);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        public boolean equals(Object r10) {
            if (r10 != this) goto L5;
            return true;
        L5:
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().equals(r10);     // Catch: Throwable -> L10
            monitor-exit(r11);     // Catch: Throwable -> L10
            return r12;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            int r11 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Set<E> delegate() {
            return (Set) super.delegate();
        }
    }

    public static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        transient Set<Map.Entry<K, V>> entrySet;

        public SynchronizedSetMultimap(SetMultimap<K, V> r10, @NullableDecl Object r11) {
            super(r10, r11);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Multimap delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection entries() {
            return entries();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection removeAll(Object r10) {
            return removeAll(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r10, Iterable r11) {
            return replaceValues(r10, r11);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<Map.Entry<K, V>> entries() {
            Object r10 = this.mutex;
            monitor-enter(r10);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.entrySet != null) goto L9;
            this.entrySet = Synchronized.set(delegate().entries(), this.mutex);     // Catch: Throwable -> L7
        L9:
            Set<Map.Entry<K, V>> r11 = this.entrySet;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<V> get(K r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            Set<V> r12 = Synchronized.set(delegate().get(r10), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<V> removeAll(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            Set<V> r12 = delegate().removeAll(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<V> replaceValues(K r10, Iterable<? extends V> r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            Set<V> r13 = delegate().replaceValues(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public SetMultimap<K, V> delegate() {
            return (SetMultimap) super.delegate();
        }
    }

    public static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedSortedMap(SortedMap<K, V> r10, @NullableDecl Object r11) {
            super(r10, r11);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Comparator<? super K> r11 = delegate().comparator();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            K r11 = delegate().firstKey();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedMap<K, V> headMap(K r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            SortedMap<K, V> r12 = Synchronized.sortedMap(delegate().headMap(r10), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            K r11 = delegate().lastKey();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedMap<K, V> subMap(K r10, K r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            SortedMap<K, V> r13 = Synchronized.sortedMap(delegate().subMap(r10, r11), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedMap<K, V> tailMap(K r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            SortedMap<K, V> r12 = Synchronized.sortedMap(delegate().tailMap(r10), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedMap<K, V> delegate() {
            return (SortedMap) super.delegate();
        }
    }

    public static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedSortedSet(SortedSet<E> r10, @NullableDecl Object r11) {
            super(r10, r11);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Comparator<? super E> r11 = delegate().comparator();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.SortedSet
        public E first() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().first();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedSet<E> headSet(E r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            SortedSet<E> r12 = Synchronized.access$100(delegate().headSet(r10), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.SortedSet
        public E last() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            E r11 = delegate().last();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedSet<E> subSet(E r10, E r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            SortedSet<E> r13 = Synchronized.access$100(delegate().subSet(r10, r11), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedSet<E> tailSet(E r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            SortedSet<E> r12 = Synchronized.access$100(delegate().tailSet(r10), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedSet<E> delegate() {
            return (SortedSet) super.delegate();
        }
    }

    public static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedSortedSetMultimap(SortedSetMultimap<K, V> r10, @NullableDecl Object r11) {
            super(r10, r11);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Multimap delegate() {
            return delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection removeAll(Object r10) {
            return removeAll(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r10, Iterable r11) {
            return replaceValues(r10, r11);
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator<? super V> valueComparator() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Comparator<? super V> r11 = delegate().valueComparator();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ SetMultimap delegate() {
            return delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set get(Object r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set removeAll(Object r10) {
            return removeAll(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set replaceValues(Object r10, Iterable r11) {
            return replaceValues(r10, r11);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public SortedSet<V> get(K r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            SortedSet<V> r12 = Synchronized.access$100(delegate().get(r10), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public SortedSet<V> removeAll(Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            SortedSet<V> r12 = delegate().removeAll(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public SortedSet<V> replaceValues(K r10, Iterable<? extends V> r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            SortedSet<V> r13 = delegate().replaceValues(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedSetMultimap<K, V> delegate() {
            return (SortedSetMultimap) super.delegate();
        }
    }

    public static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements Table<R, C, V> {
        public SynchronizedTable(Table<R, C, V> r10, Object r11) {
            super(r10, r11);
        }

        @Override // com.google.common.collect.Table
        public Set<Table.Cell<R, C, V>> cellSet() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Set<Table.Cell<R, C, V>> r11 = Synchronized.set(delegate().cellSet(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public void clear() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            delegate().clear();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public Map<R, V> column(@NullableDecl C r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            Map<R, V> r12 = Synchronized.map(delegate().column(r10), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public Set<C> columnKeySet() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Set<C> r11 = Synchronized.set(delegate().columnKeySet(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public Map<C, Map<R, V>> columnMap() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Map<C, Map<R, V>> r11 = Synchronized.map(Maps.transformValues(delegate().columnMap(), new AnonymousClass2(this)), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public boolean contains(@NullableDecl Object r10, @NullableDecl Object r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            boolean r13 = delegate().contains(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public boolean containsColumn(@NullableDecl Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().containsColumn(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public boolean containsRow(@NullableDecl Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().containsRow(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public boolean containsValue(@NullableDecl Object r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().containsValue(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Table
        public boolean equals(@NullableDecl Object r10) {
            if (this != r10) goto L5;
            return true;
        L5:
            Object r11 = this.mutex;
            monitor-enter(r11);
            boolean r12 = delegate().equals(r10);     // Catch: Throwable -> L10
            monitor-exit(r11);     // Catch: Throwable -> L10
            return r12;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public V get(@NullableDecl Object r10, @NullableDecl Object r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            V r13 = delegate().get(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public int hashCode() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            int r11 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public boolean isEmpty() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            boolean r11 = delegate().isEmpty();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public V put(@NullableDecl R r10, @NullableDecl C r11, @NullableDecl V r12) {
            Object r13 = this.mutex;
            monitor-enter(r13);
            V r14 = delegate().put(r10, r11, r12);     // Catch: Throwable -> L7
            monitor-exit(r13);     // Catch: Throwable -> L7
            return r14;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public void putAll(Table<? extends R, ? extends C, ? extends V> r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            delegate().putAll(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public V remove(@NullableDecl Object r10, @NullableDecl Object r11) {
            Object r12 = this.mutex;
            monitor-enter(r12);
            V r13 = delegate().remove(r10, r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public Map<C, V> row(@NullableDecl R r10) {
            Object r11 = this.mutex;
            monitor-enter(r11);
            Map<C, V> r12 = Synchronized.map(delegate().row(r10), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return r12;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public Set<R> rowKeySet() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Set<R> r11 = Synchronized.set(delegate().rowKeySet(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public Map<R, Map<C, V>> rowMap() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Map<R, Map<C, V>> r11 = Synchronized.map(Maps.transformValues(delegate().rowMap(), new AnonymousClass1(this)), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public int size() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            int r11 = delegate().size();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Table
        public Collection<V> values() {
            Object r10 = this.mutex;
            monitor-enter(r10);
            Collection<V> r11 = Synchronized.access$500(delegate().values(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Table<R, C, V> delegate() {
            return (Table) super.delegate();
        }
    }

    private Synchronized() {
    }

    public static /* synthetic */ SortedSet access$100(SortedSet r10, Object r11) {
        return sortedSet(r10, r11);
    }

    public static /* synthetic */ List access$200(List r10, Object r11) {
        return list(r10, r11);
    }

    public static /* synthetic */ Set access$300(Set r10, Object r11) {
        return typePreservingSet(r10, r11);
    }

    public static /* synthetic */ Collection access$400(Collection r10, Object r11) {
        return typePreservingCollection(r10, r11);
    }

    public static /* synthetic */ Collection access$500(Collection r10, Object r11) {
        return collection(r10, r11);
    }

    public static /* synthetic */ Map.Entry access$700(Map.Entry r10, Object r11) {
        return nullableSynchronizedEntry(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> BiMap<K, V> biMap(BiMap<K, V> r10, @NullableDecl Object r11) {
        if ((r10 instanceof SynchronizedBiMap) == false) goto L5;
    L9:
        return r10;
    L5:
        if ((r10 instanceof ImmutableBiMap) == true) goto L9;
        return new SynchronizedBiMap(r10, r11, null, 0 == true ? 1 : 0);
    }

    private static <E> Collection<E> collection(Collection<E> r10, @NullableDecl Object r11) {
        return new SynchronizedCollection(r10, r11, null);
    }

    public static <E> Deque<E> deque(Deque<E> r10, @NullableDecl Object r11) {
        return new SynchronizedDeque(r10, r11);
    }

    private static <E> List<E> list(List<E> r10, @NullableDecl Object r11) {
        if ((r10 instanceof RandomAccess) == false) goto L6;
        return new SynchronizedRandomAccessList(r10, r11);
    L6:
        return new SynchronizedList(r10, r11);
    }

    public static <K, V> ListMultimap<K, V> listMultimap(ListMultimap<K, V> r10, @NullableDecl Object r11) {
        if ((r10 instanceof SynchronizedListMultimap) == false) goto L5;
    L9:
        return r10;
    L5:
        if ((r10 instanceof BaseImmutableMultimap) == true) goto L9;
        return new SynchronizedListMultimap(r10, r11);
    }

    @VisibleForTesting
    public static <K, V> Map<K, V> map(Map<K, V> r10, @NullableDecl Object r11) {
        return new SynchronizedMap(r10, r11);
    }

    public static <K, V> Multimap<K, V> multimap(Multimap<K, V> r10, @NullableDecl Object r11) {
        if ((r10 instanceof SynchronizedMultimap) == false) goto L5;
    L9:
        return r10;
    L5:
        if ((r10 instanceof BaseImmutableMultimap) == true) goto L9;
        return new SynchronizedMultimap(r10, r11);
    }

    public static <E> Multiset<E> multiset(Multiset<E> r10, @NullableDecl Object r11) {
        if ((r10 instanceof SynchronizedMultiset) == false) goto L5;
    L9:
        return r10;
    L5:
        if ((r10 instanceof ImmutableMultiset) == true) goto L9;
        return new SynchronizedMultiset(r10, r11);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> navigableMap(NavigableMap<K, V> r10) {
        return navigableMap(r10, null);
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> navigableSet(NavigableSet<E> r10, @NullableDecl Object r11) {
        return new SynchronizedNavigableSet(r10, r11);
    }

    @GwtIncompatible
    private static <K, V> Map.Entry<K, V> nullableSynchronizedEntry(@NullableDecl Map.Entry<K, V> r10, @NullableDecl Object r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new SynchronizedEntry(r10, r11);
    }

    public static <E> Queue<E> queue(Queue<E> r10, @NullableDecl Object r11) {
        if ((r10 instanceof SynchronizedQueue) == false) goto L6;
        return r10;
    L6:
        return new SynchronizedQueue(r10, r11);
    }

    @VisibleForTesting
    public static <E> Set<E> set(Set<E> r10, @NullableDecl Object r11) {
        return new SynchronizedSet(r10, r11);
    }

    public static <K, V> SetMultimap<K, V> setMultimap(SetMultimap<K, V> r10, @NullableDecl Object r11) {
        if ((r10 instanceof SynchronizedSetMultimap) == false) goto L5;
    L9:
        return r10;
    L5:
        if ((r10 instanceof BaseImmutableMultimap) == true) goto L9;
        return new SynchronizedSetMultimap(r10, r11);
    }

    public static <K, V> SortedMap<K, V> sortedMap(SortedMap<K, V> r10, @NullableDecl Object r11) {
        return new SynchronizedSortedMap(r10, r11);
    }

    private static <E> SortedSet<E> sortedSet(SortedSet<E> r10, @NullableDecl Object r11) {
        return new SynchronizedSortedSet(r10, r11);
    }

    public static <K, V> SortedSetMultimap<K, V> sortedSetMultimap(SortedSetMultimap<K, V> r10, @NullableDecl Object r11) {
        if ((r10 instanceof SynchronizedSortedSetMultimap) == false) goto L6;
        return r10;
    L6:
        return new SynchronizedSortedSetMultimap(r10, r11);
    }

    public static <R, C, V> Table<R, C, V> table(Table<R, C, V> r10, Object r11) {
        return new SynchronizedTable(r10, r11);
    }

    private static <E> Collection<E> typePreservingCollection(Collection<E> r10, @NullableDecl Object r11) {
        if ((r10 instanceof SortedSet) == false) goto L7;
        return sortedSet((SortedSet) r10, r11);
    L7:
        if ((r10 instanceof Set) == false) goto L11;
        return set((Set) r10, r11);
    L11:
        if ((r10 instanceof List) == false) goto L15;
        return list((List) r10, r11);
    L15:
        return collection(r10, r11);
    }

    private static <E> Set<E> typePreservingSet(Set<E> r10, @NullableDecl Object r11) {
        if ((r10 instanceof SortedSet) == false) goto L7;
        return sortedSet((SortedSet) r10, r11);
    L7:
        return set(r10, r11);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> navigableMap(NavigableMap<K, V> r10, @NullableDecl Object r11) {
        return new SynchronizedNavigableMap(r10, r11);
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> navigableSet(NavigableSet<E> r10) {
        return navigableSet(r10, null);
    }
}
