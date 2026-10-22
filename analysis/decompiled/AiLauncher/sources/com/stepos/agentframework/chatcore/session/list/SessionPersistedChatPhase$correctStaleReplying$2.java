package com.stepos.agentframework.chatcore.session.list;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.chatcore.session.db.C0;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import com.stepos.agentframework.chatcore.session.db.InterfaceC1881f;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.list.SessionPersistedChatPhase$correctStaleReplying$2", f = "SessionPersistedChatPhase.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionPersistedChatPhase$correctStaleReplying$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    int label;

    public SessionPersistedChatPhase$correctStaleReplying$2(InterfaceC4014c<? super SessionPersistedChatPhase$correctStaleReplying$2> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionPersistedChatPhase$correctStaleReplying$2(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SessionPersistedChatPhase$correctStaleReplying$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        Map<String, SessionChatActivitySnapshot> value = SessionActivityTracker.INSTANCE.e().getValue();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, SessionChatActivitySnapshot> entry : value.entrySet()) {
            if (entry.getValue().getPhase() == SessionChatPhase.REPLYING) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (linkedHashMap.isEmpty()) {
            return t.f7040a;
        }
        FwkDatabase.Companion companion = FwkDatabase.INSTANCE;
        if (!companion.B()) {
            C4148a.u("SessionPersistedChat", "correctStaleReplying skipped: uid not ready", false, 4, null);
            return t.f7040a;
        }
        try {
            FwkDatabase fwkDatabaseN = companion.n();
            InterfaceC1881f interfaceC1881fJ0 = fwkDatabaseN.j0();
            C0 c0K0 = fwkDatabaseN.k0();
            for (String str : linkedHashMap.keySet()) {
                ChatMessage chatMessageZ = interfaceC1881fJ0.z(str);
                if (chatMessageZ != null) {
                    ChatMessage chatMessageB = j.b(chatMessageZ, c0K0.d(chatMessageZ.getMessageId()));
                    SessionChatPhase sessionChatPhaseC = j.c(chatMessageB);
                    SessionActivityTracker sessionActivityTracker = SessionActivityTracker.INSTANCE;
                    SessionChatActivitySnapshot sessionChatActivitySnapshot = sessionActivityTracker.e().getValue().get(str);
                    if (sessionChatActivitySnapshot != null && j.e(sessionChatActivitySnapshot.getPhase(), sessionChatActivitySnapshot.getMessageId(), chatMessageB.getMessageId(), sessionChatPhaseC)) {
                        C4148a.k("SessionPersistedChat", "correct stale REPLYING sessionId=" + str + " messageId=" + chatMessageB.getMessageId() + " to=" + sessionChatPhaseC, false, 4, null);
                        sessionActivityTracker.l(chatMessageB);
                    }
                }
            }
        } catch (IllegalStateException unused) {
            C4148a.u("SessionPersistedChat", "correctStaleReplying skipped: account database is unavailable", false, 4, null);
        } catch (Throwable th) {
            C4148a.h("SessionPersistedChat", "correctStaleReplying failed: " + th.getClass().getSimpleName(), false, 4, null);
        }
        return t.f7040a;
    }
}
