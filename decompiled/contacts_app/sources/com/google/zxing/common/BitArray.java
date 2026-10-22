package com.google.zxing.common;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class BitArray implements Cloneable {
    private int[] bits;
    private int size;

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m289clone() throws CloneNotSupportedException {
        return clone();
    }

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    public BitArray(int r1) {
        this.size = r1;
        this.bits = makeArray(r1);
    }

    BitArray(int[] r1, int r2) {
        this.bits = r1;
        this.size = r2;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeInBytes() {
        return (this.size + 7) / 8;
    }

    private void ensureCapacity(int r4) {
        if (r4 <= (this.bits.length << 5)) goto L6;
        int[] r5 = makeArray(r4);
        int[] r0 = this.bits;
        System.arraycopy(r0, 0, r5, 0, r0.length);
        this.bits = r5;
        return;
    }

    public boolean get(int r2) {
        if ((this.bits[r2 / 32] & (1 << (r2 & 31))) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void set(int r4) {
        int[] r3 = this.bits;
        int r0 = r4 / 32;
        int r5 = 1 << (r4 & 31);
        r3[r0] = r5 | r3[r0];
    }

    public void flip(int r4) {
        int[] r3 = this.bits;
        int r0 = r4 / 32;
        int r5 = 1 << (r4 & 31);
        r3[r0] = r5 ^ r3[r0];
    }

    public int getNextSet(int r4) {
        int r0 = this.size;
        if (r4 < r0) goto L5;
        return r0;
    L5:
        int r1 = r4 / 32;
        int r2 = this.bits[r1];
        int r5 = (~((1 << (r4 & 31)) - 1)) & r2;
    L6:
        if (r5 != 0) goto L12;
        r1 = r1 + 1;
        int[] r6 = this.bits;
        if (r1 == r6.length) goto L10;
        r5 = r6[r1];
        goto L6
    L10:
        return this.size;
    L12:
        int r3 = (r1 << 5) + Integer.numberOfTrailingZeros(r5);
        int r7 = this.size;
        if (r3 <= r7) goto L15;
        return r7;
    L15:
        return r3;
    }

    public int getNextUnset(int r4) {
        int r0 = this.size;
        if (r4 < r0) goto L5;
        return r0;
    L5:
        int r1 = r4 / 32;
        int r2 = ~this.bits[r1];
        int r5 = (~((1 << (r4 & 31)) - 1)) & r2;
    L6:
        if (r5 != 0) goto L12;
        r1 = r1 + 1;
        int[] r6 = this.bits;
        if (r1 == r6.length) goto L10;
        r5 = ~r6[r1];
        goto L6
    L10:
        return this.size;
    L12:
        int r3 = (r1 << 5) + Integer.numberOfTrailingZeros(r5);
        int r7 = this.size;
        if (r3 <= r7) goto L15;
        return r7;
    L15:
        return r3;
    }

    public void setBulk(int r1, int r2) {
        this.bits[r1 / 32] = r2;
    }

    public void setRange(int r7, int r8) {
        if (r8 < r7) goto L20;
        if (r7 < 0) goto L20;
        if (r8 > this.size) goto L20;
        if (r8 != r7) goto L8;
        return;
    L8:
        int r9 = r8 - 1;
        int r0 = r7 / 32;
        int r1 = r9 / 32;
        int r2 = r0;
    L9:
        if (r2 > r1) goto L18;
        int r3 = 31;
        if (r2 <= r0) goto L13;
        int r4 = 0;
    L14:
        if (r2 < r1) goto L17;
        r3 = 31 & r9;
    L17:
        int r5 = (2 << r3) - (1 << r4);
        int[] r6 = this.bits;
        r6[r2] = r5 | r6[r2];
        r2 = r2 + 1;
        goto L9
    L13:
        r4 = r7 & 31;
        goto L14
    L18:
        return;
    L20:
        throw new IllegalArgumentException();
    }

    public void clear() {
        int r0 = this.bits.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.bits[r2] = 0;
        r2 = r2 + 1;
        goto L3
    }

    public boolean isRange(int r9, int r10, boolean r11) {
        if (r10 < r9) goto L27;
        if (r9 < 0) goto L27;
        if (r10 > this.size) goto L27;
        if (r10 != r9) goto L9;
        return true;
    L9:
        int r12 = r10 - 1;
        int r1 = r9 / 32;
        int r2 = r12 / 32;
        int r3 = r1;
    L10:
        if (r3 > r2) goto L25;
        int r5 = 31;
        if (r3 <= r1) goto L14;
        int r6 = 0;
    L15:
        if (r3 < r2) goto L18;
        r5 = 31 & r12;
    L18:
        int r7 = (2 << r5) - (1 << r6);
        int r8 = this.bits[r3] & r7;
        if (r11 == true) goto L22;
        r7 = 0;
    L22:
        if (r8 != r7) goto L23;
        r3 = r3 + 1;
        goto L10
    L23:
        return false;
    L14:
        r6 = r9 & 31;
        goto L15
    L25:
        return true;
    L27:
        throw new IllegalArgumentException();
    }

    public void appendBit(boolean r5) {
        ensureCapacity(this.size + 1);
        if (r5 == false) goto L5;
        int[] r6 = this.bits;
        int r0 = this.size;
        int r2 = r0 / 32;
        r6[r2] = (1 << (r0 & 31)) | r6[r2];
    L5:
        this.size++;
    }

    public void appendBits(int r3, int r4) {
        if (r4 < 0) goto L14;
        if (r4 > 32) goto L14;
        ensureCapacity(this.size + r4);
    L6:
        if (r4 <= 0) goto L12;
        boolean r1 = true;
        if (((r3 >> (r4 - 1)) & 1) == 1) goto L11;
        r1 = false;
    L11:
        appendBit(r1);
        r4 = r4 - 1;
        goto L6
    L12:
        return;
    L14:
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public void appendBitArray(BitArray r4) {
        int r0 = r4.size;
        ensureCapacity(this.size + r0);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        appendBit(r4.get(r1));
        r1 = r1 + 1;
        goto L3
    }

    public void xor(BitArray r5) {
        if (this.size != r5.size) goto L10;
        int r0 = 0;
    L5:
        int[] r1 = this.bits;
        if (r0 >= r1.length) goto L8;
        r1[r0] = r1[r0] ^ r5.bits[r0];
        r0 = r0 + 1;
        goto L5
    L8:
        return;
    L10:
        throw new IllegalArgumentException("Sizes don't match");
    }

    public void toBytes(int r7, byte[] r8, int r9, int r10) {
        int r1 = 0;
    L3:
        if (r1 >= r10) goto L12;
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= 8) goto L11;
        if (get(r7) == false) goto L10;
        r3 = r3 | (1 << (7 - r2));
    L10:
        r7 = r7 + 1;
        r2 = r2 + 1;
        goto L6
    L11:
        r8[r9 + r1] = (byte) r3;
        r1 = r1 + 1;
        goto L3
    }

    public int[] getBitArray() {
        return this.bits;
    }

    public void reverse() {
        int[] r0 = new int[this.bits.length];
        int r1 = (this.size - 1) / 32;
        int r3 = r1 + 1;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        long r6 = this.bits[r5];
        long r7 = ((r6 & 1431655765) << 1) | ((r6 >> 1) & 1431655765);
        long r8 = ((r7 & 858993459) << 2) | ((r7 >> 2) & 858993459);
        long r9 = ((r8 & 252645135) << 4) | ((r8 >> 4) & 252645135);
        long r10 = ((r9 & 16711935) << 8) | ((r9 >> 8) & 16711935);
        r0[r1 - r5] = (int) (((r10 & 65535) << 16) | ((r10 >> 16) & 65535));
        r5 = r5 + 1;
        goto L3
    L5:
        int r2 = this.size;
        int r11 = r3 << 5;
        if (r2 == r11) goto L11;
        int r12 = r11 - r2;
        int r4 = r0[0] >>> r12;
        int r13 = 1;
    L8:
        if (r13 >= r3) goto L10;
        int r14 = r0[r13];
        r0[r13 - 1] = r4 | (r14 << (32 - r12));
        r4 = r14 >>> r12;
        r13 = r13 + 1;
        goto L8
    L10:
        r0[r3 - 1] = r4;
    L11:
        this.bits = r0;
    }

    private static int[] makeArray(int r0) {
        return new int[(r0 + 31) / 32];
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof BitArray) == true) goto L5;
        return false;
    L5:
        BitArray r5 = (BitArray) r4;
        if (this.size == r5.size) goto L8;
    L11:
        return false;
    L8:
        if (Arrays.equals(this.bits, r5.bits) == false) goto L11;
        return true;
    }

    public int hashCode() {
        return (this.size * 31) + Arrays.hashCode(this.bits);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(this.size);
        int r1 = 0;
    L4:
        if (r1 >= this.size) goto L14;
        if ((r1 & 7) != 0) goto L9;
        r0.append(' ');
    L9:
        if (get(r1) == false) goto L11;
        char r2 = 'X';
    L12:
        r0.append(r2);
        r1 = r1 + 1;
        goto L4
    L11:
        r2 = '.';
        goto L12
    L14:
        return r0.toString();
    }

    public BitArray clone() {
        return new BitArray((int[]) this.bits.clone(), this.size);
    }
}
