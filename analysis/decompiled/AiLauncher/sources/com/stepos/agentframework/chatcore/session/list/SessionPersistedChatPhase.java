package com.stepos.agentframework.chatcore.session.list;

import Ua.C1056g;
import Ua.Y;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/list/SessionPersistedChatPhase;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "", "", "sessionIds", "", "Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Collection;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionPersistedChatPhase {
    public static final SessionPersistedChatPhase INSTANCE = new SessionPersistedChatPhase();
    private static final String TAG = "SessionPersistedChat";

    public final Object a(InterfaceC4014c<? super t> interfaceC4014c) {
        Object objJ = C1056g.j(Y.b(), new SessionPersistedChatPhase$correctStaleReplying$2(null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : t.f7040a;
    }

    public final Object b(Collection<String> collection, InterfaceC4014c<? super Map<String, ? extends SessionChatPhase>> interfaceC4014c) {
        return C1056g.j(Y.b(), new SessionPersistedChatPhase$settledPhases$2(collection, null), interfaceC4014c);
    }
}
