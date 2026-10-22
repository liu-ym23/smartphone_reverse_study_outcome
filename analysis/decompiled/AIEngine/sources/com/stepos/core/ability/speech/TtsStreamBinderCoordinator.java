package com.stepos.core.ability.speech;

import com.stepos.core.ability.handler.BinderResultHandler;
import com.stepos.core.ability.handler.InferResult;
import com.stepos.core.ability.speech.TtsPcmDownlinkBatcher;
import com.stepos.core.ability.speech.TtsStreamBinderCoordinator;
import com.stepos.core.ability.speech.TtsStreamingBuffer;
import com.stepos.core.ability.telemetry.ModelCallBridge;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.common.cloud.CloudConfigBootstrap;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import com.stepos.core.common.cloud.CloudTransport;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.telemetry.ModelCallOutcome;
import com.stepos.core.common.util.TraceIdExtractorKt;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.task.AITaskRecord;
import com.stepos.core.ota.crypto.FekEnvelope;
import h7.e;
import i7.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsStreamBinderCoordinator {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_SILENCE_CHUNK_BYTES = 131072;
    public static final String MSG_LOCAL_NOT_READY = "语音合成暂不可用，请稍后重试";
    private static final long REORDER_TIMEOUT_MS = 800;
    private final String TAG;
    private final Host host;
    private final ConcurrentHashMap<String, TtsFeedReorderBuffer> reorderBuffers;
    private final TtsStreamAbility ttsAbility;
    private final ConcurrentHashMap<String, TtsCloudHolder> ttsCloudWsSessions;
    private final ConcurrentHashMap<String, Job> ttsOpenWatchdogs;
    private final ConcurrentHashMap.KeySetView<String, Boolean> ttsPendingFinish;
    private final TtsStreamingBuffer ttsStreamingBuffer;
    private final ConcurrentHashMap.KeySetView<String, Boolean> ttsStreamingInferIds;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final int computeTailSilenceBytes$ability_release(long j10, int i10, int i11, long j11) {
            if (j11 <= 0 || j10 <= 0 || i10 <= 0) {
                return 0;
            }
            if (i11 < 1) {
                i11 = 1;
            }
            long j12 = ((((i10 * i11) * 2) * j11) / 1000) - j10;
            if (j12 <= 0) {
                return 0;
            }
            long j13 = j12 - (j12 % (i11 * 2));
            if (j13 <= 0) {
                return 0;
            }
            return (int) j13;
        }

        public final List<Integer> planTailSilenceChunks$ability_release(long j10, int i10, int i11, long j11) {
            int iComputeTailSilenceBytes$ability_release = computeTailSilenceBytes$ability_release(j10, i10, i11, j11);
            if (iComputeTailSilenceBytes$ability_release <= 0) {
                return EmptyList.f10001a;
            }
            if (i11 < 1) {
                i11 = 1;
            }
            int i12 = i11 * 2;
            int i13 = TtsStreamBinderCoordinator.MAX_SILENCE_CHUNK_BYTES - (TtsStreamBinderCoordinator.MAX_SILENCE_CHUNK_BYTES % i12);
            if (i13 >= i12) {
                i12 = i13;
            }
            ArrayList arrayList = new ArrayList();
            while (iComputeTailSilenceBytes$ability_release > 0) {
                int iMin = Math.min(iComputeTailSilenceBytes$ability_release, i12);
                arrayList.add(Integer.valueOf(iMin));
                iComputeTailSilenceBytes$ability_release -= iMin;
            }
            return arrayList;
        }

        public final boolean shouldPadTailSilence$ability_release(InferResult result) {
            kotlin.jvm.internal.g.f(result, "result");
            return result instanceof InferResult.Complete;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface Host {
        void decLocalStreamCountIfCounted(String str);

        void endAicScene(String str);

        CoroutineScope getAbilityScope();

        String getToken();

        void incLocalStreamCount(String str);

        void markActive();

        void putInferJob(String str, Job job);

        void removeInferJob(String str);

        void scheduleIdleTransition();

        void startAicScene(String str, boolean z);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TtsStreamingBuffer.FeedResult.values().length];
            try {
                iArr[TtsStreamingBuffer.FeedResult.Forward.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TtsStreamingBuffer.FeedResult.Stashed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TtsStreamingBuffer.FeedResult.NotStreaming.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsStreamBinderCoordinator", f = "TtsStreamBinderCoordinator.kt", l = {447}, m = "collectTtsCloudWsEvents")
    /* renamed from: com.stepos.core.ability.speech.TtsStreamBinderCoordinator$collectTtsCloudWsEvents$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TtsStreamBinderCoordinator.this.collectTtsCloudWsEvents(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.core.ability.speech.TtsStreamBinderCoordinator$collectTtsCloudWsEvents$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ TtsCloudHolder $holder;
        final /* synthetic */ String $inferId;

        public AnonymousClass2(String str, TtsCloudHolder ttsCloudHolder) {
            this.$inferId = str;
            this.$holder = ttsCloudHolder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n emit$lambda$0(TtsStreamBinderCoordinator ttsStreamBinderCoordinator, TtsCloudHolder ttsCloudHolder, String str) {
            ttsStreamBinderCoordinator.ensureOpened(ttsCloudHolder, str);
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n emit$lambda$1(TtsStreamBinderCoordinator ttsStreamBinderCoordinator, TtsCloudHolder ttsCloudHolder, String str) {
            ttsStreamBinderCoordinator.ensureInputClosed(ttsCloudHolder, str);
            return lb.n.f10413a;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, qb.b bVar) {
            return emit((i7.d) obj, (qb.b<? super lb.n>) bVar);
        }

        public final Object emit(i7.d dVar, qb.b<? super lb.n> bVar) {
            if (kotlin.jvm.internal.g.b(dVar, d.e.f9575a)) {
                TtsStreamBinderCoordinator.this.cancelTtsOpenWatchdog(this.$inferId);
                TtsStreamCallbackQueue callbackQueue = this.$holder.getCallbackQueue();
                final TtsStreamBinderCoordinator ttsStreamBinderCoordinator = TtsStreamBinderCoordinator.this;
                final TtsCloudHolder ttsCloudHolder = this.$holder;
                final String str = this.$inferId;
                callbackQueue.enqueue(new zb.a() { // from class: com.stepos.core.ability.speech.i0
                    @Override // zb.a
                    public final Object invoke() {
                        return TtsStreamBinderCoordinator.AnonymousClass2.emit$lambda$0(ttsStreamBinderCoordinator, ttsCloudHolder, str);
                    }
                });
            } else if (dVar instanceof d.b) {
                TtsStreamBinderCoordinator.this.handleCloudAudioDelta(this.$inferId, this.$holder, (d.b) dVar);
            } else if (kotlin.jvm.internal.g.b(dVar, d.C0092d.f9574a)) {
                TtsStreamCallbackQueue callbackQueue2 = this.$holder.getCallbackQueue();
                final TtsStreamBinderCoordinator ttsStreamBinderCoordinator2 = TtsStreamBinderCoordinator.this;
                final TtsCloudHolder ttsCloudHolder2 = this.$holder;
                final String str2 = this.$inferId;
                callbackQueue2.enqueue(new zb.a() { // from class: com.stepos.core.ability.speech.j0
                    @Override // zb.a
                    public final Object invoke() {
                        return TtsStreamBinderCoordinator.AnonymousClass2.emit$lambda$1(ttsStreamBinderCoordinator2, ttsCloudHolder2, str2);
                    }
                });
            } else if (dVar instanceof d.a) {
                TtsStreamBinderCoordinator.this.scheduleCloudTerminal(this.$holder, this.$inferId, InferResult.Complete.INSTANCE, ((d.a) dVar).f9569a);
                JobKt__JobKt.cancel$default(bVar.getContext(), null, 1, null);
            } else {
                if (!(dVar instanceof d.c)) {
                    throw new NoWhenBranchMatchedException();
                }
                d.c cVar = (d.c) dVar;
                TtsStreamBinderCoordinator.scheduleCloudTerminal$default(TtsStreamBinderCoordinator.this, this.$holder, this.$inferId, new InferResult.Error(cVar.f9572a, cVar.f9573b), false, 8, null);
                JobKt__JobKt.cancel$default(bVar.getContext(), null, 1, null);
            }
            return lb.n.f10413a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsStreamBinderCoordinator", f = "TtsStreamBinderCoordinator.kt", l = {291, 324}, m = "openTtsStreamingSession")
    /* renamed from: com.stepos.core.ability.speech.TtsStreamBinderCoordinator$openTtsStreamingSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03561 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C03561(qb.b<? super C03561> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TtsStreamBinderCoordinator.this.openTtsStreamingSession(null, null, 0, null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsStreamBinderCoordinator$scheduleOrCancelPcmFlush$1", f = "TtsStreamBinderCoordinator.kt", l = {517}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsStreamBinderCoordinator$scheduleOrCancelPcmFlush$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03571 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ TtsCloudHolder $holder;
        final /* synthetic */ String $inferId;
        int label;
        final /* synthetic */ TtsStreamBinderCoordinator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03571(TtsCloudHolder ttsCloudHolder, TtsStreamBinderCoordinator ttsStreamBinderCoordinator, String str, qb.b<? super C03571> bVar) {
            super(2, bVar);
            this.$holder = ttsCloudHolder;
            this.this$0 = ttsStreamBinderCoordinator;
            this.$inferId = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$0(TtsStreamBinderCoordinator ttsStreamBinderCoordinator, TtsCloudHolder ttsCloudHolder, String str, TtsPcmDownlinkBatcher.PcmBatch pcmBatch) {
            ttsStreamBinderCoordinator.ensureOpened(ttsCloudHolder, str);
            ttsStreamBinderCoordinator.dispatchPcmBatch(ttsCloudHolder, str, pcmBatch);
            return lb.n.f10413a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return new C03571(this.$holder, this.this$0, this.$inferId, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                long pcmBatchMaxWaitMs = this.$holder.getPcmBatchMaxWaitMs();
                this.label = 1;
                if (DelayKt.delay(pcmBatchMaxWaitMs, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            this.$holder.setPcmFlushJob(null);
            TtsPcmDownlinkBatcher.PcmBatch pcmBatchFlushPending = this.$holder.getPcmBatcher().flushPending();
            if (pcmBatchFlushPending == null) {
                return lb.n.f10413a;
            }
            this.$holder.getCallbackQueue().enqueue(new k0(this.this$0, this.$holder, this.$inferId, pcmBatchFlushPending, 0));
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((C03571) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsStreamBinderCoordinator$tryHandleStreamingInferStart$1", f = "TtsStreamBinderCoordinator.kt", l = {FekEnvelope.EXPECTED_EPK_CHARS}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsStreamBinderCoordinator$tryHandleStreamingInferStart$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03581 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ IInferenceCallback $callback;
        final /* synthetic */ String $callerPkg;
        final /* synthetic */ int $callingUid;
        final /* synthetic */ String $inferId;
        final /* synthetic */ AITaskRecord $record;
        final /* synthetic */ ContentParams $streamParams;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03581(String str, IInferenceCallback iInferenceCallback, int i10, String str2, ContentParams contentParams, AITaskRecord aITaskRecord, qb.b<? super C03581> bVar) {
            super(2, bVar);
            this.$inferId = str;
            this.$callback = iInferenceCallback;
            this.$callingUid = i10;
            this.$callerPkg = str2;
            this.$streamParams = contentParams;
            this.$record = aITaskRecord;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return TtsStreamBinderCoordinator.this.new C03581(this.$inferId, this.$callback, this.$callingUid, this.$callerPkg, this.$streamParams, this.$record, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                TtsStreamBinderCoordinator ttsStreamBinderCoordinator = TtsStreamBinderCoordinator.this;
                String str = this.$inferId;
                IInferenceCallback iInferenceCallback = this.$callback;
                int i11 = this.$callingUid;
                String str2 = this.$callerPkg;
                ContentParams contentParams = this.$streamParams;
                AITaskRecord aITaskRecord = this.$record;
                this.label = 1;
                if (ttsStreamBinderCoordinator.openTtsStreamingSession(str, iInferenceCallback, i11, str2, contentParams, aITaskRecord, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((C03581) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    public TtsStreamBinderCoordinator(TtsStreamAbility ttsAbility, Host host) {
        kotlin.jvm.internal.g.f(ttsAbility, "ttsAbility");
        kotlin.jvm.internal.g.f(host, "host");
        this.ttsAbility = ttsAbility;
        this.host = host;
        this.TAG = "TtsStreamBinder";
        this.ttsStreamingBuffer = new TtsStreamingBuffer();
        this.ttsCloudWsSessions = new ConcurrentHashMap<>();
        this.ttsStreamingInferIds = ConcurrentHashMap.newKeySet();
        this.ttsPendingFinish = ConcurrentHashMap.newKeySet();
        this.ttsOpenWatchdogs = new ConcurrentHashMap<>();
        this.reorderBuffers = new ConcurrentHashMap<>();
    }

    private final void armTtsOpenWatchdog(String str) {
        Job jobPut = this.ttsOpenWatchdogs.put(str, BuildersKt__Builders_commonKt.launch$default(this.host.getAbilityScope(), null, null, new TtsStreamBinderCoordinator$armTtsOpenWatchdog$job$1(CloudConfigBootstrap.INSTANCE.get().getWatchdog().getSessionOpenTimeoutMs(), this, str, null), 3, null));
        if (jobPut != null) {
            Job.DefaultImpls.cancel$default(jobPut, null, 1, null);
        }
    }

    private final void bindLocalTtsFlywheel(String str, int i10, String str2, ContentParams contentParams) {
        p6.a abilityConfig = this.ttsAbility.getAbilityConfig();
        ModelCallBridge modelCallBridge = ModelCallBridge.INSTANCE;
        String str3 = abilityConfig.f11416a;
        b7.k kVar = (b7.k) kotlin.collections.a.v0(abilityConfig.f11419d);
        String str4 = kVar != null ? kVar.f3090a : null;
        ModelCallBridge.bindEdge$default(modelCallBridge, str, str3, str4 == null ? "" : str4, i10, str2 == null ? "" : str2, TraceIdExtractorKt.extractBusinessTraceId(contentParams), null, 64, null);
    }

    private final void cancelAllTtsOpenWatchdogs() {
        Collection<Job> collectionValues = this.ttsOpenWatchdogs.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), null, 1, null);
        }
        this.ttsOpenWatchdogs.clear();
    }

    private final void cancelPcmFlush(TtsCloudHolder ttsCloudHolder) {
        Job pcmFlushJob = ttsCloudHolder.getPcmFlushJob();
        if (pcmFlushJob != null) {
            Job.DefaultImpls.cancel$default(pcmFlushJob, null, 1, null);
        }
        ttsCloudHolder.setPcmFlushJob(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelTtsOpenWatchdog(String str) {
        Job jobRemove = this.ttsOpenWatchdogs.remove(str);
        if (jobRemove != null) {
            Job.DefaultImpls.cancel$default(jobRemove, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, lb.n] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collectTtsCloudWsEvents(java.lang.String r7, com.stepos.core.ability.speech.TtsStreamBinderCoordinator.TtsCloudHolder r8, qb.b<? super lb.n> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.stepos.core.ability.speech.TtsStreamBinderCoordinator.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.core.ability.speech.TtsStreamBinderCoordinator$collectTtsCloudWsEvents$1 r0 = (com.stepos.core.ability.speech.TtsStreamBinderCoordinator.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.TtsStreamBinderCoordinator$collectTtsCloudWsEvents$1 r0 = new com.stepos.core.ability.speech.TtsStreamBinderCoordinator$collectTtsCloudWsEvents$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3e
            if (r2 != r4) goto L36
            java.lang.Object r6 = r0.L$1
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r0.L$0
            com.stepos.core.ability.speech.TtsStreamBinderCoordinator r6 = (com.stepos.core.ability.speech.TtsStreamBinderCoordinator) r6
            kotlin.c.b(r9)     // Catch: java.lang.Throwable -> L32 java.util.concurrent.CancellationException -> L34
            goto L5b
        L32:
            r8 = move-exception
            goto L62
        L34:
            r8 = move-exception
            goto L61
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            kotlin.c.b(r9)
            com.stepos.core.ability.speech.TtsCloudWsSession r9 = r8.getSession()     // Catch: java.lang.Throwable -> L32 java.util.concurrent.CancellationException -> L34
            kotlinx.coroutines.flow.Flow r9 = r9.getEvents()     // Catch: java.lang.Throwable -> L32 java.util.concurrent.CancellationException -> L34
            com.stepos.core.ability.speech.TtsStreamBinderCoordinator$collectTtsCloudWsEvents$2 r2 = new com.stepos.core.ability.speech.TtsStreamBinderCoordinator$collectTtsCloudWsEvents$2     // Catch: java.lang.Throwable -> L32 java.util.concurrent.CancellationException -> L34
            r2.<init>(r7, r8)     // Catch: java.lang.Throwable -> L32 java.util.concurrent.CancellationException -> L34
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L32 java.util.concurrent.CancellationException -> L34
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L32 java.util.concurrent.CancellationException -> L34
            r0.label = r4     // Catch: java.lang.Throwable -> L32 java.util.concurrent.CancellationException -> L34
            java.lang.Object r8 = r9.collect(r2, r0)     // Catch: java.lang.Throwable -> L32 java.util.concurrent.CancellationException -> L34
            if (r8 != r1) goto L5b
            return r1
        L5b:
            terminateTtsCloudSession$default(r6, r7, r5, r3, r5)
            lb.n r6 = lb.n.f10413a
            return r6
        L61:
            throw r8     // Catch: java.lang.Throwable -> L32
        L62:
            terminateTtsCloudSession$default(r6, r7, r5, r3, r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsStreamBinderCoordinator.collectTtsCloudWsEvents(java.lang.String, com.stepos.core.ability.speech.TtsStreamBinderCoordinator$TtsCloudHolder, qb.b):java.lang.Object");
    }

    private final String decisionReason(h7.e eVar) {
        if (eVar instanceof e.c) {
            return ((e.c) eVar).f9370a;
        }
        if (eVar instanceof e.a) {
            return ((e.a) eVar).f9369b;
        }
        if (eVar instanceof e.b) {
            return null;
        }
        if (eVar instanceof e.d) {
            return ((e.d) eVar).f9371a;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchPcmBatch(TtsCloudHolder ttsCloudHolder, String str, TtsPcmDownlinkBatcher.PcmBatch pcmBatch) {
        TtsPcmDumpSink.INSTANCE.feed(str, ttsCloudHolder.getCallerUid(), pcmBatch.getPcm(), pcmBatch.getSampleRate(), pcmBatch.getChannels(), "CLOUD_STREAM", ttsCloudHolder.getBusinessTraceId());
        ttsCloudHolder.getHandler().onResult(str, new InferResult.Output(new AudioContent(pcmBatch.getPcm(), pcmBatch.getSampleRate(), pcmBatch.getChannels(), 2, null, 16, null)));
        ttsCloudHolder.setSentPcmBytes(ttsCloudHolder.getSentPcmBytes() + pcmBatch.getPcm().length);
        ttsCloudHolder.setLastPcmSampleRate(pcmBatch.getSampleRate());
        int channels = pcmBatch.getChannels();
        if (channels < 1) {
            channels = 1;
        }
        ttsCloudHolder.setLastPcmChannels(channels);
    }

    private final void disposeReorderBuffer(String str) {
        TtsFeedReorderBuffer ttsFeedReorderBufferRemove = this.reorderBuffers.remove(str);
        if (ttsFeedReorderBufferRemove != null) {
            ttsFeedReorderBufferRemove.dispose();
        }
    }

    private final void drainPendingText(String str) {
        TtsCloudWsSession session;
        for (String str2 : this.ttsStreamingBuffer.takePending(str)) {
            TtsCloudHolder ttsCloudHolder = this.ttsCloudWsSessions.get(str);
            if (ttsCloudHolder == null || (session = ttsCloudHolder.getSession()) == null) {
                this.ttsAbility.onFeedInput(str, new TextContent(str2));
            } else {
                session.feed(new i7.b(str2));
            }
        }
    }

    private final void emitTerminalBody(TtsCloudHolder ttsCloudHolder, String str, InferResult inferResult, boolean z) {
        String str2;
        InferResult inferResult2;
        ModelCallBridge modelCallBridge = ModelCallBridge.INSTANCE;
        modelCallBridge.mergeSessionState(str, ttsCloudHolder.getSession().correlationState());
        if (z) {
            str2 = str;
            ModelCallBridge.reportTerminal$default(modelCallBridge, str2, ModelCallOutcome.TRUNCATED, 0, ttsCloudHolder.getSession().correlationState(), 4, null);
            inferResult2 = inferResult;
        } else {
            str2 = str;
            inferResult2 = inferResult;
            ModelCallBridge.reportTerminal$default(modelCallBridge, str2, inferResult2, null, 4, null);
        }
        ttsCloudHolder.getHandler().onResult(str2, inferResult2);
        TtsPcmDumpSink.INSTANCE.close(str2);
        this.host.removeInferJob(str2);
        this.host.endAicScene(str2);
        this.host.scheduleIdleTransition();
    }

    public static /* synthetic */ void emitTerminalBody$default(TtsStreamBinderCoordinator ttsStreamBinderCoordinator, TtsCloudHolder ttsCloudHolder, String str, InferResult inferResult, boolean z, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z = false;
        }
        ttsStreamBinderCoordinator.emitTerminalBody(ttsCloudHolder, str, inferResult, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureInputClosed(TtsCloudHolder ttsCloudHolder, String str) {
        if (ttsCloudHolder.getInputClosedEmitted().compareAndSet(false, true)) {
            ttsCloudHolder.getHandler().onResult(str, new InferResult.Progress(0, inputClosedMarker()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureOpened(TtsCloudHolder ttsCloudHolder, String str) {
        if (ttsCloudHolder.getOpenedEmitted().compareAndSet(false, true)) {
            TextContent textContent = new TextContent("");
            textContent.setParams(new ContentParams.Builder().putBoolean(TtsStreamingBuffer.KEY_TTS_SESSION_OPENED, true).build());
            ttsCloudHolder.getHandler().onResult(str, new InferResult.Progress(0, textContent));
        }
    }

    private final TtsFeedReorderBuffer ensureReorderBuffer(String str) {
        TtsFeedReorderBuffer ttsFeedReorderBufferComputeIfAbsent = this.reorderBuffers.computeIfAbsent(str, new w(new e0(this, str, 1), 3));
        kotlin.jvm.internal.g.e(ttsFeedReorderBufferComputeIfAbsent, "computeIfAbsent(...)");
        return ttsFeedReorderBufferComputeIfAbsent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TtsFeedReorderBuffer ensureReorderBuffer$lambda$2(TtsStreamBinderCoordinator ttsStreamBinderCoordinator, String str, String it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new TtsFeedReorderBuffer(ttsStreamBinderCoordinator.host.getAbilityScope(), str, 800L, new e0(ttsStreamBinderCoordinator, str, 0), new android.llama.cpp.b(6, ttsStreamBinderCoordinator, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n ensureReorderBuffer$lambda$2$lambda$0(TtsStreamBinderCoordinator ttsStreamBinderCoordinator, String str, String text) {
        kotlin.jvm.internal.g.f(text, "text");
        TtsCloudHolder ttsCloudHolder = ttsStreamBinderCoordinator.ttsCloudWsSessions.get(str);
        if (ttsCloudHolder != null) {
            ttsCloudHolder.setTextFeedSeen(true);
            ttsCloudHolder.getSession().feed(new i7.b(text));
        } else {
            if (WhenMappings.$EnumSwitchMapping$0[ttsStreamBinderCoordinator.ttsStreamingBuffer.feed(str, new TextContent(text)).ordinal()] == 1) {
                ttsStreamBinderCoordinator.ttsAbility.onFeedInput(str, new TextContent(text));
            }
        }
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n ensureReorderBuffer$lambda$2$lambda$1(TtsStreamBinderCoordinator ttsStreamBinderCoordinator, String str) {
        TtsCloudHolder ttsCloudHolder = ttsStreamBinderCoordinator.ttsCloudWsSessions.get(str);
        if (ttsCloudHolder != null) {
            ttsCloudHolder.getSession().finish();
        } else if (ttsStreamBinderCoordinator.ttsStreamingBuffer.isRegistered(str)) {
            ttsStreamBinderCoordinator.ttsAbility.notifyInputClosed(str);
            ttsStreamBinderCoordinator.ttsAbility.completeInput(str);
        } else {
            ttsStreamBinderCoordinator.ttsPendingFinish.add(str);
        }
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TtsFeedReorderBuffer ensureReorderBuffer$lambda$3(zb.l lVar, Object obj) {
        return (TtsFeedReorderBuffer) lVar.invoke(obj);
    }

    private final void failOpen(String str, IInferenceCallback iInferenceCallback, int i10, String str2, String str3) {
        disposeReorderBuffer(str);
        this.ttsStreamingInferIds.remove(str);
        this.ttsPendingFinish.remove(str);
        this.host.endAicScene(str);
        a0.a.x(h0.e.f("failOpen: inferId=", str, ", code=", i10, ", "), str2, LogModule.ABILITY, this.TAG);
        ModelCallBridge.reportTerminal$default(ModelCallBridge.INSTANCE, str, new InferResult.Error(i10, str2), null, 4, null);
        if (iInferenceCallback != null) {
            new BinderResultHandler(iInferenceCallback).onResult(str, new InferResult.Error(i10, str3));
        }
        this.host.scheduleIdleTransition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCloudAudioDelta(final String str, final TtsCloudHolder ttsCloudHolder, d.b bVar) {
        List<TtsPcmDownlinkBatcher.PcmBatch> listAdd = ttsCloudHolder.getPcmBatcher().add(bVar.f9570a, bVar.f9571b, 1);
        if (ttsCloudHolder.getFirstTokenRecorded().compareAndSet(false, true)) {
            ModelCallBridge.INSTANCE.recordFirstToken(str);
        }
        if (!listAdd.isEmpty()) {
            final List listO0 = kotlin.collections.a.O0(listAdd);
            ttsCloudHolder.getCallbackQueue().enqueue(new zb.a() { // from class: com.stepos.core.ability.speech.h0
                @Override // zb.a
                public final Object invoke() {
                    return TtsStreamBinderCoordinator.handleCloudAudioDelta$lambda$15(this.f7286a, ttsCloudHolder, str, listO0);
                }
            });
        }
        scheduleOrCancelPcmFlush(ttsCloudHolder, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n handleCloudAudioDelta$lambda$15(TtsStreamBinderCoordinator ttsStreamBinderCoordinator, TtsCloudHolder ttsCloudHolder, String str, List list) {
        ttsStreamBinderCoordinator.ensureOpened(ttsCloudHolder, str);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ttsStreamBinderCoordinator.dispatchPcmBatch(ttsCloudHolder, str, (TtsPcmDownlinkBatcher.PcmBatch) it.next());
        }
        return lb.n.f10413a;
    }

    private final TextContent inputClosedMarker() {
        TextContent textContent = new TextContent("");
        textContent.setParams(new ContentParams.Builder().putBoolean(TtsStreamingBuffer.KEY_TTS_INPUT_CLOSED, true).build());
        return textContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTtsOpenTimeout(String str, long j10) {
        TtsCloudHolder ttsCloudHolder = this.ttsCloudWsSessions.get(str);
        if (ttsCloudHolder == null || ttsCloudHolder.getSession().isConnected() || ttsCloudHolder.getOpenedEmitted().get()) {
            return;
        }
        LogModule logModule = LogModule.ABILITY;
        String str2 = this.TAG;
        String token = this.host.getToken();
        StringBuilder sbO = a0.a.o("onTtsOpenTimeout: session not opened in ", j10, "ms, terminating inferId=", str);
        sbO.append(", token=");
        sbO.append(token);
        AIEngineLogger.w(logModule, str2, sbO.toString());
        terminateTtsCloudSession(str, new Pair<>(Integer.valueOf(AIEngineError.TIMEOUT), SpeechStreamUserMessage.SESSION_OPEN_TIMEOUT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object openTtsStreamingSession(java.lang.String r13, com.stepos.core.callback.IInferenceCallback r14, int r15, java.lang.String r16, com.stepos.core.data.ContentParams r17, com.stepos.core.model.task.AITaskRecord r18, qb.b<? super lb.n> r19) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsStreamBinderCoordinator.openTtsStreamingSession(java.lang.String, com.stepos.core.callback.IInferenceCallback, int, java.lang.String, com.stepos.core.data.ContentParams, com.stepos.core.model.task.AITaskRecord, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n openTtsStreamingSession$lambda$10(TtsStreamBinderCoordinator ttsStreamBinderCoordinator, String str) {
        ttsStreamBinderCoordinator.host.decLocalStreamCountIfCounted(str);
        ttsStreamBinderCoordinator.host.removeInferJob(str);
        ttsStreamBinderCoordinator.ttsStreamingBuffer.unregister(str);
        ttsStreamBinderCoordinator.host.endAicScene(str);
        ttsStreamBinderCoordinator.host.scheduleIdleTransition();
        return lb.n.f10413a;
    }

    private final void padTailSilenceIfNeeded(TtsCloudHolder ttsCloudHolder, String str) {
        int lastPcmSampleRate = ttsCloudHolder.getLastPcmSampleRate();
        int lastPcmChannels = ttsCloudHolder.getLastPcmChannels();
        int i10 = lastPcmChannels < 1 ? 1 : lastPcmChannels;
        List<Integer> listPlanTailSilenceChunks$ability_release = Companion.planTailSilenceChunks$ability_release(ttsCloudHolder.getSentPcmBytes(), lastPcmSampleRate, i10, ttsCloudHolder.getTailSilencePadMs());
        if (listPlanTailSilenceChunks$ability_release.isEmpty()) {
            return;
        }
        Iterator<T> it = listPlanTailSilenceChunks$ability_release.iterator();
        while (it.hasNext()) {
            dispatchPcmBatch(ttsCloudHolder, str, new TtsPcmDownlinkBatcher.PcmBatch(new byte[((Number) it.next()).intValue()], lastPcmSampleRate, i10));
        }
        LogModule logModule = LogModule.ABILITY;
        String str2 = this.TAG;
        Iterator<T> it2 = listPlanTailSilenceChunks$ability_release.iterator();
        int iIntValue = 0;
        while (it2.hasNext()) {
            iIntValue += ((Number) it2.next()).intValue();
        }
        int size = listPlanTailSilenceChunks$ability_release.size();
        long tailSilencePadMs = ttsCloudHolder.getTailSilencePadMs();
        StringBuilder sbF = h0.e.f("tail silence pad: inferId=", str, " padBytes=", iIntValue, " chunks=");
        com.stepos.core.ota.d.s(sbF, size, " targetMs=", tailSilencePadMs);
        sbF.append(" rate=");
        sbF.append(lastPcmSampleRate);
        sbF.append(" ch=");
        sbF.append(i10);
        a0.a.z(sbF, " (avoid client deep_buffer start-threshold underrun)", logModule, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleCloudTerminal(final TtsCloudHolder ttsCloudHolder, final String str, final InferResult inferResult, final boolean z) {
        if (ttsCloudHolder.getTerminalEmitted().compareAndSet(false, true)) {
            cancelPcmFlush(ttsCloudHolder);
            final TtsPcmDownlinkBatcher.PcmBatch pcmBatchDrain = ttsCloudHolder.getPcmBatcher().drain();
            ttsCloudHolder.getCallbackQueue().enqueue(new zb.a() { // from class: com.stepos.core.ability.speech.f0
                @Override // zb.a
                public final Object invoke() {
                    return TtsStreamBinderCoordinator.scheduleCloudTerminal$lambda$18(pcmBatchDrain, inferResult, this, ttsCloudHolder, str, z);
                }
            });
        }
    }

    public static /* synthetic */ void scheduleCloudTerminal$default(TtsStreamBinderCoordinator ttsStreamBinderCoordinator, TtsCloudHolder ttsCloudHolder, String str, InferResult inferResult, boolean z, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z = false;
        }
        ttsStreamBinderCoordinator.scheduleCloudTerminal(ttsCloudHolder, str, inferResult, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n scheduleCloudTerminal$lambda$18(TtsPcmDownlinkBatcher.PcmBatch pcmBatch, InferResult inferResult, TtsStreamBinderCoordinator ttsStreamBinderCoordinator, TtsCloudHolder ttsCloudHolder, String str, boolean z) {
        if (pcmBatch != null) {
            ttsStreamBinderCoordinator.ensureOpened(ttsCloudHolder, str);
            ttsStreamBinderCoordinator.dispatchPcmBatch(ttsCloudHolder, str, pcmBatch);
        }
        if (Companion.shouldPadTailSilence$ability_release(inferResult)) {
            ttsStreamBinderCoordinator.padTailSilenceIfNeeded(ttsCloudHolder, str);
        }
        ttsStreamBinderCoordinator.emitTerminalBody(ttsCloudHolder, str, inferResult, z);
        return lb.n.f10413a;
    }

    private final void scheduleOrCancelPcmFlush(TtsCloudHolder ttsCloudHolder, String str) {
        if (ttsCloudHolder.getPcmBatchMaxWaitMs() <= 0) {
            return;
        }
        if (!ttsCloudHolder.getPcmBatcher().hasPending()) {
            Job pcmFlushJob = ttsCloudHolder.getPcmFlushJob();
            if (pcmFlushJob != null) {
                Job.DefaultImpls.cancel$default(pcmFlushJob, null, 1, null);
            }
            ttsCloudHolder.setPcmFlushJob(null);
            return;
        }
        Job pcmFlushJob2 = ttsCloudHolder.getPcmFlushJob();
        if (pcmFlushJob2 == null || !pcmFlushJob2.isActive()) {
            ttsCloudHolder.setPcmFlushJob(BuildersKt__Builders_commonKt.launch$default(this.host.getAbilityScope(), null, null, new C03571(ttsCloudHolder, this, str, null), 3, null));
        }
    }

    private final void startTtsCloudSession(final String str, IInferenceCallback iInferenceCallback, final int i10, String str2, TtsCloudConfig ttsCloudConfig, ContentParams contentParams) {
        p6.a abilityConfig = this.ttsAbility.getAbilityConfig();
        final String strResolveFlywheelTraceId = TraceIdExtractorKt.resolveFlywheelTraceId(TraceIdExtractorKt.extractBusinessTraceId(contentParams));
        ModelCallBridge modelCallBridge = ModelCallBridge.INSTANCE;
        String str3 = abilityConfig.f11416a;
        b7.k kVar = (b7.k) kotlin.collections.a.v0(abilityConfig.f11419d);
        String str4 = kVar != null ? kVar.f3090a : null;
        if (str4 == null) {
            str4 = "";
        }
        modelCallBridge.bindCloud(str, str3, str4, i10, str2 == null ? "" : str2, CloudTransport.WEBSOCKET, strResolveFlywheelTraceId);
        AIEngineLogger.i(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("[TRACE] TTS startTtsCloudSession: traceId=", strResolveFlywheelTraceId, ", inferId=", str));
        TtsCloudWsSession ttsCloudWsSessionCreateCloudWsSession = this.ttsAbility.createCloudWsSession(ttsCloudConfig, strResolveFlywheelTraceId, new zb.l() { // from class: com.stepos.core.ability.speech.g0
            @Override // zb.l
            public final Object invoke(Object obj) {
                return TtsStreamBinderCoordinator.startTtsCloudSession$lambda$11(str, i10, strResolveFlywheelTraceId, (String) obj);
            }
        });
        ttsCloudWsSessionCreateCloudWsSession.setOnCorrelationEstablished(new s(str, 4));
        TtsCloudHolder ttsCloudHolder = new TtsCloudHolder(ttsCloudWsSessionCreateCloudWsSession, new BinderResultHandler(iInferenceCallback), new TtsPcmDownlinkBatcher(ttsCloudConfig.streamBatchChunks()), new TtsStreamCallbackQueue(), i10, strResolveFlywheelTraceId, ttsCloudConfig.streamMaxBinderQueueMs(), ttsCloudConfig.tailSilencePadMs(), null, null, null, null, false, false, null, 0L, 0, 0, 261888, null);
        this.ttsCloudWsSessions.put(str, ttsCloudHolder);
        this.ttsStreamingBuffer.register(str);
        this.host.putInferJob(str, BuildersKt__Builders_commonKt.launch$default(this.host.getAbilityScope(), null, null, new TtsStreamBinderCoordinator$startTtsCloudSession$job$1(this, str, ttsCloudHolder, null), 3, null));
        ttsCloudWsSessionCreateCloudWsSession.start();
        armTtsOpenWatchdog(str);
        drainPendingText(str);
        this.ttsStreamingInferIds.remove(str);
        if (this.ttsPendingFinish.remove(str)) {
            ttsCloudWsSessionCreateCloudWsSession.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n startTtsCloudSession$lambda$11(String str, int i10, String str2, String text) {
        kotlin.jvm.internal.g.f(text, "text");
        TtsPcmDumpSink.INSTANCE.feedText(str, i10, text, "CLOUD_STREAM", str2);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n startTtsCloudSession$lambda$12(String str, CloudSessionCorrelationState state) {
        kotlin.jvm.internal.g.f(state, "state");
        ModelCallBridge.INSTANCE.logEstablished(str, state);
        return lb.n.f10413a;
    }

    private final void terminateTtsCloudSession(final String str, final Pair<Integer, String> pair) {
        cancelTtsOpenWatchdog(str);
        disposeReorderBuffer(str);
        this.ttsStreamingInferIds.remove(str);
        this.ttsPendingFinish.remove(str);
        this.ttsStreamingBuffer.unregister(str);
        final TtsCloudHolder ttsCloudHolderRemove = this.ttsCloudWsSessions.remove(str);
        if (ttsCloudHolderRemove == null) {
            return;
        }
        cancelPcmFlush(ttsCloudHolderRemove);
        try {
            ttsCloudHolderRemove.getSession().cancel();
            lb.n nVar = lb.n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        if (!ttsCloudHolderRemove.getTerminalEmitted().get() && ttsCloudHolderRemove.getTerminalEmitted().compareAndSet(false, true)) {
            final TtsPcmDownlinkBatcher.PcmBatch pcmBatchDrain = ttsCloudHolderRemove.getPcmBatcher().drain();
            ttsCloudHolderRemove.getCallbackQueue().enqueue(new zb.a() { // from class: com.stepos.core.ability.speech.d0
                @Override // zb.a
                public final Object invoke() {
                    return TtsStreamBinderCoordinator.terminateTtsCloudSession$lambda$23(pcmBatchDrain, this, ttsCloudHolderRemove, str, pair);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void terminateTtsCloudSession$default(TtsStreamBinderCoordinator ttsStreamBinderCoordinator, String str, Pair pair, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            pair = new Pair(-100, "tts stream session released");
        }
        ttsStreamBinderCoordinator.terminateTtsCloudSession(str, pair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final lb.n terminateTtsCloudSession$lambda$23(TtsPcmDownlinkBatcher.PcmBatch pcmBatch, TtsStreamBinderCoordinator ttsStreamBinderCoordinator, TtsCloudHolder ttsCloudHolder, String str, Pair pair) {
        if (pcmBatch != null) {
            ttsStreamBinderCoordinator.ensureOpened(ttsCloudHolder, str);
            ttsStreamBinderCoordinator.dispatchPcmBatch(ttsCloudHolder, str, pcmBatch);
        }
        emitTerminalBody$default(ttsStreamBinderCoordinator, ttsCloudHolder, str, new InferResult.Error(((Number) pair.f9985a).intValue(), (String) pair.f9986b), false, 8, null);
        return lb.n.f10413a;
    }

    public final void cancelAll() {
        Set<String> setKeySet = this.reorderBuffers.keySet();
        kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
        for (String str : kotlin.collections.a.O0(setKeySet)) {
            kotlin.jvm.internal.g.c(str);
            disposeReorderBuffer(str);
        }
        cancelAllTtsOpenWatchdogs();
        Set<String> setKeySet2 = this.ttsCloudWsSessions.keySet();
        kotlin.jvm.internal.g.e(setKeySet2, "<get-keys>(...)");
        for (String str2 : kotlin.collections.a.O0(setKeySet2)) {
            kotlin.jvm.internal.g.c(str2);
            terminateTtsCloudSession$default(this, str2, null, 2, null);
        }
        this.ttsStreamingInferIds.clear();
        this.ttsPendingFinish.clear();
        this.ttsStreamingBuffer.cancelAll();
    }

    public final boolean isStreamingStart(Content input) {
        kotlin.jvm.internal.g.f(input, "input");
        return this.ttsStreamingBuffer.isStreamingStart(input);
    }

    public final boolean tryHandleCancelInfer(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        disposeReorderBuffer(inferId);
        if (!this.ttsCloudWsSessions.containsKey(inferId) && !this.ttsStreamingBuffer.isRegistered(inferId)) {
            if (!this.ttsStreamingInferIds.remove(inferId)) {
                return false;
            }
            this.ttsPendingFinish.remove(inferId);
            this.ttsStreamingBuffer.unregister(inferId);
            this.host.endAicScene(inferId);
            return true;
        }
        terminateTtsCloudSession$default(this, inferId, null, 2, null);
        this.ttsAbility.cancelLocalStream(inferId);
        this.ttsStreamingInferIds.remove(inferId);
        this.ttsPendingFinish.remove(inferId);
        this.ttsStreamingBuffer.unregister(inferId);
        this.host.removeInferJob(inferId);
        this.host.decLocalStreamCountIfCounted(inferId);
        this.host.endAicScene(inferId);
        this.host.scheduleIdleTransition();
        return true;
    }

    public final boolean tryHandleCompleteInput(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        TtsFeedReorderBuffer ttsFeedReorderBuffer = this.reorderBuffers.get(inferId);
        if (ttsFeedReorderBuffer != null) {
            ttsFeedReorderBuffer.markCompleted();
            return true;
        }
        TtsCloudHolder ttsCloudHolder = this.ttsCloudWsSessions.get(inferId);
        if (ttsCloudHolder != null) {
            if (ttsCloudHolder.getTextFeedSeen()) {
                ttsCloudHolder.getSession().finish();
                return true;
            }
            ttsCloudHolder.setFinishPendingBeforeTextFeed(true);
            return true;
        }
        if (this.ttsStreamingInferIds.contains(inferId)) {
            this.ttsPendingFinish.add(inferId);
            return true;
        }
        if (!this.ttsStreamingBuffer.isRegistered(inferId)) {
            return false;
        }
        this.ttsAbility.notifyInputClosed(inferId);
        this.ttsAbility.completeInput(inferId);
        return true;
    }

    public final boolean tryHandleFeedInput(String inferId, Content input) {
        ContentParams params;
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(input, "input");
        boolean z = input instanceof TextContent;
        if (z && (params = ((TextContent) input).getParams()) != null && ((params.containsKey(TtsStreamingBuffer.KEY_TTS_FEED_SEQ) || params.getBoolean(TtsStreamingBuffer.KEY_TTS_FEED_EOF, false)) && this.ttsStreamingInferIds.contains(inferId))) {
            ensureReorderBuffer(inferId);
        }
        TtsFeedReorderBuffer ttsFeedReorderBuffer = this.reorderBuffers.get(inferId);
        if (ttsFeedReorderBuffer != null) {
            if (z) {
                TextContent textContent = (TextContent) input;
                ContentParams params2 = textContent.getParams();
                if (params2 != null && params2.getBoolean(TtsStreamingBuffer.KEY_TTS_FEED_EOF, false)) {
                    ttsFeedReorderBuffer.markTotal(params2.getInt(TtsStreamingBuffer.KEY_TTS_FEED_TOTAL, -1));
                } else if (textContent.getText().length() > 0) {
                    ttsFeedReorderBuffer.offer(params2 != null ? params2.getInt(TtsStreamingBuffer.KEY_TTS_FEED_SEQ, -1) : -1, textContent.getText());
                }
            }
            return true;
        }
        TtsCloudHolder ttsCloudHolder = this.ttsCloudWsSessions.get(inferId);
        if (ttsCloudHolder != null) {
            if (z) {
                TextContent textContent2 = (TextContent) input;
                if (textContent2.getText().length() > 0) {
                    ttsCloudHolder.setTextFeedSeen(true);
                    ttsCloudHolder.getSession().feed(new i7.b(textContent2.getText()));
                    if (ttsCloudHolder.getFinishPendingBeforeTextFeed()) {
                        ttsCloudHolder.setFinishPendingBeforeTextFeed(false);
                        ttsCloudHolder.getSession().finish();
                    }
                }
            }
            return true;
        }
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.ttsStreamingBuffer.feed(inferId, input).ordinal()];
        if (i10 == 1) {
            this.ttsAbility.onFeedInput(inferId, input);
            return true;
        }
        if (i10 == 2) {
            return true;
        }
        if (i10 == 3) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean tryHandleStreamingInferStart(String inferId, Content input, IInferenceCallback iInferenceCallback, int i10, String str, boolean z, AITaskRecord aITaskRecord) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(input, "input");
        if (!isStreamingStart(input)) {
            return false;
        }
        this.host.markActive();
        if (!this.ttsStreamingInferIds.add(inferId)) {
            AIEngineLogger.w(LogModule.ABILITY, this.TAG, ai.onnxruntime.a.l("duplicate streaming inferId=", inferId, " ignored, token=", this.host.getToken()));
            return true;
        }
        TextContent textContent = input instanceof TextContent ? (TextContent) input : null;
        ContentParams params = textContent != null ? textContent.getParams() : null;
        if (params != null && params.getBoolean(TtsStreamingBuffer.KEY_TTS_FEED_ORDERED, false)) {
            ensureReorderBuffer(inferId);
        }
        this.host.startAicScene(inferId, z);
        BuildersKt__Builders_commonKt.launch$default(this.host.getAbilityScope(), null, null, new C03581(inferId, iInferenceCallback, i10, str, params, aITaskRecord, null), 3, null);
        return true;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TtsCloudHolder {
        private final String businessTraceId;
        private final TtsStreamCallbackQueue callbackQueue;
        private final int callerUid;
        private volatile boolean finishPendingBeforeTextFeed;
        private final AtomicBoolean firstTokenRecorded;
        private final BinderResultHandler handler;
        private final AtomicBoolean inputClosedEmitted;
        private volatile int lastPcmChannels;
        private volatile int lastPcmSampleRate;
        private final AtomicBoolean openedEmitted;
        private final long pcmBatchMaxWaitMs;
        private final TtsPcmDownlinkBatcher pcmBatcher;
        private volatile Job pcmFlushJob;
        private volatile long sentPcmBytes;
        private final TtsCloudWsSession session;
        private final long tailSilencePadMs;
        private final AtomicBoolean terminalEmitted;
        private volatile boolean textFeedSeen;

        public TtsCloudHolder(TtsCloudWsSession session, BinderResultHandler handler, TtsPcmDownlinkBatcher pcmBatcher, TtsStreamCallbackQueue callbackQueue, int i10, String businessTraceId, long j10, long j11, AtomicBoolean firstTokenRecorded, AtomicBoolean terminalEmitted, AtomicBoolean openedEmitted, AtomicBoolean inputClosedEmitted, boolean z, boolean z3, Job job, long j12, int i11, int i12) {
            kotlin.jvm.internal.g.f(session, "session");
            kotlin.jvm.internal.g.f(handler, "handler");
            kotlin.jvm.internal.g.f(pcmBatcher, "pcmBatcher");
            kotlin.jvm.internal.g.f(callbackQueue, "callbackQueue");
            kotlin.jvm.internal.g.f(businessTraceId, "businessTraceId");
            kotlin.jvm.internal.g.f(firstTokenRecorded, "firstTokenRecorded");
            kotlin.jvm.internal.g.f(terminalEmitted, "terminalEmitted");
            kotlin.jvm.internal.g.f(openedEmitted, "openedEmitted");
            kotlin.jvm.internal.g.f(inputClosedEmitted, "inputClosedEmitted");
            this.session = session;
            this.handler = handler;
            this.pcmBatcher = pcmBatcher;
            this.callbackQueue = callbackQueue;
            this.callerUid = i10;
            this.businessTraceId = businessTraceId;
            this.pcmBatchMaxWaitMs = j10;
            this.tailSilencePadMs = j11;
            this.firstTokenRecorded = firstTokenRecorded;
            this.terminalEmitted = terminalEmitted;
            this.openedEmitted = openedEmitted;
            this.inputClosedEmitted = inputClosedEmitted;
            this.textFeedSeen = z;
            this.finishPendingBeforeTextFeed = z3;
            this.pcmFlushJob = job;
            this.sentPcmBytes = j12;
            this.lastPcmSampleRate = i11;
            this.lastPcmChannels = i12;
        }

        public final TtsCloudWsSession component1() {
            return this.session;
        }

        public final AtomicBoolean component10() {
            return this.terminalEmitted;
        }

        public final AtomicBoolean component11() {
            return this.openedEmitted;
        }

        public final AtomicBoolean component12() {
            return this.inputClosedEmitted;
        }

        public final boolean component13() {
            return this.textFeedSeen;
        }

        public final boolean component14() {
            return this.finishPendingBeforeTextFeed;
        }

        public final Job component15() {
            return this.pcmFlushJob;
        }

        public final long component16() {
            return this.sentPcmBytes;
        }

        public final int component17() {
            return this.lastPcmSampleRate;
        }

        public final int component18() {
            return this.lastPcmChannels;
        }

        public final BinderResultHandler component2() {
            return this.handler;
        }

        public final TtsPcmDownlinkBatcher component3() {
            return this.pcmBatcher;
        }

        public final TtsStreamCallbackQueue component4() {
            return this.callbackQueue;
        }

        public final int component5() {
            return this.callerUid;
        }

        public final String component6() {
            return this.businessTraceId;
        }

        public final long component7() {
            return this.pcmBatchMaxWaitMs;
        }

        public final long component8() {
            return this.tailSilencePadMs;
        }

        public final AtomicBoolean component9() {
            return this.firstTokenRecorded;
        }

        public final TtsCloudHolder copy(TtsCloudWsSession session, BinderResultHandler handler, TtsPcmDownlinkBatcher pcmBatcher, TtsStreamCallbackQueue callbackQueue, int i10, String businessTraceId, long j10, long j11, AtomicBoolean firstTokenRecorded, AtomicBoolean terminalEmitted, AtomicBoolean openedEmitted, AtomicBoolean inputClosedEmitted, boolean z, boolean z3, Job job, long j12, int i11, int i12) {
            kotlin.jvm.internal.g.f(session, "session");
            kotlin.jvm.internal.g.f(handler, "handler");
            kotlin.jvm.internal.g.f(pcmBatcher, "pcmBatcher");
            kotlin.jvm.internal.g.f(callbackQueue, "callbackQueue");
            kotlin.jvm.internal.g.f(businessTraceId, "businessTraceId");
            kotlin.jvm.internal.g.f(firstTokenRecorded, "firstTokenRecorded");
            kotlin.jvm.internal.g.f(terminalEmitted, "terminalEmitted");
            kotlin.jvm.internal.g.f(openedEmitted, "openedEmitted");
            kotlin.jvm.internal.g.f(inputClosedEmitted, "inputClosedEmitted");
            return new TtsCloudHolder(session, handler, pcmBatcher, callbackQueue, i10, businessTraceId, j10, j11, firstTokenRecorded, terminalEmitted, openedEmitted, inputClosedEmitted, z, z3, job, j12, i11, i12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TtsCloudHolder)) {
                return false;
            }
            TtsCloudHolder ttsCloudHolder = (TtsCloudHolder) obj;
            return kotlin.jvm.internal.g.b(this.session, ttsCloudHolder.session) && kotlin.jvm.internal.g.b(this.handler, ttsCloudHolder.handler) && kotlin.jvm.internal.g.b(this.pcmBatcher, ttsCloudHolder.pcmBatcher) && kotlin.jvm.internal.g.b(this.callbackQueue, ttsCloudHolder.callbackQueue) && this.callerUid == ttsCloudHolder.callerUid && kotlin.jvm.internal.g.b(this.businessTraceId, ttsCloudHolder.businessTraceId) && this.pcmBatchMaxWaitMs == ttsCloudHolder.pcmBatchMaxWaitMs && this.tailSilencePadMs == ttsCloudHolder.tailSilencePadMs && kotlin.jvm.internal.g.b(this.firstTokenRecorded, ttsCloudHolder.firstTokenRecorded) && kotlin.jvm.internal.g.b(this.terminalEmitted, ttsCloudHolder.terminalEmitted) && kotlin.jvm.internal.g.b(this.openedEmitted, ttsCloudHolder.openedEmitted) && kotlin.jvm.internal.g.b(this.inputClosedEmitted, ttsCloudHolder.inputClosedEmitted) && this.textFeedSeen == ttsCloudHolder.textFeedSeen && this.finishPendingBeforeTextFeed == ttsCloudHolder.finishPendingBeforeTextFeed && kotlin.jvm.internal.g.b(this.pcmFlushJob, ttsCloudHolder.pcmFlushJob) && this.sentPcmBytes == ttsCloudHolder.sentPcmBytes && this.lastPcmSampleRate == ttsCloudHolder.lastPcmSampleRate && this.lastPcmChannels == ttsCloudHolder.lastPcmChannels;
        }

        public final String getBusinessTraceId() {
            return this.businessTraceId;
        }

        public final TtsStreamCallbackQueue getCallbackQueue() {
            return this.callbackQueue;
        }

        public final int getCallerUid() {
            return this.callerUid;
        }

        public final boolean getFinishPendingBeforeTextFeed() {
            return this.finishPendingBeforeTextFeed;
        }

        public final AtomicBoolean getFirstTokenRecorded() {
            return this.firstTokenRecorded;
        }

        public final BinderResultHandler getHandler() {
            return this.handler;
        }

        public final AtomicBoolean getInputClosedEmitted() {
            return this.inputClosedEmitted;
        }

        public final int getLastPcmChannels() {
            return this.lastPcmChannels;
        }

        public final int getLastPcmSampleRate() {
            return this.lastPcmSampleRate;
        }

        public final AtomicBoolean getOpenedEmitted() {
            return this.openedEmitted;
        }

        public final long getPcmBatchMaxWaitMs() {
            return this.pcmBatchMaxWaitMs;
        }

        public final TtsPcmDownlinkBatcher getPcmBatcher() {
            return this.pcmBatcher;
        }

        public final Job getPcmFlushJob() {
            return this.pcmFlushJob;
        }

        public final long getSentPcmBytes() {
            return this.sentPcmBytes;
        }

        public final TtsCloudWsSession getSession() {
            return this.session;
        }

        public final long getTailSilencePadMs() {
            return this.tailSilencePadMs;
        }

        public final AtomicBoolean getTerminalEmitted() {
            return this.terminalEmitted;
        }

        public final boolean getTextFeedSeen() {
            return this.textFeedSeen;
        }

        public int hashCode() {
            return Integer.hashCode(this.lastPcmChannels) + ai.onnxruntime.a.d(this.lastPcmSampleRate, a0.a.c((ai.onnxruntime.a.f(ai.onnxruntime.a.f((this.inputClosedEmitted.hashCode() + ((this.openedEmitted.hashCode() + ((this.terminalEmitted.hashCode() + ((this.firstTokenRecorded.hashCode() + a0.a.c(a0.a.c(v1.d.a(ai.onnxruntime.a.d(this.callerUid, (this.callbackQueue.hashCode() + ((this.pcmBatcher.hashCode() + ((this.handler.hashCode() + (this.session.hashCode() * 31)) * 31)) * 31)) * 31, 31), 31, this.businessTraceId), this.pcmBatchMaxWaitMs, 31), this.tailSilencePadMs, 31)) * 31)) * 31)) * 31)) * 31, 31, this.textFeedSeen), 31, this.finishPendingBeforeTextFeed) + (this.pcmFlushJob == null ? 0 : this.pcmFlushJob.hashCode())) * 31, this.sentPcmBytes, 31), 31);
        }

        public final void setFinishPendingBeforeTextFeed(boolean z) {
            this.finishPendingBeforeTextFeed = z;
        }

        public final void setLastPcmChannels(int i10) {
            this.lastPcmChannels = i10;
        }

        public final void setLastPcmSampleRate(int i10) {
            this.lastPcmSampleRate = i10;
        }

        public final void setPcmFlushJob(Job job) {
            this.pcmFlushJob = job;
        }

        public final void setSentPcmBytes(long j10) {
            this.sentPcmBytes = j10;
        }

        public final void setTextFeedSeen(boolean z) {
            this.textFeedSeen = z;
        }

        public String toString() {
            TtsCloudWsSession ttsCloudWsSession = this.session;
            BinderResultHandler binderResultHandler = this.handler;
            TtsPcmDownlinkBatcher ttsPcmDownlinkBatcher = this.pcmBatcher;
            TtsStreamCallbackQueue ttsStreamCallbackQueue = this.callbackQueue;
            int i10 = this.callerUid;
            String str = this.businessTraceId;
            long j10 = this.pcmBatchMaxWaitMs;
            long j11 = this.tailSilencePadMs;
            AtomicBoolean atomicBoolean = this.firstTokenRecorded;
            AtomicBoolean atomicBoolean2 = this.terminalEmitted;
            AtomicBoolean atomicBoolean3 = this.openedEmitted;
            AtomicBoolean atomicBoolean4 = this.inputClosedEmitted;
            boolean z = this.textFeedSeen;
            boolean z3 = this.finishPendingBeforeTextFeed;
            Job job = this.pcmFlushJob;
            long j12 = this.sentPcmBytes;
            int i11 = this.lastPcmSampleRate;
            int i12 = this.lastPcmChannels;
            StringBuilder sb2 = new StringBuilder("TtsCloudHolder(session=");
            sb2.append(ttsCloudWsSession);
            sb2.append(", handler=");
            sb2.append(binderResultHandler);
            sb2.append(", pcmBatcher=");
            sb2.append(ttsPcmDownlinkBatcher);
            sb2.append(", callbackQueue=");
            sb2.append(ttsStreamCallbackQueue);
            sb2.append(", callerUid=");
            h0.e.h(i10, ", businessTraceId=", str, ", pcmBatchMaxWaitMs=", sb2);
            sb2.append(j10);
            a0.a.s(j11, ", tailSilencePadMs=", ", firstTokenRecorded=", sb2);
            sb2.append(atomicBoolean);
            sb2.append(", terminalEmitted=");
            sb2.append(atomicBoolean2);
            sb2.append(", openedEmitted=");
            sb2.append(atomicBoolean3);
            sb2.append(", inputClosedEmitted=");
            sb2.append(atomicBoolean4);
            sb2.append(", textFeedSeen=");
            sb2.append(z);
            sb2.append(", finishPendingBeforeTextFeed=");
            sb2.append(z3);
            sb2.append(", pcmFlushJob=");
            sb2.append(job);
            sb2.append(", sentPcmBytes=");
            sb2.append(j12);
            sb2.append(", lastPcmSampleRate=");
            sb2.append(i11);
            sb2.append(", lastPcmChannels=");
            sb2.append(i12);
            sb2.append(")");
            return sb2.toString();
        }

        public /* synthetic */ TtsCloudHolder(TtsCloudWsSession ttsCloudWsSession, BinderResultHandler binderResultHandler, TtsPcmDownlinkBatcher ttsPcmDownlinkBatcher, TtsStreamCallbackQueue ttsStreamCallbackQueue, int i10, String str, long j10, long j11, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, AtomicBoolean atomicBoolean3, AtomicBoolean atomicBoolean4, boolean z, boolean z3, Job job, long j12, int i11, int i12, int i13, kotlin.jvm.internal.e eVar) {
            this(ttsCloudWsSession, binderResultHandler, ttsPcmDownlinkBatcher, ttsStreamCallbackQueue, i10, str, j10, j11, (i13 & 256) != 0 ? new AtomicBoolean(false) : atomicBoolean, (i13 & VadSessionManager.FRAME_BYTES) != 0 ? new AtomicBoolean(false) : atomicBoolean2, (i13 & 1024) != 0 ? new AtomicBoolean(false) : atomicBoolean3, (i13 & 2048) != 0 ? new AtomicBoolean(false) : atomicBoolean4, (i13 & 4096) != 0 ? false : z, (i13 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? false : z3, (i13 & 16384) != 0 ? null : job, (32768 & i13) != 0 ? 0L : j12, (65536 & i13) != 0 ? 0 : i11, (i13 & TtsStreamBinderCoordinator.MAX_SILENCE_CHUNK_BYTES) != 0 ? 1 : i12);
        }
    }
}
