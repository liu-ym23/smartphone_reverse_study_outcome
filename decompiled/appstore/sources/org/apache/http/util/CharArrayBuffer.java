package org.apache.http.util;

import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.nio.CharBuffer;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes4.dex */
public final class CharArrayBuffer implements CharSequence, Serializable {
    private static final long serialVersionUID = -6208952725094867135L;
    private char[] buffer;
    private int len;

    public CharArrayBuffer(int r10) {
        Args.notNegative(r10, "Buffer capacity");
        this.buffer = new char[r10];
    }

    private void expand(int r10) {
        char[] r11 = new char[Math.max(this.buffer.length << 1, r10)];
        System.arraycopy(this.buffer, 0, r11, 0, this.len);
        this.buffer = r11;
    }

    public void append(char[] r10, int r11, int r12) {
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

    public char[] buffer() {
        return this.buffer;
    }

    public int capacity() {
        return this.buffer.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int r10) {
        return this.buffer[r10];
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

    public int indexOf(int r10, int r11, int r12) {
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

    @Override // java.lang.CharSequence
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

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r10, int r11) {
        if (r10 < 0) goto L13;
        if (r11 > this.len) goto L11;
        if (r10 > r11) goto L9;
        return CharBuffer.wrap(this.buffer, r10, r11);
    L9:
        throw new IndexOutOfBoundsException("beginIndex: " + r10 + " > endIndex: " + r11);
    L11:
        throw new IndexOutOfBoundsException("endIndex: " + r11 + " > length: " + this.len);
    L13:
        throw new IndexOutOfBoundsException("Negative beginIndex: " + r10);
    }

    public String substring(int r10, int r11) {
        if (r10 < 0) goto L13;
        if (r11 > this.len) goto L11;
        if (r10 > r11) goto L9;
        return new String(this.buffer, r10, r11 - r10);
    L9:
        throw new IndexOutOfBoundsException("beginIndex: " + r10 + " > endIndex: " + r11);
    L11:
        throw new IndexOutOfBoundsException("endIndex: " + r11 + " > length: " + this.len);
    L13:
        throw new IndexOutOfBoundsException("Negative beginIndex: " + r10);
    }

    public String substringTrimmed(int r10, int r11) {
        if (r10 < 0) goto L21;
        if (r11 > this.len) goto L19;
        if (r10 > r11) goto L17;
    L6:
        if (r10 >= r11) goto L10;
        if (HTTP.isWhitespace(this.buffer[r10]) == false) goto L10;
        r10 = r10 + 1;
    L10:
        if (r11 <= r10) goto L15;
        if (HTTP.isWhitespace(this.buffer[r11 - 1]) == false) goto L15;
        r11 = r11 - 1;
    L15:
        return new String(this.buffer, r10, r11 - r10);
    L17:
        throw new IndexOutOfBoundsException("beginIndex: " + r10 + " > endIndex: " + r11);
    L19:
        throw new IndexOutOfBoundsException("endIndex: " + r11 + " > length: " + this.len);
    L21:
        throw new IndexOutOfBoundsException("Negative beginIndex: " + r10);
    }

    public char[] toCharArray() {
        int r10 = this.len;
        char[] r11 = new char[r10];
        if (r10 <= 0) goto L5;
        System.arraycopy(this.buffer, 0, r11, 0, r10);
    L5:
        return r11;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.buffer, 0, this.len);
    }

    public int indexOf(int r10) {
        return indexOf(r10, 0, this.len);
    }

    public void append(String r10) {
        if (r10 != null) goto L5;
        r10 = "null";
    L5:
        int r11 = r10.length();
        int r12 = this.len + r11;
        if (r12 <= this.buffer.length) goto L8;
        expand(r12);
    L8:
        r10.getChars(0, r11, this.buffer, this.len);
        this.len = r12;
    }

    public void append(CharArrayBuffer r10, int r11, int r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        append(r10.buffer, r11, r12);
    }

    public void append(CharArrayBuffer r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        append(r10.buffer, 0, r10.len);
    }

    public void append(char r10) {
        int r11 = this.len + 1;
        if (r11 <= this.buffer.length) goto L5;
        expand(r11);
    L5:
        this.buffer[this.len] = r10;
        this.len = r11;
    }

    public void append(byte[] r10, int r11, int r12) {
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
        this.buffer[r14] = (char) (r10[r11] & UnsignedBytes.MAX_VALUE);
        r11 = r11 + 1;
        r14 = r14 + 1;
        goto L17
    L19:
        this.len = r15;
        return;
    L22:
        throw new IndexOutOfBoundsException("off: " + r11 + " len: " + r12 + " b.length: " + r10.length);
    }

    public void append(ByteArrayBuffer r10, int r11, int r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        append(r10.buffer(), r11, r12);
    }

    public void append(Object r10) {
        append(String.valueOf(r10));
    }
}
