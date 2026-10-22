package com.stepos.ailauncher.chat.adapter;

import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/SessionIndicatorState;", "", "<init>", "(Ljava/lang/String;I)V", "SEND_FAILED", "FAILED", "WAITING_FOR_USER", "RUNNING", "COMPLETED_UNREAD", ModelFlowMeta.PLAN_NONE, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionIndicatorState {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SessionIndicatorState[] $VALUES;
    public static final SessionIndicatorState SEND_FAILED = new SessionIndicatorState("SEND_FAILED", 0);
    public static final SessionIndicatorState FAILED = new SessionIndicatorState("FAILED", 1);
    public static final SessionIndicatorState WAITING_FOR_USER = new SessionIndicatorState("WAITING_FOR_USER", 2);
    public static final SessionIndicatorState RUNNING = new SessionIndicatorState("RUNNING", 3);
    public static final SessionIndicatorState COMPLETED_UNREAD = new SessionIndicatorState("COMPLETED_UNREAD", 4);
    public static final SessionIndicatorState NONE = new SessionIndicatorState(ModelFlowMeta.PLAN_NONE, 5);

    private static final /* synthetic */ SessionIndicatorState[] $values() {
        return new SessionIndicatorState[]{SEND_FAILED, FAILED, WAITING_FOR_USER, RUNNING, COMPLETED_UNREAD, NONE};
    }

    static {
        SessionIndicatorState[] sessionIndicatorStateArr$values = $values();
        $VALUES = sessionIndicatorStateArr$values;
        $ENTRIES = kotlin.enums.a.a(sessionIndicatorStateArr$values);
    }

    private SessionIndicatorState(String str, int i10) {
    }

    public static InterfaceC4149a<SessionIndicatorState> getEntries() {
        return $ENTRIES;
    }

    public static SessionIndicatorState valueOf(String str) {
        return (SessionIndicatorState) Enum.valueOf(SessionIndicatorState.class, str);
    }

    public static SessionIndicatorState[] values() {
        return (SessionIndicatorState[]) $VALUES.clone();
    }
}
