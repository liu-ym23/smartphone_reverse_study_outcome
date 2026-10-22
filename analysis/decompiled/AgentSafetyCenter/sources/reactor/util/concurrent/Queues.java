package reactor.util.concurrent;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.io.Serializable;
import java.lang.invoke.VarHandle;
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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class Queues {
    public static final int CAPACITY_UNSURE = Integer.MIN_VALUE;
    public static final int XS_BUFFER_SIZE = Math.max(8, Integer.parseInt(System.getProperty("reactor.bufferSize.x", "32")));
    public static final int SMALL_BUFFER_SIZE = Math.max(16, Integer.parseInt(System.getProperty("reactor.bufferSize.small", "256")));
    static final Supplier ZERO_SUPPLIER = new com.fasterxml.jackson.core.util.a(4);
    static final Supplier ONE_SUPPLIER = new com.fasterxml.jackson.core.util.a(5);
    static final Supplier XS_SUPPLIER = new com.fasterxml.jackson.core.util.a(6);
    static final Supplier SMALL_SUPPLIER = new com.fasterxml.jackson.core.util.a(7);
    static final Supplier SMALL_UNBOUNDED = new com.fasterxml.jackson.core.util.a(8);
    static final Supplier XS_UNBOUNDED = new com.fasterxml.jackson.core.util.a(9);

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
            return Reader.READ_DONE;
        }
        if (queue instanceof SpscArrayQueue) {
            return ((SpscArrayQueue) queue).length();
        }
        if (queue instanceof MpscLinkedQueue) {
            return Reader.READ_DONE;
        }
        if (queue instanceof BlockingQueue) {
            return ((BlockingQueue) queue).remainingCapacity();
        }
        if (queue instanceof ConcurrentLinkedQueue) {
            return Reader.READ_DONE;
        }
        return Integer.MIN_VALUE;
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
        int i3 = 1;
        if (i == 1) {
            return ONE_SUPPLIER;
        }
        if (i == 0) {
            return ZERO_SUPPLIER;
        }
        int iMax = Math.max(8, i);
        if (iMax > 10000000) {
            return SMALL_UNBOUNDED;
        }
        a aVar = new a(i3);
        aVar.f10907f = iMax;
        VarHandle.storeStoreFence();
        return aVar;
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

    public static <T> Supplier<Queue<T>> unbounded(int i) {
        if (i == XS_BUFFER_SIZE) {
            return XS_UNBOUNDED;
        }
        if (i == Integer.MAX_VALUE || i == SMALL_BUFFER_SIZE) {
            return unbounded();
        }
        a aVar = new a(0);
        aVar.f10907f = i;
        VarHandle.storeStoreFence();
        return aVar;
    }

    public static <T> Supplier<Queue<T>> unboundedMultiproducer() {
        return new com.fasterxml.jackson.core.util.a(10);
    }

    public static <T> Supplier<Queue<T>> xs() {
        return XS_SUPPLIER;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        @Override // java.util.Queue
        public T remove() {
            return getAndSet(null);
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

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            return false;
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            T t10 = get();
            if (t10 == null) {
                return new Object[0];
            }
            return new Object[]{t10};
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        @Override // java.util.Queue
        public T remove() {
            throw new NoSuchElementException("immutable empty queue");
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
        public <T1> T1[] toArray(T1[] t1Arr) {
            if (t1Arr.length > 0) {
                t1Arr[0] = null;
            }
            return t1Arr;
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            return false;
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return new Object[0];
        }

        @Override // java.util.Collection
        public void clear() {
        }
    }

    public static <T> Supplier<Queue<T>> unbounded() {
        return SMALL_UNBOUNDED;
    }
}
