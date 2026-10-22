package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TransformationUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class z {
    private static final String TAG = "TransformationUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Paint f3850a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Paint f3851b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Paint f3852c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f3853d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Lock f3854e = null;

    /* JADX INFO: compiled from: TransformationUtils.java */
    private static final class a implements Lock {
        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long r1, TimeUnit r3) {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }

        a() {
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }
    }

    public static int a(int r0) {
        switch(r0) {
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

    public static boolean b(int r0) {
        switch(r0) {
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
        f3850a = new Paint(6);
        f3851b = new Paint(7);
        HashSet r0 = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        f3853d = r0;
        if (r0.contains(Build.MODEL) == false) goto L5;
        Lock r1 = new ReentrantLock();
    L6:
        f3854e = r1;
        Paint r2 = new Paint(7);
        f3852c = r2;
        r2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        return;
    L5:
        r1 = new a();
        goto L6
    }

    public static Lock a() {
        return f3854e;
    }

    public static Bitmap a(com.bumptech.glide.load.engine.a.e r7, Bitmap r8, int r9, int r10) {
        com.bumptech.glide.load.engine.a.e r11 = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r7, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
        if (r8.getWidth() == r9) goto L5;
    L7:
        Matrix r0 = new Matrix();
        float r3 = 0.0f;
        if ((r8.getWidth() * r10) <= (r8.getHeight() * r9)) goto L10;
        float r1 = r10 / r8.getHeight();
        r3 = (r9 - (r8.getWidth() * r1)) * 0.5f;
        float r2 = 0.0f;
    L11:
        r0.setScale(r1, r1);
        r0.postTranslate((int) (r3 + 0.5f), (int) (r2 + 0.5f));
        Bitmap r12 = r11.a(r9, r10, a(r8));
        a(r8, r12);
        a(r8, r12, r0);
        return r12;
    L10:
        r1 = r9 / r8.getWidth();
        r2 = (r10 - (r8.getHeight() * r1)) * 0.5f;
        goto L11
    L5:
        if (r8.getHeight() != r10) goto L7;
        return r8;
    }

    public static Bitmap b(com.bumptech.glide.load.engine.a.e r6, Bitmap r7, int r8, int r9) {
        com.bumptech.glide.load.engine.a.e r10 = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r6, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
        if (r7.getWidth() == r8) goto L5;
    L10:
        float r0 = Math.min(r8 / r7.getWidth(), r9 / r7.getHeight());
        int r3 = Math.round(r7.getWidth() * r0);
        int r4 = Math.round(r7.getHeight() * r0);
        if (r7.getWidth() == r3) goto L13;
    L18:
        Bitmap r11 = r10.a((int) (r7.getWidth() * r0), (int) (r7.getHeight() * r0), a(r7));
        a(r7, r11);
        if (a(TAG, 2) == false) goto L21;
        a(TAG, "request: " + r8 + "x" + r9);
        a(TAG, "toFit:   " + r7.getWidth() + "x" + r7.getHeight());
        a(TAG, "toReuse: " + r11.getWidth() + "x" + r11.getHeight());
        a(TAG, "minPct:   " + r0);
    L21:
        Matrix r12 = new Matrix();
        r12.setScale(r0, r0);
        a(r7, r11, r12);
        return r11;
    L13:
        if (r7.getHeight() != r4) goto L18;
        if (a(TAG, 2) == false) goto L17;
        a(TAG, "adjusted target size matches input, returning input");
    L17:
        return r7;
    L5:
        if (r7.getHeight() != r9) goto L10;
        if (a(TAG, 2) == false) goto L9;
        a(TAG, "requested target size matches input, returning input");
    L9:
        return r7;
    }

    public static Bitmap c(com.bumptech.glide.load.engine.a.e r3, Bitmap r4, int r5, int r6) {
        com.bumptech.glide.load.engine.a.e r7 = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
        if (r4.getWidth() > r5) goto L11;
        if (r4.getHeight() > r6) goto L11;
        if (a(TAG, 2) == false) goto L9;
        a(TAG, "requested target size larger or equal to input, returning input");
    L9:
        return r4;
    L11:
        if (a(TAG, 2) == false) goto L14;
        a(TAG, "requested target size too big for input, fit centering instead");
    L14:
        return b(r7, r4, r5, r6);
    }

    public static void a(Bitmap r0, Bitmap r1) {
        r1.setHasAlpha(r0.hasAlpha());
    }

    public static Bitmap a(com.bumptech.glide.load.engine.a.e r4, Bitmap r5, int r6) {
        com.bumptech.glide.load.engine.a.e r7 = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
        if (b(r6) == true) goto L5;
        return r5;
    L5:
        Matrix r0 = new Matrix();
        a(r6, r0);
        RectF r8 = new RectF(0.0f, 0.0f, r5.getWidth(), r5.getHeight());
        r0.mapRect(r8);
        Bitmap r9 = r7.a(Math.round(r8.width()), Math.round(r8.height()), a(r5));
        r0.postTranslate(-r8.left, -r8.top);
        r9.setHasAlpha(r5.hasAlpha());
        a(r5, r9, r0);
        return r9;
    }

    private static void a(Canvas r1) {
        r1.setBitmap(null);
    }

    private static Bitmap.Config a(Bitmap r1) {
        if (r1.getConfig() == null) goto L6;
        return r1.getConfig();
    L6:
        return Bitmap.Config.ARGB_8888;
    }

    private static void a(Bitmap r2, Bitmap r3, Matrix r4) {
        Lock r0 = f3854e;
        r0.lock();
        Canvas r1 = new Canvas(r3);     // Catch: Throwable -> L6
        r1.drawBitmap(r2, r4, f3850a);     // Catch: Throwable -> L6
        a(r1);     // Catch: Throwable -> L6
        r0.unlock();
        return;
    L6:
        th = move-exception;
        f3854e.unlock();
        throw th;
    }

    static void a(int r5, Matrix r6) {
        switch(r5) {
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
        r6.setRotate(-90.0f);
        return;
    L6:
        r6.setRotate(-90.0f);
        r6.postScale(-1.0f, 1.0f);
        return;
    L7:
        r6.setRotate(90.0f);
        return;
    L8:
        r6.setRotate(90.0f);
        r6.postScale(-1.0f, 1.0f);
        return;
    L9:
        r6.setRotate(180.0f);
        r6.postScale(-1.0f, 1.0f);
        return;
    L10:
        r6.setRotate(180.0f);
        return;
    L11:
        r6.setScale(-1.0f, 1.0f);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}
