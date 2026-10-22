package com.zyql.intenttaskmanager.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.zyql.intenttaskmanager.bean.guiagent.GuiAgentConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u0001B±\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b%\u0010$J\u0012\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010$J\u0010\u0010'\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b'\u0010\u001cJ\u0010\u0010(\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b(\u0010\u001cJ\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010$J\u0012\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b*\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010$J\u0012\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b-\u0010.J\u0012\u0010/\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b/\u00100J\u0012\u00101\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b1\u0010$J\u0012\u00102\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b2\u00103J\u0012\u00104\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b4\u0010$J\u0018\u00105\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b7\u0010\u001cJÀ\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b:\u0010$J\u0010\u0010;\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b;\u0010\u001cJ\u001a\u0010?\u001a\u00020>2\b\u0010=\u001a\u0004\u0018\u00010<HÖ\u0003¢\u0006\u0004\b?\u0010@R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010A\u001a\u0004\bB\u0010$R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010A\u001a\u0004\bC\u0010$R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010A\u001a\u0004\bD\u0010$R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010E\u001a\u0004\bF\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010E\u001a\u0004\bG\u0010\u001cR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010A\u001a\u0004\bH\u0010$R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010I\u001a\u0004\bJ\u0010+R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010A\u001a\u0004\bK\u0010$R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010L\u001a\u0004\bM\u0010.R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010N\u001a\u0004\bO\u00100R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010A\u001a\u0004\bP\u0010$R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010Q\u001a\u0004\bR\u00103R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010A\u001a\u0004\bS\u0010$R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010T\u001a\u0004\bU\u00106\"\u0004\bV\u0010WR\u0017\u0010\u0018\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010E\u001a\u0004\bX\u0010\u001c¨\u0006Y"}, d2 = {"Lcom/zyql/intenttaskmanager/bean/TaskConfig;", "Landroid/os/Parcelable;", "", "taskId", "toolCallId", "parentTaskId", "", "taskType", "priority", "condition", "", "abilityId", "toolName", "Lcom/zyql/intenttaskmanager/bean/TaskUiInfo;", "taskUiInfo", "Lcom/zyql/intenttaskmanager/bean/guiagent/GuiAgentConfig;", "guiAgentConfig", "params", "Landroid/os/Bundle;", "extra", "clientPackageName", "", "Lcom/zyql/intenttaskmanager/bean/TaskAction;", "actions", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/zyql/intenttaskmanager/bean/TaskUiInfo;Lcom/zyql/intenttaskmanager/bean/guiagent/GuiAgentConfig;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Ljava/util/List;I)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "()Ljava/lang/Long;", "component8", "component9", "()Lcom/zyql/intenttaskmanager/bean/TaskUiInfo;", "component10", "()Lcom/zyql/intenttaskmanager/bean/guiagent/GuiAgentConfig;", "component11", "component12", "()Landroid/os/Bundle;", "component13", "component14", "()Ljava/util/List;", "component15", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/zyql/intenttaskmanager/bean/TaskUiInfo;Lcom/zyql/intenttaskmanager/bean/guiagent/GuiAgentConfig;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Ljava/util/List;I)Lcom/zyql/intenttaskmanager/bean/TaskConfig;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "getToolCallId", "getParentTaskId", "I", "getTaskType", "getPriority", "getCondition", "Ljava/lang/Long;", "getAbilityId", "getToolName", "Lcom/zyql/intenttaskmanager/bean/TaskUiInfo;", "getTaskUiInfo", "Lcom/zyql/intenttaskmanager/bean/guiagent/GuiAgentConfig;", "getGuiAgentConfig", "getParams", "Landroid/os/Bundle;", "getExtra", "getClientPackageName", "Ljava/util/List;", "getActions", "setActions", "(Ljava/util/List;)V", "getVersion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TaskConfig implements Parcelable {
    public static final Parcelable.Creator<TaskConfig> CREATOR = new a();
    private final Long abilityId;
    private List<TaskAction> actions;
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

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<TaskConfig> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TaskConfig createFromParcel(Parcel parcel) {
            String str;
            p.i(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            String string4 = parcel.readString();
            ArrayList arrayList = null;
            Long lValueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String string5 = parcel.readString();
            TaskUiInfo taskUiInfoCreateFromParcel = parcel.readInt() == 0 ? null : TaskUiInfo.CREATOR.createFromParcel(parcel);
            GuiAgentConfig guiAgentConfigCreateFromParcel = parcel.readInt() == 0 ? null : GuiAgentConfig.CREATOR.createFromParcel(parcel);
            String string6 = parcel.readString();
            Bundle bundle = parcel.readBundle(TaskConfig.class.getClassLoader());
            String string7 = parcel.readString();
            if (parcel.readInt() == 0) {
                str = string;
            } else {
                int i12 = parcel.readInt();
                arrayList = new ArrayList(i12);
                str = string;
                int i13 = 0;
                while (i13 != i12) {
                    arrayList.add(TaskAction.CREATOR.createFromParcel(parcel));
                    i13++;
                    i12 = i12;
                }
            }
            return new TaskConfig(str, string2, string3, i10, i11, string4, lValueOf, string5, taskUiInfoCreateFromParcel, guiAgentConfigCreateFromParcel, string6, bundle, string7, arrayList, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final TaskConfig[] newArray(int i10) {
            return new TaskConfig[i10];
        }
    }

    public TaskConfig(String taskId, String toolCallId, String str, int i10, int i11, String str2, Long l10, String str3, TaskUiInfo taskUiInfo, GuiAgentConfig guiAgentConfig, String str4, Bundle bundle, String str5, List<TaskAction> list, int i12) {
        p.i(taskId, "taskId");
        p.i(toolCallId, "toolCallId");
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
        this.actions = list;
        this.version = i12;
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component10, reason: from getter */
    public final GuiAgentConfig getGuiAgentConfig() {
        return this.guiAgentConfig;
    }

    /* renamed from: component11, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    /* renamed from: component12, reason: from getter */
    public final Bundle getExtra() {
        return this.extra;
    }

    /* renamed from: component13, reason: from getter */
    public final String getClientPackageName() {
        return this.clientPackageName;
    }

    public final List<TaskAction> component14() {
        return this.actions;
    }

    /* renamed from: component15, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: component2, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTaskType() {
        return this.taskType;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCondition() {
        return this.condition;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getAbilityId() {
        return this.abilityId;
    }

    /* renamed from: component8, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component9, reason: from getter */
    public final TaskUiInfo getTaskUiInfo() {
        return this.taskUiInfo;
    }

    public final TaskConfig copy(String taskId, String toolCallId, String parentTaskId, int taskType, int priority, String condition, Long abilityId, String toolName, TaskUiInfo taskUiInfo, GuiAgentConfig guiAgentConfig, String params, Bundle extra, String clientPackageName, List<TaskAction> actions, int version) {
        p.i(taskId, "taskId");
        p.i(toolCallId, "toolCallId");
        return new TaskConfig(taskId, toolCallId, parentTaskId, taskType, priority, condition, abilityId, toolName, taskUiInfo, guiAgentConfig, params, extra, clientPackageName, actions, version);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskConfig)) {
            return false;
        }
        TaskConfig taskConfig = (TaskConfig) other;
        return p.d(this.taskId, taskConfig.taskId) && p.d(this.toolCallId, taskConfig.toolCallId) && p.d(this.parentTaskId, taskConfig.parentTaskId) && this.taskType == taskConfig.taskType && this.priority == taskConfig.priority && p.d(this.condition, taskConfig.condition) && p.d(this.abilityId, taskConfig.abilityId) && p.d(this.toolName, taskConfig.toolName) && p.d(this.taskUiInfo, taskConfig.taskUiInfo) && p.d(this.guiAgentConfig, taskConfig.guiAgentConfig) && p.d(this.params, taskConfig.params) && p.d(this.extra, taskConfig.extra) && p.d(this.clientPackageName, taskConfig.clientPackageName) && p.d(this.actions, taskConfig.actions) && this.version == taskConfig.version;
    }

    public final Long getAbilityId() {
        return this.abilityId;
    }

    public final List<TaskAction> getActions() {
        return this.actions;
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
        int iHashCode = ((this.taskId.hashCode() * 31) + this.toolCallId.hashCode()) * 31;
        String str = this.parentTaskId;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.taskType)) * 31) + Integer.hashCode(this.priority)) * 31;
        String str2 = this.condition;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l10 = this.abilityId;
        int iHashCode4 = (iHashCode3 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str3 = this.toolName;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        TaskUiInfo taskUiInfo = this.taskUiInfo;
        int iHashCode6 = (iHashCode5 + (taskUiInfo == null ? 0 : taskUiInfo.hashCode())) * 31;
        GuiAgentConfig guiAgentConfig = this.guiAgentConfig;
        int iHashCode7 = (iHashCode6 + (guiAgentConfig == null ? 0 : guiAgentConfig.hashCode())) * 31;
        String str4 = this.params;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Bundle bundle = this.extra;
        int iHashCode9 = (iHashCode8 + (bundle == null ? 0 : bundle.hashCode())) * 31;
        String str5 = this.clientPackageName;
        int iHashCode10 = (iHashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<TaskAction> list = this.actions;
        return ((iHashCode10 + (list != null ? list.hashCode() : 0)) * 31) + Integer.hashCode(this.version);
    }

    public final void setActions(List<TaskAction> list) {
        this.actions = list;
    }

    public String toString() {
        return "TaskConfig(taskId=" + this.taskId + ", toolCallId=" + this.toolCallId + ", parentTaskId=" + this.parentTaskId + ", taskType=" + this.taskType + ", priority=" + this.priority + ", condition=" + this.condition + ", abilityId=" + this.abilityId + ", toolName=" + this.toolName + ", taskUiInfo=" + this.taskUiInfo + ", guiAgentConfig=" + this.guiAgentConfig + ", params=" + this.params + ", extra=" + this.extra + ", clientPackageName=" + this.clientPackageName + ", actions=" + this.actions + ", version=" + this.version + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
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
            taskUiInfo.writeToParcel(dest, flags);
        }
        GuiAgentConfig guiAgentConfig = this.guiAgentConfig;
        if (guiAgentConfig == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            guiAgentConfig.writeToParcel(dest, flags);
        }
        dest.writeString(this.params);
        dest.writeBundle(this.extra);
        dest.writeString(this.clientPackageName);
        List<TaskAction> list = this.actions;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<TaskAction> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        dest.writeInt(this.version);
    }

    public /* synthetic */ TaskConfig(String str, String str2, String str3, int i10, int i11, String str4, Long l10, String str5, TaskUiInfo taskUiInfo, GuiAgentConfig guiAgentConfig, String str6, Bundle bundle, String str7, List list, int i12, int i13, i iVar) {
        this(str, str2, (i13 & 4) != 0 ? null : str3, i10, (i13 & 16) != 0 ? 2 : i11, (i13 & 32) != 0 ? null : str4, (i13 & 64) != 0 ? null : l10, (i13 & 128) != 0 ? null : str5, (i13 & 256) != 0 ? null : taskUiInfo, (i13 & 512) != 0 ? null : guiAgentConfig, (i13 & 1024) != 0 ? null : str6, (i13 & 2048) != 0 ? null : bundle, (i13 & 4096) != 0 ? null : str7, (i13 & b.THRESHOLD) != 0 ? null : list, (i13 & 16384) != 0 ? 0 : i12);
    }
}
