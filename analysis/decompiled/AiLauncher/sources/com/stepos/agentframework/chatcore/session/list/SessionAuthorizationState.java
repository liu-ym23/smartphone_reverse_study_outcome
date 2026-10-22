package com.stepos.agentframework.chatcore.session.list;

import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/list/SessionAuthorizationState;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "REQUIRED", "HIGH_RISK_CONFIRMATION", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionAuthorizationState {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SessionAuthorizationState[] $VALUES;
    public static final SessionAuthorizationState NONE = new SessionAuthorizationState(ModelFlowMeta.PLAN_NONE, 0);
    public static final SessionAuthorizationState REQUIRED = new SessionAuthorizationState("REQUIRED", 1);
    public static final SessionAuthorizationState HIGH_RISK_CONFIRMATION = new SessionAuthorizationState("HIGH_RISK_CONFIRMATION", 2);

    private static final /* synthetic */ SessionAuthorizationState[] $values() {
        return new SessionAuthorizationState[]{NONE, REQUIRED, HIGH_RISK_CONFIRMATION};
    }

    static {
        SessionAuthorizationState[] sessionAuthorizationStateArr$values = $values();
        $VALUES = sessionAuthorizationStateArr$values;
        $ENTRIES = kotlin.enums.a.a(sessionAuthorizationStateArr$values);
    }

    private SessionAuthorizationState(String str, int i10) {
    }

    public static InterfaceC4149a<SessionAuthorizationState> getEntries() {
        return $ENTRIES;
    }

    public static SessionAuthorizationState valueOf(String str) {
        return (SessionAuthorizationState) Enum.valueOf(SessionAuthorizationState.class, str);
    }

    public static SessionAuthorizationState[] values() {
        return (SessionAuthorizationState[]) $VALUES.clone();
    }
}
