package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;

    public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.ArrayBasedBuilder add(Object r1) {
            return add(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object r1) {
            return add(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object[] r1) {
            return add(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterable r1) {
            return addAll(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterator r1) {
            return addAll(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection build() {
            return build();
        }

        public Builder() {
            this(4);
        }

        Builder(int r1) {
            super(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E r1) {
            super.add(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E... r1) {
            super.add(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterable<? extends E> r1) {
            super.addAll(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterator<? extends E> r1) {
            super.addAll(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSet<E> build() {
            ImmutableSet<E> r0 = ImmutableSet.access$000(this.size, this.contents);
            this.size = r0.size();
            return r0;
        }
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] r1) {
            this.elements = r1;
        }

        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public abstract UnmodifiableIterator<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    static /* synthetic */ ImmutableSet access$000(int r0, Object[] r1) {
        return construct(r0, r1);
    }

    public static <E> ImmutableSet<E> of() {
        return EmptyImmutableSet.INSTANCE;
    }

    public static <E> ImmutableSet<E> of(E r1) {
        return new SingletonImmutableSet(r1);
    }

    public static <E> ImmutableSet<E> of(E r3, E r4) {
        return construct(2, new Object[]{r3, r4});
    }

    public static <E> ImmutableSet<E> of(E r3, E r4, E r5) {
        return construct(3, new Object[]{r3, r4, r5});
    }

    public static <E> ImmutableSet<E> of(E r3, E r4, E r5, E r6) {
        return construct(4, new Object[]{r3, r4, r5, r6});
    }

    public static <E> ImmutableSet<E> of(E r3, E r4, E r5, E r6, E r7) {
        return construct(5, new Object[]{r3, r4, r5, r6, r7});
    }

    public static <E> ImmutableSet<E> of(E r4, E r5, E r6, E r7, E r8, E r9, E... r10) {
        int r0 = r10.length + 6;
        Object[] r2 = new Object[r0];
        r2[0] = r4;
        r2[1] = r5;
        r2[2] = r6;
        r2[3] = r7;
        r2[4] = r8;
        r2[5] = r9;
        System.arraycopy(r10, 0, r2, 6, r10.length);
        return construct(r0, r2);
    }

    private static <E> ImmutableSet<E> construct(int r13, Object... r14) {
        if (r13 == 0) goto L31;
        if (r13 == 1) goto L29;
        int r2 = chooseTableSize(r13);
        Object[] r3 = new Object[r2];
        int r4 = r2 - 1;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L6:
        if (r5 >= r13) goto L15;
        Object r8 = ObjectArrays.checkElementNotNull(r14[r5], r5);
        int r9 = r8.hashCode();
        int r10 = Hashing.smear(r9);
    L8:
        int r11 = r10 & r4;
        Object r12 = r3[r11];
        if (r12 == null) goto L10;
        if (r12.equals(r8) == true) goto L13;
        r10 = r10 + 1;
    L13:
        r5 = r5 + 1;
        goto L6
    L10:
        r14[r6] = r8;
        r3[r11] = r8;
        r7 = r7 + r9;
        r6 = r6 + 1;
        goto L13
    L15:
        Arrays.fill(r14, r6, r13, null);
        if (r6 != 1) goto L20;
        return new SingletonImmutableSet(r14[0], r7);
    L20:
        if (r2 == chooseTableSize(r6)) goto L24;
        return construct(r6, r14);
    L24:
        if (r6 >= r14.length) goto L27;
        r14 = ObjectArrays.arraysCopyOf(r14, r6);
    L27:
        return new RegularImmutableSet(r14, r7, r3, r4);
    L29:
        return of(r14[0]);
    L31:
        return of();
    }

    static int chooseTableSize(int r5) {
        boolean r1 = true;
        if (r5 >= CUTOFF) goto L10;
        int r0 = Integer.highestOneBit(r5 - 1) << 1;
    L6:
        if ((((double) r0) * DESIRED_LOAD_FACTOR) >= r5) goto L8;
        r0 = r0 << 1;
        goto L6
    L8:
        return r0;
    L10:
        if (r5 < 1073741824) goto L13;
        r1 = false;
    L13:
        Preconditions.checkArgument(r1, "collection too large");
        return 1073741824;
    }

    public static <E> ImmutableSet<E> copyOf(E[] r2) {
        int r0 = r2.length;
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L9;
        return construct(r2.length, (Object[]) r2.clone());
    L9:
        return of(r2[0]);
    L11:
        return of();
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> r1) {
        if ((r1 instanceof Collection) == false) goto L6;
        return copyOf((Collection) r1);
    L6:
        return copyOf(r1.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> r2) {
        if (r2.hasNext() == false) goto L5;
        E r0 = r2.next();
        if (r2.hasNext() == true) goto L11;
        return of(r0);
    L11:
        return new Builder().add(r0).addAll(r2).build();
    L5:
        return of();
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> r2) {
        if ((r2 instanceof ImmutableSet) == false) goto L10;
        if ((r2 instanceof ImmutableSortedSet) == true) goto L10;
        ImmutableSet<E> r0 = (ImmutableSet) r2;
        if (r0.isPartialView() == true) goto L13;
        return r0;
    L13:
        Object[] r3 = r2.toArray();
        return construct(r3.length, r3);
    L10:
        if ((r2 instanceof EnumSet) == false) goto L13;
        return copyOfEnumSet((EnumSet) r2);
    }

    private static <E extends Enum<E>> ImmutableSet<E> copyOfEnumSet(EnumSet<E> r0) {
        return ImmutableEnumSet.asImmutable(EnumSet.copyOf(r0));
    }

    ImmutableSet() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@Nullable Object r3) {
        if (r3 != this) goto L6;
        return true;
    L6:
        if ((r3 instanceof ImmutableSet) == false) goto L16;
        if (isHashCodeFast() == false) goto L16;
        if (((ImmutableSet) r3).isHashCodeFast() == false) goto L16;
        if (hashCode() == r3.hashCode()) goto L16;
        return false;
    L16:
        return Sets.equalsImpl(this, r3);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> Builder<E> builder() {
        return new Builder();
    }
}
