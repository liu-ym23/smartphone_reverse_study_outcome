package com.byted.cast.proxy.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public class FLVConverter {
    private static final int FLV_HEADER_SIZE = 13;
    private static final int TAG_HEADER_SIZE = 11;
    private static final int VIDEO_TAG_TYPE = 9;

    public FLVConverter() {
    }

    public static byte[] intTo3Bytes(int r100) {
        return new byte[]{(byte) ((r100 >> 16) & 255), (byte) ((r100 >> 8) & 255), (byte) (r100 & 255)};
    }

    public static byte[] intTo4Bytes(int r100) {
        return new byte[]{(byte) ((r100 >> 24) & 255), (byte) ((r100 >> 16) & 255), (byte) ((r100 >> 8) & 255), (byte) (r100 & 255)};
    }

    public static byte[] longTo3Bytes(long r100) {
        return new byte[]{(byte) ((r100 >> 16) & 255), (byte) ((r100 >> 8) & 255), (byte) (r100 & 255)};
    }

    public static boolean isSpsOrPps(byte[] r100) {
        if (r100 != null) goto L5;
    L27:
        return false;
    L5:
        if (r100.length < 5) goto L27;
        if (r100[0] == 0) goto L10;
    L18:
        char r101 = 0;
    L19:
        if (r101 != 0) goto L21;
        return false;
    L21:
        int r102 = (r100[r101] & UByte.MAX_VALUE) & 31;
        if (r102 != 7) goto L25;
        return true;
    L25:
        if (r102 != 8) goto L27;
        return true;
    L10:
        if (r100[1] != 0) goto L18;
        byte r103 = r100[2];
        r101 = 3;
        if (r103 == 0) goto L14;
    L16:
        if (r103 != 1) goto L18;
    L14:
        if (r100[3] != 1) goto L16;
        r101 = 4;
        goto L19
    }

    public static byte[] removeVideoTags(byte[] r100) {
        if (r100 == null) goto L34;
        int r101 = 13;
        if (r100.length <= 13) goto L34;
        int r102 = 0;
        if (r100[0] != 70) goto L34;
        if (r100[1] != 76) goto L34;
        if (r100[2] != 86) goto L34;
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L14:
        if (r104 >= 13) goto L17;
        r103.add(Byte.valueOf(r100[r104]));
        r104 = r104 + 1;
    L17:
        if (r101 >= r100.length) goto L30;
        if ((r101 + 11) > r100.length) goto L30;
        int r105 = r100[r101] & UByte.MAX_VALUE;
        int r106 = (((((r100[r101 + 1] & UByte.MAX_VALUE) << 16) | ((r100[r101 + 2] & UByte.MAX_VALUE) << 8)) | (r100[r101 + 3] & UByte.MAX_VALUE)) + 11) + 4;
        int r107 = r101 + r106;
        if (r107 > r100.length) goto L23;
        if (r105 == 9) goto L29;
        int r108 = 0;
    L27:
        if (r108 >= r106) goto L29;
        r103.add(Byte.valueOf(r100[r101 + r108]));
        r108 = r108 + 1;
    L29:
        r101 = r107;
        goto L17
    L23:
        return r100;
    L30:
        r100 = new byte[r103.size()];
    L32:
        if (r102 >= r103.size()) goto L34;
        r100[r102] = ((Byte) ListProtector.get(r103, r102)).byteValue();
        r102 = r102 + 1;
    L34:
        return r100;
    }

    public static byte[] h264ToFLV(byte[] r100, long r110, long r111, boolean r112, boolean r113) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        int r102 = r100.length + 5;
        r101.write(9);
        r101.write(intTo3Bytes(r102));
        r101.write(longTo3Bytes(r111));
        r101.write(new byte[]{(byte) ((r111 >> 24) & 255)});
        r101.write(new byte[]{0, 0, 0});
        byte[] r103 = new byte[5];
        if (r113 == false) goto L5;
        r103[0] = 23;
    L6:
        if (r112 == false) goto L8;
        r103[1] = 0;
    L9:
        long r114 = r110 - r111;
        if (r114 != 0) goto L12;
        r103[2] = 0;
        r103[3] = 0;
        r103[4] = 0;
    L13:
        r101.write(r103);
        r101.write(r100);
        r101.write(intTo4Bytes(r102 + 11));
        return r101.toByteArray();
    L12:
        r103[2] = (byte) ((r114 >> 16) & 255);
        r103[3] = (byte) ((r114 >> 8) & 255);
        r103[4] = (byte) (r114 & 255);
        goto L13
    L8:
        r103[1] = 1;
        goto L9
    L5:
        r103[0] = 39;
        goto L6
    }
}
