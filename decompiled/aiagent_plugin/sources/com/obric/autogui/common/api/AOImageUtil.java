package com.obric.autogui.common.api;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Build;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: AOImageUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOImageUtil {
    public static final AOImageUtil INSTANCE = null;
    private static final String TAG = "AutoActionImageUtil";

    /* JADX INFO: renamed from: com.obric.autogui.common.api.AOImageUtil$saveBitmapToFile$2, reason: invalid class name */
    /* JADX INFO: compiled from: AOImageUtil.kt */
    @f(b = "AOImageUtil.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.common.api.AOImageUtil$saveBitmapToFile$2")
    static final class AnonymousClass2 extends l implements m<am, d<? super Boolean>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ File $file;
        int label;

        AnonymousClass2(File r3, Bitmap r4, d<? super AnonymousClass2> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.$file = r3;
            this.$bitmap = r4;
            super(2, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$file, this.$bitmap, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super Boolean> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super Boolean> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v11 */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v13 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.io.FileOutputStream] */
        /* JADX WARN: Type inference failed for: r5v6 */
        /* JADX WARN: Type inference failed for: r5v7 */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            b.a();
            if (this.label != 0) goto L25;
            o.a(r5);
            ?? r6 = 0;
            FileOutputStream r7 = null;
            FileOutputStream r0 = new FileOutputStream(this.$file);     // Catch: Throwable -> L12 IOException -> L14
            Bitmap r4 = this.$bitmap;     // Catch: Throwable -> L8 IOException -> L10
            Bitmap.CompressFormat r8 = Bitmap.CompressFormat.JPEG;     // Catch: Throwable -> L8 IOException -> L10
            r4.compress(r8, 100, (OutputStream) ZeusTransformUtils.preCheckCast(r0, OutputStream.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8 IOException -> L10
            r0.flush();     // Catch: Throwable -> L8 IOException -> L10
            boolean r9 = true;
            r0.close();
            r6 = r8;
        L19:
            return d.c.b.a.b.a(r9);
        L10:
            e = e;
            r7 = r0;
        L15:
            e.printStackTrace();     // Catch: Throwable -> L12
            r9 = false;
            r6 = r7;
            if (r7 == null) goto L19;
            r7.close();
            r6 = r7;
        L8:
            th = th;
            r6 = r0;
        L21:
            if (r6 == 0) goto L23;
            r6.close();
        L23:
            throw th;
        L12:
            th = th;
        L14:
            e = e;
            goto L15
        L25:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        INSTANCE = new AOImageUtil();
    }

    private final int toGray(int r8) {
        int r7 = (r8 >> 16) & 255;
        int r0 = (r8 >> 8) & 255;
        return (int) (((((double) r7) * 0.299d) + (((double) r0) * 0.587d)) + (((double) (r8 & 255)) * 0.114d));
    }

    private AOImageUtil() {
    }

    public final Object saveBitmapToFile(Bitmap r4, File r5, d<? super Boolean> r6) {
        d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        return i.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r5, r4, null), m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Bitmap drawNumbersOnBitmap(Collection<? extends PointF> r21, Bitmap r22) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r21, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "points");
        d.h.b.o.e(r22, "bitmap");
        boolean r4 = true;
        Bitmap r3 = r22.copy(Bitmap.Config.ARGB_8888, true);
        Canvas r11 = new Canvas(r3);
        Paint r12 = new Paint();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r13 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        PointF r5 = (PointF) ZeusTransformUtils.preCheckCast(r2.next(), PointF.class, "com.obric.aiagent.plugin");
        r12.setColor(-65536);
        r12.setTextSize(50.0f);
        r12.setAntiAlias(r4);
        r12.setStyle(Paint.Style.FILL);
        r12.setAlpha(125);
        float r15 = r5.x * r22.getWidth();
        float r10 = r5.y * r22.getHeight();
        float r16 = r15 - 30.0f;
        float r17 = r10 - 30.0f;
        float r18 = r15 + 30.0f;
        float r19 = r10 + 30.0f;
        r11.drawRect(r16, r17, r18, r19, r12);
        r12.setAlpha(255);
        r12.setColor(-16777216);
        r11.drawLine(r16, r17, r18, r19, r12);
        r11.drawLine(r16, r19, r18, r17, r12);
        r11.drawText(String.valueOf(r13), r15, r10, r12);
        r13 = r13 + 1;
        r4 = true;
        goto L4
    L6:
        d.h.b.o.a(r3);
        return r3;
    }

    public final boolean isSameBitmapInPointArea(Bitmap r26, Bitmap r27, PointF r28, int r29) {
        d.h.b.o.e(r28, "point");
        Loog.INSTANCE.d(TAG, "isSameBitmapInPointArea, point=" + r28 + ", expandPixel=" + r29 + ", bitmap1=" + r26 + ", bitmap2=" + r27);
        if (r26 == null) goto L71;
        if (r27 == null) goto L71;
        if (r26.getWidth() == r27.getWidth()) goto L9;
    L69:
        Loog.INSTANCE.i(TAG, "isSameBitmapInPointArea, return false2, bitmap size not same, size1: " + r26.getWidth() + 'x' + r26.getHeight() + ", size2: " + r27.getWidth() + 'x' + r27.getHeight());
        return false;
    L9:
        if (r26.getHeight() != r27.getHeight()) goto L69;
        int r12 = (int) r28.x;
        int r13 = (int) r28.y;
        int r14 = Math.max(0, r12 - r29);
        int r15 = Math.max(0, r13 - r29);
        int r6 = Math.min(r26.getWidth(), r12 + r29);
        int r5 = Math.min(r26.getHeight(), r29 + r13);
        int r16 = r6 - r14;
        int r17 = r5 - r15;
        if (r16 <= 0) goto L67;
        if (r17 <= 0) goto L67;
        Bitmap r19 = null;
        d.m<int[], Bitmap> r1 = getPixelsFromBitmap(r26, r14, r15, r16, r17);     // Catch: Throwable -> L51 Exception -> L53
        int[] r7 = (int[]) ZeusTransformUtils.preCheckCast(r1.c(), int[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51 Exception -> L53
        Bitmap r24 = (Bitmap) ZeusTransformUtils.preCheckCast(r1.d(), Bitmap.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51 Exception -> L53
    L77:
        d.m<int[], Bitmap> r0 = getPixelsFromBitmap(r27, r14, r15, r16, r17);     // Catch: Throwable -> L45 Exception -> L48
        int[] r2 = (int[]) ZeusTransformUtils.preCheckCast(r0.c(), int[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45 Exception -> L48
        Bitmap r3 = (Bitmap) ZeusTransformUtils.preCheckCast(r0.d(), Bitmap.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45 Exception -> L48
        if (r7 == null) goto L40;
        if (r2 == null) goto L40;
    L38:
        e = e;
    L50:
        r19 = r24;
    L73:
        Loog.INSTANCE.e(TAG, "isSameBitmapInPointArea, getPixels failed, return false", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L61
        if (r19 == null) goto L58;
        r19.recycle();
    L58:
        if (r3 == null) goto L60;
        r3.recycle();
    L60:
        return false;
    L61:
        th = th;
    L62:
        if (r19 == null) goto L64;
        r19.recycle();
    L64:
        if (r3 == null) goto L66;
        r3.recycle();
    L66:
        throw th;
    L36:
        th = th;
    L47:
        r19 = r24;
        goto L62
    L23:
        if (Arrays.equals(r7, r2) == true) goto L30;
        Loog.INSTANCE.i(TAG, "isSameBitmapInPointArea, return false3, pixels not same");     // Catch: Throwable -> L36 Exception -> L38
        if (r24 == null) goto L27;
        r24.recycle();
    L27:
        if (r3 == null) goto L29;
        r3.recycle();
    L29:
        return false;
    L30:
        if (r24 == null) goto L32;
        r24.recycle();
    L32:
        if (r3 == null) goto L34;
        r3.recycle();
    L34:
        Loog.INSTANCE.d(TAG, "isSameBitmapInPointArea, return true, x=" + r12 + ", y=" + r13 + ", rect: " + r14 + ", " + r15 + ", " + r6 + ", " + r5);
        return true;
    L40:
        if (r24 == null) goto L42;
        r24.recycle();
    L42:
        if (r3 == null) goto L44;
        r3.recycle();
    L44:
        return false;
    L48:
        e = e;
        r3 = null;
    L45:
        th = th;
        r3 = null;
    L53:
        e = e;
        r3 = null;
    L51:
        th = th;
        r3 = null;
    L67:
        Loog.INSTANCE.w(TAG, "isSameBitmapInPointArea, invalid area, return true, x=" + r12 + ", y=" + r13 + ", rect: " + r14 + ", " + r15 + ", " + r6 + ", " + r5);
        return true;
    L71:
        Loog.INSTANCE.i(TAG, "isSameBitmapInPointArea, return false1, bitmap1=" + r26 + ", bitmap2=" + r27);
        return false;
    }

    private final d.m<int[], Bitmap> getPixelsFromBitmap(Bitmap r10, int r11, int r12, int r13, int r14) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
    L7:
        boolean r9 = false;
    L8:
        int[] r0 = new int[r13 * r14];
        if (r9 == false) goto L11;
        Bitmap r15 = Bitmap.createBitmap(r10, r11, r12, r13, r14);
        d.h.b.o.c(r15, "createBitmap(...)");
        r15.getPixels(r0, 0, r13, 0, 0, r13, r14);
        return new d.m(r0, r15);
    L11:
        r10.getPixels(r0, 0, r13, r11, r12, r13, r14);
        return new d.m(r0, null);
    L5:
        if (r10.getConfig() != Bitmap.Config.HARDWARE) goto L7;
        r9 = true;
        goto L8
    }

    public final Long calculateDHash(Bitmap r14) {
        if (r14 != null) goto L21;
        Loog.INSTANCE.w(TAG, "calculateDHash: bitmap is null");
        return null;
    L21:
        Bitmap r15 = Bitmap.createScaledBitmap(r14, 9, 8, false);     // Catch: Exception -> L18
        d.h.b.o.c(r15, "createScaledBitmap(...)");     // Catch: Exception -> L18
        int[] r2 = new int[72];     // Catch: Exception -> L18
        r15.getPixels(r2, 0, 9, 0, 0, 9, 8);     // Catch: Exception -> L18
        long r5 = 0;
        int r7 = 0;
    L8:
        if (r7 >= 8) goto L16;
        int r8 = 0;
    L10:
        if (r8 >= 8) goto L15;
        int r9 = (r7 * 9) + r8;     // Catch: Exception -> L18
        int r10 = r9 + 1;     // Catch: Exception -> L18
        if (toGray(r2[r10]) <= toGray(r2[r9])) goto L14;
        r5 = r5 | (1 << ((r7 * 8) + r8));     // Catch: Exception -> L18
    L14:
        r8 = r8 + 1;     // Catch: Exception -> L18
        goto L10
    L15:
        r7 = r7 + 1;     // Catch: Exception -> L18
        goto L8
    L16:
        r15.recycle();     // Catch: Exception -> L18
        return Long.valueOf(r5);
    L18:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "calculateDHash failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    public final int calculateHammingDistance(Long r5, Long r6) {
        if (r5 == null) goto L7;
        if (r6 == null) goto L9;
        long r0 = r5.longValue() ^ r6.longValue();
        Loog.INSTANCE.i(TAG, "calculateHammingDistance: hash1=" + r5 + ", hash2=" + r6 + ", xor=" + r0);
        return Long.bitCount(r0);
    L9:
        return Integer.MAX_VALUE;
    L7:
        return Integer.MAX_VALUE;
    }

    public static /* synthetic */ boolean isSimilarByDHash$default(AOImageUtil r0, Bitmap r1, Bitmap r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = 10;
    L6:
        return r0.isSimilarByDHash(r1, r2, r3);
    }

    public final boolean isSimilarByDHash(Bitmap r9, Bitmap r10, int r11) {
        Long r12 = calculateDHash(r9);
        Long r13 = calculateDHash(r10);
        boolean r0 = false;
        if (r12 == null) goto L11;
        if (r13 == null) goto L11;
        Loog.INSTANCE.i(TAG, "isSimilarByDHash start: hash1=" + r12 + ", hash2=" + r13 + ", xor=" + (r12.longValue() ^ r13.longValue()) + ", max=" + r11);
        int r8 = calculateHammingDistance(r12, r13);
        if (r8 > r11) goto L9;
        r0 = true;
    L9:
        Loog.INSTANCE.i(TAG, "isSimilarByDHash result: distance=" + r8 + ", max=" + r11 + ", isSimilar=" + r0);
        return r0;
    L11:
        Loog.INSTANCE.w(TAG, "isSimilarByDHash: failed to calculate hash, hash1=" + r12 + ", hash2=" + r13);
        return false;
    }
}
