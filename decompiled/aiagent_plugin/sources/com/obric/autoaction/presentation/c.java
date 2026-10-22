package com.obric.autoaction.presentation;

import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.b.ad;
import kotlinx.coroutines.b.w;

/* JADX INFO: compiled from: AgentEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f24841a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final w<b> f24842b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ab<b> f24843c = null;

    private c() {
    }

    static {
        f24841a = new c();
        w<b> r0 = ad.a(0, 0, null, 7, null);
        f24842b = r0;
        f24843c = kotlinx.coroutines.b.j.a(r0);
    }

    public final ab<b> a() {
        return f24843c;
    }

    public final Object a(String r2, boolean r3, d.c.d<? super x> r4) {
        d.c.d<? super x> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r5 = f24842b.emit(new b.h(r2, r3), r1);
        if (r5 != d.c.a.b.a()) goto L6;
        return r5;
    L6:
        return x.f38692a;
    }

    public final Object a(IAutoActionAgentEventListener.SessionInfo r8, BizStatus r9, BizStatus r10, Bundle r11, int r12, d.c.d<? super x> r13) {
        d.c.d<? super x> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        Object r14 = f24842b.emit(new b.c(r8, r9, r10, r11, r12), r7);
        if (r14 != d.c.a.b.a()) goto L6;
        return r14;
    L6:
        return x.f38692a;
    }

    public final Object a(QueueStatus r2, d.c.d<? super x> r3) {
        d.c.d<? super x> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        Object r4 = f24842b.emit(new b.g(r2), r1);
        if (r4 != d.c.a.b.a()) goto L6;
        return r4;
    L6:
        return x.f38692a;
    }

    public final Object a(String r2, IAutoActionAgentEventListener.AgentStepInfo r3, d.c.d<? super x> r4) {
        d.c.d<? super x> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r5 = f24842b.emit(new b.C0576b(r2, r3), r1);
        if (r5 != d.c.a.b.a()) goto L6;
        return r5;
    L6:
        return x.f38692a;
    }

    public final Object a(IAutoActionAgentEventListener.OperatingAppInfo r2, d.c.d<? super x> r3) {
        d.c.d<? super x> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        Object r4 = f24842b.emit(new b.f(r2), r1);
        if (r4 != d.c.a.b.a()) goto L6;
        return r4;
    L6:
        return x.f38692a;
    }

    public final Object a(IAutoActionAgentEventListener.SessionInfo r2, IAutoActionAgentEventListener.AgentStepInfo r3, IAutoActionAgentEventListener.AgentStepExecInfo r4, d.c.d<? super x> r5) {
        d.c.d<? super x> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Object r6 = f24842b.emit(new b.a(r2, r3, r4), r1);
        if (r6 != d.c.a.b.a()) goto L6;
        return r6;
    L6:
        return x.f38692a;
    }

    public final Object a(String r2, b.d r3, d.c.d<? super x> r4) {
        d.c.d<? super x> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r5 = f24842b.emit(new b.e(r2, r3), r1);
        if (r5 != d.c.a.b.a()) goto L6;
        return r5;
    L6:
        return x.f38692a;
    }
}
