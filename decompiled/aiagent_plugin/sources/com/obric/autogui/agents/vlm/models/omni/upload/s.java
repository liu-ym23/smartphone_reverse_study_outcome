package com.obric.autogui.agents.vlm.models.omni.upload;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.obric.autogui.common.api.platform.display.capture.HeifScreenshotAttachment;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.OutputStream;
import java.util.Arrays;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: OmniUploadImageLogger.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s {
    private static final String TAG = "OmniUploadImageLogger";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f28827a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f28828b = null;

    /* JADX INFO: compiled from: OmniUploadImageLogger.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f28829a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f28829a == r6.f28829a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f28829a);
        }

        public String toString() {
            return "OmniUploadImageSaveResult(isNewFile=" + this.f28829a + ')';
        }

        public a(boolean r1) {
            this.f28829a = r1;
        }
    }

    /* JADX INFO: compiled from: OmniUploadImageLogger.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f28831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f28832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final File f28833d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f28830a, r6.f28830a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f28831b, r6.f28831b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f28832c, r6.f28832c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f28833d, r6.f28833d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f28830a.hashCode() * 31) + this.f28831b.hashCode()) * 31) + this.f28832c.hashCode()) * 31) + this.f28833d.hashCode();
        }

        public String toString() {
            return "UploadTarget(taskId=" + this.f28830a + ", toolId=" + this.f28831b + ", context=" + this.f28832c + ", journalDir=" + this.f28833d + ')';
        }

        public b(String r3, String r4, Context r5, File r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, DBDefinition.TASK_ID);
            d.h.b.o.e(r4, "toolId");
            d.h.b.o.e(r7, "context");
            d.h.b.o.e(r6, "journalDir");
            this.f28830a = r3;
            this.f28831b = r4;
            this.f28832c = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            this.f28833d = r6;
        }

        public final String a() {
            return this.f28830a;
        }

        public final String b() {
            return this.f28831b;
        }

        public final Context getContext() {
            return this.f28832c;
        }

        public final File c() {
            return this.f28833d;
        }
    }

    /* JADX INFO: compiled from: OmniUploadImageLogger.kt */
    @d.c.b.a.f(b = "OmniUploadImageLogger.kt", c = {144, 161}, d = "saveInferenceHeif", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniUploadImageLogger")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28836c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28837d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f28838e;
        Object f;
        int g;
        long h;
        /* synthetic */ Object i;
        final /* synthetic */ s j;
        int k;

        c(s r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.i = r7;
            this.k |= Integer.MIN_VALUE;
            return s.b(this.j, null, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniUploadImageLogger.kt */
    @d.c.b.a.f(b = "OmniUploadImageLogger.kt", c = {60}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniUploadImageLogger$saveInferenceScreenshot$4")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f28840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ScreenshotResult f28841c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f28842d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f28843e;
        final /* synthetic */ Closeable f;

        d(b r3, ScreenshotResult r4, String r5, int r6, Closeable r7, d.c.d<? super d> r8) {
            Closeable r9 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r7, Closeable.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28840b = r3;
            this.f28841c = r4;
            this.f28842d = r5;
            this.f28843e = r6;
            this.f = r9;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f28840b, this.f28841c, this.f28842d, this.f28843e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v4, types: [d.x, java.lang.Object] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28839a;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            d.o.a(r9);     // Catch: Throwable -> L7
        L15:
            this.f.close();
            d this = d.x.f38692a;
            return this;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r9);
            s r2 = s.f28827a;     // Catch: Throwable -> L7
            b r10 = this.f28840b;     // Catch: Throwable -> L7
            ScreenshotResult r3 = this.f28841c;     // Catch: Throwable -> L7
            String r4 = this.f28842d;     // Catch: Throwable -> L7
            int r5 = this.f28843e;     // Catch: Throwable -> L7
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            this.f28839a = 1;     // Catch: Throwable -> L7
            if (s.a(r2, r10, r3, r4, r5, r6) != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            this.f.close();
            throw th;
        }
    }

    /* JADX INFO: compiled from: OmniUploadImageLogger.kt */
    @d.c.b.a.f(b = "OmniUploadImageLogger.kt", c = {87, 116}, d = "saveInferenceScreenshotBlocking", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniUploadImageLogger")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28846c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28847d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f28848e;
        Object f;
        int g;
        long h;
        /* synthetic */ Object i;
        final /* synthetic */ s j;
        int k;

        e(s r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.i = r7;
            this.k |= Integer.MIN_VALUE;
            return s.a(this.j, null, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ q lambda$GSxvNuwQRrvyk5qgClTEmnKFye0() {
        return b();
    }

    public static /* synthetic */ a lambda$r3Pp4CT37tBeMsSJMSWFxXxGTFY(File r0, String r1, byte[] r2, String r3) {
        return a(r0, r1, r2, r3);
    }

    private s() {
    }

    public static final /* synthetic */ Object a(s r6, b r7, ScreenshotResult r8, String r9, int r10, d.c.d r11) {
        return r6.a(r7, r8, r9, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(s r6, b r7, ScreenshotResult r8, String r9, int r10, d.c.d r11) {
        return r6.b(r7, r8, r9, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f28827a = new s();
        f28828b = d.g.a($$Lambda$s$GSxvNuwQRrvyk5qgClTEmnKFye0.INSTANCE);
    }

    private final q a() {
        return (q) ZeusTransformUtils.preCheckCast(f28828b.b(), q.class, "com.obric.aiagent.plugin");
    }

    private static final q b() {
        return new q();
    }

    public final void a(com.obric.autogui.session.a r12, ScreenshotResult r13, String r14, int r15, String r16) {
        d.h.b.o.e(r12, SensitiveType.SESSION);
        d.h.b.o.e(r14, "stepId");
        if (com.obric.autogui.agents.vlm.models.omni.upload.d.a(r12, TAG) == true) goto L5;
        return;
    L5:
        String r3 = r12.b();
        String r5 = null;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L9;
        r3 = null;
    L9:
        if (r16 == null) goto L14;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L14;
        r5 = r16;
    L14:
        if (r3 == null) goto L37;
        if (r5 == null) goto L37;
        if (r13 == null) goto L19;
        b r4 = a(r12, r3, r5);
        if (r4 != null) goto L25;
        return;
    L25:
        Closeable r1 = v.f28855a.e(r3);
        if (r1 == null) goto L28;
        AOThreadingTools.INSTANCE.launchIO((d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r4, r13, r14, r15, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        r1.close();
        throw th;
    L28:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L43;
        Loog.INSTANCE.i(TAG, "skip saving image after producer barrier closed, taskId=" + r3);
        return;
    L43:
        return;
    L19:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L42;
        Loog.INSTANCE.w(TAG, "skip saving image, taskId=" + r3 + ", toolId=" + r5 + ", screenshot is null");
        return;
    L42:
        return;
    L37:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L44;
        Loog.INSTANCE.w(TAG, "skip saving image, taskId=" + r3 + ", toolId=" + r5);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.String] */
    private final Object a(b r27, ScreenshotResult r28, String r29, int r30, d.c.d<? super d.x> r31) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r31, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, e.class) == false) goto L7;
        e r2 = (e) ZeusTransformUtils.preCheckCast(r1, e.class, "com.obric.aiagent.plugin");
        if ((r2.k & Integer.MIN_VALUE) == 0) goto L7;
        r2.k -= Integer.MIN_VALUE;
    L8:
        e r8 = r2;
        Object r3 = r8.i;
        Object r9 = d.c.a.b.a();
        int r4 = r8.k;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 != 2) goto L18;
        long r5 = r8.h;
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(r8.f28846c, byte[].class, "com.obric.aiagent.plugin");
        z.f r6 = (z.f) ZeusTransformUtils.preCheckCast(r8.f28845b, z.f.class, "com.obric.aiagent.plugin");
        Bitmap r7 = (Bitmap) ZeusTransformUtils.preCheckCast(r8.f28844a, Bitmap.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L15
    L53:
        if (((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin")) == null) goto L55;
        long r10 = AOSystemTools.INSTANCE.nowTimeMillis();     // Catch: Throwable -> L15
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L63;
        Loog.INSTANCE.d(TAG, "fileName=" + ((String) ZeusTransformUtils.preCheckCast(r6.f38504a, String.class, "com.obric.aiagent.plugin")) + ", size=" + r0.length + ", l=" + (r10 - r5) + "ms");     // Catch: Throwable -> L15
    L63:
        r7.recycle();
        return d.x.f38692a;
    L55:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L57;
        Loog.INSTANCE.w(TAG, "failed to write image, fileName=" + ((String) ZeusTransformUtils.preCheckCast(r6.f38504a, String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L15
    L57:
        d.x r11 = d.x.f38692a;     // Catch: Throwable -> L15
        r7.recycle();
        return r11;
    L15:
        th = th;
    L73:
        OmniDataFeedbackLog.INSTANCE.e(TAG, "failed to save image, fileName=" + ((String) ZeusTransformUtils.preCheckCast(r6.f38504a, String.class, "com.obric.aiagent.plugin")), th);     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        r7.recycle();
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        int r12 = r8.g;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r8.f, String.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r8.f28848e, String.class, "com.obric.aiagent.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r8.f28847d, String.class, "com.obric.aiagent.plugin");
        ScreenshotResult r16 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r8.f28846c, ScreenshotResult.class, "com.obric.aiagent.plugin");
        b r17 = (b) ZeusTransformUtils.preCheckCast(r8.f28845b, b.class, "com.obric.aiagent.plugin");
        s r18 = (s) ZeusTransformUtils.preCheckCast(r8.f28844a, s.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        b r19 = r17;
    L27:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L29;
        String r110 = r13;
        String r20 = r15;
    L32:
        Bitmap r21 = r18.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r16);
        if (r21 == null) goto L35;
        r6 = new z.f();
        r6.f38504a = SensitiveType.UNKNOWN;
        com.obric.autogui.agents.vlm.models.omni.a.g r111 = (com.obric.autogui.agents.vlm.models.omni.a.g) ZeusTransformUtils.preCheckCast(r.f28823b, com.obric.autogui.agents.vlm.models.omni.a.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L64
        String r22 = String.format("%03d", Arrays.copyOf(new Object[]{d.c.b.a.b.a(r12)}, 1));     // Catch: Throwable -> L64
        d.h.b.o.c(r22, "format(...)");     // Catch: Throwable -> L64
        r6.f38504a = com.obric.autogui.agents.vlm.models.omni.a.g.a(r111, r22, r14, r110, r20, null, 16, null);     // Catch: Throwable -> L64
        long r23 = AOSystemTools.INSTANCE.nowTimeMillis();     // Catch: Throwable -> L64
        r0 = r18.a(r21);     // Catch: Throwable -> L64
        if (r0 == null) goto L43;
        File r24 = r19.c();     // Catch: Throwable -> L64
        String r112 = (String) ZeusTransformUtils.preCheckCast(r6.f38504a, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L64
        r8.f28844a = r21;     // Catch: Throwable -> L64
        r8.f28845b = r6;     // Catch: Throwable -> L64
        r8.f28846c = r0;     // Catch: Throwable -> L64
        r8.f28847d = null;     // Catch: Throwable -> L64
        r8.f28848e = null;     // Catch: Throwable -> L64
        r8.f = null;     // Catch: Throwable -> L64
        r8.h = r23;     // Catch: Throwable -> L64
        r8.k = 2;     // Catch: Throwable -> L64
        Object r25 = r18.a(r14, r24, r112, r0, r8);     // Catch: Throwable -> L64
        if (r25 != r9) goto L51;
        return r9;
    L51:
        r7 = r21;
        r3 = r25;
        r5 = r23;
        goto L53
    L43:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L45;
        Loog.INSTANCE.w(TAG, "failed to encode image, fileName=" + ((String) ZeusTransformUtils.preCheckCast(r6.f38504a, String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L64
    L45:
        d.x r26 = d.x.f38692a;     // Catch: Throwable -> L64
        r21.recycle();
        return r26;
    L64:
        th = th;
        r7 = r21;
        goto L73
    L35:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L38;
        Loog.INSTANCE.w(TAG, "skip saving image, taskId=" + r14 + ", toolId=" + r110 + ", status=" + r16.getStatus());
    L38:
        return d.x.f38692a;
    L29:
        return d.x.f38692a;
    L20:
        d.o.a(r3);
        String r113 = r27.a();
        r110 = r27.b();
        if (r28.getStatus() != ScreenshotResult.Status.Ok) goto L31;
        r8.f28844a = this;
        r19 = r27;
        r8.f28845b = r19;
        r8.f28846c = r28;
        r8.f28847d = r29;
        r8.f28848e = r113;
        r8.f = r110;
        r8.g = r30;
        r8.k = 1;
        r3 = b(r27, r28, r29, r30, r8);
        if (r3 != r9) goto L25;
        return r9;
    L25:
        r16 = r28;
        r15 = r29;
        r14 = r113;
        r13 = r110;
        r18 = this;
        r12 = r30;
        goto L27
    L31:
        r19 = r27;
        r16 = r28;
        r20 = r29;
        r14 = r113;
        r18 = this;
        r12 = r30;
    L7:
        r2 = new e(this, r1);
        goto L8
    }

    private final Object b(b r18, ScreenshotResult r19, String r20, int r21, d.c.d<? super Boolean> r22) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L7;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");
        if ((r3.k & Integer.MIN_VALUE) == 0) goto L7;
        r3.k -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.i;
        Object r4 = d.c.a.b.a();
        int r5 = r3.k;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L19;
        if (r5 != 2) goto L18;
        long r6 = r3.h;
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(r3.f28835b, byte[].class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r3.f28834a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L15
    L39:
        if (((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin")) == null) goto L41;
        long r8 = AOSystemTools.INSTANCE.nowTimeMillis();     // Catch: Throwable -> L15
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L48;
        Loog.INSTANCE.d(TAG, "heif reused, fileName=" + r7 + ", size=" + r0.length + ", l=" + (r8 - r6) + "ms");     // Catch: Throwable -> L15
    L48:
        boolean r9 = true;
    L53:
        return d.c.b.a.b.a(r9);
    L41:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L44;
        Loog.INSTANCE.w(TAG, "failed to write heif, fileName=" + r7);     // Catch: Throwable -> L15
    L44:
        return d.c.b.a.b.a(false);
    L15:
        th = th;
    L51:
        OmniDataFeedbackLog.INSTANCE.e(TAG, "failed to save heif, fileName=" + r7 + ", fallback to bitmap", th);
        r9 = false;
        goto L53
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        int r10 = r3.g;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r3.f, String.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r3.f28838e, String.class, "com.obric.aiagent.plugin");
        HeifScreenshotAttachment r13 = (HeifScreenshotAttachment) ZeusTransformUtils.preCheckCast(r3.f28837d, HeifScreenshotAttachment.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r3.f28836c, String.class, "com.obric.aiagent.plugin");
        b r15 = (b) ZeusTransformUtils.preCheckCast(r3.f28835b, b.class, "com.obric.aiagent.plugin");
        s r16 = (s) ZeusTransformUtils.preCheckCast(r3.f28834a, s.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L29:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L55;
        if (r13.isValid() == false) goto L55;
        r r17 = r.f28823b;
        String r23 = String.format("%03d", Arrays.copyOf(new Object[]{d.c.b.a.b.a(r10)}, 1));
        d.h.b.o.c(r23, "format(...)");
        String r24 = r17.a(r23, r12, r11, r14, ".heif");
        long r25 = AOSystemTools.INSTANCE.nowTimeMillis();
        r0 = d.f.k.c(r13.getFile());     // Catch: Throwable -> L49
        File r26 = r15.c();     // Catch: Throwable -> L49
        r3.f28834a = r24;     // Catch: Throwable -> L49
        r3.f28835b = r0;     // Catch: Throwable -> L49
        r3.f28836c = null;     // Catch: Throwable -> L49
        r3.f28837d = null;     // Catch: Throwable -> L49
        r3.f28838e = null;     // Catch: Throwable -> L49
        r3.f = null;     // Catch: Throwable -> L49
        r3.h = r25;     // Catch: Throwable -> L49
        r3.k = 2;     // Catch: Throwable -> L49
        Object r27 = r16.a(r12, r26, r24, r0, r3);     // Catch: Throwable -> L49
        if (r27 != r4) goto L37;
        return r4;
    L37:
        r6 = r25;
        r7 = r24;
        r2 = r27;
    L49:
        th = th;
        r7 = r24;
    L55:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L58;
        Loog.INSTANCE.w(TAG, "heif not ready, fallback to bitmap, taskId=" + r12 + ", toolId=" + r11);
    L58:
        return d.c.b.a.b.a(false);
    L20:
        d.o.a(r2);
        r13 = r19.getHeifAttachment();
        if (r13 == null) goto L23;
        String r28 = r18.a();
        r11 = r18.b();
        r3.f28834a = this;
        r3.f28835b = r18;
        r14 = r20;
        r3.f28836c = r14;
        r3.f28837d = r13;
        r3.f28838e = r28;
        r3.f = r11;
        r3.g = r21;
        r3.k = 1;
        Object r110 = r13.awaitEncodingComplete(r3);
        if (r110 != r4) goto L27;
        return r4;
    L27:
        r16 = this;
        r10 = r21;
        r15 = r18;
        r12 = r28;
        r2 = r110;
        goto L29
    L23:
        return d.c.b.a.b.a(false);
    L7:
        r3 = new c(this, r1);
        goto L8
    }

    private final b a(com.obric.autogui.session.a r6, String r7, String r8) {
        b r2 = null;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        File r9 = r6.y().b();     // Catch: Throwable -> L10
        if (r9 != null) goto L9;
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L13;
        Loog.INSTANCE.w(TAG, "skip saving image, taskId=" + r7 + ", toolId=" + r8 + ", journalDir is null");     // Catch: Throwable -> L10
    L13:
    L12:
        return r2;
    L9:
        r2 = new b(r7, r8, r1, r9);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        OmniDataFeedbackLog.INSTANCE.e(TAG, "failed to snapshot image target, taskId=" + r7 + ", toolId=" + r8, th);
        goto L12
    }

    private final Bitmap a(Context r7, ScreenshotResult r8) {
        Bitmap r6 = com.obric.autogui.agents.vlm.models.omni.intent.h.f28416a.a(r8, (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"));
        Bitmap r9 = null;
        if (r6 != null) goto L6;
        return null;
    L6:
        if (r6.isRecycled() == false) goto L9;
        return null;
    L9:
        if (r8.getStatus() != ScreenshotResult.Status.ContainsSecure) goto L11;
        boolean r0 = true;
    L32:
        r9 = r6.copy(Bitmap.Config.ARGB_8888, false);     // Catch: Throwable -> L17
        if (r0 == true) goto L15;
    L23:
        return r9;
    L15:
        if (r6.isRecycled() == true) goto L23;
    L16:
        r6.recycle();
    L17:
        th = move-exception;
        OmniDataFeedbackLog.INSTANCE.e(TAG, "copy screenshot failed, status=" + r8.getStatus(), th);     // Catch: Throwable -> L24
        if (r0 == false) goto L23;
        if (r6.isRecycled() == true) goto L23;
    L24:
        th = move-exception;
        if (r0 == true) goto L27;
    L29:
        throw th;
    L27:
        if (r6.isRecycled() == true) goto L29;
        r6.recycle();
        goto L29
    L11:
        r0 = false;
        goto L32
    }

    private final Object a(final String r2, final File r3, final String r4, final byte[] r5, d.c.d<? super a> r6) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return v.f28855a.a(r2, new $$Lambda$s$r3Pp4CT37tBeMsSJMSWFxXxGTFY(r3, r4, r5, r2), r1);
    }

    private static final a a(File r2, String r3, byte[] r4, String r5) {
        File r6 = r.f28823b.a(r2);
        if (r6.exists() == false) goto L5;
    L7:
        File r7 = d.f.k.a(r6, r3);
        n.a r8 = n.f28819a.a(r7, r4);
        if (r8 != null) goto L11;
        return null;
    L11:
        if (r8.a() == false) goto L14;
        f28827a.a().e(r5);
    L14:
        return new a(r8.a());
    L5:
        if (r6.mkdirs() == true) goto L7;
        return null;
    }

    private final byte[] a(Bitmap r6) {
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(new ByteArrayOutputStream(), Closeable.class, "com.obric.aiagent.plugin");
        ByteArrayOutputStream r0 = (ByteArrayOutputStream) ZeusTransformUtils.preCheckCast(r5, ByteArrayOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r6.compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream) ZeusTransformUtils.preCheckCast(r0, OutputStream.class, "com.obric.aiagent.plugin")) == false) goto L7;
        byte[] r7 = r0.toByteArray();     // Catch: Throwable -> L10
    L8:
        d.f.c.a(r5, null);
        return r7;
    L7:
        r7 = null;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        d.f.c.a(r5, th);
        throw th;
    }
}
