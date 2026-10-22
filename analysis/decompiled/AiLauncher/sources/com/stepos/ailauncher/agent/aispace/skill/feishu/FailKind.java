package com.stepos.ailauncher.agent.aispace.skill.feishu;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FailKind;", "", "<init>", "(Ljava/lang/String;I)V", "Failed", "Timeout", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FailKind {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ FailKind[] $VALUES;
    public static final FailKind Failed = new FailKind("Failed", 0);
    public static final FailKind Timeout = new FailKind("Timeout", 1);

    private static final /* synthetic */ FailKind[] $values() {
        return new FailKind[]{Failed, Timeout};
    }

    static {
        FailKind[] failKindArr$values = $values();
        $VALUES = failKindArr$values;
        $ENTRIES = kotlin.enums.a.a(failKindArr$values);
    }

    private FailKind(String str, int i10) {
    }

    public static InterfaceC4149a<FailKind> getEntries() {
        return $ENTRIES;
    }

    public static FailKind valueOf(String str) {
        return (FailKind) Enum.valueOf(FailKind.class, str);
    }

    public static FailKind[] values() {
        return (FailKind[]) $VALUES.clone();
    }
}
