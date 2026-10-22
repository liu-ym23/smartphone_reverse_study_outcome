package com.autonavi.base.amap.mapcore;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.ByteArrayOutputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public class Convert {
    public static byte[] convertInt(int r100) {
        return new byte[]{(byte) (r100 & 255), (byte) ((r100 >> 8) & 255), (byte) ((r100 >> 16) & 255), (byte) ((r100 >> 24) & 255)};
    }

    public static byte[] convertShort(int r100) {
        return new byte[]{(byte) (r100 & 255), (byte) ((r100 >> 8) & 255)};
    }

    public static byte[] covertBytes(byte r100) {
        return new byte[]{r100};
    }

    public static boolean getBit(byte r100, int r101) {
        int r102 = 32 - r101;
        if ((((r100 << r102) >>> r102) >>> (r101 - 1)) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getNum(byte r100, int r101, int r102) {
        int r103 = (32 - r102) - 1;
        return ((r100 << r103) >>> r103) >>> r101;
    }

    public static int getNum(short r100, int r101, int r102) {
        int r103 = 32 - r102;
        return ((r100 << r103) >>> r103) >>> (r101 - 1);
    }

    public Convert() {
    }

    public static final String bytesToHexString(byte[] r100) {
        StringBuffer r101 = new StringBuffer(r100.length);
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        String r103 = Integer.toHexString(r100[r102] & UByte.MAX_VALUE);
        if (r103.length() >= 2) goto L8;
        r101.append(0);
    L8:
        r101.append(r103.toUpperCase());
        r102 = r102 + 1;
        goto L4
    L10:
        return r101.toString();
    }

    public static byte[] get1BString(String r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L5
        byte[] r102 = r100.getBytes("UTF-8");     // Catch: Exception -> L5
        r101.write(new byte[]{(byte) r102.length});     // Catch: Exception -> L5
        r101.write(r102);     // Catch: Exception -> L5
        return r101.toByteArray();
    L5:
        e = move-exception;
        e.printStackTrace();
        return new byte[1];
    }

    public static byte[] get2BString(String r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L4
        byte[] r102 = r100.getBytes("UTF-8");     // Catch: Exception -> L4
        r101.write(convertShort(r102.length));     // Catch: Exception -> L4
        r101.write(r102);     // Catch: Exception -> L4
        return r101.toByteArray();
    L4:
        e = move-exception;
        e.printStackTrace();
        return new byte[1];
    }

    public static byte[] getDouble(double r100) {
        byte[] r101 = new byte[8];
        String r102 = Long.toHexString(Double.doubleToLongBits(r100));
        int r103 = 0;
    L3:
        if (r103 >= 8) goto L5;
        int r104 = r103 * 2;
        String r105 = r102.substring(r104, r104 + 2);
        r101[7 - r103] = (byte) CastIntegerProtector.parseInt(r105, 16);
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static double convertDouble(byte[] r100, int r101) {
        long r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= 8) goto L7;
        r102 = r102 + (((long) (r100[r103 + r101] & UByte.MAX_VALUE)) << (r103 * 8));
        r103 = r103 + 1;
        goto L4
    L7:
        return Double.longBitsToDouble(r102);
    }

    public static int getInt(byte[] r100, int r101) {
        int r102 = r100[r101 + 3] & UByte.MAX_VALUE;
        int r103 = r100[r101 + 2] & UByte.MAX_VALUE;
        int r104 = r100[r101 + 1] & UByte.MAX_VALUE;
        int r105 = r100[r101 + 0] & UByte.MAX_VALUE;
        return (((r102 << 24) + (r103 << 16)) + (r104 << 8)) + (r105 << 0);
    }

    public static short getShort(byte[] r100, int r101) {
        int r102 = r100[r101 + 1] & UByte.MAX_VALUE;
        int r103 = r100[r101 + 0] & UByte.MAX_VALUE;
        return (short) ((r102 << 8) + (r103 << 0));
    }

    public static int getUShort(byte[] r100, int r101) {
        int r102 = r100[r101 + 1] & UByte.MAX_VALUE;
        int r103 = r100[r101 + 0] & UByte.MAX_VALUE;
        return (r102 << 8) + (r103 << 0);
    }

    public static void convert1bString(byte[] r100, int r101, ConvertString r102) {
        byte r103 = r100[r101];     // Catch: Exception -> L4
        r102.byteLength = r103;     // Catch: Exception -> L4
        r102.value = new String(r100, r101 + 1, r103, "UTF-8");     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        r102.byteLength = 0;
        r102.value = "";
    }

    public static void convert2bString(byte[] r100, int r101, ConvertString r102) {
        short r103 = getShort(r100, r101);     // Catch: Exception -> L4
        r102.byteLength = r103;     // Catch: Exception -> L4
        r102.value = new String(r100, r101 + 2, r103, "UTF-8");     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        r102.byteLength = 0;
        r102.value = "";
    }

    public static byte[] copyString(byte[] r100, int r101, int r102) {
        byte[] r103 = new byte[r102];
        System.arraycopy(r100, r101, r103, 0, r102);
        return r103;
    }

    public static String getString(byte[] r100, int r101, int r102) {
        return new String(r100, r101, r102, "UTF-8");
    L4:
        return "";
    }

    public static byte[] getSubBytes(byte[] r100, int r101, int r102) {
        byte[] r103 = new byte[r102];
        System.arraycopy(r100, r101, r103, 0, r102);
        return r103;
    }

    public static void writeInt(byte[] r100, int r101, int r102) {
        System.arraycopy(convertInt(r102), 0, r100, r101, 4);
    }

    public static void writeShort(byte[] r100, int r101, short r102) {
        System.arraycopy(convertShort(r102), 0, r100, r101, 2);
    }

    public static void moveArray(byte[] r100, int r101, byte[] r102, int r103, int r104) {
        byte[] r105 = new byte[r104];
        System.arraycopy(r100, r101, r105, 0, r104);
        System.arraycopy(r105, 0, r102, r103, r104);
    }
}
