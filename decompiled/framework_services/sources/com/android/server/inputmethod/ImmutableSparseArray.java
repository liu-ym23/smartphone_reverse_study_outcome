package com.android.server.inputmethod;

import android.util.SparseArray;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
final class ImmutableSparseArray<E> {
    private static final ImmutableSparseArray<Object> EMPTY = null;
    private final SparseArray<E> mArray;

    static {
        EMPTY = new ImmutableSparseArray(new SparseArray());
    }

    static <T> ImmutableSparseArray<T> empty() {
        return (ImmutableSparseArray<T>) EMPTY;
    }

    private ImmutableSparseArray(SparseArray<E> array) {
        this.mArray = array;
    }

    int size() {
        return this.mArray.size();
    }

    int keyAt(int index) {
        return this.mArray.keyAt(index);
    }

    public E valueAt(int index) {
        return this.mArray.valueAt(index);
    }

    int indexOfKey(int key) {
        return this.mArray.indexOfKey(key);
    }

    boolean contains(int key) {
        return this.mArray.contains(key);
    }

    E get(int key) {
        return this.mArray.get(key);
    }

    void forEach(Consumer<E> consumer) {
        int size = this.mArray.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        consumer.accept(this.mArray.valueAt(i));
        i = i + 1;
        goto L3
    }

    ImmutableSparseArray<E> cloneWithPutOrSelf(int key, E value) {
        int prevKeyIndex = this.mArray.indexOfKey(key);
        if (prevKeyIndex < 0) goto L7;
        E prevValue = this.mArray.valueAt(prevKeyIndex);
        if (prevValue != value) goto L7;
        return this;
    L7:
        SparseArray<E> clone = this.mArray.clone();
        clone.put(key, value);
        return new ImmutableSparseArray(clone);
    }

    ImmutableSparseArray<E> cloneWithRemoveOrSelf(int key) {
        int index = indexOfKey(key);
        if (index >= 0) goto L6;
        return this;
    L6:
        if (this.mArray.size() == 1) goto L8;
        SparseArray<E> clone = this.mArray.clone();
        clone.remove(key);
        return new ImmutableSparseArray(clone);
    L8:
        return empty();
    }
}
