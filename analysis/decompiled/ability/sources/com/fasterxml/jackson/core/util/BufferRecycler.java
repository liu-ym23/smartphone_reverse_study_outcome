package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.RecyclerPool;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public class BufferRecycler implements RecyclerPool.WithPool<BufferRecycler> {
    public static final int BYTE_BASE64_CODEC_BUFFER = 3;
    public static final int BYTE_READ_IO_BUFFER = 0;
    public static final int BYTE_WRITE_CONCAT_BUFFER = 2;
    public static final int BYTE_WRITE_ENCODING_BUFFER = 1;
    public static final int CHAR_CONCAT_BUFFER = 1;
    public static final int CHAR_NAME_COPY_BUFFER = 3;
    public static final int CHAR_TEXT_BUFFER = 2;
    public static final int CHAR_TOKEN_BUFFER = 0;
    protected final AtomicReferenceArray<byte[]> _byteBuffers;
    protected final AtomicReferenceArray<char[]> _charBuffers;
    private RecyclerPool<BufferRecycler> _pool;
    private static final int[] BYTE_BUFFER_LENGTHS = {8000, 8000, 2000, 2000};
    private static final int[] CHAR_BUFFER_LENGTHS = {4000, 4000, 200, 200};

    public interface Gettable {
        BufferRecycler bufferRecycler();
    }

    public BufferRecycler() {
        this(4, 4);
    }

    public final byte[] allocByteBuffer(int i) {
        return allocByteBuffer(i, 0);
    }

    public final char[] allocCharBuffer(int i) {
        return allocCharBuffer(i, 0);
    }

    public byte[] balloc(int i) {
        return new byte[i];
    }

    public int byteBufferLength(int i) {
        return BYTE_BUFFER_LENGTHS[i];
    }

    public char[] calloc(int i) {
        return new char[i];
    }

    public int charBufferLength(int i) {
        return CHAR_BUFFER_LENGTHS[i];
    }

    public boolean isLinkedWithPool() {
        return this._pool != null;
    }

    public void releaseByteBuffer(int i, byte[] bArr) {
        byte[] bArr2 = this._byteBuffers.get(i);
        if (bArr2 == null || bArr.length > bArr2.length) {
            this._byteBuffers.set(i, bArr);
        }
    }

    public void releaseCharBuffer(int i, char[] cArr) {
        char[] cArr2 = this._charBuffers.get(i);
        if (cArr2 == null || cArr.length > cArr2.length) {
            this._charBuffers.set(i, cArr);
        }
    }

    @Override // com.fasterxml.jackson.core.util.RecyclerPool.WithPool
    public void releaseToPool() {
        RecyclerPool<BufferRecycler> recyclerPool = this._pool;
        if (recyclerPool != null) {
            this._pool = null;
            recyclerPool.releasePooled(this);
        }
    }

    @Override // com.fasterxml.jackson.core.util.RecyclerPool.WithPool
    public /* bridge */ /* synthetic */ RecyclerPool.WithPool withPool(RecyclerPool recyclerPool) {
        return withPool((RecyclerPool<BufferRecycler>) recyclerPool);
    }

    public BufferRecycler(int i, int i6) {
        this._byteBuffers = new AtomicReferenceArray<>(i);
        this._charBuffers = new AtomicReferenceArray<>(i6);
    }

    public byte[] allocByteBuffer(int i, int i6) {
        int iByteBufferLength = byteBufferLength(i);
        if (i6 < iByteBufferLength) {
            i6 = iByteBufferLength;
        }
        byte[] andSet = this._byteBuffers.getAndSet(i, null);
        return (andSet == null || andSet.length < i6) ? balloc(i6) : andSet;
    }

    public char[] allocCharBuffer(int i, int i6) {
        int iCharBufferLength = charBufferLength(i);
        if (i6 < iCharBufferLength) {
            i6 = iCharBufferLength;
        }
        char[] andSet = this._charBuffers.getAndSet(i, null);
        return (andSet == null || andSet.length < i6) ? calloc(i6) : andSet;
    }

    @Override // com.fasterxml.jackson.core.util.RecyclerPool.WithPool
    public BufferRecycler withPool(RecyclerPool<BufferRecycler> recyclerPool) {
        if (this._pool == null) {
            Objects.requireNonNull(recyclerPool);
            this._pool = recyclerPool;
            return this;
        }
        throw new IllegalStateException("BufferRecycler already linked to pool: " + recyclerPool);
    }
}
