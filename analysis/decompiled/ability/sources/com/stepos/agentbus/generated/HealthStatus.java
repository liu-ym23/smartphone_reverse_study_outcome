package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentbus/generated/HealthStatus;", "", AppAgent.CONSTRUCT, "()V", "isAvailable", "", "()Z", "isUnavailable", "Available", "Unavailable", "Degraded", "Lcom/stepos/agentbus/generated/HealthStatus$Available;", "Lcom/stepos/agentbus/generated/HealthStatus$Degraded;", "Lcom/stepos/agentbus/generated/HealthStatus$Unavailable;", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class HealthStatus {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentbus/generated/HealthStatus$Available;", "Lcom/stepos/agentbus/generated/HealthStatus;", "reason", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Available extends HealthStatus {
        private final String reason;

        /* JADX WARN: Multi-variable type inference failed */
        public Available() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Available copy$default(Available available, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = available.reason;
            }
            return available.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public final Available copy(String reason) {
            return new Available(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Available) && k.b(this.reason, ((Available) other).reason);
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            String str = this.reason;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return B7.a.m("Available(reason=", this.reason, ")");
        }

        public Available(String str) {
            super(null);
            this.reason = str;
        }

        public /* synthetic */ Available(String str, int i, e eVar) {
            this((i & 1) != 0 ? null : str);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentbus/generated/HealthStatus$Degraded;", "Lcom/stepos/agentbus/generated/HealthStatus;", "reason", "", "sinceMs", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;J)V", "getReason", "()Ljava/lang/String;", "getSinceMs", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Degraded extends HealthStatus {
        private final String reason;
        private final long sinceMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Degraded(String reason, long j5) {
            super(null);
            k.f(reason, "reason");
            this.reason = reason;
            this.sinceMs = j5;
        }

        public static /* synthetic */ Degraded copy$default(Degraded degraded, String str, long j5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = degraded.reason;
            }
            if ((i & 2) != 0) {
                j5 = degraded.sinceMs;
            }
            return degraded.copy(str, j5);
        }

        /* renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        /* renamed from: component2, reason: from getter */
        public final long getSinceMs() {
            return this.sinceMs;
        }

        public final Degraded copy(String reason, long sinceMs) {
            k.f(reason, "reason");
            return new Degraded(reason, sinceMs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Degraded)) {
                return false;
            }
            Degraded degraded = (Degraded) other;
            return k.b(this.reason, degraded.reason) && this.sinceMs == degraded.sinceMs;
        }

        public final String getReason() {
            return this.reason;
        }

        public final long getSinceMs() {
            return this.sinceMs;
        }

        public int hashCode() {
            return Long.hashCode(this.sinceMs) + (this.reason.hashCode() * 31);
        }

        public String toString() {
            return "Degraded(reason=" + this.reason + ", sinceMs=" + this.sinceMs + ")";
        }
    }

    public /* synthetic */ HealthStatus(e eVar) {
        this();
    }

    public final boolean isAvailable() {
        return this instanceof Available;
    }

    public final boolean isUnavailable() {
        return this instanceof Unavailable;
    }

    private HealthStatus() {
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentbus/generated/HealthStatus$Unavailable;", "Lcom/stepos/agentbus/generated/HealthStatus;", "reason", "", "sinceMs", "", "retryHint", "Lcom/stepos/agentbus/generated/RetryHint;", AppAgent.CONSTRUCT, "(Ljava/lang/String;JLcom/stepos/agentbus/generated/RetryHint;)V", "getReason", "()Ljava/lang/String;", "getSinceMs", "()J", "getRetryHint", "()Lcom/stepos/agentbus/generated/RetryHint;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Unavailable extends HealthStatus {
        private final String reason;
        private final RetryHint retryHint;
        private final long sinceMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unavailable(String reason, long j5, RetryHint retryHint) {
            super(null);
            k.f(reason, "reason");
            k.f(retryHint, "retryHint");
            this.reason = reason;
            this.sinceMs = j5;
            this.retryHint = retryHint;
        }

        public static /* synthetic */ Unavailable copy$default(Unavailable unavailable, String str, long j5, RetryHint retryHint, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unavailable.reason;
            }
            if ((i & 2) != 0) {
                j5 = unavailable.sinceMs;
            }
            if ((i & 4) != 0) {
                retryHint = unavailable.retryHint;
            }
            return unavailable.copy(str, j5, retryHint);
        }

        /* renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        /* renamed from: component2, reason: from getter */
        public final long getSinceMs() {
            return this.sinceMs;
        }

        /* renamed from: component3, reason: from getter */
        public final RetryHint getRetryHint() {
            return this.retryHint;
        }

        public final Unavailable copy(String reason, long sinceMs, RetryHint retryHint) {
            k.f(reason, "reason");
            k.f(retryHint, "retryHint");
            return new Unavailable(reason, sinceMs, retryHint);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Unavailable)) {
                return false;
            }
            Unavailable unavailable = (Unavailable) other;
            return k.b(this.reason, unavailable.reason) && this.sinceMs == unavailable.sinceMs && this.retryHint == unavailable.retryHint;
        }

        public final String getReason() {
            return this.reason;
        }

        public final RetryHint getRetryHint() {
            return this.retryHint;
        }

        public final long getSinceMs() {
            return this.sinceMs;
        }

        public int hashCode() {
            return this.retryHint.hashCode() + androidx.appfunctions.metadata.a.c(this.reason.hashCode() * 31, 31, this.sinceMs);
        }

        public String toString() {
            return "Unavailable(reason=" + this.reason + ", sinceMs=" + this.sinceMs + ", retryHint=" + this.retryHint + ")";
        }

        public /* synthetic */ Unavailable(String str, long j5, RetryHint retryHint, int i, e eVar) {
            this(str, j5, (i & 4) != 0 ? RetryHint.Auto : retryHint);
        }
    }
}
