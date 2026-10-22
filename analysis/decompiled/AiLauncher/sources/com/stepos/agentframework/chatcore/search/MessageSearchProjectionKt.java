package com.stepos.agentframework.chatcore.search;

import Ka.t;
import La.D;
import La.H;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;
import p9.InterfaceC5074l;
import u4.AgentMessage;
import u4.m;
import w4.ChatMessage;
import w4.MessageSearchProjectionEntity;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000e\u0010\f\"\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lw4/c;", "", "Lu4/a;", "parts", "Lw4/g;", "o", "(Lw4/c;Ljava/util/List;)Lw4/g;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;)Ljava/lang/String;", UxipConstants.f30680s, "n", "(Ljava/lang/String;)Ljava/lang/String;", "query", "m", "Lkotlin/text/Regex;", "WHITESPACE", "Lkotlin/text/Regex;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MessageSearchProjectionKt {
    private static final Regex WHITESPACE = new Regex("\\s+");

    public static final String g(List<AgentMessage> parts) {
        kotlin.jvm.internal.p.i(parts, "parts");
        return SequencesKt___SequencesKt.O(SequencesKt___SequencesKt.B(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.L(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.G(F.d0(parts), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.search.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MessageSearchProjectionKt.h((AgentMessage) obj));
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.search.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MessageSearchProjectionKt.i((AgentMessage) obj));
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.search.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MessageSearchProjectionKt.j((AgentMessage) obj);
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.search.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MessageSearchProjectionKt.k((String) obj);
            }
        }), MessageSearchProjectionKt$extractVisibleText$5.INSTANCE), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.search.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MessageSearchProjectionKt.l((String) obj));
            }
        })), "\n", null, null, 0, null, null, 62, null);
    }

    public static final boolean h(AgentMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getHiddenInUi();
    }

    public static final boolean i(AgentMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getType() == AgentMessageType.TEXT || it.getType() == AgentMessageType.THINKING_TEXT;
    }

    public static final Ka.j j(AgentMessage part) {
        kotlin.jvm.internal.p.i(part, "part");
        String deepThinkText = part.getDeepThinkText();
        u4.m content = part.getContent();
        m.TextMessage textMessage = content instanceof m.TextMessage ? (m.TextMessage) content : null;
        String text = textMessage != null ? textMessage.getText() : null;
        if (text == null) {
            text = "";
        }
        return t.w(deepThinkText, text);
    }

    public static final String k(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return O6.f.INSTANCE.b(it);
    }

    public static final boolean l(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.length() > 0;
    }

    public static final String m(String query) {
        kotlin.jvm.internal.p.i(query, "query");
        return "%" + D.T(D.T(D.T(query, "\\", "\\\\", false, 4, null), "%", "\\%", false, 4, null), "_", "\\_", false, 4, null) + "%";
    }

    public static final String n(String str) {
        return H.D1(WHITESPACE.l(str, " ")).toString();
    }

    public static final MessageSearchProjectionEntity o(ChatMessage chatMessage, List<AgentMessage> parts) {
        kotlin.jvm.internal.p.i(chatMessage, "<this>");
        kotlin.jvm.internal.p.i(parts, "parts");
        return new MessageSearchProjectionEntity(chatMessage.getMessageId(), chatMessage.getSessionId(), chatMessage.getAgentId(), chatMessage.getRole().name(), (chatMessage.getRole() == AgentRole.USER || chatMessage.getRole() == AgentRole.ASSISTANT) ? g(parts) : "", chatMessage.getTime(), chatMessage.getStatus().name());
    }

    public static /* synthetic */ MessageSearchProjectionEntity p(ChatMessage chatMessage, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = F.m1(chatMessage.i());
        }
        return o(chatMessage, list);
    }
}
