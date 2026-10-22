package com.byted.cast.sdk.log;

import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes43.dex */
public class LoggerManager {
    private static final Map<String, Logger> LOGGER_CACHE = null;

    static {
        LOGGER_CACHE = new WeakHashMap();
    }

    private LoggerManager() {
        throw new UnsupportedOperationException();
    }

    public static Logger getLogger(String r100) {
        Map<String, Logger> r101 = LOGGER_CACHE;
        monitor-enter(r101);
        Logger r102 = r101.get(r100);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        if (r102 != null) goto L15;
        r102 = new Logger(r100);
        monitor-enter(r101);
        r101.put(r100, r102);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        return r102;
    L16:
        th = move-exception;
        throw th;
    }
}
