package com.google.zxing.maxicode.decoder;

import com.google.common.base.Ascii;
import com.google.zxing.common.DecoderResult;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes3.dex */
final class DecodedBitStreamParser {
    private static final char ECI = 65530;
    private static final char FS = 28;
    private static final char GS = 29;
    private static final char LATCHA = 65527;
    private static final char LATCHB = 65528;
    private static final char LOCK = 65529;
    private static final char NS = 65531;
    private static final char PAD = 65532;
    private static final char RS = 30;
    private static final String[] SETS = null;
    private static final char SHIFTA = 65520;
    private static final char SHIFTB = 65521;
    private static final char SHIFTC = 65522;
    private static final char SHIFTD = 65523;
    private static final char SHIFTE = 65524;
    private static final char THREESHIFTA = 65526;
    private static final char TWOSHIFTA = 65525;

    static {
        SETS = new String[]{"\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};
    }

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(byte[] r7, int r8) {
        StringBuilder r0 = new StringBuilder(144);
        if (r8 == 2) goto L14;
        if (r8 == 3) goto L14;
        if (r8 != 4) goto L9;
        r0.append(getMessage(r7, 1, 93));
    L22:
        return new DecoderResult(r7, r0.toString(), null, String.valueOf(r8));
    L9:
        if (r8 != 5) goto L22;
        r0.append(getMessage(r7, 1, 77));
    L14:
        if (r8 != 2) goto L16;
        String r1 = new DecimalFormat("0000000000".substring(0, getPostCode2Length(r7))).format(getPostCode2(r7));
    L17:
        DecimalFormat r3 = new DecimalFormat("000");
        String r4 = r3.format(getCountry(r7));
        String r5 = r3.format(getServiceClass(r7));
        r0.append(getMessage(r7, 10, 84));
        if (r0.toString().startsWith("[)>\u001e01\u001d") == false) goto L20;
        r0.insert(9, r1 + GS + r4 + GS + r5 + GS);
        goto L22
    L20:
        r0.insert(0, r1 + GS + r4 + GS + r5 + GS);
        goto L22
    L16:
        r1 = getPostCode3(r7);
        goto L17
    }

    private static int getBit(int r1, byte[] r2) {
        int r3 = r1 - 1;
        if (((1 << (5 - (r3 % 6))) & r2[r3 / 6]) != 0) goto L6;
        return 0;
    L6:
        return 1;
    }

    private static int getInt(byte[] r4, byte[] r5) {
        if (r5.length == 0) goto L10;
        int r0 = 0;
        int r1 = 0;
    L6:
        if (r0 >= r5.length) goto L8;
        r1 = r1 + (getBit(r5[r0], r4) << ((r5.length - r0) - 1));
        r0 = r0 + 1;
        goto L6
    L8:
        return r1;
    L10:
        throw new IllegalArgumentException();
    }

    private static int getCountry(byte[] r1) {
        return getInt(r1, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38});
    }

    private static int getServiceClass(byte[] r1) {
        return getInt(r1, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52});
    }

    private static int getPostCode2Length(byte[] r1) {
        return getInt(r1, new byte[]{39, 40, 41, 42, Ascii.US, 32});
    }

    private static int getPostCode2(byte[] r1) {
        return getInt(r1, new byte[]{33, 34, 35, 36, Ascii.EM, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 7, 8, 9, 10, Ascii.VT, Ascii.FF, 1, 2});
    }

    private static String getPostCode3(byte[] r6) {
        String[] r2 = SETS;
        return String.valueOf(new char[]{r2[0].charAt(getInt(r6, new byte[]{39, 40, 41, 42, Ascii.US, 32})), r2[0].charAt(getInt(r6, new byte[]{33, 34, 35, 36, Ascii.EM, Ascii.SUB})), r2[0].charAt(getInt(r6, new byte[]{Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, 19, Ascii.DC4})), r2[0].charAt(getInt(r6, new byte[]{Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.CR, Ascii.SO})), r2[0].charAt(getInt(r6, new byte[]{Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 7, 8})), r2[0].charAt(getInt(r6, new byte[]{9, 10, Ascii.VT, Ascii.FF, 1, 2}))});
    }

    private static String getMessage(byte[] r12, int r13, int r14) {
        StringBuilder r0 = new StringBuilder();
        int r3 = r13;
        int r5 = -1;
        int r4 = 0;
        int r6 = 0;
    L4:
        if (r3 >= (r13 + r14)) goto L22;
        char r7 = SETS[r4].charAt(r12[r3]);
        switch(r7) {
            case 65520: goto L16;
            case 65521: goto L16;
            case 65522: goto L16;
            case 65523: goto L16;
            case 65524: goto L16;
            case 65525: goto L13;
            case 65526: goto L12;
            case 65527: goto L11;
            case 65528: goto L10;
            case 65529: goto L9;
            case 65530: goto L7;
            case 65531: goto L8;
            default: goto L7;
        };
    L7:
        r0.append(r7);
    L17:
        int r8 = r5 - 1;
        if (r5 != 0) goto L20;
        r4 = r6;
    L20:
        r3 = r3 + 1;
        r5 = r8;
        goto L4
    L8:
        int r9 = r3 + 1;
        int r10 = r12[r9] << Ascii.CAN;
        int r11 = r9 + 1;
        int r15 = r10 + (r12[r11] << Ascii.DC2);
        int r16 = r11 + 1;
        int r17 = r15 + (r12[r16] << Ascii.FF);
        int r18 = r16 + 1;
        int r19 = r17 + (r12[r18] << 6);
        r3 = r18 + 1;
        r0.append(new DecimalFormat("000000000").format(r19 + r12[r3]));
        goto L17
    L9:
        r5 = -1;
        goto L17
    L10:
        r5 = -1;
        r4 = 1;
        goto L17
    L11:
        r5 = -1;
    L15:
        r4 = 0;
        goto L17
    L12:
        r5 = 3;
    L14:
        r6 = r4;
        goto L15
    L13:
        r5 = 2;
        goto L14
    L16:
        r6 = r4;
        r4 = r7 - SHIFTA;
        r5 = 1;
    L22:
        if (r0.length() <= 0) goto L27;
        if (r0.charAt(r0.length() - 1) != 65532) goto L27;
        r0.setLength(r0.length() - 1);
    L27:
        return r0.toString();
    }
}
