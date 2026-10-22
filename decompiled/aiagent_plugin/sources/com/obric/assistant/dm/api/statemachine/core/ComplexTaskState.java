package com.obric.assistant.dm.api.statemachine.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aiagent.assistant.idl.bean.DMConstData;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: ComplexTaskState.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ComplexTaskState extends TaskState {
    private final Map<String, String> extra;
    private final int state;
    private final TaskId taskId;
    private final TaskInfo taskInfo;

    /* JADX INFO: compiled from: ComplexTaskState.kt */
    public static final class CallUser extends ComplexTaskState {
        public static final Parcelable.Creator<CallUser> CREATOR = null;
        private final Map<String, String> extra;
        private final int state;
        private final TaskId taskId;
        private final TaskInfo taskInfo;

        /* JADX INFO: compiled from: ComplexTaskState.kt */
        public static final class Creator implements Parcelable.Creator<CallUser> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CallUser createFromParcel(Parcel r9) {
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
                return new CallUser(r8, r1, r2, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
            L5:
                r0 = TaskInfo.CREATOR.createFromParcel(r9);
                goto L6
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ CallUser createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CallUser[] newArray(int r1) {
                return new CallUser[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ CallUser[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ CallUser copy$default(CallUser r1, TaskId r2, TaskInfo r3, int r4, Map r5, int r6, Object r7) {
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

        public final CallUser copy(TaskId r2, TaskInfo r3, int r4, Map<String, String> r5) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new CallUser(r2, r3, r4, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, CallUser.class) == true) goto L8;
            return false;
        L8:
            CallUser r6 = (CallUser) ZeusTransformUtils.preCheckCast(r5, CallUser.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_CallUser";
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
            return "CallUser(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", state=" + this.state + ", extra=" + this.extra + ')';
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

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public TaskId getTaskId() {
            return this.taskId;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState
        public TaskInfo getTaskInfo() {
            return this.taskInfo;
        }

        public /* synthetic */ CallUser(TaskId r2, TaskInfo r3, int r4, Map r5, int r6, h r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = DMConstData.a.f16246d.ordinal();
        L9:
            if ((r6 & 8) == 0) goto L11;
            r8 = ao.b();
        L11:
            this(r2, r3, r4, r8);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public int getState() {
            return this.state;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public CallUser(TaskId r7, TaskInfo r8, int r9, Map<String, String> r10) {
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

    /* JADX INFO: compiled from: ComplexTaskState.kt */
    public static final class Clarify extends ComplexTaskState {
        public static final Parcelable.Creator<Clarify> CREATOR = null;
        private final Map<String, String> extra;
        private final int state;
        private final TaskId taskId;
        private final TaskInfo taskInfo;

        /* JADX INFO: compiled from: ComplexTaskState.kt */
        public static final class Creator implements Parcelable.Creator<Clarify> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Clarify createFromParcel(Parcel r9) {
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
                return new Clarify(r8, r1, r2, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
            L5:
                r0 = TaskInfo.CREATOR.createFromParcel(r9);
                goto L6
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Clarify createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Clarify[] newArray(int r1) {
                return new Clarify[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Clarify[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ Clarify copy$default(Clarify r1, TaskId r2, TaskInfo r3, int r4, Map r5, int r6, Object r7) {
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

        public final Clarify copy(TaskId r2, TaskInfo r3, int r4, Map<String, String> r5) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new Clarify(r2, r3, r4, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, Clarify.class) == true) goto L8;
            return false;
        L8:
            Clarify r6 = (Clarify) ZeusTransformUtils.preCheckCast(r5, Clarify.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_Clarify";
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
            return "Clarify(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", state=" + this.state + ", extra=" + this.extra + ')';
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

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public TaskId getTaskId() {
            return this.taskId;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState
        public TaskInfo getTaskInfo() {
            return this.taskInfo;
        }

        public /* synthetic */ Clarify(TaskId r2, TaskInfo r3, int r4, Map r5, int r6, h r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = DMConstData.a.f16247e.ordinal();
        L9:
            if ((r6 & 8) == 0) goto L11;
            r8 = ao.b();
        L11:
            this(r2, r3, r4, r8);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public int getState() {
            return this.state;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public Clarify(TaskId r7, TaskInfo r8, int r9, Map<String, String> r10) {
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

    /* JADX INFO: compiled from: ComplexTaskState.kt */
    public static final class ClarifyAck extends ComplexTaskState {
        public static final Parcelable.Creator<ClarifyAck> CREATOR = null;
        private final Map<String, String> extra;
        private final int state;
        private final TaskId taskId;
        private final TaskInfo taskInfo;

        /* JADX INFO: compiled from: ComplexTaskState.kt */
        public static final class Creator implements Parcelable.Creator<ClarifyAck> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ClarifyAck createFromParcel(Parcel r9) {
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
                return new ClarifyAck(r8, r1, r2, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
            L5:
                r0 = TaskInfo.CREATOR.createFromParcel(r9);
                goto L6
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ ClarifyAck createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ClarifyAck[] newArray(int r1) {
                return new ClarifyAck[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ ClarifyAck[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ ClarifyAck copy$default(ClarifyAck r1, TaskId r2, TaskInfo r3, int r4, Map r5, int r6, Object r7) {
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

        public final ClarifyAck copy(TaskId r2, TaskInfo r3, int r4, Map<String, String> r5) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new ClarifyAck(r2, r3, r4, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, ClarifyAck.class) == true) goto L8;
            return false;
        L8:
            ClarifyAck r6 = (ClarifyAck) ZeusTransformUtils.preCheckCast(r5, ClarifyAck.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_ClarifyAck";
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
            return "ClarifyAck(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", state=" + this.state + ", extra=" + this.extra + ')';
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

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public TaskId getTaskId() {
            return this.taskId;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState
        public TaskInfo getTaskInfo() {
            return this.taskInfo;
        }

        public /* synthetic */ ClarifyAck(TaskId r2, TaskInfo r3, int r4, Map r5, int r6, h r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = DMConstData.a.f.ordinal();
        L9:
            if ((r6 & 8) == 0) goto L11;
            r8 = ao.b();
        L11:
            this(r2, r3, r4, r8);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public int getState() {
            return this.state;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public ClarifyAck(TaskId r7, TaskInfo r8, int r9, Map<String, String> r10) {
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

    /* JADX INFO: compiled from: ComplexTaskState.kt */
    public static final class Idle extends ComplexTaskState {
        public static final Parcelable.Creator<Idle> CREATOR = null;
        private final Map<String, String> extra;
        private final int state;
        private final TaskId taskId;
        private final TaskInfo taskInfo;

        /* JADX INFO: compiled from: ComplexTaskState.kt */
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
            return "ComplexTask_Idle";
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
        public boolean isCompletedOrCanceled() {
            return true;
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

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public TaskId getTaskId() {
            return this.taskId;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState
        public TaskInfo getTaskInfo() {
            return this.taskInfo;
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
            r4 = DMConstData.a.f16243a.ordinal();
        L12:
            if ((r6 & 8) == 0) goto L14;
            r8 = ao.b();
        L14:
            this(r2, r3, r4, r8);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public int getState() {
            return this.state;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
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

    /* JADX INFO: compiled from: ComplexTaskState.kt */
    public static final class Queueing extends ComplexTaskState {
        public static final Parcelable.Creator<Queueing> CREATOR = null;
        private final Map<String, String> extra;
        private final int state;
        private final TaskId taskId;
        private final TaskInfo taskInfo;

        /* JADX INFO: compiled from: ComplexTaskState.kt */
        public static final class Creator implements Parcelable.Creator<Queueing> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Queueing createFromParcel(Parcel r9) {
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
                return new Queueing(r8, r1, r2, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
            L5:
                r0 = TaskInfo.CREATOR.createFromParcel(r9);
                goto L6
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Queueing createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Queueing[] newArray(int r1) {
                return new Queueing[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Queueing[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ Queueing copy$default(Queueing r1, TaskId r2, TaskInfo r3, int r4, Map r5, int r6, Object r7) {
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

        public final Queueing copy(TaskId r2, TaskInfo r3, int r4, Map<String, String> r5) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new Queueing(r2, r3, r4, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, Queueing.class) == true) goto L8;
            return false;
        L8:
            Queueing r6 = (Queueing) ZeusTransformUtils.preCheckCast(r5, Queueing.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_Queueing";
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
            return "Queueing(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", state=" + this.state + ", extra=" + this.extra + ')';
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

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public TaskId getTaskId() {
            return this.taskId;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState
        public TaskInfo getTaskInfo() {
            return this.taskInfo;
        }

        public /* synthetic */ Queueing(TaskId r2, TaskInfo r3, int r4, Map r5, int r6, h r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = DMConstData.a.f16244b.ordinal();
        L9:
            if ((r6 & 8) == 0) goto L11;
            r8 = ao.b();
        L11:
            this(r2, r3, r4, r8);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public int getState() {
            return this.state;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public Queueing(TaskId r7, TaskInfo r8, int r9, Map<String, String> r10) {
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

    /* JADX INFO: compiled from: ComplexTaskState.kt */
    public static final class TTS extends ComplexTaskState {
        public static final Parcelable.Creator<TTS> CREATOR = null;
        private final Map<String, String> extra;
        private final int state;
        private final TaskId taskId;
        private final TaskInfo taskInfo;

        /* JADX INFO: compiled from: ComplexTaskState.kt */
        public static final class Creator implements Parcelable.Creator<TTS> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TTS createFromParcel(Parcel r9) {
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
                return new TTS(r8, r1, r2, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
            L5:
                r0 = TaskInfo.CREATOR.createFromParcel(r9);
                goto L6
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TTS createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TTS[] newArray(int r1) {
                return new TTS[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TTS[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ TTS copy$default(TTS r1, TaskId r2, TaskInfo r3, int r4, Map r5, int r6, Object r7) {
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

        public final TTS copy(TaskId r2, TaskInfo r3, int r4, Map<String, String> r5) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new TTS(r2, r3, r4, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, TTS.class) == true) goto L8;
            return false;
        L8:
            TTS r6 = (TTS) ZeusTransformUtils.preCheckCast(r5, TTS.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_TTS";
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
        public boolean isCompletedOrCanceled() {
            return false;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State
        public boolean isIdle() {
            return false;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State
        public String toString() {
            return "TTS(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", state=" + this.state + ", extra=" + this.extra + ')';
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

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public TaskId getTaskId() {
            return this.taskId;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState
        public TaskInfo getTaskInfo() {
            return this.taskInfo;
        }

        public /* synthetic */ TTS(TaskId r2, TaskInfo r3, int r4, Map r5, int r6, h r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = DMConstData.a.j.ordinal();
        L9:
            if ((r6 & 8) == 0) goto L11;
            r8 = ao.b();
        L11:
            this(r2, r3, r4, r8);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public int getState() {
            return this.state;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public TTS(TaskId r7, TaskInfo r8, int r9, Map<String, String> r10) {
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

    /* JADX INFO: compiled from: ComplexTaskState.kt */
    public static final class TakingOver extends ComplexTaskState {
        public static final Parcelable.Creator<TakingOver> CREATOR = null;
        private final Map<String, String> extra;
        private final int state;
        private final TaskId taskId;
        private final TaskInfo taskInfo;

        /* JADX INFO: compiled from: ComplexTaskState.kt */
        public static final class Creator implements Parcelable.Creator<TakingOver> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TakingOver createFromParcel(Parcel r9) {
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
                return new TakingOver(r8, r1, r2, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
            L5:
                r0 = TaskInfo.CREATOR.createFromParcel(r9);
                goto L6
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TakingOver createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TakingOver[] newArray(int r1) {
                return new TakingOver[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TakingOver[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ TakingOver copy$default(TakingOver r1, TaskId r2, TaskInfo r3, int r4, Map r5, int r6, Object r7) {
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

        public final TakingOver copy(TaskId r2, TaskInfo r3, int r4, Map<String, String> r5) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new TakingOver(r2, r3, r4, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, TakingOver.class) == true) goto L8;
            return false;
        L8:
            TakingOver r6 = (TakingOver) ZeusTransformUtils.preCheckCast(r5, TakingOver.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_TakingOver";
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
            return "TakingOver(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", state=" + this.state + ", extra=" + this.extra + ')';
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

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public TaskId getTaskId() {
            return this.taskId;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState
        public TaskInfo getTaskInfo() {
            return this.taskInfo;
        }

        public /* synthetic */ TakingOver(TaskId r2, TaskInfo r3, int r4, Map r5, int r6, h r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = DMConstData.a.g.ordinal();
        L9:
            if ((r6 & 8) == 0) goto L11;
            r8 = ao.b();
        L11:
            this(r2, r3, r4, r8);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public int getState() {
            return this.state;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public TakingOver(TaskId r7, TaskInfo r8, int r9, Map<String, String> r10) {
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

    /* JADX INFO: compiled from: ComplexTaskState.kt */
    public static final class Terminated extends ComplexTaskState {
        public static final Parcelable.Creator<Terminated> CREATOR = null;
        private final Map<String, String> extra;
        private final int state;
        private final TaskId taskId;
        private final TaskInfo taskInfo;

        /* JADX INFO: compiled from: ComplexTaskState.kt */
        public static final class Creator implements Parcelable.Creator<Terminated> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Terminated createFromParcel(Parcel r9) {
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
                return new Terminated(r8, r1, r2, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
            L5:
                r0 = TaskInfo.CREATOR.createFromParcel(r9);
                goto L6
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Terminated createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Terminated[] newArray(int r1) {
                return new Terminated[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Terminated[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ Terminated copy$default(Terminated r1, TaskId r2, TaskInfo r3, int r4, Map r5, int r6, Object r7) {
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

        public final Terminated copy(TaskId r2, TaskInfo r3, int r4, Map<String, String> r5) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new Terminated(r2, r3, r4, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, Terminated.class) == true) goto L8;
            return false;
        L8:
            Terminated r6 = (Terminated) ZeusTransformUtils.preCheckCast(r5, Terminated.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_Terminated";
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
        public boolean isCompletedOrCanceled() {
            return true;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State
        public boolean isIdle() {
            return false;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.State
        public String toString() {
            return "Terminated(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", state=" + this.state + ", extra=" + this.extra + ')';
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

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public TaskId getTaskId() {
            return this.taskId;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState
        public TaskInfo getTaskInfo() {
            return this.taskInfo;
        }

        public /* synthetic */ Terminated(TaskId r2, TaskInfo r3, int r4, Map r5, int r6, h r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = DMConstData.a.i.ordinal();
        L9:
            if ((r6 & 8) == 0) goto L11;
            r8 = ao.b();
        L11:
            this(r2, r3, r4, r8);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public int getState() {
            return this.state;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public Terminated(TaskId r7, TaskInfo r8, int r9, Map<String, String> r10) {
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

    /* JADX INFO: compiled from: ComplexTaskState.kt */
    public static final class Thinking extends ComplexTaskState {
        public static final Parcelable.Creator<Thinking> CREATOR = null;
        private final Map<String, String> extra;
        private final int state;
        private final TaskId taskId;
        private final TaskInfo taskInfo;

        /* JADX INFO: compiled from: ComplexTaskState.kt */
        public static final class Creator implements Parcelable.Creator<Thinking> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Thinking createFromParcel(Parcel r9) {
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
                return new Thinking(r8, r1, r2, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
            L5:
                r0 = TaskInfo.CREATOR.createFromParcel(r9);
                goto L6
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Thinking createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Thinking[] newArray(int r1) {
                return new Thinking[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Thinking[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ Thinking copy$default(Thinking r1, TaskId r2, TaskInfo r3, int r4, Map r5, int r6, Object r7) {
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

        public final Thinking copy(TaskId r2, TaskInfo r3, int r4, Map<String, String> r5) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new Thinking(r2, r3, r4, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, Thinking.class) == true) goto L8;
            return false;
        L8:
            Thinking r6 = (Thinking) ZeusTransformUtils.preCheckCast(r5, Thinking.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_Thinking";
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
            return "Thinking(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", state=" + this.state + ", extra=" + this.extra + ')';
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

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public TaskId getTaskId() {
            return this.taskId;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState
        public TaskInfo getTaskInfo() {
            return this.taskInfo;
        }

        public /* synthetic */ Thinking(TaskId r2, TaskInfo r3, int r4, Map r5, int r6, h r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = DMConstData.a.f16245c.ordinal();
        L9:
            if ((r6 & 8) == 0) goto L11;
            r8 = ao.b();
        L11:
            this(r2, r3, r4, r8);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public int getState() {
            return this.state;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public Thinking(TaskId r7, TaskInfo r8, int r9, Map<String, String> r10) {
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

    /* JADX INFO: compiled from: ComplexTaskState.kt */
    public static final class ThinkingCompleted extends ComplexTaskState {
        public static final Parcelable.Creator<ThinkingCompleted> CREATOR = null;
        private final Map<String, String> extra;
        private final int state;
        private final TaskId taskId;
        private final TaskInfo taskInfo;

        /* JADX INFO: compiled from: ComplexTaskState.kt */
        public static final class Creator implements Parcelable.Creator<ThinkingCompleted> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ThinkingCompleted createFromParcel(Parcel r9) {
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
                return new ThinkingCompleted(r8, r1, r2, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
            L5:
                r0 = TaskInfo.CREATOR.createFromParcel(r9);
                goto L6
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ ThinkingCompleted createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ThinkingCompleted[] newArray(int r1) {
                return new ThinkingCompleted[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ ThinkingCompleted[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ ThinkingCompleted copy$default(ThinkingCompleted r1, TaskId r2, TaskInfo r3, int r4, Map r5, int r6, Object r7) {
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

        public final ThinkingCompleted copy(TaskId r2, TaskInfo r3, int r4, Map<String, String> r5) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new ThinkingCompleted(r2, r3, r4, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, ThinkingCompleted.class) == true) goto L8;
            return false;
        L8:
            ThinkingCompleted r6 = (ThinkingCompleted) ZeusTransformUtils.preCheckCast(r5, ThinkingCompleted.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_ThinkingCompleted";
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
            return "ThinkingCompleted(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", state=" + this.state + ", extra=" + this.extra + ')';
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

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public TaskId getTaskId() {
            return this.taskId;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState
        public TaskInfo getTaskInfo() {
            return this.taskInfo;
        }

        public /* synthetic */ ThinkingCompleted(TaskId r2, TaskInfo r3, int r4, Map r5, int r6, h r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = DMConstData.a.h.ordinal();
        L9:
            if ((r6 & 8) == 0) goto L11;
            r8 = ao.b();
        L11:
            this(r2, r3, r4, r8);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public int getState() {
            return this.state;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskState, com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public ThinkingCompleted(TaskId r7, TaskInfo r8, int r9, Map<String, String> r10) {
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

    public /* synthetic */ ComplexTaskState(TaskId r2, TaskInfo r3, int r4, Map r5, h r6) {
        this(r2, r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
    public TaskId getTaskId() {
        return this.taskId;
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.TaskState
    public TaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public /* synthetic */ ComplexTaskState(TaskId r8, TaskInfo r9, int r10, Map r11, int r12, h r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        TaskId r2 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        TaskInfo r3 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        r10 = DMConstData.a.f16243a.ordinal();
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

    @Override // com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
    public int getState() {
        return this.state;
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.TaskState, com.obric.assistant.dm.api.statemachine.core.State
    public Map<String, String> getExtra() {
        return this.extra;
    }

    private ComplexTaskState(TaskId r7, TaskInfo r8, int r9, Map<String, String> r10) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        super(r7, r8, r9, r11, null);
        this.taskId = r7;
        this.taskInfo = r8;
        this.state = r9;
        this.extra = r11;
    }
}
