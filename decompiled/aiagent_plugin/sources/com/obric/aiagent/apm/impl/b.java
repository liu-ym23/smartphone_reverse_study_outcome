package com.obric.aiagent.apm.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.bytedance.apm.impl.DefaultTTNetImpl;
import com.bytedance.apm.util.t;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.memory.MemoryWidget;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.j;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ITraceDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.l;
import d.h.b.o;
import d.n;
import d.x;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ApmAgentImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f16108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f16109c = null;

    /* JADX INFO: compiled from: ApmAgentImpl.kt */
    /* synthetic */ class a extends l implements d.h.a.b<String, x> {
        a(Object r8) {
            super(1, r8, b.class, "startApmIfNeeded", "startApmIfNeeded(Ljava/lang/String;)V", 0);
        }

        public final void a(String r3) {
            o.e(r3, "p0");
            b.a((b) ZeusTransformUtils.preCheckCast(this.receiver, b.class, "com.obric.aiagent.plugin"), r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(String r3) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.apm.impl.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ApmAgentImpl.kt */
    public static final class C0325b implements com.bytedance.apm.core.b {
        C0325b() {
        }

        @Override // com.bytedance.apm.core.b
        public Map<String, String> a() {
            return (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.apm.core.b
        public String b() {
            return ITraceDepend.Companion.getSessionId();
        }

        @Override // com.bytedance.apm.core.b
        public long c() {
            String r2 = ITraceDepend.Companion.getUserID();
            if (r2 != null) goto L7;
            return 0;
        L7:
            return Long.parseLong(r2);
        }
    }

    private final void a(com.bytedance.apm.config.b.a r1) {
    }

    public static /* synthetic */ void lambda$5oLYG4UPsRcJXuTIHMa_AhWcsrU(Activity r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$MZkNouRRaGUoL4MSM-p3zRMycng, reason: not valid java name */
    public static /* synthetic */ x m115lambda$MZkNouRRaGUoL4MSMp3zRMycng(String r0, String r1, String r2) {
        return a(r0, r1, r2);
    }

    private b() {
    }

    public static final /* synthetic */ void a(b r0, String r1) {
        r0.a(r1);
    }

    static {
        f16107a = new b();
        f16109c = new AtomicBoolean(false);
    }

    public final void a() {
        boolean r0 = true;
        com.bytedance.apm.b.f4156a = true;
        if (IAppContext.Companion.isDebug() == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        f16108b = r1;
        b();
        com.bytedance.apm.config.b.a r2 = com.bytedance.apm.config.b.B().a(new com.bytedance.apm.f.c.a().a().b().c().d().e().a(WsConstants.EXIT_DELAY_TIME).f()).a(true).b(true);
        b r3 = f16107a;
        o.a(r2);
        r3.a(r2);
        com.bytedance.apm.a.a().a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r2.a(20000000).c(false).d(true).e(f16108b).f(true).g(true).a(com.bytedance.apm.config.a.f().a(false).b(true).a(60000).c(true).a($$Lambda$b$5oLYG4UPsRcJXuTIHMa_AhWcsrU.INSTANCE).a()).a());
        IAppLog r4 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L12;
        String r5 = r4.getFlowDid();
    L13:
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L19;
        r0 = false;
    L19:
        if (r0 == false) goto L21;
        a(r5);
        return;
    L21:
        if (r4 == null) goto L23;
        r4.awaitFlowDid((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    L23:
        ITraceDepend.Companion.awaitTraceId($$Lambda$b$MZkNouRRaGUoL4MSMp3zRMycng.INSTANCE);
        return;
    L12:
        r5 = null;
        goto L13
    L5:
        if (IAppContext.Companion.isReleaseChannel() == false) goto L8;
        r1 = false;
        goto L9
    }

    private static final void a(Activity r3) {
        ILogDepend.Companion.i("ActivityLeak", "onActivityLeaked():" + ((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin")).getLocalClassName());
    }

    private static final x a(String r1, String r2, String r3) {
        o.e(r1, "d");
        o.e(r2, "<unused var>");
        o.e(r3, "<unused var>");
        f16107a.a(r1);
        return x.f38692a;
    }

    public final void a(String r1, String r2) {
        o.e(r1, "key");
        o.e(r2, "value");
        com.bytedance.apm.b.a(r1, r2);
    }

    private final void b() {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        b r3 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        com.bytedance.news.common.service.manager.d.a(IHttpService.class, new DefaultTTNetImpl());     // Catch: Throwable -> L5
        ILogDepend.Companion.i("ApmAgentImpl", "registerApmHttpService success");     // Catch: Throwable -> L5
        Object r4 = n.f(x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = n.c(r4);
        if (r5 == null) goto L13;
        ILogDepend.Companion.e("ApmAgentImpl", "registerApmHttpService failed", r5);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r2 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L7
    }

    private final void a(String r4) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (f16109c.compareAndSet(false, true) == false) goto L13;
        b(r4);
        return;
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void b(String r4) {
        com.bytedance.apm.config.c.a r3 = com.bytedance.apm.config.c.a().a(IAppContext.Companion.getAppId()).e(IAppContext.Companion.getBuildChannel()).c(IAppContext.Companion.getVersionName()).d(String.valueOf(IAppContext.Companion.getUpdateVersionCode())).b(r4).d(true).a(t.a()).a((j) ZeusTransformUtils.preCheckCast(new MemoryWidget(com.bytedance.memory.f.a.i().a(), null), j.class, "com.obric.aiagent.plugin")).a(true).c(true).a((j) ZeusTransformUtils.preCheckCast(new com.c.a.b(), j.class, "com.obric.aiagent.plugin")).b(true).a((com.bytedance.apm.core.b) ZeusTransformUtils.preCheckCast(new C0325b(), com.bytedance.apm.core.b.class, "com.obric.aiagent.plugin"));
        com.bytedance.apm.a.a().a(r3.a());
    }
}
