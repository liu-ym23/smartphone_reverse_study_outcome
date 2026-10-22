package com.stepos.agentframework.adapter.agentbus.bff;

import La.H;
import Z8.C1174w;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.Configuration;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import h9.InterfaceC4149a;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import v9.C5685n;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/PrimaryAgent;", "", "", "id", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Companion", Const.INTENT_KEY_APIKEY, "AMOO", "AGENT_BUS", "OPEN_CLAW", "STEP_CLAW", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PrimaryAgent {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PrimaryAgent[] $VALUES;
    private static final Map<String, PrimaryAgent> BY_ID;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String DISPLAY_NAME = "Amoo";
    private final String id;
    public static final PrimaryAgent AMOO = new PrimaryAgent("AMOO", 0, DidiCardProvider.MARKET_SOURCE);
    public static final PrimaryAgent AGENT_BUS = new PrimaryAgent("AGENT_BUS", 1, "agent_bus");
    public static final PrimaryAgent OPEN_CLAW = new PrimaryAgent("OPEN_CLAW", 2, "open_claw");
    public static final PrimaryAgent STEP_CLAW = new PrimaryAgent("STEP_CLAW", 3, Configuration.OPENCLAW_FIXED_AGENT_ID);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/PrimaryAgent$a;", "", "<init>", "()V", "", "agentId", "Lcom/stepos/agentframework/adapter/agentbus/bff/PrimaryAgent;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcom/stepos/agentframework/adapter/agentbus/bff/PrimaryAgent;", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", "DISPLAY_NAME", "Ljava/lang/String;", "", "BY_ID", "Ljava/util/Map;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.bff.PrimaryAgent$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a(String agentId) {
            return b(agentId) != null;
        }

        public final PrimaryAgent b(String agentId) {
            String string;
            if (agentId == null || (string = H.D1(agentId).toString()) == null) {
                return null;
            }
            Locale ROOT = Locale.ROOT;
            kotlin.jvm.internal.p.h(ROOT, "ROOT");
            String lowerCase = string.toLowerCase(ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            if (lowerCase == null) {
                return null;
            }
            return (PrimaryAgent) PrimaryAgent.BY_ID.get(lowerCase);
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ PrimaryAgent[] $values() {
        return new PrimaryAgent[]{AMOO, AGENT_BUS, OPEN_CLAW, STEP_CLAW};
    }

    static {
        PrimaryAgent[] primaryAgentArr$values = $values();
        $VALUES = primaryAgentArr$values;
        $ENTRIES = kotlin.enums.a.a(primaryAgentArr$values);
        INSTANCE = new Companion(null);
        InterfaceC4149a<PrimaryAgent> entries = getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(entries, 10)), 16));
        for (PrimaryAgent primaryAgent : entries) {
            linkedHashMap.put(primaryAgent.id, primaryAgent);
        }
        BY_ID = linkedHashMap;
    }

    private PrimaryAgent(String str, int i10, String str2) {
        this.id = str2;
    }

    public static InterfaceC4149a<PrimaryAgent> getEntries() {
        return $ENTRIES;
    }

    public static PrimaryAgent valueOf(String str) {
        return (PrimaryAgent) Enum.valueOf(PrimaryAgent.class, str);
    }

    public static PrimaryAgent[] values() {
        return (PrimaryAgent[]) $VALUES.clone();
    }

    public final String getId() {
        return this.id;
    }
}
