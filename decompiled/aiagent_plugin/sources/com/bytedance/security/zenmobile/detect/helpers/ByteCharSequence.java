package com.bytedance.security.zenmobile.detect.helpers;

/* JADX INFO: loaded from: classes.dex */
public final class ByteCharSequence implements CharSequence {
    private final byte[] data;
    private final int length;
    private final int offset;

    public ByteCharSequence(byte[] r3) {
        this(r3, 0, r3.length);
    }

    public ByteCharSequence(byte[] r1, int r2, int r3) {
        this.data = r1;
        this.offset = r2;
        this.length = r3;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int r2) {
        return (char) (this.data[this.offset + r2] & 255);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r3, int r4) {
        return new ByteCharSequence(this.data, this.offset + r3, r4 - r3);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = this.offset;
    L4:
        if (r1 >= (this.offset + this.length)) goto L9;
        byte[] r2 = this.data;
        if (r1 >= r2.length) goto L9;
        r0.append(String.format("%02X ", new Object[]{Integer.valueOf(r2[r1] & 255)}));
        r1 = r1 + 1;
    L9:
        return r0.toString();
    }
}
