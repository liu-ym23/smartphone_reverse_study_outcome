package org.libpag;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public class TraceImage {
    public static void Trace(String str, ByteBuffer byteBuffer, int i10, int i11) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(byteBuffer);
        Log.i(str, "Image(width = " + bitmapCreateBitmap.getWidth() + ", height = " + bitmapCreateBitmap.getHeight() + ")");
    }
}
