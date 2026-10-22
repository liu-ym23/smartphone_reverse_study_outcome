package com.stepos.core.performance.orchestrator;

import com.stepos.base.inference.data.BackendType;
import com.stepos.core.performance.data.BackendConstraint;
import com.stepos.core.performance.data.GlobalVerdict;
import com.stepos.core.performance.data.VerdictReason;
import ec.f;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.a;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VerdictBuilder {
    private final List<VerdictReason> auditLog;
    private BackendConstraint backendConstraint;
    private List<? extends BackendType> backendFallbackChain;
    private int cacheEvictionRetainMb;
    private int cbFailureThreshold;
    private long cbResetTimeoutMs;
    private final VerdictDefaults defaults;
    private long deferredReleaseDelayMs;
    private int dspMaxConcurrent;
    private long idleTimeoutMs;
    private int maxConcurrent;
    private BackendType recommendedBackend;
    private final Set<String> sealedFields;
    private boolean shouldEvictAllIdle;
    private boolean suggestCloudRouting;
    private final Set<String> writtenFields;

    public VerdictBuilder(VerdictDefaults defaults) {
        g.f(defaults, "defaults");
        this.defaults = defaults;
        this.sealedFields = new LinkedHashSet();
        this.writtenFields = new LinkedHashSet();
        this.auditLog = new ArrayList();
        this.recommendedBackend = defaults.getRecommendedBackend();
        this.backendFallbackChain = defaults.getBackendFallbackChain();
        this.backendConstraint = defaults.getBackendConstraint();
        this.maxConcurrent = defaults.getMaxConcurrent();
        this.dspMaxConcurrent = defaults.getDspMaxConcurrent();
        this.idleTimeoutMs = defaults.getIdleTimeoutMs();
        this.deferredReleaseDelayMs = defaults.getDeferredReleaseDelayMs();
        this.cacheEvictionRetainMb = defaults.getCacheEvictionRetainMb();
        this.shouldEvictAllIdle = defaults.getShouldEvictAllIdle();
        this.suggestCloudRouting = defaults.getSuggestCloudRouting();
        this.cbFailureThreshold = defaults.getCbFailureThreshold();
        this.cbResetTimeoutMs = defaults.getCbResetTimeoutMs();
    }

    private final void writeInternal(String str, Object obj, String str2, String str3, String str4) {
        switch (str.hashCode()) {
            case -2128940685:
                if (str.equals("idleTimeoutMs")) {
                    g.d(obj, "null cannot be cast to non-null type kotlin.Long");
                    this.idleTimeoutMs = ((Long) obj).longValue();
                    break;
                } else {
                    return;
                }
            case -702989759:
                if (str.equals("deferredReleaseDelayMs")) {
                    g.d(obj, "null cannot be cast to non-null type kotlin.Long");
                    this.deferredReleaseDelayMs = ((Long) obj).longValue();
                    break;
                } else {
                    return;
                }
            case -581843462:
                if (str.equals("dspMaxConcurrent")) {
                    g.d(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.dspMaxConcurrent = ((Integer) obj).intValue();
                    break;
                } else {
                    return;
                }
            case -493826593:
                if (str.equals("shouldEvictAllIdle")) {
                    g.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    this.shouldEvictAllIdle = ((Boolean) obj).booleanValue();
                    break;
                } else {
                    return;
                }
            case 314087771:
                if (str.equals("cacheEvictionRetainMb")) {
                    g.d(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.cacheEvictionRetainMb = ((Integer) obj).intValue();
                    break;
                } else {
                    return;
                }
            case 407303097:
                if (str.equals("recommendedBackend")) {
                    g.d(obj, "null cannot be cast to non-null type com.stepos.base.inference.data.BackendType");
                    this.recommendedBackend = (BackendType) obj;
                    break;
                } else {
                    return;
                }
            case 822845568:
                if (str.equals("cbFailureThreshold")) {
                    g.d(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.cbFailureThreshold = ((Integer) obj).intValue();
                    break;
                } else {
                    return;
                }
            case 984498805:
                if (str.equals("suggestCloudRouting")) {
                    g.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    this.suggestCloudRouting = ((Boolean) obj).booleanValue();
                    break;
                } else {
                    return;
                }
            case 1646197307:
                if (str.equals("maxConcurrent")) {
                    g.d(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.maxConcurrent = ((Integer) obj).intValue();
                    break;
                } else {
                    return;
                }
            case 1928746135:
                if (str.equals("cbResetTimeoutMs")) {
                    g.d(obj, "null cannot be cast to non-null type kotlin.Long");
                    this.cbResetTimeoutMs = ((Long) obj).longValue();
                    break;
                } else {
                    return;
                }
            case 2047063755:
                if (str.equals("backendFallbackChain")) {
                    g.d(obj, "null cannot be cast to non-null type kotlin.collections.List<com.stepos.base.inference.data.BackendType>");
                    this.backendFallbackChain = (List) obj;
                    break;
                } else {
                    return;
                }
            case 2108608401:
                if (str.equals("backendConstraint")) {
                    g.d(obj, "null cannot be cast to non-null type com.stepos.core.performance.data.BackendConstraint");
                    this.backendConstraint = (BackendConstraint) obj;
                    break;
                } else {
                    return;
                }
            default:
                return;
        }
        this.writtenFields.add(str);
        this.auditLog.add(new VerdictReason(str4, str, str2, obj.toString(), str3));
    }

    public static /* synthetic */ void writeInternal$default(VerdictBuilder verdictBuilder, String str, Object obj, String str2, String str3, String str4, int i10, Object obj2) {
        if ((i10 & 16) != 0) {
            str4 = "";
        }
        verdictBuilder.writeInternal(str, obj, str2, str3, str4);
    }

    public final GlobalVerdict build() {
        return new GlobalVerdict(this.recommendedBackend, this.backendFallbackChain, this.backendConstraint, this.maxConcurrent, this.dspMaxConcurrent, this.idleTimeoutMs, this.deferredReleaseDelayMs, this.cacheEvictionRetainMb, this.shouldEvictAllIdle, this.suggestCloudRouting, this.cbFailureThreshold, this.cbResetTimeoutMs, this.defaults.getThermalState(), this.defaults.getBatteryLevel(), this.defaults.isCharging(), this.defaults.isForeground(), this.defaults.getBackgroundDurationMs(), a.O0(this.auditLog), a.R0(this.sealedFields), 0L, 524288, null);
    }

    public final boolean isBackendSealed() {
        return this.sealedFields.contains("backendConstraint") || this.sealedFields.contains("recommendedBackend");
    }

    public final void seal(f<?> field, Object value, String reason) {
        g.f(field, "field");
        g.f(value, "value");
        g.f(reason, "reason");
        String name = field.getName();
        if (this.sealedFields.contains(name)) {
            this.auditLog.add(new VerdictReason("<current>", name, "override_blocked", value.toString(), reason));
        } else {
            writeInternal$default(this, name, value, "seal", reason, null, 16, null);
            this.sealedFields.add(name);
        }
    }

    public final void suggest(f<?> field, Object value, String reason) {
        g.f(field, "field");
        g.f(value, "value");
        g.f(reason, "reason");
        String name = field.getName();
        if (this.sealedFields.contains(name)) {
            this.auditLog.add(new VerdictReason("<current>", name, "override_blocked", value.toString(), reason));
        } else {
            writeInternal$default(this, name, value, "suggest", reason, null, 16, null);
        }
    }

    public final void suggestIfAbsent(f<?> field, Object value, String reason) {
        g.f(field, "field");
        g.f(value, "value");
        g.f(reason, "reason");
        String name = field.getName();
        if (this.sealedFields.contains(name) || this.writtenFields.contains(name)) {
            this.auditLog.add(new VerdictReason("<current>", name, "override_blocked", value.toString(), "already written, suggestIfAbsent skipped"));
        } else {
            writeInternal$default(this, name, value, "suggestIfAbsent", reason, null, 16, null);
        }
    }

    public final void seal(String policyId, f<?> field, Object value, String reason) {
        g.f(policyId, "policyId");
        g.f(field, "field");
        g.f(value, "value");
        g.f(reason, "reason");
        String name = field.getName();
        if (this.sealedFields.contains(name)) {
            this.auditLog.add(new VerdictReason(policyId, name, "override_blocked", value.toString(), reason));
        } else {
            writeInternal(name, value, "seal", reason, policyId);
            this.sealedFields.add(name);
        }
    }

    public final void suggest(String policyId, f<?> field, Object value, String reason) {
        g.f(policyId, "policyId");
        g.f(field, "field");
        g.f(value, "value");
        g.f(reason, "reason");
        String name = field.getName();
        if (this.sealedFields.contains(name)) {
            this.auditLog.add(new VerdictReason(policyId, name, "override_blocked", value.toString(), reason));
        } else {
            writeInternal(name, value, "suggest", reason, policyId);
        }
    }

    public final void suggestIfAbsent(String policyId, f<?> field, Object value, String reason) {
        g.f(policyId, "policyId");
        g.f(field, "field");
        g.f(value, "value");
        g.f(reason, "reason");
        String name = field.getName();
        if (!this.sealedFields.contains(name) && !this.writtenFields.contains(name)) {
            writeInternal(name, value, "suggestIfAbsent", reason, policyId);
        } else {
            this.auditLog.add(new VerdictReason(policyId, name, "override_blocked", value.toString(), "already written, suggestIfAbsent skipped"));
        }
    }
}
