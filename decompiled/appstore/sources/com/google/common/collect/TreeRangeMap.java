package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {
    private static final RangeMap EMPTY_SUB_RANGE_MAP = null;
    private final NavigableMap<Cut<K>, RangeMapEntry<K, V>> entriesByLowerBound;

    public final class AsMapOfRanges extends Maps.IteratorBasedAbstractMap<Range<K>, V> {
        final Iterable<Map.Entry<Range<K>, V>> entryIterable;
        final /* synthetic */ TreeRangeMap this$0;

        public AsMapOfRanges(TreeRangeMap r10, Iterable<RangeMapEntry<K, V>> r11) {
            this.this$0 = r10;
            this.entryIterable = r11;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object r10) {
            if (get(r10) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<Range<K>, V>> entryIterator() {
            return this.entryIterable.iterator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@NullableDecl Object r10) {
            if ((r10 instanceof Range) == false) goto L10;
            Range r11 = (Range) r10;
            RangeMapEntry r12 = (RangeMapEntry) TreeRangeMap.access$000(this.this$0).get(r11.lowerBound);
            if (r12 != null) goto L7;
            return null;
        L7:
            if (r12.getKey().equals(r11) == true) goto L9;
            return null;
        L9:
            return (V) r12.getValue();
        L10:
            return null;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return TreeRangeMap.access$000(this.this$0).size();
        }
    }

    public static final class RangeMapEntry<K extends Comparable, V> extends AbstractMapEntry<Range<K>, V> {
        private final Range<K> range;
        private final V value;

        public RangeMapEntry(Cut<K> r10, Cut<K> r11, V r12) {
            this(Range.create(r10, r11), r12);
        }

        public boolean contains(K r10) {
            return this.range.contains(r10);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public /* bridge */ /* synthetic */ Object getKey() {
            return getKey();
        }

        public Cut<K> getLowerBound() {
            return (Cut<K>) this.range.lowerBound;
        }

        public Cut<K> getUpperBound() {
            return (Cut<K>) this.range.upperBound;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        public RangeMapEntry(Range<K> r10, V r11) {
            this.range = r10;
            this.value = r11;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Range<K> getKey() {
            return this.range;
        }
    }

    public class SubRangeMap implements RangeMap<K, V> {
        private final Range<K> subRange;
        final /* synthetic */ TreeRangeMap this$0;

        public class SubRangeMapAsMap extends AbstractMap<Range<K>, V> {
            final /* synthetic */ SubRangeMap this$1;

            public SubRangeMapAsMap(SubRangeMap r10) {
                this.this$1 = r10;
            }

            public static /* synthetic */ boolean access$400(SubRangeMapAsMap r10, Predicate r11) {
                return r10.removeEntryIf(r11);
            }

            private boolean removeEntryIf(Predicate<? super Map.Entry<Range<K>, V>> r10) {
                ArrayList r11 = Lists.newArrayList();
                Iterator<Map.Entry<Range<K>, V>> r12 = entrySet().iterator();
            L4:
                if (r12.hasNext() == false) goto L8;
                Map.Entry<Range<K>, V> r13 = r12.next();
                if (r10.apply(r13) == false) goto L4;
                r11.add(r13.getKey());
                goto L4
            L8:
                Iterator r14 = r11.iterator();
            L10:
                if (r14.hasNext() == false) goto L13;
                this.this$1.this$0.remove((Range) r14.next());
                goto L10
            L13:
                return !r11.isEmpty();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public void clear() {
                this.this$1.clear();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public boolean containsKey(Object r10) {
                if (get(r10) == null) goto L5;
                return true;
            L5:
                return false;
            }

            public Iterator<Map.Entry<Range<K>, V>> entryIterator() {
                if (SubRangeMap.access$300(this.this$1).isEmpty() == true) goto L5;
                Cut r10 = (Cut) MoreObjects.firstNonNull(TreeRangeMap.access$000(this.this$1.this$0).floorKey(SubRangeMap.access$300(this.this$1).lowerBound), SubRangeMap.access$300(this.this$1).lowerBound);
                final Iterator<V> r11 = TreeRangeMap.access$000(this.this$1.this$0).tailMap(r10, true).values().iterator();
                return new AnonymousClass3(this, r11);
            L5:
                return Iterators.emptyIterator();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Map.Entry<Range<K>, V>> entrySet() {
                return new AnonymousClass2(this);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.util.AbstractMap, java.util.Map
            public V get(Object r10) {
                if ((r10 instanceof Range) == false) goto L24;
                Range r11 = (Range) r10;     // Catch: ClassCastException -> L25
                if (SubRangeMap.access$300(this.this$1).encloses(r11) == false) goto L24;
                if (r11.isEmpty() == true) goto L24;
                if (r11.lowerBound.compareTo(SubRangeMap.access$300(this.this$1).lowerBound) != 0) goto L16;
                Map.Entry r12 = TreeRangeMap.access$000(this.this$1.this$0).floorEntry(r11.lowerBound);     // Catch: ClassCastException -> L25
                if (r12 == null) goto L15;
                RangeMapEntry r13 = (RangeMapEntry) r12.getValue();     // Catch: ClassCastException -> L25
            L17:
                if (r13 == null) goto L24;
                if (r13.getKey().isConnected(SubRangeMap.access$300(this.this$1)) == false) goto L24;
                if (r13.getKey().intersection(SubRangeMap.access$300(this.this$1)).equals(r11) == false) goto L24;
                return (V) r13.getValue();
            L15:
                r13 = null;
                goto L17
            L16:
                r13 = (RangeMapEntry) TreeRangeMap.access$000(this.this$1.this$0).get(r11.lowerBound);     // Catch: ClassCastException -> L25
            L24:
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Range<K>> keySet() {
                return new AnonymousClass1(this, this);
            }

            @Override // java.util.AbstractMap, java.util.Map
            public V remove(Object r10) {
                V r11 = (V) get(r10);
                if (r11 == null) goto L6;
                TreeRangeMap r12 = this.this$1.this$0;
                r12.remove((Range) r10);
                return r11;
            L6:
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Collection<V> values() {
                return new AnonymousClass4(this, this);
            }
        }

        public SubRangeMap(TreeRangeMap r10, Range<K> r11) {
            this.this$0 = r10;
            this.subRange = r11;
        }

        public static /* synthetic */ Range access$300(SubRangeMap r10) {
            return r10.subRange;
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range<K>, V> asDescendingMapOfRanges() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range<K>, V> asMapOfRanges() {
            return new SubRangeMapAsMap(this);
        }

        @Override // com.google.common.collect.RangeMap
        public void clear() {
            this.this$0.remove(this.subRange);
        }

        @Override // com.google.common.collect.RangeMap
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof RangeMap) == true) goto L5;
            return false;
        L5:
            return asMapOfRanges().equals(((RangeMap) r10).asMapOfRanges());
        }

        @Override // com.google.common.collect.RangeMap
        @NullableDecl
        public V get(K r10) {
            if (this.subRange.contains(r10) == true) goto L7;
            return null;
        L7:
            return (V) this.this$0.get(r10);
        }

        @Override // com.google.common.collect.RangeMap
        @NullableDecl
        public Map.Entry<Range<K>, V> getEntry(K r10) {
            if (this.subRange.contains(r10) == false) goto L8;
            Map.Entry<Range<K>, V> r11 = this.this$0.getEntry(r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return Maps.immutableEntry(r11.getKey().intersection(this.subRange), r11.getValue());
        L8:
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        public int hashCode() {
            return asMapOfRanges().hashCode();
        }

        @Override // com.google.common.collect.RangeMap
        public void put(Range<K> r10, V r11) {
            Preconditions.checkArgument(this.subRange.encloses(r10), "Cannot put range %s into a subRangeMap(%s)", r10, this.subRange);
            this.this$0.put(r10, r11);
        }

        @Override // com.google.common.collect.RangeMap
        public void putAll(RangeMap<K, V> r10) {
            if (r10.asMapOfRanges().isEmpty() == false) goto L5;
            return;
        L5:
            Range<K> r11 = r10.span();
            Preconditions.checkArgument(this.subRange.encloses(r11), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", r11, this.subRange);
            this.this$0.putAll(r10);
        }

        @Override // com.google.common.collect.RangeMap
        public void putCoalescing(Range<K> r10, V r11) {
            if (TreeRangeMap.access$000(this.this$0).isEmpty() == false) goto L5;
        L11:
            put(r10, r11);
            return;
        L5:
            if (r10.isEmpty() == true) goto L11;
            if (this.subRange.encloses(r10) == false) goto L11;
            put(TreeRangeMap.access$100(this.this$0, r10, Preconditions.checkNotNull(r11)).intersection(this.subRange), r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.common.collect.RangeMap
        public void remove(Range<K> r10) {
            if (r10.isConnected(this.subRange) == false) goto L6;
            this.this$0.remove(r10.intersection(this.subRange));
            return;
        }

        @Override // com.google.common.collect.RangeMap
        public Range<K> span() {
            Map.Entry r10 = TreeRangeMap.access$000(this.this$0).floorEntry(this.subRange.lowerBound);
            if (r10 != null) goto L5;
        L7:
            Cut r11 = (Cut) TreeRangeMap.access$000(this.this$0).ceilingKey(this.subRange.lowerBound);
            if (r11 == null) goto L22;
            if (r11.compareTo(this.subRange.upperBound) >= 0) goto L22;
        L11:
            Map.Entry r12 = TreeRangeMap.access$000(this.this$0).lowerEntry(this.subRange.upperBound);
            if (r12 == null) goto L20;
            if (((RangeMapEntry) r12.getValue()).getUpperBound().compareTo(this.subRange.upperBound) < 0) goto L16;
            Cut r13 = this.subRange.upperBound;
        L18:
            return Range.create(r11, r13);
        L16:
            r13 = ((RangeMapEntry) r12.getValue()).getUpperBound();
            goto L18
        L20:
            throw new NoSuchElementException();
        L22:
            throw new NoSuchElementException();
        L5:
            if (((RangeMapEntry) r10.getValue()).getUpperBound().compareTo(this.subRange.lowerBound) <= 0) goto L7;
            r11 = this.subRange.lowerBound;
            goto L11
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.common.collect.RangeMap
        public RangeMap<K, V> subRangeMap(Range<K> r10) {
            if (r10.isConnected(this.subRange) == true) goto L7;
            return TreeRangeMap.access$200(this.this$0);
        L7:
            return this.this$0.subRangeMap(r10.intersection(this.subRange));
        }

        @Override // com.google.common.collect.RangeMap
        public String toString() {
            return asMapOfRanges().toString();
        }
    }

    static {
        EMPTY_SUB_RANGE_MAP = new AnonymousClass1();
    }

    private TreeRangeMap() {
        this.entriesByLowerBound = Maps.newTreeMap();
    }

    public static /* synthetic */ NavigableMap access$000(TreeRangeMap r10) {
        return r10.entriesByLowerBound;
    }

    public static /* synthetic */ Range access$100(TreeRangeMap r10, Range r11, Object r12) {
        return r10.coalescedRange(r11, r12);
    }

    public static /* synthetic */ RangeMap access$200(TreeRangeMap r10) {
        return r10.emptySubRangeMap();
    }

    private static <K extends Comparable, V> Range<K> coalesce(Range<K> r10, V r11, @NullableDecl Map.Entry<Cut<K>, RangeMapEntry<K, V>> r12) {
        if (r12 != null) goto L4;
        return r10;
    L4:
        if (r12.getValue().getKey().isConnected(r10) == true) goto L6;
        return r10;
    L6:
        if (r12.getValue().getValue().equals(r11) == true) goto L8;
        return r10;
    L8:
        return (Range<K>) r10.span(r12.getValue().getKey());
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private Range<K> coalescedRange(Range<K> r10, V r11) {
        return coalesce(coalesce(r10, r11, this.entriesByLowerBound.lowerEntry((Cut<K>) r10.lowerBound)), r11, this.entriesByLowerBound.floorEntry((Cut<K>) r10.upperBound));
    }

    public static <K extends Comparable, V> TreeRangeMap<K, V> create() {
        return new TreeRangeMap();
    }

    private RangeMap<K, V> emptySubRangeMap() {
        return EMPTY_SUB_RANGE_MAP;
    }

    private void putRangeMapEntry(Cut<K> r10, Cut<K> r11, V r12) {
        this.entriesByLowerBound.put(r10, new RangeMapEntry(r10, r11, r12));
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asDescendingMapOfRanges() {
        return new AsMapOfRanges(this, this.entriesByLowerBound.descendingMap().values());
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asMapOfRanges() {
        return new AsMapOfRanges(this, this.entriesByLowerBound.values());
    }

    @Override // com.google.common.collect.RangeMap
    public void clear() {
        this.entriesByLowerBound.clear();
    }

    @Override // com.google.common.collect.RangeMap
    public boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof RangeMap) == true) goto L5;
        return false;
    L5:
        return asMapOfRanges().equals(((RangeMap) r10).asMapOfRanges());
    }

    @Override // com.google.common.collect.RangeMap
    @NullableDecl
    public V get(K r10) {
        Map.Entry<Range<K>, V> r11 = getEntry(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        return r11.getValue();
    }

    @Override // com.google.common.collect.RangeMap
    @NullableDecl
    public Map.Entry<Range<K>, V> getEntry(K r10) {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> r11 = this.entriesByLowerBound.floorEntry(Cut.belowValue(r10));
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.getValue().contains(r10) == true) goto L7;
        return null;
    L7:
        return r11.getValue();
    }

    @Override // com.google.common.collect.RangeMap
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    public void put(Range<K> r10, V r11) {
        if (r10.isEmpty() == true) goto L6;
        Preconditions.checkNotNull(r11);
        remove(r10);
        this.entriesByLowerBound.put(r10.lowerBound, new RangeMapEntry(r10, r11));
        return;
    }

    @Override // com.google.common.collect.RangeMap
    public void putAll(RangeMap<K, V> r10) {
        Iterator<Map.Entry<Range<K>, V>> r11 = r10.asMapOfRanges().entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<Range<K>, V> r12 = r11.next();
        put(r12.getKey(), r12.getValue());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeMap
    public void putCoalescing(Range<K> r10, V r11) {
        if (this.entriesByLowerBound.isEmpty() == false) goto L6;
        put(r10, r11);
        return;
    L6:
        put(coalescedRange(r10, Preconditions.checkNotNull(r11)), r11);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.common.collect.RangeMap
    public void remove(Range<K> r10) {
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> r11 = this.entriesByLowerBound.lowerEntry((Cut<K>) r10.lowerBound);
        if (r11 == null) goto L13;
        RangeMapEntry<K, V> r12 = r11.getValue();
        if (r12.getUpperBound().compareTo(r10.lowerBound) <= 0) goto L13;
        if (r12.getUpperBound().compareTo(r10.upperBound) <= 0) goto L12;
        putRangeMapEntry(r10.upperBound, r12.getUpperBound(), r11.getValue().getValue());
    L12:
        putRangeMapEntry(r12.getLowerBound(), r10.lowerBound, r11.getValue().getValue());
    L13:
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> r13 = this.entriesByLowerBound.lowerEntry((Cut<K>) r10.upperBound);
        if (r13 == null) goto L18;
        RangeMapEntry<K, V> r14 = r13.getValue();
        if (r14.getUpperBound().compareTo(r10.upperBound) <= 0) goto L18;
        putRangeMapEntry(r10.upperBound, r14.getUpperBound(), r13.getValue().getValue());
    L18:
        NavigableMap<Cut<K>, RangeMapEntry<K, V>> r15 = this.entriesByLowerBound;
        Cut<C> r16 = r10.lowerBound;
        r15.subMap((Cut<K>) r16, (Cut<K>) r10.upperBound).clear();
    }

    @Override // com.google.common.collect.RangeMap
    public Range<K> span() {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> r10 = this.entriesByLowerBound.firstEntry();
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> r11 = this.entriesByLowerBound.lastEntry();
        if (r10 == null) goto L7;
        return Range.create(r10.getValue().getKey().lowerBound, r11.getValue().getKey().upperBound);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeMap
    public RangeMap<K, V> subRangeMap(Range<K> r10) {
        if (r10.equals(Range.all()) == false) goto L6;
        return this;
    L6:
        return new SubRangeMap(this, r10);
    }

    @Override // com.google.common.collect.RangeMap
    public String toString() {
        return this.entriesByLowerBound.values().toString();
    }
}
