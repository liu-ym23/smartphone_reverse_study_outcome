package org.apache.http.util;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public final class ByteArrayBuffer implements Serializable {
    private static final long serialVersionUID = 4359112959524048036L;
    private byte[] buffer;
    private int len;

    public ByteArrayBuffer(int r10) {
        Args.notNegative(r10, "Buffer capacity");
        this.buffer = new byte[r10];
    }

    private void expand(int r10) {
        byte[] r11 = new byte[Math.max(this.buffer.length << 1, r10)];
        System.arraycopy(this.buffer, 0, r11, 0, this.len);
        this.buffer = r11;
    }

    public void append(byte[] r10, int r11, int r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r11 < 0) goto L20;
        if (r11 > r10.length) goto L20;
        if (r12 < 0) goto L20;
        int r13 = r11 + r12;
        if (r13 < 0) goto L20;
        if (r13 > r10.length) goto L20;
        if (r12 != 0) goto L14;
        return;
    L14:
        int r14 = this.len + r12;
        if (r14 <= this.buffer.length) goto L17;
        expand(r14);
    L17:
        System.arraycopy(r10, r11, this.buffer, this.len, r12);
        this.len = r14;
        return;
    L20:
        throw new IndexOutOfBoundsException("off: " + r11 + " len: " + r12 + " b.length: " + r10.length);
    }

    public byte[] buffer() {
        return this.buffer;
    }

    public int byteAt(int r10) {
        return this.buffer[r10];
    }

    public int capacity() {
        return this.buffer.length;
    }

    public void clear() {
        this.len = 0;
    }

    public void ensureCapacity(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        int r11 = this.buffer.length;
        int r12 = this.len;
        if (r10 <= (r11 - r12)) goto L8;
        expand(r12 + r10);
        return;
    }

    public int indexOf(byte r10, int r11, int r12) {
        if (r11 >= 0) goto L4;
        r11 = 0;
    L4:
        int r13 = this.len;
        if (r12 <= r13) goto L8;
        r12 = r13;
    L8:
        if (r11 <= r12) goto L10;
        return -1;
    L10:
        if (r11 >= r12) goto L15;
        if (this.buffer[r11] == r10) goto L13;
        r11 = r11 + 1;
        goto L10
    L13:
        return r11;
    L15:
        return -1;
    }

    public boolean isEmpty() {
        if (this.len != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFull() {
        if (this.len != this.buffer.length) goto L5;
        return true;
    L5:
        return false;
    }

    public int length() {
        return this.len;
    }

    public void setLength(int r10) {
        if (r10 < 0) goto L8;
        if (r10 > this.buffer.length) goto L8;
        this.len = r10;
        return;
    L8:
        throw new IndexOutOfBoundsException("len: " + r10 + " < 0 or > buffer len: " + this.buffer.length);
    }

    public byte[] toByteArray() {
        int r10 = this.len;
        byte[] r11 = new byte[r10];
        if (r10 <= 0) goto L5;
        System.arraycopy(this.buffer, 0, r11, 0, r10);
    L5:
        return r11;
    }

    public int indexOf(byte r10) {
        return indexOf(r10, 0, this.len);
    }

    public void append(int r10) {
        int r11 = this.len + 1;
        if (r11 <= this.buffer.length) goto L5;
        expand(r11);
    L5:
        this.buffer[this.len] = (byte) r10;
        this.len = r11;
    }

    public void append(char[] r10, int r11, int r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r11 < 0) goto L22;
        if (r11 > r10.length) goto L22;
        if (r12 < 0) goto L22;
        int r13 = r11 + r12;
        if (r13 < 0) goto L22;
        if (r13 > r10.length) goto L22;
        if (r12 != 0) goto L14;
        return;
    L14:
        int r14 = this.len;
        int r15 = r12 + r14;
        if (r15 <= this.buffer.length) goto L17;
        expand(r15);
    L17:
        if (r14 >= r15) goto L19;
        this.buffer[r14] = (byte) r10[r11];
        r11 = r11 + 1;
        r14 = r14 + 1;
        goto L17
    L19:
        this.len = r15;
        return;
    L22:
        throw new IndexOutOfBoundsException("off: " + r11 + " len: " + r12 + " b.length: " + r10.length);
    }

    public void append(CharArrayBuffer r10, int r11, int r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        append(r10.buffer(), r11, r12);
    }
}
