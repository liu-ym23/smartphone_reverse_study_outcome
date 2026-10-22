package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\rJ\u001d\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dR0\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u001ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b`\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R0\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u001ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e`\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00060#j\b\u0012\u0004\u0012\u00020\u0006`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/stepos/agentframework/chatui/q1;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "messageId", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "status", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/EReplyStatus;)V", "e", "(Ljava/lang/String;)V", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)I", "capturedEpoch", "", "c", "(Ljava/lang/String;I)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)Z", "oldMessageId", "incoming", "f", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/EReplyStatus;)V", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/EReplyStatus;)Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "terminalById", "Ljava/util/HashMap;", "epochById", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "suppressStaleTerminalIds", "Ljava/util/HashSet;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.q1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2042q1 {
    private final HashMap<String, EReplyStatus> terminalById = new HashMap<>();
    private final HashMap<String, Integer> epochById = new HashMap<>();
    private final HashSet<String> suppressStaleTerminalIds = new HashSet<>();

    public final void a(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        if (messageId.length() == 0) {
            return;
        }
        this.terminalById.remove(messageId);
        this.suppressStaleTerminalIds.remove(messageId);
    }

    public final int b(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        Integer num = this.epochById.get(messageId);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final boolean c(String messageId, int capturedEpoch) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        return messageId.length() > 0 && b(messageId) != capturedEpoch;
    }

    public final EReplyStatus d(String messageId, EReplyStatus incoming) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(incoming, "incoming");
        EReplyStatus eReplyStatus = this.terminalById.get(messageId);
        if (eReplyStatus != null) {
            incoming = eReplyStatus.mergeWithIncoming(incoming);
        }
        if (incoming.isTerminal()) {
            this.terminalById.put(messageId, incoming);
        }
        return incoming;
    }

    public final void e(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        if (messageId.length() == 0) {
            return;
        }
        this.terminalById.remove(messageId);
        HashMap<String, Integer> map = this.epochById;
        Integer num = map.get(messageId);
        map.put(messageId, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
        this.suppressStaleTerminalIds.add(messageId);
    }

    public final void f(String messageId, String oldMessageId, EReplyStatus incoming) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(oldMessageId, "oldMessageId");
        kotlin.jvm.internal.p.i(incoming, "incoming");
        if (messageId.length() > 0) {
            this.suppressStaleTerminalIds.remove(messageId);
        }
        if (oldMessageId.length() > 0) {
            this.suppressStaleTerminalIds.remove(oldMessageId);
            this.terminalById.remove(oldMessageId);
        }
        if (messageId.length() == 0) {
            return;
        }
        if (incoming.isTerminal()) {
            this.terminalById.put(messageId, incoming);
        } else {
            this.terminalById.remove(messageId);
        }
    }

    public final void g(String messageId, EReplyStatus status) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(status, "status");
        if (messageId.length() != 0 && status.isTerminal()) {
            this.terminalById.put(messageId, status);
        }
    }

    public final void h() {
        this.terminalById.clear();
        this.epochById.clear();
        this.suppressStaleTerminalIds.clear();
    }

    public final boolean i(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        return messageId.length() > 0 && this.suppressStaleTerminalIds.contains(messageId);
    }
}
