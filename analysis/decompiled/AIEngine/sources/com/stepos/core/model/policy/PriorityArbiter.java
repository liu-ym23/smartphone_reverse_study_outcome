package com.stepos.core.model.policy;

import com.stepos.base.awareness.data.SceneType;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.model.task.AITaskRecord;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PriorityArbiter {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TaskPriority.values().length];
            try {
                TaskPriority.a aVar = TaskPriority.f6396b;
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                TaskPriority.a aVar2 = TaskPriority.f6396b;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                TaskPriority.a aVar3 = TaskPriority.f6396b;
                iArr[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                TaskPriority.a aVar4 = TaskPriority.f6396b;
                iArr[0] = 4;
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
            try {
                SceneType sceneType4 = SceneType.f6193a;
                iArr2[5] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private final TaskPriority adjustByAbility(TaskPriority taskPriority, String str) {
        if (g.b(str, "voice_assistant")) {
            int i10 = taskPriority.f6402a;
            TaskPriority taskPriority2 = TaskPriority.f6398d;
            if (i10 > 1) {
                return taskPriority2;
            }
        } else if (g.b(str, "background_analysis")) {
            int i11 = taskPriority.f6402a;
            TaskPriority taskPriority3 = TaskPriority.h;
            if (i11 < 3) {
                return taskPriority3;
            }
        }
        return taskPriority;
    }

    private final TaskPriority adjustByScene(TaskPriority taskPriority, SceneType sceneType) {
        int iOrdinal = sceneType.ordinal();
        if (iOrdinal == 1) {
            int iOrdinal2 = taskPriority.ordinal();
            if (iOrdinal2 == 1) {
                return TaskPriority.f6397c;
            }
            if (iOrdinal2 == 2) {
                return TaskPriority.f6398d;
            }
            if (iOrdinal2 == 3) {
                return TaskPriority.f6399e;
            }
        } else if (iOrdinal == 2) {
            int iOrdinal3 = taskPriority.ordinal();
            if (iOrdinal3 == 0) {
                return TaskPriority.f6398d;
            }
            if (iOrdinal3 == 1) {
                return TaskPriority.f6399e;
            }
            if (iOrdinal3 == 2) {
                return TaskPriority.h;
            }
        } else if ((iOrdinal == 4 || iOrdinal == 5) && taskPriority != TaskPriority.f6397c) {
            return TaskPriority.h;
        }
        return taskPriority;
    }

    public final TaskPriority arbitrate(AITaskRecord task, SceneType scene) {
        g.f(task, "task");
        g.f(scene, "scene");
        return adjustByAbility(adjustByScene(task.getPriority(), scene), task.getAbilityId());
    }
}
