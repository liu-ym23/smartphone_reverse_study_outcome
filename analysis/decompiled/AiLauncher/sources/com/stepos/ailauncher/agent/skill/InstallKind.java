package com.stepos.ailauncher.agent.skill;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/InstallKind;", "", "<init>", "(Ljava/lang/String;I)V", "SKILL", "CLI", "AGENT", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstallKind {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ InstallKind[] $VALUES;
    public static final InstallKind SKILL = new InstallKind("SKILL", 0);
    public static final InstallKind CLI = new InstallKind("CLI", 1);
    public static final InstallKind AGENT = new InstallKind("AGENT", 2);

    private static final /* synthetic */ InstallKind[] $values() {
        return new InstallKind[]{SKILL, CLI, AGENT};
    }

    static {
        InstallKind[] installKindArr$values = $values();
        $VALUES = installKindArr$values;
        $ENTRIES = a.a(installKindArr$values);
    }

    private InstallKind(String str, int i10) {
    }

    public static InterfaceC4149a<InstallKind> getEntries() {
        return $ENTRIES;
    }

    public static InstallKind valueOf(String str) {
        return (InstallKind) Enum.valueOf(InstallKind.class, str);
    }

    public static InstallKind[] values() {
        return (InstallKind[]) $VALUES.clone();
    }
}
