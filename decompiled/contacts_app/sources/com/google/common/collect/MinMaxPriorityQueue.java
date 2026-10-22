package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
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

/* JADX INFO: loaded from: classes2.dex */
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {
    private static final int DEFAULT_CAPACITY = 11;
    private static final int EVEN_POWERS_OF_TWO = 1431655765;
    private static final int ODD_POWERS_OF_TWO = -1431655766;
    private final MinMaxPriorityQueue<E>.Heap maxHeap;
    final int maximumSize;
    private final MinMaxPriorityQueue<E>.Heap minHeap;
    private int modCount;
    private Object[] queue;
    private int size;

    /* JADX INFO: renamed from: com.google.common.collect.MinMaxPriorityQueue$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder<B> {
        private static final int UNSET_EXPECTED_SIZE = -1;
        private final Comparator<B> comparator;
        private int expectedSize;
        private int maximumSize;

        /* synthetic */ Builder(Comparator r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ Ordering access$200(Builder r0) {
            return r0.ordering();
        }

        static /* synthetic */ int access$300(Builder r0) {
            return r0.maximumSize;
        }

        private Builder(Comparator<B> r2) {
            this.expectedSize = -1;
            this.maximumSize = Integer.MAX_VALUE;
            this.comparator = (Comparator) Preconditions.checkNotNull(r2);
        }

        public Builder<B> expectedSize(int r2) {
            if (r2 < 0) goto L4;
            boolean r0 = true;
        L5:
            Preconditions.checkArgument(r0);
            this.expectedSize = r2;
            return this;
        L4:
            r0 = false;
            goto L5
        }

        public Builder<B> maximumSize(int r2) {
            if (r2 <= 0) goto L4;
            boolean r0 = true;
        L5:
            Preconditions.checkArgument(r0);
            this.maximumSize = r2;
            return this;
        L4:
            r0 = false;
            goto L5
        }

        public <T extends B> MinMaxPriorityQueue<T> create() {
            return create(Collections.emptySet());
        }

        public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> r4) {
            MinMaxPriorityQueue<T> r0 = new MinMaxPriorityQueue(this, MinMaxPriorityQueue.initialQueueSize(this.expectedSize, this.maximumSize, r4), null);
            Iterator<? extends T> r3 = r4.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r0.offer(r3.next());
            goto L4
        L6:
            return r0;
        }

        private <T extends B> Ordering<T> ordering() {
            return Ordering.from(this.comparator);
        }
    }

    private class Heap {
        final Ordering<E> ordering;
        MinMaxPriorityQueue<E>.Heap otherHeap;
        final /* synthetic */ MinMaxPriorityQueue this$0;

        private int getLeftChildIndex(int r1) {
            return (r1 * 2) + 1;
        }

        private int getRightChildIndex(int r1) {
            return (r1 * 2) + 2;
        }

        static /* synthetic */ boolean access$400(Heap r0, int r1) {
            return r0.verifyIndex(r1);
        }

        Heap(MinMaxPriorityQueue r1, Ordering<E> r2) {
            this.this$0 = r1;
            this.ordering = r2;
        }

        int compareElements(int r3, int r4) {
            Ordering<E> r0 = this.ordering;
            Object r5 = this.this$0.elementData(r3);
            return r0.compare((E) r5, (E) this.this$0.elementData(r4));
        }

        MoveDesc<E> tryCrossOverAndBubbleUp(int r4, int r5, E r6) {
            int r0 = crossOver(r5, r6);
            if (r0 != r5) goto L5;
            return null;
        L5:
            if (r0 >= r4) goto L7;
            Object r7 = this.this$0.elementData(r4);
        L9:
            if (this.otherHeap.bubbleUpAlternatingLevels(r0, r6) < r4) goto L11;
            return null;
        L11:
            return new MoveDesc(r6, r7);
        L7:
            r7 = this.this$0.elementData(getParentIndex(r4));
            goto L9
        }

        void bubbleUp(int r2, E r3) {
            int r0 = crossOverUp(r2, r3);
            if (r0 == r2) goto L6;
            Heap this = this.otherHeap;
            r2 = r0;
        L6:
            this.bubbleUpAlternatingLevels(r2, r3);
        }

        int bubbleUpAlternatingLevels(int r4, E r5) {
        L3:
            if (r4 <= 2) goto L8;
            int r0 = getGrandparentIndex(r4);
            Object r1 = this.this$0.elementData(r0);
            if (this.ordering.compare((E) r1, r5) <= 0) goto L8;
            MinMaxPriorityQueue.access$500(this.this$0)[r4] = r1;
            r4 = r0;
        L8:
            MinMaxPriorityQueue.access$500(this.this$0)[r4] = r5;
            return r4;
        }

        int findMin(int r3, int r4) {
            if (r3 < MinMaxPriorityQueue.access$600(this.this$0)) goto L6;
            return -1;
        L6:
            if (r3 <= 0) goto L8;
            boolean r0 = true;
        L9:
            Preconditions.checkState(r0);
            int r1 = Math.min(r3, MinMaxPriorityQueue.access$600(this.this$0) - r4) + r4;
            int r5 = r3 + 1;
        L10:
            if (r5 >= r1) goto L15;
            if (compareElements(r5, r3) >= 0) goto L14;
            r3 = r5;
        L14:
            r5 = r5 + 1;
            goto L10
        L15:
            return r3;
        L8:
            r0 = false;
            goto L9
        }

        int findMinChild(int r2) {
            return findMin(getLeftChildIndex(r2), 2);
        }

        int findMinGrandChild(int r2) {
            int r3 = getLeftChildIndex(r2);
            if (r3 >= 0) goto L7;
            return -1;
        L7:
            return findMin(getLeftChildIndex(r3), 4);
        }

        int crossOverUp(int r6, E r7) {
            if (r6 != 0) goto L5;
            MinMaxPriorityQueue.access$500(this.this$0)[0] = r7;
            return 0;
        L5:
            int r0 = getParentIndex(r6);
            Object r1 = this.this$0.elementData(r0);
            if (r0 == 0) goto L15;
            int r2 = getRightChildIndex(getParentIndex(r0));
            if (r2 == r0) goto L15;
            if (getLeftChildIndex(r2) < MinMaxPriorityQueue.access$600(this.this$0)) goto L15;
            Object r3 = this.this$0.elementData(r2);
            if (this.ordering.compare((E) r3, (E) r1) >= 0) goto L15;
            r0 = r2;
            r1 = r3;
        L15:
            if (this.ordering.compare((E) r1, r7) >= 0) goto L18;
            MinMaxPriorityQueue.access$500(this.this$0)[r6] = r1;
            MinMaxPriorityQueue.access$500(this.this$0)[r0] = r7;
            return r0;
        L18:
            MinMaxPriorityQueue.access$500(this.this$0)[r6] = r7;
            return r6;
        }

        int getCorrectLastElement(E r4) {
            int r0 = getParentIndex(MinMaxPriorityQueue.access$600(this.this$0));
            if (r0 == 0) goto L13;
            int r1 = getRightChildIndex(getParentIndex(r0));
            if (r1 == r0) goto L13;
            if (getLeftChildIndex(r1) < MinMaxPriorityQueue.access$600(this.this$0)) goto L13;
            Object r2 = this.this$0.elementData(r1);
            if (this.ordering.compare((E) r2, r4) >= 0) goto L13;
            MinMaxPriorityQueue.access$500(this.this$0)[r1] = r4;
            MinMaxPriorityQueue.access$500(this.this$0)[MinMaxPriorityQueue.access$600(this.this$0)] = r2;
            return r1;
        L13:
            return MinMaxPriorityQueue.access$600(this.this$0);
        }

        int crossOver(int r4, E r5) {
            int r0 = findMinChild(r4);
            if (r0 <= 0) goto L9;
            if (this.ordering.compare((E) this.this$0.elementData(r0), r5) >= 0) goto L9;
            MinMaxPriorityQueue.access$500(this.this$0)[r4] = this.this$0.elementData(r0);
            MinMaxPriorityQueue.access$500(this.this$0)[r0] = r5;
            return r0;
        L9:
            return crossOverUp(r4, r5);
        }

        int fillHoleAt(int r4) {
        L2:
            int r0 = findMinGrandChild(r4);
            if (r0 <= 0) goto L5;
            MinMaxPriorityQueue.access$500(this.this$0)[r4] = this.this$0.elementData(r0);
            r4 = r0;
            goto L2
        L5:
            return r4;
        }

        private boolean verifyIndex(int r4) {
            if (getLeftChildIndex(r4) >= MinMaxPriorityQueue.access$600(this.this$0)) goto L8;
            if (compareElements(r4, getLeftChildIndex(r4)) <= 0) goto L8;
            return false;
        L8:
            if (getRightChildIndex(r4) < MinMaxPriorityQueue.access$600(this.this$0)) goto L10;
        L12:
            if (r4 <= 0) goto L17;
            if (compareElements(r4, getParentIndex(r4)) <= 0) goto L17;
            return false;
        L17:
            if (r4 > 2) goto L19;
            return true;
        L19:
            if (compareElements(getGrandparentIndex(r4), r4) <= 0) goto L23;
            return false;
        L23:
            return true;
        L10:
            if (compareElements(r4, getRightChildIndex(r4)) <= 0) goto L12;
            return false;
        }

        private int getParentIndex(int r1) {
            return (r1 - 1) / 2;
        }

        private int getGrandparentIndex(int r1) {
            return getParentIndex(getParentIndex(r1));
        }
    }

    static class MoveDesc<E> {
        final E replaced;
        final E toTrickle;

        MoveDesc(E r1, E r2) {
            this.toTrickle = r1;
            this.replaced = r2;
        }
    }

    private class QueueIterator implements Iterator<E> {
        private boolean canRemove;
        private int cursor;
        private int expectedModCount;
        private Queue<E> forgetMeNot;
        private E lastFromForgetMeNot;
        private List<E> skipMe;
        final /* synthetic */ MinMaxPriorityQueue this$0;

        private QueueIterator(MinMaxPriorityQueue r2) {
            this.this$0 = r2;
            this.cursor = -1;
            this.expectedModCount = MinMaxPriorityQueue.access$700(r2);
        }

        /* synthetic */ QueueIterator(MinMaxPriorityQueue r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkModCount();
            if (nextNotInSkipMe(this.cursor + 1) < this.this$0.size()) goto L11;
            Queue<E> r3 = this.forgetMeNot;
            if (r3 != null) goto L7;
        L9:
            return false;
        L7:
            if (r3.isEmpty() == true) goto L9;
            return true;
        L11:
            return true;
        }

        @Override // java.util.Iterator
        public E next() {
            checkModCount();
            int r0 = nextNotInSkipMe(this.cursor + 1);
            if (r0 >= this.this$0.size()) goto L7;
            this.cursor = r0;
            this.canRemove = true;
            return (E) this.this$0.elementData(r0);
        L7:
            if (this.forgetMeNot == null) goto L13;
            this.cursor = this.this$0.size();
            E r1 = this.forgetMeNot.poll();
            this.lastFromForgetMeNot = r1;
            if (r1 == null) goto L13;
            this.canRemove = true;
            return r1;
        L13:
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            checkModCount();
            this.canRemove = false;
            this.expectedModCount++;
            if (this.cursor >= this.this$0.size()) goto L11;
            MoveDesc<E> r0 = this.this$0.removeAt(this.cursor);
            if (r0 != null) goto L7;
        L10:
            this.cursor--;
            return;
        L7:
            if (this.forgetMeNot != null) goto L9;
            this.forgetMeNot = new ArrayDeque();
            this.skipMe = new ArrayList(3);
        L9:
            this.forgetMeNot.add(r0.toTrickle);
            this.skipMe.add(r0.replaced);
            goto L10
        L11:
            Preconditions.checkState(removeExact(this.lastFromForgetMeNot));
            this.lastFromForgetMeNot = null;
        }

        private boolean containsExact(Iterable<E> r1, E r2) {
            Iterator<E> r0 = r1.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            if (r0.next() != r2) goto L4;
            return true;
        L9:
            return false;
        }

        boolean removeExact(Object r4) {
            int r1 = 0;
        L4:
            if (r1 >= MinMaxPriorityQueue.access$600(this.this$0)) goto L10;
            if (MinMaxPriorityQueue.access$500(this.this$0)[r1] == r4) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            this.this$0.removeAt(r1);
            return true;
        L10:
            return false;
        }

        void checkModCount() {
            if (MinMaxPriorityQueue.access$700(this.this$0) != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private int nextNotInSkipMe(int r3) {
            if (this.skipMe != null) goto L5;
        L9:
            return r3;
        L5:
            if (r3 >= this.this$0.size()) goto L9;
            if (containsExact(this.skipMe, this.this$0.elementData(r3)) == false) goto L9;
            r3 = r3 + 1;
            goto L5
        }
    }

    /* synthetic */ MinMaxPriorityQueue(Builder r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static /* synthetic */ Object[] access$500(MinMaxPriorityQueue r0) {
        return r0.queue;
    }

    static /* synthetic */ int access$600(MinMaxPriorityQueue r0) {
        return r0.size;
    }

    static /* synthetic */ int access$700(MinMaxPriorityQueue r0) {
        return r0.modCount;
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create() {
        return new Builder(Ordering.natural(), null).create();
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> r3) {
        return new Builder(Ordering.natural(), null).create(r3);
    }

    public static <B> Builder<B> orderedBy(Comparator<B> r2) {
        return new Builder(r2, null);
    }

    public static Builder<Comparable> expectedSize(int r3) {
        return new Builder(Ordering.natural(), null).expectedSize(r3);
    }

    public static Builder<Comparable> maximumSize(int r3) {
        return new Builder(Ordering.natural(), null).maximumSize(r3);
    }

    private MinMaxPriorityQueue(Builder<? super E> r4, int r5) {
        Ordering r0 = Builder.access$200(r4);
        MinMaxPriorityQueue<E>.Heap r1 = new Heap(this, r0);
        this.minHeap = r1;
        MinMaxPriorityQueue<E>.Heap r2 = new Heap(this, r0.reverse());
        this.maxHeap = r2;
        r1.otherHeap = r2;
        r2.otherHeap = r1;
        this.maximumSize = Builder.access$300(r4);
        this.queue = new Object[r5];
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E r1) {
        offer(r1);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> r3) {
        Iterator<? extends E> r4 = r3.iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L6;
        offer(r4.next());
        r0 = true;
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.Queue
    public boolean offer(E r4) {
        Preconditions.checkNotNull(r4);
        this.modCount++;
        int r0 = this.size;
        this.size = r0 + 1;
        growIfNeeded();
        heapForIndex(r0).bubbleUp(r0, r4);
        if (this.size > this.maximumSize) goto L5;
        return true;
    L5:
        if (pollLast() != r4) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return removeAndGet(0);
    }

    E elementData(int r1) {
        return (E) this.queue[r1];
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return elementData(0);
    }

    private int getMaxElementIndex() {
        int r0 = this.size;
        if (r0 != 1) goto L5;
        return 0;
    L5:
        if (r0 != 2) goto L7;
        return 1;
    L7:
        if (this.maxHeap.compareElements(1, 2) > 0) goto L10;
        return 1;
    L10:
        return 2;
    }

    public E pollFirst() {
        return poll();
    }

    public E removeFirst() {
        return remove();
    }

    public E peekFirst() {
        return peek();
    }

    public E pollLast() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return removeAndGet(getMaxElementIndex());
    }

    public E removeLast() {
        if (isEmpty() == true) goto L7;
        return removeAndGet(getMaxElementIndex());
    L7:
        throw new NoSuchElementException();
    }

    public E peekLast() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return elementData(getMaxElementIndex());
    }

    MoveDesc<E> removeAt(int r7) {
        Preconditions.checkPositionIndex(r7, this.size);
        this.modCount++;
        int r0 = this.size - 1;
        this.size = r0;
        if (r0 != r7) goto L6;
        this.queue[r0] = null;
        return null;
    L6:
        E r1 = elementData(r0);
        int r2 = heapForIndex(this.size).getCorrectLastElement(r1);
        E r3 = elementData(this.size);
        this.queue[this.size] = null;
        MoveDesc<E> r6 = fillHole(r7, r3);
        if (r2 >= r7) goto L13;
        if (r6 != null) goto L12;
        return new MoveDesc(r1, r3);
    L12:
        return new MoveDesc(r1, r6.replaced);
    L13:
        return r6;
    }

    private MoveDesc<E> fillHole(int r4, E r5) {
        MinMaxPriorityQueue<E>.Heap r0 = heapForIndex(r4);
        int r1 = r0.fillHoleAt(r4);
        int r2 = r0.bubbleUpAlternatingLevels(r1, r5);
        if (r2 == r1) goto L5;
        if (r2 < r4) goto L10;
        return null;
    L10:
        return new MoveDesc(r5, elementData(r4));
    L5:
        return r0.tryCrossOverAndBubbleUp(r4, r1, r5);
    }

    private E removeAndGet(int r2) {
        E r0 = elementData(r2);
        removeAt(r2);
        return r0;
    }

    private MinMaxPriorityQueue<E>.Heap heapForIndex(int r1) {
        if (isEvenLevel(r1) == false) goto L6;
        return this.minHeap;
    L6:
        return this.maxHeap;
    }

    static boolean isEvenLevel(int r4) {
        int r5 = r4 + 1;
        if (r5 <= 0) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkState(r2, "negative index");
        if ((EVEN_POWERS_OF_TWO & r5) <= (r5 & ODD_POWERS_OF_TWO)) goto L10;
        return true;
    L10:
        return false;
    L5:
        r2 = false;
        goto L6
    }

    boolean isIntact() {
        int r1 = 1;
    L4:
        if (r1 >= this.size) goto L10;
        if (Heap.access$400(heapForIndex(r1), r1) == false) goto L7;
        r1 = r1 + 1;
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

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        int r1 = 0;
    L4:
        if (r1 >= this.size) goto L6;
        this.queue[r1] = null;
        r1 = r1 + 1;
        goto L4
    L6:
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        int r0 = this.size;
        Object[] r1 = new Object[r0];
        System.arraycopy(this.queue, 0, r1, 0, r0);
        return r1;
    }

    public Comparator<? super E> comparator() {
        return this.minHeap.ordering;
    }

    int capacity() {
        return this.queue.length;
    }

    static int initialQueueSize(int r1, int r2, Iterable<?> r3) {
        if (r1 != (-1)) goto L6;
        r1 = 11;
    L6:
        if ((r3 instanceof Collection) == false) goto L9;
        r1 = Math.max(r1, ((Collection) r3).size());
    L9:
        return capAtMaximumSize(r1, r2);
    }

    private void growIfNeeded() {
        if (this.size <= this.queue.length) goto L6;
        Object[] r0 = new Object[calculateNewCapacity()];
        Object[] r1 = this.queue;
        System.arraycopy(r1, 0, r0, 0, r1.length);
        this.queue = r0;
        return;
    }

    private int calculateNewCapacity() {
        int r0 = this.queue.length;
        if (r0 >= 64) goto L5;
        int r1 = (r0 + 1) * 2;
    L7:
        return capAtMaximumSize(r1, this.maximumSize);
    L5:
        r1 = IntMath.checkedMultiply(r0 / 2, 3);
        goto L7
    }

    private static int capAtMaximumSize(int r0, int r1) {
        return Math.min(r0 - 1, r1) + 1;
    }
}
