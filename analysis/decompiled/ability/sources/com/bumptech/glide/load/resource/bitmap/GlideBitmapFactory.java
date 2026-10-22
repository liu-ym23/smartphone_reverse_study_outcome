package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Gainmap;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Preconditions;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
final class GlideBitmapFactory {
    private static final String TAG = "GlideBitmapFactory";

    @RequiresApi(34)
    public static final class GainmapCopier {
        private static final ColorMatrixColorFilter OPAQUE_FILTER = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 255.0f});

        private GainmapCopier() {
        }

        public static Gainmap convertSingleChannelGainmapToTripleChannelGainmap(Gainmap gainmap) {
            Bitmap gainmapContents = gainmap.getGainmapContents();
            if (gainmapContents.getConfig() != Bitmap.Config.ALPHA_8) {
                return gainmap;
            }
            Gainmap gainmapD = a.d(copyAlpha8ToOpaqueArgb888(gainmapContents));
            float[] ratioMin = gainmap.getRatioMin();
            gainmapD.setRatioMin(ratioMin[0], ratioMin[1], ratioMin[2]);
            float[] ratioMax = gainmap.getRatioMax();
            gainmapD.setRatioMax(ratioMax[0], ratioMax[1], ratioMax[2]);
            float[] gamma = gainmap.getGamma();
            gainmapD.setGamma(gamma[0], gamma[1], gamma[2]);
            float[] epsilonSdr = gainmap.getEpsilonSdr();
            gainmapD.setEpsilonSdr(epsilonSdr[0], epsilonSdr[1], epsilonSdr[2]);
            float[] epsilonHdr = gainmap.getEpsilonHdr();
            gainmapD.setEpsilonHdr(epsilonHdr[0], epsilonHdr[1], epsilonHdr[2]);
            gainmapD.setDisplayRatioForFullHdr(gainmap.getDisplayRatioForFullHdr());
            gainmapD.setMinDisplayRatioForHdrTransition(gainmap.getMinDisplayRatioForHdrTransition());
            return gainmapD;
        }

        private static Bitmap copyAlpha8ToOpaqueArgb888(Bitmap bitmap) {
            Preconditions.checkArgument(bitmap.getConfig() == Bitmap.Config.ALPHA_8);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(OPAQUE_FILTER);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            canvas.setBitmap(null);
            return bitmapCreateBitmap;
        }
    }

    public static final class GainmapDecoderWorkaroundStateCalculator {
        private static final GlideSuppliers.GlideSupplier<Boolean> REQUIRES_GAIN_MAP_FIX = GlideSuppliers.memorize(new b(0));
        private static final String TAG = "GainmapWorkaroundCalc";

        private GainmapDecoderWorkaroundStateCalculator() {
        }

        private static boolean calculateNeedsGainmapDecodeWorkaround() {
            if (Build.VERSION.SDK_INT != 34) {
                return false;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
            Bitmap bitmapCopy = bitmapCreateBitmap.copy(Bitmap.Config.HARDWARE, false);
            bitmapCreateBitmap.recycle();
            boolean z10 = bitmapCopy == null;
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "calculateNeedsGainmapDecodeWorkaround=" + z10);
            }
            if (bitmapCopy != null) {
                bitmapCopy.recycle();
            }
            return z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean lambda$static$0() {
            return Boolean.valueOf(calculateNeedsGainmapDecodeWorkaround());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean needsGainmapDecodeWorkaround(BitmapFactory.Options options) {
            if (Build.VERSION.SDK_INT == 34 && options.inPreferredConfig == Bitmap.Config.HARDWARE) {
                return REQUIRES_GAIN_MAP_FIX.get().booleanValue();
            }
            return false;
        }
    }

    private GlideBitmapFactory() {
    }

    @Nullable
    public static Bitmap decodeByteArray(byte[] bArr, BitmapFactory.Options options, ImageReader imageReader) {
        return (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) ? safeAndExpensiveDecodeHardwareBitmapWithGainmap(bArr, options) : BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    @Nullable
    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, BitmapFactory.Options options, ImageReader imageReader) {
        return (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) ? safeAndExpensiveDecodeHardwareBitmapWithGainmap(fileDescriptor, options) : BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    @Nullable
    public static Bitmap decodeStream(InputStream inputStream, BitmapFactory.Options options, ImageReader imageReader) {
        return (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) ? safeAndExpensiveDecodeHardwareBitmapWithGainmap(inputStream, options) : BitmapFactory.decodeStream(inputStream, null, options);
    }

    private static boolean isLikelyToContainGainmap(ImageReader imageReader) {
        try {
            boolean zHasJpegMpf = imageReader.hasJpegMpf();
            if (!Log.isLoggable(TAG, 2)) {
                return zHasJpegMpf;
            }
            Log.v(TAG, "isLikelyToContainGainmap=" + zHasJpegMpf);
            return zHasJpegMpf;
        } catch (IOException e) {
            if (!Log.isLoggable(TAG, 2)) {
                return false;
            }
            Log.v(TAG, "isLikelyToContainGainmap failed", e);
            return false;
        }
    }

    @Nullable
    @RequiresApi(34)
    private static Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(InputStream inputStream, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeStream;
        Bitmap.Config config = options.inPreferredConfig;
        Bitmap.Config config2 = Bitmap.Config.HARDWARE;
        Preconditions.checkArgument(config == config2);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            if (bitmapDecodeStream == null) {
                if (bitmapDecodeStream != null) {
                    bitmapDecodeStream.recycle();
                }
                options.inPreferredConfig = config2;
                return null;
            }
            try {
                Bitmap bitmapSafeDecodeBitmapWithGainmap = safeDecodeBitmapWithGainmap(bitmapDecodeStream);
                bitmapDecodeStream.recycle();
                options.inPreferredConfig = config2;
                return bitmapSafeDecodeBitmapWithGainmap;
            } catch (Throwable th2) {
                th = th2;
                if (bitmapDecodeStream != null) {
                    bitmapDecodeStream.recycle();
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeStream = null;
        }
    }

    @Nullable
    @RequiresApi(34)
    private static Bitmap safeDecodeBitmapWithGainmap(Bitmap bitmap) {
        Gainmap gainmap = bitmap.getGainmap();
        if (gainmap != null && gainmap.getGainmapContents().getConfig() == Bitmap.Config.ALPHA_8) {
            bitmap.setGainmap(GainmapCopier.convertSingleChannelGainmapToTripleChannelGainmap(gainmap));
        }
        return bitmap.copy(Bitmap.Config.HARDWARE, false);
    }

    @Nullable
    @RequiresApi(34)
    private static Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(byte[] bArr, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeByteArray;
        Bitmap.Config config = options.inPreferredConfig;
        Bitmap.Config config2 = Bitmap.Config.HARDWARE;
        Preconditions.checkArgument(config == config2);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray == null) {
                if (bitmapDecodeByteArray != null) {
                    bitmapDecodeByteArray.recycle();
                }
                options.inPreferredConfig = config2;
                return null;
            }
            try {
                Bitmap bitmapSafeDecodeBitmapWithGainmap = safeDecodeBitmapWithGainmap(bitmapDecodeByteArray);
                bitmapDecodeByteArray.recycle();
                options.inPreferredConfig = config2;
                return bitmapSafeDecodeBitmapWithGainmap;
            } catch (Throwable th2) {
                th = th2;
                if (bitmapDecodeByteArray != null) {
                    bitmapDecodeByteArray.recycle();
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeByteArray = null;
        }
    }

    @Nullable
    @RequiresApi(34)
    private static Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(FileDescriptor fileDescriptor, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeFileDescriptor;
        Bitmap.Config config = options.inPreferredConfig;
        Bitmap.Config config2 = Bitmap.Config.HARDWARE;
        Preconditions.checkArgument(config == config2);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            if (bitmapDecodeFileDescriptor == null) {
                if (bitmapDecodeFileDescriptor != null) {
                    bitmapDecodeFileDescriptor.recycle();
                }
                options.inPreferredConfig = config2;
                return null;
            }
            try {
                Bitmap bitmapSafeDecodeBitmapWithGainmap = safeDecodeBitmapWithGainmap(bitmapDecodeFileDescriptor);
                bitmapDecodeFileDescriptor.recycle();
                options.inPreferredConfig = config2;
                return bitmapSafeDecodeBitmapWithGainmap;
            } catch (Throwable th2) {
                th = th2;
                if (bitmapDecodeFileDescriptor != null) {
                    bitmapDecodeFileDescriptor.recycle();
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeFileDescriptor = null;
        }
    }
}
