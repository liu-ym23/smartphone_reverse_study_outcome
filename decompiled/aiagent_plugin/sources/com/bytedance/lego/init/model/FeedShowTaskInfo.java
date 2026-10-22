package com.bytedance.lego.init.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class FeedShowTaskInfo implements Serializable, Comparable<FeedShowTaskInfo> {

    @SerializedName("moduleName")
    public String moduleName;

    @SerializedName("mustRunInMainThread")
    public boolean mustRunInMainThread;

    @SerializedName("priority")
    public int priority;
    public transient BaseFeedShowTask task;

    @SerializedName(DBDefinition.TASK_ID)
    public String taskId;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(FeedShowTaskInfo r3) {
        return compareTo2((FeedShowTaskInfo) ZeusTransformUtils.preCheckCast(r3, FeedShowTaskInfo.class, "com.obric.aiagent.plugin"));
    }

    public FeedShowTaskInfo() {
    }

    public FeedShowTaskInfo(String r3, String r4, BaseFeedShowTask r5, boolean r6, int r7) {
        BaseFeedShowTask r8 = (BaseFeedShowTask) ZeusTransformUtils.wrapperContextForParams(r5, BaseFeedShowTask.class, "com.obric.aiagent.plugin");
        this.taskId = r3;
        this.moduleName = r4;
        this.task = r8;
        this.mustRunInMainThread = r6;
        this.priority = r7;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FeedShowTaskInfo r3) {
        int r0 = this.priority;
        int r1 = r3.priority;
        if (r0 >= r1) goto L6;
        return 1;
    L6:
        if (r0 <= r1) goto L10;
        return -1;
    L10:
        return this.task.getClass().getSimpleName().compareTo(r3.task.getClass().getSimpleName());
    }

    public String toString() {
        return this.priority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName;
    }
}
