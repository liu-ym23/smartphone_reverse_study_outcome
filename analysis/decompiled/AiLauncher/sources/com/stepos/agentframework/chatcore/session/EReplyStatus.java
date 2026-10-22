package com.stepos.agentframework.chatcore.session;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "", "<init>", "(Ljava/lang/String;I)V", "START", "TOOL_EXECUTING", "REPLYING", "COMPLETED", "CANCELED", "ERROR", "isTerminal", "", "mergeWithIncoming", "incoming", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EReplyStatus {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ EReplyStatus[] $VALUES;
    public static final EReplyStatus START = new EReplyStatus("START", 0);
    public static final EReplyStatus TOOL_EXECUTING = new EReplyStatus("TOOL_EXECUTING", 1);
    public static final EReplyStatus REPLYING = new EReplyStatus("REPLYING", 2);
    public static final EReplyStatus COMPLETED = new EReplyStatus("COMPLETED", 3);
    public static final EReplyStatus CANCELED = new EReplyStatus("CANCELED", 4);
    public static final EReplyStatus ERROR = new EReplyStatus("ERROR", 5);

    private static final /* synthetic */ EReplyStatus[] $values() {
        return new EReplyStatus[]{START, TOOL_EXECUTING, REPLYING, COMPLETED, CANCELED, ERROR};
    }

    static {
        EReplyStatus[] eReplyStatusArr$values = $values();
        $VALUES = eReplyStatusArr$values;
        $ENTRIES = kotlin.enums.a.a(eReplyStatusArr$values);
    }

    private EReplyStatus(String str, int i10) {
    }

    public static InterfaceC4149a<EReplyStatus> getEntries() {
        return $ENTRIES;
    }

    public static EReplyStatus valueOf(String str) {
        return (EReplyStatus) Enum.valueOf(EReplyStatus.class, str);
    }

    public static EReplyStatus[] values() {
        return (EReplyStatus[]) $VALUES.clone();
    }

    public final boolean isTerminal() {
        return this == COMPLETED || this == CANCELED || this == ERROR;
    }

    public final EReplyStatus mergeWithIncoming(EReplyStatus incoming) {
        EReplyStatus eReplyStatus;
        kotlin.jvm.internal.p.i(incoming, "incoming");
        return !isTerminal() ? incoming : (incoming.isTerminal() && (this == (eReplyStatus = COMPLETED) || incoming != eReplyStatus)) ? incoming : this;
    }
}
