package com.bytedance.location.protobuf;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
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

    IterableByteBufferInputStream(Iterable<ByteBuffer> data) {
        this.iterator = data.iterator();
        this.dataSize = 0;
        Iterator<ByteBuffer> r1 = data.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ByteBuffer r2 = r1.next();
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
        this.currentIndex++;
        if (this.iterator.hasNext() == true) goto L5;
        return false;
    L5:
        this.currentByteBuffer = this.iterator.next();
        this.currentByteBufferPos = this.currentByteBuffer.position();
        if (this.currentByteBuffer.hasArray() == false) goto L8;
        this.hasArray = true;
        this.currentArray = this.currentByteBuffer.array();
        this.currentArrayOffset = this.currentByteBuffer.arrayOffset();
    L9:
        return true;
    L8:
        this.hasArray = false;
        this.currentAddress = UnsafeUtil.addressOffset(this.currentByteBuffer);
        this.currentArray = null;
        goto L9
    }

    private void updateCurrentByteBufferPos(int numberOfBytesRead) {
        this.currentByteBufferPos += numberOfBytesRead;
        if (this.currentByteBufferPos != this.currentByteBuffer.limit()) goto L6;
        getNextByteBuffer();
        return;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.currentIndex != this.dataSize) goto L7;
        return -1;
    L7:
        if (this.hasArray == false) goto L10;
        int result = this.currentArray[this.currentByteBufferPos + this.currentArrayOffset] & CecDeviceType.INACTIVE;
        updateCurrentByteBufferPos(1);
        return result;
    L10:
        int result2 = this.currentByteBufferPos;
        int result3 = UnsafeUtil.getByte(((long) result2) + this.currentAddress) & CecDeviceType.INACTIVE;
        updateCurrentByteBufferPos(1);
        return result3;
    }

    @Override // java.io.InputStream
    public int read(byte[] output, int offset, int length) throws IOException {
        if (this.currentIndex != this.dataSize) goto L6;
        return -1;
    L6:
        int remaining = this.currentByteBuffer.limit() - this.currentByteBufferPos;
        if (length <= remaining) goto L10;
        length = remaining;
    L10:
        if (this.hasArray == false) goto L12;
        System.arraycopy(this.currentArray, this.currentByteBufferPos + this.currentArrayOffset, output, offset, length);
        updateCurrentByteBufferPos(length);
    L13:
        return length;
    L12:
        int prevPos = this.currentByteBuffer.position();
        this.currentByteBuffer.position(this.currentByteBufferPos);
        this.currentByteBuffer.get(output, offset, length);
        this.currentByteBuffer.position(prevPos);
        updateCurrentByteBufferPos(length);
        goto L13
    }
}
