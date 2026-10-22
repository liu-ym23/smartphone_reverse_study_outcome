package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0019J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJH\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b!\u0010\u0019J\u0010\u0010\"\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\"\u0010\u000fJ\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b-\u0010\u001bR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\b.\u0010\u0019R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010/\u001a\u0004\b0\u0010\u001e¨\u00061"}, d2 = {"Lcom/stepos/ability/bean/InternalTask;", "Landroid/os/Parcelable;", "Lcom/stepos/ability/bean/Task;", "task", "", "toolCallId", "", "abilityId", "toolName", "Lcom/stepos/ability/bean/GuiAgentConfig;", "guiAgentConfig", "<init>", "(Lcom/stepos/ability/bean/Task;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/stepos/ability/bean/GuiAgentConfig;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Lcom/stepos/ability/bean/Task;", "component2", "()Ljava/lang/String;", "component3", "()Ljava/lang/Long;", "component4", "component5", "()Lcom/stepos/ability/bean/GuiAgentConfig;", ChatTracker.CLICK_COPY, "(Lcom/stepos/ability/bean/Task;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/stepos/ability/bean/GuiAgentConfig;)Lcom/stepos/ability/bean/InternalTask;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ability/bean/Task;", "getTask", "Ljava/lang/String;", "getToolCallId", "Ljava/lang/Long;", "getAbilityId", "getToolName", "Lcom/stepos/ability/bean/GuiAgentConfig;", "getGuiAgentConfig", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class InternalTask implements Parcelable {
    public static final Parcelable.Creator<InternalTask> CREATOR = new a();
    private final Long abilityId;
    private final GuiAgentConfig guiAgentConfig;
    private final Task task;
    private final String toolCallId;
    private final String toolName;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<InternalTask> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InternalTask createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new InternalTask(Task.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readInt() != 0 ? GuiAgentConfig.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final InternalTask[] newArray(int i10) {
            return new InternalTask[i10];
        }
    }

    public InternalTask(Task task, String toolCallId, Long l10, String str, GuiAgentConfig guiAgentConfig) {
        p.i(task, "task");
        p.i(toolCallId, "toolCallId");
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

    /* renamed from: component1, reason: from getter */
    public final Task getTask() {
        return this.task;
    }

    /* renamed from: component2, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getAbilityId() {
        return this.abilityId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component5, reason: from getter */
    public final GuiAgentConfig getGuiAgentConfig() {
        return this.guiAgentConfig;
    }

    public final InternalTask copy(Task task, String toolCallId, Long abilityId, String toolName, GuiAgentConfig guiAgentConfig) {
        p.i(task, "task");
        p.i(toolCallId, "toolCallId");
        return new InternalTask(task, toolCallId, abilityId, toolName, guiAgentConfig);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InternalTask)) {
            return false;
        }
        InternalTask internalTask = (InternalTask) other;
        return p.d(this.task, internalTask.task) && p.d(this.toolCallId, internalTask.toolCallId) && p.d(this.abilityId, internalTask.abilityId) && p.d(this.toolName, internalTask.toolName) && p.d(this.guiAgentConfig, internalTask.guiAgentConfig);
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
        int iHashCode = ((this.task.hashCode() * 31) + this.toolCallId.hashCode()) * 31;
        Long l10 = this.abilityId;
        int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str = this.toolName;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        GuiAgentConfig guiAgentConfig = this.guiAgentConfig;
        return iHashCode3 + (guiAgentConfig != null ? guiAgentConfig.hashCode() : 0);
    }

    public String toString() {
        return "InternalTask(task=" + this.task + ", toolCallId=" + this.toolCallId + ", abilityId=" + this.abilityId + ", toolName=" + this.toolName + ", guiAgentConfig=" + this.guiAgentConfig + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        this.task.writeToParcel(dest, flags);
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
            guiAgentConfig.writeToParcel(dest, flags);
        }
    }

    public /* synthetic */ InternalTask(Task task, String str, Long l10, String str2, GuiAgentConfig guiAgentConfig, int i10, i iVar) {
        this(task, str, (i10 & 4) != 0 ? null : l10, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? null : guiAgentConfig);
    }
}
