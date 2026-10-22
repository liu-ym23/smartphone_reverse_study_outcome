package com.airbnb.lottie.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.provider.Settings;
import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes.dex */
public final class Utils {
    private static final float INV_SQRT_2 = 0.0f;
    public static final int SECOND_IN_NANOS = 1000000000;
    private static final ThreadLocal<PathMeasure> threadLocalPathMeasure = null;
    private static final ThreadLocal<float[]> threadLocalPoints = null;
    private static final ThreadLocal<Path> threadLocalTempPath = null;
    private static final ThreadLocal<Path> threadLocalTempPath2 = null;

    public static int hashFor(float r2, float r3, float r4, float r5) {
        if (r2 == 0.0f) goto L5;
        int r6 = (int) (527 * r2);
    L7:
        if (r3 == 0.0f) goto L10;
        r6 = (int) ((r6 * 31) * r3);
    L10:
        if (r4 == 0.0f) goto L13;
        r6 = (int) ((r6 * 31) * r4);
    L13:
        if (r5 != 0.0f) goto L15;
        return r6;
    L15:
        return (int) ((r6 * 31) * r5);
    L5:
        r6 = 17;
        goto L7
    }

    public static boolean isAtLeastVersion(int r2, int r3, int r4, int r5, int r6, int r7) {
        if (r2 >= r5) goto L6;
        return false;
    L6:
        if (r2 <= r5) goto L8;
        return true;
    L8:
        if (r3 >= r6) goto L10;
        return false;
    L10:
        if (r3 <= r6) goto L12;
        return true;
    L12:
        if (r4 >= r7) goto L14;
        return false;
    L14:
        return true;
    }

    static {
        threadLocalPathMeasure = new AnonymousClass1();
        threadLocalTempPath = new AnonymousClass2();
        threadLocalTempPath2 = new AnonymousClass3();
        threadLocalPoints = new AnonymousClass4();
        INV_SQRT_2 = (float) (Math.sqrt(2.0d) / 2.0d);
    }

    private Utils() {
    }

    public static Path createPath(PointF r8, PointF r9, PointF r10, PointF r11) {
        Path r7 = new Path();
        r7.moveTo(r8.x, r8.y);
        if (r10 == null) goto L10;
        if (r11 == null) goto L10;
        if (r10.length() == 0.0f) goto L8;
    L9:
        float r0 = r8.x;
        r7.cubicTo(r10.x + r0, r8.y + r10.y, r9.x + r11.x, r9.y + r11.y, r9.x, r9.y);
    L11:
        return r7;
    L8:
        if (r11.length() != 0.0f) goto L9;
    L10:
        r7.lineTo(r9.x, r9.y);
        goto L11
    }

    public static void closeQuietly(Closeable r0) {
        if (r0 != null) goto L9;
        return;
    L9:
        r0.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static float getScale(Matrix r6) {
        float[] r0 = threadLocalPoints.get();
        r0[0] = 0.0f;
        r0[1] = 0.0f;
        float r2 = INV_SQRT_2;
        r0[2] = r2;
        r0[3] = r2;
        r6.mapPoints(r0);
        return (float) Math.hypot(r0[2] - r0[0], r0[3] - r0[1]);
    }

    public static boolean hasZeroScaleAxis(Matrix r6) {
        float[] r0 = threadLocalPoints.get();
        r0[0] = 0.0f;
        r0[1] = 0.0f;
        r0[2] = 37394.73f;
        r0[3] = 39575.234f;
        r6.mapPoints(r0);
        if (r0[0] == r0[2]) goto L7;
        if (r0[1] == r0[3]) goto L7;
        return false;
    L7:
        return true;
    }

    public static void applyTrimPathIfNeeded(Path r3, TrimPathContent r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isHidden() == true) goto L9;
        float r0 = ((FloatKeyframeAnimation) r4.getStart()).getFloatValue();
        float r1 = ((FloatKeyframeAnimation) r4.getEnd()).getFloatValue();
        applyTrimPathIfNeeded(r3, r0 / 100.0f, r1 / 100.0f, ((FloatKeyframeAnimation) r4.getOffset()).getFloatValue() / 360.0f);
        return;
    }

    public static void applyTrimPathIfNeeded(Path r10, float r11, float r12, float r13) {
        L.beginSection("applyTrimPathIfNeeded");
        PathMeasure r1 = threadLocalPathMeasure.get();
        Path r2 = threadLocalTempPath.get();
        Path r3 = threadLocalTempPath2.get();
        r1.setPath(r10, false);
        float r4 = r1.getLength();
        if (r11 != 1.0f) goto L9;
        if (r12 != 0.0f) goto L9;
        L.endSection("applyTrimPathIfNeeded");
        return;
    L9:
        if (r4 >= 1.0f) goto L11;
    L38:
        L.endSection("applyTrimPathIfNeeded");
        return;
    L11:
        if (Math.abs((r12 - r11) - 1.0f) < 0.01d) goto L38;
        float r14 = r11 * r4;
        float r15 = r12 * r4;
        float r16 = r13 * r4;
        float r5 = Math.min(r14, r15) + r16;
        float r17 = Math.max(r14, r15) + r16;
        if (r5 < r4) goto L19;
        if (r17 < r4) goto L19;
        r5 = MiscUtils.floorMod(r5, r4);
        r17 = MiscUtils.floorMod(r17, r4);
    L19:
        if (r5 >= 0.0f) goto L22;
        r5 = MiscUtils.floorMod(r5, r4);
    L22:
        if (r17 >= 0.0f) goto L25;
        r17 = MiscUtils.floorMod(r17, r4);
    L25:
        if (r5 != r17) goto L28;
        r10.reset();
        L.endSection("applyTrimPathIfNeeded");
        return;
    L28:
        if (r5 < r17) goto L30;
        r5 = r5 - r4;
    L30:
        r2.reset();
        r1.getSegment(r5, r17, r2, true);
        if (r17 <= r4) goto L34;
        r3.reset();
        r1.getSegment(0.0f, r17 % r4, r3, true);
        r2.addPath(r3);
    L36:
        r10.set(r2);
        L.endSection("applyTrimPathIfNeeded");
        return;
    L34:
        if (r5 >= 0.0f) goto L36;
        r3.reset();
        r1.getSegment(r5 + r4, r4, r3, true);
        r2.addPath(r3);
        goto L36
    }

    public static float dpScale() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float getAnimationScale(Context r2) {
        return Settings.Global.getFloat(r2.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static Bitmap resizeBitmapIfNeeded(Bitmap r1, int r2, int r3) {
        if (r1.getWidth() == r2) goto L5;
    L7:
        Bitmap r4 = Bitmap.createScaledBitmap(r1, r2, r3, true);
        r1.recycle();
        return r4;
    L5:
        if (r1.getHeight() != r3) goto L7;
        return r1;
    }

    public static boolean isNetworkException(Throwable r1) {
        if ((r1 instanceof SocketException) == false) goto L5;
    L18:
        return true;
    L5:
        if ((r1 instanceof ClosedChannelException) == true) goto L18;
        if ((r1 instanceof InterruptedIOException) == true) goto L18;
        if ((r1 instanceof ProtocolException) == true) goto L18;
        if ((r1 instanceof SSLException) == true) goto L18;
        if ((r1 instanceof UnknownHostException) == true) goto L18;
        if ((r1 instanceof UnknownServiceException) == true) goto L18;
        return false;
    }

    public static void saveLayerCompat(Canvas r1, RectF r2, Paint r3) {
        saveLayerCompat(r1, r2, r3, 31);
    }

    public static void saveLayerCompat(Canvas r0, RectF r1, Paint r2, int r3) {
        L.beginSection("Utils#saveLayer");
        r0.saveLayer(r1, r2);
        L.endSection("Utils#saveLayer");
    }

    public static Bitmap renderPath(Path r4) {
        RectF r0 = new RectF();
        r4.computeBounds(r0, false);
        Bitmap r1 = Bitmap.createBitmap((int) r0.right, (int) r0.bottom, Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(r1);
        LPaint r3 = new LPaint();
        r3.setAntiAlias(true);
        r3.setColor(-16776961);
        r2.drawPath(r4, r3);
        return r1;
    }
}
