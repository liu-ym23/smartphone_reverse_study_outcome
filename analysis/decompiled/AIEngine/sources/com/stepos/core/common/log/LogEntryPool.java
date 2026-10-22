package com.stepos.core.common.log;

import java.util.Map;
import kotlin.jvm.internal.g;
import mb.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogEntryPool {
    private static final int POOL_SIZE = 64;
    public static final LogEntryPool INSTANCE = new LogEntryPool();
    private static final k<LogEntry> pool = new k<>(64);
    private static final Object lock = new Object();

    private LogEntryPool() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LogEntry obtain$default(LogEntryPool logEntryPool, LogLevel logLevel, LogModule logModule, String str, String str2, Throwable th, Map map, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            th = null;
        }
        if ((i10 & 32) != 0) {
            map = null;
        }
        return logEntryPool.obtain(logLevel, logModule, str, str2, th, map);
    }

    public final LogEntry obtain(LogLevel level, LogModule module, String tag, String message, Throwable th, Map<String, ? extends Object> map) {
        g.f(level, "level");
        g.f(module, "module");
        g.f(tag, "tag");
        g.f(message, "message");
        return LogEntry.Companion.create(level, module, tag, message, th, map);
    }

    public final void recycle(LogEntry entry) {
        g.f(entry, "entry");
    }
}
