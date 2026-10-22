package com.obric.autogui.platforms.tools.internal.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.view.SurfaceControl;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ReflectedScreenCapture.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "ReflectedScreenCapture";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f30350a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f30351b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f30352c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f30353d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f30354e = null;
    private static final String f = null;
    private static final f g = null;
    private static final f h = null;

    /* JADX INFO: compiled from: ReflectedScreenCapture.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ParcelFileDescriptor f30355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f30356b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f30357c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f30358d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f30359e;
        private boolean f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30355a, r6.f30355a) == true) goto L12;
            return false;
        L12:
            if (this.f30356b == r6.f30356b) goto L15;
            return false;
        L15:
            if (this.f30357c == r6.f30357c) goto L18;
            return false;
        L18:
            if (this.f30358d == r6.f30358d) goto L21;
            return false;
        L21:
            if (this.f30359e == r6.f30359e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            return (((((((((this.f30355a.hashCode() * 31) + Integer.hashCode(this.f30356b)) * 31) + Integer.hashCode(this.f30357c)) * 31) + Integer.hashCode(this.f30358d)) * 31) + Integer.hashCode(this.f30359e)) * 31) + Boolean.hashCode(this.f);
        }

        public String toString() {
            return "HeifOutput(fd=" + this.f30355a + ", outputWidth=" + this.f30356b + ", outputHeight=" + this.f30357c + ", qp=" + this.f30358d + ", downscalePreference=" + this.f30359e + ", applied=" + this.f + ')';
        }

        public a(ParcelFileDescriptor r2, int r3, int r4, int r5, int r6, boolean r7) {
            o.e(r2, "fd");
            this.f30355a = r2;
            this.f30356b = r3;
            this.f30357c = r4;
            this.f30358d = r5;
            this.f30359e = r6;
            this.f = r7;
        }

        public /* synthetic */ a(ParcelFileDescriptor r8, int r9, int r10, int r11, int r12, boolean r13, int r14, h r15) {
            if ((r14 & 32) == 0) goto L5;
            r13 = false;
        L5:
            this(r8, r9, r10, r11, r12, r13);
        }

        public final ParcelFileDescriptor a() {
            return this.f30355a;
        }

        public final int b() {
            return this.f30356b;
        }

        public final int c() {
            return this.f30357c;
        }

        public final int d() {
            return this.f30358d;
        }

        public final int e() {
            return this.f30359e;
        }

        public final void a(boolean r1) {
            this.f = r1;
        }

        public final boolean f() {
            return this.f;
        }
    }

    public static /* synthetic */ Method lambda$T4MbLDg1FZJw6YSDsUp9iE2hHwY() {
        return h();
    }

    public static /* synthetic */ Method lambda$zicjKfTyY3QbkvJpNi1o_1TBQTM() {
        return g();
    }

    private b() {
    }

    static {
        f30350a = new b();
        if (Build.VERSION.SDK_INT < 37) goto L5;
        String r0 = "android.window.ScreenCaptureInternal";
    L6:
        f30351b = r0;
        f30352c = r0 + "$CaptureArgs";
        f30353d = r0 + "$CaptureArgs$Builder";
        f30354e = r0 + "$ScreenCaptureListener";
        f = r0 + "$ScreenshotHardwareBuffer";
        g = g.a($$Lambda$b$zicjKfTyY3QbkvJpNi1o_1TBQTM.INSTANCE);
        h = g.a($$Lambda$b$T4MbLDg1FZJw6YSDsUp9iE2hHwY.INSTANCE);
        return;
    L5:
        r0 = "android.window.ScreenCapture";
        goto L6
    }

    private final Method e() {
        return (Method) ZeusTransformUtils.preCheckCast(g.b(), Method.class, "com.obric.aiagent.plugin");
    }

    private static final Method g() {
    L13:
        return ZeusTransformUtils.forName(f30353d, "com.obric.aiagent.plugin").getDeclaredMethod("setHeifOutput", new Class[]{ParcelFileDescriptor.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
    L7:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "setHeifOutput is not supported", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    L5:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to resolve setHeifOutput", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    private final Method f() {
        return (Method) ZeusTransformUtils.preCheckCast(h.b(), Method.class, "com.obric.aiagent.plugin");
    }

    private static final Method h() {
        Class<?> r3 = ZeusTransformUtils.forName(f30354e, "com.obric.aiagent.plugin");     // Catch: Exception -> L5 NoSuchMethodException -> L7
    L13:
        return ZeusTransformUtils.forName(f30353d, "com.obric.aiagent.plugin").getDeclaredMethod("setHeifEarlyBufferListener", new Class[]{r3});
    L7:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "setHeifEarlyBufferListener is not supported", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    L5:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to resolve setHeifEarlyBufferListener", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    public final boolean a() {
        if (e() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        if (f() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final Object c() {
        return ZeusTransformUtils.forName("android.view.WindowManagerGlobal", "com.obric.aiagent.plugin").getDeclaredMethod("getWindowManagerService", new Class[0]).invoke(null, new Object[0]);
    L5:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to get WindowManagerService", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    public final Object d() {
        return ZeusTransformUtils.forName(f30351b, "com.obric.aiagent.plugin").getDeclaredMethod("createSyncCaptureListener", new Class[0]).invoke(null, new Object[0]);
    L5:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to createSyncCaptureListener", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    public static /* synthetic */ boolean a(b r0, Object r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 2000;
    L6:
        return r0.a(r1, r2);
    }

    public final boolean a(Object r7, long r8) {
        o.e(r7, "listener");
        Class<?> r3 = r7.getClass();     // Catch: Exception -> L18
        n.a r5 = n.f38560a;     // Catch: Throwable -> L7
        b r6 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        Object r9 = n.f(r3.getMethod("getBuffer", new Class[]{Long.TYPE}));     // Catch: Throwable -> L7
    L10:
        if (n.b(r9) == false) goto L12;
        r9 = null;
    L12:
        Method r10 = (Method) ZeusTransformUtils.preCheckCast(r9, Method.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        if (r10 == null) goto L15;
        Object r11 = r10.invoke(r7, new Object[]{Long.valueOf(r8)});     // Catch: Exception -> L18
    L16:
        if (r11 != null) goto L25;
        return false;
    L25:
        return true;
    L15:
        r11 = r3.getMethod("getBuffer", new Class[0]).invoke(r7, new Object[0]);     // Catch: Exception -> L18
    L7:
        th = move-exception;
        n.a r12 = n.f38560a;     // Catch: Exception -> L18
        r9 = n.f(d.o.a(th));     // Catch: Exception -> L18
    L18:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "awaitFinalCompletion failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }

    public static /* synthetic */ boolean a(b r9, Object r10, int r11, Rect r12, Object r13, float r14, a r15, Object r16, int r17, Object r18) {
        if ((r17 & 16) == 0) goto L5;
        float r6 = 1.0f;
    L7:
        if ((r17 & 32) == 0) goto L9;
        a r7 = null;
    L11:
        if ((r17 & 64) == 0) goto L13;
        Object r8 = null;
    L15:
        return r9.a(r10, r11, r12, r13, r6, r7, r8);
    L13:
        r8 = r16;
        goto L15
    L9:
        r7 = r15;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }

    public final boolean a(Object r9, int r10, Rect r11, Object r12, float r13, a r14, Object r15) {
        o.e(r9, "wms");
        o.e(r11, "crop");
        o.e(r12, "listener");
        Object r8 = a(r11, null, r13, r14, r15);     // Catch: Exception -> L8
        if (r8 != null) goto L6;
        return false;
    L6:
        ZeusTransformUtils.forName("android.view.IWindowManager", "com.obric.aiagent.plugin").getMethod("captureDisplay", new Class[]{Integer.TYPE, ZeusTransformUtils.forName(f30352c, "com.obric.aiagent.plugin"), ZeusTransformUtils.forName(f30354e, "com.obric.aiagent.plugin")}).invoke(r9, new Object[]{Integer.valueOf(r10), r8, r12});     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to captureDisplay", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }

    private final Object a(Rect r10, SurfaceControl[] r11, float r12, a r13, Object r14) {
        Class r2 = ZeusTransformUtils.forName(f30353d, "com.obric.aiagent.plugin");     // Catch: Exception -> L25
        Object r4 = r2.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L25
        r2.getDeclaredMethod("setSourceCrop", new Class[]{Rect.class}).invoke(r4, new Object[]{r10});     // Catch: Exception -> L25
        r2.getDeclaredMethod("setFrameScale", new Class[]{Float.TYPE}).invoke(r4, new Object[]{Float.valueOf(r12)});     // Catch: Exception -> L25
        Loog.INSTANCE.i(TAG, "buildCaptureArgs, crop: " + r10 + ", excludeLayers: " + r11 + ", scale: " + r12);     // Catch: Exception -> L25
        if (r13 == null) goto L8;
        Method r15 = e();     // Catch: Exception -> L25
        if (r15 == null) goto L8;
        r15.invoke(r4, new Object[]{r13.a(), Integer.valueOf(r13.b()), Integer.valueOf(r13.c()), Integer.valueOf(r13.d()), Integer.valueOf(r13.e())});     // Catch: Exception -> L25
        r13.a(true);     // Catch: Exception -> L25
        Loog.INSTANCE.i(TAG, "buildCaptureArgs, heifOutput width=" + r13.b() + ", height=" + r13.c() + ", qp=" + r13.d() + ", downscalePreference=" + r13.e());     // Catch: Exception -> L25
    L8:
        if (r14 == null) goto L12;
        Method r9 = f();     // Catch: Exception -> L25
        if (r9 == null) goto L12;
        r9.invoke(r4, new Object[]{r14});     // Catch: Exception -> L25
        Loog.INSTANCE.i(TAG, "buildCaptureArgs, early buffer listener attached");     // Catch: Exception -> L25
    L12:
        if (r11 != null) goto L14;
    L20:
        boolean r16 = true;
    L21:
        if (r16 == true) goto L23;
        r2.getDeclaredMethod("setExcludeLayers", new Class[]{SurfaceControl[].class}).invoke(r4, new Object[]{r11});     // Catch: Exception -> L25
    L23:
        return r2.getDeclaredMethod(JsonPOJOBuilder.DEFAULT_BUILD_METHOD, new Class[0]).invoke(r4, new Object[0]);
    L14:
        if (r11.length != 0) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == true) goto L20;
        r16 = false;
        goto L21
    L16:
        r17 = false;
    L25:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to build CaptureArgs", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    public final com.obric.autogui.platforms.tools.internal.b.a a(Object r9, float r10) {
        o.e(r9, "listener");
        Object r11 = r9.getClass().getMethod("getBuffer", new Class[0]).invoke(r9, new Object[0]);     // Catch: Exception -> L9
        if (r11 != null) goto L8;
        Loog.INSTANCE.e(TAG, "[SS-Result], getBuffer() return null.");     // Catch: Exception -> L9
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);
    L8:
        return b(r11, r10);
    L9:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to extract result from listener", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);
    }

    public final com.obric.autogui.platforms.tools.internal.b.a b(Object r13, float r14) {
        if (r13 != null) goto L6;
        Loog.INSTANCE.e(TAG, "[SS-Buffer], buffer is null.");     // Catch: Exception -> L19
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);
    L6:
        Class r2 = ZeusTransformUtils.forName(f, "com.obric.aiagent.plugin");     // Catch: Exception -> L19
        Method r3 = r2.getMethod("asBitmap", new Class[0]);     // Catch: Exception -> L19
        Method r4 = r2.getMethod("containsSecureLayers", new Class[0]);     // Catch: Exception -> L19
        Bitmap r5 = (Bitmap) ZeusTransformUtils.preCheckCast(r3.invoke(r13, new Object[0]), Bitmap.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L19
        Object r15 = r4.invoke(r13, new Object[0]);     // Catch: Exception -> L19
        o.a(r15, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L19
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L10;
        Loog.INSTANCE.w(TAG, " - [SS-Buffer] this ScreenShot buffer contains SecureLayers!");     // Catch: Exception -> L19
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ContainsSecure, null, 0.0f, null, 14, null);
    L10:
        if (r5 != null) goto L13;
        Loog.INSTANCE.e(TAG, "[SS-Buffer], asBitmap() return null.");     // Catch: Exception -> L19
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);
    L13:
        Bitmap r7 = r5.copy(Bitmap.Config.ARGB_8888, false);     // Catch: Exception -> L19
        if (r7 != null) goto L17;
        b r12 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L19
        Loog.INSTANCE.e(TAG, "[SS-Buffer], failed to copy to software bitmap.");     // Catch: Exception -> L19
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);
    L17:
        Loog.INSTANCE.i(TAG, "screenshot-opti [SS-Buffer], software bitmap ready, w=" + r7.getWidth() + ", h=" + r7.getHeight() + ", scale=" + r14);     // Catch: Exception -> L19
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.Ok, r7, r14, null, 8, null);
    L19:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to extract result from buffer", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);
    }
}
