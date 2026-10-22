package com.stepos.ailauncher.chat.view;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/chat/view/SessionAction;", "", "<init>", "(Ljava/lang/String;I)V", "Rename", "Delete", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionAction {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SessionAction[] $VALUES;
    public static final SessionAction Rename = new SessionAction("Rename", 0);
    public static final SessionAction Delete = new SessionAction("Delete", 1);

    private static final /* synthetic */ SessionAction[] $values() {
        return new SessionAction[]{Rename, Delete};
    }

    static {
        SessionAction[] sessionActionArr$values = $values();
        $VALUES = sessionActionArr$values;
        $ENTRIES = kotlin.enums.a.a(sessionActionArr$values);
    }

    private SessionAction(String str, int i10) {
    }

    public static InterfaceC4149a<SessionAction> getEntries() {
        return $ENTRIES;
    }

    public static SessionAction valueOf(String str) {
        return (SessionAction) Enum.valueOf(SessionAction.class, str);
    }

    public static SessionAction[] values() {
        return (SessionAction[]) $VALUES.clone();
    }
}
