package com.stepos.core.ability.executor;

import android.annotation.SuppressLint;
import com.stepos.base.concurrency.data.PoolType;
import com.stepos.base.error.ContextOverflowException;
import com.stepos.base.model.ModelLoadException;
import com.stepos.base.strategy.OrchestrationRejectedException;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.ability.converter.AbilityInputConverter;
import com.stepos.core.ability.converter.AbilityOutputConverter;
import com.stepos.core.ability.executor.IInferenceExecutor;
import com.stepos.core.ability.handler.IResultHandler;
import com.stepos.core.ability.handler.InferResult;
import com.stepos.core.ability.speech.AsrFileCloudAuthException;
import com.stepos.core.ability.speech.AsrFileCloudNetworkException;
import com.stepos.core.ability.speech.AsrFileCloudTaskFailedException;
import com.stepos.core.ability.speech.AsrFileCloudTimeoutException;
import com.stepos.core.ability.speech.AsrSseCloudException;
import com.stepos.core.common.cloud.CloudApiException;
import com.stepos.core.common.cloud.CloudErrorUserMessage;
import com.stepos.core.common.cloud.CloudHttpErrorMapper;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.telemetry.DataVolume;
import com.stepos.core.common.telemetry.ModelCallOutcome;
import com.stepos.core.common.telemetry.PowerPerfTracker;
import com.stepos.core.common.telemetry.TrackerContext;
import com.stepos.core.data.base.Content;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.concurrency.PressureCancelledException;
import com.stepos.core.model.task.AITaskRecord;
import com.stepos.core.model.task.BackpressureException;
import com.stepos.core.model.task.CircuitBreakerOpenException;
import com.stepos.core.model.task.InferenceException;
import fc.i;
import gc.q;
import h0.e;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutCancellationException;
import lb.n;
import mb.m;
import p6.d;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InferenceExecutor implements IInferenceExecutor {
    private final String TAG;
    private final d<?, ?> ability;
    private final ConcurrentHashMap<String, IResultHandler> inFlight;
    private final AbilityInputConverter inputConverter;
    private final AbilityOutputConverter outputConverter;
    private m7.a registeredWatchdog;
    private final CoroutineScope scope;
    private final ExecutorCoroutineDispatcher singleThreadDispatcher;
    private final ExecutorService singleThreadExecutor;
    private final CompletableJob supervisorJob;
    private final ConcurrentHashMap<String, Object> taskRecords;
    private final String watchdogKey;
    private final Object watchdogLock;
    private int watchdogRefs;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ability.executor.InferenceExecutor$executeInternal$1", f = "InferenceExecutor.kt", l = {234, 265}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.executor.InferenceExecutor$executeInternal$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ Content $input;
        final /* synthetic */ zb.a<n> $onComplete;
        final /* synthetic */ PowerPerfTracker $perfTracker;
        final /* synthetic */ Object $record;
        final /* synthetic */ String $requestId;
        final /* synthetic */ IResultHandler $resultHandler;
        final /* synthetic */ AITaskRecord $taskRec;
        long J$0;
        long J$1;
        long J$2;
        long J$3;
        long J$4;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @c(c = "com.stepos.core.ability.executor.InferenceExecutor$executeInternal$1$3", f = "InferenceExecutor.kt", l = {266, 277}, m = "invokeSuspend")
        /* renamed from: com.stepos.core.ability.executor.InferenceExecutor$executeInternal$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
            final /* synthetic */ String $abilityId;
            final /* synthetic */ v6.c $abilityInput;
            final /* synthetic */ Ref$ObjectRef<Throwable> $failCause;
            final /* synthetic */ AtomicBoolean $firstTokenEmitted;
            final /* synthetic */ Ref$IntRef $flywheelErrorCode;
            final /* synthetic */ Ref$ObjectRef<ModelCallOutcome> $flywheelOutcome;
            final /* synthetic */ Ref$BooleanRef $inferFailed;
            final /* synthetic */ Content $input;
            final /* synthetic */ String $modelName;
            final /* synthetic */ Ref$IntRef $outputCount;
            final /* synthetic */ PowerPerfTracker $perfTracker;
            final /* synthetic */ Object $record;
            final /* synthetic */ String $requestId;
            final /* synthetic */ IResultHandler $resultHandler;
            final /* synthetic */ long $startNs;
            final /* synthetic */ AITaskRecord $taskRec;
            final /* synthetic */ d<v6.c, v6.d> $typedAbility;
            int label;
            final /* synthetic */ InferenceExecutor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(d<v6.c, v6.d> dVar, v6.c cVar, Object obj, InferenceExecutor inferenceExecutor, String str, String str2, long j10, Ref$IntRef ref$IntRef, Ref$BooleanRef ref$BooleanRef, IResultHandler iResultHandler, Content content, AtomicBoolean atomicBoolean, String str3, PowerPerfTracker powerPerfTracker, Ref$ObjectRef<ModelCallOutcome> ref$ObjectRef, Ref$IntRef ref$IntRef2, Ref$ObjectRef<Throwable> ref$ObjectRef2, AITaskRecord aITaskRecord, qb.b<? super AnonymousClass3> bVar) {
                super(2, bVar);
                this.$typedAbility = dVar;
                this.$abilityInput = cVar;
                this.$record = obj;
                this.this$0 = inferenceExecutor;
                this.$requestId = str;
                this.$abilityId = str2;
                this.$startNs = j10;
                this.$outputCount = ref$IntRef;
                this.$inferFailed = ref$BooleanRef;
                this.$resultHandler = iResultHandler;
                this.$input = content;
                this.$firstTokenEmitted = atomicBoolean;
                this.$modelName = str3;
                this.$perfTracker = powerPerfTracker;
                this.$flywheelOutcome = ref$ObjectRef;
                this.$flywheelErrorCode = ref$IntRef2;
                this.$failCause = ref$ObjectRef2;
                this.$taskRec = aITaskRecord;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DataVolume invokeSuspend$lambda$2$lambda$1$lambda$0(int i10, DataVolume dataVolume) {
                return DataVolume.copy$default(dataVolume, null, null, null, null, null, null, null, Integer.valueOf(i10), null, 383, null);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final qb.b<n> create(Object obj, qb.b<?> bVar) {
                return new AnonymousClass3(this.$typedAbility, this.$abilityInput, this.$record, this.this$0, this.$requestId, this.$abilityId, this.$startNs, this.$outputCount, this.$inferFailed, this.$resultHandler, this.$input, this.$firstTokenEmitted, this.$modelName, this.$perfTracker, this.$flywheelOutcome, this.$flywheelErrorCode, this.$failCause, this.$taskRec, bVar);
            }

            /* JADX WARN: Code restructure failed: missing block: B:28:0x009c, code lost:
            
                if (r2.collect(r7, r22) == r1) goto L29;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r23) {
                /*
                    Method dump skipped, instructions count: 252
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.executor.InferenceExecutor.AnonymousClass1.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // zb.p
            public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
                return ((AnonymousClass3) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: com.stepos.core.ability.executor.InferenceExecutor$executeInternal$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ModelCallOutcome.values().length];
                try {
                    iArr[ModelCallOutcome.CANCELLED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ModelCallOutcome.TIMEOUT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, AITaskRecord aITaskRecord, Object obj, PowerPerfTracker powerPerfTracker, Content content, IResultHandler iResultHandler, zb.a<n> aVar, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$requestId = str;
            this.$taskRec = aITaskRecord;
            this.$record = obj;
            this.$perfTracker = powerPerfTracker;
            this.$input = content;
            this.$resultHandler = iResultHandler;
            this.$onComplete = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = InferenceExecutor.this.new AnonymousClass1(this.$requestId, this.$taskRec, this.$record, this.$perfTracker, this.$input, this.$resultHandler, this.$onComplete, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:1000:0x1db9 A[Catch: all -> 0x1dbc, TryCatch #81 {all -> 0x1dbc, blocks: (B:998:0x1db5, B:1000:0x1db9, B:1005:0x1dc4, B:1007:0x1dca, B:1009:0x1dce, B:1012:0x1dd4), top: B:1327:0x1db5 }] */
        /* JADX WARN: Removed duplicated region for block: B:1003:0x1dc1  */
        /* JADX WARN: Removed duplicated region for block: B:1005:0x1dc4 A[Catch: all -> 0x1dbc, TryCatch #81 {all -> 0x1dbc, blocks: (B:998:0x1db5, B:1000:0x1db9, B:1005:0x1dc4, B:1007:0x1dca, B:1009:0x1dce, B:1012:0x1dd4), top: B:1327:0x1db5 }] */
        /* JADX WARN: Removed duplicated region for block: B:1006:0x1dc9  */
        /* JADX WARN: Removed duplicated region for block: B:1009:0x1dce A[Catch: all -> 0x1dbc, TryCatch #81 {all -> 0x1dbc, blocks: (B:998:0x1db5, B:1000:0x1db9, B:1005:0x1dc4, B:1007:0x1dca, B:1009:0x1dce, B:1012:0x1dd4), top: B:1327:0x1db5 }] */
        /* JADX WARN: Removed duplicated region for block: B:1010:0x1dd1  */
        /* JADX WARN: Removed duplicated region for block: B:1012:0x1dd4 A[Catch: all -> 0x1dbc, TRY_LEAVE, TryCatch #81 {all -> 0x1dbc, blocks: (B:998:0x1db5, B:1000:0x1db9, B:1005:0x1dc4, B:1007:0x1dca, B:1009:0x1dce, B:1012:0x1dd4), top: B:1327:0x1db5 }] */
        /* JADX WARN: Removed duplicated region for block: B:1051:0x1e6f  */
        /* JADX WARN: Removed duplicated region for block: B:1055:0x1e81  */
        /* JADX WARN: Removed duplicated region for block: B:1059:0x1e96 A[Catch: all -> 0x1e99, TryCatch #63 {all -> 0x1e99, blocks: (B:1057:0x1e92, B:1059:0x1e96, B:1087:0x1eeb, B:1065:0x1e9f, B:1067:0x1eaf, B:1069:0x1eb7, B:1071:0x1ebb, B:1073:0x1ec1, B:1075:0x1ec5, B:1077:0x1ec9, B:1078:0x1ecc, B:1086:0x1ee1, B:1082:0x1ed4, B:1084:0x1eda), top: B:1317:0x1e92 }] */
        /* JADX WARN: Removed duplicated region for block: B:1062:0x1e9b  */
        /* JADX WARN: Removed duplicated region for block: B:1064:0x1e9e A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:1065:0x1e9f A[Catch: all -> 0x1e99, TryCatch #63 {all -> 0x1e99, blocks: (B:1057:0x1e92, B:1059:0x1e96, B:1087:0x1eeb, B:1065:0x1e9f, B:1067:0x1eaf, B:1069:0x1eb7, B:1071:0x1ebb, B:1073:0x1ec1, B:1075:0x1ec5, B:1077:0x1ec9, B:1078:0x1ecc, B:1086:0x1ee1, B:1082:0x1ed4, B:1084:0x1eda), top: B:1317:0x1e92 }] */
        /* JADX WARN: Removed duplicated region for block: B:1069:0x1eb7 A[Catch: all -> 0x1e99, TryCatch #63 {all -> 0x1e99, blocks: (B:1057:0x1e92, B:1059:0x1e96, B:1087:0x1eeb, B:1065:0x1e9f, B:1067:0x1eaf, B:1069:0x1eb7, B:1071:0x1ebb, B:1073:0x1ec1, B:1075:0x1ec5, B:1077:0x1ec9, B:1078:0x1ecc, B:1086:0x1ee1, B:1082:0x1ed4, B:1084:0x1eda), top: B:1317:0x1e92 }] */
        /* JADX WARN: Removed duplicated region for block: B:1070:0x1eba  */
        /* JADX WARN: Removed duplicated region for block: B:1073:0x1ec1 A[Catch: all -> 0x1e99, TryCatch #63 {all -> 0x1e99, blocks: (B:1057:0x1e92, B:1059:0x1e96, B:1087:0x1eeb, B:1065:0x1e9f, B:1067:0x1eaf, B:1069:0x1eb7, B:1071:0x1ebb, B:1073:0x1ec1, B:1075:0x1ec5, B:1077:0x1ec9, B:1078:0x1ecc, B:1086:0x1ee1, B:1082:0x1ed4, B:1084:0x1eda), top: B:1317:0x1e92 }] */
        /* JADX WARN: Removed duplicated region for block: B:1080:0x1ed0  */
        /* JADX WARN: Removed duplicated region for block: B:1081:0x1ed2  */
        /* JADX WARN: Removed duplicated region for block: B:1092:0x1efc  */
        /* JADX WARN: Removed duplicated region for block: B:1111:0x1f82  */
        /* JADX WARN: Removed duplicated region for block: B:1112:0x1f85  */
        /* JADX WARN: Removed duplicated region for block: B:1114:0x1f88  */
        /* JADX WARN: Removed duplicated region for block: B:1115:0x1f8d  */
        /* JADX WARN: Removed duplicated region for block: B:1118:0x1f92  */
        /* JADX WARN: Removed duplicated region for block: B:1119:0x1f95  */
        /* JADX WARN: Removed duplicated region for block: B:1122:0x1fbb  */
        /* JADX WARN: Removed duplicated region for block: B:1124:0x1fc4  */
        /* JADX WARN: Removed duplicated region for block: B:1176:0x20a1  */
        /* JADX WARN: Removed duplicated region for block: B:1177:0x20b1  */
        /* JADX WARN: Removed duplicated region for block: B:1181:0x20ee A[Catch: all -> 0x20f1, TryCatch #107 {all -> 0x20f1, blocks: (B:1179:0x20ea, B:1181:0x20ee, B:1186:0x20f9, B:1188:0x20ff, B:1190:0x2103, B:1193:0x2109), top: B:1343:0x20ea }] */
        /* JADX WARN: Removed duplicated region for block: B:1184:0x20f6  */
        /* JADX WARN: Removed duplicated region for block: B:1186:0x20f9 A[Catch: all -> 0x20f1, TryCatch #107 {all -> 0x20f1, blocks: (B:1179:0x20ea, B:1181:0x20ee, B:1186:0x20f9, B:1188:0x20ff, B:1190:0x2103, B:1193:0x2109), top: B:1343:0x20ea }] */
        /* JADX WARN: Removed duplicated region for block: B:1187:0x20fe  */
        /* JADX WARN: Removed duplicated region for block: B:1190:0x2103 A[Catch: all -> 0x20f1, TryCatch #107 {all -> 0x20f1, blocks: (B:1179:0x20ea, B:1181:0x20ee, B:1186:0x20f9, B:1188:0x20ff, B:1190:0x2103, B:1193:0x2109), top: B:1343:0x20ea }] */
        /* JADX WARN: Removed duplicated region for block: B:1191:0x2106  */
        /* JADX WARN: Removed duplicated region for block: B:1193:0x2109 A[Catch: all -> 0x20f1, TRY_LEAVE, TryCatch #107 {all -> 0x20f1, blocks: (B:1179:0x20ea, B:1181:0x20ee, B:1186:0x20f9, B:1188:0x20ff, B:1190:0x2103, B:1193:0x2109), top: B:1343:0x20ea }] */
        /* JADX WARN: Removed duplicated region for block: B:1232:0x21a4  */
        /* JADX WARN: Removed duplicated region for block: B:1236:0x21b6  */
        /* JADX WARN: Removed duplicated region for block: B:1240:0x21cb A[Catch: all -> 0x21ce, TryCatch #94 {all -> 0x21ce, blocks: (B:1238:0x21c7, B:1240:0x21cb, B:1267:0x221f, B:1246:0x21d4, B:1248:0x21e4, B:1250:0x21ec, B:1252:0x21f1, B:1254:0x21f7, B:1256:0x21fb, B:1257:0x21fe, B:1258:0x2200, B:1266:0x2215, B:1262:0x2208, B:1264:0x220e), top: B:1333:0x21c7 }] */
        /* JADX WARN: Removed duplicated region for block: B:1243:0x21d0  */
        /* JADX WARN: Removed duplicated region for block: B:1245:0x21d3 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:1246:0x21d4 A[Catch: all -> 0x21ce, TryCatch #94 {all -> 0x21ce, blocks: (B:1238:0x21c7, B:1240:0x21cb, B:1267:0x221f, B:1246:0x21d4, B:1248:0x21e4, B:1250:0x21ec, B:1252:0x21f1, B:1254:0x21f7, B:1256:0x21fb, B:1257:0x21fe, B:1258:0x2200, B:1266:0x2215, B:1262:0x2208, B:1264:0x220e), top: B:1333:0x21c7 }] */
        /* JADX WARN: Removed duplicated region for block: B:1250:0x21ec A[Catch: all -> 0x21ce, TryCatch #94 {all -> 0x21ce, blocks: (B:1238:0x21c7, B:1240:0x21cb, B:1267:0x221f, B:1246:0x21d4, B:1248:0x21e4, B:1250:0x21ec, B:1252:0x21f1, B:1254:0x21f7, B:1256:0x21fb, B:1257:0x21fe, B:1258:0x2200, B:1266:0x2215, B:1262:0x2208, B:1264:0x220e), top: B:1333:0x21c7 }] */
        /* JADX WARN: Removed duplicated region for block: B:1251:0x21f0  */
        /* JADX WARN: Removed duplicated region for block: B:1254:0x21f7 A[Catch: all -> 0x21ce, TryCatch #94 {all -> 0x21ce, blocks: (B:1238:0x21c7, B:1240:0x21cb, B:1267:0x221f, B:1246:0x21d4, B:1248:0x21e4, B:1250:0x21ec, B:1252:0x21f1, B:1254:0x21f7, B:1256:0x21fb, B:1257:0x21fe, B:1258:0x2200, B:1266:0x2215, B:1262:0x2208, B:1264:0x220e), top: B:1333:0x21c7 }] */
        /* JADX WARN: Removed duplicated region for block: B:1260:0x2204  */
        /* JADX WARN: Removed duplicated region for block: B:1261:0x2206  */
        /* JADX WARN: Removed duplicated region for block: B:1272:0x2230  */
        /* JADX WARN: Removed duplicated region for block: B:1275:0x2241  */
        /* JADX WARN: Removed duplicated region for block: B:1293:0x1757 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:1321:0x1ba1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:1335:0x12cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:1381:0x07d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:1395:0x0703 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:1397:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:1398:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:144:0x07be  */
        /* JADX WARN: Removed duplicated region for block: B:145:0x07c2 A[Catch: all -> 0x0f70, Exception -> 0x0f75, CancellationException -> 0x0f7c, TimeoutCancellationException -> 0x0f83, TRY_ENTER, TRY_LEAVE, TryCatch #67 {TimeoutCancellationException -> 0x0f83, CancellationException -> 0x0f7c, Exception -> 0x0f75, all -> 0x0f70, blocks: (B:123:0x06ca, B:139:0x07b5, B:145:0x07c2, B:148:0x07cd), top: B:1389:0x06ca }] */
        /* JADX WARN: Removed duplicated region for block: B:147:0x07c6 A[Catch: all -> 0x070e, Exception -> 0x073d, CancellationException -> 0x0761, TimeoutCancellationException -> 0x0785, TRY_ENTER, TRY_LEAVE, TryCatch #64 {TimeoutCancellationException -> 0x0785, CancellationException -> 0x0761, Exception -> 0x073d, all -> 0x070e, blocks: (B:125:0x0703, B:141:0x07b9, B:147:0x07c6, B:150:0x07d3, B:156:0x07e9, B:158:0x07fb), top: B:1395:0x0703 }] */
        /* JADX WARN: Removed duplicated region for block: B:150:0x07d3 A[Catch: all -> 0x070e, Exception -> 0x073d, CancellationException -> 0x0761, TimeoutCancellationException -> 0x0785, TRY_ENTER, TRY_LEAVE, TryCatch #64 {TimeoutCancellationException -> 0x0785, CancellationException -> 0x0761, Exception -> 0x073d, all -> 0x070e, blocks: (B:125:0x0703, B:141:0x07b9, B:147:0x07c6, B:150:0x07d3, B:156:0x07e9, B:158:0x07fb), top: B:1395:0x0703 }] */
        /* JADX WARN: Removed duplicated region for block: B:152:0x07d6  */
        /* JADX WARN: Removed duplicated region for block: B:200:0x0936  */
        /* JADX WARN: Removed duplicated region for block: B:203:0x094e  */
        /* JADX WARN: Removed duplicated region for block: B:204:0x0951  */
        /* JADX WARN: Removed duplicated region for block: B:206:0x0954  */
        /* JADX WARN: Removed duplicated region for block: B:207:0x0959  */
        /* JADX WARN: Removed duplicated region for block: B:210:0x095e  */
        /* JADX WARN: Removed duplicated region for block: B:211:0x0961  */
        /* JADX WARN: Removed duplicated region for block: B:214:0x098f  */
        /* JADX WARN: Removed duplicated region for block: B:216:0x099a  */
        /* JADX WARN: Removed duplicated region for block: B:268:0x0a7d  */
        /* JADX WARN: Removed duplicated region for block: B:269:0x0a8d  */
        /* JADX WARN: Removed duplicated region for block: B:273:0x0ac6 A[Catch: all -> 0x0ac9, TryCatch #90 {all -> 0x0ac9, blocks: (B:271:0x0ac2, B:273:0x0ac6, B:278:0x0acf, B:280:0x0ad5, B:282:0x0ad9, B:285:0x0adf, B:287:0x0ae3, B:295:0x0afa, B:298:0x0b02, B:300:0x0b0e, B:301:0x0b15, B:303:0x0b1f, B:305:0x0b23, B:306:0x0b2c, B:308:0x0b32, B:296:0x0afd, B:297:0x0b00, B:291:0x0aec, B:309:0x0b37, B:311:0x0b48, B:312:0x0b4c, B:318:0x0b6d, B:315:0x0b5a, B:317:0x0b60), top: B:1331:0x0ac2 }] */
        /* JADX WARN: Removed duplicated region for block: B:276:0x0acc  */
        /* JADX WARN: Removed duplicated region for block: B:278:0x0acf A[Catch: all -> 0x0ac9, TryCatch #90 {all -> 0x0ac9, blocks: (B:271:0x0ac2, B:273:0x0ac6, B:278:0x0acf, B:280:0x0ad5, B:282:0x0ad9, B:285:0x0adf, B:287:0x0ae3, B:295:0x0afa, B:298:0x0b02, B:300:0x0b0e, B:301:0x0b15, B:303:0x0b1f, B:305:0x0b23, B:306:0x0b2c, B:308:0x0b32, B:296:0x0afd, B:297:0x0b00, B:291:0x0aec, B:309:0x0b37, B:311:0x0b48, B:312:0x0b4c, B:318:0x0b6d, B:315:0x0b5a, B:317:0x0b60), top: B:1331:0x0ac2 }] */
        /* JADX WARN: Removed duplicated region for block: B:279:0x0ad4  */
        /* JADX WARN: Removed duplicated region for block: B:282:0x0ad9 A[Catch: all -> 0x0ac9, TryCatch #90 {all -> 0x0ac9, blocks: (B:271:0x0ac2, B:273:0x0ac6, B:278:0x0acf, B:280:0x0ad5, B:282:0x0ad9, B:285:0x0adf, B:287:0x0ae3, B:295:0x0afa, B:298:0x0b02, B:300:0x0b0e, B:301:0x0b15, B:303:0x0b1f, B:305:0x0b23, B:306:0x0b2c, B:308:0x0b32, B:296:0x0afd, B:297:0x0b00, B:291:0x0aec, B:309:0x0b37, B:311:0x0b48, B:312:0x0b4c, B:318:0x0b6d, B:315:0x0b5a, B:317:0x0b60), top: B:1331:0x0ac2 }] */
        /* JADX WARN: Removed duplicated region for block: B:283:0x0adc  */
        /* JADX WARN: Removed duplicated region for block: B:285:0x0adf A[Catch: all -> 0x0ac9, TryCatch #90 {all -> 0x0ac9, blocks: (B:271:0x0ac2, B:273:0x0ac6, B:278:0x0acf, B:280:0x0ad5, B:282:0x0ad9, B:285:0x0adf, B:287:0x0ae3, B:295:0x0afa, B:298:0x0b02, B:300:0x0b0e, B:301:0x0b15, B:303:0x0b1f, B:305:0x0b23, B:306:0x0b2c, B:308:0x0b32, B:296:0x0afd, B:297:0x0b00, B:291:0x0aec, B:309:0x0b37, B:311:0x0b48, B:312:0x0b4c, B:318:0x0b6d, B:315:0x0b5a, B:317:0x0b60), top: B:1331:0x0ac2 }] */
        /* JADX WARN: Removed duplicated region for block: B:320:0x0b70  */
        /* JADX WARN: Removed duplicated region for block: B:324:0x0b80  */
        /* JADX WARN: Removed duplicated region for block: B:328:0x0b95 A[Catch: all -> 0x0b98, TryCatch #62 {all -> 0x0b98, blocks: (B:326:0x0b91, B:328:0x0b95, B:356:0x0bea, B:334:0x0b9e, B:336:0x0bae, B:338:0x0bb6, B:340:0x0bbb, B:342:0x0bc1, B:344:0x0bc5, B:346:0x0bc9, B:347:0x0bcc, B:355:0x0be1, B:351:0x0bd4, B:353:0x0bda), top: B:1315:0x0b91 }] */
        /* JADX WARN: Removed duplicated region for block: B:331:0x0b9a  */
        /* JADX WARN: Removed duplicated region for block: B:338:0x0bb6 A[Catch: all -> 0x0b98, TryCatch #62 {all -> 0x0b98, blocks: (B:326:0x0b91, B:328:0x0b95, B:356:0x0bea, B:334:0x0b9e, B:336:0x0bae, B:338:0x0bb6, B:340:0x0bbb, B:342:0x0bc1, B:344:0x0bc5, B:346:0x0bc9, B:347:0x0bcc, B:355:0x0be1, B:351:0x0bd4, B:353:0x0bda), top: B:1315:0x0b91 }] */
        /* JADX WARN: Removed duplicated region for block: B:339:0x0bba  */
        /* JADX WARN: Removed duplicated region for block: B:342:0x0bc1 A[Catch: all -> 0x0b98, TryCatch #62 {all -> 0x0b98, blocks: (B:326:0x0b91, B:328:0x0b95, B:356:0x0bea, B:334:0x0b9e, B:336:0x0bae, B:338:0x0bb6, B:340:0x0bbb, B:342:0x0bc1, B:344:0x0bc5, B:346:0x0bc9, B:347:0x0bcc, B:355:0x0be1, B:351:0x0bd4, B:353:0x0bda), top: B:1315:0x0b91 }] */
        /* JADX WARN: Removed duplicated region for block: B:349:0x0bd0  */
        /* JADX WARN: Removed duplicated region for block: B:350:0x0bd2  */
        /* JADX WARN: Removed duplicated region for block: B:361:0x0bfb  */
        /* JADX WARN: Removed duplicated region for block: B:364:0x0c0c A[PHI: r0
          0x0c0c: PHI (r0v449 zb.a<lb.n>) = (r0v203 zb.a<lb.n>), (r0v281 zb.a<lb.n>), (r0v412 zb.a<lb.n>), (r0v472 zb.a<lb.n>) binds: [B:700:0x1625, B:895:0x1a91, B:1094:0x1f0b, B:363:0x0c0a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:536:0x1362  */
        /* JADX WARN: Removed duplicated region for block: B:537:0x1365  */
        /* JADX WARN: Removed duplicated region for block: B:539:0x1368  */
        /* JADX WARN: Removed duplicated region for block: B:540:0x136d  */
        /* JADX WARN: Removed duplicated region for block: B:543:0x1372  */
        /* JADX WARN: Removed duplicated region for block: B:544:0x1375  */
        /* JADX WARN: Removed duplicated region for block: B:547:0x139b  */
        /* JADX WARN: Removed duplicated region for block: B:549:0x13a6  */
        /* JADX WARN: Removed duplicated region for block: B:601:0x1487  */
        /* JADX WARN: Removed duplicated region for block: B:602:0x1497  */
        /* JADX WARN: Removed duplicated region for block: B:606:0x14d4 A[Catch: all -> 0x14d7, TryCatch #99 {all -> 0x14d7, blocks: (B:604:0x14d0, B:606:0x14d4, B:611:0x14df, B:613:0x14e5, B:615:0x14e9, B:618:0x14ef), top: B:1337:0x14d0 }] */
        /* JADX WARN: Removed duplicated region for block: B:609:0x14dc  */
        /* JADX WARN: Removed duplicated region for block: B:611:0x14df A[Catch: all -> 0x14d7, TryCatch #99 {all -> 0x14d7, blocks: (B:604:0x14d0, B:606:0x14d4, B:611:0x14df, B:613:0x14e5, B:615:0x14e9, B:618:0x14ef), top: B:1337:0x14d0 }] */
        /* JADX WARN: Removed duplicated region for block: B:612:0x14e4  */
        /* JADX WARN: Removed duplicated region for block: B:615:0x14e9 A[Catch: all -> 0x14d7, TryCatch #99 {all -> 0x14d7, blocks: (B:604:0x14d0, B:606:0x14d4, B:611:0x14df, B:613:0x14e5, B:615:0x14e9, B:618:0x14ef), top: B:1337:0x14d0 }] */
        /* JADX WARN: Removed duplicated region for block: B:616:0x14ec  */
        /* JADX WARN: Removed duplicated region for block: B:618:0x14ef A[Catch: all -> 0x14d7, TRY_LEAVE, TryCatch #99 {all -> 0x14d7, blocks: (B:604:0x14d0, B:606:0x14d4, B:611:0x14df, B:613:0x14e5, B:615:0x14e9, B:618:0x14ef), top: B:1337:0x14d0 }] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0444  */
        /* JADX WARN: Removed duplicated region for block: B:657:0x158a  */
        /* JADX WARN: Removed duplicated region for block: B:661:0x159c  */
        /* JADX WARN: Removed duplicated region for block: B:665:0x15b1 A[Catch: all -> 0x15b4, TryCatch #76 {all -> 0x15b4, blocks: (B:663:0x15ad, B:665:0x15b1, B:693:0x1605, B:671:0x15ba, B:673:0x15ca, B:675:0x15d2, B:677:0x15d6, B:679:0x15dc, B:681:0x15e0, B:683:0x15e4, B:684:0x15e7, B:692:0x15fc, B:688:0x15ef, B:690:0x15f5), top: B:1323:0x15ad }] */
        /* JADX WARN: Removed duplicated region for block: B:668:0x15b6  */
        /* JADX WARN: Removed duplicated region for block: B:670:0x15b9 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:671:0x15ba A[Catch: all -> 0x15b4, TryCatch #76 {all -> 0x15b4, blocks: (B:663:0x15ad, B:665:0x15b1, B:693:0x1605, B:671:0x15ba, B:673:0x15ca, B:675:0x15d2, B:677:0x15d6, B:679:0x15dc, B:681:0x15e0, B:683:0x15e4, B:684:0x15e7, B:692:0x15fc, B:688:0x15ef, B:690:0x15f5), top: B:1323:0x15ad }] */
        /* JADX WARN: Removed duplicated region for block: B:675:0x15d2 A[Catch: all -> 0x15b4, TryCatch #76 {all -> 0x15b4, blocks: (B:663:0x15ad, B:665:0x15b1, B:693:0x1605, B:671:0x15ba, B:673:0x15ca, B:675:0x15d2, B:677:0x15d6, B:679:0x15dc, B:681:0x15e0, B:683:0x15e4, B:684:0x15e7, B:692:0x15fc, B:688:0x15ef, B:690:0x15f5), top: B:1323:0x15ad }] */
        /* JADX WARN: Removed duplicated region for block: B:676:0x15d5  */
        /* JADX WARN: Removed duplicated region for block: B:679:0x15dc A[Catch: all -> 0x15b4, TryCatch #76 {all -> 0x15b4, blocks: (B:663:0x15ad, B:665:0x15b1, B:693:0x1605, B:671:0x15ba, B:673:0x15ca, B:675:0x15d2, B:677:0x15d6, B:679:0x15dc, B:681:0x15e0, B:683:0x15e4, B:684:0x15e7, B:692:0x15fc, B:688:0x15ef, B:690:0x15f5), top: B:1323:0x15ad }] */
        /* JADX WARN: Removed duplicated region for block: B:686:0x15eb  */
        /* JADX WARN: Removed duplicated region for block: B:687:0x15ed  */
        /* JADX WARN: Removed duplicated region for block: B:698:0x1616  */
        /* JADX WARN: Removed duplicated region for block: B:732:0x17cc  */
        /* JADX WARN: Removed duplicated region for block: B:733:0x17cf  */
        /* JADX WARN: Removed duplicated region for block: B:735:0x17d2  */
        /* JADX WARN: Removed duplicated region for block: B:736:0x17d7  */
        /* JADX WARN: Removed duplicated region for block: B:739:0x17dc  */
        /* JADX WARN: Removed duplicated region for block: B:740:0x17df  */
        /* JADX WARN: Removed duplicated region for block: B:743:0x1805  */
        /* JADX WARN: Removed duplicated region for block: B:745:0x1810  */
        /* JADX WARN: Removed duplicated region for block: B:797:0x18f3  */
        /* JADX WARN: Removed duplicated region for block: B:798:0x1903  */
        /* JADX WARN: Removed duplicated region for block: B:802:0x1940 A[Catch: all -> 0x1943, TryCatch #16 {all -> 0x1943, blocks: (B:800:0x193c, B:802:0x1940, B:807:0x194b, B:809:0x1951, B:811:0x1955, B:814:0x195b), top: B:1287:0x193c }] */
        /* JADX WARN: Removed duplicated region for block: B:805:0x1948  */
        /* JADX WARN: Removed duplicated region for block: B:807:0x194b A[Catch: all -> 0x1943, TryCatch #16 {all -> 0x1943, blocks: (B:800:0x193c, B:802:0x1940, B:807:0x194b, B:809:0x1951, B:811:0x1955, B:814:0x195b), top: B:1287:0x193c }] */
        /* JADX WARN: Removed duplicated region for block: B:808:0x1950  */
        /* JADX WARN: Removed duplicated region for block: B:811:0x1955 A[Catch: all -> 0x1943, TryCatch #16 {all -> 0x1943, blocks: (B:800:0x193c, B:802:0x1940, B:807:0x194b, B:809:0x1951, B:811:0x1955, B:814:0x195b), top: B:1287:0x193c }] */
        /* JADX WARN: Removed duplicated region for block: B:812:0x1958  */
        /* JADX WARN: Removed duplicated region for block: B:814:0x195b A[Catch: all -> 0x1943, TRY_LEAVE, TryCatch #16 {all -> 0x1943, blocks: (B:800:0x193c, B:802:0x1940, B:807:0x194b, B:809:0x1951, B:811:0x1955, B:814:0x195b), top: B:1287:0x193c }] */
        /* JADX WARN: Removed duplicated region for block: B:853:0x19f6  */
        /* JADX WARN: Removed duplicated region for block: B:857:0x1a08  */
        /* JADX WARN: Removed duplicated region for block: B:861:0x1a1d A[Catch: all -> 0x1a20, TryCatch #0 {all -> 0x1a20, blocks: (B:859:0x1a19, B:861:0x1a1d, B:888:0x1a71, B:867:0x1a26, B:869:0x1a36, B:871:0x1a3e, B:873:0x1a43, B:875:0x1a49, B:877:0x1a4d, B:878:0x1a50, B:879:0x1a52, B:887:0x1a67, B:883:0x1a5a, B:885:0x1a60), top: B:1277:0x1a19 }] */
        /* JADX WARN: Removed duplicated region for block: B:864:0x1a22  */
        /* JADX WARN: Removed duplicated region for block: B:866:0x1a25 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:867:0x1a26 A[Catch: all -> 0x1a20, TryCatch #0 {all -> 0x1a20, blocks: (B:859:0x1a19, B:861:0x1a1d, B:888:0x1a71, B:867:0x1a26, B:869:0x1a36, B:871:0x1a3e, B:873:0x1a43, B:875:0x1a49, B:877:0x1a4d, B:878:0x1a50, B:879:0x1a52, B:887:0x1a67, B:883:0x1a5a, B:885:0x1a60), top: B:1277:0x1a19 }] */
        /* JADX WARN: Removed duplicated region for block: B:871:0x1a3e A[Catch: all -> 0x1a20, TryCatch #0 {all -> 0x1a20, blocks: (B:859:0x1a19, B:861:0x1a1d, B:888:0x1a71, B:867:0x1a26, B:869:0x1a36, B:871:0x1a3e, B:873:0x1a43, B:875:0x1a49, B:877:0x1a4d, B:878:0x1a50, B:879:0x1a52, B:887:0x1a67, B:883:0x1a5a, B:885:0x1a60), top: B:1277:0x1a19 }] */
        /* JADX WARN: Removed duplicated region for block: B:872:0x1a42  */
        /* JADX WARN: Removed duplicated region for block: B:875:0x1a49 A[Catch: all -> 0x1a20, TryCatch #0 {all -> 0x1a20, blocks: (B:859:0x1a19, B:861:0x1a1d, B:888:0x1a71, B:867:0x1a26, B:869:0x1a36, B:871:0x1a3e, B:873:0x1a43, B:875:0x1a49, B:877:0x1a4d, B:878:0x1a50, B:879:0x1a52, B:887:0x1a67, B:883:0x1a5a, B:885:0x1a60), top: B:1277:0x1a19 }] */
        /* JADX WARN: Removed duplicated region for block: B:881:0x1a56  */
        /* JADX WARN: Removed duplicated region for block: B:882:0x1a58  */
        /* JADX WARN: Removed duplicated region for block: B:893:0x1a82  */
        /* JADX WARN: Removed duplicated region for block: B:930:0x1c41  */
        /* JADX WARN: Removed duplicated region for block: B:931:0x1c44  */
        /* JADX WARN: Removed duplicated region for block: B:933:0x1c47  */
        /* JADX WARN: Removed duplicated region for block: B:934:0x1c4c  */
        /* JADX WARN: Removed duplicated region for block: B:937:0x1c51  */
        /* JADX WARN: Removed duplicated region for block: B:938:0x1c54  */
        /* JADX WARN: Removed duplicated region for block: B:941:0x1c7e  */
        /* JADX WARN: Removed duplicated region for block: B:943:0x1c89  */
        /* JADX WARN: Removed duplicated region for block: B:995:0x1d6c  */
        /* JADX WARN: Removed duplicated region for block: B:996:0x1d7c  */
        /* JADX WARN: Type inference failed for: r0v159, types: [T, java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r0v535 */
        /* JADX WARN: Type inference failed for: r0v536 */
        /* JADX WARN: Type inference failed for: r0v537 */
        /* JADX WARN: Type inference failed for: r0v538 */
        /* JADX WARN: Type inference failed for: r0v539 */
        /* JADX WARN: Type inference failed for: r11v74, types: [T, com.stepos.core.common.telemetry.ModelCallOutcome] */
        /* JADX WARN: Type inference failed for: r13v85, types: [T, com.stepos.core.common.telemetry.ModelCallOutcome] */
        /* JADX WARN: Type inference failed for: r13v99, types: [T, com.stepos.core.common.telemetry.ModelCallOutcome] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r104) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 8775
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.executor.InferenceExecutor.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    public InferenceExecutor(d<?, ?> ability) {
        g.f(ability, "ability");
        this.ability = ability;
        this.TAG = "InferenceExecutor";
        this.inputConverter = new AbilityInputConverter();
        this.outputConverter = new AbilityOutputConverter();
        this.taskRecords = new ConcurrentHashMap<>();
        this.inFlight = new ConcurrentHashMap<>();
        this.watchdogKey = "InferenceExecutor-" + ability.getAbilityConfig().f11417b + "#" + InferenceExecutorKt.inferenceExecutorWatchdogSeq.incrementAndGet();
        this.watchdogLock = new Object();
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.stepos.core.ability.executor.a
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return InferenceExecutor.singleThreadExecutor$lambda$0(this.f7225a, runnable);
            }
        });
        this.singleThreadExecutor = singleThreadExecutor;
        g.e(singleThreadExecutor, "singleThreadExecutor");
        ExecutorCoroutineDispatcher executorCoroutineDispatcherFrom = ExecutorsKt.from(singleThreadExecutor);
        this.singleThreadDispatcher = executorCoroutineDispatcherFrom;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.supervisorJob = completableJobSupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(executorCoroutineDispatcherFrom.plus(completableJobSupervisorJob$default));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Job executeInternal$default(InferenceExecutor inferenceExecutor, String str, Content content, IResultHandler iResultHandler, zb.a aVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            aVar = null;
        }
        return inferenceExecutor.executeInternal(str, content, iResultHandler, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InferResult.RoutingDecision extractRoutingDecision(Object obj) {
        j7.d dVar = obj instanceof j7.d ? (j7.d) obj : null;
        if (dVar == null || dVar.getOrchestrationReason().length() == 0) {
            return null;
        }
        return new InferResult.RoutingDecision(dVar.getExecutionLocationName(), dVar.getOrchestrationReason());
    }

    private final Job launchMonitored(kotlin.coroutines.d dVar, p<? super CoroutineScope, ? super qb.b<? super n>, ? extends Object> pVar) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        synchronized (this.watchdogLock) {
            try {
                if (this.watchdogRefs == 0) {
                    m7.a aVar = m7.b.f10516b.get();
                    this.registeredWatchdog = aVar;
                    if (aVar != null) {
                        aVar.d(this.watchdogKey, this.singleThreadExecutor);
                    }
                }
                this.watchdogRefs++;
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, dVar, null, pVar, 2, null);
            jobLaunch$default.invokeOnCompletion(new com.stepos.ability.sdk.client.b(2, atomicBoolean, this));
            return jobLaunch$default;
        } catch (Throwable th2) {
            launchMonitored$finishMonitoring(atomicBoolean, this);
            throw th2;
        }
    }

    private static final void launchMonitored$finishMonitoring(AtomicBoolean atomicBoolean, InferenceExecutor inferenceExecutor) {
        if (atomicBoolean.compareAndSet(false, true)) {
            synchronized (inferenceExecutor.watchdogLock) {
                try {
                    int i10 = inferenceExecutor.watchdogRefs - 1;
                    inferenceExecutor.watchdogRefs = i10;
                    if (i10 == 0) {
                        m7.a aVar = inferenceExecutor.registeredWatchdog;
                        if (aVar != null) {
                            aVar.e(inferenceExecutor.watchdogKey);
                        }
                        inferenceExecutor.registeredWatchdog = null;
                    }
                    n nVar = n.f10413a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n launchMonitored$lambda$4$lambda$3(AtomicBoolean atomicBoolean, InferenceExecutor inferenceExecutor, Throwable th) {
        launchMonitored$finishMonitoring(atomicBoolean, inferenceExecutor);
        return n.f10413a;
    }

    private final int mapCloudHttpCode(int i10) {
        return CloudHttpErrorMapper.INSTANCE.toErrorCode(Integer.valueOf(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread singleThreadExecutor$lambda$0(InferenceExecutor inferenceExecutor, Runnable runnable) {
        return new Thread(runnable, inferenceExecutor.watchdogKey);
    }

    private final String userFacing(int i10, String str) {
        String strOrElse = CloudErrorUserMessage.INSTANCE.orElse(i10, str);
        if (!g.b(strOrElse, str)) {
            LogModule logModule = LogModule.ABILITY;
            String str2 = this.TAG;
            StringBuilder sbE = e.e("mapInferException: code=", i10, ", reason=", str, " (business sees: ");
            sbE.append(strOrElse);
            sbE.append(")");
            AIEngineLogger.w(logModule, str2, sbE.toString());
        }
        return strOrElse;
    }

    @Override // com.stepos.core.ability.executor.IInferenceExecutor
    public boolean cancel(String str) {
        return IInferenceExecutor.DefaultImpls.cancel(this, str);
    }

    @Override // com.stepos.core.ability.executor.IInferenceExecutor
    public Job execute(String requestId, Content input, IResultHandler resultHandler, AITaskRecord taskRecord) {
        g.f(requestId, "requestId");
        g.f(input, "input");
        g.f(resultHandler, "resultHandler");
        g.f(taskRecord, "taskRecord");
        this.taskRecords.put(requestId, taskRecord);
        return executeInternal$default(this, requestId, input, resultHandler, null, 8, null);
    }

    @SuppressLint({"NewApi"})
    public final Job executeInternal(String requestId, Content input, IResultHandler resultHandler, zb.a<n> aVar) {
        kotlin.coroutines.d aVar2;
        Object powerTracker;
        g.f(requestId, "requestId");
        g.f(input, "input");
        g.f(resultHandler, "resultHandler");
        if (this.supervisorJob.isCancelled()) {
            AIEngineLogger.w(LogModule.INFERENCE, this.TAG, "execute: executor released, ignoring requestId=".concat(requestId));
            resultHandler.onResult(requestId, new InferResult.Error(AIEngineError.ALREADY_CLOSED, "Executor released"));
            if (aVar != null) {
                aVar.invoke();
            }
            return null;
        }
        AIEngineLogger.d(LogModule.INFERENCE, this.TAG, "execute: requestId=".concat(requestId));
        Object objRemove = this.taskRecords.remove(requestId);
        this.inFlight.put(requestId, resultHandler);
        AITaskRecord aITaskRecord = objRemove instanceof AITaskRecord ? (AITaskRecord) objRemove : null;
        Object powerTracker2 = aITaskRecord != null ? aITaskRecord.getPowerTracker() : null;
        PowerPerfTracker powerPerfTracker = powerTracker2 instanceof PowerPerfTracker ? (PowerPerfTracker) powerTracker2 : null;
        if (aITaskRecord != null) {
            TaskPriority priority = aITaskRecord.getFinalTier();
            if (priority == null) {
                priority = aITaskRecord.getPriority();
            }
            g.f(priority, "priority");
            PoolType.f6214b.getClass();
            aVar2 = new com.stepos.base.concurrency.cpuset.a(PoolType.a.a(priority));
        } else {
            aVar2 = EmptyCoroutineContext.f10057a;
        }
        return launchMonitored(aVar2.plus((aITaskRecord == null || (powerTracker = aITaskRecord.getPowerTracker()) == null) ? EmptyCoroutineContext.f10057a : new TrackerContext(powerTracker)), new AnonymousClass1(requestId, aITaskRecord, objRemove, powerPerfTracker, input, resultHandler, aVar, null));
    }

    public final Pair<Integer, String> mapInferException$ability_release(Throwable e10) {
        Integer numValueOf = Integer.valueOf(AIEngineError.CLOUD_NETWORK_UNAVAILABLE);
        Integer numValueOf2 = Integer.valueOf(AIEngineError.CLOUD_REQUEST_TIMEOUT);
        g.f(e10, "e");
        if (e10 instanceof OrchestrationRejectedException) {
            OrchestrationRejectedException orchestrationRejectedException = (OrchestrationRejectedException) e10;
            int i10 = orchestrationRejectedException.f6394a;
            Integer numValueOf3 = Integer.valueOf(i10);
            String str = orchestrationRejectedException.f6395b;
            if (str == null) {
                str = "Orchestration rejected";
            }
            return new Pair<>(numValueOf3, userFacing(i10, str));
        }
        if (e10 instanceof BackpressureException) {
            Integer numValueOf4 = Integer.valueOf(AIEngineError.QUOTA_EXCEEDED);
            String message = e10.getMessage();
            if (message == null) {
                message = "系统繁忙";
            }
            return new Pair<>(numValueOf4, message + "|retryAfterMs=" + ((BackpressureException) e10).getRetryAfterMs());
        }
        if (e10 instanceof CircuitBreakerOpenException) {
            Integer numValueOf5 = Integer.valueOf(AIEngineError.CIRCUIT_BREAKER_OPEN);
            String message2 = e10.getMessage();
            if (message2 == null) {
                message2 = "服务暂时不可用";
            }
            return new Pair<>(numValueOf5, userFacing(AIEngineError.CIRCUIT_BREAKER_OPEN, message2));
        }
        if (e10 instanceof InferenceException) {
            InferenceException inferenceException = (InferenceException) e10;
            Integer numValueOf6 = Integer.valueOf(inferenceException.getErrorCode());
            int errorCode = inferenceException.getErrorCode();
            String message3 = e10.getMessage();
            if (message3 == null) {
                message3 = "Inference rejected";
            }
            return new Pair<>(numValueOf6, userFacing(errorCode, message3));
        }
        if (e10 instanceof ModelLoadException) {
            Integer num = ((ModelLoadException) e10).f6319a;
            int iIntValue = num != null ? num.intValue() : AIEngineError.MODEL_LOAD_FAILED;
            Integer numValueOf7 = Integer.valueOf(iIntValue);
            String message4 = e10.getMessage();
            if (message4 == null) {
                message4 = "Model load failed";
            }
            return new Pair<>(numValueOf7, userFacing(iIntValue, message4));
        }
        if (e10 instanceof PressureCancelledException) {
            Integer numValueOf8 = Integer.valueOf(AIEngineError.PRESSURE_CANCELLED);
            String message5 = e10.getMessage();
            if (message5 == null) {
                message5 = "内存压力，后台任务被取消";
            }
            return new Pair<>(numValueOf8, message5 + "|retryAfterMs=" + ((PressureCancelledException) e10).getRetryAfterMs());
        }
        if (e10 instanceof ContextOverflowException) {
            Integer numValueOf9 = Integer.valueOf(AIEngineError.INFERENCE_TOKEN_LIMIT_EXCEEDED);
            String message6 = e10.getMessage();
            if (message6 == null) {
                message6 = "上下文超出模型窗口限制";
            }
            return new Pair<>(numValueOf9, message6);
        }
        if (e10 instanceof AsrFileCloudTimeoutException) {
            String message7 = e10.getMessage();
            if (message7 == null) {
                message7 = "云端请求超时";
            }
            return new Pair<>(numValueOf2, userFacing(AIEngineError.CLOUD_REQUEST_TIMEOUT, message7));
        }
        if (e10 instanceof AsrFileCloudNetworkException) {
            String message8 = e10.getMessage();
            if (message8 == null) {
                message8 = "云端网络不可达";
            }
            return new Pair<>(numValueOf, userFacing(AIEngineError.CLOUD_NETWORK_UNAVAILABLE, message8));
        }
        if (e10 instanceof AsrFileCloudTaskFailedException) {
            Integer numValueOf10 = Integer.valueOf(AIEngineError.CLOUD_TASK_FAILED);
            String message9 = e10.getMessage();
            if (message9 == null) {
                message9 = "云端任务执行失败";
            }
            return new Pair<>(numValueOf10, userFacing(AIEngineError.CLOUD_TASK_FAILED, message9));
        }
        if (e10 instanceof AsrFileCloudAuthException) {
            AsrFileCloudAuthException asrFileCloudAuthException = (AsrFileCloudAuthException) e10;
            Integer numValueOf11 = Integer.valueOf(asrFileCloudAuthException.getErrorCode());
            int errorCode2 = asrFileCloudAuthException.getErrorCode();
            String message10 = e10.getMessage();
            if (message10 == null) {
                message10 = "云端鉴权失败";
            }
            return new Pair<>(numValueOf11, userFacing(errorCode2, message10));
        }
        if (e10 instanceof AsrSseCloudException) {
            AsrSseCloudException asrSseCloudException = (AsrSseCloudException) e10;
            Integer numValueOf12 = Integer.valueOf(asrSseCloudException.getErrorCode());
            int errorCode3 = asrSseCloudException.getErrorCode();
            String message11 = e10.getMessage();
            if (message11 == null) {
                message11 = "云端 ASR-SSE 失败";
            }
            return new Pair<>(numValueOf12, userFacing(errorCode3, message11));
        }
        if (e10 instanceof CloudApiException) {
            CloudApiException cloudApiException = (CloudApiException) e10;
            int iMapCloudHttpCode = mapCloudHttpCode(cloudApiException.getHttpCode());
            return new Pair<>(Integer.valueOf(iMapCloudHttpCode), userFacing(iMapCloudHttpCode, a0.a.g("Cloud HTTP ", cloudApiException.getHttpCode(), ": ", e10.getMessage())));
        }
        if (e10 instanceof TimeoutCancellationException) {
            String message12 = e10.getMessage();
            if (message12 == null) {
                message12 = "timeout";
            }
            return new Pair<>(numValueOf2, userFacing(AIEngineError.CLOUD_REQUEST_TIMEOUT, "云端上传/请求超时：".concat(message12)));
        }
        String message13 = e10.getMessage();
        if (message13 == null) {
            message13 = "";
        }
        return q.l0(message13, "cloud.endpoint", true) ? new Pair<>(Integer.valueOf(AIEngineError.CLOUD_ENDPOINT_NOT_CONFIGURED), message13) : (q.l0(message13, "no network", true) || q.l0(message13, "无网络", true)) ? new Pair<>(numValueOf, message13) : new Pair<>(Integer.valueOf(AIEngineError.INFERENCE_FAILED), "Inference error: ".concat(message13));
    }

    @Override // com.stepos.core.ability.executor.IInferenceExecutor
    public void release() {
        LogModule logModule = LogModule.INFERENCE;
        String str = this.TAG;
        i<Job> children = this.supervisorJob.getChildren();
        g.f(children, "<this>");
        Iterator<Job> it = children.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            it.next();
            i10++;
            if (i10 < 0) {
                m.e0();
                throw null;
            }
        }
        AIEngineLogger.d(logModule, str, "release: cancelling " + i10 + " running tasks");
        Set<String> setKeySet = this.inFlight.keySet();
        g.e(setKeySet, "<get-keys>(...)");
        List<String> listO0 = kotlin.collections.a.O0(setKeySet);
        if (!listO0.isEmpty()) {
            AIEngineLogger.w(LogModule.INFERENCE, this.TAG, "release: notifying " + listO0.size() + " in-flight request(s) with CANCELLED");
            for (String str2 : listO0) {
                IResultHandler iResultHandlerRemove = this.inFlight.remove(str2);
                if (iResultHandlerRemove != null) {
                    try {
                        g.c(str2);
                        iResultHandlerRemove.onResult(str2, new InferResult.Error(-100, "Inference cancelled: executor released"));
                        n nVar = n.f10413a;
                    } catch (Throwable th) {
                        kotlin.c.a(th);
                    }
                }
            }
        }
        Job.DefaultImpls.cancel$default(this.supervisorJob, null, 1, null);
        this.singleThreadDispatcher.close();
    }

    @Override // com.stepos.core.ability.executor.IInferenceExecutor
    public Job execute(String requestId, Content input, IResultHandler resultHandler, AITaskRecord taskRecord, zb.a<n> aVar) {
        g.f(requestId, "requestId");
        g.f(input, "input");
        g.f(resultHandler, "resultHandler");
        g.f(taskRecord, "taskRecord");
        this.taskRecords.put(requestId, taskRecord);
        return executeInternal(requestId, input, resultHandler, aVar);
    }

    @Override // com.stepos.core.ability.executor.IInferenceExecutor
    public void execute(String requestId, Content input, IResultHandler resultHandler) {
        g.f(requestId, "requestId");
        g.f(input, "input");
        g.f(resultHandler, "resultHandler");
        executeInternal$default(this, requestId, input, resultHandler, null, 8, null);
    }
}
