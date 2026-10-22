package com.stepos.taskrobot.taskmanager.experiencelib.model;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/DeleteExperienceResponse;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DeleteExperienceResponse {

    @SerializedName("task_id")
    private final String taskId;

    public DeleteExperienceResponse(String taskId) {
        k.f(taskId, "taskId");
        this.taskId = taskId;
    }

    public static /* synthetic */ DeleteExperienceResponse copy$default(DeleteExperienceResponse deleteExperienceResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deleteExperienceResponse.taskId;
        }
        return deleteExperienceResponse.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public final DeleteExperienceResponse copy(String taskId) {
        k.f(taskId, "taskId");
        return new DeleteExperienceResponse(taskId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DeleteExperienceResponse) && k.b(this.taskId, ((DeleteExperienceResponse) other).taskId);
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        return this.taskId.hashCode();
    }

    public String toString() {
        return a.m("DeleteExperienceResponse(taskId=", this.taskId, ")");
    }
}
