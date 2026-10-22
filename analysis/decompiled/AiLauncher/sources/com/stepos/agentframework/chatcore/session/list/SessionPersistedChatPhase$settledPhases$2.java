package com.stepos.agentframework.chatcore.session.list;

import La.H;
import Ua.M;
import Y8.t;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import com.stepos.agentframework.chatcore.session.C1927e0;
import com.stepos.agentframework.chatcore.session.db.C0;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import com.stepos.agentframework.chatcore.session.db.InterfaceC1881f;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LUa/M;", "", "", "Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;", "<anonymous>", "(LUa/M;)Ljava/util/Map;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.list.SessionPersistedChatPhase$settledPhases$2", f = "SessionPersistedChatPhase.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionPersistedChatPhase$settledPhases$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Map<String, ? extends SessionChatPhase>>, Object> {
    final /* synthetic */ Collection<String> $sessionIds;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionPersistedChatPhase$settledPhases$2(Collection<String> collection, InterfaceC4014c<? super SessionPersistedChatPhase$settledPhases$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$sessionIds = collection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionPersistedChatPhase$settledPhases$2(this.$sessionIds, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Map<String, ? extends SessionChatPhase>> interfaceC4014c) {
        return ((SessionPersistedChatPhase$settledPhases$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SessionChatPhase sessionChatPhaseC;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        Collection<String> collection = this.$sessionIds;
        ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((String) obj2).length() > 0) {
                arrayList2.add(obj2);
            }
        }
        List<String> listG0 = F.g0(arrayList2);
        if (listG0.isEmpty()) {
            return kotlin.collections.a.i();
        }
        FwkDatabase.Companion companion = FwkDatabase.INSTANCE;
        if (!companion.B()) {
            C4148a.u("SessionPersistedChat", "settledPhases skipped: uid not ready", false, 4, null);
            return kotlin.collections.a.i();
        }
        try {
            FwkDatabase fwkDatabaseN = companion.n();
            InterfaceC1881f interfaceC1881fJ0 = fwkDatabaseN.j0();
            C0 c0K0 = fwkDatabaseN.k0();
            Map mapC = Q.c();
            for (String str : listG0) {
                ChatMessage chatMessageL = interfaceC1881fJ0.l(str);
                if (chatMessageL != null && (sessionChatPhaseC = j.c(j.b(chatMessageL, c0K0.d(chatMessageL.getMessageId())))) != null) {
                    if (j.d(sessionChatPhaseC, C1927e0.INSTANCE.d(str))) {
                        C4148a.k("SessionPersistedChat", "settled phase from db sessionId=" + str + " phase=" + sessionChatPhaseC, false, 4, null);
                        mapC.put(str, sessionChatPhaseC);
                    } else {
                        C4148a.k("SessionPersistedChat", "settled phase skipped sessionId=" + str + " phase=" + sessionChatPhaseC + " coldStartInterrupted=true", false, 4, null);
                    }
                }
            }
            return Q.b(mapC);
        } catch (IllegalStateException unused) {
            C4148a.u("SessionPersistedChat", "settledPhases skipped: account database is unavailable", false, 4, null);
            return kotlin.collections.a.i();
        } catch (Throwable th) {
            C4148a.h("SessionPersistedChat", "settledPhases failed: " + th.getClass().getSimpleName(), false, 4, null);
            return kotlin.collections.a.i();
        }
    }
}
