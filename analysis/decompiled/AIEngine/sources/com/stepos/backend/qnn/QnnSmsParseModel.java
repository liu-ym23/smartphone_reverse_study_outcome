package com.stepos.backend.qnn;

import android.content.Context;
import android.util.Log;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.common.log.AiEngineAtrace;
import com.stepos.core.model.callback.StreamCallback;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class QnnSmsParseModel extends QnnModelBase implements e7.h {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnSmsParseModel", f = "QnnSmsParseModel.kt", l = {87}, m = "doClose")
    /* renamed from: com.stepos.backend.qnn.QnnSmsParseModel$doClose$1, reason: invalid class name */
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
            return QnnSmsParseModel.this.doClose(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnSmsParseModel", f = "QnnSmsParseModel.kt", l = {179}, m = "doFlowInfer")
    /* renamed from: com.stepos.backend.qnn.QnnSmsParseModel$doFlowInfer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02681 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02681(qb.b<? super C02681> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnSmsParseModel.this.doFlowInfer(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnSmsParseModel$doInferInternal$1", f = "QnnSmsParseModel.kt", l = {131, 135, 148}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnSmsParseModel$doInferInternal$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02691 extends SuspendLambda implements zb.p<ProducerScope<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ Object $input;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ QnnSmsParseModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02691(Object obj, QnnSmsParseModel qnnSmsParseModel, qb.b<? super C02691> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = qnnSmsParseModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final lb.n invokeSuspend$lambda$0(ProducerScope producerScope, QnnSmsParseModel qnnSmsParseModel, String str) {
            if (ChannelResult.m159isFailureimpl(producerScope.mo149trySendJP2dKIU(new Result(new d.q(str, null, 0 == true ? 1 : 0, 6))))) {
                if (producerScope.isClosedForSend()) {
                    throw new CancellationException("SMS-parse flow closed");
                }
                Log.w(qnnSmsParseModel.getTAG(), "Drop SMS-parse token (buffer full)");
            }
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$1(ProducerScope producerScope) {
            SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$2(ProducerScope producerScope, int i10, String str) {
            producerScope.close(new RuntimeException(a0.a.g("SMS-parse error ", i10, ": ", str)));
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$4(String str, StreamCallback streamCallback) {
            return ((Boolean) AiEngineAtrace.section("qnn/call", "sms_parse_stream", new a0(1, str, streamCallback))).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$5(QnnSmsParseModel qnnSmsParseModel) {
            QnnNative.INSTANCE.releaseInferPermit(qnnSmsParseModel.getConfig().f3090a);
            Log.d(qnnSmsParseModel.getTAG(), "SMS-parse stream flow closed");
            return lb.n.f10413a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C02691 c02691 = new C02691(this.$input, this.this$0, bVar);
            c02691.L$0 = obj;
            return c02691;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Result<? extends d.q>> producerScope, qb.b<? super lb.n> bVar) {
            return invoke2((ProducerScope<? super Result<d.q>>) producerScope, bVar);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(1:(1:(1:(3:7|40|41)(2:8|9))(6:10|46|11|30|(1:32)|37))(1:15))(5:16|(1:18)(2:19|(1:21)(2:42|43))|22|(1:25)|39)|44|26|(4:29|30|(0)|37)|39|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00cc, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00cd, code lost:
        
            r1 = r12;
            r12 = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0102, code lost:
        
            if (kotlinx.coroutines.channels.ProduceKt.awaitClose(r1, r3, r11) == r0) goto L39;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c1 A[Catch: Exception -> 0x0026, TRY_LEAVE, TryCatch #1 {Exception -> 0x0026, blocks: (B:11:0x0021, B:30:0x00b9, B:32:0x00c1), top: B:46:0x0021 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 290
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnSmsParseModel.C02691.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProducerScope<? super Result<d.q>> producerScope, qb.b<? super lb.n> bVar) {
            return ((C02691) create(producerScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnSmsParseModel", f = "QnnSmsParseModel.kt", l = {71, 71}, m = "doWarmup")
    /* renamed from: com.stepos.backend.qnn.QnnSmsParseModel$doWarmup$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02701 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C02701(qb.b<? super C02701> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnSmsParseModel.this.doWarmup(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnSmsParseModel", f = "QnnSmsParseModel.kt", l = {172}, m = "processText")
    /* renamed from: com.stepos.backend.qnn.QnnSmsParseModel$processText$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02711 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02711(qb.b<? super C02711> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnSmsParseModel.this.processText(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QnnSmsParseModel(b7.k config) {
        super(config);
        kotlin.jvm.internal.g.f(config, "config");
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
            java.lang.String r0 = "Failed to release SMS-parse model: "
            boolean r1 = r7 instanceof com.stepos.backend.qnn.QnnSmsParseModel.AnonymousClass1
            if (r1 == 0) goto L15
            r1 = r7
            com.stepos.backend.qnn.QnnSmsParseModel$doClose$1 r1 = (com.stepos.backend.qnn.QnnSmsParseModel.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.backend.qnn.QnnSmsParseModel$doClose$1 r1 = new com.stepos.backend.qnn.QnnSmsParseModel$doClose$1
            r1.<init>(r7)
        L1a:
            java.lang.Object r7 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L35
            if (r3 != r4) goto L2d
            java.lang.Object r6 = r1.L$0
            com.stepos.backend.qnn.QnnSmsParseModel r6 = (com.stepos.backend.qnn.QnnSmsParseModel) r6
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
            java.lang.String r3 = "doClose: waiting for running inference…"
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
            java.lang.String r2 = "doClose: timeout waiting for infer permit; skip nativeRelease to avoid UAF"
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
            goto Lbb
        L79:
            r1 = move-exception
            goto L9e
        L7b:
            java.lang.String r1 = r6.getTAG()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r2 = "doClose: releasing SMS-parse model"
            android.util.Log.d(r1, r2)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            com.stepos.backend.qnn.SmsParseQnnJni.nativeRelease()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r1 = r6.getTAG()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r2 = "✅ SMS-parse model released"
            android.util.Log.i(r1, r2)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            if (r7 == 0) goto Lb8
        L92:
            com.stepos.backend.qnn.QnnNative r7 = com.stepos.backend.qnn.QnnNative.INSTANCE
            b7.k r6 = r6.getConfig()
            java.lang.String r6 = r6.f3090a
            r7.releaseInferPermit(r6)
            goto Lb8
        L9e:
            java.lang.String r2 = r6.getTAG()     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = r1.getMessage()     // Catch: java.lang.Throwable -> L77
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L77
            r4.append(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L77
            android.util.Log.e(r2, r0, r1)     // Catch: java.lang.Throwable -> L77
            if (r7 == 0) goto Lb8
            goto L92
        Lb8:
            lb.n r6 = lb.n.f10413a
            return r6
        Lbb:
            if (r7 == 0) goto Lc8
            com.stepos.backend.qnn.QnnNative r7 = com.stepos.backend.qnn.QnnNative.INSTANCE
            b7.k r6 = r6.getConfig()
            java.lang.String r6 = r6.f3090a
            r7.releaseInferPermit(r6)
        Lc8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnSmsParseModel.doClose(qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.backend.qnn.QnnModelBase, com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doFlowInfer(java.lang.Object r5, qb.b<? super kotlinx.coroutines.flow.Flow<? extends kotlin.Result<? extends java.lang.Object>>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.backend.qnn.QnnSmsParseModel.C02681
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.backend.qnn.QnnSmsParseModel$doFlowInfer$1 r0 = (com.stepos.backend.qnn.QnnSmsParseModel.C02681) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.QnnSmsParseModel$doFlowInfer$1 r0 = new com.stepos.backend.qnn.QnnSmsParseModel$doFlowInfer$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r6)
            goto L44
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.c.b(r6)
            java.lang.String r6 = r4.getTAG()
            java.lang.String r2 = "doFlowInfer: native SMS-parse inference"
            android.util.Log.d(r6, r2)
            r0.label = r3
            java.lang.Object r6 = r4.infer(r5, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
            com.stepos.backend.qnn.QnnSmsParseModel$doFlowInfer$$inlined$map$1 r4 = new com.stepos.backend.qnn.QnnSmsParseModel$doFlowInfer$$inlined$map$1
            r4.<init>()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnSmsParseModel.doFlowInfer(java.lang.Object, qb.b):java.lang.Object");
    }

    @Override // com.stepos.backend.qnn.QnnModelBase
    public Flow<Result<v6.d>> doInferInternal(Object input) {
        kotlin.jvm.internal.g.f(input, "input");
        return FlowKt.flowOn(FlowKt__ContextKt.buffer$default(FlowKt.callbackFlow(new C02691(input, this, null)), 1024, null, 2, null), Dispatchers.getIO());
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doInitialize(Context context, b7.k kVar, qb.b<? super lb.n> bVar) {
        String strB = kVar.b();
        if (strB == null) {
            strB = kVar.f3091b;
        }
        String str = context.getApplicationInfo().nativeLibraryDir;
        Log.i(getTAG(), "Initializing SMS-parse QNN model: " + strB);
        checkModelFile(strB);
        File parentFile = new File(strB).getParentFile();
        if (parentFile == null) {
            throw new IllegalStateException(ai.onnxruntime.a.k("Invalid model path (no parent): ", strB));
        }
        SmsParseNative.INSTANCE.ensureRuntime(context);
        if (!SmsParseQnnJni.INSTANCE.ensureLoaded()) {
            throw new IllegalStateException("Missing libsmsparse_qnn.so; check app CMake smsparse_qnn target and jniLibs");
        }
        SmsParseGenieConfig smsParseGenieConfig = SmsParseGenieConfig.INSTANCE;
        smsParseGenieConfig.ensureHtpBackendConfig(parentFile);
        String strApplySmsparseEngineDefaults = smsParseGenieConfig.applySmsparseEngineDefaults(smsParseGenieConfig.loadResolvedGenieJson(parentFile, strB));
        smsParseGenieConfig.logInitDiagnostics(parentFile, strApplySmsparseEngineDefaults);
        String absolutePath = parentFile.getAbsolutePath();
        kotlin.jvm.internal.g.e(absolutePath, "getAbsolutePath(...)");
        if (!SmsParseQnnJni.nativeInitWithGenieJson(strApplySmsparseEngineDefaults, absolutePath, str)) {
            throw new IllegalStateException(com.stepos.core.ota.d.h("SMS-parse Genie init failed: modelDir=", SmsParseQnnJni.nativeGetLastInitErrorCode(), parentFile.getPath(), " genieStatus="));
        }
        a0.a.y("✅ SMS-parse QNN model initialized: ", strB, getTAG());
        return lb.n.f10413a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // com.stepos.backend.qnn.QnnModelBase, com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doWarmup(qb.b<? super lb.n> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "SMS-parse warmup done, length="
            boolean r1 = r8 instanceof com.stepos.backend.qnn.QnnSmsParseModel.C02701
            if (r1 == 0) goto L15
            r1 = r8
            com.stepos.backend.qnn.QnnSmsParseModel$doWarmup$1 r1 = (com.stepos.backend.qnn.QnnSmsParseModel.C02701) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.backend.qnn.QnnSmsParseModel$doWarmup$1 r1 = new com.stepos.backend.qnn.QnnSmsParseModel$doWarmup$1
            r1.<init>(r8)
        L1a:
            java.lang.Object r8 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r3 = r1.label
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L50
            if (r3 == r5) goto L42
            if (r3 != r4) goto L3a
            java.lang.Object r7 = r1.L$1
            java.lang.StringBuilder r7 = (java.lang.StringBuilder) r7
            java.lang.Object r1 = r1.L$0
            com.stepos.backend.qnn.QnnSmsParseModel r1 = (com.stepos.backend.qnn.QnnSmsParseModel) r1
            kotlin.c.b(r8)     // Catch: java.lang.Exception -> L36
            r8 = r7
            r7 = r1
            goto L8a
        L36:
            r7 = move-exception
            r3 = r1
            goto La5
        L3a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L42:
            java.lang.Object r7 = r1.L$1
            java.lang.StringBuilder r7 = (java.lang.StringBuilder) r7
            java.lang.Object r3 = r1.L$0
            com.stepos.backend.qnn.QnnSmsParseModel r3 = (com.stepos.backend.qnn.QnnSmsParseModel) r3
            kotlin.c.b(r8)     // Catch: java.lang.Exception -> L4e
            goto L74
        L4e:
            r7 = move-exception
            goto La5
        L50:
            kotlin.c.b(r8)
            java.lang.String r8 = r7.getTAG()
            java.lang.String r3 = "SMS-parse warmup: test inference"
            android.util.Log.d(r8, r3)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La2
            r8.<init>()     // Catch: java.lang.Exception -> La2
            java.lang.String r3 = "Hello"
            r1.L$0 = r7     // Catch: java.lang.Exception -> La2
            r1.L$1 = r8     // Catch: java.lang.Exception -> La2
            r1.label = r5     // Catch: java.lang.Exception -> La2
            java.lang.Object r3 = r7.infer(r3, r1)     // Catch: java.lang.Exception -> La2
            if (r3 != r2) goto L70
            goto L87
        L70:
            r6 = r3
            r3 = r7
            r7 = r8
            r8 = r6
        L74:
            kotlinx.coroutines.flow.Flow r8 = (kotlinx.coroutines.flow.Flow) r8     // Catch: java.lang.Exception -> L4e
            com.stepos.backend.qnn.QnnSmsParseModel$doWarmup$2 r5 = new com.stepos.backend.qnn.QnnSmsParseModel$doWarmup$2     // Catch: java.lang.Exception -> L4e
            r5.<init>()     // Catch: java.lang.Exception -> L4e
            r1.L$0 = r3     // Catch: java.lang.Exception -> L4e
            r1.L$1 = r7     // Catch: java.lang.Exception -> L4e
            r1.label = r4     // Catch: java.lang.Exception -> L4e
            java.lang.Object r8 = r8.collect(r5, r1)     // Catch: java.lang.Exception -> L4e
            if (r8 != r2) goto L88
        L87:
            return r2
        L88:
            r8 = r7
            r7 = r3
        L8a:
            java.lang.String r1 = r7.getTAG()     // Catch: java.lang.Exception -> La2
            int r8 = r8.length()     // Catch: java.lang.Exception -> La2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La2
            r2.<init>(r0)     // Catch: java.lang.Exception -> La2
            r2.append(r8)     // Catch: java.lang.Exception -> La2
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Exception -> La2
            android.util.Log.d(r1, r8)     // Catch: java.lang.Exception -> La2
            goto Lb2
        La2:
            r8 = move-exception
            r3 = r7
            r7 = r8
        La5:
            java.lang.String r8 = r3.getTAG()
            java.lang.String r7 = r7.getMessage()
            java.lang.String r0 = "SMS-parse warmup failed (non-critical): "
            a0.a.A(r0, r7, r8)
        Lb2:
            lb.n r7 = lb.n.f10413a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnSmsParseModel.doWarmup(qb.b):java.lang.Object");
    }

    @Override // e7.b
    public ProtocolType getType() {
        return ProtocolType.f6378a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // e7.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object processText(v6.c.g r23, java.lang.Object r24, qb.b<? super kotlinx.coroutines.flow.Flow<? extends v6.d>> r25) {
        /*
            r22 = this;
            r0 = r24
            r1 = r25
            boolean r2 = r1 instanceof com.stepos.backend.qnn.QnnSmsParseModel.C02711
            if (r2 == 0) goto L19
            r2 = r1
            com.stepos.backend.qnn.QnnSmsParseModel$processText$1 r2 = (com.stepos.backend.qnn.QnnSmsParseModel.C02711) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r22
            goto L20
        L19:
            com.stepos.backend.qnn.QnnSmsParseModel$processText$1 r2 = new com.stepos.backend.qnn.QnnSmsParseModel$processText$1
            r3 = r22
            r2.<init>(r1)
        L20:
            java.lang.Object r1 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r5 = r2.label
            r6 = 1
            if (r5 == 0) goto L38
            if (r5 != r6) goto L30
            kotlin.c.b(r1)
            goto Lbb
        L30:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L38:
            kotlin.c.b(r1)
            java.lang.String r1 = r3.getTAG()
            r11 = r23
            java.lang.String r5 = r11.f13416b
            int r5 = r5.length()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "processText: input_len="
            r7.<init>(r8)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            android.util.Log.d(r1, r5)
            boolean r1 = r0 instanceof com.stepos.core.model.task.AITaskRecord
            r5 = 0
            if (r1 == 0) goto L60
            com.stepos.core.model.task.AITaskRecord r0 = (com.stepos.core.model.task.AITaskRecord) r0
            goto L61
        L60:
            r0 = r5
        L61:
            j7.e r7 = new j7.e
            b7.k r1 = r3.getConfig()
            java.lang.String r10 = r1.f3090a
            r1 = 0
            if (r0 == 0) goto L72
            int r3 = r0.getCallerUid()
            r12 = r3
            goto L73
        L72:
            r12 = r1
        L73:
            if (r0 == 0) goto L79
            int r1 = r0.getCallerPid()
        L79:
            r13 = r1
            if (r0 == 0) goto L85
            java.lang.String r1 = r0.getCallerPackage()
            if (r1 != 0) goto L83
            goto L85
        L83:
            r14 = r1
            goto L88
        L85:
            java.lang.String r1 = ""
            goto L83
        L88:
            if (r0 == 0) goto L91
            boolean r1 = r0.isForeground()
            r16 = r1
            goto L93
        L91:
            r16 = r6
        L93:
            if (r0 == 0) goto L99
            java.lang.Object r5 = r0.getPowerTracker()
        L99:
            r17 = r5
            r20 = 0
            r21 = 6529(0x1981, float:9.149E-42)
            r8 = 0
            java.lang.String r9 = "chat-smsparse"
            r15 = 0
            r18 = 0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r20, r21)
            com.stepos.core.model.task.AITaskSupervisor$Companion r0 = com.stepos.core.model.task.AITaskSupervisor.Companion
            android.content.Context r1 = l7.a.f10344a
            if (r1 == 0) goto Lc3
            com.stepos.core.model.task.AITaskSupervisor r0 = r0.getInstance(r1)
            r2.label = r6
            java.lang.Object r1 = r0.submitTask(r7, r2)
            if (r1 != r4) goto Lbb
            return r4
        Lbb:
            kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
            com.stepos.backend.qnn.QnnSmsParseModel$processText$$inlined$map$1 r0 = new com.stepos.backend.qnn.QnnSmsParseModel$processText$$inlined$map$1
            r0.<init>()
            return r0
        Lc3:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "ContextHolder must be initialized before use!"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnSmsParseModel.processText(v6.c$g, java.lang.Object, qb.b):java.lang.Object");
    }

    @Override // e7.h
    public boolean resetContext() {
        return false;
    }
}
