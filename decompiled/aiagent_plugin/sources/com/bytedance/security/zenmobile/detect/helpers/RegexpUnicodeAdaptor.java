package com.bytedance.security.zenmobile.detect.helpers;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class RegexpUnicodeAdaptor {
    private static final String allChinese = "[\\x{4E00}-\\x{9FFF}·]";
    private static final String allChineseUtf8Bytes = "(([\\xE5-\\xE9][\\x80-\\xBF][\\x80-\\xBF])|(\\xE4[\\xB8-\\xBF][\\x80-\\xBF])|(\\xC2\\xB7))";

    private static int getNumBytesForUtf8Char(int r4) {
        if ((r4 >> 7) != 0) goto L6;
        return 1;
    L6:
        if ((r4 >> 5) != 6) goto L10;
        return 2;
    L10:
        if ((r4 >> 4) != 14) goto L13;
        return 3;
    L13:
        if ((r4 >> 3) != 30) goto L16;
        return 4;
    L16:
        return 1;
    }

    public RegexpUnicodeAdaptor() {
    }

    public static String matchAllChineseChars(String r2) {
        return r2.replace(allChinese, allChineseUtf8Bytes);
    }

    public static String getUtf8Encoding(String r8) {
        StringBuilder r0 = new StringBuilder();
        byte[] r9 = r8.getBytes(StandardCharsets.UTF_8);
        int r2 = 0;
    L4:
        if (r2 >= r9.length) goto L14;
        int r3 = r9[r2] & 255;
        if (r3 <= 127) goto L11;
        int r4 = getNumBytesForUtf8Char(r3);
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L10;
        r0.append(String.format("\\x%02X", new Object[]{Integer.valueOf(r9[r2 + r5] & 255)}));
        r5 = r5 + 1;
        goto L8
    L10:
        r2 = r2 + (r4 - 1);
    L12:
        r2 = r2 + 1;
        goto L4
    L11:
        r0.append((char) r3);
        goto L12
    L14:
        return r0.toString();
    }
}
