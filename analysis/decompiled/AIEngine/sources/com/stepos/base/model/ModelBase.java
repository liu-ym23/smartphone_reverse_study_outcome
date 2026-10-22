package com.stepos.base.model;

import android.content.Context;
import android.os.SystemClock;
import b7.k;
import com.stepos.base.model.b;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import lb.n;
import mb.l;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ModelBase implements b7.a {
    private static final a Companion = new a();
    private final k config;
    private Context ctx;
    private final Mutex mutex;
    private ModelState state;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static final String a(a aVar, b.C0044b c0044b, b.C0044b c0044b2, long j10) {
            aVar.getClass();
            if (c0044b == null || c0044b2 == null) {
                return ai.onnxruntime.a.h(j10, "elapsed=", "ms");
            }
            b.f6348a.getClass();
            String strB = b.b(c0044b2);
            String strA = b.a(c0044b, c0044b2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strB);
            sb2.append(" (");
            sb2.append(strA);
            sb2.append(" from-begin, elapsed=");
            return ai.onnxruntime.a.m(sb2, j10, "ms)");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.base.model.ModelBase$inferStreaming$2", f = "ModelBase.kt", l = {124, 143, 143, 162}, m = "invokeSuspend")
    /* renamed from: com.stepos.base.model.ModelBase$inferStreaming$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends Object>>, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public b.C0044b f6297a;

        /* renamed from: b, reason: collision with root package name */
        public Ref$BooleanRef f6298b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f6299c;

        /* renamed from: d, reason: collision with root package name */
        public long f6300d;

        /* renamed from: e, reason: collision with root package name */
        public int f6301e;
        public /* synthetic */ Object h;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ Object f6303k;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: com.stepos.base.model.ModelBase$inferStreaming$2$a */
        public static final class a<T> implements FlowCollector {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref$BooleanRef f6304a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f6305b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ModelBase f6306c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ b.C0044b f6307d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ long f6308e;
            public final /* synthetic */ FlowCollector<Result<? extends Object>> h;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Ref$BooleanRef ref$BooleanRef, boolean z, ModelBase modelBase, b.C0044b c0044b, long j10, FlowCollector<? super Result<? extends Object>> flowCollector) {
                this.f6304a = ref$BooleanRef;
                this.f6305b = z;
                this.f6306c = modelBase;
                this.f6307d = c0044b;
                this.f6308e = j10;
                this.h = flowCollector;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, qb.b<? super n> bVar) {
                Ref$BooleanRef ref$BooleanRef = this.f6304a;
                if (!ref$BooleanRef.f10073a) {
                    ref$BooleanRef.f10073a = true;
                    a0.a.y("inferStreaming FIRST_TOKEN: ", a.a(ModelBase.Companion, this.f6307d, b.a.a(this.f6305b), SystemClock.elapsedRealtime() - this.f6308e), this.f6306c.inferLogTag());
                }
                Object objEmit = this.h.emit(obj, bVar);
                return objEmit == CoroutineSingletons.f10059a ? objEmit : n.f10413a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.f6303k = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = ModelBase.this.new AnonymousClass2(this.f6303k, bVar);
            anonymousClass2.h = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends Object>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x009f, code lost:
        
            if (r9.emit(r3, r17) == r2) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0190, code lost:
        
            if (r9.emit(r3, r17) == r2) goto L53;
         */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0106  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instructions count: 406
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.model.ModelBase.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public ModelBase(k config) {
        g.f(config, "config");
        this.config = config;
        this.state = ModelState.f6326a;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String inferLogTag() {
        return ai.onnxruntime.a.k("Infer-", this.config.f3090a);
    }

    @Override // b7.a
    public boolean cancel() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: cleanup-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m20cleanupIoAF18A(qb.b<? super kotlin.Result<lb.n>> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.stepos.base.model.ModelBase$cleanup$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.base.model.ModelBase$cleanup$1 r0 = (com.stepos.base.model.ModelBase$cleanup$1) r0
            int r1 = r0.f6284e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6284e = r1
            goto L18
        L13:
            com.stepos.base.model.ModelBase$cleanup$1 r0 = new com.stepos.base.model.ModelBase$cleanup$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f6282c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.f6284e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L46
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            kotlinx.coroutines.sync.Mutex r7 = r0.f6281b
            com.stepos.base.model.ModelBase r0 = r0.f6280a
            kotlin.c.b(r8)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            goto L75
        L2f:
            r8 = move-exception
            goto L93
        L32:
            r8 = move-exception
            goto L86
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            kotlinx.coroutines.sync.Mutex r7 = r0.f6281b
            com.stepos.base.model.ModelBase r2 = r0.f6280a
            kotlin.c.b(r8)
            r8 = r7
            r7 = r2
            goto L58
        L46:
            kotlin.c.b(r8)
            kotlinx.coroutines.sync.Mutex r8 = r7.mutex
            r0.f6280a = r7
            r0.f6281b = r8
            r0.f6284e = r4
            java.lang.Object r2 = r8.lock(r5, r0)
            if (r2 != r1) goto L58
            goto L72
        L58:
            com.stepos.base.model.ModelState r2 = r7.state     // Catch: java.lang.Throwable -> L61
            com.stepos.base.model.ModelState r4 = com.stepos.base.model.ModelState.f6332k     // Catch: java.lang.Throwable -> L61
            if (r2 != r4) goto L66
            lb.n r7 = lb.n.f10413a     // Catch: java.lang.Throwable -> L61
            goto L8f
        L61:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
            goto L93
        L66:
            r0.f6280a = r7     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L81
            r0.f6281b = r8     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L81
            r0.f6284e = r3     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L81
            java.lang.Object r0 = r7.doCleanup(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L81
            if (r0 != r1) goto L73
        L72:
            return r1
        L73:
            r0 = r7
            r7 = r8
        L75:
            com.stepos.base.model.ModelState r8 = com.stepos.base.model.ModelState.f6332k     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            r0.state = r8     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            r0.ctx = r5     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            lb.n r8 = lb.n.f10413a     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
        L7d:
            r6 = r8
            r8 = r7
            r7 = r6
            goto L8f
        L81:
            r0 = move-exception
            r6 = r0
            r0 = r7
            r7 = r8
            r8 = r6
        L86:
            com.stepos.base.model.ModelState r1 = com.stepos.base.model.ModelState.f6333l     // Catch: java.lang.Throwable -> L2f
            r0.state = r1     // Catch: java.lang.Throwable -> L2f
            kotlin.Result$Failure r8 = kotlin.c.a(r8)     // Catch: java.lang.Throwable -> L2f
            goto L7d
        L8f:
            r8.unlock(r5)
            return r7
        L93:
            r7.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.model.ModelBase.m20cleanupIoAF18A(qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // b7.a
    /* renamed from: close-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mo9closeIoAF18A(qb.b<? super kotlin.Result<lb.n>> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.stepos.base.model.ModelBase$close$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.base.model.ModelBase$close$1 r0 = (com.stepos.base.model.ModelBase$close$1) r0
            int r1 = r0.f6289e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6289e = r1
            goto L18
        L13:
            com.stepos.base.model.ModelBase$close$1 r0 = new com.stepos.base.model.ModelBase$close$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f6287c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.f6289e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L47
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            kotlinx.coroutines.sync.Mutex r7 = r0.f6286b
            com.stepos.base.model.ModelBase r0 = r0.f6285a
            kotlin.c.b(r8)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            goto L84
        L2f:
            r8 = move-exception
            goto La0
        L32:
            r8 = move-exception
            goto L93
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            kotlinx.coroutines.sync.Mutex r7 = r0.f6286b
            com.stepos.base.model.ModelBase r2 = r0.f6285a
            kotlin.c.b(r8)
            r8 = r7
            r7 = r2
            goto L59
        L47:
            kotlin.c.b(r8)
            kotlinx.coroutines.sync.Mutex r8 = r7.mutex
            r0.f6285a = r7
            r0.f6286b = r8
            r0.f6289e = r4
            java.lang.Object r2 = r8.lock(r5, r0)
            if (r2 != r1) goto L59
            goto L81
        L59:
            com.stepos.base.model.ModelState r2 = com.stepos.base.model.ModelState.f6332k     // Catch: java.lang.Throwable -> L70
            com.stepos.base.model.ModelState r4 = com.stepos.base.model.ModelState.f6326a     // Catch: java.lang.Throwable -> L70
            com.stepos.base.model.ModelState[] r2 = new com.stepos.base.model.ModelState[]{r2, r4}     // Catch: java.lang.Throwable -> L70
            java.util.Set r2 = mb.l.s0(r2)     // Catch: java.lang.Throwable -> L70
            com.stepos.base.model.ModelState r4 = r7.state     // Catch: java.lang.Throwable -> L70
            boolean r2 = r2.contains(r4)     // Catch: java.lang.Throwable -> L70
            if (r2 == 0) goto L75
            lb.n r7 = lb.n.f10413a     // Catch: java.lang.Throwable -> L70
            goto L9c
        L70:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
            goto La0
        L75:
            r0.f6285a = r7     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L8e
            r0.f6286b = r8     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L8e
            r0.f6289e = r3     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L8e
            java.lang.Object r0 = r7.doClose(r0)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L8e
            if (r0 != r1) goto L82
        L81:
            return r1
        L82:
            r0 = r7
            r7 = r8
        L84:
            com.stepos.base.model.ModelState r8 = com.stepos.base.model.ModelState.f6331j     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            r0.state = r8     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            lb.n r8 = lb.n.f10413a     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
        L8a:
            r6 = r8
            r8 = r7
            r7 = r6
            goto L9c
        L8e:
            r0 = move-exception
            r6 = r0
            r0 = r7
            r7 = r8
            r8 = r6
        L93:
            com.stepos.base.model.ModelState r1 = com.stepos.base.model.ModelState.f6333l     // Catch: java.lang.Throwable -> L2f
            r0.state = r1     // Catch: java.lang.Throwable -> L2f
            kotlin.Result$Failure r8 = kotlin.c.a(r8)     // Catch: java.lang.Throwable -> L2f
            goto L8a
        L9c:
            r8.unlock(r5)
            return r7
        La0:
            r7.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.model.ModelBase.mo9closeIoAF18A(qb.b):java.lang.Object");
    }

    public abstract Object doCleanup(qb.b<? super n> bVar);

    public abstract Object doClose(qb.b<? super n> bVar);

    public abstract Object doFlowInfer(Object obj, qb.b<? super Flow<? extends Result<? extends Object>>> bVar);

    public abstract Object doInfer(Object obj, qb.b<Object> bVar);

    public abstract Object doInitialize(Context context, k kVar, qb.b<? super n> bVar);

    public abstract Object doWarmup(qb.b<? super n> bVar);

    @Override // b7.a
    public final k getConfig() {
        return this.config;
    }

    public final Context getContext() {
        Context context = this.ctx;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Not initialized");
    }

    public final ModelState getCurrentState() {
        return this.state;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8 A[Catch: all -> 0x0065, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0065, blocks: (B:17:0x0060, B:32:0x00a8), top: B:60:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6 A[Catch: all -> 0x00e1, TRY_ENTER, TryCatch #0 {all -> 0x00e1, blocks: (B:44:0x00fe, B:48:0x0127, B:30:0x0094, B:34:0x00b6, B:36:0x00c9, B:40:0x00e5), top: B:60:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /* JADX WARN: Type inference failed for: r9v0, types: [int, kotlinx.coroutines.sync.Mutex] */
    @Override // b7.a
    /* renamed from: infer-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mo10infer0E7RQCE(java.lang.Object r17, zb.l<? super kotlin.Result<? extends java.lang.Object>, lb.n> r18, qb.b<? super kotlin.Result<? extends java.lang.Object>> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.model.ModelBase.mo10infer0E7RQCE(java.lang.Object, zb.l, qb.b):java.lang.Object");
    }

    @Override // b7.a
    public final Object inferStreaming(Object obj, qb.b<? super Flow<? extends Result<? extends Object>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(obj, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.stepos.base.model.ModelBase] */
    /* JADX WARN: Type inference failed for: r8v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.stepos.base.model.ModelBase] */
    /* JADX WARN: Type inference failed for: r8v3 */
    @Override // b7.a
    /* renamed from: initialize-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mo11initializegIAlus(android.content.Context r9, qb.b<? super kotlin.Result<lb.n>> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.stepos.base.model.ModelBase$initialize$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.base.model.ModelBase$initialize$1 r0 = (com.stepos.base.model.ModelBase$initialize$1) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            com.stepos.base.model.ModelBase$initialize$1 r0 = new com.stepos.base.model.ModelBase$initialize$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f6312d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.h
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4e
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r8 = r0.f6310b
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            com.stepos.base.model.ModelBase r9 = r0.f6309a
            kotlin.c.b(r10)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L35
            goto L9c
        L32:
            r9 = move-exception
            goto Lb7
        L35:
            r10 = move-exception
            goto Laa
        L38:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L40:
            kotlinx.coroutines.sync.Mutex r8 = r0.f6311c
            java.lang.Object r9 = r0.f6310b
            android.content.Context r9 = (android.content.Context) r9
            com.stepos.base.model.ModelBase r2 = r0.f6309a
            kotlin.c.b(r10)
            r10 = r8
            r8 = r2
            goto L62
        L4e:
            kotlin.c.b(r10)
            kotlinx.coroutines.sync.Mutex r10 = r8.mutex
            r0.f6309a = r8
            r0.f6310b = r9
            r0.f6311c = r10
            r0.h = r4
            java.lang.Object r2 = r10.lock(r5, r0)
            if (r2 != r1) goto L62
            goto L99
        L62:
            com.stepos.base.model.ModelState r2 = com.stepos.base.model.ModelState.f6326a     // Catch: java.lang.Throwable -> L84
            com.stepos.base.model.ModelState r4 = com.stepos.base.model.ModelState.f6331j     // Catch: java.lang.Throwable -> L84
            com.stepos.base.model.ModelState r6 = com.stepos.base.model.ModelState.f6333l     // Catch: java.lang.Throwable -> L84
            com.stepos.base.model.ModelState[] r2 = new com.stepos.base.model.ModelState[]{r2, r4, r6}     // Catch: java.lang.Throwable -> L84
            java.util.Set r2 = mb.l.s0(r2)     // Catch: java.lang.Throwable -> L84
            com.stepos.base.model.ModelState r4 = r8.state     // Catch: java.lang.Throwable -> L84
            boolean r2 = r2.contains(r4)     // Catch: java.lang.Throwable -> L84
            if (r2 != 0) goto L87
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L84
            java.lang.String r9 = "Invalid state"
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L84
            kotlin.Result$Failure r8 = kotlin.c.a(r8)     // Catch: java.lang.Throwable -> L84
            goto Lb3
        L84:
            r9 = move-exception
            r8 = r10
            goto Lb7
        L87:
            r8.ctx = r9     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> La5
            b7.k r2 = r8.config     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> La5
            r0.f6309a = r8     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> La5
            r0.f6310b = r10     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> La5
            r0.f6311c = r5     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> La5
            r0.h = r3     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> La5
            java.lang.Object r9 = r8.doInitialize(r9, r2, r0)     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> La5
            if (r9 != r1) goto L9a
        L99:
            return r1
        L9a:
            r9 = r8
            r8 = r10
        L9c:
            com.stepos.base.model.ModelState r10 = com.stepos.base.model.ModelState.f6329d     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L35
            r9.state = r10     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L35
            lb.n r9 = lb.n.f10413a     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L35
        La2:
            r10 = r8
            r8 = r9
            goto Lb3
        La5:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r10
            r10 = r7
        Laa:
            com.stepos.base.model.ModelState r0 = com.stepos.base.model.ModelState.f6333l     // Catch: java.lang.Throwable -> L32
            r9.state = r0     // Catch: java.lang.Throwable -> L32
            kotlin.Result$Failure r9 = kotlin.c.a(r10)     // Catch: java.lang.Throwable -> L32
            goto La2
        Lb3:
            r10.unlock(r5)
            return r8
        Lb7:
            r8.unlock(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.model.ModelBase.mo11initializegIAlus(android.content.Context, qb.b):java.lang.Object");
    }

    @Override // b7.a
    public boolean isReady() {
        return l.s0(new ModelState[]{ModelState.f6329d, ModelState.f6330e}).contains(this.state);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: warmup-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m21warmupIoAF18A(qb.b<? super kotlin.Result<lb.n>> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.stepos.base.model.ModelBase$warmup$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.base.model.ModelBase$warmup$1 r0 = (com.stepos.base.model.ModelBase$warmup$1) r0
            int r1 = r0.f6318e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6318e = r1
            goto L18
        L13:
            com.stepos.base.model.ModelBase$warmup$1 r0 = new com.stepos.base.model.ModelBase$warmup$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f6316c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.f6318e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L47
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            kotlinx.coroutines.sync.Mutex r7 = r0.f6315b
            com.stepos.base.model.ModelBase r0 = r0.f6314a
            kotlin.c.b(r8)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            goto L8a
        L2f:
            r8 = move-exception
            goto La6
        L32:
            r8 = move-exception
            goto L99
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            kotlinx.coroutines.sync.Mutex r7 = r0.f6315b
            com.stepos.base.model.ModelBase r2 = r0.f6314a
            kotlin.c.b(r8)
            r8 = r7
            r7 = r2
            goto L59
        L47:
            kotlin.c.b(r8)
            kotlinx.coroutines.sync.Mutex r8 = r7.mutex
            r0.f6314a = r7
            r0.f6315b = r8
            r0.f6318e = r4
            java.lang.Object r2 = r8.lock(r5, r0)
            if (r2 != r1) goto L59
            goto L87
        L59:
            b7.k r2 = r7.config     // Catch: java.lang.Throwable -> L64
            com.stepos.base.model.InferenceConfig r2 = r2.f3096g     // Catch: java.lang.Throwable -> L64
            boolean r2 = r2.f6269g     // Catch: java.lang.Throwable -> L64
            if (r2 != 0) goto L69
            lb.n r7 = lb.n.f10413a     // Catch: java.lang.Throwable -> L64
            goto La2
        L64:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
            goto La6
        L69:
            com.stepos.base.model.ModelState r2 = r7.state     // Catch: java.lang.Throwable -> L64
            com.stepos.base.model.ModelState r4 = com.stepos.base.model.ModelState.f6329d     // Catch: java.lang.Throwable -> L64
            if (r2 == r4) goto L7b
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L64
            java.lang.String r0 = "Initialize first"
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L64
            kotlin.Result$Failure r7 = kotlin.c.a(r7)     // Catch: java.lang.Throwable -> L64
            goto La2
        L7b:
            r0.f6314a = r7     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L94
            r0.f6315b = r8     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L94
            r0.f6318e = r3     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L94
            java.lang.Object r0 = r7.doWarmup(r0)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L94
            if (r0 != r1) goto L88
        L87:
            return r1
        L88:
            r0 = r7
            r7 = r8
        L8a:
            com.stepos.base.model.ModelState r8 = com.stepos.base.model.ModelState.f6330e     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            r0.state = r8     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            lb.n r8 = lb.n.f10413a     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
        L90:
            r6 = r8
            r8 = r7
            r7 = r6
            goto La2
        L94:
            r0 = move-exception
            r6 = r0
            r0 = r7
            r7 = r8
            r8 = r6
        L99:
            com.stepos.base.model.ModelState r1 = com.stepos.base.model.ModelState.f6333l     // Catch: java.lang.Throwable -> L2f
            r0.state = r1     // Catch: java.lang.Throwable -> L2f
            kotlin.Result$Failure r8 = kotlin.c.a(r8)     // Catch: java.lang.Throwable -> L2f
            goto L90
        La2:
            r8.unlock(r5)
            return r7
        La6:
            r7.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.base.model.ModelBase.m21warmupIoAF18A(qb.b):java.lang.Object");
    }
}
