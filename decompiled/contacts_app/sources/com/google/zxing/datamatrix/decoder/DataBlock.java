package com.google.zxing.datamatrix.decoder;

/* JADX INFO: loaded from: classes3.dex */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int r1, byte[] r2) {
        this.numDataCodewords = r1;
        this.codewords = r2;
    }

    static DataBlock[] getDataBlocks(byte[] r13, Version r14) {
        Version.ECBlocks r0 = r14.getECBlocks();
        Version.ECB[] r1 = r0.getECBlocks();
        int r2 = r1.length;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r5 = r5 + r1[r4].getCount();
        r4 = r4 + 1;
        goto L3
    L5:
        DataBlock[] r3 = new DataBlock[r5];
        int r6 = r1.length;
        int r7 = 0;
        int r8 = 0;
    L6:
        if (r7 >= r6) goto L12;
        Version.ECB r9 = r1[r7];
        int r10 = 0;
    L9:
        if (r10 >= r9.getCount()) goto L11;
        int r11 = r9.getDataCodewords();
        r3[r8] = new DataBlock(r11, new byte[r0.getECCodewords() + r11]);
        r10 = r10 + 1;
        r8 = r8 + 1;
        goto L9
    L11:
        r7 = r7 + 1;
        goto L6
    L12:
        int r12 = r3[0].codewords.length - r0.getECCodewords();
        int r15 = r12 - 1;
        int r16 = 0;
        int r17 = 0;
    L13:
        if (r16 >= r15) goto L19;
        int r18 = 0;
    L15:
        if (r18 >= r8) goto L17;
        r3[r18].codewords[r16] = r13[r17];
        r18 = r18 + 1;
        r17 = r17 + 1;
        goto L15
    L17:
        r16 = r16 + 1;
        goto L13
    L19:
        if (r14.getVersionNumber() != 24) goto L21;
        boolean r19 = true;
    L22:
        if (r19 == false) goto L24;
        int r20 = 8;
    L25:
        int r21 = 0;
    L26:
        if (r21 >= r20) goto L28;
        r3[r21].codewords[r15] = r13[r17];
        r21 = r21 + 1;
        r17 = r17 + 1;
        goto L26
    L28:
        int r22 = r3[0].codewords.length;
    L29:
        if (r12 >= r22) goto L43;
        int r23 = 0;
    L31:
        if (r23 >= r8) goto L41;
        if (r19 == false) goto L34;
        int r24 = (r23 + 8) % r8;
    L35:
        if (r19 == true) goto L37;
    L39:
        int r25 = r12;
    L40:
        r3[r24].codewords[r25] = r13[r17];
        r23 = r23 + 1;
        r17 = r17 + 1;
        goto L31
    L37:
        if (r24 <= 7) goto L39;
        r25 = r12 - 1;
        goto L40
    L34:
        r24 = r23;
        goto L35
    L41:
        r12 = r12 + 1;
        goto L29
    L43:
        if (r17 != r13.length) goto L46;
        return r3;
    L46:
        throw new IllegalArgumentException();
    L24:
        r20 = r8;
        goto L25
    L21:
        r19 = false;
        goto L22
    }

    int getNumDataCodewords() {
        return this.numDataCodewords;
    }

    byte[] getCodewords() {
        return this.codewords;
    }
}
