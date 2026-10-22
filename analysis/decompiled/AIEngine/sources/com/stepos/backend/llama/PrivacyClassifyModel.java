package com.stepos.backend.llama;

import android.util.Log;
import b7.k;
import com.stepos.backend.llama.PrivacyClassifyJni;
import com.stepos.base.model.ModelBase;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.common.log.AiEngineAtrace;
import com.stepos.core.data.base.Content;
import e7.f;
import e7.h;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import lb.n;
import mb.y;
import rb.c;
import v6.c;
import v6.d;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PrivacyClassifyModel extends ModelBase implements h {
    public static final Companion Companion = new Companion(null);
    private static final float DEFAULT_THRESHOLD = 0.8f;
    private static final String KEY_THRESHOLD = "privacyClassifyThreshold";
    private int flashAttn;
    private final Mutex inferLock;
    private final String modelId;
    private int nBatch;
    private int nCtx;
    private int nThreads;
    private volatile long nativeHandle;
    private final String tag;
    private final float threshold;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.llama.PrivacyClassifyModel", f = "PrivacyClassifyModel.kt", l = {228, 163}, m = "classifyOnce")
    /* renamed from: com.stepos.backend.llama.PrivacyClassifyModel$classifyOnce$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrivacyClassifyModel.this.classifyOnce(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.llama.PrivacyClassifyModel$doFlowInfer$2", f = "PrivacyClassifyModel.kt", l = {141, 141, 143}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.llama.PrivacyClassifyModel$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends Object>>, qb.b<? super n>, Object> {
        final /* synthetic */ Object $input;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$input = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = PrivacyClassifyModel.this.new AnonymousClass2(this.$input, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        
            if (r1.emit(r6, r7) == r0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
        
            if (r1.emit(r3, r7) != r0) goto L31;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r1v4 */
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
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L35
                if (r1 == r4) goto L26
                if (r1 == r3) goto L1c
                if (r1 != r2) goto L14
                kotlin.c.b(r8)
                goto L77
            L14:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1c:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r8)     // Catch: java.lang.Exception -> L24
                goto L77
            L24:
                r8 = move-exception
                goto L61
            L26:
                java.lang.Object r1 = r7.L$1
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                java.lang.Object r4 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                kotlin.c.b(r8)     // Catch: java.lang.Exception -> L32
                goto L4f
            L32:
                r8 = move-exception
                r1 = r4
                goto L61
            L35:
                kotlin.c.b(r8)
                java.lang.Object r8 = r7.L$0
                r1 = r8
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                com.stepos.backend.llama.PrivacyClassifyModel r8 = com.stepos.backend.llama.PrivacyClassifyModel.this     // Catch: java.lang.Exception -> L24
                java.lang.Object r6 = r7.$input     // Catch: java.lang.Exception -> L24
                r7.L$0 = r1     // Catch: java.lang.Exception -> L24
                r7.L$1 = r1     // Catch: java.lang.Exception -> L24
                r7.label = r4     // Catch: java.lang.Exception -> L24
                java.lang.Object r8 = r8.doInfer(r6, r7)     // Catch: java.lang.Exception -> L24
                if (r8 != r0) goto L4e
                goto L76
            L4e:
                r4 = r1
            L4f:
                kotlin.Result r6 = new kotlin.Result     // Catch: java.lang.Exception -> L32
                r6.<init>(r8)     // Catch: java.lang.Exception -> L32
                r7.L$0 = r4     // Catch: java.lang.Exception -> L32
                r7.L$1 = r5     // Catch: java.lang.Exception -> L32
                r7.label = r3     // Catch: java.lang.Exception -> L32
                java.lang.Object r7 = r1.emit(r6, r7)     // Catch: java.lang.Exception -> L32
                if (r7 != r0) goto L77
                goto L76
            L61:
                kotlin.Result$Failure r8 = kotlin.c.a(r8)
                kotlin.Result r3 = new kotlin.Result
                r3.<init>(r8)
                r7.L$0 = r5
                r7.L$1 = r5
                r7.label = r2
                java.lang.Object r7 = r1.emit(r3, r7)
                if (r7 != r0) goto L77
            L76:
                return r0
            L77:
                lb.n r7 = lb.n.f10413a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.PrivacyClassifyModel.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends Object>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.llama.PrivacyClassifyModel", f = "PrivacyClassifyModel.kt", l = {Content.Types.TYPE_BOOLEAN}, m = "doInitialize")
    /* renamed from: com.stepos.backend.llama.PrivacyClassifyModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C02011(qb.b<? super C02011> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrivacyClassifyModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.llama.PrivacyClassifyModel$processText$2", f = "PrivacyClassifyModel.kt", l = {149, 149, 152}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.llama.PrivacyClassifyModel$processText$2, reason: invalid class name and case insensitive filesystem */
    public static final class C02022 extends SuspendLambda implements p<FlowCollector<? super d>, qb.b<? super n>, Object> {
        final /* synthetic */ c.g $input;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02022(c.g gVar, qb.b<? super C02022> bVar) {
            super(2, bVar);
            this.$input = gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            C02022 c02022 = PrivacyClassifyModel.this.new C02022(this.$input, bVar);
            c02022.L$0 = obj;
            return c02022;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
        
            if (r1.emit(r10, r9) == r0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x009b, code lost:
        
            if (r1.emit(r4, r9) != r0) goto L31;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r1v4 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r9.label
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L37
                if (r1 == r4) goto L28
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.c.b(r10)
                goto L9e
            L15:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L1d:
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r10)     // Catch: java.lang.Exception -> L26
                goto L9e
            L26:
                r10 = move-exception
                goto L62
            L28:
                java.lang.Object r1 = r9.L$1
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                java.lang.Object r4 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                kotlin.c.b(r10)     // Catch: java.lang.Exception -> L34
                goto L55
            L34:
                r10 = move-exception
                r1 = r4
                goto L62
            L37:
                kotlin.c.b(r10)
                java.lang.Object r10 = r9.L$0
                r1 = r10
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                com.stepos.backend.llama.PrivacyClassifyModel r10 = com.stepos.backend.llama.PrivacyClassifyModel.this     // Catch: java.lang.Exception -> L26
                v6.c$g r6 = r9.$input     // Catch: java.lang.Exception -> L26
                java.lang.String r7 = r6.f13416b     // Catch: java.lang.Exception -> L26
                java.lang.String r6 = r6.f13417c     // Catch: java.lang.Exception -> L26
                r9.L$0 = r1     // Catch: java.lang.Exception -> L26
                r9.L$1 = r1     // Catch: java.lang.Exception -> L26
                r9.label = r4     // Catch: java.lang.Exception -> L26
                java.lang.Object r10 = com.stepos.backend.llama.PrivacyClassifyModel.access$classifyOnce(r10, r7, r6, r9)     // Catch: java.lang.Exception -> L26
                if (r10 != r0) goto L54
                goto L9d
            L54:
                r4 = r1
            L55:
                r9.L$0 = r4     // Catch: java.lang.Exception -> L34
                r9.L$1 = r5     // Catch: java.lang.Exception -> L34
                r9.label = r3     // Catch: java.lang.Exception -> L34
                java.lang.Object r9 = r1.emit(r10, r9)     // Catch: java.lang.Exception -> L34
                if (r9 != r0) goto L9e
                goto L9d
            L62:
                com.stepos.backend.llama.PrivacyClassifyModel r4 = com.stepos.backend.llama.PrivacyClassifyModel.this
                java.lang.String r4 = com.stepos.backend.llama.PrivacyClassifyModel.access$getTag$p(r4)
                java.lang.String r6 = r10.getMessage()
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r8 = "processText failed: "
                r7.<init>(r8)
                r7.append(r6)
                java.lang.String r6 = r7.toString()
                android.util.Log.e(r4, r6, r10)
                v6.d$f r4 = new v6.d$f
                java.lang.String r10 = r10.getMessage()
                java.lang.String r6 = "PrivacyClassify failed: "
                java.lang.String r10 = ai.onnxruntime.a.k(r6, r10)
                v6.c$g r6 = r9.$input
                java.lang.String r6 = r6.f13417c
                r7 = 0
                r4.<init>(r10, r7, r3, r6)
                r9.L$0 = r5
                r9.L$1 = r5
                r9.label = r2
                java.lang.Object r9 = r1.emit(r4, r9)
                if (r9 != r0) goto L9e
            L9d:
                return r0
            L9e:
                lb.n r9 = lb.n.f10413a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.PrivacyClassifyModel.C02022.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super d> flowCollector, qb.b<? super n> bVar) {
            return ((C02022) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    static {
        Object obj = f.f8615a;
        f.b(i.a(PrivacyClassifyModel.class), y.M(ProtocolType.f6378a));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivacyClassifyModel(k config) {
        super(config);
        g.f(config, "config");
        this.tag = "PrivacyClassifyModel";
        this.modelId = config.f3090a;
        this.inferLock = MutexKt.Mutex$default(false, 1, null);
        this.nThreads = 4;
        this.flashAttn = -1;
        Object obj = config.f3096g.h.get("privacyClassifyThreshold");
        Float f8 = obj instanceof Float ? (Float) obj : null;
        this.threshold = f8 != null ? f8.floatValue() : DEFAULT_THRESHOLD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object classifyOnce(java.lang.String r23, java.lang.String r24, qb.b<? super v6.d> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.PrivacyClassifyModel.classifyOnce(java.lang.String, java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PrivacyClassifyJni.Result classifyOnce$lambda$10$lambda$9(long j10, String str) {
        return (PrivacyClassifyJni.Result) AiEngineAtrace.section("llama/call", "privacy_classify", new a(j10, str, 0));
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doCleanup(qb.b<? super n> bVar) {
        return n.f10413a;
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doClose(qb.b<? super n> bVar) {
        Object objA;
        long j10 = this.nativeHandle;
        this.nativeHandle = 0L;
        if (j10 != 0) {
            try {
                PrivacyClassifyJni.nativeRelease(j10);
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                a0.a.A("nativeRelease failed: ", thB.getMessage(), this.tag);
            }
        }
        return n.f10413a;
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doFlowInfer(Object obj, qb.b<? super Flow<? extends Result<? extends Object>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(obj, null));
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doInfer(Object obj, qb.b<Object> bVar) {
        String str;
        boolean z = obj instanceof c.g;
        if (z) {
            str = ((c.g) obj).f13416b;
        } else {
            if (!(obj instanceof String)) {
                throw new IllegalArgumentException(ai.onnxruntime.a.k("PrivacyClassifyModel expects Input.Text or String, got ", i.a(obj.getClass()).c()));
            }
            str = (String) obj;
        }
        return classifyOnce(str, z ? ((c.g) obj).f13417c : "", bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInitialize(android.content.Context r11, b7.k r12, qb.b<? super lb.n> r13) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.PrivacyClassifyModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doWarmup(qb.b<? super n> bVar) {
        Log.d(this.tag, "doWarmup: skip (small classifier)");
        return n.f10413a;
    }

    @Override // e7.b
    public ProtocolType getType() {
        return ProtocolType.f6378a;
    }

    @Override // e7.h
    public Object processText(c.g gVar, Object obj, qb.b<? super Flow<? extends d>> bVar) {
        return FlowKt.flow(new C02022(gVar, null));
    }

    @Override // e7.h
    public boolean resetContext() {
        return false;
    }
}
