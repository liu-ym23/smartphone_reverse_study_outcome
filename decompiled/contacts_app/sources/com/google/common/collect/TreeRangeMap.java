package com.google.common.collect;

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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {
    private static final RangeMap EMPTY_SUB_RANGE_MAP = null;
    private final NavigableMap<Cut<K>, RangeMapEntry<K, V>> entriesByLowerBound;

    private final class AsMapOfRanges extends AbstractMap<Range<K>, V> {
        final /* synthetic */ TreeRangeMap this$0;

        private AsMapOfRanges(TreeRangeMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AsMapOfRanges(TreeRangeMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object r1) {
            if (get(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@Nullable Object r2) {
            if ((r2 instanceof Range) == false) goto L10;
            Range r3 = (Range) r2;
            RangeMapEntry r1 = (RangeMapEntry) TreeRangeMap.access$100(this.this$0).get(r3.lowerBound);
            if (r1 != null) goto L7;
            return null;
        L7:
            if (r1.getKey().equals(r3) == true) goto L9;
            return null;
        L9:
            return (V) r1.getValue();
        L10:
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<Range<K>, V>> entrySet() {
            return new AnonymousClass1(this);
        }
    }

    private static final class RangeMapEntry<K extends Comparable, V> extends AbstractMapEntry<Range<K>, V> {
        private final Range<K> range;
        private final V value;

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public /* bridge */ /* synthetic */ Object getKey() {
            return getKey();
        }

        RangeMapEntry(Cut<K> r1, Cut<K> r2, V r3) {
            this(Range.create(r1, r2), r3);
        }

        RangeMapEntry(Range<K> r1, V r2) {
            this.range = r1;
            this.value = r2;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Range<K> getKey() {
            return this.range;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        public boolean contains(K r1) {
            return this.range.contains(r1);
        }

        Cut<K> getLowerBound() {
            return (Cut<K>) this.range.lowerBound;
        }

        Cut<K> getUpperBound() {
            return (Cut<K>) this.range.upperBound;
        }
    }

    private class SubRangeMap implements RangeMap<K, V> {
        private final Range<K> subRange;
        final /* synthetic */ TreeRangeMap this$0;

        class SubRangeMapAsMap extends AbstractMap<Range<K>, V> {
            final /* synthetic */ SubRangeMap this$1;

            SubRangeMapAsMap(SubRangeMap r1) {
                this.this$1 = r1;
            }

            static /* synthetic */ boolean access$400(SubRangeMapAsMap r0, Predicate r1) {
                return r0.removeEntryIf(r1);
            }

            @Override // java.util.AbstractMap, java.util.Map
            public boolean containsKey(Object r1) {
                if (get(r1) == null) goto L5;
                return true;
            L5:
                return false;
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
            public V get(Object r5) {
                if ((r5 instanceof Range) == false) goto L24;
                Range r6 = (Range) r5;     // Catch: ClassCastException -> L25
                if (SubRangeMap.access$300(this.this$1).encloses(r6) == false) goto L24;
                if (r6.isEmpty() == true) goto L24;
                if (r6.lowerBound.compareTo(SubRangeMap.access$300(this.this$1).lowerBound) != 0) goto L16;
                Map.Entry r1 = TreeRangeMap.access$100(this.this$1.this$0).floorEntry(r6.lowerBound);     // Catch: ClassCastException -> L25
                if (r1 == null) goto L15;
                RangeMapEntry r2 = (RangeMapEntry) r1.getValue();     // Catch: ClassCastException -> L25
            L17:
                if (r2 == null) goto L24;
                if (r2.getKey().isConnected(SubRangeMap.access$300(this.this$1)) == false) goto L24;
                if (r2.getKey().intersection(SubRangeMap.access$300(this.this$1)).equals(r6) == false) goto L24;
                return (V) r2.getValue();
            L15:
                r2 = null;
                goto L17
            L16:
                r2 = (RangeMapEntry) TreeRangeMap.access$100(this.this$1.this$0).get(r6.lowerBound);     // Catch: ClassCastException -> L25
            L24:
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public V remove(Object r2) {
                V r0 = (V) get(r2);
                if (r0 == null) goto L6;
                TreeRangeMap r1 = this.this$1.this$0;
                r1.remove((Range) r2);
                return r0;
            L6:
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public void clear() {
                this.this$1.clear();
            }

            private boolean removeEntryIf(Predicate<? super Map.Entry<Range<K>, V>> r5) {
                ArrayList r0 = Lists.newArrayList();
                Iterator<Map.Entry<Range<K>, V>> r1 = entrySet().iterator();
            L4:
                if (r1.hasNext() == false) goto L8;
                Map.Entry<Range<K>, V> r2 = r1.next();
                if (r5.apply(r2) == false) goto L4;
                r0.add(r2.getKey());
                goto L4
            L8:
                Iterator r6 = r0.iterator();
            L10:
                if (r6.hasNext() == false) goto L13;
                this.this$1.this$0.remove((Range) r6.next());
                goto L10
            L13:
                return !r0.isEmpty();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Range<K>> keySet() {
                return new AnonymousClass1(this, this);
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Map.Entry<Range<K>, V>> entrySet() {
                return new AnonymousClass2(this);
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Collection<V> values() {
                return new AnonymousClass3(this, this);
            }
        }

        static /* synthetic */ Range access$300(SubRangeMap r0) {
            return r0.subRange;
        }

        SubRangeMap(TreeRangeMap r1, Range<K> r2) {
            this.this$0 = r1;
            this.subRange = r2;
        }

        @Override // com.google.common.collect.RangeMap
        @Nullable
        public V get(K r2) {
            if (this.subRange.contains(r2) == true) goto L7;
            return null;
        L7:
            return (V) this.this$0.get(r2);
        }

        @Override // com.google.common.collect.RangeMap
        @Nullable
        public Map.Entry<Range<K>, V> getEntry(K r2) {
            if (this.subRange.contains(r2) == false) goto L8;
            Map.Entry<Range<K>, V> r3 = this.this$0.getEntry(r2);
            if (r3 != null) goto L7;
            return null;
        L7:
            return Maps.immutableEntry(r3.getKey().intersection(this.subRange), r3.getValue());
        L8:
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        public Range<K> span() {
            Map.Entry r0 = TreeRangeMap.access$100(this.this$0).floorEntry(this.subRange.lowerBound);
            if (r0 != null) goto L5;
        L7:
            Cut r1 = (Cut) TreeRangeMap.access$100(this.this$0).ceilingKey(this.subRange.lowerBound);
            if (r1 == null) goto L22;
            if (r1.compareTo(this.subRange.upperBound) >= 0) goto L22;
        L11:
            Map.Entry r2 = TreeRangeMap.access$100(this.this$0).lowerEntry(this.subRange.upperBound);
            if (r2 == null) goto L20;
            if (((RangeMapEntry) r2.getValue()).getUpperBound().compareTo(this.subRange.upperBound) < 0) goto L16;
            Cut r4 = this.subRange.upperBound;
        L18:
            return Range.create(r1, r4);
        L16:
            r4 = ((RangeMapEntry) r2.getValue()).getUpperBound();
            goto L18
        L20:
            throw new NoSuchElementException();
        L22:
            throw new NoSuchElementException();
        L5:
            if (((RangeMapEntry) r0.getValue()).getUpperBound().compareTo(this.subRange.lowerBound) <= 0) goto L7;
            r1 = this.subRange.lowerBound;
            goto L11
        }

        @Override // com.google.common.collect.RangeMap
        public void put(Range<K> r5, V r6) {
            Preconditions.checkArgument(this.subRange.encloses(r5), "Cannot put range %s into a subRangeMap(%s)", new Object[]{r5, this.subRange});
            this.this$0.put(r5, r6);
        }

        @Override // com.google.common.collect.RangeMap
        public void putAll(RangeMap<K, V> r5) {
            if (r5.asMapOfRanges().isEmpty() == false) goto L5;
            return;
        L5:
            Range<K> r0 = r5.span();
            Preconditions.checkArgument(this.subRange.encloses(r0), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", new Object[]{r0, this.subRange});
            this.this$0.putAll(r5);
        }

        @Override // com.google.common.collect.RangeMap
        public void clear() {
            this.this$0.remove(this.subRange);
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
        public void remove(Range<K> r2) {
            if (r2.isConnected(this.subRange) == false) goto L6;
            this.this$0.remove(r2.intersection(this.subRange));
            return;
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
        public RangeMap<K, V> subRangeMap(Range<K> r2) {
            if (r2.isConnected(this.subRange) == true) goto L7;
            return TreeRangeMap.access$200(this.this$0);
        L7:
            return this.this$0.subRangeMap(r2.intersection(this.subRange));
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range<K>, V> asMapOfRanges() {
            return new SubRangeMapAsMap(this);
        }

        @Override // com.google.common.collect.RangeMap
        public boolean equals(@Nullable Object r2) {
            if ((r2 instanceof RangeMap) == true) goto L5;
            return false;
        L5:
            return asMapOfRanges().equals(((RangeMap) r2).asMapOfRanges());
        }

        @Override // com.google.common.collect.RangeMap
        public int hashCode() {
            return asMapOfRanges().hashCode();
        }

        @Override // com.google.common.collect.RangeMap
        public String toString() {
            return asMapOfRanges().toString();
        }
    }

    static /* synthetic */ NavigableMap access$100(TreeRangeMap r0) {
        return r0.entriesByLowerBound;
    }

    static /* synthetic */ RangeMap access$200(TreeRangeMap r0) {
        return r0.emptySubRangeMap();
    }

    public static <K extends Comparable, V> TreeRangeMap<K, V> create() {
        return new TreeRangeMap();
    }

    private TreeRangeMap() {
        this.entriesByLowerBound = Maps.newTreeMap();
    }

    @Override // com.google.common.collect.RangeMap
    @Nullable
    public V get(K r1) {
        Map.Entry<Range<K>, V> r0 = getEntry(r1);
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getValue();
    }

    @Override // com.google.common.collect.RangeMap
    @Nullable
    public Map.Entry<Range<K>, V> getEntry(K r2) {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> r1 = this.entriesByLowerBound.floorEntry(Cut.belowValue(r2));
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.getValue().contains(r2) == true) goto L7;
        return null;
    L7:
        return r1.getValue();
    }

    @Override // com.google.common.collect.RangeMap
    public void put(Range<K> r3, V r4) {
        if (r3.isEmpty() == true) goto L6;
        Preconditions.checkNotNull(r4);
        remove(r3);
        this.entriesByLowerBound.put(r3.lowerBound, new RangeMapEntry(r3, r4));
        return;
    }

    @Override // com.google.common.collect.RangeMap
    public void putAll(RangeMap<K, V> r3) {
        Iterator<Map.Entry<Range<K>, V>> r4 = r3.asMapOfRanges().entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<Range<K>, V> r0 = r4.next();
        put(r0.getKey(), r0.getValue());
        goto L4
    }

    @Override // com.google.common.collect.RangeMap
    public void clear() {
        this.entriesByLowerBound.clear();
    }

    @Override // com.google.common.collect.RangeMap
    public Range<K> span() {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> r0 = this.entriesByLowerBound.firstEntry();
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> r1 = this.entriesByLowerBound.lastEntry();
        if (r0 == null) goto L7;
        return Range.create(r0.getValue().getKey().lowerBound, r1.getValue().getKey().upperBound);
    L7:
        throw new NoSuchElementException();
    }

    private void putRangeMapEntry(Cut<K> r2, Cut<K> r3, V r4) {
        this.entriesByLowerBound.put(r2, new RangeMapEntry(r2, r3, r4));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.common.collect.RangeMap
    public void remove(Range<K> r6) {
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> r0 = this.entriesByLowerBound.lowerEntry((Cut<K>) r6.lowerBound);
        if (r0 == null) goto L13;
        RangeMapEntry<K, V> r1 = r0.getValue();
        if (r1.getUpperBound().compareTo(r6.lowerBound) <= 0) goto L13;
        if (r1.getUpperBound().compareTo(r6.upperBound) <= 0) goto L12;
        putRangeMapEntry(r6.upperBound, r1.getUpperBound(), r0.getValue().getValue());
    L12:
        putRangeMapEntry(r1.getLowerBound(), r6.lowerBound, r0.getValue().getValue());
    L13:
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> r2 = this.entriesByLowerBound.lowerEntry((Cut<K>) r6.upperBound);
        if (r2 == null) goto L18;
        RangeMapEntry<K, V> r3 = r2.getValue();
        if (r3.getUpperBound().compareTo(r6.upperBound) <= 0) goto L18;
        putRangeMapEntry(r6.upperBound, r3.getUpperBound(), r2.getValue().getValue());
        this.entriesByLowerBound.remove(r6.lowerBound);
    L18:
        NavigableMap<Cut<K>, RangeMapEntry<K, V>> r5 = this.entriesByLowerBound;
        Cut<C> r4 = r6.lowerBound;
        r5.subMap((Cut<K>) r4, (Cut<K>) r6.upperBound).clear();
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asMapOfRanges() {
        return new AsMapOfRanges(this, null);
    }

    @Override // com.google.common.collect.RangeMap
    public RangeMap<K, V> subRangeMap(Range<K> r2) {
        if (r2.equals(Range.all()) == false) goto L6;
        return this;
    L6:
        return new SubRangeMap(this, r2);
    }

    private RangeMap<K, V> emptySubRangeMap() {
        return EMPTY_SUB_RANGE_MAP;
    }

    static {
        EMPTY_SUB_RANGE_MAP = new AnonymousClass1();
    }

    @Override // com.google.common.collect.RangeMap
    public boolean equals(@Nullable Object r2) {
        if ((r2 instanceof RangeMap) == true) goto L5;
        return false;
    L5:
        return asMapOfRanges().equals(((RangeMap) r2).asMapOfRanges());
    }

    @Override // com.google.common.collect.RangeMap
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    public String toString() {
        return this.entriesByLowerBound.values().toString();
    }
}
