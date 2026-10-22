package com.stepos.agentframework.floatcard.api;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/floatcard/api/FloatCardRiskLevel;", "", "<init>", "(Ljava/lang/String;I)V", "High", "Medium", "Low", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FloatCardRiskLevel {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ FloatCardRiskLevel[] $VALUES;
    public static final FloatCardRiskLevel High = new FloatCardRiskLevel("High", 0);
    public static final FloatCardRiskLevel Medium = new FloatCardRiskLevel("Medium", 1);
    public static final FloatCardRiskLevel Low = new FloatCardRiskLevel("Low", 2);

    private static final /* synthetic */ FloatCardRiskLevel[] $values() {
        return new FloatCardRiskLevel[]{High, Medium, Low};
    }

    static {
        FloatCardRiskLevel[] floatCardRiskLevelArr$values = $values();
        $VALUES = floatCardRiskLevelArr$values;
        $ENTRIES = a.a(floatCardRiskLevelArr$values);
    }

    private FloatCardRiskLevel(String str, int i10) {
    }

    public static InterfaceC4149a<FloatCardRiskLevel> getEntries() {
        return $ENTRIES;
    }

    public static FloatCardRiskLevel valueOf(String str) {
        return (FloatCardRiskLevel) Enum.valueOf(FloatCardRiskLevel.class, str);
    }

    public static FloatCardRiskLevel[] values() {
        return (FloatCardRiskLevel[]) $VALUES.clone();
    }
}
