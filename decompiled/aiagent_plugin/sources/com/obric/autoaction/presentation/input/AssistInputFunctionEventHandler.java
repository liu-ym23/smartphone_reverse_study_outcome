package com.obric.autoaction.presentation.input;

import com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener;
import com.obric.autogui.common.api.assistant.AssistantAbilityHelper;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import d.h.b.o;

/* JADX INFO: compiled from: AssistInputFunctionEventHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AssistInputFunctionEventHandler implements IAutoActionTaskFunctionEventListener {
    @Override // com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener
    public void onFunctionStarted(String r1) {
        o.e(r1, "functionName");
    }

    public AssistInputFunctionEventHandler() {
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener
    public void onFunctionStopped(String r4) {
        o.e(r4, "functionName");
        if (o.a(r4, "CallUser") == true) goto L7;
        if (o.a(r4, "ManualOperating") == true) goto L7;
        return;
    L7:
        if (AssistantAbilityHelper.INSTANCE.isChatPageInVD() == false) goto L11;
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [AssistInput] closeInput as `" + r4 + "` stopped (assist-in-vd).");
        b.f24958a.d();
        return;
    }
}
