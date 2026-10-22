package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import kotlinx.coroutines.channels.Channel;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {
    private static final int DEFAULT_CAPACITY = 11;
    private static final int EVEN_POWERS_OF_TWO = 1431655765;
    private static final int ODD_POWERS_OF_TWO = -1431655766;
    private final MinMaxPriorityQueue<E>.Heap maxHeap;

    @VisibleForTesting
    final int maximumSize;
    private final MinMaxPriorityQueue<E>.Heap minHeap;
    private int modCount;
    private Object[] queue;
    private int size;

    /* JADX INFO: renamed from: com.google.common.collect.MinMaxPriorityQueue$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    @Beta
    public static final class Builder<B> {
        private static final int UNSET_EXPECTED_SIZE = -1;
        private final Comparator<B> comparator;
        private int expectedSize;
        private int maximumSize;

        public /* synthetic */ Builder(Comparator r10, AnonymousClass1 r11) {
            this(r10);
        }

        public static /* synthetic */ Ordering access$200(Builder r10) {
            return r10.ordering();
        }

        public static /* synthetic */ int access$300(Builder r10) {
            return r10.maximumSize;
        }

        private <T extends B> Ordering<T> ordering() {
            return Ordering.from(this.comparator);
        }

        public <T extends B> MinMaxPriorityQueue<T> create() {
            return create(Collections.emptySet());
        }

        @CanIgnoreReturnValue
        public Builder<B> expectedSize(int r10) {
            if (r10 < 0) goto L4;
            boolean r11 = true;
        L5:
            Preconditions.checkArgument(r11);
            this.expectedSize = r10;
            return this;
        L4:
            r11 = false;
            goto L5
        }

        @CanIgnoreReturnValue
        public Builder<B> maximumSize(int r10) {
            if (r10 <= 0) goto L4;
            boolean r11 = true;
        L5:
            Preconditions.checkArgument(r11);
            this.maximumSize = r10;
            return this;
        L4:
            r11 = false;
            goto L5
        }

        private Builder(Comparator<B> r10) {
            this.expectedSize = -1;
            this.maximumSize = Channel.UNLIMITED;
            this.comparator = (Comparator) Preconditions.checkNotNull(r10);
        }

        public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> r10) {
            MinMaxPriorityQueue<T> r11 = new MinMaxPriorityQueue(this, MinMaxPriorityQueue.initialQueueSize(this.expectedSize, this.maximumSize, r10), null);
            Iterator<? extends T> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            r11.offer(r12.next());
            goto L4
        L6:
            return r11;
        }
    }

    public class Heap {
        final Ordering<E> ordering;

        @Weak
        @MonotonicNonNullDecl
        MinMaxPriorityQueue<E>.Heap otherHeap;
        final /* synthetic */ MinMaxPriorityQueue this$0;

        public Heap(MinMaxPriorityQueue r10, Ordering<E> r11) {
            this.this$0 = r10;
            this.ordering = r11;
        }

        public static /* synthetic */ boolean access$400(Heap r10, int r11) {
            return r10.verifyIndex(r11);
        }

        private int getGrandparentIndex(int r10) {
            return getParentIndex(getParentIndex(r10));
        }

        private int getLeftChildIndex(int r10) {
            return (r10 * 2) + 1;
        }

        private int getParentIndex(int r10) {
            return (r10 - 1) / 2;
        }

        private int getRightChildIndex(int r10) {
            return (r10 * 2) + 2;
        }

        private boolean verifyIndex(int r10) {
            if (getLeftChildIndex(r10) >= MinMaxPriorityQueue.access$600(this.this$0)) goto L8;
            if (compareElements(r10, getLeftChildIndex(r10)) <= 0) goto L8;
            return false;
        L8:
            if (getRightChildIndex(r10) < MinMaxPriorityQueue.access$600(this.this$0)) goto L10;
        L12:
            if (r10 <= 0) goto L17;
            if (compareElements(r10, getParentIndex(r10)) <= 0) goto L17;
            return false;
        L17:
            if (r10 > 2) goto L19;
            return true;
        L19:
            if (compareElements(getGrandparentIndex(r10), r10) <= 0) goto L23;
            return false;
        L23:
            return true;
        L10:
            if (compareElements(r10, getRightChildIndex(r10)) <= 0) goto L12;
            return false;
        }

        public void bubbleUp(int r10, E r11) {
            int r12 = crossOverUp(r10, r11);
            if (r12 == r10) goto L6;
            Heap this = this.otherHeap;
            r10 = r12;
        L6:
            this.bubbleUpAlternatingLevels(r10, r11);
        }

        @CanIgnoreReturnValue
        public int bubbleUpAlternatingLevels(int r10, E r11) {
        L3:
            if (r10 <= 2) goto L8;
            int r12 = getGrandparentIndex(r10);
            Object r13 = this.this$0.elementData(r12);
            if (this.ordering.compare((E) r13, r11) <= 0) goto L8;
            MinMaxPriorityQueue.access$500(this.this$0)[r10] = r13;
            r10 = r12;
        L8:
            MinMaxPriorityQueue.access$500(this.this$0)[r10] = r11;
            return r10;
        }

        public int compareElements(int r10, int r11) {
            Ordering<E> r12 = this.ordering;
            Object r13 = this.this$0.elementData(r10);
            return r12.compare((E) r13, (E) this.this$0.elementData(r11));
        }

        public int crossOver(int r10, E r11) {
            int r12 = findMinChild(r10);
            if (r12 <= 0) goto L9;
            if (this.ordering.compare((E) this.this$0.elementData(r12), r11) >= 0) goto L9;
            MinMaxPriorityQueue.access$500(this.this$0)[r10] = this.this$0.elementData(r12);
            MinMaxPriorityQueue.access$500(this.this$0)[r12] = r11;
            return r12;
        L9:
            return crossOverUp(r10, r11);
        }

        public int crossOverUp(int r10, E r11) {
            if (r10 != 0) goto L5;
            MinMaxPriorityQueue.access$500(this.this$0)[0] = r11;
            return 0;
        L5:
            int r12 = getParentIndex(r10);
            Object r13 = this.this$0.elementData(r12);
            if (r12 == 0) goto L15;
            int r14 = getRightChildIndex(getParentIndex(r12));
            if (r14 == r12) goto L15;
            if (getLeftChildIndex(r14) < MinMaxPriorityQueue.access$600(this.this$0)) goto L15;
            Object r15 = this.this$0.elementData(r14);
            if (this.ordering.compare((E) r15, (E) r13) >= 0) goto L15;
            r12 = r14;
            r13 = r15;
        L15:
            if (this.ordering.compare((E) r13, r11) >= 0) goto L18;
            MinMaxPriorityQueue.access$500(this.this$0)[r10] = r13;
            MinMaxPriorityQueue.access$500(this.this$0)[r12] = r11;
            return r12;
        L18:
            MinMaxPriorityQueue.access$500(this.this$0)[r10] = r11;
            return r10;
        }

        public int fillHoleAt(int r10) {
        L2:
            int r11 = findMinGrandChild(r10);
            if (r11 <= 0) goto L5;
            MinMaxPriorityQueue.access$500(this.this$0)[r10] = this.this$0.elementData(r11);
            r10 = r11;
            goto L2
        L5:
            return r10;
        }

        public int findMin(int r10, int r11) {
            if (r10 < MinMaxPriorityQueue.access$600(this.this$0)) goto L6;
            return -1;
        L6:
            if (r10 <= 0) goto L8;
            boolean r12 = true;
        L9:
            Preconditions.checkState(r12);
            int r13 = Math.min(r10, MinMaxPriorityQueue.access$600(this.this$0) - r11) + r11;
            int r14 = r10 + 1;
        L10:
            if (r14 >= r13) goto L15;
            if (compareElements(r14, r10) >= 0) goto L14;
            r10 = r14;
        L14:
            r14 = r14 + 1;
            goto L10
        L15:
            return r10;
        L8:
            r12 = false;
            goto L9
        }

        public int findMinChild(int r10) {
            return findMin(getLeftChildIndex(r10), 2);
        }

        public int findMinGrandChild(int r10) {
            int r11 = getLeftChildIndex(r10);
            if (r11 >= 0) goto L7;
            return -1;
        L7:
            return findMin(getLeftChildIndex(r11), 4);
        }

        public int swapWithConceptuallyLastElement(E r10) {
            int r11 = getParentIndex(MinMaxPriorityQueue.access$600(this.this$0));
            if (r11 == 0) goto L13;
            int r12 = getRightChildIndex(getParentIndex(r11));
            if (r12 == r11) goto L13;
            if (getLeftChildIndex(r12) < MinMaxPriorityQueue.access$600(this.this$0)) goto L13;
            Object r13 = this.this$0.elementData(r12);
            if (this.ordering.compare((E) r13, r10) >= 0) goto L13;
            MinMaxPriorityQueue.access$500(this.this$0)[r12] = r10;
            MinMaxPriorityQueue.access$500(this.this$0)[MinMaxPriorityQueue.access$600(this.this$0)] = r13;
            return r12;
        L13:
            return MinMaxPriorityQueue.access$600(this.this$0);
        }

        public MoveDesc<E> tryCrossOverAndBubbleUp(int r10, int r11, E r12) {
            int r13 = crossOver(r11, r12);
            if (r13 != r11) goto L5;
            return null;
        L5:
            if (r13 >= r10) goto L7;
            Object r14 = this.this$0.elementData(r10);
        L9:
            if (this.otherHeap.bubbleUpAlternatingLevels(r13, r12) < r10) goto L11;
            return null;
        L11:
            return new MoveDesc(r12, r14);
        L7:
            r14 = this.this$0.elementData(getParentIndex(r10));
            goto L9
        }
    }

    public static class MoveDesc<E> {
        final E replaced;
        final E toTrickle;

        public MoveDesc(E r10, E r11) {
            this.toTrickle = r10;
            this.replaced = r11;
        }
    }

    public class QueueIterator implements Iterator<E> {
        private boolean canRemove;
        private int cursor;
        private int expectedModCount;

        @MonotonicNonNullDecl
        private Queue<E> forgetMeNot;

        @NullableDecl
        private E lastFromForgetMeNot;
        private int nextCursor;

        @MonotonicNonNullDecl
        private List<E> skipMe;
        final /* synthetic */ MinMaxPriorityQueue this$0;

        private QueueIterator(MinMaxPriorityQueue r10) {
            this.this$0 = r10;
            this.cursor = -1;
            this.nextCursor = -1;
            this.expectedModCount = MinMaxPriorityQueue.access$700(r10);
        }

        private void checkModCount() {
            if (MinMaxPriorityQueue.access$700(this.this$0) != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        private boolean foundAndRemovedExactReference(Iterable<E> r10, E r11) {
            Iterator<E> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L9;
            if (r12.next() != r11) goto L4;
            r12.remove();
            return true;
        L9:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void nextNotInSkipMe(int r10) {
            if (this.nextCursor < r10) goto L5;
            return;
        L5:
            if (this.skipMe != null) goto L7;
        L11:
            this.nextCursor = r10;
            return;
        L7:
            if (r10 >= this.this$0.size()) goto L11;
            if (foundAndRemovedExactReference(this.skipMe, this.this$0.elementData(r10)) == false) goto L11;
            r10 = r10 + 1;
            goto L7
        }

        private boolean removeExact(Object r10) {
            int r11 = 0;
        L4:
            if (r11 >= MinMaxPriorityQueue.access$600(this.this$0)) goto L10;
            if (MinMaxPriorityQueue.access$500(this.this$0)[r11] == r10) goto L7;
            r11 = r11 + 1;
            goto L4
        L7:
            this.this$0.removeAt(r11);
            return true;
        L10:
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            if (this.nextCursor < this.this$0.size()) goto L11;
            Queue<E> r10 = this.forgetMeNot;
            if (r10 != null) goto L7;
        L9:
            return false;
        L7:
            if (r10.isEmpty() == true) goto L9;
            return true;
        L11:
            return true;
        }

        @Override // java.util.Iterator
        public E next() {
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            if (this.nextCursor >= this.this$0.size()) goto L7;
            int r10 = this.nextCursor;
            this.cursor = r10;
            this.canRemove = true;
            return (E) this.this$0.elementData(r10);
        L7:
            if (this.forgetMeNot == null) goto L13;
            this.cursor = this.this$0.size();
            E r11 = this.forgetMeNot.poll();
            this.lastFromForgetMeNot = r11;
            if (r11 == null) goto L13;
            this.canRemove = true;
            return r11;
        L13:
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            checkModCount();
            this.canRemove = false;
            this.expectedModCount++;
            if (this.cursor >= this.this$0.size()) goto L16;
            MoveDesc<E> r10 = this.this$0.removeAt(this.cursor);
            if (r10 != null) goto L7;
        L15:
            this.cursor--;
            this.nextCursor--;
            return;
        L7:
            if (this.forgetMeNot != null) goto L10;
            this.forgetMeNot = new ArrayDeque();
            this.skipMe = new ArrayList(3);
        L10:
            if (foundAndRemovedExactReference(this.skipMe, r10.toTrickle) == true) goto L13;
            this.forgetMeNot.add(r10.toTrickle);
        L13:
            if (foundAndRemovedExactReference(this.forgetMeNot, r10.replaced) == true) goto L15;
            this.skipMe.add(r10.replaced);
            goto L15
        L16:
            Preconditions.checkState(removeExact(this.lastFromForgetMeNot));
            this.lastFromForgetMeNot = null;
        }

        public /* synthetic */ QueueIterator(MinMaxPriorityQueue r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public /* synthetic */ MinMaxPriorityQueue(Builder r10, int r11, AnonymousClass1 r12) {
        this(r10, r11);
    }

    public static /* synthetic */ Object[] access$500(MinMaxPriorityQueue r10) {
        return r10.queue;
    }

    public static /* synthetic */ int access$600(MinMaxPriorityQueue r10) {
        return r10.size;
    }

    public static /* synthetic */ int access$700(MinMaxPriorityQueue r10) {
        return r10.modCount;
    }

    private int calculateNewCapacity() {
        int r10 = this.queue.length;
        if (r10 >= 64) goto L5;
        int r11 = (r10 + 1) * 2;
    L7:
        return capAtMaximumSize(r11, this.maximumSize);
    L5:
        r11 = IntMath.checkedMultiply(r10 / 2, 3);
        goto L7
    }

    private static int capAtMaximumSize(int r10, int r11) {
        return Math.min(r10 - 1, r11) + 1;
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create() {
        return new Builder(Ordering.natural(), null).create();
    }

    public static Builder<Comparable> expectedSize(int r10) {
        return new Builder(Ordering.natural(), null).expectedSize(r10);
    }

    private MoveDesc<E> fillHole(int r10, E r11) {
        MinMaxPriorityQueue<E>.Heap r12 = heapForIndex(r10);
        int r13 = r12.fillHoleAt(r10);
        int r14 = r12.bubbleUpAlternatingLevels(r13, r11);
        if (r14 == r13) goto L5;
        if (r14 < r10) goto L10;
        return null;
    L10:
        return new MoveDesc(r11, elementData(r10));
    L5:
        return r12.tryCrossOverAndBubbleUp(r10, r13, r11);
    }

    private int getMaxElementIndex() {
        int r10 = this.size;
        if (r10 != 1) goto L5;
        return 0;
    L5:
        if (r10 != 2) goto L7;
        return 1;
    L7:
        if (this.maxHeap.compareElements(1, 2) > 0) goto L10;
        return 1;
    L10:
        return 2;
    }

    private void growIfNeeded() {
        if (this.size <= this.queue.length) goto L6;
        Object[] r10 = new Object[calculateNewCapacity()];
        Object[] r11 = this.queue;
        System.arraycopy(r11, 0, r10, 0, r11.length);
        this.queue = r10;
        return;
    }

    private MinMaxPriorityQueue<E>.Heap heapForIndex(int r10) {
        if (isEvenLevel(r10) == false) goto L6;
        return this.minHeap;
    L6:
        return this.maxHeap;
    }

    @VisibleForTesting
    public static int initialQueueSize(int r10, int r11, Iterable<?> r12) {
        if (r10 != (-1)) goto L6;
        r10 = 11;
    L6:
        if ((r12 instanceof Collection) == false) goto L9;
        r10 = Math.max(r10, ((Collection) r12).size());
    L9:
        return capAtMaximumSize(r10, r11);
    }

    @VisibleForTesting
    public static boolean isEvenLevel(int r10) {
        int r11 = ~(~(r10 + 1));
        if (r11 <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12, "negative index");
        if ((EVEN_POWERS_OF_TWO & r11) <= (r11 & ODD_POWERS_OF_TWO)) goto L10;
        return true;
    L10:
        return false;
    L5:
        r12 = false;
        goto L6
    }

    public static Builder<Comparable> maximumSize(int r10) {
        return new Builder(Ordering.natural(), null).maximumSize(r10);
    }

    public static <B> Builder<B> orderedBy(Comparator<B> r10) {
        return new Builder(r10, null);
    }

    private E removeAndGet(int r10) {
        E r11 = elementData(r10);
        removeAt(r10);
        return r11;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E r10) {
        offer(r10);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> r10) {
        Iterator<? extends E> r11 = r10.iterator();
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L6;
        offer(r11.next());
        r12 = true;
        goto L4
    L6:
        return r12;
    }

    @VisibleForTesting
    public int capacity() {
        return this.queue.length;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        int r10 = 0;
    L4:
        if (r10 >= this.size) goto L6;
        this.queue[r10] = null;
        r10 = r10 + 1;
        goto L4
    L6:
        this.size = 0;
    }

    public Comparator<? super E> comparator() {
        return this.minHeap.ordering;
    }

    public E elementData(int r10) {
        return (E) this.queue[r10];
    }

    @VisibleForTesting
    public boolean isIntact() {
        int r10 = 1;
    L4:
        if (r10 >= this.size) goto L10;
        if (Heap.access$400(heapForIndex(r10), r10) == false) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return false;
    L10:
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new QueueIterator(this, null);
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E r10) {
        Preconditions.checkNotNull(r10);
        this.modCount++;
        int r11 = this.size;
        this.size = r11 + 1;
        growIfNeeded();
        heapForIndex(r11).bubbleUp(r11, r10);
        if (this.size > this.maximumSize) goto L5;
        return true;
    L5:
        if (pollLast() != r10) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return elementData(0);
    }

    public E peekFirst() {
        return peek();
    }

    public E peekLast() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return elementData(getMaxElementIndex());
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E poll() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return removeAndGet(0);
    }

    @CanIgnoreReturnValue
    public E pollFirst() {
        return poll();
    }

    @CanIgnoreReturnValue
    public E pollLast() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return removeAndGet(getMaxElementIndex());
    }

    @VisibleForTesting
    @CanIgnoreReturnValue
    public MoveDesc<E> removeAt(int r10) {
        Preconditions.checkPositionIndex(r10, this.size);
        this.modCount++;
        int r11 = this.size - 1;
        this.size = r11;
        if (r11 != r10) goto L6;
        this.queue[r11] = null;
        return null;
    L6:
        E r12 = elementData(r11);
        int r13 = heapForIndex(this.size).swapWithConceptuallyLastElement(r12);
        if (r13 != r10) goto L10;
        this.queue[this.size] = null;
        return null;
    L10:
        E r14 = elementData(this.size);
        this.queue[this.size] = null;
        MoveDesc<E> r15 = fillHole(r10, r14);
        if (r13 >= r10) goto L17;
        if (r15 != null) goto L16;
        return new MoveDesc(r12, r14);
    L16:
        return new MoveDesc(r12, r15.replaced);
    L17:
        return r15;
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return remove();
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        if (isEmpty() == true) goto L7;
        return removeAndGet(getMaxElementIndex());
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        int r10 = this.size;
        Object[] r11 = new Object[r10];
        System.arraycopy(this.queue, 0, r11, 0, r10);
        return r11;
    }

    private MinMaxPriorityQueue(Builder<? super E> r10, int r11) {
        Ordering r12 = Builder.access$200(r10);
        MinMaxPriorityQueue<E>.Heap r13 = new Heap(this, r12);
        this.minHeap = r13;
        MinMaxPriorityQueue<E>.Heap r14 = new Heap(this, r12.reverse());
        this.maxHeap = r14;
        r13.otherHeap = r14;
        r14.otherHeap = r13;
        this.maximumSize = Builder.access$300(r10);
        this.queue = new Object[r11];
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> r10) {
        return new Builder(Ordering.natural(), null).create(r10);
    }
}
