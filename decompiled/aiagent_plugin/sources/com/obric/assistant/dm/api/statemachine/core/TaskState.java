package com.obric.assistant.dm.api.statemachine.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: TaskState.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TaskState extends State {
    private final Map<String, String> extra;
    private final int state;
    private final TaskId taskId;
    private final TaskInfo taskInfo;

    /* JADX INFO: compiled from: TaskState.kt */
    public static final class Idle extends TaskState {
        public static final Parcelable.Creator<Idle> CREATOR = null;
        private final Map<String, String> extra;
        private final int state;
        private final TaskId taskId;
        private final TaskInfo taskInfo;

        /* JADX INFO: compiled from: TaskState.kt */
        public static final class Creator implements Parcelable.Creator<Idle> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Idle createFromParcel(Parcel r9) {
                o.e(r9, "parcel");
                TaskInfo r0 = null;
                if (r9.readInt() != 0) goto L5;
                TaskId r8 = null;
            L6:
                TaskId r10 = (TaskId) ZeusTransformUtils.preCheckCast(r8, TaskId.class, "com.obric.aiagent.plugin");
                if (r9.readInt() == 0) goto L10;
                r0 = TaskInfo.CREATOR.createFromParcel(r9);
            L10:
                TaskInfo r1 = (TaskInfo) ZeusTransformUtils.preCheckCast(r0, TaskInfo.class, "com.obric.aiagent.plugin");
                int r2 = r9.readInt();
                int r3 = r9.readInt();
                LinkedHashMap r4 = new LinkedHashMap(r3);
                int r5 = 0;
            L11:
                if (r5 == r3) goto L14;
                r4.put(r9.readString(), r9.readString());
                r5 = r5 + 1;
                goto L11
            L14:
                return new Idle(r10, r1, r2, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
            L5:
                r8 = TaskId.CREATOR.createFromParcel(r9);
                goto L6
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Idle createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Idle[] newArray(int r1) {
                return new Idle[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Idle[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public Idle() {
            this(null, null, 0, null, 15, null);
        }

        public static /* synthetic */ Idle copy$default(Idle r1, TaskId r2, TaskInfo r3, int r4, Map r5, int r6, Object r7) {
            Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if ((r6 & 1) == 0) goto L6;
            r2 = r1.taskId;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = r1.taskInfo;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = r1.state;
        L12:
            if ((r6 & 8) == 0) goto L15;
            r8 = r1.extra;
        L15:
            return r1.copy(r2, r3, r4, r8);
        }

        public final TaskId component1() {
            return this.taskId;
        }

        public final TaskInfo component2() {
            return this.taskInfo;
        }

        public final int component3() {
            return this.state;
        }

        public final Map<String, String> component4() {
            return this.extra;
        }

        public final Idle copy(TaskId r2, TaskInfo r3, int r4, Map<String, String> r5) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r1, "extra");
            return new Idle(r2, r3, r4, r1);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State
        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Idle.class) == true) goto L8;
            return false;
        L8:
            Idle r6 = (Idle) ZeusTransformUtils.preCheckCast(r5, Idle.class, "com.obric.aiagent.plugin");
            if (o.a(this.taskId, r6.taskId) == true) goto L12;
            return false;
        L12:
            if (o.a(this.taskInfo, r6.taskInfo) == true) goto L15;
            return false;
        L15:
            if (this.state == r6.state) goto L18;
            return false;
        L18:
            if (o.a(this.extra, r6.extra) == true) goto L20;
            return false;
        L20:
            return true;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State
        public String getStateName() {
            return "SimpleTask_Idle";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State
        public int hashCode() {
            TaskId r0 = this.taskId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            TaskInfo r4 = this.taskInfo;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return ((((r3 + r1) * 31) + Integer.hashCode(this.state)) * 31) + this.extra.hashCode();
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State
        public boolean isIdle() {
            return true;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State
        public String toString() {
            return "Idle(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", state=" + this.state + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            TaskId r0 = this.taskId;
            if (r0 != null) goto L5;
            r4.writeInt(0);
        L6:
            TaskInfo r1 = this.taskInfo;
            if (r1 != null) goto L9;
            r4.writeInt(0);
        L10:
            r4.writeInt(this.state);
            Map<String, String> r3 = this.extra;
            r4.writeInt(r3.size());
            Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
        L12:
            if (r6.hasNext() == false) goto L14;
            Map.Entry<String, String> r7 = r6.next();
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L12
        L14:
            return;
        L9:
            r4.writeInt(1);
            r1.writeToParcel(r4, r5);
            goto L10
        L5:
            r4.writeInt(1);
            r0.writeToParcel(r4, r5);
            goto L6
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public TaskId getTaskId() {
            return this.taskId;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.TaskState
        public TaskInfo getTaskInfo() {
            return this.taskInfo;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public int getState() {
            return this.state;
        }

        public /* synthetic */ Idle(TaskId r2, TaskInfo r3, int r4, Map r5, int r6, h r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = 0;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r8 = ao.b();
        L14:
            this(r2, r3, r4, r8);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public Idle(TaskId r7, TaskInfo r8, int r9, Map<String, String> r10) {
            Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
            o.e(r11, "extra");
            super(r7, r8, r9, r11, null);
            this.taskId = r7;
            this.taskInfo = r8;
            this.state = r9;
            this.extra = r11;
        }
    }

    /* JADX INFO: compiled from: TaskState.kt */
    public static final class Processing extends TaskState {
        public static final Parcelable.Creator<Processing> CREATOR = null;
        private final Map<String, String> extra;
        private final int state;
        private final TaskId taskId;
        private final TaskInfo taskInfo;

        /* JADX INFO: compiled from: TaskState.kt */
        public static final class Creator implements Parcelable.Creator<Processing> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Processing createFromParcel(Parcel r9) {
                o.e(r9, "parcel");
                TaskId r8 = (TaskId) ZeusTransformUtils.preCheckCast(TaskId.CREATOR.createFromParcel(r9), TaskId.class, "com.obric.aiagent.plugin");
                if (r9.readInt() != 0) goto L5;
                TaskInfo r0 = null;
            L6:
                TaskInfo r1 = (TaskInfo) ZeusTransformUtils.preCheckCast(r0, TaskInfo.class, "com.obric.aiagent.plugin");
                int r2 = r9.readInt();
                int r3 = r9.readInt();
                LinkedHashMap r4 = new LinkedHashMap(r3);
                int r5 = 0;
            L7:
                if (r5 == r3) goto L10;
                r4.put(r9.readString(), r9.readString());
                r5 = r5 + 1;
                goto L7
            L10:
                return new Processing(r8, r1, r2, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
            L5:
                r0 = TaskInfo.CREATOR.createFromParcel(r9);
                goto L6
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Processing createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Processing[] newArray(int r1) {
                return new Processing[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Processing[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ Processing copy$default(Processing r1, TaskId r2, TaskInfo r3, int r4, Map r5, int r6, Object r7) {
            Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if ((r6 & 1) == 0) goto L6;
            r2 = r1.taskId;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = r1.taskInfo;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = r1.state;
        L12:
            if ((r6 & 8) == 0) goto L15;
            r8 = r1.extra;
        L15:
            return r1.copy(r2, r3, r4, r8);
        }

        public final TaskId component1() {
            return this.taskId;
        }

        public final TaskInfo component2() {
            return this.taskInfo;
        }

        public final int component3() {
            return this.state;
        }

        public final Map<String, String> component4() {
            return this.extra;
        }

        public final Processing copy(TaskId r2, TaskInfo r3, int r4, Map<String, String> r5) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new Processing(r2, r3, r4, r1);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State
        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Processing.class) == true) goto L8;
            return false;
        L8:
            Processing r6 = (Processing) ZeusTransformUtils.preCheckCast(r5, Processing.class, "com.obric.aiagent.plugin");
            if (o.a(this.taskId, r6.taskId) == true) goto L12;
            return false;
        L12:
            if (o.a(this.taskInfo, r6.taskInfo) == true) goto L15;
            return false;
        L15:
            if (this.state == r6.state) goto L18;
            return false;
        L18:
            if (o.a(this.extra, r6.extra) == true) goto L20;
            return false;
        L20:
            return true;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State
        public String getStateName() {
            return "SimpleTask_Processing";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State
        public int hashCode() {
            int r0 = this.taskId.hashCode() * 31;
            TaskInfo r1 = this.taskInfo;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((r0 + r2) * 31) + Integer.hashCode(this.state)) * 31) + this.extra.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State
        public boolean isIdle() {
            return false;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State
        public String toString() {
            return "Processing(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", state=" + this.state + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            this.taskId.writeToParcel(r4, r5);
            TaskInfo r0 = this.taskInfo;
            if (r0 != null) goto L5;
            r4.writeInt(0);
        L6:
            r4.writeInt(this.state);
            Map<String, String> r3 = this.extra;
            r4.writeInt(r3.size());
            Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            Map.Entry<String, String> r7 = r6.next();
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L8
        L10:
            return;
        L5:
            r4.writeInt(1);
            r0.writeToParcel(r4, r5);
            goto L6
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public TaskId getTaskId() {
            return this.taskId;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.TaskState
        public TaskInfo getTaskInfo() {
            return this.taskInfo;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public int getState() {
            return this.state;
        }

        public /* synthetic */ Processing(TaskId r2, TaskInfo r3, int r4, Map r5, int r6, h r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = 1;
        L9:
            if ((r6 & 8) == 0) goto L11;
            r8 = ao.b();
        L11:
            this(r2, r3, r4, r8);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public Processing(TaskId r7, TaskInfo r8, int r9, Map<String, String> r10) {
            Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
            o.e(r7, DBDefinition.TASK_ID);
            o.e(r11, "extra");
            super(r7, r8, r9, r11, null);
            this.taskId = r7;
            this.taskInfo = r8;
            this.state = r9;
            this.extra = r11;
        }
    }

    public /* synthetic */ TaskState(TaskId r2, TaskInfo r3, int r4, Map r5, h r6) {
        this(r2, r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.State
    public TaskId getTaskId() {
        return this.taskId;
    }

    public TaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.State
    public int getState() {
        return this.state;
    }

    public /* synthetic */ TaskState(TaskId r8, TaskInfo r9, int r10, Map r11, int r12, h r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        TaskId r2 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        TaskInfo r3 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        r10 = 0;
    L13:
        int r4 = r10;
        if ((r12 & 8) == 0) goto L16;
        r14 = ao.b();
    L16:
        this(r2, r3, r4, r14, null);
        return;
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.State
    public Map<String, String> getExtra() {
        return this.extra;
    }

    private TaskState(TaskId r3, TaskInfo r4, int r5, Map<String, String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        super(r3, r5, r7);
        this.taskId = r3;
        this.taskInfo = r4;
        this.state = r5;
        this.extra = r7;
    }
}
