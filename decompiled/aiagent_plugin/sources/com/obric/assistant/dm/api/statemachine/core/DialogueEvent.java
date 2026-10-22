package com.obric.assistant.dm.api.statemachine.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: DialogueEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DialogueEvent extends DMEvent {
    private final Map<String, String> extra;
    private final TaskId taskId;

    /* JADX INFO: compiled from: DialogueEvent.kt */
    public static final class TaskCompleted extends DialogueEvent {
        public static final Parcelable.Creator<TaskCompleted> CREATOR = null;
        private final Map<String, String> extra;
        private final TaskId taskId;

        /* JADX INFO: compiled from: DialogueEvent.kt */
        public static final class Creator implements Parcelable.Creator<TaskCompleted> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TaskCompleted createFromParcel(Parcel r7) {
                o.e(r7, "parcel");
                if (r7.readInt() != 0) goto L5;
                TaskId r6 = null;
            L6:
                TaskId r8 = (TaskId) ZeusTransformUtils.preCheckCast(r6, TaskId.class, "com.obric.aiagent.plugin");
                int r0 = r7.readInt();
                LinkedHashMap r2 = new LinkedHashMap(r0);
                int r3 = 0;
            L7:
                if (r3 == r0) goto L10;
                r2.put(r7.readString(), r7.readString());
                r3 = r3 + 1;
                goto L7
            L10:
                return new TaskCompleted(r8, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin"));
            L5:
                r6 = TaskId.CREATOR.createFromParcel(r7);
                goto L6
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TaskCompleted createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TaskCompleted[] newArray(int r1) {
                return new TaskCompleted[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TaskCompleted[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public TaskCompleted() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ TaskCompleted copy$default(TaskCompleted r1, TaskId r2, Map r3, int r4, Object r5) {
            Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r2 = r1.taskId;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r6 = r1.extra;
        L9:
            return r1.copy(r2, r6);
        }

        public final TaskId component1() {
            return this.taskId;
        }

        public final Map<String, String> component2() {
            return this.extra;
        }

        public final TaskCompleted copy(TaskId r2, Map<String, String> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            o.e(r1, "extra");
            return new TaskCompleted(r2, r1);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, TaskCompleted.class) == true) goto L8;
            return false;
        L8:
            TaskCompleted r6 = (TaskCompleted) ZeusTransformUtils.preCheckCast(r5, TaskCompleted.class, "com.obric.aiagent.plugin");
            if (o.a(this.taskId, r6.taskId) == true) goto L12;
            return false;
        L12:
            if (o.a(this.extra, r6.extra) == true) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String getEventName() {
            return "DialogueEvent_TaskCompleted";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public int hashCode() {
            TaskId r0 = this.taskId;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.extra.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String toString() {
            return "TaskCompleted(taskId=" + this.taskId + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            TaskId r0 = this.taskId;
            if (r0 != null) goto L5;
            r4.writeInt(0);
        L6:
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

        @Override // com.obric.assistant.dm.api.statemachine.core.DialogueEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public TaskId getTaskId() {
            return this.taskId;
        }

        public /* synthetic */ TaskCompleted(TaskId r2, Map r3, int r4, h r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r6 = ao.b();
        L8:
            this(r2, r6);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DialogueEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public TaskCompleted(TaskId r3, Map<String, String> r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            o.e(r5, "extra");
            super(r3, r5, null);
            this.taskId = r3;
            this.extra = r5;
        }
    }

    /* JADX INFO: compiled from: DialogueEvent.kt */
    public static final class UserQuery extends DialogueEvent {
        public static final Parcelable.Creator<UserQuery> CREATOR = null;
        private final Map<String, String> extra;
        private final String query;
        private final TaskId taskId;

        /* JADX INFO: compiled from: DialogueEvent.kt */
        public static final class Creator implements Parcelable.Creator<UserQuery> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final UserQuery createFromParcel(Parcel r8) {
                o.e(r8, "parcel");
                String r7 = r8.readString();
                if (r8.readInt() != 0) goto L5;
                TaskId r0 = null;
            L6:
                TaskId r1 = (TaskId) ZeusTransformUtils.preCheckCast(r0, TaskId.class, "com.obric.aiagent.plugin");
                int r2 = r8.readInt();
                LinkedHashMap r3 = new LinkedHashMap(r2);
                int r4 = 0;
            L7:
                if (r4 == r2) goto L10;
                r3.put(r8.readString(), r8.readString());
                r4 = r4 + 1;
                goto L7
            L10:
                return new UserQuery(r7, r1, (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin"));
            L5:
                r0 = TaskId.CREATOR.createFromParcel(r8);
                goto L6
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ UserQuery createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final UserQuery[] newArray(int r1) {
                return new UserQuery[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ UserQuery[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ UserQuery copy$default(UserQuery r1, String r2, TaskId r3, Map r4, int r5, Object r6) {
            Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            if ((r5 & 1) == 0) goto L6;
            r2 = r1.query;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = r1.taskId;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r7 = r1.extra;
        L12:
            return r1.copy(r2, r3, r7);
        }

        public final String component1() {
            return this.query;
        }

        public final TaskId component2() {
            return this.taskId;
        }

        public final Map<String, String> component3() {
            return this.extra;
        }

        public final UserQuery copy(String r2, TaskId r3, Map<String, String> r4) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DownloadConstants.QUERY_KEY);
            o.e(r1, "extra");
            return new UserQuery(r2, r3, r1);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, UserQuery.class) == true) goto L8;
            return false;
        L8:
            UserQuery r6 = (UserQuery) ZeusTransformUtils.preCheckCast(r5, UserQuery.class, "com.obric.aiagent.plugin");
            if (o.a(this.query, r6.query) == true) goto L12;
            return false;
        L12:
            if (o.a(this.taskId, r6.taskId) == true) goto L15;
            return false;
        L15:
            if (o.a(this.extra, r6.extra) == true) goto L17;
            return false;
        L17:
            return true;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String getEventName() {
            return "DialogueEvent_UserQuery";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public int hashCode() {
            int r0 = this.query.hashCode() * 31;
            TaskId r1 = this.taskId;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.extra.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String toString() {
            return "UserQuery(query=" + this.query + ", taskId=" + this.taskId + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            r4.writeString(this.query);
            TaskId r0 = this.taskId;
            if (r0 != null) goto L5;
            r4.writeInt(0);
        L6:
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

        public final String getQuery() {
            return this.query;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DialogueEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public TaskId getTaskId() {
            return this.taskId;
        }

        public /* synthetic */ UserQuery(String r2, TaskId r3, Map r4, int r5, h r6) {
            Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            if ((r5 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r7 = ao.b();
        L8:
            this(r2, r3, r7);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DialogueEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public UserQuery(String r3, TaskId r4, Map<String, String> r5) {
            Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r3, DownloadConstants.QUERY_KEY);
            o.e(r6, "extra");
            super(r4, r6, null);
            this.query = r3;
            this.taskId = r4;
            this.extra = r6;
        }
    }

    public /* synthetic */ DialogueEvent(TaskId r2, Map r3, h r4) {
        this(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
    public TaskId getTaskId() {
        return this.taskId;
    }

    public /* synthetic */ DialogueEvent(TaskId r2, Map r3, int r4, h r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        h r0 = null;
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = ao.b();
    L8:
        this(r2, r6, r0);
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
    public Map<String, String> getExtra() {
        return this.extra;
    }

    private DialogueEvent(TaskId r8, Map<String, String> r9) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        super(r8, r10, 0, 4, null);
        this.taskId = r8;
        this.extra = r10;
    }
}
