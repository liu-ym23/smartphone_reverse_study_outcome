package com.stepos.core.ota.install;

import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ExtractMode {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ ExtractMode[] $VALUES;
    public static final ExtractMode ASYNC = new ExtractMode("ASYNC", 0);
    public static final ExtractMode SYNC = new ExtractMode("SYNC", 1);
    public static final ExtractMode SKIP_IF_MISSING = new ExtractMode("SKIP_IF_MISSING", 2);

    private static final /* synthetic */ ExtractMode[] $values() {
        return new ExtractMode[]{ASYNC, SYNC, SKIP_IF_MISSING};
    }

    static {
        ExtractMode[] extractModeArr$values = $values();
        $VALUES = extractModeArr$values;
        $ENTRIES = kotlin.enums.a.a(extractModeArr$values);
    }

    private ExtractMode(String str, int i10) {
    }

    public static a<ExtractMode> getEntries() {
        return $ENTRIES;
    }

    public static ExtractMode valueOf(String str) {
        return (ExtractMode) Enum.valueOf(ExtractMode.class, str);
    }

    public static ExtractMode[] values() {
        return (ExtractMode[]) $VALUES.clone();
    }
}
