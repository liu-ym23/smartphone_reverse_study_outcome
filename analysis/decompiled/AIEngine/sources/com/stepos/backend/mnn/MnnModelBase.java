package com.stepos.backend.mnn;

import android.content.Context;
import android.util.Log;
import b7.k;
import com.stepos.base.model.ModelBase;
import com.stepos.core.common.memory.NativeMemoryBridge;
import gc.q;
import java.io.File;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class MnnModelBase extends ModelBase {
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
    @rb.c(c = "com.stepos.backend.mnn.MnnModelBase", f = "MnnModelBase.kt", l = {136, 136}, m = "collectFirstOutput")
    /* renamed from: com.stepos.backend.mnn.MnnModelBase$collectFirstOutput$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MnnModelBase.this.collectFirstOutput(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnModelBase", f = "MnnModelBase.kt", l = {109}, m = "doFlowInfer$suspendImpl")
    /* renamed from: com.stepos.backend.mnn.MnnModelBase$doFlowInfer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02231 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02231(qb.b<? super C02231> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MnnModelBase.doFlowInfer$suspendImpl(MnnModelBase.this, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnModelBase", f = "MnnModelBase.kt", l = {97, 97}, m = "doInfer$suspendImpl")
    /* renamed from: com.stepos.backend.mnn.MnnModelBase$doInfer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02241 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02241(qb.b<? super C02241> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MnnModelBase.doInfer$suspendImpl(MnnModelBase.this, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MnnModelBase(k config) {
        super(config);
        kotlin.jvm.internal.g.f(config, "config");
        this.TAG = "MnnModel-".concat(getClass().getSimpleName());
    }

    public static /* synthetic */ Object doCleanup$suspendImpl(MnnModelBase mnnModelBase, qb.b<? super n> bVar) {
        Log.d(mnnModelBase.TAG, "doCleanup: completed");
        return n.f10413a;
    }

    public static Object doClose$suspendImpl(MnnModelBase mnnModelBase, qb.b<? super n> bVar) {
        Log.i(mnnModelBase.TAG, "MnnModelBase closed (stub): " + mnnModelBase.getConfig().f3090a);
        NativeMemoryBridge.requestPurge();
        return n.f10413a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object doFlowInfer$suspendImpl(com.stepos.backend.mnn.MnnModelBase r4, java.lang.Object r5, qb.b<? super kotlinx.coroutines.flow.Flow<? extends kotlin.Result<? extends java.lang.Object>>> r6) {
        /*
            boolean r0 = r6 instanceof com.stepos.backend.mnn.MnnModelBase.C02231
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.backend.mnn.MnnModelBase$doFlowInfer$1 r0 = (com.stepos.backend.mnn.MnnModelBase.C02231) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.mnn.MnnModelBase$doFlowInfer$1 r0 = new com.stepos.backend.mnn.MnnModelBase$doFlowInfer$1
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
            com.stepos.backend.mnn.MnnModelBase$doFlowInfer$2$1 r4 = new com.stepos.backend.mnn.MnnModelBase$doFlowInfer$2$1
            r5 = 0
            r4.<init>(r6, r5)
            kotlinx.coroutines.flow.Flow r4 = kotlinx.coroutines.flow.FlowKt.flow(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnModelBase.doFlowInfer$suspendImpl(com.stepos.backend.mnn.MnnModelBase, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0082, code lost:
    
        if (((kotlinx.coroutines.flow.Flow) r10).collect(r9, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object doInfer$suspendImpl(com.stepos.backend.mnn.MnnModelBase r8, java.lang.Object r9, qb.b<java.lang.Object> r10) {
        /*
            boolean r0 = r10 instanceof com.stepos.backend.mnn.MnnModelBase.C02241
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.backend.mnn.MnnModelBase$doInfer$1 r0 = (com.stepos.backend.mnn.MnnModelBase.C02241) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.mnn.MnnModelBase$doInfer$1 r0 = new com.stepos.backend.mnn.MnnModelBase$doInfer$1
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
            com.stepos.backend.mnn.MnnModelBase$doInfer$2 r9 = new com.stepos.backend.mnn.MnnModelBase$doInfer$2
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnModelBase.doInfer$suspendImpl(com.stepos.backend.mnn.MnnModelBase, java.lang.Object, qb.b):java.lang.Object");
    }

    public static Object doInitialize$suspendImpl(MnnModelBase mnnModelBase, Context context, k kVar, qb.b<? super n> bVar) {
        String strB = kVar.b();
        String str = kVar.f3090a;
        if (strB == null) {
            strB = kVar.f3091b;
        }
        if (q.t0(strB)) {
            throw new IllegalStateException(a0.a.k("Model path is empty for modelId='", str, "'"));
        }
        if (!new File(strB).exists()) {
            throw new IllegalStateException(h0.e.c("Model path not found: '", strB, "' (modelId='", str, "')"));
        }
        mnnModelBase.checkModelFile(strB);
        Log.i(mnnModelBase.TAG, h0.e.c("MnnModelBase initialized (stub): ", str, " (", strB, ")"));
        return n.f10413a;
    }

    public static /* synthetic */ Object doWarmup$suspendImpl(MnnModelBase mnnModelBase, qb.b<? super n> bVar) {
        Log.d(mnnModelBase.TAG, "doWarmup: default no-op");
        return n.f10413a;
    }

    public final void checkModelFile(String modelPath) {
        kotlin.jvm.internal.g.f(modelPath, "modelPath");
        if (!new File(modelPath).exists()) {
            throw new IllegalStateException(a0.a.k("Model config not found: ", modelPath, " — check abilities.json modelId/modelFile or model deployment"));
        }
        Log.d(this.TAG, "Model config verified: ".concat(modelPath));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
    
        if (r7 == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collectFirstOutput(java.lang.Object r6, qb.b<? super v6.d> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.backend.mnn.MnnModelBase.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.backend.mnn.MnnModelBase$collectFirstOutput$1 r0 = (com.stepos.backend.mnn.MnnModelBase.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.mnn.MnnModelBase$collectFirstOutput$1 r0 = new com.stepos.backend.mnn.MnnModelBase$collectFirstOutput$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.c.b(r7)
            goto L4d
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.c.b(r7)
            goto L42
        L36:
            kotlin.c.b(r7)
            r0.label = r4
            java.lang.Object r7 = r5.infer(r6, r0)
            if (r7 != r1) goto L42
            goto L4c
        L42:
            kotlinx.coroutines.flow.Flow r7 = (kotlinx.coroutines.flow.Flow) r7
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.first(r7, r0)
            if (r7 != r1) goto L4d
        L4c:
            return r1
        L4d:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.f9987a
            kotlin.c.b(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnModelBase.collectFirstOutput(java.lang.Object, qb.b):java.lang.Object");
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doCleanup(qb.b<? super n> bVar) {
        return doCleanup$suspendImpl(this, bVar);
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doClose(qb.b<? super n> bVar) {
        return doClose$suspendImpl(this, bVar);
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
    public Object doInitialize(Context context, k kVar, qb.b<? super n> bVar) {
        return doInitialize$suspendImpl(this, context, kVar, bVar);
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doWarmup(qb.b<? super n> bVar) {
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
        return doInferInternal(obj);
    }
}
