package com.bytedance.lego.init.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class IdleTaskInfo implements Comparable<IdleTaskInfo> {
    public boolean mustRunInMainThread;
    public int priority;
    public BaseIdleTask task;
    public String taskId;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(IdleTaskInfo r3) {
        return compareTo2((IdleTaskInfo) ZeusTransformUtils.preCheckCast(r3, IdleTaskInfo.class, "com.obric.aiagent.plugin"));
    }

    public IdleTaskInfo(String r3, boolean r4, int r5, BaseIdleTask r6) {
        BaseIdleTask r7 = (BaseIdleTask) ZeusTransformUtils.wrapperContextForParams(r6, BaseIdleTask.class, "com.obric.aiagent.plugin");
        this.taskId = r3;
        this.mustRunInMainThread = r4;
        this.priority = r5;
        this.task = r7;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(IdleTaskInfo r3) {
        if (r3 == null) goto L15;
        BaseIdleTask r0 = this.task;
        if (r0 == null) goto L17;
        int r2 = this.priority;
        int r1 = r3.priority;
        if (r2 <= r1) goto L10;
        return -1;
    L10:
        if (r2 >= r1) goto L14;
        return 1;
    L14:
        return r0.getClass().getSimpleName().compareTo(r3.task.getClass().getSimpleName());
    L17:
        return 0;
    L15:
        return 0;
    }

    public String toString() {
        return "priority:" + this.priority + " taskClassName:" + this.task.getClass().getSimpleName() + " mustRunInMainThread:" + this.mustRunInMainThread;
    }
}
