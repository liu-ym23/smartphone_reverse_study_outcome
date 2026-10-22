package com.obric.aiagent.ttnet.interceptor;

import com.bytedance.retrofit2.ak;
import com.bytedance.retrofit2.b.c;
import com.obric.aiagent.assistant.idl.IFlowAssistantActiveStateListenerIDL;
import com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL;
import com.obric.aiagent.assistant.idl.u;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.aiagent.ttnet.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.io.IOException;

/* JADX INFO: compiled from: RequestRestrictInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.bytedance.retrofit2.d.b {
    private static final String TAG = "RequestRestrictInterceptor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0481a f22258a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.ttnet.interceptor.b f22259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f22260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f22261d;

    /* JADX INFO: renamed from: com.obric.aiagent.ttnet.interceptor.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RequestRestrictInterceptor.kt */
    public static final class C0481a {
        public /* synthetic */ C0481a(h r1) {
            this();
        }

        private C0481a() {
        }
    }

    /* JADX INFO: compiled from: RequestRestrictInterceptor.kt */
    public static final class b extends IOException {
        public b(String r2) {
            o.e(r2, "msg");
            super(r2);
        }
    }

    static {
        f22258a = new C0481a(null);
    }

    /* JADX INFO: renamed from: lambda$jYEiqKnnspX-CDLHuEHpTqxiDc0, reason: not valid java name */
    public static /* synthetic */ void m389lambda$jYEiqKnnspXCDLHuEHpTqxiDc0(a r0, IFlowAssistantStateIDL r1) {
        a(r0, r1);
    }

    public a(e r7, com.obric.aiagent.ttnet.b r8) {
        com.obric.aiagent.ttnet.b r9 = (com.obric.aiagent.ttnet.b) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.aiagent.ttnet.b.class, "com.obric.aiagent.plugin");
        o.e(r7, "config");
        o.e(r9, "manager");
        this.f22259b = new com.obric.aiagent.ttnet.interceptor.b(r7, r9);
        if (IAppContext.Companion.isDebug() == false) goto L5;
    L8:
        boolean r10 = true;
    L9:
        this.f22260c = r10;
        com.obric.aiagent.ttnet.a.f22195a.a();
        u.a(aa.b(IFlowAssistantStateIDL.class), false, false, new $$Lambda$a$jYEiqKnnspXCDLHuEHpTqxiDc0(this), 3, null);
        return;
    L5:
        if (IAppContext.Companion.isReleaseChannel() == false) goto L8;
        r10 = false;
        goto L9
    }

    public static final /* synthetic */ void a(a r0, boolean r1) {
        r0.f22261d = r1;
    }

    private static final void a(final a r2, IFlowAssistantStateIDL r3) {
        IFlowAssistantStateIDL r4 = (IFlowAssistantStateIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
        o.e(r4, "ipc");
        r2.f22261d = r4.isActive();
        r4.registerActiveStateListener((IFlowAssistantActiveStateListenerIDL) ZeusTransformUtils.preCheckCast(new RequestRestrictInterceptor$1$1(r2), IFlowAssistantActiveStateListenerIDL.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.retrofit2.d.b
    public ak<?> a(com.bytedance.retrofit2.d.b.a r4) {
        com.bytedance.retrofit2.d.b.a r5 = (com.bytedance.retrofit2.d.b.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.retrofit2.d.b.a.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        return null;
    L6:
        c r0 = r5.a();
        com.obric.aiagent.ttnet.interceptor.b r2 = this.f22259b;
        o.a(r0);
        if (r2.a(r0) == false) goto L11;
        return r5.a(r0);
    L11:
        if (a() == false) goto L13;
        b r3 = new b("Reject background request. request=" + r0.n() + '/' + r0.o());
        ILogDepend.Companion.w(TAG, r3.getMessage());
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
    L13:
        return r5.a(r5.a());
    }

    private final boolean a() {
        if (b() == true) goto L5;
        boolean r0 = this.f22259b.a();
        boolean r3 = c();
        if (this.f22260c == false) goto L11;
        ILogDepend.Companion.i(TAG, "shouldRejectBackgroundRequest shouldRestrict=" + r0 + ", flowBackgroundIntercepting=" + r3);
    L11:
        if (r0 == true) goto L13;
        if (r3 == true) goto L13;
        return false;
    L13:
        return true;
    L5:
        if (this.f22260c == false) goto L7;
        ILogDepend.Companion.i(TAG, "OAuto is active, skip background restrict");
    L7:
        return false;
    }

    private final boolean b() {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r6 = n.f(Boolean.valueOf(SharedState.INSTANCE.getBoolean("oauto_active_state", false)));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = n.c(r6);
        if (r3 == null) goto L12;
        ILogDepend.Companion.w(TAG, "query OAuto active state failed: " + r3.getMessage());
        r6 = false;
    L12:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        th = move-exception;
        n.a r4 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L7
    }

    private final boolean c() {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L8
        a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        boolean r3 = com.obric.aiagent.ttnet.a.f22195a.b();     // Catch: Throwable -> L8
        if (r5.f22260c == false) goto L6;
        ILogDepend.Companion.i(TAG, "isFlowBackgroundIntercepting " + r3);     // Catch: Throwable -> L8
    L6:
        Object r6 = n.f(Boolean.valueOf(r3));     // Catch: Throwable -> L8
    L10:
        Throwable r4 = n.c(r6);
        if (r4 == null) goto L15;
        ILogDepend.Companion.w(TAG, "query flow background intercepting failed: " + r4.getMessage());
        r6 = false;
    L15:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L8:
        th = move-exception;
        n.a r7 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L10
    }
}
