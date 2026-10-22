package com.stepos.core.ability.speech;

import android.os.SystemClock;
import com.stepos.base.ability.ApplyScope;
import com.stepos.base.strategy.OrchestrationRejectedException;
import com.stepos.core.ability.handler.BinderResultHandler;
import com.stepos.core.ability.handler.InferResult;
import com.stepos.core.ability.speech.AsrStreamingBuffer;
import com.stepos.core.ability.telemetry.ModelCallBridge;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.common.cloud.CloudConfigBootstrap;
import com.stepos.core.common.cloud.CloudErrorUserMessage;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import com.stepos.core.common.cloud.CloudTransport;
import com.stepos.core.common.cloud.CloudTransportConfig;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.telemetry.PowerPerfTracker;
import com.stepos.core.common.util.AsrParamKeys;
import com.stepos.core.common.util.TraceIdExtractorKt;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.base.Content;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.task.AITaskRecord;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrRealtimeBinderCoordinator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String MSG_IDLE_TIMEOUT = "网络连接中断，请稍后重试";

    @Deprecated
    public static final String MSG_INTERNAL_ERROR = "语音识别异常，请稍后重试";

    @Deprecated
    public static final String MSG_LOCAL_NOT_READY = "语音识别暂不可用，请稍后重试";

    @Deprecated
    public static final int STREAM_CHANNEL = 1;

    @Deprecated
    public static final int STREAM_EVENT_BUFFER = 64;

    @Deprecated
    public static final int STREAM_SAMPLE_RATE = 16000;

    @Deprecated
    public static final String TAG = "AsrRealtimeCoordinator";
    private final int callerUid;
    private final ConcurrentHashMap<String, Long> closeChannelAtNs;
    private final AtomicBoolean cloudActorStarted;
    private final ConcurrentHashMap.KeySetView<String, Boolean> cloudFinalizing;
    private final Channel<lb.n> cloudOpenWakeups;
    private final ConcurrentHashMap<String, CloudWsHolder> cloudWsSessions;
    private final Host host;
    private final lb.d pcmDumpSink$delegate;
    private final AtomicReference<PendingCloudOpen> pendingCloudOpen;
    private final ConcurrentHashMap.KeySetView<String, Boolean> pendingFinish;
    private final ConcurrentHashMap<String, AsrFeedReorderBuffer> reorderBuffers;
    private final lb.d reorderScope$delegate;
    private final ConcurrentHashMap<String, Job> streamOpenWatchdogs;
    private final StreamingCapableAbility streamingAbility;
    private final AsrStreamingBuffer streamingBuffer;
    private final ConcurrentHashMap.KeySetView<String, Boolean> streamingInferIds;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface Host {
        void cancelInferJob(String str);

        void decActiveInference();

        void decLocalStreamCountIfCounted(String str);

        void endAicScene(String str);

        boolean forwardCompleteInput(String str);

        void forwardFeedInput(String str, Content content);

        String getAbilityId();

        CoroutineScope getAbilityScope();

        String getModelId();

        String getToken();

        void incActiveInference();

        void incLocalStreamCount(String str);

        void markActive();

        void onInferTerminal(String str);

        void putInferJob(String str, Job job);

        void releaseInferSlot(String str);

        void removeInferJob(String str);

        void scheduleIdleTransition();

        void startAicScene(String str, boolean z);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class PendingCloudOpen {
        private final IInferenceCallback callback;
        private final String callerPkg;
        private final int callerUid;
        private final String inferId;
        private final ContentParams params;
        private final String reason;

        public PendingCloudOpen(String inferId, IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, String reason, String str) {
            kotlin.jvm.internal.g.f(inferId, "inferId");
            kotlin.jvm.internal.g.f(reason, "reason");
            this.inferId = inferId;
            this.callback = iInferenceCallback;
            this.callerUid = i10;
            this.params = contentParams;
            this.reason = reason;
            this.callerPkg = str;
        }

        public static /* synthetic */ PendingCloudOpen copy$default(PendingCloudOpen pendingCloudOpen, String str, IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = pendingCloudOpen.inferId;
            }
            if ((i11 & 2) != 0) {
                iInferenceCallback = pendingCloudOpen.callback;
            }
            if ((i11 & 4) != 0) {
                i10 = pendingCloudOpen.callerUid;
            }
            if ((i11 & 8) != 0) {
                contentParams = pendingCloudOpen.params;
            }
            if ((i11 & 16) != 0) {
                str2 = pendingCloudOpen.reason;
            }
            if ((i11 & 32) != 0) {
                str3 = pendingCloudOpen.callerPkg;
            }
            String str4 = str2;
            String str5 = str3;
            return pendingCloudOpen.copy(str, iInferenceCallback, i10, contentParams, str4, str5);
        }

        public final String component1() {
            return this.inferId;
        }

        public final IInferenceCallback component2() {
            return this.callback;
        }

        public final int component3() {
            return this.callerUid;
        }

        public final ContentParams component4() {
            return this.params;
        }

        public final String component5() {
            return this.reason;
        }

        public final String component6() {
            return this.callerPkg;
        }

        public final PendingCloudOpen copy(String inferId, IInferenceCallback iInferenceCallback, int i10, ContentParams contentParams, String reason, String str) {
            kotlin.jvm.internal.g.f(inferId, "inferId");
            kotlin.jvm.internal.g.f(reason, "reason");
            return new PendingCloudOpen(inferId, iInferenceCallback, i10, contentParams, reason, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PendingCloudOpen)) {
                return false;
            }
            PendingCloudOpen pendingCloudOpen = (PendingCloudOpen) obj;
            return kotlin.jvm.internal.g.b(this.inferId, pendingCloudOpen.inferId) && kotlin.jvm.internal.g.b(this.callback, pendingCloudOpen.callback) && this.callerUid == pendingCloudOpen.callerUid && kotlin.jvm.internal.g.b(this.params, pendingCloudOpen.params) && kotlin.jvm.internal.g.b(this.reason, pendingCloudOpen.reason) && kotlin.jvm.internal.g.b(this.callerPkg, pendingCloudOpen.callerPkg);
        }

        public final IInferenceCallback getCallback() {
            return this.callback;
        }

        public final String getCallerPkg() {
            return this.callerPkg;
        }

        public final int getCallerUid() {
            return this.callerUid;
        }

        public final String getInferId() {
            return this.inferId;
        }

        public final ContentParams getParams() {
            return this.params;
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            int iHashCode = this.inferId.hashCode() * 31;
            IInferenceCallback iInferenceCallback = this.callback;
            int iD = ai.onnxruntime.a.d(this.callerUid, (iHashCode + (iInferenceCallback == null ? 0 : iInferenceCallback.hashCode())) * 31, 31);
            ContentParams contentParams = this.params;
            int iA = v1.d.a((iD + (contentParams == null ? 0 : contentParams.hashCode())) * 31, 31, this.reason);
            String str = this.callerPkg;
            return iA + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            String str = this.inferId;
            IInferenceCallback iInferenceCallback = this.callback;
            int i10 = this.callerUid;
            ContentParams contentParams = this.params;
            String str2 = this.reason;
            String str3 = this.callerPkg;
            StringBuilder sb2 = new StringBuilder("PendingCloudOpen(inferId=");
            sb2.append(str);
            sb2.append(", callback=");
            sb2.append(iInferenceCallback);
            sb2.append(", callerUid=");
            sb2.append(i10);
            sb2.append(", params=");
            sb2.append(contentParams);
            sb2.append(", reason=");
            return com.stepos.core.ota.d.j(sb2, str2, ", callerPkg=", str3, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator", f = "AsrRealtimeBinderCoordinator.kt", l = {940}, m = "closeActiveCloudAndAwait")
    /* renamed from: com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$closeActiveCloudAndAwait$1, reason: invalid class name */
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
            return AsrRealtimeBinderCoordinator.this.closeActiveCloudAndAwait(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator", f = "AsrRealtimeBinderCoordinator.kt", l = {580}, m = "collectCloudWsEvents")
    /* renamed from: com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$collectCloudWsEvents$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03241 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03241(qb.b<? super C03241> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrRealtimeBinderCoordinator.this.collectCloudWsEvents(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator", f = "AsrRealtimeBinderCoordinator.kt", l = {918}, m = "drainCloudOpenLatest")
    /* renamed from: com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$drainCloudOpenLatest$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03251 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03251(qb.b<? super C03251> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrRealtimeBinderCoordinator.this.drainCloudOpenLatest(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$ensureCloudActor$1", f = "AsrRealtimeBinderCoordinator.kt", l = {907, 908}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$ensureCloudActor$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03261 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public C03261(qb.b<? super C03261> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C03261 c03261 = AsrRealtimeBinderCoordinator.this.new C03261(bVar);
            c03261.L$0 = obj;
            return c03261;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
        
            if (r11.drainCloudOpenLatest(r10) == r0) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0066 -> B:25:0x0069). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2e
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                java.lang.Object r1 = r10.L$1
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r10.L$0
                kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                kotlin.c.b(r11)     // Catch: java.lang.Throwable -> L18
                goto L69
            L18:
                r11 = move-exception
                goto L6c
            L1a:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L22:
                java.lang.Object r1 = r10.L$1
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r10.L$0
                kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                kotlin.c.b(r11)
                goto L4f
            L2e:
                kotlin.c.b(r11)
                java.lang.Object r11 = r10.L$0
                kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator r1 = com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.this
                kotlinx.coroutines.channels.Channel r1 = com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.access$getCloudOpenWakeups$p(r1)
                kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            L3f:
                r10.L$0 = r11
                r10.L$1 = r1
                r10.label = r3
                java.lang.Object r4 = r1.hasNext(r10)
                if (r4 != r0) goto L4c
                goto L68
            L4c:
                r9 = r4
                r4 = r11
                r11 = r9
            L4f:
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r11 == 0) goto L97
                r1.next()
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator r11 = com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.this
                r10.L$0 = r4     // Catch: java.lang.Throwable -> L18
                r10.L$1 = r1     // Catch: java.lang.Throwable -> L18
                r10.label = r2     // Catch: java.lang.Throwable -> L18
                java.lang.Object r11 = com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.access$drainCloudOpenLatest(r11, r10)     // Catch: java.lang.Throwable -> L18
                if (r11 != r0) goto L69
            L68:
                return r0
            L69:
                lb.n r11 = lb.n.f10413a     // Catch: java.lang.Throwable -> L18
                goto L70
            L6c:
                kotlin.Result$Failure r11 = kotlin.c.a(r11)
            L70:
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator r5 = com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.this
                java.lang.Throwable r11 = kotlin.Result.b(r11)
                if (r11 == 0) goto L95
                com.stepos.core.common.log.LogModule r6 = com.stepos.core.common.log.LogModule.ABILITY
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$Host r5 = com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.access$getHost$p(r5)
                java.lang.String r5 = r5.getToken()
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r8 = "cloud open actor drain failed, token="
                r7.<init>(r8)
                r7.append(r5)
                java.lang.String r5 = r7.toString()
                java.lang.String r7 = "AsrRealtimeCoordinator"
                com.stepos.core.common.log.AIEngineLogger.e(r6, r7, r5, r11)
            L95:
                r11 = r4
                goto L3f
            L97:
                lb.n r10 = lb.n.f10413a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.C03261.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((C03261) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator", f = "AsrRealtimeBinderCoordinator.kt", l = {421, 489}, m = "openStreamingSession")
    /* renamed from: com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$openStreamingSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03271 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C03271(qb.b<? super C03271> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrRealtimeBinderCoordinator.this.openStreamingSession(null, null, 0, null, null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$scheduleCloudFinalize$1", f = "AsrRealtimeBinderCoordinator.kt", l = {807, 828}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$scheduleCloudFinalize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03281 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ zb.p<String, InferResult, lb.n> $finalize;
        final /* synthetic */ CloudWsHolder $holder;
        final /* synthetic */ String $inferId;
        final /* synthetic */ long $waitMs;
        long J$0;
        int label;
        final /* synthetic */ AsrRealtimeBinderCoordinator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C03281(CloudWsHolder cloudWsHolder, long j10, String str, AsrRealtimeBinderCoordinator asrRealtimeBinderCoordinator, zb.p<? super String, ? super InferResult, lb.n> pVar, qb.b<? super C03281> bVar) {
            super(2, bVar);
            this.$holder = cloudWsHolder;
            this.$waitMs = j10;
            this.$inferId = str;
            this.this$0 = asrRealtimeBinderCoordinator;
            this.$finalize = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return new C03281(this.$holder, this.$waitMs, this.$inferId, this.this$0, this.$finalize, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            long j10;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                AsrCloudWsSession session = this.$holder.getSession();
                long j11 = this.$waitMs;
                this.label = 1;
                obj = session.awaitOpened(j11, this);
                if (obj != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j10 = this.J$0;
                kotlin.c.b(obj);
                this.$finalize.invoke(ai.onnxruntime.a.h(j10, "grace-after-late-open(", "ms)"), InferResult.Complete.INSTANCE);
                return lb.n.f10413a;
            }
            kotlin.c.b(obj);
            if (!((Boolean) obj).booleanValue()) {
                int iNoResultTerminalCode = this.$holder.getSession().noResultTerminalCode();
                AIEngineLogger.w(LogModule.ABILITY, AsrRealtimeBinderCoordinator.TAG, com.stepos.core.ota.d.j(ai.onnxruntime.a.r(this.$waitMs, "[DIAG] closeChannel(cloud): still not opened after ", "ms, fail, code=", iNoResultTerminalCode), ", inferId=", this.$inferId, ", token=", this.this$0.host.getToken()));
                this.$finalize.invoke(ai.onnxruntime.a.g(iNoResultTerminalCode, "no-ws-open-after-wait(code=", ")"), new InferResult.Error(iNoResultTerminalCode, CloudErrorUserMessage.INSTANCE.of(iNoResultTerminalCode)));
                return lb.n.f10413a;
            }
            CloudTransportConfig.Watchdog watchdog = CloudConfigBootstrap.INSTANCE.get().getWatchdog();
            long manualCommitGraceMs = this.$holder.getSession().isManualCommitMode() ? watchdog.getManualCommitGraceMs() : watchdog.getFinishGraceMs();
            AIEngineLogger.i(LogModule.ABILITY, AsrRealtimeBinderCoordinator.TAG, a0.a.h("[DIAG] closeChannel(cloud): late open after closeChannel, waiting grace=", manualCommitGraceMs, "ms, inferId=", this.$inferId));
            this.J$0 = manualCommitGraceMs;
            this.label = 2;
            if (DelayKt.delay(manualCommitGraceMs, this) != coroutineSingletons) {
                j10 = manualCommitGraceMs;
                this.$finalize.invoke(ai.onnxruntime.a.h(j10, "grace-after-late-open(", "ms)"), InferResult.Complete.INSTANCE);
                return lb.n.f10413a;
            }
            return coroutineSingletons;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((C03281) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$scheduleCloudFinalize$2", f = "AsrRealtimeBinderCoordinator.kt", l = {848}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$scheduleCloudFinalize$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03292 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ zb.p<String, InferResult, lb.n> $finalize;
        final /* synthetic */ long $graceMs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C03292(long j10, zb.p<? super String, ? super InferResult, lb.n> pVar, qb.b<? super C03292> bVar) {
            super(2, bVar);
            this.$graceMs = j10;
            this.$finalize = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return new C03292(this.$graceMs, this.$finalize, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                long j10 = this.$graceMs;
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
            this.$finalize.invoke(ai.onnxruntime.a.h(this.$graceMs, "grace(", "ms)"), InferResult.Complete.INSTANCE);
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((C03292) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$startCloudIdleWatchdog$1", f = "AsrRealtimeBinderCoordinator.kt", l = {857}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$startCloudIdleWatchdog$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03301 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ CloudWsHolder $holder;
        final /* synthetic */ String $inferId;
        final /* synthetic */ CloudTransportConfig.Watchdog $watchdog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03301(String str, CloudWsHolder cloudWsHolder, CloudTransportConfig.Watchdog watchdog, qb.b<? super C03301> bVar) {
            super(2, bVar);
            this.$inferId = str;
            this.$holder = cloudWsHolder;
            this.$watchdog = watchdog;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return AsrRealtimeBinderCoordinator.this.new C03301(this.$inferId, this.$holder, this.$watchdog, bVar);
        }

        /* JADX WARN: Path cross not found for [B:9:0x0018, B:18:0x0055], limit reached: 26 */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0034 -> B:14:0x0037). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r7.label
                r2 = 1
                if (r1 == 0) goto L15
                if (r1 != r2) goto Ld
                kotlin.c.b(r8)
                goto L37
            Ld:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L15:
                kotlin.c.b(r8)
            L18:
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator r8 = com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.this
                java.util.concurrent.ConcurrentHashMap r8 = com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.access$getCloudWsSessions$p(r8)
                java.lang.String r1 = r7.$inferId
                java.lang.Object r8 = r8.get(r1)
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$CloudWsHolder r1 = r7.$holder
                if (r8 != r1) goto Ld0
                com.stepos.core.common.cloud.CloudTransportConfig$Watchdog r8 = r7.$watchdog
                long r3 = r8.getIdleCheckMs()
                r7.label = r2
                java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r3, r7)
                if (r8 != r0) goto L37
                return r0
            L37:
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator r8 = com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.this
                java.util.concurrent.ConcurrentHashMap r8 = com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.access$getCloudWsSessions$p(r8)
                java.lang.String r1 = r7.$inferId
                java.lang.Object r8 = r8.get(r1)
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$CloudWsHolder r1 = r7.$holder
                if (r8 != r1) goto Ld0
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator r8 = com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.this
                java.util.concurrent.ConcurrentHashMap$KeySetView r8 = com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.access$getCloudFinalizing$p(r8)
                java.lang.String r1 = r7.$inferId
                boolean r8 = r8.contains(r1)
                if (r8 != 0) goto L18
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$CloudWsHolder r8 = r7.$holder
                com.stepos.core.ability.speech.AsrCloudWsSession r8 = r8.getSession()
                boolean r8 = r8.isConnected()
                if (r8 == 0) goto L6f
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$CloudWsHolder r8 = r7.$holder
                java.util.concurrent.atomic.AtomicLong r8 = r8.getLastEventNs()
                long r3 = android.os.SystemClock.elapsedRealtimeNanos()
                r8.set(r3)
                goto L18
            L6f:
                long r3 = android.os.SystemClock.elapsedRealtimeNanos()
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$CloudWsHolder r8 = r7.$holder
                java.util.concurrent.atomic.AtomicLong r8 = r8.getLastEventNs()
                long r5 = r8.get()
                long r3 = r3 - r5
                r8 = 1000000(0xf4240, float:1.401298E-39)
                long r5 = (long) r8
                long r3 = r3 / r5
                com.stepos.core.common.cloud.CloudTransportConfig$Watchdog r8 = r7.$watchdog
                long r5 = r8.getIdleTimeoutMs()
                int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r8 < 0) goto L18
                com.stepos.core.common.log.LogModule r8 = com.stepos.core.common.log.LogModule.ABILITY
                com.stepos.core.common.cloud.CloudTransportConfig$Watchdog r0 = r7.$watchdog
                long r0 = r0.getIdleTimeoutMs()
                java.lang.String r2 = r7.$inferId
                java.lang.String r5 = "cloud WS disconnected & idle "
                java.lang.String r6 = "ms > "
                java.lang.StringBuilder r3 = ai.onnxruntime.a.q(r3, r5, r6)
                r3.append(r0)
                java.lang.String r0 = "ms, cancelling inferId="
                r3.append(r0)
                r3.append(r2)
                java.lang.String r0 = r3.toString()
                java.lang.String r1 = "AsrRealtimeCoordinator"
                com.stepos.core.common.log.AIEngineLogger.w(r8, r1, r0)
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator r8 = com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.this
                java.lang.String r0 = r7.$inferId
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$CloudWsHolder r1 = r7.$holder
                com.stepos.core.ability.handler.InferResult$Error r2 = new com.stepos.core.ability.handler.InferResult$Error
                r3 = -101(0xffffffffffffff9b, float:NaN)
                java.lang.String r4 = "网络连接中断，请稍后重试"
                r2.<init>(r3, r4)
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.access$emitCloudTerminal(r8, r0, r1, r2)
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator r8 = com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.this
                com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$Host r8 = com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.access$getHost$p(r8)
                java.lang.String r7 = r7.$inferId
                r8.cancelInferJob(r7)
            Ld0:
                lb.n r7 = lb.n.f10413a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.C03301.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((C03301) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$tryHandleStreamingInferStart$1", f = "AsrRealtimeBinderCoordinator.kt", l = {189}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$tryHandleStreamingInferStart$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03311 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ IInferenceCallback $callback;
        final /* synthetic */ String $callerPkg;
        final /* synthetic */ int $callingUid;
        final /* synthetic */ String $inferId;
        final /* synthetic */ AITaskRecord $record;
        final /* synthetic */ ContentParams $streamParams;
        final /* synthetic */ PowerPerfTracker $tracker;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03311(String str, IInferenceCallback iInferenceCallback, int i10, String str2, ContentParams contentParams, PowerPerfTracker powerPerfTracker, AITaskRecord aITaskRecord, qb.b<? super C03311> bVar) {
            super(2, bVar);
            this.$inferId = str;
            this.$callback = iInferenceCallback;
            this.$callingUid = i10;
            this.$callerPkg = str2;
            this.$streamParams = contentParams;
            this.$tracker = powerPerfTracker;
            this.$record = aITaskRecord;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return AsrRealtimeBinderCoordinator.this.new C03311(this.$inferId, this.$callback, this.$callingUid, this.$callerPkg, this.$streamParams, this.$tracker, this.$record, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                AsrRealtimeBinderCoordinator asrRealtimeBinderCoordinator = AsrRealtimeBinderCoordinator.this;
                String str = this.$inferId;
                IInferenceCallback iInferenceCallback = this.$callback;
                int i11 = this.$callingUid;
                String str2 = this.$callerPkg;
                ContentParams contentParams = this.$streamParams;
                PowerPerfTracker powerPerfTracker = this.$tracker;
                AITaskRecord aITaskRecord = this.$record;
                this.label = 1;
                if (asrRealtimeBinderCoordinator.openStreamingSession(str, iInferenceCallback, i11, str2, contentParams, powerPerfTracker, aITaskRecord, this) == coroutineSingletons) {
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
            return ((C03311) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    public AsrRealtimeBinderCoordinator(StreamingCapableAbility streamingAbility, int i10, Host host) {
        kotlin.jvm.internal.g.f(streamingAbility, "streamingAbility");
        kotlin.jvm.internal.g.f(host, "host");
        this.streamingAbility = streamingAbility;
        this.callerUid = i10;
        this.host = host;
        this.streamingBuffer = new AsrStreamingBuffer(CloudConfigBootstrap.INSTANCE.get().getBackpressure().getUplinkQueueLimitBytes());
        this.cloudWsSessions = new ConcurrentHashMap<>();
        this.pcmDumpSink$delegate = kotlin.b.b(new m0(this, 1));
        this.pendingCloudOpen = new AtomicReference<>(null);
        this.cloudOpenWakeups = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.cloudActorStarted = new AtomicBoolean(false);
        this.cloudFinalizing = ConcurrentHashMap.newKeySet();
        this.closeChannelAtNs = new ConcurrentHashMap<>();
        this.streamingInferIds = ConcurrentHashMap.newKeySet();
        this.pendingFinish = ConcurrentHashMap.newKeySet();
        this.reorderBuffers = new ConcurrentHashMap<>();
        this.reorderScope$delegate = kotlin.b.b(new e(this, 2));
        this.streamOpenWatchdogs = new ConcurrentHashMap<>();
    }

    private final void armStreamOpenWatchdog(String str, IInferenceCallback iInferenceCallback, int i10, String str2, ContentParams contentParams) {
        Job jobPut = this.streamOpenWatchdogs.put(str, BuildersKt__Builders_commonKt.launch$default(this.host.getAbilityScope(), null, null, new AsrRealtimeBinderCoordinator$armStreamOpenWatchdog$job$1(CloudConfigBootstrap.INSTANCE.get().getWatchdog().getSessionOpenTimeoutMs(), this, str, iInferenceCallback, i10, str2, contentParams, null), 3, null));
        if (jobPut != null) {
            Job.DefaultImpls.cancel$default(jobPut, null, 1, null);
        }
    }

    private final void bindCloudAsrCorrelation(String str, int i10, String str2, ContentParams contentParams) {
        ModelCallBridge modelCallBridge = ModelCallBridge.INSTANCE;
        String abilityId = this.host.getAbilityId();
        String modelId = this.host.getModelId();
        if (str2 == null) {
            str2 = "";
        }
        modelCallBridge.bindCloud(str, abilityId, modelId, i10, str2, CloudTransport.WEBSOCKET, TraceIdExtractorKt.extractBusinessTraceId(contentParams));
    }

    private final void bindLocalAsrFlywheel(String str, int i10, String str2, ContentParams contentParams) {
        ModelCallBridge modelCallBridge = ModelCallBridge.INSTANCE;
        String abilityId = this.host.getAbilityId();
        String modelId = this.host.getModelId();
        if (str2 == null) {
            str2 = "";
        }
        ModelCallBridge.bindEdge$default(modelCallBridge, str, abilityId, modelId, i10, str2, TraceIdExtractorKt.extractBusinessTraceId(contentParams), null, 64, null);
    }

    private final void cancelAllStreamOpenWatchdogs() {
        Collection<Job> collectionValues = this.streamOpenWatchdogs.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), null, 1, null);
        }
        this.streamOpenWatchdogs.clear();
    }

    private final void cancelStreamOpenWatchdog(String str) {
        Job jobRemove = this.streamOpenWatchdogs.remove(str);
        if (jobRemove != null) {
            Job.DefaultImpls.cancel$default(jobRemove, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object closeActiveCloudAndAwait(qb.b<? super lb.n> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$closeActiveCloudAndAwait$1 r0 = (com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$closeActiveCloudAndAwait$1 r0 = new com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$closeActiveCloudAndAwait$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r10 = r0.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r0 = r0.L$0
            com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator r0 = (com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator) r0
            kotlin.c.b(r11)     // Catch: java.lang.Throwable -> L32
            r2 = r10
            r10 = r0
            goto La7
        L32:
            r11 = move-exception
            r2 = r10
            r10 = r0
            goto Lae
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3e:
            kotlin.c.b(r11)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$CloudWsHolder> r11 = r10.cloudWsSessions
            java.util.Set r11 = r11.entrySet()
            java.lang.String r2 = "<get-entries>(...)"
            kotlin.jvm.internal.g.e(r11, r2)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r11 = kotlin.collections.a.u0(r11)
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            if (r11 != 0) goto L59
            lb.n r10 = lb.n.f10413a
            return r10
        L59:
            java.lang.Object r2 = r11.getKey()
            java.lang.String r4 = "<get-key>(...)"
            kotlin.jvm.internal.g.e(r2, r4)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r11 = r11.getValue()
            java.lang.String r4 = "<get-value>(...)"
            kotlin.jvm.internal.g.e(r11, r4)
            com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$CloudWsHolder r11 = (com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.CloudWsHolder) r11
            com.stepos.core.ability.speech.StreamingCapableAbility r4 = r10.streamingAbility
            long r4 = r4.cloudCloseAckTimeoutMs()
            com.stepos.core.common.log.LogModule r6 = com.stepos.core.common.log.LogModule.ABILITY
            com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$Host r7 = r10.host
            java.lang.String r7 = r7.getToken()
            java.lang.String r8 = "closeActiveCloudAndAwait: closing active cloud WS oldInferId="
            java.lang.String r9 = ", await ack(<="
            java.lang.StringBuilder r8 = com.stepos.core.ota.d.l(r8, r4, r2, r9)
            java.lang.String r9 = "ms), token="
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.String r8 = "AsrRealtimeCoordinator"
            com.stepos.core.common.log.AIEngineLogger.i(r6, r8, r7)
            com.stepos.core.ability.speech.AsrCloudWsSession r11 = r11.getSession()     // Catch: java.lang.Throwable -> Lad
            r0.L$0 = r10     // Catch: java.lang.Throwable -> Lad
            r0.L$1 = r2     // Catch: java.lang.Throwable -> Lad
            r0.label = r3     // Catch: java.lang.Throwable -> Lad
            java.lang.Object r11 = r11.closeAndAwait(r4, r0)     // Catch: java.lang.Throwable -> Lad
            if (r11 != r1) goto La7
            return r1
        La7:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Throwable -> Lad
            r11.getClass()     // Catch: java.lang.Throwable -> Lad
            goto Lb1
        Lad:
            r11 = move-exception
        Lae:
            kotlin.c.a(r11)
        Lb1:
            com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$Host r11 = r10.host
            r11.cancelInferJob(r2)
            com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$Host r11 = r10.host
            r11.removeInferJob(r2)
            r10.terminateCloudSession(r2)
            lb.n r10 = lb.n.f10413a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.closeActiveCloudAndAwait(qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collectCloudWsEvents(java.lang.String r17, com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.CloudWsHolder r18, qb.b<? super lb.n> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.collectCloudWsEvents(java.lang.String, com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$CloudWsHolder, qb.b):java.lang.Object");
    }

    private final boolean completeDownstream(String str) {
        this.closeChannelAtNs.put(str, Long.valueOf(SystemClock.elapsedRealtimeNanos()));
        getPcmDumpSink().close(str);
        CloudWsHolder cloudWsHolder = this.cloudWsSessions.get(str);
        if (cloudWsHolder != null) {
            scheduleCloudFinalize(str, cloudWsHolder);
            return true;
        }
        if (this.streamingInferIds.contains(str)) {
            this.pendingFinish.add(str);
            CloudWsHolder cloudWsHolder2 = this.cloudWsSessions.get(str);
            if (cloudWsHolder2 != null && this.pendingFinish.remove(str)) {
                scheduleCloudFinalize(str, cloudWsHolder2);
            }
            return true;
        }
        if (this.streamingBuffer.complete(str) == null) {
            return false;
        }
        if (!this.host.forwardCompleteInput(str)) {
            this.host.decLocalStreamCountIfCounted(str);
            this.closeChannelAtNs.remove(str);
            this.host.scheduleIdleTransition();
        }
        return true;
    }

    private final String devReasonOf(String str) {
        return ai.onnxruntime.a.k("ASR streaming ", str);
    }

    private final void disposeReorderBuffer(String str) {
        AsrFeedReorderBuffer asrFeedReorderBufferRemove = this.reorderBuffers.remove(str);
        if (asrFeedReorderBufferRemove != null) {
            asrFeedReorderBufferRemove.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0054 -> B:22:0x0057). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object drainCloudOpenLatest(qb.b<? super lb.n> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.C03251
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$drainCloudOpenLatest$1 r0 = (com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.C03251) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$drainCloudOpenLatest$1 r0 = new com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$drainCloudOpenLatest$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$1
            com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$PendingCloudOpen r6 = (com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.PendingCloudOpen) r6
            java.lang.Object r2 = r0.L$0
            com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator r2 = (com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator) r2
            kotlin.c.b(r7)
            r7 = r6
            r6 = r2
            goto L57
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.c.b(r7)
        L3c:
            java.util.concurrent.atomic.AtomicReference<com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$PendingCloudOpen> r7 = r6.pendingCloudOpen
            r2 = 0
            java.lang.Object r7 = r7.getAndSet(r2)
            com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$PendingCloudOpen r7 = (com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.PendingCloudOpen) r7
            if (r7 != 0) goto L4a
            lb.n r6 = lb.n.f10413a
            return r6
        L4a:
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r2 = r6.closeActiveCloudAndAwait(r0)
            if (r2 != r1) goto L57
            return r1
        L57:
            java.util.concurrent.atomic.AtomicReference<com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$PendingCloudOpen> r2 = r6.pendingCloudOpen
            java.lang.Object r2 = r2.get()
            com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$PendingCloudOpen r2 = (com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.PendingCloudOpen) r2
            if (r2 == 0) goto L90
            if (r2 == r7) goto L90
            java.lang.String r4 = r2.getInferId()
            java.lang.String r5 = r7.getInferId()
            boolean r4 = kotlin.jvm.internal.g.b(r4, r5)
            if (r4 != 0) goto L77
            java.lang.String r2 = "superseded during close-wait"
            r6.emitSupersededCancel(r7, r2)
            goto L3c
        L77:
            com.stepos.core.common.log.LogModule r0 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r1 = r7.getInferId()
            com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator$Host r3 = r6.host
            java.lang.String r3 = r3.getToken()
            java.lang.String r4 = "drainCloudOpenLatest: duplicate inferId="
            java.lang.String r5 = " during close-wait, idempotent, token="
            java.lang.String r1 = ai.onnxruntime.a.l(r4, r1, r5, r3)
            java.lang.String r3 = "AsrRealtimeCoordinator"
            com.stepos.core.common.log.AIEngineLogger.d(r0, r3, r1)
        L90:
            if (r2 == 0) goto La1
            java.lang.String r0 = r2.getInferId()
            java.lang.String r1 = r7.getInferId()
            boolean r0 = kotlin.jvm.internal.g.b(r0, r1)
            if (r0 == 0) goto La1
            r7 = r2
        La1:
            r6.startCloudSessionNow(r7)
            lb.n r6 = lb.n.f10413a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.drainCloudOpenLatest(qb.b):java.lang.Object");
    }

    private final void drainPendingCloudOpen(String str) {
        PendingCloudOpen andSet = this.pendingCloudOpen.getAndSet(null);
        if (andSet != null) {
            emitSupersededCancel(andSet, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean emitCloudTerminal(String str, CloudWsHolder cloudWsHolder, InferResult inferResult) {
        if (!cloudWsHolder.getTerminalEmitted().compareAndSet(false, true)) {
            return false;
        }
        ModelCallBridge modelCallBridge = ModelCallBridge.INSTANCE;
        modelCallBridge.mergeSessionState(str, cloudWsHolder.getSession().correlationState());
        ModelCallBridge.reportTerminal$default(modelCallBridge, str, inferResult, null, 4, null);
        cloudWsHolder.getHandler().onResult(str, inferResult);
        return true;
    }

    private final void emitSupersededCancel(PendingCloudOpen pendingCloudOpen, String str, int i10, String str2) {
        String inferId = pendingCloudOpen.getInferId();
        this.streamingInferIds.remove(inferId);
        this.pendingFinish.remove(inferId);
        disposeReorderBuffer(inferId);
        this.streamingBuffer.takePending(inferId);
        this.host.endAicScene(inferId);
        this.host.onInferTerminal(inferId);
        IInferenceCallback callback = pendingCloudOpen.getCallback();
        if (callback != null) {
            new BinderResultHandler(callback).onResult(inferId, new InferResult.Error(i10, str2));
        }
        ModelCallBridge.reportTerminal$default(ModelCallBridge.INSTANCE, inferId, new InferResult.Error(i10, devReasonOf(str)), null, 4, null);
        AIEngineLogger.i(LogModule.ABILITY, TAG, ai.onnxruntime.a.p(h0.e.f("emitSupersededCancel: inferId=", inferId, ", code=", i10, ", "), str, ", token=", this.host.getToken()));
        this.host.scheduleIdleTransition();
    }

    private final void ensureCloudActor() {
        if (this.cloudActorStarted.compareAndSet(false, true)) {
            BuildersKt__Builders_commonKt.launch$default(this.host.getAbilityScope(), null, null, new C03261(null), 3, null);
        }
    }

    private final AsrFeedReorderBuffer ensureReorderBuffer(String str) {
        int i10 = 1;
        AsrFeedReorderBuffer asrFeedReorderBufferComputeIfAbsent = this.reorderBuffers.computeIfAbsent(str, new o0(new com.stepos.aicgroup.f(i10, this, str), i10));
        kotlin.jvm.internal.g.e(asrFeedReorderBufferComputeIfAbsent, "computeIfAbsent(...)");
        return asrFeedReorderBufferComputeIfAbsent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsrFeedReorderBuffer ensureReorderBuffer$lambda$4(AsrRealtimeBinderCoordinator asrRealtimeBinderCoordinator, String str, String it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new AsrFeedReorderBuffer(asrRealtimeBinderCoordinator.getReorderScope(), str, 120L, 200L, 1000L, 16, AsrFeedReorderBuffer.MAX_PENDING_BYTES, new com.stepos.ability.sdk.client.b(3, asrRealtimeBinderCoordinator, str), new android.llama.cpp.b(5, asrRealtimeBinderCoordinator, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n ensureReorderBuffer$lambda$4$lambda$2(AsrRealtimeBinderCoordinator asrRealtimeBinderCoordinator, String str, AudioContent frame) {
        kotlin.jvm.internal.g.f(frame, "frame");
        asrRealtimeBinderCoordinator.feedDownstream(str, frame);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n ensureReorderBuffer$lambda$4$lambda$3(AsrRealtimeBinderCoordinator asrRealtimeBinderCoordinator, String str) {
        asrRealtimeBinderCoordinator.reorderBuffers.remove(str);
        if (!asrRealtimeBinderCoordinator.completeDownstream(str)) {
            asrRealtimeBinderCoordinator.host.forwardCompleteInput(str);
        }
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsrFeedReorderBuffer ensureReorderBuffer$lambda$5(zb.l lVar, Object obj) {
        return (AsrFeedReorderBuffer) lVar.invoke(obj);
    }

    private final boolean feedDownstream(String str, Content content) {
        boolean z = content instanceof AudioContent;
        if (z) {
            AudioContent audioContent = (AudioContent) content;
            if (audioContent.getAudioBytes().length != 0) {
                getPcmDumpSink().feed(str, audioContent, this.cloudWsSessions.containsKey(str) ? "CLOUD" : "LOCAL");
            }
        }
        CloudWsHolder cloudWsHolder = this.cloudWsSessions.get(str);
        if (cloudWsHolder == null) {
            AsrStreamingBuffer.FeedResult feedResultFeed = this.streamingBuffer.feed(str, content);
            if (!(feedResultFeed instanceof AsrStreamingBuffer.FeedResult.Buffered) && !(feedResultFeed instanceof AsrStreamingBuffer.FeedResult.StashedPending) && !(feedResultFeed instanceof AsrStreamingBuffer.FeedResult.DroppedTerminated)) {
                if (feedResultFeed instanceof AsrStreamingBuffer.FeedResult.Forward) {
                    this.host.forwardFeedInput(str, content);
                    return true;
                }
                if (feedResultFeed instanceof AsrStreamingBuffer.FeedResult.NotStreaming) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            }
        } else if (z) {
            AsrCloudWsSession session = cloudWsHolder.getSession();
            AudioContent audioContent2 = (AudioContent) content;
            byte[] audioBytes = audioContent2.getAudioBytes();
            ContentParams params = audioContent2.getParams();
            session.feed(new i7.a(audioBytes, params != null ? params.getInt(AsrParamKeys.REALTIME_FEED_SEQ, -1) : -1));
            return true;
        }
        return true;
    }

    private final AsrPcmDumpSink getPcmDumpSink() {
        return (AsrPcmDumpSink) this.pcmDumpSink$delegate.getValue();
    }

    private final CoroutineScope getReorderScope() {
        return (CoroutineScope) this.reorderScope$delegate.getValue();
    }

    private final void maybeEmitSupersededPendingCloudOpen(PendingCloudOpen pendingCloudOpen, PendingCloudOpen pendingCloudOpen2, String str) {
        if (!kotlin.jvm.internal.g.b(pendingCloudOpen.getInferId(), pendingCloudOpen2.getInferId())) {
            emitSupersededCancel(pendingCloudOpen, str);
            return;
        }
        LogModule logModule = LogModule.ABILITY;
        String inferId = pendingCloudOpen2.getInferId();
        String token = this.host.getToken();
        StringBuilder sbS = ai.onnxruntime.a.s("pendingCloudOpen: duplicate inferId=", inferId, ", skip supersede (", str, "), token=");
        sbS.append(token);
        AIEngineLogger.d(logModule, TAG, sbS.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStreamOpenTimeout(String str, IInferenceCallback iInferenceCallback, int i10, String str2, ContentParams contentParams, long j10) {
        if (this.cloudWsSessions.containsKey(str)) {
            return;
        }
        PendingCloudOpen pendingCloudOpen = this.pendingCloudOpen.get();
        if (pendingCloudOpen != null && kotlin.jvm.internal.g.b(pendingCloudOpen.getInferId(), str)) {
            AtomicReference<PendingCloudOpen> atomicReference = this.pendingCloudOpen;
            while (!atomicReference.compareAndSet(pendingCloudOpen, null) && atomicReference.get() == pendingCloudOpen) {
            }
        }
        this.streamingBuffer.markTerminated(str);
        LogModule logModule = LogModule.ABILITY;
        String token = this.host.getToken();
        StringBuilder sbO = a0.a.o("onStreamOpenTimeout: session not opened in ", j10, "ms, terminating inferId=", str);
        sbO.append(", token=");
        sbO.append(token);
        AIEngineLogger.w(logModule, TAG, sbO.toString());
        emitSupersededCancel(new PendingCloudOpen(str, iInferenceCallback, i10, contentParams, ai.onnxruntime.a.h(j10, "open timeout(", "ms)"), str2), ai.onnxruntime.a.h(j10, "open timeout(", "ms)"), AIEngineError.TIMEOUT, SpeechStreamUserMessage.SESSION_OPEN_TIMEOUT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:57:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object openStreamingSession(java.lang.String r17, com.stepos.core.callback.IInferenceCallback r18, int r19, java.lang.String r20, com.stepos.core.data.ContentParams r21, com.stepos.core.common.telemetry.PowerPerfTracker r22, com.stepos.core.model.task.AITaskRecord r23, qb.b<? super lb.n> r24) {
        /*
            Method dump skipped, instructions count: 876
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator.openStreamingSession(java.lang.String, com.stepos.core.callback.IInferenceCallback, int, java.lang.String, com.stepos.core.data.ContentParams, com.stepos.core.common.telemetry.PowerPerfTracker, com.stepos.core.model.task.AITaskRecord, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n openStreamingSession$lambda$15(AsrRealtimeBinderCoordinator asrRealtimeBinderCoordinator, String str) {
        Long lRemove = asrRealtimeBinderCoordinator.closeChannelAtNs.remove(str);
        if (lRemove != null) {
            a0.a.z(com.stepos.core.ota.d.l("[DIAG] closeChannel(local) DONE: onStreamComplete, inferId=", (SystemClock.elapsedRealtimeNanos() - lRemove.longValue()) / 1000000, str, ", closeChannel→complete cost="), "ms", LogModule.ABILITY, TAG);
        }
        asrRealtimeBinderCoordinator.host.decLocalStreamCountIfCounted(str);
        asrRealtimeBinderCoordinator.host.removeInferJob(str);
        asrRealtimeBinderCoordinator.host.releaseInferSlot(str);
        asrRealtimeBinderCoordinator.host.endAicScene(str);
        asrRealtimeBinderCoordinator.host.scheduleIdleTransition();
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsrPcmDumpSink pcmDumpSink_delegate$lambda$0(AsrRealtimeBinderCoordinator asrRealtimeBinderCoordinator) {
        return new AsrPcmDumpSink(asrRealtimeBinderCoordinator.callerUid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineScope reorderScope_delegate$lambda$1(AsrRealtimeBinderCoordinator asrRealtimeBinderCoordinator) {
        return CoroutineScopeKt.CoroutineScope(asrRealtimeBinderCoordinator.host.getAbilityScope().getCoroutineContext().plus(AsrFeedDispatch.INSTANCE.getDispatcher()));
    }

    private final void scheduleCloudFinalize(final String str, final CloudWsHolder cloudWsHolder) {
        if (!this.cloudFinalizing.add(str)) {
            AIEngineLogger.d(LogModule.ABILITY, TAG, "[DIAG] closeChannel(cloud): finalize already scheduled, inferId=" + str);
            return;
        }
        Long l10 = this.closeChannelAtNs.get(str);
        final long jLongValue = l10 != null ? l10.longValue() : SystemClock.elapsedRealtimeNanos();
        zb.p pVar = new zb.p() { // from class: com.stepos.core.ability.speech.r
            @Override // zb.p
            public final Object invoke(Object obj, Object obj2) {
                return AsrRealtimeBinderCoordinator.scheduleCloudFinalize$lambda$17(this.f7333a, str, cloudWsHolder, jLongValue, (String) obj, (InferResult) obj2);
            }
        };
        if (cloudWsHolder.getSession().hasEverOpened()) {
            CloudTransportConfig.Watchdog watchdog = CloudConfigBootstrap.INSTANCE.get().getWatchdog();
            boolean zIsManualCommitMode = cloudWsHolder.getSession().isManualCommitMode();
            long manualCommitGraceMs = zIsManualCommitMode ? watchdog.getManualCommitGraceMs() : watchdog.getFinishGraceMs();
            LogModule logModule = LogModule.ABILITY;
            StringBuilder sbL = com.stepos.core.ota.d.l("[DIAG] closeChannel(cloud): finish() sent (", manualCommitGraceMs, zIsManualCommitMode ? "manual commit" : "silence tail", "), waiting endOfTurn or grace=");
            sbL.append("ms, inferId=");
            sbL.append(str);
            AIEngineLogger.i(logModule, TAG, sbL.toString());
            cloudWsHolder.getSession().finish();
            BuildersKt__Builders_commonKt.launch$default(this.host.getAbilityScope(), null, null, new C03292(manualCommitGraceMs, pVar, null), 3, null);
            return;
        }
        if (!cloudWsHolder.getSession().isHandshakeInFlight()) {
            int iNoResultTerminalCode = cloudWsHolder.getSession().noResultTerminalCode();
            LogModule logModule2 = LogModule.ABILITY;
            String token = this.host.getToken();
            StringBuilder sbE = h0.e.e("[DIAG] closeChannel(cloud): ws never opened, skip grace & fail fast, code=", iNoResultTerminalCode, ", inferId=", str, ", token=");
            sbE.append(token);
            AIEngineLogger.w(logModule2, TAG, sbE.toString());
            pVar.invoke(ai.onnxruntime.a.j(")", iNoResultTerminalCode, new StringBuilder("no-ws-open(code=")), new InferResult.Error(iNoResultTerminalCode, CloudErrorUserMessage.INSTANCE.of(iNoResultTerminalCode)));
            return;
        }
        long closeWaitOpenMs = CloudConfigBootstrap.INSTANCE.get().getWatchdog().getCloseWaitOpenMs();
        LogModule logModule3 = LogModule.ABILITY;
        String token2 = this.host.getToken();
        StringBuilder sbO = a0.a.o("[DIAG] closeChannel(cloud): ws handshake in flight, wait ", closeWaitOpenMs, "ms for open then finish, inferId=", str);
        sbO.append(", token=");
        sbO.append(token2);
        AIEngineLogger.i(logModule3, TAG, sbO.toString());
        cloudWsHolder.getSession().finish();
        BuildersKt__Builders_commonKt.launch$default(this.host.getAbilityScope(), null, null, new C03281(cloudWsHolder, closeWaitOpenMs, str, this, pVar, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n scheduleCloudFinalize$lambda$17(AsrRealtimeBinderCoordinator asrRealtimeBinderCoordinator, String str, CloudWsHolder cloudWsHolder, long j10, String source, InferResult result) {
        kotlin.jvm.internal.g.f(source, "source");
        kotlin.jvm.internal.g.f(result, "result");
        if (asrRealtimeBinderCoordinator.emitCloudTerminal(str, cloudWsHolder, result)) {
            AIEngineLogger.i(LogModule.ABILITY, TAG, ai.onnxruntime.a.m(ai.onnxruntime.a.s("[DIAG] closeChannel(cloud) DONE via ", source, ": inferId=", str, ", closeChannel→terminal cost="), (SystemClock.elapsedRealtimeNanos() - j10) / 1000000, "ms"));
            asrRealtimeBinderCoordinator.closeChannelAtNs.remove(str);
            asrRealtimeBinderCoordinator.host.cancelInferJob(str);
        }
        return lb.n.f10413a;
    }

    private final void startCloudIdleWatchdog(String str, CloudWsHolder cloudWsHolder) {
        BuildersKt__Builders_commonKt.launch$default(this.host.getAbilityScope(), null, null, new C03301(str, cloudWsHolder, CloudConfigBootstrap.INSTANCE.get().getWatchdog(), null), 3, null);
    }

    private final void startCloudSessionNow(PendingCloudOpen pendingCloudOpen) {
        final String inferId = pendingCloudOpen.getInferId();
        if (this.streamingBuffer.isTerminated(inferId)) {
            cancelStreamOpenWatchdog(inferId);
            ai.onnxruntime.a.w("startCloudSessionNow: aborted, already terminated by open watchdog, inferId=", inferId, LogModule.ABILITY, TAG);
            return;
        }
        String strExtractTraceId = TraceIdExtractorKt.extractTraceId(pendingCloudOpen.getParams());
        LogModule logModule = LogModule.ABILITY;
        AIEngineLogger.i(logModule, TAG, ai.onnxruntime.a.l("[TRACE] ASR startCloudSessionNow: businessTraceId=", strExtractTraceId == null ? "<none>" : strExtractTraceId, ", inferId=", inferId));
        try {
            final AsrCloudWsSession asrCloudWsSessionCreateCloudWsSession = this.streamingAbility.createCloudWsSession(pendingCloudOpen.getCallerPkg(), strExtractTraceId, pendingCloudOpen.getParams());
            if (asrCloudWsSessionCreateCloudWsSession == null) {
                ai.onnxruntime.a.w("startCloudSessionNow: cloud config missing, inferId=", inferId, logModule, TAG);
                cancelStreamOpenWatchdog(inferId);
                emitSupersededCancel(pendingCloudOpen, "cloud ASR not configured", AIEngineError.CLOUD_ENDPOINT_NOT_CONFIGURED, CloudErrorUserMessage.INSTANCE.of(AIEngineError.CLOUD_ENDPOINT_NOT_CONFIGURED));
                return;
            }
            asrCloudWsSessionCreateCloudWsSession.setOnCorrelationEstablished(new t(inferId, 2));
            BinderResultHandler binderResultHandler = new BinderResultHandler(pendingCloudOpen.getCallback());
            AsrSegmentationResolver asrSegmentationResolver = AsrSegmentationResolver.INSTANCE;
            int iMaxCharsFor = asrSegmentationResolver.maxCharsFor(this.streamingAbility.segmentationConfig(), pendingCloudOpen.getCallerPkg(), pendingCloudOpen.getParams(), ApplyScope.f6190c);
            int i10 = asrSegmentationResolver.resolve(this.streamingAbility.segmentationConfig(), pendingCloudOpen.getCallerPkg(), pendingCloudOpen.getParams()).f11444b;
            final CloudWsHolder cloudWsHolder = new CloudWsHolder(asrCloudWsSessionCreateCloudWsSession, pendingCloudOpen.getCallerUid(), binderResultHandler, pendingCloudOpen.getCallback(), iMaxCharsFor, i10);
            String callerPkg = pendingCloudOpen.getCallerPkg();
            boolean z = iMaxCharsFor > 0;
            StringBuilder sbF = h0.e.f("[DIAG] segmentation(cloud): pkg=", callerPkg, ", maxChars=", iMaxCharsFor, ", window=");
            sbF.append(i10);
            sbF.append(", enabled=");
            sbF.append(z);
            sbF.append(", inferId=");
            a0.a.z(sbF, inferId, logModule, TAG);
            cancelStreamOpenWatchdog(inferId);
            this.host.incActiveInference();
            this.host.putInferJob(inferId, BuildersKt__Builders_commonKt.launch$default(this.host.getAbilityScope(), null, null, new AsrRealtimeBinderCoordinator$startCloudSessionNow$collectJob$1(this, inferId, cloudWsHolder, null), 3, null));
            startCloudIdleWatchdog(inferId, cloudWsHolder);
            final AsrFeedReorderBuffer asrFeedReorderBuffer = this.reorderBuffers.get(inferId);
            zb.a aVar = new zb.a() { // from class: com.stepos.core.ability.speech.q
                @Override // zb.a
                public final Object invoke() {
                    return AsrRealtimeBinderCoordinator.startCloudSessionNow$lambda$22(this.f7328a, inferId, cloudWsHolder, asrFeedReorderBuffer, asrCloudWsSessionCreateCloudWsSession);
                }
            };
            if (asrFeedReorderBuffer != null) {
                asrFeedReorderBuffer.withDeliverySuspended(aVar);
            } else {
                aVar.invoke();
            }
            asrCloudWsSessionCreateCloudWsSession.start();
            this.streamingInferIds.remove(inferId);
            if (this.pendingFinish.remove(inferId)) {
                scheduleCloudFinalize(inferId, cloudWsHolder);
                AIEngineLogger.d(logModule, TAG, "startCloudSessionNow: applied deferred finish, inferId=" + inferId);
            }
            AIEngineLogger.i(logModule, TAG, ai.onnxruntime.a.l("startCloudSessionNow: CLOUD WS started, inferId=", inferId, ", token=", this.host.getToken()));
        } catch (OrchestrationRejectedException e10) {
            LogModule logModule2 = LogModule.ABILITY;
            String strDetailMessage = e10.f6395b;
            AIEngineLogger.w(logModule2, TAG, ai.onnxruntime.a.l("startCloudSessionNow: scene_type denied (", strDetailMessage, "), inferId=", inferId));
            cancelStreamOpenWatchdog(inferId);
            if (strDetailMessage == null) {
                strDetailMessage = CloudSceneTypeGuard.INSTANCE.detailMessage(this.host.getAbilityId(), pendingCloudOpen.getCallerPkg());
            }
            CloudErrorUserMessage cloudErrorUserMessage = CloudErrorUserMessage.INSTANCE;
            int i11 = e10.f6394a;
            emitSupersededCancel(pendingCloudOpen, strDetailMessage, i11, cloudErrorUserMessage.of(i11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n startCloudSessionNow$lambda$20(String str, CloudSessionCorrelationState state) {
        kotlin.jvm.internal.g.f(state, "state");
        ModelCallBridge.INSTANCE.logEstablished(str, state);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final lb.n startCloudSessionNow$lambda$22(AsrRealtimeBinderCoordinator asrRealtimeBinderCoordinator, String str, CloudWsHolder cloudWsHolder, AsrFeedReorderBuffer asrFeedReorderBuffer, AsrCloudWsSession asrCloudWsSession) {
        asrRealtimeBinderCoordinator.cloudWsSessions.put(str, cloudWsHolder);
        Iterator<T> it = asrRealtimeBinderCoordinator.streamingBuffer.takePendingWithSeq(str).iterator();
        int i10 = -1;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            int iIntValue = ((Number) pair.f9985a).intValue();
            asrCloudWsSession.feed(new i7.a((byte[]) pair.f9986b, iIntValue));
            if (iIntValue > i10) {
                i10 = iIntValue;
            }
        }
        if (i10 >= 0 && asrFeedReorderBuffer != null) {
            asrFeedReorderBuffer.advancePast(i10);
        }
        return lb.n.f10413a;
    }

    private final void terminateAllCloudSessions() {
        for (String str : this.cloudWsSessions.keySet()) {
            kotlin.jvm.internal.g.e(str, "next(...)");
            terminateCloudSession(str);
        }
    }

    private final void terminateCloudSession(String str) {
        cancelStreamOpenWatchdog(str);
        disposeReorderBuffer(str);
        this.streamingInferIds.remove(str);
        this.pendingFinish.remove(str);
        this.cloudFinalizing.remove(str);
        this.closeChannelAtNs.remove(str);
        getPcmDumpSink().close(str);
        CloudWsHolder cloudWsHolderRemove = this.cloudWsSessions.remove(str);
        if (cloudWsHolderRemove == null) {
            return;
        }
        try {
            cloudWsHolderRemove.getSession().cancel();
            lb.n nVar = lb.n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        emitCloudTerminal(str, cloudWsHolderRemove, new InferResult.Error(-100, "cloud ASR session released"));
        this.host.endAicScene(str);
        this.host.onInferTerminal(str);
        AIEngineLogger.d(LogModule.ABILITY, TAG, ai.onnxruntime.a.l("terminateCloudSession: inferId=", str, ", token=", this.host.getToken()));
    }

    public static /* synthetic */ boolean tryHandleStreamingInferStart$default(AsrRealtimeBinderCoordinator asrRealtimeBinderCoordinator, String str, Content content, IInferenceCallback iInferenceCallback, int i10, String str2, boolean z, PowerPerfTracker powerPerfTracker, AITaskRecord aITaskRecord, int i11, Object obj) {
        if ((i11 & 64) != 0) {
            powerPerfTracker = null;
        }
        if ((i11 & TraceIdKeys.MAX_LENGTH) != 0) {
            aITaskRecord = null;
        }
        return asrRealtimeBinderCoordinator.tryHandleStreamingInferStart(str, content, iInferenceCallback, i10, str2, z, powerPerfTracker, aITaskRecord);
    }

    public final void cancelAll() {
        cancelAllStreamOpenWatchdogs();
        terminateAllCloudSessions();
        drainPendingCloudOpen("cancelAll");
        this.streamingInferIds.clear();
        this.pendingFinish.clear();
        this.streamingBuffer.cancelAll();
        Set<String> setKeySet = this.reorderBuffers.keySet();
        kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
        for (String str : kotlin.collections.a.O0(setKeySet)) {
            kotlin.jvm.internal.g.c(str);
            disposeReorderBuffer(str);
        }
        getPcmDumpSink().closeAll();
    }

    public final boolean isStreamingStart(Content input) {
        kotlin.jvm.internal.g.f(input, "input");
        return this.streamingBuffer.isStreamingSignal(input);
    }

    public final void releaseClose() {
        cancelAll();
        SendChannel.DefaultImpls.close$default(this.cloudOpenWakeups, null, 1, null);
    }

    public final boolean tryHandleCancelInfer(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        if (this.cloudWsSessions.containsKey(inferId)) {
            cancelStreamOpenWatchdog(inferId);
            disposeReorderBuffer(inferId);
            this.host.releaseInferSlot(inferId);
            getPcmDumpSink().close(inferId);
            this.host.cancelInferJob(inferId);
            this.streamingBuffer.clearTerminated(inferId);
            return true;
        }
        if (!this.streamingInferIds.contains(inferId)) {
            return false;
        }
        cancelStreamOpenWatchdog(inferId);
        disposeReorderBuffer(inferId);
        PendingCloudOpen pendingCloudOpen = this.pendingCloudOpen.get();
        if (pendingCloudOpen == null || !kotlin.jvm.internal.g.b(pendingCloudOpen.getInferId(), inferId)) {
            this.streamingInferIds.remove(inferId);
            this.pendingFinish.remove(inferId);
            this.streamingBuffer.takePending(inferId);
            this.host.releaseInferSlot(inferId);
            getPcmDumpSink().close(inferId);
            this.host.endAicScene(inferId);
            this.host.scheduleIdleTransition();
            break;
        }
        AtomicReference<PendingCloudOpen> atomicReference = this.pendingCloudOpen;
        while (!atomicReference.compareAndSet(pendingCloudOpen, null)) {
            if (atomicReference.get() != pendingCloudOpen) {
                this.streamingInferIds.remove(inferId);
                this.pendingFinish.remove(inferId);
                this.streamingBuffer.takePending(inferId);
                this.host.releaseInferSlot(inferId);
                getPcmDumpSink().close(inferId);
                this.host.endAicScene(inferId);
                this.host.scheduleIdleTransition();
                break;
            }
        }
        emitSupersededCancel(pendingCloudOpen, "cancelled");
        this.streamingBuffer.clearTerminated(inferId);
        return true;
    }

    public final boolean tryHandleCompleteInput(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        AsrFeedReorderBuffer asrFeedReorderBuffer = this.reorderBuffers.get(inferId);
        if (asrFeedReorderBuffer == null) {
            return completeDownstream(inferId);
        }
        asrFeedReorderBuffer.markCompleted();
        return true;
    }

    public final boolean tryHandleFeedInput(String inferId, Content input) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(input, "input");
        AsrFeedReorderBuffer asrFeedReorderBuffer = this.reorderBuffers.get(inferId);
        if (asrFeedReorderBuffer == null || !(input instanceof AudioContent)) {
            return feedDownstream(inferId, input);
        }
        AudioContent audioContent = (AudioContent) input;
        ContentParams params = audioContent.getParams();
        if (params == null || !params.getBoolean(AsrParamKeys.REALTIME_FEED_EOF, false)) {
            if (!(audioContent.getAudioBytes().length == 0)) {
                asrFeedReorderBuffer.offer(params != null ? params.getInt(AsrParamKeys.REALTIME_FEED_SEQ, -1) : -1, audioContent);
            }
        } else {
            asrFeedReorderBuffer.markTotal(params.getInt(AsrParamKeys.REALTIME_FEED_TOTAL, -1));
        }
        return true;
    }

    public final boolean tryHandleStreamingInferStart(String inferId, Content input, IInferenceCallback iInferenceCallback, int i10, String str, boolean z, PowerPerfTracker powerPerfTracker, AITaskRecord aITaskRecord) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(input, "input");
        if (!this.streamingBuffer.isStreamingSignal(input)) {
            return false;
        }
        this.host.markActive();
        if (!this.streamingInferIds.add(inferId)) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, ai.onnxruntime.a.l("duplicate streaming inferId=", inferId, " ignored, token=", this.host.getToken()));
            return true;
        }
        AudioContent audioContent = input instanceof AudioContent ? (AudioContent) input : null;
        ContentParams params = audioContent != null ? audioContent.getParams() : null;
        if (params != null && params.getBoolean(AsrParamKeys.REALTIME_FEED_ORDERED, false)) {
            ensureReorderBuffer(inferId);
        }
        this.host.startAicScene(inferId, z);
        armStreamOpenWatchdog(inferId, iInferenceCallback, i10, str, params);
        BuildersKt__Builders_commonKt.launch$default(this.host.getAbilityScope(), null, null, new C03311(inferId, iInferenceCallback, i10, str, params, powerPerfTracker, aITaskRecord, null), 3, null);
        return true;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class CloudWsHolder {
        private final IInferenceCallback callback;
        private final int callerUid;
        private final BinderResultHandler handler;
        private final AtomicLong lastEventNs;
        private final int segMaxChars;
        private final int segPunctWindow;
        private final AsrCloudWsSession session;
        private final AtomicBoolean terminalEmitted;

        public CloudWsHolder(AsrCloudWsSession session, int i10, BinderResultHandler handler, IInferenceCallback iInferenceCallback, int i11, int i12) {
            kotlin.jvm.internal.g.f(session, "session");
            kotlin.jvm.internal.g.f(handler, "handler");
            this.session = session;
            this.callerUid = i10;
            this.handler = handler;
            this.callback = iInferenceCallback;
            this.segMaxChars = i11;
            this.segPunctWindow = i12;
            this.lastEventNs = new AtomicLong(SystemClock.elapsedRealtimeNanos());
            this.terminalEmitted = new AtomicBoolean(false);
        }

        public final IInferenceCallback getCallback() {
            return this.callback;
        }

        public final int getCallerUid() {
            return this.callerUid;
        }

        public final BinderResultHandler getHandler() {
            return this.handler;
        }

        public final AtomicLong getLastEventNs() {
            return this.lastEventNs;
        }

        public final int getSegMaxChars() {
            return this.segMaxChars;
        }

        public final int getSegPunctWindow() {
            return this.segPunctWindow;
        }

        public final AsrCloudWsSession getSession() {
            return this.session;
        }

        public final AtomicBoolean getTerminalEmitted() {
            return this.terminalEmitted;
        }

        public /* synthetic */ CloudWsHolder(AsrCloudWsSession asrCloudWsSession, int i10, BinderResultHandler binderResultHandler, IInferenceCallback iInferenceCallback, int i11, int i12, int i13, kotlin.jvm.internal.e eVar) {
            this(asrCloudWsSession, i10, binderResultHandler, iInferenceCallback, (i13 & 16) != 0 ? 0 : i11, (i13 & 32) != 0 ? 0 : i12);
        }
    }

    private final void emitSupersededCancel(PendingCloudOpen pendingCloudOpen, String str) {
        emitSupersededCancel(pendingCloudOpen, str, -100, devReasonOf(str));
    }
}
