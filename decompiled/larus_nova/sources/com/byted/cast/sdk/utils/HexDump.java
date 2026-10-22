package com.byted.cast.sdk.utils;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;

/* JADX INFO: loaded from: classes43.dex */
public class HexDump {
    private static final char[] HEX_DIGITS = null;
    private static final char[] HEX_LOWER_CASE_DIGITS = null;

    public HexDump() {
    }

    public static byte[] toByteArray(byte r100) {
        return new byte[]{r100};
    }

    public static byte[] toByteArray(int r100) {
        return new byte[]{(byte) ((r100 >> 24) & 255), (byte) ((r100 >> 16) & 255), (byte) ((r100 >> 8) & 255), (byte) (r100 & 255)};
    }

    static {
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        HEX_LOWER_CASE_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public static String dumpHexString(byte[] r100) {
        if (r100 != null) goto L6;
        return "(null)";
    L6:
        return dumpHexString(r100, 0, r100.length);
    }

    public static byte[] hexStringToByteArray(String r100) {
        int r101 = r100.length();
        byte[] r102 = new byte[r101 / 2];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103 / 2] = (byte) ((toByte(r100.charAt(r103)) << 4) | toByte(r100.charAt(r103 + 1)));
        r103 = r103 + 2;
        goto L3
    L5:
        return r102;
    }

    private static int toByte(char r100) {
        if (r100 >= '0') goto L5;
    L8:
        char r101 = 'A';
        if (r100 >= 'A') goto L11;
    L14:
        r101 = 'a';
        if (r100 < 'a') goto L20;
        if (r100 > 'f') goto L20;
    L13:
        return (r100 - r101) + 10;
    L20:
        throw new RuntimeException("Invalid hex char '" + r100 + "'");
    L11:
        if (r100 > 'F') goto L14;
    L5:
        if (r100 > '9') goto L8;
        return r100 - '0';
    }

    public static String toHexString(byte r100) {
        return toHexString(toByteArray(r100));
    }

    public static String toHexString(int r100) {
        return toHexString(toByteArray(r100));
    }

    public static String toHexString(byte[] r100) {
        return toHexString(r100, 0, r100.length, true);
    }

    public static String toHexString(byte[] r100, boolean r101) {
        return toHexString(r100, 0, r100.length, r101);
    }

    public static StringBuilder appendByteAsHex(StringBuilder r100, byte r101, boolean r102) {
        if (r102 == false) goto L4;
        char[] r103 = HEX_DIGITS;
    L5:
        r100.append(r103[(r101 >> 4) & 15]);
        r100.append(r103[r101 & 15]);
        return r100;
    L4:
        r103 = HEX_LOWER_CASE_DIGITS;
        goto L5
    }

    public static String dumpHexString(byte[] r110, int r111, int r112) {
        if (r110 != null) goto L5;
        return "(null)";
    L5:
        StringBuilder r100 = new StringBuilder("\n0x");
        byte[] r101 = new byte[16];
        r100.append(toHexString(r111));
        int r102 = 0;
        int r103 = r111;
        int r104 = 0;
    L7:
        if (r103 >= (r111 + r112)) goto L19;
        if (r104 != 16) goto L18;
        r100.append(" ");
        int r105 = 0;
    L10:
        if (r105 >= 16) goto L17;
        byte r106 = r101[r105];
        if (r106 <= 32) goto L15;
        if (r106 >= 126) goto L15;
        r100.append(new String(r101, r105, 1));
    L16:
        r105 = r105 + 1;
    L15:
        r100.append(".");
        goto L16
    L17:
        r100.append("\n0x");
        r100.append(toHexString(r103));
        r104 = 0;
    L18:
        byte r107 = r110[r103];
        r100.append(" ");
        char[] r108 = HEX_DIGITS;
        r100.append(r108[(r107 >>> 4) & 15]);
        r100.append(r108[r107 & 15]);
        r101[r104] = r107;
        r103 = r103 + 1;
        r104 = r104 + 1;
        goto L7
    L19:
        if (r104 == 16) goto L31;
        int r113 = ((16 - r104) * 3) + 1;
        int r114 = 0;
    L21:
        if (r114 >= r113) goto L23;
        r100.append(" ");
        r114 = r114 + 1;
    L23:
        if (r102 >= r104) goto L31;
        byte r115 = r101[r102];
        if (r115 <= 32) goto L28;
        if (r115 >= 126) goto L28;
        r100.append(new String(r101, r102, 1));
    L29:
        r102 = r102 + 1;
    L28:
        r100.append(".");
    L31:
        return r100.toString();
    }

    public static String toHexString(byte[] r100, int r101, int r102) {
        return toHexString(r100, r101, r102, true);
    }

    public static String toHexString(byte[] r100, int r101, int r102, boolean r103) {
        if (r103 == false) goto L4;
        char[] r104 = HEX_DIGITS;
    L5:
        char[] r105 = new char[r102 * 2];
        int r106 = 0;
        int r107 = r101;
    L7:
        if (r107 >= (r101 + r102)) goto L10;
        byte r108 = r100[r107];
        int r109 = r106 + 1;
        r105[r106] = r104[(r108 >>> 4) & 15];
        r106 = r109 + 1;
        r105[r109] = r104[r108 & 15];
        r107 = r107 + 1;
        goto L7
    L10:
        return new String(r105);
    L4:
        r104 = HEX_LOWER_CASE_DIGITS;
        goto L5
    }
}
