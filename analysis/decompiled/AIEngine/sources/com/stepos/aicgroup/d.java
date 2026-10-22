package com.stepos.aicgroup;

import com.stepos.backend.qnn.QnnPerceptionModel;
import com.stepos.backend.qnn.QnnVLMModel;
import com.stepos.core.common.telemetry.DelayedFreqSampler;
import com.stepos.core.common.telemetry.scene.AiStageSceneDonator;
import com.stepos.core.ota.display.ModelDisplayResourceStore;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5692a;

    public /* synthetic */ d(int i10) {
        this.f5692a = i10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f5692a) {
            case 0:
                AiDispatchersManager aiDispatchersManager = AiDispatchersManager.INSTANCE;
                return com.stepos.core.ota.d.n(runnable, "AiLimit-Control", true);
            case 1:
                AiThermalManager aiThermalManager = AiThermalManager.INSTANCE;
                return com.stepos.core.ota.d.n(runnable, "AiThermal", true);
            case 2:
                return QnnPerceptionModel.perceptionNativeDispatcher$lambda$7(runnable);
            case 3:
                return QnnVLMModel.vlmNativeDispatcher$lambda$13(runnable);
            case 4:
                return DelayedFreqSampler.scheduler$lambda$1(runnable);
            case 5:
                return AiStageSceneDonator.worker$lambda$1(runnable);
            case 6:
                return ModelDisplayResourceStore.warmExecutor_delegate$lambda$5$lambda$4(runnable);
            case 7:
                return com.stepos.core.ota.d.n(runnable, "ModelChangeBroadcast", true);
            case 8:
                return com.stepos.core.ota.d.n(runnable, "scp-moderation-model", true);
            default:
                return new Thread(runnable, "ResponseTask");
        }
    }
}
