package com.stepos.core.performance.policies;

import ai.onnxruntime.a;
import com.stepos.core.performance.data.GlobalVerdict;
import com.stepos.core.performance.data.ModelMeta;
import com.stepos.core.performance.data.PreInitAction;
import com.stepos.core.performance.data.SignalSnapshot;
import com.stepos.core.performance.orchestrator.VerdictBuilder;
import com.stepos.core.performance.policies.IPerformancePolicy;
import java.util.Locale;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DspConcurrencyPolicy implements IPerformancePolicy {

    /* renamed from: id, reason: collision with root package name */
    private final String f7610id = "DspConcurrencyPolicy";
    private final int priority = 80;

    private final int computeDspPermits(String str) {
        String str2;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        g.e(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -900258985:
                str2 = "sm7675";
                break;
            case -900231183:
                str2 = "sm8450";
                break;
            case -900231116:
                str2 = "sm8475";
                break;
            case -900230222:
                str2 = "sm8550";
                break;
            case -900229318:
                str2 = "sm8635";
                break;
            case -900229261:
                return !lowerCase.equals("sm8650") ? 1 : 2;
            case -900228300:
                return !lowerCase.equals("sm8750") ? 1 : 2;
            case -900227365:
                return !lowerCase.equals("sm8845") ? 1 : 2;
            default:
                return 1;
        }
        lowerCase.equals(str2);
        return 1;
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public void evaluate(SignalSnapshot snapshot, VerdictBuilder builder) {
        g.f(snapshot, "snapshot");
        g.f(builder, "builder");
        int iComputeDspPermits = computeDspPermits(snapshot.getSocModel());
        builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.DspConcurrencyPolicy.evaluate.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
            public Object get(Object obj) {
                return Integer.valueOf(((GlobalVerdict) obj).getDspMaxConcurrent());
            }
        }, Integer.valueOf(iComputeDspPermits), a.i("SoC=", iComputeDspPermits, snapshot.getSocModel(), ": dspMaxConcurrent=", " (HTP core count)"));
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public PreInitAction evaluatePreInit(SignalSnapshot signalSnapshot, ModelMeta modelMeta) {
        return IPerformancePolicy.DefaultImpls.evaluatePreInit(this, signalSnapshot, modelMeta);
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public String getId() {
        return this.f7610id;
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public int getPriority() {
        return this.priority;
    }
}
