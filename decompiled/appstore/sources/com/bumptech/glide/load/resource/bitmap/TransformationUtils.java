package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public final class TransformationUtils {
    private static final Lock BITMAP_DRAWABLE_LOCK = null;
    private static final Paint CIRCLE_CROP_BITMAP_PAINT = null;
    private static final int CIRCLE_CROP_PAINT_FLAGS = 7;
    private static final Paint CIRCLE_CROP_SHAPE_PAINT = null;
    private static final Paint DEFAULT_PAINT = null;
    private static final Set<String> MODELS_REQUIRING_BITMAP_LOCK = null;
    public static final int PAINT_FLAGS = 6;
    private static final String TAG = "TransformationUtils";

    public static final class NoLock implements Lock {
        public NoLock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long r10, @NonNull TimeUnit r11) throws InterruptedException {
            return true;
        }
    }

    static {
        DEFAULT_PAINT = new Paint(6);
        CIRCLE_CROP_SHAPE_PAINT = new Paint(7);
        HashSet r10 = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        MODELS_REQUIRING_BITMAP_LOCK = r10;
        if (r10.contains(Build.MODEL) == false) goto L5;
        Lock r11 = new ReentrantLock();
    L6:
        BITMAP_DRAWABLE_LOCK = r11;
        Paint r12 = new Paint(7);
        CIRCLE_CROP_BITMAP_PAINT = r12;
        r12.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        return;
    L5:
        r11 = new NoLock();
        goto L6
    }

    private TransformationUtils() {
    }

    private static void applyMatrix(@NonNull Bitmap r10, @NonNull Bitmap r11, Matrix r12) {
        Lock r13 = BITMAP_DRAWABLE_LOCK;
        r13.lock();
        Canvas r14 = new Canvas(r11);     // Catch: Throwable -> L6
        r14.drawBitmap(r10, r12, DEFAULT_PAINT);     // Catch: Throwable -> L6
        clear(r14);     // Catch: Throwable -> L6
        r13.unlock();
        return;
    L6:
        th = move-exception;
        BITMAP_DRAWABLE_LOCK.unlock();
        throw th;
    }

    public static Bitmap centerCrop(@NonNull BitmapPool r10, @NonNull Bitmap r11, int r12, int r13) {
        if (r11.getWidth() == r12) goto L5;
    L7:
        Matrix r14 = new Matrix();
        float r15 = 0.0f;
        if ((r11.getWidth() * r13) <= (r11.getHeight() * r12)) goto L10;
        float r16 = r13 / r11.getHeight();
        r15 = (r12 - (r11.getWidth() * r16)) * 0.5f;
        float r17 = 0.0f;
    L11:
        r14.setScale(r16, r16);
        r14.postTranslate((int) (r15 + 0.5f), (int) (r17 + 0.5f));
        Bitmap r18 = r10.get(r12, r13, getNonNullConfig(r11));
        setAlpha(r11, r18);
        applyMatrix(r11, r18, r14);
        return r18;
    L10:
        r16 = r12 / r11.getWidth();
        r17 = (r13 - (r11.getHeight() * r16)) * 0.5f;
        goto L11
    L5:
        if (r11.getHeight() != r13) goto L7;
        return r11;
    }

    public static Bitmap centerInside(@NonNull BitmapPool r10, @NonNull Bitmap r11, int r12, int r13) {
        if (r11.getWidth() > r12) goto L11;
        if (r11.getHeight() > r13) goto L11;
        if (Log.isLoggable(TAG, 2) == false) goto L9;
        Log.v(TAG, "requested target size larger or equal to input, returning input");
    L9:
        return r11;
    L11:
        if (Log.isLoggable(TAG, 2) == false) goto L14;
        Log.v(TAG, "requested target size too big for input, fit centering instead");
    L14:
        return fitCenter(r10, r11, r12, r13);
    }

    public static Bitmap circleCrop(@NonNull BitmapPool r10, @NonNull Bitmap r11, int r12, int r13) {
        int r14 = Math.min(r12, r13);
        float r15 = r14;
        float r16 = r15 / 2.0f;
        float r17 = r11.getWidth();
        float r18 = r11.getHeight();
        float r19 = Math.max(r15 / r17, r15 / r18);
        float r20 = r17 * r19;
        float r21 = r19 * r18;
        float r22 = (r15 - r20) / 2.0f;
        float r23 = (r15 - r21) / 2.0f;
        RectF r24 = new RectF(r22, r23, r20 + r22, r21 + r23);
        Bitmap r25 = getAlphaSafeBitmap(r10, r11);
        Bitmap r26 = r10.get(r14, r14, getAlphaSafeConfig(r11));
        r26.setHasAlpha(true);
        Lock r27 = BITMAP_DRAWABLE_LOCK;
        r27.lock();
        Canvas r28 = new Canvas(r26);     // Catch: Throwable -> L8
        r28.drawCircle(r16, r16, r16, CIRCLE_CROP_SHAPE_PAINT);     // Catch: Throwable -> L8
        r28.drawBitmap(r25, null, r24, CIRCLE_CROP_BITMAP_PAINT);     // Catch: Throwable -> L8
        clear(r28);     // Catch: Throwable -> L8
        r27.unlock();
        if (r25.equals(r11) == true) goto L7;
        r10.put(r25);
    L7:
        return r26;
    L8:
        th = move-exception;
        BITMAP_DRAWABLE_LOCK.unlock();
        throw th;
    }

    private static void clear(Canvas r10) {
        r10.setBitmap(null);
    }

    public static Bitmap fitCenter(@NonNull BitmapPool r10, @NonNull Bitmap r11, int r12, int r13) {
        if (r11.getWidth() == r12) goto L5;
    L10:
        float r14 = Math.min(r12 / r11.getWidth(), r13 / r11.getHeight());
        int r15 = Math.round(r11.getWidth() * r14);
        int r16 = Math.round(r11.getHeight() * r14);
        if (r11.getWidth() == r15) goto L13;
    L18:
        Bitmap r17 = r10.get((int) (r11.getWidth() * r14), (int) (r11.getHeight() * r14), getNonNullConfig(r11));
        setAlpha(r11, r17);
        if (Log.isLoggable(TAG, 2) == false) goto L21;
        Log.v(TAG, "request: " + r12 + FixCard.FixStyle.KEY_X + r13);
        Log.v(TAG, "toFit:   " + r11.getWidth() + FixCard.FixStyle.KEY_X + r11.getHeight());
        Log.v(TAG, "toReuse: " + r17.getWidth() + FixCard.FixStyle.KEY_X + r17.getHeight());
        StringBuilder r18 = new StringBuilder();
        r18.append("minPct:   ");
        r18.append(r14);
        Log.v(TAG, r18.toString());
    L21:
        Matrix r19 = new Matrix();
        r19.setScale(r14, r14);
        applyMatrix(r11, r17, r19);
        return r17;
    L13:
        if (r11.getHeight() != r16) goto L18;
        if (Log.isLoggable(TAG, 2) == false) goto L17;
        Log.v(TAG, "adjusted target size matches input, returning input");
    L17:
        return r11;
    L5:
        if (r11.getHeight() != r13) goto L10;
        if (Log.isLoggable(TAG, 2) == false) goto L9;
        Log.v(TAG, "requested target size matches input, returning input");
    L9:
        return r11;
    }

    private static Bitmap getAlphaSafeBitmap(@NonNull BitmapPool r10, @NonNull Bitmap r11) {
        Bitmap.Config r12 = getAlphaSafeConfig(r11);
        if (r12.equals(r11.getConfig()) == false) goto L5;
        return r11;
    L5:
        Bitmap r13 = r10.get(r11.getWidth(), r11.getHeight(), r12);
        new Canvas(r13).drawBitmap(r11, 0.0f, 0.0f, null);
        return r13;
    }

    @NonNull
    private static Bitmap.Config getAlphaSafeConfig(@NonNull Bitmap r10) {
        Bitmap.Config r11 = Bitmap.Config.RGBA_F16;
        if (r11.equals(r10.getConfig()) == false) goto L6;
        return r11;
    L6:
        return Bitmap.Config.ARGB_8888;
    }

    public static Lock getBitmapDrawableLock() {
        return BITMAP_DRAWABLE_LOCK;
    }

    public static int getExifOrientationDegrees(int r10) {
        switch(r10) {
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L4;
            case 8: goto L4;
            default: goto L3;
        };
    L3:
        return 0;
    L4:
        return 270;
    L5:
        return 90;
    L6:
        return AnimationConstants.DURATION_180;
    }

    @NonNull
    private static Bitmap.Config getNonNullConfig(@NonNull Bitmap r10) {
        if (r10.getConfig() == null) goto L6;
        return r10.getConfig();
    L6:
        return Bitmap.Config.ARGB_8888;
    }

    @VisibleForTesting
    public static void initializeMatrixForRotation(int r10, Matrix r11) {
        switch(r10) {
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L19;
        };
    L5:
        r11.setRotate(-90.0f);
        return;
    L6:
        r11.setRotate(-90.0f);
        r11.postScale(-1.0f, 1.0f);
        return;
    L7:
        r11.setRotate(90.0f);
        return;
    L8:
        r11.setRotate(90.0f);
        r11.postScale(-1.0f, 1.0f);
        return;
    L9:
        r11.setRotate(180.0f);
        r11.postScale(-1.0f, 1.0f);
        return;
    L10:
        r11.setRotate(180.0f);
        return;
    L11:
        r11.setScale(-1.0f, 1.0f);
        return;
    }

    public static boolean isExifOrientationRequired(int r10) {
        switch(r10) {
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    public static Bitmap rotateImage(@NonNull Bitmap r10, int r11) {
        if (r11 == 0) goto L12;
        Matrix r12 = new Matrix();     // Catch: Exception -> L5
        r12.setRotate(r11);     // Catch: Exception -> L5
        return Bitmap.createBitmap(r10, 0, 0, r10.getWidth(), r10.getHeight(), r12, true);
    L5:
        e = move-exception;
        if (Log.isLoggable(TAG, 6) == false) goto L13;
        Log.e(TAG, "Exception when trying to orient image", e);
        return r10;
    L13:
        return r10;
    L12:
        return r10;
    }

    public static Bitmap rotateImageExif(@NonNull BitmapPool r10, @NonNull Bitmap r11, int r12) {
        if (isExifOrientationRequired(r12) == true) goto L5;
        return r11;
    L5:
        Matrix r13 = new Matrix();
        initializeMatrixForRotation(r12, r13);
        RectF r14 = new RectF(0.0f, 0.0f, r11.getWidth(), r11.getHeight());
        r13.mapRect(r14);
        Bitmap r15 = r10.get(Math.round(r14.width()), Math.round(r14.height()), getNonNullConfig(r11));
        r13.postTranslate(-r14.left, -r14.top);
        r15.setHasAlpha(r11.hasAlpha());
        applyMatrix(r11, r15, r13);
        return r15;
    }

    @Deprecated
    public static Bitmap roundedCorners(@NonNull BitmapPool r10, @NonNull Bitmap r11, int r12, int r13, int r14) {
        return roundedCorners(r10, r11, r14);
    }

    public static void setAlpha(Bitmap r10, Bitmap r11) {
        r11.setHasAlpha(r10.hasAlpha());
    }

    public static Bitmap roundedCorners(@NonNull BitmapPool r10, @NonNull Bitmap r11, int r12) {
        if (r12 <= 0) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13, "roundingRadius must be greater than 0.");
        Bitmap.Config r14 = getAlphaSafeConfig(r11);
        Bitmap r15 = getAlphaSafeBitmap(r10, r11);
        Bitmap r16 = r10.get(r15.getWidth(), r15.getHeight(), r14);
        r16.setHasAlpha(true);
        Shader.TileMode r17 = Shader.TileMode.CLAMP;
        BitmapShader r18 = new BitmapShader(r15, r17, r17);
        Paint r19 = new Paint();
        r19.setAntiAlias(true);
        r19.setShader(r18);
        RectF r20 = new RectF(0.0f, 0.0f, r16.getWidth(), r16.getHeight());
        Lock r21 = BITMAP_DRAWABLE_LOCK;
        r21.lock();
        Canvas r22 = new Canvas(r16);     // Catch: Throwable -> L12
        r22.drawColor(0, PorterDuff.Mode.CLEAR);     // Catch: Throwable -> L12
        float r110 = r12;
        r22.drawRoundRect(r20, r110, r110, r19);     // Catch: Throwable -> L12
        clear(r22);     // Catch: Throwable -> L12
        r21.unlock();
        if (r15.equals(r11) == true) goto L11;
        r10.put(r15);
    L11:
        return r16;
    L12:
        th = move-exception;
        BITMAP_DRAWABLE_LOCK.unlock();
        throw th;
    L5:
        r13 = false;
        goto L6
    }
}
