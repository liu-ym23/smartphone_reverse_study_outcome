package com.zyql.logbox;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/zyql/logbox/LogStorageMode;", "", "<init>", "(Ljava/lang/String;I)V", "SEPARATED", "SHARED", "logbox_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LogStorageMode {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ LogStorageMode[] $VALUES;
    public static final LogStorageMode SEPARATED = new LogStorageMode("SEPARATED", 0);
    public static final LogStorageMode SHARED = new LogStorageMode("SHARED", 1);

    private static final /* synthetic */ LogStorageMode[] $values() {
        return new LogStorageMode[]{SEPARATED, SHARED};
    }

    static {
        LogStorageMode[] logStorageModeArr$values = $values();
        $VALUES = logStorageModeArr$values;
        $ENTRIES = a.a(logStorageModeArr$values);
    }

    private LogStorageMode(String str, int i10) {
    }

    public static InterfaceC4149a<LogStorageMode> getEntries() {
        return $ENTRIES;
    }

    public static LogStorageMode valueOf(String str) {
        return (LogStorageMode) Enum.valueOf(LogStorageMode.class, str);
    }

    public static LogStorageMode[] values() {
        return (LogStorageMode[]) $VALUES.clone();
    }
}
