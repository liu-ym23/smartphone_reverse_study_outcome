package com.stepos.ailauncher.agent.aispace.market;

import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import java.util.Locale;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0005\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", "", "<init>", "(Ljava/lang/String;I)V", "", "isInFlight", "()Z", "isInstalled", "Companion", Const.INTENT_KEY_APIKEY, "NOT_INSTALLED", "INSTALLING", "QUEUED", "INSTALLED_ENABLED", "INSTALLED_DISABLED", "UNINSTALLING", "UPDATING", "INSTALL_FAILED", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentMarketStatus {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ AgentMarketStatus[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final AgentMarketStatus NOT_INSTALLED = new AgentMarketStatus("NOT_INSTALLED", 0);
    public static final AgentMarketStatus INSTALLING = new AgentMarketStatus("INSTALLING", 1);
    public static final AgentMarketStatus QUEUED = new AgentMarketStatus("QUEUED", 2);
    public static final AgentMarketStatus INSTALLED_ENABLED = new AgentMarketStatus("INSTALLED_ENABLED", 3);
    public static final AgentMarketStatus INSTALLED_DISABLED = new AgentMarketStatus("INSTALLED_DISABLED", 4);
    public static final AgentMarketStatus UNINSTALLING = new AgentMarketStatus("UNINSTALLING", 5);
    public static final AgentMarketStatus UPDATING = new AgentMarketStatus("UPDATING", 6);
    public static final AgentMarketStatus INSTALL_FAILED = new AgentMarketStatus("INSTALL_FAILED", 7);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus$a;", "", "<init>", "()V", "", "status", "", x5.d.EXTRA_ENABLED, "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Z)Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketStatus$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AgentMarketStatus a(String status, boolean enabled) {
            String upperCase;
            if (status != null) {
                upperCase = status.toUpperCase(Locale.ROOT);
                kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
            } else {
                upperCase = null;
            }
            if (upperCase == null) {
                return null;
            }
            switch (upperCase.hashCode()) {
                case -805319996:
                    if (upperCase.equals("AGENT_STATUS_PENDING")) {
                        return AgentMarketStatus.QUEUED;
                    }
                    return null;
                case -398663686:
                    if (upperCase.equals("AGENT_STATUS_INSTALLING")) {
                        return AgentMarketStatus.INSTALLING;
                    }
                    return null;
                case 113944211:
                    if (upperCase.equals("AGENT_STATUS_UNINSTALLING")) {
                        return AgentMarketStatus.UNINSTALLING;
                    }
                    return null;
                case 347691402:
                    if (!upperCase.equals("AGENT_STATUS_INSTALL_SUCCEEDED")) {
                        return null;
                    }
                    break;
                case 735356113:
                    if (upperCase.equals("AGENT_STATUS_UNINSTALL_SUCCEEDED")) {
                        return AgentMarketStatus.NOT_INSTALLED;
                    }
                    return null;
                case 938531840:
                    if (!upperCase.equals("AGENT_STATUS_UPDATE_FAILED")) {
                        return null;
                    }
                    break;
                case 990855085:
                    if (!upperCase.equals("AGENT_STATUS_UNINSTALL_FAILED")) {
                        return null;
                    }
                    break;
                case 1013476756:
                    if (upperCase.equals("AGENT_STATUS_INSTALL_FAILED")) {
                        return AgentMarketStatus.INSTALL_FAILED;
                    }
                    return null;
                case 1046692766:
                    if (!upperCase.equals("AGENT_STATUS_UPDATE_SUCCEEDED")) {
                        return null;
                    }
                    break;
                case 1812867993:
                    if (upperCase.equals("AGENT_STATUS_UPDATING")) {
                        return AgentMarketStatus.UPDATING;
                    }
                    return null;
                default:
                    return null;
            }
            return enabled ? AgentMarketStatus.INSTALLED_ENABLED : AgentMarketStatus.INSTALLED_DISABLED;
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ AgentMarketStatus[] $values() {
        return new AgentMarketStatus[]{NOT_INSTALLED, INSTALLING, QUEUED, INSTALLED_ENABLED, INSTALLED_DISABLED, UNINSTALLING, UPDATING, INSTALL_FAILED};
    }

    static {
        AgentMarketStatus[] agentMarketStatusArr$values = $values();
        $VALUES = agentMarketStatusArr$values;
        $ENTRIES = kotlin.enums.a.a(agentMarketStatusArr$values);
        INSTANCE = new Companion(null);
    }

    private AgentMarketStatus(String str, int i10) {
    }

    public static InterfaceC4149a<AgentMarketStatus> getEntries() {
        return $ENTRIES;
    }

    public static AgentMarketStatus valueOf(String str) {
        return (AgentMarketStatus) Enum.valueOf(AgentMarketStatus.class, str);
    }

    public static AgentMarketStatus[] values() {
        return (AgentMarketStatus[]) $VALUES.clone();
    }

    public final boolean isInFlight() {
        return this == INSTALLING || this == QUEUED || this == UNINSTALLING || this == UPDATING;
    }

    public final boolean isInstalled() {
        return this == INSTALLED_ENABLED || this == INSTALLED_DISABLED;
    }
}
