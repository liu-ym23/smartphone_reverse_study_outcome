package org.apache.commons.compress.archivers.zip;

/* JADX INFO: loaded from: classes3.dex */
class CircularBuffer {
    private final byte[] buffer;
    private int readIndex;
    private final int size;
    private int writeIndex;

    CircularBuffer(int size) {
        this.size = size;
        this.buffer = new byte[size];
    }

    public boolean available() {
        if (this.readIndex == this.writeIndex) goto L5;
        return true;
    L5:
        return false;
    }

    public void put(int value) {
        this.buffer[this.writeIndex] = (byte) value;
        this.writeIndex = (this.writeIndex + 1) % this.size;
    }

    public int get() {
        if (available() == false) goto L6;
        int value = this.buffer[this.readIndex];
        this.readIndex = (this.readIndex + 1) % this.size;
        return value & 255;
    L6:
        return -1;
    }

    public void copy(int distance, int length) {
        int pos1 = this.writeIndex - distance;
        int pos2 = pos1 + length;
        int i = pos1;
    L3:
        if (i >= pos2) goto L6;
        this.buffer[this.writeIndex] = this.buffer[(this.size + i) % this.size];
        this.writeIndex = (this.writeIndex + 1) % this.size;
        i = i + 1;
        goto L3
    }
}
