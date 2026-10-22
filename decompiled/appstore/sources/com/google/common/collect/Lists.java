package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
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
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Lists {

    public static class AbstractListWrapper<E> extends AbstractList<E> {
        final List<E> backingList;

        public AbstractListWrapper(List<E> r10) {
            this.backingList = (List) Preconditions.checkNotNull(r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int r10, E r11) {
            this.backingList.add(r10, r11);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int r10, Collection<? extends E> r11) {
            return this.backingList.addAll(r10, r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r10) {
            return this.backingList.contains(r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int r10) {
            return this.backingList.get(r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public E remove(int r10) {
            return this.backingList.remove(r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int r10, E r11) {
            return this.backingList.set(r10, r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.backingList.size();
        }
    }

    public static final class CharSequenceAsList extends AbstractList<Character> {
        private final CharSequence sequence;

        public CharSequenceAsList(CharSequence r10) {
            this.sequence = r10;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.sequence.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public Character get(int r10) {
            Preconditions.checkElementIndex(r10, size());
            return Character.valueOf(this.sequence.charAt(r10));
        }
    }

    public static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;

        @NullableDecl
        final E first;
        final E[] rest;

        public OnePlusArrayList(@NullableDecl E r10, E[] r11) {
            this.first = r10;
            this.rest = (E[]) ((Object[]) Preconditions.checkNotNull(r11));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int r10) {
            Preconditions.checkElementIndex(r10, size());
            if (r10 != 0) goto L6;
            return this.first;
        L6:
            return this.rest[r10 - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 1);
        }
    }

    public static class Partition<T> extends AbstractList<List<T>> {
        final List<T> list;
        final int size;

        public Partition(List<T> r10, int r11) {
            this.list = r10;
            this.size = r11;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.divide(this.list.size(), this.size, RoundingMode.CEILING);
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> get(int r10) {
            Preconditions.checkElementIndex(r10, size());
            int r11 = this.size;
            int r12 = r10 * r11;
            int r13 = Math.min(r11 + r12, this.list.size());
            return this.list.subList(r12, r13);
        }
    }

    public static class RandomAccessListWrapper<E> extends AbstractListWrapper<E> implements RandomAccess {
        public RandomAccessListWrapper(List<E> r10) {
            super(r10);
        }
    }

    public static class RandomAccessPartition<T> extends Partition<T> implements RandomAccess {
        public RandomAccessPartition(List<T> r10, int r11) {
            super(r10, r11);
        }
    }

    public static class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
        public RandomAccessReverseList(List<T> r10) {
            super(r10);
        }
    }

    public static class ReverseList<T> extends AbstractList<T> {
        private final List<T> forwardList;

        public ReverseList(List<T> r10) {
            this.forwardList = (List) Preconditions.checkNotNull(r10);
        }

        public static /* synthetic */ int access$000(ReverseList r10, int r11) {
            return r10.reversePosition(r11);
        }

        private int reverseIndex(int r10) {
            int r11 = size();
            Preconditions.checkElementIndex(r10, r11);
            return (r11 - 1) - r10;
        }

        private int reversePosition(int r10) {
            int r11 = size();
            Preconditions.checkPositionIndex(r10, r11);
            return r11 - r10;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int r10, @NullableDecl T r11) {
            this.forwardList.add(reversePosition(r10), r11);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.forwardList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int r10) {
            return this.forwardList.get(reverseIndex(r10));
        }

        public List<T> getForwardList() {
            return this.forwardList;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int r10) {
            int r11 = reversePosition(r10);
            final ListIterator<T> r12 = this.forwardList.listIterator(r11);
            return new AnonymousClass1(this, r12);
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int r10) {
            return this.forwardList.remove(reverseIndex(r10));
        }

        @Override // java.util.AbstractList
        public void removeRange(int r10, int r11) {
            subList(r10, r11).clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T set(int r10, @NullableDecl T r11) {
            return this.forwardList.set(reverseIndex(r10), r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.forwardList.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> subList(int r10, int r11) {
            Preconditions.checkPositionIndexes(r10, r11, size());
            return Lists.reverse(this.forwardList.subList(reversePosition(r11), reversePosition(r10)));
        }
    }

    public static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String string;

        public StringAsImmutableList(String r10) {
            this.string = r10;
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@NullableDecl Object r10) {
            if ((r10 instanceof Character) == true) goto L7;
            return -1;
        L7:
            return this.string.indexOf(((Character) r10).charValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@NullableDecl Object r10) {
            if ((r10 instanceof Character) == true) goto L7;
            return -1;
        L7:
            return this.string.lastIndexOf(((Character) r10).charValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.string.length();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ List subList(int r10, int r11) {
            return subList(r10, r11);
        }

        @Override // java.util.List
        public Character get(int r10) {
            Preconditions.checkElementIndex(r10, size());
            return Character.valueOf(this.string.charAt(r10));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<Character> subList(int r10, int r11) {
            Preconditions.checkPositionIndexes(r10, r11, size());
            return Lists.charactersOf(this.string.substring(r10, r11));
        }
    }

    public static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        public TransformingRandomAccessList(List<F> r10, Function<? super F, ? extends T> r11) {
            this.fromList = (List) Preconditions.checkNotNull(r10);
            this.function = (Function) Preconditions.checkNotNull(r11);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int r10) {
            return this.function.apply(this.fromList.get(r10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int r10) {
            final ListIterator<F> r11 = this.fromList.listIterator(r10);
            return new AnonymousClass1(this, r11);
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int r10) {
            return this.function.apply(this.fromList.remove(r10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        public TransformingSequentialList(List<F> r10, Function<? super F, ? extends T> r11) {
            this.fromList = (List) Preconditions.checkNotNull(r10);
            this.function = (Function) Preconditions.checkNotNull(r11);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int r10) {
            final ListIterator<F> r11 = this.fromList.listIterator(r10);
            return new AnonymousClass1(this, r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;

        @NullableDecl
        final E first;
        final E[] rest;

        @NullableDecl
        final E second;

        public TwoPlusArrayList(@NullableDecl E r10, @NullableDecl E r11, E[] r12) {
            this.first = r10;
            this.second = r11;
            this.rest = (E[]) ((Object[]) Preconditions.checkNotNull(r12));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int r10) {
            if (r10 == 0) goto L10;
            if (r10 == 1) goto L8;
            Preconditions.checkElementIndex(r10, size());
            return this.rest[r10 - 2];
        L8:
            return this.second;
        L10:
            return this.first;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 2);
        }
    }

    private Lists() {
    }

    public static <E> boolean addAllImpl(List<E> r10, int r11, Iterable<? extends E> r12) {
        ListIterator<E> r13 = r10.listIterator(r11);
        Iterator<? extends E> r14 = r12.iterator();
        boolean r15 = false;
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.add(r14.next());
        r15 = true;
        goto L4
    L6:
        return r15;
    }

    public static <E> List<E> asList(@NullableDecl E r10, E[] r11) {
        return new OnePlusArrayList(r10, r11);
    }

    public static <B> List<List<B>> cartesianProduct(List<? extends List<? extends B>> r10) {
        return CartesianList.create(r10);
    }

    public static <T> List<T> cast(Iterable<T> r10) {
        return (List) r10;
    }

    public static ImmutableList<Character> charactersOf(String r10) {
        return new StringAsImmutableList((String) Preconditions.checkNotNull(r10));
    }

    @VisibleForTesting
    public static int computeArrayListCapacity(int r10) {
        CollectPreconditions.checkNonnegative(r10, "arraySize");
        return Ints.saturatedCast((((long) r10) + 5) + ((long) (r10 / 10)));
    }

    public static boolean equalsImpl(List<?> r10, @NullableDecl Object r11) {
        if (r11 != Preconditions.checkNotNull(r10)) goto L6;
        return true;
    L6:
        if ((r11 instanceof List) == true) goto L8;
        return false;
    L8:
        List r12 = (List) r11;
        int r13 = r10.size();
        if (r13 == r12.size()) goto L12;
        return false;
    L12:
        if ((r10 instanceof RandomAccess) == false) goto L23;
        if ((r12 instanceof RandomAccess) == false) goto L23;
        int r14 = 0;
    L16:
        if (r14 >= r13) goto L21;
        if (Objects.equal(r10.get(r14), r12.get(r14)) == false) goto L19;
        r14 = r14 + 1;
        goto L16
    L19:
        return false;
    L21:
        return true;
    L23:
        return Iterators.elementsEqual(r10.iterator(), r12.iterator());
    }

    public static int hashCodeImpl(List<?> r10) {
        Iterator<?> r11 = r10.iterator();
        int r12 = 1;
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r13 = r11.next();
        int r14 = r12 * 31;
        if (r13 != null) goto L8;
        int r15 = 0;
    L9:
        r12 = ~(~(r14 + r15));
        goto L4
    L8:
        r15 = r13.hashCode();
        goto L9
    L10:
        return r12;
    }

    public static int indexOfImpl(List<?> r10, @NullableDecl Object r11) {
        if ((r10 instanceof RandomAccess) == true) goto L5;
        ListIterator<?> r12 = r10.listIterator();
    L8:
        if (r12.hasNext() == false) goto L13;
        if (Objects.equal(r11, r12.next()) == false) goto L8;
        return r12.previousIndex();
    L13:
        return -1;
    L5:
        return indexOfRandomAccess(r10, r11);
    }

    private static int indexOfRandomAccess(List<?> r10, @NullableDecl Object r11) {
        int r12 = r10.size();
        int r13 = 0;
        if (r11 != null) goto L9;
    L4:
        if (r13 >= r12) goto L14;
        if (r10.get(r13) == null) goto L7;
        r13 = r13 + 1;
        goto L4
    L7:
        return r13;
    L14:
        return -1;
    L9:
        if (r13 >= r12) goto L20;
        if (r11.equals(r10.get(r13)) == true) goto L12;
        r13 = r13 + 1;
        goto L9
    L12:
        return r13;
    L20:
        return -1;
    }

    public static int lastIndexOfImpl(List<?> r10, @NullableDecl Object r11) {
        if ((r10 instanceof RandomAccess) == true) goto L5;
        ListIterator<?> r12 = r10.listIterator(r10.size());
    L8:
        if (r12.hasPrevious() == false) goto L13;
        if (Objects.equal(r11, r12.previous()) == false) goto L8;
        return r12.nextIndex();
    L13:
        return -1;
    L5:
        return lastIndexOfRandomAccess(r10, r11);
    }

    private static int lastIndexOfRandomAccess(List<?> r10, @NullableDecl Object r11) {
        if (r11 != null) goto L9;
        int r12 = r10.size() - 1;
    L4:
        if (r12 < 0) goto L15;
        if (r10.get(r12) == null) goto L7;
        r12 = r12 - 1;
        goto L4
    L7:
        return r12;
    L15:
        return -1;
    L9:
        int r13 = r10.size() - 1;
    L10:
        if (r13 < 0) goto L21;
        if (r11.equals(r10.get(r13)) == true) goto L13;
        r13 = r13 - 1;
        goto L10
    L13:
        return r13;
    L21:
        return -1;
    }

    public static <E> ListIterator<E> listIteratorImpl(List<E> r10, int r11) {
        return new AbstractListWrapper(r10).listIterator(r11);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList();
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithCapacity(int r10) {
        CollectPreconditions.checkNonnegative(r10, "initialArraySize");
        return new ArrayList(r10);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithExpectedSize(int r10) {
        return new ArrayList(computeArrayListCapacity(r10));
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList();
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList();
    }

    public static <T> List<List<T>> partition(List<T> r10, int r11) {
        Preconditions.checkNotNull(r10);
        if (r11 <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        if ((r10 instanceof RandomAccess) == false) goto L10;
        return new RandomAccessPartition(r10, r11);
    L10:
        return new Partition(r10, r11);
    L5:
        r12 = false;
        goto L6
    }

    public static <T> List<T> reverse(List<T> r10) {
        if ((r10 instanceof ImmutableList) == false) goto L7;
        return ((ImmutableList) r10).reverse();
    L7:
        if ((r10 instanceof ReverseList) == false) goto L11;
        return ((ReverseList) r10).getForwardList();
    L11:
        if ((r10 instanceof RandomAccess) == false) goto L15;
        return new RandomAccessReverseList(r10);
    L15:
        return new ReverseList(r10);
    }

    public static <E> List<E> subListImpl(final List<E> r10, int r11, int r12) {
        if ((r10 instanceof RandomAccess) == false) goto L5;
        List r13 = new AnonymousClass1(r10);
    L7:
        return r13.subList(r11, r12);
    L5:
        r13 = new AnonymousClass2(r10);
        goto L7
    }

    public static <F, T> List<T> transform(List<F> r10, Function<? super F, ? extends T> r11) {
        if ((r10 instanceof RandomAccess) == false) goto L6;
        return new TransformingRandomAccessList(r10, r11);
    L6:
        return new TransformingSequentialList(r10, r11);
    }

    public static <E> List<E> asList(@NullableDecl E r10, @NullableDecl E r11, E[] r12) {
        return new TwoPlusArrayList(r10, r11, r12);
    }

    @SafeVarargs
    public static <B> List<List<B>> cartesianProduct(List<? extends B>... r10) {
        return cartesianProduct(Arrays.asList(r10));
    }

    @Beta
    public static List<Character> charactersOf(CharSequence r10) {
        return new CharSequenceAsList((CharSequence) Preconditions.checkNotNull(r10));
    }

    @SafeVarargs
    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(E... r10) {
        Preconditions.checkNotNull(r10);
        ArrayList<E> r11 = new ArrayList(computeArrayListCapacity(r10.length));
        Collections.addAll(r11, r10);
        return r11;
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(Iterable<? extends E> r10) {
        if ((r10 instanceof Collection) == false) goto L5;
        Collection r11 = Collections2.cast(r10);
    L7:
        return new CopyOnWriteArrayList(r11);
    L5:
        r11 = newArrayList(r10);
        goto L7
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> r10) {
        LinkedList<E> r11 = newLinkedList();
        Iterables.addAll(r11, r10);
        return r11;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> r10) {
        Preconditions.checkNotNull(r10);
        if ((r10 instanceof Collection) == false) goto L6;
        return new ArrayList(Collections2.cast(r10));
    L6:
        return newArrayList(r10.iterator());
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> r10) {
        ArrayList<E> r11 = newArrayList();
        Iterators.addAll(r11, r10);
        return r11;
    }
}
