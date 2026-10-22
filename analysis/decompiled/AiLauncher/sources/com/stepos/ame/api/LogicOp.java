package com.stepos.ame.api;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ame/api/LogicOp;", "", "<init>", "(Ljava/lang/String;I)V", "AND", "OR", "NOT", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LogicOp {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ LogicOp[] $VALUES;
    public static final LogicOp AND = new LogicOp("AND", 0);
    public static final LogicOp OR = new LogicOp("OR", 1);
    public static final LogicOp NOT = new LogicOp("NOT", 2);

    private static final /* synthetic */ LogicOp[] $values() {
        return new LogicOp[]{AND, OR, NOT};
    }

    static {
        LogicOp[] logicOpArr$values = $values();
        $VALUES = logicOpArr$values;
        $ENTRIES = a.a(logicOpArr$values);
    }

    private LogicOp(String str, int i10) {
    }

    public static InterfaceC4149a<LogicOp> getEntries() {
        return $ENTRIES;
    }

    public static LogicOp valueOf(String str) {
        return (LogicOp) Enum.valueOf(LogicOp.class, str);
    }

    public static LogicOp[] values() {
        return (LogicOp[]) $VALUES.clone();
    }
}
