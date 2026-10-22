package com.obric.autogui.agents.vlm.models.omni.upload.a;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: OmniUploadReactViewTreeCallbackRegistrar.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "OmniReactViewTreeReg";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f28535a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f28536b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f28537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f28538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f28539e;
    private static final d.f f = null;

    /* JADX INFO: compiled from: OmniUploadReactViewTreeCallbackRegistrar.kt */
    @d.c.b.a.f(b = "OmniUploadReactViewTreeCallbackRegistrar.kt", c = {68}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.reactviewtree.OmniUploadReactViewTreeCallbackRegistrar$scheduleUnregisterForSession$1")
    static final class a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f28541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f28542c;

        a(String r3, long r4, d.c.d<? super a> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28541b = r3;
            this.f28542c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f28541b, this.f28542c, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28540a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L13:
            b.a(b.f28535a, this.f28541b, this.f28542c);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            long r3 = b.a(b.f28535a);
            if (r3 <= 0) goto L13;
            AOThreadingTools r9 = AOThreadingTools.INSTANCE;
            d.c.d<? super x> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28540a = 1;
            if (r9.delayForMillis(r3, r2) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: lambda$iXRtHiqc4-XeokOZ-yMBoBBh-CA, reason: not valid java name */
    public static /* synthetic */ com.obric.autogui.agents.vlm.models.omni.upload.a.a m781lambda$iXRtHiqc4XeokOZyMBoBBhCA() {
        return c();
    }

    private b() {
    }

    public static final /* synthetic */ long a(b r2) {
        return r2.b();
    }

    public static final /* synthetic */ void a(b r0, String r1, long r2) {
        r0.a(r1, r2);
    }

    static {
        f28535a = new b();
        f28536b = new Object();
        f = d.g.a($$Lambda$b$iXRtHiqc4XeokOZyMBoBBhCA.INSTANCE);
    }

    private final com.obric.autogui.agents.vlm.models.omni.upload.a.a a() {
        return (com.obric.autogui.agents.vlm.models.omni.upload.a.a) ZeusTransformUtils.preCheckCast(f.b(), com.obric.autogui.agents.vlm.models.omni.upload.a.a.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autogui.agents.vlm.models.omni.upload.a.a c() {
        return new com.obric.autogui.agents.vlm.models.omni.upload.a.a();
    }

    public final void a(String r6) {
        d.h.b.o.e(r6, ObricMemoryConstants.KEY_SESSION_ID);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
        return;
    L6:
        if (com.obric.autogui.common.a.h.f28984a.b() == false) goto L8;
        Object r5 = f28536b;
        monitor-enter(r5);
        long r0 = f28539e;     // Catch: Throwable -> L29
        b r2 = f28535a;     // Catch: Throwable -> L29
        f28539e = r0 + 1;     // Catch: Throwable -> L29
        if (f28537c == false) goto L20;
        String r1 = f28538d;     // Catch: Throwable -> L29
        f28538d = r6;     // Catch: Throwable -> L29
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L18;
        Loog.INSTANCE.i(TAG, "reuse inject-event callback, previousSessionId=" + r1 + ", sessionId=" + r6);     // Catch: Throwable -> L29
    L18:
        monitor-exit(r5);
        return;
    L20:
        boolean r3 = com.obric.autogui.platforms.tools.internal.a.g.f30334a.a((com.obric.framework.inputmethod.api.a) ZeusTransformUtils.preCheckCast(r2.a(), com.obric.framework.inputmethod.api.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L29
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L23;
        Loog.INSTANCE.i(TAG, "register inject-event callback, ok=" + r3 + ", sessionId=" + r6);     // Catch: Throwable -> L29
    L23:
        if (r3 == false) goto L25;
        f28537c = true;     // Catch: Throwable -> L29
        f28538d = r6;     // Catch: Throwable -> L29
    L26:
        x r7 = x.f38692a;     // Catch: Throwable -> L29
        monitor-exit(r5);
        return;
    L25:
        f28538d = null;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    L8:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L33;
        Loog.INSTANCE.i(TAG, "skip register, feature disabled, sessionId=" + r6);
        return;
    }

    public final void b(String r6) {
        d.h.b.o.e(r6, ObricMemoryConstants.KEY_SESSION_ID);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        Object r5 = f28536b;
        monitor-enter(r5);
        String r0 = f28538d;     // Catch: Throwable -> L21
        if (f28537c == false) goto L17;
        if (d.h.b.o.a(r0, r6) == false) goto L17;
        long r1 = f28539e + 1;     // Catch: Throwable -> L21
        f28539e = r1;     // Catch: Throwable -> L21
        monitor-exit(r5);
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new a(r6, r1, null), m.class, "com.obric.aiagent.plugin"));
        return;
    L17:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L19;
        Loog.INSTANCE.i(TAG, "skip schedule unregister, registeredSessionId=" + r0 + ", sessionId=" + r6);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r5);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    private final void a(String r6, long r7) {
        Object r5 = f28536b;
        monitor-enter(r5);
        String r0 = f28538d;     // Catch: Throwable -> L22
        if (f28537c == false) goto L18;
        if (d.h.b.o.a(r0, r6) == false) goto L18;
        if (f28539e != r7) goto L18;
        boolean r8 = com.obric.autogui.platforms.tools.internal.a.g.f30334a.b((com.obric.framework.inputmethod.api.a) ZeusTransformUtils.preCheckCast(f28535a.a(), com.obric.framework.inputmethod.api.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L14;
        Loog.INSTANCE.i(TAG, "unregister inject-event callback, ok=" + r8 + ", sessionId=" + r6);     // Catch: Throwable -> L22
    L14:
        f28537c = false;     // Catch: Throwable -> L22
        f28538d = null;     // Catch: Throwable -> L22
        f28539e++;     // Catch: Throwable -> L22
        monitor-exit(r5);
        return;
    L18:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L20;
        Loog.INSTANCE.i(TAG, "skip delayed unregister, registeredSessionId=" + r0 + ", sessionId=" + r6 + ", token=" + r7 + ", currentToken=" + f28539e);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r5);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    private final long b() {
        return com.obric.autogui.common.a.h.f28984a.d();
    }
}
