package org.libpag;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class TraceImage {
    public static void Trace(String str, ByteBuffer byteBuffer, int i, int i6) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i6, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(byteBuffer);
        Log.i(str, "Image(width = " + bitmapCreateBitmap.getWidth() + ", height = " + bitmapCreateBitmap.getHeight() + ")");
    }
}
