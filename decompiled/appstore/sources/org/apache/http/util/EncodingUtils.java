package org.apache.http.util;

import org.apache.http.Consts;

/* JADX INFO: loaded from: classes4.dex */
public final class EncodingUtils {
    private EncodingUtils() {
    }

    public static byte[] getAsciiBytes(String r10) {
        Args.notNull(r10, "Input");
        return r10.getBytes(Consts.ASCII);
    }

    public static String getAsciiString(byte[] r10, int r11, int r12) {
        Args.notNull(r10, "Input");
        return new String(r10, r11, r12, Consts.ASCII);
    }

    public static byte[] getBytes(String r10, String r11) {
        Args.notNull(r10, "Input");
        Args.notEmpty(r11, "Charset");
        return r10.getBytes(r11);
    L6:
        return r10.getBytes();
    }

    public static String getString(byte[] r10, int r11, int r12, String r13) {
        Args.notNull(r10, "Input");
        Args.notEmpty(r13, "Charset");
        return new String(r10, r11, r12, r13);
    L6:
        return new String(r10, r11, r12);
    }

    public static String getAsciiString(byte[] r10) {
        Args.notNull(r10, "Input");
        return getAsciiString(r10, 0, r10.length);
    }

    public static String getString(byte[] r10, String r11) {
        Args.notNull(r10, "Input");
        return getString(r10, 0, r10.length, r11);
    }
}
