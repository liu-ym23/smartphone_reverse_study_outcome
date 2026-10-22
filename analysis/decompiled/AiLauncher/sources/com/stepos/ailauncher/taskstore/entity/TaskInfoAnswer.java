package com.stepos.ailauncher.taskstore.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001cJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u001cJ\u0012\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\u001cJ\u0010\u0010'\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b'\u0010(Jr\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b+\u0010\u001cJ\u0010\u0010,\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b,\u0010\u0014J\u001a\u0010/\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010-HÖ\u0003¢\u0006\u0004\b/\u00100R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u0010\u001cR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00101\u001a\u0004\b3\u0010\u001cR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b4\u0010\u001cR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00105\u001a\u0004\b6\u0010 R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00107\u001a\u0004\b8\u0010\"R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00109\u001a\u0004\b:\u0010$R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u00101\u001a\u0004\b;\u0010\u001cR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u00101\u001a\u0004\b<\u0010\u001cR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010=\u001a\u0004\b>\u0010(¨\u0006?"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswer;", "Landroid/os/Parcelable;", "", "actionId", "taskId", "answersJson", "", "cancel", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswerPhase;", "phase", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActor;", "actor", "reason", "error", "", "ts", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswerPhase;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActor;Ljava/lang/String;Ljava/lang/String;J)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Ljava/lang/Boolean;", "component5", "()Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswerPhase;", "component6", "()Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActor;", "component7", "component8", "component9", "()J", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswerPhase;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActor;Ljava/lang/String;Ljava/lang/String;J)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswer;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getActionId", "getTaskId", "getAnswersJson", "Ljava/lang/Boolean;", "getCancel", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswerPhase;", "getPhase", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActor;", "getActor", "getReason", "getError", "J", "getTs", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskInfoAnswer implements Parcelable {
    public static final Parcelable.Creator<TaskInfoAnswer> CREATOR = new Creator();
    private final String actionId;
    private final TaskInfoActor actor;
    private final String answersJson;
    private final Boolean cancel;
    private final String error;
    private final TaskInfoAnswerPhase phase;
    private final String reason;
    private final String taskId;
    private final long ts;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TaskInfoAnswer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfoAnswer createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            p.i(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new TaskInfoAnswer(string, string2, string3, boolValueOf, TaskInfoAnswerPhase.valueOf(parcel.readString()), TaskInfoActor.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfoAnswer[] newArray(int i10) {
            return new TaskInfoAnswer[i10];
        }
    }

    public TaskInfoAnswer(String actionId, String taskId, String str, Boolean bool, TaskInfoAnswerPhase phase, TaskInfoActor actor, String str2, String str3, long j10) {
        p.i(actionId, "actionId");
        p.i(taskId, "taskId");
        p.i(phase, "phase");
        p.i(actor, "actor");
        this.actionId = actionId;
        this.taskId = taskId;
        this.answersJson = str;
        this.cancel = bool;
        this.phase = phase;
        this.actor = actor;
        this.reason = str2;
        this.error = str3;
        this.ts = j10;
    }

    public static /* synthetic */ TaskInfoAnswer copy$default(TaskInfoAnswer taskInfoAnswer, String str, String str2, String str3, Boolean bool, TaskInfoAnswerPhase taskInfoAnswerPhase, TaskInfoActor taskInfoActor, String str4, String str5, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = taskInfoAnswer.actionId;
        }
        if ((i10 & 2) != 0) {
            str2 = taskInfoAnswer.taskId;
        }
        if ((i10 & 4) != 0) {
            str3 = taskInfoAnswer.answersJson;
        }
        if ((i10 & 8) != 0) {
            bool = taskInfoAnswer.cancel;
        }
        if ((i10 & 16) != 0) {
            taskInfoAnswerPhase = taskInfoAnswer.phase;
        }
        if ((i10 & 32) != 0) {
            taskInfoActor = taskInfoAnswer.actor;
        }
        if ((i10 & 64) != 0) {
            str4 = taskInfoAnswer.reason;
        }
        if ((i10 & 128) != 0) {
            str5 = taskInfoAnswer.error;
        }
        if ((i10 & 256) != 0) {
            j10 = taskInfoAnswer.ts;
        }
        long j11 = j10;
        String str6 = str4;
        String str7 = str5;
        TaskInfoAnswerPhase taskInfoAnswerPhase2 = taskInfoAnswerPhase;
        TaskInfoActor taskInfoActor2 = taskInfoActor;
        return taskInfoAnswer.copy(str, str2, str3, bool, taskInfoAnswerPhase2, taskInfoActor2, str6, str7, j11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getActionId() {
        return this.actionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAnswersJson() {
        return this.answersJson;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getCancel() {
        return this.cancel;
    }

    /* renamed from: component5, reason: from getter */
    public final TaskInfoAnswerPhase getPhase() {
        return this.phase;
    }

    /* renamed from: component6, reason: from getter */
    public final TaskInfoActor getActor() {
        return this.actor;
    }

    /* renamed from: component7, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component8, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component9, reason: from getter */
    public final long getTs() {
        return this.ts;
    }

    public final TaskInfoAnswer copy(String actionId, String taskId, String answersJson, Boolean cancel, TaskInfoAnswerPhase phase, TaskInfoActor actor, String reason, String error, long ts) {
        p.i(actionId, "actionId");
        p.i(taskId, "taskId");
        p.i(phase, "phase");
        p.i(actor, "actor");
        return new TaskInfoAnswer(actionId, taskId, answersJson, cancel, phase, actor, reason, error, ts);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskInfoAnswer)) {
            return false;
        }
        TaskInfoAnswer taskInfoAnswer = (TaskInfoAnswer) other;
        return p.d(this.actionId, taskInfoAnswer.actionId) && p.d(this.taskId, taskInfoAnswer.taskId) && p.d(this.answersJson, taskInfoAnswer.answersJson) && p.d(this.cancel, taskInfoAnswer.cancel) && this.phase == taskInfoAnswer.phase && p.d(this.actor, taskInfoAnswer.actor) && p.d(this.reason, taskInfoAnswer.reason) && p.d(this.error, taskInfoAnswer.error) && this.ts == taskInfoAnswer.ts;
    }

    public final String getActionId() {
        return this.actionId;
    }

    public final TaskInfoActor getActor() {
        return this.actor;
    }

    public final String getAnswersJson() {
        return this.answersJson;
    }

    public final Boolean getCancel() {
        return this.cancel;
    }

    public final String getError() {
        return this.error;
    }

    public final TaskInfoAnswerPhase getPhase() {
        return this.phase;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final long getTs() {
        return this.ts;
    }

    public int hashCode() {
        int iHashCode = ((this.actionId.hashCode() * 31) + this.taskId.hashCode()) * 31;
        String str = this.answersJson;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.cancel;
        int iHashCode3 = (((((iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31) + this.phase.hashCode()) * 31) + this.actor.hashCode()) * 31;
        String str2 = this.reason;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.error;
        return ((iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31) + Long.hashCode(this.ts);
    }

    public String toString() {
        return "TaskInfoAnswer(actionId=" + this.actionId + ", taskId=" + this.taskId + ", answersJson=" + this.answersJson + ", cancel=" + this.cancel + ", phase=" + this.phase + ", actor=" + this.actor + ", reason=" + this.reason + ", error=" + this.error + ", ts=" + this.ts + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        int iBooleanValue;
        p.i(dest, "dest");
        dest.writeString(this.actionId);
        dest.writeString(this.taskId);
        dest.writeString(this.answersJson);
        Boolean bool = this.cancel;
        if (bool == null) {
            iBooleanValue = 0;
        } else {
            dest.writeInt(1);
            iBooleanValue = bool.booleanValue();
        }
        dest.writeInt(iBooleanValue);
        dest.writeString(this.phase.name());
        this.actor.writeToParcel(dest, flags);
        dest.writeString(this.reason);
        dest.writeString(this.error);
        dest.writeLong(this.ts);
    }

    public /* synthetic */ TaskInfoAnswer(String str, String str2, String str3, Boolean bool, TaskInfoAnswerPhase taskInfoAnswerPhase, TaskInfoActor taskInfoActor, String str4, String str5, long j10, int i10, i iVar) {
        this(str, str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : bool, taskInfoAnswerPhase, taskInfoActor, (i10 & 64) != 0 ? null : str4, (i10 & 128) != 0 ? null : str5, j10);
    }
}
