package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import h8.C4148a;
import java.util.Iterator;
import java.util.List;
import kotlin.Function2;
import kotlin.Metadata;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007JW\u0010\u0015\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2&\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001b\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001f\u001a\u00020\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010#\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\r¢\u0006\u0004\b#\u0010$J\u001d\u0010'\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\b¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\b¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u0013¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0013¢\u0006\u0004\b-\u0010,J\u0017\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\bH\u0002¢\u0006\u0004\b/\u00100J\u001e\u00101\u001a\u00020\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0082@¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b3\u00104R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00105R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00106¨\u00067"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/MessageManager;", "", "Lx4/f;", "messageRepository", "Lx4/e;", "conversationTitleRepository", "<init>", "(Lx4/f;Lx4/e;)V", "", "agentId", "defaultSessionId", "", "usesOpenClawMainChannelSessionLogic", "", "limit", "Lkotlin/Function3;", "Lw4/e;", "", "Lw4/c;", "LY8/t;", "callback", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;ZILp9/q;)V", "sessionId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;)Lw4/e;", "messages", "l", "(Ljava/util/List;)V", "messageIds", "failed", "p", "(Ljava/util/List;Z)V", "messageId", "isLike", "m", "(Ljava/lang/String;I)V", "message", "deleteMessageId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lw4/c;Ljava/lang/String;)V", "f", "(Ljava/lang/String;)V", "e", "()V", "k", "op", "o", "(Ljava/lang/String;)Z", "n", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Ljava/lang/String;", "Lx4/f;", "Lx4/e;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MessageManager {
    private final x4.e conversationTitleRepository;
    private final x4.f messageRepository;

    /* JADX WARN: Multi-variable type inference failed */
    public MessageManager() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final void e() {
        Function2.c(new MessageManager$deleteAll$1(this, null));
    }

    public final void f(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        Function2.c(new MessageManager$deleteMessage$1(this, messageId, null));
    }

    public final void g(String agentId, String defaultSessionId, boolean usesOpenClawMainChannelSessionLogic, int limit, p9.q<? super String, ? super w4.e, ? super List<ChatMessage>, Y8.t> callback) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(defaultSessionId, "defaultSessionId");
        kotlin.jvm.internal.p.i(callback, "callback");
        Function2.c(new MessageManager$loadHistory$1(this, defaultSessionId, limit, usesOpenClawMainChannelSessionLogic, agentId, callback, null));
    }

    public final w4.e h(String agentId, String sessionId) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (o("queryConversationTitle")) {
            return this.conversationTitleRepository.g(sessionId);
        }
        return null;
    }

    public final void i(ChatMessage message, String deleteMessageId) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(deleteMessageId, "deleteMessageId");
        Function2.c(new MessageManager$replaceMessage$1(this, message, deleteMessageId, null));
    }

    public final String j(String agentId) {
        Object next;
        Object next2;
        Iterator<T> it = this.conversationTitleRepository.j(agentId).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!((w4.e) next).getIsTempSession()) {
                break;
            }
        }
        w4.e eVar = (w4.e) next;
        if (eVar != null) {
            return eVar.getSessionId();
        }
        Iterator<T> it2 = this.messageRepository.s().iterator();
        if (it2.hasNext()) {
            next2 = it2.next();
            if (it2.hasNext()) {
                long time = ((ChatMessage) next2).getTime();
                do {
                    Object next3 = it2.next();
                    long time2 = ((ChatMessage) next3).getTime();
                    if (time < time2) {
                        next2 = next3;
                        time = time2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next2 = null;
        }
        ChatMessage chatMessage = (ChatMessage) next2;
        String sessionId = chatMessage != null ? chatMessage.getSessionId() : null;
        return sessionId == null ? "" : sessionId;
    }

    public final void k() {
        Function2.c(new MessageManager$runColdStartCleanup$1(this, null));
    }

    public final void l(List<ChatMessage> messages) {
        kotlin.jvm.internal.p.i(messages, "messages");
        Function2.c(new MessageManager$saveMessages$1(this, messages, null));
    }

    public final void m(String messageId, int isLike) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        Function2.c(new MessageManager$setLikeStatus$1(this, messageId, isLike, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x019f -> B:86:0x01a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(java.util.List<java.lang.String> r13, e9.InterfaceC4014c<? super Y8.t> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.MessageManager.n(java.util.List, e9.c):java.lang.Object");
    }

    public final boolean o(String op) {
        if (FwkDatabase.INSTANCE.B()) {
            return true;
        }
        C4148a.u("MessageManager", "skip " + op + ": uid not ready (not logged in)", false, 4, null);
        return false;
    }

    public final void p(List<String> messageIds, boolean failed) {
        kotlin.jvm.internal.p.i(messageIds, "messageIds");
        if (messageIds.isEmpty()) {
            return;
        }
        Function2.c(new MessageManager$updateSendFailedWhenPersisted$1(this, messageIds, failed, null));
    }

    public MessageManager(x4.f messageRepository, x4.e conversationTitleRepository) {
        kotlin.jvm.internal.p.i(messageRepository, "messageRepository");
        kotlin.jvm.internal.p.i(conversationTitleRepository, "conversationTitleRepository");
        this.messageRepository = messageRepository;
        this.conversationTitleRepository = conversationTitleRepository;
    }

    public /* synthetic */ MessageManager(x4.f fVar, x4.e eVar, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? new x4.v(null, null, null, 7, null) : fVar, (i10 & 2) != 0 ? new x4.d() : eVar);
    }
}
