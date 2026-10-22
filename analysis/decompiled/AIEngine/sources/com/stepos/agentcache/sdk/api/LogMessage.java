package com.stepos.agentcache.sdk.api;

import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogMessage {
    private final String event;
    private final LogLevel level;
    private final String log;
    private final String stack;

    public LogMessage(LogLevel level, String event, String log, String str) {
        g.f(level, "level");
        g.f(event, "event");
        g.f(log, "log");
        this.level = level;
        this.event = event;
        this.log = log;
        this.stack = str;
    }

    public static /* synthetic */ LogMessage copy$default(LogMessage logMessage, LogLevel logLevel, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            logLevel = logMessage.level;
        }
        if ((i10 & 2) != 0) {
            str = logMessage.event;
        }
        if ((i10 & 4) != 0) {
            str2 = logMessage.log;
        }
        if ((i10 & 8) != 0) {
            str3 = logMessage.stack;
        }
        return logMessage.copy(logLevel, str, str2, str3);
    }

    public final LogLevel component1() {
        return this.level;
    }

    public final String component2() {
        return this.event;
    }

    public final String component3() {
        return this.log;
    }

    public final String component4() {
        return this.stack;
    }

    public final LogMessage copy(LogLevel level, String event, String log, String str) {
        g.f(level, "level");
        g.f(event, "event");
        g.f(log, "log");
        return new LogMessage(level, event, log, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogMessage)) {
            return false;
        }
        LogMessage logMessage = (LogMessage) obj;
        return this.level == logMessage.level && g.b(this.event, logMessage.event) && g.b(this.log, logMessage.log) && g.b(this.stack, logMessage.stack);
    }

    public final String getEvent() {
        return this.event;
    }

    public final LogLevel getLevel() {
        return this.level;
    }

    public final String getLog() {
        return this.log;
    }

    public final String getStack() {
        return this.stack;
    }

    public int hashCode() {
        int iA = d.a(d.a(this.level.hashCode() * 31, 31, this.event), 31, this.log);
        String str = this.stack;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        LogLevel logLevel = this.level;
        String str = this.event;
        String str2 = this.log;
        String str3 = this.stack;
        StringBuilder sb2 = new StringBuilder("LogMessage(level=");
        sb2.append(logLevel);
        sb2.append(", event=");
        sb2.append(str);
        sb2.append(", log=");
        return com.stepos.core.ota.d.j(sb2, str2, ", stack=", str3, ")");
    }

    public /* synthetic */ LogMessage(LogLevel logLevel, String str, String str2, String str3, int i10, e eVar) {
        this(logLevel, str, str2, (i10 & 8) != 0 ? null : str3);
    }
}
