package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
abstract class FlatMapTracker<T> {
    long consumerIndex;
    long producerIndex;
    volatile int size;
    static final AtomicIntegerFieldUpdater<FlatMapTracker> SIZE = AtomicIntegerFieldUpdater.newUpdater(FlatMapTracker.class, "size");
    static final int[] FREE_EMPTY = new int[0];
    volatile T[] array = empty();
    int[] free = FREE_EMPTY;

    public final boolean add(T t10) {
        if (this.array == terminated()) {
            return false;
        }
        synchronized (this) {
            try {
                T[] tArr = this.array;
                if (tArr == terminated()) {
                    return false;
                }
                int iPollFree = pollFree();
                if (iPollFree < 0) {
                    iPollFree = tArr.length;
                    T[] tArrNewArray = iPollFree != 0 ? newArray(iPollFree << 1) : newArray(4);
                    System.arraycopy(tArr, 0, tArrNewArray, 0, iPollFree);
                    this.array = tArrNewArray;
                    int length = tArrNewArray.length;
                    int[] iArr = new int[length];
                    int i = iPollFree + 1;
                    for (int i3 = i; i3 < length; i3++) {
                        iArr[i3] = i3;
                    }
                    this.free = iArr;
                    this.consumerIndex = i;
                    this.producerIndex = length;
                    tArr = tArrNewArray;
                }
                setIndex(t10, iPollFree);
                AtomicIntegerFieldUpdater<FlatMapTracker> atomicIntegerFieldUpdater = SIZE;
                atomicIntegerFieldUpdater.lazySet(this, this.size);
                tArr[iPollFree] = t10;
                atomicIntegerFieldUpdater.lazySet(this, this.size + 1);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract T[] empty();

    public final T[] get() {
        return this.array;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public abstract T[] newArray(int i);

    public void offerFree(int i) {
        int[] iArr = this.free;
        int length = iArr.length - 1;
        long j10 = this.producerIndex;
        iArr[length & ((int) j10)] = i;
        this.producerIndex = j10 + 1;
    }

    public int pollFree() {
        int[] iArr = this.free;
        int length = iArr.length - 1;
        long j10 = this.consumerIndex;
        if (this.producerIndex == j10) {
            return -1;
        }
        int i = length & ((int) j10);
        this.consumerIndex = j10 + 1;
        return iArr[i];
    }

    public final void remove(int i) {
        synchronized (this) {
            try {
                T[] tArr = this.array;
                if (tArr != terminated()) {
                    tArr[i] = null;
                    offerFree(i);
                    SIZE.lazySet(this, this.size - 1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void setIndex(T t10, int i);

    public abstract T[] terminated();

    public final void unsubscribe() {
        T[] tArrTerminated = terminated();
        synchronized (this) {
            try {
                T[] tArr = this.array;
                if (tArr == tArrTerminated) {
                    return;
                }
                SIZE.lazySet(this, 0);
                this.free = null;
                this.array = tArrTerminated;
                for (T t10 : tArr) {
                    if (t10 != null) {
                        unsubscribeEntry(t10);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void unsubscribeEntry(T t10);
}
