package androidx.camera.core.internal.utils;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes2.dex */
public class ArrayRingBuffer<T> implements RingBuffer<T> {
    private static final String TAG = "ZslRingBuffer";
    private final ArrayDeque<T> mBuffer;
    private final Object mLock;
    final RingBuffer.OnRemoveCallback<T> mOnRemoveCallback;
    private final int mRingBufferCapacity;

    @Override // androidx.camera.core.internal.utils.RingBuffer
    public T dequeue() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        T r101 = this.mBuffer.removeLast();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.internal.utils.RingBuffer
    public boolean isEmpty() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        boolean r101 = this.mBuffer.isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.internal.utils.RingBuffer
    public int getMaxCapacity() {
        return this.mRingBufferCapacity;
    }

    public ArrayRingBuffer(int r100) {
        this(r100, null);
    }

    @Override // androidx.camera.core.internal.utils.RingBuffer
    public void enqueue(T r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mBuffer.size() < this.mRingBufferCapacity) goto L7;
        T r102 = dequeue();     // Catch: Throwable -> L15
    L8:
        this.mBuffer.addFirst(r100);     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        RingBuffer.OnRemoveCallback<T> r103 = this.mOnRemoveCallback;
        if (r103 == null) goto L20;
        if (r102 == null) goto L21;
        r103.onRemove(r102);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public ArrayRingBuffer(int r100, RingBuffer.OnRemoveCallback<T> r101) {
        this.mLock = new Object();
        this.mRingBufferCapacity = r100;
        this.mBuffer = new ArrayDeque(r100);
        this.mOnRemoveCallback = r101;
    }
}
