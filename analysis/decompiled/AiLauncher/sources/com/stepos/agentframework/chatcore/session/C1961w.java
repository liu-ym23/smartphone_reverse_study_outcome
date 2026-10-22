package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.audit.RunBlockedEvent;
import java.util.Collection;
import kotlin.Metadata;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0007\u001a%\u0010\u0003\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a5\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0000¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lw4/c;", "liveStreaming", "latestBySession", Const.INTENT_KEY_PKGNAME, "(Lw4/c;Lw4/c;)Lw4/c;", "", "usesMainChannel", "hasNeverConversed", "isIndependentConversation", Const.INTENT_KEY_UMID, "(ZZZ)Z", "", "id", "sessionId", "tempSessionId", "", "retiredSessionIds", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;)Z", "passed", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;)Ljava/lang/String;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1961w {
    public static final String a(String passed, String sessionId, String tempSessionId, Collection<String> retiredSessionIds) {
        kotlin.jvm.internal.p.i(passed, "passed");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(tempSessionId, "tempSessionId");
        kotlin.jvm.internal.p.i(retiredSessionIds, "retiredSessionIds");
        return (c(passed, sessionId, tempSessionId, retiredSessionIds) && sessionId.length() != 0) ? sessionId : passed;
    }

    public static final ChatMessage b(ChatMessage chatMessage, ChatMessage chatMessage2) {
        if (chatMessage != null) {
            return chatMessage;
        }
        if (chatMessage2 == null || chatMessage2.getRole() != AgentRole.ASSISTANT || La.D.X(chatMessage2.getMessageId(), RunBlockedEvent.AUDIT_BLOCKED_REPLY_PREFIX, false, 2, null) || La.D.X(chatMessage2.getMessageId(), RunBlockedEvent.PRIVACY_BLOCKED_REPLY_PREFIX, false, 2, null)) {
            return null;
        }
        return chatMessage2;
    }

    public static final boolean c(String id, String sessionId, String tempSessionId, Collection<String> retiredSessionIds) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(tempSessionId, "tempSessionId");
        kotlin.jvm.internal.p.i(retiredSessionIds, "retiredSessionIds");
        if (id.length() > 0) {
            return kotlin.jvm.internal.p.d(id, sessionId) || kotlin.jvm.internal.p.d(id, tempSessionId) || retiredSessionIds.contains(id);
        }
        return false;
    }

    public static final boolean d(boolean z10, boolean z11, boolean z12) {
        return z10 && z11 && !z12;
    }
}
