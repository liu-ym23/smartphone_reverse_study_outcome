package com.bytedance.android.livesdkapi.util.url;

/* JADX INFO: loaded from: classes12.dex */
public final class CharArrayBuffer {
    public static final int CR = 13;
    public static final int HT = 9;
    public static final int LF = 10;
    public static final int SP = 32;
    private char[] buffer;
    private int len;

    public String toString() {
        return new String(this.buffer, 0, this.len);
    }

    public char[] buffer() {
        return this.buffer;
    }

    public CharArrayBuffer(int r100) {
        if (r100 < 0) goto L7;
        this.buffer = new char[r100];
        return;
    L7:
        throw new IllegalArgumentException("Buffer capacity may not be negative");
    }

    private void expand(int r100) {
        char[] r101 = new char[Math.max(this.buffer.length << 1, r100)];
        System.arraycopy(this.buffer, 0, r101, 0, this.len);
        this.buffer = r101;
    }

    public void append(String r100) {
        if (r100 != null) goto L4;
        r100 = "null";
    L4:
        int r101 = r100.length();
        int r102 = this.len + r101;
        if (r102 <= this.buffer.length) goto L7;
        expand(r102);
    L7:
        r100.getChars(0, r101, this.buffer, this.len);
        this.len = r102;
    }

    public void append(byte[] r100, int r101, int r102) {
        if (r100 != 0) goto L4;
        return;
    L4:
        if (r101 < 0) goto L25;
        if (r101 > r100.length) goto L25;
        if (r102 < 0) goto L25;
        int r103 = r101 + r102;
        if (r103 < 0) goto L25;
        if (r103 > r100.length) goto L25;
        if (r102 != 0) goto L14;
        return;
    L14:
        int r104 = this.len;
        int r105 = r102 + r104;
        if (r105 <= this.buffer.length) goto L17;
        expand(r105);
    L17:
        if (r104 >= r105) goto L22;
        int r106 = r100[r101];
        if (r106 >= 0) goto L21;
        r106 = r106 + 256;
    L21:
        this.buffer[r104] = (char) r106;
        r101 = r101 + 1;
        r104 = r104 + 1;
        goto L17
    L22:
        this.len = r105;
        return;
    L25:
        throw new IndexOutOfBoundsException();
    }

    public void append(char[] r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 < 0) goto L20;
        if (r101 > r100.length) goto L20;
        if (r102 < 0) goto L20;
        int r103 = r101 + r102;
        if (r103 < 0) goto L20;
        if (r103 > r100.length) goto L20;
        if (r102 != 0) goto L14;
        return;
    L14:
        int r104 = this.len + r102;
        if (r104 <= this.buffer.length) goto L17;
        expand(r104);
    L17:
        System.arraycopy(r100, r101, this.buffer, this.len, r102);
        this.len = r104;
        return;
    L20:
        throw new IndexOutOfBoundsException();
    }
}
