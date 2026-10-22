package com.bytedance.safetyguard.lxc.internal.a;

import com.bytedance.safetyguard.lxc.api.SafetyGuardLogLevel;
import com.bytedance.safetyguard.lxc.api.SafetyGuardLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;

/* JADX INFO: compiled from: CallbackSafetyGuardLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b implements com.bytedance.safetyguard.lxc.internal.a.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SafetyGuardLogger f9709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.a.e f9710b;

    /* JADX INFO: compiled from: CallbackSafetyGuardLogger.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9711a = null;

        static {
            int[] r0 = new int[SafetyGuardLogLevel.values().length];
            r0[SafetyGuardLogLevel.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[SafetyGuardLogLevel.INFO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[SafetyGuardLogLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[SafetyGuardLogLevel.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f9711a = r0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CallbackSafetyGuardLogger.kt */
    static final class C0223b extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9712a;

        C0223b(String r1) {
            this.f9712a = r1;
            super(0);
        }

        public final String a() {
            return this.f9712a;
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CallbackSafetyGuardLogger.kt */
    static final class c extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9713a;

        c(String r1) {
            this.f9713a = r1;
            super(0);
        }

        public final String a() {
            return this.f9713a;
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CallbackSafetyGuardLogger.kt */
    static final class d extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9714a;

        d(String r1) {
            this.f9714a = r1;
            super(0);
        }

        public final String a() {
            return this.f9714a;
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CallbackSafetyGuardLogger.kt */
    static final class e extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9715a;

        e(String r1) {
            this.f9715a = r1;
            super(0);
        }

        public final String a() {
            return this.f9715a;
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    public b(SafetyGuardLogger r3, com.bytedance.safetyguard.lxc.internal.a.e r4) {
        SafetyGuardLogger r5 = (SafetyGuardLogger) ZeusTransformUtils.wrapperContextForParams(r3, SafetyGuardLogger.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.a.e r6 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        o.e(r5, "delegate");
        o.e(r6, "fallback");
        this.f9709a = r5;
        this.f9710b = r6;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.a.e
    public void a(String r3, d.h.a.a<String> r4) {
        d.h.a.a<String> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "tag");
        o.e(r5, "message");
        a(SafetyGuardLogLevel.DEBUG, r3, null, r5);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.a.e
    public void b(String r3, d.h.a.a<String> r4) {
        d.h.a.a<String> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "tag");
        o.e(r5, "message");
        a(SafetyGuardLogLevel.INFO, r3, null, r5);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.a.e
    public void a(String r3, Throwable r4, d.h.a.a<String> r5) {
        d.h.a.a<String> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "tag");
        o.e(r6, "message");
        a(SafetyGuardLogLevel.WARN, r3, r4, r6);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.a.e
    public void b(String r3, Throwable r4, d.h.a.a<String> r5) {
        d.h.a.a<String> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "tag");
        o.e(r6, "message");
        a(SafetyGuardLogLevel.ERROR, r3, r4, r6);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.a.e
    public String a(String r1) {
        return this.f9710b.a(r1);
    }

    private final void a(SafetyGuardLogLevel r11, String r12, Throwable r13, d.h.a.a<String> r14) {
        d.h.a.a r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");
        String r4 = f.a(r12);
        if (this.f9709a.isEnabled(r11, r4) == true) goto L22;
        return;
    L22:
        String r7 = com.bytedance.safetyguard.lxc.internal.a.c.a(((String) ZeusTransformUtils.preCheckCast(r15.invoke(), String.class, "com.obric.aiagent.plugin")) + com.bytedance.safetyguard.lxc.internal.a.c.b(r13));     // Catch: Throwable -> L12
        this.f9709a.log(r11, r4, r7);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        com.bytedance.safetyguard.lxc.internal.a.c.a(th);
        a(r11, r4, "log", th, r7);
        return;
    L12:
        th = move-exception;
        com.bytedance.safetyguard.lxc.internal.a.c.a(th);
        a(this, r11, r4, "message", th, null, 16, null);
        return;
    L15:
        th = move-exception;
        com.bytedance.safetyguard.lxc.internal.a.c.a(th);
        a(this, r11, r4, "is_enabled", th, null, 16, null);
    }

    static /* synthetic */ void a(b r6, SafetyGuardLogLevel r7, String r8, String r9, Throwable r10, String r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        r6.a(r7, r8, r9, r10, r11);
    }

    private final void a(SafetyGuardLogLevel r17, String r18, String r19, Throwable r20, String r21) {
        String r2 = com.bytedance.safetyguard.lxc.internal.a.c.a(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.e(new String[]{r21, "component=sdk_logging event=callback_failed outcome=fallback stage=" + r19 + " exceptionClass=" + com.bytedance.safetyguard.lxc.internal.a.c.c(r20)}), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));
        int r4 = a.f9711a[r17.ordinal()];     // Catch: Throwable -> L16
        if (r4 == 1) goto L14;
        if (r4 != 2) goto L7;
        this.f9710b.b(r18, (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r2), d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
    L19:
        return;
    L7:
        if (r4 != 3) goto L9;
        com.bytedance.safetyguard.lxc.internal.a.e.a.a(this.f9710b, r18, null, (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(r2), d.h.a.a.class, "com.obric.aiagent.plugin"), 2, null);     // Catch: Throwable -> L16
        goto L19
    L9:
        if (r4 != 4) goto L19;
        com.bytedance.safetyguard.lxc.internal.a.e.a.b(this.f9710b, r18, null, (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(r2), d.h.a.a.class, "com.obric.aiagent.plugin"), 2, null);     // Catch: Throwable -> L16
        goto L19
    L14:
        this.f9710b.a(r18, (d.h.a.a) ZeusTransformUtils.preCheckCast(new C0223b(r2), d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        com.bytedance.safetyguard.lxc.internal.a.c.a(th);
    }
}
