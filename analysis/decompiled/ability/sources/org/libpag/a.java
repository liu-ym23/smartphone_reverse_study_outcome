package org.libpag;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.util.Pair;

/* loaded from: classes4.dex */
abstract class a {
    public static Pair a(int i, int i6, boolean z10) {
        Bitmap bitmapWrapHardwareBuffer;
        if (i == 0 || i6 == 0) {
            return Pair.create(null, null);
        }
        HardwareBuffer hardwareBufferA = a(i, i6);
        if (hardwareBufferA != null) {
            try {
                bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBufferA, ColorSpace.get(ColorSpace.Named.SRGB));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            bitmapWrapHardwareBuffer = null;
        }
        return bitmapWrapHardwareBuffer != null ? Pair.create(bitmapWrapHardwareBuffer, hardwareBufferA) : Pair.create(Bitmap.createBitmap(i, i6, Bitmap.Config.ARGB_8888), null);
    }

    private static HardwareBuffer a(int i, int i6) {
        if (i <= 0 || i6 <= 0) {
            return null;
        }
        try {
            return HardwareBuffer.create(i, i6, 1, 1, 819L);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
