package com.stepos.agentframework.adapter.netcore;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.taskstore.provider.c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\u0010R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010'R\u0011\u0010)\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b(\u0010\u0010¨\u0006*"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/C;", "", "Lcom/stepos/agentframework/adapter/netcore/TaskEventType;", "eventType", "", c.a.COL_SEQ, "ts", "", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "Lcom/stepos/agentframework/adapter/netcore/e;", "task", "Lcom/stepos/agentframework/adapter/netcore/f;", "answer", "<init>", "(Lcom/stepos/agentframework/adapter/netcore/TaskEventType;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/stepos/agentframework/adapter/netcore/e;Lcom/stepos/agentframework/adapter/netcore/f;)V", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/adapter/netcore/TaskEventType;", "c", "()Lcom/stepos/agentframework/adapter/netcore/TaskEventType;", "Ljava/lang/Long;", Const.INTENT_KEY_UMID, "()Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/lang/String;", "e", "Lcom/stepos/agentframework/adapter/netcore/e;", "f", "()Lcom/stepos/agentframework/adapter/netcore/e;", "Lcom/stepos/agentframework/adapter/netcore/f;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/adapter/netcore/f;", Const.INTENT_KEY_BACKGROUND_COMMAND, "taskId", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.netcore.C, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskEventPayload {
    private final BusTaskAnswer answer;
    private final TaskEventType eventType;
    private final Long seq;
    private final String sessionKey;
    private final BusTask task;
    private final Long ts;

    public TaskEventPayload(TaskEventType eventType, Long l10, Long l11, String str, BusTask busTask, BusTaskAnswer busTaskAnswer) {
        kotlin.jvm.internal.p.i(eventType, "eventType");
        this.eventType = eventType;
        this.seq = l10;
        this.ts = l11;
        this.sessionKey = str;
        this.task = busTask;
        this.answer = busTaskAnswer;
    }

    public final String a() {
        String sessionKey;
        String requestSessionKey;
        BusTask busTask = this.task;
        String str = null;
        if (busTask != null && (requestSessionKey = busTask.getRequestSessionKey()) != null) {
            if (H.x0(requestSessionKey)) {
                requestSessionKey = null;
            }
            if (requestSessionKey != null) {
                return requestSessionKey;
            }
        }
        BusTask busTask2 = this.task;
        if (busTask2 == null || (sessionKey = busTask2.getSessionKey()) == null || H.x0(sessionKey)) {
            sessionKey = null;
        }
        if (sessionKey != null) {
            return sessionKey;
        }
        String str2 = this.sessionKey;
        if (str2 != null && !H.x0(str2)) {
            str = str2;
        }
        return str == null ? "" : str;
    }

    /* renamed from: b, reason: from getter */
    public final BusTaskAnswer getAnswer() {
        return this.answer;
    }

    /* renamed from: c, reason: from getter */
    public final TaskEventType getEventType() {
        return this.eventType;
    }

    /* renamed from: d, reason: from getter */
    public final Long getSeq() {
        return this.seq;
    }

    /* renamed from: e, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskEventPayload)) {
            return false;
        }
        TaskEventPayload taskEventPayload = (TaskEventPayload) other;
        return this.eventType == taskEventPayload.eventType && kotlin.jvm.internal.p.d(this.seq, taskEventPayload.seq) && kotlin.jvm.internal.p.d(this.ts, taskEventPayload.ts) && kotlin.jvm.internal.p.d(this.sessionKey, taskEventPayload.sessionKey) && kotlin.jvm.internal.p.d(this.task, taskEventPayload.task) && kotlin.jvm.internal.p.d(this.answer, taskEventPayload.answer);
    }

    /* renamed from: f, reason: from getter */
    public final BusTask getTask() {
        return this.task;
    }

    public final String g() {
        String taskId;
        BusTask busTask = this.task;
        if (busTask != null && (taskId = busTask.getTaskId()) != null) {
            return taskId;
        }
        BusTaskAnswer busTaskAnswer = this.answer;
        return busTaskAnswer != null ? busTaskAnswer.getTaskId() : "";
    }

    /* renamed from: h, reason: from getter */
    public final Long getTs() {
        return this.ts;
    }

    public int hashCode() {
        int iHashCode = this.eventType.hashCode() * 31;
        Long l10 = this.seq;
        int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.ts;
        int iHashCode3 = (iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str = this.sessionKey;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        BusTask busTask = this.task;
        int iHashCode5 = (iHashCode4 + (busTask == null ? 0 : busTask.hashCode())) * 31;
        BusTaskAnswer busTaskAnswer = this.answer;
        return iHashCode5 + (busTaskAnswer != null ? busTaskAnswer.hashCode() : 0);
    }

    public String toString() {
        return "TaskEventPayload(eventType=" + this.eventType + ", seq=" + this.seq + ", ts=" + this.ts + ", sessionKey=" + this.sessionKey + ", task=" + this.task + ", answer=" + this.answer + ")";
    }

    public /* synthetic */ TaskEventPayload(TaskEventType taskEventType, Long l10, Long l11, String str, BusTask busTask, BusTaskAnswer busTaskAnswer, int i10, kotlin.jvm.internal.i iVar) {
        this(taskEventType, (i10 & 2) != 0 ? null : l10, (i10 & 4) != 0 ? null : l11, (i10 & 8) != 0 ? null : str, (i10 & 16) != 0 ? null : busTask, (i10 & 32) != 0 ? null : busTaskAnswer);
    }
}
