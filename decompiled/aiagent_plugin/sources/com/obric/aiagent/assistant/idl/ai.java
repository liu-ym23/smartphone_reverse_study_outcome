package com.obric.aiagent.assistant.idl;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FlowMessageCallbackExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ai {
    private static final String TAG = "FlowMessageCallbackExt";

    public static final void a(IFlowMessageIDL r4, IFlowMessageCallbackIDL r5, int r6) {
        IFlowMessageIDL r7 = (IFlowMessageIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowMessageIDL.class, "com.obric.aiagent.plugin");
        IFlowMessageCallbackIDL r8 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "<this>");
        d.h.b.o.e(r8, "callback");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        r7.registerCallback(r8);     // Catch: Throwable -> L5
        Object r1 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r2 = d.n.c(r1);
        if (r2 == null) goto L17;
        ILogDepend.Companion.e(TAG, "registerCallback failed", r2);
    L17:
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L12
        r7.registerCallbackWithEvents(r8, r6);     // Catch: Throwable -> L12
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        d.n.f(d.o.a(th));
        return;
    L5:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r1 = d.n.f(d.o.a(th));
        goto L7
    }
}
