package com.stepos.agentcache.sdk.api;

import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogLevel {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ LogLevel[] $VALUES;
    public static final LogLevel INFO = new LogLevel("INFO", 0);
    public static final LogLevel WARN = new LogLevel("WARN", 1);
    public static final LogLevel ERROR = new LogLevel("ERROR", 2);

    private static final /* synthetic */ LogLevel[] $values() {
        return new LogLevel[]{INFO, WARN, ERROR};
    }

    static {
        LogLevel[] logLevelArr$values = $values();
        $VALUES = logLevelArr$values;
        $ENTRIES = kotlin.enums.a.a(logLevelArr$values);
    }

    private LogLevel(String str, int i10) {
    }

    public static a<LogLevel> getEntries() {
        return $ENTRIES;
    }

    public static LogLevel valueOf(String str) {
        return (LogLevel) Enum.valueOf(LogLevel.class, str);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) $VALUES.clone();
    }
}
