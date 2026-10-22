package com.stepos.common;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/common/ReInstallMode;", "", "<init>", "(Ljava/lang/String;I)V", "CONFIG_ONLY", "FULL", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReInstallMode {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ReInstallMode[] $VALUES;
    public static final ReInstallMode CONFIG_ONLY = new ReInstallMode("CONFIG_ONLY", 0);
    public static final ReInstallMode FULL = new ReInstallMode("FULL", 1);

    private static final /* synthetic */ ReInstallMode[] $values() {
        return new ReInstallMode[]{CONFIG_ONLY, FULL};
    }

    static {
        ReInstallMode[] reInstallModeArr$values = $values();
        $VALUES = reInstallModeArr$values;
        $ENTRIES = a.a(reInstallModeArr$values);
    }

    private ReInstallMode(String str, int i10) {
    }

    public static InterfaceC4149a<ReInstallMode> getEntries() {
        return $ENTRIES;
    }

    public static ReInstallMode valueOf(String str) {
        return (ReInstallMode) Enum.valueOf(ReInstallMode.class, str);
    }

    public static ReInstallMode[] values() {
        return (ReInstallMode[]) $VALUES.clone();
    }
}
