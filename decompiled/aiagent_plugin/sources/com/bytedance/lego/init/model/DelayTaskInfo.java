package com.bytedance.lego.init.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DelayTaskInfo implements Serializable, Comparable<DelayTaskInfo> {

    @SerializedName("delayTime")
    public DelayTime delayTime;

    @SerializedName("moduleName")
    public String moduleName;

    @SerializedName("mustRunInMainThread")
    public boolean mustRunInMainThread;

    @SerializedName("priority")
    public int priority;

    @SerializedName("realPriority")
    public int realPriority;

    @SerializedName("runInProcess")
    public List<String> runInProcess;
    public transient IDelayTask task;

    @SerializedName(DBDefinition.TASK_ID)
    public String taskId;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(DelayTaskInfo r3) {
        return compareTo2((DelayTaskInfo) ZeusTransformUtils.preCheckCast(r3, DelayTaskInfo.class, "com.obric.aiagent.plugin"));
    }

    public DelayTaskInfo() {
    }

    public DelayTaskInfo(String r3, String r4, IDelayTask r5, boolean r6, List<String> r7, int r8, DelayTime r9) {
        IDelayTask r10 = (IDelayTask) ZeusTransformUtils.wrapperContextForParams(r5, IDelayTask.class, "com.obric.aiagent.plugin");
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        this.taskId = r3;
        this.moduleName = r4;
        this.task = r10;
        this.mustRunInMainThread = r6;
        this.runInProcess = r11;
        this.priority = r8;
        this.delayTime = r9;
        this.realPriority = r9.getValue() - r8;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(DelayTaskInfo r3) {
        int r0 = this.realPriority;
        int r1 = r3.realPriority;
        if (r0 >= r1) goto L6;
        return -1;
    L6:
        if (r0 <= r1) goto L10;
        return 1;
    L10:
        return this.task.getClass().getSimpleName().compareTo(r3.task.getClass().getSimpleName());
    }

    public String toString() {
        return this.realPriority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName + "," + this.delayTime.name() + "," + this.priority + "," + listToString(this.runInProcess);
    }

    private String listToString(List<String> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.isEmpty() == true) goto L16;
        StringBuilder r7 = new StringBuilder();
        r7.append("[");
        r7.append((String) ZeusTransformUtils.preCheckCast(r5.get(0), String.class, "com.obric.aiagent.plugin"));
        int r1 = 1;
    L9:
        if (r1 >= r5.size()) goto L11;
        r7.append("," + ((String) ZeusTransformUtils.preCheckCast(r5.get(r1), String.class, "com.obric.aiagent.plugin")));
        r1 = r1 + 1;
        goto L9
    L11:
        r7.append("]");
        return r7.toString();
    L16:
        return null;
    }
}
