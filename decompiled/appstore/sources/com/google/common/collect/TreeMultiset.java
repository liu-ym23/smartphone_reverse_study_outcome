package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 1;
    private final transient AvlNode<E> header;
    private final transient GeneralRange<E> range;
    private final transient Reference<AvlNode<E>> rootReference;

    /* JADX INFO: renamed from: com.google.common.collect.TreeMultiset$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType = null;

        static {
            int[] r10 = new int[BoundType.values().length];
            $SwitchMap$com$google$common$collect$BoundType = r10;
            r10[BoundType.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$common$collect$BoundType[BoundType.CLOSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static abstract enum Aggregate extends Enum<Aggregate> {
        private static final /* synthetic */ Aggregate[] $VALUES = null;
        public static final Aggregate DISTINCT = null;
        public static final Aggregate SIZE = null;

        static {
            final String r10 = "SIZE";
            final int r11 = 0;
            Aggregate r12 = new AnonymousClass1(r10, r11);
            SIZE = r12;
            final String r13 = "DISTINCT";
            final int r14 = 1;
            Aggregate r15 = new AnonymousClass2(r13, r14);
            DISTINCT = r15;
            $VALUES = new Aggregate[]{r12, r15};
        }

        private Aggregate(String r10, int r11) {
            super(r10, r11);
        }

        public static Aggregate valueOf(String r10) {
            return (Aggregate) Enum.valueOf(Aggregate.class, r10);
        }

        public static Aggregate[] values() {
            return (Aggregate[]) $VALUES.clone();
        }

        public abstract int nodeAggregate(AvlNode<?> r10);

        public abstract long treeAggregate(@NullableDecl AvlNode<?> r10);

        public /* synthetic */ Aggregate(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    public static final class AvlNode<E> {
        private int distinctElements;

        @NullableDecl
        private final E elem;
        private int elemCount;
        private int height;

        @NullableDecl
        private AvlNode<E> left;

        @NullableDecl
        private AvlNode<E> pred;

        @NullableDecl
        private AvlNode<E> right;

        @NullableDecl
        private AvlNode<E> succ;
        private long totalCount;

        public AvlNode(@NullableDecl E r10, int r11) {
            if (r11 <= 0) goto L5;
            boolean r12 = true;
        L6:
            Preconditions.checkArgument(r12);
            this.elem = r10;
            this.elemCount = r11;
            this.totalCount = r11;
            this.distinctElements = 1;
            this.height = 1;
            this.left = null;
            this.right = null;
            return;
        L5:
            r12 = false;
            goto L6
        }

        public static /* synthetic */ AvlNode access$1000(AvlNode r10, Comparator r11, Object r12) {
            return r10.ceiling(r11, r12);
        }

        public static /* synthetic */ AvlNode access$1100(AvlNode r10, Comparator r11, Object r12) {
            return r10.floor(r11, r12);
        }

        public static /* synthetic */ int access$200(AvlNode r10) {
            return r10.elemCount;
        }

        public static /* synthetic */ int access$202(AvlNode r10, int r11) {
            r10.elemCount = r11;
            return r11;
        }

        public static /* synthetic */ long access$300(AvlNode r10) {
            return r10.totalCount;
        }

        public static /* synthetic */ int access$400(AvlNode r10) {
            return r10.distinctElements;
        }

        public static /* synthetic */ Object access$500(AvlNode r10) {
            return r10.elem;
        }

        public static /* synthetic */ AvlNode access$600(AvlNode r10) {
            return r10.left;
        }

        public static /* synthetic */ AvlNode access$602(AvlNode r10, AvlNode r11) {
            r10.left = r11;
            return r11;
        }

        public static /* synthetic */ AvlNode access$700(AvlNode r10) {
            return r10.right;
        }

        public static /* synthetic */ AvlNode access$702(AvlNode r10, AvlNode r11) {
            r10.right = r11;
            return r11;
        }

        public static /* synthetic */ AvlNode access$800(AvlNode r10) {
            return r10.succ;
        }

        public static /* synthetic */ AvlNode access$802(AvlNode r10, AvlNode r11) {
            r10.succ = r11;
            return r11;
        }

        public static /* synthetic */ AvlNode access$900(AvlNode r10) {
            return r10.pred;
        }

        public static /* synthetic */ AvlNode access$902(AvlNode r10, AvlNode r11) {
            r10.pred = r11;
            return r11;
        }

        private AvlNode<E> addLeftChild(E r10, int r11) {
            AvlNode<E> r12 = new AvlNode(r10, r11);
            this.left = r12;
            TreeMultiset.access$1700(this.pred, r12, this);
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += (long) r11;
            return this;
        }

        private AvlNode<E> addRightChild(E r10, int r11) {
            AvlNode<E> r12 = new AvlNode(r10, r11);
            this.right = r12;
            TreeMultiset.access$1700(this, r12, this.succ);
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += (long) r11;
            return this;
        }

        private int balanceFactor() {
            return height(this.left) - height(this.right);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NullableDecl
        private AvlNode<E> ceiling(Comparator<? super E> r10, E r11) {
            int r12 = r10.compare(r11, this.elem);
            if (r12 >= 0) goto L9;
            AvlNode<E> r13 = this.left;
            if (r13 != null) goto L8;
            return this;
        L8:
            return (AvlNode) MoreObjects.firstNonNull(r13.ceiling(r10, r11), this);
        L9:
            if (r12 != 0) goto L11;
            return this;
        L11:
            AvlNode<E> r14 = this.right;
            if (r14 != null) goto L15;
            return null;
        L15:
            return r14.ceiling(r10, r11);
        }

        private AvlNode<E> deleteMe() {
            int r10 = this.elemCount;
            this.elemCount = 0;
            TreeMultiset.access$1800(this.pred, this.succ);
            AvlNode<E> r11 = this.left;
            if (r11 == null) goto L5;
            AvlNode<E> r12 = this.right;
            if (r12 != null) goto L10;
            return r11;
        L10:
            if (r11.height < r12.height) goto L13;
            AvlNode<E> r13 = this.pred;
            r13.left = r11.removeMax(r13);
            r13.right = this.right;
            r13.distinctElements = this.distinctElements - 1;
            r13.totalCount = this.totalCount - ((long) r10);
            return r13.rebalance();
        L13:
            AvlNode<E> r14 = this.succ;
            r14.right = r12.removeMin(r14);
            r14.left = this.left;
            r14.distinctElements = this.distinctElements - 1;
            r14.totalCount = this.totalCount - ((long) r10);
            return r14.rebalance();
        L5:
            return this.right;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NullableDecl
        private AvlNode<E> floor(Comparator<? super E> r10, E r11) {
            int r12 = r10.compare(r11, this.elem);
            if (r12 <= 0) goto L9;
            AvlNode<E> r13 = this.right;
            if (r13 != null) goto L8;
            return this;
        L8:
            return (AvlNode) MoreObjects.firstNonNull(r13.floor(r10, r11), this);
        L9:
            if (r12 != 0) goto L11;
            return this;
        L11:
            AvlNode<E> r14 = this.left;
            if (r14 != null) goto L15;
            return null;
        L15:
            return r14.floor(r10, r11);
        }

        private static int height(@NullableDecl AvlNode<?> r10) {
            if (r10 != null) goto L5;
            return 0;
        L5:
            return ((AvlNode) r10).height;
        }

        private AvlNode<E> rebalance() {
            int r10 = balanceFactor();
            if (r10 == (-2)) goto L14;
            if (r10 == 2) goto L9;
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

        private void recompute() {
            recomputeMultiset();
            recomputeHeight();
        }

        private void recomputeHeight() {
            this.height = Math.max(height(this.left), height(this.right)) + 1;
        }

        private void recomputeMultiset() {
            this.distinctElements = (TreeMultiset.distinctElements(this.left) + 1) + TreeMultiset.distinctElements(this.right);
            this.totalCount = (((long) this.elemCount) + totalCount(this.left)) + totalCount(this.right);
        }

        private AvlNode<E> removeMax(AvlNode<E> r10) {
            AvlNode<E> r11 = this.right;
            if (r11 == null) goto L5;
            this.right = r11.removeMax(r10);
            this.distinctElements--;
            this.totalCount -= (long) r10.elemCount;
            return rebalance();
        L5:
            return this.left;
        }

        private AvlNode<E> removeMin(AvlNode<E> r10) {
            AvlNode<E> r11 = this.left;
            if (r11 == null) goto L5;
            this.left = r11.removeMin(r10);
            this.distinctElements--;
            this.totalCount -= (long) r10.elemCount;
            return rebalance();
        L5:
            return this.right;
        }

        private AvlNode<E> rotateLeft() {
            if (this.right == null) goto L5;
            boolean r10 = true;
        L6:
            Preconditions.checkState(r10);
            AvlNode<E> r11 = this.right;
            this.right = r11.left;
            r11.left = this;
            r11.totalCount = this.totalCount;
            r11.distinctElements = this.distinctElements;
            recompute();
            r11.recomputeHeight();
            return r11;
        L5:
            r10 = false;
            goto L6
        }

        private AvlNode<E> rotateRight() {
            if (this.left == null) goto L5;
            boolean r10 = true;
        L6:
            Preconditions.checkState(r10);
            AvlNode<E> r11 = this.left;
            this.left = r11.right;
            r11.right = this;
            r11.totalCount = this.totalCount;
            r11.distinctElements = this.distinctElements;
            recompute();
            r11.recomputeHeight();
            return r11;
        L5:
            r10 = false;
            goto L6
        }

        private static long totalCount(@NullableDecl AvlNode<?> r10) {
            if (r10 != null) goto L5;
            return 0;
        L5:
            return ((AvlNode) r10).totalCount;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AvlNode<E> add(Comparator<? super E> r10, @NullableDecl E r11, int r12, int[] r13) {
            int r14 = r10.compare(r11, this.elem);
            boolean r15 = true;
            if (r14 >= 0) goto L16;
            AvlNode<E> r16 = this.left;
            if (r16 != null) goto L8;
            r13[0] = 0;
            return addLeftChild(r11, r12);
        L8:
            int r17 = r16.height;
            AvlNode<E> r18 = r16.add(r10, r11, r12, r13);
            this.left = r18;
            if (r13[0] != 0) goto L11;
            this.distinctElements++;
        L11:
            this.totalCount += (long) r12;
            if (r18.height != r17) goto L15;
            return this;
        L15:
            return rebalance();
        L16:
            if (r14 <= 0) goto L29;
            AvlNode<E> r19 = this.right;
            if (r19 != null) goto L21;
            r13[0] = 0;
            return addRightChild(r11, r12);
        L21:
            int r20 = r19.height;
            AvlNode<E> r21 = r19.add(r10, r11, r12, r13);
            this.right = r21;
            if (r13[0] != 0) goto L24;
            this.distinctElements++;
        L24:
            this.totalCount += (long) r12;
            if (r21.height != r20) goto L28;
            return this;
        L28:
            return rebalance();
        L29:
            int r22 = this.elemCount;
            r13[0] = r22;
            long r23 = r12;
            if ((((long) r22) + r23) <= 2147483647L) goto L33;
            r15 = false;
        L33:
            Preconditions.checkArgument(r15);
            this.elemCount += r12;
            this.totalCount += r23;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int count(Comparator<? super E> r10, E r11) {
            int r12 = r10.compare(r11, this.elem);
            if (r12 >= 0) goto L9;
            AvlNode<E> r13 = this.left;
            if (r13 != null) goto L8;
            return 0;
        L8:
            return r13.count(r10, r11);
        L9:
            if (r12 <= 0) goto L16;
            AvlNode<E> r14 = this.right;
            if (r14 != null) goto L14;
            return 0;
        L14:
            return r14.count(r10, r11);
        L16:
            return this.elemCount;
        }

        public int getCount() {
            return this.elemCount;
        }

        public E getElement() {
            return this.elem;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AvlNode<E> remove(Comparator<? super E> r10, @NullableDecl E r11, int r12, int[] r13) {
            int r14 = r10.compare(r11, this.elem);
            if (r14 >= 0) goto L17;
            AvlNode<E> r15 = this.left;
            if (r15 != null) goto L8;
            r13[0] = 0;
            return this;
        L8:
            this.left = r15.remove(r10, r11, r12, r13);
            int r16 = r13[0];
            if (r16 <= 0) goto L13;
            if (r12 < r16) goto L12;
            this.distinctElements--;
            this.totalCount -= (long) r16;
            goto L13
        L12:
            this.totalCount -= (long) r12;
        L13:
            if (r16 != 0) goto L16;
            return this;
        L16:
            return rebalance();
        L17:
            if (r14 <= 0) goto L29;
            AvlNode<E> r17 = this.right;
            if (r17 != null) goto L22;
            r13[0] = 0;
            return this;
        L22:
            this.right = r17.remove(r10, r11, r12, r13);
            int r18 = r13[0];
            if (r18 <= 0) goto L28;
            if (r12 < r18) goto L26;
            this.distinctElements--;
            this.totalCount -= (long) r18;
            goto L28
        L26:
            this.totalCount -= (long) r12;
        L28:
            return rebalance();
        L29:
            int r19 = this.elemCount;
            r13[0] = r19;
            if (r12 >= r19) goto L32;
            this.elemCount = r19 - r12;
            this.totalCount -= (long) r12;
            return this;
        L32:
            return deleteMe();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AvlNode<E> setCount(Comparator<? super E> r10, @NullableDecl E r11, int r12, int[] r13) {
            int r14 = r10.compare(r11, this.elem);
            if (r14 >= 0) goto L21;
            AvlNode<E> r15 = this.left;
            if (r15 != null) goto L10;
            r13[0] = 0;
            if (r12 > 0) goto L9;
            return this;
        L9:
            return addLeftChild(r11, r12);
        L10:
            this.left = r15.setCount(r10, r11, r12, r13);
            if (r12 == 0) goto L13;
        L15:
            if (r12 > 0) goto L17;
        L19:
            this.totalCount += (long) (r12 - r13[0]);
            return rebalance();
        L17:
            if (r13[0] != 0) goto L19;
            this.distinctElements++;
            goto L19
        L13:
            if (r13[0] == 0) goto L15;
            this.distinctElements--;
            goto L19
        L21:
            if (r14 <= 0) goto L39;
            AvlNode<E> r16 = this.right;
            if (r16 != null) goto L28;
            r13[0] = 0;
            if (r12 > 0) goto L27;
            return this;
        L27:
            return addRightChild(r11, r12);
        L28:
            this.right = r16.setCount(r10, r11, r12, r13);
            if (r12 == 0) goto L31;
        L33:
            if (r12 > 0) goto L35;
        L37:
            this.totalCount += (long) (r12 - r13[0]);
            return rebalance();
        L35:
            if (r13[0] != 0) goto L37;
            this.distinctElements++;
            goto L37
        L31:
            if (r13[0] == 0) goto L33;
            this.distinctElements--;
            goto L37
        L39:
            int r17 = this.elemCount;
            r13[0] = r17;
            if (r12 == 0) goto L42;
            this.totalCount += (long) (r12 - r17);
            this.elemCount = r12;
            return this;
        L42:
            return deleteMe();
        }

        public String toString() {
            return Multisets.immutableEntry(getElement(), getCount()).toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AvlNode<E> setCount(Comparator<? super E> r10, @NullableDecl E r11, int r12, int r13, int[] r14) {
            int r15 = r10.compare(r11, this.elem);
            if (r15 >= 0) goto L22;
            AvlNode<E> r16 = this.left;
            if (r16 != null) goto L11;
            r14[0] = 0;
            if (r12 != 0) goto L48;
            if (r13 > 0) goto L10;
            return this;
        L10:
            return addLeftChild(r11, r13);
        L48:
            return this;
        L11:
            this.left = r16.setCount(r10, r11, r12, r13, r14);
            int r17 = r14[0];
            if (r17 != r12) goto L21;
            if (r13 != 0) goto L16;
            if (r17 == 0) goto L16;
            this.distinctElements--;
        L19:
            this.totalCount += (long) (r13 - r17);
        L16:
            if (r13 <= 0) goto L19;
            if (r17 != 0) goto L19;
            this.distinctElements++;
        L21:
            return rebalance();
        L22:
            if (r15 <= 0) goto L41;
            AvlNode<E> r18 = this.right;
            if (r18 != null) goto L30;
            r14[0] = 0;
            if (r12 != 0) goto L50;
            if (r13 > 0) goto L29;
            return this;
        L29:
            return addRightChild(r11, r13);
        L50:
            return this;
        L30:
            this.right = r18.setCount(r10, r11, r12, r13, r14);
            int r19 = r14[0];
            if (r19 != r12) goto L40;
            if (r13 != 0) goto L35;
            if (r19 == 0) goto L35;
            this.distinctElements--;
        L38:
            this.totalCount += (long) (r13 - r19);
        L35:
            if (r13 <= 0) goto L38;
            if (r19 != 0) goto L38;
            this.distinctElements++;
        L40:
            return rebalance();
        L41:
            int r20 = this.elemCount;
            r14[0] = r20;
            if (r12 != r20) goto L47;
            if (r13 == 0) goto L45;
            this.totalCount += (long) (r13 - r20);
            this.elemCount = r13;
            goto L47
        L45:
            return deleteMe();
        L47:
            return this;
        }
    }

    public static final class Reference<T> {

        @NullableDecl
        private T value;

        private Reference() {
        }

        public void checkAndSet(@NullableDecl T r10, T r11) {
            if (this.value != r10) goto L7;
            this.value = r11;
            return;
        L7:
            throw new ConcurrentModificationException();
        }

        public void clear() {
            this.value = null;
        }

        @NullableDecl
        public T get() {
            return this.value;
        }

        public /* synthetic */ Reference(AnonymousClass1 r10) {
            this();
        }
    }

    public TreeMultiset(Reference<AvlNode<E>> r10, GeneralRange<E> r11, AvlNode<E> r12) {
        super(r11.comparator());
        this.rootReference = r10;
        this.range = r11;
        this.header = r12;
    }

    public static /* synthetic */ AvlNode access$1200(TreeMultiset r10) {
        return r10.firstNode();
    }

    public static /* synthetic */ GeneralRange access$1300(TreeMultiset r10) {
        return r10.range;
    }

    public static /* synthetic */ Multiset.Entry access$1400(TreeMultiset r10, AvlNode r11) {
        return r10.wrapEntry(r11);
    }

    public static /* synthetic */ AvlNode access$1500(TreeMultiset r10) {
        return r10.header;
    }

    public static /* synthetic */ AvlNode access$1600(TreeMultiset r10) {
        return r10.lastNode();
    }

    public static /* synthetic */ void access$1700(AvlNode r10, AvlNode r11, AvlNode r12) {
        successor(r10, r11, r12);
    }

    public static /* synthetic */ void access$1800(AvlNode r10, AvlNode r11) {
        successor(r10, r11);
    }

    private long aggregateAboveRange(Aggregate r10, @NullableDecl AvlNode<E> r11) {
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r12 = comparator().compare(this.range.getUpperEndpoint(), AvlNode.access$500(r11));
        if (r12 > 0) goto L8;
        if (r12 != 0) goto L21;
        int r13 = AnonymousClass4.$SwitchMap$com$google$common$collect$BoundType[this.range.getUpperBoundType().ordinal()];
        if (r13 != 1) goto L13;
        long r14 = r10.nodeAggregate(r11);
        long r15 = r10.treeAggregate(AvlNode.access$700(r11));
    L20:
        return r14 + r15;
    L13:
        if (r13 != 2) goto L17;
        return r10.treeAggregate(AvlNode.access$700(r11));
    L17:
        throw new AssertionError();
    L21:
        r14 = r10.treeAggregate(AvlNode.access$700(r11)) + ((long) r10.nodeAggregate(r11));
        r15 = aggregateAboveRange(r10, AvlNode.access$600(r11));
        goto L20
    L8:
        return aggregateAboveRange(r10, AvlNode.access$700(r11));
    }

    private long aggregateBelowRange(Aggregate r10, @NullableDecl AvlNode<E> r11) {
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r12 = comparator().compare(this.range.getLowerEndpoint(), AvlNode.access$500(r11));
        if (r12 < 0) goto L8;
        if (r12 != 0) goto L21;
        int r13 = AnonymousClass4.$SwitchMap$com$google$common$collect$BoundType[this.range.getLowerBoundType().ordinal()];
        if (r13 != 1) goto L13;
        long r14 = r10.nodeAggregate(r11);
        long r15 = r10.treeAggregate(AvlNode.access$600(r11));
    L20:
        return r14 + r15;
    L13:
        if (r13 != 2) goto L17;
        return r10.treeAggregate(AvlNode.access$600(r11));
    L17:
        throw new AssertionError();
    L21:
        r14 = r10.treeAggregate(AvlNode.access$600(r11)) + ((long) r10.nodeAggregate(r11));
        r15 = aggregateBelowRange(r10, AvlNode.access$700(r11));
        goto L20
    L8:
        return aggregateBelowRange(r10, AvlNode.access$600(r11));
    }

    private long aggregateForEntries(Aggregate r10) {
        AvlNode<E> r11 = this.rootReference.get();
        long r12 = r10.treeAggregate(r11);
        if (this.range.hasLowerBound() == false) goto L6;
        r12 = r12 - aggregateBelowRange(r10, r11);
    L6:
        if (this.range.hasUpperBound() == true) goto L8;
        return r12;
    L8:
        return r12 - aggregateAboveRange(r10, r11);
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset(Ordering.natural());
    }

    @NullableDecl
    private AvlNode<E> firstNode() {
        if (this.rootReference.get() != null) goto L6;
        return null;
    L6:
        if (this.range.hasLowerBound() == false) goto L15;
        E r10 = this.range.getLowerEndpoint();
        AvlNode<E> r11 = AvlNode.access$1000(this.rootReference.get(), comparator(), r10);
        if (r11 != null) goto L11;
        return null;
    L11:
        if (this.range.getLowerBoundType() != BoundType.OPEN) goto L17;
        if (comparator().compare(r10, r11.getElement()) != 0) goto L17;
        r11 = AvlNode.access$800(r11);
    L17:
        if (r11 != this.header) goto L19;
        return null;
    L19:
        if (this.range.contains(r11.getElement()) == true) goto L22;
        return null;
    L22:
        return r11;
    L15:
        r11 = AvlNode.access$800(this.header);
        goto L17
    }

    @NullableDecl
    private AvlNode<E> lastNode() {
        if (this.rootReference.get() != null) goto L6;
        return null;
    L6:
        if (this.range.hasUpperBound() == false) goto L15;
        E r10 = this.range.getUpperEndpoint();
        AvlNode<E> r11 = AvlNode.access$1100(this.rootReference.get(), comparator(), r10);
        if (r11 != null) goto L11;
        return null;
    L11:
        if (this.range.getUpperBoundType() != BoundType.OPEN) goto L17;
        if (comparator().compare(r10, r11.getElement()) != 0) goto L17;
        r11 = AvlNode.access$900(r11);
    L17:
        if (r11 != this.header) goto L19;
        return null;
    L19:
        if (this.range.contains(r11.getElement()) == true) goto L22;
        return null;
    L22:
        return r11;
    L15:
        r11 = AvlNode.access$900(this.header);
        goto L17
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        Comparator r11 = (Comparator) r10.readObject();
        Serialization.getFieldSetter(AbstractSortedMultiset.class, "comparator").set(this, r11);
        Serialization.getFieldSetter(TreeMultiset.class, "range").set(this, GeneralRange.all(r11));
        Serialization.getFieldSetter(TreeMultiset.class, "rootReference").set(this, new Reference(null));
        AvlNode r12 = new AvlNode(null, 1);
        Serialization.getFieldSetter(TreeMultiset.class, "header").set(this, r12);
        successor(r12, r12);
        Serialization.populateMultiset(this, r10);
    }

    private static <T> void successor(AvlNode<T> r10, AvlNode<T> r11) {
        AvlNode.access$802(r10, r11);
        AvlNode.access$902(r11, r10);
    }

    private Multiset.Entry<E> wrapEntry(final AvlNode<E> r10) {
        return new AnonymousClass1(this, r10);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.defaultWriteObject();
        r10.writeObject(elementSet().comparator());
        Serialization.writeMultiset(this, r10);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(@NullableDecl E r10, int r11) {
        CollectPreconditions.checkNonnegative(r11, "occurrences");
        if (r11 == 0) goto L5;
        Preconditions.checkArgument(this.range.contains(r10));
        AvlNode<E> r12 = this.rootReference.get();
        if (r12 != null) goto L10;
        comparator().compare(r10, r10);
        AvlNode<E> r13 = new AvlNode(r10, r11);
        AvlNode<E> r14 = this.header;
        successor(r14, r13, r14);
        this.rootReference.checkAndSet(r12, r13);
        return 0;
    L10:
        int[] r15 = new int[1];
        AvlNode<E> r16 = r12.add(comparator(), r10, r11, r15);
        this.rootReference.checkAndSet(r12, r16);
        return r15[0];
    L5:
        return count(r10);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.range.hasLowerBound() == false) goto L5;
    L11:
        Iterators.clear(entryIterator());
        return;
    L5:
        if (this.range.hasUpperBound() == true) goto L11;
        AvlNode<E> r10 = AvlNode.access$800(this.header);
    L7:
        AvlNode<E> r11 = this.header;
        if (r10 == r11) goto L10;
        AvlNode<E> r12 = AvlNode.access$800(r10);
        AvlNode.access$202(r10, 0);
        AvlNode.access$602(r10, null);
        AvlNode.access$702(r10, null);
        AvlNode.access$902(r10, null);
        AvlNode.access$802(r10, null);
        r10 = r12;
        goto L7
    L10:
        successor(r11, r11);
        this.rootReference.clear();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object r10) {
        return super.contains(r10);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object r10) {
        AvlNode<E> r11 = this.rootReference.get();     // Catch: Throwable -> L10
        if (this.range.contains(r10) == false) goto L9;
        if (r11 == null) goto L9;
        return r11.count(comparator(), r10);
    L9:
        return 0;
    }

    @Override // com.google.common.collect.AbstractSortedMultiset
    public Iterator<Multiset.Entry<E>> descendingEntryIterator() {
        return new AnonymousClass3(this);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public int distinctElements() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.AbstractMultiset
    public Iterator<E> elementIterator() {
        return Multisets.elementIterator(entryIterator());
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new AnonymousClass2(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(@NullableDecl E r10, BoundType r11) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), r10, r11)), this.header);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
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

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object r10, int r11) {
        CollectPreconditions.checkNonnegative(r11, "occurrences");
        if (r11 == 0) goto L5;
        AvlNode<E> r12 = this.rootReference.get();
        int[] r13 = new int[1];
        if (this.range.contains(r10) == false) goto L14;
        if (r12 == null) goto L14;
        AvlNode<E> r14 = r12.remove(comparator(), r10, r11, r13);     // Catch: Throwable -> L15
        this.rootReference.checkAndSet(r12, r14);
        return r13[0];
    L14:
        return 0;
    L5:
        return count(r10);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(@NullableDecl E r10, int r11) {
        CollectPreconditions.checkNonnegative(r11, "count");
        boolean r12 = true;
        if (this.range.contains(r10) == true) goto L9;
        if (r11 == 0) goto L7;
        r12 = false;
    L7:
        Preconditions.checkArgument(r12);
        return 0;
    L9:
        AvlNode<E> r13 = this.rootReference.get();
        if (r13 != null) goto L14;
        if (r11 <= 0) goto L13;
        add(r10, r11);
    L13:
        return 0;
    L14:
        int[] r14 = new int[1];
        this.rootReference.checkAndSet(r13, r13.setCount(comparator(), r10, r11, r14));
        return r14[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.SIZE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(@NullableDecl Object r10, BoundType r11, @NullableDecl Object r12, BoundType r13) {
        return super.subMultiset(r10, r11, r12, r13);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(@NullableDecl E r10, BoundType r11) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), r10, r11)), this.header);
    }

    public static <E> TreeMultiset<E> create(@NullableDecl Comparator<? super E> r10) {
        if (r10 != null) goto L5;
        return new TreeMultiset(Ordering.natural());
    L5:
        return new TreeMultiset(r10);
    }

    public static int distinctElements(@NullableDecl AvlNode<?> r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        return AvlNode.access$400(r10);
    }

    private static <T> void successor(AvlNode<T> r10, AvlNode<T> r11, AvlNode<T> r12) {
        successor(r10, r11);
        successor(r11, r12);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> r10) {
        TreeMultiset<E> r11 = create();
        Iterables.addAll(r11, r10);
        return r11;
    }

    public TreeMultiset(Comparator<? super E> r10) {
        super(r10);
        this.range = GeneralRange.all(r10);
        AvlNode<E> r11 = new AvlNode(null, 1);
        this.header = r11;
        successor(r11, r11);
        this.rootReference = new Reference(null);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(@NullableDecl E r11, int r12, int r13) {
        CollectPreconditions.checkNonnegative(r13, "newCount");
        CollectPreconditions.checkNonnegative(r12, "oldCount");
        Preconditions.checkArgument(this.range.contains(r11));
        AvlNode<E> r10 = this.rootReference.get();
        if (r10 != null) goto L9;
        if (r12 != 0) goto L8;
        if (r13 <= 0) goto L7;
        add(r11, r13);
    L7:
        return true;
    L8:
        return false;
    L9:
        int[] r14 = new int[1];
        AvlNode<E> r15 = r10.setCount(comparator(), r11, r12, r13, r14);
        this.rootReference.checkAndSet(r10, r15);
        if (r14[0] == r12) goto L12;
        return false;
    L12:
        return true;
    }
}
