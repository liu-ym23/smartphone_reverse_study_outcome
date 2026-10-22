package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InternalTask implements Parcelable {
    public static final Parcelable.Creator<InternalTask> CREATOR = new a();
    private final Long abilityId;
    private final GuiAgentConfig guiAgentConfig;
    private final Task task;
    private final String toolCallId;
    private final String toolName;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<InternalTask> {
        @Override // android.os.Parcelable.Creator
        public final InternalTask createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new InternalTask(Task.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readInt() != 0 ? GuiAgentConfig.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final InternalTask[] newArray(int i10) {
            return new InternalTask[i10];
        }
    }

    public InternalTask(Task task, String toolCallId, Long l10, String str, GuiAgentConfig guiAgentConfig) {
        g.f(task, "task");
        g.f(toolCallId, "toolCallId");
        this.task = task;
        this.toolCallId = toolCallId;
        this.abilityId = l10;
        this.toolName = str;
        this.guiAgentConfig = guiAgentConfig;
    }

    public static /* synthetic */ InternalTask copy$default(InternalTask internalTask, Task task, String str, Long l10, String str2, GuiAgentConfig guiAgentConfig, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            task = internalTask.task;
        }
        if ((i10 & 2) != 0) {
            str = internalTask.toolCallId;
        }
        if ((i10 & 4) != 0) {
            l10 = internalTask.abilityId;
        }
        if ((i10 & 8) != 0) {
            str2 = internalTask.toolName;
        }
        if ((i10 & 16) != 0) {
            guiAgentConfig = internalTask.guiAgentConfig;
        }
        GuiAgentConfig guiAgentConfig2 = guiAgentConfig;
        Long l11 = l10;
        return internalTask.copy(task, str, l11, str2, guiAgentConfig2);
    }

    public final Task component1() {
        return this.task;
    }

    public final String component2() {
        return this.toolCallId;
    }

    public final Long component3() {
        return this.abilityId;
    }

    public final String component4() {
        return this.toolName;
    }

    public final GuiAgentConfig component5() {
        return this.guiAgentConfig;
    }

    public final InternalTask copy(Task task, String toolCallId, Long l10, String str, GuiAgentConfig guiAgentConfig) {
        g.f(task, "task");
        g.f(toolCallId, "toolCallId");
        return new InternalTask(task, toolCallId, l10, str, guiAgentConfig);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InternalTask)) {
            return false;
        }
        InternalTask internalTask = (InternalTask) obj;
        return g.b(this.task, internalTask.task) && g.b(this.toolCallId, internalTask.toolCallId) && g.b(this.abilityId, internalTask.abilityId) && g.b(this.toolName, internalTask.toolName) && g.b(this.guiAgentConfig, internalTask.guiAgentConfig);
    }

    public final Long getAbilityId() {
        return this.abilityId;
    }

    public final GuiAgentConfig getGuiAgentConfig() {
        return this.guiAgentConfig;
    }

    public final Task getTask() {
        return this.task;
    }

    public final String getToolCallId() {
        return this.toolCallId;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public int hashCode() {
        int iA = d.a(this.task.hashCode() * 31, 31, this.toolCallId);
        Long l10 = this.abilityId;
        int iHashCode = (iA + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str = this.toolName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        GuiAgentConfig guiAgentConfig = this.guiAgentConfig;
        return iHashCode2 + (guiAgentConfig != null ? guiAgentConfig.hashCode() : 0);
    }

    public String toString() {
        return "InternalTask(task=" + this.task + ", toolCallId=" + this.toolCallId + ", abilityId=" + this.abilityId + ", toolName=" + this.toolName + ", guiAgentConfig=" + this.guiAgentConfig + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        this.task.writeToParcel(dest, i10);
        dest.writeString(this.toolCallId);
        Long l10 = this.abilityId;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        dest.writeString(this.toolName);
        GuiAgentConfig guiAgentConfig = this.guiAgentConfig;
        if (guiAgentConfig == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            guiAgentConfig.writeToParcel(dest, i10);
        }
    }

    public /* synthetic */ InternalTask(Task task, String str, Long l10, String str2, GuiAgentConfig guiAgentConfig, int i10, e eVar) {
        this(task, str, (i10 & 4) != 0 ? null : l10, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? null : guiAgentConfig);
    }
}
