package com.stepos.core.model.policy;

import com.stepos.base.awareness.data.SceneType;
import com.stepos.base.concurrency.data.PoolType;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.common.runtime.EngineRuntimeConfig;
import com.stepos.core.model.task.AITaskRecord;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import q6.a;
import r6.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyEngine {
    private final PriorityArbiter priorityArbiter;
    private final a sceneAwareness;
    private final SchedulePolicy schedulePolicy;

    /* JADX WARN: Multi-variable type inference failed */
    public PolicyEngine() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final int calculateOomAdj(TaskPriority taskPriority, SceneType sceneType) {
        if (sceneType == SceneType.f6194b) {
            return 0;
        }
        if (taskPriority == TaskPriority.f6397c) {
            return 100;
        }
        if (taskPriority == TaskPriority.f6398d) {
            return 200;
        }
        if (sceneType == SceneType.f6195c) {
            return 900;
        }
        if (sceneType == SceneType.f6197e) {
            return EngineRuntimeConfig.MIN_ABSOLUTE_TARGET_MB;
        }
        return 500;
    }

    public static r6.a makeDecision$default(PolicyEngine policyEngine, AITaskRecord aITaskRecord, SceneType sceneType, b bVar, int i10, Object obj) {
        a aVar;
        a aVar2;
        if ((i10 & 2) != 0 && ((aVar2 = policyEngine.sceneAwareness) == null || (sceneType = aVar2.getCurrentScene()) == null)) {
            sceneType = SceneType.f6193a;
        }
        if ((i10 & 4) != 0 && ((aVar = policyEngine.sceneAwareness) == null || (bVar = aVar.getSystemLoad()) == null)) {
            b bVar2 = b.f11747j;
            bVar = b.f11747j;
        }
        return policyEngine.makeDecision(aITaskRecord, sceneType, bVar);
    }

    public final r6.a makeDecision(AITaskRecord task, SceneType scene, b load) {
        g.f(task, "task");
        g.f(scene, "scene");
        g.f(load, "load");
        TaskPriority taskPriorityArbitrate = this.priorityArbiter.arbitrate(task, scene);
        PoolType poolTypeSelectPool = this.schedulePolicy.selectPool(task, taskPriorityArbitrate, load);
        return new r6.a(scene, null, poolTypeSelectPool.name(), this.schedulePolicy.calculateThreads(load), this.schedulePolicy.calculateTimeout(task, scene), 0, calculateOomAdj(taskPriorityArbitrate, scene), 3554);
    }

    public PolicyEngine(a aVar) {
        this.sceneAwareness = aVar;
        this.priorityArbiter = new PriorityArbiter();
        this.schedulePolicy = new SchedulePolicy();
    }

    public /* synthetic */ PolicyEngine(a aVar, int i10, e eVar) {
        this((i10 & 1) != 0 ? null : aVar);
    }
}
