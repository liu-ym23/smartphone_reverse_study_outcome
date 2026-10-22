package com.stepos.core.performance.policies;

import ai.onnxruntime.a;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.performance.data.AicGroupPressureLevel;
import com.stepos.core.performance.data.GlobalVerdict;
import com.stepos.core.performance.data.ModelMeta;
import com.stepos.core.performance.data.PreInitAction;
import com.stepos.core.performance.data.SignalSnapshot;
import com.stepos.core.performance.orchestrator.VerdictBuilder;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MemoryPressurePolicy implements IPerformancePolicy {

    /* renamed from: id, reason: collision with root package name */
    private final String f7613id = "MemoryPressurePolicy";
    private final int priority = 15;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AicGroupPressureLevel.values().length];
            try {
                iArr[AicGroupPressureLevel.ULTRA_LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AicGroupPressureLevel.LOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AicGroupPressureLevel.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final long computeIdleTimeoutMs(SignalSnapshot signalSnapshot) {
        long selfProcessMemMb = (signalSnapshot.getTotalRamMb() < 8192 ? 15L : 30L) - ((signalSnapshot.getSelfProcessMemMb() / 500) * 5);
        if (selfProcessMemMb < 5) {
            selfProcessMemMb = 5;
        }
        return selfProcessMemMb * 1000;
    }

    private final AicGroupPressureLevel mapTrimMemoryToLevel(SignalSnapshot signalSnapshot) {
        if (signalSnapshot.isLowMemory()) {
            return AicGroupPressureLevel.ULTRA_LOW;
        }
        Integer trimMemoryLevel = signalSnapshot.getTrimMemoryLevel();
        if (trimMemoryLevel == null) {
            return AicGroupPressureLevel.NORMAL;
        }
        int iIntValue = trimMemoryLevel.intValue();
        return iIntValue >= 15 ? AicGroupPressureLevel.ULTRA_LOW : iIntValue >= 10 ? AicGroupPressureLevel.LOW : AicGroupPressureLevel.NORMAL;
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public void evaluate(SignalSnapshot snapshot, VerdictBuilder builder) {
        g.f(snapshot, "snapshot");
        g.f(builder, "builder");
        AicGroupPressureLevel a10 = snapshot.getAicgroupAvailable() ? snapshot.getAicgroupPressureLevel() : AicGroupPressureLevel.NORMAL;
        AicGroupPressureLevel b10 = mapTrimMemoryToLevel(snapshot);
        g.f(a10, "a");
        g.f(b10, "b");
        int i10 = WhenMappings.$EnumSwitchMapping$0[(a10.compareTo(b10) >= 0 ? a10 : b10).ordinal()];
        if (i10 == 1) {
            builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.MemoryPressurePolicy.evaluate.1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Boolean.valueOf(((GlobalVerdict) obj).getShouldEvictAllIdle());
                }
            }, Boolean.TRUE, "pressure=ULTRA_LOW(aic=" + a10 + ",trim=" + b10 + "): evict all idle");
            builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.MemoryPressurePolicy.evaluate.2
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Integer.valueOf(((GlobalVerdict) obj).getCacheEvictionRetainMb());
                }
            }, 64, "pressure=ULTRA_LOW: retain at most 64MB");
            builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.MemoryPressurePolicy.evaluate.3
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Long.valueOf(((GlobalVerdict) obj).getIdleTimeoutMs());
                }
            }, 0L, "pressure=ULTRA_LOW: zero idle timeout");
            builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.MemoryPressurePolicy.evaluate.4
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Long.valueOf(((GlobalVerdict) obj).getDeferredReleaseDelayMs());
                }
            }, 0L, "pressure=ULTRA_LOW: disable hot-buffer to avoid OOM");
            return;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            long jComputeIdleTimeoutMs = computeIdleTimeoutMs(snapshot);
            builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.MemoryPressurePolicy.evaluate.7
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Long.valueOf(((GlobalVerdict) obj).getIdleTimeoutMs());
                }
            }, Long.valueOf(jComputeIdleTimeoutMs), a.h(jComputeIdleTimeoutMs, "idle timeout RAM-adaptive: ", "ms"));
            return;
        }
        builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.MemoryPressurePolicy.evaluate.5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
            public Object get(Object obj) {
                return Integer.valueOf(((GlobalVerdict) obj).getCacheEvictionRetainMb());
            }
        }, 256, "pressure=LOW(aic=" + a10 + ",trim=" + b10 + "): retain at most 256MB");
        builder.seal(getId(), new PropertyReference1Impl() { // from class: com.stepos.core.performance.policies.MemoryPressurePolicy.evaluate.6
            @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
            public Object get(Object obj) {
                return Long.valueOf(((GlobalVerdict) obj).getIdleTimeoutMs());
            }
        }, Long.valueOf(AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS), "pressure=LOW: idle timeout 30s");
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public PreInitAction evaluatePreInit(SignalSnapshot snapshot, ModelMeta modelMeta) {
        g.f(snapshot, "snapshot");
        g.f(modelMeta, "modelMeta");
        if (modelMeta.getEstimatedInitMemoryMb() > 500) {
            return new PreInitAction.EvictAll(a.h(modelMeta.getEstimatedInitMemoryMb(), "heavy model pre-init: estimated ", "MB > 500MB"), false, 2, null);
        }
        if (snapshot.getSelfProcessMemMb() > 2048) {
            return new PreInitAction.EvictAll(a.h(snapshot.getSelfProcessMemMb(), "process mem > 2GB: ", "MB"), true);
        }
        if (snapshot.getAvgInitMemoryMb() <= 0 || g.b(snapshot.getCurrentModelId(), modelMeta.getModelId())) {
            return PreInitAction.NoOp.INSTANCE;
        }
        return new PreInitAction.EvictCategory(modelMeta.getModelCategory(), "same-category competition: " + modelMeta.getModelCategory());
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public String getId() {
        return this.f7613id;
    }

    @Override // com.stepos.core.performance.policies.IPerformancePolicy
    public int getPriority() {
        return this.priority;
    }
}
