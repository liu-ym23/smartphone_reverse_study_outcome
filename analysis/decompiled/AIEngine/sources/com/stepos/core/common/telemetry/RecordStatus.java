package com.stepos.core.common.telemetry;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RecordStatus {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ RecordStatus[] $VALUES;
    public static final RecordStatus SUCCESS = new RecordStatus("SUCCESS", 0);
    public static final RecordStatus FAILED = new RecordStatus("FAILED", 1);
    public static final RecordStatus CANCELLED = new RecordStatus("CANCELLED", 2);
    public static final RecordStatus TIMEOUT = new RecordStatus("TIMEOUT", 3);

    private static final /* synthetic */ RecordStatus[] $values() {
        return new RecordStatus[]{SUCCESS, FAILED, CANCELLED, TIMEOUT};
    }

    static {
        RecordStatus[] recordStatusArr$values = $values();
        $VALUES = recordStatusArr$values;
        $ENTRIES = kotlin.enums.a.a(recordStatusArr$values);
    }

    private RecordStatus(String str, int i10) {
    }

    public static sb.a<RecordStatus> getEntries() {
        return $ENTRIES;
    }

    public static RecordStatus valueOf(String str) {
        return (RecordStatus) Enum.valueOf(RecordStatus.class, str);
    }

    public static RecordStatus[] values() {
        return (RecordStatus[]) $VALUES.clone();
    }
}
