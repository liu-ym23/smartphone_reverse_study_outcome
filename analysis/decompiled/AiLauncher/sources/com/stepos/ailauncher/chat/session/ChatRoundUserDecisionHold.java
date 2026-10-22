package com.stepos.ailauncher.chat.session;

import La.H;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.h;
import Y8.t;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.ConversationSessionIds;
import com.stepos.agentframework.chatcore.session.list.SessionPendingActionKind;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.C2706l;
import com.stepos.ailauncher.common.utils.v;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.d;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014JA\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)RT\u0010.\u001aB\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n ,*\u0004\u0018\u00010-0- ,* \u0012\f\u0012\n ,*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n ,*\u0004\u0018\u00010-0-\u0018\u00010+0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/stepos/ailauncher/chat/session/ChatRoundUserDecisionHold;", "", "<init>", "()V", "", "sessionId", "requestId", "riskLevel", "", "timeoutMs", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "source", "m", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "l", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)V", "o", "(Ljava/lang/String;)Ljava/lang/String;", "action", "Lkotlin/Function2;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "block", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/p;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Ljava/util/List;", "TAG", "Ljava/lang/String;", "DEFAULT_AUTHORIZATION_TIMEOUT_MS", "J", "LUa/M;", "ioScope", "LUa/M;", "Lx4/d;", "titles$delegate", "LY8/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lx4/d;", "titles", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "", "releasedRequestIds", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatRoundUserDecisionHold {
    private static final long DEFAULT_AUTHORIZATION_TIMEOUT_MS = 600000;
    private static final String TAG = "ChatRoundUserDecisionHold";
    public static final ChatRoundUserDecisionHold INSTANCE = new ChatRoundUserDecisionHold();
    private static final M ioScope = d.a(L0.b(null, 1, null).plus(Y.b()));

    /* renamed from: titles$delegate, reason: from kotlin metadata */
    private static final h titles = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.session.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ChatRoundUserDecisionHold.p();
        }
    });
    private static final ConcurrentHashMap.KeySetView<String, Boolean> releasedRequestIds = ConcurrentHashMap.newKeySet();

    public static final t k(String str, SessionHandler handler, String key) {
        p.i(handler, "handler");
        p.i(key, "key");
        handler.Z1(key, str);
        return t.f7040a;
    }

    public static final t n(String str, String str2, SessionHandler handler, String key) {
        p.i(handler, "handler");
        p.i(key, "key");
        handler.f3(key, str, str2);
        return t.f7040a;
    }

    public static final x4.d p() {
        return new x4.d();
    }

    public final void f(String sessionId, String requestId, String action, p9.p<? super SessionHandler, ? super String, t> block) {
        if (H.x0(sessionId)) {
            C4148a.k(TAG, action + " skip ChatRound: empty session req=" + requestId, false, 4, null);
            return;
        }
        LinkedHashSet linkedHashSetG = Z8.Y.g(sessionId, ConversationSessionIds.INSTANCE.m(sessionId));
        ArrayList arrayList = new ArrayList();
        for (Object obj : linkedHashSetG) {
            if (!H.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(h((String) it.next()));
        }
        if (linkedHashSet.isEmpty()) {
            C4148a.k(TAG, action + " no handler session=" + sessionId + " req=" + requestId, false, 4, null);
            return;
        }
        Iterator it2 = linkedHashSet.iterator();
        p.h(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next = it2.next();
            p.h(next, "next(...)");
            SessionHandler sessionHandler = (SessionHandler) next;
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                block.invoke(sessionHandler, (String) it3.next());
            }
        }
        C4148a.k(TAG, action + " session=" + sessionId + " keys=" + arrayList + " handlers=" + linkedHashSet.size() + " req=" + requestId, false, 4, null);
    }

    public final void g(String requestId) {
        releasedRequestIds.add(requestId);
        C1060i.d(ioScope, null, null, new ChatRoundUserDecisionHold$clearPending$1(requestId, null), 3, null);
    }

    public final List<SessionHandler> h(String sessionId) {
        AgentSession.AgentConversation agentConversationR1;
        if (sessionId.length() == 0) {
            return C1173v.m();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        SessionHandler sessionHandler = AgentConfig.INSTANCE.a().getSessionHandler();
        if (sessionHandler != null && (((agentConversationR1 = sessionHandler.R1()) != null && (p.d(agentConversationR1.getSessionId(), sessionId) || p.d(agentConversationR1.getTempSessionId(), sessionId))) || sessionHandler.i2(sessionId))) {
            linkedHashSet.add(sessionHandler);
        }
        C2706l.Companion companion = C2706l.INSTANCE;
        SessionHandler sessionHandlerE = companion.a().e(sessionId);
        if (sessionHandlerE != null) {
            linkedHashSet.add(sessionHandlerE);
        }
        SessionHandler sessionHandlerD = companion.a().d(sessionId);
        if (sessionHandlerD != null) {
            linkedHashSet.add(sessionHandlerD);
        }
        return F.m1(linkedHashSet);
    }

    public final x4.d i() {
        return (x4.d) titles.getValue();
    }

    public final void j(String sessionId, final String requestId, String riskLevel, long timeoutMs) {
        p.i(sessionId, "sessionId");
        p.i(requestId, "requestId");
        if (H.x0(requestId)) {
            return;
        }
        String strO = o(sessionId);
        l(strO, requestId, riskLevel, timeoutMs);
        f(strO, requestId, "hold", new p9.p() { // from class: com.stepos.ailauncher.chat.session.c
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChatRoundUserDecisionHold.k(requestId, (SessionHandler) obj, (String) obj2);
            }
        });
    }

    public final void l(String sessionId, String requestId, String riskLevel, long timeoutMs) {
        if (H.x0(sessionId)) {
            C4148a.k(TAG, "persist skip: empty session req=" + requestId, false, 4, null);
            return;
        }
        String strM = ConversationSessionIds.INSTANCE.m(sessionId);
        if (H.x0(strM)) {
            strM = sessionId;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jG = jCurrentTimeMillis + C5685n.g(timeoutMs, 1L);
        SessionPendingActionKind sessionPendingActionKindB = com.stepos.agentframework.chatcore.session.list.h.b(riskLevel);
        v vVar = v.INSTANCE;
        boolean z10 = vVar.t(sessionId) || vVar.t(strM);
        releasedRequestIds.remove(requestId);
        C1060i.d(ioScope, null, null, new ChatRoundUserDecisionHold$persistPending$1(strM, sessionId, z10, jCurrentTimeMillis, requestId, sessionPendingActionKindB, jG, timeoutMs, null), 3, null);
    }

    public final void m(String sessionId, final String requestId, final String source) {
        p.i(sessionId, "sessionId");
        p.i(requestId, "requestId");
        p.i(source, "source");
        if (H.x0(requestId)) {
            return;
        }
        g(requestId);
        f(o(sessionId), requestId, "release:" + source, new p9.p() { // from class: com.stepos.ailauncher.chat.session.b
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChatRoundUserDecisionHold.n(requestId, source, (SessionHandler) obj, (String) obj2);
            }
        });
    }

    public final String o(String sessionId) {
        AgentSession.AgentConversation agentConversationR1;
        if (!H.x0(sessionId)) {
            return sessionId;
        }
        SessionHandler sessionHandler = AgentConfig.INSTANCE.a().getSessionHandler();
        String sessionId2 = (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) ? null : agentConversationR1.getSessionId();
        return sessionId2 == null ? "" : sessionId2;
    }
}
