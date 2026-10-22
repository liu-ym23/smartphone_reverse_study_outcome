package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible(emulated = true)
public final class Utf8 {
    private Utf8() {
    }

    public static int encodedLength(CharSequence r10) {
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L7;
        if (r10.charAt(r12) >= 128) goto L7;
        r12 = r12 + 1;
    L7:
        int r13 = r11;
    L8:
        if (r12 >= r11) goto L13;
        char r14 = r10.charAt(r12);
        if (r14 >= 2048) goto L12;
        r13 = r13 + ((127 - r14) >>> 31);
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = r13 + encodedLengthGeneral(r10, r12);
    L13:
        if (r13 < r11) goto L16;
        return r13;
    L16:
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) r13) + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence r10, int r11) {
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r11 >= r12) goto L17;
        char r14 = r10.charAt(r11);
        if (r14 >= 2048) goto L7;
        r13 = r13 + ((127 - r14) >>> 31);
    L16:
        r11 = r11 + 1;
        goto L3
    L7:
        r13 = r13 + 2;
        if (55296 > r14) goto L16;
        if (r14 > 57343) goto L16;
        if (Character.codePointAt(r10, r11) == r14) goto L15;
        r11 = r11 + 1;
        goto L16
    L15:
        throw new IllegalArgumentException(unpairedSurrogateMsg(r11));
    L17:
        return r13;
    }

    public static boolean isWellFormed(byte[] r10) {
        return isWellFormed(r10, 0, r10.length);
    }

    private static boolean isWellFormedSlowPath(byte[] r10, int r11, int r12) {
    L2:
        if (r11 >= r12) goto L3;
        int r13 = r11 + 1;
        byte r14 = r10[r11];
        if (r14 < 0) goto L8;
        r11 = r13;
        goto L2
    L8:
        if (r14 < (-32)) goto L9;
        if (r14 < (-16)) goto L18;
        if ((r11 + 3) >= r12) goto L34;
        int r15 = r11 + 2;
        byte r16 = r10[r13];
        if (r16 > (-65)) goto L43;
        if ((((r14 << Ascii.FS) + (r16 + 112)) >> 30) != 0) goto L43;
        int r17 = r11 + 3;
        if (r10[r15] > (-65)) goto L43;
        r11 = r11 + 4;
        if (r10[r17] <= (-65)) goto L2;
    L43:
        return false;
    L34:
        return false;
    L18:
        int r18 = r11 + 2;
        if (r18 >= r12) goto L20;
        byte r19 = r10[r13];
        if (r19 > (-65)) goto L31;
        if (r14 != (-32)) goto L27;
        if (r19 < (-96)) goto L31;
    L27:
        if (r14 != (-19)) goto L29;
        if ((-96) <= r19) goto L31;
    L29:
        r11 = r11 + 3;
        if (r10[r18] <= (-65)) goto L2;
    L31:
        return false;
    L20:
        return false;
    L9:
        if (r13 == r12) goto L10;
        if (r14 < (-62)) goto L15;
        r11 = r11 + 2;
        if (r10[r13] <= (-65)) goto L2;
    L15:
        return false;
    L10:
        return false;
    L3:
        return true;
    }

    private static String unpairedSurrogateMsg(int r10) {
        return "Unpaired surrogate at index " + r10;
    }

    public static boolean isWellFormed(byte[] r10, int r11, int r12) {
        int r13 = r12 + r11;
        Preconditions.checkPositionIndexes(r11, r13, r10.length);
    L3:
        if (r11 >= r13) goto L9;
        if (r10[r11] < 0) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        return isWellFormedSlowPath(r10, r11, r13);
    L9:
        return true;
    }
}
