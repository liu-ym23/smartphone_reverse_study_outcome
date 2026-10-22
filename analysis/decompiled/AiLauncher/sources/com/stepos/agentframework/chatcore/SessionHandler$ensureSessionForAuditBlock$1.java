package com.stepos.agentframework.chatcore;

import Ua.M;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.ConversationSessionKind;
import com.stepos.agentframework.chatcore.session.Z;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Iterator;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$ensureSessionForAuditBlock$1", f = "SessionHandler.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$ensureSessionForAuditBlock$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentSession.AgentConversation $conv;
    final /* synthetic */ String $effectiveSessionId;
    final /* synthetic */ AgentSession $s;
    final /* synthetic */ String $title;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SessionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$ensureSessionForAuditBlock$1(SessionHandler sessionHandler, AgentSession agentSession, AgentSession.AgentConversation agentConversation, String str, String str2, InterfaceC4014c<? super SessionHandler$ensureSessionForAuditBlock$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sessionHandler;
        this.$s = agentSession;
        this.$conv = agentConversation;
        this.$effectiveSessionId = str;
        this.$title = str2;
    }

    public static final void i(SessionHandler sessionHandler) {
        Iterator it = sessionHandler.conversationListCallbacks.iterator();
        while (it.hasNext()) {
            ((Z) it.next()).a();
        }
    }

    public static final void n(SessionHandler sessionHandler) {
        Iterator it = sessionHandler.conversationListCallbacks.iterator();
        while (it.hasNext()) {
            ((Z) it.next()).a();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SessionHandler$ensureSessionForAuditBlock$1 sessionHandler$ensureSessionForAuditBlock$1 = new SessionHandler$ensureSessionForAuditBlock$1(this.this$0, this.$s, this.$conv, this.$effectiveSessionId, this.$title, interfaceC4014c);
        sessionHandler$ensureSessionForAuditBlock$1.L$0 = obj;
        return sessionHandler$ensureSessionForAuditBlock$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionHandler$ensureSessionForAuditBlock$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        final SessionHandler sessionHandler;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (!FwkDatabase.INSTANCE.B()) {
            C4148a.u(this.this$0.TAG, "ensureSessionForAuditBlock: uid became unavailable, skip persist", false, 4, null);
            return Y8.t.f7040a;
        }
        AgentSession agentSession = this.$s;
        AgentSession.AgentConversation agentConversation = this.$conv;
        String str = this.$effectiveSessionId;
        final SessionHandler sessionHandler2 = this.this$0;
        String str2 = this.$title;
        try {
            Result.Companion companion = Result.INSTANCE;
            x4.e conversationTitleRepository = agentSession.getConversationTitleRepository();
            String agentId = agentConversation.getAgentId();
            if (La.H.x0(agentId)) {
                agentId = sessionHandler2.getConfiguration().getSessionConfig().getAgentId();
            }
            String migratingFromSessionId = agentSession.getMigratingFromSessionId();
            if (migratingFromSessionId.length() <= 0 || !kotlin.jvm.internal.p.d(str, agentConversation.getSessionId()) || agentConversation.getIsTempSession() || conversationTitleRepository.g(str) != null || conversationTitleRepository.g(migratingFromSessionId) == null) {
                if (conversationTitleRepository.g(str) == null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long jR = conversationTitleRepository.r(agentId);
                    if (jCurrentTimeMillis <= jR) {
                        jCurrentTimeMillis = 1 + jR;
                    }
                    long j10 = jCurrentTimeMillis;
                    String strR1 = La.K.R1(str2, 50);
                    if (strR1.length() == 0) {
                        strR1 = "新会话";
                    }
                    String str3 = strR1;
                    sessionHandler = sessionHandler2;
                    conversationTitleRepository.m(new w4.e(0, str, str3, agentId, null, 0L, j10, j10, agentConversation.getIsTempSession(), sessionHandler2.getConfiguration().getSessionConfig().E() ? ConversationSessionKind.INSTANCE.b(str).getCode() : ConversationSessionKind.NORMAL.getCode(), false, 0, 0, 7217, null));
                    C4148a.k(sessionHandler.TAG, "ensureSessionForAuditBlock inserted conversation_title sessionId=" + str + " isTempSession=" + agentConversation.getIsTempSession() + " agentId=" + agentId, false, 4, null);
                } else {
                    sessionHandler = sessionHandler2;
                }
                sessionHandler.mainHandler.post(new Runnable() { // from class: com.stepos.agentframework.chatcore.J
                    @Override // java.lang.Runnable
                    public final void run() {
                        SessionHandler$ensureSessionForAuditBlock$1.n(sessionHandler);
                    }
                });
            } else {
                sessionHandler2.mainHandler.post(new Runnable() { // from class: com.stepos.agentframework.chatcore.I
                    @Override // java.lang.Runnable
                    public final void run() {
                        SessionHandler$ensureSessionForAuditBlock$1.i(sessionHandler2);
                    }
                });
            }
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        SessionHandler sessionHandler3 = this.this$0;
        String str4 = this.$effectiveSessionId;
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(sessionHandler3.TAG, "ensureSessionForAuditBlock persist failed sessionId=" + str4, thE, false, 8, null);
        }
        return Y8.t.f7040a;
    }
}
