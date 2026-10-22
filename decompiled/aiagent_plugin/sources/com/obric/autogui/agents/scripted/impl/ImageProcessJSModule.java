package com.obric.autogui.agents.scripted.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Base64;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ImageProcessJSModule.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ImageProcessJSModule extends JSModule {
    public static final a Companion = null;
    public static final String NAME = "ImageProcessJSModule";
    private static final String TAG = "ImageProcessJSModule";
    private final d.f coroutineScope$delegate;

    /* JADX INFO: compiled from: ImageProcessJSModule.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$E38cqsk2vEr9qaiUeKY3m2-KByw, reason: not valid java name */
    public static /* synthetic */ x m720lambda$E38cqsk2vEr9qaiUeKY3m2KByw(Callback r0, ImageProcessJSModule r1, String r2, String r3, int r4) {
        return encodeImage$lambda$9(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ x lambda$ToLLtvRfELBIIn9RWJLIeRzqlzs(String r0, Callback r1, String r2, ImageProcessJSModule r3, String r4, String r5) {
        return findOverlapOffset$lambda$50(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ x lambda$WBBDznrdvkQBMFY23960xjNYOpk(Callback r0, ImageProcessJSModule r1, String r2, int r3, int r4, int r5, int r6, String r7, int r8) {
        return cropImage$lambda$27(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ am lambda$qwLFWuodpuICA5TZlHrhKZKA8qg() {
        return coroutineScope_delegate$lambda$0();
    }

    public static /* synthetic */ x lambda$thexdfYduf7qo4YrBAMQPRbaD5s(Callback r0, ImageProcessJSModule r1, String r2) {
        return getImageSize$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$uv4J5IsExBsAGF1kUXGqKOqDSAc(Callback r0, ImageProcessJSModule r1, String r2, int r3, String r4, int r5) {
        return resizeImage$lambda$20(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ x lambda$wQ8QedGWwTA6UyufM1xvY1UzRLE(Callback r0, String r1, String r2, ImageProcessJSModule r3, String r4, int r5) {
        return stitchImages$lambda$44(r0, r1, r2, r3, r4, r5);
    }

    public ImageProcessJSModule(Context r3, Object r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        super(r5, r4);
        this.coroutineScope$delegate = d.g.a($$Lambda$ImageProcessJSModule$qwLFWuodpuICA5TZlHrhKZKA8qg.INSTANCE);
    }

    private final am getCoroutineScope() {
        return (am) ZeusTransformUtils.preCheckCast(this.coroutineScope$delegate.b(), am.class, "com.obric.aiagent.plugin");
    }

    private static final am coroutineScope_delegate$lambda$0() {
        return an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final void getImageSize(final String r3, Callback r4) {
        final Callback r5 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "base64");
        d.h.b.o.e(r5, "callback");
        if (com.obric.autogui.agents.scripted.c.b.f26918a.s() == true) goto L6;
        r5.invoke(new Object[]{"{}"});
        return;
    L6:
        f.a(getCoroutineScope(), "ImageProcessJSModule", "getImageSize", r5, new $$Lambda$ImageProcessJSModule$thexdfYduf7qo4YrBAMQPRbaD5s(r5, this, r3));
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final void encodeImage(final String r9, final String r10, final int r11, Callback r12) {
        final Callback r13 = (Callback) ZeusTransformUtils.wrapperContextForParams(r12, Callback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "base64");
        d.h.b.o.e(r10, DBDefinition.MIME_TYPE);
        d.h.b.o.e(r13, "callback");
        if (com.obric.autogui.agents.scripted.c.b.f26918a.s() == true) goto L6;
        r13.invoke(new Object[]{"{}"});
        return;
    L6:
        f.a(getCoroutineScope(), "ImageProcessJSModule", "encodeImage", r13, new $$Lambda$ImageProcessJSModule$E38cqsk2vEr9qaiUeKY3m2KByw(r13, this, r9, r10, r11));
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final void resizeImage(final String r10, final int r11, final String r12, final int r13, Callback r14) {
        final Callback r15 = (Callback) ZeusTransformUtils.wrapperContextForParams(r14, Callback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "base64");
        d.h.b.o.e(r12, DBDefinition.MIME_TYPE);
        d.h.b.o.e(r15, "callback");
        if (com.obric.autogui.agents.scripted.c.b.f26918a.s() == true) goto L6;
        r15.invoke(new Object[]{"{}"});
        return;
    L6:
        f.a(getCoroutineScope(), "ImageProcessJSModule", "resizeImage", r15, new $$Lambda$ImageProcessJSModule$uv4J5IsExBsAGF1kUXGqKOqDSAc(r15, this, r10, r11, r12, r13));
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final void cropImage(final String r14, final int r15, final int r16, final int r17, final int r18, final String r19, final int r20, Callback r21) {
        final Callback r0 = (Callback) ZeusTransformUtils.wrapperContextForParams(r21, Callback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r14, "base64");
        d.h.b.o.e(r19, DBDefinition.MIME_TYPE);
        d.h.b.o.e(r0, "callback");
        if (com.obric.autogui.agents.scripted.c.b.f26918a.s() == true) goto L6;
        r0.invoke(new Object[]{"{}"});
        return;
    L6:
        f.a(getCoroutineScope(), "ImageProcessJSModule", "cropImage", r0, new $$Lambda$ImageProcessJSModule$WBBDznrdvkQBMFY23960xjNYOpk(r0, this, r14, r15, r16, r17, r18, r19, r20));
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final void stitchImages(final String r10, final String r11, final String r12, final int r13, Callback r14) {
        final Callback r15 = (Callback) ZeusTransformUtils.wrapperContextForParams(r14, Callback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "base64ArrayJson");
        d.h.b.o.e(r11, "direction");
        d.h.b.o.e(r12, DBDefinition.MIME_TYPE);
        d.h.b.o.e(r15, "callback");
        if (com.obric.autogui.agents.scripted.c.b.f26918a.s() == true) goto L6;
        r15.invoke(new Object[]{"{}"});
        return;
    L6:
        f.a(getCoroutineScope(), "ImageProcessJSModule", "stitchImages", r15, new $$Lambda$ImageProcessJSModule$wQ8QedGWwTA6UyufM1xvY1UzRLE(r15, r11, r10, this, r12, r13));
    }

    private final Bitmap decodeBase64ToBitmap(String r8) {
        int r7 = com.obric.autogui.agents.scripted.c.b.f26918a.w();
        if (r8.length() <= r7) goto L16;
        com.obric.autogui.agents.scripted.c.c.a("ImageProcessJSModule", "decodeBase64ToBitmap: base64 too large (" + r8.length() + " > " + r7 + ')');
        return null;
    L16:
        byte[] r9 = Base64.decode(r8, 2);     // Catch: Exception -> L13
        int r10 = com.obric.autogui.agents.scripted.c.b.f26918a.y();     // Catch: Exception -> L13
        BitmapFactory.Options r0 = new BitmapFactory.Options();     // Catch: Exception -> L13
        r0.inJustDecodeBounds = true;     // Catch: Exception -> L13
        BitmapFactory.decodeByteArray(r9, 0, r9.length, r0);     // Catch: Exception -> L13
        int r4 = r0.outWidth * r0.outHeight;     // Catch: Exception -> L13
        if (r4 <= r10) goto L17;
        com.obric.autogui.agents.scripted.c.c.a("ImageProcessJSModule", "decodeBase64ToBitmap: image too large (" + r0.outWidth + 'x' + r0.outHeight + '=' + r4 + " pixels > " + r10 + ')');     // Catch: Exception -> L13
        return null;
    L17:
        return BitmapFactory.decodeByteArray(r9, 0, r9.length);
    L13:
        e = move-exception;
        com.obric.autogui.agents.scripted.c.c.a("ImageProcessJSModule", "decodeBase64ToBitmap failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    private final String encodeBitmapToBase64(Bitmap r4, String r5, int r6) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Exception -> L12
        String r7 = r5.toLowerCase(Locale.ROOT);     // Catch: Exception -> L12
        d.h.b.o.c(r7, "toLowerCase(...)");     // Catch: Exception -> L12
        if (d.h.b.o.a(r7, "jpeg") == false) goto L6;
    L9:
        r4.compress(Bitmap.CompressFormat.JPEG, d.l.n.a(r6, 0, 100), (OutputStream) ZeusTransformUtils.preCheckCast(r0, OutputStream.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L12
        String r8 = "image/jpeg";
    L10:
        String r9 = Base64.encodeToString(r0.toByteArray(), 2);     // Catch: Exception -> L12
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L12
        r10.put("base64", r9);     // Catch: Exception -> L12
        r10.put("mime", r8);     // Catch: Exception -> L12
        String r11 = r10.toString();     // Catch: Exception -> L12
        d.h.b.o.a(r11);     // Catch: Exception -> L12
        return r11;
    L6:
        if (d.h.b.o.a(r7, "jpg") == true) goto L9;
        r4.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream) ZeusTransformUtils.preCheckCast(r0, OutputStream.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L12
        r8 = "image/png";
    L12:
        e = move-exception;
        com.obric.autogui.agents.scripted.c.c.a("ImageProcessJSModule", "encodeBitmapToBase64 failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return "{}";
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final void findOverlapOffset(final String r10, final String r11, final String r12, final String r13, Callback r14) {
        final Callback r15 = (Callback) ZeusTransformUtils.wrapperContextForParams(r14, Callback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "prevBase64");
        d.h.b.o.e(r11, "currBase64");
        d.h.b.o.e(r12, "direction");
        d.h.b.o.e(r13, "optionsJson");
        d.h.b.o.e(r15, "callback");
        if (com.obric.autogui.agents.scripted.c.b.f26918a.s() == true) goto L6;
        r15.invoke(new Object[]{"{}"});
        return;
    L6:
        f.a(getCoroutineScope(), "ImageProcessJSModule", "findOverlapOffset", r15, new $$Lambda$ImageProcessJSModule$ToLLtvRfELBIIn9RWJLIeRzqlzs(r13, r15, r12, this, r10, r11));
    }

    private static final x findOverlapOffset$lambda$50(String r21, Callback r22, String r23, ImageProcessJSModule r24, String r25, String r26) {
        Callback r4 = (Callback) ZeusTransformUtils.wrapperContextForParams(r22, Callback.class, "com.obric.aiagent.plugin");
        JSONObject r6 = new JSONObject(r21);
        double r13 = r6.optDouble("stripRatio", 0.05d);
        double r15 = r6.optDouble("mseThreshold", 800.0d);
        double r17 = r6.optDouble("pageEndRatio", 0.9d);
        long r7 = System.currentTimeMillis();
        d.m r9 = new d.m(r24.decodeBase64ToBitmap(r25), r24.decodeBase64ToBitmap(r26));     // Catch: Throwable -> L31
        long r8 = System.currentTimeMillis() - r7;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L7;
        Loog.INSTANCE.d("ImageProcessJSModule", "findOverlapOffset: decode cost: " + r8 + "ms");
    L7:
        Bitmap r1 = (Bitmap) ZeusTransformUtils.preCheckCast(r9.c(), Bitmap.class, "com.obric.aiagent.plugin");
        Bitmap r2 = (Bitmap) ZeusTransformUtils.preCheckCast(r9.d(), Bitmap.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L24;
        if (r2 == null) goto L24;
        String r10 = r23.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L21
        d.h.b.o.c(r10, "toLowerCase(...)");     // Catch: Throwable -> L21
        if (d.h.b.o.a(r10, "vertical") == false) goto L14;
        d.m<Integer, Boolean> r11 = r24.detectVerticalOverlap(r1, r2, r13, r15, r17);     // Catch: Throwable -> L21
    L16:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L18;
        Loog.INSTANCE.d("ImageProcessJSModule", "findOverlapOffset: direction=" + r23 + " overlap=" + ((Number) ZeusTransformUtils.preCheckCast(r11.a(), Number.class, "com.obric.aiagent.plugin")).intValue() + " isPageEnd=" + ((Boolean) ZeusTransformUtils.preCheckCast(r11.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());     // Catch: Throwable -> L21
    L18:
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L21
        r3.put("overlap", ((Number) ZeusTransformUtils.preCheckCast(r11.a(), Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L21
        r3.put("isPageEnd", ((Boolean) ZeusTransformUtils.preCheckCast(r11.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());     // Catch: Throwable -> L21
        x r5 = x.f38692a;     // Catch: Throwable -> L21
        r4.invoke(new Object[]{r3.toString()});     // Catch: Throwable -> L21
        r1.recycle();
        r2.recycle();
        return x.f38692a;
    L14:
        r11 = r24.detectHorizontalOverlap(r1, r2, r13, r15, r17);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r1.recycle();
        r2.recycle();
        throw th;
    L24:
        com.obric.autogui.agents.scripted.c.c.a("ImageProcessJSModule", "findOverlapOffset: failed to decode base64");
        if (r1 == null) goto L27;
        r1.recycle();
    L27:
        if (r2 == null) goto L29;
        r2.recycle();
    L29:
        r4.invoke(new Object[]{"{}"});
        return x.f38692a;
    L31:
        th = move-exception;
        long r12 = System.currentTimeMillis() - r7;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L35;
        Loog.INSTANCE.d("ImageProcessJSModule", "findOverlapOffset: decode cost: " + r12 + "ms");
    L35:
        throw th;
    }

    private final d.m<Integer, Boolean> detectVerticalOverlap(Bitmap r23, Bitmap r24, double r25, double r27, double r29) {
        int r0 = r23.getWidth();
        int r1 = r23.getHeight();
        int r7 = r24.getHeight();
        int r8 = Math.max(10, (int) (((double) r1) * r25));
        int[] r9 = extractPixels(r23, 0, r1 - r8, r0, r8);
        int r11 = Math.max(1, r0 / 200);
        int r12 = r7 - r8;
        long r13 = System.currentTimeMillis();
        String r6 = " cost: ";
        String r5 = "ImageProcessJSModule";
        double r2 = Double.MAX_VALUE;
        String r4 = "detectVerticalOverlap: search";
        if (r12 < 0) goto L15;
        double r17 = Double.MAX_VALUE;
        int r3 = 0;
        int r19 = 0;
    L5:
        int r26 = r3;
        String r10 = r4;
        String r21 = r5;
        int r20 = r7;
        String r14 = r6;
        double r15 = calculateMSE(r9, extractPixels(r24, 0, r26, r0, r8), r0, r8, r11);     // Catch: Throwable -> L13
        if (r15 >= r17) goto L9;
        r19 = r26;
        r17 = r15;
        int r16 = r19;
    L10:
        if (r16 == r12) goto L12;
        r3 = r16 + 1;     // Catch: Throwable -> L13
        r6 = r14;
        r4 = r10;
        r7 = r20;
        r5 = r21;
        goto L5
    L12:
        r2 = r17;
    L16:
        x r18 = x.f38692a;     // Catch: Throwable -> L13
        long r22 = System.currentTimeMillis() - r13;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L20;
        String r28 = r21;
        Loog.INSTANCE.d(r28, r10 + r14 + r22 + "ms");
    L22:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L25;
        Loog.INSTANCE.d(r28, "detectVerticalOverlap: iterations=" + r12 + " bestMSE=" + r2);
    L25:
        if (r2 > r27) goto L27;
        int r30 = r19 + r8;
        if (r30 <= (((double) r20) * r29)) goto L31;
        boolean r110 = true;
    L33:
        return new d.m(Integer.valueOf(r30), Boolean.valueOf(r110));
    L31:
        r110 = false;
        goto L33
    L27:
        return new d.m(0, false);
    L20:
        r28 = r21;
        goto L22
    L9:
        r16 = r26;
    L13:
        th = move-exception;
        String r31 = r21;
        long r32 = System.currentTimeMillis() - r13;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L37;
        Loog.INSTANCE.d(r31, r10 + r14 + r32 + "ms");
    L37:
        throw th;
    L15:
        r10 = "detectVerticalOverlap: search";
        r21 = "ImageProcessJSModule";
        r20 = r7;
        r14 = " cost: ";
        r19 = 0;
        goto L16
    }

    private final d.m<Integer, Boolean> detectHorizontalOverlap(Bitmap r23, Bitmap r24, double r25, double r27, double r29) {
        int r0 = r23.getWidth();
        int r1 = r24.getWidth();
        int r8 = r23.getHeight();
        int r9 = Math.max(10, (int) (((double) r0) * r25));
        int[] r2 = extractPixels(r23, r0 - r9, 0, r9, r8);
        int r11 = Math.max(1, r8 / 200);
        int r12 = r1 - r9;
        long r13 = System.currentTimeMillis();
        String r7 = " cost: ";
        String r6 = "ImageProcessJSModule";
        double r3 = Double.MAX_VALUE;
        String r5 = "detectHorizontalOverlap: search";
        if (r12 < 0) goto L15;
        double r17 = Double.MAX_VALUE;
        int r4 = 0;
        int r19 = 0;
    L5:
        int r26 = r4;
        String r10 = r5;
        String r21 = r6;
        int r20 = r1;
        String r14 = r7;
        double r15 = calculateMSE(r2, extractPixels(r24, r4, 0, r9, r8), r9, r8, r11);     // Catch: Throwable -> L13
        if (r15 >= r17) goto L9;
        r19 = r26;
        r17 = r15;
        int r16 = r19;
    L10:
        if (r16 == r12) goto L12;
        r4 = r16 + 1;     // Catch: Throwable -> L13
        r7 = r14;
        r5 = r10;
        r1 = r20;
        r6 = r21;
        goto L5
    L12:
        r3 = r17;
    L16:
        x r18 = x.f38692a;     // Catch: Throwable -> L13
        long r22 = System.currentTimeMillis() - r13;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L20;
        String r28 = r10 + r14 + r22 + "ms";
        String r30 = r21;
        Loog.INSTANCE.d(r30, r28);
    L22:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L25;
        Loog.INSTANCE.d(r30, "detectHorizontalOverlap: iterations=" + r12 + " bestMSE=" + r3);
    L25:
        if (r3 > r27) goto L27;
        int r31 = r19 + r9;
        if (r31 <= (((double) r20) * r29)) goto L31;
        boolean r110 = true;
    L33:
        return new d.m(Integer.valueOf(r31), Boolean.valueOf(r110));
    L31:
        r110 = false;
        goto L33
    L27:
        return new d.m(0, false);
    L20:
        r30 = r21;
        goto L22
    L9:
        r16 = r26;
    L13:
        th = move-exception;
        String r32 = r21;
        long r33 = System.currentTimeMillis() - r13;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L37;
        Loog.INSTANCE.d(r32, r10 + r14 + r33 + "ms");
    L37:
        throw th;
    L15:
        r20 = r1;
        r10 = "detectHorizontalOverlap: search";
        r21 = "ImageProcessJSModule";
        r14 = " cost: ";
        r19 = 0;
        goto L16
    }

    private final int[] extractPixels(Bitmap r9, int r10, int r11, int r12, int r13) {
        int[] r8 = new int[r12 * r13];
        r9.getPixels(r8, 0, r12, r10, r11, r12, r13);
        return r8;
    }

    private final double calculateMSE(int[] r17, int[] r18, int r19, int r20, int r21) {
        int r1 = 0;
        double r2 = 0.0d;
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r5 >= r20) goto L14;
        d.l.h r7 = d.l.n.a((d.l.h) ZeusTransformUtils.preCheckCast(d.l.n.b(r1, r19), d.l.h.class, "com.obric.aiagent.plugin"), r21);
        int r9 = r7.a();
        int r10 = r7.b();
        int r8 = r7.c();
        if (r8 <= 0) goto L7;
        if (r9 > r10) goto L7;
    L9:
        int r11 = (r5 * r19) + r9;
        int r12 = r17[r11];
        int r13 = r18[r11];
        int r14 = ((r12 >> 16) & 255) - ((r13 >> 16) & 255);
        int r15 = r5;
        int r16 = ((r12 >> 8) & 255) - ((r13 >> 8) & 255);
        int r110 = (r12 & 255) - (r13 & 255);
        r2 = ((r2 + ((double) (r14 * r14))) + ((double) (r16 * r16))) + ((double) (r110 * r110));
        r6 = r6 + 3;
        if (r9 == r10) goto L13;
        r9 = r9 + r8;
        r5 = r15;
    L13:
        r5 = r15 + 1;
        r1 = 0;
    L7:
        if (r8 >= 0) goto L12;
        if (r10 <= r9) goto L9;
    L12:
        r15 = r5;
        goto L13
    L14:
        if (r6 > 0) goto L22;
        return Double.MAX_VALUE;
    L22:
        return r2 / ((double) r6);
    }

    private static final x getImageSize$lambda$4(Callback r8, ImageProcessJSModule r9, String r10) {
        Callback r11 = (Callback) ZeusTransformUtils.wrapperContextForParams(r8, Callback.class, "com.obric.aiagent.plugin");
        long r4 = System.currentTimeMillis();
        Bitmap r12 = r9.decodeBase64ToBitmap(r10);     // Catch: Throwable -> L22
        long r6 = System.currentTimeMillis() - r4;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L8;
        Loog.INSTANCE.d("ImageProcessJSModule", "getImageSize: decode cost: " + r6 + "ms");
    L8:
        if (r12 != null) goto L29;
        com.obric.autogui.agents.scripted.c.c.a("ImageProcessJSModule", "getImageSize: failed to decode base64");
        r11.invoke(new Object[]{"{}"});
        return x.f38692a;
    L29:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L17
        r1.put("width", r12.getWidth());     // Catch: Throwable -> L17
        r1.put("height", r12.getHeight());     // Catch: Throwable -> L17
        r11.invoke(new Object[]{r1.toString()});     // Catch: Throwable -> L17
        x r13 = x.f38692a;     // Catch: Throwable -> L17
        if (r12.isRecycled() == true) goto L16;
        r12.recycle();
    L16:
        return x.f38692a;
    L17:
        th = move-exception;
        if (r12.isRecycled() == true) goto L21;
        r12.recycle();
    L21:
        throw th;
    L22:
        th = move-exception;
        long r14 = System.currentTimeMillis() - r4;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L26;
        Loog.INSTANCE.d("ImageProcessJSModule", "getImageSize: decode cost: " + r14 + "ms");
    L26:
        throw th;
    }

    private static final x encodeImage$lambda$9(Callback r10, ImageProcessJSModule r11, String r12, String r13, int r14) {
        Callback r15 = (Callback) ZeusTransformUtils.wrapperContextForParams(r10, Callback.class, "com.obric.aiagent.plugin");
        long r4 = System.currentTimeMillis();
        Bitmap r16 = r11.decodeBase64ToBitmap(r12);     // Catch: Throwable -> L35
        long r6 = System.currentTimeMillis() - r4;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L8;
        Loog.INSTANCE.d("ImageProcessJSModule", "encodeImage: decode cost: " + r6 + "ms");
    L8:
        if (r16 != null) goto L42;
        com.obric.autogui.agents.scripted.c.c.a("ImageProcessJSModule", "encodeImage: failed to decode base64");
        r15.invoke(new Object[]{"{}"});
        return x.f38692a;
    L42:
        long r7 = System.currentTimeMillis();     // Catch: Throwable -> L30
        String r17 = r11.encodeBitmapToBase64(r16, r13, r14);     // Catch: Throwable -> L25
        long r8 = System.currentTimeMillis() - r7;     // Catch: Throwable -> L30
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L17;
        Loog.INSTANCE.d("ImageProcessJSModule", "encodeImage: encode cost: " + r8 + "ms");     // Catch: Throwable -> L30
    L17:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L19;
        Loog.INSTANCE.d("ImageProcessJSModule", "encodeImage: mime=" + r13 + " quality=" + r14);     // Catch: Throwable -> L30
    L19:
        r15.invoke(new Object[]{r17});     // Catch: Throwable -> L30
        x r18 = x.f38692a;     // Catch: Throwable -> L30
        if (r16.isRecycled() == true) goto L24;
        r16.recycle();
    L24:
        return x.f38692a;
    L25:
        th = move-exception;
        long r19 = System.currentTimeMillis() - r7;     // Catch: Throwable -> L30
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L29;
        Loog.INSTANCE.d("ImageProcessJSModule", "encodeImage: encode cost: " + r19 + "ms");     // Catch: Throwable -> L30
    L29:
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        if (r16.isRecycled() == true) goto L34;
        r16.recycle();
    L34:
        throw th;
    L35:
        th = move-exception;
        long r110 = System.currentTimeMillis() - r4;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L39;
        Loog.INSTANCE.d("ImageProcessJSModule", "encodeImage: decode cost: " + r110 + "ms");
    L39:
        throw th;
    }

    private static final x resizeImage$lambda$20(Callback r18, ImageProcessJSModule r19, String r20, int r21, String r22, int r23) {
        Callback r7 = (Callback) ZeusTransformUtils.wrapperContextForParams(r18, Callback.class, "com.obric.aiagent.plugin");
        long r9 = System.currentTimeMillis();
        Bitmap r11 = r19.decodeBase64ToBitmap(r20);     // Catch: Throwable -> L85
        long r12 = System.currentTimeMillis() - r9;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L8;
        Loog.INSTANCE.d("ImageProcessJSModule", "resizeImage: decode cost: " + r12 + "ms");
    L8:
        if (r11 != null) goto L96;
        com.obric.autogui.agents.scripted.c.c.a("ImageProcessJSModule", "resizeImage: failed to decode base64");
        r7.invoke(new Object[]{"{}"});
        return x.f38692a;
    L96:
        int r10 = r11.getWidth() * r11.getHeight();     // Catch: Throwable -> L79
        long r13 = System.currentTimeMillis();     // Catch: Throwable -> L79
        if (r10 <= r21) goto L20;
        double r0 = Math.sqrt(((double) r21) / ((double) r10));     // Catch: Throwable -> L17
        int r8 = (int) (((double) r11.getWidth()) * r0);     // Catch: Throwable -> L17
        int r1 = (int) (((double) r11.getHeight()) * r0);     // Catch: Throwable -> L17
        Bitmap r14 = Bitmap.createScaledBitmap(r11, r8, r1, true);     // Catch: Throwable -> L17
        d.h.b.o.c(r14, "createScaledBitmap(...)");     // Catch: Throwable -> L17
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L23;
        Loog.INSTANCE.d("ImageProcessJSModule", "resizeImage: from=" + r11.getWidth() + 'x' + r11.getHeight() + " to=" + r8 + 'x' + r1);     // Catch: Throwable -> L17
    L23:
        long r2 = System.currentTimeMillis() - r13;     // Catch: Throwable -> L79
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L26;
        Loog.INSTANCE.d("ImageProcessJSModule", "resizeImage: resize cost: " + r2 + "ms");     // Catch: Throwable -> L79
    L26:
        if (r14 != r11) goto L28;
        boolean r3 = true;
    L30:
        if (r3 == false) goto L46;
        long r15 = System.currentTimeMillis();     // Catch: Throwable -> L79
        String r4 = r19.encodeBitmapToBase64(r14, r22, r23);     // Catch: Throwable -> L41
        long r5 = System.currentTimeMillis() - r15;     // Catch: Throwable -> L79
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L40;
        Loog.INSTANCE.d("ImageProcessJSModule", "resizeImage: encode cost: " + r5 + "ms");     // Catch: Throwable -> L77
    L40:
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L77
        r6.put("base64", new JSONObject(r4).optString("base64", ""));     // Catch: Throwable -> L77
        r6.put("width", r14.getWidth());     // Catch: Throwable -> L77
        r6.put("height", r14.getHeight());     // Catch: Throwable -> L77
        r6.put("mime", new JSONObject(r4).optString("mime", ""));     // Catch: Throwable -> L77
        r7.invoke(new Object[]{r6.toString()});     // Catch: Throwable -> L77
    L56:
        x r16 = x.f38692a;     // Catch: Throwable -> L77
        if (r11.isRecycled() == true) goto L61;
        r11.recycle();
    L61:
        return x.f38692a;
    L41:
        th = move-exception;
        long r17 = System.currentTimeMillis() - r15;     // Catch: Throwable -> L77
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L100;
        Loog.INSTANCE.d("ImageProcessJSModule", "resizeImage: encode cost: " + r17 + "ms");     // Catch: Throwable -> L77
        throw th;     // Catch: Throwable -> L77
    L100:
        throw th;     // Catch: Throwable -> L77
    L46:
        r11 = r11;
        long r110 = System.currentTimeMillis();     // Catch: Throwable -> L68
        String r24 = r19.encodeBitmapToBase64(r14, r22, r23);     // Catch: Throwable -> L62
        long r25 = System.currentTimeMillis() - r110;     // Catch: Throwable -> L68
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L52;
        Loog.INSTANCE.d("ImageProcessJSModule", "resizeImage: encode cost: " + r25 + "ms");     // Catch: Throwable -> L68
    L52:
        JSONObject r26 = new JSONObject();     // Catch: Throwable -> L68
        r26.put("base64", new JSONObject(r24).optString("base64", ""));     // Catch: Throwable -> L68
        r26.put("width", r14.getWidth());     // Catch: Throwable -> L68
        r26.put("height", r14.getHeight());     // Catch: Throwable -> L68
        r26.put("mime", new JSONObject(r24).optString("mime", ""));     // Catch: Throwable -> L68
        r7.invoke(new Object[]{r26.toString()});     // Catch: Throwable -> L68
        x r27 = x.f38692a;     // Catch: Throwable -> L68
        if (r14.isRecycled() == true) goto L56;
        r14.recycle();     // Catch: Throwable -> L77
        goto L56
    L62:
        th = move-exception;
        long r28 = System.currentTimeMillis() - r110;     // Catch: Throwable -> L68
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L101;
        Loog.INSTANCE.d("ImageProcessJSModule", "resizeImage: encode cost: " + r28 + "ms");     // Catch: Throwable -> L68
        throw th;     // Catch: Throwable -> L68
    L101:
        throw th;     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        if (r14.isRecycled() == true) goto L72;
        r14.recycle();     // Catch: Throwable -> L77
    L72:
        throw th;     // Catch: Throwable -> L77
    L28:
        r3 = false;
        goto L30
    L20:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L22;
        Loog.INSTANCE.d("ImageProcessJSModule", "resizeImage: no resize needed currentPixels=" + r10 + " maxPixels=" + r21);     // Catch: Throwable -> L17
    L22:
        r14 = r11;
    L77:
        th = th;
    L82:
        if (r11.isRecycled() == true) goto L84;
        r11.recycle();
    L84:
        throw th;
    L17:
        th = move-exception;
        long r29 = System.currentTimeMillis() - r13;     // Catch: Throwable -> L77
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L76;
        Loog.INSTANCE.d("ImageProcessJSModule", "resizeImage: resize cost: " + r29 + "ms");     // Catch: Throwable -> L77
    L76:
        throw th;     // Catch: Throwable -> L77
    L79:
        th = th;
        r11 = r11;
    L85:
        th = move-exception;
        long r30 = System.currentTimeMillis() - r9;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L102;
        Loog.INSTANCE.d("ImageProcessJSModule", "resizeImage: decode cost: " + r30 + "ms");
        throw th;
    L102:
        throw th;
    }

    private static final x cropImage$lambda$27(Callback r17, ImageProcessJSModule r18, String r19, int r20, int r21, int r22, int r23, String r24, int r25) {
        Callback r0 = (Callback) ZeusTransformUtils.wrapperContextForParams(r17, Callback.class, "com.obric.aiagent.plugin");
        long r5 = System.currentTimeMillis();
        Bitmap r7 = r18.decodeBase64ToBitmap(r19);     // Catch: Throwable -> L62
        long r8 = System.currentTimeMillis() - r5;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L8;
        Loog.INSTANCE.d("ImageProcessJSModule", "cropImage: decode cost: " + r8 + "ms");
    L8:
        if (r7 != null) goto L70;
        com.obric.autogui.agents.scripted.c.c.a("ImageProcessJSModule", "cropImage: failed to decode base64");
        r0.invoke(new Object[]{"{}"});
        return x.f38692a;
    L70:
        int r9 = d.l.n.a(r20, 0, r7.getWidth() - 1);     // Catch: Throwable -> L57
        int r10 = d.l.n.a(r21, 0, r7.getHeight() - 1);     // Catch: Throwable -> L57
        int r11 = d.l.n.d(r22, r7.getWidth() - r9);     // Catch: Throwable -> L57
        int r12 = d.l.n.d(r23, r7.getHeight() - r10);     // Catch: Throwable -> L57
        if (r11 <= 0) goto L50;
        if (r12 <= 0) goto L50;
        long r13 = System.currentTimeMillis();     // Catch: Throwable -> L57
        Bitmap r14 = Bitmap.createBitmap(r7, r9, r10, r11, r12);     // Catch: Throwable -> L45
        long r15 = System.currentTimeMillis() - r13;     // Catch: Throwable -> L57
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L20;
        Loog.INSTANCE.d("ImageProcessJSModule", "cropImage: crop cost: " + r15 + "ms");     // Catch: Throwable -> L57
    L20:
        d.h.b.o.c(r14, "runWithPerformanceLog(...)");     // Catch: Throwable -> L57
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L67;
        Loog.INSTANCE.d("ImageProcessJSModule", "cropImage: rect=" + r9 + ',' + r10 + ',' + r11 + ',' + r12);     // Catch: Throwable -> L57
    L67:
        long r16 = System.currentTimeMillis();     // Catch: Throwable -> L40
        String r6 = r18.encodeBitmapToBase64(r14, r24, r25);     // Catch: Throwable -> L34
        long r110 = System.currentTimeMillis() - r16;     // Catch: Throwable -> L40
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L29;
        Loog.INSTANCE.d("ImageProcessJSModule", "cropImage: encode cost: " + r110 + "ms");     // Catch: Throwable -> L40
    L29:
        r0.invoke(new Object[]{r6});     // Catch: Throwable -> L40
        x r1 = x.f38692a;     // Catch: Throwable -> L40
        if (r14.isRecycled() == true) goto L51;
        r14.recycle();     // Catch: Throwable -> L57
    L51:
        x r2 = x.f38692a;     // Catch: Throwable -> L57
        if (r7.isRecycled() == true) goto L56;
        r7.recycle();
    L56:
        return x.f38692a;
    L34:
        th = move-exception;
        long r111 = System.currentTimeMillis() - r16;     // Catch: Throwable -> L40
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L75;
        Loog.INSTANCE.d("ImageProcessJSModule", "cropImage: encode cost: " + r111 + "ms");     // Catch: Throwable -> L40
        throw th;     // Catch: Throwable -> L40
    L75:
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        if (r14.isRecycled() == true) goto L44;
        r14.recycle();     // Catch: Throwable -> L57
    L44:
        throw th;     // Catch: Throwable -> L57
    L45:
        th = move-exception;
        long r26 = System.currentTimeMillis() - r13;     // Catch: Throwable -> L57
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L76;
        Loog.INSTANCE.d("ImageProcessJSModule", "cropImage: crop cost: " + r26 + "ms");     // Catch: Throwable -> L57
        throw th;     // Catch: Throwable -> L57
    L76:
        throw th;     // Catch: Throwable -> L57
    L50:
        com.obric.autogui.agents.scripted.c.c.a("ImageProcessJSModule", "cropImage: invalid crop region");     // Catch: Throwable -> L57
        r0.invoke(new Object[]{"{}"});     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        if (r7.isRecycled() == true) goto L61;
        r7.recycle();
    L61:
        throw th;
    L62:
        th = move-exception;
        long r27 = System.currentTimeMillis() - r5;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L77;
        Loog.INSTANCE.d("ImageProcessJSModule", "cropImage: decode cost: " + r27 + "ms");
        throw th;
    L77:
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v12 */
    private static final x stitchImages$lambda$44(Callback r29, String r30, String r31, ImageProcessJSModule r32, String r33, int r34) {
        String r4 = "up";
        Callback r8 = (Callback) ZeusTransformUtils.wrapperContextForParams(r29, Callback.class, "com.obric.aiagent.plugin");
        long r11 = System.currentTimeMillis();
        JSONArray r13 = new JSONArray(r31);     // Catch: Throwable -> L177
        long r14 = System.currentTimeMillis() - r11;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L7;
        Loog.INSTANCE.d("ImageProcessJSModule", "stitchImages: parse json cost: " + r14 + "ms");
    L7:
        int r10 = com.obric.autogui.agents.scripted.c.b.f26918a.x();
        if (r13.length() <= r10) goto L12;
        com.obric.autogui.agents.scripted.c.c.a("ImageProcessJSModule", "stitchImages: too many images (" + r13.length() + " > " + r10 + ')');
        r8.invoke(new Object[]{"{}"});
        return x.f38692a;
    L12:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L15;
        Loog.INSTANCE.d("ImageProcessJSModule", "stitchImages: count=" + r13.length());
    L15:
        if (r13.length() != 0) goto L18;
        com.obric.autogui.agents.scripted.c.c.a("ImageProcessJSModule", "stitchImages: empty image array");
        r8.invoke(new Object[]{"{}"});
        return x.f38692a;
    L18:
        long r15 = System.currentTimeMillis();
        JSONArray r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L172
        int r16 = r13.length();     // Catch: Throwable -> L172
        int r0 = 0;
        r12 = r13;
    L20:
        if (r0 >= r16) goto L30;
        int r17 = r16;
        String r18 = r12.getString(r0);     // Catch: Throwable -> L172
        d.h.b.o.a(r18);     // Catch: Throwable -> L172
        Bitmap r19 = r32.decodeBase64ToBitmap(r18);     // Catch: Throwable -> L172
        if (r19 == null) goto L25;
        Boolean.valueOf(r12.add(r19));     // Catch: Throwable -> L172
        r4 = r4;
        r12 = r12;
    L29:
        r0 = r0 + 1;
        r16 = r17;
        r12 = r12;
        r4 = r4;
        goto L20
    L25:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L28;
        Loog.INSTANCE.w("ImageProcessJSModule", "stitchImages: failed to decode image at index " + r0 + ", skipping");     // Catch: Throwable -> L172
    L28:
        x r5 = x.f38692a;     // Catch: Throwable -> L172
        goto L29
    L30:
        String r110 = r4;
        long r111 = System.currentTimeMillis() - r15;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L34;
        Loog.INSTANCE.d("ImageProcessJSModule", "stitchImages: decode all cost: " + r111 + "ms");
    L34:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L37;
        Loog.INSTANCE.d("ImageProcessJSModule", "stitchImages: valid=" + r12.size());
    L37:
        if (r12.isEmpty() == false) goto L190;
        com.obric.autogui.agents.scripted.c.c.a("ImageProcessJSModule", "stitchImages: no valid images to stitch");
        r8.invoke(new Object[]{"{}"});
        return x.f38692a;
    L190:
    L163:
        th = th;
        r12 = r12;
    L165:
        Iterator r1 = r12.iterator();
    L167:
        if (r1.hasNext() == false) goto L171;
        Bitmap r2 = (Bitmap) ZeusTransformUtils.preCheckCast(r1.next(), Bitmap.class, "com.obric.aiagent.plugin");
        if (r2.isRecycled() == true) goto L167;
        r2.recycle();
        goto L167
    L171:
        throw th;
    L41:
        String r112 = "";
        if (r12.size() != 1) goto L63;
        long r113 = System.currentTimeMillis();     // Catch: Throwable -> L163
        String r3 = r32.encodeBitmapToBase64((Bitmap) ZeusTransformUtils.preCheckCast(r12.get(0), Bitmap.class, "com.obric.aiagent.plugin"), r33, r34);     // Catch: Throwable -> L57
        long r6 = System.currentTimeMillis() - r113;     // Catch: Throwable -> L163
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L49;
        Loog.INSTANCE.d("ImageProcessJSModule", "stitchImages: encode cost: " + r6 + "ms");     // Catch: Throwable -> L163
    L49:
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L163
        r7.put("base64", new JSONObject(r3).optString("base64", ""));     // Catch: Throwable -> L163
        r7.put("width", ((Bitmap) ZeusTransformUtils.preCheckCast(r12.get(0), Bitmap.class, "com.obric.aiagent.plugin")).getWidth());     // Catch: Throwable -> L163
        r7.put("height", ((Bitmap) ZeusTransformUtils.preCheckCast(r12.get(0), Bitmap.class, "com.obric.aiagent.plugin")).getHeight());     // Catch: Throwable -> L163
        r7.put("mime", new JSONObject(r3).optString("mime", ""));     // Catch: Throwable -> L163
        r8.invoke(new Object[]{r7.toString()});     // Catch: Throwable -> L163
        x r9 = x.f38692a;     // Catch: Throwable -> L163
        Iterator r20 = r12.iterator();
    L52:
        if (r20.hasNext() == false) goto L56;
        Bitmap r21 = (Bitmap) ZeusTransformUtils.preCheckCast(r20.next(), Bitmap.class, "com.obric.aiagent.plugin");
        if (r21.isRecycled() == true) goto L52;
        r21.recycle();
        goto L52
    L56:
        return r9;
    L57:
        th = move-exception;
        long r22 = System.currentTimeMillis() - r113;     // Catch: Throwable -> L163
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L61;
        Loog.INSTANCE.d("ImageProcessJSModule", "stitchImages: encode cost: " + r22 + "ms");     // Catch: Throwable -> L163
    L61:
        throw th;     // Catch: Throwable -> L163
    L63:
        if (d.h.b.o.a(r30, r110) == true) goto L68;
        String r114 = "mime";
        if (d.h.b.o.a(r30, "left") == true) goto L69;
        List r115 = r12;
    L71:
        if (d.h.b.o.a(r30, r110) == false) goto L73;
    L76:
        boolean r23 = true;
    L186:
        if (r23 == true) goto L79;
        Iterator r24 = ((Iterable) ZeusTransformUtils.preCheckCast(r115, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L161
        int r116 = 0;
    L92:
        if (r24.hasNext() == false) goto L94;
        r116 = r116 + ((Bitmap) ZeusTransformUtils.preCheckCast(r24.next(), Bitmap.class, "com.obric.aiagent.plugin")).getWidth();     // Catch: Throwable -> L161
        r24 = r24;
        goto L92
    L94:
        int r25 = r116;
    L95:
        if (r23 == false) goto L101;
        Iterator r117 = ((Iterable) ZeusTransformUtils.preCheckCast(r115, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L161
        int r118 = 0;
    L98:
        if (r117.hasNext() == false) goto L100;
        r118 = r118 + ((Bitmap) ZeusTransformUtils.preCheckCast(r117.next(), Bitmap.class, "com.obric.aiagent.plugin")).getHeight();     // Catch: Throwable -> L161
        r112 = r112;
        r117 = r117;
        goto L98
    L100:
        String r26 = r112;
    L110:
        long r27 = System.currentTimeMillis();     // Catch: Throwable -> L161
        Bitmap r119 = Bitmap.createBitmap(r25, r118, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L154
        d.h.b.o.c(r119, "createBitmap(...)");     // Catch: Throwable -> L154
        Canvas r120 = new Canvas(r119);     // Catch: Throwable -> L154
        r120.drawColor(-1);     // Catch: Throwable -> L154
        float r121 = 0.0f;
        Iterator r122 = r115.iterator();     // Catch: Throwable -> L154
    L112:
        if (r122.hasNext() == false) goto L119;
        Iterator r28 = r122;
        Bitmap r35 = (Bitmap) ZeusTransformUtils.preCheckCast(r122.next(), Bitmap.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L154
        if (r23 == false) goto L117;
        r120.drawBitmap(r35, (r25 - r35.getWidth()) / 2.0f, r121, null);     // Catch: Throwable -> L154
        int r36 = r35.getHeight();     // Catch: Throwable -> L154
    L118:
        r121 = r121 + r36;
        r122 = r28;
        r23 = r23;
        goto L112
    L117:
        r120.drawBitmap(r35, r121, (r118 - r35.getHeight()) / 2.0f, null);     // Catch: Throwable -> L154
        r36 = r35.getWidth();     // Catch: Throwable -> L154
        goto L118
    L119:
        long r123 = System.currentTimeMillis() - r27;     // Catch: Throwable -> L161
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L123;
        Loog.INSTANCE.d("ImageProcessJSModule", "stitchImages: stitch cost: " + r123 + "ms");     // Catch: Throwable -> L161
    L123:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L189;
        Loog.INSTANCE.d("ImageProcessJSModule", "stitchImages: canvas=" + r25 + 'x' + r118 + " direction=" + r30);     // Catch: Throwable -> L161
    L189:
        long r124 = System.currentTimeMillis();     // Catch: Throwable -> L149
        String r37 = r32.encodeBitmapToBase64(r119, r33, r34);     // Catch: Throwable -> L143
        long r38 = System.currentTimeMillis() - r124;     // Catch: Throwable -> L149
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L131;
        Loog.INSTANCE.d("ImageProcessJSModule", "stitchImages: encode cost: " + r38 + "ms");     // Catch: Throwable -> L149
    L131:
        JSONObject r39 = new JSONObject();     // Catch: Throwable -> L149
        String r40 = r26;
        r39.put("base64", new JSONObject(r37).optString("base64", r40));     // Catch: Throwable -> L149
        r39.put("width", r25);     // Catch: Throwable -> L149
        r39.put("height", r118);     // Catch: Throwable -> L149
        JSONObject r41 = new JSONObject(r37);     // Catch: Throwable -> L149
        String r42 = r114;
        r39.put(r42, r41.optString(r42, r40));     // Catch: Throwable -> L149
        r8.invoke(new Object[]{r39.toString()});     // Catch: Throwable -> L149
        x r43 = x.f38692a;     // Catch: Throwable -> L149
        if (r119.isRecycled() == true) goto L135;
        r119.recycle();     // Catch: Throwable -> L161
    L135:
        Iterator r44 = r12.iterator();
    L137:
        if (r44.hasNext() == false) goto L142;
        Bitmap r45 = (Bitmap) ZeusTransformUtils.preCheckCast(r44.next(), Bitmap.class, "com.obric.aiagent.plugin");
        if (r45.isRecycled() == true) goto L137;
        r45.recycle();
        goto L137
    L142:
        return x.f38692a;
    L143:
        th = move-exception;
        long r46 = System.currentTimeMillis() - r124;     // Catch: Throwable -> L149
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L224;
        Loog.INSTANCE.d("ImageProcessJSModule", "stitchImages: encode cost: " + r46 + "ms");     // Catch: Throwable -> L149
        throw th;     // Catch: Throwable -> L149
    L224:
        throw th;     // Catch: Throwable -> L149
    L149:
        th = move-exception;
        if (r119.isRecycled() == true) goto L153;
        r119.recycle();     // Catch: Throwable -> L161
    L153:
        throw th;     // Catch: Throwable -> L161
    L154:
        th = move-exception;
        long r47 = System.currentTimeMillis() - r27;     // Catch: Throwable -> L161
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L158;
        Loog.INSTANCE.d("ImageProcessJSModule", "stitchImages: stitch cost: " + r47 + "ms");     // Catch: Throwable -> L161
    L158:
        throw th;     // Catch: Throwable -> L161
    L101:
        r26 = "";
        Iterator r125 = ((Iterable) ZeusTransformUtils.preCheckCast(r115, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L161
        if (r125.hasNext() == false) goto L160;
        r118 = ((Bitmap) ZeusTransformUtils.preCheckCast(r125.next(), Bitmap.class, "com.obric.aiagent.plugin")).getHeight();     // Catch: Throwable -> L161
    L105:
        if (r125.hasNext() == false) goto L110;
        Iterator r210 = r125;
        int r126 = ((Bitmap) ZeusTransformUtils.preCheckCast(r125.next(), Bitmap.class, "com.obric.aiagent.plugin")).getHeight();     // Catch: Throwable -> L161
        if (r118 >= r126) goto L109;
        r118 = r126;
    L109:
        r125 = r210;
        goto L105
    L160:
        throw new NoSuchElementException();     // Catch: Throwable -> L161
    L79:
        Iterator r127 = ((Iterable) ZeusTransformUtils.preCheckCast(r115, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L161
        if (r127.hasNext() == false) goto L89;
        r25 = ((Bitmap) ZeusTransformUtils.preCheckCast(r127.next(), Bitmap.class, "com.obric.aiagent.plugin")).getWidth();     // Catch: Throwable -> L161
    L83:
        if (r127.hasNext() == false) goto L95;
        Iterator r211 = r127;
        int r128 = ((Bitmap) ZeusTransformUtils.preCheckCast(r127.next(), Bitmap.class, "com.obric.aiagent.plugin")).getWidth();     // Catch: Throwable -> L161
        if (r25 >= r128) goto L87;
        r25 = r128;
    L87:
        r127 = r211;
        goto L83
    L89:
        throw new NoSuchElementException();     // Catch: Throwable -> L161
    L161:
        th = th;
        goto L165
    L73:
        if (d.h.b.o.a(r30, "down") == true) goto L76;
        r23 = false;
    L69:
        r115 = d.a.p.l((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L163
        goto L71
    L68:
        r114 = "mime";
    L172:
        th = move-exception;
        long r48 = System.currentTimeMillis() - r15;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L176;
        Loog.INSTANCE.d("ImageProcessJSModule", "stitchImages: decode all cost: " + r48 + "ms");
    L176:
        throw th;
    L177:
        th = move-exception;
        long r49 = System.currentTimeMillis() - r11;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L181;
        Loog.INSTANCE.d("ImageProcessJSModule", "stitchImages: parse json cost: " + r49 + "ms");
    L181:
        throw th;
    }
}
