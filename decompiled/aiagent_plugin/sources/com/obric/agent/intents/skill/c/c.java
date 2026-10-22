package com.obric.agent.intents.skill.c;

import android.os.SystemClock;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.manager.api.al;
import com.obric.aiagent.skill.ovirt.api.IOVirtService;
import com.obric.aiagent.skill.virt.api.x;
import com.obric.aiagent.skill.virt.api.y;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.k;
import d.n;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: ShellBashActionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.obric.agent.intents.skill.a.c<com.obric.agent.intents.skill.c.a, a> {
    private static final String TAG = "ShellBashActionExecutor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14909a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14910b = null;

    /* JADX INFO: compiled from: ShellBashActionExecutor.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("command")
        private final String f14911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("cwd")
        private final String f14912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("timeout_ms")
        private final Long f14913c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14911a, r6.f14911a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14912b, r6.f14912b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f14913c, r6.f14913c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r0 = this.f14911a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f14912b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Long r7 = this.f14913c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "BashActionRequest(command=" + this.f14911a + ", cwd=" + this.f14912b + ", timeoutMs=" + this.f14913c + ')';
        }

        public final String a() {
            return this.f14911a;
        }

        public final String b() {
            return this.f14912b;
        }

        public final Long c() {
            return this.f14913c;
        }
    }

    /* JADX INFO: compiled from: ShellBashActionExecutor.kt */
    private static abstract class b {

        /* JADX INFO: compiled from: ShellBashActionExecutor.kt */
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f14914a = null;

            static {
                f14914a = new a();
            }

            private a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.obric.agent.intents.skill.c.c$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ShellBashActionExecutor.kt */
        public static final class C0299b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final x f14915a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0299b.class) == true) goto L8;
                return false;
            L8:
                C0299b r6 = (C0299b) ZeusTransformUtils.preCheckCast(r5, C0299b.class, "com.obric.aiagent.plugin");
                if (o.a(this.f14915a, r6.f14915a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                x r0 = this.f14915a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public String toString() {
                return "Valid(path=" + this.f14915a + ')';
            }

            public C0299b(x r3) {
                x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.aiagent.plugin");
                super(null);
                this.f14915a = r4;
            }

            public final x a() {
                return this.f14915a;
            }
        }

        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.intents.skill.c.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShellBashActionExecutor.kt */
    @d.c.b.a.f(b = "ShellBashActionExecutor.kt", c = {221}, d = "awaitFirstResultOrPending", e = "com.obric.agent.intents.skill.systemshell.ShellBashActionExecutor")
    static final class C0300c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f14919d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f14920e;
        /* synthetic */ Object f;
        final /* synthetic */ c g;
        int h;

        C0300c(c r3, d.c.d<? super C0300c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            this.f = r9;
            this.h |= Integer.MIN_VALUE;
            return c.a(this.g, null, null, 0, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShellBashActionExecutor.kt */
    @d.c.b.a.f(b = "ShellBashActionExecutor.kt", c = {222}, d = "invokeSuspend", e = "com.obric.agent.intents.skill.systemshell.ShellBashActionExecutor$awaitFirstResultOrPending$firstResult$1")
    static final class d extends l implements m<am, d.c.d<? super com.obric.aiagent.skill.ovirt.api.b.b.a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.ovirt.api.b.b f14922b;

        d(com.obric.aiagent.skill.ovirt.api.b.b r3, d.c.d<? super d> r4) {
            com.obric.aiagent.skill.ovirt.api.b.b r5 = (com.obric.aiagent.skill.ovirt.api.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.skill.ovirt.api.b.b.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14922b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super com.obric.aiagent.skill.ovirt.api.b.b.a> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f14922b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.aiagent.skill.ovirt.api.b.b.a> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14921a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            com.obric.aiagent.skill.ovirt.api.b.b r6 = this.f14922b;
            d.c.d<? super com.obric.aiagent.skill.ovirt.api.b.b.a> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14921a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShellBashActionExecutor.kt */
    @d.c.b.a.f(b = "ShellBashActionExecutor.kt", c = {115}, d = "execute", e = "com.obric.agent.intents.skill.systemshell.ShellBashActionExecutor")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f14926d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f14927e;
        long f;
        /* synthetic */ Object g;
        final /* synthetic */ c h;
        int i;

        e(c r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return this.h.a2(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShellBashActionExecutor.kt */
    @d.c.b.a.f(b = "ShellBashActionExecutor.kt", c = {171}, d = "invokeSuspend", e = "com.obric.agent.intents.skill.systemshell.ShellBashActionExecutor$execute$2")
    static final class f extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DispatchContext f14929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.intents.skill.c.a f14930c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.ovirt.api.b.b f14931d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f14932e;
        final /* synthetic */ long f;
        private /* synthetic */ Object g;

        f(DispatchContext r3, com.obric.agent.intents.skill.c.a r4, com.obric.aiagent.skill.ovirt.api.b.b r5, long r6, long r8, d.c.d<? super f> r10) {
            com.obric.aiagent.skill.ovirt.api.b.b r7 = (com.obric.aiagent.skill.ovirt.api.b.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.skill.ovirt.api.b.b.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14929b = r3;
            this.f14930c = r4;
            this.f14931d = r7;
            this.f14932e = r6;
            this.f = r8;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r12, d.c.d<?> r13) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            f r14 = new f(this.f14929b, this.f14930c, this.f14931d, this.f14932e, this.f, r10);
            r14.g = r12;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r14, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14928a;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            d.o.a(r15);     // Catch: Throwable -> L15
        L13:
            Object r16 = n.f((IntentResult) ZeusTransformUtils.preCheckCast(r15, IntentResult.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        L17:
            com.obric.aiagent.skill.ovirt.api.b.b r2 = this.f14931d;
            com.obric.agent.intents.skill.c.a r3 = this.f14930c;
            long r6 = this.f;
            Throwable r4 = n.c(r16);
            if (r4 != null) goto L21;
        L25:
            AtomicCapabilitySdk.INSTANCE.updateIntentResult((IntentResult) ZeusTransformUtils.preCheckCast(r16, IntentResult.class, "com.obric.aiagent.plugin"), this.f14929b, true);
            return d.x.f38692a;
        L21:
            if (IAppContext.Companion.isDebug() == false) goto L23;
            ILogDepend.Companion.e(c.TAG, "bash async final failed executionId=" + r2.a(), r4);
        L24:
            j.e r17 = j.f15039a.a("START_FAILED", "operation failed", r2.a());
            c.a(c.f14909a, r3.b(), r6, -2002, r17);
            r16 = j.a(j.f15039a, r17, -2002, false, 4, null);
            goto L25
        L23:
            ILogDepend.Companion.e(c.TAG, "bash async final failed");
            goto L24
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r15);
            am r18 = (am) ZeusTransformUtils.preCheckCast(this.g, am.class, "com.obric.aiagent.plugin");
            com.obric.agent.intents.skill.c.a r5 = this.f14930c;
            com.obric.aiagent.skill.ovirt.api.b.b r7 = this.f14931d;
            long r8 = this.f14932e;
            long r9 = this.f;
            n.a r19 = n.f38560a;     // Catch: Throwable -> L15
            c r10 = c.f14909a;     // Catch: Throwable -> L15
            long r11 = d.l.n.a(r8 - (SystemClock.elapsedRealtime() - r9), 0);     // Catch: Throwable -> L15
            this.f14928a = 1;     // Catch: Throwable -> L15
            r15 = c.a(r10, r5, r7, r11, r9, this);     // Catch: Throwable -> L15
            if (r15 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            n.a r12 = n.f38560a;
            r16 = n.f(d.o.a(th));
            goto L17
        }
    }

    private final long a(long r5, long r7) {
        if ((Long.MAX_VALUE - r5) >= r7) goto L6;
        return Long.MAX_VALUE;
    L6:
        return r5 + r7;
    }

    private c() {
    }

    public static final /* synthetic */ Object a(c r10, com.obric.agent.intents.skill.c.a r11, com.obric.aiagent.skill.ovirt.api.b.b r12, long r13, long r15, d.c.d r17) {
        return r10.a(r11, (com.obric.aiagent.skill.ovirt.api.b.b) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.aiagent.skill.ovirt.api.b.b.class, "com.obric.aiagent.plugin"), r13, r15, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(c r0, String r1, long r2, int r4, j.e r5) {
        r0.a(r1, r2, r4, r5);
    }

    @Override // com.obric.agent.intents.skill.a.c
    public /* synthetic */ Object a(com.obric.agent.intents.skill.c.a r3, a r4, DispatchContext r5, d.c.d r6) {
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a2((com.obric.agent.intents.skill.c.a) ZeusTransformUtils.preCheckCast(r3, com.obric.agent.intents.skill.c.a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin"), r5, r7);
    }

    static {
        f14909a = new c();
        f14910b = "bash";
    }

    @Override // com.obric.agent.intents.skill.a.c
    public String a() {
        return f14910b;
    }

    public final com.obric.aiagent.skill.virt.api.m a(String r7, String r8) {
        o.e(r7, "actionType");
        o.e(r8, "actionArgs");
        if (o.a(r7, "bash") == false) goto L17;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L17;
        a r6 = (a) ZeusTransformUtils.preCheckCast(com.obric.agent.intents.skill.a.e.f14888a.a(r8, a.class, TAG), a.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L10;
        com.obric.aiagent.skill.virt.api.l r9 = com.obric.aiagent.skill.virt.api.l.f21577a;
        String r10 = r6.a();
        if (r10 != null) goto L15;
        r10 = "";
    L15:
        return r9.a(r10);
    L10:
        return new com.obric.aiagent.skill.virt.api.m(null, null, 0, 7, null);
    L17:
        return new com.obric.aiagent.skill.virt.api.m(null, null, 0, 7, null);
    }

    @Override // com.obric.agent.intents.skill.a.c
    public com.obric.agent.intents.skill.a.g<a> a(com.obric.agent.intents.skill.a.f r15) {
        o.e(r15, Ext.KEY_REQUEST);
        a r14 = (a) ZeusTransformUtils.preCheckCast(com.obric.agent.intents.skill.a.e.f14888a.a(r15.c(), a.class, TAG), a.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L5;
        String r16 = r14.a();
        if (r16 != null) goto L10;
        r16 = "";
    L10:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L14;
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.a(new IntentResult(-2004, null, null, "command is missing", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null)), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L14:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.b(r14), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L5:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.a(new IntentResult(103, null, null, "invalid bash actionArgs", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null)), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public Object a2(com.obric.agent.intents.skill.c.a r29, a r30, DispatchContext r31, d.c.d<? super IntentResult<Empty>> r32) {
        c r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r32, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, e.class) == false) goto L7;
        e r4 = (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.aiagent.plugin");
        if ((r4.i & Integer.MIN_VALUE) == 0) goto L7;
        r4.i -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.g;
        Object r5 = d.c.a.b.a();
        int r6 = r4.i;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        long r1 = r4.f;
        long r7 = r4.f14927e;
        com.obric.aiagent.skill.ovirt.api.b.a r9 = (com.obric.aiagent.skill.ovirt.api.b.a) ZeusTransformUtils.preCheckCast(r4.f14926d, com.obric.aiagent.skill.ovirt.api.b.a.class, "com.obric.aiagent.plugin");
        com.obric.agent.intents.skill.c.a r10 = (com.obric.agent.intents.skill.c.a) ZeusTransformUtils.preCheckCast(r4.f14925c, com.obric.agent.intents.skill.c.a.class, "com.obric.aiagent.plugin");
        DispatchContext r11 = (DispatchContext) ZeusTransformUtils.preCheckCast(r4.f14924b, DispatchContext.class, "com.obric.aiagent.plugin");
        c r8 = (c) ZeusTransformUtils.preCheckCast(r4.f14923a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        long r13 = r1;
        r0 = r8;
        com.obric.agent.intents.skill.c.a r12 = r10;
        DispatchContext r14 = r11;
    L46:
        com.obric.aiagent.skill.ovirt.api.d r15 = (com.obric.aiagent.skill.ovirt.api.d) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.ovirt.api.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, com.obric.aiagent.skill.ovirt.api.d.a.class) == false) goto L59;
        com.obric.aiagent.skill.ovirt.api.b.b.c r16 = ((com.obric.aiagent.skill.ovirt.api.d.a) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.ovirt.api.d.a.class, "com.obric.aiagent.plugin")).a();
        j.e r17 = j.f15039a.a(r16, ((com.obric.aiagent.skill.ovirt.api.d.a) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.ovirt.api.d.a.class, "com.obric.aiagent.plugin")).b());
        if (IAppContext.Companion.isDebug() == false) goto L55;
        ILogDepend.Companion r18 = ILogDepend.Companion;
        StringBuilder r19 = new StringBuilder().append("bash blocked uniqueId=").append(r12.b()).append(" executionId=");
        if (r16 == null) goto L53;
        String r20 = r16.a();
    L54:
        r18.w(TAG, r19.append(r20).append(" reason=").append(((com.obric.aiagent.skill.ovirt.api.d.a) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.ovirt.api.d.a.class, "com.obric.aiagent.plugin")).b()).toString());
    L56:
        r0.a(r12.b(), r7, 1001, r17);
        com.obric.agent.intents.skill.e.a.f15181a.a(r12.b(), r0.a(), "blocked", d.c.b.a.b.a(1001), "BLOCKED", com.obric.aiagent.skill.virt.api.l.f21577a.a(r9.a()));
        return j.a(j.f15039a, r17, 1001, false, 4, null);
    L53:
        r20 = null;
        goto L54
    L55:
        ILogDepend.Companion.w(TAG, "bash blocked");
        goto L56
    L59:
        if (ZeusTransformUtils.instanceOf(r15, com.obric.aiagent.skill.ovirt.api.d.c.class) == false) goto L63;
        kotlinx.coroutines.i.a(com.obric.agent.intents.skill.a.h.f14894a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new f(r14, r12, ((com.obric.aiagent.skill.ovirt.api.d.c) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.ovirt.api.d.c.class, "com.obric.aiagent.plugin")).a(), r13, r7, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return com.obric.agent.intents.skill.a.d.a("System_Shell action accepted");
    L63:
        if (ZeusTransformUtils.instanceOf(r15, com.obric.aiagent.skill.ovirt.api.d.b.class) == false) goto L65;
    L69:
        j.e r21 = j.a(j.f15039a, "START_FAILED", "operation failed", null, 4, null);
        r0.a(r12.b(), r7, -2002, r21);
        return j.a(j.f15039a, r21, -2002, false, 4, null);
    L65:
        if (ZeusTransformUtils.instanceOf(r15, com.obric.aiagent.skill.ovirt.api.d.C0441d.class) == true) goto L69;
        throw new k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r3);
        long r110 = SystemClock.elapsedRealtime();
        al r22 = al.f19195a.a();
        Long r23 = r30.c();
        if (r23 != null) goto L17;
    L25:
        long r111 = r22.r();
    L26:
        b r24 = r0.a(r29, r30.b());
        String r112 = "";
        if (ZeusTransformUtils.instanceOf(r24, b.a.class) == false) goto L34;
        ILogDepend.Companion.w(TAG, "bash rejected invalid cwd");
        com.obric.agent.intents.skill.e.a r113 = com.obric.agent.intents.skill.e.a.f15181a;
        String r114 = r29.b();
        String r115 = a();
        Integer r25 = d.c.b.a.b.a(103);
        com.obric.aiagent.skill.virt.api.l r26 = com.obric.aiagent.skill.virt.api.l.f21577a;
        String r27 = r30.a();
        if (r27 == null) goto L32;
        r112 = r27;
    L32:
        com.obric.agent.intents.skill.e.a.a(r113, r114, r115, null, r25, null, r26.a(r112), 20, null);
        return new IntentResult(103, null, null, "invalid cwd", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L34:
        String r116 = r30.a();
        if (r116 == null) goto L38;
        r112 = r116;
    L38:
        o.a(r24, "null cannot be cast to non-null type com.obric.agent.intents.skill.systemshell.ShellBashActionExecutor.WorkDirResolveResult.Valid");
        x r117 = ((b.C0299b) ZeusTransformUtils.preCheckCast(r24, b.C0299b.class, "com.obric.aiagent.plugin")).a();
        long r118 = r22.a(r111);
        Long r28 = d.c.b.a.b.a(r0.a(r110, r111));
        Map<String, String> r33 = r31.getExt();
        if (r33 == null) goto L41;
        String r210 = (String) ZeusTransformUtils.preCheckCast(r33.get("outbound_sensitive_data"), String.class, "com.obric.aiagent.plugin");
    L42:
        com.obric.aiagent.skill.ovirt.api.b.a r119 = new com.obric.aiagent.skill.ovirt.api.b.a(r112, r117, null, r118, null, r28, r111, r210, 4, null);
        IOVirtService.d r34 = r29.a().getShell();
        String r35 = r29.b();
        r4.f14923a = r0;
        r4.f14924b = r31;
        r4.f14925c = r29;
        r4.f14926d = r119;
        r4.f14927e = r110;
        r4.f = r111;
        r4.i = 1;
        Object r36 = r34.a(r35, r119, r4);
        if (r36 != r5) goto L45;
        return r5;
    L45:
        r9 = r119;
        r3 = r36;
        r7 = r110;
        r14 = r31;
        r12 = r29;
        r13 = r111;
        goto L46
    L41:
        r210 = null;
        goto L42
    L17:
        if (((Number) ZeusTransformUtils.preCheckCast(r23, Number.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L19;
        boolean r120 = true;
    L20:
        if (r120 == true) goto L23;
        r23 = null;
    L23:
        if (r23 == null) goto L25;
        r111 = r23.longValue();
        goto L26
    L19:
        r120 = false;
    L7:
        r4 = new e(r0, r2);
        goto L8
    }

    private final Object a(com.obric.agent.intents.skill.c.a r22, com.obric.aiagent.skill.ovirt.api.b.b r23, long r24, long r26, d.c.d<? super IntentResult<Empty>> r28) {
        c r0 = this;
        long r1 = r24;
        com.obric.aiagent.skill.ovirt.api.b.b r3 = (com.obric.aiagent.skill.ovirt.api.b.b) ZeusTransformUtils.wrapperContextForParams(r23, com.obric.aiagent.skill.ovirt.api.b.b.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, C0300c.class) == false) goto L7;
        C0300c r6 = (C0300c) ZeusTransformUtils.preCheckCast(r5, C0300c.class, "com.obric.aiagent.plugin");
        if ((r6.h & Integer.MIN_VALUE) == 0) goto L7;
        r6.h -= Integer.MIN_VALUE;
    L8:
        Object r7 = r6.f;
        Object r8 = d.c.a.b.a();
        int r9 = r6.h;
        if (r9 == 0) goto L14;
        if (r9 != 1) goto L13;
        long r2 = r6.f14920e;
        long r4 = r6.f14919d;
        com.obric.aiagent.skill.ovirt.api.b.b r10 = (com.obric.aiagent.skill.ovirt.api.b.b) ZeusTransformUtils.preCheckCast(r6.f14918c, com.obric.aiagent.skill.ovirt.api.b.b.class, "com.obric.aiagent.plugin");
        com.obric.agent.intents.skill.c.a r11 = (com.obric.agent.intents.skill.c.a) ZeusTransformUtils.preCheckCast(r6.f14917b, com.obric.agent.intents.skill.c.a.class, "com.obric.aiagent.plugin");
        c r12 = (c) ZeusTransformUtils.preCheckCast(r6.f14916a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
        long r13 = r2;
        r1 = r4;
        r0 = r12;
        r3 = r10;
    L17:
        com.obric.aiagent.skill.ovirt.api.b.b.a r14 = (com.obric.aiagent.skill.ovirt.api.b.b.a) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.ovirt.api.b.b.a.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L21;
        ILogDepend.Companion.i(TAG, "bash final uniqueId=" + r11.b() + " executionId=" + r14.a().a() + " exitCode=" + r14.a().g());
        j.e r15 = j.f15039a.a(r14);
        r0.a(r11.b(), r13, 0, r15);
        return j.a(j.f15039a, r15, 0, false, 6, null);
    L21:
        com.obric.aiagent.skill.ovirt.api.b.b.c r16 = r3.b();
        ILogDepend.Companion.i(TAG, "bash pending uniqueId=" + r11.b() + " executionId=" + r16.a() + " timeoutMs=" + r1);
        j.e r17 = j.a(j.f15039a, r16, "PENDING", null, null, 0, 0, 60, null);
        r0.a(r11.b(), r13, 0, r17);
        return j.a(j.f15039a, r17, 0, true, 2, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r7);
        m r18 = (m) ZeusTransformUtils.preCheckCast(new d(r3, null), m.class, "com.obric.aiagent.plugin");
        r6.f14916a = r0;
        r11 = r22;
        r6.f14917b = r11;
        r6.f14918c = r3;
        r6.f14919d = r1;
        r13 = r26;
        r6.f14920e = r13;
        r6.h = 1;
        r7 = dg.b(r1, r18, r6);
        if (r7 != r8) goto L17;
        return r8;
    L7:
        r6 = new C0300c(r0, r5);
        goto L8
    }

    private final void a(String r7, long r8, int r10, j.e r11) {
        com.obric.agent.intents.skill.e.a.f15181a.a(r7, SystemClock.elapsedRealtime() - r8, r10, r11);
    }

    private final b a(com.obric.agent.intents.skill.c.a r7, String r8) {
        if (r8 == null) goto L34;
        String r9 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r9 == null) goto L34;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r9 = null;
    L10:
        if (r9 == null) goto L34;
    L26:
        e = move-exception;
        if (IAppContext.Companion.isDebug() == false) goto L30;
        ILogDepend.Companion.w(TAG, "bash rejected malformed cwd value=" + r9, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L38:
        return (b) ZeusTransformUtils.preCheckCast(b.a.f14914a, b.class, "com.obric.aiagent.plugin");
    L30:
        ILogDepend.Companion.w(TAG, "bash rejected malformed cwd");
        goto L38
    L13:
        if (o.a(r9, "~") == false) goto L16;
        b r6 = (b) ZeusTransformUtils.preCheckCast(new b.C0299b((x) ZeusTransformUtils.preCheckCast(y.a(r7.c(), null, 1, null), x.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L26
    L35:
        return r6;
    L16:
        if (d.o.o.b(r9, "~/", false, 2, null) == false) goto L19;
        r6 = (b) ZeusTransformUtils.preCheckCast(new b.C0299b((x) ZeusTransformUtils.preCheckCast(r7.c().a(d.o.o.a(r9, (CharSequence) ZeusTransformUtils.preCheckCast("~/", CharSequence.class, "com.obric.aiagent.plugin"))), x.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L26
        goto L35
    L19:
        if (d.o.o.b(r9, "/", false, 2, null) == false) goto L24;
        com.obric.aiagent.skill.virt.api.a r0 = r7.c().c(r9);     // Catch: Exception -> L26
        if (b(r7, r0.a()) == false) goto L23;
        r6 = (b) ZeusTransformUtils.preCheckCast(new b.C0299b((x) ZeusTransformUtils.preCheckCast(r0, x.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L26
        goto L35
    L23:
        r6 = (b) ZeusTransformUtils.preCheckCast(b.a.f14914a, b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L26
        goto L35
    L24:
        r6 = (b) ZeusTransformUtils.preCheckCast(new b.C0299b((x) ZeusTransformUtils.preCheckCast(r7.c().a(r9), x.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L26
    L34:
        return (b) ZeusTransformUtils.preCheckCast(new b.C0299b(null), b.class, "com.obric.aiagent.plugin");
    }

    private final boolean b(com.obric.agent.intents.skill.c.a r5, String r6) {
        String r0 = a(r5.c().a().a());
        com.obric.aiagent.skill.virt.api.j r7 = r5.c().b();
        if (r7 == null) goto L7;
        String r8 = r7.a();
        if (r8 == null) goto L7;
        String r4 = a(r8);
    L9:
        if (o.a(r6, r0) == false) goto L11;
    L21:
        return true;
    L11:
        if (d.o.o.b(r6, r0 + '/', false, 2, null) == true) goto L21;
        if (r4 == null) goto L18;
        if (o.a(r6, r4) == true) goto L21;
        if (d.o.o.b(r6, r4 + '/', false, 2, null) == true) goto L21;
    L18:
        if (o.a(r6, "/tmp") == true) goto L21;
        if (d.o.o.b(r6, "/tmp/", false, 2, null) == true) goto L21;
        return false;
    L7:
        r4 = null;
        goto L9
    }

    private final String a(String r6) {
        if (r6.length() > 1) goto L5;
        return r6;
    L5:
        if (d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == true) goto L7;
        return r6;
    L7:
        return d.o.o.c(r6, new char[]{'/'});
    }
}
