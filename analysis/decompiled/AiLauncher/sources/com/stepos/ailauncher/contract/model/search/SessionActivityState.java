package com.stepos.ailauncher.contract.model.search;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "", "<init>", "(Ljava/lang/String;I)V", "RUNNING", "WAITING_FOR_USER", "COMPLETED_UNREAD", "FAILED", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionActivityState {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SessionActivityState[] $VALUES;
    public static final SessionActivityState RUNNING = new SessionActivityState("RUNNING", 0);
    public static final SessionActivityState WAITING_FOR_USER = new SessionActivityState("WAITING_FOR_USER", 1);
    public static final SessionActivityState COMPLETED_UNREAD = new SessionActivityState("COMPLETED_UNREAD", 2);
    public static final SessionActivityState FAILED = new SessionActivityState("FAILED", 3);

    private static final /* synthetic */ SessionActivityState[] $values() {
        return new SessionActivityState[]{RUNNING, WAITING_FOR_USER, COMPLETED_UNREAD, FAILED};
    }

    static {
        SessionActivityState[] sessionActivityStateArr$values = $values();
        $VALUES = sessionActivityStateArr$values;
        $ENTRIES = a.a(sessionActivityStateArr$values);
    }

    private SessionActivityState(String str, int i10) {
    }

    public static InterfaceC4149a<SessionActivityState> getEntries() {
        return $ENTRIES;
    }

    public static SessionActivityState valueOf(String str) {
        return (SessionActivityState) Enum.valueOf(SessionActivityState.class, str);
    }

    public static SessionActivityState[] values() {
        return (SessionActivityState[]) $VALUES.clone();
    }
}
