package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class MapConstraints {

    static class ConstrainedAsMapEntries<K, V> extends ForwardingSet<Map.Entry<K, Collection<V>>> {
        private final MapConstraint<? super K, ? super V> constraint;
        private final Set<Map.Entry<K, Collection<V>>> entries;

        static /* synthetic */ MapConstraint access$600(ConstrainedAsMapEntries r0) {
            return r0.constraint;
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        ConstrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> r1, MapConstraint<? super K, ? super V> r2) {
            this.entries = r1;
            this.constraint = r2;
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Set<Map.Entry<K, Collection<V>>> delegate() {
            return this.entries;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            final Iterator<Map.Entry<K, Collection<V>>> r0 = this.entries.iterator();
            return new AnonymousClass1(this, r0);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) standardToArray(r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return Maps.containsEntryImpl(delegate(), r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r1) {
            return standardContainsAll(r1);
        }

        @Override // com.google.common.collect.ForwardingSet, java.util.Collection, java.util.Set
        public boolean equals(@Nullable Object r1) {
            return standardEquals(r1);
        }

        @Override // com.google.common.collect.ForwardingSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return standardHashCode();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r1) {
            return Maps.removeEntryImpl(delegate(), r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r1) {
            return standardRemoveAll(r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r1) {
            return standardRetainAll(r1);
        }
    }

    private static class ConstrainedAsMapValues<K, V> extends ForwardingCollection<Collection<V>> {
        final Collection<Collection<V>> delegate;
        final Set<Map.Entry<K, Collection<V>>> entrySet;

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        ConstrainedAsMapValues(Collection<Collection<V>> r1, Set<Map.Entry<K, Collection<V>>> r2) {
            this.delegate = r1;
            this.entrySet = r2;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Collection<Collection<V>> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Collection<V>> iterator() {
            final Iterator<Map.Entry<K, Collection<V>>> r0 = this.entrySet.iterator();
            return new AnonymousClass1(this, r0);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) standardToArray(r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return standardContains(r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r1) {
            return standardContainsAll(r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r1) {
            return standardRemove(r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r1) {
            return standardRemoveAll(r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r1) {
            return standardRetainAll(r1);
        }
    }

    private static class ConstrainedBiMap<K, V> extends ConstrainedMap<K, V> implements BiMap<K, V> {
        volatile BiMap<V, K> inverse;

        @Override // com.google.common.collect.MapConstraints.ConstrainedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.MapConstraints.ConstrainedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        ConstrainedBiMap(BiMap<K, V> r1, @Nullable BiMap<V, K> r2, MapConstraint<? super K, ? super V> r3) {
            super(r1, r3);
            this.inverse = r2;
        }

        @Override // com.google.common.collect.MapConstraints.ConstrainedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected BiMap<K, V> delegate() {
            return (BiMap) super.delegate();
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(K r2, V r3) {
            this.constraint.checkKeyValue(r2, r3);
            return delegate().forcePut(r2, r3);
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            if (this.inverse != null) goto L6;
            this.inverse = new ConstrainedBiMap(delegate().inverse(), this, new InverseConstraint(this.constraint));
        L6:
            return this.inverse;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<V> values() {
            return delegate().values();
        }
    }

    private static class ConstrainedEntries<K, V> extends ForwardingCollection<Map.Entry<K, V>> {
        final MapConstraint<? super K, ? super V> constraint;
        final Collection<Map.Entry<K, V>> entries;

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        ConstrainedEntries(Collection<Map.Entry<K, V>> r1, MapConstraint<? super K, ? super V> r2) {
            this.entries = r1;
            this.constraint = r2;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Collection<Map.Entry<K, V>> delegate() {
            return this.entries;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            final Iterator<Map.Entry<K, V>> r0 = this.entries.iterator();
            return new AnonymousClass1(this, r0);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) standardToArray(r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return Maps.containsEntryImpl(delegate(), r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r1) {
            return standardContainsAll(r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r1) {
            return Maps.removeEntryImpl(delegate(), r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r1) {
            return standardRemoveAll(r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r1) {
            return standardRetainAll(r1);
        }
    }

    static class ConstrainedEntrySet<K, V> extends ConstrainedEntries<K, V> implements Set<Map.Entry<K, V>> {
        ConstrainedEntrySet(Set<Map.Entry<K, V>> r1, MapConstraint<? super K, ? super V> r2) {
            super(r1, r2);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@Nullable Object r1) {
            return Sets.equalsImpl(this, r1);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    private static class ConstrainedListMultimap<K, V> extends ConstrainedMultimap<K, V> implements ListMultimap<K, V> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
            return removeAll(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r1, Iterable r2) {
            return replaceValues(r1, r2);
        }

        ConstrainedListMultimap(ListMultimap<K, V> r1, MapConstraint<? super K, ? super V> r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public List<V> get(K r1) {
            return (List) super.get(r1);
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public List<V> removeAll(Object r1) {
            return (List) super.removeAll(r1);
        }

        @Override // com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public List<V> replaceValues(K r1, Iterable<? extends V> r2) {
            return (List) super.replaceValues(r1, r2);
        }
    }

    static class ConstrainedMap<K, V> extends ForwardingMap<K, V> {
        final MapConstraint<? super K, ? super V> constraint;
        private final Map<K, V> delegate;
        private transient Set<Map.Entry<K, V>> entrySet;

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        ConstrainedMap(Map<K, V> r1, MapConstraint<? super K, ? super V> r2) {
            this.delegate = (Map) Preconditions.checkNotNull(r1);
            this.constraint = (MapConstraint) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected Map<K, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> r0 = this.entrySet;
            if (r0 != null) goto L6;
            Set<Map.Entry<K, V>> r1 = MapConstraints.access$000(this.delegate.entrySet(), this.constraint);
            this.entrySet = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public V put(K r2, V r3) {
            this.constraint.checkKeyValue(r2, r3);
            return this.delegate.put(r2, r3);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public void putAll(Map<? extends K, ? extends V> r2) {
            this.delegate.putAll(MapConstraints.access$100(r2, this.constraint));
        }
    }

    private static class ConstrainedMultimap<K, V> extends ForwardingMultimap<K, V> implements Serializable {
        transient Map<K, Collection<V>> asMap;
        final MapConstraint<? super K, ? super V> constraint;
        final Multimap<K, V> delegate;
        transient Collection<Map.Entry<K, V>> entries;

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        public ConstrainedMultimap(Multimap<K, V> r1, MapConstraint<? super K, ? super V> r2) {
            this.delegate = (Multimap) Preconditions.checkNotNull(r1);
            this.constraint = (MapConstraint) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        protected Multimap<K, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> r0 = this.asMap;
            if (r0 != null) goto L6;
            final Map<K, Collection<V>> r1 = this.delegate.asMap();
            ForwardingMap<K, Collection<V>> r2 = new AnonymousClass1(this, r1);
            this.asMap = r2;
            return r2;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> r0 = this.entries;
            if (r0 != null) goto L6;
            Collection<Map.Entry<K, V>> r1 = MapConstraints.access$300(this.delegate.entries(), this.constraint);
            this.entries = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection<V> get(final K r3) {
            return Constraints.constrainedTypePreservingCollection(this.delegate.get(r3), new AnonymousClass2(this, r3));
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean put(K r2, V r3) {
            this.constraint.checkKeyValue(r2, r3);
            return this.delegate.put(r2, r3);
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean putAll(K r2, Iterable<? extends V> r3) {
            return this.delegate.putAll(r2, MapConstraints.access$400(r2, r3, this.constraint));
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> r4) {
            Iterator<Map.Entry<? extends K, ? extends V>> r5 = r4.entries().iterator();
            boolean r0 = false;
        L4:
            if (r5.hasNext() == false) goto L6;
            Map.Entry<? extends K, ? extends V> r1 = r5.next();
            r0 = r0 | put(r1.getKey(), r1.getValue());
            goto L4
        L6:
            return r0;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection<V> replaceValues(K r2, Iterable<? extends V> r3) {
            return this.delegate.replaceValues(r2, MapConstraints.access$400(r2, r3, this.constraint));
        }
    }

    private static class ConstrainedSetMultimap<K, V> extends ConstrainedMultimap<K, V> implements SetMultimap<K, V> {
        @Override // com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection entries() {
            return entries();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
            return removeAll(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r1, Iterable r2) {
            return replaceValues(r1, r2);
        }

        ConstrainedSetMultimap(SetMultimap<K, V> r1, MapConstraint<? super K, ? super V> r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set<V> get(K r1) {
            return (Set) super.get(r1);
        }

        @Override // com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set<Map.Entry<K, V>> entries() {
            return (Set) super.entries();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set<V> removeAll(Object r1) {
            return (Set) super.removeAll(r1);
        }

        @Override // com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set<V> replaceValues(K r1, Iterable<? extends V> r2) {
            return (Set) super.replaceValues(r1, r2);
        }
    }

    private static class ConstrainedSortedSetMultimap<K, V> extends ConstrainedSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapConstraints.ConstrainedSetMultimap, com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection get(Object r1) {
            return get(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapConstraints.ConstrainedSetMultimap, com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set get(Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.MapConstraints.ConstrainedSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
            return removeAll(r1);
        }

        @Override // com.google.common.collect.MapConstraints.ConstrainedSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set removeAll(Object r1) {
            return removeAll(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapConstraints.ConstrainedSetMultimap, com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object r1, Iterable r2) {
            return replaceValues(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapConstraints.ConstrainedSetMultimap, com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ Set replaceValues(Object r1, Iterable r2) {
            return replaceValues(r1, r2);
        }

        ConstrainedSortedSetMultimap(SortedSetMultimap<K, V> r1, MapConstraint<? super K, ? super V> r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.MapConstraints.ConstrainedSetMultimap, com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public SortedSet<V> get(K r1) {
            return (SortedSet) super.get(r1);
        }

        @Override // com.google.common.collect.MapConstraints.ConstrainedSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public SortedSet<V> removeAll(Object r1) {
            return (SortedSet) super.removeAll(r1);
        }

        @Override // com.google.common.collect.MapConstraints.ConstrainedSetMultimap, com.google.common.collect.MapConstraints.ConstrainedMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public SortedSet<V> replaceValues(K r1, Iterable<? extends V> r2) {
            return (SortedSet) super.replaceValues(r1, r2);
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator<? super V> valueComparator() {
            return ((SortedSetMultimap) delegate()).valueComparator();
        }
    }

    private static class InverseConstraint<K, V> implements MapConstraint<K, V> {
        final MapConstraint<? super V, ? super K> constraint;

        public InverseConstraint(MapConstraint<? super V, ? super K> r1) {
            this.constraint = (MapConstraint) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.collect.MapConstraint
        public void checkKeyValue(K r1, V r2) {
            this.constraint.checkKeyValue(r2, r1);
        }
    }

    private static final enum NotNullMapConstraint extends Enum<NotNullMapConstraint> implements MapConstraint<Object, Object> {
        private static final /* synthetic */ NotNullMapConstraint[] $VALUES = null;
        public static final NotNullMapConstraint INSTANCE = null;

        @Override // java.lang.Enum, com.google.common.collect.MapConstraint
        public String toString() {
            return "Not null";
        }

        private NotNullMapConstraint(String r1, int r2) {
            super(r1, r2);
        }

        public static NotNullMapConstraint valueOf(String r1) {
            return (NotNullMapConstraint) Enum.valueOf(NotNullMapConstraint.class, r1);
        }

        public static NotNullMapConstraint[] values() {
            return (NotNullMapConstraint[]) $VALUES.clone();
        }

        static {
            NotNullMapConstraint r0 = new NotNullMapConstraint("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new NotNullMapConstraint[]{r0};
        }

        @Override // com.google.common.collect.MapConstraint
        public void checkKeyValue(Object r1, Object r2) {
            Preconditions.checkNotNull(r1);
            Preconditions.checkNotNull(r2);
        }
    }

    static /* synthetic */ Set access$000(Set r0, MapConstraint r1) {
        return constrainedEntrySet(r0, r1);
    }

    static /* synthetic */ Map access$100(Map r0, MapConstraint r1) {
        return checkMap(r0, r1);
    }

    static /* synthetic */ Set access$200(Set r0, MapConstraint r1) {
        return constrainedAsMapEntries(r0, r1);
    }

    static /* synthetic */ Collection access$300(Collection r0, MapConstraint r1) {
        return constrainedEntries(r0, r1);
    }

    static /* synthetic */ Collection access$400(Object r0, Iterable r1, MapConstraint r2) {
        return checkValues(r0, r1, r2);
    }

    static /* synthetic */ Map.Entry access$500(Map.Entry r0, MapConstraint r1) {
        return constrainedEntry(r0, r1);
    }

    static /* synthetic */ Map.Entry access$700(Map.Entry r0, MapConstraint r1) {
        return constrainedAsMapEntry(r0, r1);
    }

    private MapConstraints() {
    }

    public static MapConstraint<Object, Object> notNull() {
        return NotNullMapConstraint.INSTANCE;
    }

    public static <K, V> Map<K, V> constrainedMap(Map<K, V> r1, MapConstraint<? super K, ? super V> r2) {
        return new ConstrainedMap(r1, r2);
    }

    public static <K, V> Multimap<K, V> constrainedMultimap(Multimap<K, V> r1, MapConstraint<? super K, ? super V> r2) {
        return new ConstrainedMultimap(r1, r2);
    }

    public static <K, V> ListMultimap<K, V> constrainedListMultimap(ListMultimap<K, V> r1, MapConstraint<? super K, ? super V> r2) {
        return new ConstrainedListMultimap(r1, r2);
    }

    public static <K, V> SetMultimap<K, V> constrainedSetMultimap(SetMultimap<K, V> r1, MapConstraint<? super K, ? super V> r2) {
        return new ConstrainedSetMultimap(r1, r2);
    }

    public static <K, V> SortedSetMultimap<K, V> constrainedSortedSetMultimap(SortedSetMultimap<K, V> r1, MapConstraint<? super K, ? super V> r2) {
        return new ConstrainedSortedSetMultimap(r1, r2);
    }

    private static <K, V> Map.Entry<K, V> constrainedEntry(final Map.Entry<K, V> r1, final MapConstraint<? super K, ? super V> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass1(r1, r2);
    }

    private static <K, V> Map.Entry<K, Collection<V>> constrainedAsMapEntry(final Map.Entry<K, Collection<V>> r1, final MapConstraint<? super K, ? super V> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass2(r1, r2);
    }

    private static <K, V> Set<Map.Entry<K, Collection<V>>> constrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> r1, MapConstraint<? super K, ? super V> r2) {
        return new ConstrainedAsMapEntries(r1, r2);
    }

    private static <K, V> Collection<Map.Entry<K, V>> constrainedEntries(Collection<Map.Entry<K, V>> r1, MapConstraint<? super K, ? super V> r2) {
        if ((r1 instanceof Set) == false) goto L7;
        return constrainedEntrySet((Set) r1, r2);
    L7:
        return new ConstrainedEntries(r1, r2);
    }

    private static <K, V> Set<Map.Entry<K, V>> constrainedEntrySet(Set<Map.Entry<K, V>> r1, MapConstraint<? super K, ? super V> r2) {
        return new ConstrainedEntrySet(r1, r2);
    }

    public static <K, V> BiMap<K, V> constrainedBiMap(BiMap<K, V> r2, MapConstraint<? super K, ? super V> r3) {
        return new ConstrainedBiMap(r2, null, r3);
    }

    private static <K, V> Collection<V> checkValues(K r2, Iterable<? extends V> r3, MapConstraint<? super K, ? super V> r4) {
        ArrayList r5 = Lists.newArrayList(r3);
        Iterator r0 = r5.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r4.checkKeyValue(r2, (Object) r0.next());
        goto L4
    L6:
        return r5;
    }

    private static <K, V> Map<K, V> checkMap(Map<? extends K, ? extends V> r3, MapConstraint<? super K, ? super V> r4) {
        LinkedHashMap r0 = new LinkedHashMap(r3);
        Iterator<Map.Entry<K, V>> r5 = r0.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<K, V> r1 = r5.next();
        r4.checkKeyValue(r1.getKey(), r1.getValue());
        goto L4
    L6:
        return r0;
    }
}
