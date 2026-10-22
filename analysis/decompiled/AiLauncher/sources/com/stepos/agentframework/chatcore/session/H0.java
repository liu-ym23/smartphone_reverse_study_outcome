package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w4.ChatMessage;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\bJ\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/H0;", "", "<init>", "()V", "", "shownText", "pulledText", "c", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "e", "(Ljava/lang/String;Ljava/lang/String;)Z", "userMessageId", "assistantMessageId", Const.INTENT_KEY_UMID, "Lw4/c;", "message", "", "nowMs", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lw4/c;J)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class H0 {
    public static final H0 INSTANCE = new H0();

    public static /* synthetic */ void b(H0 h02, ChatMessage chatMessage, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = System.currentTimeMillis();
        }
        h02.a(chatMessage, j10);
    }

    public final void a(ChatMessage message, long nowMs) {
        kotlin.jvm.internal.p.i(message, "message");
        message.P(nowMs);
        message.O(null);
    }

    public final String c(String shownText, String pulledText) {
        kotlin.jvm.internal.p.i(shownText, "shownText");
        kotlin.jvm.internal.p.i(pulledText, "pulledText");
        return ((pulledText.length() >= shownText.length() || !La.D.X(shownText, pulledText, false, 2, null)) && (shownText.length() <= 0 || La.H.c0(shownText, pulledText, false, 2, null).length() != 0 || shownText.length() < pulledText.length())) ? pulledText : shownText;
    }

    public final String d(String userMessageId, String assistantMessageId) {
        int iU0;
        kotlin.jvm.internal.p.i(userMessageId, "userMessageId");
        kotlin.jvm.internal.p.i(assistantMessageId, "assistantMessageId");
        String string = La.H.D1(userMessageId).toString();
        if (La.D.X(string, "as-", false, 2, null) || (iU0 = La.H.u0(assistantMessageId, "as-", 0, false, 6, null)) < 0) {
            return string;
        }
        String strSubstring = assistantMessageId.substring(iU0);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final boolean e(String shownText, String pulledText) {
        kotlin.jvm.internal.p.i(shownText, "shownText");
        kotlin.jvm.internal.p.i(pulledText, "pulledText");
        if (shownText.length() == 0 && pulledText.length() == 0) {
            return false;
        }
        if (pulledText.length() < shownText.length()) {
            return true;
        }
        return shownText.length() > 0 && La.H.c0(shownText, pulledText, false, 2, null).length() == 0;
    }
}
