package com.bytedance.lego.init.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InitTaskFullInfo implements Serializable, Comparable<InitTaskFullInfo> {

    @SerializedName("afterPrivacyPopupWindow")
    public boolean afterPrivacyPopupWindow;
    public transient List<String> child;
    public transient List<String> dependencies;

    @SerializedName("dependon")
    public String[] dependon;

    @SerializedName("desc")
    public String desc;

    @SerializedName("earliestPeriod")
    public InitPeriod earliestPeriod;

    @SerializedName("executePriority")
    public int executePriority;

    @SerializedName("latestPeriod")
    public InitPeriod latestPeriod;

    @SerializedName("moduleName")
    public String moduleName;

    @SerializedName("mustRunInMainThread")
    public boolean mustRunInMainThread;
    public transient List<String> parent;
    public transient int priority;
    public transient float realPriority;

    @SerializedName("runInProcess")
    public List<String> runInProcess;

    @SerializedName("taskClassName")
    public String taskClassName;

    @SerializedName(DBDefinition.TASK_ID)
    public String taskId;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(InitTaskFullInfo r3) {
        return compareTo2((InitTaskFullInfo) ZeusTransformUtils.preCheckCast(r3, InitTaskFullInfo.class, "com.obric.aiagent.plugin"));
    }

    public InitTaskFullInfo() {
        this.earliestPeriod = InitPeriod.APP_ATTACHBASE2SUPER;
        this.latestPeriod = InitPeriod.NONE;
        this.priority = -1;
        this.realPriority = 0.0f;
    }

    public InitTaskFullInfo(String r3, Boolean r4, boolean r5, InitPeriod r6, InitPeriod r7, float r8, List<String> r9, List<String> r10, List<String> r11, List<String> r12, String r13) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        List<String> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        this.earliestPeriod = InitPeriod.APP_ATTACHBASE2SUPER;
        this.latestPeriod = InitPeriod.NONE;
        this.priority = -1;
        this.realPriority = 0.0f;
        this.taskId = r3;
        this.mustRunInMainThread = r4.booleanValue();
        this.earliestPeriod = r6;
        this.latestPeriod = r7;
        this.realPriority = r8;
        this.runInProcess = r14;
        this.child = r15;
        this.parent = r16;
        this.dependencies = r17;
        this.taskClassName = r13;
        this.afterPrivacyPopupWindow = r5;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(InitTaskFullInfo r4) {
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
        return this.realPriority + "," + this.taskId + "," + this.mustRunInMainThread + ",[" + getPeriodStr(this.earliestPeriod) + "," + getPeriodStr(this.latestPeriod) + "]," + arrayToString(this.dependon) + "," + listToString(this.runInProcess) + "," + this.moduleName;
    }

    public String getFullContent() {
        return this.realPriority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName + "," + this.taskClassName + "," + listToString(this.runInProcess) + "," + listToString(this.dependencies) + "," + listToString(this.child) + "," + listToString(this.parent);
    }

    private String getPeriodStr(InitPeriod r1) {
        if (r1 != null) goto L6;
        return InitPeriod.NONE.name();
    L6:
        return r1.name();
    }

    private String arrayToString(String[] r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.length <= 0) goto L15;
        StringBuilder r3 = new StringBuilder();
        r3.append("[");
        r3.append(r4[0]);
        int r0 = 1;
    L8:
        if (r0 >= r4.length) goto L10;
        r3.append("," + r4[r0]);
        r0 = r0 + 1;
        goto L8
    L10:
        r3.append("]");
        return r3.toString();
    L15:
        return null;
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
