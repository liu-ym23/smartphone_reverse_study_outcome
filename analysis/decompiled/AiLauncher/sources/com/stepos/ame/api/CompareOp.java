package com.stepos.ame.api;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/stepos/ame/api/CompareOp;", "", "<init>", "(Ljava/lang/String;I)V", "EQ", "NE", "GT", "GE", "LT", "LE", "IN", "NOT_IN", "BETWEEN", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CompareOp {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ CompareOp[] $VALUES;
    public static final CompareOp EQ = new CompareOp("EQ", 0);
    public static final CompareOp NE = new CompareOp("NE", 1);
    public static final CompareOp GT = new CompareOp("GT", 2);
    public static final CompareOp GE = new CompareOp("GE", 3);
    public static final CompareOp LT = new CompareOp("LT", 4);
    public static final CompareOp LE = new CompareOp("LE", 5);
    public static final CompareOp IN = new CompareOp("IN", 6);
    public static final CompareOp NOT_IN = new CompareOp("NOT_IN", 7);
    public static final CompareOp BETWEEN = new CompareOp("BETWEEN", 8);

    private static final /* synthetic */ CompareOp[] $values() {
        return new CompareOp[]{EQ, NE, GT, GE, LT, LE, IN, NOT_IN, BETWEEN};
    }

    static {
        CompareOp[] compareOpArr$values = $values();
        $VALUES = compareOpArr$values;
        $ENTRIES = a.a(compareOpArr$values);
    }

    private CompareOp(String str, int i10) {
    }

    public static InterfaceC4149a<CompareOp> getEntries() {
        return $ENTRIES;
    }

    public static CompareOp valueOf(String str) {
        return (CompareOp) Enum.valueOf(CompareOp.class, str);
    }

    public static CompareOp[] values() {
        return (CompareOp[]) $VALUES.clone();
    }
}
