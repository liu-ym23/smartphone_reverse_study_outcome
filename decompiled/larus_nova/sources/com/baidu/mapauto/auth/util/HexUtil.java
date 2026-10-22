package com.baidu.mapauto.auth.util;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public class HexUtil {
    private static final char[] DIGITS_LOWER = null;
    private static final char[] DIGITS_UPPER = null;

    static {
        DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        DIGITS_UPPER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public HexUtil() {
    }

    public static String byte2hex(byte[] r100) {
        StringBuffer r101 = new StringBuffer();
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        String r103 = Integer.toHexString(r100[r102] & UByte.MAX_VALUE);
        if (r103.length() != 1) goto L8;
        r101.append("0");
    L8:
        r101.append(r103);
        r102 = r102 + 1;
        goto L4
    L10:
        return r101.toString();
    }

    public static char[] encodeHex(byte[] r100) {
        return encodeHex(r100, true);
    }

    public static char[] encodeHex(byte[] r100, boolean r101) {
        if (r101 == false) goto L4;
        char[] r102 = DIGITS_LOWER;
    L6:
        return encodeHex(r100, r102);
    L4:
        r102 = DIGITS_UPPER;
        goto L6
    }

    public static char[] encodeHex(byte[] r100, char[] r101) {
        int r102 = r100.length;
        char[] r103 = new char[r102 << 1];
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r102) goto L5;
        int r106 = r105 + 1;
        byte r107 = r100[r104];
        r103[r105] = r101[(r107 & 240) >>> 4];
        r105 = r106 + 1;
        r103[r106] = r101[r107 & 15];
        r104 = r104 + 1;
        goto L3
    L5:
        return r103;
    }

    public static String encodeHexStr(byte[] r100) {
        return encodeHexStr(r100, true);
    }

    public static String encodeHexStr(byte[] r100, boolean r101) {
        if (r101 == false) goto L4;
        char[] r102 = DIGITS_LOWER;
    L6:
        return encodeHexStr(r100, r102);
    L4:
        r102 = DIGITS_UPPER;
        goto L6
    }

    public static String encodeHexStr(byte[] r100, char[] r101) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return new String(encodeHex(r100, r101));
    }

    public static byte[] hex2byte(String r100) {
        int r101 = 0;
        if (r100 == null) goto L11;
        if (r100.length() < 2) goto L11;
        int r102 = r100.length() / 2;
        byte[] r103 = new byte[r102];
    L7:
        if (r101 >= r102) goto L9;
        int r104 = r101 * 2;
        r103[r101] = (byte) (CastIntegerProtector.parseInt(r100.substring(r104, r104 + 2), 16) & 255);
        r101 = r101 + 1;
        goto L7
    L9:
        return r103;
    L11:
        return new byte[0];
    }
}
