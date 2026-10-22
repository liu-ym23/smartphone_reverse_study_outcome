package com.stepos.ame;

import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ame/ThermalStatus;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "LIGHT", "MODERATE", "SEVERE", "CRITICAL", "EMERGENCY", "SHUTDOWN", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ThermalStatus {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ThermalStatus[] $VALUES;
    public static final ThermalStatus NONE = new ThermalStatus(ModelFlowMeta.PLAN_NONE, 0);
    public static final ThermalStatus LIGHT = new ThermalStatus("LIGHT", 1);
    public static final ThermalStatus MODERATE = new ThermalStatus("MODERATE", 2);
    public static final ThermalStatus SEVERE = new ThermalStatus("SEVERE", 3);
    public static final ThermalStatus CRITICAL = new ThermalStatus("CRITICAL", 4);
    public static final ThermalStatus EMERGENCY = new ThermalStatus("EMERGENCY", 5);
    public static final ThermalStatus SHUTDOWN = new ThermalStatus("SHUTDOWN", 6);

    private static final /* synthetic */ ThermalStatus[] $values() {
        return new ThermalStatus[]{NONE, LIGHT, MODERATE, SEVERE, CRITICAL, EMERGENCY, SHUTDOWN};
    }

    static {
        ThermalStatus[] thermalStatusArr$values = $values();
        $VALUES = thermalStatusArr$values;
        $ENTRIES = a.a(thermalStatusArr$values);
    }

    private ThermalStatus(String str, int i10) {
    }

    public static InterfaceC4149a<ThermalStatus> getEntries() {
        return $ENTRIES;
    }

    public static ThermalStatus valueOf(String str) {
        return (ThermalStatus) Enum.valueOf(ThermalStatus.class, str);
    }

    public static ThermalStatus[] values() {
        return (ThermalStatus[]) $VALUES.clone();
    }
}
