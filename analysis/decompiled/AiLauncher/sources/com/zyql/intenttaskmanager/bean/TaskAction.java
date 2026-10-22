package com.zyql.intenttaskmanager.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J2\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0014J\u0010\u0010\u001a\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001a\u0010\fJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0014R%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010\u0016¨\u0006$"}, d2 = {"Lcom/zyql/intenttaskmanager/bean/TaskAction;", "Landroid/os/Parcelable;", "", "taskId", "", "Lcom/zyql/intenttaskmanager/bean/Action;", "Lcom/zyql/intenttaskmanager/bean/ActionConfig;", "actions", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/Map;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/util/Map;)Lcom/zyql/intenttaskmanager/bean/TaskAction;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "Ljava/util/Map;", "getActions", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TaskAction implements Parcelable {
    public static final Parcelable.Creator<TaskAction> CREATOR = new a();
    private final Map<Action, ActionConfig> actions;
    private final String taskId;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<TaskAction> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TaskAction createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            String string = parcel.readString();
            int i10 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i10);
            for (int i11 = 0; i11 != i10; i11++) {
                linkedHashMap.put(Action.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : ActionConfig.CREATOR.createFromParcel(parcel));
            }
            return new TaskAction(string, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final TaskAction[] newArray(int i10) {
            return new TaskAction[i10];
        }
    }

    public TaskAction(String taskId, Map<Action, ActionConfig> actions) {
        p.i(taskId, "taskId");
        p.i(actions, "actions");
        this.taskId = taskId;
        this.actions = actions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskAction copy$default(TaskAction taskAction, String str, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = taskAction.taskId;
        }
        if ((i10 & 2) != 0) {
            map = taskAction.actions;
        }
        return taskAction.copy(str, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public final Map<Action, ActionConfig> component2() {
        return this.actions;
    }

    public final TaskAction copy(String taskId, Map<Action, ActionConfig> actions) {
        p.i(taskId, "taskId");
        p.i(actions, "actions");
        return new TaskAction(taskId, actions);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskAction)) {
            return false;
        }
        TaskAction taskAction = (TaskAction) other;
        return p.d(this.taskId, taskAction.taskId) && p.d(this.actions, taskAction.actions);
    }

    public final Map<Action, ActionConfig> getActions() {
        return this.actions;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        return (this.taskId.hashCode() * 31) + this.actions.hashCode();
    }

    public String toString() {
        return "TaskAction(taskId=" + this.taskId + ", actions=" + this.actions + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.taskId);
        Map<Action, ActionConfig> map = this.actions;
        dest.writeInt(map.size());
        for (Map.Entry<Action, ActionConfig> entry : map.entrySet()) {
            dest.writeString(entry.getKey().name());
            ActionConfig value = entry.getValue();
            if (value == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                value.writeToParcel(dest, flags);
            }
        }
    }
}
