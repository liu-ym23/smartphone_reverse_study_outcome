package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient AvlNode<E> header;
    private final transient GeneralRange<E> range;
    private final transient Reference<AvlNode<E>> rootReference;

    /* JADX INFO: renamed from: com.google.common.collect.TreeMultiset$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType = null;

        static {
            int[] r0 = new int[BoundType.values().length];
            $SwitchMap$com$google$common$collect$BoundType = r0;
            r0[BoundType.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$common$collect$BoundType[BoundType.CLOSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private static abstract enum Aggregate extends Enum<Aggregate> {
        private static final /* synthetic */ Aggregate[] $VALUES = null;
        public static final Aggregate DISTINCT = null;
        public static final Aggregate SIZE = null;

        abstract int nodeAggregate(AvlNode<?> r1);

        abstract long treeAggregate(@Nullable AvlNode<?> r1);

        private Aggregate(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ Aggregate(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static Aggregate valueOf(String r1) {
            return (Aggregate) Enum.valueOf(Aggregate.class, r1);
        }

        public static Aggregate[] values() {
            return (Aggregate[]) $VALUES.clone();
        }

        static {
            final String r1 = "SIZE";
            final int r2 = 0;
            Aggregate r0 = new AnonymousClass1(r1, r2);
            SIZE = r0;
            final String r3 = "DISTINCT";
            final int r4 = 1;
            Aggregate r5 = new AnonymousClass2(r3, r4);
            DISTINCT = r5;
            $VALUES = new Aggregate[]{r0, r5};
        }
    }

    private static final class AvlNode<E> extends Multisets.AbstractEntry<E> {
        private int distinctElements;

        @Nullable
        private final E elem;
        private int elemCount;
        private int height;
        private AvlNode<E> left;
        private AvlNode<E> pred;
        private AvlNode<E> right;
        private AvlNode<E> succ;
        private long totalCount;

        static /* synthetic */ AvlNode access$1000(AvlNode r0, Comparator r1, Object r2) {
            return r0.floor(r1, r2);
        }

        static /* synthetic */ AvlNode access$1100(AvlNode r0) {
            return r0.pred;
        }

        static /* synthetic */ AvlNode access$1102(AvlNode r0, AvlNode r1) {
            r0.pred = r1;
            return r1;
        }

        static /* synthetic */ int access$200(AvlNode r0) {
            return r0.elemCount;
        }

        static /* synthetic */ long access$300(AvlNode r2) {
            return r2.totalCount;
        }

        static /* synthetic */ int access$400(AvlNode r0) {
            return r0.distinctElements;
        }

        static /* synthetic */ Object access$500(AvlNode r0) {
            return r0.elem;
        }

        static /* synthetic */ AvlNode access$600(AvlNode r0) {
            return r0.left;
        }

        static /* synthetic */ AvlNode access$700(AvlNode r0) {
            return r0.right;
        }

        static /* synthetic */ AvlNode access$800(AvlNode r0, Comparator r1, Object r2) {
            return r0.ceiling(r1, r2);
        }

        static /* synthetic */ AvlNode access$900(AvlNode r0) {
            return r0.succ;
        }

        static /* synthetic */ AvlNode access$902(AvlNode r0, AvlNode r1) {
            r0.succ = r1;
            return r1;
        }

        AvlNode(@Nullable E r3, int r4) {
            if (r4 <= 0) goto L5;
            boolean r1 = true;
        L6:
            Preconditions.checkArgument(r1);
            this.elem = r3;
            this.elemCount = r4;
            this.totalCount = r4;
            this.distinctElements = 1;
            this.height = 1;
            this.left = null;
            this.right = null;
            return;
        L5:
            r1 = false;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int count(Comparator<? super E> r3, E r4) {
            int r0 = r3.compare(r4, this.elem);
            if (r0 >= 0) goto L9;
            AvlNode<E> r2 = this.left;
            if (r2 != null) goto L8;
            return 0;
        L8:
            return r2.count(r3, r4);
        L9:
            if (r0 <= 0) goto L16;
            AvlNode<E> r5 = this.right;
            if (r5 != null) goto L14;
            return 0;
        L14:
            return r5.count(r3, r4);
        L16:
            return this.elemCount;
        }

        private AvlNode<E> addRightChild(E r3, int r4) {
            AvlNode<E> r0 = new AvlNode(r3, r4);
            this.right = r0;
            TreeMultiset.access$1700(this, r0, this.succ);
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += (long) r4;
            return this;
        }

        private AvlNode<E> addLeftChild(E r3, int r4) {
            AvlNode<E> r0 = new AvlNode(r3, r4);
            this.left = r0;
            TreeMultiset.access$1700(this.pred, r0, this);
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += (long) r4;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        AvlNode<E> add(Comparator<? super E> r8, @Nullable E r9, int r10, int[] r11) {
            int r0 = r8.compare(r9, this.elem);
            boolean r1 = true;
            if (r0 >= 0) goto L16;
            AvlNode<E> r2 = this.left;
            if (r2 != null) goto L8;
            r11[0] = 0;
            return addLeftChild(r9, r10);
        L8:
            int r3 = r2.height;
            AvlNode<E> r12 = r2.add(r8, r9, r10, r11);
            this.left = r12;
            if (r11[0] != 0) goto L11;
            this.distinctElements++;
        L11:
            this.totalCount += (long) r10;
            if (r12.height != r3) goto L15;
            return this;
        L15:
            return rebalance();
        L16:
            if (r0 <= 0) goto L29;
            AvlNode<E> r4 = this.right;
            if (r4 != null) goto L21;
            r11[0] = 0;
            return addRightChild(r9, r10);
        L21:
            int r5 = r4.height;
            AvlNode<E> r13 = r4.add(r8, r9, r10, r11);
            this.right = r13;
            if (r11[0] != 0) goto L24;
            this.distinctElements++;
        L24:
            this.totalCount += (long) r10;
            if (r13.height != r5) goto L28;
            return this;
        L28:
            return rebalance();
        L29:
            int r14 = this.elemCount;
            r11[0] = r14;
            long r6 = r10;
            if ((((long) r14) + r6) <= 2147483647L) goto L33;
            r1 = false;
        L33:
            Preconditions.checkArgument(r1);
            this.elemCount += r10;
            this.totalCount += r6;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        AvlNode<E> remove(Comparator<? super E> r3, @Nullable E r4, int r5, int[] r6) {
            int r0 = r3.compare(r4, this.elem);
            if (r0 >= 0) goto L17;
            AvlNode<E> r1 = this.left;
            if (r1 != null) goto L8;
            r6[0] = 0;
            return this;
        L8:
            this.left = r1.remove(r3, r4, r5, r6);
            int r7 = r6[0];
            if (r7 <= 0) goto L13;
            if (r5 < r7) goto L12;
            this.distinctElements--;
            this.totalCount -= (long) r7;
            goto L13
        L12:
            this.totalCount -= (long) r5;
        L13:
            if (r7 != 0) goto L16;
            return this;
        L16:
            return rebalance();
        L17:
            if (r0 <= 0) goto L29;
            AvlNode<E> r2 = this.right;
            if (r2 != null) goto L22;
            r6[0] = 0;
            return this;
        L22:
            this.right = r2.remove(r3, r4, r5, r6);
            int r8 = r6[0];
            if (r8 <= 0) goto L28;
            if (r5 < r8) goto L26;
            this.distinctElements--;
            this.totalCount -= (long) r8;
            goto L28
        L26:
            this.totalCount -= (long) r5;
        L28:
            return rebalance();
        L29:
            int r9 = this.elemCount;
            r6[0] = r9;
            if (r5 >= r9) goto L32;
            this.elemCount = r9 - r5;
            this.totalCount -= (long) r5;
            return this;
        L32:
            return deleteMe();
        }

        /* JADX WARN: Multi-variable type inference failed */
        AvlNode<E> setCount(Comparator<? super E> r3, @Nullable E r4, int r5, int[] r6) {
            int r0 = r3.compare(r4, this.elem);
            if (r0 >= 0) goto L21;
            AvlNode<E> r1 = this.left;
            if (r1 != null) goto L10;
            r6[0] = 0;
            if (r5 > 0) goto L9;
            return this;
        L9:
            return addLeftChild(r4, r5);
        L10:
            this.left = r1.setCount(r3, r4, r5, r6);
            if (r5 == 0) goto L13;
        L15:
            if (r5 > 0) goto L17;
        L19:
            this.totalCount += (long) (r5 - r6[0]);
            return rebalance();
        L17:
            if (r6[0] != 0) goto L19;
            this.distinctElements++;
            goto L19
        L13:
            if (r6[0] == 0) goto L15;
            this.distinctElements--;
            goto L19
        L21:
            if (r0 <= 0) goto L39;
            AvlNode<E> r2 = this.right;
            if (r2 != null) goto L28;
            r6[0] = 0;
            if (r5 > 0) goto L27;
            return this;
        L27:
            return addRightChild(r4, r5);
        L28:
            this.right = r2.setCount(r3, r4, r5, r6);
            if (r5 == 0) goto L31;
        L33:
            if (r5 > 0) goto L35;
        L37:
            this.totalCount += (long) (r5 - r6[0]);
            return rebalance();
        L35:
            if (r6[0] != 0) goto L37;
            this.distinctElements++;
            goto L37
        L31:
            if (r6[0] == 0) goto L33;
            this.distinctElements--;
            goto L37
        L39:
            int r7 = this.elemCount;
            r6[0] = r7;
            if (r5 == 0) goto L42;
            this.totalCount += (long) (r5 - r7);
            this.elemCount = r5;
            return this;
        L42:
            return deleteMe();
        }

        /* JADX WARN: Multi-variable type inference failed */
        AvlNode<E> setCount(Comparator<? super E> r9, @Nullable E r10, int r11, int r12, int[] r13) {
            int r0 = r9.compare(r10, this.elem);
            if (r0 >= 0) goto L22;
            AvlNode<E> r2 = this.left;
            if (r2 != null) goto L11;
            r13[0] = 0;
            if (r11 != 0) goto L48;
            if (r12 > 0) goto L10;
            return this;
        L10:
            return addLeftChild(r10, r12);
        L48:
            return this;
        L11:
            this.left = r2.setCount(r9, r10, r11, r12, r13);
            int r14 = r13[0];
            if (r14 != r11) goto L21;
            if (r12 != 0) goto L16;
            if (r14 == 0) goto L16;
            this.distinctElements--;
        L19:
            this.totalCount += (long) (r12 - r14);
        L16:
            if (r12 <= 0) goto L19;
            if (r14 != 0) goto L19;
            this.distinctElements++;
        L21:
            return rebalance();
        L22:
            if (r0 <= 0) goto L41;
            AvlNode<E> r3 = this.right;
            if (r3 != null) goto L30;
            r13[0] = 0;
            if (r11 != 0) goto L50;
            if (r12 > 0) goto L29;
            return this;
        L29:
            return addRightChild(r10, r12);
        L50:
            return this;
        L30:
            this.right = r3.setCount(r9, r10, r11, r12, r13);
            int r15 = r13[0];
            if (r15 != r11) goto L40;
            if (r12 != 0) goto L35;
            if (r15 == 0) goto L35;
            this.distinctElements--;
        L38:
            this.totalCount += (long) (r12 - r15);
        L35:
            if (r12 <= 0) goto L38;
            if (r15 != 0) goto L38;
            this.distinctElements++;
        L40:
            return rebalance();
        L41:
            int r16 = this.elemCount;
            r13[0] = r16;
            if (r11 != r16) goto L47;
            if (r12 == 0) goto L45;
            this.totalCount += (long) (r12 - r16);
            this.elemCount = r12;
            goto L47
        L45:
            return deleteMe();
        L47:
            return this;
        }

        private AvlNode<E> deleteMe() {
            int r0 = this.elemCount;
            this.elemCount = 0;
            TreeMultiset.access$1800(this.pred, this.succ);
            AvlNode<E> r1 = this.left;
            if (r1 == null) goto L5;
            AvlNode<E> r2 = this.right;
            if (r2 != null) goto L10;
            return r1;
        L10:
            if (r1.height < r2.height) goto L13;
            AvlNode<E> r3 = this.pred;
            r3.left = r1.removeMax(r3);
            r3.right = this.right;
            r3.distinctElements = this.distinctElements - 1;
            r3.totalCount = this.totalCount - ((long) r0);
            return r3.rebalance();
        L13:
            AvlNode<E> r4 = this.succ;
            r4.right = r2.removeMin(r4);
            r4.left = this.left;
            r4.distinctElements = this.distinctElements - 1;
            r4.totalCount = this.totalCount - ((long) r0);
            return r4.rebalance();
        L5:
            return this.right;
        }

        private AvlNode<E> removeMin(AvlNode<E> r5) {
            AvlNode<E> r0 = this.left;
            if (r0 == null) goto L5;
            this.left = r0.removeMin(r5);
            this.distinctElements--;
            this.totalCount -= (long) r5.elemCount;
            return rebalance();
        L5:
            return this.right;
        }

        private AvlNode<E> removeMax(AvlNode<E> r5) {
            AvlNode<E> r0 = this.right;
            if (r0 == null) goto L5;
            this.right = r0.removeMax(r5);
            this.distinctElements--;
            this.totalCount -= (long) r5.elemCount;
            return rebalance();
        L5:
            return this.left;
        }

        private void recomputeMultiset() {
            this.distinctElements = (TreeMultiset.distinctElements(this.left) + 1) + TreeMultiset.distinctElements(this.right);
            this.totalCount = (((long) this.elemCount) + totalCount(this.left)) + totalCount(this.right);
        }

        private void recomputeHeight() {
            this.height = Math.max(height(this.left), height(this.right)) + 1;
        }

        private void recompute() {
            recomputeMultiset();
            recomputeHeight();
        }

        private AvlNode<E> rebalance() {
            int r0 = balanceFactor();
            if (r0 == (-2)) goto L14;
            if (r0 == 2) goto L9;
            recomputeHeight();
            return this;
        L9:
            if (this.left.balanceFactor() >= 0) goto L12;
            this.left = this.left.rotateLeft();
        L12:
            return rotateRight();
        L14:
            if (this.right.balanceFactor() <= 0) goto L17;
            this.right = this.right.rotateRight();
        L17:
            return rotateLeft();
        }

        private int balanceFactor() {
            return height(this.left) - height(this.right);
        }

        private AvlNode<E> rotateLeft() {
            if (this.right == null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0);
            AvlNode<E> r1 = this.right;
            this.right = r1.left;
            r1.left = this;
            r1.totalCount = this.totalCount;
            r1.distinctElements = this.distinctElements;
            recompute();
            r1.recomputeHeight();
            return r1;
        L5:
            r0 = false;
            goto L6
        }

        private AvlNode<E> rotateRight() {
            if (this.left == null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0);
            AvlNode<E> r1 = this.left;
            this.left = r1.right;
            r1.right = this;
            r1.totalCount = this.totalCount;
            r1.distinctElements = this.distinctElements;
            recompute();
            r1.recomputeHeight();
            return r1;
        L5:
            r0 = false;
            goto L6
        }

        private static long totalCount(@Nullable AvlNode<?> r2) {
            if (r2 != null) goto L5;
            return 0;
        L5:
            return ((AvlNode) r2).totalCount;
        }

        private static int height(@Nullable AvlNode<?> r0) {
            if (r0 != null) goto L5;
            return 0;
        L5:
            return ((AvlNode) r0).height;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        private AvlNode<E> ceiling(Comparator<? super E> r2, E r3) {
            int r0 = r2.compare(r3, this.elem);
            if (r0 >= 0) goto L9;
            AvlNode<E> r1 = this.left;
            if (r1 != null) goto L8;
            return this;
        L8:
            return (AvlNode) MoreObjects.firstNonNull(r1.ceiling(r2, r3), this);
        L9:
            if (r0 != 0) goto L11;
            return this;
        L11:
            AvlNode<E> r4 = this.right;
            if (r4 != null) goto L15;
            return null;
        L15:
            return r4.ceiling(r2, r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        private AvlNode<E> floor(Comparator<? super E> r2, E r3) {
            int r0 = r2.compare(r3, this.elem);
            if (r0 <= 0) goto L9;
            AvlNode<E> r1 = this.right;
            if (r1 != null) goto L8;
            return this;
        L8:
            return (AvlNode) MoreObjects.firstNonNull(r1.floor(r2, r3), this);
        L9:
            if (r0 != 0) goto L11;
            return this;
        L11:
            AvlNode<E> r4 = this.left;
            if (r4 != null) goto L15;
            return null;
        L15:
            return r4.floor(r2, r3);
        }

        @Override // com.google.common.collect.Multiset.Entry
        public E getElement() {
            return this.elem;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            return this.elemCount;
        }

        @Override // com.google.common.collect.Multisets.AbstractEntry, com.google.common.collect.Multiset.Entry
        public String toString() {
            return Multisets.immutableEntry(getElement(), getCount()).toString();
        }
    }

    private static final class Reference<T> {

        @Nullable
        private T value;

        private Reference() {
        }

        /* synthetic */ Reference(AnonymousClass1 r1) {
            this();
        }

        @Nullable
        public T get() {
            return this.value;
        }

        public void checkAndSet(@Nullable T r2, T r3) {
            if (this.value != r2) goto L7;
            this.value = r3;
            return;
        L7:
            throw new ConcurrentModificationException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean add(@Nullable Object r1) {
        return super.add(r1);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection r1) {
        return super.addAll(r1);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@Nullable Object r1) {
        return super.contains(r1);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean equals(@Nullable Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean remove(@Nullable Object r1) {
        return super.remove(r1);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean removeAll(Collection r1) {
        return super.removeAll(r1);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean retainAll(Collection r1) {
        return super.retainAll(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(@Nullable Object r1, BoundType r2, @Nullable Object r3, BoundType r4) {
        return super.subMultiset(r1, r2, r3, r4);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    static /* synthetic */ AvlNode access$1200(TreeMultiset r0) {
        return r0.firstNode();
    }

    static /* synthetic */ GeneralRange access$1300(TreeMultiset r0) {
        return r0.range;
    }

    static /* synthetic */ Multiset.Entry access$1400(TreeMultiset r0, AvlNode r1) {
        return r0.wrapEntry(r1);
    }

    static /* synthetic */ AvlNode access$1500(TreeMultiset r0) {
        return r0.header;
    }

    static /* synthetic */ AvlNode access$1600(TreeMultiset r0) {
        return r0.lastNode();
    }

    static /* synthetic */ void access$1700(AvlNode r0, AvlNode r1, AvlNode r2) {
        successor(r0, r1, r2);
    }

    static /* synthetic */ void access$1800(AvlNode r0, AvlNode r1) {
        successor(r0, r1);
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset(Ordering.natural());
    }

    public static <E> TreeMultiset<E> create(@Nullable Comparator<? super E> r1) {
        if (r1 != null) goto L5;
        return new TreeMultiset(Ordering.natural());
    L5:
        return new TreeMultiset(r1);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> r1) {
        TreeMultiset<E> r0 = create();
        Iterables.addAll(r0, r1);
        return r0;
    }

    TreeMultiset(Reference<AvlNode<E>> r2, GeneralRange<E> r3, AvlNode<E> r4) {
        super(r3.comparator());
        this.rootReference = r2;
        this.range = r3;
        this.header = r4;
    }

    TreeMultiset(Comparator<? super E> r3) {
        super(r3);
        this.range = GeneralRange.all(r3);
        AvlNode<E> r4 = new AvlNode(null, 1);
        this.header = r4;
        successor(r4, r4);
        this.rootReference = new Reference(null);
    }

    private long aggregateForEntries(Aggregate r6) {
        AvlNode<E> r0 = this.rootReference.get();
        long r1 = r6.treeAggregate(r0);
        if (this.range.hasLowerBound() == false) goto L6;
        r1 = r1 - aggregateBelowRange(r6, r0);
    L6:
        if (this.range.hasUpperBound() == true) goto L8;
        return r1;
    L8:
        return r1 - aggregateAboveRange(r6, r0);
    }

    private long aggregateBelowRange(Aggregate r5, @Nullable AvlNode<E> r6) {
        if (r6 != null) goto L5;
        return 0;
    L5:
        int r0 = comparator().compare(this.range.getLowerEndpoint(), AvlNode.access$500(r6));
        if (r0 < 0) goto L8;
        if (r0 != 0) goto L21;
        int r4 = AnonymousClass4.$SwitchMap$com$google$common$collect$BoundType[this.range.getLowerBoundType().ordinal()];
        if (r4 != 1) goto L13;
        long r1 = r5.nodeAggregate(r6);
        long r7 = r5.treeAggregate(AvlNode.access$600(r6));
    L20:
        return r1 + r7;
    L13:
        if (r4 != 2) goto L17;
        return r5.treeAggregate(AvlNode.access$600(r6));
    L17:
        throw new AssertionError();
    L21:
        r1 = r5.treeAggregate(AvlNode.access$600(r6)) + ((long) r5.nodeAggregate(r6));
        r7 = aggregateBelowRange(r5, AvlNode.access$700(r6));
        goto L20
    L8:
        return aggregateBelowRange(r5, AvlNode.access$600(r6));
    }

    private long aggregateAboveRange(Aggregate r5, @Nullable AvlNode<E> r6) {
        if (r6 != null) goto L5;
        return 0;
    L5:
        int r0 = comparator().compare(this.range.getUpperEndpoint(), AvlNode.access$500(r6));
        if (r0 > 0) goto L8;
        if (r0 != 0) goto L21;
        int r4 = AnonymousClass4.$SwitchMap$com$google$common$collect$BoundType[this.range.getUpperBoundType().ordinal()];
        if (r4 != 1) goto L13;
        long r1 = r5.nodeAggregate(r6);
        long r7 = r5.treeAggregate(AvlNode.access$700(r6));
    L20:
        return r1 + r7;
    L13:
        if (r4 != 2) goto L17;
        return r5.treeAggregate(AvlNode.access$700(r6));
    L17:
        throw new AssertionError();
    L21:
        r1 = r5.treeAggregate(AvlNode.access$700(r6)) + ((long) r5.nodeAggregate(r6));
        r7 = aggregateAboveRange(r5, AvlNode.access$600(r6));
        goto L20
    L8:
        return aggregateAboveRange(r5, AvlNode.access$700(r6));
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public int size() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.SIZE));
    }

    @Override // com.google.common.collect.AbstractMultiset
    int distinctElements() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int count(@Nullable Object r4) {
        AvlNode<E> r1 = this.rootReference.get();     // Catch: Throwable -> L10
        if (this.range.contains(r4) == false) goto L9;
        if (r1 == null) goto L9;
        return r1.count(comparator(), r4);
    L9:
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int add(@Nullable E r5, int r6) {
        CollectPreconditions.checkNonnegative(r6, "occurrences");
        if (r6 == 0) goto L5;
        Preconditions.checkArgument(this.range.contains(r5));
        AvlNode<E> r0 = this.rootReference.get();
        if (r0 != null) goto L10;
        comparator().compare(r5, r5);
        AvlNode<E> r2 = new AvlNode(r5, r6);
        AvlNode<E> r7 = this.header;
        successor(r7, r2, r7);
        this.rootReference.checkAndSet(r0, r2);
        return 0;
    L10:
        int[] r3 = new int[1];
        AvlNode<E> r8 = r0.add(comparator(), r5, r6, r3);
        this.rootReference.checkAndSet(r0, r8);
        return r3[0];
    L5:
        return count(r5);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int remove(@Nullable Object r5, int r6) {
        CollectPreconditions.checkNonnegative(r6, "occurrences");
        if (r6 == 0) goto L5;
        AvlNode<E> r0 = this.rootReference.get();
        int[] r1 = new int[1];
        if (this.range.contains(r5) == false) goto L14;
        if (r0 == null) goto L14;
        AvlNode<E> r7 = r0.remove(comparator(), r5, r6, r1);     // Catch: Throwable -> L15
        this.rootReference.checkAndSet(r0, r7);
        return r1[0];
    L14:
        return 0;
    L5:
        return count(r5);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int setCount(@Nullable E r5, int r6) {
        CollectPreconditions.checkNonnegative(r6, "count");
        boolean r1 = true;
        if (this.range.contains(r5) == true) goto L9;
        if (r6 == 0) goto L7;
        r1 = false;
    L7:
        Preconditions.checkArgument(r1);
        return 0;
    L9:
        AvlNode<E> r0 = this.rootReference.get();
        if (r0 != null) goto L14;
        if (r6 <= 0) goto L13;
        add(r5, r6);
    L13:
        return 0;
    L14:
        int[] r2 = new int[1];
        this.rootReference.checkAndSet(r0, r0.setCount(comparator(), r5, r6, r2));
        return r2[0];
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public boolean setCount(@Nullable E r11, int r12, int r13) {
        CollectPreconditions.checkNonnegative(r13, "newCount");
        CollectPreconditions.checkNonnegative(r12, "oldCount");
        Preconditions.checkArgument(this.range.contains(r11));
        AvlNode<E> r0 = this.rootReference.get();
        if (r0 != null) goto L9;
        if (r12 != 0) goto L8;
        if (r13 <= 0) goto L7;
        add(r11, r13);
    L7:
        return true;
    L8:
        return false;
    L9:
        int[] r9 = new int[1];
        AvlNode<E> r14 = r0.setCount(comparator(), r11, r12, r13, r9);
        this.rootReference.checkAndSet(r0, r14);
        if (r9[0] == r12) goto L12;
        return false;
    L12:
        return true;
    }

    private Multiset.Entry<E> wrapEntry(final AvlNode<E> r2) {
        return new AnonymousClass1(this, r2);
    }

    @Nullable
    private AvlNode<E> firstNode() {
        if (this.rootReference.get() != null) goto L6;
        return null;
    L6:
        if (this.range.hasLowerBound() == false) goto L15;
        E r0 = this.range.getLowerEndpoint();
        AvlNode<E> r2 = AvlNode.access$800(this.rootReference.get(), comparator(), r0);
        if (r2 != null) goto L11;
        return null;
    L11:
        if (this.range.getLowerBoundType() != BoundType.OPEN) goto L17;
        if (comparator().compare(r0, r2.getElement()) != 0) goto L17;
        r2 = AvlNode.access$900(r2);
    L17:
        if (r2 != this.header) goto L19;
        return null;
    L19:
        if (this.range.contains(r2.getElement()) == true) goto L22;
        return null;
    L22:
        return r2;
    L15:
        r2 = AvlNode.access$900(this.header);
        goto L17
    }

    @Nullable
    private AvlNode<E> lastNode() {
        if (this.rootReference.get() != null) goto L6;
        return null;
    L6:
        if (this.range.hasUpperBound() == false) goto L15;
        E r0 = this.range.getUpperEndpoint();
        AvlNode<E> r2 = AvlNode.access$1000(this.rootReference.get(), comparator(), r0);
        if (r2 != null) goto L11;
        return null;
    L11:
        if (this.range.getUpperBoundType() != BoundType.OPEN) goto L17;
        if (comparator().compare(r0, r2.getElement()) != 0) goto L17;
        r2 = AvlNode.access$1100(r2);
    L17:
        if (r2 != this.header) goto L19;
        return null;
    L19:
        if (this.range.contains(r2.getElement()) == true) goto L22;
        return null;
    L22:
        return r2;
    L15:
        r2 = AvlNode.access$1100(this.header);
        goto L17
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<Multiset.Entry<E>> entryIterator() {
        return new AnonymousClass2(this);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset
    Iterator<Multiset.Entry<E>> descendingEntryIterator() {
        return new AnonymousClass3(this);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(@Nullable E r5, BoundType r6) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), r5, r6)), this.header);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(@Nullable E r5, BoundType r6) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), r5, r6)), this.header);
    }

    static int distinctElements(@Nullable AvlNode<?> r0) {
        if (r0 != null) goto L5;
        return 0;
    L5:
        return AvlNode.access$400(r0);
    }

    private static <T> void successor(AvlNode<T> r0, AvlNode<T> r1) {
        AvlNode.access$902(r0, r1);
        AvlNode.access$1102(r1, r0);
    }

    private static <T> void successor(AvlNode<T> r0, AvlNode<T> r1, AvlNode<T> r2) {
        successor(r0, r1);
        successor(r1, r2);
    }

    private void writeObject(ObjectOutputStream r2) throws IOException {
        r2.defaultWriteObject();
        r2.writeObject(elementSet().comparator());
        Serialization.writeMultiset(this, r2);
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        Comparator r0 = (Comparator) r5.readObject();
        Serialization.getFieldSetter(AbstractSortedMultiset.class, "comparator").set(this, r0);
        Serialization.getFieldSetter(TreeMultiset.class, "range").set(this, GeneralRange.all(r0));
        Serialization.getFieldSetter(TreeMultiset.class, "rootReference").set(this, new Reference(null));
        AvlNode r1 = new AvlNode(null, 1);
        Serialization.getFieldSetter(TreeMultiset.class, "header").set(this, r1);
        successor(r1, r1);
        Serialization.populateMultiset(this, r5);
    }
}
