package com.stepos.ailauncher.chat.input;

import Y8.t;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001f\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010!\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0004\b!\u0010\"J \u0010%\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001cH\u0082@¢\u0006\u0004\b%\u0010&J\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00192\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/stepos/ailauncher/chat/input/ChatStopActions;", "", "<init>", "()V", "owner", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "LY8/t;", "l", "(Ljava/lang/Object;Lcom/stepos/agentframework/chatcore/SessionHandler;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "c", "(Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "e", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/agentframework/chatcore/SessionHandler;)Z", "cancelledTasks", "roundActive", "m", "(ZZ)Z", "", "status", "k", "(I)Z", "", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "tasks", "", "sessionId", "tempSessionId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Z", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/chatcore/SessionHandler;Le9/c;)Ljava/lang/Object;", Parameters.SESSION_ID, "tempSid", "f", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentframework/chatcore/SessionHandler;)Ljava/util/List;", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatStopActions {
    public static final ChatStopActions INSTANCE = new ChatStopActions();
    private static final String TAG = "ChatStopActions";

    public final void c(SessionHandler handler) {
        p.i(handler, "handler");
        handler.R3(new ChatStopActions$armUnfinishedTaskCancel$1(null));
    }

    public final Object d(SessionHandler sessionHandler, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        AgentSession.AgentConversation agentConversationR1;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) {
            return t.f7040a;
        }
        String sessionId = agentConversationR1.getSessionId();
        if (sessionId == null) {
            sessionId = "";
        }
        String tempSessionId = agentConversationR1.getTempSessionId();
        Object objF = f(sessionId, tempSessionId != null ? tempSessionId : "", interfaceC4014c);
        return objF == C4063a.g() ? objF : t.f7040a;
    }

    public final void e(SessionHandler handler) {
        List<String> listH = h(handler);
        if (listH.isEmpty()) {
            return;
        }
        Function2.a(new ChatStopActions$cancelUnfinishedTasks$1(listH, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0139, code lost:
    
        if (Ua.C1056g.j(r1, r3, r0) == r12) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(java.lang.String r10, java.lang.String r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.input.ChatStopActions.f(java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final void g(Object owner, SessionHandler handler) {
        p.i(owner, "owner");
        if (handler != null) {
            handler.a3(owner, null);
        }
    }

    public final List<String> h(SessionHandler handler) {
        AgentSession.AgentConversation agentConversationR1;
        if (handler == null || (agentConversationR1 = handler.R1()) == null) {
            return C1173v.m();
        }
        List listP = C1173v.p(agentConversationR1.getSessionId(), agentConversationR1.getTempSessionId());
        ArrayList arrayList = new ArrayList();
        for (Object obj : listP) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return F.g0(arrayList);
    }

    public final boolean i(List<UiTask> tasks, String sessionId, String tempSessionId) {
        p.i(tasks, "tasks");
        p.i(sessionId, "sessionId");
        p.i(tempSessionId, "tempSessionId");
        if (sessionId.length() == 0 && tempSessionId.length() == 0) {
            return false;
        }
        List<UiTask> list = tasks;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (UiTask uiTask : list) {
            if (INSTANCE.k(uiTask.getStatus()) && (p.d(uiTask.getRequestedSessionKey(), sessionId) || p.d(uiTask.getRequestedSessionKey(), tempSessionId))) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(SessionHandler handler) {
        if (handler == null) {
            return false;
        }
        List<String> listH = h(handler);
        if ((listH instanceof Collection) && listH.isEmpty()) {
            return false;
        }
        Iterator<T> it = listH.iterator();
        while (it.hasNext()) {
            if (handler.i2((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean k(int status) {
        return status == 2;
    }

    public final void l(Object owner, SessionHandler handler) {
        p.i(owner, "owner");
        p.i(handler, "handler");
        handler.a3(owner, new ChatStopActions$registerPreSendCancel$1(handler, null));
    }

    public final boolean m(boolean cancelledTasks, boolean roundActive) {
        return cancelledTasks && !roundActive;
    }
}
