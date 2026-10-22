package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultPlacement {
    private final byte[] bits;
    private final CharSequence codewords;
    private final int numcols;
    private final int numrows;

    public DefaultPlacement(CharSequence r1, int r2, int r3) {
        this.codewords = r1;
        this.numcols = r2;
        this.numrows = r3;
        byte[] r4 = new byte[r2 * r3];
        this.bits = r4;
        Arrays.fill(r4, (byte) -1);
    }

    final int getNumrows() {
        return this.numrows;
    }

    final int getNumcols() {
        return this.numcols;
    }

    final byte[] getBits() {
        return this.bits;
    }

    public final boolean getBit(int r2, int r3) {
        if (this.bits[(r3 * this.numcols) + r2] != 1) goto L5;
        return true;
    L5:
        return false;
    }

    private void setBit(int r2, int r3, boolean r4) {
        this.bits[(r3 * this.numcols) + r2] = r4 ? 1 : 0;
    }

    private boolean hasBit(int r2, int r3) {
        if (this.bits[(r3 * this.numcols) + r2] < 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final void place() {
        int r0 = 0;
        int r2 = 0;
        int r3 = 4;
    L4:
        if (r3 != this.numrows) goto L8;
        if (r0 != 0) goto L8;
        corner1(r2);
        r2 = r2 + 1;
    L8:
        if (r3 != (this.numrows - 2)) goto L14;
        if (r0 != 0) goto L14;
        if ((this.numcols % 4) == 0) goto L14;
        corner2(r2);
        r2 = r2 + 1;
    L14:
        if (r3 != (this.numrows - 2)) goto L20;
        if (r0 != 0) goto L20;
        if ((this.numcols % 8) != 4) goto L20;
        corner3(r2);
        r2 = r2 + 1;
    L20:
        if (r3 != (this.numrows + 4)) goto L26;
        if (r0 != 2) goto L26;
        if ((this.numcols % 8) != 0) goto L26;
        corner4(r2);
        r2 = r2 + 1;
    L26:
        if (r3 >= this.numrows) goto L31;
        if (r0 < 0) goto L31;
        if (hasBit(r0, r3) == true) goto L31;
        utah(r3, r0, r2);
        r2 = r2 + 1;
    L31:
        r3 = r3 - 2;
        r0 = r0 + 2;
        if (r3 < 0) goto L35;
        if (r0 < this.numcols) goto L26;
    L35:
        int r4 = r3 + 1;
        int r1 = r0 + 3;
    L36:
        if (r4 >= 0) goto L38;
    L42:
        r4 = r4 + 2;
        r1 = r1 - 2;
        int r5 = this.numrows;
        if (r4 >= r5) goto L45;
        if (r1 >= 0) goto L36;
    L45:
        r3 = r4 + 3;
        r0 = r1 + 1;
        if (r3 < r5) goto L4;
        int r6 = this.numcols;
        if (r0 < r6) goto L4;
        if (hasBit(r6 - 1, r5 - 1) == true) goto L65;
        setBit(this.numcols - 1, this.numrows - 1, true);
        setBit(this.numcols - 2, this.numrows - 2, true);
        return;
    L65:
        return;
    L38:
        if (r1 >= this.numcols) goto L42;
        if (hasBit(r1, r4) == true) goto L42;
        utah(r4, r1, r2);
        r2 = r2 + 1;
        goto L42
    }

    private void module(int r2, int r3, int r4, int r5) {
        if (r2 >= 0) goto L4;
        int r0 = this.numrows;
        r2 = r2 + r0;
        r3 = r3 + (4 - ((r0 + 4) % 8));
    L4:
        if (r3 >= 0) goto L6;
        int r1 = this.numcols;
        r3 = r3 + r1;
        r2 = r2 + (4 - ((r1 + 4) % 8));
    L6:
        char r6 = this.codewords.charAt(r4);
        boolean r7 = true;
        if ((r6 & (1 << (8 - r5))) != 0) goto L10;
        r7 = false;
    L10:
        setBit(r3, r2, r7);
    }

    private void utah(int r5, int r6, int r7) {
        int r0 = r5 - 2;
        int r1 = r6 - 2;
        module(r0, r1, r7, 1);
        int r2 = r6 - 1;
        module(r0, r2, r7, 2);
        int r3 = r5 - 1;
        module(r3, r1, r7, 3);
        module(r3, r2, r7, 4);
        module(r3, r6, r7, 5);
        module(r5, r1, r7, 6);
        module(r5, r2, r7, 7);
        module(r5, r6, r7, 8);
    }

    private void corner1(int r7) {
        module(this.numrows - 1, 0, r7, 1);
        module(this.numrows - 1, 1, r7, 2);
        module(this.numrows - 1, 2, r7, 3);
        module(0, this.numcols - 2, r7, 4);
        module(0, this.numcols - 1, r7, 5);
        module(1, this.numcols - 1, r7, 6);
        module(2, this.numcols - 1, r7, 7);
        module(3, this.numcols - 1, r7, 8);
    }

    private void corner2(int r7) {
        module(this.numrows - 3, 0, r7, 1);
        module(this.numrows - 2, 0, r7, 2);
        module(this.numrows - 1, 0, r7, 3);
        module(0, this.numcols - 4, r7, 4);
        module(0, this.numcols - 3, r7, 5);
        module(0, this.numcols - 2, r7, 6);
        module(0, this.numcols - 1, r7, 7);
        module(1, this.numcols - 1, r7, 8);
    }

    private void corner3(int r7) {
        module(this.numrows - 3, 0, r7, 1);
        module(this.numrows - 2, 0, r7, 2);
        module(this.numrows - 1, 0, r7, 3);
        module(0, this.numcols - 2, r7, 4);
        module(0, this.numcols - 1, r7, 5);
        module(1, this.numcols - 1, r7, 6);
        module(2, this.numcols - 1, r7, 7);
        module(3, this.numcols - 1, r7, 8);
    }

    private void corner4(int r7) {
        module(this.numrows - 1, 0, r7, 1);
        module(this.numrows - 1, this.numcols - 1, r7, 2);
        module(0, this.numcols - 3, r7, 3);
        module(0, this.numcols - 2, r7, 4);
        module(0, this.numcols - 1, r7, 5);
        module(1, this.numcols - 3, r7, 6);
        module(1, this.numcols - 2, r7, 7);
        module(1, this.numcols - 1, r7, 8);
    }
}
