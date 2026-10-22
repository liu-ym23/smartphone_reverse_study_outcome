package com.stepos.agentframework.chatcore.session;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/ESessionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PREPARING", "READY", "PREPARE_ERROR", "AWAITING_REPLY", "REPLYING", "USER_CANCELLED", "ERROR_TERMINATED", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ESessionStatus {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ESessionStatus[] $VALUES;
    public static final ESessionStatus PREPARING = new ESessionStatus("PREPARING", 0);
    public static final ESessionStatus READY = new ESessionStatus("READY", 1);
    public static final ESessionStatus PREPARE_ERROR = new ESessionStatus("PREPARE_ERROR", 2);
    public static final ESessionStatus AWAITING_REPLY = new ESessionStatus("AWAITING_REPLY", 3);
    public static final ESessionStatus REPLYING = new ESessionStatus("REPLYING", 4);
    public static final ESessionStatus USER_CANCELLED = new ESessionStatus("USER_CANCELLED", 5);
    public static final ESessionStatus ERROR_TERMINATED = new ESessionStatus("ERROR_TERMINATED", 6);

    private static final /* synthetic */ ESessionStatus[] $values() {
        return new ESessionStatus[]{PREPARING, READY, PREPARE_ERROR, AWAITING_REPLY, REPLYING, USER_CANCELLED, ERROR_TERMINATED};
    }

    static {
        ESessionStatus[] eSessionStatusArr$values = $values();
        $VALUES = eSessionStatusArr$values;
        $ENTRIES = kotlin.enums.a.a(eSessionStatusArr$values);
    }

    private ESessionStatus(String str, int i10) {
    }

    public static InterfaceC4149a<ESessionStatus> getEntries() {
        return $ENTRIES;
    }

    public static ESessionStatus valueOf(String str) {
        return (ESessionStatus) Enum.valueOf(ESessionStatus.class, str);
    }

    public static ESessionStatus[] values() {
        return (ESessionStatus[]) $VALUES.clone();
    }
}
