package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class CharTypes {
    protected static final byte[] HB;
    protected static final byte[] HBlower;
    protected static final char[] HC;
    protected static final char[] HClower;
    protected static final int[] sHexValues;
    protected static final int[] sInputCodes;
    protected static final int[] sInputCodesComment;
    protected static final int[] sInputCodesJsNames;
    protected static final int[] sInputCodesUTF8;
    protected static final int[] sInputCodesUtf8JsNames;
    protected static final int[] sInputCodesWS;
    protected static final int[] sOutputEscapes128;
    protected static final int[] sOutputEscapes128WithSlash;

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        HC = charArray;
        HClower = "0123456789abcdef".toCharArray();
        int length = charArray.length;
        HB = new byte[length];
        HBlower = new byte[length];
        for (int i = 0; i < length; i++) {
            HB[i] = (byte) HC[i];
            HBlower[i] = (byte) HClower[i];
        }
        int[] iArr = new int[ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH];
        for (int i3 = 0; i3 < 32; i3++) {
            iArr[i3] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        sInputCodes = iArr;
        int length2 = iArr.length;
        int[] iArr2 = new int[length2];
        System.arraycopy(iArr, 0, iArr2, 0, length2);
        for (int i10 = 128; i10 < 256; i10++) {
            iArr2[i10] = (i10 & 224) == 192 ? 2 : (i10 & 240) == 224 ? 3 : (i10 & 248) == 240 ? 4 : -1;
        }
        sInputCodesUTF8 = iArr2;
        int[] iArr3 = new int[ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH];
        Arrays.fill(iArr3, -1);
        for (int i11 = 33; i11 < 256; i11++) {
            if (Character.isJavaIdentifierPart((char) i11)) {
                iArr3[i11] = 0;
            }
        }
        iArr3[64] = 0;
        iArr3[35] = 0;
        iArr3[42] = 0;
        iArr3[45] = 0;
        iArr3[43] = 0;
        sInputCodesJsNames = iArr3;
        int[] iArr4 = new int[ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH];
        System.arraycopy(iArr3, 0, iArr4, 0, ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH);
        Arrays.fill(iArr4, 128, 128, 0);
        sInputCodesUtf8JsNames = iArr4;
        int[] iArr5 = new int[ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH];
        int[] iArr6 = sInputCodesUTF8;
        System.arraycopy(iArr6, 128, iArr5, 128, 128);
        Arrays.fill(iArr5, 0, 32, -1);
        iArr5[9] = 0;
        iArr5[10] = 10;
        iArr5[13] = 13;
        iArr5[42] = 42;
        sInputCodesComment = iArr5;
        int[] iArr7 = new int[ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH];
        System.arraycopy(iArr6, 128, iArr7, 128, 128);
        Arrays.fill(iArr7, 0, 32, -1);
        iArr7[32] = 1;
        iArr7[9] = 1;
        iArr7[10] = 10;
        iArr7[13] = 13;
        iArr7[47] = 47;
        iArr7[35] = 35;
        sInputCodesWS = iArr7;
        int[] iArr8 = new int[128];
        for (int i12 = 0; i12 < 32; i12++) {
            iArr8[i12] = -1;
        }
        iArr8[34] = 34;
        iArr8[92] = 92;
        iArr8[8] = 98;
        iArr8[9] = 116;
        iArr8[12] = 102;
        iArr8[10] = 110;
        iArr8[13] = 114;
        sOutputEscapes128 = iArr8;
        int[] iArrCopyOf = Arrays.copyOf(iArr8, iArr8.length);
        sOutputEscapes128WithSlash = iArrCopyOf;
        iArrCopyOf[47] = 47;
        int[] iArr9 = new int[ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH];
        sHexValues = iArr9;
        Arrays.fill(iArr9, -1);
        for (int i13 = 0; i13 < 10; i13++) {
            sHexValues[i13 + 48] = i13;
        }
        for (int i14 = 0; i14 < 6; i14++) {
            int[] iArr10 = sHexValues;
            int i15 = i14 + 10;
            iArr10[i14 + 97] = i15;
            iArr10[i14 + 65] = i15;
        }
    }

    public static void appendQuoted(StringBuilder sb2, String str) {
        int[] iArr = sOutputEscapes128;
        int length = iArr.length;
        int length2 = str.length();
        for (int i = 0; i < length2; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= length || iArr[cCharAt] == 0) {
                sb2.append(cCharAt);
            } else {
                sb2.append('\\');
                int i3 = iArr[cCharAt];
                if (i3 < 0) {
                    sb2.append('u');
                    sb2.append('0');
                    sb2.append('0');
                    char[] cArr = HC;
                    sb2.append(cArr[cCharAt >> 4]);
                    sb2.append(cArr[cCharAt & 15]);
                } else {
                    sb2.append((char) i3);
                }
            }
        }
    }

    public static int charToHex(int i) {
        return sHexValues[i & 255];
    }

    public static byte[] copyHexBytes(boolean z10) {
        return (byte[]) (z10 ? HB.clone() : HBlower.clone());
    }

    public static char[] copyHexChars(boolean z10) {
        return (char[]) (z10 ? HC.clone() : HClower.clone());
    }

    public static int[] get7BitOutputEscapes(int i, boolean z10) {
        return i == 34 ? z10 ? sOutputEscapes128WithSlash : sOutputEscapes128 : AltEscapes.instance.escapesFor(i, z10);
    }

    public static int[] getInputCodeComment() {
        return sInputCodesComment;
    }

    public static int[] getInputCodeLatin1() {
        return sInputCodes;
    }

    public static int[] getInputCodeLatin1JsNames() {
        return sInputCodesJsNames;
    }

    public static int[] getInputCodeUtf8() {
        return sInputCodesUTF8;
    }

    public static int[] getInputCodeUtf8JsNames() {
        return sInputCodesUtf8JsNames;
    }

    public static int[] getInputCodeWS() {
        return sInputCodesWS;
    }

    public static char hexToChar(int i) {
        return HC[i];
    }

    @Deprecated
    public static byte[] copyHexBytes() {
        return copyHexBytes(true);
    }

    @Deprecated
    public static char[] copyHexChars() {
        return copyHexChars(true);
    }

    public static int[] get7BitOutputEscapes(int i) {
        if (i == 34) {
            return sOutputEscapes128;
        }
        return AltEscapes.instance.escapesFor(i);
    }

    public static int[] get7BitOutputEscapes() {
        return sOutputEscapes128;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class AltEscapes {
        public static final AltEscapes instance = new AltEscapes();
        private int[][] _altEscapes = new int[128][];
        private int[][] _altEscapesWithSlash = new int[128][];

        private AltEscapes() {
        }

        public int[] escapesFor(int i) {
            int[] iArrCopyOf = this._altEscapes[i];
            if (iArrCopyOf == null) {
                iArrCopyOf = Arrays.copyOf(CharTypes.sOutputEscapes128, 128);
                if (iArrCopyOf[i] == 0) {
                    iArrCopyOf[i] = -1;
                }
                this._altEscapes[i] = iArrCopyOf;
            }
            return iArrCopyOf;
        }

        public int[] escapesFor(int i, boolean z10) {
            if (!z10) {
                return escapesFor(i);
            }
            int[] iArr = this._altEscapesWithSlash[i];
            if (iArr != null) {
                return iArr;
            }
            int[] iArrEscapesFor = escapesFor(i);
            iArrEscapesFor[47] = 47;
            this._altEscapesWithSlash[i] = iArrEscapesFor;
            return iArrEscapesFor;
        }
    }
}
