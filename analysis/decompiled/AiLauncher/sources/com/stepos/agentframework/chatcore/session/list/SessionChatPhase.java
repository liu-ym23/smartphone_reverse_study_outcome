package com.stepos.agentframework.chatcore.session.list;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;", "", "<init>", "(Ljava/lang/String;I)V", "REPLYING", "REPLIED", "WAITING", "FAILED", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionChatPhase {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SessionChatPhase[] $VALUES;
    public static final SessionChatPhase REPLYING = new SessionChatPhase("REPLYING", 0);
    public static final SessionChatPhase REPLIED = new SessionChatPhase("REPLIED", 1);
    public static final SessionChatPhase WAITING = new SessionChatPhase("WAITING", 2);
    public static final SessionChatPhase FAILED = new SessionChatPhase("FAILED", 3);

    private static final /* synthetic */ SessionChatPhase[] $values() {
        return new SessionChatPhase[]{REPLYING, REPLIED, WAITING, FAILED};
    }

    static {
        SessionChatPhase[] sessionChatPhaseArr$values = $values();
        $VALUES = sessionChatPhaseArr$values;
        $ENTRIES = kotlin.enums.a.a(sessionChatPhaseArr$values);
    }

    private SessionChatPhase(String str, int i10) {
    }

    public static InterfaceC4149a<SessionChatPhase> getEntries() {
        return $ENTRIES;
    }

    public static SessionChatPhase valueOf(String str) {
        return (SessionChatPhase) Enum.valueOf(SessionChatPhase.class, str);
    }

    public static SessionChatPhase[] values() {
        return (SessionChatPhase[]) $VALUES.clone();
    }
}
