package com.stepos.backend.qnn;

import android.graphics.Bitmap;
import android.util.Log;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.common.log.AiEngineAtrace;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.data.base.Content;
import com.stepos.core.model.callback.StreamCallback;
import com.stepos.core.model.manager.ModelCacheImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class QnnVLMModel extends QnnModelBase implements e7.d {
    public static final Companion Companion = new Companion(null);
    private static final ExecutorCoroutineDispatcher vlmNativeDispatcher;
    private GenieConfigResolution atRestConfig;
    private volatile long nativeHandle;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnVLMModel", f = "QnnVLMModel.kt", l = {Content.Types.TYPE_BOOLEAN}, m = "doClose")
    /* renamed from: com.stepos.backend.qnn.QnnVLMModel$doClose$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnVLMModel.this.doClose(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnVLMModel$doInferInternal$1", f = "QnnVLMModel.kt", l = {193, 201, 229, 254}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnVLMModel$doInferInternal$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02771 extends SuspendLambda implements zb.p<ProducerScope<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ Object $input;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ QnnVLMModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02771(Object obj, QnnVLMModel qnnVLMModel, qb.b<? super C02771> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = qnnVLMModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final lb.n invokeSuspend$lambda$0(StringBuilder sb2, ProducerScope producerScope, QnnVLMModel qnnVLMModel, String str) {
            sb2.append(str);
            if (ChannelResult.m159isFailureimpl(producerScope.mo149trySendJP2dKIU(new Result(new d.q(str, null, 0 == true ? 1 : 0, 6))))) {
                if (producerScope.isClosedForSend()) {
                    throw new CancellationException("VLM flow closed");
                }
                Log.w(qnnVLMModel.getTAG(), "Drop VLM token (buffer full)");
            }
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$1(QnnVLMModel qnnVLMModel, StringBuilder sb2, ProducerScope producerScope) {
            Log.i(qnnVLMModel.getTAG(), "VLM output: len=" + sb2.length());
            SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$2(StringBuilder sb2, QnnVLMModel qnnVLMModel, ProducerScope producerScope, int i10, String str) {
            if (sb2.length() > 0) {
                Log.i(qnnVLMModel.getTAG(), "VLM output (partial before error): len=" + sb2.length());
            }
            producerScope.close(new RuntimeException(a0.a.g("VLM error ", i10, ": ", str)));
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$6(QnnVLMModel qnnVLMModel, ResolvedVlmInputs resolvedVlmInputs, StreamCallback streamCallback) {
            return ((Boolean) AiEngineAtrace.section("qnn/call", "vlm_stream", new f0(qnnVLMModel, resolvedVlmInputs, streamCallback, 0))).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$6$lambda$5(QnnVLMModel qnnVLMModel, ResolvedVlmInputs resolvedVlmInputs, StreamCallback streamCallback) {
            return QnnNative.nativeVLMStream(qnnVLMModel.nativeHandle, resolvedVlmInputs.getSystemPrompt(), resolvedVlmInputs.getPrompt(), resolvedVlmInputs.getImageBytes(), resolvedVlmInputs.getVideoPaths(), resolvedVlmInputs.getVideoFilterFps(), resolvedVlmInputs.getMaxTokens(), resolvedVlmInputs.getVlmTemperature(), resolvedVlmInputs.getVlmTopK(), resolvedVlmInputs.getVlmTopP(), streamCallback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$9(boolean z, ProducerScope producerScope, QnnVLMModel qnnVLMModel) {
            Object objA;
            if (z) {
                try {
                    QnnNative.nativeClearLLMPhaseCallback(qnnVLMModel.nativeHandle, 2);
                    objA = lb.n.f10413a;
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    Log.w(qnnVLMModel.getTAG(), "[Phase] clear failed modelId=".concat(qnnVLMModel.getConfig().f3090a), thB);
                }
            }
            QnnNative.INSTANCE.releaseInferPermit(qnnVLMModel.getConfig().f3090a);
            Log.d(qnnVLMModel.getTAG(), "VLM stream flow closed, permit released");
            return lb.n.f10413a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C02771 c02771 = new C02771(this.$input, this.this$0, bVar);
            c02771.L$0 = obj;
            return c02771;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Result<? extends d.q>> producerScope, qb.b<? super lb.n> bVar) {
            return invoke2((ProducerScope<? super Result<d.q>>) producerScope, bVar);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(12:16|17|52|(1:76)(10:57|100|58|59|98|60|67|(1:70)|71|(1:73)(8:75|96|77|(2:79|91)|80|(0)|(0)(0)|89))|74|96|77|(0)|80|(0)|(0)(0)|89) */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0227, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0260, code lost:
        
            if (kotlinx.coroutines.channels.ProduceKt.awaitClose(r5, r2, r20) == r4) goto L91;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:70:0x01bb  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x01dc  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x01f3  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0213  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x021c A[Catch: Exception -> 0x0227, TRY_LEAVE, TryCatch #0 {Exception -> 0x0227, blocks: (B:80:0x0214, B:82:0x021c, B:77:0x01f7), top: B:96:0x01f7 }] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0248  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x024a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 640
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnVLMModel.C02771.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProducerScope<? super Result<d.q>> producerScope, qb.b<? super lb.n> bVar) {
            return ((C02771) create(producerScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnVLMModel", f = "QnnVLMModel.kt", l = {74, 85}, m = "doInitialize")
    /* renamed from: com.stepos.backend.qnn.QnnVLMModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02781 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02781(qb.b<? super C02781> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnVLMModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnVLMModel$doInitialize$2", f = "QnnVLMModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnVLMModel$doInitialize$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.l<qb.b<? super lb.n>, Object> {
        final /* synthetic */ String $modelPath;
        final /* synthetic */ String $nativeLibDir;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, String str2, qb.b<? super AnonymousClass2> bVar) {
            super(1, bVar);
            this.$modelPath = str;
            this.$nativeLibDir = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$0(QnnVLMModel qnnVLMModel, String str, String str2) {
            qnnVLMModel.nativeHandle = QnnNative.nativeVLMInit(str, str2);
            if (qnnVLMModel.nativeHandle != 0) {
                return lb.n.f10413a;
            }
            throw new IllegalStateException(ai.onnxruntime.a.k("VLM model init failed: ", str));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(qb.b<?> bVar) {
            return QnnVLMModel.this.new AnonymousClass2(this.$modelPath, this.$nativeLibDir, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            AiEngineAtrace.section("qnn/init", ModelCacheImpl.MODEL_TYPE_VLM, new v(QnnVLMModel.this, this.$modelPath, this.$nativeLibDir, 2));
            return lb.n.f10413a;
        }

        @Override // zb.l
        public final Object invoke(qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnVLMModel", f = "QnnVLMModel.kt", l = {323, 323}, m = "processMixed")
    /* renamed from: com.stepos.backend.qnn.QnnVLMModel$processMixed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02791 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C02791(qb.b<? super C02791> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnVLMModel.this.processMixed(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnVLMModel", f = "QnnVLMModel.kt", l = {293}, m = "processMixedStream")
    /* renamed from: com.stepos.backend.qnn.QnnVLMModel$processMixedStream$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02811 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02811(qb.b<? super C02811> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnVLMModel.this.processMixedStream(null, null, this);
        }
    }

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new com.stepos.aicgroup.d(3));
        kotlin.jvm.internal.g.e(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        vlmNativeDispatcher = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QnnVLMModel(b7.k config) {
        super(config);
        kotlin.jvm.internal.g.f(config, "config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n doClose$lambda$0(QnnVLMModel qnnVLMModel) {
        QnnNative.nativeVLMRelease(qnnVLMModel.nativeHandle);
        return lb.n.f10413a;
    }

    private final byte[] encodeBitmapToPng(Bitmap bitmap) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (Exception e10) {
            Log.e(getTAG(), "encodeBitmapToPng failed: " + e10.getMessage(), e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0126 A[PHI: r1
      0x0126: PHI (r1v22 java.lang.String) = (r1v7 java.lang.String), (r1v25 java.lang.String) binds: [B:61:0x0138, B:54:0x0124] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.backend.qnn.QnnVLMModel.ResolvedVlmInputs resolveVlmInputs(v6.c.e r17) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnVLMModel.resolveVlmInputs(v6.c$e):com.stepos.backend.qnn.QnnVLMModel$ResolvedVlmInputs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread vlmNativeDispatcher$lambda$13(Runnable runnable) {
        return com.stepos.core.ota.d.n(runnable, "QnnVLM-native", true);
    }

    @Override // com.stepos.base.model.ModelBase, b7.a
    public boolean cancel() {
        Object objA;
        Log.d(getTAG(), "cancel: signaling native VLM preemption");
        try {
            objA = Boolean.valueOf(QnnNative.nativeVLMCancel(this.nativeHandle));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doClose(qb.b<? super lb.n> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Failed to release VLM model: "
            boolean r1 = r7 instanceof com.stepos.backend.qnn.QnnVLMModel.AnonymousClass1
            if (r1 == 0) goto L15
            r1 = r7
            com.stepos.backend.qnn.QnnVLMModel$doClose$1 r1 = (com.stepos.backend.qnn.QnnVLMModel.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.backend.qnn.QnnVLMModel$doClose$1 r1 = new com.stepos.backend.qnn.QnnVLMModel$doClose$1
            r1.<init>(r7)
        L1a:
            java.lang.Object r7 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L35
            if (r3 != r4) goto L2d
            java.lang.Object r6 = r1.L$0
            com.stepos.backend.qnn.QnnVLMModel r6 = (com.stepos.backend.qnn.QnnVLMModel) r6
            kotlin.c.b(r7)
            goto L56
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.c.b(r7)
            java.lang.String r7 = r6.getTAG()
            java.lang.String r3 = "doClose: waiting for running inference to finish..."
            android.util.Log.d(r7, r3)
            com.stepos.backend.qnn.QnnNative r7 = com.stepos.backend.qnn.QnnNative.INSTANCE
            b7.k r3 = r6.getConfig()
            java.lang.String r3 = r3.f3090a
            r1.L$0 = r6
            r1.label = r4
            r4 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r7 = r7.acquireInferPermitWithTimeout(r3, r4, r1)
            if (r7 != r2) goto L56
            return r2
        L56:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L7b
            java.lang.String r1 = r6.getTAG()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r2 = "doClose: timeout waiting for infer permit; skip nativeVLMRelease to avoid UAF"
            android.util.Log.e(r1, r2)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            lb.n r0 = lb.n.f10413a     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            if (r7 == 0) goto L76
            com.stepos.backend.qnn.QnnNative r7 = com.stepos.backend.qnn.QnnNative.INSTANCE
            b7.k r6 = r6.getConfig()
            java.lang.String r6 = r6.f3090a
            r7.releaseInferPermit(r6)
        L76:
            return r0
        L77:
            r0 = move-exception
            goto Lcf
        L79:
            r1 = move-exception
            goto Lb2
        L7b:
            java.lang.String r1 = r6.getTAG()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r2 = "doClose: releasing VLM model"
            android.util.Log.d(r1, r2)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r1 = "qnn/release"
            java.lang.String r2 = "vlm"
            com.stepos.backend.qnn.w r3 = new com.stepos.backend.qnn.w     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r4 = 5
            r3.<init>(r6, r4)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            com.stepos.core.common.log.AiEngineAtrace.section(r1, r2, r3)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            com.stepos.backend.qnn.GenieConfigResolution r1 = r6.atRestConfig     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            if (r1 == 0) goto L98
            r1.release()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
        L98:
            r1 = 0
            r6.atRestConfig = r1     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r1 = r6.getTAG()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r2 = "✅ VLM model released"
            android.util.Log.i(r1, r2)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            if (r7 == 0) goto Lcc
        La6:
            com.stepos.backend.qnn.QnnNative r7 = com.stepos.backend.qnn.QnnNative.INSTANCE
            b7.k r6 = r6.getConfig()
            java.lang.String r6 = r6.f3090a
            r7.releaseInferPermit(r6)
            goto Lcc
        Lb2:
            java.lang.String r2 = r6.getTAG()     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = r1.getMessage()     // Catch: java.lang.Throwable -> L77
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L77
            r4.append(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L77
            android.util.Log.e(r2, r0, r1)     // Catch: java.lang.Throwable -> L77
            if (r7 == 0) goto Lcc
            goto La6
        Lcc:
            lb.n r6 = lb.n.f10413a
            return r6
        Lcf:
            if (r7 == 0) goto Ldc
            com.stepos.backend.qnn.QnnNative r7 = com.stepos.backend.qnn.QnnNative.INSTANCE
            b7.k r6 = r6.getConfig()
            java.lang.String r6 = r6.f3090a
            r7.releaseInferPermit(r6)
        Ldc:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnVLMModel.doClose(qb.b):java.lang.Object");
    }

    @Override // com.stepos.backend.qnn.QnnModelBase
    public Flow<Result<v6.d>> doInferInternal(Object input) {
        kotlin.jvm.internal.g.f(input, "input");
        return FlowKt.flowOn(FlowKt__ContextKt.buffer$default(FlowKt.callbackFlow(new C02771(input, this, null)), 1024, null, 2, null), vlmNativeDispatcher);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInitialize(android.content.Context r8, b7.k r9, qb.b<? super lb.n> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.stepos.backend.qnn.QnnVLMModel.C02781
            if (r0 == 0) goto L14
            r0 = r10
            com.stepos.backend.qnn.QnnVLMModel$doInitialize$1 r0 = (com.stepos.backend.qnn.QnnVLMModel.C02781) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.stepos.backend.qnn.QnnVLMModel$doInitialize$1 r0 = new com.stepos.backend.qnn.QnnVLMModel$doInitialize$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L4f
            if (r1 == r3) goto L3d
            if (r1 != r2) goto L35
            java.lang.Object r7 = r4.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r4.L$0
            com.stepos.backend.qnn.QnnVLMModel r8 = (com.stepos.backend.qnn.QnnVLMModel) r8
            kotlin.c.b(r10)
            goto Lb4
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            java.lang.Object r7 = r4.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r4.L$1
            android.content.Context r8 = (android.content.Context) r8
            java.lang.Object r9 = r4.L$0
            com.stepos.backend.qnn.QnnVLMModel r9 = (com.stepos.backend.qnn.QnnVLMModel) r9
            kotlin.c.b(r10)
            r1 = r7
            r7 = r9
            goto L74
        L4f:
            kotlin.c.b(r10)
            java.lang.String r10 = r9.b()
            if (r10 != 0) goto L5a
            java.lang.String r10 = r9.f3091b
        L5a:
            android.content.pm.ApplicationInfo r1 = r8.getApplicationInfo()
            java.lang.String r1 = r1.nativeLibraryDir
            java.io.File r5 = new java.io.File
            r5.<init>(r10)
            r4.L$0 = r7
            r4.L$1 = r8
            r4.L$2 = r1
            r4.label = r3
            java.lang.Object r10 = com.stepos.backend.qnn.QnnModelBaseKt.resolveGenieConfig(r9, r5, r4)
            if (r10 != r0) goto L74
            goto Lb1
        L74:
            com.stepos.backend.qnn.GenieConfigResolution r10 = (com.stepos.backend.qnn.GenieConfigResolution) r10
            r7.atRestConfig = r10
            java.lang.String r9 = r10.getConfigPath()
            java.lang.String r10 = r7.getTAG()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Initializing VLM model: "
            r3.<init>(r5)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            android.util.Log.i(r10, r3)
            r7.checkModelFile(r9)
            r10 = r1
            com.stepos.backend.qnn.QnnNative r1 = com.stepos.backend.qnn.QnnNative.INSTANCE
            r1.init(r8)
            com.stepos.backend.qnn.QnnVLMModel$doInitialize$2 r3 = new com.stepos.backend.qnn.QnnVLMModel$doInitialize$2
            r8 = 0
            r3.<init>(r9, r10, r8)
            r4.L$0 = r7
            r4.L$1 = r9
            r4.L$2 = r8
            r4.label = r2
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r8 = com.stepos.backend.qnn.QnnNative.withInferLock$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto Lb2
        Lb1:
            return r0
        Lb2:
            r8 = r7
            r7 = r9
        Lb4:
            java.lang.String r8 = r8.getTAG()
            java.lang.String r9 = "✅ VLM model initialized: "
            a0.a.y(r9, r7, r8)
            lb.n r7 = lb.n.f10413a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnVLMModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
    }

    @Override // com.stepos.backend.qnn.QnnModelBase, com.stepos.base.model.ModelBase
    public Object doWarmup(qb.b<? super lb.n> bVar) {
        Log.d(getTAG(), "VLM warmup skipped (requires image or video)");
        return lb.n.f10413a;
    }

    @Override // e7.b
    public ProtocolType getType() {
        return ProtocolType.f6382e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // e7.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object processMixed(v6.c.e r13, java.lang.Object r14, qb.b<? super v6.d> r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnVLMModel.processMixed(v6.c$e, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // e7.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object processMixedStream(v6.c.e r23, java.lang.Object r24, qb.b<? super kotlinx.coroutines.flow.Flow<? extends v6.d>> r25) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnVLMModel.processMixedStream(v6.c$e, java.lang.Object, qb.b):java.lang.Object");
    }

    public final Object processVLMStream(c.e eVar, qb.b<? super Flow<? extends Result<? extends v6.d>>> bVar) {
        return infer(eVar, bVar);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ResolvedVlmInputs {
        private final byte[][] imageBytes;
        private final int maxTokens;
        private final String prompt;
        private final String systemPrompt;
        private final int videoFilterFps;
        private final String[] videoPaths;
        private final float vlmTemperature;
        private final int vlmTopK;
        private final float vlmTopP;

        public ResolvedVlmInputs(String str, String prompt, byte[][] imageBytes, String[] videoPaths, int i10, int i11, float f8, int i12, float f9) {
            kotlin.jvm.internal.g.f(prompt, "prompt");
            kotlin.jvm.internal.g.f(imageBytes, "imageBytes");
            kotlin.jvm.internal.g.f(videoPaths, "videoPaths");
            this.systemPrompt = str;
            this.prompt = prompt;
            this.imageBytes = imageBytes;
            this.videoPaths = videoPaths;
            this.videoFilterFps = i10;
            this.maxTokens = i11;
            this.vlmTemperature = f8;
            this.vlmTopK = i12;
            this.vlmTopP = f9;
        }

        public static /* synthetic */ ResolvedVlmInputs copy$default(ResolvedVlmInputs resolvedVlmInputs, String str, String str2, byte[][] bArr, String[] strArr, int i10, int i11, float f8, int i12, float f9, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                str = resolvedVlmInputs.systemPrompt;
            }
            if ((i13 & 2) != 0) {
                str2 = resolvedVlmInputs.prompt;
            }
            if ((i13 & 4) != 0) {
                bArr = resolvedVlmInputs.imageBytes;
            }
            if ((i13 & 8) != 0) {
                strArr = resolvedVlmInputs.videoPaths;
            }
            if ((i13 & 16) != 0) {
                i10 = resolvedVlmInputs.videoFilterFps;
            }
            if ((i13 & 32) != 0) {
                i11 = resolvedVlmInputs.maxTokens;
            }
            if ((i13 & 64) != 0) {
                f8 = resolvedVlmInputs.vlmTemperature;
            }
            if ((i13 & TraceIdKeys.MAX_LENGTH) != 0) {
                i12 = resolvedVlmInputs.vlmTopK;
            }
            if ((i13 & 256) != 0) {
                f9 = resolvedVlmInputs.vlmTopP;
            }
            int i14 = i12;
            float f10 = f9;
            int i15 = i11;
            float f11 = f8;
            int i16 = i10;
            byte[][] bArr2 = bArr;
            return resolvedVlmInputs.copy(str, str2, bArr2, strArr, i16, i15, f11, i14, f10);
        }

        public final String component1() {
            return this.systemPrompt;
        }

        public final String component2() {
            return this.prompt;
        }

        public final byte[][] component3() {
            return this.imageBytes;
        }

        public final String[] component4() {
            return this.videoPaths;
        }

        public final int component5() {
            return this.videoFilterFps;
        }

        public final int component6() {
            return this.maxTokens;
        }

        public final float component7() {
            return this.vlmTemperature;
        }

        public final int component8() {
            return this.vlmTopK;
        }

        public final float component9() {
            return this.vlmTopP;
        }

        public final ResolvedVlmInputs copy(String str, String prompt, byte[][] imageBytes, String[] videoPaths, int i10, int i11, float f8, int i12, float f9) {
            kotlin.jvm.internal.g.f(prompt, "prompt");
            kotlin.jvm.internal.g.f(imageBytes, "imageBytes");
            kotlin.jvm.internal.g.f(videoPaths, "videoPaths");
            return new ResolvedVlmInputs(str, prompt, imageBytes, videoPaths, i10, i11, f8, i12, f9);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResolvedVlmInputs)) {
                return false;
            }
            ResolvedVlmInputs resolvedVlmInputs = (ResolvedVlmInputs) obj;
            return kotlin.jvm.internal.g.b(this.systemPrompt, resolvedVlmInputs.systemPrompt) && kotlin.jvm.internal.g.b(this.prompt, resolvedVlmInputs.prompt) && kotlin.jvm.internal.g.b(this.imageBytes, resolvedVlmInputs.imageBytes) && kotlin.jvm.internal.g.b(this.videoPaths, resolvedVlmInputs.videoPaths) && this.videoFilterFps == resolvedVlmInputs.videoFilterFps && this.maxTokens == resolvedVlmInputs.maxTokens && Float.compare(this.vlmTemperature, resolvedVlmInputs.vlmTemperature) == 0 && this.vlmTopK == resolvedVlmInputs.vlmTopK && Float.compare(this.vlmTopP, resolvedVlmInputs.vlmTopP) == 0;
        }

        public final byte[][] getImageBytes() {
            return this.imageBytes;
        }

        public final int getMaxTokens() {
            return this.maxTokens;
        }

        public final String getPrompt() {
            return this.prompt;
        }

        public final String getSystemPrompt() {
            return this.systemPrompt;
        }

        public final int getVideoFilterFps() {
            return this.videoFilterFps;
        }

        public final String[] getVideoPaths() {
            return this.videoPaths;
        }

        public final float getVlmTemperature() {
            return this.vlmTemperature;
        }

        public final int getVlmTopK() {
            return this.vlmTopK;
        }

        public final float getVlmTopP() {
            return this.vlmTopP;
        }

        public int hashCode() {
            String str = this.systemPrompt;
            return Float.hashCode(this.vlmTopP) + ai.onnxruntime.a.d(this.vlmTopK, a0.a.a(this.vlmTemperature, ai.onnxruntime.a.d(this.maxTokens, ai.onnxruntime.a.d(this.videoFilterFps, (((Arrays.hashCode(this.imageBytes) + v1.d.a((str == null ? 0 : str.hashCode()) * 31, 31, this.prompt)) * 31) + Arrays.hashCode(this.videoPaths)) * 31, 31), 31), 31), 31);
        }

        public String toString() {
            String str = this.systemPrompt;
            String str2 = this.prompt;
            String string = Arrays.toString(this.imageBytes);
            String string2 = Arrays.toString(this.videoPaths);
            int i10 = this.videoFilterFps;
            int i11 = this.maxTokens;
            float f8 = this.vlmTemperature;
            int i12 = this.vlmTopK;
            float f9 = this.vlmTopP;
            StringBuilder sbS = ai.onnxruntime.a.s("ResolvedVlmInputs(systemPrompt=", str, ", prompt=", str2, ", imageBytes=");
            ai.onnxruntime.a.z(sbS, string, ", videoPaths=", string2, ", videoFilterFps=");
            h0.e.l(sbS, i10, ", maxTokens=", i11, ", vlmTemperature=");
            sbS.append(f8);
            sbS.append(", vlmTopK=");
            sbS.append(i12);
            sbS.append(", vlmTopP=");
            sbS.append(f9);
            sbS.append(")");
            return sbS.toString();
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
            	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
            	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
            	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
            */
        public /* synthetic */ ResolvedVlmInputs(java.lang.String r2, java.lang.String r3, byte[][] r4, java.lang.String[] r5, int r6, int r7, float r8, int r9, float r10, int r11, kotlin.jvm.internal.e r12) {
            /*
                r1 = this;
                r12 = r11 & 1
                if (r12 == 0) goto L5
                r2 = 0
            L5:
                r12 = r11 & 64
                r0 = -1082130432(0xffffffffbf800000, float:-1.0)
                if (r12 == 0) goto Lc
                r8 = r0
            Lc:
                r12 = r11 & 128(0x80, float:1.8E-43)
                if (r12 == 0) goto L11
                r9 = -1
            L11:
                r11 = r11 & 256(0x100, float:3.59E-43)
                if (r11 == 0) goto L20
                r12 = r0
                r10 = r8
                r11 = r9
                r8 = r6
                r9 = r7
                r6 = r4
                r7 = r5
                r4 = r2
                r5 = r3
                r3 = r1
                goto L2a
            L20:
                r12 = r10
                r11 = r9
                r9 = r7
                r10 = r8
                r7 = r5
                r8 = r6
                r5 = r3
                r6 = r4
                r3 = r1
                r4 = r2
            L2a:
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnVLMModel.ResolvedVlmInputs.<init>(java.lang.String, java.lang.String, byte[][], java.lang.String[], int, int, float, int, float, int, kotlin.jvm.internal.e):void");
        }
    }
}
