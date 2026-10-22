package com.stepos.ability.commoninternal;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ability/commoninternal/AbilityType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "UNKNOWN", "LOCAL_MCP", "LOCAL_APP_FUNCTIONS", "REMOTE_MCP", "commonInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ AbilityType[] $VALUES;
    public static final AbilityType UNKNOWN = new AbilityType("UNKNOWN", 0);
    public static final AbilityType LOCAL_MCP = new AbilityType("LOCAL_MCP", 1);
    public static final AbilityType LOCAL_APP_FUNCTIONS = new AbilityType("LOCAL_APP_FUNCTIONS", 2);
    public static final AbilityType REMOTE_MCP = new AbilityType("REMOTE_MCP", 3);

    private static final /* synthetic */ AbilityType[] $values() {
        return new AbilityType[]{UNKNOWN, LOCAL_MCP, LOCAL_APP_FUNCTIONS, REMOTE_MCP};
    }

    static {
        AbilityType[] abilityTypeArr$values = $values();
        $VALUES = abilityTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(abilityTypeArr$values);
    }

    private AbilityType(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static AbilityType valueOf(String str) {
        return (AbilityType) Enum.valueOf(AbilityType.class, str);
    }

    public static AbilityType[] values() {
        return (AbilityType[]) $VALUES.clone();
    }
}
