package com.obric.agent.autoaction;

import com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.funcall_api.bean.IntentAppAction;
import java.util.Map;

/* JADX INFO: compiled from: IAutoActionService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAutoActionService {
    void addExtForOAuto(IntentAppAction r1, IntentResult<?> r2, IntentAppAction r3);

    void closeAssistantInputPanel();

    void init();

    boolean isAutoActionInstalled();

    void notifyAssistantState(boolean r1, StateInfo r2);

    void notifyCloseAutoGUISwitch();

    void notifyStopAutoAction(String r1, String r2);

    void onAssistantInteractionListenerDied();

    void onFlowBind();

    void onFlowUnbind();

    void openAssistantInputPanel(StateInfo r1, boolean r2);

    void replyToAutoAction(String r1);

    void requestSendMessage(String r1, String r2, Map<String, String> r3);

    boolean scheduleTimerTask(int r1, String r2, String r3, String r4);

    void setAssistantInteractionListener(IAssistantInteractionListenerIDL r1);
}
