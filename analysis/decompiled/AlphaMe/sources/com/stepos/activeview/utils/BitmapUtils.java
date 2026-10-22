package com.stepos.activeview.utils;

import B0.g;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;

/* loaded from: classes.dex */
public class BitmapUtils {
    private static final String LOG_TAG = "BitmapUtils";

    private static int calculateInSampleSize(BitmapFactory.Options options, int i4, int i5) {
        int i6 = options.outHeight;
        int i7 = options.outWidth;
        int i8 = 1;
        if (i6 > i5 || i7 > i4) {
            int i9 = i6 / 2;
            int i10 = i7 / 2;
            while (i9 / i8 >= i5 && i10 / i8 >= i4) {
                i8 *= 2;
            }
        }
        StringBuilder sbU = g.u("Image orig width =", i7, ", reqWidth=", i4, "; height =");
        sbU.append(i6);
        sbU.append(", reqHeight=");
        sbU.append(i5);
        sbU.append("; inSampleSize=");
        sbU.append(i8);
        LogUtil.i(LOG_TAG, sbU.toString());
        return i8;
    }

    public static Bitmap createScaleBitmap(Bitmap bitmap, int i4, int i5) {
        float f4 = i5;
        float f5 = i4;
        float fMin = Math.min(Math.min(bitmap.getWidth(), i4), (f5 / f4) * bitmap.getHeight());
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(fMin), Math.round((f4 / f5) * fMin), true);
        if (bitmap != bitmapCreateScaledBitmap) {
            bitmap.recycle();
        }
        return bitmapCreateScaledBitmap;
    }

    public static Bitmap decodeSampledBitmapFromFile(String str, int i4, int i5) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        if (i4 == -1) {
            i4 = options.outWidth;
        }
        if (i5 == -1) {
            i5 = options.outHeight;
        }
        options.inSampleSize = calculateInSampleSize(options, i4, i5);
        options.inJustDecodeBounds = false;
        return createScaleBitmap(BitmapFactory.decodeFile(str, options), i4, i5);
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources resources, int i4, int i5, int i6) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i4, options);
        options.inSampleSize = calculateInSampleSize(options, i5, i6);
        options.inJustDecodeBounds = false;
        return createScaleBitmap(BitmapFactory.decodeResource(resources, i4, options), i5, i6);
    }

    public static Bitmap decodeSampledBitmapFromStream(InputStream inputStream, int i4, int i5) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        options.inSampleSize = calculateInSampleSize(options, i4, i5);
        options.inJustDecodeBounds = false;
        return createScaleBitmap(BitmapFactory.decodeStream(inputStream, null, options), i4, i5);
    }

    public static int calculateInSampleSize(int i4, int i5, int i6, int i7) {
        int i8 = 1;
        if (i5 > i7 || i4 > i6) {
            int i9 = i5 / 2;
            int i10 = i4 / 2;
            while (i9 / i8 > i7 && i10 / i8 > i6) {
                i8 *= 2;
            }
        }
        StringBuilder sbU = g.u("Image orig width =", i4, ", reqWidth=", i6, "; height =");
        sbU.append(i5);
        sbU.append(", reqHeight=");
        sbU.append(i7);
        sbU.append("; inSampleSize=");
        sbU.append(i8);
        LogUtil.i(LOG_TAG, sbU.toString());
        return i8;
    }
}
