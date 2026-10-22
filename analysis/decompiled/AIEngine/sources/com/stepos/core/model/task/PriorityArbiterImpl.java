package com.stepos.core.model.task;

import android.content.Context;
import android.util.Log;
import com.stepos.base.health.EngineMetrics;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.performance.signal.AdjSegment;
import com.stepos.core.performance.signal.AndroidPerUidSignalProvider;
import com.stepos.core.performance.signal.PerUidSignalProvider;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PriorityArbiterImpl implements j7.a {
    public static final Companion Companion = new Companion(null);
    private final PerUidSignalProvider perUidSignalProvider;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[AdjSegment.values().length];
                try {
                    iArr[AdjSegment.LT100.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AdjSegment.LT400.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AdjSegment.GE400.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[TaskPriority.values().length];
                try {
                    TaskPriority.a aVar = TaskPriority.f6396b;
                    iArr2[0] = 1;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    TaskPriority.a aVar2 = TaskPriority.f6396b;
                    iArr2[1] = 2;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    TaskPriority.a aVar3 = TaskPriority.f6396b;
                    iArr2[2] = 3;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    TaskPriority.a aVar4 = TaskPriority.f6396b;
                    iArr2[3] = 4;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final TaskPriority arbitrate(TaskPriority declared, AdjSegment adj) {
            TaskPriority taskPriority;
            g.f(declared, "declared");
            g.f(adj, "adj");
            int iOrdinal = declared.ordinal();
            if (iOrdinal == 0) {
                int i10 = WhenMappings.$EnumSwitchMapping$0[adj.ordinal()];
                if (i10 == 1) {
                    taskPriority = TaskPriority.f6397c;
                } else if (i10 == 2) {
                    taskPriority = TaskPriority.f6398d;
                } else {
                    if (i10 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    taskPriority = TaskPriority.h;
                }
            } else if (iOrdinal == 1) {
                int i11 = WhenMappings.$EnumSwitchMapping$0[adj.ordinal()];
                if (i11 == 1 || i11 == 2) {
                    taskPriority = TaskPriority.f6398d;
                } else {
                    if (i11 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    taskPriority = TaskPriority.h;
                }
            } else if (iOrdinal == 2) {
                int i12 = WhenMappings.$EnumSwitchMapping$0[adj.ordinal()];
                if (i12 == 1 || i12 == 2) {
                    taskPriority = TaskPriority.f6399e;
                } else {
                    if (i12 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    taskPriority = TaskPriority.h;
                }
            } else {
                if (iOrdinal != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                taskPriority = TaskPriority.h;
            }
            TaskPriority.f6396b.getClass();
            return (TaskPriority) TaskPriority.f6401k.get(Math.max(declared.ordinal(), taskPriority.ordinal()));
        }

        public final PriorityArbiterImpl forContext(Context context) {
            g.f(context, "context");
            return new PriorityArbiterImpl(new AndroidPerUidSignalProvider(context));
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PriorityArbiterImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // j7.a
    public TaskPriority calculate(j7.b task, String str, float f8, int i10) {
        g.f(task, "task");
        TaskPriority priority = task.getPriority();
        AITaskRecord aITaskRecord = task instanceof AITaskRecord ? (AITaskRecord) task : null;
        int callerUid = aITaskRecord != null ? aITaskRecord.getCallerUid() : 0;
        AdjSegment adjSegment = this.perUidSignalProvider.readAdjSegment(callerUid);
        boolean zIsFocused = this.perUidSignalProvider.isFocused(callerUid);
        TaskPriority taskPriorityArbitrate = Companion.arbitrate(priority, adjSegment);
        Log.i("PriorityArbiter", "档位裁决 uid=" + callerUid + "：声明档=" + priority + "，实时读到 应用段位=" + adjSegment + " 是否有焦点=" + zIsFocused + "，按降档矩阵算出 最终档=" + taskPriorityArbitrate + (taskPriorityArbitrate != priority ? "（发生降档）" : "（未降档）"));
        if (aITaskRecord != null) {
            aITaskRecord.setFinalTier(taskPriorityArbitrate);
            aITaskRecord.setPriorityScore(taskPriorityArbitrate.a());
            if (taskPriorityArbitrate != priority) {
                AtomicLong atomicLong = EngineMetrics.f6226a;
                EngineMetrics.f6232g.incrementAndGet();
            }
        }
        return taskPriorityArbitrate;
    }

    public int compare(j7.b task1, j7.b task2) {
        g.f(task1, "task1");
        g.f(task2, "task2");
        return getScore(task2, null, 0.0f, 0) - getScore(task1, null, 0.0f, 0);
    }

    @Override // j7.a
    public int getScore(j7.b task, String str, float f8, int i10) {
        TaskPriority finalTier;
        g.f(task, "task");
        AITaskRecord aITaskRecord = task instanceof AITaskRecord ? (AITaskRecord) task : null;
        return (aITaskRecord == null || (finalTier = aITaskRecord.getFinalTier()) == null) ? task.getPriority().a() : finalTier.a();
    }

    public PriorityArbiterImpl(PerUidSignalProvider perUidSignalProvider) {
        g.f(perUidSignalProvider, "perUidSignalProvider");
        this.perUidSignalProvider = perUidSignalProvider;
    }

    public /* synthetic */ PriorityArbiterImpl(PerUidSignalProvider perUidSignalProvider, int i10, e eVar) {
        this((i10 & 1) != 0 ? AndroidPerUidSignalProvider.Companion.getEMPTY() : perUidSignalProvider);
    }
}
