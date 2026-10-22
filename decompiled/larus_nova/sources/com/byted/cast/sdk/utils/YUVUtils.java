package com.byted.cast.sdk.utils;

import android.graphics.Bitmap;
import android.media.Image;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes43.dex */
public class YUVUtils {
    public YUVUtils() {
    }

    public static byte[] convertToNV21(Image r100) {
        int r101 = r100.getWidth();
        int r102 = r100.getHeight();
        Image.Plane[] r103 = r100.getPlanes();
        ByteBuffer r104 = r103[0].getBuffer();
        int r105 = r103[0].getPixelStride();
        Bitmap r106 = Bitmap.createBitmap((int) (r101 + ((r103[0].getRowStride() - (r105 * r101)) / r105)), r102, Bitmap.Config.ARGB_8888);
        r106.copyPixelsFromBuffer(r104);
        byte[] r107 = getNV21(r101, r102, r106);
        r106.recycle();
        r100.close();
        return r107;
    }

    public static byte[] getNV21(int r110, int r111, Bitmap r112) {
        int r100 = r110 * r111;
        int[] r101 = new int[r100];
        r112.getPixels(r101, 0, r110, 0, 0, r110, r111);
        byte[] r102 = new byte[r100 + ((((int) Math.ceil(((double) r111) / 2.0d)) * 2) * ((int) Math.ceil(((double) r110) / 2.0d)))];
        encodeYUV420SP(r102, r101, r110, r111);
        r112.recycle();
        return r102;
    }

    public static void encodeYUV420SP(byte[] r110, int[] r111, int r112, int r113) {
        int r100 = r112 * r113;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r101 >= r113) goto L29;
        int r104 = 0;
    L5:
        if (r104 >= r112) goto L28;
        int r105 = r111[r103];
        int r106 = (16711680 & r105) >> 16;
        int r114 = (65280 & r105) >> 8;
        int r115 = 255;
        int r107 = r105 & 255;
        int r116 = (((((r106 * 66) + (r114 * 129)) + (r107 * 25)) + 128) >> 8) + 16;
        int r117 = (((((r106 * (-38)) - (r114 * 74)) + (r107 * 112)) + 128) >> 8) + 128;
        int r108 = (((((r106 * 112) - (r114 * 94)) - (r107 * 18)) + 128) >> 8) + 128;
        int r109 = r102 + 1;
        if (r116 >= 0) goto L9;
        r116 = 0;
    L11:
        r110[r102] = (byte) r116;
        if ((r101 % 2) != 0) goto L27;
        if ((r103 % 2) != 0) goto L27;
        int r118 = r100 + 1;
        if (r108 >= 0) goto L18;
        r108 = 0;
    L20:
        r110[r100] = (byte) r108;
        r100 = r118 + 1;
        if (r117 >= 0) goto L23;
        r115 = 0;
    L26:
        r110[r118] = (byte) r115;
        goto L27
    L23:
        if (r117 > 255) goto L26;
        r115 = r117;
        goto L26
    L18:
        if (r108 <= 255) goto L20;
        r108 = 255;
    L27:
        r103 = r103 + 1;
        r104 = r104 + 1;
        r102 = r109;
        goto L5
    L9:
        if (r116 <= 255) goto L11;
        r116 = 255;
        goto L11
    L28:
        r101 = r101 + 1;
        goto L3
    }
}
