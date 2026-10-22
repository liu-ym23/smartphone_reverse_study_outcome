package com.obric.autoaction.presentation.function;

import com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener;
import com.obric.autogui.common.api.logging.Loog;
import d.h.b.o;

/* JADX INFO: compiled from: UIAgentFunctionListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class UIAgentFunctionListener implements IAutoActionTaskFunctionEventListener {
    private final String TAG;

    public UIAgentFunctionListener() {
        this.TAG = "UI-FuncListener";
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener
    public void onFunctionStarted(String r4) {
        o.e(r4, "functionName");
        Loog.INSTANCE.d(this.TAG, "functionStarted (" + r4 + ')');
        b.f24937a.a(r4);
        a r3 = b.f24937a.b(r4);
        if (r3 == null) goto L6;
        r3.d();
        return;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener
    public void onFunctionStopped(String r4) {
        o.e(r4, "functionName");
        Loog.INSTANCE.d(this.TAG, "onFunctionStopped (" + r4 + ')');
        b.f24937a.a(null);
        a r3 = b.f24937a.b(r4);
        if (r3 == null) goto L6;
        r3.f();
        return;
    }
}
