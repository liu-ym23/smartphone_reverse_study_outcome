package reactor.util.concurrent;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import reactor.core.publisher.Hooks;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
public final class Queues {
    public static final int CAPACITY_UNSURE = Integer.MIN_VALUE;
    public static final int XS_BUFFER_SIZE = Math.max(8, Integer.parseInt(System.getProperty("reactor.bufferSize.x", "32")));
    public static final int SMALL_BUFFER_SIZE = Math.max(16, Integer.parseInt(System.getProperty("reactor.bufferSize.small", "256")));
    static final Supplier ZERO_SUPPLIER = new C3.a(6);
    static final Supplier ONE_SUPPLIER = new C3.a(7);
    static final Supplier XS_SUPPLIER = new C3.a(8);
    static final Supplier SMALL_SUPPLIER = new C3.a(9);
    static final Supplier SMALL_UNBOUNDED = new C3.a(10);
    static final Supplier XS_UNBOUNDED = new C3.a(11);

    public static final class OneQueue<T> extends AtomicReference<T> implements Queue<T> {
        private static final long serialVersionUID = -6079491923525372331L;

        @Override // java.util.Queue, java.util.Collection
        public boolean add(T t9) {
            while (!offer(t9)) {
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends T> collection) {
            return false;
        }

        @Override // java.util.Collection
        public void clear() {
            set(null);
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return Objects.equals(get(), obj);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return false;
        }

        @Override // java.util.Queue
        public T element() {
            return get();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return get() == null;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new QueueIterator(this);
        }

        @Override // java.util.Queue
        public boolean offer(T t9) {
            if (get() != null) {
                return false;
            }
            lazySet(t9);
            return true;
        }

        @Override // java.util.Queue
        @Nullable
        public T peek() {
            return get();
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            T t9 = get();
            if (t9 != null) {
                lazySet(null);
            }
            return t9;
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return false;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return false;
        }

        @Override // java.util.Collection
        public int size() {
            return get() == null ? 0 : 1;
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            T t9 = get();
            return t9 == null ? new Object[0] : new Object[]{t9};
        }

        @Override // java.util.Queue
        public T remove() {
            return getAndSet(null);
        }

        @Override // java.util.Collection
        public <T1> T1[] toArray(T1[] t1Arr) {
            int size = size();
            if (t1Arr.length < size) {
                t1Arr = (T1[]) ((Object[]) Array.newInstance(t1Arr.getClass().getComponentType(), size));
            }
            if (size == 1) {
                t1Arr[0] = get();
            }
            if (t1Arr.length > size) {
                t1Arr[size] = null;
            }
            return t1Arr;
        }
    }

    public static final class QueueIterator<T> implements Iterator<T> {
        final Queue<T> queue;

        public QueueIterator(Queue<T> queue) {
            this.queue = queue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.queue.poll();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.queue.remove();
        }
    }

    public static final class ZeroQueue<T> implements Queue<T>, Serializable {
        private static final long serialVersionUID = -8876883675795156827L;

        @Override // java.util.Queue, java.util.Collection
        public boolean add(T t9) {
            return false;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends T> collection) {
            return false;
        }

        @Override // java.util.Collection
        public void clear() {
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return false;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return false;
        }

        @Override // java.util.Queue
        public T element() {
            throw new NoSuchElementException("immutable empty queue");
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return Collections.emptyIterator();
        }

        @Override // java.util.Queue
        public boolean offer(T t9) {
            return false;
        }

        @Override // java.util.Queue
        @Nullable
        public T peek() {
            return null;
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            return null;
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return false;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return false;
        }

        @Override // java.util.Collection
        public int size() {
            return 0;
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return new Object[0];
        }

        @Override // java.util.Queue
        public T remove() {
            throw new NoSuchElementException("immutable empty queue");
        }

        @Override // java.util.Collection
        public <T1> T1[] toArray(T1[] t1Arr) {
            if (t1Arr.length > 0) {
                t1Arr[0] = null;
            }
            return t1Arr;
        }
    }

    private Queues() {
    }

    public static final int capacity(Queue queue) {
        if (queue instanceof ZeroQueue) {
            return 0;
        }
        if (queue instanceof OneQueue) {
            return 1;
        }
        if (queue instanceof SpscLinkedArrayQueue) {
            return Integer.MAX_VALUE;
        }
        if (queue instanceof SpscArrayQueue) {
            return ((SpscArrayQueue) queue).length();
        }
        if (queue instanceof MpscLinkedQueue) {
            return Integer.MAX_VALUE;
        }
        return queue instanceof BlockingQueue ? ((BlockingQueue) queue).remainingCapacity() : queue instanceof ConcurrentLinkedQueue ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }

    public static int ceilingNextPowerOfTwo(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static <T> Supplier<Queue<T>> empty() {
        return ZERO_SUPPLIER;
    }

    public static <T> Supplier<Queue<T>> get(int i) {
        if (i == Integer.MAX_VALUE) {
            return SMALL_UNBOUNDED;
        }
        if (i == XS_BUFFER_SIZE) {
            return XS_SUPPLIER;
        }
        if (i == SMALL_BUFFER_SIZE) {
            return SMALL_SUPPLIER;
        }
        if (i == 1) {
            return ONE_SUPPLIER;
        }
        if (i == 0) {
            return ZERO_SUPPLIER;
        }
        int iMax = Math.max(8, i);
        return iMax > 10000000 ? SMALL_UNBOUNDED : new a(iMax, 1);
    }

    public static boolean isPowerOfTwo(int i) {
        return Integer.bitCount(i) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Queue lambda$get$0(int i) {
        return Hooks.wrapQueue(new SpscArrayQueue(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$3() {
        return Hooks.wrapQueue(new ZeroQueue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$4() {
        return Hooks.wrapQueue(new OneQueue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$5() {
        return Hooks.wrapQueue(new SpscArrayQueue(XS_BUFFER_SIZE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$6() {
        return Hooks.wrapQueue(new SpscArrayQueue(SMALL_BUFFER_SIZE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$7() {
        return Hooks.wrapQueue(new SpscLinkedArrayQueue(SMALL_BUFFER_SIZE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$8() {
        return Hooks.wrapQueue(new SpscLinkedArrayQueue(XS_BUFFER_SIZE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Queue lambda$unbounded$1(int i) {
        return Hooks.wrapQueue(new SpscLinkedArrayQueue(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Queue lambda$unboundedMultiproducer$2() {
        return Hooks.wrapQueue(new MpscLinkedQueue());
    }

    public static <T> Supplier<Queue<T>> one() {
        return ONE_SUPPLIER;
    }

    public static <T> Supplier<Queue<T>> small() {
        return SMALL_SUPPLIER;
    }

    public static <T> Supplier<Queue<T>> unbounded() {
        return SMALL_UNBOUNDED;
    }

    public static <T> Supplier<Queue<T>> unboundedMultiproducer() {
        return new C3.a(12);
    }

    public static <T> Supplier<Queue<T>> xs() {
        return XS_SUPPLIER;
    }

    public static <T> Supplier<Queue<T>> unbounded(int i) {
        return i == XS_BUFFER_SIZE ? XS_UNBOUNDED : (i == Integer.MAX_VALUE || i == SMALL_BUFFER_SIZE) ? unbounded() : new a(i, 0);
    }
}
