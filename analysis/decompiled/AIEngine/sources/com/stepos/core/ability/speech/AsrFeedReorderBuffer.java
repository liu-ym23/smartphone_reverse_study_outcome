package com.stepos.core.ability.speech;

import android.os.SystemClock;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.util.AsrSseStreamParamKeys;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrFeedReorderBuffer {
    public static final Companion Companion = new Companion(null);
    public static final long GAP_TIMEOUT_MS = 120;
    public static final long MAX_PENDING_BYTES = 32768;
    public static final int MAX_PENDING_FRAMES = 16;
    private static final String TAG = "AsrFeedReorder";
    public static final long TAIL_HARD_LIMIT_MS = 1000;
    public static final long TAIL_TIMEOUT_MS = 200;
    private static final String TIMER_GAP = "gap";
    private static final String TIMER_TAIL = "tail";
    private boolean completed;
    private long completedAtNs;
    private final Object deliverLock;
    private long deliveredFrames;
    private boolean finished;
    private long gapSinceNs;
    private final long gapTimeoutMs;
    private Job hardLimitJob;
    private final String inferId;
    private final Object lock;
    private int lostFrames;
    private final long maxPendingBytes;
    private final int maxPendingFrames;
    private int nextSeq;
    private final zb.l<AudioContent, lb.n> onFeed;
    private final zb.a<lb.n> onFinish;
    private final mb.k<AudioContent> passthrough;
    private final TreeMap<Integer, AudioContent> pending;
    private long pendingBytes;
    private int replayedUpTo;
    private final CoroutineScope scope;
    private final long tailHardLimitMs;
    private final long tailTimeoutMs;
    private Job timerJob;
    private String timerKind;
    private int total;
    private final Channel<lb.n> wake;
    private final Job worker;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrFeedReorderBuffer$armHardLimitLocked$1", f = "AsrFeedReorderBuffer.kt", l = {453}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrFeedReorderBuffer$armHardLimitLocked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        int label;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return AsrFeedReorderBuffer.this.new AnonymousClass1(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                long j10 = AsrFeedReorderBuffer.this.tailHardLimitMs;
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
            AsrFeedReorderBuffer.this.onTailHardLimit();
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrFeedReorderBuffer$armTimerLocked$1", f = "AsrFeedReorderBuffer.kt", l = {527}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrFeedReorderBuffer$armTimerLocked$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03091 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ long $delayMs;
        int label;
        final /* synthetic */ AsrFeedReorderBuffer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03091(long j10, AsrFeedReorderBuffer asrFeedReorderBuffer, qb.b<? super C03091> bVar) {
            super(2, bVar);
            this.$delayMs = j10;
            this.this$0 = asrFeedReorderBuffer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return new C03091(this.$delayMs, this.this$0, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                long j10 = this.$delayMs;
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
            this.this$0.onStallTimeout();
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((C03091) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AsrFeedReorderBuffer(CoroutineScope scope, String inferId, long j10, long j11, long j12, int i10, long j13, zb.l<? super AudioContent, lb.n> onFeed, zb.a<lb.n> onFinish) {
        kotlin.jvm.internal.g.f(scope, "scope");
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(onFeed, "onFeed");
        kotlin.jvm.internal.g.f(onFinish, "onFinish");
        this.scope = scope;
        this.inferId = inferId;
        this.gapTimeoutMs = j10;
        this.tailTimeoutMs = j11;
        this.tailHardLimitMs = j12;
        this.maxPendingFrames = i10;
        this.maxPendingBytes = j13;
        this.onFeed = onFeed;
        this.onFinish = onFinish;
        this.lock = new Object();
        this.deliverLock = new Object();
        this.pending = new TreeMap<>();
        this.total = -1;
        this.passthrough = new mb.k<>();
        this.timerKind = "";
        this.replayedUpTo = -1;
        this.wake = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.worker = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AsrFeedReorderBuffer$worker$1(this, null), 3, null);
    }

    private final void armHardLimitLocked() {
        if (this.hardLimitJob != null) {
            return;
        }
        this.hardLimitJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(null), 3, null);
    }

    private final void armTimerLocked(long j10, String str, boolean z) {
        if (z || this.timerJob == null || !kotlin.jvm.internal.g.b(this.timerKind, str)) {
            Job job = this.timerJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, null, 1, null);
            }
            this.timerKind = str;
            this.timerJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C03091(j10, this, null), 3, null);
        }
    }

    public static /* synthetic */ void armTimerLocked$default(AsrFeedReorderBuffer asrFeedReorderBuffer, long j10, String str, boolean z, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z = false;
        }
        asrFeedReorderBuffer.armTimerLocked(j10, str, z);
    }

    private final void cancelAllTimersLocked() {
        cancelTimerLocked();
        Job job = this.hardLimitJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.hardLimitJob = null;
    }

    private final void cancelTimerLocked() {
        Job job = this.timerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.timerJob = null;
        this.timerKind = "";
    }

    private final int countInnerGapsLocked() {
        if (this.pending.size() < 2) {
            return 0;
        }
        int iIntValue = this.pending.lastKey().intValue();
        Integer numFirstKey = this.pending.firstKey();
        kotlin.jvm.internal.g.e(numFirstKey, "firstKey(...)");
        return ((iIntValue - numFirstKey.intValue()) + 1) - this.pending.size();
    }

    private final void deliverAll(List<AudioContent> list) {
        Object objA;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            try {
                this.onFeed.invoke((AudioContent) it.next());
                objA = lb.n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                synchronized (this.lock) {
                    this.lostFrames++;
                }
                a0.a.x(ai.onnxruntime.a.s("reorder onFeed failed, dropping 1 frame (", thB.getClass().getSimpleName(), ": ", thB.getMessage(), ") inferId="), this.inferId, LogModule.ABILITY, TAG);
            }
        }
    }

    private final void drainContiguousLocked(List<AudioContent> list) {
        while (true) {
            AudioContent audioContentRemove = this.pending.remove(Integer.valueOf(this.nextSeq));
            if (audioContentRemove == null) {
                return;
            }
            this.pendingBytes -= audioContentRemove.getAudioBytes().length;
            list.add(audioContentRemove);
            this.nextSeq++;
            this.deliveredFrames++;
        }
    }

    private final int drainPassthroughLocked(List<AudioContent> list) {
        int iA = this.passthrough.a();
        while (!this.passthrough.isEmpty()) {
            list.add(this.passthrough.removeFirst());
        }
        return iA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cd A[Catch: all -> 0x0019, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0005, B:5:0x0011, B:8:0x0016, B:48:0x00c5, B:49:0x00c6, B:51:0x00cd, B:54:0x00d7, B:55:0x00d8, B:6:0x0012, B:13:0x001d, B:15:0x002b, B:21:0x005c, B:25:0x0069, B:27:0x0073, B:29:0x0081, B:31:0x0087, B:33:0x0090, B:36:0x0096, B:38:0x009a, B:40:0x009e, B:47:0x00c3, B:43:0x00a9, B:45:0x00b3, B:46:0x00bf, B:32:0x008e, B:20:0x0038), top: B:60:0x0005, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void evaluate() {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFeedReorderBuffer.evaluate():void");
    }

    private final void flushRemainingAndFinishLocked(List<AudioContent> list) {
        if (!this.pending.isEmpty()) {
            this.lostFrames += countInnerGapsLocked();
            AIEngineLogger.w(LogModule.ABILITY, TAG, a0.a.g("reorder finalize flush ", this.pending.size(), " buffered frame(s) with gaps inferId=", this.inferId));
            Collection<AudioContent> collectionValues = this.pending.values();
            kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
            list.addAll(collectionValues);
            this.deliveredFrames += this.pending.size();
            this.nextSeq = this.pending.lastKey().intValue() + 1;
            this.pending.clear();
            this.pendingBytes = 0L;
        }
        int i10 = this.total;
        int i11 = this.nextSeq;
        if (i10 > i11) {
            this.lostFrames = (i10 - i11) + this.lostFrames;
            LogModule logModule = LogModule.ABILITY;
            String str = this.inferId;
            StringBuilder sbD = h0.e.d(i10 - i11, "reorder tail loss: ", i11, " trailing frame(s) never arrived (nextSeq=", " total=");
            sbD.append(i10);
            sbD.append(") inferId=");
            sbD.append(str);
            AIEngineLogger.w(logModule, TAG, sbD.toString());
            this.nextSeq = this.total;
        }
        this.finished = true;
        this.gapSinceNs = 0L;
        Job job = this.hardLimitJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.hardLimitJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0072 A[Catch: all -> 0x0019, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0005, B:5:0x0011, B:8:0x0016, B:28:0x006a, B:29:0x006b, B:31:0x0072, B:34:0x007c, B:35:0x007d, B:6:0x0012, B:14:0x001d, B:16:0x002a, B:20:0x0032, B:22:0x004d, B:27:0x0068, B:24:0x0055, B:26:0x005d, B:19:0x0030), top: B:38:0x0005, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onStallTimeout() {
        /*
            r12 = this;
            java.lang.String r0 = "timeout("
            java.lang.Object r1 = r12.deliverLock
            monitor-enter(r1)
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L19
            r2.<init>()     // Catch: java.lang.Throwable -> L19
            kotlin.jvm.internal.Ref$BooleanRef r3 = new kotlin.jvm.internal.Ref$BooleanRef     // Catch: java.lang.Throwable -> L19
            r3.<init>()     // Catch: java.lang.Throwable -> L19
            java.lang.Object r4 = r12.lock     // Catch: java.lang.Throwable -> L19
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L19
            boolean r5 = r12.finished     // Catch: java.lang.Throwable -> L2d
            if (r5 == 0) goto L1c
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L19
            monitor-exit(r1)
            return
        L19:
            r0 = move-exception
            r12 = r0
            goto L7e
        L1c:
            r5 = 0
            r12.timerJob = r5     // Catch: java.lang.Throwable -> L2d
            java.lang.String r5 = ""
            r12.timerKind = r5     // Catch: java.lang.Throwable -> L2d
            r12.drainPassthroughLocked(r2)     // Catch: java.lang.Throwable -> L2d
            boolean r5 = r12.completed     // Catch: java.lang.Throwable -> L2d
            if (r5 == 0) goto L30
            long r5 = r12.tailTimeoutMs     // Catch: java.lang.Throwable -> L2d
            goto L32
        L2d:
            r0 = move-exception
            r12 = r0
            goto L7c
        L30:
            long r5 = r12.gapTimeoutMs     // Catch: java.lang.Throwable -> L2d
        L32:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2d
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L2d
            r7.append(r5)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r0 = "ms)"
            r7.append(r0)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r0 = r7.toString()     // Catch: java.lang.Throwable -> L2d
            r12.skipGapLocked(r0)     // Catch: java.lang.Throwable -> L2d
            r12.drainContiguousLocked(r2)     // Catch: java.lang.Throwable -> L2d
            boolean r0 = r12.completed     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L55
            r12.flushRemainingAndFinishLocked(r2)     // Catch: java.lang.Throwable -> L2d
            r0 = 1
            r3.f10073a = r0     // Catch: java.lang.Throwable -> L2d
        L53:
            r5 = r12
            goto L68
        L55:
            java.util.TreeMap<java.lang.Integer, com.stepos.core.data.AudioContent> r0 = r12.pending     // Catch: java.lang.Throwable -> L2d
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L2d
            if (r0 != 0) goto L53
            long r6 = r12.gapTimeoutMs     // Catch: java.lang.Throwable -> L2d
            java.lang.String r8 = "gap"
            r10 = 4
            r11 = 0
            r9 = 0
            r5 = r12
            armTimerLocked$default(r5, r6, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L2d
        L68:
            lb.n r12 = lb.n.f10413a     // Catch: java.lang.Throwable -> L2d
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L19
            r5.deliverAll(r2)     // Catch: java.lang.Throwable -> L19
            boolean r12 = r3.f10073a     // Catch: java.lang.Throwable -> L19
            if (r12 == 0) goto L7a
            zb.a<lb.n> r12 = r5.onFinish     // Catch: java.lang.Throwable -> L19
            r12.invoke()     // Catch: java.lang.Throwable -> L19
            r5.stopWorker()     // Catch: java.lang.Throwable -> L19
        L7a:
            monitor-exit(r1)
            return
        L7c:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L19
            throw r12     // Catch: java.lang.Throwable -> L19
        L7e:
            monitor-exit(r1)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFeedReorderBuffer.onStallTimeout():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTailHardLimit() {
        synchronized (this.deliverLock) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.lock) {
                if (this.finished) {
                    return;
                }
                this.hardLimitJob = null;
                long jElapsedRealtimeNanos = this.completedAtNs == 0 ? -1L : (SystemClock.elapsedRealtimeNanos() - this.completedAtNs) / 1000000;
                AIEngineLogger.w(LogModule.ABILITY, TAG, "reorder tail hard limit " + this.tailHardLimitMs + "ms reached (waited=" + jElapsedRealtimeNanos + "ms, nextSeq=" + this.nextSeq + " total=" + this.total + " pending=" + this.pending.size() + "), finalizing inferId=" + this.inferId);
                cancelTimerLocked();
                drainPassthroughLocked(arrayList);
                drainContiguousLocked(arrayList);
                flushRemainingAndFinishLocked(arrayList);
                lb.n nVar = lb.n.f10413a;
                deliverAll(arrayList);
                this.onFinish.invoke();
                stopWorker();
            }
        }
    }

    private final void skipGapLocked(String str) {
        if (this.pending.isEmpty() || this.pending.containsKey(Integer.valueOf(this.nextSeq))) {
            return;
        }
        Integer numFirstKey = this.pending.firstKey();
        int iIntValue = numFirstKey.intValue() - this.nextSeq;
        this.lostFrames += iIntValue;
        long jElapsedRealtimeNanos = this.gapSinceNs == 0 ? 0L : (SystemClock.elapsedRealtimeNanos() - this.gapSinceNs) / 1000000;
        LogModule logModule = LogModule.ABILITY;
        int i10 = this.nextSeq;
        int iIntValue2 = numFirstKey.intValue() - 1;
        int size = this.pending.size();
        int i11 = this.lostFrames;
        String str2 = this.inferId;
        StringBuilder sbF = h0.e.f("reorder gap ", str, ": skip seq ", i10, "..");
        h0.e.l(sbF, iIntValue2, " (", iIntValue, " frame(s) never arrived), heldMs=");
        sbF.append(jElapsedRealtimeNanos);
        sbF.append(" pending=");
        sbF.append(size);
        sbF.append(" lostTotal=");
        sbF.append(i11);
        sbF.append(" inferId=");
        sbF.append(str2);
        AIEngineLogger.w(logModule, TAG, sbF.toString());
        this.nextSeq = numFirstKey.intValue();
        this.gapSinceNs = 0L;
    }

    private final void stopWorker() {
        SendChannel.DefaultImpls.close$default(this.wake, null, 1, null);
        Job.DefaultImpls.cancel$default(this.worker, null, 1, null);
    }

    public final void advancePast(int i10) {
        if (i10 < 0) {
            return;
        }
        synchronized (this.lock) {
            try {
                if (!this.finished && i10 >= this.nextSeq) {
                    this.nextSeq = i10 + 1;
                    this.replayedUpTo = i10;
                    int i11 = 0;
                    int iIntValue = -1;
                    while (!this.pending.isEmpty() && this.pending.firstKey().intValue() < this.nextSeq) {
                        if (iIntValue < 0) {
                            iIntValue = this.pending.firstKey().intValue();
                        }
                        kotlin.jvm.internal.g.c(this.pending.pollFirstEntry());
                        this.pendingBytes -= r3.getValue().getAudioBytes().length;
                        i11++;
                    }
                    this.lostFrames += i11;
                    this.gapSinceNs = 0L;
                    lb.n nVar = lb.n.f10413a;
                    if (i11 > 0) {
                        LogModule logModule = LogModule.ABILITY;
                        int iLostFrameCount = lostFrameCount();
                        String str = this.inferId;
                        StringBuilder sbD = h0.e.d(i10, "reorder advancePast ", i11, ": drop ", " buffered frame(s) from seq=");
                        h0.e.l(sbD, iIntValue, " (replayed range already sent out-of-band), lostTotal=", iLostFrameCount, " inferId=");
                        a0.a.x(sbD, str, logModule, TAG);
                    }
                    this.wake.mo149trySendJP2dKIU(lb.n.f10413a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void dispose() {
        int i10;
        int size;
        long j10;
        synchronized (this.lock) {
            this.finished = true;
            cancelAllTimersLocked();
            i10 = this.lostFrames;
            size = this.pending.size();
            j10 = this.deliveredFrames;
            this.pending.clear();
            this.pendingBytes = 0L;
            this.passthrough.clear();
            lb.n nVar = lb.n.f10413a;
        }
        stopWorker();
        if (i10 > 0 || size > 0) {
            LogModule logModule = LogModule.ABILITY;
            String str = this.inferId;
            StringBuilder sbR = ai.onnxruntime.a.r(j10, "reorder dispose: delivered=", " lostFrames=", i10);
            sbR.append(" abandoned=");
            sbR.append(size);
            sbR.append(" inferId=");
            sbR.append(str);
            AIEngineLogger.w(logModule, TAG, sbR.toString());
        }
    }

    public final int lostFrameCount() {
        int i10;
        synchronized (this.lock) {
            i10 = this.lostFrames;
        }
        return i10;
    }

    public final void markCompleted() {
        synchronized (this.lock) {
            try {
                if (this.finished) {
                    return;
                }
                this.completed = true;
                if (this.completedAtNs == 0) {
                    this.completedAtNs = SystemClock.elapsedRealtimeNanos();
                }
                armHardLimitLocked();
                lb.n nVar = lb.n.f10413a;
                this.wake.mo149trySendJP2dKIU(lb.n.f10413a);
            } catch (Throwable th) {
                throw th;
            }
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
                this.wake.mo149trySendJP2dKIU(lb.n.f10413a);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void offer(int i10, AudioContent frame) {
        ContentParams params;
        kotlin.jvm.internal.g.f(frame, "frame");
        if (frame.getAudioBytes().length != 0 || ((params = frame.getParams()) != null && params.getBoolean(AsrSseStreamParamKeys.VAD_GATE, false))) {
            if (i10 < 0) {
                ai.onnxruntime.a.w("reorder passthrough: frame without seq, inferId=", this.inferId, LogModule.ABILITY, TAG);
                synchronized (this.lock) {
                    if (this.finished) {
                        return;
                    }
                    this.passthrough.addLast(frame);
                    lb.n nVar = lb.n.f10413a;
                    this.wake.mo149trySendJP2dKIU(lb.n.f10413a);
                    return;
                }
            }
            synchronized (this.lock) {
                try {
                    if (this.finished) {
                        return;
                    }
                    int i11 = this.nextSeq;
                    if (i10 >= i11) {
                        if (!this.pending.containsKey(Integer.valueOf(i10))) {
                            this.pending.put(Integer.valueOf(i10), frame);
                            this.pendingBytes += frame.getAudioBytes().length;
                            lb.n nVar2 = lb.n.f10413a;
                            this.wake.mo149trySendJP2dKIU(lb.n.f10413a);
                            return;
                        }
                        AIEngineLogger.w(LogModule.ABILITY, TAG, "reorder drop duplicate seq=" + i10 + " (still buffered) inferId=" + this.inferId);
                        return;
                    }
                    boolean z = i10 <= this.replayedUpTo;
                    if (z) {
                        this.lostFrames++;
                    }
                    String str = z ? "dropped-in-replayed-range" : this.lostFrames > 0 ? "late-after-gap-skip" : "duplicate";
                    AIEngineLogger.w(LogModule.ABILITY, TAG, "reorder drop " + str + " seq=" + i10 + " (nextSeq=" + i11 + ", lostSoFar=" + this.lostFrames + ") inferId=" + this.inferId);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final <T> T withDeliverySuspended(zb.a<? extends T> block) {
        T tInvoke;
        kotlin.jvm.internal.g.f(block, "block");
        synchronized (this.deliverLock) {
            tInvoke = block.invoke();
        }
        return tInvoke;
    }
}
