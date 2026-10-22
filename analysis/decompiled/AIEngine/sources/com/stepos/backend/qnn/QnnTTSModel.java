package com.stepos.backend.qnn;

import android.util.Log;
import com.stepos.backend.qnn.QnnTTSModel;
import com.stepos.base.concurrency.cpuset.AiTier;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.common.log.AiEngineAtrace;
import com.stepos.core.data.base.Content;
import com.stepos.core.model.callback.TTSStreamCallback;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class QnnTTSModel extends QnnModelBase implements e7.g {
    private GenieConfigResolution atRestConfig;
    private int bitWidth;
    private int channels;
    private volatile long nativeHandle;
    private volatile String pendingSpeakerId;
    private volatile String pendingSystemPrompt;
    private int sampleRate;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnTTSModel", f = "QnnTTSModel.kt", l = {135}, m = "doClose")
    /* renamed from: com.stepos.backend.qnn.QnnTTSModel$doClose$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02721 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02721(qb.b<? super C02721> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnTTSModel.this.doClose(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnTTSModel", f = "QnnTTSModel.kt", l = {289}, m = "doFlowInfer")
    /* renamed from: com.stepos.backend.qnn.QnnTTSModel$doFlowInfer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02731 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02731(qb.b<? super C02731> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnTTSModel.this.doFlowInfer(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnTTSModel$doInferInternal$1", f = "QnnTTSModel.kt", l = {185, 187, 224}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnTTSModel$doInferInternal$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02741 extends SuspendLambda implements zb.p<ProducerScope<? super Result<? extends v6.d>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ Object $input;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ QnnTTSModel this$0;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @rb.c(c = "com.stepos.backend.qnn.QnnTTSModel$doInferInternal$1$1", f = "QnnTTSModel.kt", l = {208}, m = "invokeSuspend")
        /* renamed from: com.stepos.backend.qnn.QnnTTSModel$doInferInternal$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00421 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
            final /* synthetic */ ProducerScope<Result<? extends v6.d>> $$this$callbackFlow;
            final /* synthetic */ TTSStreamCallback $callback;
            final /* synthetic */ long $h;
            final /* synthetic */ CountDownLatch $nativeCallDone;
            final /* synthetic */ String $prompt;
            final /* synthetic */ String $speakerId;
            final /* synthetic */ String $systemPrompt;
            int label;
            final /* synthetic */ QnnTTSModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C00421(ProducerScope<? super Result<? extends v6.d>> producerScope, QnnTTSModel qnnTTSModel, CountDownLatch countDownLatch, long j10, String str, String str2, String str3, TTSStreamCallback tTSStreamCallback, qb.b<? super C00421> bVar) {
                super(2, bVar);
                this.$$this$callbackFlow = producerScope;
                this.this$0 = qnnTTSModel;
                this.$nativeCallDone = countDownLatch;
                this.$h = j10;
                this.$systemPrompt = str;
                this.$prompt = str2;
                this.$speakerId = str3;
                this.$callback = tTSStreamCallback;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean invokeSuspend$lambda$1(final long j10, final String str, final String str2, final String str3, final TTSStreamCallback tTSStreamCallback) {
                return ((Boolean) AiEngineAtrace.section("qnn/call", "tts_generate", new zb.a() { // from class: com.stepos.backend.qnn.e0
                    @Override // zb.a
                    public final Object invoke() {
                        return Boolean.valueOf(QnnNative.nativeTTSGenerate(j10, str, str2, str3, tTSStreamCallback));
                    }
                })).booleanValue();
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
                return new C00421(this.$$this$callbackFlow, this.this$0, this.$nativeCallDone, this.$h, this.$systemPrompt, this.$prompt, this.$speakerId, this.$callback, bVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                int i10 = this.label;
                try {
                    try {
                        if (i10 == 0) {
                            kotlin.c.b(obj);
                            AiTier aiTier = AiTier.f6204a;
                            final long j10 = this.$h;
                            final String str = this.$systemPrompt;
                            final String str2 = this.$prompt;
                            final String str3 = this.$speakerId;
                            final TTSStreamCallback tTSStreamCallback = this.$callback;
                            zb.a aVar = new zb.a() { // from class: com.stepos.backend.qnn.d0
                                @Override // zb.a
                                public final Object invoke() {
                                    return Boolean.valueOf(QnnTTSModel.C02741.C00421.invokeSuspend$lambda$1(j10, str, str2, str3, tTSStreamCallback));
                                }
                            };
                            this.label = 1;
                            obj = aiTier.b(aVar, this);
                            if (obj == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            kotlin.c.b(obj);
                        }
                        if (!((Boolean) obj).booleanValue()) {
                            this.$$this$callbackFlow.close(new RuntimeException("Failed to start TTS inference"));
                        }
                    } catch (Exception e10) {
                        Log.e(this.this$0.getTAG(), "TTS infer failed: " + e10.getMessage(), e10);
                        this.$$this$callbackFlow.close(e10);
                    }
                    this.$nativeCallDone.countDown();
                    return lb.n.f10413a;
                } catch (Throwable th) {
                    this.$nativeCallDone.countDown();
                    throw th;
                }
            }

            @Override // zb.p
            public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
                return ((C00421) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02741(Object obj, QnnTTSModel qnnTTSModel, qb.b<? super C02741> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = qnnTTSModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$0(ProducerScope producerScope, QnnTTSModel qnnTTSModel, float[] fArr) {
            producerScope.mo149trySendJP2dKIU(new Result(new d.b(fArr, qnnTTSModel.sampleRate, qnnTTSModel.channels, 24)));
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$1(ProducerScope producerScope) {
            SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$2(ProducerScope producerScope, int i10, String str) {
            producerScope.close(new RuntimeException(a0.a.g("TTS error ", i10, ": ", str)));
            return lb.n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$7(boolean z, ProducerScope producerScope, CountDownLatch countDownLatch, QnnTTSModel qnnTTSModel, long j10) {
            Object objA;
            if (z) {
                try {
                    QnnNative.nativeClearTTSPhaseCallback(j10);
                    objA = lb.n.f10413a;
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    Log.w(qnnTTSModel.getTAG(), "[Phase] TTS clear failed", thB);
                }
            }
            if (!countDownLatch.await(15L, TimeUnit.SECONDS)) {
                Log.w(qnnTTSModel.getTAG(), "⚠️ TTS native call did not finish within 15s timeout");
            }
            QnnNative.INSTANCE.releaseInferPermit(qnnTTSModel.getConfig().f3090a);
            Log.d(qnnTTSModel.getTAG(), "TTS stream flow closed");
            return lb.n.f10413a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C02741 c02741 = new C02741(this.$input, this.this$0, bVar);
            c02741.L$0 = obj;
            return c02741;
        }

        /* JADX WARN: Code restructure failed: missing block: B:52:0x01ce, code lost:
        
            if (kotlinx.coroutines.channels.ProduceKt.awaitClose(r19, r17, r24) != r2) goto L54;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:47:0x016d  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0184  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instructions count: 494
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnTTSModel.C02741.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(ProducerScope<? super Result<? extends v6.d>> producerScope, qb.b<? super lb.n> bVar) {
            return ((C02741) create(producerScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnTTSModel", f = "QnnTTSModel.kt", l = {92, Content.Types.TYPE_FLOAT_ARRAY}, m = "doInitialize")
    /* renamed from: com.stepos.backend.qnn.QnnTTSModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02751 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C02751(qb.b<? super C02751> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnTTSModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnTTSModel$doInitialize$2", f = "QnnTTSModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnTTSModel$doInitialize$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.l<qb.b<? super lb.n>, Object> {
        final /* synthetic */ boolean $enableProfile;
        final /* synthetic */ String $modelPath;
        final /* synthetic */ String $nativeLibDir;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, String str2, boolean z, qb.b<? super AnonymousClass2> bVar) {
            super(1, bVar);
            this.$modelPath = str;
            this.$nativeLibDir = str2;
            this.$enableProfile = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final lb.n invokeSuspend$lambda$0(QnnTTSModel qnnTTSModel, String str, String str2, boolean z) {
            qnnTTSModel.nativeHandle = QnnNative.nativeTTSInit(str, str2, z);
            if (qnnTTSModel.nativeHandle != 0) {
                return lb.n.f10413a;
            }
            throw new IllegalStateException(ai.onnxruntime.a.k("TTS model init failed: ", str));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(qb.b<?> bVar) {
            return QnnTTSModel.this.new AnonymousClass2(this.$modelPath, this.$nativeLibDir, this.$enableProfile, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            AiEngineAtrace.section("qnn/init", "tts", new m(QnnTTSModel.this, this.$modelPath, this.$nativeLibDir, this.$enableProfile));
            return lb.n.f10413a;
        }

        @Override // zb.l
        public final Object invoke(qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnTTSModel", f = "QnnTTSModel.kt", l = {279}, m = "processSynthesize")
    /* renamed from: com.stepos.backend.qnn.QnnTTSModel$processSynthesize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02761 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02761(qb.b<? super C02761> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnTTSModel.this.processSynthesize(null, null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QnnTTSModel(b7.k config) {
        super(config);
        kotlin.jvm.internal.g.f(config, "config");
        this.sampleRate = 24000;
        this.channels = 1;
        this.bitWidth = 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TTSStreamCallback createTTSStreamCallback(final zb.l<? super float[], lb.n> lVar, final zb.a<lb.n> aVar, final zb.p<? super Integer, ? super String, lb.n> pVar) {
        return new TTSStreamCallback() { // from class: com.stepos.backend.qnn.QnnTTSModel.createTTSStreamCallback.1
            @Override // com.stepos.core.model.callback.TTSStreamCallback
            public void onAudioChunk(float[] audioData) {
                kotlin.jvm.internal.g.f(audioData, "audioData");
                Log.v(QnnTTSModel.this.getTAG(), "onAudioChunk: size=" + audioData.length);
                lVar.invoke(audioData);
            }

            @Override // com.stepos.core.model.callback.TTSStreamCallback
            public void onComplete() {
                Log.d(QnnTTSModel.this.getTAG(), "TTS stream completed");
                aVar.invoke();
            }

            @Override // com.stepos.core.model.callback.TTSStreamCallback
            public void onError(int i10, String message) {
                kotlin.jvm.internal.g.f(message, "message");
                Log.e(QnnTTSModel.this.getTAG(), "TTS stream error: code=" + i10 + ", msg=" + message);
                pVar.invoke(Integer.valueOf(i10), message);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n doClose$lambda$0(QnnTTSModel qnnTTSModel) {
        QnnNative.nativeTTSRelease(qnnTTSModel.nativeHandle);
        return lb.n.f10413a;
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
            java.lang.String r0 = "Failed to release TTS model: "
            boolean r1 = r7 instanceof com.stepos.backend.qnn.QnnTTSModel.C02721
            if (r1 == 0) goto L15
            r1 = r7
            com.stepos.backend.qnn.QnnTTSModel$doClose$1 r1 = (com.stepos.backend.qnn.QnnTTSModel.C02721) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.backend.qnn.QnnTTSModel$doClose$1 r1 = new com.stepos.backend.qnn.QnnTTSModel$doClose$1
            r1.<init>(r7)
        L1a:
            java.lang.Object r7 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L35
            if (r3 != r4) goto L2d
            java.lang.Object r6 = r1.L$0
            com.stepos.backend.qnn.QnnTTSModel r6 = (com.stepos.backend.qnn.QnnTTSModel) r6
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
            java.lang.String r2 = "doClose: timeout waiting for infer permit; skip nativeTTSRelease to avoid UAF"
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
            java.lang.String r2 = "doClose: releasing TTS model"
            android.util.Log.d(r1, r2)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r1 = "qnn/release"
            java.lang.String r2 = "tts"
            com.stepos.backend.qnn.w r3 = new com.stepos.backend.qnn.w     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r4 = 4
            r3.<init>(r6, r4)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            com.stepos.core.common.log.AiEngineAtrace.section(r1, r2, r3)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            com.stepos.backend.qnn.GenieConfigResolution r1 = r6.atRestConfig     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            if (r1 == 0) goto L98
            r1.release()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
        L98:
            r1 = 0
            r6.atRestConfig = r1     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r1 = r6.getTAG()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r2 = "✅ TTS model released"
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnTTSModel.doClose(qb.b):java.lang.Object");
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
            boolean r0 = r6 instanceof com.stepos.backend.qnn.QnnTTSModel.C02731
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.backend.qnn.QnnTTSModel$doFlowInfer$1 r0 = (com.stepos.backend.qnn.QnnTTSModel.C02731) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.QnnTTSModel$doFlowInfer$1 r0 = new com.stepos.backend.qnn.QnnTTSModel$doFlowInfer$1
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
            com.stepos.backend.qnn.QnnTTSModel$doFlowInfer$$inlined$map$1 r4 = new com.stepos.backend.qnn.QnnTTSModel$doFlowInfer$$inlined$map$1
            r4.<init>()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnTTSModel.doFlowInfer(java.lang.Object, qb.b):java.lang.Object");
    }

    @Override // com.stepos.backend.qnn.QnnModelBase
    public Flow<Result<v6.d>> doInferInternal(Object input) {
        kotlin.jvm.internal.g.f(input, "input");
        return FlowKt.callbackFlow(new C02741(input, this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInitialize(android.content.Context r20, b7.k r21, qb.b<? super lb.n> r22) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnTTSModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
    }

    @Override // com.stepos.backend.qnn.QnnModelBase, com.stepos.base.model.ModelBase
    public Object doWarmup(qb.b<? super lb.n> bVar) {
        Log.d(getTAG(), "TTS warmup skipped");
        return lb.n.f10413a;
    }

    public final int getChannels() {
        return this.channels;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    @Override // e7.b
    public ProtocolType getType() {
        return ProtocolType.h;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013d  */
    @Override // e7.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object processSynthesize(v6.c.g r24, java.lang.String r25, java.lang.Object r26, qb.b<? super kotlinx.coroutines.flow.Flow<? extends v6.d>> r27) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnTTSModel.processSynthesize(v6.c$g, java.lang.String, java.lang.Object, qb.b):java.lang.Object");
    }
}
