package com.stepos.backend.qnn;

import android.os.SystemClock;
import android.util.Log;
import com.stepos.backend.qnn.lora.LoraAwareExecutor;
import com.stepos.backend.qnn.lora.SwitchResult;
import com.stepos.base.error.ContextOverflowException;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.ability.util.EmbedSessionImageMock;
import com.stepos.core.common.log.AiEngineAtrace;
import com.stepos.core.data.base.Content;
import com.stepos.core.model.callback.StreamCallback;
import com.stepos.core.model.manager.ModelCacheImpl;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
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
public final class QnnLLMModel extends QnnModelBase implements e7.h {
    private GenieConfigResolution atRestConfig;
    private volatile long nativeHandle;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnLLMModel", f = "QnnLLMModel.kt", l = {127}, m = "doClose")
    /* renamed from: com.stepos.backend.qnn.QnnLLMModel$doClose$1, reason: invalid class name */
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
            return QnnLLMModel.this.doClose(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnLLMModel", f = "QnnLLMModel.kt", l = {EmbedSessionImageMock.DIM}, m = "doFlowInfer")
    /* renamed from: com.stepos.backend.qnn.QnnLLMModel$doFlowInfer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02481 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02481(qb.b<? super C02481> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnLLMModel.this.doFlowInfer(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnLLMModel$doInferInternal$1", f = "QnnLLMModel.kt", l = {261, 268, 297, 327}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnLLMModel$doInferInternal$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02491 extends SuspendLambda implements zb.p<ProducerScope<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ Object $input;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ QnnLLMModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02491(Object obj, QnnLLMModel qnnLLMModel, qb.b<? super C02491> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = qnnLLMModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final lb.n invokeSuspend$lambda$1(Ref$IntRef ref$IntRef, Ref$LongRef ref$LongRef, QnnLLMModel qnnLLMModel, long j10, String str, ProducerScope producerScope, String str2) {
            int i10 = ref$IntRef.f10074a + 1;
            ref$IntRef.f10074a = i10;
            if (i10 == 1) {
                ref$LongRef.f10075a = SystemClock.elapsedRealtime();
                Log.w(qnnLLMModel.getTAG(), "[PERF] QNN 首 token: " + (ref$LongRef.f10075a - j10) + "ms (从 doInfer 入口起), prompt_len=" + str.length());
            }
            int i11 = ref$IntRef.f10074a;
            if (i11 <= 3 || i11 % 50 == 0) {
                Log.d(qnnLLMModel.getTAG(), "[DIAG] onToken #" + ref$IntRef.f10074a + ": len=" + str2.length());
            }
            if (ChannelResult.m159isFailureimpl(producerScope.mo149trySendJP2dKIU(new Result(new d.q(str2, null, 0 == true ? 1 : 0, 6))))) {
                if (producerScope.isClosedForSend()) {
                    throw new CancellationException("LLM flow closed");
                }
                Log.w(qnnLLMModel.getTAG(), "Drop LLM token (buffer full)");
            }
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$10(boolean z, ProducerScope producerScope, QnnLLMModel qnnLLMModel, Ref$IntRef ref$IntRef) {
            Object objA;
            if (z) {
                try {
                    QnnNative.nativeClearLLMPhaseCallback(qnnLLMModel.nativeHandle, 1);
                    objA = lb.n.f10413a;
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    Log.w(qnnLLMModel.getTAG(), "[Phase] clear failed modelId=".concat(qnnLLMModel.getConfig().f3090a), thB);
                }
            }
            String tag = qnnLLMModel.getTAG();
            int i10 = ref$IntRef.f10074a;
            QnnNative qnnNative = QnnNative.INSTANCE;
            Log.w(tag, "[DIAG] awaitClose: releasing permit, tokenCount=" + i10 + ", semaphore_avail=" + qnnNative.semaphoreAvailable());
            qnnNative.releaseInferPermit(qnnLLMModel.getConfig().f3090a);
            Log.w(qnnLLMModel.getTAG(), "[DIAG] awaitClose DONE: semaphore_avail=" + qnnNative.semaphoreAvailable());
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$2(Ref$LongRef ref$LongRef, QnnLLMModel qnnLLMModel, long j10, Ref$IntRef ref$IntRef, ProducerScope producerScope, String str) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j11 = ref$LongRef.f10075a;
            long j12 = j11 > 0 ? jElapsedRealtime - j11 : 0L;
            String tag = qnnLLMModel.getTAG();
            long j13 = jElapsedRealtime - j10;
            int i10 = ref$IntRef.f10074a;
            StringBuilder sbQ = ai.onnxruntime.a.q(j13, "[PERF] QNN onComplete: total=", "ms, decode=");
            sbQ.append(j12);
            sbQ.append("ms, tokenCount=");
            sbQ.append(i10);
            Log.w(tag, sbQ.toString());
            Log.w(qnnLLMModel.getTAG(), "[DIAG] nativeChatStream callback.onComplete: tokenCount=" + ref$IntRef.f10074a);
            if (ref$IntRef.f10074a == 0) {
                int length = str.length();
                producerScope.close(new ContextOverflowException(com.stepos.core.ota.d.e((int) (length * 0.6d), "上下文超出模型窗口限制：输入约 ", length, " token（", " 字符），请压缩上下文后重试")));
            } else {
                SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
            }
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$3(QnnLLMModel qnnLLMModel, ProducerScope producerScope, int i10, String str) {
            Log.e(qnnLLMModel.getTAG(), "[DIAG] nativeChatStream callback.onError: code=" + i10 + ", msg=" + str);
            producerScope.close(new RuntimeException(a0.a.g("LLM error ", i10, ": ", str)));
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$7(String str, QnnLLMModel qnnLLMModel, String str2, StreamCallback streamCallback, int i10, float f8, int i11, float f9, float f10) {
            return ((Boolean) AiEngineAtrace.section("qnn/call", "llm_stream", new u(str, qnnLLMModel, str2, streamCallback, i10, f8, i11, f9, f10, 1))).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$7$lambda$6(String str, QnnLLMModel qnnLLMModel, String str2, StreamCallback streamCallback, int i10, float f8, int i11, float f9, float f10) {
            return str != null ? QnnNative.nativeChatStreamWithSystem(qnnLLMModel.nativeHandle, str, str2, streamCallback, i10, f8, i11, f9, f10) : QnnNative.nativeChatStream(qnnLLMModel.nativeHandle, str2, streamCallback, i10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C02491 c02491 = new C02491(this.$input, this.this$0, bVar);
            c02491.L$0 = obj;
            return c02491;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Result<? extends d.q>> producerScope, qb.b<? super lb.n> bVar) {
            return invoke2((ProducerScope<? super Result<d.q>>) producerScope, bVar);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(14:16|17|108|(1:132)(10:113|162|114|115|160|116|123|(1:126)|127|(1:129)(10:131|158|133|(2:135|151)|136|(0)(0)|140|(0)|(0)(0)|149))|130|158|133|(0)|136|(0)(0)|140|(0)|(0)(0)|149) */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x041e, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x045b, code lost:
        
            if (kotlinx.coroutines.channels.ProduceKt.awaitClose(r12, r2, r37) == r14) goto L151;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:103:0x02c8  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x0369  */
        /* JADX WARN: Removed duplicated region for block: B:129:0x038a  */
        /* JADX WARN: Removed duplicated region for block: B:131:0x03a1  */
        /* JADX WARN: Removed duplicated region for block: B:135:0x03ce  */
        /* JADX WARN: Removed duplicated region for block: B:138:0x03e5  */
        /* JADX WARN: Removed duplicated region for block: B:139:0x03e7  */
        /* JADX WARN: Removed duplicated region for block: B:142:0x0413 A[Catch: Exception -> 0x041e, TRY_LEAVE, TryCatch #1 {Exception -> 0x041e, blocks: (B:136:0x03d0, B:140:0x03e8, B:142:0x0413, B:133:0x03a5), top: B:158:0x03a5 }] */
        /* JADX WARN: Removed duplicated region for block: B:147:0x043f  */
        /* JADX WARN: Removed duplicated region for block: B:148:0x0441  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x014e  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x019a  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x01aa  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01b5  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01c2  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01c8  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x01ce  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x01d4  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x01da  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x01e0  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x01e8  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x01f0  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r38) {
            /*
                Method dump skipped, instructions count: 1147
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnLLMModel.C02491.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProducerScope<? super Result<d.q>> producerScope, qb.b<? super lb.n> bVar) {
            return ((C02491) create(producerScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnLLMModel", f = "QnnLLMModel.kt", l = {78, 89}, m = "doInitialize")
    /* renamed from: com.stepos.backend.qnn.QnnLLMModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02501 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02501(qb.b<? super C02501> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnLLMModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnLLMModel$doInitialize$2", f = "QnnLLMModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnLLMModel$doInitialize$2, reason: invalid class name */
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
        public static final lb.n invokeSuspend$lambda$0(QnnLLMModel qnnLLMModel, String str, String str2) {
            qnnLLMModel.nativeHandle = QnnNative.nativeInit(str, str2);
            if (qnnLLMModel.nativeHandle != 0) {
                return lb.n.f10413a;
            }
            throw new IllegalStateException(ai.onnxruntime.a.k("LLM model init failed: ", str));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(qb.b<?> bVar) {
            return QnnLLMModel.this.new AnonymousClass2(this.$modelPath, this.$nativeLibDir, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            AiEngineAtrace.section("qnn/init", ModelCacheImpl.MODEL_TYPE_LLM, new v(QnnLLMModel.this, this.$modelPath, this.$nativeLibDir, 0));
            return lb.n.f10413a;
        }

        @Override // zb.l
        public final Object invoke(qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnLLMModel", f = "QnnLLMModel.kt", l = {Content.Types.TYPE_DOUBLE_ARRAY, Content.Types.TYPE_DOUBLE_ARRAY}, m = "doWarmup")
    /* renamed from: com.stepos.backend.qnn.QnnLLMModel$doWarmup$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02511 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C02511(qb.b<? super C02511> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnLLMModel.this.doWarmup(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnLLMModel", f = "QnnLLMModel.kt", l = {369}, m = "processText")
    /* renamed from: com.stepos.backend.qnn.QnnLLMModel$processText$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02531 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02531(qb.b<? super C02531> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnLLMModel.this.processText(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QnnLLMModel(b7.k config) {
        super(config);
        kotlin.jvm.internal.g.f(config, "config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n doClose$lambda$1(QnnLLMModel qnnLLMModel) {
        QnnNative.nativeRelease(qnnLLMModel.nativeHandle);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean doInitialize$lambda$0(QnnLLMModel qnnLLMModel) {
        return QnnNative.nativeResetChat(qnnLLMModel.nativeHandle);
    }

    @Override // com.stepos.base.model.ModelBase, b7.a
    public boolean cancel() {
        Object objA;
        Log.d(getTAG(), "cancel: signaling native LLM preemption");
        try {
            objA = Boolean.valueOf(QnnNative.nativeLLMCancel(this.nativeHandle));
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
            java.lang.String r0 = "Failed to release LLM model: "
            boolean r1 = r7 instanceof com.stepos.backend.qnn.QnnLLMModel.AnonymousClass1
            if (r1 == 0) goto L15
            r1 = r7
            com.stepos.backend.qnn.QnnLLMModel$doClose$1 r1 = (com.stepos.backend.qnn.QnnLLMModel.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.backend.qnn.QnnLLMModel$doClose$1 r1 = new com.stepos.backend.qnn.QnnLLMModel$doClose$1
            r1.<init>(r7)
        L1a:
            java.lang.Object r7 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L35
            if (r3 != r4) goto L2d
            java.lang.Object r6 = r1.L$0
            com.stepos.backend.qnn.QnnLLMModel r6 = (com.stepos.backend.qnn.QnnLLMModel) r6
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
            goto Lcf
        L79:
            r1 = move-exception
            goto Lb2
        L7b:
            java.lang.String r1 = r6.getTAG()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r2 = "doClose: releasing LLM model"
            android.util.Log.d(r1, r2)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r1 = "qnn/release"
            java.lang.String r2 = "llm"
            com.stepos.backend.qnn.e r3 = new com.stepos.backend.qnn.e     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r4 = 2
            r3.<init>(r6, r4)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            com.stepos.core.common.log.AiEngineAtrace.section(r1, r2, r3)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            com.stepos.backend.qnn.GenieConfigResolution r1 = r6.atRestConfig     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            if (r1 == 0) goto L98
            r1.release()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
        L98:
            r1 = 0
            r6.atRestConfig = r1     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r1 = r6.getTAG()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r2 = "✅ LLM model released"
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnLLMModel.doClose(qb.b):java.lang.Object");
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
            boolean r0 = r6 instanceof com.stepos.backend.qnn.QnnLLMModel.C02481
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.backend.qnn.QnnLLMModel$doFlowInfer$1 r0 = (com.stepos.backend.qnn.QnnLLMModel.C02481) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.QnnLLMModel$doFlowInfer$1 r0 = new com.stepos.backend.qnn.QnnLLMModel$doFlowInfer$1
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
            java.lang.String r2 = "doFlowInfer: executing native inference"
            android.util.Log.d(r6, r2)
            r0.label = r3
            java.lang.Object r6 = r4.infer(r5, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
            com.stepos.backend.qnn.QnnLLMModel$doFlowInfer$$inlined$map$1 r4 = new com.stepos.backend.qnn.QnnLLMModel$doFlowInfer$$inlined$map$1
            r4.<init>()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnLLMModel.doFlowInfer(java.lang.Object, qb.b):java.lang.Object");
    }

    @Override // com.stepos.backend.qnn.QnnModelBase
    public Flow<Result<v6.d>> doInferInternal(Object input) {
        kotlin.jvm.internal.g.f(input, "input");
        return FlowKt.flowOn(FlowKt__ContextKt.buffer$default(FlowKt.callbackFlow(new C02491(input, this, null)), 1024, null, 2, null), Dispatchers.getIO());
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
            boolean r0 = r10 instanceof com.stepos.backend.qnn.QnnLLMModel.C02501
            if (r0 == 0) goto L14
            r0 = r10
            com.stepos.backend.qnn.QnnLLMModel$doInitialize$1 r0 = (com.stepos.backend.qnn.QnnLLMModel.C02501) r0
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
            com.stepos.backend.qnn.QnnLLMModel$doInitialize$1 r0 = new com.stepos.backend.qnn.QnnLLMModel$doInitialize$1
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
            com.stepos.backend.qnn.QnnLLMModel r8 = (com.stepos.backend.qnn.QnnLLMModel) r8
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
            com.stepos.backend.qnn.QnnLLMModel r9 = (com.stepos.backend.qnn.QnnLLMModel) r9
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
            java.lang.String r5 = "Initializing LLM model: "
            r3.<init>(r5)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            android.util.Log.i(r10, r3)
            r7.checkModelFile(r9)
            r10 = r1
            com.stepos.backend.qnn.QnnNative r1 = com.stepos.backend.qnn.QnnNative.INSTANCE
            r1.init(r8)
            com.stepos.backend.qnn.QnnLLMModel$doInitialize$2 r3 = new com.stepos.backend.qnn.QnnLLMModel$doInitialize$2
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
            com.stepos.core.model.bridge.NativeChatBridge r9 = com.stepos.core.model.bridge.NativeChatBridge.INSTANCE
            com.stepos.backend.qnn.w r10 = new com.stepos.backend.qnn.w
            r0 = 3
            r10.<init>(r8, r0)
            r9.register(r10)
            java.lang.String r8 = r8.getTAG()
            java.lang.String r9 = "✅ LLM model initialized: "
            a0.a.y(r9, r7, r8)
            lb.n r7 = lb.n.f10413a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnLLMModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
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
            java.lang.String r0 = "LLM warmup completed, result length: "
            boolean r1 = r8 instanceof com.stepos.backend.qnn.QnnLLMModel.C02511
            if (r1 == 0) goto L15
            r1 = r8
            com.stepos.backend.qnn.QnnLLMModel$doWarmup$1 r1 = (com.stepos.backend.qnn.QnnLLMModel.C02511) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.backend.qnn.QnnLLMModel$doWarmup$1 r1 = new com.stepos.backend.qnn.QnnLLMModel$doWarmup$1
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
            com.stepos.backend.qnn.QnnLLMModel r1 = (com.stepos.backend.qnn.QnnLLMModel) r1
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
            com.stepos.backend.qnn.QnnLLMModel r3 = (com.stepos.backend.qnn.QnnLLMModel) r3
            kotlin.c.b(r8)     // Catch: java.lang.Exception -> L4e
            goto L74
        L4e:
            r7 = move-exception
            goto La5
        L50:
            kotlin.c.b(r8)
            java.lang.String r8 = r7.getTAG()
            java.lang.String r3 = "LLM warmup: executing test inference"
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
            com.stepos.backend.qnn.QnnLLMModel$doWarmup$2 r5 = new com.stepos.backend.qnn.QnnLLMModel$doWarmup$2     // Catch: java.lang.Exception -> L4e
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
            java.lang.String r0 = "LLM warmup failed (non-critical): "
            a0.a.A(r0, r7, r8)
        Lb2:
            lb.n r7 = lb.n.f10413a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnLLMModel.doWarmup(qb.b):java.lang.Object");
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
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnLLMModel.processText(v6.c$g, java.lang.Object, qb.b):java.lang.Object");
    }

    @Override // e7.h
    public boolean resetContext() {
        try {
            return QnnNative.nativeResetChat(this.nativeHandle);
        } catch (Exception e10) {
            Log.e(this.getTAG(), "resetContext failed: " + e10.getMessage(), e10);
            return false;
        }
    }

    public final Object resetLora(String str, qb.b<? super SwitchResult> bVar) {
        a0.a.v("resetLora: ", str, getTAG());
        return LoraAwareExecutor.INSTANCE.resetLora(str, this.nativeHandle, bVar);
    }

    public final Object switchLora(String str, String str2, qb.b<? super SwitchResult> bVar) {
        Log.d(getTAG(), "switchLora: " + str + " -> " + str2);
        return LoraAwareExecutor.INSTANCE.switchLora(str, str2, this.nativeHandle, bVar);
    }
}
