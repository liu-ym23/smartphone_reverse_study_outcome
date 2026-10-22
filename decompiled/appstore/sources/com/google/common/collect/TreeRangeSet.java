package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public class TreeRangeSet<C extends Comparable<?>> extends AbstractRangeSet<C> implements Serializable {

    @MonotonicNonNullDecl
    private transient Set<Range<C>> asDescendingSetOfRanges;

    @MonotonicNonNullDecl
    private transient Set<Range<C>> asRanges;

    @MonotonicNonNullDecl
    private transient RangeSet<C> complement;

    @VisibleForTesting
    final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* JADX INFO: renamed from: com.google.common.collect.TreeRangeSet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public final class AsRanges extends ForwardingCollection<Range<C>> implements Set<Range<C>> {
        final Collection<Range<C>> delegate;
        final /* synthetic */ TreeRangeSet this$0;

        public AsRanges(TreeRangeSet r10, Collection<Range<C>> r11) {
            this.this$0 = r10;
            this.delegate = r11;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object r10) {
            return Sets.equalsImpl(this, r10);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection<Range<C>> delegate() {
            return this.delegate;
        }
    }

    public final class Complement extends TreeRangeSet<C> {
        final /* synthetic */ TreeRangeSet this$0;

        public Complement(TreeRangeSet r10) {
            this.this$0 = r10;
            super(new ComplementRangesByLowerBound(r10.rangesByLowerBound), null);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void add(Range<C> r10) {
            this.this$0.remove(r10);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public RangeSet<C> complement() {
            return this.this$0;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public boolean contains(C r10) {
            return !this.this$0.contains(r10);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void remove(Range<C> r10) {
            this.this$0.add(r10);
        }
    }

    public static final class ComplementRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
        private final Range<Cut<C>> complementLowerBoundWindow;
        private final NavigableMap<Cut<C>, Range<C>> positiveRangesByLowerBound;
        private final NavigableMap<Cut<C>, Range<C>> positiveRangesByUpperBound;

        public ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> r10) {
            this(r10, Range.all());
        }

        public static /* synthetic */ Range access$100(ComplementRangesByLowerBound r10) {
            return r10.complementLowerBoundWindow;
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r10) {
            if (get(r10) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public Iterator<Map.Entry<Cut<C>, Range<C>>> descendingEntryIterator() {
            if (this.complementLowerBoundWindow.hasUpperBound() == false) goto L5;
            Cut<C> r10 = (Cut) this.complementLowerBoundWindow.upperEndpoint();
        L7:
            if (this.complementLowerBoundWindow.hasUpperBound() == true) goto L9;
        L11:
            boolean r11 = false;
        L12:
            final PeekingIterator r12 = Iterators.peekingIterator(this.positiveRangesByUpperBound.headMap(r10, r11).descendingMap().values().iterator());
            if (r12.hasNext() == false) goto L19;
            if (((Range) r12.peek()).upperBound != Cut.aboveAll()) goto L17;
            Cut<C> r13 = ((Range) r12.next()).lowerBound;
        L24:
            final Cut r14 = (Cut) MoreObjects.firstNonNull(r13, Cut.aboveAll());
            return new AnonymousClass2(this, r14, r12);
        L17:
            r13 = this.positiveRangesByLowerBound.higherKey(((Range) r12.peek()).upperBound);
            goto L24
        L19:
            if (this.complementLowerBoundWindow.contains(Cut.belowAll()) == false) goto L27;
            if (this.positiveRangesByLowerBound.containsKey(Cut.belowAll()) == true) goto L27;
            r13 = this.positiveRangesByLowerBound.higherKey(Cut.belowAll());
        L27:
            return Iterators.emptyIterator();
        L9:
            if (this.complementLowerBoundWindow.upperBoundType() != BoundType.CLOSED) goto L11;
            r11 = true;
            goto L12
        L5:
            r10 = Cut.aboveAll();
            goto L7
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
            if (this.complementLowerBoundWindow.hasLowerBound() == false) goto L9;
            NavigableMap<Cut<C>, Range<C>> r10 = this.positiveRangesByUpperBound;
            Comparable r11 = this.complementLowerBoundWindow.lowerEndpoint();
            if (this.complementLowerBoundWindow.lowerBoundType() != BoundType.CLOSED) goto L7;
            boolean r12 = true;
        L8:
            Collection<Range<C>> r13 = r10.tailMap((Cut<C>) r11, r12).values();
        L10:
            final PeekingIterator r14 = Iterators.peekingIterator(r13.iterator());
            if (this.complementLowerBoundWindow.contains(Cut.belowAll()) == false) goto L18;
            if (r14.hasNext() == true) goto L15;
        L16:
            final Cut r15 = Cut.belowAll();
        L21:
            return new AnonymousClass1(this, r15, r14);
        L15:
            if (((Range) r14.peek()).lowerBound != Cut.belowAll()) goto L16;
        L18:
            if (r14.hasNext() == false) goto L23;
            r15 = ((Range) r14.next()).upperBound;
            goto L21
        L23:
            return Iterators.emptyIterator();
        L7:
            r12 = false;
            goto L8
        L9:
            r13 = this.positiveRangesByUpperBound.values();
            goto L10
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @NullableDecl
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return get(r10);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap headMap(Object r10, boolean r11) {
            return headMap((Cut) r10, r11);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.size(entryIterator());
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap subMap(Object r10, boolean r11, Object r12, boolean r13) {
            return subMap((Cut) r10, r11, (Cut) r12, r13);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap tailMap(Object r10, boolean r11) {
            return tailMap((Cut) r10, r11);
        }

        private ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> r10, Range<Cut<C>> r11) {
            this.positiveRangesByLowerBound = r10;
            this.positiveRangesByUpperBound = new RangesByUpperBound(r10);
            this.complementLowerBoundWindow = r11;
        }

        private NavigableMap<Cut<C>, Range<C>> subMap(Range<Cut<C>> r10) {
            if (this.complementLowerBoundWindow.isConnected(r10) == false) goto L5;
            Range<C> r11 = r10.intersection(this.complementLowerBoundWindow);
            return new ComplementRangesByLowerBound(this.positiveRangesByLowerBound, r11);
        L5:
            return ImmutableSortedMap.of();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @NullableDecl
        public Range<C> get(Object r10) {
            if ((r10 instanceof Cut) == true) goto L12;
        L10:
            return null;
        L12:
            Cut<C> r11 = (Cut) r10;     // Catch: ClassCastException -> L11
            Map.Entry<Cut<C>, Range<C>> r12 = tailMap(r11, true).firstEntry();     // Catch: ClassCastException -> L11
            if (r12 == null) goto L10;
            if (r12.getKey().equals(r11) == false) goto L10;
            return r12.getValue();
        }

        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> r10, boolean r11) {
            return subMap(Range.upTo(r10, BoundType.forBoolean(r11)));
        }

        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> r10, boolean r11) {
            return subMap(Range.downTo(r10, BoundType.forBoolean(r11)));
        }

        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> r10, boolean r11, Cut<C> r12, boolean r13) {
            return subMap(Range.range(r10, BoundType.forBoolean(r11), r12, BoundType.forBoolean(r13)));
        }
    }

    @VisibleForTesting
    public static final class RangesByUpperBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
        private final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;
        private final Range<Cut<C>> upperBoundWindow;

        public RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> r10) {
            this.rangesByLowerBound = r10;
            this.upperBoundWindow = Range.all();
        }

        public static /* synthetic */ Range access$000(RangesByUpperBound r10) {
            return r10.upperBoundWindow;
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object r10) {
            if (get(r10) == null) goto L5;
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
        @Override // com.google.common.collect.AbstractNavigableMap
        public Iterator<Map.Entry<Cut<C>, Range<C>>> descendingEntryIterator() {
            if (this.upperBoundWindow.hasUpperBound() == false) goto L5;
            Collection<Range<C>> r10 = this.rangesByLowerBound.headMap(this.upperBoundWindow.upperEndpoint(), false).descendingMap().values();
        L6:
            final PeekingIterator r11 = Iterators.peekingIterator(r10.iterator());
            if (r11.hasNext() == false) goto L12;
            if (this.upperBoundWindow.upperBound.isLessThan(((Range) r11.peek()).upperBound) == false) goto L12;
            r11.next();
        L12:
            return new AnonymousClass2(this, r11);
        L5:
            r10 = this.rangesByLowerBound.descendingMap().values();
            goto L6
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
        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
            if (this.upperBoundWindow.hasLowerBound() == true) goto L5;
            final Iterator<Range<C>> r10 = this.rangesByLowerBound.values().iterator();
        L13:
            return new AnonymousClass1(this, r10);
        L5:
            Map.Entry r11 = this.rangesByLowerBound.lowerEntry((Cut<C>) this.upperBoundWindow.lowerEndpoint());
            if (r11 != null) goto L9;
            r10 = this.rangesByLowerBound.values().iterator();
            goto L13
        L9:
            if (this.upperBoundWindow.lowerBound.isLessThan(((Range) r11.getValue()).upperBound) == false) goto L11;
            r10 = this.rangesByLowerBound.tailMap(r11.getKey(), true).values().iterator();
            goto L13
        L11:
            r10 = this.rangesByLowerBound.tailMap(this.upperBoundWindow.lowerEndpoint(), true).values().iterator();
            goto L13
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object get(@NullableDecl Object r10) {
            return get(r10);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap headMap(Object r10, boolean r11) {
            return headMap((Cut) r10, r11);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.upperBoundWindow.equals(Range.all()) == false) goto L6;
            return this.rangesByLowerBound.isEmpty();
        L6:
            if (entryIterator().hasNext() == true) goto L8;
            return true;
        L8:
            return false;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            if (this.upperBoundWindow.equals(Range.all()) == false) goto L7;
            return this.rangesByLowerBound.size();
        L7:
            return Iterators.size(entryIterator());
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap subMap(Object r10, boolean r11, Object r12, boolean r13) {
            return subMap((Cut) r10, r11, (Cut) r12, r13);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap tailMap(Object r10, boolean r11) {
            return tailMap((Cut) r10, r11);
        }

        private NavigableMap<Cut<C>, Range<C>> subMap(Range<Cut<C>> r10) {
            if (r10.isConnected(this.upperBoundWindow) == false) goto L7;
            return new RangesByUpperBound(this.rangesByLowerBound, r10.intersection(this.upperBoundWindow));
        L7:
            return ImmutableSortedMap.of();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        public Range<C> get(@NullableDecl Object r10) {
            if ((r10 instanceof Cut) == true) goto L15;
        L13:
            return null;
        L15:
            Cut<C> r11 = (Cut) r10;     // Catch: ClassCastException -> L14
            if (this.upperBoundWindow.contains(r11) == true) goto L7;
            return null;
        L7:
            Map.Entry<Cut<C>, Range<C>> r12 = this.rangesByLowerBound.lowerEntry(r11);     // Catch: ClassCastException -> L14
            if (r12 == null) goto L13;
            if (r12.getValue().upperBound.equals(r11) == false) goto L13;
            return r12.getValue();
        }

        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> r10, boolean r11) {
            return subMap(Range.upTo(r10, BoundType.forBoolean(r11)));
        }

        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> r10, boolean r11) {
            return subMap(Range.downTo(r10, BoundType.forBoolean(r11)));
        }

        private RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> r10, Range<Cut<C>> r11) {
            this.rangesByLowerBound = r10;
            this.upperBoundWindow = r11;
        }

        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> r10, boolean r11, Cut<C> r12, boolean r13) {
            return subMap(Range.range(r10, BoundType.forBoolean(r11), r12, BoundType.forBoolean(r13)));
        }
    }

    public final class SubRangeSet extends TreeRangeSet<C> {
        private final Range<C> restriction;
        final /* synthetic */ TreeRangeSet this$0;

        public SubRangeSet(TreeRangeSet r10, Range<C> r11) {
            this.this$0 = r10;
            AnonymousClass1 r12 = null;
            super(new SubRangeSetRangesByLowerBound(Range.all(), r11, r10.rangesByLowerBound, r12), r12);
            this.restriction = r11;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void add(Range<C> r10) {
            Preconditions.checkArgument(this.restriction.encloses(r10), "Cannot add range %s to subRangeSet(%s)", r10, this.restriction);
            super.add(r10);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void clear() {
            this.this$0.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public boolean contains(C r10) {
            if (this.restriction.contains(r10) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.this$0.contains(r10) == false) goto L7;
            return true;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public boolean encloses(Range<C> r10) {
            if (this.restriction.isEmpty() == false) goto L5;
            return false;
        L5:
            if (this.restriction.encloses(r10) == false) goto L13;
            Range r11 = TreeRangeSet.access$600(this.this$0, r10);
            if (r11 != null) goto L9;
            return false;
        L9:
            if (r11.intersection(this.restriction).isEmpty() == true) goto L15;
            return true;
        L15:
            return false;
        L13:
            return false;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        @NullableDecl
        public Range<C> rangeContaining(C r10) {
            if (this.restriction.contains(r10) == true) goto L5;
            return null;
        L5:
            Range<C> r11 = this.this$0.rangeContaining(r10);
            if (r11 != null) goto L9;
            return null;
        L9:
            return r11.intersection(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void remove(Range<C> r10) {
            if (r10.isConnected(this.restriction) == false) goto L6;
            this.this$0.remove(r10.intersection(this.restriction));
            return;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public RangeSet<C> subRangeSet(Range<C> r10) {
            if (r10.encloses(this.restriction) == false) goto L6;
            return this;
        L6:
            if (r10.isConnected(this.restriction) == false) goto L10;
            return new SubRangeSet(this, this.restriction.intersection(r10));
        L10:
            return ImmutableRangeSet.of();
        }
    }

    public static final class SubRangeSetRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
        private final Range<Cut<C>> lowerBoundWindow;
        private final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;
        private final NavigableMap<Cut<C>, Range<C>> rangesByUpperBound;
        private final Range<C> restriction;

        public /* synthetic */ SubRangeSetRangesByLowerBound(Range r10, Range r11, NavigableMap r12, AnonymousClass1 r13) {
            this(r10, r11, r12);
        }

        public static /* synthetic */ Range access$300(SubRangeSetRangesByLowerBound r10) {
            return r10.restriction;
        }

        public static /* synthetic */ Range access$400(SubRangeSetRangesByLowerBound r10) {
            return r10.lowerBoundWindow;
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object r10) {
            if (get(r10) == null) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // com.google.common.collect.AbstractNavigableMap
        public Iterator<Map.Entry<Cut<C>, Range<C>>> descendingEntryIterator() {
            if (this.restriction.isEmpty() == true) goto L5;
            Cut r10 = (Cut) Ordering.natural().min(this.lowerBoundWindow.upperBound, Cut.belowValue(this.restriction.upperBound));
            NavigableMap<Cut<C>, Range<C>> r11 = this.rangesByLowerBound;
            Comparable r12 = r10.endpoint();
            if (r10.typeAsUpperBound() != BoundType.CLOSED) goto L9;
            boolean r13 = true;
        L10:
            final Iterator<Range<C>> r14 = r11.headMap((Cut<C>) r12, r13).descendingMap().values().iterator();
            return new AnonymousClass2(this, r14);
        L9:
            r13 = false;
            goto L10
        L5:
            return Iterators.emptyIterator();
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
        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
            if (this.restriction.isEmpty() == false) goto L7;
            return Iterators.emptyIterator();
        L7:
            if (this.lowerBoundWindow.upperBound.isLessThan(this.restriction.lowerBound) == true) goto L9;
            boolean r10 = false;
            if (this.lowerBoundWindow.lowerBound.isLessThan(this.restriction.lowerBound) == false) goto L13;
            final Iterator<Range<C>> r11 = this.rangesByUpperBound.tailMap(this.restriction.lowerBound, false).values().iterator();
        L17:
            final Cut r12 = (Cut) Ordering.natural().min(this.lowerBoundWindow.upperBound, Cut.belowValue(this.restriction.upperBound));
            return new AnonymousClass1(this, r11, r12);
        L13:
            NavigableMap<Cut<C>, Range<C>> r13 = this.rangesByLowerBound;
            Comparable r14 = this.lowerBoundWindow.lowerBound.endpoint();
            if (this.lowerBoundWindow.lowerBoundType() != BoundType.CLOSED) goto L16;
            r10 = true;
        L16:
            r11 = r13.tailMap(r14, r10).values().iterator();
            goto L17
        L9:
            return Iterators.emptyIterator();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @NullableDecl
        public /* bridge */ /* synthetic */ Object get(@NullableDecl Object r10) {
            return get(r10);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap headMap(Object r10, boolean r11) {
            return headMap((Cut) r10, r11);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.size(entryIterator());
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap subMap(Object r10, boolean r11, Object r12, boolean r13) {
            return subMap((Cut) r10, r11, (Cut) r12, r13);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap tailMap(Object r10, boolean r11) {
            return tailMap((Cut) r10, r11);
        }

        private SubRangeSetRangesByLowerBound(Range<Cut<C>> r10, Range<C> r11, NavigableMap<Cut<C>, Range<C>> r12) {
            this.lowerBoundWindow = (Range) Preconditions.checkNotNull(r10);
            this.restriction = (Range) Preconditions.checkNotNull(r11);
            this.rangesByLowerBound = (NavigableMap) Preconditions.checkNotNull(r12);
            this.rangesByUpperBound = new RangesByUpperBound(r12);
        }

        private NavigableMap<Cut<C>, Range<C>> subMap(Range<Cut<C>> r10) {
            if (r10.isConnected(this.lowerBoundWindow) == true) goto L7;
            return ImmutableSortedMap.of();
        L7:
            return new SubRangeSetRangesByLowerBound(this.lowerBoundWindow.intersection(r10), this.restriction, this.rangesByLowerBound);
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
        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @NullableDecl
        public Range<C> get(@NullableDecl Object r10) {
            if ((r10 instanceof Cut) == true) goto L25;
        L23:
            return null;
        L25:
            Cut<C> r11 = (Cut) r10;     // Catch: ClassCastException -> L24
            if (this.lowerBoundWindow.contains(r11) == false) goto L23;
            if (r11.compareTo(this.restriction.lowerBound) < 0) goto L23;
            if (r11.compareTo(this.restriction.upperBound) >= 0) goto L23;
            if (r11.equals(this.restriction.lowerBound) == false) goto L19;
            Range r12 = (Range) Maps.valueOrNull(this.rangesByLowerBound.floorEntry(r11));     // Catch: ClassCastException -> L24
            if (r12 == null) goto L23;
            if (r12.upperBound.compareTo(this.restriction.lowerBound) <= 0) goto L23;
            return r12.intersection(this.restriction);
        L19:
            Range r13 = (Range) this.rangesByLowerBound.get(r11);     // Catch: ClassCastException -> L24
            if (r13 == null) goto L23;
            return r13.intersection(this.restriction);
        }

        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> r10, boolean r11) {
            return subMap(Range.upTo(r10, BoundType.forBoolean(r11)));
        }

        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> r10, boolean r11) {
            return subMap(Range.downTo(r10, BoundType.forBoolean(r11)));
        }

        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> r10, boolean r11, Cut<C> r12, boolean r13) {
            return subMap(Range.range(r10, BoundType.forBoolean(r11), r12, BoundType.forBoolean(r13)));
        }
    }

    public /* synthetic */ TreeRangeSet(NavigableMap r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static /* synthetic */ Range access$600(TreeRangeSet r10, Range r11) {
        return r10.rangeEnclosing(r11);
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet(new TreeMap());
    }

    @NullableDecl
    private Range<C> rangeEnclosing(Range<C> r10) {
        Preconditions.checkNotNull(r10);
        Map.Entry<Cut<C>, Range<C>> r11 = this.rangesByLowerBound.floorEntry(r10.lowerBound);
        if (r11 != null) goto L5;
    L7:
        return null;
    L5:
        if (r11.getValue().encloses(r10) == false) goto L7;
        return r11.getValue();
    }

    private void replaceRangeWithSameLowerBound(Range<C> r10) {
        if (r10.isEmpty() == false) goto L5;
        this.rangesByLowerBound.remove(r10.lowerBound);
        return;
    L5:
        this.rangesByLowerBound.put(r10.lowerBound, r10);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public void add(Range<C> r10) {
        Preconditions.checkNotNull(r10);
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        Cut<C> r11 = r10.lowerBound;
        Cut<C> r12 = r10.upperBound;
        Map.Entry<Cut<C>, Range<C>> r13 = this.rangesByLowerBound.lowerEntry(r11);
        if (r13 == null) goto L13;
        Range<C> r14 = r13.getValue();
        if (r14.upperBound.compareTo(r11) < 0) goto L13;
        if (r14.upperBound.compareTo(r12) < 0) goto L12;
        r12 = r14.upperBound;
    L12:
        r11 = r14.lowerBound;
    L13:
        Map.Entry<Cut<C>, Range<C>> r15 = this.rangesByLowerBound.floorEntry(r12);
        if (r15 == null) goto L18;
        Range<C> r16 = r15.getValue();
        if (r16.upperBound.compareTo(r12) < 0) goto L18;
        r12 = r16.upperBound;
    L18:
        this.rangesByLowerBound.subMap(r11, r12).clear();
        replaceRangeWithSameLowerBound(Range.create(r11, r12));
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(RangeSet r10) {
        super.addAll(r10);
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> r10 = this.asDescendingSetOfRanges;
        if (r10 != null) goto L6;
        AsRanges r11 = new AsRanges(this, this.rangesByLowerBound.descendingMap().values());
        this.asDescendingSetOfRanges = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asRanges() {
        Set<Range<C>> r10 = this.asRanges;
        if (r10 != null) goto L6;
        AsRanges r11 = new AsRanges(this, this.rangesByLowerBound.values());
        this.asRanges = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> complement() {
        RangeSet<C> r10 = this.complement;
        if (r10 != null) goto L6;
        Complement r11 = new Complement(this);
        this.complement = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(Comparable r10) {
        return super.contains(r10);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean encloses(Range<C> r10) {
        Preconditions.checkNotNull(r10);
        Map.Entry<Cut<C>, Range<C>> r11 = this.rangesByLowerBound.floorEntry(r10.lowerBound);
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.getValue().encloses(r10) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet r10) {
        return super.enclosesAll(r10);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object r10) {
        return super.equals(r10);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean intersects(Range<C> r10) {
        Preconditions.checkNotNull(r10);
        Map.Entry<Cut<C>, Range<C>> r11 = this.rangesByLowerBound.ceilingEntry(r10.lowerBound);
        if (r11 != null) goto L5;
    L9:
        Map.Entry<Cut<C>, Range<C>> r12 = this.rangesByLowerBound.lowerEntry(r10.lowerBound);
        if (r12 != null) goto L12;
    L16:
        return false;
    L12:
        if (r12.getValue().isConnected(r10) == false) goto L16;
        if (r12.getValue().intersection(r10).isEmpty() == true) goto L16;
        return true;
    L5:
        if (r11.getValue().isConnected(r10) == false) goto L9;
        if (r11.getValue().intersection(r10).isEmpty() == true) goto L9;
        return true;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @NullableDecl
    public Range<C> rangeContaining(C r10) {
        Preconditions.checkNotNull(r10);
        Map.Entry<Cut<C>, Range<C>> r11 = this.rangesByLowerBound.floorEntry(Cut.belowValue(r10));
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.getValue().contains(r10) == true) goto L7;
        return null;
    L7:
        return r11.getValue();
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
    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public void remove(Range<C> r10) {
        Preconditions.checkNotNull(r10);
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        Map.Entry<Cut<C>, Range<C>> r11 = this.rangesByLowerBound.lowerEntry(r10.lowerBound);
        if (r11 == null) goto L15;
        Range<C> r12 = r11.getValue();
        if (r12.upperBound.compareTo(r10.lowerBound) < 0) goto L15;
        if (r10.hasUpperBound() == true) goto L12;
    L14:
        replaceRangeWithSameLowerBound(Range.create(r12.lowerBound, r10.lowerBound));
        goto L15
    L12:
        if (r12.upperBound.compareTo(r10.upperBound) < 0) goto L14;
        replaceRangeWithSameLowerBound(Range.create(r10.upperBound, r12.upperBound));
    L15:
        Map.Entry<Cut<C>, Range<C>> r13 = this.rangesByLowerBound.floorEntry(r10.upperBound);
        if (r13 == null) goto L22;
        Range<C> r14 = r13.getValue();
        if (r10.hasUpperBound() == false) goto L22;
        if (r14.upperBound.compareTo(r10.upperBound) < 0) goto L22;
        replaceRangeWithSameLowerBound(Range.create(r10.upperBound, r14.upperBound));
    L22:
        this.rangesByLowerBound.subMap(r10.lowerBound, r10.upperBound).clear();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(RangeSet r10) {
        super.removeAll(r10);
    }

    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> r10 = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> r11 = this.rangesByLowerBound.lastEntry();
        if (r10 == null) goto L7;
        return Range.create(r10.getValue().lowerBound, r11.getValue().upperBound);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> subRangeSet(Range<C> r10) {
        if (r10.equals(Range.all()) == false) goto L6;
        return this;
    L6:
        return new SubRangeSet(this, r10);
    }

    private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> r10) {
        this.rangesByLowerBound = r10;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(RangeSet<C> r10) {
        TreeRangeSet<C> r11 = create();
        r11.addAll(r10);
        return r11;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(Iterable r10) {
        super.addAll(r10);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable r10) {
        return super.enclosesAll(r10);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(Iterable r10) {
        super.removeAll(r10);
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> r10) {
        TreeRangeSet<C> r11 = create();
        r11.addAll(r10);
        return r11;
    }
}
