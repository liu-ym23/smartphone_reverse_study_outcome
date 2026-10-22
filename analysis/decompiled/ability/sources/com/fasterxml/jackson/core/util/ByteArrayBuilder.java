package com.fasterxml.jackson.core.util;

import androidx.compose.foundation.b;
import com.fasterxml.jackson.core.util.BufferRecycler;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class ByteArrayBuilder extends OutputStream implements BufferRecycler.Gettable {
    static final int DEFAULT_BLOCK_ARRAY_SIZE = 40;
    private static final int INITIAL_BLOCK_SIZE = 500;
    private static final int MAX_BLOCK_SIZE = 131072;
    public static final byte[] NO_BYTES = new byte[0];
    private final BufferRecycler _bufferRecycler;
    private byte[] _currBlock;
    private int _currBlockPtr;
    private final LinkedList<byte[]> _pastBlocks;
    private int _pastLen;

    public ByteArrayBuilder() {
        this((BufferRecycler) null);
    }

    private void _allocMore() {
        int length = this._pastLen + this._currBlock.length;
        if (length < 0) {
            throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
        }
        this._pastLen = length;
        int iMax = Math.max(length >> 1, 1000);
        if (iMax > 131072) {
            iMax = 131072;
        }
        this._pastBlocks.add(this._currBlock);
        this._currBlock = new byte[iMax];
        this._currBlockPtr = 0;
    }

    public static ByteArrayBuilder fromInitial(byte[] bArr, int i) {
        return new ByteArrayBuilder(null, bArr, i);
    }

    public void append(int i) {
        if (this._currBlockPtr >= this._currBlock.length) {
            _allocMore();
        }
        byte[] bArr = this._currBlock;
        int i6 = this._currBlockPtr;
        this._currBlockPtr = i6 + 1;
        bArr[i6] = (byte) i;
    }

    public void appendFourBytes(int i) {
        int i6 = this._currBlockPtr;
        int i10 = i6 + 3;
        byte[] bArr = this._currBlock;
        if (i10 >= bArr.length) {
            append(i >> 24);
            append(i >> 16);
            append(i >> 8);
            append(i);
            return;
        }
        int i11 = i6 + 1;
        this._currBlockPtr = i11;
        bArr[i6] = (byte) (i >> 24);
        int i12 = i6 + 2;
        this._currBlockPtr = i12;
        bArr[i11] = (byte) (i >> 16);
        int i13 = i6 + 3;
        this._currBlockPtr = i13;
        bArr[i12] = (byte) (i >> 8);
        this._currBlockPtr = i6 + 4;
        bArr[i13] = (byte) i;
    }

    public void appendThreeBytes(int i) {
        int i6 = this._currBlockPtr;
        int i10 = i6 + 2;
        byte[] bArr = this._currBlock;
        if (i10 >= bArr.length) {
            append(i >> 16);
            append(i >> 8);
            append(i);
            return;
        }
        int i11 = i6 + 1;
        this._currBlockPtr = i11;
        bArr[i6] = (byte) (i >> 16);
        int i12 = i6 + 2;
        this._currBlockPtr = i12;
        bArr[i11] = (byte) (i >> 8);
        this._currBlockPtr = i6 + 3;
        bArr[i12] = (byte) i;
    }

    public void appendTwoBytes(int i) {
        int i6 = this._currBlockPtr;
        int i10 = i6 + 1;
        byte[] bArr = this._currBlock;
        if (i10 >= bArr.length) {
            append(i >> 8);
            append(i);
            return;
        }
        int i11 = i6 + 1;
        this._currBlockPtr = i11;
        bArr[i6] = (byte) (i >> 8);
        this._currBlockPtr = i6 + 2;
        bArr[i11] = (byte) i;
    }

    @Override // com.fasterxml.jackson.core.util.BufferRecycler.Gettable
    public BufferRecycler bufferRecycler() {
        return this._bufferRecycler;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public byte[] completeAndCoalesce(int i) {
        this._currBlockPtr = i;
        return toByteArray();
    }

    public byte[] finishCurrentSegment() {
        _allocMore();
        return this._currBlock;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public byte[] getClearAndRelease() {
        byte[] byteArray = toByteArray();
        release();
        return byteArray;
    }

    public byte[] getCurrentSegment() {
        return this._currBlock;
    }

    public int getCurrentSegmentLength() {
        return this._currBlockPtr;
    }

    public void release() {
        byte[] bArr;
        reset();
        BufferRecycler bufferRecycler = this._bufferRecycler;
        if (bufferRecycler == null || (bArr = this._currBlock) == null) {
            return;
        }
        bufferRecycler.releaseByteBuffer(2, bArr);
        this._currBlock = null;
    }

    public void reset() {
        this._pastLen = 0;
        this._currBlockPtr = 0;
        if (this._pastBlocks.isEmpty()) {
            return;
        }
        this._pastBlocks.clear();
    }

    public byte[] resetAndGetFirstSegment() {
        reset();
        return this._currBlock;
    }

    public void setCurrentSegmentLength(int i) {
        this._currBlockPtr = i;
    }

    public int size() {
        return this._pastLen + this._currBlockPtr;
    }

    public byte[] toByteArray() {
        int i = this._pastLen + this._currBlockPtr;
        if (i == 0) {
            return NO_BYTES;
        }
        byte[] bArr = new byte[i];
        Iterator<byte[]> it = this._pastBlocks.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            byte[] next = it.next();
            int length = next.length;
            System.arraycopy(next, 0, bArr, i6, length);
            i6 += length;
        }
        System.arraycopy(this._currBlock, 0, bArr, i6, this._currBlockPtr);
        int i10 = i6 + this._currBlockPtr;
        if (i10 != i) {
            throw new RuntimeException(b.o(i, "Internal error: total len assumed to be ", i10, ", copied ", " bytes"));
        }
        if (!this._pastBlocks.isEmpty()) {
            reset();
        }
        return bArr;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public ByteArrayBuilder(BufferRecycler bufferRecycler) {
        this(bufferRecycler, 500);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i6) {
        while (true) {
            int iMin = Math.min(this._currBlock.length - this._currBlockPtr, i6);
            if (iMin > 0) {
                System.arraycopy(bArr, i, this._currBlock, this._currBlockPtr, iMin);
                i += iMin;
                this._currBlockPtr += iMin;
                i6 -= iMin;
            }
            if (i6 <= 0) {
                return;
            } else {
                _allocMore();
            }
        }
    }

    public ByteArrayBuilder(int i) {
        this(null, i);
    }

    public ByteArrayBuilder(BufferRecycler bufferRecycler, int i) {
        this._pastBlocks = new LinkedList<>();
        this._bufferRecycler = bufferRecycler;
        this._currBlock = bufferRecycler == null ? new byte[i > 131072 ? 131072 : i] : bufferRecycler.allocByteBuffer(2);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        append(i);
    }

    private ByteArrayBuilder(BufferRecycler bufferRecycler, byte[] bArr, int i) {
        this._pastBlocks = new LinkedList<>();
        this._bufferRecycler = bufferRecycler;
        this._currBlock = bArr;
        this._currBlockPtr = i;
    }
}
