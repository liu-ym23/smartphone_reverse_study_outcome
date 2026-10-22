package com.stepos.agentbus.config;

import kotlin.Metadata;
import q7.f;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentbus/config/TraceLogConfig;", "", "maxFileSizeMb", "", "maxFileCount", "<init>", "(II)V", "getMaxFileSizeMb", "()I", "getMaxFileCount", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TraceLogConfig {
    private final int maxFileCount;
    private final int maxFileSizeMb;

    /* JADX WARN: Illegal instructions before constructor call */
    public TraceLogConfig() {
        int i2 = 0;
        this(i2, i2, 3, null);
    }

    public static /* synthetic */ TraceLogConfig copy$default(TraceLogConfig traceLogConfig, int i2, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i2 = traceLogConfig.maxFileSizeMb;
        }
        if ((i11 & 2) != 0) {
            i10 = traceLogConfig.maxFileCount;
        }
        return traceLogConfig.copy(i2, i10);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMaxFileSizeMb() {
        return this.maxFileSizeMb;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMaxFileCount() {
        return this.maxFileCount;
    }

    public final TraceLogConfig copy(int maxFileSizeMb, int maxFileCount) {
        return new TraceLogConfig(maxFileSizeMb, maxFileCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraceLogConfig)) {
            return false;
        }
        TraceLogConfig traceLogConfig = (TraceLogConfig) other;
        return this.maxFileSizeMb == traceLogConfig.maxFileSizeMb && this.maxFileCount == traceLogConfig.maxFileCount;
    }

    public final int getMaxFileCount() {
        return this.maxFileCount;
    }

    public final int getMaxFileSizeMb() {
        return this.maxFileSizeMb;
    }

    public int hashCode() {
        return Integer.hashCode(this.maxFileCount) + (Integer.hashCode(this.maxFileSizeMb) * 31);
    }

    public String toString() {
        return "TraceLogConfig(maxFileSizeMb=" + this.maxFileSizeMb + ", maxFileCount=" + this.maxFileCount + ")";
    }

    public TraceLogConfig(int i2, int i10) {
        this.maxFileSizeMb = i2;
        this.maxFileCount = i10;
    }

    public /* synthetic */ TraceLogConfig(int i2, int i10, int i11, f fVar) {
        this((i11 & 1) != 0 ? 10 : i2, (i11 & 2) != 0 ? 3 : i10);
    }
}
