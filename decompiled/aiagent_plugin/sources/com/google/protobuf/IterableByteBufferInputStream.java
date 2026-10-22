package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class IterableByteBufferInputStream extends InputStream {
    private long currentAddress;
    private byte[] currentArray;
    private int currentArrayOffset;
    private ByteBuffer currentByteBuffer;
    private int currentByteBufferPos;
    private int currentIndex;
    private int dataSize;
    private boolean hasArray;
    private Iterator<ByteBuffer> iterator;

    IterableByteBufferInputStream(Iterable<ByteBuffer> r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.aiagent.plugin");
        this.iterator = r6.iterator();
        this.dataSize = 0;
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        ByteBuffer r2 = (ByteBuffer) ZeusTransformUtils.preCheckCast(r7.next(), ByteBuffer.class, "com.obric.aiagent.plugin");
        this.dataSize++;
        goto L4
    L6:
        this.currentIndex = -1;
        if (getNextByteBuffer() == true) goto L11;
        this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
        this.currentIndex = 0;
        this.currentByteBufferPos = 0;
        this.currentAddress = 0;
        return;
    }

    private boolean getNextByteBuffer() {
    L2:
        this.currentIndex++;
        if (this.iterator.hasNext() == false) goto L4;
        ByteBuffer r0 = (ByteBuffer) ZeusTransformUtils.preCheckCast(this.iterator.next(), ByteBuffer.class, "com.obric.aiagent.plugin");
        this.currentByteBuffer = r0;
        if (r0.hasRemaining() == false) goto L2;
        this.currentByteBufferPos = this.currentByteBuffer.position();
        if (this.currentByteBuffer.hasArray() == false) goto L10;
        this.hasArray = true;
        this.currentArray = this.currentByteBuffer.array();
        this.currentArrayOffset = this.currentByteBuffer.arrayOffset();
    L11:
        return true;
    L10:
        this.hasArray = false;
        this.currentAddress = UnsafeUtil.addressOffset(this.currentByteBuffer);
        this.currentArray = null;
        goto L11
    L4:
        return false;
    }

    private void updateCurrentByteBufferPos(int r2) {
        int r0 = this.currentByteBufferPos + r2;
        this.currentByteBufferPos = r0;
        if (r0 != this.currentByteBuffer.limit()) goto L6;
        getNextByteBuffer();
        return;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.currentIndex != this.dataSize) goto L7;
        return -1;
    L7:
        if (this.hasArray == false) goto L10;
        int r0 = this.currentArray[this.currentByteBufferPos + this.currentArrayOffset] & 255;
        updateCurrentByteBufferPos(1);
        return r0;
    L10:
        int r1 = UnsafeUtil.getByte(((long) this.currentByteBufferPos) + this.currentAddress) & 255;
        updateCurrentByteBufferPos(1);
        return r1;
    }

    @Override // java.io.InputStream
    public int read(byte[] r4, int r5, int r6) {
        if (this.currentIndex != this.dataSize) goto L6;
        return -1;
    L6:
        int r0 = this.currentByteBuffer.limit();
        int r1 = this.currentByteBufferPos;
        int r2 = r0 - r1;
        if (r6 <= r2) goto L10;
        r6 = r2;
    L10:
        if (this.hasArray == false) goto L12;
        System.arraycopy(this.currentArray, r1 + this.currentArrayOffset, r4, r5, r6);
        updateCurrentByteBufferPos(r6);
    L13:
        return r6;
    L12:
        int r3 = this.currentByteBuffer.position();
        Java8Compatibility.position(this.currentByteBuffer, this.currentByteBufferPos);
        this.currentByteBuffer.get(r4, r5, r6);
        Java8Compatibility.position(this.currentByteBuffer, r3);
        updateCurrentByteBufferPos(r6);
        goto L13
    }
}
