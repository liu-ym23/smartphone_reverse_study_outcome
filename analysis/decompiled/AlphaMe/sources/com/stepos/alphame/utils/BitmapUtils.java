package com.stepos.alphame.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.alibaba.fastjson.asm.Opcodes;
import com.stepos.alphame.utils.pool.PoolManager;

/* loaded from: classes.dex */
public class BitmapUtils {
    public static Bitmap getBitmap8888(Bitmap bitmap, int i4) {
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap.Config config = bitmap.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        if (config == config2 && i4 == 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i4 % Opcodes.GETFIELD != 0) {
            width = bitmap.getHeight();
            height = bitmap.getWidth();
        }
        Bitmap bitmapAcquireBitmap = PoolManager.acquireBitmap(width, height, config2);
        Canvas canvas = new Canvas(bitmapAcquireBitmap);
        Matrix matrix = new Matrix();
        matrix.postTranslate((-bitmap.getWidth()) / 2.0f, (-bitmap.getHeight()) / 2.0f);
        matrix.postRotate(i4);
        matrix.postTranslate(width / 2.0f, height / 2.0f);
        canvas.drawBitmap(bitmap, matrix, null);
        PoolManager.releaseBitmap(bitmap);
        return bitmapAcquireBitmap;
    }

    public static int getOrientation(ExifInterface exifInterface) {
        int attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 3) {
            return Opcodes.GETFIELD;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }
}
