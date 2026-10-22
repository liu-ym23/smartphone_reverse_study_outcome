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
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.Preconditions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes39.dex */
public final class TransformationUtils {
    private static final Lock BITMAP_DRAWABLE_LOCK = null;
    private static final Paint CIRCLE_CROP_BITMAP_PAINT = null;
    private static final int CIRCLE_CROP_PAINT_FLAGS = 7;
    private static final Paint CIRCLE_CROP_SHAPE_PAINT = null;
    private static final Paint DEFAULT_PAINT = null;
    private static final Set<String> MODELS_REQUIRING_BITMAP_LOCK = null;
    public static final int PAINT_FLAGS = 6;
    private static final String TAG = "TransformationUtils";

    public interface DrawRoundedCornerFn {
        void drawRoundedCorners(Canvas r100, Paint r101, RectF r102);
    }

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
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long r100, TimeUnit r101) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }
    }

    public static int getExifOrientationDegrees(int r100) {
        switch(r100) {
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
        return 180;
    }

    public static boolean isExifOrientationRequired(int r100) {
        switch(r100) {
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

    static {
        DEFAULT_PAINT = new Paint(6);
        CIRCLE_CROP_SHAPE_PAINT = new Paint(7);
        HashSet r100 = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        MODELS_REQUIRING_BITMAP_LOCK = r100;
        if (r100.contains(Build.MODEL) == false) goto L5;
        Lock r101 = new ReentrantLock();
    L6:
        BITMAP_DRAWABLE_LOCK = r101;
        Paint r102 = new Paint(7);
        CIRCLE_CROP_BITMAP_PAINT = r102;
        r102.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        return;
    L5:
        r101 = new NoLock();
        goto L6
    }

    private TransformationUtils() {
    }

    public static Lock getBitmapDrawableLock() {
        return BITMAP_DRAWABLE_LOCK;
    }

    private static void clear(Canvas r100) {
        r100.setBitmap(null);
    }

    private static Bitmap.Config getAlphaSafeConfig(Bitmap r100) {
        if (Build.VERSION.SDK_INT < 26) goto L9;
        if (Bitmap.Config.RGBA_F16.equals(r100.getConfig()) == false) goto L9;
        return Bitmap.Config.RGBA_F16;
    L9:
        return Bitmap.Config.ARGB_8888;
    }

    private static Bitmap.Config getNonNullConfig(Bitmap r100) {
        if (r100.getConfig() == null) goto L6;
        return r100.getConfig();
    L6:
        return Bitmap.Config.ARGB_8888;
    }

    private static Bitmap getAlphaSafeBitmap(BitmapPool r100, Bitmap r101) {
        Bitmap.Config r102 = getAlphaSafeConfig(r101);
        if (r102.equals(r101.getConfig()) == false) goto L5;
        return r101;
    L5:
        Bitmap r103 = r100.get(r101.getWidth(), r101.getHeight(), r102);
        new Canvas(r103).drawBitmap(r101, 0.0f, 0.0f, null);
        return r103;
    }

    public static void initializeMatrixForRotation(int r100, Matrix r101) {
        switch(r100) {
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
        r101.setRotate(-90.0f);
        return;
    L6:
        r101.setRotate(-90.0f);
        r101.postScale(-1.0f, 1.0f);
        return;
    L7:
        r101.setRotate(90.0f);
        return;
    L8:
        r101.setRotate(90.0f);
        r101.postScale(-1.0f, 1.0f);
        return;
    L9:
        r101.setRotate(180.0f);
        r101.postScale(-1.0f, 1.0f);
        return;
    L10:
        r101.setRotate(180.0f);
        return;
    L11:
        r101.setScale(-1.0f, 1.0f);
        return;
    }

    public static Bitmap rotateImage(Bitmap r100, int r101) {
        if (r101 == 0) goto L10;
        Matrix r102 = new Matrix();     // Catch: Exception -> L5
        r102.setRotate(r101);     // Catch: Exception -> L5
        return Bitmap.createBitmap(r100, 0, 0, r100.getWidth(), r100.getHeight(), r102, true);
    L5:
        e = move-exception;
        GlideLogUtil.e(TAG, "Exception when trying to orient image", e);
        return r100;
    L10:
        return r100;
    }

    public static void setAlpha(Bitmap r100, Bitmap r101) {
        r101.setHasAlpha(r100.hasAlpha());
    }

    private static void applyMatrix(Bitmap r100, Bitmap r101, Matrix r102) {
        Lock r103 = BITMAP_DRAWABLE_LOCK;
        r103.lock();
        Canvas r104 = new Canvas(r101);     // Catch: Throwable -> L6
        r104.drawBitmap(r100, r102, DEFAULT_PAINT);     // Catch: Throwable -> L6
        clear(r104);     // Catch: Throwable -> L6
        r103.unlock();
        return;
    L6:
        th = move-exception;
        BITMAP_DRAWABLE_LOCK.unlock();
        throw th;
    }

    public static Bitmap rotateImageExif(BitmapPool r100, Bitmap r101, int r102) {
        if (isExifOrientationRequired(r102) == true) goto L5;
        return r101;
    L5:
        Matrix r103 = new Matrix();
        initializeMatrixForRotation(r102, r103);
        RectF r104 = new RectF(0.0f, 0.0f, r101.getWidth(), r101.getHeight());
        r103.mapRect(r104);
        Bitmap r105 = r100.get(Math.round(r104.width()), Math.round(r104.height()), getNonNullConfig(r101));
        r103.postTranslate(-r104.left, -r104.top);
        r105.setHasAlpha(r101.hasAlpha());
        applyMatrix(r101, r105, r103);
        return r105;
    }

    private static Bitmap roundedCorners(BitmapPool r100, Bitmap r101, DrawRoundedCornerFn r110) {
        Bitmap.Config r102 = getAlphaSafeConfig(r101);
        Bitmap r103 = getAlphaSafeBitmap(r100, r101);
        Bitmap r104 = r100.get(r103.getWidth(), r103.getHeight(), r102);
        r104.setHasAlpha(true);
        Shader.TileMode r105 = Shader.TileMode.CLAMP;
        BitmapShader r106 = new BitmapShader(r103, r105, r105);
        Paint r107 = new Paint();
        r107.setAntiAlias(true);
        r107.setShader(r106);
        RectF r108 = new RectF(0.0f, 0.0f, r104.getWidth(), r104.getHeight());
        Lock r109 = BITMAP_DRAWABLE_LOCK;
        r109.lock();
        Canvas r111 = new Canvas(r104);     // Catch: Throwable -> L8
        r111.drawColor(0, PorterDuff.Mode.CLEAR);     // Catch: Throwable -> L8
        r110.drawRoundedCorners(r111, r107, r108);     // Catch: Throwable -> L8
        clear(r111);     // Catch: Throwable -> L8
        r109.unlock();
        if (r103.equals(r101) == true) goto L7;
        r100.put(r103);
    L7:
        return r104;
    L8:
        th = move-exception;
        BITMAP_DRAWABLE_LOCK.unlock();
        throw th;
    }

    public static Bitmap roundedCorners(BitmapPool r100, Bitmap r101, final int r102) {
        if (r102 <= 0) goto L4;
        boolean r103 = true;
    L5:
        Preconditions.checkArgument(r103, "roundingRadius must be greater than 0.");
        return roundedCorners(r100, r101, new AnonymousClass1(r102));
    L4:
        r103 = false;
        goto L5
    }

    public static Bitmap centerCrop(BitmapPool r100, Bitmap r101, int r102, int r103) {
        if (r101.getWidth() == r102) goto L5;
    L7:
        Matrix r104 = new Matrix();
        float r105 = 0.0f;
        if ((r101.getWidth() * r103) <= (r101.getHeight() * r102)) goto L10;
        float r106 = r103 / r101.getHeight();
        r105 = (r102 - (r101.getWidth() * r106)) * 0.5f;
        float r107 = 0.0f;
    L11:
        r104.setScale(r106, r106);
        r104.postTranslate((int) (r105 + 0.5f), (int) (r107 + 0.5f));
        Bitmap r108 = r100.get(r102, r103, getNonNullConfig(r101));
        setAlpha(r101, r108);
        applyMatrix(r101, r108, r104);
        return r108;
    L10:
        r106 = r102 / r101.getWidth();
        r107 = (r103 - (r101.getHeight() * r106)) * 0.5f;
        goto L11
    L5:
        if (r101.getHeight() != r103) goto L7;
        return r101;
    }

    public static Bitmap centerInside(BitmapPool r100, Bitmap r101, int r102, int r103) {
        if (r101.getWidth() <= r102) goto L5;
    L8:
        GlideLogUtil.v(TAG, "requested target size too big for input, fit centering instead");
        return fitCenter(r100, r101, r102, r103);
    L5:
        if (r101.getHeight() > r103) goto L8;
        GlideLogUtil.v(TAG, "requested target size larger or equal to input, returning input");
        return r101;
    }

    public static Bitmap circleCrop(BitmapPool r100, Bitmap r101, int r102, int r103) {
        int r104 = Math.min(r102, r103);
        float r105 = r104;
        float r106 = r105 / 2.0f;
        float r107 = r101.getWidth();
        float r108 = r101.getHeight();
        float r109 = Math.max(r105 / r107, r105 / r108);
        float r110 = r107 * r109;
        float r111 = r109 * r108;
        float r112 = (r105 - r110) / 2.0f;
        float r113 = (r105 - r111) / 2.0f;
        RectF r114 = new RectF(r112, r113, r110 + r112, r111 + r113);
        Bitmap r115 = getAlphaSafeBitmap(r100, r101);
        Bitmap r116 = r100.get(r104, r104, getAlphaSafeConfig(r101));
        r116.setHasAlpha(true);
        Lock r117 = BITMAP_DRAWABLE_LOCK;
        r117.lock();
        Canvas r118 = new Canvas(r116);     // Catch: Throwable -> L8
        r118.drawCircle(r106, r106, r106, CIRCLE_CROP_SHAPE_PAINT);     // Catch: Throwable -> L8
        r118.drawBitmap(r115, null, r114, CIRCLE_CROP_BITMAP_PAINT);     // Catch: Throwable -> L8
        clear(r118);     // Catch: Throwable -> L8
        r117.unlock();
        if (r115.equals(r101) == true) goto L7;
        r100.put(r115);
    L7:
        return r116;
    L8:
        th = move-exception;
        BITMAP_DRAWABLE_LOCK.unlock();
        throw th;
    }

    public static Bitmap fitCenter(BitmapPool r100, Bitmap r101, int r102, int r103) {
        if (r101.getWidth() == r102) goto L5;
    L8:
        float r104 = Math.min(r102 / r101.getWidth(), r103 / r101.getHeight());
        int r105 = Math.round(r101.getWidth() * r104);
        int r106 = Math.round(r101.getHeight() * r104);
        if (r101.getWidth() == r105) goto L11;
    L14:
        Bitmap r107 = r100.get((int) (r101.getWidth() * r104), (int) (r101.getHeight() * r104), getNonNullConfig(r101));
        setAlpha(r101, r107);
        GlideLogUtil.v(TAG, "request: " + r102 + "x" + r103);
        GlideLogUtil.v(TAG, "toFit:   " + r101.getWidth() + "x" + r101.getHeight());
        GlideLogUtil.v(TAG, "toReuse: " + r107.getWidth() + "x" + r107.getHeight());
        StringBuilder r108 = new StringBuilder("minPct:   ");
        r108.append(r104);
        GlideLogUtil.v(TAG, r108.toString());
        Matrix r109 = new Matrix();
        r109.setScale(r104, r104);
        applyMatrix(r101, r107, r109);
        return r107;
    L11:
        if (r101.getHeight() != r106) goto L14;
        GlideLogUtil.v(TAG, "adjusted target size matches input, returning input");
        return r101;
    L5:
        if (r101.getHeight() != r103) goto L8;
        GlideLogUtil.v(TAG, "requested target size matches input, returning input");
        return r101;
    }

    public static Bitmap roundedCorners(BitmapPool r100, Bitmap r101, int r102, int r103, int r104) {
        return roundedCorners(r100, r101, r104);
    }

    public static Bitmap roundedCorners(BitmapPool r100, Bitmap r101, final float r102, final float r103, final float r104, final float r105) {
        return roundedCorners(r100, r101, new AnonymousClass2(r102, r103, r104, r105));
    }
}
