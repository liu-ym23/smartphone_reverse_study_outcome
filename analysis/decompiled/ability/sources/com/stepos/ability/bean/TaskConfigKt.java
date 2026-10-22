package com.stepos.ability.bean;

import android.os.Bundle;
import com.stepos.ability.common.TaskStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import w0.C2085f;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toInternalTask", "Lcom/stepos/ability/bean/InternalTask;", "Lcom/stepos/ability/bean/TaskConfig;", "bean_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskConfigKt {
    public static final InternalTask toInternalTask(TaskConfig taskConfig) {
        k.f(taskConfig, "<this>");
        Long abilityId = taskConfig.getAbilityId();
        String toolCallId = taskConfig.getToolCallId();
        String toolName = taskConfig.getToolName();
        GuiAgentConfig guiAgentConfig = taskConfig.getGuiAgentConfig();
        String taskId = taskConfig.getTaskId();
        String parentTaskId = taskConfig.getParentTaskId();
        TaskUiInfo taskUiInfo = taskConfig.getTaskUiInfo();
        String name = taskUiInfo != null ? taskUiInfo.getName() : null;
        TaskUiInfo taskUiInfo2 = taskConfig.getTaskUiInfo();
        String coverUri = taskUiInfo2 != null ? taskUiInfo2.getCoverUri() : null;
        TaskUiInfo taskUiInfo3 = taskConfig.getTaskUiInfo();
        String description = taskUiInfo3 != null ? taskUiInfo3.getDescription() : null;
        int taskType = taskConfig.getTaskType();
        int priority = taskConfig.getPriority();
        C2085f c2085f = TaskStatus.b;
        String params = taskConfig.getParams();
        Bundle extra = taskConfig.getExtra();
        String clientPackageName = taskConfig.getClientPackageName();
        if (clientPackageName == null) {
            clientPackageName = "";
        }
        return new InternalTask(new Task(taskId, null, name, coverUri, description, clientPackageName, 0, taskType, 0, priority, parentTaskId, 0L, 0L, 0L, null, null, params, extra, taskConfig.getVersion(), 63554, null), toolCallId, abilityId, toolName, guiAgentConfig);
    }
}
