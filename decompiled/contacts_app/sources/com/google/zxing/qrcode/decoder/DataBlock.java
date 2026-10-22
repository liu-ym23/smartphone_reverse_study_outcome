package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: classes3.dex */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int r1, byte[] r2) {
        this.numDataCodewords = r1;
        this.codewords = r2;
    }

    static DataBlock[] getDataBlocks(byte[] r12, Version r13, ErrorCorrectionLevel r14) {
        if (r12.length != r13.getTotalCodewords()) goto L39;
        Version.ECBlocks r15 = r13.getECBlocksForLevel(r14);
        Version.ECB[] r16 = r15.getECBlocks();
        int r0 = r16.length;
        int r2 = 0;
        int r3 = 0;
    L5:
        if (r2 >= r0) goto L7;
        r3 = r3 + r16[r2].getCount();
        r2 = r2 + 1;
        goto L5
    L7:
        DataBlock[] r1 = new DataBlock[r3];
        int r4 = r16.length;
        int r5 = 0;
        int r6 = 0;
    L8:
        if (r5 >= r4) goto L14;
        Version.ECB r7 = r16[r5];
        int r8 = 0;
    L11:
        if (r8 >= r7.getCount()) goto L13;
        int r9 = r7.getDataCodewords();
        r1[r6] = new DataBlock(r9, new byte[r15.getECCodewordsPerBlock() + r9]);
        r8 = r8 + 1;
        r6 = r6 + 1;
        goto L11
    L13:
        r5 = r5 + 1;
        goto L8
    L14:
        int r17 = r1[0].codewords.length;
        int r10 = r3 - 1;
    L15:
        if (r10 < 0) goto L19;
        if (r1[r10].codewords.length == r17) goto L19;
        r10 = r10 - 1;
    L19:
        int r11 = r10 + 1;
        int r18 = r17 - r15.getECCodewordsPerBlock();
        int r19 = 0;
        int r20 = 0;
    L20:
        if (r19 >= r18) goto L25;
        int r21 = 0;
    L22:
        if (r21 >= r6) goto L24;
        r1[r21].codewords[r19] = r12[r20];
        r21 = r21 + 1;
        r20 = r20 + 1;
        goto L22
    L24:
        r19 = r19 + 1;
        goto L20
    L25:
        int r110 = r11;
    L26:
        if (r110 >= r6) goto L28;
        r1[r110].codewords[r18] = r12[r20];
        r110 = r110 + 1;
        r20 = r20 + 1;
        goto L26
    L28:
        int r111 = r1[0].codewords.length;
    L29:
        if (r18 >= r111) goto L37;
        int r22 = 0;
    L31:
        if (r22 >= r6) goto L36;
        if (r22 >= r11) goto L34;
        int r23 = r18;
    L35:
        r1[r22].codewords[r23] = r12[r20];
        r22 = r22 + 1;
        r20 = r20 + 1;
        goto L31
    L34:
        r23 = r18 + 1;
        goto L35
    L36:
        r18 = r18 + 1;
        goto L29
    L37:
        return r1;
    L39:
        throw new IllegalArgumentException();
    }

    int getNumDataCodewords() {
        return this.numDataCodewords;
    }

    byte[] getCodewords() {
        return this.codewords;
    }
}
