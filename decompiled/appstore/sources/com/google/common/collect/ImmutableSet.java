package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;

    @RetainedWith
    @NullableDecl
    @LazyInit
    private transient ImmutableList<E> asList;

    public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        private int hashCode;

        @VisibleForTesting
        @NullableDecl
        Object[] hashTable;

        public Builder() {
            super(4);
        }

        private void addDeduping(E r10) {
            int r11 = this.hashTable.length - 1;
            int r12 = r10.hashCode();
            int r13 = Hashing.smear(r12);
        L3:
            int r14 = r13 & r11;
            Object[] r15 = this.hashTable;
            Object r16 = r15[r14];
            if (r16 == null) goto L5;
            if (r16.equals(r10) == true) goto L9;
            r13 = r14 + 1;
            goto L3
        L9:
            return;
        L5:
            r15[r14] = r10;
            this.hashCode += r12;
            super.add(r10);
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
            this.hashTable = new Object[ImmutableSet.chooseTableSize(r10)];
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
        public ImmutableSet<E> build() {
            int r10 = this.size;
            if (r10 == 0) goto L22;
            if (r10 == 1) goto L20;
            if (this.hashTable != null) goto L9;
        L16:
            ImmutableSet<E> r11 = ImmutableSet.access$100(this.size, this.contents);
            this.size = r11.size();
        L17:
            this.forceCopy = true;
            this.hashTable = null;
            return r11;
        L9:
            if (ImmutableSet.chooseTableSize(r10) != this.hashTable.length) goto L16;
            if (ImmutableSet.access$000(this.size, this.contents.length) == false) goto L14;
            Object[] r12 = Arrays.copyOf(this.contents, this.size);
        L13:
            Object[] r13 = r12;
            int r14 = this.hashCode;
            Object[] r15 = this.hashTable;
            r11 = new RegularImmutableSet(r13, r14, r15, r15.length - 1, this.size);
            goto L17
        L14:
            r12 = this.contents;
            goto L13
        L20:
            return ImmutableSet.of(this.contents[0]);
        L22:
            return ImmutableSet.of();
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
            Preconditions.checkNotNull(r10);
            if (this.hashTable == null) goto L8;
            Iterator<? extends E> r11 = r10.iterator();
        L6:
            if (r11.hasNext() == false) goto L9;
            add(r11.next());
        L9:
            return this;
        L8:
            super.addAll(r10);
            goto L9
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E r10) {
            Preconditions.checkNotNull(r10);
            if (this.hashTable != null) goto L5;
        L8:
            this.hashTable = null;
            super.add(r10);
            return this;
        L5:
            if (ImmutableSet.chooseTableSize(this.size) > this.hashTable.length) goto L8;
            addDeduping(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> r10) {
            Preconditions.checkNotNull(r10);
        L4:
            if (r10.hasNext() == false) goto L6;
            add(r10.next());
            goto L4
        L6:
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... r10) {
            if (this.hashTable == null) goto L7;
            int r11 = r10.length;
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L8;
            add(r10[r12]);
            r12 = r12 + 1;
        L8:
            return this;
        L7:
            super.add(r10);
            goto L8
        }
    }

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public SerializedForm(Object[] r10) {
            this.elements = r10;
        }

        public Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    public ImmutableSet() {
    }

    public static /* synthetic */ boolean access$000(int r10, int r11) {
        return shouldTrim(r10, r11);
    }

    public static /* synthetic */ ImmutableSet access$100(int r10, Object[] r11) {
        return construct(r10, r11);
    }

    public static <E> Builder<E> builder() {
        return new Builder();
    }

    @Beta
    public static <E> Builder<E> builderWithExpectedSize(int r10) {
        CollectPreconditions.checkNonnegative(r10, "expectedSize");
        return new Builder(r10);
    }

    @VisibleForTesting
    public static int chooseTableSize(int r10) {
        int r11 = Math.max(r10, 2);
        boolean r12 = true;
        if (r11 >= CUTOFF) goto L10;
        int r13 = Integer.highestOneBit(r11 - 1) << 1;
    L6:
        if ((((double) r13) * DESIRED_LOAD_FACTOR) >= r11) goto L8;
        r13 = r13 << 1;
        goto L6
    L8:
        return r13;
    L10:
        if (r11 < 1073741824) goto L13;
        r12 = false;
    L13:
        Preconditions.checkArgument(r12, "collection too large");
        return 1073741824;
    }

    private static <E> ImmutableSet<E> construct(int r13, Object... r14) {
        if (r13 == 0) goto L31;
        if (r13 == 1) goto L29;
        int r10 = chooseTableSize(r13);
        Object[] r11 = new Object[r10];
        int r12 = r10 - 1;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
    L6:
        if (r15 >= r13) goto L15;
        Object r18 = ObjectArrays.checkElementNotNull(r14[r15], r15);
        int r19 = r18.hashCode();
        int r110 = Hashing.smear(r19);
    L8:
        int r111 = r110 & r12;
        Object r112 = r11[r111];
        if (r112 == null) goto L10;
        if (r112.equals(r18) == true) goto L13;
        r110 = r110 + 1;
    L13:
        r15 = r15 + 1;
        goto L6
    L10:
        r14[r17] = r18;
        r11[r111] = r18;
        r16 = r16 + r19;
        r17 = r17 + 1;
        goto L13
    L15:
        Arrays.fill(r14, r17, r13, null);
        if (r17 != 1) goto L20;
        return new SingletonImmutableSet(r14[0], r16);
    L20:
        if (chooseTableSize(r17) >= (r10 / 2)) goto L24;
        return construct(r17, r14);
    L24:
        if (shouldTrim(r17, r14.length) == false) goto L27;
        r14 = Arrays.copyOf(r14, r17);
    L27:
        return new RegularImmutableSet(r14, r16, r11, r12, r17);
    L29:
        return of(r14[0]);
    L31:
        return of();
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> r10) {
        if ((r10 instanceof ImmutableSet) == true) goto L5;
    L9:
        Object[] r11 = r10.toArray();
        return construct(r11.length, r11);
    L5:
        if ((r10 instanceof SortedSet) == true) goto L9;
        ImmutableSet<E> r12 = (ImmutableSet) r10;
        if (r12.isPartialView() == true) goto L9;
        return r12;
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    private static boolean shouldTrim(int r10, int r11) {
        if (r10 >= ((r11 >> 1) + (r11 >> 2))) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> r10 = this.asList;
        if (r10 != null) goto L6;
        ImmutableList<E> r11 = createAsList();
        this.asList = r11;
        return r11;
    L6:
        return r10;
    }

    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ImmutableSet) == false) goto L16;
        if (isHashCodeFast() == false) goto L16;
        if (((ImmutableSet) r10).isHashCodeFast() == false) goto L16;
        if (hashCode() == r10.hashCode()) goto L16;
        return false;
    L16:
        return Sets.equalsImpl(this, r10);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract UnmodifiableIterator<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E r10) {
        return new SingletonImmutableSet(r10);
    }

    public static <E> ImmutableSet<E> of(E r10, E r11) {
        return construct(2, new Object[]{r10, r11});
    }

    public static <E> ImmutableSet<E> of(E r10, E r11, E r12) {
        return construct(3, new Object[]{r10, r11, r12});
    }

    public static <E> ImmutableSet<E> of(E r10, E r11, E r12, E r13) {
        return construct(4, new Object[]{r10, r11, r12, r13});
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> r10) {
        if ((r10 instanceof Collection) == false) goto L6;
        return copyOf((Collection) r10);
    L6:
        return copyOf(r10.iterator());
    }

    public static <E> ImmutableSet<E> of(E r10, E r11, E r12, E r13, E r14) {
        return construct(5, new Object[]{r10, r11, r12, r13, r14});
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E r10, E r11, E r12, E r13, E r14, E r15, E... r16) {
        if (r16.length > 2147483641) goto L5;
        boolean r17 = true;
    L6:
        Preconditions.checkArgument(r17, "the total number of elements must fit in an int");
        int r18 = r16.length + 6;
        Object[] r19 = new Object[r18];
        r19[0] = r10;
        r19[1] = r11;
        r19[2] = r12;
        r19[3] = r13;
        r19[4] = r14;
        r19[5] = r15;
        System.arraycopy(r16, 0, r19, 6, r16.length);
        return construct(r18, r19);
    L5:
        r17 = false;
        goto L6
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> r10) {
        if (r10.hasNext() == false) goto L5;
        E r11 = r10.next();
        if (r10.hasNext() == true) goto L11;
        return of(r11);
    L11:
        return new Builder().add(r11).addAll(r10).build();
    L5:
        return of();
    }

    public static <E> ImmutableSet<E> copyOf(E[] r10) {
        int r11 = r10.length;
        if (r11 == 0) goto L11;
        if (r11 == 1) goto L9;
        return construct(r10.length, (Object[]) r10.clone());
    L9:
        return of(r10[0]);
    L11:
        return of();
    }
}
