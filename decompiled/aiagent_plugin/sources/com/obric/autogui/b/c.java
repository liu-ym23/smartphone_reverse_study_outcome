package com.obric.autogui.b;

import com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: TaskFunctionEventListeners.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements IAutoActionTaskFunctionEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f28941a = null;

    static {
        f28941a = new c();
    }

    /* JADX INFO: renamed from: lambda$mNBM-zImN4I_il6_DeOAeCxNnJI, reason: not valid java name */
    public static /* synthetic */ x m797lambda$mNBMzImN4I_il6_DeOAeCxNnJI(String r0, IAutoActionTaskFunctionEventListener r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$t_6-DXRXkARl4riAHIBHdk2gk2A, reason: not valid java name */
    public static /* synthetic */ x m798lambda$t_6DXRXkARl4riAHIBHdk2gk2A(String r0, IAutoActionTaskFunctionEventListener r1) {
        return a(r0, r1);
    }

    private c() {
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener
    public void onFunctionStarted(final String r2) {
        o.e(r2, "functionName");
        a(new $$Lambda$c$t_6DXRXkARl4riAHIBHdk2gk2A(r2));
    }

    private static final x a(String r2, IAutoActionTaskFunctionEventListener r3) {
        IAutoActionTaskFunctionEventListener r4 = (IAutoActionTaskFunctionEventListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoActionTaskFunctionEventListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "$this$triggerListeners");
        r4.onFunctionStarted(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener
    public void onFunctionStopped(final String r2) {
        o.e(r2, "functionName");
        a(new $$Lambda$c$mNBMzImN4I_il6_DeOAeCxNnJI(r2));
    }

    private static final x b(String r2, IAutoActionTaskFunctionEventListener r3) {
        IAutoActionTaskFunctionEventListener r4 = (IAutoActionTaskFunctionEventListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoActionTaskFunctionEventListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "$this$triggerListeners");
        r4.onFunctionStopped(r2);
        return x.f38692a;
    }

    private final void a(d.h.a.b<? super IAutoActionTaskFunctionEventListener, x> r4) {
        d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        Set r5 = ServiceManager.get().getServices(IAutoActionTaskFunctionEventListener.class);
        o.b(r5, "ServiceManager.get().getServices(T::class.java)");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        r3.invoke((IAutoActionTaskFunctionEventListener) ZeusTransformUtils.preCheckCast(r6.next(), IAutoActionTaskFunctionEventListener.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L4
    }
}
