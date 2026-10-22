package com.stepos.ailauncher.agent.skill.installer;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installer/CommandKind;", "", "<init>", "(Ljava/lang/String;I)V", "INSTALL", "ENABLE", "DISABLE", "UNINSTALL", "UPDATE", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CommandKind {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ CommandKind[] $VALUES;
    public static final CommandKind INSTALL = new CommandKind("INSTALL", 0);
    public static final CommandKind ENABLE = new CommandKind("ENABLE", 1);
    public static final CommandKind DISABLE = new CommandKind("DISABLE", 2);
    public static final CommandKind UNINSTALL = new CommandKind("UNINSTALL", 3);
    public static final CommandKind UPDATE = new CommandKind("UPDATE", 4);

    private static final /* synthetic */ CommandKind[] $values() {
        return new CommandKind[]{INSTALL, ENABLE, DISABLE, UNINSTALL, UPDATE};
    }

    static {
        CommandKind[] commandKindArr$values = $values();
        $VALUES = commandKindArr$values;
        $ENTRIES = kotlin.enums.a.a(commandKindArr$values);
    }

    private CommandKind(String str, int i10) {
    }

    public static InterfaceC4149a<CommandKind> getEntries() {
        return $ENTRIES;
    }

    public static CommandKind valueOf(String str) {
        return (CommandKind) Enum.valueOf(CommandKind.class, str);
    }

    public static CommandKind[] values() {
        return (CommandKind[]) $VALUES.clone();
    }
}
