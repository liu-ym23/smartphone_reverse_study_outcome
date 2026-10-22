package com.autonavi.base.amap.mapcore.tools;

import java.io.ByteArrayOutputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public class GLConvertUtil {
    public static byte[] convertInt(int r100) {
        return new byte[]{(byte) (r100 & 255), (byte) ((r100 >> 8) & 255), (byte) ((r100 >> 16) & 255), (byte) ((r100 >> 24) & 255)};
    }

    public static byte[] convertShort(int r100) {
        return new byte[]{(byte) (r100 & 255), (byte) ((r100 >> 8) & 255)};
    }

    public GLConvertUtil() {
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

    public static int getInt2(byte[] r100, int r101) {
        int r102 = r100[r101 + 0] & UByte.MAX_VALUE;
        int r103 = r100[r101 + 1] & UByte.MAX_VALUE;
        int r104 = r100[r101 + 2] & UByte.MAX_VALUE;
        int r105 = r100[r101 + 3] & UByte.MAX_VALUE;
        return (((r102 << 24) + (r103 << 16)) + (r104 << 8)) + (r105 << 0);
    }

    public static long getLong(byte[] r110, int r111) {
        return ((((((((r110[r111 + 7] & UByte.MAX_VALUE) << 56) + ((r110[r111 + 6] & UByte.MAX_VALUE) << 48)) + ((r110[r111 + 5] & UByte.MAX_VALUE) << 40)) + ((r110[r111 + 4] & UByte.MAX_VALUE) << 32)) + ((r110[r111 + 3] & UByte.MAX_VALUE) << 24)) + ((r110[r111 + 2] & UByte.MAX_VALUE) << 16)) + ((r110[r111 + 1] & UByte.MAX_VALUE) << 8)) + (((long) (r110[r111 + 0] & UByte.MAX_VALUE)) << 0);
    }

    public static short getShort(byte[] r100, int r101) {
        int r102 = r100[r101 + 1] & UByte.MAX_VALUE;
        int r103 = r100[r101 + 0] & UByte.MAX_VALUE;
        return (short) ((r102 << 8) + (r103 << 0));
    }

    public static short getShort2(byte[] r100, int r101) {
        int r102 = r100[r101 + 0] & UByte.MAX_VALUE;
        int r103 = r100[r101 + 1] & UByte.MAX_VALUE;
        return (short) ((r102 << 8) + (r103 << 0));
    }

    public static int getUShort(byte[] r100, int r101) {
        int r102 = r100[r101 + 1] & UByte.MAX_VALUE;
        int r103 = r100[r101 + 0] & UByte.MAX_VALUE;
        return (r102 << 8) + (r103 << 0);
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
