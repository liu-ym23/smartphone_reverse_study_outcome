package com.stepos.agentframework.chatcore.session.list;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY", "EXTERNAL", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionAgentCategory {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SessionAgentCategory[] $VALUES;
    public static final SessionAgentCategory PRIMARY = new SessionAgentCategory("PRIMARY", 0);
    public static final SessionAgentCategory EXTERNAL = new SessionAgentCategory("EXTERNAL", 1);

    private static final /* synthetic */ SessionAgentCategory[] $values() {
        return new SessionAgentCategory[]{PRIMARY, EXTERNAL};
    }

    static {
        SessionAgentCategory[] sessionAgentCategoryArr$values = $values();
        $VALUES = sessionAgentCategoryArr$values;
        $ENTRIES = kotlin.enums.a.a(sessionAgentCategoryArr$values);
    }

    private SessionAgentCategory(String str, int i10) {
    }

    public static InterfaceC4149a<SessionAgentCategory> getEntries() {
        return $ENTRIES;
    }

    public static SessionAgentCategory valueOf(String str) {
        return (SessionAgentCategory) Enum.valueOf(SessionAgentCategory.class, str);
    }

    public static SessionAgentCategory[] values() {
        return (SessionAgentCategory[]) $VALUES.clone();
    }
}
