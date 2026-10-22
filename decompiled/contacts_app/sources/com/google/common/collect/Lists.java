package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Lists {

    private static class AbstractListWrapper<E> extends AbstractList<E> {
        final List<E> backingList;

        AbstractListWrapper(List<E> r1) {
            this.backingList = (List) Preconditions.checkNotNull(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int r1, E r2) {
            this.backingList.add(r1, r2);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int r1, Collection<? extends E> r2) {
            return this.backingList.addAll(r1, r2);
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int r1) {
            return this.backingList.get(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public E remove(int r1) {
            return this.backingList.remove(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int r1, E r2) {
            return this.backingList.set(r1, r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r1) {
            return this.backingList.contains(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.backingList.size();
        }
    }

    private static final class CharSequenceAsList extends AbstractList<Character> {
        private final CharSequence sequence;

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        CharSequenceAsList(CharSequence r1) {
            this.sequence = r1;
        }

        @Override // java.util.AbstractList, java.util.List
        public Character get(int r2) {
            Preconditions.checkElementIndex(r2, size());
            return Character.valueOf(this.sequence.charAt(r2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.sequence.length();
        }
    }

    private static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final E first;
        final E[] rest;

        OnePlusArrayList(@Nullable E r1, E[] r2) {
            this.first = r1;
            this.rest = (E[]) ((Object[]) Preconditions.checkNotNull(r2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.rest.length + 1;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int r2) {
            Preconditions.checkElementIndex(r2, size());
            if (r2 != 0) goto L6;
            return this.first;
        L6:
            return this.rest[r2 - 1];
        }
    }

    private static class Partition<T> extends AbstractList<List<T>> {
        final List<T> list;
        final int size;

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        Partition(List<T> r1, int r2) {
            this.list = r1;
            this.size = r2;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> get(int r3) {
            Preconditions.checkElementIndex(r3, size());
            int r0 = this.size;
            int r4 = r3 * r0;
            int r1 = Math.min(r0 + r4, this.list.size());
            return this.list.subList(r4, r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.divide(this.list.size(), this.size, RoundingMode.CEILING);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.list.isEmpty();
        }
    }

    private static class RandomAccessListWrapper<E> extends AbstractListWrapper<E> implements RandomAccess {
        RandomAccessListWrapper(List<E> r1) {
            super(r1);
        }
    }

    private static class RandomAccessPartition<T> extends Partition<T> implements RandomAccess {
        RandomAccessPartition(List<T> r1, int r2) {
            super(r1, r2);
        }
    }

    private static class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
        RandomAccessReverseList(List<T> r1) {
            super(r1);
        }
    }

    private static class ReverseList<T> extends AbstractList<T> {
        private final List<T> forwardList;

        static /* synthetic */ int access$000(ReverseList r0, int r1) {
            return r0.reversePosition(r1);
        }

        ReverseList(List<T> r1) {
            this.forwardList = (List) Preconditions.checkNotNull(r1);
        }

        List<T> getForwardList() {
            return this.forwardList;
        }

        private int reverseIndex(int r1) {
            int r0 = size();
            Preconditions.checkElementIndex(r1, r0);
            return (r0 - 1) - r1;
        }

        private int reversePosition(int r1) {
            int r0 = size();
            Preconditions.checkPositionIndex(r1, r0);
            return r0 - r1;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int r2, @Nullable T r3) {
            this.forwardList.add(reversePosition(r2), r3);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.forwardList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int r2) {
            return this.forwardList.remove(reverseIndex(r2));
        }

        @Override // java.util.AbstractList
        protected void removeRange(int r1, int r2) {
            subList(r1, r2).clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T set(int r2, @Nullable T r3) {
            return this.forwardList.set(reverseIndex(r2), r3);
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int r2) {
            return this.forwardList.get(reverseIndex(r2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.forwardList.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> subList(int r2, int r3) {
            Preconditions.checkPositionIndexes(r2, r3, size());
            return Lists.reverse(this.forwardList.subList(reversePosition(r3), reversePosition(r2)));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int r2) {
            int r3 = reversePosition(r2);
            final ListIterator<T> r4 = this.forwardList.listIterator(r3);
            return new AnonymousClass1(this, r4);
        }
    }

    private static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String string;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ List subList(int r1, int r2) {
            return subList(r1, r2);
        }

        StringAsImmutableList(String r1) {
            this.string = r1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@Nullable Object r2) {
            if ((r2 instanceof Character) == true) goto L7;
            return -1;
        L7:
            return this.string.indexOf(((Character) r2).charValue());
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@Nullable Object r2) {
            if ((r2 instanceof Character) == true) goto L7;
            return -1;
        L7:
            return this.string.lastIndexOf(((Character) r2).charValue());
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<Character> subList(int r2, int r3) {
            Preconditions.checkPositionIndexes(r2, r3, size());
            return Lists.charactersOf(this.string.substring(r2, r3));
        }

        @Override // java.util.List
        public Character get(int r2) {
            Preconditions.checkElementIndex(r2, size());
            return Character.valueOf(this.string.charAt(r2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.string.length();
        }
    }

    private static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        TransformingRandomAccessList(List<F> r1, Function<? super F, ? extends T> r2) {
            this.fromList = (List) Preconditions.checkNotNull(r1);
            this.function = (Function) Preconditions.checkNotNull(r2);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int r2) {
            return this.function.apply(this.fromList.get(r2));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int r3) {
            final ListIterator<F> r4 = this.fromList.listIterator(r3);
            return new AnonymousClass1(this, r4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int r2) {
            return this.function.apply(this.fromList.remove(r2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    private static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        TransformingSequentialList(List<F> r1, Function<? super F, ? extends T> r2) {
            this.fromList = (List) Preconditions.checkNotNull(r1);
            this.function = (Function) Preconditions.checkNotNull(r2);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int r3) {
            final ListIterator<F> r4 = this.fromList.listIterator(r3);
            return new AnonymousClass1(this, r4);
        }
    }

    private static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final E first;
        final E[] rest;
        final E second;

        TwoPlusArrayList(@Nullable E r1, @Nullable E r2, E[] r3) {
            this.first = r1;
            this.second = r2;
            this.rest = (E[]) ((Object[]) Preconditions.checkNotNull(r3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.rest.length + 2;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int r2) {
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L8;
            Preconditions.checkElementIndex(r2, size());
            return this.rest[r2 - 2];
        L8:
            return this.second;
        L10:
            return this.first;
        }
    }

    private Lists() {
    }

    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList();
    }

    public static <E> ArrayList<E> newArrayList(E... r2) {
        Preconditions.checkNotNull(r2);
        ArrayList<E> r1 = new ArrayList(computeArrayListCapacity(r2.length));
        Collections.addAll(r1, r2);
        return r1;
    }

    static int computeArrayListCapacity(int r4) {
        CollectPreconditions.checkNonnegative(r4, "arraySize");
        return Ints.saturatedCast((((long) r4) + 5) + ((long) (r4 / 10)));
    }

    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> r1) {
        Preconditions.checkNotNull(r1);
        if ((r1 instanceof Collection) == false) goto L6;
        return new ArrayList(Collections2.cast(r1));
    L6:
        return newArrayList(r1.iterator());
    }

    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> r1) {
        ArrayList<E> r0 = newArrayList();
        Iterators.addAll(r0, r1);
        return r0;
    }

    public static <E> ArrayList<E> newArrayListWithCapacity(int r1) {
        CollectPreconditions.checkNonnegative(r1, "initialArraySize");
        return new ArrayList(r1);
    }

    public static <E> ArrayList<E> newArrayListWithExpectedSize(int r1) {
        return new ArrayList(computeArrayListCapacity(r1));
    }

    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList();
    }

    public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> r1) {
        LinkedList<E> r0 = newLinkedList();
        Iterables.addAll(r0, r1);
        return r0;
    }

    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList();
    }

    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(Iterable<? extends E> r1) {
        if ((r1 instanceof Collection) == false) goto L5;
        Collection r2 = Collections2.cast(r1);
    L7:
        return new CopyOnWriteArrayList(r2);
    L5:
        r2 = newArrayList(r1);
        goto L7
    }

    public static <E> List<E> asList(@Nullable E r1, E[] r2) {
        return new OnePlusArrayList(r1, r2);
    }

    public static <E> List<E> asList(@Nullable E r1, @Nullable E r2, E[] r3) {
        return new TwoPlusArrayList(r1, r2, r3);
    }

    static <B> List<List<B>> cartesianProduct(List<? extends List<? extends B>> r0) {
        return CartesianList.create(r0);
    }

    static <B> List<List<B>> cartesianProduct(List<? extends B>... r0) {
        return cartesianProduct(Arrays.asList(r0));
    }

    public static <F, T> List<T> transform(List<F> r1, Function<? super F, ? extends T> r2) {
        if ((r1 instanceof RandomAccess) == false) goto L6;
        return new TransformingRandomAccessList(r1, r2);
    L6:
        return new TransformingSequentialList(r1, r2);
    }

    public static <T> List<List<T>> partition(List<T> r1, int r2) {
        Preconditions.checkNotNull(r1);
        if (r2 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        if ((r1 instanceof RandomAccess) == false) goto L10;
        return new RandomAccessPartition(r1, r2);
    L10:
        return new Partition(r1, r2);
    L5:
        r0 = false;
        goto L6
    }

    public static ImmutableList<Character> charactersOf(String r1) {
        return new StringAsImmutableList((String) Preconditions.checkNotNull(r1));
    }

    public static List<Character> charactersOf(CharSequence r1) {
        return new CharSequenceAsList((CharSequence) Preconditions.checkNotNull(r1));
    }

    public static <T> List<T> reverse(List<T> r1) {
        if ((r1 instanceof ImmutableList) == false) goto L7;
        return ((ImmutableList) r1).reverse();
    L7:
        if ((r1 instanceof ReverseList) == false) goto L11;
        return ((ReverseList) r1).getForwardList();
    L11:
        if ((r1 instanceof RandomAccess) == false) goto L15;
        return new RandomAccessReverseList(r1);
    L15:
        return new ReverseList(r1);
    }

    static int hashCodeImpl(List<?> r2) {
        Iterator<?> r3 = r2.iterator();
        int r0 = 1;
    L4:
        if (r3.hasNext() == false) goto L10;
        Object r1 = r3.next();
        int r4 = r0 * 31;
        if (r1 != null) goto L8;
        int r5 = 0;
    L9:
        r0 = ~(~(r4 + r5));
        goto L4
    L8:
        r5 = r1.hashCode();
        goto L9
    L10:
        return r0;
    }

    static boolean equalsImpl(List<?> r4, @Nullable Object r5) {
        if (r5 != Preconditions.checkNotNull(r4)) goto L6;
        return true;
    L6:
        if ((r5 instanceof List) == true) goto L8;
        return false;
    L8:
        List r6 = (List) r5;
        if (r4.size() != r6.size()) goto L14;
        if (Iterators.elementsEqual(r4.iterator(), r6.iterator()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    static <E> boolean addAllImpl(List<E> r1, int r2, Iterable<? extends E> r3) {
        ListIterator<E> r4 = r1.listIterator(r2);
        Iterator<? extends E> r5 = r3.iterator();
        boolean r6 = false;
    L4:
        if (r5.hasNext() == false) goto L6;
        r4.add(r5.next());
        r6 = true;
        goto L4
    L6:
        return r6;
    }

    static int indexOfImpl(List<?> r1, @Nullable Object r2) {
        ListIterator<?> r3 = r1.listIterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (Objects.equal(r2, r3.next()) == false) goto L4;
        return r3.previousIndex();
    L9:
        return -1;
    }

    static int lastIndexOfImpl(List<?> r1, @Nullable Object r2) {
        ListIterator<?> r3 = r1.listIterator(r1.size());
    L4:
        if (r3.hasPrevious() == false) goto L9;
        if (Objects.equal(r2, r3.previous()) == false) goto L4;
        return r3.nextIndex();
    L9:
        return -1;
    }

    static <E> ListIterator<E> listIteratorImpl(List<E> r1, int r2) {
        return new AbstractListWrapper(r1).listIterator(r2);
    }

    static <E> List<E> subListImpl(final List<E> r1, int r2, int r3) {
        if ((r1 instanceof RandomAccess) == false) goto L5;
        List r0 = new AnonymousClass1(r1);
    L7:
        return r0.subList(r2, r3);
    L5:
        r0 = new AnonymousClass2(r1);
        goto L7
    }

    static <T> List<T> cast(Iterable<T> r0) {
        return (List) r0;
    }
}
