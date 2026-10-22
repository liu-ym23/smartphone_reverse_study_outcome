package com.stepos.agentframework.chatcore.session;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.ailauncher.chat.view.LauncherChatLayout;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.AskUserConversation;
import kotlin.AskUserQuestion;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import org.json.JSONArray;
import org.json.JSONObject;
import u4.AgentMessage;
import u4.m;
import v9.C5685n;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u000e\u001a\u00020\u0002*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u0004\u001a\u0011\u0010\u000f\u001a\u00020\n*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0019\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lw4/c;", "message", "", "e", "(Lw4/c;)Z", "Lu4/m$f;", "echo", "Lu4/a;", "f", "(Lu4/m$f;)Lu4/a;", "", "inquiryId", "c", "(Lw4/c;Ljava/lang/String;)Z", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "(Lw4/c;)Ljava/lang/String;", "parameter", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class K {
    public static final String a(String str) {
        Object objB;
        String string;
        String strOptString;
        if (La.H.x0(str)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("inquiries");
            if (jSONArrayOptJSONArray == null) {
                string = null;
                objB = Result.b(string);
            } else {
                Iterator<Integer> it = C5685n.s(0, jSONArrayOptJSONArray.length()).iterator();
                while (it.hasNext()) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(((Z8.M) it).nextInt());
                    if (jSONObjectOptJSONObject == null || (strOptString = jSONObjectOptJSONObject.optString("question")) == null || (string = La.H.D1(strOptString).toString()) == null || string.length() <= 0) {
                        string = null;
                    }
                    if (string != null) {
                        break;
                    }
                }
                string = null;
                objB = Result.b(string);
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (String) (Result.g(objB) ? null : objB);
    }

    public static final String b(ChatMessage chatMessage) {
        String strA;
        Object next;
        String question;
        String string;
        String str;
        kotlin.jvm.internal.p.i(chatMessage, "<this>");
        AskUserConversation askUserConversation = chatMessage.getAskUserConversation();
        if (askUserConversation != null) {
            Iterator<T> it = askUserConversation.b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                String string2 = La.H.D1(((AskUserQuestion) next).getQuestion()).toString();
                if (string2.length() > 0 && ((str = askUserConversation.a().get(string2)) == null || La.H.x0(str))) {
                    break;
                }
            }
            AskUserQuestion askUserQuestion = (AskUserQuestion) next;
            if (askUserQuestion != null && (question = askUserQuestion.getQuestion()) != null && (string = La.H.D1(question).toString()) != null) {
                String str2 = string.length() > 0 ? string : null;
                if (str2 != null) {
                    return str2;
                }
            }
        }
        Iterator<AgentMessage> it2 = chatMessage.i().iterator();
        while (it2.hasNext()) {
            List<AgentTool> listG = it2.next().g();
            if (listG == null) {
                listG = C1173v.m();
            }
            for (AgentTool agentTool : listG) {
                if (La.D.L(agentTool.getName(), LauncherChatLayout.ASK_USER_TOOL_NAME, true) && (strA = a(agentTool.getParameter())) != null) {
                    return strA;
                }
            }
        }
        return "";
    }

    public static final boolean c(ChatMessage chatMessage, String inquiryId) {
        kotlin.jvm.internal.p.i(chatMessage, "<this>");
        kotlin.jvm.internal.p.i(inquiryId, "inquiryId");
        List<AgentMessage> listI = chatMessage.i();
        if ((listI instanceof Collection) && listI.isEmpty()) {
            return false;
        }
        for (AgentMessage agentMessage : listI) {
            if (agentMessage.getType() == AgentMessageType.INQUIRY) {
                u4.m content = agentMessage.getContent();
                m.InquiryMessage inquiryMessage = content instanceof m.InquiryMessage ? (m.InquiryMessage) content : null;
                if (kotlin.jvm.internal.p.d(inquiryMessage != null ? inquiryMessage.getInquiryId() : null, inquiryId)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean d(ChatMessage chatMessage) {
        kotlin.jvm.internal.p.i(chatMessage, "<this>");
        List<AgentMessage> listI = chatMessage.i();
        if (!(listI instanceof Collection) || !listI.isEmpty()) {
            Iterator<T> it = listI.iterator();
            while (it.hasNext()) {
                List<AgentTool> listG = ((AgentMessage) it.next()).g();
                if (listG == null) {
                    listG = C1173v.m();
                }
                List<AgentTool> list = listG;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        if (La.D.L(((AgentTool) it2.next()).getName(), LauncherChatLayout.ASK_USER_TOOL_NAME, true)) {
                            List<AgentMessage> listI2 = chatMessage.i();
                            if ((listI2 instanceof Collection) && listI2.isEmpty()) {
                                return true;
                            }
                            Iterator<T> it3 = listI2.iterator();
                            while (it3.hasNext()) {
                                if (((AgentMessage) it3.next()).getType() == AgentMessageType.INQUIRY) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean e(ChatMessage message) {
        kotlin.jvm.internal.p.i(message, "message");
        if (message.i().isEmpty()) {
            return true;
        }
        if (message.i().size() == 1) {
            AgentMessage agentMessage = message.i().get(0);
            if (agentMessage.getType() == AgentMessageType.TEXT && agentMessage.getDeepThinkText().length() == 0 && agentMessage.getContent().h().length() == 0) {
                return true;
            }
        }
        return false;
    }

    public static final AgentMessage f(m.InquiryMessage echo) {
        kotlin.jvm.internal.p.i(echo, "echo");
        return new AgentMessage(AgentMessageType.INQUIRY, null, echo, null, false, false, 58, null);
    }
}
