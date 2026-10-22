package org.libpag;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class TraceImage {
    public static void Trace(String str, ByteBuffer byteBuffer, int i5, int i6) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(byteBuffer);
        Log.i(str, "Image(width = " + bitmapCreateBitmap.getWidth() + ", height = " + bitmapCreateBitmap.getHeight() + ")");
    }
}
