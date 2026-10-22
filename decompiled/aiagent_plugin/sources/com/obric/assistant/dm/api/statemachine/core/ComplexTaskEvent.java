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

/* JADX INFO: compiled from: ComplexTaskEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ComplexTaskEvent extends DMEvent {
    private final Map<String, String> extra;
    private final TaskId taskId;

    /* JADX INFO: compiled from: ComplexTaskEvent.kt */
    public static final class ContinueThinking extends ComplexTaskEvent {
        public static final Parcelable.Creator<ContinueThinking> CREATOR = null;
        private final Map<String, String> extra;
        private final TaskId taskId;

        /* JADX INFO: compiled from: ComplexTaskEvent.kt */
        public static final class Creator implements Parcelable.Creator<ContinueThinking> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ContinueThinking createFromParcel(Parcel r7) {
                o.e(r7, "parcel");
                TaskId r6 = (TaskId) ZeusTransformUtils.preCheckCast(TaskId.CREATOR.createFromParcel(r7), TaskId.class, "com.obric.aiagent.plugin");
                int r0 = r7.readInt();
                LinkedHashMap r2 = new LinkedHashMap(r0);
                int r3 = 0;
            L3:
                if (r3 == r0) goto L6;
                r2.put(r7.readString(), r7.readString());
                r3 = r3 + 1;
                goto L3
            L6:
                return new ContinueThinking(r6, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin"));
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ ContinueThinking createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ContinueThinking[] newArray(int r1) {
                return new ContinueThinking[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ ContinueThinking[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ ContinueThinking copy$default(ContinueThinking r1, TaskId r2, Map r3, int r4, Object r5) {
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

        public final ContinueThinking copy(TaskId r2, Map<String, String> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new ContinueThinking(r2, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, ContinueThinking.class) == true) goto L8;
            return false;
        L8:
            ContinueThinking r6 = (ContinueThinking) ZeusTransformUtils.preCheckCast(r5, ContinueThinking.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_ContinueThinking";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public int hashCode() {
            return (this.taskId.hashCode() * 31) + this.extra.hashCode();
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String toString() {
            return "ContinueThinking(taskId=" + this.taskId + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            this.taskId.writeToParcel(r4, r5);
            Map<String, String> r3 = this.extra;
            r4.writeInt(r3.size());
            Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<String, String> r7 = r6.next();
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L4
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public TaskId getTaskId() {
            return this.taskId;
        }

        public /* synthetic */ ContinueThinking(TaskId r2, Map r3, int r4, h r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r6 = ao.b();
        L5:
            this(r2, r6);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public ContinueThinking(TaskId r3, Map<String, String> r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            o.e(r3, DBDefinition.TASK_ID);
            o.e(r5, "extra");
            super(r3, r5, null);
            this.taskId = r3;
            this.extra = r5;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskEvent.kt */
    public static final class InterruptTask extends ComplexTaskEvent {
        public static final Parcelable.Creator<InterruptTask> CREATOR = null;
        private final Map<String, String> extra;
        private final TaskId taskId;

        /* JADX INFO: compiled from: ComplexTaskEvent.kt */
        public static final class Creator implements Parcelable.Creator<InterruptTask> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final InterruptTask createFromParcel(Parcel r7) {
                o.e(r7, "parcel");
                TaskId r6 = (TaskId) ZeusTransformUtils.preCheckCast(TaskId.CREATOR.createFromParcel(r7), TaskId.class, "com.obric.aiagent.plugin");
                int r0 = r7.readInt();
                LinkedHashMap r2 = new LinkedHashMap(r0);
                int r3 = 0;
            L3:
                if (r3 == r0) goto L6;
                r2.put(r7.readString(), r7.readString());
                r3 = r3 + 1;
                goto L3
            L6:
                return new InterruptTask(r6, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin"));
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ InterruptTask createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final InterruptTask[] newArray(int r1) {
                return new InterruptTask[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ InterruptTask[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ InterruptTask copy$default(InterruptTask r1, TaskId r2, Map r3, int r4, Object r5) {
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

        public final InterruptTask copy(TaskId r2, Map<String, String> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new InterruptTask(r2, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, InterruptTask.class) == true) goto L8;
            return false;
        L8:
            InterruptTask r6 = (InterruptTask) ZeusTransformUtils.preCheckCast(r5, InterruptTask.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_InterruptTask";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public int hashCode() {
            return (this.taskId.hashCode() * 31) + this.extra.hashCode();
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String toString() {
            return "InterruptTask(taskId=" + this.taskId + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            this.taskId.writeToParcel(r4, r5);
            Map<String, String> r3 = this.extra;
            r4.writeInt(r3.size());
            Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<String, String> r7 = r6.next();
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L4
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public TaskId getTaskId() {
            return this.taskId;
        }

        public /* synthetic */ InterruptTask(TaskId r2, Map r3, int r4, h r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r6 = ao.b();
        L5:
            this(r2, r6);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public InterruptTask(TaskId r3, Map<String, String> r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            o.e(r3, DBDefinition.TASK_ID);
            o.e(r5, "extra");
            super(r3, r5, null);
            this.taskId = r3;
            this.extra = r5;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskEvent.kt */
    public static final class PlayTTS extends ComplexTaskEvent {
        public static final Parcelable.Creator<PlayTTS> CREATOR = null;
        private final Map<String, String> extra;
        private final TaskId taskId;

        /* JADX INFO: compiled from: ComplexTaskEvent.kt */
        public static final class Creator implements Parcelable.Creator<PlayTTS> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PlayTTS createFromParcel(Parcel r7) {
                o.e(r7, "parcel");
                TaskId r6 = (TaskId) ZeusTransformUtils.preCheckCast(TaskId.CREATOR.createFromParcel(r7), TaskId.class, "com.obric.aiagent.plugin");
                int r0 = r7.readInt();
                LinkedHashMap r2 = new LinkedHashMap(r0);
                int r3 = 0;
            L3:
                if (r3 == r0) goto L6;
                r2.put(r7.readString(), r7.readString());
                r3 = r3 + 1;
                goto L3
            L6:
                return new PlayTTS(r6, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin"));
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ PlayTTS createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PlayTTS[] newArray(int r1) {
                return new PlayTTS[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ PlayTTS[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ PlayTTS copy$default(PlayTTS r1, TaskId r2, Map r3, int r4, Object r5) {
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

        public final PlayTTS copy(TaskId r2, Map<String, String> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new PlayTTS(r2, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, PlayTTS.class) == true) goto L8;
            return false;
        L8:
            PlayTTS r6 = (PlayTTS) ZeusTransformUtils.preCheckCast(r5, PlayTTS.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_PlayTTS";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public int hashCode() {
            return (this.taskId.hashCode() * 31) + this.extra.hashCode();
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String toString() {
            return "PlayTTS(taskId=" + this.taskId + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            this.taskId.writeToParcel(r4, r5);
            Map<String, String> r3 = this.extra;
            r4.writeInt(r3.size());
            Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<String, String> r7 = r6.next();
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L4
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public TaskId getTaskId() {
            return this.taskId;
        }

        public /* synthetic */ PlayTTS(TaskId r2, Map r3, int r4, h r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r6 = ao.b();
        L5:
            this(r2, r6);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public PlayTTS(TaskId r3, Map<String, String> r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            o.e(r3, DBDefinition.TASK_ID);
            o.e(r5, "extra");
            super(r3, r5, null);
            this.taskId = r3;
            this.extra = r5;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskEvent.kt */
    public static final class RecieveComplexClarify extends ComplexTaskEvent {
        public static final Parcelable.Creator<RecieveComplexClarify> CREATOR = null;
        private final Map<String, String> extra;
        private final TaskId taskId;

        /* JADX INFO: compiled from: ComplexTaskEvent.kt */
        public static final class Creator implements Parcelable.Creator<RecieveComplexClarify> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final RecieveComplexClarify createFromParcel(Parcel r7) {
                o.e(r7, "parcel");
                TaskId r6 = (TaskId) ZeusTransformUtils.preCheckCast(TaskId.CREATOR.createFromParcel(r7), TaskId.class, "com.obric.aiagent.plugin");
                int r0 = r7.readInt();
                LinkedHashMap r2 = new LinkedHashMap(r0);
                int r3 = 0;
            L3:
                if (r3 == r0) goto L6;
                r2.put(r7.readString(), r7.readString());
                r3 = r3 + 1;
                goto L3
            L6:
                return new RecieveComplexClarify(r6, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin"));
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ RecieveComplexClarify createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final RecieveComplexClarify[] newArray(int r1) {
                return new RecieveComplexClarify[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ RecieveComplexClarify[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ RecieveComplexClarify copy$default(RecieveComplexClarify r1, TaskId r2, Map r3, int r4, Object r5) {
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

        public final RecieveComplexClarify copy(TaskId r2, Map<String, String> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new RecieveComplexClarify(r2, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, RecieveComplexClarify.class) == true) goto L8;
            return false;
        L8:
            RecieveComplexClarify r6 = (RecieveComplexClarify) ZeusTransformUtils.preCheckCast(r5, RecieveComplexClarify.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_ReceiveAnswer";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public int hashCode() {
            return (this.taskId.hashCode() * 31) + this.extra.hashCode();
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String toString() {
            return "RecieveComplexClarify(taskId=" + this.taskId + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            this.taskId.writeToParcel(r4, r5);
            Map<String, String> r3 = this.extra;
            r4.writeInt(r3.size());
            Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<String, String> r7 = r6.next();
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L4
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public TaskId getTaskId() {
            return this.taskId;
        }

        public /* synthetic */ RecieveComplexClarify(TaskId r2, Map r3, int r4, h r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r6 = ao.b();
        L5:
            this(r2, r6);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public RecieveComplexClarify(TaskId r3, Map<String, String> r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            o.e(r3, DBDefinition.TASK_ID);
            o.e(r5, "extra");
            super(r3, r5, null);
            this.taskId = r3;
            this.extra = r5;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskEvent.kt */
    public static final class StartTask extends ComplexTaskEvent {
        public static final Parcelable.Creator<StartTask> CREATOR = null;
        private final Map<String, String> extra;
        private final TaskId taskId;
        private final TaskInfo taskInfo;

        /* JADX INFO: compiled from: ComplexTaskEvent.kt */
        public static final class Creator implements Parcelable.Creator<StartTask> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final StartTask createFromParcel(Parcel r8) {
                o.e(r8, "parcel");
                TaskId r7 = (TaskId) ZeusTransformUtils.preCheckCast(TaskId.CREATOR.createFromParcel(r8), TaskId.class, "com.obric.aiagent.plugin");
                if (r8.readInt() != 0) goto L5;
                TaskInfo r0 = null;
            L6:
                TaskInfo r1 = (TaskInfo) ZeusTransformUtils.preCheckCast(r0, TaskInfo.class, "com.obric.aiagent.plugin");
                int r2 = r8.readInt();
                LinkedHashMap r3 = new LinkedHashMap(r2);
                int r4 = 0;
            L7:
                if (r4 == r2) goto L10;
                r3.put(r8.readString(), r8.readString());
                r4 = r4 + 1;
                goto L7
            L10:
                return new StartTask(r7, r1, (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin"));
            L5:
                r0 = TaskInfo.CREATOR.createFromParcel(r8);
                goto L6
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ StartTask createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final StartTask[] newArray(int r1) {
                return new StartTask[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ StartTask[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        private final TaskInfo component2() {
            return this.taskInfo;
        }

        public static /* synthetic */ StartTask copy$default(StartTask r1, TaskId r2, TaskInfo r3, Map r4, int r5, Object r6) {
            Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            if ((r5 & 1) == 0) goto L6;
            r2 = r1.taskId;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = r1.taskInfo;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r7 = r1.extra;
        L12:
            return r1.copy(r2, r3, r7);
        }

        public final TaskId component1() {
            return this.taskId;
        }

        public final Map<String, String> component3() {
            return this.extra;
        }

        public final StartTask copy(TaskId r2, TaskInfo r3, Map<String, String> r4) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new StartTask(r2, r3, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, StartTask.class) == true) goto L8;
            return false;
        L8:
            StartTask r6 = (StartTask) ZeusTransformUtils.preCheckCast(r5, StartTask.class, "com.obric.aiagent.plugin");
            if (o.a(this.taskId, r6.taskId) == true) goto L12;
            return false;
        L12:
            if (o.a(this.taskInfo, r6.taskInfo) == true) goto L15;
            return false;
        L15:
            if (o.a(this.extra, r6.extra) == true) goto L17;
            return false;
        L17:
            return true;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String getEventName() {
            return "ComplexTask_StartTask";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public int hashCode() {
            int r0 = this.taskId.hashCode() * 31;
            TaskInfo r1 = this.taskInfo;
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
            return "StartTask(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            this.taskId.writeToParcel(r4, r5);
            TaskInfo r0 = this.taskInfo;
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

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public TaskId getTaskId() {
            return this.taskId;
        }

        public /* synthetic */ StartTask(TaskId r2, TaskInfo r3, Map r4, int r5, h r6) {
            Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            if ((r5 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r7 = ao.b();
        L8:
            this(r2, r3, r7);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public StartTask(TaskId r3, TaskInfo r4, Map<String, String> r5) {
            Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r3, DBDefinition.TASK_ID);
            o.e(r6, "extra");
            super(r3, r6, null);
            this.taskId = r3;
            this.taskInfo = r4;
            this.extra = r6;
        }

        public final TaskInfo getTaskInfo() {
            return this.taskInfo;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskEvent.kt */
    public static final class TaskCompleted extends ComplexTaskEvent {
        public static final Parcelable.Creator<TaskCompleted> CREATOR = null;
        private final Map<String, String> extra;
        private final TaskId taskId;

        /* JADX INFO: compiled from: ComplexTaskEvent.kt */
        public static final class Creator implements Parcelable.Creator<TaskCompleted> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TaskCompleted createFromParcel(Parcel r7) {
                o.e(r7, "parcel");
                TaskId r6 = (TaskId) ZeusTransformUtils.preCheckCast(TaskId.CREATOR.createFromParcel(r7), TaskId.class, "com.obric.aiagent.plugin");
                int r0 = r7.readInt();
                LinkedHashMap r2 = new LinkedHashMap(r0);
                int r3 = 0;
            L3:
                if (r3 == r0) goto L6;
                r2.put(r7.readString(), r7.readString());
                r3 = r3 + 1;
                goto L3
            L6:
                return new TaskCompleted(r6, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin"));
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
            o.e(r2, DBDefinition.TASK_ID);
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
            return "ComplexTask_TaskCompleted";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public int hashCode() {
            return (this.taskId.hashCode() * 31) + this.extra.hashCode();
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String toString() {
            return "TaskCompleted(taskId=" + this.taskId + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            this.taskId.writeToParcel(r4, r5);
            Map<String, String> r3 = this.extra;
            r4.writeInt(r3.size());
            Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<String, String> r7 = r6.next();
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L4
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public TaskId getTaskId() {
            return this.taskId;
        }

        public /* synthetic */ TaskCompleted(TaskId r2, Map r3, int r4, h r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r6 = ao.b();
        L5:
            this(r2, r6);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public TaskCompleted(TaskId r3, Map<String, String> r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            o.e(r3, DBDefinition.TASK_ID);
            o.e(r5, "extra");
            super(r3, r5, null);
            this.taskId = r3;
            this.extra = r5;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskEvent.kt */
    public static final class ThinkingCompleted extends ComplexTaskEvent {
        public static final Parcelable.Creator<ThinkingCompleted> CREATOR = null;
        private final Map<String, String> extra;
        private final TaskId taskId;

        /* JADX INFO: compiled from: ComplexTaskEvent.kt */
        public static final class Creator implements Parcelable.Creator<ThinkingCompleted> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ThinkingCompleted createFromParcel(Parcel r7) {
                o.e(r7, "parcel");
                TaskId r6 = (TaskId) ZeusTransformUtils.preCheckCast(TaskId.CREATOR.createFromParcel(r7), TaskId.class, "com.obric.aiagent.plugin");
                int r0 = r7.readInt();
                LinkedHashMap r2 = new LinkedHashMap(r0);
                int r3 = 0;
            L3:
                if (r3 == r0) goto L6;
                r2.put(r7.readString(), r7.readString());
                r3 = r3 + 1;
                goto L3
            L6:
                return new ThinkingCompleted(r6, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin"));
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

        public static /* synthetic */ ThinkingCompleted copy$default(ThinkingCompleted r1, TaskId r2, Map r3, int r4, Object r5) {
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

        public final ThinkingCompleted copy(TaskId r2, Map<String, String> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new ThinkingCompleted(r2, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, ThinkingCompleted.class) == true) goto L8;
            return false;
        L8:
            ThinkingCompleted r6 = (ThinkingCompleted) ZeusTransformUtils.preCheckCast(r5, ThinkingCompleted.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_ThinkingCompleted";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public int hashCode() {
            return (this.taskId.hashCode() * 31) + this.extra.hashCode();
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String toString() {
            return "ThinkingCompleted(taskId=" + this.taskId + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            this.taskId.writeToParcel(r4, r5);
            Map<String, String> r3 = this.extra;
            r4.writeInt(r3.size());
            Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<String, String> r7 = r6.next();
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L4
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public TaskId getTaskId() {
            return this.taskId;
        }

        public /* synthetic */ ThinkingCompleted(TaskId r2, Map r3, int r4, h r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r6 = ao.b();
        L5:
            this(r2, r6);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public ThinkingCompleted(TaskId r3, Map<String, String> r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            o.e(r3, DBDefinition.TASK_ID);
            o.e(r5, "extra");
            super(r3, r5, null);
            this.taskId = r3;
            this.extra = r5;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskEvent.kt */
    public static final class TriggerComplexCalluser extends ComplexTaskEvent {
        public static final Parcelable.Creator<TriggerComplexCalluser> CREATOR = null;
        private final Map<String, String> extra;
        private final TaskId taskId;

        /* JADX INFO: compiled from: ComplexTaskEvent.kt */
        public static final class Creator implements Parcelable.Creator<TriggerComplexCalluser> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TriggerComplexCalluser createFromParcel(Parcel r7) {
                o.e(r7, "parcel");
                TaskId r6 = (TaskId) ZeusTransformUtils.preCheckCast(TaskId.CREATOR.createFromParcel(r7), TaskId.class, "com.obric.aiagent.plugin");
                int r0 = r7.readInt();
                LinkedHashMap r2 = new LinkedHashMap(r0);
                int r3 = 0;
            L3:
                if (r3 == r0) goto L6;
                r2.put(r7.readString(), r7.readString());
                r3 = r3 + 1;
                goto L3
            L6:
                return new TriggerComplexCalluser(r6, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin"));
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TriggerComplexCalluser createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TriggerComplexCalluser[] newArray(int r1) {
                return new TriggerComplexCalluser[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TriggerComplexCalluser[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ TriggerComplexCalluser copy$default(TriggerComplexCalluser r1, TaskId r2, Map r3, int r4, Object r5) {
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

        public final TriggerComplexCalluser copy(TaskId r2, Map<String, String> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new TriggerComplexCalluser(r2, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, TriggerComplexCalluser.class) == true) goto L8;
            return false;
        L8:
            TriggerComplexCalluser r6 = (TriggerComplexCalluser) ZeusTransformUtils.preCheckCast(r5, TriggerComplexCalluser.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_CallUser";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public int hashCode() {
            return (this.taskId.hashCode() * 31) + this.extra.hashCode();
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String toString() {
            return "TriggerComplexCalluser(taskId=" + this.taskId + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            this.taskId.writeToParcel(r4, r5);
            Map<String, String> r3 = this.extra;
            r4.writeInt(r3.size());
            Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<String, String> r7 = r6.next();
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L4
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public TaskId getTaskId() {
            return this.taskId;
        }

        public /* synthetic */ TriggerComplexCalluser(TaskId r2, Map r3, int r4, h r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r6 = ao.b();
        L5:
            this(r2, r6);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public TriggerComplexCalluser(TaskId r3, Map<String, String> r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            o.e(r3, DBDefinition.TASK_ID);
            o.e(r5, "extra");
            super(r3, r5, null);
            this.taskId = r3;
            this.extra = r5;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskEvent.kt */
    public static final class TriggerComplexClarify extends ComplexTaskEvent {
        public static final Parcelable.Creator<TriggerComplexClarify> CREATOR = null;
        private final Map<String, String> extra;
        private final TaskId taskId;

        /* JADX INFO: compiled from: ComplexTaskEvent.kt */
        public static final class Creator implements Parcelable.Creator<TriggerComplexClarify> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TriggerComplexClarify createFromParcel(Parcel r7) {
                o.e(r7, "parcel");
                TaskId r6 = (TaskId) ZeusTransformUtils.preCheckCast(TaskId.CREATOR.createFromParcel(r7), TaskId.class, "com.obric.aiagent.plugin");
                int r0 = r7.readInt();
                LinkedHashMap r2 = new LinkedHashMap(r0);
                int r3 = 0;
            L3:
                if (r3 == r0) goto L6;
                r2.put(r7.readString(), r7.readString());
                r3 = r3 + 1;
                goto L3
            L6:
                return new TriggerComplexClarify(r6, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin"));
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TriggerComplexClarify createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TriggerComplexClarify[] newArray(int r1) {
                return new TriggerComplexClarify[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TriggerComplexClarify[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ TriggerComplexClarify copy$default(TriggerComplexClarify r1, TaskId r2, Map r3, int r4, Object r5) {
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

        public final TriggerComplexClarify copy(TaskId r2, Map<String, String> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new TriggerComplexClarify(r2, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, TriggerComplexClarify.class) == true) goto L8;
            return false;
        L8:
            TriggerComplexClarify r6 = (TriggerComplexClarify) ZeusTransformUtils.preCheckCast(r5, TriggerComplexClarify.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_TriggerQuestion";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public int hashCode() {
            return (this.taskId.hashCode() * 31) + this.extra.hashCode();
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String toString() {
            return "TriggerComplexClarify(taskId=" + this.taskId + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            this.taskId.writeToParcel(r4, r5);
            Map<String, String> r3 = this.extra;
            r4.writeInt(r3.size());
            Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<String, String> r7 = r6.next();
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L4
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public TaskId getTaskId() {
            return this.taskId;
        }

        public /* synthetic */ TriggerComplexClarify(TaskId r2, Map r3, int r4, h r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r6 = ao.b();
        L5:
            this(r2, r6);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public TriggerComplexClarify(TaskId r3, Map<String, String> r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            o.e(r3, DBDefinition.TASK_ID);
            o.e(r5, "extra");
            super(r3, r5, null);
            this.taskId = r3;
            this.extra = r5;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskEvent.kt */
    public static final class TriggerComplexQueueing extends ComplexTaskEvent {
        public static final Parcelable.Creator<TriggerComplexQueueing> CREATOR = null;
        private final Map<String, String> extra;
        private final TaskId taskId;

        /* JADX INFO: compiled from: ComplexTaskEvent.kt */
        public static final class Creator implements Parcelable.Creator<TriggerComplexQueueing> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TriggerComplexQueueing createFromParcel(Parcel r7) {
                o.e(r7, "parcel");
                TaskId r6 = (TaskId) ZeusTransformUtils.preCheckCast(TaskId.CREATOR.createFromParcel(r7), TaskId.class, "com.obric.aiagent.plugin");
                int r0 = r7.readInt();
                LinkedHashMap r2 = new LinkedHashMap(r0);
                int r3 = 0;
            L3:
                if (r3 == r0) goto L6;
                r2.put(r7.readString(), r7.readString());
                r3 = r3 + 1;
                goto L3
            L6:
                return new TriggerComplexQueueing(r6, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin"));
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TriggerComplexQueueing createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TriggerComplexQueueing[] newArray(int r1) {
                return new TriggerComplexQueueing[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TriggerComplexQueueing[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ TriggerComplexQueueing copy$default(TriggerComplexQueueing r1, TaskId r2, Map r3, int r4, Object r5) {
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

        public final TriggerComplexQueueing copy(TaskId r2, Map<String, String> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new TriggerComplexQueueing(r2, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, TriggerComplexQueueing.class) == true) goto L8;
            return false;
        L8:
            TriggerComplexQueueing r6 = (TriggerComplexQueueing) ZeusTransformUtils.preCheckCast(r5, TriggerComplexQueueing.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_TaskQueue";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public int hashCode() {
            return (this.taskId.hashCode() * 31) + this.extra.hashCode();
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String toString() {
            return "TriggerComplexQueueing(taskId=" + this.taskId + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            this.taskId.writeToParcel(r4, r5);
            Map<String, String> r3 = this.extra;
            r4.writeInt(r3.size());
            Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<String, String> r7 = r6.next();
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L4
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public TaskId getTaskId() {
            return this.taskId;
        }

        public /* synthetic */ TriggerComplexQueueing(TaskId r2, Map r3, int r4, h r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r6 = ao.b();
        L5:
            this(r2, r6);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public TriggerComplexQueueing(TaskId r3, Map<String, String> r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            o.e(r3, DBDefinition.TASK_ID);
            o.e(r5, "extra");
            super(r3, r5, null);
            this.taskId = r3;
            this.extra = r5;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskEvent.kt */
    public static final class TriggerComplexTakingOver extends ComplexTaskEvent {
        public static final Parcelable.Creator<TriggerComplexTakingOver> CREATOR = null;
        private final Map<String, String> extra;
        private final TaskId taskId;

        /* JADX INFO: compiled from: ComplexTaskEvent.kt */
        public static final class Creator implements Parcelable.Creator<TriggerComplexTakingOver> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TriggerComplexTakingOver createFromParcel(Parcel r7) {
                o.e(r7, "parcel");
                TaskId r6 = (TaskId) ZeusTransformUtils.preCheckCast(TaskId.CREATOR.createFromParcel(r7), TaskId.class, "com.obric.aiagent.plugin");
                int r0 = r7.readInt();
                LinkedHashMap r2 = new LinkedHashMap(r0);
                int r3 = 0;
            L3:
                if (r3 == r0) goto L6;
                r2.put(r7.readString(), r7.readString());
                r3 = r3 + 1;
                goto L3
            L6:
                return new TriggerComplexTakingOver(r6, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin"));
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TriggerComplexTakingOver createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TriggerComplexTakingOver[] newArray(int r1) {
                return new TriggerComplexTakingOver[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TriggerComplexTakingOver[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ TriggerComplexTakingOver copy$default(TriggerComplexTakingOver r1, TaskId r2, Map r3, int r4, Object r5) {
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

        public final TriggerComplexTakingOver copy(TaskId r2, Map<String, String> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new TriggerComplexTakingOver(r2, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, TriggerComplexTakingOver.class) == true) goto L8;
            return false;
        L8:
            TriggerComplexTakingOver r6 = (TriggerComplexTakingOver) ZeusTransformUtils.preCheckCast(r5, TriggerComplexTakingOver.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_TriggerTakingOver";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public int hashCode() {
            return (this.taskId.hashCode() * 31) + this.extra.hashCode();
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String toString() {
            return "TriggerComplexTakingOver(taskId=" + this.taskId + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            this.taskId.writeToParcel(r4, r5);
            Map<String, String> r3 = this.extra;
            r4.writeInt(r3.size());
            Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<String, String> r7 = r6.next();
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L4
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public TaskId getTaskId() {
            return this.taskId;
        }

        public /* synthetic */ TriggerComplexTakingOver(TaskId r2, Map r3, int r4, h r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r6 = ao.b();
        L5:
            this(r2, r6);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public TriggerComplexTakingOver(TaskId r3, Map<String, String> r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            o.e(r3, DBDefinition.TASK_ID);
            o.e(r5, "extra");
            super(r3, r5, null);
            this.taskId = r3;
            this.extra = r5;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskEvent.kt */
    public static final class TriggerComplexThinking extends ComplexTaskEvent {
        public static final Parcelable.Creator<TriggerComplexThinking> CREATOR = null;
        private final Map<String, String> extra;
        private final TaskId taskId;

        /* JADX INFO: compiled from: ComplexTaskEvent.kt */
        public static final class Creator implements Parcelable.Creator<TriggerComplexThinking> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TriggerComplexThinking createFromParcel(Parcel r7) {
                o.e(r7, "parcel");
                TaskId r6 = (TaskId) ZeusTransformUtils.preCheckCast(TaskId.CREATOR.createFromParcel(r7), TaskId.class, "com.obric.aiagent.plugin");
                int r0 = r7.readInt();
                LinkedHashMap r2 = new LinkedHashMap(r0);
                int r3 = 0;
            L3:
                if (r3 == r0) goto L6;
                r2.put(r7.readString(), r7.readString());
                r3 = r3 + 1;
                goto L3
            L6:
                return new TriggerComplexThinking(r6, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin"));
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TriggerComplexThinking createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TriggerComplexThinking[] newArray(int r1) {
                return new TriggerComplexThinking[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ TriggerComplexThinking[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ TriggerComplexThinking copy$default(TriggerComplexThinking r1, TaskId r2, Map r3, int r4, Object r5) {
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

        public final TriggerComplexThinking copy(TaskId r2, Map<String, String> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r1, "extra");
            return new TriggerComplexThinking(r2, r1);
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
            if (ZeusTransformUtils.instanceOf(r5, TriggerComplexThinking.class) == true) goto L8;
            return false;
        L8:
            TriggerComplexThinking r6 = (TriggerComplexThinking) ZeusTransformUtils.preCheckCast(r5, TriggerComplexThinking.class, "com.obric.aiagent.plugin");
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
            return "ComplexTask_QueueToThinking";
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public int hashCode() {
            return (this.taskId.hashCode() * 31) + this.extra.hashCode();
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
        public String toString() {
            return "TriggerComplexThinking(taskId=" + this.taskId + ", extra=" + this.extra + ')';
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent, android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            o.e(r4, "dest");
            this.taskId.writeToParcel(r4, r5);
            Map<String, String> r3 = this.extra;
            r4.writeInt(r3.size());
            Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<String, String> r7 = r6.next();
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
            goto L4
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public TaskId getTaskId() {
            return this.taskId;
        }

        public /* synthetic */ TriggerComplexThinking(TaskId r2, Map r3, int r4, h r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r6 = ao.b();
        L5:
            this(r2, r6);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent, com.obric.assistant.dm.api.statemachine.core.DMEvent
        public Map<String, String> getExtra() {
            return this.extra;
        }

        public TriggerComplexThinking(TaskId r3, Map<String, String> r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            o.e(r3, DBDefinition.TASK_ID);
            o.e(r5, "extra");
            super(r3, r5, null);
            this.taskId = r3;
            this.extra = r5;
        }
    }

    public /* synthetic */ ComplexTaskEvent(TaskId r2, Map r3, h r4) {
        this(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.DMEvent
    public TaskId getTaskId() {
        return this.taskId;
    }

    public /* synthetic */ ComplexTaskEvent(TaskId r2, Map r3, int r4, h r5) {
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

    private ComplexTaskEvent(TaskId r8, Map<String, String> r9) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        super(r8, r10, 0, 4, null);
        this.taskId = r8;
        this.extra = r10;
    }
}
