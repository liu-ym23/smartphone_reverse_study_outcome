package com.obric.aiagent.ttnet;

import com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL;
import com.obric.aiagent.assistant.idl.IFlowBackgroundInterceptStateListenerIDL;
import com.obric.aiagent.assistant.idl.u;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.o;
import d.n;
import d.x;

/* JADX INFO: compiled from: FlowBackgroundInterceptStateCache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "FlowBgInterceptCache";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22195a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f22196b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f22197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f22198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final FlowBackgroundInterceptStateCache$listener$1 f22199e = null;

    /* JADX INFO: renamed from: lambda$BSRlYsKVj2vgBb4NmhZ8PTj-qn8, reason: not valid java name */
    public static /* synthetic */ void m385lambda$BSRlYsKVj2vgBb4NmhZ8PTjqn8(IFlowAssistantStateIDL r0) {
        a(r0);
    }

    private a() {
    }

    public static final /* synthetic */ void a(boolean r0) {
        f22198d = r0;
    }

    public static final /* synthetic */ boolean c() {
        return f22196b;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.aiagent.ttnet.FlowBackgroundInterceptStateCache$listener$1] */
    static {
        f22195a = new a();
        if (IAppContext.Companion.isDebug() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        f22196b = r0;
        f22199e = new FlowBackgroundInterceptStateCache$listener$1();
        return;
    L5:
        if (IAppContext.Companion.isReleaseChannel() == false) goto L8;
        r0 = false;
        goto L9
    }

    public final void a() {
        if (f22197c == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (f22197c == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        f22197c = true;     // Catch: Throwable -> L15
        x r0 = x.f38692a;     // Catch: Throwable -> L15
        monitor-exit(this);
        u.a(aa.b(IFlowAssistantStateIDL.class), false, false, $$Lambda$a$BSRlYsKVj2vgBb4NmhZ8PTjqn8.INSTANCE, 3, null);
    }

    private static final void a(IFlowAssistantStateIDL r4) {
        IFlowAssistantStateIDL r5 = (IFlowAssistantStateIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
        o.e(r5, "ipc");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L8
        f22198d = r5.isBackgroundIntercepting();     // Catch: Throwable -> L8
        r5.registerBackgroundInterceptingListener((IFlowBackgroundInterceptStateListenerIDL) ZeusTransformUtils.preCheckCast(f22199e, IFlowBackgroundInterceptStateListenerIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        if (f22196b == false) goto L6;
        ILogDepend.Companion.i(TAG, "registered listener, seed intercepting=" + f22198d);     // Catch: Throwable -> L8
    L6:
        Object r6 = n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L17;
        ILogDepend.Companion.w(TAG, "register background intercepting listener failed: " + r7.getMessage());
        return;
    L17:
        return;
    L8:
        th = move-exception;
        n.a r2 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L10
    }

    public final boolean b() {
        if (f22197c == true) goto L6;
        a();
    L6:
        return f22198d;
    }
}
