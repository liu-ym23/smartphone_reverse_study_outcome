package com.stepos.agentbus.config;

import kotlin.Metadata;
import q7.f;
import q7.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentbus/config/LoggingConfig;", "", "traceLog", "Lcom/stepos/agentbus/config/TraceLogConfig;", "auditLog", "Lcom/stepos/agentbus/config/AuditLogConfig;", "<init>", "(Lcom/stepos/agentbus/config/TraceLogConfig;Lcom/stepos/agentbus/config/AuditLogConfig;)V", "getTraceLog", "()Lcom/stepos/agentbus/config/TraceLogConfig;", "getAuditLog", "()Lcom/stepos/agentbus/config/AuditLogConfig;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LoggingConfig {
    private final AuditLogConfig auditLog;
    private final TraceLogConfig traceLog;

    /* JADX WARN: Multi-variable type inference failed */
    public LoggingConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ LoggingConfig copy$default(LoggingConfig loggingConfig, TraceLogConfig traceLogConfig, AuditLogConfig auditLogConfig, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            traceLogConfig = loggingConfig.traceLog;
        }
        if ((i2 & 2) != 0) {
            auditLogConfig = loggingConfig.auditLog;
        }
        return loggingConfig.copy(traceLogConfig, auditLogConfig);
    }

    /* renamed from: component1, reason: from getter */
    public final TraceLogConfig getTraceLog() {
        return this.traceLog;
    }

    /* renamed from: component2, reason: from getter */
    public final AuditLogConfig getAuditLog() {
        return this.auditLog;
    }

    public final LoggingConfig copy(TraceLogConfig traceLog, AuditLogConfig auditLog) {
        k.e(traceLog, "traceLog");
        k.e(auditLog, "auditLog");
        return new LoggingConfig(traceLog, auditLog);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoggingConfig)) {
            return false;
        }
        LoggingConfig loggingConfig = (LoggingConfig) other;
        return k.a(this.traceLog, loggingConfig.traceLog) && k.a(this.auditLog, loggingConfig.auditLog);
    }

    public final AuditLogConfig getAuditLog() {
        return this.auditLog;
    }

    public final TraceLogConfig getTraceLog() {
        return this.traceLog;
    }

    public int hashCode() {
        return this.auditLog.hashCode() + (this.traceLog.hashCode() * 31);
    }

    public String toString() {
        return "LoggingConfig(traceLog=" + this.traceLog + ", auditLog=" + this.auditLog + ")";
    }

    public LoggingConfig(TraceLogConfig traceLogConfig, AuditLogConfig auditLogConfig) {
        k.e(traceLogConfig, "traceLog");
        k.e(auditLogConfig, "auditLog");
        this.traceLog = traceLogConfig;
        this.auditLog = auditLogConfig;
    }

    public /* synthetic */ LoggingConfig(TraceLogConfig traceLogConfig, AuditLogConfig auditLogConfig, int i2, f fVar) {
        this((i2 & 1) != 0 ? new TraceLogConfig(0, 0, 3, null) : traceLogConfig, (i2 & 2) != 0 ? new AuditLogConfig(0, 0, 3, null) : auditLogConfig);
    }
}
