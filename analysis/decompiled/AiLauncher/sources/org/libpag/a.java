package org.libpag;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.util.Pair;

/* loaded from: classes5.dex */
abstract class a {
    public static Pair a(int i10, int i11, boolean z10) {
        Bitmap bitmapWrapHardwareBuffer;
        if (i10 == 0 || i11 == 0) {
            return Pair.create(null, null);
        }
        HardwareBuffer hardwareBufferA = a(i10, i11);
        if (hardwareBufferA != null) {
            try {
                bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBufferA, ColorSpace.get(ColorSpace.Named.SRGB));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else {
            bitmapWrapHardwareBuffer = null;
        }
        return bitmapWrapHardwareBuffer != null ? Pair.create(bitmapWrapHardwareBuffer, hardwareBufferA) : Pair.create(Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888), null);
    }

    private static HardwareBuffer a(int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            return null;
        }
        try {
            return HardwareBuffer.create(i10, i11, 1, 1, 819L);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
