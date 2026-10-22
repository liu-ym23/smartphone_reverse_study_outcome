package com.stepos.agentframework.chatcore.session;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/InterruptCause;", "", "abortReason", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getAbortReason", "()Ljava/lang/String;", "SEND_TIMEOUT", "POST_ACK_TIMEOUT", "STREAM_STALL", "TRANSPORT_ERROR", "watchdogTimeout", "", "getWatchdogTimeout", "()Z", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InterruptCause {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ InterruptCause[] $VALUES;
    private final String abortReason;
    public static final InterruptCause SEND_TIMEOUT = new InterruptCause("SEND_TIMEOUT", 0, "client.send_timeout");
    public static final InterruptCause POST_ACK_TIMEOUT = new InterruptCause("POST_ACK_TIMEOUT", 1, "client.post_ack_timeout");
    public static final InterruptCause STREAM_STALL = new InterruptCause("STREAM_STALL", 2, "client.stream_stall");
    public static final InterruptCause TRANSPORT_ERROR = new InterruptCause("TRANSPORT_ERROR", 3, "client.transport_error");

    private static final /* synthetic */ InterruptCause[] $values() {
        return new InterruptCause[]{SEND_TIMEOUT, POST_ACK_TIMEOUT, STREAM_STALL, TRANSPORT_ERROR};
    }

    static {
        InterruptCause[] interruptCauseArr$values = $values();
        $VALUES = interruptCauseArr$values;
        $ENTRIES = kotlin.enums.a.a(interruptCauseArr$values);
    }

    private InterruptCause(String str, int i10, String str2) {
        this.abortReason = str2;
    }

    public static InterfaceC4149a<InterruptCause> getEntries() {
        return $ENTRIES;
    }

    public static InterruptCause valueOf(String str) {
        return (InterruptCause) Enum.valueOf(InterruptCause.class, str);
    }

    public static InterruptCause[] values() {
        return (InterruptCause[]) $VALUES.clone();
    }

    public final String getAbortReason() {
        return this.abortReason;
    }

    public final boolean getWatchdogTimeout() {
        return this != TRANSPORT_ERROR;
    }
}
