package com.bytedance.lego.init.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PriorityInitTask.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PriorityInitTask implements Comparable<PriorityInitTask> {
    private final float priority;
    private final InitTaskInfo taskInfo;

    public PriorityInitTask(float r2, InitTaskInfo r3) {
        o.d(r3, "taskInfo");
        this.priority = r2;
        this.taskInfo = r3;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(PriorityInitTask r3) {
        return compareTo2((PriorityInitTask) ZeusTransformUtils.preCheckCast(r3, PriorityInitTask.class, "com.obric.aiagent.plugin"));
    }

    public final float getPriority() {
        return this.priority;
    }

    public final InitTaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(PriorityInitTask r3) {
        o.d(r3, "o");
        float r4 = r3.priority - this.priority;
        float r0 = 0;
        if (r4 <= r0) goto L7;
        return 1;
    L7:
        if (r4 >= r0) goto L10;
        return -1;
    L10:
        return 0;
    }
}
