package com.android.server.usb.descriptors;

import android.hardware.tv.hdmi.cec.CecDeviceType;

/* JADX INFO: loaded from: classes3.dex */
public final class ByteStream {
    private static final String TAG = "ByteStream";
    private final byte[] mBytes;
    private int mIndex;
    private int mReadCount;

    public ByteStream(byte[] bytes) {
        if (bytes == null) goto L7;
        this.mBytes = bytes;
        return;
    L7:
        throw new IllegalArgumentException();
    }

    public void resetReadCount() {
        this.mReadCount = 0;
    }

    public int getReadCount() {
        return this.mReadCount;
    }

    public byte peekByte() {
        if (available() <= 0) goto L7;
        return this.mBytes[this.mIndex + 1];
    L7:
        throw new IndexOutOfBoundsException();
    }

    public byte getByte() {
        if (available() <= 0) goto L7;
        this.mReadCount++;
        byte[] r0 = this.mBytes;
        int r1 = this.mIndex;
        this.mIndex = r1 + 1;
        return r0[r1];
    L7:
        throw new IndexOutOfBoundsException();
    }

    public int getUnsignedByte() {
        if (available() <= 0) goto L7;
        this.mReadCount++;
        byte[] r0 = this.mBytes;
        int r1 = this.mIndex;
        this.mIndex = r1 + 1;
        return r0[r1] & CecDeviceType.INACTIVE;
    L7:
        throw new IndexOutOfBoundsException();
    }

    public int unpackUsbShort() {
        if (available() < 2) goto L7;
        int b0 = getUnsignedByte();
        int b1 = getUnsignedByte();
        return (b1 << 8) | b0;
    L7:
        throw new IndexOutOfBoundsException();
    }

    public int unpackUsbTriple() {
        if (available() < 3) goto L7;
        int b0 = getUnsignedByte();
        int b1 = getUnsignedByte();
        int b2 = getUnsignedByte();
        return ((b2 << 16) | (b1 << 8)) | b0;
    L7:
        throw new IndexOutOfBoundsException();
    }

    public int unpackUsbInt() {
        if (available() < 4) goto L7;
        int b0 = getUnsignedByte();
        int b1 = getUnsignedByte();
        int b2 = getUnsignedByte();
        int b3 = getUnsignedByte();
        return (((b3 << 24) | (b2 << 16)) | (b1 << 8)) | b0;
    L7:
        throw new IndexOutOfBoundsException();
    }

    public void advance(int numBytes) {
        if (numBytes < 0) goto L10;
        long longNewIndex = ((long) this.mIndex) + ((long) numBytes);
        if (longNewIndex > this.mBytes.length) goto L7;
        this.mReadCount += numBytes;
        this.mIndex += numBytes;
        return;
    L7:
        this.mIndex = this.mBytes.length;
        throw new IndexOutOfBoundsException();
    L10:
        throw new IllegalArgumentException();
    }

    public void reverse(int numBytes) {
        if (numBytes < 0) goto L10;
        if (this.mIndex < numBytes) goto L7;
        this.mReadCount -= numBytes;
        this.mIndex -= numBytes;
        return;
    L7:
        this.mIndex = 0;
        throw new IndexOutOfBoundsException();
    L10:
        throw new IllegalArgumentException();
    }

    public int available() {
        return this.mBytes.length - this.mIndex;
    }
}
