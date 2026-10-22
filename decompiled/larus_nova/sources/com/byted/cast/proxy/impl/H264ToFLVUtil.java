package com.byted.cast.proxy.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public class H264ToFLVUtil {
    public H264ToFLVUtil() {
    }

    private static int uByteToInt(byte r100) {
        return r100 & UByte.MAX_VALUE;
    }

    private static byte[] write2BytesBE(int r100) {
        return new byte[]{(byte) ((r100 >> 8) & 255), (byte) (r100 & 255)};
    }

    private static byte[] write3BytesBE(int r100) {
        return new byte[]{(byte) ((r100 >> 16) & 255), (byte) ((r100 >> 8) & 255), (byte) (r100 & 255)};
    }

    private static byte[] write4BytesBE(int r100) {
        return new byte[]{(byte) ((r100 >> 24) & 255), (byte) ((r100 >> 16) & 255), (byte) ((r100 >> 8) & 255), (byte) (r100 & 255)};
    }

    private static byte[] naluToFlvFormat(byte[] r100) {
        if (r100 == null) goto L22;
        if (r100.length == 0) goto L22;
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L20;
        int r104 = findStartCode(r100, r103);
        if (r104 == 0) goto L20;
        int r105 = r103 + r104;
        int r106 = r105;
    L11:
        if (r106 >= r102) goto L15;
        if (findStartCode(r100, r106) != 0) goto L15;
        r106 = r106 + 1;
    L15:
        int r107 = r106 - r105;
        if (r107 <= 0) goto L18;
        r101.write(write4BytesBE(r107), 0, 4);
        r101.write(r100, r105, r107);
    L18:
        r103 = r106;
    L20:
        return r101.toByteArray();
    L22:
        throw new IllegalArgumentException("H264 data cannot be empty.");
    }

    private static List<byte[]> splitSpsPps(byte[] r100) {
        ArrayList r101 = new ArrayList(2);
        int r102 = r100.length;
        int r103 = findStartCode(r100, 0);
        if (r103 == 0) goto L20;
        int r104 = r103 + 0;
        int r105 = r104;
    L5:
        if (r105 >= r102) goto L9;
        if (findStartCode(r100, r105) != 0) goto L9;
        r105 = r105 + 1;
    L9:
        int r106 = r105 - r104;
        byte[] r107 = new byte[r106];
        System.arraycopy(r100, r104, r107, 0, r106);
        r101.add(r107);
        if (r105 >= r102) goto L18;
        int r108 = findStartCode(r100, r105);
        if (r108 == 0) goto L16;
        int r109 = r105 + r108;
        int r110 = r102 - r109;
        byte[] r111 = new byte[r110];
        System.arraycopy(r100, r109, r111, 0, r110);
        r101.add(r111);
        return r101;
    L16:
        throw new IllegalArgumentException("PPS data must start with a valid start code.");
    L18:
        throw new IllegalArgumentException("SPS/PPS data does not contain PPS after SPS.");
    L20:
        throw new IllegalArgumentException("SPS/PPS data must start with a valid start code.");
    }

    private static int findStartCode(byte[] r100, int r101) {
        int r102 = r100.length;
        int r103 = r101 + 3;
        if (r103 < r102) goto L5;
    L14:
        int r104 = r101 + 2;
        if (r104 < r102) goto L17;
        return 0;
    L17:
        if (uByteToInt(r100[r101]) == 0) goto L19;
        return 0;
    L19:
        if (uByteToInt(r100[r101 + 1]) == 0) goto L21;
        return 0;
    L21:
        if (uByteToInt(r100[r104]) != 1) goto L28;
        return 3;
    L28:
        return 0;
    L5:
        if (uByteToInt(r100[r101]) != 0) goto L14;
        if (uByteToInt(r100[r101 + 1]) != 0) goto L14;
        if (uByteToInt(r100[r101 + 2]) != 0) goto L14;
        if (uByteToInt(r100[r103]) != 1) goto L14;
        return 4;
    }

    public static byte[] h264ToFLV(byte[] r100, long r110, long r111, boolean r112, boolean r113) {
        if (r100 == null) goto L20;
        if (r100.length == 0) goto L20;
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        int r102 = 2;
        if (r112 == false) goto L12;
        List<byte[]> r103 = splitSpsPps(r100);
        if (r103.size() < 2) goto L11;
        byte[] r104 = (byte[]) ListProtector.get(r103, 0);
        byte[] r105 = (byte[]) ListProtector.get(r103, 1);
        ByteArrayOutputStream r106 = new ByteArrayOutputStream();
        r106.write(1);
        r106.write(r104[1]);
        r106.write(r104[2]);
        r106.write(r104[3]);
        r106.write(255);
        r106.write(225);
        r106.write(write2BytesBE(r104.length), 0, 2);
        r106.write(r104, 0, r104.length);
        r106.write(1);
        r106.write(write2BytesBE(r105.length), 0, 2);
        r106.write(r105, 0, r105.length);
        byte[] r107 = r106.toByteArray();
    L13:
        if (r113 == false) goto L15;
        r102 = 1;
    L15:
        if (r112 == false) goto L17;
        r102 = 1;
    L17:
        r101.write((byte) ((r102 << 4) | 7));
        r101.write(!r112 ? 1 : 0);
        r101.write(write3BytesBE((int) (r110 - r111)), 0, 3);
        r101.write(r107, 0, r107.length);
        byte[] r108 = r101.toByteArray();
        ByteArrayOutputStream r114 = new ByteArrayOutputStream();
        r114.write(9);
        r114.write(write3BytesBE(r108.length), 0, 3);
        int r115 = (int) r111;
        r114.write(write3BytesBE(r115), 0, 3);
        r114.write((byte) ((r115 >> 24) & 255));
        r114.write(new byte[]{0, 0, 0}, 0, 3);
        r114.write(r108, 0, r108.length);
        r114.write(write4BytesBE(r108.length + 11), 0, 4);
        return r114.toByteArray();
    L11:
        throw new IllegalArgumentException("SPS/PPS data is incomplete.");
    L12:
        r107 = naluToFlvFormat(r100);
    L20:
        throw new IllegalArgumentException("h264Data cannot be null or empty.");
    }
}
