package com.stepos.ailauncher.chat.fragment;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/CliKind;", "", "<init>", "(Ljava/lang/String;I)V", "FEISHU", "WECOM", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CliKind {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ CliKind[] $VALUES;
    public static final CliKind FEISHU = new CliKind("FEISHU", 0);
    public static final CliKind WECOM = new CliKind("WECOM", 1);

    private static final /* synthetic */ CliKind[] $values() {
        return new CliKind[]{FEISHU, WECOM};
    }

    static {
        CliKind[] cliKindArr$values = $values();
        $VALUES = cliKindArr$values;
        $ENTRIES = kotlin.enums.a.a(cliKindArr$values);
    }

    private CliKind(String str, int i10) {
    }

    public static InterfaceC4149a<CliKind> getEntries() {
        return $ENTRIES;
    }

    public static CliKind valueOf(String str) {
        return (CliKind) Enum.valueOf(CliKind.class, str);
    }

    public static CliKind[] values() {
        return (CliKind[]) $VALUES.clone();
    }
}
