package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
    private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = null;
    private static final Comparator<Comparable> NATURAL_ORDER = null;
    private static final long serialVersionUID = 0;
    private transient ImmutableSortedMap<K, V> descendingMap;
    private final transient RegularImmutableSortedSet<K> keySet;
    private final transient ImmutableList<V> valueList;

    public static class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        private final Comparator<? super K> comparator;
        private transient Object[] keys;
        private transient Object[] values;

        public Builder(Comparator<? super K> r10) {
            this(r10, 4);
        }

        private void ensureCapacity(int r10) {
            Object[] r11 = this.keys;
            if (r10 <= r11.length) goto L6;
            int r12 = ImmutableCollection.Builder.expandedCapacity(r11.length, r10);
            this.keys = Arrays.copyOf(this.keys, r12);
            this.values = Arrays.copyOf(this.values, r12);
            return;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public /* bridge */ /* synthetic */ ImmutableMap build() {
            return build();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        @Deprecated
        public /* bridge */ /* synthetic */ ImmutableMap.Builder orderEntriesByValue(Comparator r10) {
            return orderEntriesByValue(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMap.Builder put(Object r10, Object r11) {
            return put(r10, r11);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        public /* bridge */ /* synthetic */ ImmutableMap.Builder putAll(Iterable r10) {
            return putAll(r10);
        }

        private Builder(Comparator<? super K> r10, int r11) {
            this.comparator = (Comparator) Preconditions.checkNotNull(r10);
            this.keys = new Object[r11];
            this.values = new Object[r11];
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableSortedMap<K, V> build() {
            int r10 = this.size;
            if (r10 == 0) goto L21;
            int r11 = 0;
            if (r10 == 1) goto L19;
            Object[] r12 = Arrays.copyOf(this.keys, r10);
            Arrays.sort(r12, this.comparator);
            Object[] r13 = new Object[this.size];
        L8:
            if (r11 >= this.size) goto L17;
            if (r11 <= 0) goto L15;
            int r14 = r11 - 1;
            if (this.comparator.compare(r12[r14], r12[r11]) != 0) goto L15;
            throw new IllegalArgumentException("keys required to be distinct but compared as equal: " + r12[r14] + " and " + r12[r11]);
        L15:
            r13[Arrays.binarySearch(r12, this.keys[r11], this.comparator)] = this.values[r11];
            r11 = r11 + 1;
            goto L8
        L17:
            return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.asImmutableList(r12), this.comparator), ImmutableList.asImmutableList(r13));
        L19:
            return ImmutableSortedMap.access$000(this.comparator, this.keys[0], this.values[0]);
        L21:
            return ImmutableSortedMap.emptyMap(this.comparator);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        @Deprecated
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> r10) {
            throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMap.Builder put(Map.Entry r10) {
            return put(r10);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMap.Builder putAll(Map r10) {
            return putAll(r10);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(K r10, V r11) {
            ensureCapacity(this.size + 1);
            CollectPreconditions.checkEntryNotNull(r10, r11);
            Object[] r12 = this.keys;
            int r13 = this.size;
            r12[r13] = r10;
            this.values[r13] = r11;
            this.size = r13 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> r10) {
            super.putAll(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> r10) {
            super.putAll(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> r10) {
            super.put(r10);
            return this;
        }
    }

    public static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;
        private final Comparator<Object> comparator;

        public SerializedForm(ImmutableSortedMap<?, ?> r10) {
            super(r10);
            this.comparator = r10.comparator();
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public Object readResolve() {
            return createMap(new Builder(this.comparator));
        }
    }

    static {
        NATURAL_ORDER = Ordering.natural();
        NATURAL_EMPTY_MAP = new ImmutableSortedMap(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> r10, ImmutableList<V> r11) {
        this(r10, r11, null);
    }

    public static /* synthetic */ ImmutableSortedMap access$000(Comparator r10, Object r11, Object r12) {
        return of(r10, r11, r12);
    }

    public static /* synthetic */ RegularImmutableSortedSet access$100(ImmutableSortedMap r10) {
        return r10.keySet;
    }

    public static /* synthetic */ ImmutableList access$200(ImmutableSortedMap r10) {
        return r10.valueList;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> r10) {
        return copyOfInternal(r10, (Ordering) NATURAL_ORDER);
    }

    private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> r10, Comparator<? super K> r11) {
        boolean r12 = false;
        if ((r10 instanceof SortedMap) == false) goto L10;
        Comparator<? super K> r13 = ((SortedMap) r10).comparator();
        if (r13 == null) goto L7;
        r12 = r11.equals(r13);
        goto L10
    L7:
        if (r11 != NATURAL_ORDER) goto L10;
        r12 = true;
    L10:
        if (r12 == false) goto L17;
        if ((r10 instanceof ImmutableSortedMap) == false) goto L17;
        ImmutableSortedMap<K, V> r14 = (ImmutableSortedMap) r10;
        if (r14.isPartialView() == true) goto L17;
        return r14;
    L17:
        return fromEntries(r11, r12, r10.entrySet());
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> r10) {
        Comparator<? super K> r11 = r10.comparator();
        if (r11 != null) goto L6;
        r11 = NATURAL_ORDER;
    L6:
        if ((r10 instanceof ImmutableSortedMap) == false) goto L11;
        ImmutableSortedMap<K, V> r12 = (ImmutableSortedMap) r10;
        if (r12.isPartialView() == true) goto L11;
        return r12;
    L11:
        return fromEntries(r11, true, r10.entrySet());
    }

    public static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> r10) {
        if (Ordering.natural().equals(r10) == false) goto L7;
        return of();
    L7:
        return new ImmutableSortedMap(ImmutableSortedSet.emptySet(r10), ImmutableList.of());
    }

    private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> r10, boolean r11, Iterable<? extends Map.Entry<? extends K, ? extends V>> r12) {
        Map.Entry[] r13 = (Map.Entry[]) Iterables.toArray(r12, ImmutableMap.EMPTY_ENTRY_ARRAY);
        return fromEntries(r10, r11, r13, r13.length);
    }

    private ImmutableSortedMap<K, V> getSubMap(int r10, int r11) {
        if (r10 == 0) goto L4;
    L6:
        if (r10 != r11) goto L10;
        return emptyMap(comparator());
    L10:
        return new ImmutableSortedMap(this.keySet.getSubSet(r10, r11), this.valueList.subList(r10, r11));
    L4:
        if (r11 != size()) goto L6;
        return this;
    }

    public static <K extends Comparable<?>, V> Builder<K, V> naturalOrder() {
        return new Builder(Ordering.natural());
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return (ImmutableSortedMap<K, V>) NATURAL_EMPTY_MAP;
    }

    private static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> ofEntries(Map.Entry<K, V>... r10) {
        return fromEntries(Ordering.natural(), false, r10, r10.length);
    }

    public static <K, V> Builder<K, V> orderedBy(Comparator<K> r10) {
        return new Builder(r10);
    }

    public static <K extends Comparable<?>, V> Builder<K, V> reverseOrder() {
        return new Builder(Ordering.natural().reverse());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K r10) {
        return tailMap(r10, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K r10) {
        return (K) Maps.keyOrNull(ceilingEntry(r10));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new C1EntrySet(this);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableSet descendingKeySet() {
        return descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap descendingMap() {
        return descendingMap();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return entrySet().asList().get(0);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K r10) {
        return headMap(r10, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K r10) {
        return (K) Maps.keyOrNull(floorEntry(r10));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(@NullableDecl Object r10) {
        int r11 = this.keySet.indexOf(r10);
        if (r11 != (-1)) goto L6;
        return null;
    L6:
        return this.valueList.get(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap headMap(Object r10, boolean r11) {
        return headMap(r10, r11);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K r10) {
        return tailMap(r10, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K r10) {
        return (K) Maps.keyOrNull(higherEntry(r10));
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        if (this.keySet.isPartialView() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.valueList.isPartialView() == true) goto L8;
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ ImmutableSet keySet() {
        return keySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return entrySet().asList().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K r10) {
        return headMap(r10, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K r10) {
        return (K) Maps.keyOrNull(lowerEntry(r10));
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableSet navigableKeySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    @CanIgnoreReturnValue
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @CanIgnoreReturnValue
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.valueList.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap subMap(Object r10, boolean r11, Object r12, boolean r13) {
        return subMap(r10, r11, r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap tailMap(Object r10, boolean r11) {
        return tailMap(r10, r11);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> r10, ImmutableList<V> r11, ImmutableSortedMap<K, V> r12) {
        this.keySet = r10;
        this.valueList = r11;
        this.descendingMap = r12;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r10, Object r11) {
        return of(Ordering.natural(), r10, r11);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> descendingKeySet() {
        return this.keySet.descendingSet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> r10 = this.descendingMap;
        if (r10 == null) goto L5;
        return r10;
    L5:
        if (isEmpty() == false) goto L9;
        return emptyMap(Ordering.from(comparator()).reverse());
    L9:
        return new ImmutableSortedMap((RegularImmutableSortedSet) this.keySet.descendingSet(), this.valueList.reverse(), this);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap headMap(Object r10) {
        return headMap(r10);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.keySet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap subMap(Object r10, Object r11) {
        return subMap(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap tailMap(Object r10) {
        return tailMap(r10);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableCollection<V> values() {
        return this.valueList;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> r10, Comparator<? super K> r11) {
        return copyOfInternal(r10, (Comparator) Preconditions.checkNotNull(r11));
    }

    private static <K, V> ImmutableSortedMap<K, V> fromEntries(final Comparator<? super K> r10, boolean r11, Map.Entry<K, V>[] r12, int r13) {
        if (r13 == 0) goto L21;
        int r14 = 0;
        if (r13 == 1) goto L19;
        Object[] r15 = new Object[r13];
        Object[] r16 = new Object[r13];
        if (r11 == false) goto L9;
    L7:
        if (r14 >= r13) goto L17;
        K r17 = r12[r14].getKey();
        V r18 = r12[r14].getValue();
        CollectPreconditions.checkEntryNotNull(r17, r18);
        r15[r14] = r17;
        r16[r14] = r18;
        r14 = r14 + 1;
    L17:
        return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.asImmutableList(r15), r10), ImmutableList.asImmutableList(r16));
    L9:
        Arrays.sort(r12, 0, r13, new AnonymousClass1(r10));
        Object r19 = r12[0].getKey();
        r15[0] = r19;
        V r20 = r12[0].getValue();
        r16[0] = r20;
        CollectPreconditions.checkEntryNotNull(r15[0], r20);
        int r21 = 1;
    L10:
        if (r21 >= r13) goto L17;
        Object r22 = r12[r21].getKey();
        V r23 = r12[r21].getValue();
        CollectPreconditions.checkEntryNotNull(r22, r23);
        r15[r21] = r22;
        r16[r21] = r23;
        if (r10.compare(r19, r22) == 0) goto L14;
        boolean r110 = true;
    L15:
        ImmutableMap.checkNoConflict(r110, "key", r12[r21 - 1], r12[r21]);
        r21 = r21 + 1;
        r19 = r22;
        goto L10
    L14:
        r110 = false;
        goto L15
    L19:
        return of(r10, r12[0].getKey(), r12[0].getValue());
    L21:
        return emptyMap(r10);
    }

    private static <K, V> ImmutableSortedMap<K, V> of(Comparator<? super K> r10, K r11, V r12) {
        return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.of(r11), (Comparator) Preconditions.checkNotNull(r10)), ImmutableList.of(r12));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K r10) {
        return headMap(r10, false);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSortedSet<K> keySet() {
        return this.keySet;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> subMap(K r10, K r11) {
        return subMap(r10, true, r11, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K r10) {
        return tailMap(r10, true);
    }

    @Beta
    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r10) {
        return copyOf(r10, (Ordering) NATURAL_ORDER);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> headMap(K r10, boolean r11) {
        return getSubMap(0, this.keySet.headIndex((K) Preconditions.checkNotNull(r10), r11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> subMap(K r10, boolean r11, K r12, boolean r13) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r12);
        if (comparator().compare(r10, r12) > 0) goto L5;
        boolean r14 = true;
    L6:
        Preconditions.checkArgument(r14, "expected fromKey <= toKey but %s > %s", r10, r12);
        return headMap(r12, r13).tailMap(r10, r11);
    L5:
        r14 = false;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> tailMap(K r10, boolean r11) {
        return getSubMap(this.keySet.tailIndex((K) Preconditions.checkNotNull(r10), r11), size());
    }

    @Beta
    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r10, Comparator<? super K> r11) {
        return fromEntries((Comparator) Preconditions.checkNotNull(r11), false, r10);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r10, Object r11, Comparable r12, Object r13) {
        return ofEntries(new Map.Entry[]{ImmutableMap.entryOf(r10, r11), ImmutableMap.entryOf(r12, r13)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r10, Object r11, Comparable r12, Object r13, Comparable r14, Object r15) {
        return ofEntries(new Map.Entry[]{ImmutableMap.entryOf(r10, r11), ImmutableMap.entryOf(r12, r13), ImmutableMap.entryOf(r14, r15)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r10, Object r11, Comparable r12, Object r13, Comparable r14, Object r15, Comparable r16, Object r17) {
        return ofEntries(new Map.Entry[]{ImmutableMap.entryOf(r10, r11), ImmutableMap.entryOf(r12, r13), ImmutableMap.entryOf(r14, r15), ImmutableMap.entryOf(r16, r17)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r10, Object r11, Comparable r12, Object r13, Comparable r14, Object r15, Comparable r16, Object r17, Comparable r18, Object r19) {
        return ofEntries(new Map.Entry[]{ImmutableMap.entryOf(r10, r11), ImmutableMap.entryOf(r12, r13), ImmutableMap.entryOf(r14, r15), ImmutableMap.entryOf(r16, r17), ImmutableMap.entryOf(r18, r19)});
    }
}
