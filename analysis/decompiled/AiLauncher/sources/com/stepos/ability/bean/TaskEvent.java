package com.stepos.ability.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ability.bean.TaskEvent;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001f2\u00020\u0001:\f\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u000b !\"#$%&'()*¨\u0006+"}, d2 = {"Lcom/stepos/ability/bean/TaskEvent;", "Landroid/os/Parcelable;", "<init>", "()V", "typeCode", "", "getTypeCode", "()I", "task", "Lcom/stepos/ability/bean/Task;", "getTask", "()Lcom/stepos/ability/bean/Task;", "taskId", "", "getTaskId", "()Ljava/lang/String;", "bundle", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "TaskCreate", "TaskPending", "TaskStart", "TaskResume", "TaskPause", "TaskComplete", "TaskCancel", "TaskFail", "TaskProgress", "TaskRemoved", "TaskTakeOver", "Companion", "Lcom/stepos/ability/bean/TaskEvent$TaskCancel;", "Lcom/stepos/ability/bean/TaskEvent$TaskComplete;", "Lcom/stepos/ability/bean/TaskEvent$TaskCreate;", "Lcom/stepos/ability/bean/TaskEvent$TaskFail;", "Lcom/stepos/ability/bean/TaskEvent$TaskPause;", "Lcom/stepos/ability/bean/TaskEvent$TaskPending;", "Lcom/stepos/ability/bean/TaskEvent$TaskProgress;", "Lcom/stepos/ability/bean/TaskEvent$TaskRemoved;", "Lcom/stepos/ability/bean/TaskEvent$TaskResume;", "Lcom/stepos/ability/bean/TaskEvent$TaskStart;", "Lcom/stepos/ability/bean/TaskEvent$TaskTakeOver;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TaskEvent implements Parcelable {
    public static final int TYPE_TASK_CANCEL = 5;
    public static final int TYPE_TASK_COMPLETE = 4;
    public static final int TYPE_TASK_CREATE = 0;
    public static final int TYPE_TASK_FAIL = 6;
    public static final int TYPE_TASK_PAUSE = 3;
    public static final int TYPE_TASK_PENDING = 9;
    public static final int TYPE_TASK_PROGRESS = 2;
    public static final int TYPE_TASK_REMOVED = 7;
    public static final int TYPE_TASK_RESUME = 8;
    public static final int TYPE_TASK_START = 1;
    public static final int TYPE_TASK_TAKEOVER = 10;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<TaskEvent> CREATOR = new Parcelable.Creator<TaskEvent>() { // from class: com.stepos.ability.bean.TaskEvent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TaskEvent createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            int i10 = parcel.readInt();
            switch (i10) {
                case 0:
                    TaskEvent.TaskCreate taskCreateCreateFromParcel = TaskEvent.TaskCreate.CREATOR.createFromParcel(parcel);
                    p.h(taskCreateCreateFromParcel, "createFromParcel(...)");
                    return taskCreateCreateFromParcel;
                case 1:
                    TaskEvent.TaskStart taskStartCreateFromParcel = TaskEvent.TaskStart.CREATOR.createFromParcel(parcel);
                    p.h(taskStartCreateFromParcel, "createFromParcel(...)");
                    return taskStartCreateFromParcel;
                case 2:
                    TaskEvent.TaskProgress taskProgressCreateFromParcel = TaskEvent.TaskProgress.CREATOR.createFromParcel(parcel);
                    p.h(taskProgressCreateFromParcel, "createFromParcel(...)");
                    return taskProgressCreateFromParcel;
                case 3:
                    TaskEvent.TaskPause taskPauseCreateFromParcel = TaskEvent.TaskPause.CREATOR.createFromParcel(parcel);
                    p.h(taskPauseCreateFromParcel, "createFromParcel(...)");
                    return taskPauseCreateFromParcel;
                case 4:
                    TaskEvent.TaskComplete taskCompleteCreateFromParcel = TaskEvent.TaskComplete.CREATOR.createFromParcel(parcel);
                    p.h(taskCompleteCreateFromParcel, "createFromParcel(...)");
                    return taskCompleteCreateFromParcel;
                case 5:
                    TaskEvent.TaskCancel taskCancelCreateFromParcel = TaskEvent.TaskCancel.CREATOR.createFromParcel(parcel);
                    p.h(taskCancelCreateFromParcel, "createFromParcel(...)");
                    return taskCancelCreateFromParcel;
                case 6:
                    TaskEvent.TaskFail taskFailCreateFromParcel = TaskEvent.TaskFail.CREATOR.createFromParcel(parcel);
                    p.h(taskFailCreateFromParcel, "createFromParcel(...)");
                    return taskFailCreateFromParcel;
                case 7:
                    TaskEvent.TaskRemoved taskRemovedCreateFromParcel = TaskEvent.TaskRemoved.CREATOR.createFromParcel(parcel);
                    p.h(taskRemovedCreateFromParcel, "createFromParcel(...)");
                    return taskRemovedCreateFromParcel;
                case 8:
                    TaskEvent.TaskResume taskResumeCreateFromParcel = TaskEvent.TaskResume.CREATOR.createFromParcel(parcel);
                    p.h(taskResumeCreateFromParcel, "createFromParcel(...)");
                    return taskResumeCreateFromParcel;
                case 9:
                    TaskEvent.TaskPending taskPendingCreateFromParcel = TaskEvent.TaskPending.CREATOR.createFromParcel(parcel);
                    p.h(taskPendingCreateFromParcel, "createFromParcel(...)");
                    return taskPendingCreateFromParcel;
                case 10:
                    TaskEvent.TaskTakeOver taskTakeOverCreateFromParcel = TaskEvent.TaskTakeOver.CREATOR.createFromParcel(parcel);
                    p.h(taskTakeOverCreateFromParcel, "createFromParcel(...)");
                    return taskTakeOverCreateFromParcel;
                default:
                    throw new IllegalArgumentException("Unknown TaskEvent type: " + i10);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TaskEvent[] newArray(int size) {
            return new TaskEvent[size];
        }
    };

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/stepos/ability/bean/TaskEvent$Companion;", "", "<init>", "()V", "minimalTask", "Lcom/stepos/ability/bean/Task;", "taskId", "", "TYPE_TASK_CREATE", "", "TYPE_TASK_START", "TYPE_TASK_PROGRESS", "TYPE_TASK_PAUSE", "TYPE_TASK_COMPLETE", "TYPE_TASK_CANCEL", "TYPE_TASK_FAIL", "TYPE_TASK_REMOVED", "TYPE_TASK_RESUME", "TYPE_TASK_PENDING", "TYPE_TASK_TAKEOVER", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/ability/bean/TaskEvent;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Task minimalTask(String taskId) {
            return new Task(taskId, null, null, null, null, null, 0, 0, 0, 0, null, 0L, 0L, 0L, null, null, null, null, 0, 524158, null);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0014R\u0014\u0010%\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\n¨\u0006'"}, d2 = {"Lcom/stepos/ability/bean/TaskEvent$TaskCancel;", "Lcom/stepos/ability/bean/TaskEvent;", "Lcom/stepos/ability/bean/Task;", "task", "Landroid/os/Bundle;", "bundle", "<init>", "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Lcom/stepos/ability/bean/Task;", "component2", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)Lcom/stepos/ability/bean/TaskEvent$TaskCancel;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ability/bean/Task;", "getTask", "Landroid/os/Bundle;", "getBundle", "getTypeCode", "typeCode", "Companion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskCancel extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Parcelable.Creator<TaskCancel> CREATOR = new Parcelable.Creator<TaskCancel>() { // from class: com.stepos.ability.bean.TaskEvent$TaskCancel$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskCancel createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                Task task = (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class);
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                p.f(task);
                return new TaskEvent.TaskCancel(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskCancel[] newArray(int size) {
                return new TaskEvent.TaskCancel[size];
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskCancel(Task task, Bundle bundle) {
            super(null);
            p.i(task, "task");
            this.task = task;
            this.bundle = bundle;
        }

        public static /* synthetic */ TaskCancel copy$default(TaskCancel taskCancel, Task task, Bundle bundle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                task = taskCancel.task;
            }
            if ((i10 & 2) != 0) {
                bundle = taskCancel.bundle;
            }
            return taskCancel.copy(task, bundle);
        }

        /* renamed from: component1, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: component2, reason: from getter */
        public final Bundle getBundle() {
            return this.bundle;
        }

        public final TaskCancel copy(Task task, Bundle bundle) {
            p.i(task, "task");
            return new TaskCancel(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskCancel)) {
                return false;
            }
            TaskCancel taskCancel = (TaskCancel) other;
            return p.d(this.task, taskCancel.task) && p.d(this.bundle, taskCancel.bundle);
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Bundle getBundle() {
            return this.bundle;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Task getTask() {
            return this.task;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public int getTypeCode() {
            return 5;
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Bundle bundle = this.bundle;
            return iHashCode + (bundle == null ? 0 : bundle.hashCode());
        }

        public String toString() {
            return "TaskCancel(task=" + this.task + ", bundle=" + this.bundle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            p.i(parcel, "parcel");
            parcel.writeInt(5);
            parcel.writeParcelable(getTask(), flags);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskCancel(Task task, Bundle bundle, int i10, i iVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0014R\u0014\u0010%\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\n¨\u0006'"}, d2 = {"Lcom/stepos/ability/bean/TaskEvent$TaskComplete;", "Lcom/stepos/ability/bean/TaskEvent;", "Lcom/stepos/ability/bean/Task;", "task", "Landroid/os/Bundle;", "bundle", "<init>", "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Lcom/stepos/ability/bean/Task;", "component2", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)Lcom/stepos/ability/bean/TaskEvent$TaskComplete;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ability/bean/Task;", "getTask", "Landroid/os/Bundle;", "getBundle", "getTypeCode", "typeCode", "Companion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskComplete extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Parcelable.Creator<TaskComplete> CREATOR = new Parcelable.Creator<TaskComplete>() { // from class: com.stepos.ability.bean.TaskEvent$TaskComplete$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskComplete createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                Task task = (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class);
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                p.f(task);
                return new TaskEvent.TaskComplete(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskComplete[] newArray(int size) {
                return new TaskEvent.TaskComplete[size];
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskComplete(Task task, Bundle bundle) {
            super(null);
            p.i(task, "task");
            this.task = task;
            this.bundle = bundle;
        }

        public static /* synthetic */ TaskComplete copy$default(TaskComplete taskComplete, Task task, Bundle bundle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                task = taskComplete.task;
            }
            if ((i10 & 2) != 0) {
                bundle = taskComplete.bundle;
            }
            return taskComplete.copy(task, bundle);
        }

        /* renamed from: component1, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: component2, reason: from getter */
        public final Bundle getBundle() {
            return this.bundle;
        }

        public final TaskComplete copy(Task task, Bundle bundle) {
            p.i(task, "task");
            return new TaskComplete(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskComplete)) {
                return false;
            }
            TaskComplete taskComplete = (TaskComplete) other;
            return p.d(this.task, taskComplete.task) && p.d(this.bundle, taskComplete.bundle);
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Bundle getBundle() {
            return this.bundle;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Task getTask() {
            return this.task;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public int getTypeCode() {
            return 4;
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Bundle bundle = this.bundle;
            return iHashCode + (bundle == null ? 0 : bundle.hashCode());
        }

        public String toString() {
            return "TaskComplete(task=" + this.task + ", bundle=" + this.bundle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            p.i(parcel, "parcel");
            parcel.writeInt(4);
            parcel.writeParcelable(getTask(), flags);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskComplete(Task task, Bundle bundle, int i10, i iVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0014R\u0014\u0010%\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\n¨\u0006'"}, d2 = {"Lcom/stepos/ability/bean/TaskEvent$TaskCreate;", "Lcom/stepos/ability/bean/TaskEvent;", "Lcom/stepos/ability/bean/Task;", "task", "Landroid/os/Bundle;", "bundle", "<init>", "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Lcom/stepos/ability/bean/Task;", "component2", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)Lcom/stepos/ability/bean/TaskEvent$TaskCreate;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ability/bean/Task;", "getTask", "Landroid/os/Bundle;", "getBundle", "getTypeCode", "typeCode", "Companion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskCreate extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Parcelable.Creator<TaskCreate> CREATOR = new Parcelable.Creator<TaskCreate>() { // from class: com.stepos.ability.bean.TaskEvent$TaskCreate$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskCreate createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                Task task = (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class);
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                p.f(task);
                return new TaskEvent.TaskCreate(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskCreate[] newArray(int size) {
                return new TaskEvent.TaskCreate[size];
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskCreate(Task task, Bundle bundle) {
            super(null);
            p.i(task, "task");
            this.task = task;
            this.bundle = bundle;
        }

        public static /* synthetic */ TaskCreate copy$default(TaskCreate taskCreate, Task task, Bundle bundle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                task = taskCreate.task;
            }
            if ((i10 & 2) != 0) {
                bundle = taskCreate.bundle;
            }
            return taskCreate.copy(task, bundle);
        }

        /* renamed from: component1, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: component2, reason: from getter */
        public final Bundle getBundle() {
            return this.bundle;
        }

        public final TaskCreate copy(Task task, Bundle bundle) {
            p.i(task, "task");
            return new TaskCreate(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskCreate)) {
                return false;
            }
            TaskCreate taskCreate = (TaskCreate) other;
            return p.d(this.task, taskCreate.task) && p.d(this.bundle, taskCreate.bundle);
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Bundle getBundle() {
            return this.bundle;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Task getTask() {
            return this.task;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public int getTypeCode() {
            return 0;
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Bundle bundle = this.bundle;
            return iHashCode + (bundle == null ? 0 : bundle.hashCode());
        }

        public String toString() {
            return "TaskCreate(task=" + this.task + ", bundle=" + this.bundle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            p.i(parcel, "parcel");
            parcel.writeInt(0);
            parcel.writeParcelable(getTask(), flags);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskCreate(Task task, Bundle bundle, int i10, i iVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0014R\u0014\u0010%\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\n¨\u0006'"}, d2 = {"Lcom/stepos/ability/bean/TaskEvent$TaskFail;", "Lcom/stepos/ability/bean/TaskEvent;", "Lcom/stepos/ability/bean/Task;", "task", "Landroid/os/Bundle;", "bundle", "<init>", "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Lcom/stepos/ability/bean/Task;", "component2", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)Lcom/stepos/ability/bean/TaskEvent$TaskFail;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ability/bean/Task;", "getTask", "Landroid/os/Bundle;", "getBundle", "getTypeCode", "typeCode", "Companion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskFail extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Parcelable.Creator<TaskFail> CREATOR = new Parcelable.Creator<TaskFail>() { // from class: com.stepos.ability.bean.TaskEvent$TaskFail$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskFail createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                Task task = (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class);
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                p.f(task);
                return new TaskEvent.TaskFail(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskFail[] newArray(int size) {
                return new TaskEvent.TaskFail[size];
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskFail(Task task, Bundle bundle) {
            super(null);
            p.i(task, "task");
            this.task = task;
            this.bundle = bundle;
        }

        public static /* synthetic */ TaskFail copy$default(TaskFail taskFail, Task task, Bundle bundle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                task = taskFail.task;
            }
            if ((i10 & 2) != 0) {
                bundle = taskFail.bundle;
            }
            return taskFail.copy(task, bundle);
        }

        /* renamed from: component1, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: component2, reason: from getter */
        public final Bundle getBundle() {
            return this.bundle;
        }

        public final TaskFail copy(Task task, Bundle bundle) {
            p.i(task, "task");
            return new TaskFail(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskFail)) {
                return false;
            }
            TaskFail taskFail = (TaskFail) other;
            return p.d(this.task, taskFail.task) && p.d(this.bundle, taskFail.bundle);
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Bundle getBundle() {
            return this.bundle;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Task getTask() {
            return this.task;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public int getTypeCode() {
            return 6;
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Bundle bundle = this.bundle;
            return iHashCode + (bundle == null ? 0 : bundle.hashCode());
        }

        public String toString() {
            return "TaskFail(task=" + this.task + ", bundle=" + this.bundle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            p.i(parcel, "parcel");
            parcel.writeInt(6);
            parcel.writeParcelable(getTask(), flags);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskFail(Task task, Bundle bundle, int i10, i iVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0014R\u0014\u0010%\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\n¨\u0006'"}, d2 = {"Lcom/stepos/ability/bean/TaskEvent$TaskPause;", "Lcom/stepos/ability/bean/TaskEvent;", "Lcom/stepos/ability/bean/Task;", "task", "Landroid/os/Bundle;", "bundle", "<init>", "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Lcom/stepos/ability/bean/Task;", "component2", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)Lcom/stepos/ability/bean/TaskEvent$TaskPause;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ability/bean/Task;", "getTask", "Landroid/os/Bundle;", "getBundle", "getTypeCode", "typeCode", "Companion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskPause extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Parcelable.Creator<TaskPause> CREATOR = new Parcelable.Creator<TaskPause>() { // from class: com.stepos.ability.bean.TaskEvent$TaskPause$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskPause createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                Task task = (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class);
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                p.f(task);
                return new TaskEvent.TaskPause(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskPause[] newArray(int size) {
                return new TaskEvent.TaskPause[size];
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskPause(Task task, Bundle bundle) {
            super(null);
            p.i(task, "task");
            this.task = task;
            this.bundle = bundle;
        }

        public static /* synthetic */ TaskPause copy$default(TaskPause taskPause, Task task, Bundle bundle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                task = taskPause.task;
            }
            if ((i10 & 2) != 0) {
                bundle = taskPause.bundle;
            }
            return taskPause.copy(task, bundle);
        }

        /* renamed from: component1, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: component2, reason: from getter */
        public final Bundle getBundle() {
            return this.bundle;
        }

        public final TaskPause copy(Task task, Bundle bundle) {
            p.i(task, "task");
            return new TaskPause(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskPause)) {
                return false;
            }
            TaskPause taskPause = (TaskPause) other;
            return p.d(this.task, taskPause.task) && p.d(this.bundle, taskPause.bundle);
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Bundle getBundle() {
            return this.bundle;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Task getTask() {
            return this.task;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public int getTypeCode() {
            return 3;
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Bundle bundle = this.bundle;
            return iHashCode + (bundle == null ? 0 : bundle.hashCode());
        }

        public String toString() {
            return "TaskPause(task=" + this.task + ", bundle=" + this.bundle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            p.i(parcel, "parcel");
            parcel.writeInt(3);
            parcel.writeParcelable(getTask(), flags);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskPause(Task task, Bundle bundle, int i10, i iVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0014R\u0014\u0010%\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\n¨\u0006'"}, d2 = {"Lcom/stepos/ability/bean/TaskEvent$TaskPending;", "Lcom/stepos/ability/bean/TaskEvent;", "Lcom/stepos/ability/bean/Task;", "task", "Landroid/os/Bundle;", "bundle", "<init>", "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Lcom/stepos/ability/bean/Task;", "component2", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)Lcom/stepos/ability/bean/TaskEvent$TaskPending;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ability/bean/Task;", "getTask", "Landroid/os/Bundle;", "getBundle", "getTypeCode", "typeCode", "Companion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskPending extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Parcelable.Creator<TaskPending> CREATOR = new Parcelable.Creator<TaskPending>() { // from class: com.stepos.ability.bean.TaskEvent$TaskPending$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskPending createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                Task task = (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class);
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                p.f(task);
                return new TaskEvent.TaskPending(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskPending[] newArray(int size) {
                return new TaskEvent.TaskPending[size];
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskPending(Task task, Bundle bundle) {
            super(null);
            p.i(task, "task");
            this.task = task;
            this.bundle = bundle;
        }

        public static /* synthetic */ TaskPending copy$default(TaskPending taskPending, Task task, Bundle bundle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                task = taskPending.task;
            }
            if ((i10 & 2) != 0) {
                bundle = taskPending.bundle;
            }
            return taskPending.copy(task, bundle);
        }

        /* renamed from: component1, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: component2, reason: from getter */
        public final Bundle getBundle() {
            return this.bundle;
        }

        public final TaskPending copy(Task task, Bundle bundle) {
            p.i(task, "task");
            return new TaskPending(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskPending)) {
                return false;
            }
            TaskPending taskPending = (TaskPending) other;
            return p.d(this.task, taskPending.task) && p.d(this.bundle, taskPending.bundle);
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Bundle getBundle() {
            return this.bundle;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Task getTask() {
            return this.task;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public int getTypeCode() {
            return 9;
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Bundle bundle = this.bundle;
            return iHashCode + (bundle == null ? 0 : bundle.hashCode());
        }

        public String toString() {
            return "TaskPending(task=" + this.task + ", bundle=" + this.bundle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            p.i(parcel, "parcel");
            parcel.writeInt(9);
            parcel.writeParcelable(getTask(), flags);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskPending(Task task, Bundle bundle, int i10, i iVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0012J\u0010\u0010\u0018\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0014R\u0014\u0010%\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\n¨\u0006)"}, d2 = {"Lcom/stepos/ability/bean/TaskEvent$TaskRemoved;", "Lcom/stepos/ability/bean/TaskEvent;", "", "taskId", "Landroid/os/Bundle;", "bundle", "<init>", "(Ljava/lang/String;Landroid/os/Bundle;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Landroid/os/Bundle;)Lcom/stepos/ability/bean/TaskEvent$TaskRemoved;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "Landroid/os/Bundle;", "getBundle", "Lcom/stepos/ability/bean/Task;", "getTask", "()Lcom/stepos/ability/bean/Task;", "task", "getTypeCode", "typeCode", "Companion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskRemoved extends TaskEvent {
        private final Bundle bundle;
        private final String taskId;
        public static final Parcelable.Creator<TaskRemoved> CREATOR = new Parcelable.Creator<TaskRemoved>() { // from class: com.stepos.ability.bean.TaskEvent$TaskRemoved$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskRemoved createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                String string = parcel.readString();
                if (string == null) {
                    string = "";
                }
                return new TaskEvent.TaskRemoved(string, parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskRemoved[] newArray(int size) {
                return new TaskEvent.TaskRemoved[size];
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskRemoved(String taskId, Bundle bundle) {
            super(null);
            p.i(taskId, "taskId");
            this.taskId = taskId;
            this.bundle = bundle;
        }

        public static /* synthetic */ TaskRemoved copy$default(TaskRemoved taskRemoved, String str, Bundle bundle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = taskRemoved.taskId;
            }
            if ((i10 & 2) != 0) {
                bundle = taskRemoved.bundle;
            }
            return taskRemoved.copy(str, bundle);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: component2, reason: from getter */
        public final Bundle getBundle() {
            return this.bundle;
        }

        public final TaskRemoved copy(String taskId, Bundle bundle) {
            p.i(taskId, "taskId");
            return new TaskRemoved(taskId, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskRemoved)) {
                return false;
            }
            TaskRemoved taskRemoved = (TaskRemoved) other;
            return p.d(this.taskId, taskRemoved.taskId) && p.d(this.bundle, taskRemoved.bundle);
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Bundle getBundle() {
            return this.bundle;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Task getTask() {
            return TaskEvent.INSTANCE.minimalTask(getTaskId());
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public String getTaskId() {
            return this.taskId;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public int getTypeCode() {
            return 7;
        }

        public int hashCode() {
            int iHashCode = this.taskId.hashCode() * 31;
            Bundle bundle = this.bundle;
            return iHashCode + (bundle == null ? 0 : bundle.hashCode());
        }

        public String toString() {
            return "TaskRemoved(taskId=" + this.taskId + ", bundle=" + this.bundle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            p.i(parcel, "parcel");
            parcel.writeInt(7);
            parcel.writeString(getTaskId());
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskRemoved(String str, Bundle bundle, int i10, i iVar) {
            this(str, (i10 & 2) != 0 ? null : bundle);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0014R\u0014\u0010%\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\n¨\u0006'"}, d2 = {"Lcom/stepos/ability/bean/TaskEvent$TaskResume;", "Lcom/stepos/ability/bean/TaskEvent;", "Lcom/stepos/ability/bean/Task;", "task", "Landroid/os/Bundle;", "bundle", "<init>", "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Lcom/stepos/ability/bean/Task;", "component2", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)Lcom/stepos/ability/bean/TaskEvent$TaskResume;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ability/bean/Task;", "getTask", "Landroid/os/Bundle;", "getBundle", "getTypeCode", "typeCode", "Companion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskResume extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Parcelable.Creator<TaskResume> CREATOR = new Parcelable.Creator<TaskResume>() { // from class: com.stepos.ability.bean.TaskEvent$TaskResume$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskResume createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                Task task = (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class);
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                p.f(task);
                return new TaskEvent.TaskResume(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskResume[] newArray(int size) {
                return new TaskEvent.TaskResume[size];
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskResume(Task task, Bundle bundle) {
            super(null);
            p.i(task, "task");
            this.task = task;
            this.bundle = bundle;
        }

        public static /* synthetic */ TaskResume copy$default(TaskResume taskResume, Task task, Bundle bundle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                task = taskResume.task;
            }
            if ((i10 & 2) != 0) {
                bundle = taskResume.bundle;
            }
            return taskResume.copy(task, bundle);
        }

        /* renamed from: component1, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: component2, reason: from getter */
        public final Bundle getBundle() {
            return this.bundle;
        }

        public final TaskResume copy(Task task, Bundle bundle) {
            p.i(task, "task");
            return new TaskResume(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskResume)) {
                return false;
            }
            TaskResume taskResume = (TaskResume) other;
            return p.d(this.task, taskResume.task) && p.d(this.bundle, taskResume.bundle);
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Bundle getBundle() {
            return this.bundle;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Task getTask() {
            return this.task;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public int getTypeCode() {
            return 8;
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Bundle bundle = this.bundle;
            return iHashCode + (bundle == null ? 0 : bundle.hashCode());
        }

        public String toString() {
            return "TaskResume(task=" + this.task + ", bundle=" + this.bundle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            p.i(parcel, "parcel");
            parcel.writeInt(8);
            parcel.writeParcelable(getTask(), flags);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskResume(Task task, Bundle bundle, int i10, i iVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0014R\u0014\u0010%\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\n¨\u0006'"}, d2 = {"Lcom/stepos/ability/bean/TaskEvent$TaskStart;", "Lcom/stepos/ability/bean/TaskEvent;", "Lcom/stepos/ability/bean/Task;", "task", "Landroid/os/Bundle;", "bundle", "<init>", "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Lcom/stepos/ability/bean/Task;", "component2", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)Lcom/stepos/ability/bean/TaskEvent$TaskStart;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ability/bean/Task;", "getTask", "Landroid/os/Bundle;", "getBundle", "getTypeCode", "typeCode", "Companion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskStart extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Parcelable.Creator<TaskStart> CREATOR = new Parcelable.Creator<TaskStart>() { // from class: com.stepos.ability.bean.TaskEvent$TaskStart$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskStart createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                Task task = (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class);
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                p.f(task);
                return new TaskEvent.TaskStart(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskStart[] newArray(int size) {
                return new TaskEvent.TaskStart[size];
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskStart(Task task, Bundle bundle) {
            super(null);
            p.i(task, "task");
            this.task = task;
            this.bundle = bundle;
        }

        public static /* synthetic */ TaskStart copy$default(TaskStart taskStart, Task task, Bundle bundle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                task = taskStart.task;
            }
            if ((i10 & 2) != 0) {
                bundle = taskStart.bundle;
            }
            return taskStart.copy(task, bundle);
        }

        /* renamed from: component1, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: component2, reason: from getter */
        public final Bundle getBundle() {
            return this.bundle;
        }

        public final TaskStart copy(Task task, Bundle bundle) {
            p.i(task, "task");
            return new TaskStart(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskStart)) {
                return false;
            }
            TaskStart taskStart = (TaskStart) other;
            return p.d(this.task, taskStart.task) && p.d(this.bundle, taskStart.bundle);
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Bundle getBundle() {
            return this.bundle;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Task getTask() {
            return this.task;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public int getTypeCode() {
            return 1;
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Bundle bundle = this.bundle;
            return iHashCode + (bundle == null ? 0 : bundle.hashCode());
        }

        public String toString() {
            return "TaskStart(task=" + this.task + ", bundle=" + this.bundle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            p.i(parcel, "parcel");
            parcel.writeInt(1);
            parcel.writeParcelable(getTask(), flags);
            parcel.writeInt(getBundle() == null ? 0 : 1);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskStart(Task task, Bundle bundle, int i10, i iVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0014R\u0014\u0010%\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\n¨\u0006'"}, d2 = {"Lcom/stepos/ability/bean/TaskEvent$TaskTakeOver;", "Lcom/stepos/ability/bean/TaskEvent;", "Lcom/stepos/ability/bean/Task;", "task", "Landroid/os/Bundle;", "bundle", "<init>", "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Lcom/stepos/ability/bean/Task;", "component2", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)Lcom/stepos/ability/bean/TaskEvent$TaskTakeOver;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ability/bean/Task;", "getTask", "Landroid/os/Bundle;", "getBundle", "getTypeCode", "typeCode", "Companion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskTakeOver extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Parcelable.Creator<TaskTakeOver> CREATOR = new Parcelable.Creator<TaskTakeOver>() { // from class: com.stepos.ability.bean.TaskEvent$TaskTakeOver$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskTakeOver createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                Task task = (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class);
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                p.f(task);
                return new TaskEvent.TaskTakeOver(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskTakeOver[] newArray(int size) {
                return new TaskEvent.TaskTakeOver[size];
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskTakeOver(Task task, Bundle bundle) {
            super(null);
            p.i(task, "task");
            this.task = task;
            this.bundle = bundle;
        }

        public static /* synthetic */ TaskTakeOver copy$default(TaskTakeOver taskTakeOver, Task task, Bundle bundle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                task = taskTakeOver.task;
            }
            if ((i10 & 2) != 0) {
                bundle = taskTakeOver.bundle;
            }
            return taskTakeOver.copy(task, bundle);
        }

        /* renamed from: component1, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: component2, reason: from getter */
        public final Bundle getBundle() {
            return this.bundle;
        }

        public final TaskTakeOver copy(Task task, Bundle bundle) {
            p.i(task, "task");
            return new TaskTakeOver(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskTakeOver)) {
                return false;
            }
            TaskTakeOver taskTakeOver = (TaskTakeOver) other;
            return p.d(this.task, taskTakeOver.task) && p.d(this.bundle, taskTakeOver.bundle);
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Bundle getBundle() {
            return this.bundle;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Task getTask() {
            return this.task;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public int getTypeCode() {
            return 10;
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Bundle bundle = this.bundle;
            return iHashCode + (bundle == null ? 0 : bundle.hashCode());
        }

        public String toString() {
            return "TaskTakeOver(task=" + this.task + ", bundle=" + this.bundle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            p.i(parcel, "parcel");
            parcel.writeInt(10);
            parcel.writeParcelable(getTask(), flags);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskTakeOver(Task task, Bundle bundle, int i10, i iVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    public /* synthetic */ TaskEvent(i iVar) {
        this();
    }

    public abstract Bundle getBundle();

    public abstract Task getTask();

    public String getTaskId() {
        return getTask().getTaskId();
    }

    public abstract int getTypeCode();

    private TaskEvent() {
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0014R\u0014\u0010%\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\n¨\u0006'"}, d2 = {"Lcom/stepos/ability/bean/TaskEvent$TaskProgress;", "Lcom/stepos/ability/bean/TaskEvent;", "Lcom/stepos/ability/bean/Task;", "task", "Landroid/os/Bundle;", "bundle", "<init>", "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Lcom/stepos/ability/bean/Task;", "component2", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(Lcom/stepos/ability/bean/Task;Landroid/os/Bundle;)Lcom/stepos/ability/bean/TaskEvent$TaskProgress;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ability/bean/Task;", "getTask", "Landroid/os/Bundle;", "getBundle", "getTypeCode", "typeCode", "Companion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskProgress extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Parcelable.Creator<TaskProgress> CREATOR = new Parcelable.Creator<TaskProgress>() { // from class: com.stepos.ability.bean.TaskEvent$TaskProgress$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskProgress createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                Task task = (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class);
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                p.f(task);
                return new TaskEvent.TaskProgress(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskProgress[] newArray(int size) {
                return new TaskEvent.TaskProgress[size];
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskProgress(Task task, Bundle bundle) {
            super(null);
            p.i(task, "task");
            this.task = task;
            this.bundle = bundle;
        }

        public static /* synthetic */ TaskProgress copy$default(TaskProgress taskProgress, Task task, Bundle bundle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                task = taskProgress.task;
            }
            if ((i10 & 2) != 0) {
                bundle = taskProgress.bundle;
            }
            return taskProgress.copy(task, bundle);
        }

        /* renamed from: component1, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: component2, reason: from getter */
        public final Bundle getBundle() {
            return this.bundle;
        }

        public final TaskProgress copy(Task task, Bundle bundle) {
            p.i(task, "task");
            return new TaskProgress(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskProgress)) {
                return false;
            }
            TaskProgress taskProgress = (TaskProgress) other;
            return p.d(this.task, taskProgress.task) && p.d(this.bundle, taskProgress.bundle);
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Bundle getBundle() {
            return this.bundle;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Task getTask() {
            return this.task;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public int getTypeCode() {
            return 2;
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Bundle bundle = this.bundle;
            return iHashCode + (bundle == null ? 0 : bundle.hashCode());
        }

        public String toString() {
            return "TaskProgress(task=" + this.task + ", bundle=" + this.bundle + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            p.i(parcel, "parcel");
            parcel.writeInt(2);
            parcel.writeParcelable(getTask(), flags);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskProgress(Task task, Bundle bundle, int i10, i iVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }
}
