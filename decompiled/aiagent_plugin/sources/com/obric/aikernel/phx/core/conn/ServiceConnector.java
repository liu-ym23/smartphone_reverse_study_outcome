package com.obric.aikernel.phx.core.conn;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: ServiceConnector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ServiceConnector {
    public static final long BINDER_TIMEOUT = 5000;
    public static final Companion Companion = null;
    private static final String TAG = "ServiceConnector";
    private final AIKernelConfig aiKernelConfig;
    private final ComponentName connName;
    private au<? extends AIKBinder> connectTask;
    private final ServiceConnector$connection$1 connection;
    private final Context context;
    private volatile n<? super AIKBinder> continuation;
    private final ServiceConnector$lifeCycleConnection$1 lifeCycleConnection;
    private volatile AIKBinder remote;

    /* JADX INFO: compiled from: ServiceConnector.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2, reason: invalid class name */
    /* JADX INFO: compiled from: ServiceConnector.kt */
    @f(b = "ServiceConnector.kt", c = {182}, d = "invokeSuspend", e = "com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2")
    static final class AnonymousClass2 extends l implements m<am, d<? super AIKBinder>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ServiceConnector this$0;

        AnonymousClass2(ServiceConnector r3, d<? super AnonymousClass2> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r5);
            r0.L$0 = r3;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super AIKBinder> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super AIKBinder> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = b.a();
            int r1 = this.label;
            IBinder r3 = null;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            o.a(r12);     // Catch: Throwable -> L7
        L56:
            Object r13 = d.n.f((AIKBinder) ZeusTransformUtils.preCheckCast(r12, AIKBinder.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
        L59:
            Throwable r2 = d.n.c(r13);
            if (r2 == null) goto L63;
            AIKLog.INSTANCE.w(ServiceConnector.TAG, "connectTask failed by " + r2);
        L63:
            if (d.n.b(r13) == false) goto L65;
            r13 = null;
        L65:
            AIKBinder r14 = (AIKBinder) ZeusTransformUtils.preCheckCast(r13, AIKBinder.class, "com.obric.aiagent.plugin");
            if (r14 == null) goto L80;
            ServiceConnector r11 = this.this$0;
            AIKLog r4 = AIKLog.INSTANCE;
            StringBuilder r5 = new StringBuilder().append("await finished ");
            AIKBinder r15 = ServiceConnector.access$getRemote$p(r11);
            if (r15 == null) goto L70;
            r3 = r15.asBinder();
        L70:
            r4.v(ServiceConnector.TAG, r5.append(r3).toString());
            return r14;
        L80:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            o.a(r12);
            am r16 = (am) ZeusTransformUtils.preCheckCast(this.L$0, am.class, "com.obric.aiagent.plugin");
            ServiceConnector r17 = this.this$0;
            monitor-enter(r17);
            AIKBinder r6 = ServiceConnector.access$getRemote$p(r17);     // Catch: Throwable -> L72
            boolean r7 = false;
            if (r6 == null) goto L20;
            IBinder r8 = r6.asBinder();     // Catch: Throwable -> L72
            if (r8 == null) goto L20;
            if (r8.isBinderAlive() != true) goto L20;
            boolean r9 = true;
        L22:
            if (r9 == true) goto L39;
            AIKLog r10 = AIKLog.INSTANCE;     // Catch: Throwable -> L72
            StringBuilder r18 = new StringBuilder().append("should rebind ");     // Catch: Throwable -> L72
            AIKBinder r19 = ServiceConnector.access$getRemote$p(r17);     // Catch: Throwable -> L72
            if (r19 == null) goto L26;
            IBinder r20 = r19.asBinder();     // Catch: Throwable -> L72
        L27:
            StringBuilder r21 = r18.append(r20).append(' ').append(ServiceConnector.access$getConnectTask$p(r17)).append(' ');     // Catch: Throwable -> L72
            au r22 = ServiceConnector.access$getConnectTask$p(r17);     // Catch: Throwable -> L72
            if (r22 == null) goto L30;
            Boolean r23 = d.c.b.a.b.a(r22.i());     // Catch: Throwable -> L72
        L31:
            r10.d(ServiceConnector.TAG, r21.append(r23).toString());     // Catch: Throwable -> L72
            au r24 = ServiceConnector.access$getConnectTask$p(r17);     // Catch: Throwable -> L72
            if (r24 != null) goto L34;
        L36:
            if (r7 == false) goto L39;
            ServiceConnector.access$setConnectTask$p(r17, null);     // Catch: Throwable -> L72
            goto L39
        L34:
            if (r24.i() != true) goto L36;
            r7 = true;
            goto L36
        L30:
            r23 = null;
            goto L31
        L26:
            r20 = null;
        L39:
            if (ServiceConnector.access$getConnectTask$p(r17) != null) goto L45;
            AIKLog r25 = AIKLog.INSTANCE;     // Catch: Throwable -> L72
            StringBuilder r26 = new StringBuilder().append("new task ");     // Catch: Throwable -> L72
            AIKBinder r27 = ServiceConnector.access$getRemote$p(r17);     // Catch: Throwable -> L72
            if (r27 == null) goto L43;
            IBinder r28 = r27.asBinder();     // Catch: Throwable -> L72
        L44:
            r25.i(ServiceConnector.TAG, r26.append(r28).toString());     // Catch: Throwable -> L72
            ServiceConnector.access$setConnectTask$p(r17, i.b(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new ServiceConnector$getService$2$1$1(r17, null), m.class, "com.obric.aiagent.plugin"), 3, null));     // Catch: Throwable -> L72
            i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new ServiceConnector$getService$2$1$2(ServiceConnector.access$getConnectTask$p(r17), null), m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Throwable -> L72
        L50:
            au r29 = ServiceConnector.access$getConnectTask$p(r17);     // Catch: Throwable -> L72
            monitor-exit(r17);
            if (r29 == null) goto L79;
            d.n.a r110 = d.n.f38560a;     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            r12 = r29.a(this);     // Catch: Throwable -> L7
            if (r12 != r0) goto L56;
            return r0;
        L79:
            return null;
        L43:
            r28 = null;
            goto L44
        L45:
            AIKLog r30 = AIKLog.INSTANCE;     // Catch: Throwable -> L72
            StringBuilder r31 = new StringBuilder().append("reuse task ").append(ServiceConnector.access$getConnectTask$p(r17)).append(' ');     // Catch: Throwable -> L72
            au r32 = ServiceConnector.access$getConnectTask$p(r17);     // Catch: Throwable -> L72
            if (r32 == null) goto L48;
            Boolean r33 = d.c.b.a.b.a(r32.i());     // Catch: Throwable -> L72
        L49:
            r30.d(ServiceConnector.TAG, r31.append(r33).toString());     // Catch: Throwable -> L72
            goto L50
        L48:
            r33 = null;
        L20:
            r9 = false;
        L72:
            th = move-exception;
            throw th;
        L7:
            th = move-exception;
            d.n.a r34 = d.n.f38560a;
            r13 = d.n.f(o.a(th));
            goto L59
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.obric.aikernel.phx.core.conn.ServiceConnector$connection$1] */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.obric.aikernel.phx.core.conn.ServiceConnector$lifeCycleConnection$1] */
    public ServiceConnector(Context r3, AIKernelConfig r4, ComponentName r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        d.h.b.o.e(r4, "aiKernelConfig");
        d.h.b.o.e(r5, "connName");
        this.context = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.aiKernelConfig = r4;
        this.connName = r5;
        this.connection = new ServiceConnector$connection$1(this);
        this.lifeCycleConnection = new ServiceConnector$lifeCycleConnection$1(this);
    }

    public static final /* synthetic */ AIKernelConfig access$getAiKernelConfig$p(ServiceConnector r0) {
        return r0.aiKernelConfig;
    }

    public static final /* synthetic */ ComponentName access$getConnName$p(ServiceConnector r0) {
        return r0.connName;
    }

    public static final /* synthetic */ au access$getConnectTask$p(ServiceConnector r0) {
        return r0.connectTask;
    }

    public static final /* synthetic */ ServiceConnector$connection$1 access$getConnection$p(ServiceConnector r0) {
        return r0.connection;
    }

    public static final /* synthetic */ Context access$getContext$p(ServiceConnector r0) {
        return r0.context;
    }

    public static final /* synthetic */ n access$getContinuation$p(ServiceConnector r0) {
        return r0.continuation;
    }

    public static final /* synthetic */ ServiceConnector$lifeCycleConnection$1 access$getLifeCycleConnection$p(ServiceConnector r0) {
        return r0.lifeCycleConnection;
    }

    public static final /* synthetic */ AIKBinder access$getRemote$p(ServiceConnector r0) {
        return r0.remote;
    }

    public static final /* synthetic */ void access$setConnectTask$p(ServiceConnector r2, au r3) {
        r2.connectTask = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setContinuation$p(ServiceConnector r2, n r3) {
        r2.continuation = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setRemote$p(ServiceConnector r2, AIKBinder r3) {
        r2.remote = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r3, AIKBinder.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ Object getService$default(ServiceConnector r1, long r2, d r4, int r5, Object r6) {
        d<? super AIKBinder> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 5000;
    L6:
        return r1.getService(r2, r7);
    }

    public final Object getService(long r5, d<? super AIKBinder> r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        AIKBinder r0 = this.remote;
        boolean r2 = true;
        if (r0 == null) goto L9;
        IBinder r1 = r0.asBinder();
        if (r1 == null) goto L9;
        if (r1.isBinderAlive() != true) goto L9;
    L10:
        if (r2 == false) goto L14;
        return this.remote;
    L14:
        return dg.b(r5, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), m.class, "com.obric.aiagent.plugin"), r8);
    L9:
        r2 = false;
        goto L10
    }
}
