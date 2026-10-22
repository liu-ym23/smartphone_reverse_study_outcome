package com.stepos.aiengine;

import com.stepos.aicgroup.memory.PressureLevel;
import com.stepos.aiengine.memory.AiModelPressureHandler;
import com.stepos.base.model.ReleaseReason;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final /* synthetic */ class AIEngineApplication$registerAicMemoryCallback$1$cameraHandler$1 extends FunctionReferenceImpl implements l<String, Integer> {
    @Override // zb.l
    public final Integer invoke(String str) {
        String p02 = str;
        g.f(p02, "p0");
        AiModelPressureHandler aiModelPressureHandler = (AiModelPressureHandler) this.receiver;
        aiModelPressureHandler.getClass();
        return Integer.valueOf(aiModelPressureHandler.a(PressureLevel.LOW, ReleaseReason.f6340d, p02));
    }
}
