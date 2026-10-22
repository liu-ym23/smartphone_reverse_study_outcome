package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Ordering<T> implements Comparator<T> {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    static class ArbitraryOrdering extends Ordering<Object> {
        private Map<Object, Integer> uids;

        public String toString() {
            return "Ordering.arbitrary()";
        }

        ArbitraryOrdering() {
            this.uids = Platform.tryWeakKeys(new MapMaker()).makeComputingMap(new AnonymousClass1(this));
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Object r5, Object r6) {
            if (r5 != r6) goto L6;
            return 0;
        L6:
            if (r5 != null) goto L9;
            return -1;
        L9:
            if (r6 != null) goto L11;
            return 1;
        L11:
            int r2 = identityHashCode(r5);
            int r3 = identityHashCode(r6);
            if (r2 == r3) goto L17;
            if (r2 >= r3) goto L16;
            return -1;
        L16:
            return 1;
        L17:
            int r4 = this.uids.get(r5).compareTo(this.uids.get(r6));
            if (r4 == 0) goto L21;
            return r4;
        L21:
            throw new AssertionError();
        }

        int identityHashCode(Object r1) {
            return System.identityHashCode(r1);
        }
    }

    private static class ArbitraryOrderingHolder {
        static final Ordering<Object> ARBITRARY_ORDERING = null;

        private ArbitraryOrderingHolder() {
        }

        static {
            ARBITRARY_ORDERING = new ArbitraryOrdering();
        }
    }

    static class IncomparableValueException extends ClassCastException {
        private static final long serialVersionUID = 0;
        final Object value;

        IncomparableValueException(Object r3) {
            super("Cannot compare value: " + r3);
            this.value = r3;
        }
    }

    @Override // java.util.Comparator
    public abstract int compare(@Nullable T r1, @Nullable T r2);

    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    public static <T> Ordering<T> from(Comparator<T> r1) {
        if ((r1 instanceof Ordering) == false) goto L6;
        return (Ordering) r1;
    L6:
        return new ComparatorOrdering(r1);
    }

    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> r0) {
        return (Ordering) Preconditions.checkNotNull(r0);
    }

    public static <T> Ordering<T> explicit(List<T> r1) {
        return new ExplicitOrdering(r1);
    }

    public static <T> Ordering<T> explicit(T r0, T... r1) {
        return explicit(Lists.asList(r0, r1));
    }

    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    public static Ordering<Object> arbitrary() {
        return ArbitraryOrderingHolder.ARBITRARY_ORDERING;
    }

    protected Ordering() {
    }

    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    public <F> Ordering<F> onResultOf(Function<F, ? extends T> r2) {
        return new ByFunctionOrdering(r2, this);
    }

    <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys() {
        return (Ordering<Map.Entry<T2, ?>>) onResultOf(Maps.keyFunction());
    }

    public <U extends T> Ordering<U> compound(Comparator<? super U> r2) {
        return new CompoundOrdering(this, (Comparator) Preconditions.checkNotNull(r2));
    }

    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> r1) {
        return new CompoundOrdering(r1);
    }

    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    public <E extends T> E min(Iterator<E> r3) {
        E r0 = r3.next();
    L4:
        if (r3.hasNext() == false) goto L6;
        E r1 = r0;
        r0 = (E) min(r1, r3.next());
        goto L4
    L6:
        return r0;
    }

    public <E extends T> E min(Iterable<E> r1) {
        return (E) min(r1.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E min(@Nullable E r1, @Nullable E r2) {
        if (compare(r1, r2) > 0) goto L6;
        return r1;
    L6:
        return r2;
    }

    public <E extends T> E min(@Nullable E r2, @Nullable E r3, @Nullable E r4, E... r5) {
        E r6 = (E) min(min(r2, r3), r4);
        int r7 = r5.length;
        int r8 = 0;
    L3:
        if (r8 >= r7) goto L5;
        E r9 = r6;
        r6 = (E) min(r9, r5[r8]);
        r8 = r8 + 1;
        goto L3
    L5:
        return r6;
    }

    public <E extends T> E max(Iterator<E> r3) {
        E r0 = r3.next();
    L4:
        if (r3.hasNext() == false) goto L6;
        E r1 = r0;
        r0 = (E) max(r1, r3.next());
        goto L4
    L6:
        return r0;
    }

    public <E extends T> E max(Iterable<E> r1) {
        return (E) max(r1.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E max(@Nullable E r1, @Nullable E r2) {
        if (compare(r1, r2) < 0) goto L6;
        return r1;
    L6:
        return r2;
    }

    public <E extends T> E max(@Nullable E r2, @Nullable E r3, @Nullable E r4, E... r5) {
        E r6 = (E) max(max(r2, r3), r4);
        int r7 = r5.length;
        int r8 = 0;
    L3:
        if (r8 >= r7) goto L5;
        E r9 = r6;
        r6 = (E) max(r9, r5[r8]);
        r8 = r8 + 1;
        goto L3
    L5:
        return r6;
    }

    public <E extends T> List<E> leastOf(Iterable<E> r8, int r9) {
        if ((r8 instanceof Collection) == false) goto L12;
        Collection r0 = (Collection) r8;
        if (r0.size() > (((long) r9) * 2)) goto L12;
        Object[] r10 = r0.toArray();
        Arrays.sort(r10, this);
        if (r10.length <= r9) goto L10;
        r10 = ObjectArrays.arraysCopyOf(r10, r9);
    L10:
        return Collections.unmodifiableList(Arrays.asList(r10));
    L12:
        return leastOf(r8.iterator(), r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> List<E> leastOf(Iterator<E> r9, int r10) {
        Preconditions.checkNotNull(r9);
        CollectPreconditions.checkNonnegative(r10, "k");
        if (r10 == 0) goto L42;
        if (r9.hasNext() == false) goto L42;
        if (r10 < 1073741823) goto L14;
        ArrayList r11 = Lists.newArrayList(r9);
        Collections.sort(r11, this);
        if (r11.size() <= r10) goto L12;
        r11.subList(r10, r11.size()).clear();
    L12:
        r11.trimToSize();
        return Collections.unmodifiableList(r11);
    L14:
        int r0 = r10 * 2;
        Object[] r1 = new Object[r0];
        Object r2 = r9.next();
        r1[0] = r2;
        int r5 = 1;
    L15:
        if (r5 >= r10) goto L20;
        if (r9.hasNext() == false) goto L20;
        E r6 = r9.next();
        r1[r5] = r6;
        r2 = max(r2, r6);
        r5 = r5 + 1;
    L20:
        if (r9.hasNext() == false) goto L39;
        E r7 = r9.next();
        if (compare(r7, r2) >= 0) goto L20;
        int r8 = r5 + 1;
        r1[r5] = r7;
        if (r8 == r0) goto L26;
        r5 = r8;
        goto L20
    L26:
        int r3 = r0 - 1;
        int r12 = 0;
        int r13 = 0;
    L27:
        if (r12 >= r3) goto L33;
        int r14 = partition(r1, r12, r3, ((r12 + r3) + 1) >>> 1);
        if (r14 > r10) goto L30;
        if (r14 >= r10) goto L33;
        r12 = Math.max(r14, r12 + 1);
        r13 = r14;
        goto L27
    L30:
        r3 = r14 - 1;
    L33:
        r2 = r1[r13];
    L34:
        r13 = r13 + 1;
        if (r13 >= r10) goto L37;
        r2 = max(r2, r1[r13]);
        goto L34
    L37:
        r5 = r10;
        goto L20
    L39:
        Arrays.sort(r1, 0, r5, this);
        return Collections.unmodifiableList(Arrays.asList(ObjectArrays.arraysCopyOf(r1, Math.min(r5, r10))));
    L42:
        return ImmutableList.of();
    }

    private <E extends T> int partition(E[] r3, int r4, int r5, int r6) {
        E r0 = r3[r6];
        r3[r6] = r3[r5];
        r3[r5] = r0;
        int r7 = r4;
    L3:
        if (r4 >= r5) goto L8;
        if (compare(r3[r4], r0) >= 0) goto L7;
        ObjectArrays.swap(r3, r7, r4);
        r7 = r7 + 1;
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        ObjectArrays.swap(r3, r5, r7);
        return r7;
    }

    public <E extends T> List<E> greatestOf(Iterable<E> r1, int r2) {
        return reverse().leastOf(r1, r2);
    }

    public <E extends T> List<E> greatestOf(Iterator<E> r1, int r2) {
        return reverse().leastOf(r1, r2);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> r1) {
        Object[] r2 = Iterables.toArray(r1);
        Arrays.sort(r2, this);
        return Lists.newArrayList(Arrays.asList(r2));
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> r4) {
        Object[] r5 = Iterables.toArray(r4);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Preconditions.checkNotNull(r5[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        Arrays.sort(r5, this);
        return ImmutableList.asImmutableList(r5);
    }

    public boolean isOrdered(Iterable<? extends T> r3) {
        Iterator<? extends T> r4 = r3.iterator();
        if (r4.hasNext() == false) goto L12;
        T r0 = r4.next();
    L6:
        if (r4.hasNext() == false) goto L16;
        T r1 = r4.next();
        if (compare(r0, r1) > 0) goto L9;
        r0 = r1;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> r3) {
        Iterator<? extends T> r4 = r3.iterator();
        if (r4.hasNext() == false) goto L12;
        T r0 = r4.next();
    L6:
        if (r4.hasNext() == false) goto L16;
        T r1 = r4.next();
        if (compare(r0, r1) >= 0) goto L9;
        r0 = r1;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public int binarySearch(List<? extends T> r1, @Nullable T r2) {
        return Collections.binarySearch(r1, r2, this);
    }
}
