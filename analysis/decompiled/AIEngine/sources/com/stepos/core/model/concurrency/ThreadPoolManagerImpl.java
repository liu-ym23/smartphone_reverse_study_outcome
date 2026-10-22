package com.stepos.core.model.concurrency;

import android.os.SystemClock;
import android.util.Log;
import com.stepos.base.concurrency.data.PoolType;
import com.stepos.base.health.EngineMetrics;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.ability.h;
import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.common.runtime.EngineRuntimeConfig;
import com.stepos.core.model.concurrency.ThreadPoolManagerImpl;
import com.stepos.core.model.task.AITaskRecord;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import lb.n;
import mb.m;
import mb.v;
import rb.c;
import v1.d;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ThreadPoolManagerImpl implements t6.b {
    private static final int SAME_MODEL_STREAK = 4;
    private static final String TAG = "ThreadPoolManager";
    private static volatile ThreadPoolManagerImpl latestInstance;
    private final ConcurrentHashMap.KeySetView<String, Boolean> dispatchPauseSources;
    private final Map<PoolType, PoolLane> lanes;
    private volatile boolean pauseNormalBg;
    private final ConcurrentHashMap<Integer, Long> recentForegroundMonoMs;
    private final CoroutineScope scope;
    private final AtomicBoolean shutdown;
    private final t6.a taskExecutor;
    private final ConcurrentHashMap<String, Job> taskJobs;
    private volatile long thermalPauseStartedAtMonoMs;
    private volatile long thermalRecoverAtMonoMs;
    public static final Companion Companion = new Companion(null);
    private static final Map<PoolType, Long> WAIT_BOOST_MS = kotlin.collections.b.g0(new Pair(PoolType.f6215c, 300L), new Pair(PoolType.f6216d, 800L), new Pair(PoolType.f6217e, 3000L), new Pair(PoolType.h, Long.valueOf(TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS)));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final ThreadPoolManagerImpl latestInstanceOrNull() {
            return ThreadPoolManagerImpl.latestInstance;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class PoolLane {
        private final Set<String> activeTaskIds;
        private final Channel<Work> channel;
        private final AtomicInteger enqueued;
        private final AtomicLong lastModelHash;
        private final Semaphore permits;
        private final AtomicInteger running;
        private final AtomicInteger sameModelStreak;
        private final PoolType type;
        private final AtomicInteger uidCursor;
        private final Channel<n> wakeup;

        public PoolLane(PoolType type) {
            g.f(type, "type");
            this.type = type;
            this.channel = ChannelKt.Channel$default(4, null, null, 6, null);
            this.permits = SemaphoreKt.Semaphore$default(type.f6219a, 0, 2, null);
            this.enqueued = new AtomicInteger(0);
            this.running = new AtomicInteger(0);
            this.lastModelHash = new AtomicLong(0L);
            this.sameModelStreak = new AtomicInteger(0);
            this.wakeup = ChannelKt.Channel$default(1, BufferOverflow.DROP_OLDEST, null, 4, null);
            this.uidCursor = new AtomicInteger(0);
            ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
            g.e(keySetViewNewKeySet, "newKeySet(...)");
            this.activeTaskIds = keySetViewNewKeySet;
        }

        public final Set<String> getActiveTaskIds() {
            return this.activeTaskIds;
        }

        public final Channel<Work> getChannel() {
            return this.channel;
        }

        public final AtomicInteger getEnqueued() {
            return this.enqueued;
        }

        public final AtomicLong getLastModelHash() {
            return this.lastModelHash;
        }

        public final Semaphore getPermits() {
            return this.permits;
        }

        public final AtomicInteger getRunning() {
            return this.running;
        }

        public final AtomicInteger getSameModelStreak() {
            return this.sameModelStreak;
        }

        public final PoolType getType() {
            return this.type;
        }

        public final AtomicInteger getUidCursor() {
            return this.uidCursor;
        }

        public final Channel<n> getWakeup() {
            return this.wakeup;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class PoolStats {
        private final int capacity;
        private final int enqueued;
        private final int running;

        public PoolStats(int i10, int i11, int i12) {
            this.enqueued = i10;
            this.running = i11;
            this.capacity = i12;
        }

        public static /* synthetic */ PoolStats copy$default(PoolStats poolStats, int i10, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i10 = poolStats.enqueued;
            }
            if ((i13 & 2) != 0) {
                i11 = poolStats.running;
            }
            if ((i13 & 4) != 0) {
                i12 = poolStats.capacity;
            }
            return poolStats.copy(i10, i11, i12);
        }

        public final int component1() {
            return this.enqueued;
        }

        public final int component2() {
            return this.running;
        }

        public final int component3() {
            return this.capacity;
        }

        public final PoolStats copy(int i10, int i11, int i12) {
            return new PoolStats(i10, i11, i12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PoolStats)) {
                return false;
            }
            PoolStats poolStats = (PoolStats) obj;
            return this.enqueued == poolStats.enqueued && this.running == poolStats.running && this.capacity == poolStats.capacity;
        }

        public final int getCapacity() {
            return this.capacity;
        }

        public final int getEnqueued() {
            return this.enqueued;
        }

        public final int getRunning() {
            return this.running;
        }

        public int hashCode() {
            return Integer.hashCode(this.capacity) + ai.onnxruntime.a.d(this.running, Integer.hashCode(this.enqueued) * 31, 31);
        }

        public String toString() {
            return ai.onnxruntime.a.j(")", this.capacity, h0.e.d(this.enqueued, "PoolStats(enqueued=", this.running, ", running=", ", capacity="));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Work {
        private final long enqueuedAtMonoMs;
        private final String modelId;
        private final l<qb.b<? super n>, Object> runner;
        private final String taskId;
        private final int uid;

        /* JADX WARN: Multi-variable type inference failed */
        public Work(String taskId, int i10, String modelId, long j10, l<? super qb.b<? super n>, ? extends Object> runner) {
            g.f(taskId, "taskId");
            g.f(modelId, "modelId");
            g.f(runner, "runner");
            this.taskId = taskId;
            this.uid = i10;
            this.modelId = modelId;
            this.enqueuedAtMonoMs = j10;
            this.runner = runner;
        }

        public static /* synthetic */ Work copy$default(Work work, String str, int i10, String str2, long j10, l lVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = work.taskId;
            }
            if ((i11 & 2) != 0) {
                i10 = work.uid;
            }
            if ((i11 & 4) != 0) {
                str2 = work.modelId;
            }
            if ((i11 & 8) != 0) {
                j10 = work.enqueuedAtMonoMs;
            }
            if ((i11 & 16) != 0) {
                lVar = work.runner;
            }
            l lVar2 = lVar;
            String str3 = str2;
            return work.copy(str, i10, str3, j10, lVar2);
        }

        public final String component1() {
            return this.taskId;
        }

        public final int component2() {
            return this.uid;
        }

        public final String component3() {
            return this.modelId;
        }

        public final long component4() {
            return this.enqueuedAtMonoMs;
        }

        public final l<qb.b<? super n>, Object> component5() {
            return this.runner;
        }

        public final Work copy(String taskId, int i10, String modelId, long j10, l<? super qb.b<? super n>, ? extends Object> runner) {
            g.f(taskId, "taskId");
            g.f(modelId, "modelId");
            g.f(runner, "runner");
            return new Work(taskId, i10, modelId, j10, runner);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Work)) {
                return false;
            }
            Work work = (Work) obj;
            return g.b(this.taskId, work.taskId) && this.uid == work.uid && g.b(this.modelId, work.modelId) && this.enqueuedAtMonoMs == work.enqueuedAtMonoMs && g.b(this.runner, work.runner);
        }

        public final long getEnqueuedAtMonoMs() {
            return this.enqueuedAtMonoMs;
        }

        public final String getModelId() {
            return this.modelId;
        }

        public final l<qb.b<? super n>, Object> getRunner() {
            return this.runner;
        }

        public final String getTaskId() {
            return this.taskId;
        }

        public final int getUid() {
            return this.uid;
        }

        public int hashCode() {
            return this.runner.hashCode() + a0.a.c(d.a(ai.onnxruntime.a.d(this.uid, this.taskId.hashCode() * 31, 31), 31, this.modelId), this.enqueuedAtMonoMs, 31);
        }

        public String toString() {
            String str = this.taskId;
            int i10 = this.uid;
            String str2 = this.modelId;
            long j10 = this.enqueuedAtMonoMs;
            l<qb.b<? super n>, Object> lVar = this.runner;
            StringBuilder sbF = h0.e.f("Work(taskId=", str, ", uid=", i10, ", modelId=");
            com.stepos.core.ota.d.p(j10, str2, ", enqueuedAtMonoMs=", sbF);
            sbF.append(", runner=");
            sbF.append(lVar);
            sbF.append(")");
            return sbF.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.model.concurrency.ThreadPoolManagerImpl", f = "ThreadPoolManagerImpl.kt", l = {388}, m = "awaitPoolsIdle")
    /* renamed from: com.stepos.core.model.concurrency.ThreadPoolManagerImpl$awaitPoolsIdle$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ThreadPoolManagerImpl.this.awaitPoolsIdle(null, 0L, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.model.concurrency.ThreadPoolManagerImpl$awaitPoolsIdle$2", f = "ThreadPoolManagerImpl.kt", l = {389}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.concurrency.ThreadPoolManagerImpl$awaitPoolsIdle$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super Boolean>, Object> {
        final /* synthetic */ Set<PoolType> $pools;
        int label;
        final /* synthetic */ ThreadPoolManagerImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Set<? extends PoolType> set, ThreadPoolManagerImpl threadPoolManagerImpl, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$pools = set;
            this.this$0 = threadPoolManagerImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new AnonymousClass2(this.$pools, this.this$0, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AtomicInteger running;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 != 0 && i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            do {
                Set<PoolType> set = this.$pools;
                ThreadPoolManagerImpl threadPoolManagerImpl = this.this$0;
                boolean z = false;
                if (!(set instanceof Collection) || !set.isEmpty()) {
                    Iterator<T> it = set.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PoolLane poolLane = (PoolLane) threadPoolManagerImpl.lanes.get((PoolType) it.next());
                        if (((poolLane == null || (running = poolLane.getRunning()) == null) ? 0 : running.get()) > 0) {
                            z = true;
                            break;
                        }
                    }
                }
                if (!z) {
                    return Boolean.TRUE;
                }
                this.label = 1;
            } while (DelayKt.delay(20L, this) != coroutineSingletons);
            return coroutineSingletons;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super Boolean> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.model.concurrency.ThreadPoolManagerImpl$launchConsumer$1", f = "ThreadPoolManagerImpl.kt", l = {426, 430, 460}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.concurrency.ThreadPoolManagerImpl$launchConsumer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03741 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ PoolLane $lane;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ThreadPoolManagerImpl this$0;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @c(c = "com.stepos.core.model.concurrency.ThreadPoolManagerImpl$launchConsumer$1$1", f = "ThreadPoolManagerImpl.kt", l = {426}, m = "invokeSuspend")
        /* renamed from: com.stepos.core.model.concurrency.ThreadPoolManagerImpl$launchConsumer$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00571 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
            final /* synthetic */ PoolLane $lane;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00571(PoolLane poolLane, qb.b<? super C00571> bVar) {
                super(2, bVar);
                this.$lane = poolLane;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final qb.b<n> create(Object obj, qb.b<?> bVar) {
                return new C00571(this.$lane, bVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                int i10 = this.label;
                if (i10 == 0) {
                    kotlin.c.b(obj);
                    Channel<n> wakeup = this.$lane.getWakeup();
                    this.label = 1;
                    if (wakeup.receive(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.c.b(obj);
                }
                return n.f10413a;
            }

            @Override // zb.p
            public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
                return ((C00571) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03741(PoolLane poolLane, ThreadPoolManagerImpl threadPoolManagerImpl, qb.b<? super C03741> bVar) {
            super(2, bVar);
            this.$lane = poolLane;
            this.this$0 = threadPoolManagerImpl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n invokeSuspend$lambda$0(PoolLane poolLane, Work work, ThreadPoolManagerImpl threadPoolManagerImpl, Job job, Throwable th) {
            if (th != null && !(th instanceof CancellationException)) {
                Log.e(ThreadPoolManagerImpl.TAG, "consumer runner failed pool=" + poolLane.getType() + " task=" + work.getTaskId(), th);
            }
            poolLane.getPermits().release();
            poolLane.getRunning().decrementAndGet();
            poolLane.getActiveTaskIds().remove(work.getTaskId());
            threadPoolManagerImpl.taskJobs.remove(work.getTaskId(), job);
            return n.f10413a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new C03741(this.$lane, this.this$0, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x00aa, code lost:
        
            if (r13 == r0) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x019b, code lost:
        
            if (r13.acquire(r12) != r0) goto L54;
         */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00fa  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0124  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x014a  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x020c A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:65:? A[LOOP:0: B:13:0x005e->B:65:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x019b -> B:54:0x019e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 528
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.concurrency.ThreadPoolManagerImpl.C03741.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C03741) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.model.concurrency.ThreadPoolManagerImpl$submitFlow$1", f = "ThreadPoolManagerImpl.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.concurrency.ThreadPoolManagerImpl$submitFlow$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03751 extends SuspendLambda implements p<ProducerScope<? super Result<? extends Object>>, qb.b<? super n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C03751(qb.b<? super C03751> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            C03751 c03751 = new C03751(bVar);
            c03751.L$0 = obj;
            return c03751;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            SendChannel.DefaultImpls.close$default((ProducerScope) this.L$0, null, 1, null);
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(ProducerScope<? super Result<? extends Object>> producerScope, qb.b<? super n> bVar) {
            return ((C03751) create(producerScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.model.concurrency.ThreadPoolManagerImpl$submitFlow$2", f = "ThreadPoolManagerImpl.kt", l = {231}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.concurrency.ThreadPoolManagerImpl$submitFlow$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03762 extends SuspendLambda implements p<ProducerScope<? super Result<? extends Object>>, qb.b<? super n>, Object> {
        final /* synthetic */ l<qb.b<? super Flow<? extends Result<? extends Object>>>, Object> $block;
        final /* synthetic */ int $callerUid;
        final /* synthetic */ PoolLane $lane;
        final /* synthetic */ String $taskId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ThreadPoolManagerImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C03762(String str, int i10, ThreadPoolManagerImpl threadPoolManagerImpl, PoolLane poolLane, l<? super qb.b<? super Flow<? extends Result<? extends Object>>>, ? extends Object> lVar, qb.b<? super C03762> bVar) {
            super(2, bVar);
            this.$taskId = str;
            this.$callerUid = i10;
            this.this$0 = threadPoolManagerImpl;
            this.$lane = poolLane;
            this.$block = lVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n invokeSuspend$lambda$0(ThreadPoolManagerImpl threadPoolManagerImpl, String str) {
            Job job = (Job) threadPoolManagerImpl.taskJobs.get(str);
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, null, 1, null);
            }
            threadPoolManagerImpl.taskJobs.remove(str);
            return n.f10413a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            C03762 c03762 = new C03762(this.$taskId, this.$callerUid, this.this$0, this.$lane, this.$block, bVar);
            c03762.L$0 = obj;
            return c03762;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                this.this$0.enqueueOrReject(this.$lane, new Work(this.$taskId, this.$callerUid, "", SystemClock.elapsedRealtime(), new ThreadPoolManagerImpl$submitFlow$2$work$1(this.$block, this.this$0, this.$taskId, producerScope, null)));
                final ThreadPoolManagerImpl threadPoolManagerImpl = this.this$0;
                final String str = this.$taskId;
                zb.a aVar = new zb.a() { // from class: com.stepos.core.model.concurrency.b
                    @Override // zb.a
                    public final Object invoke() {
                        return ThreadPoolManagerImpl.C03762.invokeSuspend$lambda$0(threadPoolManagerImpl, str);
                    }
                };
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, aVar, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(ProducerScope<? super Result<? extends Object>> producerScope, qb.b<? super n> bVar) {
            return ((C03762) create(producerScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ThreadPoolManagerImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ t6.a access$getTaskExecutor$p(ThreadPoolManagerImpl threadPoolManagerImpl) {
        threadPoolManagerImpl.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueueOrReject(PoolLane poolLane, Work work) {
        if (ChannelResult.m160isSuccessimpl(poolLane.getChannel().mo149trySendJP2dKIU(work))) {
            poolLane.getEnqueued().incrementAndGet();
            poolLane.getWakeup().mo149trySendJP2dKIU(n.f10413a);
            return;
        }
        EngineMetrics.f6229d.incrementAndGet();
        AtomicLong atomicLong = (AtomicLong) EngineMetrics.f6230e.get(poolLane.getType());
        if (atomicLong != null) {
            atomicLong.incrementAndGet();
        }
        EngineMetrics.f6231f.computeIfAbsent(Integer.valueOf(work.getUid()), new h(new com.stepos.core.common.cloud.d(10), 3)).incrementAndGet();
        Log.w(TAG, "queue full pool=" + poolLane.getType() + " uid=" + work.getUid() + " task=" + work.getTaskId());
        throw new BackpressureException("queue full: pool=" + poolLane.getType() + " uid=" + work.getUid(), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AtomicLong enqueueOrReject$lambda$10(l lVar, Object obj) {
        return (AtomicLong) lVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AtomicLong enqueueOrReject$lambda$9(Integer it) {
        g.f(it, "it");
        return new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PressureCancelledException findPressureCancelled(Throwable th) {
        for (int i10 = 0; th != null && i10 < 8; i10++) {
            if (th instanceof PressureCancelledException) {
                return (PressureCancelledException) th;
            }
            th = th.getCause();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean gateBlockedFor(PoolType poolType) {
        if (poolType != PoolType.f6217e && poolType != PoolType.h) {
            return false;
        }
        if (this.pauseNormalBg) {
            return true;
        }
        long j10 = this.thermalRecoverAtMonoMs;
        return j10 > 0 && SystemClock.elapsedRealtime() < j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getForegroundExemptionWindowMs() {
        return EngineRuntimeConfig.INSTANCE.getSnapshot().getFgTaskWindowMs();
    }

    private final long getThermalRecoverCooldownMs() {
        return EngineRuntimeConfig.INSTANCE.getSnapshot().getThermalRecoverCooldownMs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasForegroundTaskInWindow$lambda$13(long j10, long j11, Map.Entry entry) {
        g.f(entry, "<destruct>");
        Object value = entry.getValue();
        g.e(value, "component2(...)");
        return j10 - ((Long) value).longValue() > j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasForegroundTaskInWindow$lambda$14(l lVar, Object obj) {
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    private final void launchConsumer(PoolLane poolLane) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C03741(poolLane, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Work pickByUidRoundRobin(PoolLane poolLane, ArrayDeque<Work> arrayDeque) {
        if (arrayDeque.size() <= 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList(m.Z(arrayDeque, 10));
        Iterator<T> it = arrayDeque.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((Work) it.next()).getUid()));
        }
        List listO0 = kotlin.collections.a.o0(arrayList);
        if (listO0.size() <= 1) {
            return null;
        }
        int iIntValue = ((Number) listO0.get(Math.floorMod(poolLane.getUidCursor().getAndIncrement(), listO0.size()))).intValue();
        Iterator<Work> it2 = arrayDeque.iterator();
        g.e(it2, "iterator(...)");
        while (it2.hasNext()) {
            Work next = it2.next();
            if (next.getUid() == iIntValue) {
                it2.remove();
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Work pickWithModelStreak(PoolLane poolLane, ArrayDeque<Work> arrayDeque) {
        long j10 = poolLane.getLastModelHash().get();
        if (poolLane.getSameModelStreak().get() >= 4) {
            Iterator<Work> it = arrayDeque.iterator();
            g.e(it, "iterator(...)");
            while (it.hasNext()) {
                Work next = it.next();
                if (next.getModelId().hashCode() != j10) {
                    it.remove();
                    return next;
                }
            }
        }
        Work workPollFirst = arrayDeque.pollFirst();
        g.e(workPollFirst, "pollFirst(...)");
        return workPollFirst;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean pressureBlockedFor(PoolType poolType) {
        if (poolType != PoolType.f6217e && poolType != PoolType.h) {
            return false;
        }
        ConcurrentHashMap.KeySetView<String, Boolean> dispatchPauseSources = this.dispatchPauseSources;
        g.e(dispatchPauseSources, "dispatchPauseSources");
        return !dispatchPauseSources.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordForegroundTouch(int i10) {
        this.recentForegroundMonoMs.put(Integer.valueOf(i10), Long.valueOf(SystemClock.elapsedRealtime()));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitPoolsIdle(java.util.Set<? extends com.stepos.base.concurrency.data.PoolType> r5, long r6, qb.b<? super java.lang.Boolean> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.stepos.core.model.concurrency.ThreadPoolManagerImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.core.model.concurrency.ThreadPoolManagerImpl$awaitPoolsIdle$1 r0 = (com.stepos.core.model.concurrency.ThreadPoolManagerImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.model.concurrency.ThreadPoolManagerImpl$awaitPoolsIdle$1 r0 = new com.stepos.core.model.concurrency.ThreadPoolManagerImpl$awaitPoolsIdle$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r8)
            goto L41
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.c.b(r8)
            com.stepos.core.model.concurrency.ThreadPoolManagerImpl$awaitPoolsIdle$2 r8 = new com.stepos.core.model.concurrency.ThreadPoolManagerImpl$awaitPoolsIdle$2
            r2 = 0
            r8.<init>(r5, r4, r2)
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r6, r8, r0)
            if (r8 != r1) goto L41
            return r1
        L41:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            if (r8 == 0) goto L4a
            boolean r4 = r8.booleanValue()
            goto L4b
        L4a:
            r4 = 0
        L4b:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.concurrency.ThreadPoolManagerImpl.awaitPoolsIdle(java.util.Set, long, qb.b):java.lang.Object");
    }

    public boolean cancel(String taskId) {
        g.f(taskId, "taskId");
        Job job = this.taskJobs.get(taskId);
        if (job == null) {
            return false;
        }
        Job.DefaultImpls.cancel$default(job, null, 1, null);
        this.taskJobs.remove(taskId);
        return true;
    }

    public final int cancelPools(Set<? extends PoolType> pools, String reason) {
        g.f(pools, "pools");
        g.f(reason, "reason");
        int i10 = 0;
        for (PoolType poolType : pools) {
            PoolLane poolLane = this.lanes.get(poolType);
            if (poolLane != null) {
                Iterator it = kotlin.collections.a.O0(poolLane.getActiveTaskIds()).iterator();
                while (it.hasNext()) {
                    Job job = this.taskJobs.get((String) it.next());
                    if (job != null && job.isActive()) {
                        job.cancel(new PressureCancelledException("pressure cancelled: pool=" + poolType + " reason=" + reason, 0L, 2, null));
                        i10++;
                    }
                }
            }
        }
        if (i10 > 0) {
            Log.w(TAG, "cancelPools: cancelled=" + i10 + " pools=" + pools + " reason=" + reason);
        }
        return i10;
    }

    public int getActiveCount(PoolType poolType) {
        AtomicInteger running;
        g.f(poolType, "poolType");
        PoolLane poolLane = this.lanes.get(poolType);
        if (poolLane == null || (running = poolLane.getRunning()) == null) {
            return 0;
        }
        return running.get();
    }

    public final int getInflightCount(PoolType poolType) {
        g.f(poolType, "poolType");
        return getActiveCount(poolType);
    }

    public final int getMaxQueueSize(PoolType poolType) {
        g.f(poolType, "poolType");
        PoolLane poolLane = this.lanes.get(poolType);
        return (poolLane == null || poolLane.getType() == null) ? 0 : 4;
    }

    public int getQueueSize(PoolType poolType) {
        AtomicInteger enqueued;
        g.f(poolType, "poolType");
        PoolLane poolLane = this.lanes.get(poolType);
        if (poolLane == null || (enqueued = poolLane.getEnqueued()) == null) {
            return 0;
        }
        return enqueued.get();
    }

    public final Map<PoolType, PoolStats> getStats() {
        Map<PoolType, PoolLane> map = this.lanes;
        LinkedHashMap linkedHashMap = new LinkedHashMap(v.a0(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            PoolLane poolLane = (PoolLane) entry.getValue();
            int i10 = poolLane.getEnqueued().get();
            int i11 = poolLane.getRunning().get();
            poolLane.getType().getClass();
            linkedHashMap.put(key, new PoolStats(i10, i11, 4));
        }
        return linkedHashMap;
    }

    public int getTotalActiveCount() {
        Iterator<T> it = this.lanes.values().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += ((PoolLane) it.next()).getRunning().get();
        }
        return i10;
    }

    public final boolean hasForegroundTaskInWindow(long j10) {
        boolean z = false;
        if (this.recentForegroundMonoMs.isEmpty()) {
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Set<Map.Entry<Integer, Long>> setEntrySet = this.recentForegroundMonoMs.entrySet();
        g.e(setEntrySet, "<get-entries>(...)");
        Set<Map.Entry<Integer, Long>> set = setEntrySet;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                g.c(entry);
                Object value = entry.getValue();
                g.e(value, "component2(...)");
                if (jElapsedRealtime - ((Long) value).longValue() <= j10) {
                    z = true;
                    break;
                }
            }
        }
        this.recentForegroundMonoMs.entrySet().removeIf(new b9.b(new b9.a(jElapsedRealtime, j10, 1), 6));
        return z;
    }

    public final boolean isDispatchGateClosed(PoolType pool) {
        g.f(pool, "pool");
        return pressureBlockedFor(pool) || gateBlockedFor(pool);
    }

    public boolean isShutdown() {
        return this.shutdown.get();
    }

    public final void onThermalStateChange(boolean z) {
        if (z) {
            if (this.pauseNormalBg) {
                return;
            }
            this.pauseNormalBg = true;
            this.thermalPauseStartedAtMonoMs = SystemClock.elapsedRealtime();
            AtomicLong atomicLong = EngineMetrics.f6226a;
            EngineMetrics.D.incrementAndGet();
            Log.w(TAG, "thermal SEVERE, pause NORMAL/BG dispatch");
            return;
        }
        if (this.pauseNormalBg) {
            long thermalRecoverCooldownMs = getThermalRecoverCooldownMs();
            this.thermalRecoverAtMonoMs = SystemClock.elapsedRealtime() + thermalRecoverCooldownMs;
            this.pauseNormalBg = false;
            long j10 = this.thermalPauseStartedAtMonoMs;
            if (j10 > 0) {
                AtomicLong atomicLong2 = EngineMetrics.f6226a;
                EngineMetrics.F.l(SystemClock.elapsedRealtime() - j10);
            }
            Iterator<T> it = this.lanes.values().iterator();
            while (it.hasNext()) {
                ((PoolLane) it.next()).getWakeup().mo149trySendJP2dKIU(n.f10413a);
            }
            Log.i(TAG, "thermal recovered, resume after " + thermalRecoverCooldownMs + "ms cooldown");
        }
    }

    public final void pauseNormalBgDispatch(String source) {
        g.f(source, "source");
        if (this.dispatchPauseSources.add(source)) {
            Log.w(TAG, "pause NORMAL/BG dispatch: source=" + source + " active=" + this.dispatchPauseSources);
        }
    }

    public final void resumeNormalBgDispatch(String source) {
        g.f(source, "source");
        if (this.dispatchPauseSources.remove(source)) {
            Iterator<T> it = this.lanes.values().iterator();
            while (it.hasNext()) {
                ((PoolLane) it.next()).getWakeup().mo149trySendJP2dKIU(n.f10413a);
            }
            Log.i(TAG, "resume NORMAL/BG dispatch: source=" + source + " remaining=" + this.dispatchPauseSources);
        }
    }

    @Override // t6.b
    public void shutdown() {
        if (this.shutdown.compareAndSet(false, true)) {
            Collection<Job> collectionValues = this.taskJobs.values();
            g.e(collectionValues, "<get-values>(...)");
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                Job.DefaultImpls.cancel$default((Job) it.next(), null, 1, null);
            }
            this.taskJobs.clear();
            CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
            Iterator<T> it2 = this.lanes.values().iterator();
            while (it2.hasNext()) {
                SendChannel.DefaultImpls.close$default(((PoolLane) it2.next()).getChannel(), null, 1, null);
            }
        }
    }

    public void shutdownNow() {
        shutdown();
    }

    public void submit(j7.b task, TaskPriority priority, r6.a decision) {
        String modelId;
        g.f(task, "task");
        g.f(priority, "priority");
        g.f(decision, "decision");
        if (this.shutdown.get()) {
            a0.a.A("shutdown, reject task=", task.getId(), TAG);
            return;
        }
        PoolType.f6214b.getClass();
        PoolLane poolLane = (PoolLane) kotlin.collections.b.e0(PoolType.a.a(priority), this.lanes);
        AITaskRecord aITaskRecord = task instanceof AITaskRecord ? (AITaskRecord) task : null;
        String id2 = task.getId();
        int callerUid = aITaskRecord != null ? aITaskRecord.getCallerUid() : 0;
        if (aITaskRecord == null || (modelId = aITaskRecord.getModelId()) == null) {
            modelId = "";
        }
        enqueueOrReject(poolLane, new Work(id2, callerUid, modelId, SystemClock.elapsedRealtime(), new ThreadPoolManagerImpl$submit$work$1(task, this, decision, null)));
    }

    @Override // t6.b
    public Flow<Result<Object>> submitFlow(String taskId, TaskPriority priority, r6.a decision, l<? super qb.b<? super Flow<? extends Result<? extends Object>>>, ? extends Object> block) {
        g.f(taskId, "taskId");
        g.f(priority, "priority");
        g.f(decision, "decision");
        g.f(block, "block");
        return submitFlow(taskId, priority, decision, 0, block);
    }

    public ThreadPoolManagerImpl(t6.a aVar) {
        latestInstance = this;
        this.shutdown = new AtomicBoolean(false);
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.taskJobs = new ConcurrentHashMap<>();
        PoolType[] poolTypeArrValues = PoolType.values();
        int iA0 = v.a0(poolTypeArrValues.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA0 < 16 ? 16 : iA0);
        for (PoolType poolType : poolTypeArrValues) {
            linkedHashMap.put(poolType, new PoolLane(poolType));
        }
        this.lanes = linkedHashMap;
        this.recentForegroundMonoMs = new ConcurrentHashMap<>();
        this.dispatchPauseSources = ConcurrentHashMap.newKeySet();
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            launchConsumer((PoolLane) it.next());
        }
    }

    public final Flow<Result<Object>> submitFlow(String taskId, TaskPriority priority, r6.a decision, int i10, l<? super qb.b<? super Flow<? extends Result<? extends Object>>>, ? extends Object> block) {
        g.f(taskId, "taskId");
        g.f(priority, "priority");
        g.f(decision, "decision");
        g.f(block, "block");
        if (this.shutdown.get()) {
            return FlowKt.channelFlow(new C03751(null));
        }
        PoolType.f6214b.getClass();
        return FlowKt.channelFlow(new C03762(taskId, i10, this, (PoolLane) kotlin.collections.b.e0(PoolType.a.a(priority), this.lanes), block, null));
    }

    public /* synthetic */ ThreadPoolManagerImpl(t6.a aVar, int i10, e eVar) {
        this((i10 & 1) != 0 ? null : aVar);
    }
}
