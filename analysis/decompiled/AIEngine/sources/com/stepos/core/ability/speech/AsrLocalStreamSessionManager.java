package com.stepos.core.ability.speech;

import com.stepos.base.concurrency.data.PoolType;
import com.stepos.base.protocol.AsrFeedKind;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.ability.converter.AbilityOutputConverter;
import com.stepos.core.ability.handler.BinderResultHandler;
import com.stepos.core.ability.handler.InferResult;
import com.stepos.core.ability.telemetry.ModelCallBridge;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.telemetry.PowerPerfTracker;
import com.stepos.core.common.telemetry.TrackerContext;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.data.AudioContent;
import com.stepos.core.model.task.AITaskRecord;
import e7.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrLocalStreamSessionManager {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String EVENT_DELTA = "asr.delta";

    @Deprecated
    public static final String EVENT_RECOGNIZED = "asr.recognized";

    @Deprecated
    public static final int LOCAL_FEED_CHANNEL_CAPACITY = 64;

    @Deprecated
    public static final long LOCAL_FEED_LOG_WINDOW = 16;
    private final zb.a<e7.a> audioProtocolProvider;
    private final ConcurrentHashMap<String, LocalStreamSession> localStreamSessions;
    private final AbilityOutputConverter streamOutputConverter;
    private final CoroutineScope streamScope;
    private final String tag;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrLocalStreamSessionManager", f = "AsrLocalStreamSessionManager.kt", l = {306}, m = "feedFrame")
    /* renamed from: com.stepos.core.ability.speech.AsrLocalStreamSessionManager$feedFrame$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrLocalStreamSessionManager.this.feedFrame(null, null, 0, false, null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrLocalStreamSessionManager$registerLocalStreamingSession$1", f = "AsrLocalStreamSessionManager.kt", l = {98}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrLocalStreamSessionManager$registerLocalStreamingSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03171 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ String $inferId;
        final /* synthetic */ LocalStreamSession $session;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03171(String str, LocalStreamSession localStreamSession, qb.b<? super C03171> bVar) {
            super(2, bVar);
            this.$inferId = str;
            this.$session = localStreamSession;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return AsrLocalStreamSessionManager.this.new C03171(this.$inferId, this.$session, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                AsrLocalStreamSessionManager asrLocalStreamSessionManager = AsrLocalStreamSessionManager.this;
                String str = this.$inferId;
                LocalStreamSession localStreamSession = this.$session;
                this.label = 1;
                if (asrLocalStreamSessionManager.runLocalStreamConsumer(str, localStreamSession, this) == coroutineSingletons) {
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
            return ((C03171) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrLocalStreamSessionManager", f = "AsrLocalStreamSessionManager.kt", l = {386}, m = "releaseAndJoin")
    /* renamed from: com.stepos.core.ability.speech.AsrLocalStreamSessionManager$releaseAndJoin$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03181 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03181(qb.b<? super C03181> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrLocalStreamSessionManager.this.releaseAndJoin(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrLocalStreamSessionManager", f = "AsrLocalStreamSessionManager.kt", l = {219, 248, 270}, m = "runLocalStreamConsumer")
    /* renamed from: com.stepos.core.ability.speech.AsrLocalStreamSessionManager$runLocalStreamConsumer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03191 extends ContinuationImpl {
        double D$0;
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C03191(qb.b<? super C03191> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrLocalStreamSessionManager.this.runLocalStreamConsumer(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AsrLocalStreamSessionManager(String tag, zb.a<? extends e7.a> audioProtocolProvider) {
        kotlin.jvm.internal.g.f(tag, "tag");
        kotlin.jvm.internal.g.f(audioProtocolProvider, "audioProtocolProvider");
        this.tag = tag;
        this.audioProtocolProvider = audioProtocolProvider;
        this.localStreamSessions = new ConcurrentHashMap<>();
        this.streamScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(AsrNativeDispatch.INSTANCE.getDispatcher()));
        this.streamOutputConverter = new AbilityOutputConverter();
    }

    private final double chunkRms(byte[] bArr) {
        int i10 = 0;
        int i11 = 0;
        double d8 = 0.0d;
        while (true) {
            int i12 = i10 + 1;
            if (i12 >= bArr.length) {
                break;
            }
            double d10 = (short) ((bArr[i12] << 8) | (bArr[i10] & 255));
            d8 += d10 * d10;
            i11++;
            i10 += 2;
        }
        if (i11 > 0) {
            return Math.sqrt(d8 / i11);
        }
        return 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitLocalStreamChunk(String str, BinderResultHandler binderResultHandler, String str2, long j10, long j11, boolean z, int i10, String str3) {
        if (str2.length() == 0) {
            return;
        }
        ModelCallBridge.INSTANCE.recordFirstToken(str);
        binderResultHandler.onResult(str, new InferResult.Output(this.streamOutputConverter.convert(new d.a(str2, j10, j11, z, i10, str3, z ? "asr.recognized" : "asr.delta"))));
    }

    public static /* synthetic */ void emitLocalStreamChunk$default(AsrLocalStreamSessionManager asrLocalStreamSessionManager, String str, BinderResultHandler binderResultHandler, String str2, long j10, long j11, boolean z, int i10, String str3, int i11, Object obj) {
        asrLocalStreamSessionManager.emitLocalStreamChunk(str, binderResultHandler, str2, j10, j11, z, (i11 & 64) != 0 ? 0 : i10, (i11 & TraceIdKeys.MAX_LENGTH) != 0 ? "" : str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a3 A[Catch: Exception -> 0x00a9, TRY_LEAVE, TryCatch #3 {Exception -> 0x00a9, blocks: (B:37:0x009b, B:39:0x00a3, B:34:0x0090), top: B:59:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object feedFrame(final e7.a r17, byte[] r18, int r19, final boolean r20, e7.a.InterfaceC0076a r21, java.lang.String r22, final com.stepos.core.ability.speech.AsrLocalStreamSessionManager.LocalStreamSession r23, qb.b<? super lb.n> r24) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrLocalStreamSessionManager.feedFrame(e7.a, byte[], int, boolean, e7.a$a, java.lang.String, com.stepos.core.ability.speech.AsrLocalStreamSessionManager$LocalStreamSession, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean feedFrame$lambda$6(LocalStreamSession localStreamSession, e7.a aVar, c.a aVar2, boolean z, a.InterfaceC0076a interfaceC0076a) {
        TrackerContext.Key key = TrackerContext.Key;
        PowerPerfTracker tracker = localStreamSession.getTracker();
        Object obj = key.getThreadLocal().get();
        key.getThreadLocal().set(tracker);
        try {
            boolean zFeedAudioFrame = aVar.feedAudioFrame(aVar2, z, interfaceC0076a, AsrFeedKind.f6375a);
            ThreadLocal<Object> threadLocal = key.getThreadLocal();
            if (obj == null) {
                threadLocal.remove();
                return zFeedAudioFrame;
            }
            threadLocal.set(obj);
            return zFeedAudioFrame;
        } catch (Throwable th) {
            ThreadLocal<Object> threadLocal2 = key.getThreadLocal();
            if (obj == null) {
                threadLocal2.remove();
            } else {
                threadLocal2.set(obj);
            }
            throw th;
        }
    }

    private final void finishLocalStream(String str) {
        LocalStreamSession localStreamSessionRemove = this.localStreamSessions.remove(str);
        if (localStreamSessionRemove == null) {
            return;
        }
        try {
            SendChannel.DefaultImpls.close$default(localStreamSessionRemove.getChannel(), null, 1, null);
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        LogModule logModule = LogModule.ABILITY;
        String str2 = this.tag;
        long j10 = localStreamSessionRemove.getEnqueued().get();
        long j11 = localStreamSessionRemove.getConsumed().get();
        long peakBacklog = localStreamSessionRemove.getPeakBacklog();
        StringBuilder sbL = com.stepos.core.ota.d.l("[backpressure] local stream end inferId=", j10, str, " enqueued=");
        a0.a.s(j11, " consumed=", " peakBacklog=", sbL);
        sbL.append(peakBacklog);
        AIEngineLogger.i(logModule, str2, sbL.toString());
        try {
            localStreamSessionRemove.getOnStreamComplete().invoke();
            lb.n nVar = lb.n.f10413a;
        } catch (Throwable th2) {
            kotlin.c.a(th2);
        }
    }

    private final short[] pcmBytesToShorts(byte[] bArr) {
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            sArr[i10] = byteBufferOrder.getShort();
        }
        return sArr;
    }

    public static /* synthetic */ void registerLocalStreamingSession$default(AsrLocalStreamSessionManager asrLocalStreamSessionManager, String str, IInferenceCallback iInferenceCallback, int i10, zb.a aVar, PowerPerfTracker powerPerfTracker, AITaskRecord aITaskRecord, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            powerPerfTracker = null;
        }
        if ((i11 & 32) != 0) {
            aITaskRecord = null;
        }
        asrLocalStreamSessionManager.registerLocalStreamingSession(str, iInferenceCallback, i10, aVar, powerPerfTracker, aITaskRecord);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void reportLocalStreamFlywheelTerminal(java.lang.String r7, com.stepos.core.ability.handler.InferResult r8) {
        /*
            r6 = this;
            com.stepos.core.ability.telemetry.ModelCallBridge r0 = com.stepos.core.ability.telemetry.ModelCallBridge.INSTANCE     // Catch: java.lang.Throwable -> L10
            r4 = 4
            r5 = 0
            r3 = 0
            r1 = r7
            r2 = r8
            com.stepos.core.ability.telemetry.ModelCallBridge.reportTerminal$default(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Ld
            lb.n r7 = lb.n.f10413a     // Catch: java.lang.Throwable -> Ld
            goto L17
        Ld:
            r0 = move-exception
        Le:
            r7 = r0
            goto L13
        L10:
            r0 = move-exception
            r1 = r7
            goto Le
        L13:
            kotlin.Result$Failure r7 = kotlin.c.a(r7)
        L17:
            java.lang.Throwable r7 = kotlin.Result.b(r7)
            if (r7 == 0) goto L30
            com.stepos.core.common.log.LogModule r8 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r6 = r6.tag
            java.lang.String r7 = r7.getMessage()
            java.lang.String r0 = "local stream flywheel terminal failed inferId="
            java.lang.String r2 = ": "
            java.lang.String r7 = ai.onnxruntime.a.l(r0, r1, r2, r7)
            com.stepos.core.common.log.AIEngineLogger.w(r8, r6, r7)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrLocalStreamSessionManager.reportLocalStreamFlywheelTerminal(java.lang.String, com.stepos.core.ability.handler.InferResult):void");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x03d2 -> B:240:0x03f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x02ab -> B:244:0x0233). Please report as a decompilation issue!!! */
    public final java.lang.Object runLocalStreamConsumer(java.lang.String r50, com.stepos.core.ability.speech.AsrLocalStreamSessionManager.LocalStreamSession r51, qb.b<? super lb.n> r52) {
        /*
            Method dump skipped, instructions count: 1551
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrLocalStreamSessionManager.runLocalStreamConsumer(java.lang.String, com.stepos.core.ability.speech.AsrLocalStreamSessionManager$LocalStreamSession, qb.b):java.lang.Object");
    }

    private static final void runLocalStreamConsumer$flushSegment(StringBuilder sb2, AsrLocalStreamSessionManager asrLocalStreamSessionManager, String str, BinderResultHandler binderResultHandler, Ref$LongRef ref$LongRef, Ref$LongRef ref$LongRef2, Ref$IntRef ref$IntRef) {
        if (sb2.length() == 0) {
            return;
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        emitLocalStreamChunk$default(asrLocalStreamSessionManager, str, binderResultHandler, string, ref$LongRef.f10075a, ref$LongRef2.f10075a, true, ref$IntRef.f10074a, null, TraceIdKeys.MAX_LENGTH, null);
        sb2.setLength(0);
        ref$LongRef.f10075a = 0L;
        ref$LongRef2.f10075a = 0L;
        ref$IntRef.f10074a++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n runLocalStreamConsumer$lambda$1(Ref$BooleanRef ref$BooleanRef, BinderResultHandler binderResultHandler, String str, Ref$BooleanRef ref$BooleanRef2, AsrLocalStreamSessionManager asrLocalStreamSessionManager, int i10, String msg) {
        kotlin.jvm.internal.g.f(msg, "msg");
        if (!ref$BooleanRef.f10073a) {
            ref$BooleanRef.f10073a = true;
            InferResult.Error error = new InferResult.Error(i10, msg);
            binderResultHandler.onResult(str, error);
            runLocalStreamConsumer$reportFlywheelTerminal(ref$BooleanRef2, asrLocalStreamSessionManager, str, error);
        }
        return lb.n.f10413a;
    }

    private static final void runLocalStreamConsumer$reportFlywheelTerminal(Ref$BooleanRef ref$BooleanRef, AsrLocalStreamSessionManager asrLocalStreamSessionManager, String str, InferResult inferResult) {
        if (ref$BooleanRef.f10073a) {
            return;
        }
        ref$BooleanRef.f10073a = true;
        asrLocalStreamSessionManager.reportLocalStreamFlywheelTerminal(str, inferResult);
    }

    public final void cancelAll() {
        Collection<LocalStreamSession> collectionValues = this.localStreamSessions.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            Job consumerJob = ((LocalStreamSession) it.next()).getConsumerJob();
            if (consumerJob != null) {
                arrayList.add(consumerJob);
            }
        }
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            try {
                Job.DefaultImpls.cancel$default((Job) obj, null, 1, null);
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
    }

    public final void completeInput(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        LocalStreamSession localStreamSession = this.localStreamSessions.get(inferId);
        if (localStreamSession == null) {
            AIEngineLogger.w(LogModule.ABILITY, this.tag, "completeInput: no local stream session, inferId=".concat(inferId));
        } else {
            SendChannel.DefaultImpls.close$default(localStreamSession.getChannel(), null, 1, null);
        }
    }

    public final void onFeedInput(String inferId, Object input) {
        LocalStreamSession localStreamSession;
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(input, "input");
        AudioContent audioContent = input instanceof AudioContent ? (AudioContent) input : null;
        if (audioContent == null || audioContent.getAudioBytes().length == 0 || (localStreamSession = this.localStreamSessions.get(inferId)) == null) {
            return;
        }
        if (localStreamSession.getSampleRate() == 0 && audioContent.getSampleRate() > 0) {
            localStreamSession.setSampleRate(audioContent.getSampleRate());
        }
        if (localStreamSession.getChannelCount() == 0 && audioContent.getChannelCount() > 0) {
            localStreamSession.setChannelCount(audioContent.getChannelCount());
        }
        long jIncrementAndGet = localStreamSession.getEnqueued().incrementAndGet();
        long j10 = jIncrementAndGet - localStreamSession.getConsumed().get();
        if (j10 > localStreamSession.getPeakBacklog()) {
            localStreamSession.setPeakBacklog(j10);
        }
        if (jIncrementAndGet % 16 == 0) {
            LogModule logModule = LogModule.ABILITY;
            String str = this.tag;
            long j11 = localStreamSession.getConsumed().get();
            long peakBacklog = localStreamSession.getPeakBacklog();
            StringBuilder sbL = com.stepos.core.ota.d.l("[backpressure] local feed inferId=", jIncrementAndGet, inferId, " enqueued=");
            a0.a.s(j11, " consumed=", " backlog=", sbL);
            sbL.append(j10);
            sbL.append(" peak=");
            sbL.append(peakBacklog);
            AIEngineLogger.i(logModule, str, sbL.toString());
        }
        localStreamSession.getChannel().mo149trySendJP2dKIU(audioContent.getAudioBytes());
    }

    public final void registerLocalStreamingSession(String inferId, IInferenceCallback iInferenceCallback, int i10, zb.a<lb.n> onStreamComplete, PowerPerfTracker powerPerfTracker, AITaskRecord aITaskRecord) {
        kotlin.coroutines.d aVar;
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(onStreamComplete, "onStreamComplete");
        LocalStreamSession localStreamSession = new LocalStreamSession(iInferenceCallback, i10, onStreamComplete, ChannelKt.Channel$default(64, BufferOverflow.DROP_OLDEST, null, 4, null), null, 0, 0, null, null, 0L, powerPerfTracker, 1008, null);
        this.localStreamSessions.put(inferId, localStreamSession);
        if (aITaskRecord != null) {
            TaskPriority priority = aITaskRecord.getFinalTier();
            if (priority == null) {
                priority = aITaskRecord.getPriority();
            }
            kotlin.jvm.internal.g.f(priority, "priority");
            PoolType.f6214b.getClass();
            aVar = new com.stepos.base.concurrency.cpuset.a(PoolType.a.a(priority));
        } else {
            aVar = null;
        }
        CoroutineScope coroutineScope = this.streamScope;
        if (aVar == null) {
            aVar = EmptyCoroutineContext.f10057a;
        }
        localStreamSession.setConsumerJob(BuildersKt__Builders_commonKt.launch$default(coroutineScope, aVar, null, new C03171(inferId, localStreamSession, null), 2, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00a5 -> B:39:0x00a6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object releaseAndJoin(qb.b<? super lb.n> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.stepos.core.ability.speech.AsrLocalStreamSessionManager.C03181
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.core.ability.speech.AsrLocalStreamSessionManager$releaseAndJoin$1 r0 = (com.stepos.core.ability.speech.AsrLocalStreamSessionManager.C03181) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.AsrLocalStreamSessionManager$releaseAndJoin$1 r0 = new com.stepos.core.ability.speech.AsrLocalStreamSessionManager$releaseAndJoin$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r8 = r0.L$1
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r2 = r0.L$0
            com.stepos.core.ability.speech.AsrLocalStreamSessionManager r2 = (com.stepos.core.ability.speech.AsrLocalStreamSessionManager) r2
            kotlin.c.b(r9)     // Catch: java.lang.Throwable -> L30
            goto La6
        L30:
            r9 = move-exception
            goto Lae
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            kotlin.c.b(r9)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.core.ability.speech.AsrLocalStreamSessionManager$LocalStreamSession> r9 = r8.localStreamSessions
            java.util.Collection r9 = r9.values()
            java.lang.String r2 = "<get-values>(...)"
            kotlin.jvm.internal.g.e(r9, r2)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r9 = r9.iterator()
        L54:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L6a
            java.lang.Object r4 = r9.next()
            com.stepos.core.ability.speech.AsrLocalStreamSessionManager$LocalStreamSession r4 = (com.stepos.core.ability.speech.AsrLocalStreamSessionManager.LocalStreamSession) r4
            kotlinx.coroutines.Job r4 = r4.getConsumerJob()
            if (r4 == 0) goto L54
            r2.add(r4)
            goto L54
        L6a:
            int r9 = r2.size()
            r4 = 0
        L6f:
            if (r4 >= r9) goto L85
            java.lang.Object r5 = r2.get(r4)
            int r4 = r4 + 1
            kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
            r6 = 0
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r5, r6, r3, r6)     // Catch: java.lang.Throwable -> L80
            lb.n r5 = lb.n.f10413a     // Catch: java.lang.Throwable -> L80
            goto L6f
        L80:
            r5 = move-exception
            kotlin.c.a(r5)
            goto L6f
        L85:
            java.util.Iterator r9 = r2.iterator()
            r7 = r9
            r9 = r8
            r8 = r7
        L8c:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lb2
            java.lang.Object r2 = r8.next()
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            r0.L$0 = r9     // Catch: java.lang.Throwable -> Laa
            r0.L$1 = r8     // Catch: java.lang.Throwable -> Laa
            r0.label = r3     // Catch: java.lang.Throwable -> Laa
            java.lang.Object r2 = r2.join(r0)     // Catch: java.lang.Throwable -> Laa
            if (r2 != r1) goto La5
            return r1
        La5:
            r2 = r9
        La6:
            lb.n r9 = lb.n.f10413a     // Catch: java.lang.Throwable -> L30
        La8:
            r9 = r2
            goto L8c
        Laa:
            r2 = move-exception
            r7 = r2
            r2 = r9
            r9 = r7
        Lae:
            kotlin.c.a(r9)
            goto La8
        Lb2:
            lb.n r8 = lb.n.f10413a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrLocalStreamSessionManager.releaseAndJoin(qb.b):java.lang.Object");
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class LocalStreamSession {
        private final IInferenceCallback callback;
        private final int callerUid;
        private final Channel<byte[]> channel;
        private volatile int channelCount;
        private final AtomicLong consumed;
        private volatile Job consumerJob;
        private final AtomicLong enqueued;
        private final zb.a<lb.n> onStreamComplete;
        private volatile long peakBacklog;
        private volatile int sampleRate;
        private final PowerPerfTracker tracker;

        public LocalStreamSession(IInferenceCallback iInferenceCallback, int i10, zb.a<lb.n> onStreamComplete, Channel<byte[]> channel, Job job, int i11, int i12, AtomicLong enqueued, AtomicLong consumed, long j10, PowerPerfTracker powerPerfTracker) {
            kotlin.jvm.internal.g.f(onStreamComplete, "onStreamComplete");
            kotlin.jvm.internal.g.f(channel, "channel");
            kotlin.jvm.internal.g.f(enqueued, "enqueued");
            kotlin.jvm.internal.g.f(consumed, "consumed");
            this.callback = iInferenceCallback;
            this.callerUid = i10;
            this.onStreamComplete = onStreamComplete;
            this.channel = channel;
            this.consumerJob = job;
            this.sampleRate = i11;
            this.channelCount = i12;
            this.enqueued = enqueued;
            this.consumed = consumed;
            this.peakBacklog = j10;
            this.tracker = powerPerfTracker;
        }

        public static /* synthetic */ LocalStreamSession copy$default(LocalStreamSession localStreamSession, IInferenceCallback iInferenceCallback, int i10, zb.a aVar, Channel channel, Job job, int i11, int i12, AtomicLong atomicLong, AtomicLong atomicLong2, long j10, PowerPerfTracker powerPerfTracker, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                iInferenceCallback = localStreamSession.callback;
            }
            if ((i13 & 2) != 0) {
                i10 = localStreamSession.callerUid;
            }
            if ((i13 & 4) != 0) {
                aVar = localStreamSession.onStreamComplete;
            }
            if ((i13 & 8) != 0) {
                channel = localStreamSession.channel;
            }
            if ((i13 & 16) != 0) {
                job = localStreamSession.consumerJob;
            }
            if ((i13 & 32) != 0) {
                i11 = localStreamSession.sampleRate;
            }
            if ((i13 & 64) != 0) {
                i12 = localStreamSession.channelCount;
            }
            if ((i13 & TraceIdKeys.MAX_LENGTH) != 0) {
                atomicLong = localStreamSession.enqueued;
            }
            if ((i13 & 256) != 0) {
                atomicLong2 = localStreamSession.consumed;
            }
            if ((i13 & VadSessionManager.FRAME_BYTES) != 0) {
                j10 = localStreamSession.peakBacklog;
            }
            if ((i13 & 1024) != 0) {
                powerPerfTracker = localStreamSession.tracker;
            }
            PowerPerfTracker powerPerfTracker2 = powerPerfTracker;
            long j11 = j10;
            AtomicLong atomicLong3 = atomicLong;
            AtomicLong atomicLong4 = atomicLong2;
            int i14 = i11;
            int i15 = i12;
            Job job2 = job;
            zb.a aVar2 = aVar;
            return localStreamSession.copy(iInferenceCallback, i10, aVar2, channel, job2, i14, i15, atomicLong3, atomicLong4, j11, powerPerfTracker2);
        }

        public final IInferenceCallback component1() {
            return this.callback;
        }

        public final long component10() {
            return this.peakBacklog;
        }

        public final PowerPerfTracker component11() {
            return this.tracker;
        }

        public final int component2() {
            return this.callerUid;
        }

        public final zb.a<lb.n> component3() {
            return this.onStreamComplete;
        }

        public final Channel<byte[]> component4() {
            return this.channel;
        }

        public final Job component5() {
            return this.consumerJob;
        }

        public final int component6() {
            return this.sampleRate;
        }

        public final int component7() {
            return this.channelCount;
        }

        public final AtomicLong component8() {
            return this.enqueued;
        }

        public final AtomicLong component9() {
            return this.consumed;
        }

        public final LocalStreamSession copy(IInferenceCallback iInferenceCallback, int i10, zb.a<lb.n> onStreamComplete, Channel<byte[]> channel, Job job, int i11, int i12, AtomicLong enqueued, AtomicLong consumed, long j10, PowerPerfTracker powerPerfTracker) {
            kotlin.jvm.internal.g.f(onStreamComplete, "onStreamComplete");
            kotlin.jvm.internal.g.f(channel, "channel");
            kotlin.jvm.internal.g.f(enqueued, "enqueued");
            kotlin.jvm.internal.g.f(consumed, "consumed");
            return new LocalStreamSession(iInferenceCallback, i10, onStreamComplete, channel, job, i11, i12, enqueued, consumed, j10, powerPerfTracker);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalStreamSession)) {
                return false;
            }
            LocalStreamSession localStreamSession = (LocalStreamSession) obj;
            return kotlin.jvm.internal.g.b(this.callback, localStreamSession.callback) && this.callerUid == localStreamSession.callerUid && kotlin.jvm.internal.g.b(this.onStreamComplete, localStreamSession.onStreamComplete) && kotlin.jvm.internal.g.b(this.channel, localStreamSession.channel) && kotlin.jvm.internal.g.b(this.consumerJob, localStreamSession.consumerJob) && this.sampleRate == localStreamSession.sampleRate && this.channelCount == localStreamSession.channelCount && kotlin.jvm.internal.g.b(this.enqueued, localStreamSession.enqueued) && kotlin.jvm.internal.g.b(this.consumed, localStreamSession.consumed) && this.peakBacklog == localStreamSession.peakBacklog && kotlin.jvm.internal.g.b(this.tracker, localStreamSession.tracker);
        }

        public final IInferenceCallback getCallback() {
            return this.callback;
        }

        public final int getCallerUid() {
            return this.callerUid;
        }

        public final Channel<byte[]> getChannel() {
            return this.channel;
        }

        public final int getChannelCount() {
            return this.channelCount;
        }

        public final AtomicLong getConsumed() {
            return this.consumed;
        }

        public final Job getConsumerJob() {
            return this.consumerJob;
        }

        public final AtomicLong getEnqueued() {
            return this.enqueued;
        }

        public final zb.a<lb.n> getOnStreamComplete() {
            return this.onStreamComplete;
        }

        public final long getPeakBacklog() {
            return this.peakBacklog;
        }

        public final int getSampleRate() {
            return this.sampleRate;
        }

        public final PowerPerfTracker getTracker() {
            return this.tracker;
        }

        public int hashCode() {
            IInferenceCallback iInferenceCallback = this.callback;
            int iC = a0.a.c((this.consumed.hashCode() + ((this.enqueued.hashCode() + ai.onnxruntime.a.d(this.channelCount, ai.onnxruntime.a.d(this.sampleRate, (((this.channel.hashCode() + ((this.onStreamComplete.hashCode() + ai.onnxruntime.a.d(this.callerUid, (iInferenceCallback == null ? 0 : iInferenceCallback.hashCode()) * 31, 31)) * 31)) * 31) + (this.consumerJob == null ? 0 : this.consumerJob.hashCode())) * 31, 31), 31)) * 31)) * 31, this.peakBacklog, 31);
            PowerPerfTracker powerPerfTracker = this.tracker;
            return iC + (powerPerfTracker != null ? powerPerfTracker.hashCode() : 0);
        }

        public final void setChannelCount(int i10) {
            this.channelCount = i10;
        }

        public final void setConsumerJob(Job job) {
            this.consumerJob = job;
        }

        public final void setPeakBacklog(long j10) {
            this.peakBacklog = j10;
        }

        public final void setSampleRate(int i10) {
            this.sampleRate = i10;
        }

        public String toString() {
            return "LocalStreamSession(callback=" + this.callback + ", callerUid=" + this.callerUid + ", onStreamComplete=" + this.onStreamComplete + ", channel=" + this.channel + ", consumerJob=" + this.consumerJob + ", sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + ", enqueued=" + this.enqueued + ", consumed=" + this.consumed + ", peakBacklog=" + this.peakBacklog + ", tracker=" + this.tracker + ")";
        }

        public /* synthetic */ LocalStreamSession(IInferenceCallback iInferenceCallback, int i10, zb.a aVar, Channel channel, Job job, int i11, int i12, AtomicLong atomicLong, AtomicLong atomicLong2, long j10, PowerPerfTracker powerPerfTracker, int i13, kotlin.jvm.internal.e eVar) {
            this(iInferenceCallback, i10, aVar, channel, (i13 & 16) != 0 ? null : job, (i13 & 32) != 0 ? 0 : i11, (i13 & 64) != 0 ? 0 : i12, (i13 & TraceIdKeys.MAX_LENGTH) != 0 ? new AtomicLong(0L) : atomicLong, (i13 & 256) != 0 ? new AtomicLong(0L) : atomicLong2, (i13 & VadSessionManager.FRAME_BYTES) != 0 ? 0L : j10, (i13 & 1024) != 0 ? null : powerPerfTracker);
        }
    }
}
