package com.stepos.core.ota.domain;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TriggerSource {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ TriggerSource[] $VALUES;
    public static final TriggerSource USER = new TriggerSource("USER", 0);
    public static final TriggerSource AUTO_DAILY = new TriggerSource("AUTO_DAILY", 1);
    public static final TriggerSource PUSH = new TriggerSource("PUSH", 2);
    public static final TriggerSource SILENT = new TriggerSource("SILENT", 3);
    public static final TriggerSource DEPENDENCY = new TriggerSource("DEPENDENCY", 4);
    public static final TriggerSource PREINSTALL = new TriggerSource("PREINSTALL", 5);
    public static final TriggerSource RETRY = new TriggerSource("RETRY", 6);
    public static final TriggerSource PUSH_FORCE = new TriggerSource("PUSH_FORCE", 7);

    private static final /* synthetic */ TriggerSource[] $values() {
        return new TriggerSource[]{USER, AUTO_DAILY, PUSH, SILENT, DEPENDENCY, PREINSTALL, RETRY, PUSH_FORCE};
    }

    static {
        TriggerSource[] triggerSourceArr$values = $values();
        $VALUES = triggerSourceArr$values;
        $ENTRIES = kotlin.enums.a.a(triggerSourceArr$values);
    }

    private TriggerSource(String str, int i10) {
    }

    public static sb.a<TriggerSource> getEntries() {
        return $ENTRIES;
    }

    public static TriggerSource valueOf(String str) {
        return (TriggerSource) Enum.valueOf(TriggerSource.class, str);
    }

    public static TriggerSource[] values() {
        return (TriggerSource[]) $VALUES.clone();
    }
}
