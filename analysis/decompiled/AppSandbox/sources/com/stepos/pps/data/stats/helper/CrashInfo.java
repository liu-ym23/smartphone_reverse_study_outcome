package com.stepos.pps.data.stats.helper;

import stepos.android.server.ErrorSource;

/* loaded from: classes.dex */
public class CrashInfo {
    long currentMillis;
    String desc;
    ErrorSource errorSource;
    String eventType;
    String foregroundState;
    String packageName;
    String packageVer;
    String packageVerName;
    int pid;
    String processName;
    int uid;

    public enum EventType {
        CRASH,
        NATIVE_CRASH,
        ANR,
        WATCHDOG,
        SYSTEM_TOMBSTONE,
        SYSTEM_RESTART
    }

    public enum ForegroundState {
        UNKNOWN,
        BACKGROUND,
        FOREGROUND
    }
}
