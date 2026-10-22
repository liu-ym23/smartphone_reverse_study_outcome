package com.bytedance.lego.init.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class PeriodTaskInfo {
    private String executionPeriod;
    private IPeriodTask task;
    private String taskId;

    public String getTaskId() {
        return this.taskId;
    }

    public IPeriodTask getTask() {
        return this.task;
    }

    public ExecutionPeriod getExecutionPeriod() {
        return ExecutionPeriod.from(this.executionPeriod);
    }

    public PeriodTaskInfo(String r3, IPeriodTask r4, String r5) {
        IPeriodTask r6 = (IPeriodTask) ZeusTransformUtils.wrapperContextForParams(r4, IPeriodTask.class, "com.obric.aiagent.plugin");
        this.taskId = r3;
        this.task = r6;
        this.executionPeriod = r5;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.taskId);
        r0.append(", " + this.task);
        r0.append(", " + this.executionPeriod);
        return r0.toString();
    }
}
