package com.obric.autoaction.presentation.input.states;

import com.obric.autogui.common.api.presentation.api.IAssistInputStateManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: AssistInputStateManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AssistInputStateManagerImpl implements IAssistInputStateManager {
    private final /* synthetic */ c $$delegate_0;

    @Override // com.obric.autogui.common.api.presentation.api.IAssistInputStateManager
    public IAssistInputStateManager.AssistInputMode getAssistInputMode() {
        return this.$$delegate_0.getAssistInputMode();
    }

    @Override // com.obric.autogui.common.api.presentation.api.IAssistInputStateManager
    public IAssistInputStateManager.StateType getCurrentState() {
        return this.$$delegate_0.getCurrentState();
    }

    @Override // com.obric.autogui.common.api.presentation.api.IAssistInputStateManager
    public void launchStateChange(IAssistInputStateManager.StateType r3, IAssistInputStateManager.StateType r4, Map<String, ? extends Object> r5) {
        Map<String, ? extends Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "to");
        o.e(r4, "from");
        this.$$delegate_0.launchStateChange(r3, r4, r6);
    }

    public AssistInputStateManagerImpl() {
        this.$$delegate_0 = c.f25027a;
    }
}
