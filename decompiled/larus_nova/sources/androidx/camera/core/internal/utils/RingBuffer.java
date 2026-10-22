package androidx.camera.core.internal.utils;

/* JADX INFO: loaded from: classes2.dex */
public interface RingBuffer<T> {

    public interface OnRemoveCallback<T> {
        void onRemove(T r100);
    }

    T dequeue();

    void enqueue(T r100);

    int getMaxCapacity();

    boolean isEmpty();
}
