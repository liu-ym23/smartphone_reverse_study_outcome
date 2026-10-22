package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class Ordering<T> implements Comparator<T> {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    @VisibleForTesting
    public static class ArbitraryOrdering extends Ordering<Object> {
        private final AtomicInteger counter;
        private final ConcurrentMap<Object, Integer> uids;

        public ArbitraryOrdering() {
            this.counter = new AtomicInteger(0);
            this.uids = Platform.tryWeakKeys(new MapMaker()).makeMap();
        }

        private Integer getUid(Object r10) {
            Integer r11 = this.uids.get(r10);
            if (r11 != null) goto L8;
            Integer r12 = Integer.valueOf(this.counter.getAndIncrement());
            Integer r13 = this.uids.putIfAbsent(r10, r12);
            if (r13 != null) goto L7;
            return r12;
        L7:
            return r13;
        L8:
            return r11;
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Object r10, Object r11) {
            if (r10 != r11) goto L6;
            return 0;
        L6:
            if (r10 != null) goto L9;
            return -1;
        L9:
            if (r11 != null) goto L11;
            return 1;
        L11:
            int r12 = identityHashCode(r10);
            int r13 = identityHashCode(r11);
            if (r12 == r13) goto L17;
            if (r12 >= r13) goto L16;
            return -1;
        L16:
            return 1;
        L17:
            int r14 = getUid(r10).compareTo(getUid(r11));
            if (r14 == 0) goto L21;
            return r14;
        L21:
            throw new AssertionError();
        }

        public int identityHashCode(Object r10) {
            return System.identityHashCode(r10);
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }
    }

    public static class ArbitraryOrderingHolder {
        static final Ordering<Object> ARBITRARY_ORDERING = null;

        static {
            ARBITRARY_ORDERING = new ArbitraryOrdering();
        }

        private ArbitraryOrderingHolder() {
        }
    }

    @VisibleForTesting
    public static class IncomparableValueException extends ClassCastException {
        private static final long serialVersionUID = 0;
        final Object value;

        public IncomparableValueException(Object r10) {
            super("Cannot compare value: " + r10);
            this.value = r10;
        }
    }

    public Ordering() {
    }

    @GwtCompatible(serializable = true)
    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    public static Ordering<Object> arbitrary() {
        return ArbitraryOrderingHolder.ARBITRARY_ORDERING;
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> explicit(List<T> r10) {
        return new ExplicitOrdering(r10);
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> from(Comparator<T> r10) {
        if ((r10 instanceof Ordering) == false) goto L6;
        return (Ordering) r10;
    L6:
        return new ComparatorOrdering(r10);
    }

    @GwtCompatible(serializable = true)
    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    @GwtCompatible(serializable = true)
    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    @Deprecated
    public int binarySearch(List<? extends T> r10, @NullableDecl T r11) {
        return Collections.binarySearch(r10, r11, this);
    }

    @Override // java.util.Comparator
    @CanIgnoreReturnValue
    public abstract int compare(@NullableDecl T r10, @NullableDecl T r11);

    @GwtCompatible(serializable = true)
    public <U extends T> Ordering<U> compound(Comparator<? super U> r10) {
        return new CompoundOrdering(this, (Comparator) Preconditions.checkNotNull(r10));
    }

    public <E extends T> List<E> greatestOf(Iterable<E> r10, int r11) {
        return reverse().leastOf(r10, r11);
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> r10) {
        return ImmutableList.sortedCopyOf(this, r10);
    }

    public boolean isOrdered(Iterable<? extends T> r10) {
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L12;
        T r12 = r11.next();
    L6:
        if (r11.hasNext() == false) goto L16;
        T r13 = r11.next();
        if (compare(r12, r13) > 0) goto L9;
        r12 = r13;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> r10) {
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L12;
        T r12 = r11.next();
    L6:
        if (r11.hasNext() == false) goto L16;
        T r13 = r11.next();
        if (compare(r12, r13) >= 0) goto L9;
        r12 = r13;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public <E extends T> List<E> leastOf(Iterable<E> r10, int r11) {
        if ((r10 instanceof Collection) == false) goto L12;
        Collection r12 = (Collection) r10;
        if (r12.size() > (((long) r11) * 2)) goto L12;
        Object[] r13 = r12.toArray();
        Arrays.sort(r13, this);
        if (r13.length <= r11) goto L10;
        r13 = Arrays.copyOf(r13, r11);
    L10:
        return Collections.unmodifiableList(Arrays.asList(r13));
    L12:
        return leastOf(r10.iterator(), r11);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    public <E extends T> E max(Iterator<E> r10) {
        E r11 = r10.next();
    L4:
        if (r10.hasNext() == false) goto L6;
        E r12 = r11;
        r11 = (E) max(r12, r10.next());
        goto L4
    L6:
        return r11;
    }

    public <E extends T> E min(Iterator<E> r10) {
        E r11 = r10.next();
    L4:
        if (r10.hasNext() == false) goto L6;
        E r12 = r11;
        r11 = (E) min(r12, r10.next());
        goto L4
    L6:
        return r11;
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    public <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys() {
        return (Ordering<Map.Entry<T2, ?>>) onResultOf(Maps.keyFunction());
    }

    @GwtCompatible(serializable = true)
    public <F> Ordering<F> onResultOf(Function<F, ? extends T> r10) {
        return new ByFunctionOrdering(r10, this);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> r10) {
        Object[] r11 = Iterables.toArray(r10);
        Arrays.sort(r11, this);
        return Lists.newArrayList(Arrays.asList(r11));
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> r10) {
        return new CompoundOrdering(r10);
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> explicit(T r10, T... r11) {
        return explicit(Lists.asList(r10, r11));
    }

    @GwtCompatible(serializable = true)
    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> r10) {
        return (Ordering) Preconditions.checkNotNull(r10);
    }

    public <E extends T> List<E> greatestOf(Iterator<E> r10, int r11) {
        return reverse().leastOf(r10, r11);
    }

    public <E extends T> E max(Iterable<E> r10) {
        return (E) max(r10.iterator());
    }

    public <E extends T> E min(Iterable<E> r10) {
        return (E) min(r10.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E max(@NullableDecl E r10, @NullableDecl E r11) {
        if (compare(r10, r11) < 0) goto L6;
        return r10;
    L6:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E min(@NullableDecl E r10, @NullableDecl E r11) {
        if (compare(r10, r11) > 0) goto L6;
        return r10;
    L6:
        return r11;
    }

    public <E extends T> E max(@NullableDecl E r10, @NullableDecl E r11, @NullableDecl E r12, E... r13) {
        E r14 = (E) max(max(r10, r11), r12);
        int r15 = r13.length;
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L5;
        E r17 = r14;
        r14 = (E) max(r17, r13[r16]);
        r16 = r16 + 1;
        goto L3
    L5:
        return r14;
    }

    public <E extends T> E min(@NullableDecl E r10, @NullableDecl E r11, @NullableDecl E r12, E... r13) {
        E r14 = (E) min(min(r10, r11), r12);
        int r15 = r13.length;
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L5;
        E r17 = r14;
        r14 = (E) min(r17, r13[r16]);
        r16 = r16 + 1;
        goto L3
    L5:
        return r14;
    }

    public <E extends T> List<E> leastOf(Iterator<E> r10, int r11) {
        Preconditions.checkNotNull(r10);
        CollectPreconditions.checkNonnegative(r11, "k");
        if (r11 == 0) goto L17;
        if (r10.hasNext() == false) goto L17;
        if (r11 < 1073741823) goto L14;
        ArrayList r12 = Lists.newArrayList(r10);
        Collections.sort(r12, this);
        if (r12.size() <= r11) goto L12;
        r12.subList(r11, r12.size()).clear();
    L12:
        r12.trimToSize();
        return Collections.unmodifiableList(r12);
    L14:
        TopKSelector r13 = TopKSelector.least(r11, this);
        r13.offerAll(r10);
        return r13.topK();
    L17:
        return Collections.emptyList();
    }
}
