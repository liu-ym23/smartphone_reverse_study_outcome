package com.stepos.taskrobot.taskmemory.bean;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.taskmemory.entity.TaskDeviceInfoEntity;
import com.stepos.taskrobot.taskmemory.entity.TaskEntity;
import com.stepos.taskrobot.taskmemory.entity.TaskStepEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/bean/TaskDetailVO;", "", "task", "Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "device", "Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;", "stepList", "", "Lcom/stepos/taskrobot/taskmemory/entity/TaskStepEntity;", AppAgent.CONSTRUCT, "(Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;Ljava/util/List;)V", "getTask", "()Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "getDevice", "()Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;", "getStepList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskDetailVO {
    private final TaskDeviceInfoEntity device;
    private final List<TaskStepEntity> stepList;
    private final TaskEntity task;

    public TaskDetailVO(TaskEntity task, TaskDeviceInfoEntity taskDeviceInfoEntity, List<TaskStepEntity> stepList) {
        k.f(task, "task");
        k.f(stepList, "stepList");
        this.task = task;
        this.device = taskDeviceInfoEntity;
        this.stepList = stepList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskDetailVO copy$default(TaskDetailVO taskDetailVO, TaskEntity taskEntity, TaskDeviceInfoEntity taskDeviceInfoEntity, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            taskEntity = taskDetailVO.task;
        }
        if ((i & 2) != 0) {
            taskDeviceInfoEntity = taskDetailVO.device;
        }
        if ((i & 4) != 0) {
            list = taskDetailVO.stepList;
        }
        return taskDetailVO.copy(taskEntity, taskDeviceInfoEntity, list);
    }

    /* renamed from: component1, reason: from getter */
    public final TaskEntity getTask() {
        return this.task;
    }

    /* renamed from: component2, reason: from getter */
    public final TaskDeviceInfoEntity getDevice() {
        return this.device;
    }

    public final List<TaskStepEntity> component3() {
        return this.stepList;
    }

    public final TaskDetailVO copy(TaskEntity task, TaskDeviceInfoEntity device, List<TaskStepEntity> stepList) {
        k.f(task, "task");
        k.f(stepList, "stepList");
        return new TaskDetailVO(task, device, stepList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskDetailVO)) {
            return false;
        }
        TaskDetailVO taskDetailVO = (TaskDetailVO) other;
        return k.b(this.task, taskDetailVO.task) && k.b(this.device, taskDetailVO.device) && k.b(this.stepList, taskDetailVO.stepList);
    }

    public final TaskDeviceInfoEntity getDevice() {
        return this.device;
    }

    public final List<TaskStepEntity> getStepList() {
        return this.stepList;
    }

    public final TaskEntity getTask() {
        return this.task;
    }

    public int hashCode() {
        int iHashCode = this.task.hashCode() * 31;
        TaskDeviceInfoEntity taskDeviceInfoEntity = this.device;
        return this.stepList.hashCode() + ((iHashCode + (taskDeviceInfoEntity == null ? 0 : taskDeviceInfoEntity.hashCode())) * 31);
    }

    public String toString() {
        TaskEntity taskEntity = this.task;
        TaskDeviceInfoEntity taskDeviceInfoEntity = this.device;
        List<TaskStepEntity> list = this.stepList;
        StringBuilder sb = new StringBuilder("TaskDetailVO(task=");
        sb.append(taskEntity);
        sb.append(", device=");
        sb.append(taskDeviceInfoEntity);
        sb.append(", stepList=");
        return a.q(sb, list, ")");
    }
}
