package com.stepos.ailauncher.chat.controller;

import Ua.C1060i;
import Z8.C1172u;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/SidebarSessionMutations;", "", "<init>", "()V", "LUa/M;", "scope", "", "sessionId", "", "clearOnly", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "sessionHandler", "Lkotlin/Function1;", "LY8/t;", "callback", Const.INTENT_KEY_APIKEY, "(LUa/M;Ljava/lang/String;ZLcom/stepos/agentframework/chatcore/SessionHandler;Lp9/l;)V", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SidebarSessionMutations {
    public static final SidebarSessionMutations INSTANCE = new SidebarSessionMutations();
    private static final String TAG = "SidebarSessionMutations";

    public static /* synthetic */ void b(SidebarSessionMutations sidebarSessionMutations, Ua.M m10, String str, boolean z10, SessionHandler sessionHandler, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            sessionHandler = AgentConfig.INSTANCE.a().n();
        }
        sidebarSessionMutations.a(m10, str, z10, sessionHandler, interfaceC5074l);
    }

    public final void a(Ua.M scope, String sessionId, boolean clearOnly, SessionHandler sessionHandler, InterfaceC5074l<? super Boolean, Y8.t> callback) {
        String tempSessionId;
        kotlin.jvm.internal.p.i(scope, "scope");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(sessionHandler, "sessionHandler");
        kotlin.jvm.internal.p.i(callback, "callback");
        AgentSession.AgentConversation agentConversationR1 = sessionHandler.R1();
        List listC = C1172u.c();
        listC.add(sessionId);
        if (kotlin.jvm.internal.p.d(agentConversationR1 != null ? agentConversationR1.B() : null, sessionId) && (tempSessionId = agentConversationR1.getTempSessionId()) != null) {
            String str = La.H.x0(tempSessionId) ? null : tempSessionId;
            if (str != null) {
                listC.add(str);
            }
        }
        C1060i.d(scope, null, null, new SidebarSessionMutations$delete$1(clearOnly, Z8.F.g0(C1172u.a(listC)), callback, sessionHandler, sessionId, scope, null), 3, null);
    }
}
