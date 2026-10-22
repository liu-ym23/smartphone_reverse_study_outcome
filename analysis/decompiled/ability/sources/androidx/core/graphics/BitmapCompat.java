package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.ReplaceWith;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes2.dex */
public final class BitmapCompat {

    @RequiresApi(27)
    public static class Api27Impl {
        private Api27Impl() {
        }

        public static Bitmap copyBitmapIfHardware(Bitmap bitmap) {
            if (bitmap.getConfig() != Bitmap.Config.HARDWARE) {
                return bitmap;
            }
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            return bitmap.copy(Api31Impl.getHardwareBitmapConfig(bitmap), true);
        }

        public static Bitmap createBitmapWithSourceColorspace(int i, int i6, Bitmap bitmap, boolean z10) {
            Bitmap.Config config = bitmap.getConfig();
            ColorSpace colorSpace = bitmap.getColorSpace();
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (z10 && !bitmap.getColorSpace().equals(colorSpace2)) {
                config = Bitmap.Config.RGBA_F16;
                colorSpace = colorSpace2;
            } else if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                config = Api31Impl.getHardwareBitmapConfig(bitmap);
            }
            return Bitmap.createBitmap(i, i6, config, bitmap.hasAlpha(), colorSpace);
        }

        public static boolean isAlreadyF16AndLinear(Bitmap bitmap) {
            return bitmap.getConfig() == Bitmap.Config.RGBA_F16 && bitmap.getColorSpace().equals(ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB));
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        public static Bitmap.Config getHardwareBitmapConfig(Bitmap bitmap) {
            return bitmap.getHardwareBuffer().getFormat() == 22 ? Bitmap.Config.RGBA_F16 : Bitmap.Config.ARGB_8888;
        }
    }

    private BitmapCompat() {
    }

    public static Bitmap createScaledBitmap(Bitmap bitmap, int i, int i6, Rect rect, boolean z10) {
        int i10;
        double dFloor;
        Bitmap bitmapCreateBitmapWithSourceColorspace;
        int i11;
        int i12;
        if (i <= 0 || i6 <= 0) {
            throw new IllegalArgumentException("dstW and dstH must be > 0!");
        }
        if (rect != null && (rect.isEmpty() || rect.left < 0 || rect.right > bitmap.getWidth() || rect.top < 0 || rect.bottom > bitmap.getHeight())) {
            throw new IllegalArgumentException("srcRect must be contained by srcBm!");
        }
        Bitmap bitmapCopyBitmapIfHardware = Api27Impl.copyBitmapIfHardware(bitmap);
        int iWidth = rect != null ? rect.width() : bitmap.getWidth();
        int iHeight = rect != null ? rect.height() : bitmap.getHeight();
        float f = i / iWidth;
        float f7 = i6 / iHeight;
        int i13 = rect != null ? rect.left : 0;
        int i14 = rect != null ? rect.top : 0;
        if (i13 == 0 && i14 == 0 && i == bitmap.getWidth() && i6 == bitmap.getHeight()) {
            return (bitmap.isMutable() && bitmap == bitmapCopyBitmapIfHardware) ? bitmap.copy(bitmap.getConfig(), true) : bitmapCopyBitmapIfHardware;
        }
        Paint paint = new Paint(1);
        paint.setFilterBitmap(true);
        Api29Impl.setPaintBlendMode(paint);
        if (iWidth == i && iHeight == i6) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i6, bitmapCopyBitmapIfHardware.getConfig());
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCopyBitmapIfHardware, -i13, -i14, paint);
            return bitmapCreateBitmap;
        }
        double dLog = Math.log(2.0d);
        if (f > 1.0f) {
            i10 = i13;
            dFloor = Math.ceil(Math.log(f) / dLog);
        } else {
            i10 = i13;
            dFloor = Math.floor(Math.log(f) / dLog);
        }
        int i15 = (int) dFloor;
        int iCeil = (int) (f7 > 1.0f ? Math.ceil(Math.log(f7) / dLog) : Math.floor(Math.log(f7) / dLog));
        if (!z10 || Api27Impl.isAlreadyF16AndLinear(bitmap)) {
            bitmapCreateBitmapWithSourceColorspace = null;
            i11 = i10;
            i12 = 0;
        } else {
            Bitmap bitmapCreateBitmapWithSourceColorspace2 = Api27Impl.createBitmapWithSourceColorspace(i15 > 0 ? sizeAtStep(iWidth, i, 1, i15) : iWidth, iCeil > 0 ? sizeAtStep(iHeight, i6, 1, iCeil) : iHeight, bitmap, true);
            new Canvas(bitmapCreateBitmapWithSourceColorspace2).drawBitmap(bitmapCopyBitmapIfHardware, -i10, -i14, paint);
            bitmapCreateBitmapWithSourceColorspace = bitmapCopyBitmapIfHardware;
            bitmapCopyBitmapIfHardware = bitmapCreateBitmapWithSourceColorspace2;
            i12 = 1;
            i14 = 0;
            i11 = 0;
        }
        Rect rect2 = new Rect(i11, i14, iWidth, iHeight);
        Rect rect3 = new Rect();
        int i16 = i15;
        int i17 = iCeil;
        while (true) {
            if (i16 == 0 && i17 == 0) {
                break;
            }
            if (i16 < 0) {
                i16++;
            } else if (i16 > 0) {
                i16--;
            }
            if (i17 < 0) {
                i17++;
            } else if (i17 > 0) {
                i17--;
            }
            int i18 = i16;
            int i19 = i12;
            rect3.set(0, 0, sizeAtStep(iWidth, i, i16, i15), sizeAtStep(iHeight, i6, i17, iCeil));
            boolean z11 = i18 == 0 && i17 == 0;
            boolean z12 = bitmapCreateBitmapWithSourceColorspace != null && bitmapCreateBitmapWithSourceColorspace.getWidth() == i && bitmapCreateBitmapWithSourceColorspace.getHeight() == i6;
            if (bitmapCreateBitmapWithSourceColorspace == null || bitmapCreateBitmapWithSourceColorspace == bitmap || ((z10 && !Api27Impl.isAlreadyF16AndLinear(bitmapCreateBitmapWithSourceColorspace)) || (z11 && (!z12 || i19 != 0)))) {
                if (bitmapCreateBitmapWithSourceColorspace != bitmap && bitmapCreateBitmapWithSourceColorspace != null) {
                    bitmapCreateBitmapWithSourceColorspace.recycle();
                }
                bitmapCreateBitmapWithSourceColorspace = Api27Impl.createBitmapWithSourceColorspace(sizeAtStep(iWidth, i, i18 > 0 ? i19 : i18, i15), sizeAtStep(iHeight, i6, i17 > 0 ? i19 : i17, iCeil), bitmap, z10 && !z11);
            }
            new Canvas(bitmapCreateBitmapWithSourceColorspace).drawBitmap(bitmapCopyBitmapIfHardware, rect2, rect3, paint);
            rect2.set(rect3);
            Bitmap bitmap2 = bitmapCreateBitmapWithSourceColorspace;
            bitmapCreateBitmapWithSourceColorspace = bitmapCopyBitmapIfHardware;
            bitmapCopyBitmapIfHardware = bitmap2;
            i16 = i18;
            i12 = i19;
        }
        if (bitmapCreateBitmapWithSourceColorspace != bitmap && bitmapCreateBitmapWithSourceColorspace != null) {
            bitmapCreateBitmapWithSourceColorspace.recycle();
        }
        return bitmapCopyBitmapIfHardware;
    }

    @ReplaceWith(expression = "bitmap.getAllocationByteCount()")
    @Deprecated
    public static int getAllocationByteCount(Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    @ReplaceWith(expression = "bitmap.hasMipMap()")
    @Deprecated
    public static boolean hasMipMap(Bitmap bitmap) {
        return bitmap.hasMipMap();
    }

    @ReplaceWith(expression = "bitmap.setHasMipMap(hasMipMap)")
    @Deprecated
    public static void setHasMipMap(Bitmap bitmap, boolean z10) {
        bitmap.setHasMipMap(z10);
    }

    @VisibleForTesting
    public static int sizeAtStep(int i, int i6, int i10, int i11) {
        return i10 == 0 ? i6 : i10 > 0 ? i * (1 << (i11 - i10)) : i6 << ((-i10) - 1);
    }
}
