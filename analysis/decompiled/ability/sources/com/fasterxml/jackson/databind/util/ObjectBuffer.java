package com.fasterxml.jackson.databind.util;

import androidx.compose.foundation.b;
import java.lang.reflect.Array;
import java.util.List;

/* loaded from: classes3.dex */
public final class ObjectBuffer {
    private static final int MAX_CHUNK = 262144;
    private static final int SMALL_CHUNK = 16384;
    private Object[] _freeBuffer;
    private LinkedNode<Object[]> _head;
    private int _size;
    private LinkedNode<Object[]> _tail;

    public final void _copyTo(Object obj, int i, Object[] objArr, int i6) {
        int i10 = 0;
        for (LinkedNode<Object[]> next = this._head; next != null; next = next.next()) {
            Object[] objArrValue = next.value();
            int length = objArrValue.length;
            System.arraycopy(objArrValue, 0, obj, i10, length);
            i10 += length;
        }
        System.arraycopy(objArr, 0, obj, i10, i6);
        int i11 = i10 + i6;
        if (i11 != i) {
            throw new IllegalStateException(b.n(i, i11, "Should have gotten ", " entries, got "));
        }
    }

    public void _reset() {
        LinkedNode<Object[]> linkedNode = this._tail;
        if (linkedNode != null) {
            this._freeBuffer = linkedNode.value();
        }
        this._tail = null;
        this._head = null;
        this._size = 0;
    }

    public Object[] appendCompletedChunk(Object[] objArr) {
        LinkedNode<Object[]> linkedNode = new LinkedNode<>(objArr, null);
        if (this._head == null) {
            this._tail = linkedNode;
            this._head = linkedNode;
        } else {
            this._tail.linkNext(linkedNode);
            this._tail = linkedNode;
        }
        int length = objArr.length;
        this._size += length;
        if (length < 16384) {
            length += length;
        } else if (length < 262144) {
            length += length >> 2;
        }
        return new Object[length];
    }

    public int bufferedSize() {
        return this._size;
    }

    public Object[] completeAndClearBuffer(Object[] objArr, int i) {
        int i6 = this._size + i;
        Object[] objArr2 = new Object[i6];
        _copyTo(objArr2, i6, objArr, i);
        _reset();
        return objArr2;
    }

    public int initialCapacity() {
        Object[] objArr = this._freeBuffer;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    public Object[] resetAndStart() {
        _reset();
        Object[] objArr = this._freeBuffer;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArr2 = new Object[12];
        this._freeBuffer = objArr2;
        return objArr2;
    }

    public Object[] resetAndStart(Object[] objArr, int i) {
        _reset();
        Object[] objArr2 = this._freeBuffer;
        if (objArr2 == null || objArr2.length < i) {
            this._freeBuffer = new Object[Math.max(12, i)];
        }
        System.arraycopy(objArr, 0, this._freeBuffer, 0, i);
        return this._freeBuffer;
    }

    public <T> T[] completeAndClearBuffer(Object[] objArr, int i, Class<T> cls) {
        int i6 = this._size + i;
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i6));
        _copyTo(tArr, i6, objArr, i);
        _reset();
        return tArr;
    }

    public void completeAndClearBuffer(Object[] objArr, int i, List<Object> list) {
        int i6;
        LinkedNode<Object[]> next = this._head;
        while (true) {
            i6 = 0;
            if (next == null) {
                break;
            }
            Object[] objArrValue = next.value();
            int length = objArrValue.length;
            while (i6 < length) {
                list.add(objArrValue[i6]);
                i6++;
            }
            next = next.next();
        }
        while (i6 < i) {
            list.add(objArr[i6]);
            i6++;
        }
        _reset();
    }
}
