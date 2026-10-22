package com.stepos.backend.qnn;

import android.util.Log;
import com.stepos.base.model.ModelBase;
import com.stepos.core.model.callback.StreamCallback;
import com.stepos.core.ota.crypto.OtaAtRestDecryptor;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import java.io.File;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class QnnModelBase extends ModelBase {
    public static final Companion Companion = new Companion(null);
    private final String TAG;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnModelBase", f = "QnnModelBase.kt", l = {64}, m = "doFlowInfer$suspendImpl")
    /* renamed from: com.stepos.backend.qnn.QnnModelBase$doFlowInfer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02541 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02541(qb.b<? super C02541> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnModelBase.doFlowInfer$suspendImpl(QnnModelBase.this, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnModelBase", f = "QnnModelBase.kt", l = {ErrorCodes.CALLER_PROTOCOL_VERSION_TOO_HIGH, ErrorCodes.CALLER_PROTOCOL_VERSION_TOO_HIGH}, m = "doInfer$suspendImpl")
    /* renamed from: com.stepos.backend.qnn.QnnModelBase$doInfer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02551 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02551(qb.b<? super C02551> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnModelBase.doInfer$suspendImpl(QnnModelBase.this, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnModelBase$infer$2", f = "QnnModelBase.kt", l = {91}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnModelBase$infer$2, reason: invalid class name and case insensitive filesystem */
    public static final class C02562 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends v6.d>>, qb.b<? super lb.n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C02562(qb.b<? super C02562> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C02562 c02562 = QnnModelBase.this.new C02562(bVar);
            c02562.L$0 = obj;
            return c02562;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Result result = new Result(kotlin.c.a(new IllegalStateException("Model not ready, current state: " + QnnModelBase.this.getCurrentState())));
                this.label = 1;
                if (flowCollector.emit(result, this) == coroutineSingletons) {
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
        public final Object invoke(FlowCollector<? super Result<? extends v6.d>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C02562) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QnnModelBase(b7.k config) {
        super(config);
        kotlin.jvm.internal.g.f(config, "config");
        this.TAG = "QnnModel-".concat(getClass().getSimpleName());
    }

    public static /* synthetic */ Object doCleanup$suspendImpl(QnnModelBase qnnModelBase, qb.b<? super lb.n> bVar) {
        Log.d(qnnModelBase.TAG, "doCleanup: completed");
        return lb.n.f10413a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object doFlowInfer$suspendImpl(com.stepos.backend.qnn.QnnModelBase r4, java.lang.Object r5, qb.b<? super kotlinx.coroutines.flow.Flow<? extends kotlin.Result<? extends java.lang.Object>>> r6) {
        /*
            boolean r0 = r6 instanceof com.stepos.backend.qnn.QnnModelBase.C02541
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.backend.qnn.QnnModelBase$doFlowInfer$1 r0 = (com.stepos.backend.qnn.QnnModelBase.C02541) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.QnnModelBase$doFlowInfer$1 r0 = new com.stepos.backend.qnn.QnnModelBase$doFlowInfer$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r6)
            goto L3b
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.c.b(r6)
            r0.label = r3
            java.lang.Object r6 = r4.infer(r5, r0)
            if (r6 != r1) goto L3b
            return r1
        L3b:
            kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
            com.stepos.backend.qnn.QnnModelBase$doFlowInfer$2$1 r4 = new com.stepos.backend.qnn.QnnModelBase$doFlowInfer$2$1
            r5 = 0
            r4.<init>(r6, r5)
            kotlinx.coroutines.flow.Flow r4 = kotlinx.coroutines.flow.FlowKt.flow(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnModelBase.doFlowInfer$suspendImpl(com.stepos.backend.qnn.QnnModelBase, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0082, code lost:
    
        if (((kotlinx.coroutines.flow.Flow) r10).collect(r9, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object doInfer$suspendImpl(com.stepos.backend.qnn.QnnModelBase r8, java.lang.Object r9, qb.b<java.lang.Object> r10) {
        /*
            boolean r0 = r10 instanceof com.stepos.backend.qnn.QnnModelBase.C02551
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.backend.qnn.QnnModelBase$doInfer$1 r0 = (com.stepos.backend.qnn.QnnModelBase.C02551) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.QnnModelBase$doInfer$1 r0 = new com.stepos.backend.qnn.QnnModelBase$doInfer$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r8 = r0.L$0
            java.lang.StringBuilder r8 = (java.lang.StringBuilder) r8
            kotlin.c.b(r10)
            goto L85
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            java.lang.Object r8 = r0.L$0
            java.lang.StringBuilder r8 = (java.lang.StringBuilder) r8
            kotlin.c.b(r10)
            goto L73
        L3e:
            kotlin.c.b(r10)
            java.lang.String r10 = r8.TAG
            java.lang.Class r2 = r9.getClass()
            kotlin.jvm.internal.c r2 = kotlin.jvm.internal.i.a(r2)
            java.lang.String r2 = r2.c()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "doInfer: input="
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            android.util.Log.d(r10, r2)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r8 = r8.infer(r9, r0)
            if (r8 != r1) goto L70
            goto L84
        L70:
            r7 = r10
            r10 = r8
            r8 = r7
        L73:
            kotlinx.coroutines.flow.Flow r10 = (kotlinx.coroutines.flow.Flow) r10
            com.stepos.backend.qnn.QnnModelBase$doInfer$2 r9 = new com.stepos.backend.qnn.QnnModelBase$doInfer$2
            r9.<init>()
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r9 = r10.collect(r9, r0)
            if (r9 != r1) goto L85
        L84:
            return r1
        L85:
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "toString(...)"
            kotlin.jvm.internal.g.e(r8, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnModelBase.doInfer$suspendImpl(com.stepos.backend.qnn.QnnModelBase, java.lang.Object, qb.b):java.lang.Object");
    }

    public static /* synthetic */ Object doWarmup$suspendImpl(QnnModelBase qnnModelBase, qb.b<? super lb.n> bVar) {
        Log.d(qnnModelBase.TAG, "doWarmup: default no-op");
        return lb.n.f10413a;
    }

    public final void checkModelFile(String modelPath) {
        kotlin.jvm.internal.g.f(modelPath, "modelPath");
        if (!new File(modelPath).exists()) {
            throw new IllegalStateException(a0.a.k("Model config not found: ", modelPath, " — check abilities.json modelId/modelFile or model deployment"));
        }
        Log.d(this.TAG, "Model config verified: ".concat(modelPath));
    }

    public final StreamCallback createStreamCallback(final zb.l<? super String, lb.n> onToken, final zb.a<lb.n> onComplete, final zb.p<? super Integer, ? super String, lb.n> onError) {
        kotlin.jvm.internal.g.f(onToken, "onToken");
        kotlin.jvm.internal.g.f(onComplete, "onComplete");
        kotlin.jvm.internal.g.f(onError, "onError");
        return new StreamCallback() { // from class: com.stepos.backend.qnn.QnnModelBase.createStreamCallback.1
            @Override // com.stepos.core.model.callback.StreamCallback
            public void onComplete() {
                onComplete.invoke();
            }

            @Override // com.stepos.core.model.callback.StreamCallback
            public void onError(int i10, String message) {
                kotlin.jvm.internal.g.f(message, "message");
                Log.e(this.getTAG(), "Stream error: code=" + i10 + ", msg=" + message);
                onError.invoke(Integer.valueOf(i10), message);
            }

            @Override // com.stepos.core.model.callback.StreamCallback
            public void onToken(String token) {
                kotlin.jvm.internal.g.f(token, "token");
                onToken.invoke(token);
            }
        };
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doCleanup(qb.b<? super lb.n> bVar) {
        return doCleanup$suspendImpl(this, bVar);
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doFlowInfer(Object obj, qb.b<? super Flow<? extends Result<? extends Object>>> bVar) {
        return doFlowInfer$suspendImpl(this, obj, bVar);
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doInfer(Object obj, qb.b<Object> bVar) {
        return doInfer$suspendImpl(this, obj, bVar);
    }

    public abstract Flow<Result<v6.d>> doInferInternal(Object obj);

    @Override // com.stepos.base.model.ModelBase
    public Object doWarmup(qb.b<? super lb.n> bVar) {
        return doWarmup$suspendImpl(this, bVar);
    }

    public final String getModelLibPath(String modelPath) {
        kotlin.jvm.internal.g.f(modelPath, "modelPath");
        String parent = new File(modelPath).getParent();
        if (parent != null) {
            return parent.concat("/lib");
        }
        throw new IllegalStateException("Invalid model path");
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final Object infer(Object obj, qb.b<? super Flow<? extends Result<? extends v6.d>>> bVar) {
        return !isReady() ? FlowKt.flow(new C02562(null)) : doInferInternal(obj);
    }

    public final <T> T withAtRestDecrypt(File hint, zb.a<? extends T> block) {
        kotlin.jvm.internal.g.f(hint, "hint");
        kotlin.jvm.internal.g.f(block, "block");
        OtaAtRestDecryptor otaAtRestDecryptor = a4.a.f37i;
        boolean zArmNativeDecrypt = otaAtRestDecryptor != null ? otaAtRestDecryptor.armNativeDecrypt(hint) : false;
        try {
            return block.invoke();
        } finally {
            if (zArmNativeDecrypt && otaAtRestDecryptor != null) {
                otaAtRestDecryptor.disarmNativeDecrypt();
            }
        }
    }
}
