package com.stepos.alphame.utils.pool.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes.dex */
public final class Util {

    /* renamed from: com.stepos.alphame.utils.pool.bitmap.Util$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private Util() {
    }

    public static boolean bothNullOrEqual(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i4, int i5) {
        int i6 = options.outHeight;
        int i7 = options.outWidth;
        int i8 = 1;
        if (i6 > i5 || i7 > i4) {
            int i9 = i6 / 2;
            int i10 = i7 / 2;
            while (i9 / i8 > i5 && i10 / i8 > i4) {
                i8 *= 2;
            }
        }
        return i8;
    }

    public static boolean canUseForInBitmap(Bitmap bitmap, BitmapFactory.Options options) {
        int i4 = options.outWidth;
        int i5 = options.inSampleSize;
        int bytesPerPixel = (options.outHeight / i5) * (i4 / i5) * getBytesPerPixel(bitmap.getConfig());
        try {
            return bytesPerPixel <= bitmap.getAllocationByteCount();
        } catch (NullPointerException unused) {
            return bytesPerPixel <= bitmap.getRowBytes() * bitmap.getHeight();
        }
    }

    public static <T> Queue<T> createQueue(int i4) {
        return new ArrayDeque(i4);
    }

    public static int getBitmapByteSize(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        Log.e("Pool.Util", "Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
        return 0;
    }

    private static int getBytesPerPixel(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i4 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (i4 != 1) {
            return (i4 == 2 || i4 == 3) ? 2 : 4;
        }
        return 1;
    }

    public static int getBitmapByteSize(int i4, int i5, Bitmap.Config config) {
        return i4 * i5 * getBytesPerPixel(config);
    }
}
