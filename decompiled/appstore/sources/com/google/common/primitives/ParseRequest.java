package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
final class ParseRequest {
    final int radix;
    final String rawValue;

    private ParseRequest(String r10, int r11) {
        this.rawValue = r10;
        this.radix = r11;
    }

    public static ParseRequest fromString(String r10) {
        if (r10.length() == 0) goto L22;
        char r11 = r10.charAt(0);
        int r12 = 16;
        if (r10.startsWith("0x") == false) goto L7;
    L18:
        r10 = r10.substring(2);
    L20:
        return new ParseRequest(r10, r12);
    L7:
        if (r10.startsWith("0X") == true) goto L18;
        if (r11 != '#') goto L13;
        r10 = r10.substring(1);
        goto L20
    L13:
        if (r11 == '0') goto L15;
    L17:
        r12 = 10;
        goto L20
    L15:
        if (r10.length() <= 1) goto L17;
        r10 = r10.substring(1);
        r12 = 8;
        goto L20
    L22:
        throw new NumberFormatException("empty string");
    }
}
