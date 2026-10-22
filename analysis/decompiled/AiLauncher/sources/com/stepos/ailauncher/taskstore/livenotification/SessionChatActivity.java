package com.stepos.ailauncher.taskstore.livenotification;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\rR\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001e\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/q;", "", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "phase", "", "updatedAt", "", "failureReason", "lastUserMessageAt", "askUserQuestion", "<init>", "(Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;JLjava/lang/String;JLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "J", "e", "()J", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.q, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class SessionChatActivity {
    private final String askUserQuestion;
    private final String failureReason;
    private final long lastUserMessageAt;
    private final SessionActivityState phase;
    private final long updatedAt;

    public SessionChatActivity(SessionActivityState sessionActivityState, long j10, String failureReason, long j11, String askUserQuestion) {
        kotlin.jvm.internal.p.i(failureReason, "failureReason");
        kotlin.jvm.internal.p.i(askUserQuestion, "askUserQuestion");
        this.phase = sessionActivityState;
        this.updatedAt = j10;
        this.failureReason = failureReason;
        this.lastUserMessageAt = j11;
        this.askUserQuestion = askUserQuestion;
    }

    /* renamed from: a, reason: from getter */
    public final String getAskUserQuestion() {
        return this.askUserQuestion;
    }

    /* renamed from: b, reason: from getter */
    public final String getFailureReason() {
        return this.failureReason;
    }

    /* renamed from: c, reason: from getter */
    public final long getLastUserMessageAt() {
        return this.lastUserMessageAt;
    }

    /* renamed from: d, reason: from getter */
    public final SessionActivityState getPhase() {
        return this.phase;
    }

    /* renamed from: e, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionChatActivity)) {
            return false;
        }
        SessionChatActivity sessionChatActivity = (SessionChatActivity) other;
        return this.phase == sessionChatActivity.phase && this.updatedAt == sessionChatActivity.updatedAt && kotlin.jvm.internal.p.d(this.failureReason, sessionChatActivity.failureReason) && this.lastUserMessageAt == sessionChatActivity.lastUserMessageAt && kotlin.jvm.internal.p.d(this.askUserQuestion, sessionChatActivity.askUserQuestion);
    }

    public int hashCode() {
        SessionActivityState sessionActivityState = this.phase;
        return ((((((((sessionActivityState == null ? 0 : sessionActivityState.hashCode()) * 31) + Long.hashCode(this.updatedAt)) * 31) + this.failureReason.hashCode()) * 31) + Long.hashCode(this.lastUserMessageAt)) * 31) + this.askUserQuestion.hashCode();
    }

    public String toString() {
        return "SessionChatActivity(phase=" + this.phase + ", updatedAt=" + this.updatedAt + ", failureReason=" + this.failureReason + ", lastUserMessageAt=" + this.lastUserMessageAt + ", askUserQuestion=" + this.askUserQuestion + ")";
    }

    public /* synthetic */ SessionChatActivity(SessionActivityState sessionActivityState, long j10, String str, long j11, String str2, int i10, kotlin.jvm.internal.i iVar) {
        this(sessionActivityState, j10, (i10 & 4) != 0 ? "" : str, (i10 & 8) != 0 ? 0L : j11, (i10 & 16) != 0 ? "" : str2);
    }
}
