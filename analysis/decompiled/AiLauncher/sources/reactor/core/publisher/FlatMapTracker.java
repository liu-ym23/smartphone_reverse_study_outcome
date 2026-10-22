package reactor.core.publisher;

import io.ktor.http.ContentDisposition;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes5.dex */
abstract class FlatMapTracker<T> {
    long consumerIndex;
    long producerIndex;
    volatile int size;
    static final AtomicIntegerFieldUpdater<FlatMapTracker> SIZE = AtomicIntegerFieldUpdater.newUpdater(FlatMapTracker.class, ContentDisposition.Parameters.Size);
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
                    int i10 = iPollFree + 1;
                    for (int i11 = i10; i11 < length; i11++) {
                        iArr[i11] = i11;
                    }
                    this.free = iArr;
                    this.consumerIndex = i10;
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

    public abstract T[] newArray(int i10);

    public void offerFree(int i10) {
        int[] iArr = this.free;
        int length = iArr.length - 1;
        long j10 = this.producerIndex;
        iArr[length & ((int) j10)] = i10;
        this.producerIndex = j10 + 1;
    }

    public int pollFree() {
        int[] iArr = this.free;
        int length = iArr.length - 1;
        long j10 = this.consumerIndex;
        if (this.producerIndex == j10) {
            return -1;
        }
        int i10 = length & ((int) j10);
        this.consumerIndex = j10 + 1;
        return iArr[i10];
    }

    public final void remove(int i10) {
        synchronized (this) {
            try {
                T[] tArr = this.array;
                if (tArr != terminated()) {
                    tArr[i10] = null;
                    offerFree(i10);
                    SIZE.lazySet(this, this.size - 1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void setIndex(T t10, int i10);

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
