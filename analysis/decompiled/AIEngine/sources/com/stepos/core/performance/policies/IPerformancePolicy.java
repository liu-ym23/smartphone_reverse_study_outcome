package com.stepos.core.performance.policies;

import com.stepos.core.performance.data.ModelMeta;
import com.stepos.core.performance.data.PreInitAction;
import com.stepos.core.performance.data.SignalSnapshot;
import com.stepos.core.performance.orchestrator.VerdictBuilder;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IPerformancePolicy {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static PreInitAction evaluatePreInit(IPerformancePolicy iPerformancePolicy, SignalSnapshot snapshot, ModelMeta modelMeta) {
            g.f(snapshot, "snapshot");
            g.f(modelMeta, "modelMeta");
            return PreInitAction.NoOp.INSTANCE;
        }
    }

    void evaluate(SignalSnapshot signalSnapshot, VerdictBuilder verdictBuilder);

    PreInitAction evaluatePreInit(SignalSnapshot signalSnapshot, ModelMeta modelMeta);

    String getId();

    int getPriority();
}
