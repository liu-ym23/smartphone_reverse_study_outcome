package com.stepos.backend.qnn;

import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.common.log.AiEngineAtrace;
import java.io.File;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class QnnRerankingModel extends QnnModelBase implements e7.d {
    private static final String ABILITY_ID = "reranking";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "QnnRerankingModel";
    private boolean inited;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnRerankingModel", f = "QnnRerankingModel.kt", l = {71}, m = "doClose")
    /* renamed from: com.stepos.backend.qnn.QnnRerankingModel$doClose$1, reason: invalid class name */
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
            return QnnRerankingModel.this.doClose(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnRerankingModel$doInferInternal$1", f = "QnnRerankingModel.kt", l = {121, 125, 131, 141, 143, 149, 159}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnRerankingModel$doInferInternal$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02641 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends v6.d>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ Object $input;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ QnnRerankingModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02641(Object obj, QnnRerankingModel qnnRerankingModel, qb.b<? super C02641> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = qnnRerankingModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float[] invokeSuspend$lambda$2(String str, List list) {
            return (float[]) AiEngineAtrace.section("qnn/call", "rerank", new a0(2, str, list));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float[] invokeSuspend$lambda$2$lambda$1(String str, List list) {
            return RerankingQnnJni.INSTANCE.nativeRerank(str, (String[]) list.toArray(new String[0]));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C02641 c02641 = new C02641(this.$input, this.this$0, bVar);
            c02641.L$0 = obj;
            return c02641;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
        
            if (r12.emit(r2, r11) == r0) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00dd, code lost:
        
            if (r12.emit(r2, r11) == r0) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0148, code lost:
        
            if (r3.emit(r12, r11) == r0) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x01ce, code lost:
        
            if (r12.emit(r2, r11) == r0) goto L78;
         */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0122  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0164 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:6:0x0010, B:9:0x0018, B:71:0x019f, B:12:0x0025, B:54:0x0125, B:56:0x0129, B:59:0x0131, B:64:0x015c, B:66:0x0164, B:68:0x016c, B:50:0x010a), top: B:81:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x016b  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x019e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 488
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnRerankingModel.C02641.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends v6.d>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C02641) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnRerankingModel", f = "QnnRerankingModel.kt", l = {58}, m = "doInitialize")
    /* renamed from: com.stepos.backend.qnn.QnnRerankingModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C02651(qb.b<? super C02651> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnRerankingModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnRerankingModel$doInitialize$2", f = "QnnRerankingModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnRerankingModel$doInitialize$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.l<qb.b<? super lb.n>, Object> {
        final /* synthetic */ String $backendLib;
        final /* synthetic */ String $modelDir;
        final /* synthetic */ String $systemLib;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, String str2, String str3, qb.b<? super AnonymousClass2> bVar) {
            super(1, bVar);
            this.$modelDir = str;
            this.$systemLib = str2;
            this.$backendLib = str3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$0(String str, String str2, String str3) {
            RerankingQnnJni rerankingQnnJni = RerankingQnnJni.INSTANCE;
            kotlin.jvm.internal.g.c(str3);
            return rerankingQnnJni.nativeInit(str, str2, str3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(qb.b<?> bVar) {
            return QnnRerankingModel.this.new AnonymousClass2(this.$modelDir, this.$systemLib, this.$backendLib, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            int iIntValue = ((Number) QnnRerankingModel.this.withAtRestDecrypt(new File(this.$modelDir), new p(this.$systemLib, 1, this.$backendLib, this.$modelDir))).intValue();
            if (iIntValue != 0) {
                throw new IllegalStateException(a0.a.g("Reranking nativeInit failed code=", iIntValue, " dir=", this.$modelDir));
            }
            QnnRerankingModel.this.inited = true;
            return lb.n.f10413a;
        }

        @Override // zb.l
        public final Object invoke(qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnRerankingModel", f = "QnnRerankingModel.kt", l = {99, 99}, m = "processMixed")
    /* renamed from: com.stepos.backend.qnn.QnnRerankingModel$processMixed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02661 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02661(qb.b<? super C02661> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnRerankingModel.this.processMixed(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnRerankingModel", f = "QnnRerankingModel.kt", l = {116}, m = "processMixedStream")
    /* renamed from: com.stepos.backend.qnn.QnnRerankingModel$processMixedStream$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02671 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02671(qb.b<? super C02671> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnRerankingModel.this.processMixedStream(null, null, this);
        }
    }

    static {
        Object obj = e7.f.f8615a;
        e7.f.b(kotlin.jvm.internal.i.a(QnnRerankingModel.class), mb.y.M(ProtocolType.f6382e));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QnnRerankingModel(b7.k config) {
        super(config);
        kotlin.jvm.internal.g.f(config, "config");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doClose(qb.b<? super lb.n> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.stepos.backend.qnn.QnnRerankingModel.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.backend.qnn.QnnRerankingModel$doClose$1 r0 = (com.stepos.backend.qnn.QnnRerankingModel.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.QnnRerankingModel$doClose$1 r0 = new com.stepos.backend.qnn.QnnRerankingModel$doClose$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            com.stepos.backend.qnn.QnnRerankingModel r5 = (com.stepos.backend.qnn.QnnRerankingModel) r5
            kotlin.c.b(r6)
            goto L4b
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.c.b(r6)
            com.stepos.backend.qnn.QnnNative r6 = com.stepos.backend.qnn.QnnNative.INSTANCE
            b7.k r2 = r5.getConfig()
            java.lang.String r2 = r2.f3090a
            r0.L$0 = r5
            r0.label = r3
            r3 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r6 = r6.acquireInferPermitWithTimeout(r2, r3, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L6e
            java.lang.String r0 = r5.getTAG()     // Catch: java.lang.Throwable -> L6c
            java.lang.String r1 = "doClose: timeout waiting for infer permit; skip nativeRelease"
            android.util.Log.e(r0, r1)     // Catch: java.lang.Throwable -> L6c
            lb.n r0 = lb.n.f10413a     // Catch: java.lang.Throwable -> L6c
            if (r6 == 0) goto L6b
            com.stepos.backend.qnn.QnnNative r6 = com.stepos.backend.qnn.QnnNative.INSTANCE
            b7.k r5 = r5.getConfig()
            java.lang.String r5 = r5.f3090a
            r6.releaseInferPermit(r5)
        L6b:
            return r0
        L6c:
            r0 = move-exception
            goto L90
        L6e:
            boolean r0 = r5.inited     // Catch: java.lang.Throwable -> L6c
            if (r0 == 0) goto L80
            com.stepos.backend.qnn.RerankingQnnJni r0 = com.stepos.backend.qnn.RerankingQnnJni.INSTANCE     // Catch: java.lang.Throwable -> L6c
            boolean r1 = r0.ensureLoaded()     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L80
            r0.nativeRelease()     // Catch: java.lang.Throwable -> L6c
            r0 = 0
            r5.inited = r0     // Catch: java.lang.Throwable -> L6c
        L80:
            if (r6 == 0) goto L8d
            com.stepos.backend.qnn.QnnNative r6 = com.stepos.backend.qnn.QnnNative.INSTANCE
            b7.k r5 = r5.getConfig()
            java.lang.String r5 = r5.f3090a
            r6.releaseInferPermit(r5)
        L8d:
            lb.n r5 = lb.n.f10413a
            return r5
        L90:
            if (r6 == 0) goto L9d
            com.stepos.backend.qnn.QnnNative r6 = com.stepos.backend.qnn.QnnNative.INSTANCE
            b7.k r5 = r5.getConfig()
            java.lang.String r5 = r5.f3090a
            r6.releaseInferPermit(r5)
        L9d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnRerankingModel.doClose(qb.b):java.lang.Object");
    }

    @Override // com.stepos.backend.qnn.QnnModelBase
    public Flow<Result<v6.d>> doInferInternal(Object input) {
        kotlin.jvm.internal.g.f(input, "input");
        return FlowKt.flow(new C02641(input, this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInitialize(android.content.Context r12, b7.k r13, qb.b<? super lb.n> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.stepos.backend.qnn.QnnRerankingModel.C02651
            if (r0 == 0) goto L14
            r0 = r14
            com.stepos.backend.qnn.QnnRerankingModel$doInitialize$1 r0 = (com.stepos.backend.qnn.QnnRerankingModel.C02651) r0
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
            com.stepos.backend.qnn.QnnRerankingModel$doInitialize$1 r0 = new com.stepos.backend.qnn.QnnRerankingModel$doInitialize$1
            r0.<init>(r14)
            goto L12
        L1a:
            java.lang.Object r14 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r11 = r4.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r4.L$0
            com.stepos.backend.qnn.QnnRerankingModel r12 = (com.stepos.backend.qnn.QnnRerankingModel) r12
            kotlin.c.b(r14)
            r7 = r11
            r11 = r12
            goto L7f
        L33:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3b:
            kotlin.c.b(r14)
            java.io.File r13 = b7.m.e(r13)
            java.io.File r13 = r13.getParentFile()
            kotlin.jvm.internal.g.c(r13)
            java.lang.String r7 = r13.getAbsolutePath()
            com.stepos.backend.qnn.RerankingQnnJni r13 = com.stepos.backend.qnn.RerankingQnnJni.INSTANCE
            boolean r13 = r13.ensureLoaded()
            if (r13 == 0) goto L8b
            com.stepos.backend.qnn.QnnNative r1 = com.stepos.backend.qnn.QnnNative.INSTANCE
            r1.init(r12)
            java.lang.String r12 = r11.getTAG()
            java.lang.String r13 = "doInitialize: systemLib=libQnnSystem.so backendLib=libQnnHtp.so"
            android.util.Log.i(r12, r13)
            com.stepos.backend.qnn.QnnRerankingModel$doInitialize$2 r3 = new com.stepos.backend.qnn.QnnRerankingModel$doInitialize$2
            r10 = 0
            java.lang.String r8 = "libQnnSystem.so"
            java.lang.String r9 = "libQnnHtp.so"
            r6 = r11
            r5 = r3
            r5.<init>(r7, r8, r9, r10)
            r4.L$0 = r11
            r4.L$1 = r7
            r4.label = r2
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r12 = com.stepos.backend.qnn.QnnNative.withInferLock$default(r1, r2, r3, r4, r5, r6)
            if (r12 != r0) goto L7f
            return r0
        L7f:
            java.lang.String r11 = r11.getTAG()
            java.lang.String r12 = "QNN reranking initialized: "
            a0.a.y(r12, r7, r11)
            lb.n r11 = lb.n.f10413a
            return r11
        L8b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Missing libreranking_qnn.so"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnRerankingModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
    }

    @Override // e7.b
    public ProtocolType getType() {
        return ProtocolType.f6382e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b1, code lost:
    
        if (r1 == r4) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // e7.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object processMixed(v6.c.e r24, java.lang.Object r25, qb.b<? super v6.d> r26) {
        /*
            r23 = this;
            r0 = r25
            r1 = r26
            boolean r2 = r1 instanceof com.stepos.backend.qnn.QnnRerankingModel.C02661
            if (r2 == 0) goto L19
            r2 = r1
            com.stepos.backend.qnn.QnnRerankingModel$processMixed$1 r2 = (com.stepos.backend.qnn.QnnRerankingModel.C02661) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r23
            goto L20
        L19:
            com.stepos.backend.qnn.QnnRerankingModel$processMixed$1 r2 = new com.stepos.backend.qnn.QnnRerankingModel$processMixed$1
            r3 = r23
            r2.<init>(r1)
        L20:
            java.lang.Object r1 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r5 = r2.label
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L40
            if (r5 == r7) goto L3b
            if (r5 != r6) goto L33
            kotlin.c.b(r1)
            goto Lb4
        L33:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3b:
            kotlin.c.b(r1)
            goto La9
        L40:
            kotlin.c.b(r1)
            boolean r1 = r0 instanceof com.stepos.core.model.task.AITaskRecord
            r5 = 0
            if (r1 == 0) goto L4b
            com.stepos.core.model.task.AITaskRecord r0 = (com.stepos.core.model.task.AITaskRecord) r0
            goto L4c
        L4b:
            r0 = r5
        L4c:
            j7.e r8 = new j7.e
            b7.k r1 = r3.getConfig()
            java.lang.String r11 = r1.f3090a
            r1 = 0
            if (r0 == 0) goto L5d
            int r3 = r0.getCallerUid()
            r13 = r3
            goto L5e
        L5d:
            r13 = r1
        L5e:
            if (r0 == 0) goto L64
            int r1 = r0.getCallerPid()
        L64:
            r14 = r1
            if (r0 == 0) goto L70
            java.lang.String r1 = r0.getCallerPackage()
            if (r1 != 0) goto L6e
            goto L70
        L6e:
            r15 = r1
            goto L73
        L70:
            java.lang.String r1 = ""
            goto L6e
        L73:
            if (r0 == 0) goto L7c
            boolean r1 = r0.isForeground()
            r17 = r1
            goto L7e
        L7c:
            r17 = r7
        L7e:
            if (r0 == 0) goto L84
            java.lang.Object r5 = r0.getPowerTracker()
        L84:
            r18 = r5
            r21 = 0
            r22 = 6529(0x1981, float:9.149E-42)
            r9 = 0
            java.lang.String r10 = "reranking"
            r16 = 0
            r19 = 0
            r12 = r24
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r21, r22)
            com.stepos.core.model.task.AITaskSupervisor$Companion r0 = com.stepos.core.model.task.AITaskSupervisor.Companion
            android.content.Context r1 = l7.a.f10344a
            if (r1 == 0) goto Lc3
            com.stepos.core.model.task.AITaskSupervisor r0 = r0.getInstance(r1)
            r2.label = r7
            java.lang.Object r1 = r0.submitTask(r8, r2)
            if (r1 != r4) goto La9
            goto Lb3
        La9:
            kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
            r2.label = r6
            java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.single(r1, r2)
            if (r1 != r4) goto Lb4
        Lb3:
            return r4
        Lb4:
            kotlin.Result r1 = (kotlin.Result) r1
            java.lang.Object r0 = r1.f9987a
            kotlin.c.b(r0)
            java.lang.String r1 = "null cannot be cast to non-null type com.stepos.base.data.Output"
            kotlin.jvm.internal.g.d(r0, r1)
            v6.d r0 = (v6.d) r0
            return r0
        Lc3:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "ContextHolder must be initialized before use!"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnRerankingModel.processMixed(v6.c$e, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // e7.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object processMixedStream(v6.c.e r23, java.lang.Object r24, qb.b<? super kotlinx.coroutines.flow.Flow<? extends v6.d>> r25) {
        /*
            r22 = this;
            r0 = r24
            r1 = r25
            boolean r2 = r1 instanceof com.stepos.backend.qnn.QnnRerankingModel.C02671
            if (r2 == 0) goto L19
            r2 = r1
            com.stepos.backend.qnn.QnnRerankingModel$processMixedStream$1 r2 = (com.stepos.backend.qnn.QnnRerankingModel.C02671) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r22
            goto L20
        L19:
            com.stepos.backend.qnn.QnnRerankingModel$processMixedStream$1 r2 = new com.stepos.backend.qnn.QnnRerankingModel$processMixedStream$1
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
            goto La0
        L30:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L38:
            kotlin.c.b(r1)
            boolean r1 = r0 instanceof com.stepos.core.model.task.AITaskRecord
            r5 = 0
            if (r1 == 0) goto L43
            com.stepos.core.model.task.AITaskRecord r0 = (com.stepos.core.model.task.AITaskRecord) r0
            goto L44
        L43:
            r0 = r5
        L44:
            j7.e r7 = new j7.e
            b7.k r1 = r3.getConfig()
            java.lang.String r10 = r1.f3090a
            r1 = 0
            if (r0 == 0) goto L55
            int r3 = r0.getCallerUid()
            r12 = r3
            goto L56
        L55:
            r12 = r1
        L56:
            if (r0 == 0) goto L5c
            int r1 = r0.getCallerPid()
        L5c:
            r13 = r1
            if (r0 == 0) goto L68
            java.lang.String r1 = r0.getCallerPackage()
            if (r1 != 0) goto L66
            goto L68
        L66:
            r14 = r1
            goto L6b
        L68:
            java.lang.String r1 = ""
            goto L66
        L6b:
            if (r0 == 0) goto L74
            boolean r1 = r0.isForeground()
            r16 = r1
            goto L76
        L74:
            r16 = r6
        L76:
            if (r0 == 0) goto L7c
            java.lang.Object r5 = r0.getPowerTracker()
        L7c:
            r17 = r5
            r20 = 0
            r21 = 6529(0x1981, float:9.149E-42)
            r8 = 0
            java.lang.String r9 = "reranking"
            r15 = 0
            r18 = 0
            r11 = r23
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r20, r21)
            com.stepos.core.model.task.AITaskSupervisor$Companion r0 = com.stepos.core.model.task.AITaskSupervisor.Companion
            android.content.Context r1 = l7.a.f10344a
            if (r1 == 0) goto La8
            com.stepos.core.model.task.AITaskSupervisor r0 = r0.getInstance(r1)
            r2.label = r6
            java.lang.Object r1 = r0.submitTask(r7, r2)
            if (r1 != r4) goto La0
            return r4
        La0:
            kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
            com.stepos.backend.qnn.QnnRerankingModel$processMixedStream$$inlined$map$1 r0 = new com.stepos.backend.qnn.QnnRerankingModel$processMixedStream$$inlined$map$1
            r0.<init>()
            return r0
        La8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "ContextHolder must be initialized before use!"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnRerankingModel.processMixedStream(v6.c$e, java.lang.Object, qb.b):java.lang.Object");
    }
}
