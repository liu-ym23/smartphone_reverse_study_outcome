package com.bytedance.safetyguard.lxc.internal.e.b;

import com.bytedance.safetyguard.lxc.api.SidecarAuthHandler;
import com.bytedance.safetyguard.lxc.api.SidecarAuthResponse;
import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar;
import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecarConfig;
import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecarInternal;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarAccountStatus;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarAppInfo;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarDeviceFlowCallback;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperationException;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarResult;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarSessionEnv;
import com.bytedance.safetyguard.lxc.api.sidecar.StartSidecarSessionRequest;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.oui.oswitch.SwitchCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.ce;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c implements SafetyGuardSidecar, SafetyGuardSidecarInternal, AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10547a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SafetyGuardSidecarConfig f10548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<Long> f10549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.e.i.b f10550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.e.a.l f10551e;
    private final com.bytedance.safetyguard.lxc.internal.e.h.b f;
    private final com.bytedance.safetyguard.lxc.internal.e.e.c g;
    private final com.bytedance.safetyguard.lxc.internal.a.e h;
    private final am i;
    private final com.bytedance.safetyguard.lxc.internal.e.g.b j;
    private final AtomicReference<com.bytedance.safetyguard.lxc.internal.e.b.b> k;
    private final AtomicLong l;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.b.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    /* synthetic */ class AnonymousClass1 extends d.h.b.l implements d.h.a.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f10552a = null;

        static {
            f10552a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        public final Long a() {
            return Long.valueOf(System.currentTimeMillis());
        }

        @Override // d.h.a.a
        public /* synthetic */ Long invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final String a(String r3) {
            d.h.b.o.e(r3, "prefix");
            return r3 + '-' + System.currentTimeMillis();
        }

        public final boolean b(String r2) {
            d.h.b.o.e(r2, "production");
            String r1 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            Locale r3 = Locale.US;
            d.h.b.o.c(r3, "US");
            String r4 = r1.toLowerCase(r3);
            d.h.b.o.c(r4, "toLowerCase(...)");
            switch(r4.hashCode()) {
                case -1278276362: goto L24;
                case -1243020381: goto L21;
                case 3179: goto L18;
                case 3668: goto L15;
                case 3314286: goto L12;
                case 94631255: goto L9;
                case 886643018: goto L6;
                default: goto L27;
            };
        L27:
            return false;
        L6:
            if (r4.equals("larksuite") == false) goto L27;
        L26:
            return true;
        L9:
            if (r4.equals("china") == true) goto L26;
        L12:
            if (r4.equals("lark") == false) goto L27;
        L15:
            if (r4.equals("sg") == true) goto L26;
        L18:
            if (r4.equals("cn") == true) goto L26;
        L21:
            if (r4.equals("global") == true) goto L26;
        L24:
            if (r4.equals("feishu") == true) goto L26;
            goto L26
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class aa extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SidecarResult f10554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f10555c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f10556d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.i.c f10557e;

        aa(String r1, SidecarResult r2, c r3, long r4, com.bytedance.safetyguard.lxc.internal.e.i.c r6) {
            this.f10553a = r1;
            this.f10554b = r2;
            this.f10555c = r3;
            this.f10556d = r4;
            this.f10557e = r6;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=sidecar event=" + this.f10553a + " outcome=failed code=" + this.f10554b.getCode() + " subcode=" + this.f10554b.getSubcode() + " subtype=" + this.f10554b.getSubtype() + " durationMs=" + (((Number) ZeusTransformUtils.preCheckCast(c.g(this.f10555c).invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() - this.f10556d) + " appRef=" + c.b(this.f10555c).a(this.f10557e.a());
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "DefaultSafetyGuardSidecar.kt", c = {439, 445}, d = "logout", e = "com.bytedance.safetyguard.lxc.internal.sidecar.core.DefaultSafetyGuardSidecar")
    static final class ab extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f10560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f10561d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f10562e;
        final /* synthetic */ c f;
        int g;

        ab(c r3, d.c.d<? super ab> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10562e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.logout((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class ac extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ac f10563a = null;

        static {
            f10563a = new ac();
        }

        ac() {
            super(0);
        }

        public final String a() {
            return "component=sidecar event=logout_started outcome=pending";
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class ad extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set<String> f10564a;

        ad(Set<String> r3) {
            this.f10564a = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            super(0);
        }

        public final String a() {
            return "component=sidecar event=grant_started outcome=pending scopeCount=" + this.f10564a.size();
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "DefaultSafetyGuardSidecar.kt", c = {397, 411}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.core.DefaultSafetyGuardSidecar$requestGrant$job$1")
    static final class ae extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f10566b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f10567c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.b.j f10568d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Set<String> f10569e;
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.b.h f;

        ae(c r3, long r4, com.bytedance.safetyguard.lxc.internal.e.b.j r6, Set<String> r7, com.bytedance.safetyguard.lxc.internal.e.b.h r8, d.c.d<? super ae> r9) {
            Set<String> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10566b = r3;
            this.f10567c = r4;
            this.f10568d = r6;
            this.f10569e = r10;
            this.f = r8;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((ae) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ae.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ae(this.f10566b, this.f10567c, this.f10568d, this.f10569e, this.f, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10565a;
            boolean r3 = true;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L9;
            d.o.a(r13);     // Catch: Throwable -> L12 CancellationException -> L14
        L38:
            return d.x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            d.o.a(r13);     // Catch: Throwable -> L12 CancellationException -> L14
        L20:
            com.bytedance.safetyguard.lxc.internal.e.i.c r14 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r13, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12 CancellationException -> L14
            if (r14 != null) goto L24;
            SidecarResult r15 = com.bytedance.safetyguard.lxc.internal.e.b.m.a(com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a, null, null, 3, null);     // Catch: Throwable -> L12 CancellationException -> L14
            c.a(this.f10566b, "grant_finished", r15, this.f10567c, null, null, null, 56, null);     // Catch: Throwable -> L12 CancellationException -> L14
            this.f10568d.a(r15);     // Catch: Throwable -> L12 CancellationException -> L14
            return d.x.f38692a;
        L24:
            String r6 = r14.d();     // Catch: Throwable -> L12 CancellationException -> L14
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12 CancellationException -> L14
            if (r2 != null) goto L27;
        L30:
            if (r3 == false) goto L33;
            SidecarResult r16 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.g(r14.a());     // Catch: Throwable -> L12 CancellationException -> L14
            c.a(this.f10566b, "grant_finished", r16, this.f10567c, null, null, null, 56, null);     // Catch: Throwable -> L12 CancellationException -> L14
            this.f10568d.a(r16);     // Catch: Throwable -> L12 CancellationException -> L14
            return d.x.f38692a;
        L33:
            c r4 = this.f10566b;     // Catch: Throwable -> L12 CancellationException -> L14
            String r17 = r14.a();     // Catch: Throwable -> L12 CancellationException -> L14
            Set<String> r5 = this.f10569e;     // Catch: Throwable -> L12 CancellationException -> L14
            com.bytedance.safetyguard.lxc.internal.e.b.j r7 = this.f10568d;     // Catch: Throwable -> L12 CancellationException -> L14
            com.bytedance.safetyguard.lxc.internal.e.b.h r8 = this.f;     // Catch: Throwable -> L12 CancellationException -> L14
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12 CancellationException -> L14
            this.f10565a = 2;     // Catch: Throwable -> L12 CancellationException -> L14
            if (c.a(r4, r17, r5, r7, r8, r6, "authorization", "grant_finished", r10) != r0) goto L38;
            return r0;
        L27:
            if (d.o.o.d(r2) == true) goto L30;
            r3 = false;
            goto L30
        L16:
            d.o.a(r13);
            com.bytedance.safetyguard.lxc.internal.e.i.b r18 = c.a(this.f10566b);     // Catch: Throwable -> L12 CancellationException -> L14
            d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.i.c> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12 CancellationException -> L14
            this.f10565a = 1;     // Catch: Throwable -> L12 CancellationException -> L14
            r13 = r18.a(r9);     // Catch: Throwable -> L12 CancellationException -> L14
            if (r13 != r0) goto L20;
            return r0;
        L14:
            e = move-exception;
            throw e;
        L12:
            th = move-exception;
            c.a(this.f10566b, "authorization", "grant_finished", this.f10567c, this.f10568d, th);
            goto L38
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "DefaultSafetyGuardSidecar.kt", c = {761}, d = "resolveAppId", e = "com.bytedance.safetyguard.lxc.internal.sidecar.core.DefaultSafetyGuardSidecar")
    static final class af extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f10570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f10571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f10572c;

        af(c r3, d.c.d<? super af> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10571b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10570a = r3;
            this.f10572c |= Integer.MIN_VALUE;
            return c.a(this.f10571b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "DefaultSafetyGuardSidecar.kt", c = {484, 496}, d = "startSession", e = "com.bytedance.safetyguard.lxc.internal.sidecar.core.DefaultSafetyGuardSidecar")
    static final class ag extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f10575c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f10576d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f10577e;
        /* synthetic */ Object f;
        final /* synthetic */ c g;
        int h;

        ag(c r3, d.c.d<? super ag> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.startSession(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class ah extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ah f10578a = null;

        static {
            f10578a = new ah();
        }

        ah() {
            super(0);
        }

        public final String a() {
            return "component=sidecar event=session_started outcome=pending";
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class ai extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f10580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.i.c f10581c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SidecarSessionEnv f10582d;

        ai(c r1, long r2, com.bytedance.safetyguard.lxc.internal.e.i.c r4, SidecarSessionEnv r5) {
            this.f10579a = r1;
            this.f10580b = r2;
            this.f10581c = r4;
            this.f10582d = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=sidecar event=session_finished outcome=success operation=start code=200 subcode=null subtype=session_started durationMs=" + (((Number) ZeusTransformUtils.preCheckCast(c.g(this.f10579a).invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() - this.f10580b) + " appRef=" + c.b(this.f10579a).a(this.f10581c.a()) + " sessionRef=" + c.b(this.f10579a).a(this.f10582d.getSessionId());
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "DefaultSafetyGuardSidecar.kt", c = {462, 465}, d = "status", e = "com.bytedance.safetyguard.lxc.internal.sidecar.core.DefaultSafetyGuardSidecar")
    static final class aj extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f10584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f10585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f10586d;

        aj(c r3, d.c.d<? super aj> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10585c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10584b = r3;
            this.f10586d |= Integer.MIN_VALUE;
            return this.f10585c.status((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10587a = null;

        static {
            int[] r0 = new int[com.bytedance.safetyguard.lxc.internal.e.b.n.values().length];
            r0[com.bytedance.safetyguard.lxc.internal.e.b.n.f10706a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[com.bytedance.safetyguard.lxc.internal.e.b.n.f10707b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[com.bytedance.safetyguard.lxc.internal.e.b.n.f10708c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f10587a = r0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.b.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class C0237c implements com.bytedance.safetyguard.lxc.internal.e.d.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10588a;

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.b.c$c$a */
        /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
        @d.c.b.a.f(b = "DefaultSafetyGuardSidecar.kt", c = {560, 562}, d = "handle", e = "com.bytedance.safetyguard.lxc.internal.sidecar.core.DefaultSafetyGuardSidecar$authHandlerInternal$1")
        static final class a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f10589a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f10590b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f10591c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ C0237c f10592d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f10593e;

            a(C0237c r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f10592d = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f10591c = r3;
                this.f10593e |= Integer.MIN_VALUE;
                return this.f10592d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        C0237c(c r1) {
            this.f10588a = r1;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.e.d.d
        public final Object a(com.bytedance.safetyguard.lxc.internal.e.d.c r7, d.c.d<? super SidecarAuthResponse> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r9, a.class) == false) goto L7;
            a r0 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
            if ((r0.f10593e & Integer.MIN_VALUE) == 0) goto L7;
            r0.f10593e -= Integer.MIN_VALUE;
        L8:
            Object r10 = r0.f10591c;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f10593e;
            if (r3 == 0) goto L21;
            if (r3 == 1) goto L18;
            if (r3 != 2) goto L17;
            d.o.a(r10);     // Catch: com.bytedance.safetyguard.lxc.internal.e.h.a -> L14
        L40:
            return (SidecarAuthResponse) ZeusTransformUtils.preCheckCast(r10, SidecarAuthResponse.class, "com.obric.aiagent.plugin");
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            r7 = (com.bytedance.safetyguard.lxc.internal.e.d.c) ZeusTransformUtils.preCheckCast(r0.f10590b, com.bytedance.safetyguard.lxc.internal.e.d.c.class, "com.obric.aiagent.plugin");
            C0237c this = (C0237c) ZeusTransformUtils.preCheckCast(r0.f10589a, C0237c.class, "com.obric.aiagent.plugin");
            d.o.a(r10);     // Catch: com.bytedance.safetyguard.lxc.internal.e.h.a -> L14
        L27:
            String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");     // Catch: com.bytedance.safetyguard.lxc.internal.e.h.a -> L14
            if (r11 == null) goto L30;
            com.bytedance.safetyguard.lxc.internal.e.e.c r6 = c.f(this.f10588a);     // Catch: com.bytedance.safetyguard.lxc.internal.e.h.a -> L14
            r0.f10589a = null;     // Catch: com.bytedance.safetyguard.lxc.internal.e.h.a -> L14
            r0.f10590b = null;     // Catch: com.bytedance.safetyguard.lxc.internal.e.h.a -> L14
            r0.f10593e = 2;     // Catch: com.bytedance.safetyguard.lxc.internal.e.h.a -> L14
            r10 = r6.a(r7, r11, r0);     // Catch: com.bytedance.safetyguard.lxc.internal.e.h.a -> L14
            if (r10 != r2) goto L40;
            return r2;
        L30:
            return com.bytedance.safetyguard.lxc.internal.e.b.k.f10703a.b();
        L21:
            d.o.a(r10);
            if (r7.i().length > c.d(this.f10588a).getMaxRequestBodyBytes()) goto L39;
            com.bytedance.safetyguard.lxc.internal.e.h.b r12 = c.e(this.f10588a);     // Catch: com.bytedance.safetyguard.lxc.internal.e.h.a -> L14
            r0.f10589a = this;     // Catch: com.bytedance.safetyguard.lxc.internal.e.h.a -> L14
            r0.f10590b = r7;     // Catch: com.bytedance.safetyguard.lxc.internal.e.h.a -> L14
            r0.f10593e = 1;     // Catch: com.bytedance.safetyguard.lxc.internal.e.h.a -> L14
            r10 = r12.a(r7, r0);     // Catch: com.bytedance.safetyguard.lxc.internal.e.h.a -> L14
            if (r10 != r2) goto L27;
            return r2;
        L39:
            return com.bytedance.safetyguard.lxc.internal.e.b.k.f10703a.d();
        L14:
            e = move-exception;
            return com.bytedance.safetyguard.lxc.internal.e.b.k.f10703a.a(e);
        L7:
            r0 = new a(this, r9);
            goto L8
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class d extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SidecarResult f10595b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f10596c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f10597d;

        d(String r1, SidecarResult r2, c r3, long r4) {
            this.f10594a = r1;
            this.f10595b = r2;
            this.f10596c = r3;
            this.f10597d = r4;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=sidecar event=" + this.f10594a + " outcome=failed code=" + this.f10595b.getCode() + " subcode=" + this.f10595b.getSubcode() + " subtype=" + this.f10595b.getSubtype() + " durationMs=" + (((Number) ZeusTransformUtils.preCheckCast(c.g(this.f10596c).invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() - this.f10597d) + " appRef=empty";
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class e extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10598a;

        e(String r1) {
            this.f10598a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=sidecar event=app_config_started outcome=pending operation=create production=" + this.f10598a;
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class f extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f10600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f10601c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.b.b f10602d;

        f(c r1, AtomicBoolean r2, long r3, com.bytedance.safetyguard.lxc.internal.e.b.b r5) {
            this.f10599a = r1;
            this.f10600b = r2;
            this.f10601c = r3;
            this.f10602d = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            c.a(this.f10599a, this.f10600b, "app_config_finished", com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.h(), this.f10601c, "create", null, null, 96, null);
            c.b(this.f10599a, this.f10602d);
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "DefaultSafetyGuardSidecar.kt", c = {92, 110, 112, IdlErrors.E_RejectInferDeviceOverheat}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.core.DefaultSafetyGuardSidecar$configCreateApp$job$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f10604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f10605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f10606d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f10607e;
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.b.j f;
        final /* synthetic */ String g;
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.b.b h;
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.b.h i;

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.b.c$g$1, reason: invalid class name */
        /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.a<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10608a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SidecarBrand f10609b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ c f10610c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.b.b f10611d;

            AnonymousClass1(String r1, SidecarBrand r2, c r3, com.bytedance.safetyguard.lxc.internal.e.b.b r4) {
                this.f10608a = r1;
                this.f10609b = r2;
                this.f10610c = r3;
                this.f10611d = r4;
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ String invoke() {
                return a();
            }

            public final String a() {
                return "component=sidecar event=app_registration_started outcome=pending production=" + this.f10608a + " bootstrapBrand=" + this.f10609b.name() + " operationRef=" + c.b(this.f10610c).a(this.f10611d.a());
            }
        }

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.b.c$g$2, reason: invalid class name */
        /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
        @d.c.b.a.f(b = "DefaultSafetyGuardSidecar.kt", c = {120}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.core.DefaultSafetyGuardSidecar$configCreateApp$job$1$2")
        static final class AnonymousClass2 extends d.c.b.a.l implements d.h.a.b<d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f10612a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f10613b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.i f10614c;

            AnonymousClass2(c r3, com.bytedance.safetyguard.lxc.internal.e.a.i r4, d.c.d<? super AnonymousClass2> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f10613b = r3;
                this.f10614c = r4;
                super(1, r6);
            }

            public final Object a(d.c.d<? super d.x> r3) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f10613b, this.f10614c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super d.x> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r12) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f10612a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r12);
            L12:
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r12);
                com.bytedance.safetyguard.lxc.internal.e.i.b r13 = c.a(this.f10613b);
                com.bytedance.safetyguard.lxc.internal.e.i.c r2 = new com.bytedance.safetyguard.lxc.internal.e.i.c(this.f10614c.a(), this.f10614c.b(), this.f10614c.d(), null, null, 24, null);
                d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f10612a = 1;
                if (r13.a(r2, r3) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
        static final class a extends d.h.b.p implements d.h.a.a<SidecarResult> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f10615a = null;

            static {
                f10615a = new a();
            }

            a() {
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ SidecarResult invoke() {
                return a();
            }

            public final SidecarResult a() {
                return com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.b("app registration failed");
            }
        }

        g(c r3, AtomicBoolean r4, long r5, com.bytedance.safetyguard.lxc.internal.e.b.j r7, String r8, com.bytedance.safetyguard.lxc.internal.e.b.b r9, com.bytedance.safetyguard.lxc.internal.e.b.h r10, d.c.d<? super g> r11) {
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10605c = r3;
            this.f10606d = r4;
            this.f10607e = r5;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            super(2, r12);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r12, d.c.d<?> r13) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f10605c, this.f10606d, this.f10607e, this.f, this.g, this.h, this.i, r10), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r25) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f10604b;
            boolean r6 = true;
            com.bytedance.safetyguard.lxc.internal.e.a.m r7 = null;
            if (r2 != 0) goto L86;
            d.o.a(r25);
            com.bytedance.safetyguard.lxc.internal.e.i.b r3 = c.a(this.f10605c);     // Catch: Throwable -> L27 CancellationException -> L29
            d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.i.c> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27 CancellationException -> L29
            this.f10604b = 1;     // Catch: Throwable -> L27 CancellationException -> L29
            Object r4 = r3.a(r9);     // Catch: Throwable -> L27 CancellationException -> L29
            if (r4 != r0) goto L35;
            return r0;
        L35:
            if (r4 == null) goto L40;
            SidecarResult r1 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.g();     // Catch: Throwable -> L27 CancellationException -> L29
            c.a(this.f10605c, this.f10606d, "app_config_finished", r1, this.f10607e, "create", null, null, 96, null);     // Catch: Throwable -> L27 CancellationException -> L29
            this.f.a(r1);     // Catch: Throwable -> L27 CancellationException -> L29
            d.x r5 = d.x.f38692a;     // Catch: Throwable -> L27 CancellationException -> L29
        L37:
            c.b(this.f10605c, this.h);
            return r5;
        L40:
            if (c.a().b(this.g) == true) goto L42;
            SidecarResult r8 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.a();     // Catch: Throwable -> L27 CancellationException -> L29
            c.a(this.f10605c, this.f10606d, "app_config_finished", r8, this.f10607e, "create", null, null, 96, null);     // Catch: Throwable -> L27 CancellationException -> L29
            this.f.a(r8);     // Catch: Throwable -> L27 CancellationException -> L29
            r5 = d.x.f38692a;     // Catch: Throwable -> L27 CancellationException -> L29
            goto L37
        L42:
            SidecarBrand r10 = SidecarBrand.FEISHU;     // Catch: Throwable -> L27 CancellationException -> L29
            c.b(this.f10605c).a("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.g, r10, this.f10605c, this.h), d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            com.bytedance.safetyguard.lxc.internal.e.a.l r11 = c.c(this.f10605c);     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.f> r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            this.f10603a = r10;     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            this.f10604b = 2;     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            Object r13 = r11.a(r10, r12);     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            if (r13 == r0) goto L45;
        L24:
            SidecarBrand r14 = r10;
            com.bytedance.safetyguard.lxc.internal.e.a.f r15 = (com.bytedance.safetyguard.lxc.internal.e.a.f) ZeusTransformUtils.preCheckCast(r13, com.bytedance.safetyguard.lxc.internal.e.a.f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            this.f.a(r15.b(), r15.c());     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            com.bytedance.safetyguard.lxc.internal.e.a.l r16 = c.c(this.f10605c);     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            String r17 = r15.a();     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            int r18 = r15.d();     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            int r19 = r15.c();     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            d.c.d<? super com.bytedance.safetyguard.lxc.internal.e.a.i> r110 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            this.f10603a = null;     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            this.f10604b = 3;     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            Object r20 = r16.a(r14, r17, r18, r19, r110);     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            if (r20 != r0) goto L49;
            return r0;
        L49:
            com.bytedance.safetyguard.lxc.internal.e.a.i r21 = (com.bytedance.safetyguard.lxc.internal.e.a.i) ZeusTransformUtils.preCheckCast(r20, com.bytedance.safetyguard.lxc.internal.e.a.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            if (c.a(this.f10605c, this.h) == true) goto L52;
            r5 = d.x.f38692a;     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            goto L37
        L52:
            com.bytedance.safetyguard.lxc.internal.e.b.h r22 = this.i;     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            d.h.a.b<? super d.c.d<? super d.x>, ? extends Object> r23 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f10605c, r21, null), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            d.c.d<? super Boolean> r24 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            this.f10603a = r21;     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            this.f10604b = 4;     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            Object r26 = r22.a(r23, r24);     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            if (r26 != r0) goto L55;
            return r0;
        L55:
            com.bytedance.safetyguard.lxc.internal.e.a.i r27 = r21;
        L57:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r26, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L59;
            r5 = d.x.f38692a;     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            goto L37
        L59:
            SidecarResult r28 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.a(r27.a(), r27.d(), r27.c());     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            c.a(this.f10605c, this.f10606d, "app_config_finished", r28, this.f10607e, "create", null, null, 96, null);     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            this.f.a(r28);     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
        L79:
            c.b(this.f10605c, this.h);
            return d.x.f38692a;
        L45:
            return r0;
        L86:
            if (r2 == 1) goto L25;
            if (r2 == 2) goto L21;
            if (r2 == 3) goto L13;
            if (r2 != 4) goto L12;
            r27 = (com.bytedance.safetyguard.lxc.internal.e.a.i) ZeusTransformUtils.preCheckCast(this.f10603a, com.bytedance.safetyguard.lxc.internal.e.a.i.class, "com.obric.aiagent.plugin");
            d.o.a(r25);     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            r26 = r25;
            goto L57
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            d.o.a(r25);     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            r20 = r25;
            goto L49
        L21:
            r10 = (SidecarBrand) ZeusTransformUtils.preCheckCast(this.f10603a, SidecarBrand.class, "com.obric.aiagent.plugin");
            d.o.a(r25);     // Catch: Throwable -> L15 com.bytedance.safetyguard.lxc.internal.e.a.m -> L17 CancellationException -> L19
            r13 = r25;
            goto L24
        L25:
            d.o.a(r25);     // Catch: Throwable -> L27 CancellationException -> L29
            r4 = r25;
        L83:
            th = move-exception;
            c.b(this.f10605c, this.h);
            throw th;
        L29:
            e = move-exception;
            c.a(this.f10605c, this.f10606d, "app_config_finished", com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.h(), this.f10607e, "create", null, null, 96, null);     // Catch: Throwable -> L83
            throw e;     // Catch: Throwable -> L83
        L27:
            th = move-exception;
            SidecarResult r29 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.c("credential store operation failed");     // Catch: Throwable -> L83
            c.a(this.f10605c, this.f10606d, "app_config_finished", r29, this.f10607e, "create", null, th, 32, null);     // Catch: Throwable -> L83
            this.f.a(r29);     // Catch: Throwable -> L83
        L17:
            e = move-exception;
            SidecarResult r30 = com.bytedance.safetyguard.lxc.internal.e.b.d.a("config", "app-registration", e, null, 8, null);     // Catch: Throwable -> L27 CancellationException -> L29
            if (r30 != null) goto L65;
            r30 = com.bytedance.safetyguard.lxc.internal.e.b.d.a("config", e, null, (d.h.a.a) ZeusTransformUtils.preCheckCast(a.f10615a, d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L27 CancellationException -> L29
        L65:
            c r31 = this.f10605c;     // Catch: Throwable -> L27 CancellationException -> L29
            AtomicBoolean r111 = this.f10606d;     // Catch: Throwable -> L27 CancellationException -> L29
            long r112 = this.f10607e;     // Catch: Throwable -> L27 CancellationException -> L29
            if (e.c() == null) goto L68;
            com.bytedance.safetyguard.lxc.internal.e.b.n r32 = com.bytedance.safetyguard.lxc.internal.e.b.n.f10706a;     // Catch: Throwable -> L27 CancellationException -> L29
        L69:
            com.bytedance.safetyguard.lxc.internal.e.b.n r113 = r32;
            if (e.c() == null) goto L73;
            r6 = false;
        L73:
            if (r6 == false) goto L75;
            r7 = e;
        L75:
            SidecarResult r114 = r30;
            c.a(r31, r111, "app_config_finished", r114, r112, "create", r113, (Throwable) ZeusTransformUtils.preCheckCast(r7, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L27 CancellationException -> L29
            this.f.a(r30);     // Catch: Throwable -> L27 CancellationException -> L29
            goto L79
        L68:
            r32 = com.bytedance.safetyguard.lxc.internal.e.b.n.f10707b;     // Catch: Throwable -> L27 CancellationException -> L29
        L19:
            e = move-exception;
            c.a(this.f10605c, this.f10606d, "app_config_finished", com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.h(), this.f10607e, "create", null, null, 96, null);     // Catch: Throwable -> L27 CancellationException -> L29
            throw e;     // Catch: Throwable -> L27 CancellationException -> L29
        L15:
            th = move-exception;
            SidecarResult r33 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.b("app registration failed");     // Catch: Throwable -> L27 CancellationException -> L29
            c.a(this.f10605c, this.f10606d, "app_config_finished", r33, this.f10607e, "create", null, th, 32, null);     // Catch: Throwable -> L27 CancellationException -> L29
            this.f.a(r33);     // Catch: Throwable -> L27 CancellationException -> L29
            goto L79
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "DefaultSafetyGuardSidecar.kt", c = {SwitchCompat.TRACK_ANIMATION_DURATION_ON, 264}, d = "configDeleteApp", e = "com.bytedance.safetyguard.lxc.internal.sidecar.core.DefaultSafetyGuardSidecar")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f10618c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f10619d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f10620e;
        int f;

        h(c r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10620e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10619d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f10620e.configDeleteApp((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class i extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f10621a = null;

        static {
            f10621a = new i();
        }

        i() {
            super(0);
        }

        public final String a() {
            return "component=sidecar event=app_config_started outcome=pending operation=delete";
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "DefaultSafetyGuardSidecar.kt", c = {216, 228}, d = "configImportApp", e = "com.bytedance.safetyguard.lxc.internal.sidecar.core.DefaultSafetyGuardSidecar")
    static final class j extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f10624c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f10625d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f10626e;
        long f;
        /* synthetic */ Object g;
        final /* synthetic */ c h;
        int i;

        j(c r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return this.h.configImportApp(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class k extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10628b;

        k(c r1, String r2) {
            this.f10627a = r1;
            this.f10628b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=sidecar event=app_config_started outcome=pending operation=import appRef=" + c.b(this.f10627a).a(this.f10628b);
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "DefaultSafetyGuardSidecar.kt", c = {478}, d = "configuredApp", e = "com.bytedance.safetyguard.lxc.internal.sidecar.core.DefaultSafetyGuardSidecar")
    static final class l extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f10629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f10630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f10631c;

        l(c r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10630b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10629a = r3;
            this.f10631c |= Integer.MIN_VALUE;
            return this.f10630b.configuredApp((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    /* synthetic */ class m extends d.h.b.l implements d.h.a.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f10632a = null;

        static {
            f10632a = new m();
        }

        m() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        public final Long a() {
            return Long.valueOf(System.currentTimeMillis());
        }

        @Override // d.h.a.a
        public /* synthetic */ Long invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class n extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10634b;

        n(c r1, String r2) {
            this.f10633a = r1;
            this.f10634b = r2;
            super(0);
        }

        public final String a() {
            return "component=sidecar event=session_end_started outcome=pending sessionRef=" + c.b(this.f10633a).a(this.f10634b);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class o extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f10635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f10636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10637c;

        o(boolean r1, c r2, String r3) {
            this.f10635a = r1;
            this.f10636b = r2;
            this.f10637c = r3;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=sidecar event=session_finished outcome=success operation=end removed=" + this.f10635a + " sessionRef=" + c.b(this.f10636b).a(this.f10637c);
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class p extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SidecarResult f10639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f10641d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f10642e;

        p(String r1, SidecarResult r2, String r3, c r4, long r5) {
            this.f10638a = r1;
            this.f10639b = r2;
            this.f10640c = r3;
            this.f10641d = r4;
            this.f10642e = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            StringBuilder r0 = new StringBuilder().append("component=sidecar event=").append(this.f10638a).append(" outcome=");
            if (this.f10639b.getSuccess() == false) goto L5;
            String r1 = "success";
        L6:
            StringBuilder r2 = r0.append(r1).append(' ');
            String r3 = this.f10640c;
            if (r3 == null) goto L10;
            String r4 = "operation=" + r3 + ' ';
            if (r4 == null) goto L10;
        L12:
            return r2.append(r4).append("code=").append(this.f10639b.getCode()).append(" subcode=").append(this.f10639b.getSubcode()).append(" subtype=").append(this.f10639b.getSubtype()).append(" durationMs=").append(((Number) ZeusTransformUtils.preCheckCast(c.g(this.f10641d).invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() - this.f10642e).append(" appRef=").append(c.b(this.f10641d).a(this.f10639b.getAppId())).append(" userRef=").append(c.b(this.f10641d).a(this.f10639b.getUserOpenId())).toString();
        L10:
            r4 = "";
            goto L12
        L5:
            r1 = "failed";
            goto L6
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class q extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set<String> f10643a;

        q(Set<String> r3) {
            this.f10643a = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            super(0);
        }

        public final String a() {
            return "component=sidecar event=login_started outcome=pending scopeCount=" + this.f10643a.size();
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "DefaultSafetyGuardSidecar.kt", c = {370, 370}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.core.DefaultSafetyGuardSidecar$login$job$1")
    static final class r extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f10645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f10646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Set<String> f10647d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.b.j f10648e;
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.b.h f;
        final /* synthetic */ long g;

        r(c r3, Set<String> r4, com.bytedance.safetyguard.lxc.internal.e.b.j r5, com.bytedance.safetyguard.lxc.internal.e.b.h r6, long r7, d.c.d<? super r> r9) {
            Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10646c = r3;
            this.f10647d = r8;
            this.f10648e = r5;
            this.f = r6;
            this.g = r7;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((r) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), r.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new r(this.f10646c, this.f10647d, this.f10648e, this.f, this.g, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r19) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f10645b;
            if (r2 == 0) goto L18;
            if (r2 == 1) goto L14;
            if (r2 != 2) goto L13;
            d.o.a(r19);     // Catch: Throwable -> L8 CancellationException -> L10
        L27:
            return d.x.f38692a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            c r3 = (c) ZeusTransformUtils.preCheckCast(this.f10644a, c.class, "com.obric.aiagent.plugin");
            d.o.a(r19);     // Catch: Throwable -> L8 CancellationException -> L10
            Object r5 = r19;
        L17:
            c r7 = r3;
            String r8 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8 CancellationException -> L10
            Set<String> r9 = this.f10647d;     // Catch: Throwable -> L8 CancellationException -> L10
            com.bytedance.safetyguard.lxc.internal.e.b.j r10 = this.f10648e;     // Catch: Throwable -> L8 CancellationException -> L10
            com.bytedance.safetyguard.lxc.internal.e.b.h r11 = this.f;     // Catch: Throwable -> L8 CancellationException -> L10
            d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8 CancellationException -> L10
            this.f10644a = null;     // Catch: Throwable -> L8 CancellationException -> L10
            this.f10645b = 2;     // Catch: Throwable -> L8 CancellationException -> L10
            if (c.a(r7, r8, r9, r10, r11, null, null, null, r15, 112, null) != r0) goto L27;
            return r0;
        L18:
            d.o.a(r19);
            r3 = this.f10646c;     // Catch: Throwable -> L8 CancellationException -> L10
            d.c.d r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8 CancellationException -> L10
            this.f10644a = r3;     // Catch: Throwable -> L8 CancellationException -> L10
            this.f10645b = 1;     // Catch: Throwable -> L8 CancellationException -> L10
            r5 = c.a(r3, null, r12);     // Catch: Throwable -> L8 CancellationException -> L10
            if (r5 != r0) goto L17;
            return r0;
        L10:
            e = move-exception;
            throw e;
        L8:
            th = move-exception;
            c.a(this.f10646c, "authentication", "login_finished", this.g, this.f10648e, th);
            goto L27
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "DefaultSafetyGuardSidecar.kt", c = {670, 684, 694, 706}, d = "loginDeviceFlow", e = "com.bytedance.safetyguard.lxc.internal.sidecar.core.DefaultSafetyGuardSidecar")
    static final class s extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f10651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f10652d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f10653e;
        Object f;
        Object g;
        Object h;
        long i;
        /* synthetic */ Object j;
        final /* synthetic */ c k;
        int l;

        s(c r3, d.c.d<? super s> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.k = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            this.j = r10;
            this.l |= Integer.MIN_VALUE;
            return c.a(this.k, null, null, null, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class t extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f10655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f10656c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f10657d;

        t(String r1, c r2, long r3, String r5) {
            this.f10654a = r1;
            this.f10655b = r2;
            this.f10656c = r3;
            this.f10657d = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=sidecar event=" + this.f10654a + " outcome=failed subtype=app_not_configured durationMs=" + (((Number) ZeusTransformUtils.preCheckCast(c.g(this.f10655b).invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() - this.f10656c) + " appRef=" + c.b(this.f10655b).a(this.f10657d);
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class u extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.i.c f10659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Set<String> f10660c;

        u(c r3, com.bytedance.safetyguard.lxc.internal.e.i.c r4, Set<String> r5) {
            Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
            this.f10658a = r3;
            this.f10659b = r4;
            this.f10660c = r6;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=sidecar event=device_authorization_started outcome=pending appRef=" + c.b(this.f10658a).a(this.f10659b.a()) + " brand=" + this.f10659b.c().name() + " scopeCount=" + this.f10660c.size();
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class v extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.i.c f10662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.j f10663c;

        v(c r1, com.bytedance.safetyguard.lxc.internal.e.i.c r2, com.bytedance.safetyguard.lxc.internal.e.a.j r3) {
            this.f10661a = r1;
            this.f10662b = r2;
            this.f10663c = r3;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=sidecar event=authorization_ready outcome=success appRef=" + c.b(this.f10661a).a(this.f10662b.a()) + " expiresInSec=" + this.f10663c.c() + " intervalSec=" + this.f10663c.d();
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class w extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.i.c f10665b;

        w(c r1, com.bytedance.safetyguard.lxc.internal.e.i.c r2) {
            this.f10664a = r1;
            this.f10665b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=sidecar event=device_token_poll_started outcome=pending appRef=" + c.b(this.f10664a).a(this.f10665b.a()) + " brand=" + this.f10665b.c().name();
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "DefaultSafetyGuardSidecar.kt", c = {707}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.core.DefaultSafetyGuardSidecar$loginDeviceFlow$6")
    static final class x extends d.c.b.a.l implements d.h.a.b<d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f10667b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.v f10668c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.i.c f10669d;

        x(c r3, com.bytedance.safetyguard.lxc.internal.e.a.v r4, com.bytedance.safetyguard.lxc.internal.e.i.c r5, d.c.d<? super x> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10667b = r3;
            this.f10668c = r4;
            this.f10669d = r5;
            super(1, r7);
        }

        public final Object a(d.c.d<? super d.x> r3) {
            return ((x) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), x.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new x(this.f10667b, this.f10668c, this.f10669d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super d.x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10666a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.bytedance.safetyguard.lxc.internal.e.i.b r7 = c.a(this.f10667b);
            com.bytedance.safetyguard.lxc.internal.e.i.d r2 = com.bytedance.safetyguard.lxc.internal.e.b.d.a(this.f10668c, this.f10669d.a());
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10666a = 1;
            if (r7.a(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class y extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f10671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f10672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.i.c f10673d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.v f10674e;

        y(String r1, c r2, long r3, com.bytedance.safetyguard.lxc.internal.e.i.c r5, com.bytedance.safetyguard.lxc.internal.e.a.v r6) {
            this.f10670a = r1;
            this.f10671b = r2;
            this.f10672c = r3;
            this.f10673d = r5;
            this.f10674e = r6;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=sidecar event=" + this.f10670a + " outcome=success durationMs=" + (((Number) ZeusTransformUtils.preCheckCast(c.g(this.f10671b).invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() - this.f10672c) + " appRef=" + c.b(this.f10671b).a(this.f10673d.a()) + " scopeCount=" + this.f10674e.g().size();
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    static final class z extends d.h.b.p implements d.h.a.a<SidecarResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.b.e f10675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Throwable f10676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.i.c f10677c;

        z(com.bytedance.safetyguard.lxc.internal.e.b.e r1, Throwable r2, com.bytedance.safetyguard.lxc.internal.e.i.c r3) {
            this.f10675a = r1;
            this.f10676b = r2;
            this.f10677c = r3;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ SidecarResult invoke() {
            return a();
        }

        public final SidecarResult a() {
            com.bytedance.safetyguard.lxc.internal.e.b.m r0 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a;
            com.bytedance.safetyguard.lxc.internal.e.b.e r1 = this.f10675a;
            if (r1 == null) goto L15;
            String r2 = r1.a();
            Throwable r3 = this.f10676b;
            if (ZeusTransformUtils.instanceOf(r3, com.bytedance.safetyguard.lxc.internal.e.a.m.class) == false) goto L7;
            com.bytedance.safetyguard.lxc.internal.e.a.m r4 = (com.bytedance.safetyguard.lxc.internal.e.a.m) ZeusTransformUtils.preCheckCast(r3, com.bytedance.safetyguard.lxc.internal.e.a.m.class, "com.obric.aiagent.plugin");
        L8:
            if (r4 == null) goto L11;
            String r5 = r4.getMessage();
            if (r5 == null) goto L11;
        L13:
            return r0.b(r2, r5, this.f10675a.b(), this.f10677c.a());
        L11:
            r5 = "authorization failed";
            goto L13
        L7:
            r4 = null;
            goto L8
        L15:
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    static {
        f10547a = new a(null);
    }

    public c(SafetyGuardSidecarConfig r3, d.h.a.a<Long> r4, com.bytedance.safetyguard.lxc.internal.e.i.b r5, com.bytedance.safetyguard.lxc.internal.e.a.l r6, com.bytedance.safetyguard.lxc.internal.e.h.b r7, com.bytedance.safetyguard.lxc.internal.e.e.c r8, com.bytedance.safetyguard.lxc.internal.a.e r9) {
        d.h.a.a<Long> r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.i.b r11 = (com.bytedance.safetyguard.lxc.internal.e.i.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.safetyguard.lxc.internal.e.i.b.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.a.l r12 = (com.bytedance.safetyguard.lxc.internal.e.a.l) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.safetyguard.lxc.internal.e.a.l.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.h.b r13 = (com.bytedance.safetyguard.lxc.internal.e.h.b) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.safetyguard.lxc.internal.e.h.b.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.a.e r14 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r9, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "config");
        d.h.b.o.e(r10, "nowMillis");
        d.h.b.o.e(r11, "credentialStore");
        d.h.b.o.e(r12, "oauthClient");
        d.h.b.o.e(r13, "tokenResolver");
        d.h.b.o.e(r8, "forwarder");
        d.h.b.o.e(r14, "logger");
        this.f10548b = r3;
        this.f10549c = r10;
        this.f10550d = r11;
        this.f10551e = r12;
        this.f = r13;
        this.g = r8;
        this.h = r14;
        boolean r15 = true;
        this.i = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
        this.j = new com.bytedance.safetyguard.lxc.internal.e.g.b(r10, null, 2, null);
        this.k = new AtomicReference(null);
        this.l = new AtomicLong(0);
        if (r3.getSessionTtlMillis() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L44;
        if (r3.getTimestampDriftMillis() < 0) goto L10;
        boolean r16 = true;
    L11:
        if (r16 == false) goto L42;
        if (r3.getMaxRequestBodyBytes() <= 0) goto L15;
        boolean r17 = true;
    L16:
        if (r17 == false) goto L40;
        if (r3.getMaxResponseBodyBytes() <= 0) goto L20;
        boolean r18 = true;
    L21:
        if (r18 == false) goto L38;
        if (r3.getConnectTimeoutMillis() <= 0) goto L25;
        boolean r19 = true;
    L26:
        if (r19 == false) goto L36;
        if (r3.getReadTimeoutMillis() > 0) goto L31;
        r15 = false;
    L31:
        if (r15 == false) goto L34;
        return;
    L34:
        throw new IllegalArgumentException("readTimeoutMillis must be positive".toString());
    L36:
        throw new IllegalArgumentException("connectTimeoutMillis must be positive".toString());
    L25:
        r19 = false;
        goto L26
    L38:
        throw new IllegalArgumentException("maxResponseBodyBytes must be positive".toString());
    L20:
        r18 = false;
        goto L21
    L40:
        throw new IllegalArgumentException("maxRequestBodyBytes must be positive".toString());
    L15:
        r17 = false;
        goto L16
    L42:
        throw new IllegalArgumentException("timestampDriftMillis must not be negative".toString());
    L10:
        r16 = false;
        goto L11
    L44:
        throw new IllegalArgumentException("sessionTtlMillis must be positive".toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final /* synthetic */ a a() {
        return f10547a;
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.i.b a(c r0) {
        return r0.f10550d;
    }

    public static final /* synthetic */ Object a(c r2, String r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r11, String r12, Set r13, com.bytedance.safetyguard.lxc.internal.e.b.j r14, com.bytedance.safetyguard.lxc.internal.e.b.h r15, String r16, String r17, String r18, d.c.d r19) {
        return r11.a(r12, (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.aiagent.plugin"), r14, r15, r16, r17, r18, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(c r0, String r1, String r2, long r3, com.bytedance.safetyguard.lxc.internal.e.b.j r5, Throwable r6) {
        r0.a(r1, r2, r3, r5, r6);
    }

    public static final /* synthetic */ void a(c r0, AtomicBoolean r1, String r2, SidecarResult r3, long r4, String r6, com.bytedance.safetyguard.lxc.internal.e.b.n r7, Throwable r8) {
        r0.a(r1, r2, r3, r4, r6, r7, r8);
    }

    public static final /* synthetic */ boolean a(c r0, com.bytedance.safetyguard.lxc.internal.e.b.b r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.a.e b(c r0) {
        return r0.h;
    }

    public static final /* synthetic */ void b(c r0, com.bytedance.safetyguard.lxc.internal.e.b.b r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.a.l c(c r0) {
        return r0.f10551e;
    }

    public static final /* synthetic */ SafetyGuardSidecarConfig d(c r0) {
        return r0.f10548b;
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.h.b e(c r0) {
        return r0.f;
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.e.c f(c r0) {
        return r0.g;
    }

    public static final /* synthetic */ d.h.a.a g(c r0) {
        return r0.f10549c;
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public int getVersion() {
        return SafetyGuardSidecar.DefaultImpls.getVersion(this);
    }

    public /* synthetic */ c(SafetyGuardSidecarConfig r12, d.h.a.a r13, com.bytedance.safetyguard.lxc.internal.e.i.b r14, com.bytedance.safetyguard.lxc.internal.e.a.l r15, com.bytedance.safetyguard.lxc.internal.e.h.b r16, com.bytedance.safetyguard.lxc.internal.e.e.c r17, com.bytedance.safetyguard.lxc.internal.a.e r18, int r19, d.h.b.h r20) {
        d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.i.b r6 = (com.bytedance.safetyguard.lxc.internal.e.i.b) ZeusTransformUtils.wrapperContextForParams(r14, com.bytedance.safetyguard.lxc.internal.e.i.b.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.a.l r7 = (com.bytedance.safetyguard.lxc.internal.e.a.l) ZeusTransformUtils.wrapperContextForParams(r15, com.bytedance.safetyguard.lxc.internal.e.a.l.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.h.b r8 = (com.bytedance.safetyguard.lxc.internal.e.h.b) ZeusTransformUtils.wrapperContextForParams(r16, com.bytedance.safetyguard.lxc.internal.e.h.b.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.a.e r2 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r18, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        if ((r19 & 2) == 0) goto L5;
        r0 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f10552a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L5:
        d.h.a.a r5 = r0;
        if ((r19 & 64) == 0) goto L8;
        com.bytedance.safetyguard.lxc.internal.a.e r10 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.preCheckCast(com.bytedance.safetyguard.lxc.internal.a.d.f9723a, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
    L9:
        this(r12, r5, r6, r7, r8, r17, r10);
        return;
    L8:
        r10 = r2;
        goto L9
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public SidecarOperation configCreateApp(String r24, SidecarDeviceFlowCallback r25) {
        SidecarDeviceFlowCallback r0 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r25, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r24, "production");
        d.h.b.o.e(r0, "callback");
        long r12 = ((Number) ZeusTransformUtils.preCheckCast(this.f10549c.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        com.bytedance.safetyguard.lxc.internal.e.b.j r14 = new com.bytedance.safetyguard.lxc.internal.e.b.j(r0);
        com.bytedance.safetyguard.lxc.internal.e.b.h r15 = new com.bytedance.safetyguard.lxc.internal.e.b.h();
        AtomicBoolean r9 = new AtomicBoolean(false);
        this.h.b("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(r24), d.h.a.a.class, "com.obric.aiagent.plugin"));
        com.bytedance.safetyguard.lxc.internal.e.b.b r16 = b();
        if (r16 != null) goto L6;
        com.bytedance.safetyguard.lxc.internal.e.b.a r17 = new com.bytedance.safetyguard.lxc.internal.e.b.a(f10547a.a("config-create-app-rejected"));
        SidecarResult r8 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.f();
        a(this, r9, "app_config_finished", r8, r12, "create", null, null, 96, null);
        r14.a(r8);
        return (SidecarOperation) ZeusTransformUtils.preCheckCast(r17, SidecarOperation.class, "com.obric.aiagent.plugin");
    L6:
        ca r6 = kotlinx.coroutines.i.a(this.i, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(this, r9, r12, r14, r24, r16, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return (SidecarOperation) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.b.f(r16.a(), r6, r14, r15, (d.h.a.a) ZeusTransformUtils.preCheckCast(new f(this, r9, r12, r16), d.h.a.a.class, "com.obric.aiagent.plugin")), SidecarOperation.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public Object configImportApp(String r37, String r38, String r39, d.c.d<? super SidecarResult> r40) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r40, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, j.class) == false) goto L7;
        j r6 = (j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.aiagent.plugin");
        if ((r6.i & Integer.MIN_VALUE) == 0) goto L7;
        r6.i -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.g;
        Object r7 = d.c.a.b.a();
        int r8 = r6.i;
        if (r8 == 0) goto L29;
        if (r8 == 1) goto L22;
        if (r8 != 2) goto L21;
        long r1 = r6.f;
        SidecarBrand r0 = (SidecarBrand) ZeusTransformUtils.preCheckCast(r6.f10625d, SidecarBrand.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.b.b r9 = (com.bytedance.safetyguard.lxc.internal.e.b.b) ZeusTransformUtils.preCheckCast(r6.f10624c, com.bytedance.safetyguard.lxc.internal.e.b.b.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r6.f10623b, String.class, "com.obric.aiagent.plugin");
        c r3 = (c) ZeusTransformUtils.preCheckCast(r6.f10622a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Throwable -> L15 CancellationException -> L17
        c r12 = r3;
    L96:
        SidecarResult r2 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.a(r10, r0);     // Catch: Throwable -> L63 CancellationException -> L65
        a(r12, "app_config_finished", r2, r1, "import", null, null, 48, null);     // Catch: Throwable -> L63 CancellationException -> L65
        com.bytedance.safetyguard.lxc.internal.e.b.b r11 = r9;
    L68:
        r12.b(r11);
    L76:
        return r2;
    L65:
        e = e;
        long r13 = r1;
    L19:
        com.bytedance.safetyguard.lxc.internal.e.b.b r14 = r9;
    L89:
        a(r12, "app_config_finished", com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.h(), r13, "import", null, null, 48, null);     // Catch: Throwable -> L83
        throw e;     // Catch: Throwable -> L83
    L83:
        th = th;
        r9 = r14;
    L85:
        r12.b(r9);
        throw th;
    L63:
        th = move-exception;
        Throwable r30 = th;
        long r26 = r1;
    L91:
        r2 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.c("credential store operation failed");     // Catch: Throwable -> L77
        a(r12, "app_config_finished", r2, r26, "import", null, r30, 16, null);     // Catch: Throwable -> L77
        r12.b(r9);
    L77:
        th = th;
        goto L85
    L17:
        e = e;
        r13 = r1;
        r12 = r3;
    L15:
        th = move-exception;
        r30 = th;
        r26 = r1;
        r12 = r3;
        goto L91
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        r1 = r6.f;
        r11 = (com.bytedance.safetyguard.lxc.internal.e.b.b) ZeusTransformUtils.preCheckCast(r6.f10626e, com.bytedance.safetyguard.lxc.internal.e.b.b.class, "com.obric.aiagent.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r6.f10625d, String.class, "com.obric.aiagent.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r6.f10624c, String.class, "com.obric.aiagent.plugin");
        String r17 = (String) ZeusTransformUtils.preCheckCast(r6.f10623b, String.class, "com.obric.aiagent.plugin");
        r12 = (c) ZeusTransformUtils.preCheckCast(r6.f10622a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Throwable -> L25 CancellationException -> L27
        String r18 = r15;
    L45:
        if (r5 == null) goto L87;
        SidecarResult r19 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.g();     // Catch: Throwable -> L25 CancellationException -> L27
        a(r12, "app_config_finished", r19, r1, "import", null, null, 48, null);     // Catch: Throwable -> L25 CancellationException -> L27
        r12.b(r11);
        return r19;
    L87:
        d.n.a r20 = d.n.f38560a;     // Catch: Throwable -> L51
        c r21 = (c) ZeusTransformUtils.preCheckCast(r12, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        Object r22 = d.n.f(SidecarBrand.Companion.fromProduction(r17));     // Catch: Throwable -> L51
    L54:
        if (d.n.c(r22) != null) goto L69;
        r0 = (SidecarBrand) ZeusTransformUtils.preCheckCast(r22, SidecarBrand.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25 CancellationException -> L27
        if (r12.a(r11) == false) goto L67;
        ce.b(r6.getContext());     // Catch: Throwable -> L25 CancellationException -> L27
        com.bytedance.safetyguard.lxc.internal.e.i.b r23 = r12.f10550d;     // Catch: Throwable -> L25 CancellationException -> L27
        com.bytedance.safetyguard.lxc.internal.e.i.c r24 = new com.bytedance.safetyguard.lxc.internal.e.i.c(r16, r18, r0, null, null, 24, null);     // Catch: Throwable -> L25 CancellationException -> L27
        r6.f10622a = r12;     // Catch: Throwable -> L25 CancellationException -> L27
        r6.f10623b = r16;     // Catch: Throwable -> L25 CancellationException -> L27
        r6.f10624c = r11;     // Catch: Throwable -> L25 CancellationException -> L27
        r6.f10625d = r0;     // Catch: Throwable -> L25 CancellationException -> L27
        r6.f10626e = null;     // Catch: Throwable -> L25 CancellationException -> L27
        r6.f = r1;     // Catch: Throwable -> L25 CancellationException -> L27
        r6.i = 2;     // Catch: Throwable -> L25 CancellationException -> L27
        if (r23.a(r24, r6) != r7) goto L60;
        return r7;
    L60:
        r9 = r11;
        r10 = r16;
        goto L96
    L67:
        r2 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.h();     // Catch: Throwable -> L25 CancellationException -> L27
        a(r12, "app_config_finished", r2, r1, "import", null, null, 48, null);     // Catch: Throwable -> L25 CancellationException -> L27
        goto L68
    L69:
        SidecarResult r25 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.d("unsupported brand");     // Catch: Throwable -> L25 CancellationException -> L27
        a(r12, "app_config_finished", r25, r1, "import", null, null, 48, null);     // Catch: Throwable -> L25 CancellationException -> L27
        r12.b(r11);
        return r25;
    L51:
        th = move-exception;
        d.n.a r27 = d.n.f38560a;     // Catch: Throwable -> L25 CancellationException -> L27
        r22 = d.n.f(d.o.a(th));     // Catch: Throwable -> L25 CancellationException -> L27
    L27:
        e = e;
        r13 = r1;
        r14 = r11;
    L25:
        th = move-exception;
        r30 = th;
        r26 = r1;
        r9 = r11;
        goto L91
    L29:
        d.o.a(r5);
        long r110 = ((Number) ZeusTransformUtils.preCheckCast(this.f10549c.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        this.h.b("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(new k(this, r38), d.h.a.a.class, "com.obric.aiagent.plugin"));
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r38, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L34;
        SidecarResult r28 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.b();
        a(this, "app_config_finished", r28, r110, "import", null, null, 48, null);
        return r28;
    L34:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r39, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L37;
        SidecarResult r29 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.c();
        a(this, "app_config_finished", r29, r110, "import", null, null, 48, null);
        return r29;
    L37:
        com.bytedance.safetyguard.lxc.internal.e.b.b r31 = b();
        if (r31 != null) goto L93;
        SidecarResult r32 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.f();
        a(this, "app_config_finished", r32, r110, "import", null, null, 48, null);
        return r32;
    L93:
        com.bytedance.safetyguard.lxc.internal.e.i.b r33 = this.f10550d;     // Catch: Throwable -> L72 CancellationException -> L79
        r6.f10622a = this;     // Catch: Throwable -> L72 CancellationException -> L79
        r6.f10623b = r37;     // Catch: Throwable -> L72 CancellationException -> L79
        r6.f10624c = r38;     // Catch: Throwable -> L72 CancellationException -> L79
        r6.f10625d = r39;     // Catch: Throwable -> L72 CancellationException -> L79
        r6.f10626e = r31;     // Catch: Throwable -> L72 CancellationException -> L79
        r6.f = r110;     // Catch: Throwable -> L72 CancellationException -> L79
        r6.i = 1;     // Catch: Throwable -> L72 CancellationException -> L79
        Object r34 = r33.a(r6);     // Catch: Throwable -> L72 CancellationException -> L79
        if (r34 != r7) goto L44;
        return r7;
    L44:
        r16 = r38;
        r18 = r39;
        r12 = this;
        r1 = r110;
        r17 = r37;
        r11 = r31;
        r5 = r34;
        goto L45
    L79:
        e = e;
        r12 = this;
        r14 = r31;
        r13 = r110;
    L72:
        th = move-exception;
        r30 = th;
        r9 = r31;
        r26 = r110;
        r12 = this;
    L7:
        r6 = new j(this, r4);
        goto L8
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public Object configDeleteApp(d.c.d<? super SidecarResult> r32) {
        c r1 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r32, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, h.class) == false) goto L7;
        h r4 = (h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f10619d;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f;
        if (r6 == 0) goto L30;
        if (r6 == 1) goto L23;
        if (r6 != 2) goto L22;
        long r7 = r4.f10618c;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r4.f10617b, String.class, "com.obric.aiagent.plugin");
        c r9 = (c) ZeusTransformUtils.preCheckCast(r4.f10616a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L15 CancellationException -> L18
        String r0 = r8;
        r1 = r9;
    L64:
        boolean r10 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L49 CancellationException -> L51
        r1.j.b(r0);     // Catch: Throwable -> L49 CancellationException -> L51
        if (r10 == false) goto L47;
        SidecarResult r11 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.a(r0);     // Catch: Throwable -> L49 CancellationException -> L51
        a(r1, "app_config_finished", r11, r7, "delete", null, null, 48, null);     // Catch: Throwable -> L49 CancellationException -> L51
    L63:
        return r11;
    L47:
        r11 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.e();     // Catch: Throwable -> L49 CancellationException -> L51
        a(r1, "app_config_finished", r11, r7, "delete", null, null, 48, null);     // Catch: Throwable -> L49 CancellationException -> L51
    L51:
        e = e;
    L20:
        long r12 = r7;
    L61:
        a(r1, "app_config_finished", com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.h(), r12, "delete", null, null, 48, null);
        throw e;
    L49:
        th = move-exception;
        Throwable r28 = th;
        c r21 = r1;
    L17:
        long r24 = r7;
    L57:
        SidecarResult r13 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.c("credential store operation failed");
        a(r21, "app_config_finished", r13, r24, "delete", null, r28, 16, null);
        return r13;
    L18:
        e = e;
        r1 = r9;
    L15:
        th = move-exception;
        r28 = th;
        r21 = r9;
        goto L17
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L23:
        long r14 = r4.f10618c;
        r1 = (c) ZeusTransformUtils.preCheckCast(r4.f10616a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L26 CancellationException -> L28
    L35:
        com.bytedance.safetyguard.lxc.internal.e.i.c r15 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r3, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26 CancellationException -> L28
        if (r15 == null) goto L53;
        r0 = r15.a();     // Catch: Throwable -> L26 CancellationException -> L28
        if (r0 == null) goto L53;
        com.bytedance.safetyguard.lxc.internal.e.i.b r16 = r1.f10550d;     // Catch: Throwable -> L26 CancellationException -> L28
        r4.f10616a = r1;     // Catch: Throwable -> L26 CancellationException -> L28
        r4.f10617b = r0;     // Catch: Throwable -> L26 CancellationException -> L28
        r4.f10618c = r14;     // Catch: Throwable -> L26 CancellationException -> L28
        r4.f = 2;     // Catch: Throwable -> L26 CancellationException -> L28
        r3 = r16.b(r4);     // Catch: Throwable -> L26 CancellationException -> L28
        if (r3 != r5) goto L43;
        return r5;
    L43:
        r7 = r14;
    L53:
        SidecarResult r17 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.e();     // Catch: Throwable -> L26 CancellationException -> L28
        a(r1, "app_config_finished", r17, r14, "delete", null, null, 48, null);     // Catch: Throwable -> L26 CancellationException -> L28
        return r17;
    L28:
        e = e;
        r12 = r14;
    L26:
        th = move-exception;
        r28 = th;
        r21 = r1;
        r24 = r14;
        goto L57
    L30:
        d.o.a(r3);
        long r18 = ((Number) ZeusTransformUtils.preCheckCast(r1.f10549c.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        r1.h.b("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(i.f10621a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        c();
        com.bytedance.safetyguard.lxc.internal.e.i.b r19 = r1.f10550d;     // Catch: Throwable -> L55 CancellationException -> L59
        r4.f10616a = r1;     // Catch: Throwable -> L55 CancellationException -> L59
        r4.f10618c = r18;     // Catch: Throwable -> L55 CancellationException -> L59
        r4.f = 1;     // Catch: Throwable -> L55 CancellationException -> L59
        r3 = r19.a(r4);     // Catch: Throwable -> L55 CancellationException -> L59
        if (r3 != r5) goto L34;
        return r5;
    L34:
        r14 = r18;
        goto L35
    L59:
        e = e;
        r12 = r18;
    L55:
        th = move-exception;
        r28 = th;
        r21 = r1;
        r24 = r18;
    L7:
        r4 = new h(r1, r2);
        goto L8
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public SidecarOperation login(Set<String> r21, SidecarDeviceFlowCallback r22) {
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r21, Set.class, "com.obric.aiagent.plugin");
        SidecarDeviceFlowCallback r0 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r22, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "scopes");
        d.h.b.o.e(r0, "callback");
        long r5 = ((Number) ZeusTransformUtils.preCheckCast(this.f10549c.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        String r10 = f10547a.a("login");
        com.bytedance.safetyguard.lxc.internal.e.b.j r12 = new com.bytedance.safetyguard.lxc.internal.e.b.j(r0);
        com.bytedance.safetyguard.lxc.internal.e.b.h r13 = new com.bytedance.safetyguard.lxc.internal.e.b.h();
        this.h.b("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(new q(r2), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return (SidecarOperation) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.b.f(r10, kotlinx.coroutines.i.a(this.i, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new r(this, r2, r12, r13, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null), r12, r13, null, 16, null), SidecarOperation.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public SidecarOperation requestGrant(Set<String> r21, SidecarDeviceFlowCallback r22) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r21, Set.class, "com.obric.aiagent.plugin");
        SidecarDeviceFlowCallback r0 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r22, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "scopes");
        d.h.b.o.e(r0, "callback");
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(this.f10549c.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        String r10 = f10547a.a("request-grant");
        com.bytedance.safetyguard.lxc.internal.e.b.j r12 = new com.bytedance.safetyguard.lxc.internal.e.b.j(r0);
        com.bytedance.safetyguard.lxc.internal.e.b.h r13 = new com.bytedance.safetyguard.lxc.internal.e.b.h();
        this.h.b("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(new ad(r5), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return (SidecarOperation) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.b.f(r10, kotlinx.coroutines.i.a(this.i, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ae(this, r2, r12, r5, r13, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null), r12, r13, null, 16, null), SidecarOperation.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x014d: MOVE (r21 I:??[long, double]) = (r9 I:??[long, double]), block:B:54:0x0149 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0168: MOVE (r4 I:??[long, double]) = (r9 I:??[long, double]), block:B:58:0x0168 */
    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public Object logout(d.c.d<? super SidecarResult> r29) {
        c r1 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r29, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, ab.class) == false) goto L7;
        ab r4 = (ab) ZeusTransformUtils.preCheckCast(r2, ab.class, "com.obric.aiagent.plugin");
        if ((r4.g & Integer.MIN_VALUE) == 0) goto L7;
        r4.g -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f10562e;
        Object r5 = d.c.a.b.a();
        int r6 = r4.g;
        boolean r8 = true;
        if (r6 == 0) goto L26;
        if (r6 == 1) goto L23;
        if (r6 != 2) goto L22;
        long r7 = r4.f10561d;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r4.f10560c, String.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.i.c r10 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r4.f10559b, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
        c r11 = (c) ZeusTransformUtils.preCheckCast(r4.f10558a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L15 CancellationException -> L18
        String r12 = r9;
        r1 = r11;
    L63:
        r1.j.a(r10.a(), r12);     // Catch: Throwable -> L46 CancellationException -> L48
        com.bytedance.safetyguard.lxc.internal.e.i.c r0 = r10;
    L51:
        SidecarResult r13 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.c(r0.a(), r12);     // Catch: Throwable -> L46 CancellationException -> L48
        a(r1, "logout_finished", r13, r7, null, null, null, 56, null);     // Catch: Throwable -> L46 CancellationException -> L48
    L66:
        return r13;
    L48:
        e = e;
    L20:
        long r14 = r7;
    L59:
        a(r1, "logout_finished", com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.h(), r14, null, null, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), 24, null);
        throw e;
    L46:
        th = move-exception;
        Throwable r25 = th;
        c r18 = r1;
    L17:
        long r21 = r7;
    L55:
        SidecarResult r15 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.c("credential store operation failed");
        a(r18, "logout_finished", r15, r21, null, null, r25, 24, null);
        return r15;
    L18:
        e = e;
        r1 = r11;
    L15:
        th = move-exception;
        r25 = th;
        r18 = r11;
        goto L17
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L23:
        long r16 = r4.f10561d;
        r1 = (c) ZeusTransformUtils.preCheckCast(r4.f10558a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L53 CancellationException -> L57
    L30:
        r0 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r3, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L53 CancellationException -> L57
        if (r0 != null) goto L34;
        SidecarResult r17 = com.bytedance.safetyguard.lxc.internal.e.b.m.a(com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a, null, null, 3, null);     // Catch: Throwable -> L53 CancellationException -> L57
        a(r1, "logout_finished", r17, r16, null, null, null, 56, null);     // Catch: Throwable -> L53 CancellationException -> L57
        return r17;
    L34:
        r12 = r0.d();     // Catch: Throwable -> L53 CancellationException -> L57
        CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L53 CancellationException -> L57
        if (r19 != null) goto L37;
    L40:
        if (r8 == true) goto L50;
        com.bytedance.safetyguard.lxc.internal.e.i.b r20 = r1.f10550d;     // Catch: Throwable -> L53 CancellationException -> L57
        String r22 = r0.a();     // Catch: Throwable -> L53 CancellationException -> L57
        r4.f10558a = r1;     // Catch: Throwable -> L53 CancellationException -> L57
        r4.f10559b = r0;     // Catch: Throwable -> L53 CancellationException -> L57
        r4.f10560c = r12;     // Catch: Throwable -> L53 CancellationException -> L57
        r4.f10561d = r16;     // Catch: Throwable -> L53 CancellationException -> L57
        r4.g = 2;     // Catch: Throwable -> L53 CancellationException -> L57
        if (r20.b(r22, r12, r4) != r5) goto L44;
        return r5;
    L44:
        r10 = r0;
        r7 = r16;
        goto L63
    L50:
        r7 = r16;
        goto L51
    L37:
        if (d.o.o.d(r19) == true) goto L40;
        r8 = false;
        goto L40
    L26:
        d.o.a(r3);
        r16 = ((Number) ZeusTransformUtils.preCheckCast(r1.f10549c.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        r1.h.a("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(ac.f10563a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        com.bytedance.safetyguard.lxc.internal.e.i.b r23 = r1.f10550d;     // Catch: Throwable -> L53 CancellationException -> L57
        r4.f10558a = r1;     // Catch: Throwable -> L53 CancellationException -> L57
        r4.f10561d = r16;     // Catch: Throwable -> L53 CancellationException -> L57
        r4.g = 1;     // Catch: Throwable -> L53 CancellationException -> L57
        r3 = r23.a(r4);     // Catch: Throwable -> L53 CancellationException -> L57
        if (r3 != r5) goto L30;
        return r5;
    L57:
        e = e;
        r14 = r9;
    L53:
        th = move-exception;
        r25 = th;
        r18 = r1;
        r21 = r9;
    L7:
        r4 = new ab(r1, r2);
        goto L8
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public Object status(d.c.d<? super SidecarAccountStatus> r18) {
        c r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, aj.class) == false) goto L7;
        aj r3 = (aj) ZeusTransformUtils.preCheckCast(r1, aj.class, "com.obric.aiagent.plugin");
        if ((r3.f10586d & Integer.MIN_VALUE) == 0) goto L7;
        r3.f10586d -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f10584b;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f10586d;
        Long r9 = null;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        com.bytedance.safetyguard.lxc.internal.e.i.c r6 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r3.f10583a, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L36:
        com.bytedance.safetyguard.lxc.internal.e.i.d r7 = (com.bytedance.safetyguard.lxc.internal.e.i.d) ZeusTransformUtils.preCheckCast(r2, com.bytedance.safetyguard.lxc.internal.e.i.d.class, "com.obric.aiagent.plugin");
    L39:
        if (r6 == null) goto L41;
        SidecarAppInfo r11 = com.bytedance.safetyguard.lxc.internal.e.b.d.a(r6);
    L42:
        if (r7 == null) goto L44;
        boolean r12 = true;
    L45:
        if (r7 == null) goto L48;
        Set<String> r8 = r7.h();
        if (r8 == null) goto L48;
    L49:
        Set<String> r13 = r8;
        if (r7 == null) goto L52;
        Long r14 = d.c.b.a.b.a(r7.f());
    L53:
        if (r7 == null) goto L56;
        r9 = d.c.b.a.b.a(r7.g());
    L56:
        return new SidecarAccountStatus(r11, r12, r13, r14, r9);
    L52:
        r14 = null;
    L48:
        r8 = ax.b();
        goto L49
    L44:
        r12 = false;
        goto L45
    L41:
        r11 = null;
        goto L42
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r0 = (c) ZeusTransformUtils.preCheckCast(r3.f10583a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L19:
        com.bytedance.safetyguard.lxc.internal.e.i.c r10 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r2, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L22;
        String r15 = r10.d();
    L23:
        if (r10 == null) goto L37;
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L27;
    L30:
        boolean r17 = true;
    L31:
        if (r17 == true) goto L37;
        com.bytedance.safetyguard.lxc.internal.e.i.b r19 = r0.f10550d;
        String r110 = r10.a();
        r3.f10583a = r10;
        r3.f10586d = 2;
        Object r20 = r19.a(r110, r15, r3);
        if (r20 != r4) goto L35;
        return r4;
    L35:
        r2 = r20;
        r6 = r10;
        goto L36
    L27:
        if (d.o.o.d(r16) == true) goto L30;
        r17 = false;
    L37:
        r6 = r10;
        r7 = null;
        goto L39
    L22:
        r15 = null;
        goto L23
    L16:
        d.o.a(r2);
        com.bytedance.safetyguard.lxc.internal.e.i.b r21 = r0.f10550d;
        r3.f10583a = r0;
        r3.f10586d = 1;
        r2 = r21.a(r3);
        if (r2 != r4) goto L19;
        return r4;
    L7:
        r3 = new aj(r0, r1);
        goto L8
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public Object configuredApp(d.c.d<? super SidecarAppInfo> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, l.class) == false) goto L7;
        l r0 = (l) ZeusTransformUtils.preCheckCast(r7, l.class, "com.obric.aiagent.plugin");
        if ((r0.f10631c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f10631c -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f10629a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f10631c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r8);
    L17:
        com.bytedance.safetyguard.lxc.internal.e.i.c r5 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r8, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L22;
        return null;
    L22:
        return com.bytedance.safetyguard.lxc.internal.e.b.d.a(r5);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        com.bytedance.safetyguard.lxc.internal.e.i.b r9 = this.f10550d;
        r0.f10631c = 1;
        r8 = r9.a(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new l(this, r7);
        goto L8
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public Object startSession(StartSidecarSessionRequest r25, d.c.d<? super SidecarSessionEnv> r26) {
        c r1 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, ag.class) == false) goto L7;
        ag r4 = (ag) ZeusTransformUtils.preCheckCast(r2, ag.class, "com.obric.aiagent.plugin");
        if ((r4.h & Integer.MIN_VALUE) == 0) goto L7;
        r4.h -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f;
        Object r5 = d.c.a.b.a();
        int r6 = r4.h;
        if (r6 == 0) goto L37;
        if (r6 == 1) goto L25;
        if (r6 != 2) goto L24;
        long r7 = r4.f10577e;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r4.f10576d, String.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.i.c r9 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r4.f10575c, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
        StartSidecarSessionRequest r10 = (StartSidecarSessionRequest) ZeusTransformUtils.preCheckCast(r4.f10574b, StartSidecarSessionRequest.class, "com.obric.aiagent.plugin");
        c r11 = (c) ZeusTransformUtils.preCheckCast(r4.f10573a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L15 SidecarOperationException -> L18 CancellationException -> L20
        String r12 = r8;
        r1 = r11;
        com.bytedance.safetyguard.lxc.internal.e.i.c r16 = r9;
    L121:
    L83:
        e = e;
        c r13 = r1;
    L105:
        a(r13, "session_finished", e.getResult(), r7, "start", null, null, 48, null);
        throw e;
    L85:
        e = e;
        c r14 = r1;
    L22:
        long r15 = r7;
    L109:
        a(r14, "session_finished", com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.h(), r15, "start", null, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), 16, null);
        throw e;
    L81:
        th = move-exception;
        Throwable r18 = th;
        c r17 = r1;
    L17:
        long r19 = r7;
    L101:
        SidecarResult r0 = com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.c("credential store operation failed");
        a(r17, "session_finished", r0, r19, "start", null, r18, 16, null);
        throw new SidecarOperationException(r0);
    L53:
        if (((com.bytedance.safetyguard.lxc.internal.e.i.d) ZeusTransformUtils.preCheckCast(r3, com.bytedance.safetyguard.lxc.internal.e.i.d.class, "com.obric.aiagent.plugin")) == null) goto L80;
        Long r20 = r10.getTtlSeconds();     // Catch: Throwable -> L81 SidecarOperationException -> L83 CancellationException -> L85
        if (r20 == null) goto L70;
        long r110 = ((Number) ZeusTransformUtils.preCheckCast(r20, Number.class, "com.obric.aiagent.plugin")).longValue();     // Catch: Throwable -> L81 SidecarOperationException -> L83 CancellationException -> L85
        if (r110 <= 0) goto L69;
        d.n.a r21 = d.n.f38560a;     // Catch: Throwable -> L61
        c r22 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
        Object r23 = d.n.f(d.c.b.a.b.a(Math.multiplyExact(r110, 1000)));     // Catch: Throwable -> L61
    L64:
        if (d.n.c(r23) != null) goto L67;
        long r111 = ((Number) ZeusTransformUtils.preCheckCast(r23, Number.class, "com.obric.aiagent.plugin")).longValue();     // Catch: Throwable -> L81 SidecarOperationException -> L83 CancellationException -> L85
    L113:
        com.bytedance.safetyguard.lxc.internal.e.g.a r24 = r1.j.a(r10.getCliName(), r16.a(), r12, r16.c(), r16.c().getSidecarAllowedHosts$safetyguard_runtime_release(), r111);     // Catch: IllegalArgumentException -> L75 ArithmeticException -> L77 Throwable -> L81 SidecarOperationException -> L83 CancellationException -> L85
        SidecarSessionEnv r27 = new SidecarSessionEnv(r24.a(), r24.g(), r16.a(), r24.e(), r16.c());     // Catch: Throwable -> L81 SidecarOperationException -> L83 CancellationException -> L85
        r1.h.b("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(new ai(r1, r7, r16, r27), d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L81 SidecarOperationException -> L83 CancellationException -> L85
        return r27;
    L78:
        throw new SidecarOperationException(com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.d());     // Catch: Throwable -> L81 SidecarOperationException -> L83 CancellationException -> L85
    L76:
        throw new SidecarOperationException(com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.d());     // Catch: Throwable -> L81 SidecarOperationException -> L83 CancellationException -> L85
    L67:
        throw new SidecarOperationException(com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.d());     // Catch: Throwable -> L81 SidecarOperationException -> L83 CancellationException -> L85
    L61:
        th = move-exception;
        d.n.a r28 = d.n.f38560a;     // Catch: Throwable -> L81 SidecarOperationException -> L83 CancellationException -> L85
        r23 = d.n.f(d.o.a(th));     // Catch: Throwable -> L81 SidecarOperationException -> L83 CancellationException -> L85
        goto L64
    L69:
        throw new SidecarOperationException(com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.d());     // Catch: Throwable -> L81 SidecarOperationException -> L83 CancellationException -> L85
    L70:
        r111 = r1.f10548b.getSessionTtlMillis();     // Catch: Throwable -> L81 SidecarOperationException -> L83 CancellationException -> L85
        goto L113
    L80:
        throw new SidecarOperationException(com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.b(r16.a(), r12));     // Catch: Throwable -> L81 SidecarOperationException -> L83 CancellationException -> L85
    L18:
        e = e;
        r13 = r11;
    L20:
        e = e;
        r14 = r11;
    L15:
        th = move-exception;
        r18 = th;
        r17 = r11;
        goto L17
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L25:
        long r29 = r4.f10577e;
        StartSidecarSessionRequest r30 = (StartSidecarSessionRequest) ZeusTransformUtils.preCheckCast(r4.f10574b, StartSidecarSessionRequest.class, "com.obric.aiagent.plugin");
        c r31 = (c) ZeusTransformUtils.preCheckCast(r4.f10573a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L28 SidecarOperationException -> L31 CancellationException -> L34
        StartSidecarSessionRequest r32 = r30;
        r1 = r31;
    L122:
        com.bytedance.safetyguard.lxc.internal.e.i.c r33 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r3, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L93 SidecarOperationException -> L95 CancellationException -> L97
        if (r33 == null) goto L92;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r33.b(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L90;
        r12 = r33.d();     // Catch: Throwable -> L93 SidecarOperationException -> L95 CancellationException -> L97
        if (r12 == null) goto L88;
        com.bytedance.safetyguard.lxc.internal.e.i.b r112 = r1.f10550d;     // Catch: Throwable -> L93 SidecarOperationException -> L95 CancellationException -> L97
        String r113 = r33.a();     // Catch: Throwable -> L93 SidecarOperationException -> L95 CancellationException -> L97
        r4.f10573a = r1;     // Catch: Throwable -> L93 SidecarOperationException -> L95 CancellationException -> L97
        r4.f10574b = r32;     // Catch: Throwable -> L93 SidecarOperationException -> L95 CancellationException -> L97
        r4.f10575c = r33;     // Catch: Throwable -> L93 SidecarOperationException -> L95 CancellationException -> L97
        r4.f10576d = r12;     // Catch: Throwable -> L93 SidecarOperationException -> L95 CancellationException -> L97
        r4.f10577e = r29;     // Catch: Throwable -> L93 SidecarOperationException -> L95 CancellationException -> L97
        r4.h = 2;     // Catch: Throwable -> L93 SidecarOperationException -> L95 CancellationException -> L97
        Object r34 = r112.a(r113, r12, r4);     // Catch: Throwable -> L93 SidecarOperationException -> L95 CancellationException -> L97
        if (r34 != r5) goto L51;
        return r5;
    L51:
        r16 = r33;
        r3 = r34;
        long r210 = r29;
        r10 = r32;
        r7 = r210;
        goto L121
    L88:
        throw new SidecarOperationException(com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.g(r33.a()));     // Catch: Throwable -> L93 SidecarOperationException -> L95 CancellationException -> L97
    L90:
        throw new SidecarOperationException(com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.f(r33.a()));     // Catch: Throwable -> L93 SidecarOperationException -> L95 CancellationException -> L97
    L92:
        throw new SidecarOperationException(com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.a("app is not configured", "call configCreateApp or configImportApp before startSession"));     // Catch: Throwable -> L93 SidecarOperationException -> L95 CancellationException -> L97
    L95:
        e = e;
        r13 = r1;
    L33:
        r7 = r29;
    L97:
        e = e;
        r14 = r1;
    L36:
        r15 = r29;
    L93:
        th = move-exception;
        r18 = th;
        r17 = r1;
    L30:
        r19 = r29;
        goto L101
    L31:
        e = e;
        r13 = r31;
    L34:
        e = e;
        r14 = r31;
    L28:
        th = move-exception;
        r18 = th;
        r17 = r31;
        goto L30
    L37:
        d.o.a(r3);
        long r114 = ((Number) ZeusTransformUtils.preCheckCast(r1.f10549c.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        r1.h.b("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(ah.f10578a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        com.bytedance.safetyguard.lxc.internal.e.i.b r35 = r1.f10550d;     // Catch: Throwable -> L99 SidecarOperationException -> L103 CancellationException -> L107
        r4.f10573a = r1;     // Catch: Throwable -> L99 SidecarOperationException -> L103 CancellationException -> L107
        r32 = r25;
        r4.f10574b = r32;     // Catch: Throwable -> L99 SidecarOperationException -> L103 CancellationException -> L107
        r4.f10577e = r114;     // Catch: Throwable -> L99 SidecarOperationException -> L103 CancellationException -> L107
        r4.h = 1;     // Catch: Throwable -> L99 SidecarOperationException -> L103 CancellationException -> L107
        r3 = r35.a(r4);     // Catch: Throwable -> L99 SidecarOperationException -> L103 CancellationException -> L107
        if (r3 != r5) goto L41;
        return r5;
    L41:
        r29 = r114;
        goto L122
    L103:
        e = e;
        r13 = r1;
        r7 = r114;
    L107:
        e = e;
        r14 = r1;
        r15 = r114;
    L99:
        th = move-exception;
        r18 = th;
        r19 = r114;
        r17 = r1;
    L7:
        r4 = new ag(r1, r2);
        goto L8
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public Object endSession(String r6, d.c.d<? super Boolean> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        this.h.a("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(new n(this, r6), d.h.a.a.class, "com.obric.aiagent.plugin"));
        Boolean r9 = d.c.b.a.b.a(this.j.a(r6));
        boolean r0 = r9.booleanValue();
        this.h.b("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(new o(r0, this, r6), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return r9;
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecarInternal
    public SidecarAuthHandler authHandlerInternal() {
        return (SidecarAuthHandler) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.b.g(this.f10548b.getMaxRequestBodyBytes(), (SidecarAuthHandler) ZeusTransformUtils.preCheckCast(a(this, null, (com.bytedance.safetyguard.lxc.internal.e.d.d) ZeusTransformUtils.preCheckCast(new C0237c(this), com.bytedance.safetyguard.lxc.internal.e.d.d.class, "com.obric.aiagent.plugin"), 1, null), SidecarAuthHandler.class, "com.obric.aiagent.plugin")), SidecarAuthHandler.class, "com.obric.aiagent.plugin");
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        c();
        an.a(this.i, "sidecar service host closed", null, 2, null);
        this.j.a();
    }

    public static /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.d.b a(c r1, d.h.a.a r2, com.bytedance.safetyguard.lxc.internal.e.d.d r3, int r4, Object r5) {
        d.h.a.a<Long> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.d.d r7 = (com.bytedance.safetyguard.lxc.internal.e.d.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.safetyguard.lxc.internal.e.d.d.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = (d.h.a.a) ZeusTransformUtils.preCheckCast(m.f10632a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L6:
        return r1.a(r6, r7);
    }

    public final com.bytedance.safetyguard.lxc.internal.e.d.b a(d.h.a.a<Long> r9, com.bytedance.safetyguard.lxc.internal.e.d.d r10) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.d.d r5 = (com.bytedance.safetyguard.lxc.internal.e.d.d) ZeusTransformUtils.wrapperContextForParams(r10, com.bytedance.safetyguard.lxc.internal.e.d.d.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "nowMillis");
        d.h.b.o.e(r5, "handler");
        return new com.bytedance.safetyguard.lxc.internal.e.d.b(this.f10548b, this.j, r5, r6, this.h);
    }

    private final com.bytedance.safetyguard.lxc.internal.e.b.b b() {
        com.bytedance.safetyguard.lxc.internal.e.b.b r0 = new com.bytedance.safetyguard.lxc.internal.e.b.b(this.l.incrementAndGet(), f10547a.a("config-app"));
        if (this.k.compareAndSet(null, r0) == false) goto L6;
        return r0;
    L6:
        return null;
    }

    private final boolean a(com.bytedance.safetyguard.lxc.internal.e.b.b r1) {
        return d.h.b.o.a(this.k.get(), r1);
    }

    private final void b(com.bytedance.safetyguard.lxc.internal.e.b.b r2) {
        this.k.compareAndSet(r2, null);
    }

    private final void c() {
        if (((com.bytedance.safetyguard.lxc.internal.e.b.b) ZeusTransformUtils.preCheckCast(this.k.getAndSet(null), com.bytedance.safetyguard.lxc.internal.e.b.b.class, "com.obric.aiagent.plugin")) == null) goto L6;
        this.l.incrementAndGet();
        return;
    }

    private final void a(String r18, String r19, long r20, com.bytedance.safetyguard.lxc.internal.e.b.j r22, Throwable r23) {
        SidecarResult r0 = com.bytedance.safetyguard.lxc.internal.e.b.m.a(com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a, r18, "credential_store_failed", 500, "credential store operation failed", "retry the operation; clear app configuration if the failure persists", null, null, null, 224, null);
        this.h.a("DefaultSafetyGuardSidecar", r23, (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(r19, r0, this, r20), d.h.a.a.class, "com.obric.aiagent.plugin"));
        r22.a(r0);
    }

    static /* synthetic */ void a(c r10, String r11, SidecarResult r12, long r13, String r15, com.bytedance.safetyguard.lxc.internal.e.b.n r16, Throwable r17, int r18, Object r19) {
        if ((r18 & 8) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r18 & 16) != 0) goto L9;
        com.bytedance.safetyguard.lxc.internal.e.b.n r8 = r16;
    L15:
        if ((r18 & 32) == 0) goto L17;
        Throwable r9 = null;
    L18:
        r10.a(r11, r12, r13, r7, r8, r9);
        return;
    L17:
        r9 = r17;
        goto L18
    L9:
        if (r12.getSuccess() == false) goto L11;
        com.bytedance.safetyguard.lxc.internal.e.b.n r0 = com.bytedance.safetyguard.lxc.internal.e.b.n.f10706a;
    L12:
        r8 = r0;
        goto L15
    L11:
        r0 = com.bytedance.safetyguard.lxc.internal.e.b.n.f10707b;
        goto L12
    L5:
        r7 = r15;
        goto L7
    }

    private final void a(String r9, SidecarResult r10, long r11, String r13, com.bytedance.safetyguard.lxc.internal.e.b.n r14, Throwable r15) {
        d.h.a.a<String> r12 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new p(r9, r10, r13, this, r11), d.h.a.a.class, "com.obric.aiagent.plugin");
        int r16 = b.f10587a[r14.ordinal()];
        if (r16 != 1) goto L5;
        this.h.b("DefaultSafetyGuardSidecar", r12);
        return;
    L5:
        if (r16 != 2) goto L7;
        this.h.a("DefaultSafetyGuardSidecar", r15, r12);
        return;
    L7:
        if (r16 != 3) goto L15;
        this.h.b("DefaultSafetyGuardSidecar", r15, r12);
        return;
    }

    static /* synthetic */ void a(c r11, AtomicBoolean r12, String r13, SidecarResult r14, long r15, String r17, com.bytedance.safetyguard.lxc.internal.e.b.n r18, Throwable r19, int r20, Object r21) {
        if ((r20 & 16) == 0) goto L5;
        String r8 = null;
    L7:
        if ((r20 & 32) != 0) goto L9;
        com.bytedance.safetyguard.lxc.internal.e.b.n r9 = r18;
    L15:
        if ((r20 & 64) == 0) goto L17;
        Throwable r10 = null;
    L18:
        r11.a(r12, r13, r14, r15, r8, r9, r10);
        return;
    L17:
        r10 = r19;
        goto L18
    L9:
        if (r14.getSuccess() == false) goto L11;
        com.bytedance.safetyguard.lxc.internal.e.b.n r0 = com.bytedance.safetyguard.lxc.internal.e.b.n.f10706a;
    L12:
        r9 = r0;
        goto L15
    L11:
        r0 = com.bytedance.safetyguard.lxc.internal.e.b.n.f10707b;
        goto L12
    L5:
        r8 = r17;
        goto L7
    }

    private final void a(AtomicBoolean r9, String r10, SidecarResult r11, long r12, String r14, com.bytedance.safetyguard.lxc.internal.e.b.n r15, Throwable r16) {
        if (r9.compareAndSet(false, true) == false) goto L6;
        a(r10, r11, r12, r14, r15, r16);
        return;
    }

    static /* synthetic */ Object a(c r11, String r12, Set r13, com.bytedance.safetyguard.lxc.internal.e.b.j r14, com.bytedance.safetyguard.lxc.internal.e.b.h r15, String r16, String r17, String r18, d.c.d r19, int r20, Object r21) {
        Set<String> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r20 & 16) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r20 & 32) == 0) goto L9;
        String r8 = "authentication";
    L11:
        if ((r20 & 64) == 0) goto L13;
        String r9 = "login_finished";
    L15:
        return r11.a(r12, r4, r14, r15, r7, r8, r9, r10);
    L13:
        r9 = r18;
        goto L15
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object a(String r28, Set<String> r29, com.bytedance.safetyguard.lxc.internal.e.b.j r30, com.bytedance.safetyguard.lxc.internal.e.b.h r31, String r32, String r33, String r34, d.c.d<? super d.x> r35) {
        Set<String> r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r29, Set.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r35, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, s.class) == false) goto L7;
        s r5 = (s) ZeusTransformUtils.preCheckCast(r4, s.class, "com.obric.aiagent.plugin");
        if ((r5.l & Integer.MIN_VALUE) == 0) goto L7;
        r5.l -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.j;
        Object r7 = d.c.a.b.a();
        int r8 = r5.l;
        if (r8 == 0) goto L39;
        if (r8 == 1) goto L38;
        if (r8 == 2) goto L31;
        if (r8 == 3) goto L24;
        if (r8 != 4) goto L23;
        long r9 = r5.i;
        com.bytedance.safetyguard.lxc.internal.e.a.v r0 = (com.bytedance.safetyguard.lxc.internal.e.a.v) ZeusTransformUtils.preCheckCast(r5.f, com.bytedance.safetyguard.lxc.internal.e.a.v.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.i.c r3 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r5.f10653e, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r5.f10652d, String.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r5.f10651c, String.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.b.j r12 = (com.bytedance.safetyguard.lxc.internal.e.b.j) ZeusTransformUtils.preCheckCast(r5.f10650b, com.bytedance.safetyguard.lxc.internal.e.b.j.class, "com.obric.aiagent.plugin");
        c r1 = (c) ZeusTransformUtils.preCheckCast(r5.f10649a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L17 CancellationException -> L20
        com.bytedance.safetyguard.lxc.internal.e.a.m r13 = null;
        com.bytedance.safetyguard.lxc.internal.e.b.j r14 = r12;
    L134:
    L87:
        th = th;
        com.bytedance.safetyguard.lxc.internal.e.b.j r15 = r14;
    L19:
        String r16 = r10;
        long r17 = r9;
        com.bytedance.safetyguard.lxc.internal.e.b.j r18 = r15;
    L107:
        if (ZeusTransformUtils.instanceOf(th, com.bytedance.safetyguard.lxc.internal.e.a.m.class) == false) goto L109;
        com.bytedance.safetyguard.lxc.internal.e.a.m r19 = (com.bytedance.safetyguard.lxc.internal.e.a.m) ZeusTransformUtils.preCheckCast(th, com.bytedance.safetyguard.lxc.internal.e.a.m.class, "com.obric.aiagent.plugin");
    L110:
        if (r19 == null) goto L112;
        Object r20 = com.bytedance.safetyguard.lxc.internal.e.b.d.a(r11, "device-authorization", r19, r3.a());
    L113:
        com.bytedance.safetyguard.lxc.internal.e.b.e r21 = com.bytedance.safetyguard.lxc.internal.e.b.d.a(th);
        SidecarResult r22 = r20;
        if (r20 == null) goto L116;
    L119:
        d.h.a.a<String> r23 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new aa(r16, r22, r1, r17, r3), d.h.a.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(th, com.bytedance.safetyguard.lxc.internal.e.a.m.class) == false) goto L122;
        r1.h.b("DefaultSafetyGuardSidecar", r23);
    L123:
        r18.a(r22);
    L125:
        return d.x.f38692a;
    L122:
        r1.h.a("DefaultSafetyGuardSidecar", th, r23);
        goto L123
    L116:
        if (ZeusTransformUtils.instanceOf(th, com.bytedance.safetyguard.lxc.internal.e.a.m.class) == false) goto L118;
        r13 = (com.bytedance.safetyguard.lxc.internal.e.a.m) ZeusTransformUtils.preCheckCast(th, com.bytedance.safetyguard.lxc.internal.e.a.m.class, "com.obric.aiagent.plugin");
    L118:
        r22 = com.bytedance.safetyguard.lxc.internal.e.b.d.a(r11, r13, r3.a(), (d.h.a.a) ZeusTransformUtils.preCheckCast(new z(r21, th, r3), d.h.a.a.class, "com.obric.aiagent.plugin"));
        goto L119
    L112:
        r20 = r13;
        goto L113
    L109:
        r19 = r13;
        goto L110
    L82:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L84;
        r1.h.b("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(new y(r10, r1, r9, r3, r0), d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: CancellationException -> L20 Throwable -> L87
        r14.a(com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.a(r3.a(), r0.a(), r0.g()));     // Catch: CancellationException -> L20 Throwable -> L87
        goto L125
    L84:
        return d.x.f38692a;
    L20:
        e = e;
        long r24 = r9;
        String r25 = r10;
    L128:
        a(r1, r25, com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.h(), r24, null, null, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), 24, null);
        throw e;
    L17:
        th = th;
        r15 = r12;
        r13 = null;
        goto L19
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L24:
        long r26 = r5.i;
        r3 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r5.g, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
        String r27 = (String) ZeusTransformUtils.preCheckCast(r5.f, String.class, "com.obric.aiagent.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r5.f10653e, String.class, "com.obric.aiagent.plugin");
        String r36 = (String) ZeusTransformUtils.preCheckCast(r5.f10652d, String.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.b.h r111 = (com.bytedance.safetyguard.lxc.internal.e.b.h) ZeusTransformUtils.preCheckCast(r5.f10651c, com.bytedance.safetyguard.lxc.internal.e.b.h.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.b.j r37 = (com.bytedance.safetyguard.lxc.internal.e.b.j) ZeusTransformUtils.preCheckCast(r5.f10650b, com.bytedance.safetyguard.lxc.internal.e.b.j.class, "com.obric.aiagent.plugin");
        r1 = (c) ZeusTransformUtils.preCheckCast(r5.f10649a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L27 CancellationException -> L29
        String r38 = r36;
        Object r39 = r7;
        Object r40 = r6;
        com.bytedance.safetyguard.lxc.internal.e.i.c r41 = r3;
        c r42 = r1;
        r16 = r27;
        r11 = r110;
        com.bytedance.safetyguard.lxc.internal.e.b.j r112 = r37;
        r17 = r26;
    L140:
        com.bytedance.safetyguard.lxc.internal.e.a.v r43 = (com.bytedance.safetyguard.lxc.internal.e.a.v) ZeusTransformUtils.preCheckCast(r40, com.bytedance.safetyguard.lxc.internal.e.a.v.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L91 CancellationException -> L94
        if (r38 == null) goto L73;
    L70:
        th = th;
        r1 = r42;
        r3 = r41;
    L97:
        r13 = null;
        r18 = r112;
        goto L107
    L66:
        if (d.h.b.o.a(r43.a(), r38) == true) goto L73;
        throw new com.bytedance.safetyguard.lxc.internal.e.a.m("principal_mismatch", "login principal mismatch", null, null, null, 28, null);     // Catch: Throwable -> L70 CancellationException -> L94
    L73:
        r13 = null;
    L89:
        th = th;
    L93:
        r1 = r42;
        r3 = r41;
        r18 = r112;
        goto L107
    L75:
        d.h.a.b<? super d.c.d<? super d.x>, ? extends Object> r44 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new x(r42, r43, r41, null), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L91 CancellationException -> L94
        r5.f10649a = r42;     // Catch: Throwable -> L91 CancellationException -> L94
        r5.f10650b = r112;     // Catch: Throwable -> L91 CancellationException -> L94
        r5.f10651c = r11;     // Catch: Throwable -> L91 CancellationException -> L94
        r5.f10652d = r16;     // Catch: Throwable -> L91 CancellationException -> L94
        r5.f10653e = r41;     // Catch: Throwable -> L91 CancellationException -> L94
        r5.f = r43;     // Catch: Throwable -> L91 CancellationException -> L94
        r13 = null;
        r5.g = null;     // Catch: Throwable -> L89 CancellationException -> L94
        r5.i = r17;     // Catch: Throwable -> L89 CancellationException -> L94
        r5.l = 4;     // Catch: Throwable -> L89 CancellationException -> L94
        Object r45 = r111.a(r44, r5);     // Catch: Throwable -> L89 CancellationException -> L94
        if (r45 != r39) goto L80;
        return r39;
    L80:
        r0 = r43;
        r9 = r17;
        r10 = r16;
        r14 = r112;
        com.bytedance.safetyguard.lxc.internal.e.i.c r210 = r41;
        r6 = r45;
        r1 = r42;
        r3 = r210;
    L91:
        th = th;
        r13 = null;
    L94:
        e = e;
        r1 = r42;
    L37:
        r24 = r17;
        r25 = r16;
        goto L128
    L29:
        e = e;
        r25 = r27;
        r24 = r26;
    L27:
        th = th;
        r13 = null;
        r16 = r27;
        r11 = r110;
        r18 = r37;
        r17 = r26;
        goto L107
    L31:
        r17 = r5.i;
        r3 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r5.g, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
        r16 = (String) ZeusTransformUtils.preCheckCast(r5.f, String.class, "com.obric.aiagent.plugin");
        String r113 = (String) ZeusTransformUtils.preCheckCast(r5.f10653e, String.class, "com.obric.aiagent.plugin");
        String r46 = (String) ZeusTransformUtils.preCheckCast(r5.f10652d, String.class, "com.obric.aiagent.plugin");
        r111 = (com.bytedance.safetyguard.lxc.internal.e.b.h) ZeusTransformUtils.preCheckCast(r5.f10651c, com.bytedance.safetyguard.lxc.internal.e.b.h.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.b.j r47 = (com.bytedance.safetyguard.lxc.internal.e.b.j) ZeusTransformUtils.preCheckCast(r5.f10650b, com.bytedance.safetyguard.lxc.internal.e.b.j.class, "com.obric.aiagent.plugin");
        r1 = (c) ZeusTransformUtils.preCheckCast(r5.f10649a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L34 CancellationException -> L36
        r112 = r47;
        r11 = r113;
    L145:
        com.bytedance.safetyguard.lxc.internal.e.a.j r48 = (com.bytedance.safetyguard.lxc.internal.e.a.j) ZeusTransformUtils.preCheckCast(r6, com.bytedance.safetyguard.lxc.internal.e.a.j.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L36 Throwable -> L96
        Object r114 = r7;
        r1.h.b("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(new v(r1, r3, r48), d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: CancellationException -> L36 Throwable -> L96
        r112.a(r48.b(), r48.c());     // Catch: CancellationException -> L36 Throwable -> L96
        r1.h.a("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(new w(r1, r3), d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: CancellationException -> L36 Throwable -> L96
        com.bytedance.safetyguard.lxc.internal.e.a.l r49 = r1.f10551e;     // Catch: CancellationException -> L36 Throwable -> L96
        String r115 = r3.a();     // Catch: CancellationException -> L36 Throwable -> L96
        String r116 = r3.b();     // Catch: CancellationException -> L36 Throwable -> L96
        SidecarBrand r117 = r3.c();     // Catch: CancellationException -> L36 Throwable -> L96
        String r118 = r48.a();     // Catch: CancellationException -> L36 Throwable -> L96
        int r211 = r48.d();     // Catch: CancellationException -> L36 Throwable -> L96
        int r212 = r48.c();     // Catch: CancellationException -> L36 Throwable -> L96
        Set<String> r50 = r48.e();     // Catch: CancellationException -> L36 Throwable -> L96
        r5.f10649a = r1;     // Catch: CancellationException -> L36 Throwable -> L96
        r5.f10650b = r112;     // Catch: CancellationException -> L36 Throwable -> L96
        r5.f10651c = r111;     // Catch: CancellationException -> L36 Throwable -> L96
        r5.f10652d = r46;     // Catch: CancellationException -> L36 Throwable -> L96
        r5.f10653e = r11;     // Catch: CancellationException -> L36 Throwable -> L96
        r5.f = r16;     // Catch: CancellationException -> L36 Throwable -> L96
        r5.g = r3;     // Catch: CancellationException -> L36 Throwable -> L96
        r5.i = r17;     // Catch: CancellationException -> L36 Throwable -> L96
        String r213 = r46;
        r5.l = 3;     // Catch: CancellationException -> L36 Throwable -> L96
        Object r51 = r49.a(r115, r116, r117, r118, r211, r212, r50, r5);     // Catch: CancellationException -> L36 Throwable -> L96
        r39 = r114;
        if (r51 != r39) goto L62;
        return r39;
    L62:
        r40 = r51;
        r41 = r3;
        r42 = r1;
        r38 = r213;
        r112 = r112;
        goto L140
    L96:
        th = th;
    L34:
        th = th;
        r13 = null;
        r18 = r47;
        r11 = r113;
    L36:
        e = e;
        goto L37
    L38:
        r17 = r5.i;
        String r52 = (String) ZeusTransformUtils.preCheckCast(r5.h, String.class, "com.obric.aiagent.plugin");
        String r53 = (String) ZeusTransformUtils.preCheckCast(r5.g, String.class, "com.obric.aiagent.plugin");
        String r54 = (String) ZeusTransformUtils.preCheckCast(r5.f, String.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.b.h r119 = (com.bytedance.safetyguard.lxc.internal.e.b.h) ZeusTransformUtils.preCheckCast(r5.f10653e, com.bytedance.safetyguard.lxc.internal.e.b.h.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.b.j r120 = (com.bytedance.safetyguard.lxc.internal.e.b.j) ZeusTransformUtils.preCheckCast(r5.f10652d, com.bytedance.safetyguard.lxc.internal.e.b.j.class, "com.obric.aiagent.plugin");
        Set<String> r121 = (Set) ZeusTransformUtils.preCheckCast(r5.f10651c, Set.class, "com.obric.aiagent.plugin");
        String r122 = (String) ZeusTransformUtils.preCheckCast(r5.f10650b, String.class, "com.obric.aiagent.plugin");
        r1 = (c) ZeusTransformUtils.preCheckCast(r5.f10649a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        String r123 = r52;
        r46 = r54;
        com.bytedance.safetyguard.lxc.internal.e.b.j r55 = r120;
        com.bytedance.safetyguard.lxc.internal.e.b.h r124 = r119;
    L43:
        com.bytedance.safetyguard.lxc.internal.e.i.c r56 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r6, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
        if (r56 != null) goto L46;
    L130:
        r1.h.b("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(new t(r123, r1, r17, r122), d.h.a.a.class, "com.obric.aiagent.plugin"));
        r55.a(com.bytedance.safetyguard.lxc.internal.e.b.m.f10705a.e(r122));
        return d.x.f38692a;
    L46:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r122, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L48;
    L132:
        r1.h.a("DefaultSafetyGuardSidecar", (d.h.a.a) ZeusTransformUtils.preCheckCast(new u(r1, r56, r121), d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L102 CancellationException -> L126
        com.bytedance.safetyguard.lxc.internal.e.a.l r57 = r1.f10551e;     // Catch: Throwable -> L102 CancellationException -> L126
        String r125 = r56.a();     // Catch: Throwable -> L102 CancellationException -> L126
        String r126 = r56.b();     // Catch: Throwable -> L102 CancellationException -> L126
        SidecarBrand r127 = r56.c();     // Catch: Throwable -> L102 CancellationException -> L126
        r5.f10649a = r1;     // Catch: Throwable -> L102 CancellationException -> L126
        r5.f10650b = r55;     // Catch: Throwable -> L102 CancellationException -> L126
        r5.f10651c = r124;     // Catch: Throwable -> L102 CancellationException -> L126
        r5.f10652d = r46;     // Catch: Throwable -> L102 CancellationException -> L126
        r5.f10653e = r53;     // Catch: Throwable -> L102 CancellationException -> L126
        r5.f = r123;     // Catch: Throwable -> L102 CancellationException -> L126
        r5.g = r56;     // Catch: Throwable -> L102 CancellationException -> L126
        String r128 = r53;
        r5.h = null;     // Catch: Throwable -> L100 CancellationException -> L126
        r5.i = r17;     // Catch: Throwable -> L98 CancellationException -> L126
        r5.l = 2;     // Catch: Throwable -> L98 CancellationException -> L126
        Object r58 = r57.a(r125, r126, r127, r121, r5);     // Catch: Throwable -> L98 CancellationException -> L126
        r7 = r7;
        if (r58 != r7) goto L57;
        return r7;
    L57:
        r112 = r55;
        r11 = r128;
        r6 = r58;
        r3 = r56;
        String r214 = r123;
        r111 = r124;
        r16 = r214;
        goto L145
    L98:
        th = th;
    L104:
        r13 = null;
    L105:
        r3 = r56;
        r18 = r55;
        r16 = r123;
        r11 = r128;
    L100:
        th = th;
        r13 = null;
    L126:
        e = e;
        r24 = r17;
        r25 = r123;
    L102:
        th = th;
        r128 = r53;
        goto L104
    L48:
        if (d.h.b.o.a(r56.a(), r122) == true) goto L132;
    L39:
        d.o.a(r6);
        r17 = ((Number) ZeusTransformUtils.preCheckCast(this.f10549c.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        com.bytedance.safetyguard.lxc.internal.e.i.b r59 = this.f10550d;
        r5.f10649a = this;
        r5.f10650b = r28;
        r5.f10651c = r2;
        r55 = r30;
        r5.f10652d = r55;
        r124 = r31;
        r5.f10653e = r124;
        r5.f = r32;
        r5.g = r33;
        r123 = r34;
        r5.h = r123;
        r5.i = r17;
        r5.l = 1;
        Object r60 = r59.a(r5);
        if (r60 != r7) goto L42;
        return r7;
    L42:
        r1 = this;
        r46 = r32;
        r122 = r28;
        r6 = r60;
        r121 = r2;
        r53 = r33;
    L7:
        r5 = new s(this, r4);
        goto L8
    }

    private final Object a(String r6, d.c.d<? super String> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, af.class) == false) goto L7;
        af r0 = (af) ZeusTransformUtils.preCheckCast(r8, af.class, "com.obric.aiagent.plugin");
        if ((r0.f10572c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f10572c -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f10570a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f10572c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r9);
    L19:
        com.bytedance.safetyguard.lxc.internal.e.i.c r5 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r9, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L22;
        String r10 = r5.a();
    L23:
        String r11 = r10;
        if (r11 != null) goto L28;
        return "";
    L28:
        return r11;
    L22:
        r10 = null;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r9);
        if (r6 != null) goto L27;
        com.bytedance.safetyguard.lxc.internal.e.i.b r12 = this.f10550d;
        r0.f10572c = 1;
        r9 = r12.a(r0);
        if (r9 != r2) goto L19;
        return r2;
    L27:
        return r6;
    L7:
        r0 = new af(this, r8);
        goto L8
    }
}
