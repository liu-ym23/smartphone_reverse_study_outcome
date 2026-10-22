package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000<\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aW\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\t2\u0006\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001d\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001d\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0015\u0010!\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b!\u0010\"\u001a\r\u0010#\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$\u001a\r\u0010%\u001a\u00020\u000b¢\u0006\u0004\b%\u0010$\"\u0014\u0010&\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010'\"\u0014\u0010(\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)\"\u0014\u0010+\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010,\"\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"", "agentId", "defaultSessionId", "", "usesOpenClawMainChannelSessionLogic", "", "limit", "Lkotlin/Function3;", "Lw4/e;", "", "Lw4/c;", "LY8/t;", "callback", "f", "(Ljava/lang/String;Ljava/lang/String;ZILp9/q;)V", "sessionId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;)Lw4/e;", "messages", "k", "(Ljava/util/List;)V", "messageIds", "failed", "m", "(Ljava/util/List;Z)V", "messageId", "isLike", "l", "(Ljava/lang/String;I)V", "message", "deleteMessageId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lw4/c;Ljava/lang/String;)V", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "c", "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "TAG", "Ljava/lang/String;", "SEND_FAILED_RETRY_MAX", "I", "", "SEND_FAILED_RETRY_DELAY_MS", "J", "Lcom/stepos/agentframework/chatcore/session/MessageManager;", "defaultMessageManager$delegate", "LY8/h;", "e", "()Lcom/stepos/agentframework/chatcore/session/MessageManager;", "defaultMessageManager", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.k0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1939k0 {
    private static final long SEND_FAILED_RETRY_DELAY_MS = 200;
    private static final int SEND_FAILED_RETRY_MAX = 3;
    private static final String TAG = "MessageManager";
    private static final Y8.h defaultMessageManager$delegate = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.j0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return C1939k0.b();
        }
    });

    /* JADX WARN: Multi-variable type inference failed */
    public static final MessageManager b() {
        return new MessageManager(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static final void c() {
        e().e();
    }

    public static final void d(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        e().f(messageId);
    }

    public static final MessageManager e() {
        return (MessageManager) defaultMessageManager$delegate.getValue();
    }

    public static final void f(String agentId, String defaultSessionId, boolean z10, int i10, p9.q<? super String, ? super w4.e, ? super List<ChatMessage>, Y8.t> callback) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(defaultSessionId, "defaultSessionId");
        kotlin.jvm.internal.p.i(callback, "callback");
        e().g(agentId, defaultSessionId, z10, i10, callback);
    }

    public static /* synthetic */ void g(String str, String str2, boolean z10, int i10, p9.q qVar, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            i10 = 10;
        }
        f(str, str2, z10, i10, qVar);
    }

    public static final w4.e h(String agentId, String sessionId) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        return e().h(agentId, sessionId);
    }

    public static final void i(ChatMessage message, String deleteMessageId) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(deleteMessageId, "deleteMessageId");
        e().i(message, deleteMessageId);
    }

    public static final void j() {
        e().k();
    }

    public static final void k(List<ChatMessage> messages) {
        kotlin.jvm.internal.p.i(messages, "messages");
        e().l(messages);
    }

    public static final void l(String messageId, int i10) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        e().m(messageId, i10);
    }

    public static final void m(List<String> messageIds, boolean z10) {
        kotlin.jvm.internal.p.i(messageIds, "messageIds");
        e().p(messageIds, z10);
    }
}
