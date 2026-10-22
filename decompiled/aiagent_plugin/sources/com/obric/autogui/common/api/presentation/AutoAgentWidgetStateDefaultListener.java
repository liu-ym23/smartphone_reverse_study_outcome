package com.obric.autogui.common.api.presentation;

import d.h.b.o;

/* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public class AutoAgentWidgetStateDefaultListener implements IAutoAgentWidgetStateListener {
    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onCallUser(WidgetState.CallUser r1) {
        o.e(r1, "state");
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onClarify(WidgetState.Clarify r1) {
        o.e(r1, "state");
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onLastStep(WidgetState.LastStep r1) {
        o.e(r1, "state");
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onOperating(WidgetState.Operating r1) {
        o.e(r1, "state");
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onPrepared(WidgetState.Prepared r1) {
        o.e(r1, "state");
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onPreparing(WidgetState.Preparing r1) {
        o.e(r1, "state");
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onQueue(WidgetState.Queue r1) {
        o.e(r1, "state");
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onSetTimerTask(WidgetState.SetTimerTask r1) {
        o.e(r1, "state");
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onTerminate(WidgetState.Terminated r1) {
        o.e(r1, "state");
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onUserInterrupt(WidgetState.UserInterrupt r1) {
        o.e(r1, "state");
    }

    public AutoAgentWidgetStateDefaultListener() {
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onStateChange(WidgetState r1, WidgetState r2) {
        IAutoAgentWidgetStateListener.DefaultImpls.onStateChange(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onStateWillChange(WidgetState r1, WidgetState r2) {
        IAutoAgentWidgetStateListener.DefaultImpls.onStateWillChange(this, r1, r2);
    }
}
