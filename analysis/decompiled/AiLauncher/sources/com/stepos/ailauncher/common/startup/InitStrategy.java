package com.stepos.ailauncher.common.startup;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/common/startup/InitStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_IMMEDIATE", "MAIN_IDLE", "BACKGROUND", "DELAYED", "LAZY", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InitStrategy {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ InitStrategy[] $VALUES;
    public static final InitStrategy MAIN_IMMEDIATE = new InitStrategy("MAIN_IMMEDIATE", 0);
    public static final InitStrategy MAIN_IDLE = new InitStrategy("MAIN_IDLE", 1);
    public static final InitStrategy BACKGROUND = new InitStrategy("BACKGROUND", 2);
    public static final InitStrategy DELAYED = new InitStrategy("DELAYED", 3);
    public static final InitStrategy LAZY = new InitStrategy("LAZY", 4);

    private static final /* synthetic */ InitStrategy[] $values() {
        return new InitStrategy[]{MAIN_IMMEDIATE, MAIN_IDLE, BACKGROUND, DELAYED, LAZY};
    }

    static {
        InitStrategy[] initStrategyArr$values = $values();
        $VALUES = initStrategyArr$values;
        $ENTRIES = kotlin.enums.a.a(initStrategyArr$values);
    }

    private InitStrategy(String str, int i10) {
    }

    public static InterfaceC4149a<InitStrategy> getEntries() {
        return $ENTRIES;
    }

    public static InitStrategy valueOf(String str) {
        return (InitStrategy) Enum.valueOf(InitStrategy.class, str);
    }

    public static InitStrategy[] values() {
        return (InitStrategy[]) $VALUES.clone();
    }
}
