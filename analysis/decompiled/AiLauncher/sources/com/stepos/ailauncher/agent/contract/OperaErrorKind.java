package com.stepos.ailauncher.agent.contract;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;", "", "<init>", "(Ljava/lang/String;I)V", "INSTALL", "CANCEL", "ENABLE", "DISABLE", "UNINSTALL", "UPDATE", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OperaErrorKind {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ OperaErrorKind[] $VALUES;
    public static final OperaErrorKind INSTALL = new OperaErrorKind("INSTALL", 0);
    public static final OperaErrorKind CANCEL = new OperaErrorKind("CANCEL", 1);
    public static final OperaErrorKind ENABLE = new OperaErrorKind("ENABLE", 2);
    public static final OperaErrorKind DISABLE = new OperaErrorKind("DISABLE", 3);
    public static final OperaErrorKind UNINSTALL = new OperaErrorKind("UNINSTALL", 4);
    public static final OperaErrorKind UPDATE = new OperaErrorKind("UPDATE", 5);

    private static final /* synthetic */ OperaErrorKind[] $values() {
        return new OperaErrorKind[]{INSTALL, CANCEL, ENABLE, DISABLE, UNINSTALL, UPDATE};
    }

    static {
        OperaErrorKind[] operaErrorKindArr$values = $values();
        $VALUES = operaErrorKindArr$values;
        $ENTRIES = a.a(operaErrorKindArr$values);
    }

    private OperaErrorKind(String str, int i10) {
    }

    public static InterfaceC4149a<OperaErrorKind> getEntries() {
        return $ENTRIES;
    }

    public static OperaErrorKind valueOf(String str) {
        return (OperaErrorKind) Enum.valueOf(OperaErrorKind.class, str);
    }

    public static OperaErrorKind[] values() {
        return (OperaErrorKind[]) $VALUES.clone();
    }
}
