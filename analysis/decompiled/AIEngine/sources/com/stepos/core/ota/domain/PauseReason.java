package com.stepos.core.ota.domain;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PauseReason {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ PauseReason[] $VALUES;
    public static final PauseReason USER = new PauseReason("USER", 0);
    public static final PauseReason NETWORK = new PauseReason("NETWORK", 1);
    public static final PauseReason EXTERNAL_NPU_BUSY = new PauseReason("EXTERNAL_NPU_BUSY", 2);
    public static final PauseReason LOW_BATTERY = new PauseReason("LOW_BATTERY", 3);
    public static final PauseReason THERMAL = new PauseReason("THERMAL", 4);
    public static final PauseReason SERVICE_DISABLED = new PauseReason("SERVICE_DISABLED", 5);
    public static final PauseReason INTERRUPTED = new PauseReason("INTERRUPTED", 6);

    private static final /* synthetic */ PauseReason[] $values() {
        return new PauseReason[]{USER, NETWORK, EXTERNAL_NPU_BUSY, LOW_BATTERY, THERMAL, SERVICE_DISABLED, INTERRUPTED};
    }

    static {
        PauseReason[] pauseReasonArr$values = $values();
        $VALUES = pauseReasonArr$values;
        $ENTRIES = kotlin.enums.a.a(pauseReasonArr$values);
    }

    private PauseReason(String str, int i10) {
    }

    public static sb.a<PauseReason> getEntries() {
        return $ENTRIES;
    }

    public static PauseReason valueOf(String str) {
        return (PauseReason) Enum.valueOf(PauseReason.class, str);
    }

    public static PauseReason[] values() {
        return (PauseReason[]) $VALUES.clone();
    }
}
