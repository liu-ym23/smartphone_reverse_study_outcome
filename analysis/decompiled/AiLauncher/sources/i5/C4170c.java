package i5;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.C2706l;
import com.stepos.ailauncher.contract.api.chat.IChatRoundAbortService;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import u4.AgentMessage;
import w4.ChatMessage;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u0010*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Li5/c;", "Lcom/stepos/ailauncher/contract/api/chat/IChatRoundAbortService;", "<init>", "()V", "", "chatSessionId", "requestSessionId", "taskId", "LY8/t;", "abortRound", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Parameters.SESSION_ID, "Lcom/stepos/agentframework/chatcore/SessionHandler;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/SessionHandler;", "Lw4/c;", "", Const.INTENT_KEY_PKGNAME, "(Lw4/c;Ljava/lang/String;)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: i5.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4170c implements IChatRoundAbortService {
    public final SessionHandler a(String sid) {
        SessionHandler sessionHandlerD;
        SessionHandler sessionHandler = AgentConfig.INSTANCE.a().getSessionHandler();
        AgentSession.AgentConversation agentConversationR1 = sessionHandler != null ? sessionHandler.R1() : null;
        return ((sessionHandler == null || agentConversationR1 == null || !(p.d(agentConversationR1.getSessionId(), sid) || p.d(agentConversationR1.getTempSessionId(), sid))) && (sessionHandlerD = C2706l.INSTANCE.a().d(sid)) != null) ? sessionHandlerD : sessionHandler;
    }

    @Override // com.stepos.ailauncher.contract.api.chat.IChatRoundAbortService
    public void abortRound(String chatSessionId, String requestSessionId, String taskId) {
        SessionHandler sessionHandlerA;
        AgentSession.AgentConversation agentConversationR1;
        ChatMessage chatMessageM;
        p.i(chatSessionId, "chatSessionId");
        p.i(requestSessionId, "requestSessionId");
        p.i(taskId, "taskId");
        if (chatSessionId.length() == 0) {
            chatSessionId = requestSessionId;
        }
        if (chatSessionId.length() == 0 || (sessionHandlerA = a(chatSessionId)) == null || (agentConversationR1 = sessionHandlerA.R1()) == null) {
            return;
        }
        if ((p.d(agentConversationR1.getSessionId(), chatSessionId) || p.d(agentConversationR1.getTempSessionId(), chatSessionId)) && agentConversationR1.P() && (chatMessageM = agentConversationR1.M()) != null && b(chatMessageM, taskId)) {
            sessionHandlerA.X3();
        }
    }

    public final boolean b(ChatMessage chatMessage, String str) {
        AppUIData appUIData;
        Object structuredContent;
        String string;
        if (str.length() == 0) {
            return false;
        }
        List<AgentMessage> listI = chatMessage.i();
        if ((listI instanceof Collection) && listI.isEmpty()) {
            return false;
        }
        Iterator<T> it = listI.iterator();
        while (it.hasNext()) {
            List<AgentTool> listG = ((AgentMessage) it.next()).g();
            if (listG != null) {
                List<AgentTool> list = listG;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    for (AgentTool agentTool : list) {
                        if (H.g0(agentTool.getResult(), str, false, 2, null) || H.g0(agentTool.getParameter(), str, false, 2, null) || H.g0(agentTool.getContent(), str, false, 2, null) || ((appUIData = agentTool.getAppUIData()) != null && (structuredContent = appUIData.getStructuredContent()) != null && (string = structuredContent.toString()) != null && H.g0(string, str, false, 2, null))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
