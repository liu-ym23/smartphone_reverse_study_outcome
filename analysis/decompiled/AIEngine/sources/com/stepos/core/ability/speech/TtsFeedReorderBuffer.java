package com.stepos.core.ability.speech;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsFeedReorderBuffer {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "TtsFeedReorder";
    private boolean completed;
    private final Object deliverLock;
    private boolean finished;
    private final String inferId;
    private final Object lock;
    private int nextSeq;
    private final zb.l<String, lb.n> onFeed;
    private final zb.a<lb.n> onFinish;
    private final TreeMap<Integer, String> pending;
    private final CoroutineScope scope;
    private final long timeoutMs;
    private Job timerJob;
    private int total;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsFeedReorderBuffer$armTimerLocked$1", f = "TtsFeedReorderBuffer.kt", l = {170}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsFeedReorderBuffer$armTimerLocked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        int label;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return TtsFeedReorderBuffer.this.new AnonymousClass1(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                long j10 = TtsFeedReorderBuffer.this.timeoutMs;
                this.label = 1;
                if (DelayKt.delay(j10, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            TtsFeedReorderBuffer.this.onStallTimeout();
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TtsFeedReorderBuffer(CoroutineScope scope, String inferId, long j10, zb.l<? super String, lb.n> onFeed, zb.a<lb.n> onFinish) {
        kotlin.jvm.internal.g.f(scope, "scope");
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(onFeed, "onFeed");
        kotlin.jvm.internal.g.f(onFinish, "onFinish");
        this.scope = scope;
        this.inferId = inferId;
        this.timeoutMs = j10;
        this.onFeed = onFeed;
        this.onFinish = onFinish;
        this.lock = new Object();
        this.deliverLock = new Object();
        this.pending = new TreeMap<>();
        this.total = -1;
    }

    private final void armTimerLocked() {
        Job job = this.timerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.timerJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(null), 3, null);
    }

    private final void cancelTimerLocked() {
        Job job = this.timerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.timerJob = null;
    }

    private final void drainContiguousLocked(List<String> list) {
        while (true) {
            String strRemove = this.pending.remove(Integer.valueOf(this.nextSeq));
            if (strRemove == null) {
                return;
            }
            list.add(strRemove);
            this.nextSeq++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void evaluate() {
        int i10;
        synchronized (this.deliverLock) {
            ArrayList arrayList = new ArrayList();
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            synchronized (this.lock) {
                try {
                    if (this.finished) {
                        return;
                    }
                    drainContiguousLocked(arrayList);
                    boolean zIsEmpty = this.pending.isEmpty();
                    boolean z = this.completed;
                    if (z && zIsEmpty && (i10 = this.total) >= 0 && this.nextSeq >= i10) {
                        this.finished = true;
                        ref$BooleanRef.f10073a = true;
                        cancelTimerLocked();
                    } else if (z || !zIsEmpty) {
                        armTimerLocked();
                    } else {
                        cancelTimerLocked();
                    }
                    lb.n nVar = lb.n.f10413a;
                    zb.l<String, lb.n> lVar = this.onFeed;
                    int size = arrayList.size();
                    int i11 = 0;
                    while (i11 < size) {
                        Object obj = arrayList.get(i11);
                        i11++;
                        lVar.invoke(obj);
                    }
                    if (ref$BooleanRef.f10073a) {
                        this.onFinish.invoke();
                    }
                    lb.n nVar2 = lb.n.f10413a;
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void onStallTimeout() {
        synchronized (this.deliverLock) {
            ArrayList arrayList = new ArrayList();
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            synchronized (this.lock) {
                try {
                    if (this.finished) {
                        return;
                    }
                    this.timerJob = null;
                    if (!this.pending.isEmpty() && !this.pending.containsKey(Integer.valueOf(this.nextSeq))) {
                        Integer numFirstKey = this.pending.firstKey();
                        AIEngineLogger.w(LogModule.ABILITY, TAG, "reorder gap timeout: skip nextSeq " + this.nextSeq + " -> " + numFirstKey + " (missing frames) inferId=" + this.inferId);
                        this.nextSeq = numFirstKey.intValue();
                    }
                    drainContiguousLocked(arrayList);
                    if (this.completed) {
                        if (!this.pending.isEmpty()) {
                            AIEngineLogger.w(LogModule.ABILITY, TAG, "reorder finalize flush " + this.pending.size() + " buffered chunk(s) with gaps inferId=" + this.inferId);
                            arrayList.addAll(this.pending.values());
                            this.pending.clear();
                        }
                        this.finished = true;
                        ref$BooleanRef.f10073a = true;
                    } else if (!this.pending.isEmpty()) {
                        armTimerLocked();
                    }
                    lb.n nVar = lb.n.f10413a;
                    zb.l<String, lb.n> lVar = this.onFeed;
                    int size = arrayList.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        i10++;
                        lVar.invoke(obj);
                    }
                    if (ref$BooleanRef.f10073a) {
                        this.onFinish.invoke();
                    }
                    lb.n nVar2 = lb.n.f10413a;
                } finally {
                }
            }
        }
    }

    public final void dispose() {
        synchronized (this.lock) {
            try {
                this.finished = true;
                Job job = this.timerJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, null, 1, null);
                }
                this.timerJob = null;
                this.pending.clear();
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void markCompleted() {
        synchronized (this.lock) {
            if (this.finished) {
                return;
            }
            this.completed = true;
            lb.n nVar = lb.n.f10413a;
            evaluate();
        }
    }

    public final void markTotal(int i10) {
        synchronized (this.lock) {
            try {
                if (this.finished) {
                    return;
                }
                if (i10 >= 0) {
                    this.total = i10;
                }
                lb.n nVar = lb.n.f10413a;
                evaluate();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void offer(int i10, String text) {
        kotlin.jvm.internal.g.f(text, "text");
        if (text.length() == 0) {
            return;
        }
        synchronized (this.lock) {
            if (this.finished) {
                return;
            }
            int i11 = this.nextSeq;
            if (i10 < i11) {
                AIEngineLogger.w(LogModule.ABILITY, TAG, "reorder drop late/dup seq=" + i10 + " (nextSeq=" + i11 + ") inferId=" + this.inferId);
                return;
            }
            if (!this.pending.containsKey(Integer.valueOf(i10))) {
                this.pending.put(Integer.valueOf(i10), text);
                lb.n nVar = lb.n.f10413a;
                evaluate();
                return;
            }
            AIEngineLogger.w(LogModule.ABILITY, TAG, "reorder drop dup seq=" + i10 + " inferId=" + this.inferId);
        }
    }
}
