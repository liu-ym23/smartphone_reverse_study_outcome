package com.zyql.ai.crop.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.util.Log;
import android.view.WindowManager;
import com.zyql.ai.crop.callback.BitmapLoadCallback;
import com.zyql.ai.crop.task.BitmapLoadTask;
import com.zyql.ai.selector.PictureContentResolver;
import com.zyql.ai.selector.widget.longimage.SubsamplingScaleImageView;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class BitmapLoadUtils {
    private static final String TAG = "BitmapLoadUtils";

    public static int calculateInSampleSize(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        int i14 = 1;
        if (i12 <= i11 && i13 <= i10) {
            return 1;
        }
        while (true) {
            if (i12 / i14 <= i11 && i13 / i14 <= i10) {
                return i14;
            }
            i14 *= 2;
        }
    }

    public static int calculateMaxBitmapSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int iSqrt = (int) Math.sqrt(Math.pow(point.x, 2.0d) + Math.pow(point.y, 2.0d));
        Canvas canvas = new Canvas();
        int iMin = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
        if (iMin > 0) {
            iSqrt = Math.min(iSqrt, iMin);
        }
        int maxTextureSize = EglUtils.getMaxTextureSize();
        if (maxTextureSize > 0) {
            iSqrt = Math.min(iSqrt, maxTextureSize);
        }
        Log.d(TAG, "maxBitmapSize: " + iSqrt);
        return iSqrt;
    }

    public static void close(Closeable closeable) throws IOException {
        if (closeable instanceof Closeable) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void decodeBitmapInBackground(Context context, Uri uri, Uri uri2, int i10, int i11, BitmapLoadCallback bitmapLoadCallback) {
        new BitmapLoadTask(context, uri, uri2, i10, i11, bitmapLoadCallback).executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]);
    }

    public static int exifToDegrees(int i10) {
        switch (i10) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return SubsamplingScaleImageView.ORIENTATION_270;
            default:
                return 0;
        }
    }

    public static int exifToTranslation(int i10) {
        return (i10 == 2 || i10 == 7 || i10 == 4 || i10 == 5) ? -1 : 1;
    }

    public static int getExifOrientation(Context context, Uri uri) {
        int orientation = 0;
        try {
            InputStream contentResolverOpenInputStream = PictureContentResolver.getContentResolverOpenInputStream(context, uri);
            if (contentResolverOpenInputStream == null) {
                return 0;
            }
            orientation = new ImageHeaderParser(contentResolverOpenInputStream).getOrientation();
            close(contentResolverOpenInputStream);
            return orientation;
        } catch (IOException e10) {
            Log.e(TAG, "getExifOrientation: " + uri.toString(), e10);
            return orientation;
        }
    }

    public static Bitmap transformBitmap(Bitmap bitmap, Matrix matrix) {
        Bitmap bitmap2;
        try {
            bitmap2 = bitmap;
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                return !bitmap2.sameAs(bitmapCreateBitmap) ? bitmapCreateBitmap : bitmap2;
            } catch (OutOfMemoryError e10) {
                e = e10;
                Log.e(TAG, "transformBitmap: ", e);
                return bitmap2;
            }
        } catch (OutOfMemoryError e11) {
            e = e11;
            bitmap2 = bitmap;
        }
    }
}
