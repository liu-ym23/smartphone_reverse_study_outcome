package com.stepos.ability.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import h0.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TaskConfig implements Parcelable {
    public static final Parcelable.Creator<TaskConfig> CREATOR = new a();
    private final Long abilityId;
    private final String clientPackageName;
    private final String condition;
    private final Bundle extra;
    private final GuiAgentConfig guiAgentConfig;
    private final String params;
    private final String parentTaskId;
    private final int priority;
    private final String taskId;
    private final int taskType;
    private final TaskUiInfo taskUiInfo;
    private final String toolCallId;
    private final String toolName;
    private final int version;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<TaskConfig> {
        @Override // android.os.Parcelable.Creator
        public final TaskConfig createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new TaskConfig(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readInt() == 0 ? null : TaskUiInfo.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? GuiAgentConfig.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readBundle(TaskConfig.class.getClassLoader()), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final TaskConfig[] newArray(int i10) {
            return new TaskConfig[i10];
        }
    }

    public TaskConfig(String taskId, String toolCallId, String str, int i10, int i11, String str2, Long l10, String str3, TaskUiInfo taskUiInfo, GuiAgentConfig guiAgentConfig, String str4, Bundle bundle, String str5, int i12) {
        g.f(taskId, "taskId");
        g.f(toolCallId, "toolCallId");
        this.taskId = taskId;
        this.toolCallId = toolCallId;
        this.parentTaskId = str;
        this.taskType = i10;
        this.priority = i11;
        this.condition = str2;
        this.abilityId = l10;
        this.toolName = str3;
        this.taskUiInfo = taskUiInfo;
        this.guiAgentConfig = guiAgentConfig;
        this.params = str4;
        this.extra = bundle;
        this.clientPackageName = str5;
        this.version = i12;
    }

    public final String component1() {
        return this.taskId;
    }

    public final GuiAgentConfig component10() {
        return this.guiAgentConfig;
    }

    public final String component11() {
        return this.params;
    }

    public final Bundle component12() {
        return this.extra;
    }

    public final String component13() {
        return this.clientPackageName;
    }

    public final int component14() {
        return this.version;
    }

    public final String component2() {
        return this.toolCallId;
    }

    public final String component3() {
        return this.parentTaskId;
    }

    public final int component4() {
        return this.taskType;
    }

    public final int component5() {
        return this.priority;
    }

    public final String component6() {
        return this.condition;
    }

    public final Long component7() {
        return this.abilityId;
    }

    public final String component8() {
        return this.toolName;
    }

    public final TaskUiInfo component9() {
        return this.taskUiInfo;
    }

    public final TaskConfig copy(String taskId, String toolCallId, String str, int i10, int i11, String str2, Long l10, String str3, TaskUiInfo taskUiInfo, GuiAgentConfig guiAgentConfig, String str4, Bundle bundle, String str5, int i12) {
        g.f(taskId, "taskId");
        g.f(toolCallId, "toolCallId");
        return new TaskConfig(taskId, toolCallId, str, i10, i11, str2, l10, str3, taskUiInfo, guiAgentConfig, str4, bundle, str5, i12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskConfig)) {
            return false;
        }
        TaskConfig taskConfig = (TaskConfig) obj;
        return g.b(this.taskId, taskConfig.taskId) && g.b(this.toolCallId, taskConfig.toolCallId) && g.b(this.parentTaskId, taskConfig.parentTaskId) && this.taskType == taskConfig.taskType && this.priority == taskConfig.priority && g.b(this.condition, taskConfig.condition) && g.b(this.abilityId, taskConfig.abilityId) && g.b(this.toolName, taskConfig.toolName) && g.b(this.taskUiInfo, taskConfig.taskUiInfo) && g.b(this.guiAgentConfig, taskConfig.guiAgentConfig) && g.b(this.params, taskConfig.params) && g.b(this.extra, taskConfig.extra) && g.b(this.clientPackageName, taskConfig.clientPackageName) && this.version == taskConfig.version;
    }

    public final Long getAbilityId() {
        return this.abilityId;
    }

    public final String getClientPackageName() {
        return this.clientPackageName;
    }

    public final String getCondition() {
        return this.condition;
    }

    public final Bundle getExtra() {
        return this.extra;
    }

    public final GuiAgentConfig getGuiAgentConfig() {
        return this.guiAgentConfig;
    }

    public final String getParams() {
        return this.params;
    }

    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final TaskUiInfo getTaskUiInfo() {
        return this.taskUiInfo;
    }

    public final String getToolCallId() {
        return this.toolCallId;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iA = d.a(this.taskId.hashCode() * 31, 31, this.toolCallId);
        String str = this.parentTaskId;
        int iD = ai.onnxruntime.a.d(this.priority, ai.onnxruntime.a.d(this.taskType, (iA + (str == null ? 0 : str.hashCode())) * 31, 31), 31);
        String str2 = this.condition;
        int iHashCode = (iD + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l10 = this.abilityId;
        int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str3 = this.toolName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        TaskUiInfo taskUiInfo = this.taskUiInfo;
        int iHashCode4 = (iHashCode3 + (taskUiInfo == null ? 0 : taskUiInfo.hashCode())) * 31;
        GuiAgentConfig guiAgentConfig = this.guiAgentConfig;
        int iHashCode5 = (iHashCode4 + (guiAgentConfig == null ? 0 : guiAgentConfig.hashCode())) * 31;
        String str4 = this.params;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Bundle bundle = this.extra;
        int iHashCode7 = (iHashCode6 + (bundle == null ? 0 : bundle.hashCode())) * 31;
        String str5 = this.clientPackageName;
        return Integer.hashCode(this.version) + ((iHashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31);
    }

    public String toString() {
        String str = this.taskId;
        String str2 = this.toolCallId;
        String str3 = this.parentTaskId;
        int i10 = this.taskType;
        int i11 = this.priority;
        String str4 = this.condition;
        Long l10 = this.abilityId;
        String str5 = this.toolName;
        TaskUiInfo taskUiInfo = this.taskUiInfo;
        GuiAgentConfig guiAgentConfig = this.guiAgentConfig;
        String str6 = this.params;
        Bundle bundle = this.extra;
        String str7 = this.clientPackageName;
        int i12 = this.version;
        StringBuilder sbS = ai.onnxruntime.a.s("TaskConfig(taskId=", str, ", toolCallId=", str2, ", parentTaskId=");
        com.stepos.core.ota.d.o(i10, str3, ", taskType=", ", priority=", sbS);
        e.h(i11, ", condition=", str4, ", abilityId=", sbS);
        sbS.append(l10);
        sbS.append(", toolName=");
        sbS.append(str5);
        sbS.append(", taskUiInfo=");
        sbS.append(taskUiInfo);
        sbS.append(", guiAgentConfig=");
        sbS.append(guiAgentConfig);
        sbS.append(", params=");
        sbS.append(str6);
        sbS.append(", extra=");
        sbS.append(bundle);
        sbS.append(", clientPackageName=");
        sbS.append(str7);
        sbS.append(", version=");
        sbS.append(i12);
        sbS.append(")");
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeString(this.taskId);
        dest.writeString(this.toolCallId);
        dest.writeString(this.parentTaskId);
        dest.writeInt(this.taskType);
        dest.writeInt(this.priority);
        dest.writeString(this.condition);
        Long l10 = this.abilityId;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        dest.writeString(this.toolName);
        TaskUiInfo taskUiInfo = this.taskUiInfo;
        if (taskUiInfo == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            taskUiInfo.writeToParcel(dest, i10);
        }
        GuiAgentConfig guiAgentConfig = this.guiAgentConfig;
        if (guiAgentConfig == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            guiAgentConfig.writeToParcel(dest, i10);
        }
        dest.writeString(this.params);
        dest.writeBundle(this.extra);
        dest.writeString(this.clientPackageName);
        dest.writeInt(this.version);
    }

    public /* synthetic */ TaskConfig(String str, String str2, String str3, int i10, int i11, String str4, Long l10, String str5, TaskUiInfo taskUiInfo, GuiAgentConfig guiAgentConfig, String str6, Bundle bundle, String str7, int i12, int i13, kotlin.jvm.internal.e eVar) {
        this(str, str2, (i13 & 4) != 0 ? null : str3, i10, (i13 & 16) != 0 ? 2 : i11, (i13 & 32) != 0 ? null : str4, (i13 & 64) != 0 ? null : l10, (i13 & TraceIdKeys.MAX_LENGTH) != 0 ? null : str5, (i13 & 256) != 0 ? null : taskUiInfo, (i13 & VadSessionManager.FRAME_BYTES) != 0 ? null : guiAgentConfig, (i13 & 1024) != 0 ? null : str6, (i13 & 2048) != 0 ? null : bundle, (i13 & 4096) != 0 ? null : str7, (i13 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? 0 : i12);
    }
}
