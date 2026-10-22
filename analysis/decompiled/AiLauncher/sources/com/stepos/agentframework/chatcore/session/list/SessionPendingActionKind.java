package com.stepos.agentframework.chatcore.session.list;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/list/SessionPendingActionKind;", "", "", "storageValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getStorageValue$chatcore_release", "()Ljava/lang/String;", "Companion", Const.INTENT_KEY_APIKEY, "MAIN_AGENT_AUTHORIZATION", "MAIN_AGENT_HIGH_RISK_CONFIRMATION", "EXTERNAL_AGENT_AUTHORIZATION", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionPendingActionKind {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SessionPendingActionKind[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String storageValue;
    public static final SessionPendingActionKind MAIN_AGENT_AUTHORIZATION = new SessionPendingActionKind("MAIN_AGENT_AUTHORIZATION", 0, "main_agent_authorization");
    public static final SessionPendingActionKind MAIN_AGENT_HIGH_RISK_CONFIRMATION = new SessionPendingActionKind("MAIN_AGENT_HIGH_RISK_CONFIRMATION", 1, "main_agent_high_risk_confirmation");
    public static final SessionPendingActionKind EXTERNAL_AGENT_AUTHORIZATION = new SessionPendingActionKind("EXTERNAL_AGENT_AUTHORIZATION", 2, "external_agent_authorization");

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/list/SessionPendingActionKind$a;", "", "<init>", "()V", "", UxipConstants.f30680s, "Lcom/stepos/agentframework/chatcore/session/list/SessionPendingActionKind;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/list/SessionPendingActionKind;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.list.SessionPendingActionKind$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final SessionPendingActionKind a(String value) {
            SessionPendingActionKind next;
            p.i(value, "value");
            Iterator<SessionPendingActionKind> it = SessionPendingActionKind.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (p.d(next.getStorageValue(), value)) {
                    break;
                }
            }
            return next;
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ SessionPendingActionKind[] $values() {
        return new SessionPendingActionKind[]{MAIN_AGENT_AUTHORIZATION, MAIN_AGENT_HIGH_RISK_CONFIRMATION, EXTERNAL_AGENT_AUTHORIZATION};
    }

    static {
        SessionPendingActionKind[] sessionPendingActionKindArr$values = $values();
        $VALUES = sessionPendingActionKindArr$values;
        $ENTRIES = kotlin.enums.a.a(sessionPendingActionKindArr$values);
        INSTANCE = new Companion(null);
    }

    private SessionPendingActionKind(String str, int i10, String str2) {
        this.storageValue = str2;
    }

    public static InterfaceC4149a<SessionPendingActionKind> getEntries() {
        return $ENTRIES;
    }

    public static SessionPendingActionKind valueOf(String str) {
        return (SessionPendingActionKind) Enum.valueOf(SessionPendingActionKind.class, str);
    }

    public static SessionPendingActionKind[] values() {
        return (SessionPendingActionKind[]) $VALUES.clone();
    }

    /* renamed from: getStorageValue$chatcore_release, reason: from getter */
    public final String getStorageValue() {
        return this.storageValue;
    }
}
