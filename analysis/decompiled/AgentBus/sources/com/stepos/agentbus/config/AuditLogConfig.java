package com.stepos.agentbus.config;

import kotlin.Metadata;
import q7.f;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentbus/config/AuditLogConfig;", "", "maxFileSizeMb", "", "retentionDays", "<init>", "(II)V", "getMaxFileSizeMb", "()I", "getRetentionDays", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AuditLogConfig {
    private final int maxFileSizeMb;
    private final int retentionDays;

    /* JADX WARN: Illegal instructions before constructor call */
    public AuditLogConfig() {
        int i2 = 0;
        this(i2, i2, 3, null);
    }

    public static /* synthetic */ AuditLogConfig copy$default(AuditLogConfig auditLogConfig, int i2, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i2 = auditLogConfig.maxFileSizeMb;
        }
        if ((i11 & 2) != 0) {
            i10 = auditLogConfig.retentionDays;
        }
        return auditLogConfig.copy(i2, i10);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMaxFileSizeMb() {
        return this.maxFileSizeMb;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRetentionDays() {
        return this.retentionDays;
    }

    public final AuditLogConfig copy(int maxFileSizeMb, int retentionDays) {
        return new AuditLogConfig(maxFileSizeMb, retentionDays);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuditLogConfig)) {
            return false;
        }
        AuditLogConfig auditLogConfig = (AuditLogConfig) other;
        return this.maxFileSizeMb == auditLogConfig.maxFileSizeMb && this.retentionDays == auditLogConfig.retentionDays;
    }

    public final int getMaxFileSizeMb() {
        return this.maxFileSizeMb;
    }

    public final int getRetentionDays() {
        return this.retentionDays;
    }

    public int hashCode() {
        return Integer.hashCode(this.retentionDays) + (Integer.hashCode(this.maxFileSizeMb) * 31);
    }

    public String toString() {
        return "AuditLogConfig(maxFileSizeMb=" + this.maxFileSizeMb + ", retentionDays=" + this.retentionDays + ")";
    }

    public AuditLogConfig(int i2, int i10) {
        this.maxFileSizeMb = i2;
        this.retentionDays = i10;
    }

    public /* synthetic */ AuditLogConfig(int i2, int i10, int i11, f fVar) {
        this((i11 & 1) != 0 ? 5 : i2, (i11 & 2) != 0 ? 7 : i10);
    }
}
