package com.stepos.core.common.telemetry;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelLoadLedger implements p6.g {
    public static final ModelLoadLedger INSTANCE = new ModelLoadLedger();
    private static final ConcurrentHashMap<String, Long> pending = new ConcurrentHashMap<>();

    private ModelLoadLedger() {
    }

    public final Long claimPending(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        if (modelId.length() == 0) {
            return null;
        }
        return pending.remove(modelId);
    }

    @Override // p6.g
    public void onAfterInfer(String taskId, String modelId, long j10) {
        kotlin.jvm.internal.g.f(taskId, "taskId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
    }

    @Override // p6.g
    public void onAfterLoad(String abilityId, String modelId, boolean z, String backendKey, long j10) {
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(backendKey, "backendKey");
        if (modelId.length() == 0) {
            return;
        }
        pending.put(modelId, Long.valueOf(j10));
    }

    @Override // p6.g
    public void onBeforeInfer(String taskId, String modelId) {
        kotlin.jvm.internal.g.f(taskId, "taskId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
    }

    @Override // p6.g
    public void onBeforeLoad(String abilityId, String modelId, boolean z, String backendKey) {
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(backendKey, "backendKey");
    }

    @Override // p6.g
    public void onInferCancelled(String taskId, String modelId) {
        kotlin.jvm.internal.g.f(taskId, "taskId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
    }

    @Override // p6.g
    public void onInferError(String taskId, String modelId, Throwable error) {
        kotlin.jvm.internal.g.f(taskId, "taskId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(error, "error");
    }

    @Override // p6.g
    public void onLoadEmpty(String abilityId, String modelId, boolean z, String backendKey, String reason) {
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(backendKey, "backendKey");
        kotlin.jvm.internal.g.f(reason, "reason");
    }

    @Override // p6.g
    public void onLoadFailed(String abilityId, String modelId, boolean z, String backendKey, Throwable error) {
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(backendKey, "backendKey");
        kotlin.jvm.internal.g.f(error, "error");
    }

    @Override // p6.g
    public void onLoadedToInvoke(String abilityId, String modelId, boolean z, String backendKey) {
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(backendKey, "backendKey");
    }

    public final void reset() {
        pending.clear();
    }
}
