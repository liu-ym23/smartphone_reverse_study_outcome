package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.pdf417.PDF417Common;

/* JADX INFO: loaded from: classes3.dex */
public final class ModulusGF {
    public static final ModulusGF PDF417_GF = null;
    private final int[] expTable;
    private final int[] logTable;
    private final int modulus;
    private final ModulusPoly one;
    private final ModulusPoly zero;

    static {
        PDF417_GF = new ModulusGF(PDF417Common.NUMBER_OF_CODEWORDS, 3);
    }

    private ModulusGF(int r6, int r7) {
        this.modulus = r6;
        this.expTable = new int[r6];
        this.logTable = new int[r6];
        int r3 = 1;
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L5;
        this.expTable[r2] = r3;
        r3 = (r3 * r7) % r6;
        r2 = r2 + 1;
        goto L3
    L5:
        int r8 = 0;
    L7:
        if (r8 >= (r6 - 1)) goto L9;
        this.logTable[this.expTable[r8]] = r8;
        r8 = r8 + 1;
        goto L7
    L9:
        this.zero = new ModulusPoly(this, new int[]{0});
        this.one = new ModulusPoly(this, new int[]{1});
    }

    ModulusPoly getZero() {
        return this.zero;
    }

    ModulusPoly getOne() {
        return this.one;
    }

    ModulusPoly buildMonomial(int r2, int r3) {
        if (r2 < 0) goto L9;
        if (r3 == 0) goto L5;
        int[] r4 = new int[r2 + 1];
        r4[0] = r3;
        return new ModulusPoly(this, r4);
    L5:
        return this.zero;
    L9:
        throw new IllegalArgumentException();
    }

    int add(int r1, int r2) {
        return (r1 + r2) % this.modulus;
    }

    int subtract(int r1, int r2) {
        int r0 = this.modulus;
        return ((r1 + r0) - r2) % r0;
    }

    int exp(int r1) {
        return this.expTable[r1];
    }

    int log(int r1) {
        if (r1 == 0) goto L6;
        return this.logTable[r1];
    L6:
        throw new IllegalArgumentException();
    }

    int inverse(int r3) {
        if (r3 == 0) goto L6;
        return this.expTable[(this.modulus - this.logTable[r3]) - 1];
    L6:
        throw new ArithmeticException();
    }

    int multiply(int r3, int r4) {
        if (r3 == 0) goto L7;
        if (r4 == 0) goto L9;
        int[] r0 = this.expTable;
        int[] r1 = this.logTable;
        return r0[(r1[r3] + r1[r4]) % (this.modulus - 1)];
    L9:
        return 0;
    L7:
        return 0;
    }

    int getSize() {
        return this.modulus;
    }
}
