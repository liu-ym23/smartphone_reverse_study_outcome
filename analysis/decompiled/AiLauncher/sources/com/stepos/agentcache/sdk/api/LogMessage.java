package com.stepos.agentcache.sdk.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.events.b;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentcache/sdk/api/LogMessage;", "", "level", "Lcom/stepos/agentcache/sdk/api/LogLevel;", "event", "", b.f30786f, "stack", "<init>", "(Lcom/stepos/agentcache/sdk/api/LogLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLevel", "()Lcom/stepos/agentcache/sdk/api/LogLevel;", "getEvent", "()Ljava/lang/String;", "getLog", "getStack", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class LogMessage {
    private final String event;
    private final LogLevel level;
    private final String log;
    private final String stack;

    public LogMessage(LogLevel level, String event, String log, String str) {
        p.i(level, "level");
        p.i(event, "event");
        p.i(log, "log");
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

    /* renamed from: component1, reason: from getter */
    public final LogLevel getLevel() {
        return this.level;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEvent() {
        return this.event;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLog() {
        return this.log;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStack() {
        return this.stack;
    }

    public final LogMessage copy(LogLevel level, String event, String log, String stack) {
        p.i(level, "level");
        p.i(event, "event");
        p.i(log, "log");
        return new LogMessage(level, event, log, stack);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogMessage)) {
            return false;
        }
        LogMessage logMessage = (LogMessage) other;
        return this.level == logMessage.level && p.d(this.event, logMessage.event) && p.d(this.log, logMessage.log) && p.d(this.stack, logMessage.stack);
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
        int iHashCode = ((((this.level.hashCode() * 31) + this.event.hashCode()) * 31) + this.log.hashCode()) * 31;
        String str = this.stack;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LogMessage(level=" + this.level + ", event=" + this.event + ", log=" + this.log + ", stack=" + this.stack + ")";
    }

    public /* synthetic */ LogMessage(LogLevel logLevel, String str, String str2, String str3, int i10, i iVar) {
        this(logLevel, str, str2, (i10 & 8) != 0 ? null : str3);
    }
}
