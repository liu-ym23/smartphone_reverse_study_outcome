package com.stepos.agentframework.adapter.agentbus.bff;

import La.H;
import Z8.C1174w;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsActivity;
import h9.InterfaceC4149a;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import v9.C5685n;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\n\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/ExternalAgent;", "", "", "id", "displayName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getDisplayName", "Companion", Const.INTENT_KEY_APIKEY, "CLAUDE", "CODEX", "STEPAI", "DEEPSEEK", "DOUBAO", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExternalAgent {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ExternalAgent[] $VALUES;
    private static final Map<String, ExternalAgent> BY_ID;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Set<String> ids;
    private final String displayName;
    private final String id;
    public static final ExternalAgent CLAUDE = new ExternalAgent("CLAUDE", 0, "claude", "Claude");
    public static final ExternalAgent CODEX = new ExternalAgent("CODEX", 1, "codex", "Codex");
    public static final ExternalAgent STEPAI = new ExternalAgent("STEPAI", 2, ConnectedAgentsActivity.FILTER_STEPAI, "阶跃 AI");
    public static final ExternalAgent DEEPSEEK = new ExternalAgent("DEEPSEEK", 3, "deepseek", "DeepSeek");
    public static final ExternalAgent DOUBAO = new ExternalAgent("DOUBAO", 4, "doubao", "豆包");

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/ExternalAgent$a;", "", "<init>", "()V", "", "agentId", "Lcom/stepos/agentframework/adapter/agentbus/bff/ExternalAgent;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcom/stepos/agentframework/adapter/agentbus/bff/ExternalAgent;", "", "ids", "Ljava/util/Set;", Const.INTENT_KEY_APIKEY, "()Ljava/util/Set;", "", "BY_ID", "Ljava/util/Map;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.bff.ExternalAgent$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Set<String> a() {
            return ExternalAgent.ids;
        }

        public final ExternalAgent b(String agentId) {
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
            return (ExternalAgent) ExternalAgent.BY_ID.get(lowerCase);
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ ExternalAgent[] $values() {
        return new ExternalAgent[]{CLAUDE, CODEX, STEPAI, DEEPSEEK, DOUBAO};
    }

    static {
        ExternalAgent[] externalAgentArr$values = $values();
        $VALUES = externalAgentArr$values;
        $ENTRIES = kotlin.enums.a.a(externalAgentArr$values);
        INSTANCE = new Companion(null);
        InterfaceC4149a<ExternalAgent> entries = getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(entries, 10)), 16));
        for (ExternalAgent externalAgent : entries) {
            linkedHashMap.put(externalAgent.id, externalAgent);
        }
        BY_ID = linkedHashMap;
        ids = linkedHashMap.keySet();
    }

    private ExternalAgent(String str, int i10, String str2, String str3) {
        this.id = str2;
        this.displayName = str3;
    }

    public static InterfaceC4149a<ExternalAgent> getEntries() {
        return $ENTRIES;
    }

    public static ExternalAgent valueOf(String str) {
        return (ExternalAgent) Enum.valueOf(ExternalAgent.class, str);
    }

    public static ExternalAgent[] values() {
        return (ExternalAgent[]) $VALUES.clone();
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getId() {
        return this.id;
    }
}
