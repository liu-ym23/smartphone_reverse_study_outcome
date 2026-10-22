package com.obric.aiagent.trace;

import androidx.core.os.e;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.applog.ICommonParams;
import com.obric.aiagent.assistant.idl.IFlowAppStateIDL;
import com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL;
import com.obric.aiagent.assistant.ipc.BuildConfig;
import com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.IRuntimeContext;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.platform.depend.ITraceDepend;
import com.obric.aiagent.product.ObricProductSdk;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.f;
import d.g;
import d.h.b.aa;
import d.h.b.o;
import d.m;
import d.s;
import d.x;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: FlowTrace.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "AppStateTrace";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22190a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f22191b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CopyOnWriteArrayList<d.h.a.b<String, x>> f22192c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f22193d = null;

    /* JADX INFO: renamed from: com.obric.aiagent.trace.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FlowTrace.kt */
    public static final class C0479a implements com.obric.aiagent.flow.applog.b {
        /* JADX INFO: renamed from: lambda$RX9RnYhRN7GrQvi-B_yGm2vjpkc, reason: not valid java name */
        public static /* synthetic */ x m384lambda$RX9RnYhRN7GrQviB_yGm2vjpkc(String r0) {
            return c(r0);
        }

        public static /* synthetic */ x lambda$ZT5JGcXiJewFuZiNQX7vvw73xDk(String r0) {
            return a(r0);
        }

        public static /* synthetic */ x lambda$hw7KQCQYQYTqHAtBOt7ZfpDWA3I(String r0) {
            return b(r0);
        }

        C0479a() {
        }

        @Override // com.obric.aiagent.flow.applog.b
        public void b() {
            com.obric.aiagent.flow.applog.b.a.a(this);
        }

        @Override // com.obric.aiagent.flow.applog.b
        public void a() {
            com.obric.aiagent.utils.a.a.f22293a.a($$Lambda$a$a$ZT5JGcXiJewFuZiNQX7vvw73xDk.INSTANCE);
            ObricProductSdk.INSTANCE.platformService().romInfo().getOSDeviceIdAsync($$Lambda$a$a$hw7KQCQYQYTqHAtBOt7ZfpDWA3I.INSTANCE);
            com.obric.aiagent.utils.a.a.f22293a.b($$Lambda$a$a$RX9RnYhRN7GrQviB_yGm2vjpkc.INSTANCE);
            com.obric.aiagent.flow.applog.a.f18577a.a(ao.b(new m[]{s.a("runtime_process_id", String.valueOf(IRuntimeContext.Companion.getProcessId())), s.a("runtime_process_name", IRuntimeContext.Companion.getProcessName()), s.a("version_name", IAppContext.Companion.getVersionName()), s.a("version_code", String.valueOf(IAppContext.Companion.getVersionCode())), s.a(MonitorConstants.EXTRA_UPDATE_VERSION, String.valueOf(IAppContext.Companion.getUpdateVersionCode())), s.a("build_id", 0), s.a("build_time", "2026-09-23"), s.a("build_git_branch", "obric/rls/15.2.0.1"), s.a("build_git_commit", "fc4b8ba9c915"), s.a("idl_sign", BuildConfig.IPC_IDL_SIGN)}));
        }

        private static final x a(String r3) {
            o.e(r3, "sysDid");
            com.obric.aiagent.flow.applog.a.f18577a.a(ao.b(new m[]{s.a("system_os_did", r3)}));
            return x.f38692a;
        }

        private static final x b(String r3) {
            o.e(r3, "it");
            com.obric.aiagent.flow.applog.a.f18577a.a(ao.b(new m[]{s.a("system_os_device_id", r3)}));
            return x.f38692a;
        }

        private static final x c(String r3) {
            o.e(r3, "sysUid");
            com.obric.aiagent.flow.applog.a.f18577a.a(ao.b(new m[]{s.a("system_os_uid", r3)}));
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: FlowTrace.kt */
    public static final class b implements com.obric.aiagent.flow.applog.b {
        b() {
        }

        @Override // com.obric.aiagent.flow.applog.b
        public void b() {
            com.obric.aiagent.flow.applog.b.a.a(this);
        }

        @Override // com.obric.aiagent.flow.applog.b
        public void a() {
            String r3 = com.obric.aiagent.flow.applog.a.f18577a.d();
            ISecureLogDepend.Companion.i(a.TAG, "addFlowDidParamToLocal did: " + r3);
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L11;
            com.obric.aiagent.flow.applog.a.f18577a.a((IFlowAppLogDataObserverIDL) ZeusTransformUtils.preCheckCast(new FlowTrace$addFlowDidParamToLocal$1$onSuccess$1(), IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin"));
            return;
        L11:
            ICommonParams r2 = (ICommonParams) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ICommonParams.class), ICommonParams.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L14;
            r2.addCommonParams("flow_did", r3);
        L14:
            a.a(a.f22190a, r3);
            return;
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }
    }

    /* JADX INFO: compiled from: FlowTrace.kt */
    public static final class c implements com.obric.aiagent.flow.applog.b {
        public static /* synthetic */ x lambda$aOGr2SNXlTWDnAZngcodBzVeBHY(String r0, String r1, String r2, String r3) {
            return a(r0, r1, r2, r3);
        }

        public static /* synthetic */ x lambda$dvSBZGVI1jAU_7KX4MPPc5CPMgM(String r0) {
            return a(r0);
        }

        c() {
        }

        @Override // com.obric.aiagent.flow.applog.b
        public void b() {
            com.obric.aiagent.flow.applog.b.a.a(this);
        }

        @Override // com.obric.aiagent.flow.applog.b
        public void a() {
            com.obric.aiagent.utils.a.a.f22293a.a($$Lambda$a$c$dvSBZGVI1jAU_7KX4MPPc5CPMgM.INSTANCE);
        }

        private static final x a(final String r4) {
            o.e(r4, "sysDid");
            String r0 = ITraceDepend.Companion.getDeviceId();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            ITraceDepend.Companion.awaitTraceId(new $$Lambda$a$c$aOGr2SNXlTWDnAZngcodBzVeBHY(r4));
        L10:
            return x.f38692a;
        L8:
            a.a(a.f22190a, "Flow init", com.obric.aiagent.flow.applog.a.f18577a.d(), r0, r4);
            goto L10
        L5:
            r1 = false;
            goto L6
        }

        private static final x a(String r1, String r2, String r3, String r4) {
            o.e(r2, "did");
            o.e(r3, "<unused var>");
            o.e(r4, "<unused var>");
            a.a(a.f22190a, "Flow init", com.obric.aiagent.flow.applog.a.f18577a.d(), r2, r1);
            return x.f38692a;
        }
    }

    public static /* synthetic */ void lambda$RWu72L0wJ7SLJJYRBNJigWlh5qk(IFlowAppStateIDL r0) {
        a(r0);
    }

    public static /* synthetic */ ICommonParams lambda$jOLxAakYael6u3OGTZwqeN7pMh8() {
        return k();
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r0) {
        r0.h();
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(a r0, String r1, String r2, String r3, String r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void b(a r0) {
        r0.i();
    }

    public static final /* synthetic */ void c(a r0) {
        r0.j();
    }

    static {
        f22190a = new a();
        f22191b = g.a($$Lambda$a$jOLxAakYael6u3OGTZwqeN7pMh8.INSTANCE);
        f22192c = new CopyOnWriteArrayList();
        f22193d = new Object();
    }

    private final ICommonParams c() {
        return (ICommonParams) ZeusTransformUtils.preCheckCast(f22191b.b(), ICommonParams.class, "com.obric.aiagent.plugin");
    }

    public final void a() {
        d();
        e();
        f();
        g();
    }

    public final String b() {
        return com.obric.aiagent.flow.applog.a.f18577a.d();
    }

    public final void a(d.h.a.b<? super String, x> r2) {
        d.h.a.b<String, x> r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r1, "callback");
        String r3 = com.obric.aiagent.flow.applog.a.f18577a.d();
        if (r3 == null) goto L5;
        r1.invoke(r3);
        return;
    L5:
        Object r4 = f22193d;
        monitor-enter(r4);
        String r0 = com.obric.aiagent.flow.applog.a.f18577a.d();     // Catch: Throwable -> L13
        if (r0 == null) goto L10;
        r1.invoke(r0);     // Catch: Throwable -> L13
        x r5 = x.f38692a;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r4);
        return;
    L10:
        Boolean.valueOf(f22192c.add(r1));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private final void d() {
        com.obric.aiagent.flow.applog.a.f18577a.a((com.obric.aiagent.flow.applog.b) ZeusTransformUtils.preCheckCast(new C0479a(), com.obric.aiagent.flow.applog.b.class, "com.obric.aiagent.plugin"));
    }

    private final void e() {
        com.obric.aiagent.flow.applog.a.f18577a.a((com.obric.aiagent.flow.applog.b) ZeusTransformUtils.preCheckCast(new b(), com.obric.aiagent.flow.applog.b.class, "com.obric.aiagent.plugin"));
    }

    private final void a(String r5) {
        Object r4 = f22193d;
        monitor-enter(r4);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(f22192c, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        ((d.h.a.b) ZeusTransformUtils.preCheckCast(r0.next(), d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r5);     // Catch: Throwable -> L11
        goto L6
    L8:
        x r6 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(r4);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private final void f() {
        com.obric.aiagent.assistant.idl.s.a(aa.b(IFlowAppStateIDL.class), false, false, $$Lambda$a$RWu72L0wJ7SLJJYRBNJigWlh5qk.INSTANCE, 3, null);
    }

    private static final void a(IFlowAppStateIDL r3) {
        IFlowAppStateIDL r4 = (IFlowAppStateIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppStateIDL.class, "com.obric.aiagent.plugin");
        o.e(r4, "it");
        r4.registerAppStateListener((IFlowOnAppStateChangedListenerIDL) ZeusTransformUtils.preCheckCast(new FlowTrace$dumpOnAppStateChanged$1$1(), IFlowOnAppStateChangedListenerIDL.class, "com.obric.aiagent.plugin"));
    }

    private final void g() {
        com.obric.aiagent.flow.applog.a.f18577a.a((com.obric.aiagent.flow.applog.b) ZeusTransformUtils.preCheckCast(new c(), com.obric.aiagent.flow.applog.b.class, "com.obric.aiagent.plugin"));
    }

    private final void h() {
        IAppLog r4 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        r4.report("flow_app_state", e.a(new m[]{s.a("state", "background")}));
        return;
    }

    private final void i() {
        ICommonParams r0 = c();
        if (r0 == null) goto L5;
        String r1 = r0.getCommonParam("flow_did");
    L6:
        a("Flow foreground", r1, ITraceDepend.Companion.getDeviceId(), com.obric.aiagent.utils.a.a.f22293a.a());
        IAppLog r4 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L10;
        r4.report("flow_app_state", e.a(new m[]{s.a("state", "foreground")}));
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void j() {
        IAppLog r4 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        r4.report("flow_app_state", e.a(new m[]{s.a("state", "exit")}));
        return;
    }

    private final void a(String r1, String r2, String r3, String r4) {
        ISecureLogDepend.Companion.i(TAG, r1 + ". did=" + r4 + ". flow-did=" + r2 + ", sys-did=" + r3);
    }

    private static final ICommonParams k() {
        return (ICommonParams) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ICommonParams.class), ICommonParams.class, "com.obric.aiagent.plugin");
    }
}
