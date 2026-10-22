package com.stepos.agentcache.sdk.api;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentcache/sdk/api/LogLevel;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "INFO", "WARN", "ERROR", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    private LogLevel(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static LogLevel valueOf(String str) {
        return (LogLevel) Enum.valueOf(LogLevel.class, str);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) $VALUES.clone();
    }
}
