package com.stepos.core.model.inference;

import android.os.SystemClock;
import android.util.Log;
import b7.k;
import b7.s;
import com.stepos.base.inference.data.BackendType;
import com.stepos.base.model.ModelLoadException;
import com.stepos.core.common.log.AiEngineAtrace;
import com.stepos.core.common.telemetry.DataVolume;
import com.stepos.core.common.telemetry.InferenceTaskIdContext;
import com.stepos.core.common.telemetry.ModelCallFlywheelBizMapper;
import com.stepos.core.common.telemetry.PowerPerfTracker;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.model.manifest.ModelManifest;
import com.stepos.core.model.task.AITaskRecord;
import com.stepos.core.model.task.InferenceException;
import com.stepos.core.model.task.TaskSession;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import lb.n;
import mb.v;
import org.json.JSONException;
import x6.b;
import y6.b;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InferenceExecutorImpl implements x6.b {
    public static final Companion Companion = new Companion(null);
    private static volatile InferenceExecutorImpl INSTANCE = null;
    private static final String TAG = "InferenceExecutor";
    private final InferenceBackendSelector backendSelector;
    private final b7.b modelCache;
    private final x6.c postprocessor;
    private final x6.d preprocessor;
    private final ConcurrentHashMap<String, b7.a> runningModels;
    private final ConcurrentHashMap<String, ProducerScope<Result<? extends Object>>> runningScopes;
    private final ConcurrentHashMap<String, AtomicBoolean> runningTasks;
    private long successfulInferences;
    private long totalInferences;
    private long totalLatencyMs;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final InferenceExecutorImpl getInstance(InferenceBackendSelector backendSelector, b7.b modelCache) {
            InferenceExecutorImpl inferenceExecutorImpl;
            g.f(backendSelector, "backendSelector");
            g.f(modelCache, "modelCache");
            InferenceExecutorImpl inferenceExecutorImpl2 = InferenceExecutorImpl.INSTANCE;
            if (inferenceExecutorImpl2 != null) {
                return inferenceExecutorImpl2;
            }
            synchronized (this) {
                inferenceExecutorImpl = InferenceExecutorImpl.INSTANCE;
                if (inferenceExecutorImpl == null) {
                    InferenceExecutorImpl inferenceExecutorImpl3 = new InferenceExecutorImpl(backendSelector, modelCache, null, null, 12, null);
                    InferenceExecutorImpl.INSTANCE = inferenceExecutorImpl3;
                    inferenceExecutorImpl = inferenceExecutorImpl3;
                }
            }
            return inferenceExecutorImpl;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.inference.InferenceExecutorImpl$execute$2", f = "InferenceExecutorImpl.kt", l = {124, 197}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.inference.InferenceExecutorImpl$execute$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<ProducerScope<? super Result<? extends Object>>, qb.b<? super n>, Object> {
        final /* synthetic */ r6.a $decision;
        final /* synthetic */ Object $input;
        final /* synthetic */ k $modelConfig;
        final /* synthetic */ String $modelName;
        final /* synthetic */ AITaskRecord $record;
        final /* synthetic */ String $traceId;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ InferenceExecutorImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, String str2, AITaskRecord aITaskRecord, InferenceExecutorImpl inferenceExecutorImpl, Object obj, r6.a aVar, k kVar, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$traceId = str;
            this.$modelName = str2;
            this.$record = aITaskRecord;
            this.this$0 = inferenceExecutorImpl;
            this.$input = obj;
            this.$decision = aVar;
            this.$modelConfig = kVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n invokeSuspend$lambda$0(InferenceExecutorImpl inferenceExecutorImpl, AITaskRecord aITaskRecord, String str, long j10, String str2) throws JSONException {
            inferenceExecutorImpl.runningScopes.remove(aITaskRecord.getId());
            boolean z = da.b.f8415a;
            da.b.d(str, System.currentTimeMillis() - j10, v.b0(new Pair(ModelManifest.TYPE_MODEL, str2)), str2);
            return n.f10413a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$traceId, this.$modelName, this.$record, this.this$0, this.$input, this.$decision, this.$modelConfig, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x00c5, code lost:
        
            if (kotlinx.coroutines.channels.ProduceKt.awaitClose(r2, r16, r25) == r8) goto L16;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) throws org.json.JSONException {
            /*
                r25 = this;
                r7 = r25
                kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r0 = r7.label
                r9 = 2
                r1 = 1
                if (r0 == 0) goto L28
                if (r0 == r1) goto L1b
                if (r0 != r9) goto L13
                kotlin.c.b(r26)
                goto Lc8
            L13:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L1b:
                long r0 = r7.J$0
                java.lang.Object r2 = r7.L$0
                kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
                kotlin.c.b(r26)
                r20 = r0
                goto La5
            L28:
                kotlin.c.b(r26)
                java.lang.Object r0 = r7.L$0
                r15 = r0
                kotlinx.coroutines.channels.ProducerScope r15 = (kotlinx.coroutines.channels.ProducerScope) r15
                long r2 = java.lang.System.currentTimeMillis()
                java.util.concurrent.atomic.AtomicBoolean r11 = new java.util.concurrent.atomic.AtomicBoolean
                r0 = 0
                r11.<init>(r0)
                boolean r0 = da.b.f8415a
                java.lang.String r0 = r7.$traceId
                java.lang.String r4 = r7.$modelName
                kotlin.Pair r5 = new kotlin.Pair
                java.lang.String r6 = "model"
                r5.<init>(r6, r4)
                com.stepos.core.model.task.AITaskRecord r4 = r7.$record
                java.lang.String r4 = r4.getBackend()
                kotlin.Pair r6 = new kotlin.Pair
                java.lang.String r10 = "backend"
                r6.<init>(r10, r4)
                kotlin.Pair[] r4 = new kotlin.Pair[]{r5, r6}
                java.util.Map r4 = kotlin.collections.b.g0(r4)
                java.lang.String r5 = r7.$modelName
                da.b.e(r0, r4, r5)
                com.stepos.core.model.inference.InferenceExecutorImpl r0 = r7.this$0
                java.util.concurrent.ConcurrentHashMap r0 = com.stepos.core.model.inference.InferenceExecutorImpl.access$getRunningScopes$p(r0)
                com.stepos.core.model.task.AITaskRecord r4 = r7.$record
                java.lang.String r4 = r4.getId()
                r0.put(r4, r15)
                com.stepos.core.model.inference.InferenceExecutorImpl r0 = r7.this$0
                com.stepos.core.model.task.AITaskRecord r4 = r7.$record
                java.lang.String r4 = r4.getId()
                java.lang.Object r5 = r7.$input
                r6.a r6 = r7.$decision
                r16 = r4
                b7.k r4 = r7.$modelConfig
                com.stepos.core.model.task.AITaskRecord r14 = r7.$record
                com.stepos.core.model.inference.InferenceExecutorImpl$execute$2$1 r10 = new com.stepos.core.model.inference.InferenceExecutorImpl$execute$2$1
                java.lang.String r12 = r7.$traceId
                java.lang.String r13 = r7.$modelName
                r10.<init>()
                r7.L$0 = r15
                r7.J$0 = r2
                r7.label = r1
                r23 = r2
                r3 = r6
                r6 = r10
                r10 = r23
                r2 = r5
                r5 = r14
                r1 = r16
                java.lang.Object r0 = com.stepos.core.model.inference.InferenceExecutorImpl.access$executeStreamInternal(r0, r1, r2, r3, r4, r5, r6, r7)
                if (r0 != r8) goto La2
                goto Lc7
            La2:
                r20 = r10
                r2 = r15
            La5:
                com.stepos.core.model.inference.InferenceExecutorImpl r0 = r7.this$0
                com.stepos.core.model.task.AITaskRecord r1 = r7.$record
                java.lang.String r3 = r7.$traceId
                java.lang.String r4 = r7.$modelName
                com.stepos.core.model.inference.c r16 = new com.stepos.core.model.inference.c
                r17 = r0
                r18 = r1
                r19 = r3
                r22 = r4
                r16.<init>()
                r0 = r16
                r1 = 0
                r7.L$0 = r1
                r7.label = r9
                java.lang.Object r0 = kotlinx.coroutines.channels.ProduceKt.awaitClose(r2, r0, r7)
                if (r0 != r8) goto Lc8
            Lc7:
                return r8
            Lc8:
                lb.n r0 = lb.n.f10413a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.inference.InferenceExecutorImpl.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(ProducerScope<? super Result<? extends Object>> producerScope, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(producerScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.inference.InferenceExecutorImpl$execute$4", f = "InferenceExecutorImpl.kt", l = {253, 308}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.inference.InferenceExecutorImpl$execute$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements p<ProducerScope<? super Result<? extends Object>>, qb.b<? super n>, Object> {
        final /* synthetic */ r6.a $decision;
        final /* synthetic */ Object $input;
        final /* synthetic */ k $modelConfig;
        final /* synthetic */ String $modelName;
        final /* synthetic */ TaskSession $session;
        final /* synthetic */ String $traceId;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ InferenceExecutorImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(String str, String str2, k kVar, InferenceExecutorImpl inferenceExecutorImpl, TaskSession taskSession, Object obj, r6.a aVar, qb.b<? super AnonymousClass4> bVar) {
            super(2, bVar);
            this.$traceId = str;
            this.$modelName = str2;
            this.$modelConfig = kVar;
            this.this$0 = inferenceExecutorImpl;
            this.$session = taskSession;
            this.$input = obj;
            this.$decision = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n invokeSuspend$lambda$0(InferenceExecutorImpl inferenceExecutorImpl, TaskSession taskSession, String str, long j10, String str2) throws JSONException {
            inferenceExecutorImpl.runningScopes.remove(taskSession.getRequest().f9710a);
            boolean z = da.b.f8415a;
            da.b.d(str, System.currentTimeMillis() - j10, v.b0(new Pair(ModelManifest.TYPE_MODEL, str2)), str2);
            return n.f10413a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$traceId, this.$modelName, this.$modelConfig, this.this$0, this.$session, this.$input, this.$decision, bVar);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x00cb, code lost:
        
            if (kotlinx.coroutines.channels.ProduceKt.awaitClose(r2, r15, r22) == r10) goto L16;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) throws org.json.JSONException {
            /*
                r22 = this;
                r7 = r22
                kotlin.coroutines.intrinsics.CoroutineSingletons r10 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r0 = r7.label
                r11 = 2
                r1 = 1
                if (r0 == 0) goto L28
                if (r0 == r1) goto L1b
                if (r0 != r11) goto L13
                kotlin.c.b(r23)
                goto Lce
            L13:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L1b:
                long r0 = r7.J$0
                java.lang.Object r2 = r7.L$0
                kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
                kotlin.c.b(r23)
                r19 = r0
                goto Lad
            L28:
                kotlin.c.b(r23)
                java.lang.Object r0 = r7.L$0
                kotlinx.coroutines.channels.ProducerScope r0 = (kotlinx.coroutines.channels.ProducerScope) r0
                long r2 = java.lang.System.currentTimeMillis()
                java.util.concurrent.atomic.AtomicBoolean r13 = new java.util.concurrent.atomic.AtomicBoolean
                r4 = 0
                r13.<init>(r4)
                boolean r4 = da.b.f8415a
                java.lang.String r4 = r7.$traceId
                java.lang.String r5 = r7.$modelName
                kotlin.Pair r6 = new kotlin.Pair
                java.lang.String r8 = "model"
                r6.<init>(r8, r5)
                b7.k r5 = r7.$modelConfig
                com.stepos.base.model.InferenceConfig r5 = r5.f3096g
                java.lang.String r5 = r5.f6263a
                kotlin.Pair r8 = new kotlin.Pair
                java.lang.String r9 = "backend"
                r8.<init>(r9, r5)
                kotlin.Pair[] r5 = new kotlin.Pair[]{r6, r8}
                java.util.Map r5 = kotlin.collections.b.g0(r5)
                java.lang.String r6 = r7.$modelName
                da.b.e(r4, r5, r6)
                com.stepos.core.model.inference.InferenceExecutorImpl r4 = r7.this$0
                java.util.concurrent.ConcurrentHashMap r4 = com.stepos.core.model.inference.InferenceExecutorImpl.access$getRunningScopes$p(r4)
                com.stepos.core.model.task.TaskSession r5 = r7.$session
                j7.e r5 = r5.getRequest()
                java.lang.String r5 = r5.f9710a
                r4.put(r5, r0)
                r17 = r0
                com.stepos.core.model.inference.InferenceExecutorImpl r0 = r7.this$0
                com.stepos.core.model.task.TaskSession r4 = r7.$session
                j7.e r4 = r4.getRequest()
                java.lang.String r4 = r4.f9710a
                java.lang.Object r5 = r7.$input
                r6.a r6 = r7.$decision
                r8 = r4
                b7.k r4 = r7.$modelConfig
                com.stepos.core.model.inference.InferenceExecutorImpl$execute$4$1 r12 = new com.stepos.core.model.inference.InferenceExecutorImpl$execute$4$1
                java.lang.String r14 = r7.$traceId
                java.lang.String r15 = r7.$modelName
                com.stepos.core.model.task.TaskSession r9 = r7.$session
                r16 = r9
                r12.<init>()
                r9 = r6
                r6 = r12
                r12 = r17
                r7.L$0 = r12
                r7.J$0 = r2
                r7.label = r1
                r13 = r2
                r2 = r5
                r5 = 0
                r1 = r8
                r8 = 16
                r3 = r9
                r9 = 0
                java.lang.Object r0 = com.stepos.core.model.inference.InferenceExecutorImpl.executeStreamInternal$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
                if (r0 != r10) goto Laa
                goto Lcd
            Laa:
                r2 = r12
                r19 = r13
            Lad:
                com.stepos.core.model.inference.InferenceExecutorImpl r0 = r7.this$0
                com.stepos.core.model.task.TaskSession r1 = r7.$session
                java.lang.String r3 = r7.$traceId
                java.lang.String r4 = r7.$modelName
                com.stepos.core.model.inference.d r15 = new com.stepos.core.model.inference.d
                r16 = r0
                r17 = r1
                r18 = r3
                r21 = r4
                r15.<init>()
                r0 = 0
                r7.L$0 = r0
                r7.label = r11
                java.lang.Object r0 = kotlinx.coroutines.channels.ProduceKt.awaitClose(r2, r15, r7)
                if (r0 != r10) goto Lce
            Lcd:
                return r10
            Lce:
                lb.n r0 = lb.n.f10413a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.inference.InferenceExecutorImpl.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(ProducerScope<? super Result<? extends Object>> producerScope, qb.b<? super n> bVar) {
            return ((AnonymousClass4) create(producerScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.inference.InferenceExecutorImpl$execute$5", f = "InferenceExecutorImpl.kt", l = {369, 373}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.inference.InferenceExecutorImpl$execute$5, reason: invalid class name */
    public static final class AnonymousClass5 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ b.InterfaceC0168b $callback;
        final /* synthetic */ SyncContext $ctx;
        final /* synthetic */ r6.a $decision;
        final /* synthetic */ Object $input;
        final /* synthetic */ String $taskId;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(r6.a aVar, String str, b.InterfaceC0168b interfaceC0168b, Object obj, SyncContext syncContext, qb.b<? super AnonymousClass5> bVar) {
            super(2, bVar);
            this.$decision = aVar;
            this.$taskId = str;
            this.$callback = interfaceC0168b;
            this.$input = obj;
            this.$ctx = syncContext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return InferenceExecutorImpl.this.new AnonymousClass5(this.$decision, this.$taskId, this.$callback, this.$input, this.$ctx, bVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            BackendType backendTypeSelect;
            long jLongValue;
            Object objAcquireSyncModel;
            k kVar;
            Object obj2;
            n nVar;
            b7.n nVar2;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            try {
                try {
                } catch (Exception e10) {
                    InferenceExecutorImpl.this.handleSyncError(this.$taskId, e10, this.$ctx.getModelConfig(), this.$callback);
                }
                if (i10 == 0) {
                    kotlin.c.b(obj);
                    backendTypeSelect = InferenceExecutorImpl.this.backendSelector.select(this.$decision);
                    Log.i(InferenceExecutorImpl.TAG, "Execute inference: taskId=" + this.$taskId + ", backend=" + backendTypeSelect);
                    this.$callback.d();
                    if (InferenceExecutorImpl.this.isRunning(this.$taskId)) {
                        k kVarResolveSyncConfig = InferenceExecutorImpl.this.resolveSyncConfig(this.$taskId, this.$input, this.$callback);
                        if (kVarResolveSyncConfig == null) {
                            nVar = n.f10413a;
                        } else {
                            this.$ctx.setModelConfig(kVarResolveSyncConfig);
                            Pair pairPreprocess = InferenceExecutorImpl.this.preprocess(this.$input, kVarResolveSyncConfig);
                            Object obj3 = pairPreprocess.f9985a;
                            jLongValue = ((Number) pairPreprocess.f9986b).longValue();
                            InferenceExecutorImpl.this.modelCache.onPreInit(kVarResolveSyncConfig);
                            InferenceExecutorImpl inferenceExecutorImpl = InferenceExecutorImpl.this;
                            String str = this.$taskId;
                            b.InterfaceC0168b interfaceC0168b = this.$callback;
                            this.L$0 = backendTypeSelect;
                            this.L$1 = kVarResolveSyncConfig;
                            this.L$2 = obj3;
                            this.J$0 = jLongValue;
                            this.label = 1;
                            objAcquireSyncModel = inferenceExecutorImpl.acquireSyncModel(str, kVarResolveSyncConfig, interfaceC0168b, true, this);
                            if (objAcquireSyncModel == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            kVar = kVarResolveSyncConfig;
                            obj2 = obj3;
                        }
                    } else {
                        b.InterfaceC0168b interfaceC0168b2 = this.$callback;
                        String taskId = this.$taskId;
                        g.f(taskId, "taskId");
                        interfaceC0168b2.onComplete();
                        nVar = n.f10413a;
                    }
                    return nVar;
                }
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    nVar2 = (b7.n) this.L$0;
                    try {
                        kotlin.c.b(obj);
                        nVar2.close();
                        return n.f10413a;
                    } catch (Throwable th) {
                        th = th;
                        nVar2.close();
                        throw th;
                    }
                }
                long j10 = this.J$0;
                Object obj4 = this.L$2;
                k kVar2 = (k) this.L$1;
                BackendType backendType = (BackendType) this.L$0;
                kotlin.c.b(obj);
                jLongValue = j10;
                backendTypeSelect = backendType;
                objAcquireSyncModel = obj;
                kVar = kVar2;
                obj2 = obj4;
                Pair pair = (Pair) objAcquireSyncModel;
                if (pair == null) {
                    nVar = n.f10413a;
                    return nVar;
                }
                b7.n nVar3 = (b7.n) pair.f9985a;
                boolean zBooleanValue = ((Boolean) pair.f9986b).booleanValue();
                try {
                    InferenceExecutorImpl inferenceExecutorImpl2 = InferenceExecutorImpl.this;
                    SyncContext syncContext = this.$ctx;
                    long j11 = jLongValue;
                    b.InterfaceC0168b interfaceC0168b3 = this.$callback;
                    this.L$0 = nVar3;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 2;
                    if (inferenceExecutorImpl2.performSyncInference(syncContext, nVar3, obj2, kVar, backendTypeSelect, j11, zBooleanValue, interfaceC0168b3, this) != coroutineSingletons) {
                        nVar2 = nVar3;
                        nVar2.close();
                        return n.f10413a;
                    }
                    return coroutineSingletons;
                } catch (Throwable th2) {
                    th = th2;
                    nVar2 = nVar3;
                    nVar2.close();
                    throw th;
                }
            } finally {
                InferenceExecutorImpl.this.runningTasks.remove(this.$taskId);
            }
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass5) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.inference.InferenceExecutorImpl$executeStream$1", f = "InferenceExecutorImpl.kt", l = {526}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.inference.InferenceExecutorImpl$executeStream$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ b.c $callback;
        final /* synthetic */ r6.a $decision;
        final /* synthetic */ Object $input;
        final /* synthetic */ String $taskId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, Object obj, r6.a aVar, b.c cVar, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$taskId = str;
            this.$input = obj;
            this.$decision = aVar;
            this.$callback = cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return InferenceExecutorImpl.this.new AnonymousClass1(this.$taskId, this.$input, this.$decision, this.$callback, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                InferenceExecutorImpl inferenceExecutorImpl = InferenceExecutorImpl.this;
                String str = this.$taskId;
                Object obj2 = this.$input;
                r6.a aVar = this.$decision;
                b.c cVar = this.$callback;
                this.label = 1;
                if (InferenceExecutorImpl.executeStreamInternal$default(inferenceExecutorImpl, str, obj2, aVar, null, null, cVar, this, 16, null) == coroutineSingletons) {
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
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.inference.InferenceExecutorImpl$executeStreamInternal$2", f = "InferenceExecutorImpl.kt", l = {594, 606}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.inference.InferenceExecutorImpl$executeStreamInternal$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03772 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ b.c $callback;
        final /* synthetic */ StreamContext $context;
        final /* synthetic */ r6.a $decision;
        final /* synthetic */ Object $input;
        final /* synthetic */ k $modelConfig;
        final /* synthetic */ AITaskRecord $record;
        final /* synthetic */ String $taskId;
        final /* synthetic */ PowerPerfTracker $tracker;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ InferenceExecutorImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03772(PowerPerfTracker powerPerfTracker, InferenceExecutorImpl inferenceExecutorImpl, r6.a aVar, String str, b.c cVar, Object obj, k kVar, StreamContext streamContext, AITaskRecord aITaskRecord, qb.b<? super C03772> bVar) {
            super(2, bVar);
            this.$tracker = powerPerfTracker;
            this.this$0 = inferenceExecutorImpl;
            this.$decision = aVar;
            this.$taskId = str;
            this.$callback = cVar;
            this.$input = obj;
            this.$modelConfig = kVar;
            this.$context = streamContext;
            this.$record = aITaskRecord;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DataVolume invokeSuspend$lambda$2$lambda$1(int i10, DataVolume dataVolume) {
            return DataVolume.copy$default(dataVolume, null, null, null, null, null, null, null, null, Integer.valueOf(i10), 255, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            C03772 c03772 = new C03772(this.$tracker, this.this$0, this.$decision, this.$taskId, this.$callback, this.$input, this.$modelConfig, this.$context, this.$record, bVar);
            c03772.L$0 = obj;
            return c03772;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:66:0x01b5 A[Catch: all -> 0x0029, TRY_LEAVE, TryCatch #3 {all -> 0x0029, blocks: (B:7:0x0020, B:64:0x01ad, B:66:0x01b5, B:69:0x01c7, B:71:0x01cb, B:79:0x01f6, B:80:0x01f9, B:60:0x0196, B:72:0x01cd, B:74:0x01e8, B:77:0x01f3), top: B:97:0x000c, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01c7 A[Catch: all -> 0x0029, TRY_ENTER, TryCatch #3 {all -> 0x0029, blocks: (B:7:0x0020, B:64:0x01ad, B:66:0x01b5, B:69:0x01c7, B:71:0x01cb, B:79:0x01f6, B:80:0x01f9, B:60:0x0196, B:72:0x01cd, B:74:0x01e8, B:77:0x01f3), top: B:97:0x000c, inners: #0 }] */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v21, types: [b7.n] */
        /* JADX WARN: Type inference failed for: r2v25 */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v4, types: [b7.n] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instructions count: 594
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.inference.InferenceExecutorImpl.C03772.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C03772) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.inference.InferenceExecutorImpl", f = "InferenceExecutorImpl.kt", l = {733, 733}, m = "performStreaming")
    /* renamed from: com.stepos.core.model.inference.InferenceExecutorImpl$performStreaming$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03781 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C03781(qb.b<? super C03781> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InferenceExecutorImpl.this.performStreaming(null, null, null, null, null, null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.inference.InferenceExecutorImpl", f = "InferenceExecutorImpl.kt", l = {456}, m = "performSyncInference")
    /* renamed from: com.stepos.core.model.inference.InferenceExecutorImpl$performSyncInference$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03801 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C03801(qb.b<? super C03801> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InferenceExecutorImpl.this.performSyncInference(null, null, null, null, null, 0L, false, null, this);
        }
    }

    public InferenceExecutorImpl(InferenceBackendSelector backendSelector, b7.b modelCache, x6.d preprocessor, x6.c postprocessor) {
        g.f(backendSelector, "backendSelector");
        g.f(modelCache, "modelCache");
        g.f(preprocessor, "preprocessor");
        g.f(postprocessor, "postprocessor");
        this.backendSelector = backendSelector;
        this.modelCache = modelCache;
        this.preprocessor = preprocessor;
        this.postprocessor = postprocessor;
        this.runningTasks = new ConcurrentHashMap<>();
        this.runningScopes = new ConcurrentHashMap<>();
        this.runningModels = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object acquireModel(String str, k kVar, b.c cVar, boolean z, qb.b<? super Pair<b7.n, Boolean>> bVar) {
        Integer num;
        AiEngineAtrace.begin(str, ModelCallFlywheelBizMapper.MODEL_PATH_EDGE, "model_acquire");
        try {
            boolean zContains = this.modelCache.contains(kVar.f3090a);
            Log.d(TAG, "Acquiring model: " + kVar.f3090a + ", cacheHit=" + zContains);
            ModelCacheImpl modelCacheImpl = s.f3120b;
            if (modelCacheImpl == null) {
                throw new IllegalStateException("VersionedModelCache not available");
            }
            b7.n nVarAcquire = modelCacheImpl.acquire(kVar.f3090a, z);
            if (nVarAcquire == null) {
                nVarAcquire = modelCacheImpl.acquire(kVar.f3090a);
            }
            return new Pair(nVarAcquire, Boolean.valueOf(zContains));
        } catch (Exception e10) {
            Log.e(TAG, "Failed to acquire model: ".concat(kVar.f3090a), e10);
            ModelLoadException modelLoadException = e10 instanceof ModelLoadException ? (ModelLoadException) e10 : null;
            int iIntValue = (modelLoadException == null || (num = modelLoadException.f6319a) == null) ? AIEngineError.MODEL_LOAD_FAILED : num.intValue();
            cVar.onError(iIntValue, "Failed to acquire model: " + e10.getMessage());
            return null;
        } finally {
            AiEngineAtrace.end(str, ModelCallFlywheelBizMapper.MODEL_PATH_EDGE, "model_acquire");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object acquireSyncModel(String taskId, k kVar, b.InterfaceC0168b interfaceC0168b, boolean z, qb.b<? super Pair<b7.n, Boolean>> bVar) {
        AiEngineAtrace.begin(taskId, ModelCallFlywheelBizMapper.MODEL_PATH_EDGE, "model_acquire");
        try {
            try {
                boolean zContains = this.modelCache.contains(kVar.f3090a);
                Log.d(TAG, "Acquiring model: " + kVar.f3090a + ", cacheHit=" + zContains);
                ModelCacheImpl modelCacheImpl = s.f3120b;
                if (modelCacheImpl == null) {
                    throw new IllegalStateException("VersionedModelCache not available");
                }
                b7.n nVarAcquire = modelCacheImpl.acquire(kVar.f3090a, z);
                if (nVarAcquire == null) {
                    nVarAcquire = modelCacheImpl.acquire(kVar.f3090a);
                }
                return new Pair(nVarAcquire, Boolean.valueOf(zContains));
            } catch (Exception e10) {
                Log.e(TAG, "Failed to acquire model: ".concat(kVar.f3090a), e10);
                String errorMessage = "Failed to acquire model: " + e10.getMessage();
                g.f(taskId, "taskId");
                g.f(errorMessage, "errorMessage");
                interfaceC0168b.onComplete();
                AiEngineAtrace.end(taskId, ModelCallFlywheelBizMapper.MODEL_PATH_EDGE, "model_acquire");
                return null;
            }
        } finally {
            AiEngineAtrace.end(taskId, ModelCallFlywheelBizMapper.MODEL_PATH_EDGE, "model_acquire");
        }
    }

    private final y6.b buildOptions(BackendType value, r6.a aVar) {
        b.a aVar2 = new b.a();
        g.f(value, "value");
        aVar2.f14144a = value;
        aVar2.f14145b = aVar.f11740d;
        aVar2.f14146c = aVar.f11742f;
        aVar2.f14147d = true;
        return new y6.b(aVar2.f14144a, aVar2.f14145b, aVar2.f14146c, aVar2.f14147d, aVar2.f14148e, aVar2.f14149f, aVar2.f14150g, aVar2.h, aVar2.f14151i, aVar2.f14152j, aVar2.f14153k, aVar2.f14154l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void completeStreaming(String taskId, final StreamContext streamContext, BackendType backend, long j10, b.c cVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        final k modelConfig = streamContext.getModelConfig();
        Object objSection = AiEngineAtrace.section(ModelCallFlywheelBizMapper.MODEL_PATH_EDGE, "postprocess", new zb.a() { // from class: com.stepos.core.model.inference.b
            @Override // zb.a
            public final Object invoke() {
                return InferenceExecutorImpl.completeStreaming$lambda$11(modelConfig, this, streamContext);
            }
        });
        long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis2;
        int tokenCount = streamContext.getTokenCount();
        long firstTokenTime = streamContext.getFirstTokenTime() > 0 ? streamContext.getFirstTokenTime() - streamContext.getStartTime() : 0L;
        long startTime = jCurrentTimeMillis - streamContext.getStartTime();
        boolean modelCacheHit = streamContext.getModelCacheHit();
        g.f(taskId, "taskId");
        g.f(backend, "backend");
        y6.c cVar2 = new y6.c(taskId, true, objSection, tokenCount, firstTokenTime, startTime, startTime > 0 ? (tokenCount * 1000.0f) / startTime : 0.0f, backend, 0, null, j10, jCurrentTimeMillis3, modelCacheHit, 3840);
        updateStatistics(cVar2);
        if (streamContext.getTokenCount() > 0) {
            confirmModelVersionHealthy(modelConfig != null ? modelConfig.f3090a : null);
        }
        cVar.onComplete(cVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object completeStreaming$lambda$11(k kVar, InferenceExecutorImpl inferenceExecutorImpl, StreamContext streamContext) {
        Object objA;
        if (kVar == null) {
            String string = streamContext.getTokenBuilder().toString();
            g.c(string);
            return string;
        }
        try {
            x6.c cVar = inferenceExecutorImpl.postprocessor;
            String string2 = streamContext.getTokenBuilder().toString();
            g.e(string2, "toString(...)");
            objA = cVar.process(string2, kVar);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return objA instanceof Result.Failure ? streamContext.getTokenBuilder().toString() : objA;
    }

    private final void confirmModelVersionHealthy(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            ModelCacheImpl modelCacheImpl = s.f3120b;
            if (modelCacheImpl == null) {
                modelCacheImpl = null;
            }
            if (modelCacheImpl != null) {
                modelCacheImpl.confirmVersionHealthy(str);
                n nVar = n.f10413a;
            }
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object executeStreamInternal(String str, Object obj, r6.a aVar, k kVar, AITaskRecord aITaskRecord, b.c cVar, qb.b<? super n> bVar) {
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        if (aITaskRecord != null) {
            aITaskRecord.setStartedAtMonoNs(jElapsedRealtimeNanos);
        }
        Object powerTracker = aITaskRecord != null ? aITaskRecord.getPowerTracker() : null;
        PowerPerfTracker powerPerfTracker = powerTracker instanceof PowerPerfTracker ? (PowerPerfTracker) powerTracker : null;
        if (powerPerfTracker != null) {
            powerPerfTracker.setStartedAtMonoNs(jElapsedRealtimeNanos);
        }
        AiEngineAtrace.end(str, "infer", "queue_wait");
        StreamContext streamContext = new StreamContext(str, System.currentTimeMillis(), 0L, 0, null, false, null, 124, null);
        this.runningTasks.put(str, new AtomicBoolean(true));
        Object objWithContext = BuildersKt.withContext(new InferenceTaskIdContext(str), new C03772(powerPerfTracker, this, aVar, str, cVar, obj, kVar, streamContext, aITaskRecord, null), bVar);
        return objWithContext == CoroutineSingletons.f10059a ? objWithContext : n.f10413a;
    }

    public static /* synthetic */ Object executeStreamInternal$default(InferenceExecutorImpl inferenceExecutorImpl, String str, Object obj, r6.a aVar, k kVar, AITaskRecord aITaskRecord, b.c cVar, qb.b bVar, int i10, Object obj2) {
        if ((i10 & 16) != 0) {
            aITaskRecord = null;
        }
        return inferenceExecutorImpl.executeStreamInternal(str, obj, aVar, kVar, aITaskRecord, cVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleStreamError(String str, Exception exc, k kVar, b.c cVar) {
        Integer num;
        logModelInferenceError(str, null, exc);
        ModelLoadException modelLoadException = exc instanceof ModelLoadException ? (ModelLoadException) exc : null;
        int iIntValue = (modelLoadException == null || (num = modelLoadException.f6319a) == null) ? AIEngineError.INFERENCE_FAILED : num.intValue();
        String message = exc.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        cVar.onError(iIntValue, message, exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSyncError(String taskId, Exception exc, k kVar, b.InterfaceC0168b interfaceC0168b) {
        logModelInferenceError(taskId, null, exc);
        exc.getMessage();
        g.f(taskId, "taskId");
        interfaceC0168b.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void logModelInferenceError(java.lang.String r3, java.lang.String r4, java.lang.Throwable r5) {
        /*
            r2 = this;
            if (r4 == 0) goto Lc
            int r2 = r4.length()
            if (r2 <= 0) goto L9
            goto La
        L9:
            r4 = 0
        La:
            if (r4 != 0) goto Ld
        Lc:
            r4 = r3
        Ld:
            com.stepos.core.common.log.LogModule r2 = com.stepos.core.common.log.LogModule.INFERENCE
            java.lang.String r0 = "Model inference error: inferId="
            java.lang.String r1 = " taskId="
            java.lang.String r3 = ai.onnxruntime.a.l(r0, r4, r1, r3)
            java.lang.String r4 = "InferenceExecutor"
            com.stepos.core.common.log.AIEngineLogger.e(r2, r4, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.inference.InferenceExecutorImpl.logModelInferenceError(java.lang.String, java.lang.String, java.lang.Throwable):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ce, code lost:
    
        if (((kotlinx.coroutines.flow.Flow) r0).collect(r12, r1) == r2) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object performStreaming(java.lang.String r15, b7.n r16, java.lang.Object r17, b7.k r18, com.stepos.core.model.inference.InferenceExecutorImpl.StreamContext r19, x6.b.c r20, com.stepos.core.common.telemetry.PowerPerfTracker r21, zb.a<lb.n> r22, qb.b<? super java.lang.Boolean> r23) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.inference.InferenceExecutorImpl.performStreaming(java.lang.String, b7.n, java.lang.Object, b7.k, com.stepos.core.model.inference.InferenceExecutorImpl$StreamContext, x6.b$c, com.stepos.core.common.telemetry.PowerPerfTracker, zb.a, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object performSyncInference(com.stepos.core.model.inference.InferenceExecutorImpl.SyncContext r30, b7.n r31, java.lang.Object r32, b7.k r33, com.stepos.base.inference.data.BackendType r34, long r35, boolean r37, x6.b.InterfaceC0168b r38, qb.b<? super lb.n> r39) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.inference.InferenceExecutorImpl.performSyncInference(com.stepos.core.model.inference.InferenceExecutorImpl$SyncContext, b7.n, java.lang.Object, b7.k, com.stepos.base.inference.data.BackendType, long, boolean, x6.b$b, qb.b):java.lang.Object");
    }

    private final Pair<Object, Long> postprocess(Object obj, k kVar) {
        return new Pair<>(AiEngineAtrace.section(ModelCallFlywheelBizMapper.MODEL_PATH_EDGE, "postprocess", new a(this, obj, kVar, 1)), Long.valueOf(System.currentTimeMillis() - System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object postprocess$lambda$7(InferenceExecutorImpl inferenceExecutorImpl, Object obj, k kVar) {
        Object objA;
        try {
            objA = inferenceExecutorImpl.postprocessor.process(obj, kVar);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return objA instanceof Result.Failure ? obj : objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Object, Long> preprocess(Object obj, k kVar) {
        return new Pair<>(AiEngineAtrace.section(ModelCallFlywheelBizMapper.MODEL_PATH_EDGE, "preprocess", new a(this, obj, kVar, 0)), Long.valueOf(System.currentTimeMillis() - System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object preprocess$lambda$9(InferenceExecutorImpl inferenceExecutorImpl, Object obj, k kVar) {
        Object objA;
        try {
            objA = inferenceExecutorImpl.preprocessor.process(obj, kVar);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return objA instanceof Result.Failure ? obj : objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k resolveConfig(String str, Object obj, k kVar, b.c cVar) {
        if (kVar != null) {
            return kVar;
        }
        Log.e(TAG, "ModelConfig required; use execute(AITaskRecord). taskId=" + str + " inputType=" + obj.getClass().getSimpleName());
        cVar.onError(AIEngineError.INFERENCE_FAILED, "ModelConfig required");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k resolveSyncConfig(String taskId, Object obj, b.InterfaceC0168b interfaceC0168b) {
        Log.e(TAG, "IInferenceExecutor.execute() without ModelConfig is unsupported; use execute(AITaskRecord). taskId=" + taskId + " inputType=" + obj.getClass().getSimpleName());
        g.f(taskId, "taskId");
        interfaceC0168b.onComplete();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int streamErrorCode(Throwable th) {
        if (!(th instanceof ModelLoadException)) {
            return AIEngineError.INFERENCE_FAILED;
        }
        Integer num = ((ModelLoadException) th).f6319a;
        return num != null ? num.intValue() : AIEngineError.MODEL_LOAD_FAILED;
    }

    private final void updateStatistics(y6.c cVar) {
        this.totalInferences++;
        if (cVar.f14156b) {
            this.successfulInferences++;
            this.totalLatencyMs += cVar.f14160f;
        }
    }

    public boolean cancel(String taskId) {
        Object objA;
        g.f(taskId, "taskId");
        AtomicBoolean atomicBoolean = this.runningTasks.get(taskId);
        if (atomicBoolean == null) {
            return false;
        }
        boolean zCompareAndSet = atomicBoolean.compareAndSet(true, false);
        try {
            b7.a aVar = this.runningModels.get(taskId);
            objA = Boolean.valueOf(aVar != null ? aVar.cancel() : false);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.w(TAG, "cancel: native cancel failed taskId=".concat(taskId), thB);
        }
        Boolean bool = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = bool;
        }
        boolean zBooleanValue = ((Boolean) objA).booleanValue();
        ProducerScope<Result<? extends Object>> producerScope = this.runningScopes.get(taskId);
        if (producerScope != null) {
            SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
        }
        if (zCompareAndSet || zBooleanValue) {
            Log.i(TAG, "Cancelled inference: taskId=" + taskId + " (closing flow, nativeCancelled=" + zBooleanValue + ")");
        }
        return zCompareAndSet || zBooleanValue;
    }

    public final boolean deliverErrorAndCancel(String taskId, int i10, String message) {
        Object objA;
        g.f(taskId, "taskId");
        g.f(message, "message");
        AtomicBoolean atomicBoolean = this.runningTasks.get(taskId);
        boolean zCompareAndSet = atomicBoolean != null ? atomicBoolean.compareAndSet(true, false) : false;
        try {
            b7.a aVar = this.runningModels.get(taskId);
            objA = Boolean.valueOf(aVar != null ? aVar.cancel() : false);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.w(TAG, "deliverErrorAndCancel: native cancel failed taskId=".concat(taskId), thB);
        }
        Boolean bool = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = bool;
        }
        boolean zBooleanValue = ((Boolean) objA).booleanValue();
        ProducerScope<Result<? extends Object>> producerScope = this.runningScopes.get(taskId);
        if (producerScope != null) {
            producerScope.mo149trySendJP2dKIU(new Result<>(kotlin.c.a(new InferenceException(i10, message))));
            SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
        }
        StringBuilder sbF = h0.e.f("deliverErrorAndCancel: taskId=", taskId, " code=", i10, " msg=");
        sbF.append(message);
        sbF.append(" flipped=");
        sbF.append(zCompareAndSet);
        sbF.append(" nativeCancelled=");
        sbF.append(zBooleanValue);
        Log.w(TAG, sbF.toString());
        return zCompareAndSet || zBooleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute(com.stepos.core.model.task.AITaskRecord r19, qb.b<? super kotlinx.coroutines.flow.Flow<? extends kotlin.Result<? extends java.lang.Object>>> r20) {
        /*
            r18 = this;
            java.lang.Object r5 = r19.getInput()
            if (r5 == 0) goto L83
            b7.k r7 = r19.getModelConfig()
            if (r7 == 0) goto L7b
            java.lang.String r2 = r7.f3090a
            java.lang.String r1 = r19.getId()
            java.lang.String r0 = r19.getBackend()
            if (r0 == 0) goto L22
            int r0 = r0.length()
            if (r0 != 0) goto L1f
            goto L22
        L1f:
            r3 = r19
            goto L2b
        L22:
            com.stepos.base.model.InferenceConfig r0 = r7.f3096g
            java.lang.String r0 = r0.f6263a
            r3 = r19
            r3.setBackend(r0)
        L2b:
            java.lang.String r0 = r3.getSceneId()
            if (r0 == 0) goto L49
            com.stepos.base.awareness.data.SceneType r0 = com.stepos.base.awareness.data.SceneType.valueOf(r0)     // Catch: java.lang.Throwable -> L36
            goto L3b
        L36:
            r0 = move-exception
            kotlin.Result$Failure r0 = kotlin.c.a(r0)
        L3b:
            com.stepos.base.awareness.data.SceneType r4 = com.stepos.base.awareness.data.SceneType.f6193a
            boolean r6 = r0 instanceof kotlin.Result.Failure
            if (r6 == 0) goto L42
            r0 = r4
        L42:
            com.stepos.base.awareness.data.SceneType r0 = (com.stepos.base.awareness.data.SceneType) r0
            if (r0 != 0) goto L47
            goto L49
        L47:
            r9 = r0
            goto L4c
        L49:
            com.stepos.base.awareness.data.SceneType r0 = com.stepos.base.awareness.data.SceneType.f6193a
            goto L47
        L4c:
            long r13 = r3.getTimeoutMs()
            com.stepos.base.concurrency.data.PoolType$a r0 = com.stepos.base.concurrency.data.PoolType.f6214b
            com.stepos.base.task.data.TaskPriority r4 = r3.getPriority()
            r0.getClass()
            com.stepos.base.concurrency.data.PoolType r0 = com.stepos.base.concurrency.data.PoolType.a.a(r4)
            java.lang.String r11 = r0.name()
            r6.a r6 = new r6.a
            r16 = 0
            r17 = 4066(0xfe2, float:5.698E-42)
            r10 = 0
            r12 = 1
            r15 = 0
            r8 = r6
            r8.<init>(r9, r10, r11, r12, r13, r15, r16, r17)
            com.stepos.core.model.inference.InferenceExecutorImpl$execute$2 r0 = new com.stepos.core.model.inference.InferenceExecutorImpl$execute$2
            r8 = 0
            r4 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlinx.coroutines.flow.Flow r0 = kotlinx.coroutines.flow.FlowKt.callbackFlow(r0)
            return r0
        L7b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Task modelConfig is null"
            r0.<init>(r1)
            throw r0
        L83:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Task input is null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.inference.InferenceExecutorImpl.execute(com.stepos.core.model.task.AITaskRecord, qb.b):java.lang.Object");
    }

    @Override // x6.b
    public void executeStream(String taskId, long j10, Object input, r6.a decision, b.c callback) {
        g.f(taskId, "taskId");
        g.f(input, "input");
        g.f(decision, "decision");
        g.f(callback, "callback");
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(taskId, input, decision, callback, null), 1, null);
    }

    public b.a getStatistics() {
        long j10 = this.totalInferences;
        long j11 = this.successfulInferences;
        return new b.a(j10, j11, j10 - j11, j11 > 0 ? this.totalLatencyMs / j11 : 0L, this.runningTasks.size());
    }

    public boolean isRunning(String taskId) {
        g.f(taskId, "taskId");
        AtomicBoolean atomicBoolean = this.runningTasks.get(taskId);
        return atomicBoolean != null && atomicBoolean.get();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class SyncContext {
        private k modelConfig;
        private final long startTime;
        private final String taskId;

        public SyncContext(String taskId, long j10, k kVar) {
            g.f(taskId, "taskId");
            this.taskId = taskId;
            this.startTime = j10;
            this.modelConfig = kVar;
        }

        public final k getModelConfig() {
            return this.modelConfig;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final String getTaskId() {
            return this.taskId;
        }

        public final void setModelConfig(k kVar) {
            this.modelConfig = kVar;
        }

        public /* synthetic */ SyncContext(String str, long j10, k kVar, int i10, kotlin.jvm.internal.e eVar) {
            this(str, j10, (i10 & 4) != 0 ? null : kVar);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class StreamContext {
        private long firstTokenTime;
        private boolean modelCacheHit;
        private k modelConfig;
        private final long startTime;
        private final String taskId;
        private final StringBuilder tokenBuilder;
        private int tokenCount;

        public StreamContext(String taskId, long j10, long j11, int i10, k kVar, boolean z, StringBuilder tokenBuilder) {
            g.f(taskId, "taskId");
            g.f(tokenBuilder, "tokenBuilder");
            this.taskId = taskId;
            this.startTime = j10;
            this.firstTokenTime = j11;
            this.tokenCount = i10;
            this.modelConfig = kVar;
            this.modelCacheHit = z;
            this.tokenBuilder = tokenBuilder;
        }

        public final long getFirstTokenTime() {
            return this.firstTokenTime;
        }

        public final boolean getModelCacheHit() {
            return this.modelCacheHit;
        }

        public final k getModelConfig() {
            return this.modelConfig;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final String getTaskId() {
            return this.taskId;
        }

        public final StringBuilder getTokenBuilder() {
            return this.tokenBuilder;
        }

        public final int getTokenCount() {
            return this.tokenCount;
        }

        public final void setFirstTokenTime(long j10) {
            this.firstTokenTime = j10;
        }

        public final void setModelCacheHit(boolean z) {
            this.modelCacheHit = z;
        }

        public final void setModelConfig(k kVar) {
            this.modelConfig = kVar;
        }

        public final void setTokenCount(int i10) {
            this.tokenCount = i10;
        }

        public /* synthetic */ StreamContext(String str, long j10, long j11, int i10, k kVar, boolean z, StringBuilder sb2, int i11, kotlin.jvm.internal.e eVar) {
            this(str, j10, (i11 & 4) != 0 ? 0L : j11, (i11 & 8) != 0 ? 0 : i10, (i11 & 16) != 0 ? null : kVar, (i11 & 32) != 0 ? false : z, (i11 & 64) != 0 ? new StringBuilder() : sb2);
        }
    }

    public /* synthetic */ InferenceExecutorImpl(InferenceBackendSelector inferenceBackendSelector, b7.b bVar, x6.d dVar, x6.c cVar, int i10, kotlin.jvm.internal.e eVar) {
        this(inferenceBackendSelector, bVar, (i10 & 4) != 0 ? new Preprocessor() : dVar, (i10 & 8) != 0 ? new Postprocessor() : cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute(com.stepos.core.model.task.TaskSession r19, qb.b<? super kotlinx.coroutines.flow.Flow<? extends kotlin.Result<? extends java.lang.Object>>> r20) {
        /*
            r18 = this;
            j7.e r0 = r19.getRequest()
            java.lang.Object r7 = r0.f9713d
            b7.k r4 = r19.getModelConfig()
            if (r4 == 0) goto L65
            java.lang.String r3 = r4.f3090a
            j7.e r0 = r19.getRequest()
            java.lang.String r2 = r0.f9710a
            java.lang.String r0 = r19.getSceneId()
            if (r0 == 0) goto L32
            com.stepos.base.awareness.data.SceneType r0 = com.stepos.base.awareness.data.SceneType.valueOf(r0)     // Catch: java.lang.Throwable -> L1f
            goto L24
        L1f:
            r0 = move-exception
            kotlin.Result$Failure r0 = kotlin.c.a(r0)
        L24:
            com.stepos.base.awareness.data.SceneType r1 = com.stepos.base.awareness.data.SceneType.f6193a
            boolean r5 = r0 instanceof kotlin.Result.Failure
            if (r5 == 0) goto L2b
            r0 = r1
        L2b:
            com.stepos.base.awareness.data.SceneType r0 = (com.stepos.base.awareness.data.SceneType) r0
            if (r0 != 0) goto L30
            goto L32
        L30:
            r9 = r0
            goto L35
        L32:
            com.stepos.base.awareness.data.SceneType r0 = com.stepos.base.awareness.data.SceneType.f6193a
            goto L30
        L35:
            long r13 = r19.getTimeoutMs()
            com.stepos.base.concurrency.data.PoolType$a r0 = com.stepos.base.concurrency.data.PoolType.f6214b
            com.stepos.base.task.data.TaskPriority r1 = r19.getPriority()
            r0.getClass()
            com.stepos.base.concurrency.data.PoolType r0 = com.stepos.base.concurrency.data.PoolType.a.a(r1)
            java.lang.String r11 = r0.name()
            r6.a r8 = new r6.a
            r16 = 0
            r17 = 4066(0xfe2, float:5.698E-42)
            r10 = 0
            r12 = 1
            r15 = 0
            r8.<init>(r9, r10, r11, r12, r13, r15, r16, r17)
            com.stepos.core.model.inference.InferenceExecutorImpl$execute$4 r1 = new com.stepos.core.model.inference.InferenceExecutorImpl$execute$4
            r9 = 0
            r5 = r18
            r6 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            kotlinx.coroutines.flow.Flow r0 = kotlinx.coroutines.flow.FlowKt.callbackFlow(r1)
            return r0
        L65:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Task modelConfig is null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.inference.InferenceExecutorImpl.execute(com.stepos.core.model.task.TaskSession, qb.b):java.lang.Object");
    }

    public void execute(String taskId, long j10, Object input, r6.a decision, b.InterfaceC0168b callback) {
        g.f(taskId, "taskId");
        g.f(input, "input");
        g.f(decision, "decision");
        g.f(callback, "callback");
        SyncContext syncContext = new SyncContext(taskId, System.currentTimeMillis(), null, 4, null);
        this.runningTasks.put(taskId, new AtomicBoolean(true));
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass5(decision, taskId, callback, input, syncContext, null), 1, null);
    }
}
