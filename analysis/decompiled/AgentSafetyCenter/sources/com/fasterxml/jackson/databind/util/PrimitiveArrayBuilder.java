package com.fasterxml.jackson.databind.util;

import androidx.activity.b;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class PrimitiveArrayBuilder<T> {
    static final int INITIAL_CHUNK_SIZE = 12;
    static final int MAX_CHUNK_SIZE = 262144;
    static final int SMALL_CHUNK_SIZE = 16384;
    protected Node<T> _bufferHead;
    protected Node<T> _bufferTail;
    protected int _bufferedEntryCount;
    protected T _freeBuffer;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Node<T> {
        final T _data;
        final int _dataLength;
        Node<T> _next;

        public Node(T t10, int i) {
            this._data = t10;
            this._dataLength = i;
        }

        public int copyData(T t10, int i) {
            System.arraycopy(this._data, 0, t10, i, this._dataLength);
            return i + this._dataLength;
        }

        public T getData() {
            return this._data;
        }

        public void linkNext(Node<T> node) {
            if (this._next != null) {
                throw new IllegalStateException();
            }
            this._next = node;
        }

        public Node<T> next() {
            return this._next;
        }
    }

    public abstract T _constructArray(int i);

    public void _reset() {
        Node<T> node = this._bufferTail;
        if (node != null) {
            this._freeBuffer = node.getData();
        }
        this._bufferTail = null;
        this._bufferHead = null;
        this._bufferedEntryCount = 0;
    }

    public final T appendCompletedChunk(T t10, int i) {
        Node<T> node = new Node<>(t10, i);
        if (this._bufferHead == null) {
            this._bufferTail = node;
            this._bufferHead = node;
        } else {
            this._bufferTail.linkNext(node);
            this._bufferTail = node;
        }
        this._bufferedEntryCount += i;
        return _constructArray(i < SMALL_CHUNK_SIZE ? i + i : i + (i >> 2));
    }

    public int bufferedSize() {
        return this._bufferedEntryCount;
    }

    public T completeAndClearBuffer(T t10, int i) {
        int i3 = this._bufferedEntryCount + i;
        T t_constructArray = _constructArray(i3);
        int iCopyData = 0;
        for (Node<T> next = this._bufferHead; next != null; next = next.next()) {
            iCopyData = next.copyData(t_constructArray, iCopyData);
        }
        System.arraycopy(t10, 0, t_constructArray, iCopyData, i);
        int i10 = iCopyData + i;
        if (i10 == i3) {
            return t_constructArray;
        }
        f.e(b.i("Should have gotten ", i3, " entries, got ", i10));
        return null;
    }

    public T resetAndStart() {
        _reset();
        T t10 = this._freeBuffer;
        return t10 == null ? _constructArray(12) : t10;
    }
}
