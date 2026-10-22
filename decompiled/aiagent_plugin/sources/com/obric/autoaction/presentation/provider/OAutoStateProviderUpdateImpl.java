package com.obric.autoaction.presentation.provider;

import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener;
import com.obric.autogui.common.api.presentation.WidgetState;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OAutoStateProviderUpdateImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OAutoStateProviderUpdateImpl implements IAutoAgentWidgetStateListener {
    public static final a Companion = null;
    private static final String TAG = "OAutoState-Prov";

    /* JADX INFO: compiled from: OAutoStateProviderUpdateImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onQueue(WidgetState.Queue r1) {
        o.e(r1, "state");
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onSetTimerTask(WidgetState.SetTimerTask r1) {
        o.e(r1, "state");
    }

    public OAutoStateProviderUpdateImpl() {
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onStateChange(WidgetState r1, WidgetState r2) {
        IAutoAgentWidgetStateListener.DefaultImpls.onStateChange(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onStateWillChange(WidgetState r1, WidgetState r2) {
        IAutoAgentWidgetStateListener.DefaultImpls.onStateWillChange(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onPreparing(WidgetState.Preparing r3) {
        o.e(r3, "state");
        Loog.INSTANCE.i(TAG, "onPreparing: ses=" + r3.getSessionInfo().getSessionId() + '/' + r3.getSessionInfo().getSessionKey());
        b.f25106a.a(b.a.f25109b);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onPrepared(WidgetState.Prepared r3) {
        o.e(r3, "state");
        Loog.INSTANCE.i(TAG, "onPrepared: ses=" + r3.getSessionInfo().getSessionId() + '/' + r3.getSessionInfo().getSessionKey());
        b.f25106a.a(b.a.f25109b);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onOperating(WidgetState.Operating r3) {
        o.e(r3, "state");
        Loog.INSTANCE.i(TAG, "onPrepared: ses=" + r3.getSessionInfo().getSessionId() + '/' + r3.getSessionInfo().getSessionKey());
        b.f25106a.a(b.a.f25110c);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onLastStep(WidgetState.LastStep r3) {
        o.e(r3, "state");
        Loog.INSTANCE.i(TAG, "onLastStep: ses=" + r3.getSessionInfo().getSessionId() + '/' + r3.getSessionInfo().getSessionKey());
        b.f25106a.a(b.a.f25108a);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onTerminate(WidgetState.Terminated r3) {
        o.e(r3, "state");
        Loog.INSTANCE.i(TAG, "onTerminate: ses=" + r3.getSessionInfo().getSessionId() + '/' + r3.getSessionInfo().getSessionKey());
        b.f25106a.a(b.a.f25108a);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onUserInterrupt(WidgetState.UserInterrupt r3) {
        o.e(r3, "state");
        Loog.INSTANCE.i(TAG, "onUserInterrupt: ses=" + r3.getSessionInfo().getSessionId() + '/' + r3.getSessionInfo().getSessionKey());
        b.f25106a.a(b.a.f);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onCallUser(WidgetState.CallUser r3) {
        o.e(r3, "state");
        Loog.INSTANCE.i(TAG, "onCallUser: ses=" + r3.getSessionInfo().getSessionId() + '/' + r3.getSessionInfo().getSessionKey());
        b.f25106a.a(b.a.f25112e);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onClarify(WidgetState.Clarify r3) {
        o.e(r3, "state");
        Loog.INSTANCE.i(TAG, "onClarify: ses=" + r3.getSessionInfo().getSessionId() + '/' + r3.getSessionInfo().getSessionKey());
        b.f25106a.a(b.a.f25111d);
    }
}
