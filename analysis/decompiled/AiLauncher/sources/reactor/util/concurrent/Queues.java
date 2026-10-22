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
import reactor.util.concurrent.Queues;

/* loaded from: classes5.dex */
public final class Queues {
    public static final int CAPACITY_UNSURE = Integer.MIN_VALUE;
    public static final int XS_BUFFER_SIZE = Math.max(8, Integer.parseInt(System.getProperty("reactor.bufferSize.x", "32")));
    public static final int SMALL_BUFFER_SIZE = Math.max(16, Integer.parseInt(System.getProperty("reactor.bufferSize.small", "256")));
    static final Supplier ZERO_SUPPLIER = new Supplier() { // from class: reactor.util.concurrent.a
        @Override // java.util.function.Supplier
        public final Object get() {
            return Hooks.wrapQueue(new Queues.ZeroQueue());
        }
    };
    static final Supplier ONE_SUPPLIER = new Supplier() { // from class: reactor.util.concurrent.b
        @Override // java.util.function.Supplier
        public final Object get() {
            return Hooks.wrapQueue(new Queues.OneQueue());
        }
    };
    static final Supplier XS_SUPPLIER = new Supplier() { // from class: reactor.util.concurrent.c
        @Override // java.util.function.Supplier
        public final Object get() {
            return Hooks.wrapQueue(new SpscArrayQueue(Queues.XS_BUFFER_SIZE));
        }
    };
    static final Supplier SMALL_SUPPLIER = new Supplier() { // from class: reactor.util.concurrent.d
        @Override // java.util.function.Supplier
        public final Object get() {
            return Hooks.wrapQueue(new SpscArrayQueue(Queues.SMALL_BUFFER_SIZE));
        }
    };
    static final Supplier SMALL_UNBOUNDED = new Supplier() { // from class: reactor.util.concurrent.e
        @Override // java.util.function.Supplier
        public final Object get() {
            return Hooks.wrapQueue(new SpscLinkedArrayQueue(Queues.SMALL_BUFFER_SIZE));
        }
    };
    static final Supplier XS_UNBOUNDED = new Supplier() { // from class: reactor.util.concurrent.f
        @Override // java.util.function.Supplier
        public final Object get() {
            return Hooks.wrapQueue(new SpscLinkedArrayQueue(Queues.XS_BUFFER_SIZE));
        }
    };

    public static final class OneQueue<T> extends AtomicReference<T> implements Queue<T> {
        private static final long serialVersionUID = -6079491923525372331L;

        @Override // java.util.Queue, java.util.Collection
        public boolean add(T t10) {
            while (!offer(t10)) {
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
        public boolean offer(T t10) {
            if (get() != null) {
                return false;
            }
            lazySet(t10);
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
            T t10 = get();
            if (t10 != null) {
                lazySet(null);
            }
            return t10;
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
            T t10 = get();
            return t10 == null ? new Object[0] : new Object[]{t10};
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
        public boolean add(T t10) {
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
        public boolean offer(T t10) {
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

    public static int ceilingNextPowerOfTwo(int i10) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i10 - 1));
    }

    public static <T> Supplier<Queue<T>> empty() {
        return ZERO_SUPPLIER;
    }

    public static <T> Supplier<Queue<T>> get(int i10) {
        if (i10 == Integer.MAX_VALUE) {
            return SMALL_UNBOUNDED;
        }
        if (i10 == XS_BUFFER_SIZE) {
            return XS_SUPPLIER;
        }
        if (i10 == SMALL_BUFFER_SIZE) {
            return SMALL_SUPPLIER;
        }
        if (i10 == 1) {
            return ONE_SUPPLIER;
        }
        if (i10 == 0) {
            return ZERO_SUPPLIER;
        }
        final int iMax = Math.max(8, i10);
        return iMax > 10000000 ? SMALL_UNBOUNDED : new Supplier() { // from class: reactor.util.concurrent.h
            @Override // java.util.function.Supplier
            public final Object get() {
                return Hooks.wrapQueue(new SpscArrayQueue(iMax));
            }
        };
    }

    public static boolean isPowerOfTwo(int i10) {
        return Integer.bitCount(i10) == 1;
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
        return new Supplier() { // from class: reactor.util.concurrent.i
            @Override // java.util.function.Supplier
            public final Object get() {
                return Hooks.wrapQueue(new MpscLinkedQueue());
            }
        };
    }

    public static <T> Supplier<Queue<T>> xs() {
        return XS_SUPPLIER;
    }

    public static <T> Supplier<Queue<T>> unbounded(final int i10) {
        return i10 == XS_BUFFER_SIZE ? XS_UNBOUNDED : (i10 == Integer.MAX_VALUE || i10 == SMALL_BUFFER_SIZE) ? unbounded() : new Supplier() { // from class: reactor.util.concurrent.g
            @Override // java.util.function.Supplier
            public final Object get() {
                return Hooks.wrapQueue(new SpscLinkedArrayQueue(i10));
            }
        };
    }
}
