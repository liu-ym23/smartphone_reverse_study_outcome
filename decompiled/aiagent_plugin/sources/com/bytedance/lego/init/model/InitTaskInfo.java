package com.bytedance.lego.init.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InitTaskInfo implements Comparable<InitTaskInfo> {
    public boolean afterPrivacyPopupWindow;
    public List<String> child;
    public List<String> dependencies;
    public volatile InitPeriod endPeriod;
    public volatile long endTime;
    public volatile boolean isCompleted;
    public String moduleName;
    public boolean mustRunInMainThread;
    public List<String> parent;
    public float realPriority;
    public List<String> runInProcess;
    public volatile long startTime;
    public IInitTask task;
    public String taskClassName;
    public String taskId;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(InitTaskInfo r3) {
        return compareTo2((InitTaskInfo) ZeusTransformUtils.preCheckCast(r3, InitTaskInfo.class, "com.obric.aiagent.plugin"));
    }

    public InitTaskInfo() {
        this.realPriority = 0.0f;
    }

    public InitTaskInfo(String r3, boolean r4, boolean r5, float r6, List<String> r7, List<String> r8, List<String> r9, List<String> r10, String r11, InitPeriod r12) {
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        this.realPriority = 0.0f;
        this.taskId = r3;
        this.mustRunInMainThread = r4;
        this.runInProcess = r13;
        this.realPriority = r6;
        this.child = r14;
        this.parent = r15;
        this.dependencies = r16;
        this.taskClassName = r11;
        this.endPeriod = r12;
        this.afterPrivacyPopupWindow = r5;
    }

    public InitTaskInfo(String r3, boolean r4, boolean r5, float r6, List<String> r7, List<String> r8, List<String> r9, List<String> r10, String r11, IInitTask r12, InitPeriod r13) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List<String> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        IInitTask r18 = (IInitTask) ZeusTransformUtils.wrapperContextForParams(r12, IInitTask.class, "com.obric.aiagent.plugin");
        this.realPriority = 0.0f;
        this.taskId = r3;
        this.mustRunInMainThread = r4;
        this.runInProcess = r14;
        this.realPriority = r6;
        this.child = r15;
        this.parent = r16;
        this.dependencies = r17;
        this.taskClassName = r11;
        this.task = r18;
        this.endPeriod = r13;
        this.afterPrivacyPopupWindow = r5;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(InitTaskInfo r4) {
        float r0 = r4.realPriority - this.realPriority;
        if (r0 <= 0.0f) goto L7;
        return 1;
    L7:
        if (r0 >= 0.0f) goto L11;
        return -1;
    L11:
        return this.taskClassName.compareTo(r4.taskClassName);
    }

    public String toString() {
        return this.realPriority + "," + this.taskId + "," + this.mustRunInMainThread;
    }

    public String getFullContent() {
        return this.realPriority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName + "," + this.taskClassName + "," + listToString(this.runInProcess) + "," + listToString(this.dependencies) + "," + listToString(this.parent) + "," + listToString(this.parent);
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
