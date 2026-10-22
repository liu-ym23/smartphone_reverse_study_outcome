package com.stepos.core.performance.orchestrator;

import ai.onnxruntime.a;
import com.stepos.base.awareness.data.ThermalState;
import com.stepos.base.inference.data.BackendType;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.ability.speech.VadRuntimeConfig;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.ota.confirm.InteractiveSessionRegistry;
import com.stepos.core.performance.data.BackendConstraint;
import com.stepos.core.performance.data.EnrichedVerdict;
import com.stepos.core.performance.data.GlobalVerdict;
import com.stepos.core.performance.data.PerformanceRequestContext;
import com.stepos.core.performance.data.SignalSnapshot;
import com.stepos.core.performance.data.VerdictReason;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RequestEnrichment {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TaskPriority.values().length];
            try {
                TaskPriority.a aVar = TaskPriority.f6396b;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                TaskPriority.a aVar2 = TaskPriority.f6396b;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                TaskPriority.a aVar3 = TaskPriority.f6396b;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                TaskPriority.a aVar4 = TaskPriority.f6396b;
                iArr[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ThermalState.values().length];
            try {
                ThermalState.a aVar5 = ThermalState.f6199a;
                iArr2[3] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                ThermalState.a aVar6 = ThermalState.f6199a;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                ThermalState.a aVar7 = ThermalState.f6199a;
                iArr2[1] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                ThermalState.a aVar8 = ThermalState.f6199a;
                iArr2[0] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private final BackendType computeBackend(GlobalVerdict globalVerdict, PerformanceRequestContext performanceRequestContext, List<VerdictReason> list) {
        if (!g.b(performanceRequestContext.getAbilityType().f11434a, "realtime_voice") || globalVerdict.getBackendConstraint() != BackendConstraint.FREE) {
            return globalVerdict.getRecommendedBackend();
        }
        list.add(new VerdictReason("RequestEnrichment", "recommendedBackend", VadRuntimeConfig.ORIGIN_OVERRIDE, "NPU", "REALTIME_VOICE + FREE constraint: force NPU for low latency"));
        return BackendType.f6254d;
    }

    private final int computeBatchSize(GlobalVerdict globalVerdict, PerformanceRequestContext performanceRequestContext, SignalSnapshot signalSnapshot, List<VerdictReason> list) {
        float f8;
        int requestedMaxBatchSize = performanceRequestContext.getRequestedMaxBatchSize();
        int i10 = WhenMappings.$EnumSwitchMapping$1[globalVerdict.getThermalState().ordinal()];
        float f9 = 0.5f;
        if (i10 == 1) {
            list.add(new VerdictReason("RequestEnrichment", "batchSize", "reduce", "0.25x", "CRITICAL thermal"));
            f8 = 0.25f;
        } else if (i10 != 2) {
            f8 = 1.0f;
        } else {
            list.add(new VerdictReason("RequestEnrichment", "batchSize", "reduce", "0.5x", "SEVERE thermal"));
            f8 = 0.5f;
        }
        if (signalSnapshot.getAvailRamMb() < 512) {
            list.add(new VerdictReason("RequestEnrichment", "batchSize", "reduce", "0.5x", a.h(signalSnapshot.getAvailRamMb(), "availRamMb=", " < 512MB")));
        } else {
            f9 = 1.0f;
        }
        int i11 = (int) (requestedMaxBatchSize * f8 * f9);
        if (i11 < 1) {
            return 1;
        }
        return i11;
    }

    private final int computeMaxTokens(GlobalVerdict globalVerdict, PerformanceRequestContext performanceRequestContext, List<VerdictReason> list) {
        int requestedMaxTokens = performanceRequestContext.getRequestedMaxTokens();
        boolean zIsCharging = globalVerdict.isCharging();
        int i10 = VadSessionManager.FRAME_BYTES;
        if (!zIsCharging) {
            if (globalVerdict.getBatteryLevel() < 10) {
                list.add(new VerdictReason("RequestEnrichment", "maxTokens", "cap", "256", "battery <10%"));
                if (requestedMaxTokens > 256) {
                    requestedMaxTokens = 256;
                }
            } else if (globalVerdict.getBatteryLevel() < 15) {
                list.add(new VerdictReason("RequestEnrichment", "maxTokens", "cap", "512", "battery <15%"));
                if (requestedMaxTokens > 512) {
                    requestedMaxTokens = 512;
                }
            } else if (globalVerdict.getBatteryLevel() < 20) {
                list.add(new VerdictReason("RequestEnrichment", "maxTokens", "cap", "1024", "battery <20%"));
                if (requestedMaxTokens > 1024) {
                    requestedMaxTokens = 1024;
                }
            }
        }
        if (globalVerdict.isForeground()) {
            return requestedMaxTokens;
        }
        if (requestedMaxTokens <= 512) {
            i10 = requestedMaxTokens;
        }
        list.add(new VerdictReason("RequestEnrichment", "maxTokens", "cap", String.valueOf(i10), "background: cap at 512"));
        if (globalVerdict.getBackgroundDurationMs() <= InteractiveSessionRegistry.DEFAULT_TTL_MS) {
            return i10;
        }
        int i11 = i10 <= 256 ? i10 : 256;
        list.add(new VerdictReason("RequestEnrichment", "maxTokens", "cap", String.valueOf(i11), "long-background >300s: cap at 256"));
        return i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int computeThreadCount(com.stepos.core.performance.data.GlobalVerdict r11, com.stepos.core.performance.data.PerformanceRequestContext r12, com.stepos.core.performance.data.SignalSnapshot r13, java.util.List<com.stepos.core.performance.data.VerdictReason> r14) {
        /*
            r10 = this;
            com.stepos.core.performance.data.CpuTopology r10 = r13.getCpuTopology()
            com.stepos.base.task.data.TaskPriority r12 = r12.getRequestPriority()
            int[] r13 = com.stepos.core.performance.orchestrator.RequestEnrichment.WhenMappings.$EnumSwitchMapping$0
            int r12 = r12.ordinal()
            r12 = r13[r12]
            r13 = 4
            r0 = 3
            r1 = 2
            r2 = 1
            if (r12 == r2) goto L32
            if (r12 == r1) goto L2b
            if (r12 == r0) goto L24
            if (r12 != r13) goto L1e
        L1c:
            r10 = r2
            goto L39
        L1e:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L24:
            int r10 = r10.getMediumCount()
            if (r10 >= r2) goto L39
            goto L1c
        L2b:
            int r10 = r10.getBigCount()
            if (r10 >= r2) goto L39
            goto L1c
        L32:
            int r10 = r10.getUltraBigCount()
            if (r10 >= r2) goto L39
            goto L1c
        L39:
            com.stepos.base.awareness.data.ThermalState r11 = r11.getThermalState()
            int[] r12 = com.stepos.core.performance.orchestrator.RequestEnrichment.WhenMappings.$EnumSwitchMapping$1
            int r11 = r11.ordinal()
            r11 = r12[r11]
            if (r11 == r2) goto L98
            if (r11 == r1) goto L75
            if (r11 == r0) goto L54
            if (r11 != r13) goto L4e
            return r10
        L4e:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L54:
            int r11 = r10 + (-1)
            if (r11 >= r2) goto L59
            goto L5a
        L59:
            r2 = r11
        L5a:
            com.stepos.core.performance.data.VerdictReason r3 = new com.stepos.core.performance.data.VerdictReason
            java.lang.String r7 = java.lang.String.valueOf(r2)
            java.lang.String r11 = "MODERATE thermal: baseline="
            java.lang.String r12 = " -1"
            java.lang.String r8 = ai.onnxruntime.a.g(r10, r11, r12)
            java.lang.String r4 = "RequestEnrichment"
            java.lang.String r5 = "threadCount"
            java.lang.String r6 = "reduce"
            r3.<init>(r4, r5, r6, r7, r8)
            r14.add(r3)
            return r2
        L75:
            float r11 = (float) r10
            r12 = 1050253722(0x3e99999a, float:0.3)
            float r11 = r11 * r12
            int r11 = (int) r11
            if (r11 >= r2) goto L7e
            goto L7f
        L7e:
            r2 = r11
        L7f:
            com.stepos.core.performance.data.VerdictReason r3 = new com.stepos.core.performance.data.VerdictReason
            java.lang.String r7 = java.lang.String.valueOf(r2)
            java.lang.String r11 = "SEVERE thermal: 30% of baseline="
            java.lang.String r8 = ai.onnxruntime.providers.a.a(r10, r11)
            java.lang.String r4 = "RequestEnrichment"
            java.lang.String r5 = "threadCount"
            java.lang.String r6 = "reduce"
            r3.<init>(r4, r5, r6, r7, r8)
            r14.add(r3)
            return r2
        L98:
            com.stepos.core.performance.data.VerdictReason r4 = new com.stepos.core.performance.data.VerdictReason
            java.lang.String r8 = "1"
            java.lang.String r9 = "CRITICAL thermal: force 1 thread"
            java.lang.String r5 = "RequestEnrichment"
            java.lang.String r6 = "threadCount"
            java.lang.String r7 = "reduce"
            r4.<init>(r5, r6, r7, r8, r9)
            r14.add(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.performance.orchestrator.RequestEnrichment.computeThreadCount(com.stepos.core.performance.data.GlobalVerdict, com.stepos.core.performance.data.PerformanceRequestContext, com.stepos.core.performance.data.SignalSnapshot, java.util.List):int");
    }

    private final long computeTimeoutMs(GlobalVerdict globalVerdict, PerformanceRequestContext performanceRequestContext, List<VerdictReason> list) {
        long requestedTimeoutMs = performanceRequestContext.getRequestedTimeoutMs();
        long modelHardCeilingMs = performanceRequestContext.getModelHardCeilingMs();
        boolean callerForeground = performanceRequestContext.getCallerForeground();
        boolean z = performanceRequestContext.getRequestPriority() == TaskPriority.f6397c;
        if (callerForeground || z) {
            list.add(new VerdictReason("RequestEnrichment", "timeoutMs", "keep", requestedTimeoutMs + "ms", (callerForeground && z) ? "caller foreground + P0 ultra-high, no compression" : callerForeground ? "caller foreground, no compression" : "P0 ultra-high realtime, no compression"));
            return requestedTimeoutMs;
        }
        if (globalVerdict.isForeground() || globalVerdict.getBackgroundDurationMs() <= InteractiveSessionRegistry.DEFAULT_TTL_MS) {
            list.add(new VerdictReason("RequestEnrichment", "timeoutMs", "keep", requestedTimeoutMs + "ms", "default baseline"));
            return requestedTimeoutMs;
        }
        long j10 = (long) (requestedTimeoutMs * 0.5d);
        long jMax = Math.max(j10, modelHardCeilingMs);
        StringBuilder sbQ = a.q(requestedTimeoutMs, "long-background >300s: 50% of baseline=", "ms -> ");
        sbQ.append(j10);
        list.add(new VerdictReason("RequestEnrichment", "timeoutMs", "compress", jMax + "ms", a0.a.d(modelHardCeilingMs, "ms, floored by model=", "ms", sbQ)));
        return jMax;
    }

    public final EnrichedVerdict enrich(GlobalVerdict global, PerformanceRequestContext context, SignalSnapshot snap) {
        g.f(global, "global");
        g.f(context, "context");
        g.f(snap, "snap");
        ArrayList arrayList = new ArrayList();
        return new EnrichedVerdict(global, computeBackend(global, context, arrayList), computeThreadCount(global, context, snap, arrayList), computeBatchSize(global, context, snap, arrayList), computeMaxTokens(global, context, arrayList), computeTimeoutMs(global, context, arrayList), arrayList);
    }
}
