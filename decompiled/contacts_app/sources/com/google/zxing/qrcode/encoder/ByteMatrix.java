package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public final class ByteMatrix {
    private final byte[][] bytes;
    private final int height;
    private final int width;

    public ByteMatrix(int r3, int r4) {
        this.bytes = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{r4, r3});
        this.width = r3;
        this.height = r4;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public byte get(int r1, int r2) {
        return this.bytes[r2][r1];
    }

    public byte[][] getArray() {
        return this.bytes;
    }

    public void set(int r1, int r2, byte r3) {
        this.bytes[r2][r1] = r3;
    }

    public void set(int r1, int r2, int r3) {
        this.bytes[r2][r1] = (byte) r3;
    }

    public void set(int r1, int r2, boolean r3) {
        this.bytes[r2][r1] = r3 ? 1 : 0;
    }

    public void clear(byte r5) {
        int r1 = 0;
    L4:
        if (r1 >= this.height) goto L10;
        int r2 = 0;
    L7:
        if (r2 >= this.width) goto L9;
        this.bytes[r1][r2] = r5;
        r2 = r2 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(((this.width * 2) * this.height) + 2);
        int r2 = 0;
    L4:
        if (r2 >= this.height) goto L18;
        int r3 = 0;
    L7:
        if (r3 >= this.width) goto L16;
        byte r4 = this.bytes[r2][r3];
        if (r4 != 0) goto L11;
        r0.append(" 0");
    L15:
        r3 = r3 + 1;
        goto L7
    L11:
        if (r4 == 1) goto L13;
        r0.append("  ");
        goto L15
    L13:
        r0.append(" 1");
        goto L15
    L16:
        r0.append('\n');
        r2 = r2 + 1;
        goto L4
    L18:
        return r0.toString();
    }
}
