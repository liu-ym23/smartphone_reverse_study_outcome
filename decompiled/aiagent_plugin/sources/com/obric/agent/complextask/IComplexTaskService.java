package com.obric.agent.complextask;

import android.content.Context;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ITaskStateChangeCallback;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.funcall_api.bean.IntentAppAction;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IComplexTaskService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IComplexTaskService {
    void addComplexTaskExt(String r1);

    void clearAllOmniTask(Map<String, String> r1);

    List<String> getComplexTaskPanelInfoFromPC(int r1);

    Map<String, String> getContext(DispatchContext r1);

    Map<String, String> getExtraForAgentSendMessage();

    d getOmniRunningState(String r1);

    void init(Context r1);

    void notifyStopComplexTask(String r1, String r2);

    void onReceiveMessage(String r1, IMMessage r2);

    void operateQueue(String r1);

    void playTts(String r1, String r2, String r3, String r4);

    void replyAskUser(String r1, String r2, String r3, Map<Object, Object> r4);

    void reportChangeTransitionFailed(String r1, String r2);

    void reportExecutionStep(IntentAppAction r1);

    void requestStateChanged(String r1, TaskStateInfo r2, ITaskStateChangeCallback r3, long r4);

    boolean sendQuery(String r1, boolean r2, String r3, String r4, String r5, Map<String, String> r6);

    void showProxyCallHistory(String r1);
}
