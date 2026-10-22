package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

/* JADX INFO: loaded from: classes3.dex */
final class BitMatrixParser {
    private final BitMatrix bitMatrix;
    private boolean mirror;
    private FormatInformation parsedFormatInfo;
    private Version parsedVersion;

    BitMatrixParser(BitMatrix r3) throws FormatException {
        int r0 = r3.getHeight();
        if (r0 < 21) goto L9;
        if ((r0 & 3) != 1) goto L9;
        this.bitMatrix = r3;
        return;
    L9:
        throw FormatException.getFormatInstance();
    }

    FormatInformation readFormatInformation() throws FormatException {
        FormatInformation r0 = this.parsedFormatInfo;
        if (r0 == null) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r2 >= 6) goto L9;
        r3 = copyBit(r2, 8, r3);
        r2 = r2 + 1;
        goto L7
    L9:
        int r4 = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, r3)));
        int r5 = 5;
    L10:
        if (r5 < 0) goto L12;
        r4 = copyBit(8, r5, r4);
        r5 = r5 - 1;
        goto L10
    L12:
        int r6 = this.bitMatrix.getHeight();
        int r7 = r6 - 7;
        int r8 = r6 - 1;
    L13:
        if (r8 < r7) goto L15;
        r1 = copyBit(8, r8, r1);
        r8 = r8 - 1;
        goto L13
    L15:
        int r9 = r6 - 8;
    L16:
        if (r9 >= r6) goto L18;
        r1 = copyBit(r9, 8, r1);
        r9 = r9 + 1;
        goto L16
    L18:
        FormatInformation r10 = FormatInformation.decodeFormatInformation(r4, r1);
        this.parsedFormatInfo = r10;
        if (r10 == null) goto L22;
        return r10;
    L22:
        throw FormatException.getFormatInstance();
    }

    Version readVersion() throws FormatException {
        Version r0 = this.parsedVersion;
        if (r0 == null) goto L5;
        return r0;
    L5:
        int r1 = this.bitMatrix.getHeight();
        int r2 = (r1 - 17) / 4;
        if (r2 <= 6) goto L8;
        int r3 = r1 - 11;
        int r4 = 5;
        int r5 = 0;
        int r6 = 5;
        int r7 = 0;
    L10:
        if (r6 < 0) goto L15;
        int r8 = r1 - 9;
    L12:
        if (r8 < r3) goto L14;
        r7 = copyBit(r8, r6, r7);
        r8 = r8 - 1;
        goto L12
    L14:
        r6 = r6 - 1;
        goto L10
    L15:
        Version r9 = Version.decodeVersionInformation(r7);
        if (r9 == null) goto L21;
        if (r9.getDimensionForVersion() != r1) goto L21;
        this.parsedVersion = r9;
        return r9;
    L21:
        if (r4 < 0) goto L26;
        int r10 = r1 - 9;
    L23:
        if (r10 < r3) goto L25;
        r5 = copyBit(r4, r10, r5);
        r10 = r10 - 1;
        goto L23
    L25:
        r4 = r4 - 1;
        goto L21
    L26:
        Version r11 = Version.decodeVersionInformation(r5);
        if (r11 == null) goto L33;
        if (r11.getDimensionForVersion() != r1) goto L33;
        this.parsedVersion = r11;
        return r11;
    L33:
        throw FormatException.getFormatInstance();
    L8:
        return Version.getVersionForNumber(r2);
    }

    private int copyBit(int r2, int r3, int r4) {
        boolean r0 = this.mirror;
        BitMatrix r1 = this.bitMatrix;
        if (r0 == false) goto L5;
        boolean r5 = r1.get(r3, r2);
    L6:
        if (r5 == false) goto L10;
        return (r4 << 1) | 1;
    L10:
        return r4 << 1;
    L5:
        r5 = r1.get(r2, r3);
        goto L6
    }

    byte[] readCodewords() throws FormatException {
        FormatInformation r1 = readFormatInformation();
        Version r2 = readVersion();
        DataMask r3 = DataMask.values()[r1.getDataMask()];
        int r4 = this.bitMatrix.getHeight();
        r3.unmaskBitMatrix(this.bitMatrix, r4);
        BitMatrix r5 = r2.buildFunctionPattern();
        byte[] r6 = new byte[r2.getTotalCodewords()];
        int r7 = r4 - 1;
        boolean r8 = true;
        int r9 = r7;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r9 <= 0) goto L27;
        if (r9 != 6) goto L7;
        r9 = r9 - 1;
    L7:
        int r13 = 0;
    L8:
        if (r13 >= r4) goto L25;
        if (r8 == false) goto L11;
        int r14 = r7 - r13;
    L12:
        int r15 = 0;
    L14:
        if (r15 >= 2) goto L24;
        int r16 = r9 - r15;
        if (r5.get(r16, r14) == true) goto L23;
        r11 = r11 + 1;
        r12 = r12 << 1;
        if (this.bitMatrix.get(r16, r14) == false) goto L21;
        r12 = r12 | 1;
    L21:
        if (r11 != 8) goto L23;
        r6[r10] = (byte) r12;
        r10 = r10 + 1;
        r11 = 0;
        r12 = 0;
    L23:
        r15 = r15 + 1;
        goto L14
    L24:
        r13 = r13 + 1;
        goto L8
    L11:
        r14 = r13;
        goto L12
    L25:
        r8 = !r8;
        r9 = r9 - 2;
        goto L3
    L27:
        if (r10 != r2.getTotalCodewords()) goto L30;
        return r6;
    L30:
        throw FormatException.getFormatInstance();
    }

    void remask() {
        if (this.parsedFormatInfo != null) goto L5;
        return;
    L5:
        DataMask r0 = DataMask.values()[this.parsedFormatInfo.getDataMask()];
        int r1 = this.bitMatrix.getHeight();
        r0.unmaskBitMatrix(this.bitMatrix, r1);
    }

    void setMirror(boolean r2) {
        this.parsedVersion = null;
        this.parsedFormatInfo = null;
        this.mirror = r2;
    }

    void mirror() {
        int r0 = 0;
    L4:
        if (r0 >= this.bitMatrix.getWidth()) goto L13;
        int r1 = r0 + 1;
        int r2 = r1;
    L7:
        if (r2 >= this.bitMatrix.getHeight()) goto L12;
        if (this.bitMatrix.get(r0, r2) == this.bitMatrix.get(r2, r0)) goto L11;
        this.bitMatrix.flip(r2, r0);
        this.bitMatrix.flip(r0, r2);
    L11:
        r2 = r2 + 1;
        goto L7
    L12:
        r0 = r1;
        goto L4
    }
}
