package com.stepos.stepclaw.memory.lightmem.remote;

import c5.l;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.lightmem.evolution.EpisodicMemoryEvolutionState;
import com.stepos.stepclaw.provider.contract.OperationResult;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/AsyncTaskStatus;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "STARTED", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "PROCESSING", "FAILED", "COMPLETED", "LEGACY_IN_FLIGHT", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "normalize", "raw", "isFailedStatus", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "taskStatus", "isCompleted", "isStartedOrProcessing", "shouldPollTrigger", "resp", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerResponse;", "shouldPollUpdate", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;", "isTriggerFailed", "isUpdateFailed", "shouldConsumeOfflineTriggerSearchGroups", "shouldApplyOfflineUpdateResult", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AsyncTaskStatus {
    public static final String COMPLETED = "completed";
    public static final String FAILED = "failed";
    public static final AsyncTaskStatus INSTANCE = new AsyncTaskStatus();
    private static final Set<String> LEGACY_IN_FLIGHT = l.k0(new String[]{EpisodicMemoryEvolutionState.PENDING, "triggering", "in_progress", "running"});
    public static final String PROCESSING = "processing";
    public static final String STARTED = "started";

    private AsyncTaskStatus() {
    }

    public final boolean isCompleted(String taskStatus) {
        p.e(taskStatus, "taskStatus");
        return p.a(normalize(taskStatus), COMPLETED);
    }

    public final boolean isFailedStatus(String taskStatus) {
        p.e(taskStatus, "taskStatus");
        return p.a(normalize(taskStatus), FAILED);
    }

    public final boolean isStartedOrProcessing(String taskStatus) {
        p.e(taskStatus, "taskStatus");
        String strNormalize = normalize(taskStatus);
        if (strNormalize.length() == 0 || isCompleted(taskStatus)) {
            return false;
        }
        if (p.a(strNormalize, STARTED) || p.a(strNormalize, PROCESSING)) {
            return true;
        }
        return LEGACY_IN_FLIGHT.contains(strNormalize);
    }

    public final boolean isTriggerFailed(OfflineTriggerResponse resp) {
        p.e(resp, "resp");
        return p.a(normalize(resp.getStatus()), FAILED) || isFailedStatus(AsyncTaskStatusKt.effectiveTaskStatus(resp));
    }

    public final boolean isUpdateFailed(OfflineUpdateResponse resp) {
        p.e(resp, "resp");
        return p.a(normalize(resp.getStatus()), FAILED) || isFailedStatus(AsyncTaskStatusKt.effectiveTaskStatus(resp));
    }

    public final String normalize(String raw) {
        p.e(raw, "raw");
        String lowerCase = n.T1(raw).toString().toLowerCase(Locale.ROOT);
        p.d(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final boolean shouldApplyOfflineUpdateResult(OfflineUpdateResponse resp) {
        p.e(resp, "resp");
        if (p.a(normalize(resp.getStatus()), OperationResult.EXTRA_SUCCESS) && !isFailedStatus(AsyncTaskStatusKt.effectiveTaskStatus(resp))) {
            return isCompleted(AsyncTaskStatusKt.effectiveTaskStatus(resp));
        }
        return false;
    }

    public final boolean shouldConsumeOfflineTriggerSearchGroups(OfflineTriggerResponse resp) {
        p.e(resp, "resp");
        if (p.a(normalize(resp.getStatus()), OperationResult.EXTRA_SUCCESS) && !isFailedStatus(AsyncTaskStatusKt.effectiveTaskStatus(resp))) {
            return isCompleted(AsyncTaskStatusKt.effectiveTaskStatus(resp));
        }
        return false;
    }

    public final boolean shouldPollTrigger(OfflineTriggerResponse resp) {
        p.e(resp, "resp");
        if (p.a(normalize(resp.getStatus()), FAILED)) {
            return false;
        }
        String strEffectiveTaskStatus = AsyncTaskStatusKt.effectiveTaskStatus(resp);
        if (isFailedStatus(strEffectiveTaskStatus) || isCompleted(strEffectiveTaskStatus) || n.t1(strEffectiveTaskStatus)) {
            return false;
        }
        return isStartedOrProcessing(strEffectiveTaskStatus);
    }

    public final boolean shouldPollUpdate(OfflineUpdateResponse resp) {
        p.e(resp, "resp");
        if (p.a(normalize(resp.getStatus()), FAILED)) {
            return false;
        }
        String strEffectiveTaskStatus = AsyncTaskStatusKt.effectiveTaskStatus(resp);
        if (isFailedStatus(strEffectiveTaskStatus) || isCompleted(strEffectiveTaskStatus) || n.t1(strEffectiveTaskStatus)) {
            return false;
        }
        return isStartedOrProcessing(strEffectiveTaskStatus);
    }
}
