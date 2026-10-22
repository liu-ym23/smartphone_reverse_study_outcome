package com.stepos.ailauncher.contract.model.search;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/contract/model/search/SidebarSessionKind;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "MAIN", "CHANNEL", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SidebarSessionKind {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SidebarSessionKind[] $VALUES;
    public static final SidebarSessionKind NORMAL = new SidebarSessionKind("NORMAL", 0);
    public static final SidebarSessionKind MAIN = new SidebarSessionKind("MAIN", 1);
    public static final SidebarSessionKind CHANNEL = new SidebarSessionKind("CHANNEL", 2);

    private static final /* synthetic */ SidebarSessionKind[] $values() {
        return new SidebarSessionKind[]{NORMAL, MAIN, CHANNEL};
    }

    static {
        SidebarSessionKind[] sidebarSessionKindArr$values = $values();
        $VALUES = sidebarSessionKindArr$values;
        $ENTRIES = a.a(sidebarSessionKindArr$values);
    }

    private SidebarSessionKind(String str, int i10) {
    }

    public static InterfaceC4149a<SidebarSessionKind> getEntries() {
        return $ENTRIES;
    }

    public static SidebarSessionKind valueOf(String str) {
        return (SidebarSessionKind) Enum.valueOf(SidebarSessionKind.class, str);
    }

    public static SidebarSessionKind[] values() {
        return (SidebarSessionKind[]) $VALUES.clone();
    }
}
