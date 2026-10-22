package com.stepos.stepclaw.chroot;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/stepos/stepclaw/chroot/HealthCheckResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "status", "Lcom/stepos/stepclaw/chroot/HealthStatus;", OperationResult.EXTRA_MESSAGE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "failedChecks", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Lcom/stepos/stepclaw/chroot/HealthStatus;Ljava/lang/String;Ljava/util/List;)V", "getStatus", "()Lcom/stepos/stepclaw/chroot/HealthStatus;", "getMessage", "()Ljava/lang/String;", "getFailedChecks", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class HealthCheckResult {
    private final List<String> failedChecks;
    private final String message;
    private final HealthStatus status;

    public HealthCheckResult(HealthStatus status, String message, List<String> failedChecks) {
        p.e(status, "status");
        p.e(message, "message");
        p.e(failedChecks, "failedChecks");
        this.status = status;
        this.message = message;
        this.failedChecks = failedChecks;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HealthCheckResult copy$default(HealthCheckResult healthCheckResult, HealthStatus healthStatus, String str, List list, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            healthStatus = healthCheckResult.status;
        }
        if ((i8 & 2) != 0) {
            str = healthCheckResult.message;
        }
        if ((i8 & 4) != 0) {
            list = healthCheckResult.failedChecks;
        }
        return healthCheckResult.copy(healthStatus, str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final HealthStatus getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final List<String> component3() {
        return this.failedChecks;
    }

    public final HealthCheckResult copy(HealthStatus status, String message, List<String> failedChecks) {
        p.e(status, "status");
        p.e(message, "message");
        p.e(failedChecks, "failedChecks");
        return new HealthCheckResult(status, message, failedChecks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HealthCheckResult)) {
            return false;
        }
        HealthCheckResult healthCheckResult = (HealthCheckResult) other;
        return this.status == healthCheckResult.status && p.a(this.message, healthCheckResult.message) && p.a(this.failedChecks, healthCheckResult.failedChecks);
    }

    public final List<String> getFailedChecks() {
        return this.failedChecks;
    }

    public final String getMessage() {
        return this.message;
    }

    public final HealthStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.failedChecks.hashCode() + b.f(this.status.hashCode() * 31, 31, this.message);
    }

    public String toString() {
        return "HealthCheckResult(status=" + this.status + ", message=" + this.message + ", failedChecks=" + this.failedChecks + ")";
    }
}
