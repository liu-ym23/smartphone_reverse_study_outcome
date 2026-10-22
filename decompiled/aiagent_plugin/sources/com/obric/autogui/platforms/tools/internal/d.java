package com.obric.autogui.platforms.tools.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.autogui.common.api.abilities.AutoActionAbilitiesKt;
import com.obric.autogui.common.api.abilities.AutoActionAbility;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.capture.HeifScreenshotAttachment;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import java.io.File;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: ScreenCaptureHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String TAG = "SC-Helper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30365a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f30366b = null;

    /* JADX INFO: compiled from: ScreenCaptureHelper.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ScreenCaptureHelper.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HeifScreenshotAttachment f30367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ParcelFileDescriptor f30368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.obric.autogui.platforms.tools.internal.b.b.a f30369c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30367a, r6.f30367a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f30368b, r6.f30368b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f30369c, r6.f30369c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f30367a.hashCode() * 31) + this.f30368b.hashCode()) * 31) + this.f30369c.hashCode();
        }

        public String toString() {
            return "HeifAttempt(attachment=" + this.f30367a + ", fd=" + this.f30368b + ", output=" + this.f30369c + ')';
        }

        public b(HeifScreenshotAttachment r2, ParcelFileDescriptor r3, com.obric.autogui.platforms.tools.internal.b.b.a r4) {
            o.e(r2, "attachment");
            o.e(r3, "fd");
            o.e(r4, "output");
            this.f30367a = r2;
            this.f30368b = r3;
            this.f30369c = r4;
        }

        public final HeifScreenshotAttachment a() {
            return this.f30367a;
        }

        public final com.obric.autogui.platforms.tools.internal.b.b.a b() {
            return this.f30369c;
        }

        public final void c() {
            n.a r0 = n.f38560a;     // Catch: Throwable -> L4
            ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).f30368b.close();     // Catch: Throwable -> L4
            n.f(x.f38692a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            n.a r1 = n.f38560a;
            n.f(d.o.a(th));
        }
    }

    /* JADX INFO: compiled from: ScreenCaptureHelper.kt */
    @f(b = "ScreenCaptureHelper.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.internal.ScreenCaptureHelper$doScreenshotEarlyBuffer$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f30371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f30372c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ w<Boolean> f30373d;

        c(Object r3, b r4, w<Boolean> r5, d.c.d<? super c> r6) {
            w<Boolean> r7 = (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30371b = r3;
            this.f30372c = r4;
            this.f30373d = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f30371b, this.f30372c, this.f30373d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f30370a != 0) goto L20;
            d.o.a(r8);
            boolean r9 = false;
            boolean r1 = com.obric.autogui.platforms.tools.internal.b.b.a(com.obric.autogui.platforms.tools.internal.b.b.f30350a, this.f30371b, 0, 2, null);     // Catch: Throwable -> L7
            this.f30372c.c();
        L10:
            if (r1 == true) goto L12;
        L14:
            Loog.INSTANCE.i(d.TAG, "[SS-Early] heif encoding complete ok=" + r1 + " valid=" + r9);
            this.f30373d.a(d.c.b.a.b.a(r9));
            return x.f38692a;
        L12:
            if (this.f30372c.a().isValid() == false) goto L14;
            r9 = true;
        L7:
            th = move-exception;
            Loog.INSTANCE.e(d.TAG, "[SS-Early] awaitFinalCompletion error", th);     // Catch: Throwable -> L16
            this.f30372c.c();
            r1 = false;
        L16:
            th = move-exception;
            this.f30372c.c();
            throw th;
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public d() {
    }

    static {
        f30365a = new a(null);
        f30366b = an.a(cx.a(null, 1, null).plus((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")));
    }

    public final boolean a() {
        if (Build.VERSION.SDK_INT >= 34) goto L6;
        Loog.INSTANCE.e(TAG, "SDKVersion=" + Build.VERSION.SDK_INT + ", smaller than 34.");
        return false;
    L6:
        return true;
    }

    public final com.obric.autogui.platforms.tools.internal.b.a a(Context r10, DisplayAccessor r11, Rect r12, float r13, ScreenshotConfig.HeifConfig r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        DisplayAccessor r16 = (DisplayAccessor) ZeusTransformUtils.wrapperContextForParams(r11, DisplayAccessor.class, "com.obric.aiagent.plugin");
        o.e(r15, "context");
        o.e(r16, "displayAccessor");
        o.e(r12, "area");
        if (a() == false) goto L5;
        b r17 = a(r15, r12, r13, r14);     // Catch: Throwable -> L41
        com.obric.autogui.platforms.tools.internal.b.a r1 = a(r16, r12, r13, r17);     // Catch: Throwable -> L37
        Loog r9 = Loog.INSTANCE;     // Catch: Throwable -> L37
        StringBuilder r18 = new StringBuilder().append("[SS-Synced] capture result, status=").append(r1.a()).append(", heifRequested=");     // Catch: Throwable -> L37
        boolean r19 = true;
        if (r17 == null) goto L10;
        boolean r110 = true;
    L11:
        StringBuilder r111 = r18.append(r110).append(", heifApplied=");     // Catch: Throwable -> L37
        if (r17 == null) goto L18;
        com.obric.autogui.platforms.tools.internal.b.b.a r112 = r17.b();     // Catch: Throwable -> L37
        if (r112 == null) goto L18;
        if (r112.f() != true) goto L18;
        boolean r113 = true;
    L19:
        r9.i(TAG, r111.append(r113).toString());     // Catch: Throwable -> L37
        if (r1.a() != ScreenshotResult.Status.Ok) goto L31;
        if (r17 == null) goto L27;
        com.obric.autogui.platforms.tools.internal.b.b.a r20 = r17.b();     // Catch: Throwable -> L37
        if (r20 == null) goto L27;
        if (r20.f() != true) goto L27;
    L28:
        if (r19 == false) goto L31;
        r1 = com.obric.autogui.platforms.tools.internal.b.a.a(r1, null, null, 0.0f, r17.a(), 7, null);     // Catch: Throwable -> L37
    L35:
        if (r17 == null) goto L46;
        r17.c();     // Catch: Throwable -> L41
        return r1;
    L46:
        return r1;
    L27:
        r19 = false;
    L31:
        if (r17 == null) goto L35;
        HeifScreenshotAttachment r21 = r17.a();     // Catch: Throwable -> L37
        if (r21 == null) goto L35;
        r21.delete();     // Catch: Throwable -> L37
    L18:
        r113 = false;
        goto L19
    L10:
        r110 = false;
    L37:
        th = move-exception;
        if (r17 == null) goto L40;
        r17.c();     // Catch: Throwable -> L41
    L40:
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[SS-Synced] Failed to extract result from listener", th);
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);
    L5:
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.NotSupported, null, 0.0f, null, 14, null);
    }

    public final com.obric.autogui.platforms.tools.internal.b.a b(Context r23, DisplayAccessor r24, Rect r25, float r26, ScreenshotConfig.HeifConfig r27) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
        DisplayAccessor r13 = (DisplayAccessor) ZeusTransformUtils.wrapperContextForParams(r24, DisplayAccessor.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        o.e(r13, "displayAccessor");
        o.e(r25, "area");
        o.e(r27, "heifConfig");
        if (a() == true) goto L5;
    L54:
        Loog.INSTANCE.i(TAG, "[SS-Early] not supported, fallback to synced");
        return a(r12, r13, r25, r26, r27);
    L5:
        if (com.obric.autogui.platforms.tools.internal.b.b.f30350a.a() == false) goto L54;
        if (com.obric.autogui.platforms.tools.internal.b.b.f30350a.b() == false) goto L54;
        Object r2 = com.obric.autogui.platforms.tools.internal.b.b.f30350a.c();
        if (r2 != null) goto L13;
        Loog.INSTANCE.e(TAG, "[SS-Early] getWindowManagerService null, fallback to synced");
        return a(r12, r13, r25, r26, r27);
    L13:
        b r8 = a(r12, r25, r26, r27);
        if (r8 != null) goto L17;
        Loog.INSTANCE.i(TAG, "[SS-Early] heif attempt null, fallback to synced");
        return a(r12, r13, r25, r26, r27);
    L17:
        Object r7 = com.obric.autogui.platforms.tools.internal.b.b.f30350a.d();
        Object r6 = com.obric.autogui.platforms.tools.internal.b.b.f30350a.d();
        if (r7 == null) goto L52;
        if (r6 == null) goto L52;
        if (com.obric.autogui.platforms.tools.internal.b.b.f30350a.a(r2, r13.getDisplayId(), r25, r6, r26, r8.b(), r7) == true) goto L24;
    L50:
        Loog.INSTANCE.e(TAG, "[SS-Early] captureDisplay failed/heif not applied, fallback to synced");
        r8.c();
        return a(r12, r13, r25, r26, r27);
    L24:
        if (r8.b().f() != true) goto L50;
        com.obric.autogui.platforms.tools.internal.b.a r0 = com.obric.autogui.platforms.tools.internal.b.b.f30350a.a(r7, r26);     // Catch: Throwable -> L28
    L30:
        com.obric.autogui.platforms.tools.internal.b.a r3 = r0;
        if (r3.a() == ScreenshotResult.Status.Ok) goto L48;
        Loog.INSTANCE.w(TAG, "[SS-Early] early miss (status=" + r3.a() + "), await final");
        com.obric.autogui.platforms.tools.internal.b.a r1 = com.obric.autogui.platforms.tools.internal.b.b.f30350a.a(r6, r26);     // Catch: Throwable -> L35
    L34:
        r8.c();
        com.obric.autogui.platforms.tools.internal.b.a r11 = r1;
        if (r11.a() == ScreenshotResult.Status.Ok) goto L41;
    L43:
        r8.a().delete();
        return r11;
    L41:
        if (r8.b().f() != true) goto L43;
        return com.obric.autogui.platforms.tools.internal.b.a.a(r11, null, null, 0.0f, r8.a(), 7, null);
    L35:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[SS-Early] final getFromListener failed", th);     // Catch: Throwable -> L45
        r1 = new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        r8.c();
        throw th;
    L48:
        w r4 = y.a(null, 1, null);
        r8.a().setEncodingComplete((au) ZeusTransformUtils.preCheckCast(r4, au.class, "com.obric.aiagent.plugin"));
        i.a(f30366b, null, null, (m) ZeusTransformUtils.preCheckCast(new c(r6, r8, r4, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        Loog.INSTANCE.i(TAG, "[SS-Early] early bitmap returned, heif draining in background");
        return com.obric.autogui.platforms.tools.internal.b.a.a(r3, null, null, 0.0f, r8.a(), 7, null);
    L28:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[SS-Early] early getFromListener failed", th);
        r0 = new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);
    L52:
        Loog.INSTANCE.e(TAG, "[SS-Early] createSyncCaptureListener null, fallback to synced");
        r8.c();
        return a(r12, r13, r25, r26, r27);
    }

    private final com.obric.autogui.platforms.tools.internal.b.a a(DisplayAccessor r12, Rect r13, float r14, b r15) {
        DisplayAccessor r16 = (DisplayAccessor) ZeusTransformUtils.wrapperContextForParams(r12, DisplayAccessor.class, "com.obric.aiagent.plugin");
        Object r2 = com.obric.autogui.platforms.tools.internal.b.b.f30350a.c();     // Catch: Throwable -> L21
        if (r2 != null) goto L7;
        Loog.INSTANCE.e(TAG, "[SS-Synced] getWindowManagerService() return null.");     // Catch: Throwable -> L21
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);
    L7:
        Object r0 = com.obric.autogui.platforms.tools.internal.b.b.f30350a.d();     // Catch: Throwable -> L21
        if (r0 != null) goto L11;
        Loog.INSTANCE.e(TAG, "[pacific] createSyncCaptureListener() failed.");     // Catch: Throwable -> L21
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);
    L11:
        com.obric.autogui.platforms.tools.internal.b.b r1 = com.obric.autogui.platforms.tools.internal.b.b.f30350a;     // Catch: Throwable -> L21
        int r3 = r16.getDisplayId();     // Catch: Throwable -> L21
        if (r15 == null) goto L14;
        com.obric.autogui.platforms.tools.internal.b.b.a r17 = r15.b();     // Catch: Throwable -> L21
    L16:
        if (com.obric.autogui.platforms.tools.internal.b.b.a(r1, r2, r3, r13, r0, r14, r17, null, 64, null) == true) goto L25;
        Loog.INSTANCE.e(TAG, "[SS-Synced] captureDisplay() failed.");     // Catch: Throwable -> L21
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);
    L25:
        return com.obric.autogui.platforms.tools.internal.b.b.f30350a.a(r0, r14);
    L14:
        r17 = null;
    L21:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[SS-Synced] Failed to extract result from listener", th);
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);
    }

    private final b a(Context r12, Rect r13, float r14, ScreenshotConfig.HeifConfig r15) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L6;
        return null;
    L6:
        if (com.obric.autogui.platforms.tools.internal.b.b.f30350a.a() == true) goto L9;
        Loog.INSTANCE.i(TAG, "[SS-Synced] heif skipped, setHeifOutput unsupported");
        return null;
    L9:
        File r16 = HeifScreenshotAttachment.Companion.cacheDir(r11);
        r16.mkdirs();
        File r17 = File.createTempFile("screenshot_", ".heif", r16);
        ParcelFileDescriptor r18 = ParcelFileDescriptor.open(r17, 1006632960);
        int r4 = d.l.n.c((int) (r13.width() * r14), 1);
        int r5 = d.l.n.c((int) (r13.height() * r14), 1);
        int r6 = d.l.n.a(r15.getQp(), 1, 51);
        int r7 = d.l.n.a(r15.getDownscalePreference(), 0, 1);
        Loog.INSTANCE.i(TAG, "[SS-Synced] heif attempt created, outputWidth=" + r4 + ", outputHeight=" + r5 + ", qp=" + r6 + ", downscalePreference=" + r7);
        o.a(r17);
        HeifScreenshotAttachment r19 = new HeifScreenshotAttachment(r17);
        o.a(r18);
        return new b(r19, r18, new com.obric.autogui.platforms.tools.internal.b.b.a(r18, r4, r5, r6, r7, false, 32, null));
    }

    public final com.obric.autogui.platforms.tools.internal.b.a a(Context r8, List<String> r9, List<String> r10, float r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        if (a() == true) goto L7;
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.NotSupported, null, 0.0f, null, 14, null);
    L7:
        if (AutoActionAbilitiesKt.isSupported(AutoActionAbility.WmCaptureMainDisplay) == false) goto L9;
        Object r7 = com.obric.autogui.platforms.tools.internal.b.b.f30350a.d();     // Catch: Throwable -> L20
        if (r7 != null) goto L15;
        Loog.INSTANCE.e(TAG, "[MD-Capture] createSyncCaptureListener() failed.");     // Catch: Throwable -> L20
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);
    L15:
        if (ObricProductSdk.INSTANCE.platformService().windowManager().takeSurfaceControlScreenshot(r13, r14, r7) == true) goto L24;
        Loog.INSTANCE.e(TAG, "[SS-Synced/MD] captureDisplay() failed.");     // Catch: Throwable -> L20
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);
    L24:
        return com.obric.autogui.platforms.tools.internal.b.b.f30350a.a(r7, 1.0f);
    L20:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[SS-Synced/MD] Failed to extract result from listener", th);
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.ApiError, null, 0.0f, null, 14, null);
    L9:
        return new com.obric.autogui.platforms.tools.internal.b.a(ScreenshotResult.Status.NotSupported, null, 0.0f, null, 14, null);
    }
}
