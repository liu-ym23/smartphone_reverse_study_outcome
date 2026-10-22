package com.stepos.ame;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ame/PowerMode;", "", "<init>", "(Ljava/lang/String;I)V", "TURBO", "NOMINAL", "SVS", "SVS_PLUS", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PowerMode {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PowerMode[] $VALUES;
    public static final PowerMode TURBO = new PowerMode("TURBO", 0);
    public static final PowerMode NOMINAL = new PowerMode("NOMINAL", 1);
    public static final PowerMode SVS = new PowerMode("SVS", 2);
    public static final PowerMode SVS_PLUS = new PowerMode("SVS_PLUS", 3);

    private static final /* synthetic */ PowerMode[] $values() {
        return new PowerMode[]{TURBO, NOMINAL, SVS, SVS_PLUS};
    }

    static {
        PowerMode[] powerModeArr$values = $values();
        $VALUES = powerModeArr$values;
        $ENTRIES = a.a(powerModeArr$values);
    }

    private PowerMode(String str, int i10) {
    }

    public static InterfaceC4149a<PowerMode> getEntries() {
        return $ENTRIES;
    }

    public static PowerMode valueOf(String str) {
        return (PowerMode) Enum.valueOf(PowerMode.class, str);
    }

    public static PowerMode[] values() {
        return (PowerMode[]) $VALUES.clone();
    }
}
