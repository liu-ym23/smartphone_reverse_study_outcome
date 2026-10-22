package com.bytedance.safetyguard.lxc.internal.client;

import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarAccountStatus;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarAppInfo;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarDeviceFlowCallback;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperationException;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarResult;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarSessionEnv;
import com.bytedance.safetyguard.lxc.api.sidecar.StartSidecarSessionRequest;
import com.bytedance.safetyguard.lxc.internal.ipc.SidecarCommandParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.SidecarResultParcel;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: RemoteSafetyGuardSidecar.kt */
/* JADX INFO: loaded from: classes.dex */
public final class t implements SafetyGuardSidecar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10034a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProxyServiceConnector f10035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<Long> f10036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final am f10037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, ca> f10038e;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.client.t$1, reason: invalid class name */
    /* JADX INFO: compiled from: RemoteSafetyGuardSidecar.kt */
    /* synthetic */ class AnonymousClass1 extends d.h.b.l implements d.h.a.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f10039a = null;

        static {
            f10039a = new AnonymousClass1();
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

    /* JADX INFO: compiled from: RemoteSafetyGuardSidecar.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final String a(String r1) {
            d.h.b.o.e(r1, "prefix");
            return r1 + '-' + UUID.randomUUID();
        }
    }

    /* JADX INFO: compiled from: RemoteSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "RemoteSafetyGuardSidecar.kt", c = {ITaskManager.Stub.TRANSACTION_removeEventTaskExecutionDetailRecordsBySessionId}, d = "configDeleteApp", e = "com.bytedance.safetyguard.lxc.internal.client.RemoteSafetyGuardSidecar")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f10040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ t f10041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f10042c;

        b(t r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10041b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10040a = r3;
            this.f10042c |= Integer.MIN_VALUE;
            return this.f10041b.configDeleteApp((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: RemoteSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "RemoteSafetyGuardSidecar.kt", c = {60}, d = "configImportApp", e = "com.bytedance.safetyguard.lxc.internal.client.RemoteSafetyGuardSidecar")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f10043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ t f10044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f10045c;

        c(t r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10044b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10043a = r3;
            this.f10045c |= Integer.MIN_VALUE;
            return this.f10044b.configImportApp(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: RemoteSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "RemoteSafetyGuardSidecar.kt", c = {116}, d = "configuredApp", e = "com.bytedance.safetyguard.lxc.internal.client.RemoteSafetyGuardSidecar")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f10047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ t f10048c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f10049d;

        d(t r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10048c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10047b = r3;
            this.f10049d |= Integer.MIN_VALUE;
            return this.f10048c.configuredApp((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: RemoteSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "RemoteSafetyGuardSidecar.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.client.RemoteSafetyGuardSidecar$endSession$2")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ t f10051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10052c;

        e(t r3, String r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10051b = r3;
            this.f10052c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f10051b, this.f10052c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f10050a != 0) goto L13;
            d.o.a(r3);
            Object r2 = t.a(this.f10051b).c(this.f10052c);
            Throwable r4 = d.n.c(r2);
            if (r4 != null) goto L7;
            return r2;
        L7:
            String r0 = t.a().a("session-end");
            String r5 = r4.getMessage();
            if (r5 != null) goto L11;
            r5 = "Proxy service is unavailable";
        L11:
            throw new SidecarOperationException(com.bytedance.safetyguard.lxc.internal.ipc.g.a(com.bytedance.safetyguard.lxc.internal.ipc.g.a(r0, r5)));
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: RemoteSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "RemoteSafetyGuardSidecar.kt", c = {188}, d = "execute", e = "com.bytedance.safetyguard.lxc.internal.client.RemoteSafetyGuardSidecar")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f10055c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ t f10056d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f10057e;

        f(t r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10056d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10055c = r3;
            this.f10057e |= Integer.MIN_VALUE;
            return t.a(this.f10056d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: RemoteSafetyGuardSidecar.kt */
    public static final class g implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.w<SidecarResultParcel> f10058a;

        @Override // com.bytedance.safetyguard.lxc.internal.client.u
        public void a(String r1, int r2) {
            d.h.b.o.e(r1, "url");
        }

        g(kotlinx.coroutines.w<SidecarResultParcel> r3) {
            this.f10058a = (kotlinx.coroutines.w) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.w.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.safetyguard.lxc.internal.client.u
        public void a(SidecarResultParcel r2) {
            d.h.b.o.e(r2, "result");
            this.f10058a.a(r2);
        }
    }

    /* JADX INFO: compiled from: RemoteSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "RemoteSafetyGuardSidecar.kt", c = {105}, d = "logout", e = "com.bytedance.safetyguard.lxc.internal.client.RemoteSafetyGuardSidecar")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f10059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ t f10060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f10061c;

        h(t r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10060b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10059a = r3;
            this.f10061c |= Integer.MIN_VALUE;
            return this.f10060b.logout((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: RemoteSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "RemoteSafetyGuardSidecar.kt", c = {197, 198}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.client.RemoteSafetyGuardSidecar$scheduleLocalSessionExpiry$job$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SidecarSessionEnv f10063b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ t f10064c;

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.client.t$i$1, reason: invalid class name */
        /* JADX INFO: compiled from: RemoteSafetyGuardSidecar.kt */
        @d.c.b.a.f(b = "RemoteSafetyGuardSidecar.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.client.RemoteSafetyGuardSidecar$scheduleLocalSessionExpiry$job$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.n<? extends Boolean>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f10065a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ t f10066b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SidecarSessionEnv f10067c;

            AnonymousClass1(t r3, SidecarSessionEnv r4, d.c.d<? super AnonymousClass1> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f10066b = r3;
                this.f10067c = r4;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super d.n<Boolean>> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f10066b, this.f10067c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super d.n<? extends Boolean>> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f10065a != 0) goto L7;
                d.o.a(r2);
                return d.n.g(t.a(this.f10066b).c(this.f10067c.getSessionId()));
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        i(SidecarSessionEnv r3, t r4, d.c.d<? super i> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10063b = r3;
            this.f10064c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f10063b, this.f10064c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10062a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r10);
        L16:
            t.c(this.f10064c).remove(this.f10063b.getSessionId());
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r10);
        L13:
            d.c.g r11 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin");
            d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f10064c, this.f10063b, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10062a = 2;
            if (kotlinx.coroutines.i.a(r11, r2, r3) != r0) goto L16;
            return r0;
        L10:
            d.o.a(r10);
            long r5 = d.l.n.a(this.f10063b.getExpiresAtMillis() - ((Number) ZeusTransformUtils.preCheckCast(t.b(this.f10064c).invoke(), Number.class, "com.obric.aiagent.plugin")).longValue(), 0);
            d.c.d r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10062a = 1;
            if (ax.a(r5, r12) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: RemoteSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "RemoteSafetyGuardSidecar.kt", c = {122}, d = "startSession", e = "com.bytedance.safetyguard.lxc.internal.client.RemoteSafetyGuardSidecar")
    static final class j extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f10069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ t f10070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f10071d;

        j(t r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10070c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10069b = r3;
            this.f10071d |= Integer.MIN_VALUE;
            return this.f10070c.startSession(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: RemoteSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "RemoteSafetyGuardSidecar.kt", c = {110}, d = "status", e = "com.bytedance.safetyguard.lxc.internal.client.RemoteSafetyGuardSidecar")
    static final class k extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f10073b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ t f10074c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f10075d;

        k(t r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10074c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10073b = r3;
            this.f10075d |= Integer.MIN_VALUE;
            return this.f10074c.status((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f10034a = new a(null);
    }

    public t(ProxyServiceConnector r3, d.h.a.a<Long> r4, am r5) {
        d.h.a.a<Long> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        am r7 = (am) ZeusTransformUtils.wrapperContextForParams(r5, am.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "connector");
        d.h.b.o.e(r6, "nowMillis");
        d.h.b.o.e(r7, "scope");
        this.f10035b = r3;
        this.f10036c = r6;
        this.f10037d = r7;
        this.f10038e = new ConcurrentHashMap();
    }

    public static final /* synthetic */ ProxyServiceConnector a(t r0) {
        return r0.f10035b;
    }

    public static final /* synthetic */ a a() {
        return f10034a;
    }

    public static final /* synthetic */ Object a(t r2, SidecarCommandParcel r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ d.h.a.a b(t r0) {
        return r0.f10036c;
    }

    public static final /* synthetic */ ConcurrentHashMap c(t r0) {
        return r0.f10038e;
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public int getVersion() {
        return SafetyGuardSidecar.DefaultImpls.getVersion(this);
    }

    public /* synthetic */ t(ProxyServiceConnector r2, d.h.a.a r3, am r4, int r5, d.h.b.h r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        am r8 = (am) ZeusTransformUtils.wrapperContextForParams(r4, am.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r7 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f10039a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L6:
        if ((r5 & 4) == 0) goto L8;
        r8 = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.a(), d.c.g.class, "com.obric.aiagent.plugin")));
    L8:
        this(r2, r7, r8);
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public SidecarOperation configCreateApp(String r16, SidecarDeviceFlowCallback r17) {
        SidecarDeviceFlowCallback r0 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r17, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r16, "production");
        d.h.b.o.e(r0, "callback");
        return a(new SidecarCommandParcel(0, f10034a.a("config-create"), 1, r16, null, null, null, null, 0, 497, null), r0);
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public Object configImportApp(String r21, String r22, String r23, d.c.d<? super SidecarResult> r24) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L7;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");
        if ((r3.f10045c & Integer.MIN_VALUE) == 0) goto L7;
        r3.f10045c -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f10043a;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f10045c;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        d.o.a(r2);
    L18:
        return com.bytedance.safetyguard.lxc.internal.ipc.g.a((SidecarResultParcel) ZeusTransformUtils.preCheckCast(r2, SidecarResultParcel.class, "com.obric.aiagent.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        SidecarCommandParcel r6 = new SidecarCommandParcel(0, f10034a.a("config-import"), 2, r21, r22, r23, null, null, 0, 449, null);
        r3.f10045c = 1;
        r2 = a(r6, r3);
        if (r2 != r4) goto L18;
        return r4;
    L7:
        r3 = new c(this, r1);
        goto L8
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public Object configDeleteApp(d.c.d<? super SidecarResult> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
        if ((r0.f10042c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f10042c -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f10040a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f10042c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r8);
    L18:
        return com.bytedance.safetyguard.lxc.internal.ipc.g.a((SidecarResultParcel) ZeusTransformUtils.preCheckCast(r8, SidecarResultParcel.class, "com.obric.aiagent.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        SidecarCommandParcel r9 = a("config-delete", 3);
        r0.f10042c = 1;
        r8 = a(r9, r0);
        if (r8 != r2) goto L18;
        return r2;
    L7:
        r0 = new b(this, r7);
        goto L8
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public SidecarOperation login(Set<String> r18, SidecarDeviceFlowCallback r19) {
        Set r0 = (Set) ZeusTransformUtils.wrapperContextForParams(r18, Set.class, "com.obric.aiagent.plugin");
        SidecarDeviceFlowCallback r2 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r19, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r0, "scopes");
        d.h.b.o.e(r2, "callback");
        return a(new SidecarCommandParcel(0, f10034a.a("login"), 4, null, null, null, d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")), null, 0, 441, null), r2);
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public SidecarOperation requestGrant(Set<String> r18, SidecarDeviceFlowCallback r19) {
        Set r0 = (Set) ZeusTransformUtils.wrapperContextForParams(r18, Set.class, "com.obric.aiagent.plugin");
        SidecarDeviceFlowCallback r2 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r19, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r0, "scopes");
        d.h.b.o.e(r2, "callback");
        return a(new SidecarCommandParcel(0, f10034a.a("grant"), 5, null, null, null, d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")), null, 0, 441, null), r2);
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public Object logout(d.c.d<? super SidecarResult> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, h.class) == false) goto L7;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r7, h.class, "com.obric.aiagent.plugin");
        if ((r0.f10061c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f10061c -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f10059a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f10061c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r8);
    L18:
        return com.bytedance.safetyguard.lxc.internal.ipc.g.a((SidecarResultParcel) ZeusTransformUtils.preCheckCast(r8, SidecarResultParcel.class, "com.obric.aiagent.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        SidecarCommandParcel r9 = a("logout", 6);
        r0.f10061c = 1;
        r8 = a(r9, r0);
        if (r8 != r2) goto L18;
        return r2;
    L7:
        r0 = new h(this, r7);
        goto L8
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public Object status(d.c.d<? super SidecarAccountStatus> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, k.class) == false) goto L7;
        k r0 = (k) ZeusTransformUtils.preCheckCast(r7, k.class, "com.obric.aiagent.plugin");
        if ((r0.f10075d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f10075d -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f10073b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f10075d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        t this = (t) ZeusTransformUtils.preCheckCast(r0.f10072a, t.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
    L17:
        SidecarResultParcel r9 = (SidecarResultParcel) ZeusTransformUtils.preCheckCast(r8, SidecarResultParcel.class, "com.obric.aiagent.plugin");
        this.a(r9);
        return com.bytedance.safetyguard.lxc.internal.ipc.g.b(r9);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        SidecarCommandParcel r10 = a("status", 7);
        r0.f10072a = this;
        r0.f10075d = 1;
        r8 = a(r10, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new k(this, r7);
        goto L8
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public Object configuredApp(d.c.d<? super SidecarAppInfo> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.aiagent.plugin");
        if ((r0.f10049d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f10049d -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f10047b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f10049d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        t this = (t) ZeusTransformUtils.preCheckCast(r0.f10046a, t.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
    L17:
        SidecarResultParcel r9 = (SidecarResultParcel) ZeusTransformUtils.preCheckCast(r8, SidecarResultParcel.class, "com.obric.aiagent.plugin");
        this.a(r9);
        return com.bytedance.safetyguard.lxc.internal.ipc.g.c(r9);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        SidecarCommandParcel r10 = a("configured-app", 8);
        r0.f10046a = this;
        r0.f10049d = 1;
        r8 = a(r10, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new d(this, r7);
        goto L8
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public Object startSession(StartSidecarSessionRequest r21, d.c.d<? super SidecarSessionEnv> r22) {
        t r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, j.class) == false) goto L7;
        j r3 = (j) ZeusTransformUtils.preCheckCast(r1, j.class, "com.obric.aiagent.plugin");
        if ((r3.f10071d & Integer.MIN_VALUE) == 0) goto L7;
        r3.f10071d -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f10069b;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f10071d;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        r0 = (t) ZeusTransformUtils.preCheckCast(r3.f10068a, t.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L21:
        SidecarResultParcel r6 = (SidecarResultParcel) ZeusTransformUtils.preCheckCast(r2, SidecarResultParcel.class, "com.obric.aiagent.plugin");
        r0.a(r6);
        SidecarSessionEnv r7 = com.bytedance.safetyguard.lxc.internal.ipc.g.d(r6);
        r0.a(r7);
        return r7;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        String r9 = f10034a.a("session-start");
        String r15 = r21.getCliName();
        Long r8 = r21.getTtlSeconds();
        if (r8 == null) goto L17;
        long r16 = r8.longValue();
    L18:
        SidecarCommandParcel r10 = new SidecarCommandParcel(0, r9, 9, null, null, null, null, r15, r16, 121, null);
        r3.f10068a = r0;
        r3.f10071d = 1;
        r2 = r0.a(r10, r3);
        if (r2 != r4) goto L21;
        return r4;
    L17:
        r16 = -1;
    L7:
        r3 = new j(r0, r1);
        goto L8
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar
    public Object endSession(String r5, d.c.d<? super Boolean> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        ca r0 = (ca) ZeusTransformUtils.preCheckCast(this.f10038e.remove(r5), ca.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        ca.a.a(r0, null, 1, null);
    L6:
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    private final SidecarOperation a(SidecarCommandParcel r5, SidecarDeviceFlowCallback r6) {
        SidecarDeviceFlowCallback r7 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r6, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
        v r0 = new v(r5.getOperationId(), this.f10035b, r7);
        Throwable r4 = d.n.c(this.f10035b.a(r5, (u) ZeusTransformUtils.preCheckCast(r0, u.class, "com.obric.aiagent.plugin")));
        if (r4 == null) goto L9;
        String r8 = r5.getOperationId();
        String r9 = r4.getMessage();
        if (r9 != null) goto L7;
        r9 = "Proxy service is unavailable";
    L7:
        r0.a(com.bytedance.safetyguard.lxc.internal.ipc.g.a(com.bytedance.safetyguard.lxc.internal.ipc.g.a(r8, r9)));
    L9:
        return (SidecarOperation) ZeusTransformUtils.preCheckCast(r0, SidecarOperation.class, "com.obric.aiagent.plugin");
    }

    private final Object a(SidecarCommandParcel r8, d.c.d<? super SidecarResultParcel> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r10, f.class, "com.obric.aiagent.plugin");
        if ((r0.f10057e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f10057e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f10055c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f10057e;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        r8 = (SidecarCommandParcel) ZeusTransformUtils.preCheckCast(r0.f10054b, SidecarCommandParcel.class, "com.obric.aiagent.plugin");
        t this = (t) ZeusTransformUtils.preCheckCast(r0.f10053a, t.class, "com.obric.aiagent.plugin");
        d.o.a(r11);     // Catch: CancellationException -> L14
    L27:
        return (SidecarResultParcel) ZeusTransformUtils.preCheckCast(r11, SidecarResultParcel.class, "com.obric.aiagent.plugin");
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r11);
        kotlinx.coroutines.w r12 = y.a(null, 1, null);
        Throwable r4 = d.n.c(this.f10035b.a(r8, (u) ZeusTransformUtils.preCheckCast(new g(r12), u.class, "com.obric.aiagent.plugin")));
        if (r4 == null) goto L24;
        String r5 = r8.getOperationId();
        String r6 = r4.getMessage();
        if (r6 != null) goto L23;
        r6 = "Proxy service is unavailable";
    L23:
        r12.a(com.bytedance.safetyguard.lxc.internal.ipc.g.a(r5, r6));
    L24:
        r0.f10053a = this;     // Catch: CancellationException -> L14
        r0.f10054b = r8;     // Catch: CancellationException -> L14
        r0.f10057e = 1;     // Catch: CancellationException -> L14
        r11 = r12.a(r0);     // Catch: CancellationException -> L14
        if (r11 != r2) goto L27;
        return r2;
    L14:
        e = move-exception;
        this.f10035b.b(r8.getOperationId());
        throw e;
    L7:
        r0 = new f(this, r10);
        goto L8
    }

    private final void a(SidecarSessionEnv r9) {
        ca r0 = kotlinx.coroutines.i.a(this.f10037d, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(r9, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        ca r8 = (ca) ZeusTransformUtils.preCheckCast(this.f10038e.put(r9.getSessionId(), r0), ca.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L6;
        ca.a.a(r8, null, 1, null);
        return;
    }

    private final SidecarCommandParcel a(String r14, int r15) {
        return new SidecarCommandParcel(0, f10034a.a(r14), r15, null, null, null, null, null, 0, 505, null);
    }

    private final void a(SidecarResultParcel r2) {
        if (r2.getResultType() == 1) goto L6;
        return;
    L6:
        throw new SidecarOperationException(com.bytedance.safetyguard.lxc.internal.ipc.g.a(r2));
    }
}
