package com.stepos.agentframework.chatcore.session.list;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJV\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b!\u0010\u0011R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\"\u0010\u0011R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b#\u0010 R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b$\u0010\u0011¨\u0006%"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/list/a;", "", "", "sessionId", "Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;", "phase", "", "at", "failureReason", "messageId", "lastUserMessageAt", "askUserQuestion", "<init>", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;)Lcom/stepos/agentframework/chatcore/session/list/a;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;", "J", Const.INTENT_KEY_UMID, "()J", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "f", "c", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.list.a, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class SessionChatActivitySnapshot {
    private final String askUserQuestion;
    private final long at;
    private final String failureReason;
    private final long lastUserMessageAt;
    private final String messageId;
    private final SessionChatPhase phase;
    private final String sessionId;

    public SessionChatActivitySnapshot(String sessionId, SessionChatPhase phase, long j10, String failureReason, String messageId, long j11, String askUserQuestion) {
        p.i(sessionId, "sessionId");
        p.i(phase, "phase");
        p.i(failureReason, "failureReason");
        p.i(messageId, "messageId");
        p.i(askUserQuestion, "askUserQuestion");
        this.sessionId = sessionId;
        this.phase = phase;
        this.at = j10;
        this.failureReason = failureReason;
        this.messageId = messageId;
        this.lastUserMessageAt = j11;
        this.askUserQuestion = askUserQuestion;
    }

    public static /* synthetic */ SessionChatActivitySnapshot b(SessionChatActivitySnapshot sessionChatActivitySnapshot, String str, SessionChatPhase sessionChatPhase, long j10, String str2, String str3, long j11, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sessionChatActivitySnapshot.sessionId;
        }
        if ((i10 & 2) != 0) {
            sessionChatPhase = sessionChatActivitySnapshot.phase;
        }
        if ((i10 & 4) != 0) {
            j10 = sessionChatActivitySnapshot.at;
        }
        if ((i10 & 8) != 0) {
            str2 = sessionChatActivitySnapshot.failureReason;
        }
        if ((i10 & 16) != 0) {
            str3 = sessionChatActivitySnapshot.messageId;
        }
        if ((i10 & 32) != 0) {
            j11 = sessionChatActivitySnapshot.lastUserMessageAt;
        }
        if ((i10 & 64) != 0) {
            str4 = sessionChatActivitySnapshot.askUserQuestion;
        }
        String str5 = str4;
        long j12 = j10;
        return sessionChatActivitySnapshot.a(str, sessionChatPhase, j12, str2, str3, j11, str5);
    }

    public final SessionChatActivitySnapshot a(String sessionId, SessionChatPhase phase, long at, String failureReason, String messageId, long lastUserMessageAt, String askUserQuestion) {
        p.i(sessionId, "sessionId");
        p.i(phase, "phase");
        p.i(failureReason, "failureReason");
        p.i(messageId, "messageId");
        p.i(askUserQuestion, "askUserQuestion");
        return new SessionChatActivitySnapshot(sessionId, phase, at, failureReason, messageId, lastUserMessageAt, askUserQuestion);
    }

    /* renamed from: c, reason: from getter */
    public final String getAskUserQuestion() {
        return this.askUserQuestion;
    }

    /* renamed from: d, reason: from getter */
    public final long getAt() {
        return this.at;
    }

    /* renamed from: e, reason: from getter */
    public final String getFailureReason() {
        return this.failureReason;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionChatActivitySnapshot)) {
            return false;
        }
        SessionChatActivitySnapshot sessionChatActivitySnapshot = (SessionChatActivitySnapshot) other;
        return p.d(this.sessionId, sessionChatActivitySnapshot.sessionId) && this.phase == sessionChatActivitySnapshot.phase && this.at == sessionChatActivitySnapshot.at && p.d(this.failureReason, sessionChatActivitySnapshot.failureReason) && p.d(this.messageId, sessionChatActivitySnapshot.messageId) && this.lastUserMessageAt == sessionChatActivitySnapshot.lastUserMessageAt && p.d(this.askUserQuestion, sessionChatActivitySnapshot.askUserQuestion);
    }

    /* renamed from: f, reason: from getter */
    public final long getLastUserMessageAt() {
        return this.lastUserMessageAt;
    }

    /* renamed from: g, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: h, reason: from getter */
    public final SessionChatPhase getPhase() {
        return this.phase;
    }

    public int hashCode() {
        return (((((((((((this.sessionId.hashCode() * 31) + this.phase.hashCode()) * 31) + Long.hashCode(this.at)) * 31) + this.failureReason.hashCode()) * 31) + this.messageId.hashCode()) * 31) + Long.hashCode(this.lastUserMessageAt)) * 31) + this.askUserQuestion.hashCode();
    }

    public String toString() {
        return "SessionChatActivitySnapshot(sessionId=" + this.sessionId + ", phase=" + this.phase + ", at=" + this.at + ", failureReason=" + this.failureReason + ", messageId=" + this.messageId + ", lastUserMessageAt=" + this.lastUserMessageAt + ", askUserQuestion=" + this.askUserQuestion + ")";
    }
}
