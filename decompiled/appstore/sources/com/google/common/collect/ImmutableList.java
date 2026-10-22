package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    private static final UnmodifiableListIterator<Object> EMPTY_ITR = null;

    public static final class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        public Builder() {
            this(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.ArrayBasedBuilder add(Object r10) {
            return add(r10);
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterable r10) {
            return addAll(r10);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection build() {
            return build();
        }

        public Builder(int r10) {
            super(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object r10) {
            return add(r10);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterator r10) {
            return addAll(r10);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableList<E> build() {
            this.forceCopy = true;
            return ImmutableList.asImmutableList(this.contents, this.size);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object[] r10) {
            return add(r10);
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> r10) {
            super.addAll(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E r10) {
            super.add(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> r10) {
            super.addAll(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... r10) {
            super.add(r10);
            return this;
        }
    }

    public static class Itr<E> extends AbstractIndexedListIterator<E> {
        private final ImmutableList<E> list;

        public Itr(ImmutableList<E> r10, int r11) {
            super(r10.size(), r11);
            this.list = r10;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        public E get(int r10) {
            return this.list.get(r10);
        }
    }

    public static class ReverseImmutableList<E> extends ImmutableList<E> {
        private final transient ImmutableList<E> forwardList;

        public ReverseImmutableList(ImmutableList<E> r10) {
            this.forwardList = r10;
        }

        private int reverseIndex(int r10) {
            return (size() - 1) - r10;
        }

        private int reversePosition(int r10) {
            return size() - r10;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            return this.forwardList.contains(r10);
        }

        @Override // java.util.List
        public E get(int r10) {
            Preconditions.checkElementIndex(r10, size());
            return this.forwardList.get(reverseIndex(r10));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@NullableDecl Object r10) {
            int r11 = this.forwardList.lastIndexOf(r10);
            if (r11 >= 0) goto L7;
            return -1;
        L7:
            return reverseIndex(r11);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.forwardList.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@NullableDecl Object r10) {
            int r11 = this.forwardList.indexOf(r10);
            if (r11 >= 0) goto L7;
            return -1;
        L7:
            return reverseIndex(r11);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.forwardList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.forwardList.size();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ List subList(int r10, int r11) {
            return subList(r10, r11);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int r10) {
            return super.listIterator(r10);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int r10, int r11) {
            Preconditions.checkPositionIndexes(r10, r11, size());
            return this.forwardList.subList(reversePosition(r11), reversePosition(r10)).reverse();
        }
    }

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public SerializedForm(Object[] r10) {
            this.elements = r10;
        }

        public Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }
    }

    public class SubList extends ImmutableList<E> {
        final transient int length;
        final transient int offset;
        final /* synthetic */ ImmutableList this$0;

        public SubList(ImmutableList r10, int r11, int r12) {
            this.this$0 = r10;
            this.offset = r11;
            this.length = r12;
        }

        @Override // java.util.List
        public E get(int r10) {
            Preconditions.checkElementIndex(r10, this.length);
            return this.this$0.get(r10 + this.offset);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public Object[] internalArray() {
            return this.this$0.internalArray();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayEnd() {
            return (this.this$0.internalArrayStart() + this.offset) + this.length;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayStart() {
            return this.this$0.internalArrayStart() + this.offset;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ List subList(int r10, int r11) {
            return subList(r10, r11);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int r10) {
            return super.listIterator(r10);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int r10, int r11) {
            Preconditions.checkPositionIndexes(r10, r11, this.length);
            ImmutableList r12 = this.this$0;
            int r13 = this.offset;
            return r12.subList(r10 + r13, r11 + r13);
        }
    }

    static {
        EMPTY_ITR = new Itr(RegularImmutableList.EMPTY, 0);
    }

    public ImmutableList() {
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] r10) {
        return asImmutableList(r10, r10.length);
    }

    public static <E> Builder<E> builder() {
        return new Builder();
    }

    @Beta
    public static <E> Builder<E> builderWithExpectedSize(int r10) {
        CollectPreconditions.checkNonnegative(r10, "expectedSize");
        return new Builder(r10);
    }

    private static <E> ImmutableList<E> construct(Object... r10) {
        return asImmutableList(ObjectArrays.checkElementsNotNull(r10));
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> r10) {
        Preconditions.checkNotNull(r10);
        if ((r10 instanceof Collection) == false) goto L6;
        return copyOf((Collection) r10);
    L6:
        return copyOf(r10.iterator());
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) RegularImmutableList.EMPTY;
    }

    private void readObject(ObjectInputStream r10) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> r10) {
        Comparable[] r11 = (Comparable[]) Iterables.toArray(r10, new Comparable[0]);
        ObjectArrays.checkElementsNotNull(r11);
        Arrays.sort(r11);
        return asImmutableList(r11);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int r10, E r11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(int r10, Collection<? extends E> r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList<E> asList() {
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object r10) {
        if (indexOf(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r10, int r11) {
        int r12 = size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        r10[r11 + r13] = get(r13);
        r13 = r13 + 1;
        goto L3
    L6:
        return r11 + r12;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object r10) {
        return Lists.equalsImpl(this, r10);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int r10 = size();
        int r11 = 1;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11 = ~(~((r11 * 31) + get(r12).hashCode()));
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object r10) {
        if (r10 != null) goto L5;
        return -1;
    L5:
        return Lists.indexOfImpl(this, r10);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object r10) {
        if (r10 != null) goto L5;
        return -1;
    L5:
        return Lists.lastIndexOfImpl(this, r10);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E remove(int r10) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> reverse() {
        if (size() > 1) goto L6;
        return this;
    L6:
        return new ReverseImmutableList(this);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E set(int r10, E r11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ List subList(int r10, int r11) {
        return subList(r10, r11);
    }

    public ImmutableList<E> subListUnchecked(int r10, int r11) {
        return new SubList(this, r10, r11 - r10);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] r10, int r11) {
        if (r11 != 0) goto L6;
        return of();
    L6:
        return new RegularImmutableList(r10, r11);
    }

    public static <E> ImmutableList<E> of(E r10) {
        return construct(new Object[]{r10});
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int r10) {
        return listIterator(r10);
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int r10, int r11) {
        Preconditions.checkPositionIndexes(r10, r11, size());
        int r12 = r11 - r10;
        if (r12 != size()) goto L5;
        return this;
    L5:
        if (r12 != 0) goto L9;
        return of();
    L9:
        return subListUnchecked(r10, r11);
    }

    public static <E> ImmutableList<E> of(E r10, E r11) {
        return construct(new Object[]{r10, r11});
    }

    @Override // java.util.List
    public UnmodifiableListIterator<E> listIterator() {
        return listIterator(0);
    }

    public static <E> ImmutableList<E> of(E r10, E r11, E r12) {
        return construct(new Object[]{r10, r11, r12});
    }

    @Override // java.util.List
    public UnmodifiableListIterator<E> listIterator(int r10) {
        Preconditions.checkPositionIndex(r10, size());
        if (isEmpty() == false) goto L7;
        return (UnmodifiableListIterator<E>) EMPTY_ITR;
    L7:
        return new Itr(this, r10);
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> r10) {
        if ((r10 instanceof ImmutableCollection) == false) goto L9;
        ImmutableList<E> r11 = ((ImmutableCollection) r10).asList();
        if (r11.isPartialView() == true) goto L7;
        return r11;
    L7:
        return asImmutableList(r11.toArray());
    L9:
        return construct(r10.toArray());
    }

    public static <E> ImmutableList<E> of(E r10, E r11, E r12, E r13) {
        return construct(new Object[]{r10, r11, r12, r13});
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> r10, Iterable<? extends E> r11) {
        Preconditions.checkNotNull(r10);
        Object[] r12 = Iterables.toArray(r11);
        ObjectArrays.checkElementsNotNull(r12);
        Arrays.sort(r12, r10);
        return asImmutableList(r12);
    }

    public static <E> ImmutableList<E> of(E r10, E r11, E r12, E r13, E r14) {
        return construct(new Object[]{r10, r11, r12, r13, r14});
    }

    public static <E> ImmutableList<E> of(E r10, E r11, E r12, E r13, E r14, E r15) {
        return construct(new Object[]{r10, r11, r12, r13, r14, r15});
    }

    public static <E> ImmutableList<E> of(E r10, E r11, E r12, E r13, E r14, E r15, E r16) {
        return construct(new Object[]{r10, r11, r12, r13, r14, r15, r16});
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> r10) {
        if (r10.hasNext() == false) goto L5;
        E r11 = r10.next();
        if (r10.hasNext() == true) goto L11;
        return of(r11);
    L11:
        return new Builder().add(r11).addAll(r10).build();
    L5:
        return of();
    }

    public static <E> ImmutableList<E> of(E r10, E r11, E r12, E r13, E r14, E r15, E r16, E r17) {
        return construct(new Object[]{r10, r11, r12, r13, r14, r15, r16, r17});
    }

    public static <E> ImmutableList<E> of(E r10, E r11, E r12, E r13, E r14, E r15, E r16, E r17, E r18) {
        return construct(new Object[]{r10, r11, r12, r13, r14, r15, r16, r17, r18});
    }

    public static <E> ImmutableList<E> of(E r10, E r11, E r12, E r13, E r14, E r15, E r16, E r17, E r18, E r19) {
        return construct(new Object[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19});
    }

    public static <E> ImmutableList<E> of(E r10, E r11, E r12, E r13, E r14, E r15, E r16, E r17, E r18, E r19, E r110) {
        return construct(new Object[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110});
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E r10, E r11, E r12, E r13, E r14, E r15, E r16, E r17, E r18, E r19, E r110, E r111, E... r112) {
        if (r112.length > 2147483635) goto L5;
        boolean r20 = true;
    L6:
        Preconditions.checkArgument(r20, "the total number of elements must fit in an int");
        Object[] r21 = new Object[r112.length + 12];
        r21[0] = r10;
        r21[1] = r11;
        r21[2] = r12;
        r21[3] = r13;
        r21[4] = r14;
        r21[5] = r15;
        r21[6] = r16;
        r21[7] = r17;
        r21[8] = r18;
        r21[9] = r19;
        r21[10] = r110;
        r21[11] = r111;
        System.arraycopy(r112, 0, r21, 12, r112.length);
        return construct(r21);
    L5:
        r20 = false;
        goto L6
    }

    public static <E> ImmutableList<E> copyOf(E[] r10) {
        if (r10.length != 0) goto L6;
        return of();
    L6:
        return construct((Object[]) r10.clone());
    }
}
