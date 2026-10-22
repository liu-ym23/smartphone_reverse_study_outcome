package com.obric.aiagent.ipc;

import android.content.Context;
import android.os.SystemClock;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.assistant.idl.IFlowIDL;
import com.obric.aiagent.assistant.idl.ag;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.h;
import d.n;
import d.o;
import d.x;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: compiled from: AgentIpcManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AgentIpcManagerImpl implements IAgentIpcManager {
    private static final am CHECK_IPC_READY_SCOPE = null;
    private static final long CHECK_IPC_READY_TIMEOUT_MS = 20000;
    public static final a Companion = null;
    private static final String EVENT_CHECK_IPC_READY = "obric_aiagent_ipc_check_ready";
    private static final String PARAM_CHECK_IPC_READY_DURATION = "duration";
    private static final String PARAM_CHECK_IPC_READY_REBIND_REQUIRED = "rebind_required";
    private static final String PARAM_CHECK_IPC_READY_RESULT = "result";
    private static final String TAG = "AgentIpcManagerImpl";
    private volatile boolean ipcReady;

    /* JADX INFO: compiled from: AgentIpcManagerImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AgentIpcManagerImpl.kt */
    @f(b = "AgentIpcManagerImpl.kt", c = {61}, d = "invokeSuspend", e = "com.obric.aiagent.ipc.AgentIpcManagerImpl$checkIpcReady$timeoutJob$1")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f18595b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AgentIpcManagerImpl f18596c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f18597d;

        b(AtomicBoolean r3, AgentIpcManagerImpl r4, long r5, d<? super b> r7) {
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
            this.f18595b = r3;
            this.f18596c = r4;
            this.f18597d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r8, d<?> r9) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f18595b, this.f18596c, this.f18597d, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18594a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            if (this.f18595b.compareAndSet(false, true) == false) goto L15;
            AgentIpcManagerImpl.access$reportCheckIpcReady(this.f18596c, this.f18597d, "timeout");
            ILogDepend.Companion.e(AgentIpcManagerImpl.TAG, "checkIpcReady: timeout waiting for IPC register");
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            d r7 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f18594a = 1;
            if (ax.a(AgentIpcManagerImpl.CHECK_IPC_READY_TIMEOUT_MS, r7) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ void lambda$49ipJvCtMoxJcNsp4XqP4C1wrgU(AtomicBoolean r0, ca r1, AgentIpcManagerImpl r2, long r3, d.h.a.b r5, IFlowIDL r6) {
        checkIpcReady$lambda$1(r0, r1, r2, r3, r5, r6);
    }

    public static /* synthetic */ void lambda$Bgfg3NGhy64f7O5730G2iCFCMoM(AgentIpcManagerImpl r0, IFlowIDL r1) {
        init$lambda$0(r0, r1);
    }

    public AgentIpcManagerImpl() {
    }

    public static final /* synthetic */ void access$reportCheckIpcReady(AgentIpcManagerImpl r0, long r1, String r3) {
        r0.reportCheckIpcReady(r1, r3);
    }

    static {
        Companion = new a(null);
        CHECK_IPC_READY_SCOPE = an.a(bd.c().plus((g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), g.class, "com.obric.aiagent.plugin")));
    }

    @Override // com.obric.aiagent.ipc.IAgentIpcManager
    public void init(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "context");
        ILogDepend.Companion.i(TAG, " init");
        com.obric.aiagent.ipc.b.f18607a.a(r11);     // Catch: Exception -> L5
        ag.a(aa.b(IFlowIDL.class), false, false, new $$Lambda$AgentIpcManagerImpl$Bgfg3NGhy64f7O5730G2iCFCMoM(this), 3, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, " init fail", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private static final void init$lambda$0(AgentIpcManagerImpl r2, IFlowIDL r3) {
        d.h.b.o.e((IFlowIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowIDL.class, "com.obric.aiagent.plugin"), "it");
        ILogDepend.Companion.i(TAG, "onIPCRegister");
        r2.ipcReady = true;
    }

    @Override // com.obric.aiagent.ipc.IAgentIpcManager
    public void checkIpcReady(d.h.a.b<? super Boolean, x> r19) {
        final d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "callback");
        if (ag.a(aa.b(IFlowIDL.class)) == null) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L15;
        ILogDepend.Companion.i(TAG, "checkIpcReady: already ready, callback success immediately");
        r9.invoke(true);
        return;
    L15:
        final long r13 = SystemClock.elapsedRealtime();     // Catch: Exception -> L12
        final AtomicBoolean r1 = new AtomicBoolean(false);     // Catch: Exception -> L12
        final ca r4 = i.a(CHECK_IPC_READY_SCOPE, null, null, (m) ZeusTransformUtils.preCheckCast(new b(r1, this, r13, null), m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Exception -> L12
        com.obric.aiagent.ipc.b.f18607a.a();     // Catch: Exception -> L12
        ILogDepend.Companion.i(TAG, "checkIpcReady: not ready, waiting for IPC register");     // Catch: Exception -> L12
        ag.a(aa.b(IFlowIDL.class), true, true, new $$Lambda$AgentIpcManagerImpl$49ipJvCtMoxJcNsp4XqP4C1wrgU(r1, r4, this, r13, r9));     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "checkIpcReady: check fail", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r9.invoke(false);
        return;
    L5:
        r0 = false;
        goto L7
    }

    private static final void checkIpcReady$lambda$1(AtomicBoolean r2, ca r3, AgentIpcManagerImpl r4, long r5, d.h.a.b r7, IFlowIDL r8) {
        ca r6 = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e((IFlowIDL) ZeusTransformUtils.wrapperContextForParams(r8, IFlowIDL.class, "com.obric.aiagent.plugin"), "it");
        if (r2.compareAndSet(false, true) == false) goto L6;
        ca.a.a(r6, null, 1, null);
        r4.ipcReady = true;
        r4.reportCheckIpcReady(r5, "success");
        ILogDepend.Companion.i(TAG, "checkIpcReady: IPC register callback success");
        r9.invoke(true);
        return;
    }

    private final void reportCheckIpcReady(long r3, String r5) {
        long r0 = SystemClock.elapsedRealtime() - r3;
        ILogDepend.Companion.i(TAG, "reportCheckIpcReady: result=" + r5 + ", duration=" + r0);
        n.a r2 = n.f38560a;     // Catch: Throwable -> L9
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L9
        r4.put("duration", r0);     // Catch: Throwable -> L9
        r4.put(PARAM_CHECK_IPC_READY_RESULT, r5);     // Catch: Throwable -> L9
        r4.put(PARAM_CHECK_IPC_READY_REBIND_REQUIRED, true);     // Catch: Throwable -> L9
        IAppLog r6 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r6 == null) goto L6;
        r6.reportToFlow(EVENT_CHECK_IPC_READY, r4);     // Catch: Throwable -> L9
        x r7 = x.f38692a;     // Catch: Throwable -> L9
    L7:
        Object r8 = n.f(r7);     // Catch: Throwable -> L9
    L11:
        Throwable r9 = n.c(r8);
        if (r9 == null) goto L17;
        ILogDepend.Companion.e(TAG, "reportCheckIpcReady failed", r9);
        return;
    L17:
        return;
    L6:
        r7 = null;
    L9:
        th = move-exception;
        n.a r10 = n.f38560a;
        r8 = n.f(o.a(th));
        goto L11
    }
}
