package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u000e\u000f\u0010B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0001\u0003\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentbus/generated/TaskEvent;", "", AppAgent.CONSTRUCT, "()V", "seq", "", "getSeq", "()Ljava/lang/Long;", "ts", "getTs", "sessionKey", "", "getSessionKey", "()Ljava/lang/String;", "Created", "Updated", "Completed", "Lcom/stepos/agentbus/generated/TaskEvent$Completed;", "Lcom/stepos/agentbus/generated/TaskEvent$Created;", "Lcom/stepos/agentbus/generated/TaskEvent$Updated;", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class TaskEvent {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J<\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/stepos/agentbus/generated/TaskEvent$Completed;", "Lcom/stepos/agentbus/generated/TaskEvent;", "task", "Lcom/stepos/agentbus/generated/Task;", "seq", "", "ts", "sessionKey", "", AppAgent.CONSTRUCT, "(Lcom/stepos/agentbus/generated/Task;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getTask", "()Lcom/stepos/agentbus/generated/Task;", "getSeq", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTs", "getSessionKey", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Lcom/stepos/agentbus/generated/Task;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/stepos/agentbus/generated/TaskEvent$Completed;", "equals", "", "other", "", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Completed extends TaskEvent {
        private final Long seq;
        private final String sessionKey;
        private final Task task;
        private final Long ts;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Completed(Task task, Long l, Long l5, String str) {
            super(null);
            k.f(task, "task");
            this.task = task;
            this.seq = l;
            this.ts = l5;
            this.sessionKey = str;
        }

        public static /* synthetic */ Completed copy$default(Completed completed, Task task, Long l, Long l5, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                task = completed.task;
            }
            if ((i & 2) != 0) {
                l = completed.seq;
            }
            if ((i & 4) != 0) {
                l5 = completed.ts;
            }
            if ((i & 8) != 0) {
                str = completed.sessionKey;
            }
            return completed.copy(task, l, l5, str);
        }

        /* renamed from: component1, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getSeq() {
            return this.seq;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getTs() {
            return this.ts;
        }

        /* renamed from: component4, reason: from getter */
        public final String getSessionKey() {
            return this.sessionKey;
        }

        public final Completed copy(Task task, Long seq, Long ts, String sessionKey) {
            k.f(task, "task");
            return new Completed(task, seq, ts, sessionKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Completed)) {
                return false;
            }
            Completed completed = (Completed) other;
            return k.b(this.task, completed.task) && k.b(this.seq, completed.seq) && k.b(this.ts, completed.ts) && k.b(this.sessionKey, completed.sessionKey);
        }

        @Override // com.stepos.agentbus.generated.TaskEvent
        public Long getSeq() {
            return this.seq;
        }

        @Override // com.stepos.agentbus.generated.TaskEvent
        public String getSessionKey() {
            return this.sessionKey;
        }

        public final Task getTask() {
            return this.task;
        }

        @Override // com.stepos.agentbus.generated.TaskEvent
        public Long getTs() {
            return this.ts;
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Long l = this.seq;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l5 = this.ts;
            int iHashCode3 = (iHashCode2 + (l5 == null ? 0 : l5.hashCode())) * 31;
            String str = this.sessionKey;
            return iHashCode3 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Completed(task=" + this.task + ", seq=" + this.seq + ", ts=" + this.ts + ", sessionKey=" + this.sessionKey + ")";
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J<\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/stepos/agentbus/generated/TaskEvent$Created;", "Lcom/stepos/agentbus/generated/TaskEvent;", "task", "Lcom/stepos/agentbus/generated/Task;", "seq", "", "ts", "sessionKey", "", AppAgent.CONSTRUCT, "(Lcom/stepos/agentbus/generated/Task;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getTask", "()Lcom/stepos/agentbus/generated/Task;", "getSeq", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTs", "getSessionKey", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Lcom/stepos/agentbus/generated/Task;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/stepos/agentbus/generated/TaskEvent$Created;", "equals", "", "other", "", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Created extends TaskEvent {
        private final Long seq;
        private final String sessionKey;
        private final Task task;
        private final Long ts;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Created(Task task, Long l, Long l5, String str) {
            super(null);
            k.f(task, "task");
            this.task = task;
            this.seq = l;
            this.ts = l5;
            this.sessionKey = str;
        }

        public static /* synthetic */ Created copy$default(Created created, Task task, Long l, Long l5, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                task = created.task;
            }
            if ((i & 2) != 0) {
                l = created.seq;
            }
            if ((i & 4) != 0) {
                l5 = created.ts;
            }
            if ((i & 8) != 0) {
                str = created.sessionKey;
            }
            return created.copy(task, l, l5, str);
        }

        /* renamed from: component1, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getSeq() {
            return this.seq;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getTs() {
            return this.ts;
        }

        /* renamed from: component4, reason: from getter */
        public final String getSessionKey() {
            return this.sessionKey;
        }

        public final Created copy(Task task, Long seq, Long ts, String sessionKey) {
            k.f(task, "task");
            return new Created(task, seq, ts, sessionKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Created)) {
                return false;
            }
            Created created = (Created) other;
            return k.b(this.task, created.task) && k.b(this.seq, created.seq) && k.b(this.ts, created.ts) && k.b(this.sessionKey, created.sessionKey);
        }

        @Override // com.stepos.agentbus.generated.TaskEvent
        public Long getSeq() {
            return this.seq;
        }

        @Override // com.stepos.agentbus.generated.TaskEvent
        public String getSessionKey() {
            return this.sessionKey;
        }

        public final Task getTask() {
            return this.task;
        }

        @Override // com.stepos.agentbus.generated.TaskEvent
        public Long getTs() {
            return this.ts;
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Long l = this.seq;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l5 = this.ts;
            int iHashCode3 = (iHashCode2 + (l5 == null ? 0 : l5.hashCode())) * 31;
            String str = this.sessionKey;
            return iHashCode3 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Created(task=" + this.task + ", seq=" + this.seq + ", ts=" + this.ts + ", sessionKey=" + this.sessionKey + ")";
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J<\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/stepos/agentbus/generated/TaskEvent$Updated;", "Lcom/stepos/agentbus/generated/TaskEvent;", "task", "Lcom/stepos/agentbus/generated/Task;", "seq", "", "ts", "sessionKey", "", AppAgent.CONSTRUCT, "(Lcom/stepos/agentbus/generated/Task;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getTask", "()Lcom/stepos/agentbus/generated/Task;", "getSeq", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTs", "getSessionKey", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Lcom/stepos/agentbus/generated/Task;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/stepos/agentbus/generated/TaskEvent$Updated;", "equals", "", "other", "", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Updated extends TaskEvent {
        private final Long seq;
        private final String sessionKey;
        private final Task task;
        private final Long ts;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Updated(Task task, Long l, Long l5, String str) {
            super(null);
            k.f(task, "task");
            this.task = task;
            this.seq = l;
            this.ts = l5;
            this.sessionKey = str;
        }

        public static /* synthetic */ Updated copy$default(Updated updated, Task task, Long l, Long l5, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                task = updated.task;
            }
            if ((i & 2) != 0) {
                l = updated.seq;
            }
            if ((i & 4) != 0) {
                l5 = updated.ts;
            }
            if ((i & 8) != 0) {
                str = updated.sessionKey;
            }
            return updated.copy(task, l, l5, str);
        }

        /* renamed from: component1, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getSeq() {
            return this.seq;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getTs() {
            return this.ts;
        }

        /* renamed from: component4, reason: from getter */
        public final String getSessionKey() {
            return this.sessionKey;
        }

        public final Updated copy(Task task, Long seq, Long ts, String sessionKey) {
            k.f(task, "task");
            return new Updated(task, seq, ts, sessionKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Updated)) {
                return false;
            }
            Updated updated = (Updated) other;
            return k.b(this.task, updated.task) && k.b(this.seq, updated.seq) && k.b(this.ts, updated.ts) && k.b(this.sessionKey, updated.sessionKey);
        }

        @Override // com.stepos.agentbus.generated.TaskEvent
        public Long getSeq() {
            return this.seq;
        }

        @Override // com.stepos.agentbus.generated.TaskEvent
        public String getSessionKey() {
            return this.sessionKey;
        }

        public final Task getTask() {
            return this.task;
        }

        @Override // com.stepos.agentbus.generated.TaskEvent
        public Long getTs() {
            return this.ts;
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Long l = this.seq;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l5 = this.ts;
            int iHashCode3 = (iHashCode2 + (l5 == null ? 0 : l5.hashCode())) * 31;
            String str = this.sessionKey;
            return iHashCode3 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Updated(task=" + this.task + ", seq=" + this.seq + ", ts=" + this.ts + ", sessionKey=" + this.sessionKey + ")";
        }
    }

    public /* synthetic */ TaskEvent(e eVar) {
        this();
    }

    public abstract Long getSeq();

    public abstract String getSessionKey();

    public abstract Long getTs();

    private TaskEvent() {
    }
}
