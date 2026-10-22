package com.stepos.ability.report.event;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u001c\u001a\u00020\u0003H\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J[\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/stepos/ability/report/event/LogEvent;", "", AgentBusWakeContract.EXTRA_TRACE_ID, "", "sessionId", "type", "Lcom/stepos/ability/report/event/LogEventType;", "level", "Lcom/stepos/ability/report/event/LogLevel;", "log", "stack", "nodeName", "statusCode", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ability/report/event/LogEventType;Lcom/stepos/ability/report/event/LogLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getTraceId", "()Ljava/lang/String;", "getSessionId", "getType", "()Lcom/stepos/ability/report/event/LogEventType;", "getLevel", "()Lcom/stepos/ability/report/event/LogLevel;", "getLog", "getStack", "getNodeName", "getStatusCode", "()I", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "report_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LogEvent {
    private final LogLevel level;
    private final String log;
    private final String nodeName;
    private final String sessionId;
    private final String stack;
    private final int statusCode;
    private final String traceId;
    private final LogEventType type;

    public LogEvent(String traceId, String sessionId, LogEventType type, LogLevel level, String log, String str, String nodeName, int i) {
        k.f(traceId, "traceId");
        k.f(sessionId, "sessionId");
        k.f(type, "type");
        k.f(level, "level");
        k.f(log, "log");
        k.f(nodeName, "nodeName");
        this.traceId = traceId;
        this.sessionId = sessionId;
        this.type = type;
        this.level = level;
        this.log = log;
        this.stack = str;
        this.nodeName = nodeName;
        this.statusCode = i;
    }

    public static /* synthetic */ LogEvent copy$default(LogEvent logEvent, String str, String str2, LogEventType logEventType, LogLevel logLevel, String str3, String str4, String str5, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = logEvent.traceId;
        }
        if ((i6 & 2) != 0) {
            str2 = logEvent.sessionId;
        }
        if ((i6 & 4) != 0) {
            logEventType = logEvent.type;
        }
        if ((i6 & 8) != 0) {
            logLevel = logEvent.level;
        }
        if ((i6 & 16) != 0) {
            str3 = logEvent.log;
        }
        if ((i6 & 32) != 0) {
            str4 = logEvent.stack;
        }
        if ((i6 & 64) != 0) {
            str5 = logEvent.nodeName;
        }
        if ((i6 & 128) != 0) {
            i = logEvent.statusCode;
        }
        String str6 = str5;
        int i10 = i;
        String str7 = str3;
        String str8 = str4;
        return logEvent.copy(str, str2, logEventType, logLevel, str7, str8, str6, i10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component3, reason: from getter */
    public final LogEventType getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final LogLevel getLevel() {
        return this.level;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLog() {
        return this.log;
    }

    /* renamed from: component6, reason: from getter */
    public final String getStack() {
        return this.stack;
    }

    /* renamed from: component7, reason: from getter */
    public final String getNodeName() {
        return this.nodeName;
    }

    /* renamed from: component8, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    public final LogEvent copy(String traceId, String sessionId, LogEventType type, LogLevel level, String log, String stack, String nodeName, int statusCode) {
        k.f(traceId, "traceId");
        k.f(sessionId, "sessionId");
        k.f(type, "type");
        k.f(level, "level");
        k.f(log, "log");
        k.f(nodeName, "nodeName");
        return new LogEvent(traceId, sessionId, type, level, log, stack, nodeName, statusCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) other;
        return k.b(this.traceId, logEvent.traceId) && k.b(this.sessionId, logEvent.sessionId) && this.type == logEvent.type && this.level == logEvent.level && k.b(this.log, logEvent.log) && k.b(this.stack, logEvent.stack) && k.b(this.nodeName, logEvent.nodeName) && this.statusCode == logEvent.statusCode;
    }

    public final LogLevel getLevel() {
        return this.level;
    }

    public final String getLog() {
        return this.log;
    }

    public final String getNodeName() {
        return this.nodeName;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getStack() {
        return this.stack;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final LogEventType getType() {
        return this.type;
    }

    public int hashCode() {
        int iC = a.c((this.level.hashCode() + ((this.type.hashCode() + a.c(this.traceId.hashCode() * 31, 31, this.sessionId)) * 31)) * 31, 31, this.log);
        String str = this.stack;
        return Integer.hashCode(this.statusCode) + a.c((iC + (str == null ? 0 : str.hashCode())) * 31, 31, this.nodeName);
    }

    public String toString() {
        String str = this.traceId;
        String str2 = this.sessionId;
        LogEventType logEventType = this.type;
        LogLevel logLevel = this.level;
        String str3 = this.stack;
        boolean z10 = str3 == null || str3.length() == 0;
        String str4 = this.nodeName;
        int i = this.statusCode;
        StringBuilder sbW = a.w("LogEvent(traceId=", str, ", sessionId=", str2, ", type=");
        sbW.append(logEventType);
        sbW.append(", level=");
        sbW.append(logLevel);
        sbW.append(", log=<redacted>, hasStack=");
        sbW.append(!z10);
        sbW.append(", nodeName=");
        sbW.append(str4);
        sbW.append(", statusCode=");
        return androidx.appfunctions.metadata.a.o(sbW, ")", i);
    }

    public /* synthetic */ LogEvent(String str, String str2, LogEventType logEventType, LogLevel logLevel, String str3, String str4, String str5, int i, int i6, e eVar) {
        this(str, str2, logEventType, (i6 & 8) != 0 ? LogLevel.INFO : logLevel, (i6 & 16) != 0 ? "" : str3, (i6 & 32) != 0 ? null : str4, (i6 & 64) != 0 ? "tool_call" : str5, (i6 & 128) != 0 ? 200 : i);
    }
}
