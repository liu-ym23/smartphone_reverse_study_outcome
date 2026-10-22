package com.fasterxml.jackson.databind.util;

import androidx.compose.foundation.b;

/* loaded from: classes3.dex */
public abstract class PrimitiveArrayBuilder<T> {
    static final int INITIAL_CHUNK_SIZE = 12;
    static final int MAX_CHUNK_SIZE = 262144;
    static final int SMALL_CHUNK_SIZE = 16384;
    protected Node<T> _bufferHead;
    protected Node<T> _bufferTail;
    protected int _bufferedEntryCount;
    protected T _freeBuffer;

    public static final class Node<T> {
        final T _data;
        final int _dataLength;
        Node<T> _next;

        public Node(T t9, int i) {
            this._data = t9;
            this._dataLength = i;
        }

        public int copyData(T t9, int i) {
            System.arraycopy(this._data, 0, t9, i, this._dataLength);
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

    public final T appendCompletedChunk(T t9, int i) {
        Node<T> node = new Node<>(t9, i);
        if (this._bufferHead == null) {
            this._bufferTail = node;
            this._bufferHead = node;
        } else {
            this._bufferTail.linkNext(node);
            this._bufferTail = node;
        }
        this._bufferedEntryCount += i;
        return _constructArray(i < 16384 ? i + i : i + (i >> 2));
    }

    public int bufferedSize() {
        return this._bufferedEntryCount;
    }

    public T completeAndClearBuffer(T t9, int i) {
        int i6 = this._bufferedEntryCount + i;
        T t_constructArray = _constructArray(i6);
        int iCopyData = 0;
        for (Node<T> next = this._bufferHead; next != null; next = next.next()) {
            iCopyData = next.copyData(t_constructArray, iCopyData);
        }
        System.arraycopy(t9, 0, t_constructArray, iCopyData, i);
        int i10 = iCopyData + i;
        if (i10 == i6) {
            return t_constructArray;
        }
        throw new IllegalStateException(b.n(i6, i10, "Should have gotten ", " entries, got "));
    }

    public T resetAndStart() {
        _reset();
        T t9 = this._freeBuffer;
        return t9 == null ? _constructArray(12) : t9;
    }
}
