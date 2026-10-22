package com.stepos.ability.bean;

import ai.onnxruntime.providers.a;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ability.bean.TaskEvent;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
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
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<TaskEvent> CREATOR = new Parcelable.Creator<TaskEvent>() { // from class: com.stepos.ability.bean.TaskEvent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TaskEvent createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            int i10 = parcel.readInt();
            switch (i10) {
                case 0:
                    TaskEvent.TaskCreate taskCreateCreateFromParcel = TaskEvent.TaskCreate.CREATOR.createFromParcel(parcel);
                    g.e(taskCreateCreateFromParcel, "createFromParcel(...)");
                    return taskCreateCreateFromParcel;
                case 1:
                    TaskEvent.TaskStart taskStartCreateFromParcel = TaskEvent.TaskStart.CREATOR.createFromParcel(parcel);
                    g.e(taskStartCreateFromParcel, "createFromParcel(...)");
                    return taskStartCreateFromParcel;
                case 2:
                    TaskEvent.TaskProgress taskProgressCreateFromParcel = TaskEvent.TaskProgress.CREATOR.createFromParcel(parcel);
                    g.e(taskProgressCreateFromParcel, "createFromParcel(...)");
                    return taskProgressCreateFromParcel;
                case 3:
                    TaskEvent.TaskPause taskPauseCreateFromParcel = TaskEvent.TaskPause.CREATOR.createFromParcel(parcel);
                    g.e(taskPauseCreateFromParcel, "createFromParcel(...)");
                    return taskPauseCreateFromParcel;
                case 4:
                    TaskEvent.TaskComplete taskCompleteCreateFromParcel = TaskEvent.TaskComplete.CREATOR.createFromParcel(parcel);
                    g.e(taskCompleteCreateFromParcel, "createFromParcel(...)");
                    return taskCompleteCreateFromParcel;
                case 5:
                    TaskEvent.TaskCancel taskCancelCreateFromParcel = TaskEvent.TaskCancel.CREATOR.createFromParcel(parcel);
                    g.e(taskCancelCreateFromParcel, "createFromParcel(...)");
                    return taskCancelCreateFromParcel;
                case 6:
                    TaskEvent.TaskFail taskFailCreateFromParcel = TaskEvent.TaskFail.CREATOR.createFromParcel(parcel);
                    g.e(taskFailCreateFromParcel, "createFromParcel(...)");
                    return taskFailCreateFromParcel;
                case 7:
                    TaskEvent.TaskRemoved taskRemovedCreateFromParcel = TaskEvent.TaskRemoved.CREATOR.createFromParcel(parcel);
                    g.e(taskRemovedCreateFromParcel, "createFromParcel(...)");
                    return taskRemovedCreateFromParcel;
                case 8:
                    TaskEvent.TaskResume taskResumeCreateFromParcel = TaskEvent.TaskResume.CREATOR.createFromParcel(parcel);
                    g.e(taskResumeCreateFromParcel, "createFromParcel(...)");
                    return taskResumeCreateFromParcel;
                case 9:
                    TaskEvent.TaskPending taskPendingCreateFromParcel = TaskEvent.TaskPending.CREATOR.createFromParcel(parcel);
                    g.e(taskPendingCreateFromParcel, "createFromParcel(...)");
                    return taskPendingCreateFromParcel;
                case 10:
                    TaskEvent.TaskTakeOver taskTakeOverCreateFromParcel = TaskEvent.TaskTakeOver.CREATOR.createFromParcel(parcel);
                    g.e(taskTakeOverCreateFromParcel, "createFromParcel(...)");
                    return taskTakeOverCreateFromParcel;
                default:
                    throw new IllegalArgumentException(a.a(i10, "Unknown TaskEvent type: "));
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TaskEvent[] newArray(int i10) {
            return new TaskEvent[i10];
        }
    };

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Task minimalTask(String str) {
            return new Task(str, null, null, null, null, null, 0, 0, 0, 0, null, 0L, 0L, 0L, null, null, null, null, 0, 524158, null);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TaskCancel extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<TaskCancel> CREATOR = new Parcelable.Creator<TaskCancel>() { // from class: com.stepos.ability.bean.TaskEvent$TaskCancel$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskCancel createFromParcel(Parcel parcel) {
                g.f(parcel, "parcel");
                Task task = Build.VERSION.SDK_INT >= 33 ? (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class) : (Task) parcel.readParcelable(Task.class.getClassLoader());
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                g.c(task);
                return new TaskEvent.TaskCancel(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskCancel[] newArray(int i10) {
                return new TaskEvent.TaskCancel[i10];
            }
        };

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskCancel(Task task, Bundle bundle) {
            super(null);
            g.f(task, "task");
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

        public final Task component1() {
            return this.task;
        }

        public final Bundle component2() {
            return this.bundle;
        }

        public final TaskCancel copy(Task task, Bundle bundle) {
            g.f(task, "task");
            return new TaskCancel(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskCancel)) {
                return false;
            }
            TaskCancel taskCancel = (TaskCancel) obj;
            return g.b(this.task, taskCancel.task) && g.b(this.bundle, taskCancel.bundle);
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
        public void writeToParcel(Parcel parcel, int i10) {
            g.f(parcel, "parcel");
            parcel.writeInt(5);
            parcel.writeParcelable(getTask(), i10);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskCancel(Task task, Bundle bundle, int i10, e eVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TaskComplete extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<TaskComplete> CREATOR = new Parcelable.Creator<TaskComplete>() { // from class: com.stepos.ability.bean.TaskEvent$TaskComplete$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskComplete createFromParcel(Parcel parcel) {
                g.f(parcel, "parcel");
                Task task = Build.VERSION.SDK_INT >= 33 ? (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class) : (Task) parcel.readParcelable(Task.class.getClassLoader());
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                g.c(task);
                return new TaskEvent.TaskComplete(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskComplete[] newArray(int i10) {
                return new TaskEvent.TaskComplete[i10];
            }
        };

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskComplete(Task task, Bundle bundle) {
            super(null);
            g.f(task, "task");
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

        public final Task component1() {
            return this.task;
        }

        public final Bundle component2() {
            return this.bundle;
        }

        public final TaskComplete copy(Task task, Bundle bundle) {
            g.f(task, "task");
            return new TaskComplete(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskComplete)) {
                return false;
            }
            TaskComplete taskComplete = (TaskComplete) obj;
            return g.b(this.task, taskComplete.task) && g.b(this.bundle, taskComplete.bundle);
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
        public void writeToParcel(Parcel parcel, int i10) {
            g.f(parcel, "parcel");
            parcel.writeInt(4);
            parcel.writeParcelable(getTask(), i10);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskComplete(Task task, Bundle bundle, int i10, e eVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TaskCreate extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<TaskCreate> CREATOR = new Parcelable.Creator<TaskCreate>() { // from class: com.stepos.ability.bean.TaskEvent$TaskCreate$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskCreate createFromParcel(Parcel parcel) {
                g.f(parcel, "parcel");
                Task task = Build.VERSION.SDK_INT >= 33 ? (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class) : (Task) parcel.readParcelable(Task.class.getClassLoader());
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                g.c(task);
                return new TaskEvent.TaskCreate(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskCreate[] newArray(int i10) {
                return new TaskEvent.TaskCreate[i10];
            }
        };

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskCreate(Task task, Bundle bundle) {
            super(null);
            g.f(task, "task");
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

        public final Task component1() {
            return this.task;
        }

        public final Bundle component2() {
            return this.bundle;
        }

        public final TaskCreate copy(Task task, Bundle bundle) {
            g.f(task, "task");
            return new TaskCreate(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskCreate)) {
                return false;
            }
            TaskCreate taskCreate = (TaskCreate) obj;
            return g.b(this.task, taskCreate.task) && g.b(this.bundle, taskCreate.bundle);
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
        public void writeToParcel(Parcel parcel, int i10) {
            g.f(parcel, "parcel");
            parcel.writeInt(0);
            parcel.writeParcelable(getTask(), i10);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskCreate(Task task, Bundle bundle, int i10, e eVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TaskFail extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<TaskFail> CREATOR = new Parcelable.Creator<TaskFail>() { // from class: com.stepos.ability.bean.TaskEvent$TaskFail$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskFail createFromParcel(Parcel parcel) {
                g.f(parcel, "parcel");
                Task task = Build.VERSION.SDK_INT >= 33 ? (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class) : (Task) parcel.readParcelable(Task.class.getClassLoader());
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                g.c(task);
                return new TaskEvent.TaskFail(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskFail[] newArray(int i10) {
                return new TaskEvent.TaskFail[i10];
            }
        };

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskFail(Task task, Bundle bundle) {
            super(null);
            g.f(task, "task");
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

        public final Task component1() {
            return this.task;
        }

        public final Bundle component2() {
            return this.bundle;
        }

        public final TaskFail copy(Task task, Bundle bundle) {
            g.f(task, "task");
            return new TaskFail(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskFail)) {
                return false;
            }
            TaskFail taskFail = (TaskFail) obj;
            return g.b(this.task, taskFail.task) && g.b(this.bundle, taskFail.bundle);
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
        public void writeToParcel(Parcel parcel, int i10) {
            g.f(parcel, "parcel");
            parcel.writeInt(6);
            parcel.writeParcelable(getTask(), i10);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskFail(Task task, Bundle bundle, int i10, e eVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TaskPause extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<TaskPause> CREATOR = new Parcelable.Creator<TaskPause>() { // from class: com.stepos.ability.bean.TaskEvent$TaskPause$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskPause createFromParcel(Parcel parcel) {
                g.f(parcel, "parcel");
                Task task = Build.VERSION.SDK_INT >= 33 ? (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class) : (Task) parcel.readParcelable(Task.class.getClassLoader());
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                g.c(task);
                return new TaskEvent.TaskPause(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskPause[] newArray(int i10) {
                return new TaskEvent.TaskPause[i10];
            }
        };

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskPause(Task task, Bundle bundle) {
            super(null);
            g.f(task, "task");
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

        public final Task component1() {
            return this.task;
        }

        public final Bundle component2() {
            return this.bundle;
        }

        public final TaskPause copy(Task task, Bundle bundle) {
            g.f(task, "task");
            return new TaskPause(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskPause)) {
                return false;
            }
            TaskPause taskPause = (TaskPause) obj;
            return g.b(this.task, taskPause.task) && g.b(this.bundle, taskPause.bundle);
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
        public void writeToParcel(Parcel parcel, int i10) {
            g.f(parcel, "parcel");
            parcel.writeInt(3);
            parcel.writeParcelable(getTask(), i10);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskPause(Task task, Bundle bundle, int i10, e eVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TaskPending extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<TaskPending> CREATOR = new Parcelable.Creator<TaskPending>() { // from class: com.stepos.ability.bean.TaskEvent$TaskPending$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskPending createFromParcel(Parcel parcel) {
                g.f(parcel, "parcel");
                Task task = Build.VERSION.SDK_INT >= 33 ? (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class) : (Task) parcel.readParcelable(Task.class.getClassLoader());
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                g.c(task);
                return new TaskEvent.TaskPending(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskPending[] newArray(int i10) {
                return new TaskEvent.TaskPending[i10];
            }
        };

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskPending(Task task, Bundle bundle) {
            super(null);
            g.f(task, "task");
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

        public final Task component1() {
            return this.task;
        }

        public final Bundle component2() {
            return this.bundle;
        }

        public final TaskPending copy(Task task, Bundle bundle) {
            g.f(task, "task");
            return new TaskPending(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskPending)) {
                return false;
            }
            TaskPending taskPending = (TaskPending) obj;
            return g.b(this.task, taskPending.task) && g.b(this.bundle, taskPending.bundle);
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
        public void writeToParcel(Parcel parcel, int i10) {
            g.f(parcel, "parcel");
            parcel.writeInt(9);
            parcel.writeParcelable(getTask(), i10);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskPending(Task task, Bundle bundle, int i10, e eVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TaskRemoved extends TaskEvent {
        private final Bundle bundle;
        private final String taskId;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<TaskRemoved> CREATOR = new Parcelable.Creator<TaskRemoved>() { // from class: com.stepos.ability.bean.TaskEvent$TaskRemoved$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskRemoved createFromParcel(Parcel parcel) {
                g.f(parcel, "parcel");
                String string = parcel.readString();
                if (string == null) {
                    string = "";
                }
                return new TaskEvent.TaskRemoved(string, parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskRemoved[] newArray(int i10) {
                return new TaskEvent.TaskRemoved[i10];
            }
        };

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskRemoved(String taskId, Bundle bundle) {
            super(null);
            g.f(taskId, "taskId");
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

        public final String component1() {
            return this.taskId;
        }

        public final Bundle component2() {
            return this.bundle;
        }

        public final TaskRemoved copy(String taskId, Bundle bundle) {
            g.f(taskId, "taskId");
            return new TaskRemoved(taskId, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskRemoved)) {
                return false;
            }
            TaskRemoved taskRemoved = (TaskRemoved) obj;
            return g.b(this.taskId, taskRemoved.taskId) && g.b(this.bundle, taskRemoved.bundle);
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Bundle getBundle() {
            return this.bundle;
        }

        @Override // com.stepos.ability.bean.TaskEvent
        public Task getTask() {
            return TaskEvent.Companion.minimalTask(getTaskId());
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
        public void writeToParcel(Parcel parcel, int i10) {
            g.f(parcel, "parcel");
            parcel.writeInt(7);
            parcel.writeString(getTaskId());
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskRemoved(String str, Bundle bundle, int i10, e eVar) {
            this(str, (i10 & 2) != 0 ? null : bundle);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TaskResume extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<TaskResume> CREATOR = new Parcelable.Creator<TaskResume>() { // from class: com.stepos.ability.bean.TaskEvent$TaskResume$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskResume createFromParcel(Parcel parcel) {
                g.f(parcel, "parcel");
                Task task = Build.VERSION.SDK_INT >= 33 ? (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class) : (Task) parcel.readParcelable(Task.class.getClassLoader());
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                g.c(task);
                return new TaskEvent.TaskResume(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskResume[] newArray(int i10) {
                return new TaskEvent.TaskResume[i10];
            }
        };

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskResume(Task task, Bundle bundle) {
            super(null);
            g.f(task, "task");
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

        public final Task component1() {
            return this.task;
        }

        public final Bundle component2() {
            return this.bundle;
        }

        public final TaskResume copy(Task task, Bundle bundle) {
            g.f(task, "task");
            return new TaskResume(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskResume)) {
                return false;
            }
            TaskResume taskResume = (TaskResume) obj;
            return g.b(this.task, taskResume.task) && g.b(this.bundle, taskResume.bundle);
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
        public void writeToParcel(Parcel parcel, int i10) {
            g.f(parcel, "parcel");
            parcel.writeInt(8);
            parcel.writeParcelable(getTask(), i10);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskResume(Task task, Bundle bundle, int i10, e eVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TaskStart extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<TaskStart> CREATOR = new Parcelable.Creator<TaskStart>() { // from class: com.stepos.ability.bean.TaskEvent$TaskStart$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskStart createFromParcel(Parcel parcel) {
                g.f(parcel, "parcel");
                Task task = Build.VERSION.SDK_INT >= 33 ? (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class) : (Task) parcel.readParcelable(Task.class.getClassLoader());
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                g.c(task);
                return new TaskEvent.TaskStart(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskStart[] newArray(int i10) {
                return new TaskEvent.TaskStart[i10];
            }
        };

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskStart(Task task, Bundle bundle) {
            super(null);
            g.f(task, "task");
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

        public final Task component1() {
            return this.task;
        }

        public final Bundle component2() {
            return this.bundle;
        }

        public final TaskStart copy(Task task, Bundle bundle) {
            g.f(task, "task");
            return new TaskStart(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskStart)) {
                return false;
            }
            TaskStart taskStart = (TaskStart) obj;
            return g.b(this.task, taskStart.task) && g.b(this.bundle, taskStart.bundle);
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
        public void writeToParcel(Parcel parcel, int i10) {
            g.f(parcel, "parcel");
            parcel.writeInt(1);
            parcel.writeParcelable(getTask(), i10);
            parcel.writeInt(getBundle() == null ? 0 : 1);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskStart(Task task, Bundle bundle, int i10, e eVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TaskTakeOver extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<TaskTakeOver> CREATOR = new Parcelable.Creator<TaskTakeOver>() { // from class: com.stepos.ability.bean.TaskEvent$TaskTakeOver$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskTakeOver createFromParcel(Parcel parcel) {
                g.f(parcel, "parcel");
                Task task = Build.VERSION.SDK_INT >= 33 ? (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class) : (Task) parcel.readParcelable(Task.class.getClassLoader());
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                g.c(task);
                return new TaskEvent.TaskTakeOver(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskTakeOver[] newArray(int i10) {
                return new TaskEvent.TaskTakeOver[i10];
            }
        };

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskTakeOver(Task task, Bundle bundle) {
            super(null);
            g.f(task, "task");
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

        public final Task component1() {
            return this.task;
        }

        public final Bundle component2() {
            return this.bundle;
        }

        public final TaskTakeOver copy(Task task, Bundle bundle) {
            g.f(task, "task");
            return new TaskTakeOver(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskTakeOver)) {
                return false;
            }
            TaskTakeOver taskTakeOver = (TaskTakeOver) obj;
            return g.b(this.task, taskTakeOver.task) && g.b(this.bundle, taskTakeOver.bundle);
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
        public void writeToParcel(Parcel parcel, int i10) {
            g.f(parcel, "parcel");
            parcel.writeInt(10);
            parcel.writeParcelable(getTask(), i10);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskTakeOver(Task task, Bundle bundle, int i10, e eVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }

    public /* synthetic */ TaskEvent(e eVar) {
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TaskProgress extends TaskEvent {
        private final Bundle bundle;
        private final Task task;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<TaskProgress> CREATOR = new Parcelable.Creator<TaskProgress>() { // from class: com.stepos.ability.bean.TaskEvent$TaskProgress$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskProgress createFromParcel(Parcel parcel) {
                g.f(parcel, "parcel");
                Task task = Build.VERSION.SDK_INT >= 33 ? (Task) parcel.readParcelable(Task.class.getClassLoader(), Task.class) : (Task) parcel.readParcelable(Task.class.getClassLoader());
                Bundle bundle = parcel.readInt() != 0 ? parcel.readBundle(Bundle.class.getClassLoader()) : null;
                g.c(task);
                return new TaskEvent.TaskProgress(task, bundle);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TaskEvent.TaskProgress[] newArray(int i10) {
                return new TaskEvent.TaskProgress[i10];
            }
        };

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskProgress(Task task, Bundle bundle) {
            super(null);
            g.f(task, "task");
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

        public final Task component1() {
            return this.task;
        }

        public final Bundle component2() {
            return this.bundle;
        }

        public final TaskProgress copy(Task task, Bundle bundle) {
            g.f(task, "task");
            return new TaskProgress(task, bundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskProgress)) {
                return false;
            }
            TaskProgress taskProgress = (TaskProgress) obj;
            return g.b(this.task, taskProgress.task) && g.b(this.bundle, taskProgress.bundle);
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
        public void writeToParcel(Parcel parcel, int i10) {
            g.f(parcel, "parcel");
            parcel.writeInt(2);
            parcel.writeParcelable(getTask(), i10);
            parcel.writeInt(getBundle() != null ? 1 : 0);
            Bundle bundle = getBundle();
            if (bundle != null) {
                parcel.writeBundle(bundle);
            }
        }

        public /* synthetic */ TaskProgress(Task task, Bundle bundle, int i10, e eVar) {
            this(task, (i10 & 2) != 0 ? null : bundle);
        }
    }
}
