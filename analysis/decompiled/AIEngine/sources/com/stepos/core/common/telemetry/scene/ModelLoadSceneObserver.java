package com.stepos.core.common.telemetry.scene;

import android.util.Log;
import com.stepos.core.common.telemetry.ModelLoadFailureReporter;
import kotlin.jvm.internal.e;
import p6.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelLoadSceneObserver implements g {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ModelLoadSceneObserver";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
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
        if (SceneDonationPolicy.INSTANCE.isDonatable(backendKey)) {
            AiStageSceneDonator.INSTANCE.onLoading(z, false, modelId, -1);
        }
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
        if (SceneDonationPolicy.INSTANCE.isDonatable(backendKey)) {
            AiStageSceneDonator.INSTANCE.onLoading(z, true, modelId, -1);
        }
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
        ModelLoadFailureReporter.INSTANCE.report(abilityId, modelId, z, backendKey, error);
        if (SceneDonationPolicy.INSTANCE.isDonatable(backendKey)) {
            String message = error.getMessage();
            StringBuilder sbS = ai.onnxruntime.a.s("onLoadFailed: abilityId=", abilityId, " modelId=", modelId, " fg=");
            sbS.append(z);
            sbS.append(": ");
            sbS.append(message);
            Log.w(TAG, sbS.toString());
            AiStageSceneDonator.INSTANCE.onLoading(z, false, modelId, -1);
        }
    }

    @Override // p6.g
    public void onLoadedToInvoke(String abilityId, String modelId, boolean z, String backendKey) {
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(backendKey, "backendKey");
    }
}
