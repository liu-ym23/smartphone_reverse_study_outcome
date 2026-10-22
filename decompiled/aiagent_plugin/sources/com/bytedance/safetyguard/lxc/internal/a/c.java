package com.bytedance.safetyguard.lxc.internal.a;

import android.content.Context;
import com.bytedance.safetyguard.lxc.api.SafetyGuardLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.o.i;
import d.o.k;

/* JADX INFO: compiled from: CallbackSafetyGuardLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final k f9716a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final k f9717b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final k f9718c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final k f9719d = null;

    /* JADX INFO: compiled from: CallbackSafetyGuardLogger.kt */
    static final class a extends p implements d.h.a.b<i, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9720a = null;

        static {
            f9720a = new a();
        }

        a() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ CharSequence invoke(i r3) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"));
        }

        public final CharSequence a(i r3) {
            i r2 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
            o.e(r2, "match");
            return (CharSequence) ZeusTransformUtils.preCheckCast(((String) ZeusTransformUtils.preCheckCast(r2.d().get(1), String.class, "com.obric.aiagent.plugin")) + "=[REDACTED]", CharSequence.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: CallbackSafetyGuardLogger.kt */
    static final class b extends p implements d.h.a.b<i, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9721a = null;

        static {
            f9721a = new b();
        }

        b() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ CharSequence invoke(i r3) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"));
        }

        public final CharSequence a(i r3) {
            i r2 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
            o.e(r2, "match");
            return (CharSequence) ZeusTransformUtils.preCheckCast(((String) ZeusTransformUtils.preCheckCast(r2.d().get(1), String.class, "com.obric.aiagent.plugin")) + "[REDACTED]", CharSequence.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CallbackSafetyGuardLogger.kt */
    static final class C0224c extends p implements d.h.a.b<i, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0224c f9722a = null;

        static {
            f9722a = new C0224c();
        }

        C0224c() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ CharSequence invoke(i r3) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"));
        }

        public final CharSequence a(i r3) {
            i r2 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
            o.e(r2, "match");
            return (CharSequence) ZeusTransformUtils.preCheckCast(((String) ZeusTransformUtils.preCheckCast(r2.d().get(1), String.class, "com.obric.aiagent.plugin")) + " [REDACTED]", CharSequence.class, "com.obric.aiagent.plugin");
        }
    }

    public static final /* synthetic */ String c(Throwable r0) {
        return d(r0);
    }

    public static final e a(Context r3, SafetyGuardLogger r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        SafetyGuardLogger r6 = (SafetyGuardLogger) ZeusTransformUtils.wrapperContextForParams(r4, SafetyGuardLogger.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        com.bytedance.safetyguard.lxc.internal.a.a.C0222a r0 = com.bytedance.safetyguard.lxc.internal.a.a.f9703a;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "getApplicationContext(...)");
        com.bytedance.safetyguard.lxc.internal.a.a r8 = r0.a(r7);
        if (r6 != null) goto L6;
        return (e) ZeusTransformUtils.preCheckCast(r8, e.class, "com.obric.aiagent.plugin");
    L6:
        return (e) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.a.b(r6, (e) ZeusTransformUtils.preCheckCast(r8, e.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin");
    }

    public static final String a(String r4) {
        o.e(r4, "rawMessage");
        String r5 = f9716a.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), " ");
        String r6 = f9717b.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(a.f9720a, d.h.a.b.class, "com.obric.aiagent.plugin"));
        String r7 = f9718c.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(b.f9721a, d.h.a.b.class, "com.obric.aiagent.plugin"));
        return d.o.o.e(f9719d.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(C0224c.f9722a, d.h.a.b.class, "com.obric.aiagent.plugin")), 4096);
    }

    public static final void a(Throwable r2) {
        o.e(r2, "<this>");
        boolean r1 = true;
        if (ZeusTransformUtils.instanceOf(r2, VirtualMachineError.class) == false) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r1 = ZeusTransformUtils.instanceOf(r2, LinkageError.class);
    L9:
        if (r1 == true) goto L11;
        return;
    L11:
        throw r2;
    L5:
        r0 = ZeusTransformUtils.instanceOf(r2, ThreadDeath.class);
        goto L6
    }

    public static final String b(Throwable r3) {
        if (r3 != null) goto L5;
        return "";
    L5:
        Throwable r0 = r3.getCause();
        StringBuilder r1 = new StringBuilder();
        r1.append(" exceptionClass=");
        r1.append(d(r3));
        if (r0 == null) goto L9;
        if (r0 == r3) goto L9;
        r1.append(" causeClass=");
        r1.append(d(r0));
    L9:
        String r4 = r1.toString();
        o.c(r4, "toString(...)");
        return r4;
    }

    private static final String d(Throwable r3) {
        String r0 = r3.getClass().getSimpleName();
        o.a(r0);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L9;
        String r4 = r3.getClass().getName();
        o.c(r4, "getName(...)");
        return d.o.o.c(r4, '.', null, 2, null);
    L9:
        return r0;
    }

    static {
        f9716a = new k("[\\u0000-\\u001f\\u007f\\u0085\\u2028\\u2029]");
        f9717b = new k("(?i)\\b(Authorization|Proxy-Authorization|Cookie|Set-Cookie)\\b\\s*[:=].*$");
        f9718c = new k("(?i)(?<![A-Za-z0-9_])([\"']?(?:app_secret|client_secret|access_token|refresh_token|tenant_access_token|authorization_code|device_code|user_code)[\"']?\\s*[:=]\\s*)(?:\"(?:\\\\.|[^\"\\\\])*\"|'(?:\\\\.|[^'\\\\])*'|[^\\s,;}&]+)");
        f9719d = new k("(?i)\\b(Bearer|Basic)\\s+[A-Za-z0-9._~+/=-]+");
    }
}
