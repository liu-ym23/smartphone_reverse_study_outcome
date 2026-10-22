package com.obric.assistant.dm.api.statemachine.manager;

import android.content.Context;
import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.core.TaskState;
import com.obric.assistant.dm.api.statemachine.core.b;
import java.util.Map;

/* JADX INFO: compiled from: IDialogStateManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IDialogStateManager {
    void cancelTask(TaskInfo r1);

    void cancelTask(TaskState r1);

    void clearAllOmniTask(Map<String, String> r1);

    DMState getCurrentDMState();

    TaskInfo getStateMachinesFromQuestionId(String r1);

    void init(Context r1);

    boolean isLogin();

    void notifyDMEvent(DMEvent r1);

    void notifyOAutoDied();

    void notifyStopOAuto(String r1);

    void registerDMStateListener(b r1);

    void replyComplexAskUser(String r1, String r2, String r3, Map<Object, Object> r4);

    void replyOmniAskUser(String r1, String r2, Map<Object, Object> r3);

    void setLogin(boolean r1);
}
