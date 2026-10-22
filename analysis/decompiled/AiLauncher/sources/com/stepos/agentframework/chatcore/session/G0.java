package com.stepos.agentframework.chatcore.session;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.AbstractC0913i;
import kotlin.AskUserConversation;
import kotlin.C0917m;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import u4.AgentMessage;
import u4.AgentResponse;
import u4.m;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J%\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\bJ\u000f\u0010!\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b!\u0010\"J\r\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u001b¢\u0006\u0004\b&\u0010'JK\u00101\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020(2\b\b\u0002\u0010/\u001a\u00020.2\n\b\u0002\u00100\u001a\u0004\u0018\u00010(¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b3\u0010\bJ\r\u00104\u001a\u00020\u0006¢\u0006\u0004\b4\u0010\u0003J\u001d\u00108\u001a\u0004\u0018\u00010\u00042\f\u00107\u001a\b\u0012\u0004\u0012\u00020605¢\u0006\u0004\b8\u00109J\u001f\u0010;\u001a\u0004\u0018\u00010:2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010,\u001a\u00020(¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b=\u0010\rJ/\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020(2\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AJ'\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020(¢\u0006\u0004\bB\u0010CJ1\u0010F\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020(2\b\b\u0002\u0010E\u001a\u00020D¢\u0006\u0004\bF\u0010GJ'\u0010H\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020(¢\u0006\u0004\bH\u0010CJ\u000f\u0010I\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bI\u0010\"J\u0015\u0010J\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(¢\u0006\u0004\bJ\u0010KJ\u0015\u0010L\u001a\u00020\u00062\u0006\u00100\u001a\u00020(¢\u0006\u0004\bL\u0010KJ\u0015\u0010M\u001a\u00020\u00062\u0006\u00100\u001a\u00020(¢\u0006\u0004\bM\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010S¨\u0006T"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/G0;", "", "<init>", "()V", "Lw4/c;", "message", "LY8/t;", "y", "(Lw4/c;)V", "Lu4/d;", UxipConstants.f30685x, "", "s", "(Lu4/d;)Z", "t", "n", "", "LK6/i$e;", "files", "c", "(Lw4/c;Ljava/util/List;)V", "LK6/i$f;", "folder", Const.INTENT_KEY_UMID, "(Lw4/c;LK6/i$f;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lw4/c;Lu4/d;)Z", "Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "responseType", "m", "(Lcom/stepos/agentframework/chatcore/session/AgentMessageType;)V", "F", "l", "p", "()Lw4/c;", "", "r", "()I", "q", "()Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "", "sessionId", "tempSessionId", "agentId", "pairId", DidiCardProvider.KEY_TRACE_ID, "", "minTime", "messageId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)Lw4/c;", "C", "f", "", "Lcom/stepos/agentframework/chatcore/intent/e;", "tools", ExifInterface.LONGITUDE_EAST, "(Ljava/util/List;)Lw4/c;", "Lcom/stepos/agentframework/chatcore/session/D0;", "e", "(Lu4/d;Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/D0;", "D", "Lcom/stepos/agentframework/chatcore/session/AgentError;", "error", "w", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/AgentError;)Lw4/c;", "u", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lw4/c;", "Lcom/stepos/agentframework/chatcore/session/ChatHintType;", "hint", "x", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/ChatHintType;)Lw4/c;", "v", "o", "B", "(Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "assistantMessage", "Lw4/c;", "part", "I", "currentType", "Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class G0 {
    private ChatMessage assistantMessage;
    private int part = -1;
    private AgentMessageType currentType = AgentMessageType.TEXT;

    public static final Ka.j A(AgentMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        List<AgentTool> listG = it.g();
        if (listG == null) {
            listG = C1173v.m();
        }
        return Z8.F.d0(listG);
    }

    public static final boolean z(AgentMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getType() == AgentMessageType.TOOL;
    }

    public final void B(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        ChatMessage chatMessage = this.assistantMessage;
        if (chatMessage != null) {
            chatMessage.S(sessionId);
        }
    }

    public final void C(ChatMessage message) {
        this.assistantMessage = message;
        if (message == null) {
            this.part = -1;
            this.currentType = AgentMessageType.TEXT;
        } else {
            this.part = message.i().size() - 1;
            int size = message.i().size();
            int i10 = this.part;
            this.currentType = (i10 < 0 || i10 >= size) ? AgentMessageType.TEXT : message.i().get(this.part).getType();
        }
    }

    public final boolean D(AgentResponse response) {
        kotlin.jvm.internal.p.i(response, "response");
        ChatMessage chatMessage = this.assistantMessage;
        if (chatMessage == null || chatMessage.getStatus() != EReplyStatus.COMPLETED || kotlin.jvm.internal.p.d(chatMessage.getMessageId(), response.getMessageId()) || K.e(chatMessage)) {
            return false;
        }
        return response.getContent().length() > 0 || response.getDeepThinkingText().length() > 0;
    }

    public final ChatMessage E(List<AgentTool> tools) {
        int iIntValue;
        List<AgentTool> listG;
        kotlin.jvm.internal.p.i(tools, "tools");
        ChatMessage chatMessage = this.assistantMessage;
        if (chatMessage == null || tools.isEmpty()) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i10 = 0;
        for (Object obj : chatMessage.i()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            AgentMessage c5574a = (AgentMessage) obj;
            if (c5574a.getType() == AgentMessageType.TOOL && (listG = c5574a.g()) != null) {
                int i12 = 0;
                for (Object obj2 : listG) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        C1173v.w();
                    }
                    AgentTool agentTool = (AgentTool) obj2;
                    if (!La.H.x0(agentTool.getToolCallId())) {
                        linkedHashMap.putIfAbsent(agentTool.getToolCallId(), Y8.j.a(Integer.valueOf(i10), Integer.valueOf(i12)));
                    }
                    i12 = i13;
                }
            }
            i10 = i11;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (AgentTool agentTool2 : tools) {
            Pair pair = (Pair) linkedHashMap.get(agentTool2.getToolCallId());
            if (pair != null) {
                iIntValue = ((Number) pair.e()).intValue();
            } else {
                n();
                l(chatMessage);
                chatMessage.i().get(this.part).m(AgentMessageType.TOOL);
                iIntValue = this.part;
            }
            Integer numValueOf = Integer.valueOf(iIntValue);
            Object objP1 = linkedHashMap2.get(numValueOf);
            if (objP1 == null) {
                List<AgentTool> listG2 = chatMessage.i().get(iIntValue).g();
                if (listG2 == null) {
                    listG2 = C1173v.m();
                }
                objP1 = Z8.F.p1(listG2);
                linkedHashMap2.put(numValueOf, objP1);
            }
            List<AgentTool> list = (List) objP1;
            Integer num = pair != null ? (Integer) pair.f() : null;
            if (num != null) {
                com.stepos.agentframework.chatcore.intent.f.a(agentTool2, list.get(num.intValue()));
            }
            q4.j.INSTANCE.g(list, agentTool2);
            if (num != null) {
                list.set(num.intValue(), agentTool2);
            } else {
                if (!La.H.x0(agentTool2.getToolCallId())) {
                    linkedHashMap.put(agentTool2.getToolCallId(), Y8.j.a(Integer.valueOf(iIntValue), Integer.valueOf(list.size())));
                }
                list.add(agentTool2);
            }
        }
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            chatMessage.i().get(((Number) entry.getKey()).intValue()).l((List) entry.getValue());
        }
        q4.j.INSTANCE.d(chatMessage.i());
        y(chatMessage);
        return chatMessage;
    }

    public final void F(AgentMessageType responseType) {
        List<AgentMessage> listI;
        this.part++;
        this.currentType = responseType;
        ChatMessage chatMessage = this.assistantMessage;
        if (chatMessage == null || (listI = chatMessage.i()) == null) {
            return;
        }
        AgentMessage c5574a = new AgentMessage(null, null, null, null, false, false, 63, null);
        c5574a.m(this.currentType);
        listI.add(c5574a);
    }

    public final void c(ChatMessage message, List<AbstractC0913i.File> files) {
        for (AbstractC0913i.File file : files) {
            String fileId = file.getFileId();
            if (fileId != null) {
                List<AgentMessage> listI = message.i();
                if (!(listI instanceof Collection) || !listI.isEmpty()) {
                    for (AgentMessage c5574a : listI) {
                        if (c5574a.getType() == AgentMessageType.FILE) {
                            u4.m mVarC = c5574a.getContent();
                            m.FileMessage cVar = mVarC instanceof m.FileMessage ? (m.FileMessage) mVarC : null;
                            if (kotlin.jvm.internal.p.d(cVar != null ? cVar.getFileId() : null, fileId)) {
                                break;
                            }
                        }
                    }
                }
            }
            List<AgentMessage> listI2 = message.i();
            AgentMessage c5574a2 = new AgentMessage(null, null, null, null, false, false, 63, null);
            c5574a2.m(AgentMessageType.FILE);
            String fileId2 = file.getFileId();
            String url = file.getUrl();
            String fileName = file.getFileName();
            Long fileSize = file.getFileSize();
            String strValueOf = fileSize != null ? String.valueOf(fileSize.longValue()) : null;
            String mimeType = file.getMimeType();
            com.stepos.agentframework.chatcore.utils.g gVar = com.stepos.agentframework.chatcore.utils.g.INSTANCE;
            String fileName2 = file.getFileName();
            if (fileName2 == null) {
                fileName2 = "";
            }
            c5574a2.i(new m.FileMessage(fileId2, null, url, null, fileName, strValueOf, mimeType, null, gVar.f(fileName2), 138, null));
            listI2.add(c5574a2);
        }
    }

    public final void d(ChatMessage message, AbstractC0913i.Folder folder) {
        List<AgentMessage> listI = message.i();
        if (!(listI instanceof Collection) || !listI.isEmpty()) {
            Iterator<T> it = listI.iterator();
            while (it.hasNext()) {
                if (((AgentMessage) it.next()).getType() == AgentMessageType.FOLDER) {
                    return;
                }
            }
        }
        List<AgentMessage> listI2 = message.i();
        AgentMessage c5574a = new AgentMessage(null, null, null, null, false, false, 63, null);
        c5574a.m(AgentMessageType.FOLDER);
        c5574a.i(new m.FolderMessage(folder.getRoot(), folder.e()));
        listI2.add(c5574a);
    }

    public final ResponseApplyResult e(AgentResponse response, String pairId) {
        ChatMessage chatMessage;
        AskUserConversation askUserConversationH;
        String strA;
        kotlin.jvm.internal.p.i(response, "response");
        kotlin.jvm.internal.p.i(pairId, "pairId");
        if (s(response) || (chatMessage = this.assistantMessage) == null) {
            return null;
        }
        Object objJ = response.getExtra();
        C0917m c0917m = objJ instanceof C0917m ? (C0917m) objJ : null;
        if (c0917m != null && (strA = kotlin.r.a(c0917m)) != null) {
            chatMessage.F(strA);
        }
        Object objJ2 = response.getExtra();
        C0917m c0917m2 = objJ2 instanceof C0917m ? (C0917m) objJ2 : null;
        if (c0917m2 != null && (askUserConversationH = c0917m2.getAskUserConversation()) != null) {
            chatMessage.G(askUserConversationH);
        }
        if (!response.k().isEmpty()) {
            c(chatMessage, response.k());
        }
        AbstractC0913i.Folder folderO = response.getFolder();
        if (folderO != null) {
            d(chatMessage, folderO);
        }
        if (t(response)) {
            chatMessage.U(chatMessage.getStatus().mergeWithIncoming(response.getStatus()));
            chatMessage.V(response.u());
            return new ResponseApplyResult(chatMessage, chatMessage.getMessageId(), false);
        }
        String messageId = chatMessage.getMessageId();
        boolean z10 = !kotlin.jvm.internal.p.d(messageId, response.getMessageId());
        if (i(chatMessage, response)) {
            chatMessage.M(response.getMessageId());
            chatMessage.S(response.getSessionId());
            chatMessage.E(response.getAgentId());
            chatMessage.c0("");
            String strR = response.getServerItemId();
            chatMessage.R(strR != null ? strR : "");
            chatMessage.U(chatMessage.getStatus().mergeWithIncoming(response.getStatus()));
            chatMessage.N(pairId);
            chatMessage.V(response.u());
            return new ResponseApplyResult(chatMessage, messageId, z10);
        }
        m(response.getType());
        l(chatMessage);
        chatMessage.M(response.getMessageId());
        chatMessage.S(response.getSessionId());
        chatMessage.E(response.getAgentId());
        chatMessage.i().get(this.part).getContent().b(response.getContent());
        chatMessage.i().get(this.part).getContent().a(response.getContent());
        chatMessage.i().get(this.part).j(chatMessage.i().get(this.part).getDeepThinkText() + response.getDeepThinkingText());
        chatMessage.i().get(this.part).m(response.getType());
        chatMessage.c0("");
        String strR2 = response.getServerItemId();
        chatMessage.R(strR2 != null ? strR2 : "");
        chatMessage.U(chatMessage.getStatus().mergeWithIncoming(response.getStatus()));
        chatMessage.N(pairId);
        chatMessage.V(response.u());
        return new ResponseApplyResult(chatMessage, messageId, z10);
    }

    public final void f() {
        C(null);
    }

    public final void g(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        ChatMessage chatMessage = this.assistantMessage;
        if (chatMessage != null) {
            if (!kotlin.jvm.internal.p.d(chatMessage.getMessageId(), messageId)) {
                chatMessage = null;
            }
            if (chatMessage != null) {
                chatMessage.F(null);
            }
        }
    }

    public final void h(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        ChatMessage chatMessage = this.assistantMessage;
        if (chatMessage != null) {
            if (!kotlin.jvm.internal.p.d(chatMessage.getMessageId(), messageId)) {
                chatMessage = null;
            }
            if (chatMessage != null) {
                chatMessage.G(null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0095 A[EDGE_INSN: B:41:0x0095->B:36:0x0095 BREAK  A[LOOP:0: B:31:0x0071->B:43:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(w4.ChatMessage r7, u4.AgentResponse r8) {
        /*
            r6 = this;
            com.stepos.agentframework.chatcore.session.AgentMessageType r0 = r8.getType()
            com.stepos.agentframework.chatcore.session.AgentMessageType r1 = com.stepos.agentframework.chatcore.session.AgentMessageType.TEXT
            r2 = 0
            if (r0 != r1) goto Lc8
            java.lang.String r0 = r8.getContent()
            int r0 = r0.length()
            if (r0 != 0) goto L15
            goto Lc8
        L15:
            com.stepos.agentframework.chatcore.session.AgentMessageType r0 = r6.currentType
            com.stepos.agentframework.chatcore.session.AgentMessageType r1 = com.stepos.agentframework.chatcore.session.AgentMessageType.TOOL
            if (r0 == r1) goto L1c
            return r2
        L1c:
            java.util.List r0 = r7.i()
            int r1 = r6.part
            java.lang.Object r0 = Z8.F.t0(r0, r1)
            u4.a r0 = (u4.AgentMessage) r0
            r1 = 0
            if (r0 == 0) goto L30
            java.util.List r0 = r0.g()
            goto L31
        L30:
            r0 = r1
        L31:
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto Lc8
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L3e
            goto Lc8
        L3e:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L4e
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L4e
            goto L65
        L4e:
            java.util.Iterator r0 = r0.iterator()
        L52:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L65
            java.lang.Object r3 = r0.next()
            com.stepos.agentframework.chatcore.intent.e r3 = (com.stepos.agentframework.chatcore.intent.AgentTool) r3
            boolean r3 = r3.getIsFinished()
            if (r3 == 0) goto L52
            goto Lc8
        L65:
            int r6 = r6.part
            r0 = 1
            int r6 = r6 - r0
            v9.g r6 = v9.C5685n.p(r6, r2)
            java.util.Iterator r6 = r6.iterator()
        L71:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L95
            java.lang.Object r3 = r6.next()
            r4 = r3
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.util.List r5 = r7.i()
            java.lang.Object r4 = r5.get(r4)
            u4.a r4 = (u4.AgentMessage) r4
            com.stepos.agentframework.chatcore.session.AgentMessageType r4 = r4.getType()
            com.stepos.agentframework.chatcore.session.AgentMessageType r5 = com.stepos.agentframework.chatcore.session.AgentMessageType.TEXT
            if (r4 != r5) goto L71
            r1 = r3
        L95:
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 == 0) goto Lc8
            int r6 = r1.intValue()
            java.util.List r1 = r7.i()
            java.lang.Object r1 = r1.get(r6)
            u4.a r1 = (u4.AgentMessage) r1
            u4.m r1 = r1.getContent()
            java.lang.String r2 = r8.getContent()
            r1.b(r2)
            java.util.List r7 = r7.i()
            java.lang.Object r6 = r7.get(r6)
            u4.a r6 = (u4.AgentMessage) r6
            u4.m r6 = r6.getContent()
            java.lang.String r7 = r8.getContent()
            r6.i(r7)
            return r0
        Lc8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.G0.i(w4.c, u4.d):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final w4.ChatMessage j(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, long r33, java.lang.String r35) {
        /*
            r27 = this;
            java.lang.String r0 = "sessionId"
            r1 = r28
            kotlin.jvm.internal.p.i(r1, r0)
            java.lang.String r0 = "tempSessionId"
            r2 = r29
            kotlin.jvm.internal.p.i(r2, r0)
            java.lang.String r0 = "agentId"
            r4 = r30
            kotlin.jvm.internal.p.i(r4, r0)
            java.lang.String r0 = "pairId"
            r12 = r31
            kotlin.jvm.internal.p.i(r12, r0)
            java.lang.String r0 = "traceId"
            r13 = r32
            kotlin.jvm.internal.p.i(r13, r0)
            long r5 = java.lang.System.currentTimeMillis()
            r27.f()
            if (r35 == 0) goto L38
            int r0 = r35.length()
            if (r0 <= 0) goto L35
            r0 = r35
            goto L36
        L35:
            r0 = 0
        L36:
            if (r0 != 0) goto L4f
        L38:
            O6.m r0 = O6.m.INSTANCE
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r7 = "assistant-wait-"
            r3.append(r7)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.String r0 = r0.c(r3)
        L4f:
            int r3 = r1.length()
            if (r3 != 0) goto L59
            r3 = r2
        L56:
            r1 = r33
            goto L5b
        L59:
            r3 = r1
            goto L56
        L5b:
            long r5 = java.lang.Math.max(r5, r1)
            com.stepos.agentframework.chatcore.session.AgentRole r7 = com.stepos.agentframework.chatcore.session.AgentRole.ASSISTANT
            com.stepos.agentframework.chatcore.session.EReplyStatus r14 = com.stepos.agentframework.chatcore.session.EReplyStatus.START
            w4.c r1 = new w4.c
            java.lang.String r8 = ""
            r9 = 0
            r10 = 0
            java.lang.String r11 = ""
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 4190208(0x3ff000, float:5.871732E-39)
            r26 = 0
            r2 = r0
            r1.<init>(r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r0 = r27
            r0.assistantMessage = r1
            kotlin.jvm.internal.p.f(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.G0.j(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, java.lang.String):w4.c");
    }

    public final void l(ChatMessage message) {
        if (this.part < 0) {
            return;
        }
        while (message.i().size() <= this.part) {
            message.i().add(new AgentMessage(this.currentType, null, null, null, false, false, 62, null));
        }
    }

    public final void m(AgentMessageType responseType) {
        int i10 = this.part;
        if (i10 == -1) {
            this.currentType = responseType;
            this.part = i10 + 1;
        } else if (this.currentType != responseType) {
            F(responseType);
        }
    }

    public final void n() {
        int i10 = this.part;
        if (i10 == -1) {
            this.currentType = AgentMessageType.TOOL;
            this.part = i10 + 1;
            return;
        }
        AgentMessageType agentMessageType = this.currentType;
        AgentMessageType agentMessageType2 = AgentMessageType.TOOL;
        if (agentMessageType != agentMessageType2) {
            F(agentMessageType2);
        }
    }

    public final ChatMessage o() {
        ChatMessage chatMessage = this.assistantMessage;
        if (chatMessage == null) {
            return null;
        }
        if (chatMessage.getStatus() == EReplyStatus.COMPLETED) {
            chatMessage.U(EReplyStatus.REPLYING);
        }
        chatMessage.O(null);
        return chatMessage;
    }

    /* renamed from: p, reason: from getter */
    public final ChatMessage getAssistantMessage() {
        return this.assistantMessage;
    }

    /* renamed from: q, reason: from getter */
    public final AgentMessageType getCurrentType() {
        return this.currentType;
    }

    /* renamed from: r, reason: from getter */
    public final int getPart() {
        return this.part;
    }

    public final boolean s(AgentResponse response) {
        if (response.getType() != AgentMessageType.TEXT || response.getContent().length() > 0 || response.getStatus().isTerminal()) {
            return false;
        }
        Object objJ = response.getExtra();
        C0917m c0917m = objJ instanceof C0917m ? (C0917m) objJ : null;
        return (c0917m != null ? kotlin.r.a(c0917m) : null) == null;
    }

    public final boolean t(AgentResponse response) {
        if (response.getContent().length() != 0 || response.getDeepThinkingText().length() != 0) {
            return false;
        }
        List<AgentTool> listY = response.y();
        return (listY == null || listY.isEmpty()) && response.getStatus().isTerminal();
    }

    public final ChatMessage u(String sessionId, String agentId, String pairId) {
        List<AgentTool> listG;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(pairId, "pairId");
        ChatMessage chatMessage = this.assistantMessage;
        if (chatMessage == null) {
            return null;
        }
        chatMessage.S(sessionId);
        chatMessage.E(agentId);
        chatMessage.U(EReplyStatus.CANCELED);
        chatMessage.N(pairId);
        chatMessage.J(ChatHintType.STOPPED);
        for (AgentMessage c5574a : chatMessage.i()) {
            if (c5574a.getType() == AgentMessageType.TOOL && (listG = c5574a.g()) != null) {
                Iterator<T> it = listG.iterator();
                while (it.hasNext()) {
                    ((AgentTool) it.next()).A(true);
                }
            }
        }
        return chatMessage;
    }

    public final ChatMessage v(String sessionId, String agentId, String pairId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(pairId, "pairId");
        ChatMessage chatMessage = this.assistantMessage;
        if (chatMessage == null) {
            return null;
        }
        chatMessage.S(sessionId);
        chatMessage.E(agentId);
        chatMessage.U(chatMessage.getStatus().mergeWithIncoming(EReplyStatus.COMPLETED));
        chatMessage.N(pairId);
        return chatMessage;
    }

    public final ChatMessage w(String sessionId, String agentId, String pairId, AgentError error) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(pairId, "pairId");
        kotlin.jvm.internal.p.i(error, "error");
        ChatMessage chatMessage = this.assistantMessage;
        if (chatMessage == null) {
            return null;
        }
        chatMessage.S(sessionId);
        chatMessage.E(agentId);
        chatMessage.U(EReplyStatus.ERROR);
        chatMessage.N(pairId);
        chatMessage.I(error.getMessage());
        chatMessage.H(error.getCode());
        return chatMessage;
    }

    public final ChatMessage x(String sessionId, String agentId, String pairId, ChatHintType hint) {
        List<AgentTool> listG;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(pairId, "pairId");
        kotlin.jvm.internal.p.i(hint, "hint");
        ChatMessage chatMessage = this.assistantMessage;
        if (chatMessage == null) {
            return null;
        }
        chatMessage.S(sessionId);
        chatMessage.E(agentId);
        chatMessage.U(EReplyStatus.CANCELED);
        chatMessage.N(pairId);
        chatMessage.J(hint);
        for (AgentMessage c5574a : chatMessage.i()) {
            if (c5574a.getType() == AgentMessageType.TOOL && (listG = c5574a.g()) != null) {
                Iterator<T> it = listG.iterator();
                while (it.hasNext()) {
                    ((AgentTool) it.next()).A(true);
                }
            }
        }
        return chatMessage;
    }

    public final void y(ChatMessage message) {
        EReplyStatus eReplyStatus;
        if (message.getStatus().isTerminal()) {
            return;
        }
        List listD0 = SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.L(SequencesKt___SequencesKt.F(Z8.F.d0(message.i()), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.E0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(G0.z((AgentMessage) obj));
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.F0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return G0.A((AgentMessage) obj);
            }
        }));
        if (listD0.isEmpty()) {
            return;
        }
        List list = listD0;
        if ((list instanceof Collection) && list.isEmpty()) {
            eReplyStatus = EReplyStatus.REPLYING;
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!((AgentTool) it.next()).getIsFinished()) {
                    eReplyStatus = EReplyStatus.TOOL_EXECUTING;
                    break;
                }
            }
            eReplyStatus = EReplyStatus.REPLYING;
        }
        message.U(eReplyStatus);
    }
}
