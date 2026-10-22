package com.obric.aiagent.product.platform.impl.b;

import android.app.ITopActivityAssistDataReceiver;
import android.view.input.AssistantInputManager;
import android.view.input.ObricInputManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: InjectEventResponseBridge.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f18824a = null;

    static {
        f18824a = new c();
    }

    private c() {
    }

    public final boolean a(com.obric.framework.inputmethod.api.a r2) {
        o.e(r2, "listener");
        Object r1 = r2.a();
        o.a(r1, "null cannot be cast to non-null type android.app.ITopActivityAssistDataReceiver");
        ObricInputManager.registerInjectEventResponseListener((ITopActivityAssistDataReceiver) ZeusTransformUtils.preCheckCast(r1, ITopActivityAssistDataReceiver.class, "com.obric.aiagent.plugin"));
        return true;
    }

    public final boolean b(com.obric.framework.inputmethod.api.a r2) {
        o.e(r2, "listener");
        Object r1 = r2.a();
        o.a(r1, "null cannot be cast to non-null type android.app.ITopActivityAssistDataReceiver");
        ObricInputManager.unregisterInjectEventResponseListener((ITopActivityAssistDataReceiver) ZeusTransformUtils.preCheckCast(r1, ITopActivityAssistDataReceiver.class, "com.obric.aiagent.plugin"));
        return true;
    }

    public final boolean c(com.obric.framework.inputmethod.api.a r2) {
        o.e(r2, "listener");
        Object r1 = r2.a();
        o.a(r1, "null cannot be cast to non-null type android.app.ITopActivityAssistDataReceiver");
        AssistantInputManager.registerInjectEventResponseListener((ITopActivityAssistDataReceiver) ZeusTransformUtils.preCheckCast(r1, ITopActivityAssistDataReceiver.class, "com.obric.aiagent.plugin"));
        return true;
    }

    public final boolean d(com.obric.framework.inputmethod.api.a r2) {
        o.e(r2, "listener");
        Object r1 = r2.a();
        o.a(r1, "null cannot be cast to non-null type android.app.ITopActivityAssistDataReceiver");
        AssistantInputManager.unregisterInjectEventResponseListener((ITopActivityAssistDataReceiver) ZeusTransformUtils.preCheckCast(r1, ITopActivityAssistDataReceiver.class, "com.obric.aiagent.plugin"));
        return true;
    }
}
