package com.stepos.core.model.policy;

import com.stepos.base.awareness.data.SceneType;
import com.stepos.base.awareness.data.ThermalState;
import com.stepos.base.concurrency.data.PoolType;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.model.task.AITaskRecord;
import gc.q;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;
import r6.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SchedulePolicy {

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
            int[] iArr2 = new int[SceneType.values().length];
            try {
                SceneType sceneType = SceneType.f6193a;
                iArr2[1] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                SceneType sceneType2 = SceneType.f6193a;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                SceneType sceneType3 = SceneType.f6193a;
                iArr2[4] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public final int calculateThreads(b load) {
        g.f(load, "load");
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        if (load.f11748a > 0.8f) {
            int i10 = (int) (iAvailableProcessors * 0.5d);
            if (i10 < 1) {
                return 1;
            }
            return i10;
        }
        ThermalState thermalState = load.h;
        if (thermalState == ThermalState.f6202d) {
            int i11 = (int) (iAvailableProcessors * 0.3d);
            if (i11 < 1) {
                return 1;
            }
            return i11;
        }
        if (thermalState == ThermalState.f6203e) {
            return 1;
        }
        if (load.f11751d >= 0.2f || (iAvailableProcessors = (int) (iAvailableProcessors * 0.6d)) >= 1) {
            return iAvailableProcessors;
        }
        return 1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long calculateTimeout(com.stepos.core.model.task.AITaskRecord r3, com.stepos.base.awareness.data.SceneType r4) {
        /*
            r2 = this;
            java.lang.String r2 = "task"
            kotlin.jvm.internal.g.f(r3, r2)
            java.lang.String r2 = "scene"
            kotlin.jvm.internal.g.f(r4, r2)
            java.lang.String r2 = r3.getAbilityId()
            int r3 = r2.hashCode()
            r0 = 60000(0xea60, double:2.9644E-319)
            switch(r3) {
                case -495781871: goto L36;
                case -82551038: goto L29;
                case 116855: goto L20;
                case 3052376: goto L19;
                default: goto L18;
            }
        L18:
            goto L41
        L19:
            java.lang.String r3 = "chat"
            boolean r2 = r2.equals(r3)
            goto L41
        L20:
            java.lang.String r3 = "vlm"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L32
            goto L41
        L29:
            java.lang.String r3 = "image_caption"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L32
            goto L41
        L32:
            r0 = 90000(0x15f90, double:4.4466E-319)
            goto L41
        L36:
            java.lang.String r3 = "voice_assistant"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L3f
            goto L41
        L3f:
            r0 = 30000(0x7530, double:1.4822E-319)
        L41:
            int[] r2 = com.stepos.core.model.policy.SchedulePolicy.WhenMappings.$EnumSwitchMapping$1
            int r3 = r4.ordinal()
            r2 = r2[r3]
            r3 = 1
            if (r2 == r3) goto L5c
            r3 = 2
            if (r2 == r3) goto L59
            r3 = 3
            if (r2 == r3) goto L53
            return r0
        L53:
            double r2 = (double) r0
            r0 = 4609434218613702656(0x3ff8000000000000, double:1.5)
        L56:
            double r2 = r2 * r0
            long r2 = (long) r2
            return r2
        L59:
            long r2 = (long) r3
            long r0 = r0 * r2
            return r0
        L5c:
            double r2 = (double) r0
            r0 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.policy.SchedulePolicy.calculateTimeout(com.stepos.core.model.task.AITaskRecord, com.stepos.base.awareness.data.SceneType):long");
    }

    public final PoolType selectPool(AITaskRecord task, TaskPriority priority, b load) {
        g.f(task, "task");
        g.f(priority, "priority");
        g.f(load, "load");
        if (load.f11748a > 0.8f) {
            return PoolType.h;
        }
        if (!q.l0(task.getAbilityId(), ModelCacheImpl.MODEL_TYPE_VLM, true)) {
            PoolType.f6214b.getClass();
            return PoolType.a.a(priority);
        }
        int iOrdinal = priority.ordinal();
        if (iOrdinal == 0) {
            return PoolType.f6215c;
        }
        if (iOrdinal == 1) {
            return PoolType.f6216d;
        }
        if (iOrdinal == 2) {
            return PoolType.f6217e;
        }
        if (iOrdinal == 3) {
            return PoolType.h;
        }
        throw new NoWhenBranchMatchedException();
    }
}
