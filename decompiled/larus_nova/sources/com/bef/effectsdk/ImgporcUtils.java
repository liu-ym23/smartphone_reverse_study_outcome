package com.bef.effectsdk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ImgporcUtils {

    /* JADX INFO: loaded from: classes39.dex */
    public static class InterpolationFlags {
        public static final int INTER_LINEAR = 1;
        public static final int INTER_NEAREST = 0;
        public static final int WARP_INVERSE_MAP = 16;

        public InterpolationFlags() {
        }
    }

    public ImgporcUtils() {
    }

    private static native float nativeCalculateAspectRatio(PointF[] r100, int r101, int r102);

    private static native Bitmap nativeCorrectPerspective(Bitmap r100, PointF[] r101, int r102, int r103, int r104);

    public static float calculateAspectRatio(PointF[] r100, int r101, int r102) {
        return nativeCalculateAspectRatio(r100, r101, r102);
    }

    private static int calculateInSampleSize(BitmapFactory.Options r100, int r101, int r102) {
        int r103 = r100.outHeight;
        int r104 = r100.outWidth;
        int r105 = 1;
        if (r103 > r102) goto L5;
        if (r104 > r101) goto L5;
    L11:
        return r105;
    L5:
        int r106 = r103 / 2;
        int r107 = r104 / 2;
    L7:
        if ((r106 / r105) < r102) goto L11;
        if ((r107 / r105) < r101) goto L11;
        r105 = r105 * 2;
        goto L7
    }

    public static byte[] compressImage(Bitmap r100, int r101, int r102) {
        if (r101 != 1) goto L5;
        Bitmap.CompressFormat r103 = Bitmap.CompressFormat.PNG;
    L6:
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();
        r100.compress(r103, r102, r104);
        return r104.toByteArray();
    L5:
        r103 = Bitmap.CompressFormat.JPEG;
        goto L6
    }

    public static Bitmap decodeImage(byte[] r100, int r101, int r102) {
        if (r101 <= 0) goto L9;
        if (r102 <= 0) goto L9;
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        r103.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(r100, 0, r100.length, r103);
        int r104 = calculateInSampleSize(r103, r101, r102);
        r103.inJustDecodeBounds = false;
        r103.inSampleSize = r104;
        return BitmapFactory.decodeByteArray(r100, 0, r100.length, r103);
    L9:
        return BitmapFactory.decodeByteArray(r100, 0, r100.length);
    }

    public static Bitmap correctPerspective(Bitmap r100, PointF[] r101, int r102, int r103) {
        return nativeCorrectPerspective(r100, r101, r102, r103, 1);
    }

    public static Bitmap correctPerspective(Bitmap r100, PointF[] r101, int r102, int r103, int r104) {
        return nativeCorrectPerspective(r100, r101, r102, r103, r104);
    }
}
