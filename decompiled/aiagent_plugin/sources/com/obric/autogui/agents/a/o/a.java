package com.obric.autogui.agents.a.o;

import android.graphics.Bitmap;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.agents.vlm.models.omni.t;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.operator.e;
import com.obric.autogui.operator.j;
import com.obric.autogui.util.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.l.n;
import d.o;
import d.x;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import org.json.JSONObject;

/* JADX INFO: compiled from: ActionEffectWhiteScreenObserver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "ActionEffectWhiteScreen";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0672a f26773a = null;

    /* JADX INFO: renamed from: com.obric.autogui.agents.a.o.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionEffectWhiteScreenObserver.kt */
    public static final class C0672a {
        public /* synthetic */ C0672a(h r1) {
            this();
        }

        private C0672a() {
        }
    }

    /* JADX INFO: compiled from: ActionEffectWhiteScreenObserver.kt */
    @f(b = "ActionEffectWhiteScreenObserver.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.whitescreen.ActionEffectWhiteScreenObserver$detectAndReport$2")
    static final class b extends l implements m<am, d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f26775b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f26776c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f26777d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.a.o.b f26778e;
        final /* synthetic */ String f;
        final /* synthetic */ long g;
        final /* synthetic */ long h;
        final /* synthetic */ long i;

        b(Bitmap r3, a r4, long r5, com.obric.autogui.agents.a.o.b r7, String r8, long r9, long r11, long r13, d<? super b> r15) {
            d r16 = (d) ZeusTransformUtils.wrapperContextForParams(r15, d.class, "com.obric.aiagent.plugin");
            this.f26775b = r3;
            this.f26776c = r4;
            this.f26777d = r5;
            this.f26778e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r11;
            this.i = r13;
            super(2, r16);
        }

        public final Object a(am r3, d<? super Boolean> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r18, d<?> r19) {
            d r16 = (d) ZeusTransformUtils.wrapperContextForParams(r19, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f26775b, this.f26776c, this.f26777d, this.f26778e, this.f, this.g, this.h, this.i, r16), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r30) {
            d.c.a.b.a();
            if (this.f26774a != 0) goto L50;
            o.a(r30);
            long r3 = AOSystemTools.INSTANCE.bootTimeMillis();
            boolean r0 = i.f31571a.b(this.f26775b);     // Catch: Throwable -> L33 Exception -> L35 CancellationException -> L43
            long r4 = a.a(this.f26776c, r3);     // Catch: Throwable -> L33 Exception -> L35 CancellationException -> L43
            long r13 = a.a(this.f26776c, this.f26777d);     // Catch: Throwable -> L33 Exception -> L35 CancellationException -> L43
            a r9 = this.f26776c;     // Catch: Throwable -> L33 Exception -> L35 CancellationException -> L43
            com.obric.autogui.agents.a.o.b r10 = this.f26778e;     // Catch: Throwable -> L33 Exception -> L35 CancellationException -> L43
            String r11 = this.f;     // Catch: Throwable -> L33 Exception -> L35 CancellationException -> L43
            if (r0 == false) goto L8;
            boolean r12 = true;
        L9:
            boolean r2 = a.a(r9, r10, r11, r12, this.g, this.h, this.i, r4, r13);     // Catch: Exception -> L31 Throwable -> L33 CancellationException -> L43
            Loog r5 = Loog.INSTANCE;     // Catch: Exception -> L31 Throwable -> L33 CancellationException -> L43
            StringBuilder r6 = new StringBuilder().append("[OAutoActionEffect] white screen detection completed ").append(a.a(this.f26776c, this.f26778e)).append(", context_source=session, screenshot_source=model_inference, screenshot_step_id=").append(com.obric.autogui.agents.a.b.a(this.f, 0, 1, null)).append(", is_white_screen=");     // Catch: Exception -> L31 Throwable -> L33 CancellationException -> L43
            if (r0 == false) goto L14;
            boolean r7 = true;
        L15:
            StringBuilder r8 = r6.append(r7).append(", queue_elapsed_ms=").append(this.g).append(", model_screenshot_capture_elapsed_ms=").append(n.a(this.h, 0)).append(", sample_prepare_elapsed_ms=").append(this.i).append(", detection_elapsed_ms=").append(r4).append(", total_elapsed_ms=").append(r13).append(", tracking_reported=");     // Catch: Exception -> L31 Throwable -> L33 CancellationException -> L43
            if (r2 == false) goto L18;
            boolean r14 = true;
        L19:
            String r15 = r8.append(r14).toString();     // Catch: Exception -> L31 Throwable -> L33 CancellationException -> L43
            String r16 = a.TAG;
            r5.i(r16, r15);     // Catch: Exception -> L29 Throwable -> L33 CancellationException -> L43
            if (r0 == false) goto L24;
            boolean r23 = true;
        L25:
            Boolean r17 = d.c.b.a.b.a(r23);     // Catch: Exception -> L29 Throwable -> L33 CancellationException -> L43
        L27:
            if (this.f26775b.isRecycled() == true) goto L57;
            this.f26775b.recycle();
            return r17;
        L57:
            return r17;
        L24:
            r23 = false;
        L29:
            e = e;
        L37:
            Loog.INSTANCE.w(r16, "[OAutoActionEffect] white screen detection failed " + a.a(this.f26776c, this.f26778e) + ", screenshot_step_id=" + com.obric.autogui.agents.a.b.a(this.f, 0, 1, null) + ", error_type=" + com.obric.autogui.agents.a.b.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")) + ", model_request_preserved=true");     // Catch: Throwable -> L33
            if (this.f26775b.isRecycled() == true) goto L42;
            this.f26775b.recycle();
        L42:
            return null;
        L18:
            r14 = false;
            goto L19
        L14:
            r7 = false;
        L31:
            e = e;
            r16 = a.TAG;
            goto L37
        L8:
            r12 = false;
        L33:
            th = move-exception;
            if (this.f26775b.isRecycled() == true) goto L48;
            this.f26775b.recycle();
        L48:
            throw th;
        L35:
            e = e;
            r16 = a.TAG;
        L43:
            e = move-exception;
            throw e;     // Catch: Throwable -> L33
        L50:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ActionEffectWhiteScreenObserver.kt */
    @f(b = "ActionEffectWhiteScreenObserver.kt", c = {91, 104}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.whitescreen.ActionEffectWhiteScreenObserver$observeAfterAction$1")
    static final class c extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f26779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f26780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26781c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f26782d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f26783e;
        final /* synthetic */ long f;
        final /* synthetic */ IScreenshot g;
        final /* synthetic */ String h;
        final /* synthetic */ String i;
        final /* synthetic */ long j;
        final /* synthetic */ com.obric.autogui.agents.a.o.b k;
        final /* synthetic */ w<Boolean> l;

        c(a r3, long r4, IScreenshot r6, String r7, String r8, long r9, com.obric.autogui.agents.a.o.b r11, w<Boolean> r12, d<? super c> r13) {
            IScreenshot r10 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r6, IScreenshot.class, "com.obric.aiagent.plugin");
            w<Boolean> r14 = (w) ZeusTransformUtils.wrapperContextForParams(r12, w.class, "com.obric.aiagent.plugin");
            d r15 = (d) ZeusTransformUtils.wrapperContextForParams(r13, d.class, "com.obric.aiagent.plugin");
            this.f26783e = r3;
            this.f = r4;
            this.g = r10;
            this.h = r7;
            this.i = r8;
            this.j = r9;
            this.k = r11;
            this.l = r14;
            super(2, r15);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r14, d<?> r15) {
            d r12 = (d) ZeusTransformUtils.wrapperContextForParams(r15, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new c(this.f26783e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, r12), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r32) {
            Object r2 = d.c.a.b.a();
            int r0 = this.f26782d;
            if (r0 == 0) goto L22;
            if (r0 == 1) goto L15;
            if (r0 != 2) goto L14;
            Bitmap r3 = (Bitmap) ZeusTransformUtils.preCheckCast(this.f26781c, Bitmap.class, "com.obric.aiagent.plugin");
            o.a(r32);     // Catch: Exception -> L9 CancellationException -> L11 Throwable -> L46
            Object r1 = r32;
        L39:
            this.l.a((Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.aiagent.plugin"));
        L60:
            return x.f38692a;
        L11:
            e = e;
        L63:
            if (r3 != null) goto L65;
        L70:
            throw e;     // Catch: Throwable -> L46
        L65:
            if ((!r3.isRecycled()) == false) goto L67;
            Bitmap r11 = r3;
        L68:
            if (r11 == null) goto L70;
            r11.recycle();     // Catch: Throwable -> L46
            goto L70
        L67:
            r11 = null;
        L9:
            e = e;
        L50:
            if (r3 != null) goto L52;
        L57:
            Loog.INSTANCE.w(a.TAG, "[OAutoActionEffect] white screen detection dispatch failed " + this.h + ", screenshot_step_id=" + com.obric.autogui.agents.a.b.a(this.i, 0, 1, null) + ", error_type=" + com.obric.autogui.agents.a.b.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")) + ", model_request_preserved=true");     // Catch: Throwable -> L46
            this.l.a(null);
            goto L60
        L52:
            if ((!r3.isRecycled()) == true) goto L55;
            r3 = null;
        L55:
            if (r3 == null) goto L57;
            r3.recycle();     // Catch: Throwable -> L46
            goto L57
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            long r12 = this.f26780b;
            long r14 = this.f26779a;
            o.a(r32);     // Catch: Exception -> L18 CancellationException -> L20 Throwable -> L46
            Object r4 = r32;
        L27:
            Bitmap r5 = (Bitmap) ZeusTransformUtils.preCheckCast(r4, Bitmap.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18 CancellationException -> L20 Throwable -> L46
        L74:
            if (r5 != null) goto L35;
            Loog.INSTANCE.w(a.TAG, "[OAutoActionEffect] white screen sample unavailable " + this.h + ", screenshot_step_id=" + com.obric.autogui.agents.a.b.a(this.i, 0, 1, null) + ", model_screenshot_capture_elapsed_ms=" + n.a(this.j, 0));     // Catch: Exception -> L41 CancellationException -> L43 Throwable -> L46
            x r6 = x.f38692a;     // Catch: Exception -> L41 CancellationException -> L43 Throwable -> L46
            this.l.a(null);
            return r6;
        L35:
            long r26 = a.a(this.f26783e, r12);     // Catch: Exception -> L41 CancellationException -> L43 Throwable -> L46
            a r7 = this.f26783e;     // Catch: Exception -> L41 CancellationException -> L43 Throwable -> L46
            com.obric.autogui.agents.a.o.b r8 = this.k;     // Catch: Exception -> L41 CancellationException -> L43 Throwable -> L46
            String r10 = this.i;     // Catch: Exception -> L41 CancellationException -> L43 Throwable -> L46
            long r13 = this.j;     // Catch: Exception -> L41 CancellationException -> L43 Throwable -> L46
            long r15 = this.f;     // Catch: Exception -> L41 CancellationException -> L43 Throwable -> L46
            d r30 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L41 CancellationException -> L43 Throwable -> L46
            this.f26781c = r5;     // Catch: Exception -> L41 CancellationException -> L43 Throwable -> L46
            this.f26782d = 2;     // Catch: Exception -> L41 CancellationException -> L43 Throwable -> L46
            r1 = a.a(r7, r8, r10, r5, r14, r13, r26, r15, r30);     // Catch: Exception -> L41 CancellationException -> L43 Throwable -> L46
            if (r1 != r2) goto L38;
            return r2;
        L38:
            r3 = r5;
        L43:
            e = e;
            r3 = r5;
        L41:
            e = e;
            r3 = r5;
            goto L50
        L22:
            o.a(r32);
            r14 = a.a(this.f26783e, this.f);     // Catch: Throwable -> L46 Exception -> L48 CancellationException -> L61
            r12 = AOSystemTools.INSTANCE.bootTimeMillis();     // Catch: Throwable -> L46 Exception -> L48 CancellationException -> L61
            a r9 = this.f26783e;     // Catch: Exception -> L18 CancellationException -> L20 Throwable -> L46
            IScreenshot r16 = this.g;     // Catch: Exception -> L18 CancellationException -> L20 Throwable -> L46
            d r17 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18 CancellationException -> L20 Throwable -> L46
            this.f26779a = r14;     // Catch: Exception -> L18 CancellationException -> L20 Throwable -> L46
            this.f26780b = r12;     // Catch: Exception -> L18 CancellationException -> L20 Throwable -> L46
            this.f26782d = 1;     // Catch: Exception -> L18 CancellationException -> L20 Throwable -> L46
            r4 = a.a(r9, r16, r17);     // Catch: Exception -> L18 CancellationException -> L20 Throwable -> L46
            if (r4 != r2) goto L27;
            return r2;
        L46:
            th = move-exception;
            this.l.a(null);
            throw th;
        L61:
            e = e;
            r3 = null;
        L48:
            e = e;
            r3 = null;
        L20:
            e = move-exception;
            throw e;     // Catch: Throwable -> L46 Exception -> L48 CancellationException -> L61
        L18:
            e = move-exception;
            long r18 = r12;
            Loog.INSTANCE.w(a.TAG, "[OAutoActionEffect] white screen sample copy failed " + this.h + ", screenshot_step_id=" + com.obric.autogui.agents.a.b.a(this.i, 0, 1, null) + ", error_type=" + com.obric.autogui.agents.a.b.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")) + ", model_request_preserved=true");     // Catch: Throwable -> L46 Exception -> L48 CancellationException -> L61
            r5 = null;
            r12 = r18;
            goto L74
        }
    }

    static {
        f26773a = new C0672a(null);
    }

    public static /* synthetic */ Bitmap lambda$DfV3sjiEeHAdYpjJCjA8Q3ujPnw(IScreenshot r0) {
        return a(r0);
    }

    public a() {
    }

    public static final /* synthetic */ long a(a r0, long r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ Object a(a r14, com.obric.autogui.agents.a.o.b r15, String r16, Bitmap r17, long r18, long r20, long r22, long r24, d r26) {
        return r14.a(r15, r16, r17, r18, r20, r22, r24, (d) ZeusTransformUtils.wrapperContextForParams(r26, d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, IScreenshot r3, d r4) {
        return r2.a((IScreenshot) ZeusTransformUtils.wrapperContextForParams(r3, IScreenshot.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(a r0, com.obric.autogui.agents.a.o.b r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ boolean a(a r0, com.obric.autogui.agents.a.o.b r1, String r2, boolean r3, long r4, long r6, long r8, long r10, long r12) {
        return r0.a(r1, r2, r3, r4, r6, r8, r10, r12);
    }

    public final void a(com.obric.autogui.session.a r18, IScreenshot r19, String r20, long r21) {
        IScreenshot r4 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r19, IScreenshot.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r18, SensitiveType.SESSION);
        d.h.b.o.e(r4, "screenshot");
        d.h.b.o.e(r20, "screenshotStepId");
        w r10 = y.a(null, 1, null);
        r r3 = t.f28523a.a(r18.b());
        if (r3 == null) goto L7;
        com.obric.autogui.agents.vlm.models.omni.l r5 = r3.e();
        if (r5 == null) goto L7;
        r5.a(r20, (au) ZeusTransformUtils.preCheckCast(r10, au.class, "com.obric.aiagent.plugin"));
    L7:
        com.obric.autogui.agents.a.o.b r9 = a(r18);
        if (r9 != null) goto L11;
        r10.a(null);
        return;
    L11:
        long r7 = AOSystemTools.INSTANCE.bootTimeMillis();
        String r6 = a(r9);
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] white screen detection dispatched " + r6 + ", context_source=session, screenshot_source=model_inference, screenshot_step_id=" + com.obric.autogui.agents.a.b.a(r20, 0, 1, null) + ", model_screenshot_capture_elapsed_ms=" + n.a(r21, 0));
        AOThreadingTools.INSTANCE.launchIOJob((m) ZeusTransformUtils.preCheckCast(new c(this, r7, r4, r6, r20, r21, r9, r10, null), m.class, "com.obric.aiagent.plugin"));
    }

    private final Object a(com.obric.autogui.agents.a.o.b r18, String r19, Bitmap r20, long r21, long r23, long r25, long r27, d<? super Boolean> r29) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r29, d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((g) ZeusTransformUtils.preCheckCast(bd.a(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new b(r20, this, r27, r18, r19, r21, r23, r25, null), m.class, "com.obric.aiagent.plugin"), r0);
    }

    private final Object a(IScreenshot r2, d<? super Bitmap> r3) {
        final IScreenshot r1 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r2, IScreenshot.class, "com.obric.aiagent.plugin");
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return r1.withResourcesLocked(new $$Lambda$a$DfV3sjiEeHAdYpjJCjA8Q3ujPnw(r1), r4);
    }

    private static final Bitmap a(IScreenshot r3) {
        IScreenshot r4 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r3, IScreenshot.class, "com.obric.aiagent.plugin");
        Bitmap r0 = r4.getBitmap();
        if (r4.isValid() == true) goto L5;
        return null;
    L5:
        if (r0.isRecycled() == false) goto L7;
        return null;
    L7:
        if (r0.getWidth() > 0) goto L9;
        return null;
    L9:
        if (r0.getHeight() <= 0) goto L30;
        Bitmap r5 = Bitmap.createScaledBitmap(r0, 128, 128, false);
        d.h.b.o.c(r5, "createScaledBitmap(...)");
        Bitmap r1 = r5.copy(Bitmap.Config.ARGB_8888, false);     // Catch: Throwable -> L18
        if (r5 != r0) goto L15;
    L17:
        return r1;
    L15:
        if (r5.isRecycled() == true) goto L17;
        r5.recycle();
    L18:
        th = move-exception;
        if (r5 != r0) goto L21;
    L23:
        throw th;
    L21:
        if (r5.isRecycled() == true) goto L23;
        r5.recycle();
        goto L23
    L30:
        return null;
    }

    private final boolean a(com.obric.autogui.agents.a.o.b r12, String r13, boolean r14, long r15, long r17, long r19, long r21, long r23) {
        IAutoActionTrackingApi r3 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L26
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L26
        r5.put(DBHelper.BATTERY_COL_SOURCE, "post_action");     // Catch: Exception -> L26
        r5.put("context_source", SensitiveType.SESSION);     // Catch: Exception -> L26
        r5.put("screenshot_source", "model_inference");     // Catch: Exception -> L26
        r5.put("screenshot_step_id", r13);     // Catch: Exception -> L26
        r5.put("session_id", r12.a());     // Catch: Exception -> L26
        r5.put("step_id", r12.b());     // Catch: Exception -> L26
        r5.put("action_type", r12.c());     // Catch: Exception -> L26
        String r6 = r12.d();     // Catch: Exception -> L26
        String r7 = null;
        if (r6 != null) goto L6;
    L11:
        String r8 = r12.e();     // Catch: Exception -> L26
        if (r8 != null) goto L14;
    L18:
        r5.put("multi_step_index", r12.f());     // Catch: Exception -> L26
        r5.put("multi_step_count", r12.g());     // Catch: Exception -> L26
        Integer r9 = r12.h();     // Catch: Exception -> L26
        if (r9 == null) goto L21;
        r5.put("execution_status_code", ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Exception -> L26
    L21:
        Boolean r10 = r12.i();     // Catch: Exception -> L26
        if (r10 == null) goto L24;
        r5.put("original_has_error", r10.booleanValue());     // Catch: Exception -> L26
    L24:
        r5.put("is_white_screen", r14);     // Catch: Exception -> L26
        r5.put("queue_elapsed_ms", r15);     // Catch: Exception -> L26
        r5.put("model_screenshot_capture_elapsed_ms", n.a(r17, 0));     // Catch: Exception -> L26
        r5.put("sample_prepare_elapsed_ms", r19);     // Catch: Exception -> L26
        r5.put("detection_elapsed_ms", r21);     // Catch: Exception -> L26
        r5.put("total_elapsed_ms", r23);     // Catch: Exception -> L26
        x r11 = x.f38692a;     // Catch: Exception -> L26
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3, "oauto_action_effect_white_screen", r5, false, false, null, 28, null);     // Catch: Exception -> L26
        return true;
    L14:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L16;
        r7 = r8;
    L16:
        if (r7 == null) goto L18;
        r5.put("log_id", r7);     // Catch: Exception -> L26
        goto L18
    L6:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L9;
        r6 = null;
    L9:
        if (r6 == null) goto L11;
        r5.put("tool_id", r6);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] white screen tracking failed " + a(r12) + ", is_white_screen=" + r14 + ", error_type=" + com.obric.autogui.agents.a.b.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        return false;
    }

    private final String a(com.obric.autogui.agents.a.o.b r6) {
        StringBuilder r5 = new StringBuilder().append("action=").append(com.obric.autogui.agents.a.b.a(r6.c(), 0, 1, null)).append(", step_id=").append(com.obric.autogui.agents.a.b.a(r6.b(), 0, 1, null)).append(", session_id=").append(com.obric.autogui.agents.a.b.a(r6.a(), 0, 1, null)).append(", tool_id=");
        String r0 = r6.d();
        String r4 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        StringBuilder r7 = r5.append(com.obric.autogui.agents.a.b.a(r0, 0, 1, null)).append(", log_id=");
        String r8 = r6.e();
        if (r8 == null) goto L10;
        r4 = r8;
    L10:
        return r7.append(com.obric.autogui.agents.a.b.a(r4, 0, 1, null)).toString();
    }

    private final com.obric.autogui.agents.a.o.b a(com.obric.autogui.session.a r20) {
        e r0 = (e) ZeusTransformUtils.preCheckCast(p.n(r20.p()), e.class, "com.obric.aiagent.plugin");
        Boolean r6 = null;
        if (r0 != null) goto L7;
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] white screen detection skipped session_id=" + com.obric.autogui.agents.a.b.a(r20.b(), 0, 1, null) + ", reason=no_executed_step");
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.autogui.agents.vlm.models.a.b.class) == false) goto L9;
        com.obric.autogui.agents.vlm.models.a.b r7 = (com.obric.autogui.agents.vlm.models.a.b) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.agents.vlm.models.a.b.class, "com.obric.aiagent.plugin");
    L11:
        if (r7 == null) goto L17;
        String r8 = r7.f();
        if (r8 == null) goto L17;
        String r9 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r9 == null) goto L17;
        String r10 = r9.toLowerCase(Locale.ROOT);
        d.h.b.o.c(r10, "toLowerCase(...)");
    L18:
        if (r10 != null) goto L20;
        r10 = "";
    L20:
        String r12 = r10;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L25;
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] white screen detection skipped session_id=" + com.obric.autogui.agents.a.b.a(r20.b(), 0, 1, null) + ", step_id=" + com.obric.autogui.agents.a.b.a(r0.W(), 0, 1, null) + ", reason=action_type_unavailable");
        return null;
    L25:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L27;
        com.obric.autogui.agents.vlm.models.impl.g r11 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
    L28:
        if (r11 == null) goto L30;
        com.obric.autogui.operator.g r13 = r11.t();
    L32:
        if (r13 != null) goto L35;
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] white screen detection skipped session_id=" + com.obric.autogui.agents.a.b.a(r20.b(), 0, 1, null) + ", step_id=" + com.obric.autogui.agents.a.b.a(r0.W(), 0, 1, null) + ", action=" + com.obric.autogui.agents.a.b.a(r12, 0, 1, null) + ", reason=step_result_unavailable");
        return null;
    L35:
        com.obric.autogui.operator.g.c r14 = r13.b();
        boolean r15 = r13.a();
        if (r14 != com.obric.autogui.operator.g.c.f29925d) goto L38;
    L42:
        boolean r16 = true;
    L44:
        if (ZeusTransformUtils.instanceOf(r0, j.class) == true) goto L80;
        if (r16 == false) goto L80;
        r r1 = t.f28523a.a(r20.b());
        if (r1 == null) goto L67;
        com.obric.autogui.agents.vlm.models.omni.l r3 = r1.e();
        if (r3 == null) goto L67;
        com.obric.autogui.agents.vlm.models.omni.intent.g r4 = r3.a();
        if (r4 == null) goto L67;
        com.obric.autogui.agents.vlm.models.omni.intent.j r5 = r4.c();
        if (r5 == null) goto L60;
        String r17 = r5.a();
        if (r17 == null) goto L60;
        String r18 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r18 == null) goto L60;
        String r19 = r18.toLowerCase(Locale.ROOT);
        d.h.b.o.c(r19, "toLowerCase(...)");
    L62:
        if (d.h.b.o.a(r19, r12) == true) goto L65;
        r4 = null;
    L65:
        if (r4 == null) goto L67;
        String r21 = r4.g();
    L68:
        boolean r22 = !ZeusTransformUtils.instanceOf(r13, com.obric.autogui.agents.a.j.c.class);
        String r110 = r20.b();
        String r111 = ((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).W();
        if (r1 == null) goto L71;
        String r112 = r1.b();
    L72:
        int r113 = ((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).N();
        int r114 = ((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).O();
        if (r22 == false) goto L75;
        Integer r115 = Integer.valueOf(r13.d());
    L76:
        if (r22 == false) goto L79;
        r6 = Boolean.valueOf(r15);
    L79:
        return new com.obric.autogui.agents.a.o.b(r110, r111, r12, r21, r112, r113, r114, r115, r6);
    L75:
        r115 = null;
        goto L76
    L71:
        r112 = null;
    L60:
        r19 = null;
    L67:
        r21 = null;
    L80:
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] white screen detection skipped session_id=" + com.obric.autogui.agents.a.b.a(r20.b(), 0, 1, null) + ", step_id=" + com.obric.autogui.agents.a.b.a(((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).W(), 0, 1, null) + ", action=" + com.obric.autogui.agents.a.b.a(r12, 0, 1, null) + ", phase=" + r14 + ", has_error=" + r15 + ", is_end_step=" + ZeusTransformUtils.instanceOf(r0, j.class) + ", reason=action_not_observable");
        return null;
    L38:
        if (r14 != com.obric.autogui.operator.g.c.f29924c) goto L41;
        if (r15 == true) goto L42;
    L41:
        r16 = false;
        goto L44
    L30:
        r13 = null;
        goto L32
    L27:
        r11 = null;
    L17:
        r10 = null;
        goto L18
    L9:
        r7 = null;
        goto L11
    }

    private final long a(long r3) {
        return n.a(AOSystemTools.INSTANCE.bootTimeMillis() - r3, 0);
    }
}
