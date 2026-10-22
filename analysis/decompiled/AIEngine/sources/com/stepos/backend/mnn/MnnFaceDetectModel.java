package com.stepos.backend.mnn;

import android.graphics.Bitmap;
import b7.k;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.common.log.AiEngineAtrace;
import com.stepos.core.ota.crypto.FekEnvelope;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import mb.y;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MnnFaceDetectModel extends MnnModelBase implements e7.i {
    public static final Companion Companion = new Companion(null);
    public static final String FACE_DETECT_ABILITY_ID = "face_detect";
    private static final String TAG = "MnnFaceDetectModel";
    private long nativeHandle;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnFaceDetectModel$doInferInternal$1", f = "MnnFaceDetectModel.kt", l = {77, 86, 92, 102, FekEnvelope.EXPECTED_EPK_CHARS}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.mnn.MnnFaceDetectModel$doInferInternal$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<FlowCollector<? super Result<? extends v6.d>>, qb.b<? super n>, Object> {
        final /* synthetic */ Object $input;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MnnFaceDetectModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Object obj, MnnFaceDetectModel mnnFaceDetectModel, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = mnnFaceDetectModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FaceDetectNativeResult invokeSuspend$lambda$1(MnnFaceDetectModel mnnFaceDetectModel, Bitmap bitmap) {
            return (FaceDetectNativeResult) AiEngineAtrace.section("mnn/call", MnnFaceDetectModel.FACE_DETECT_ABILITY_ID, new g(mnnFaceDetectModel, bitmap, 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FaceDetectNativeResult invokeSuspend$lambda$1$lambda$0(MnnFaceDetectModel mnnFaceDetectModel, Bitmap bitmap) {
            return FaceDetectJni.INSTANCE.nativeDetect(mnnFaceDetectModel.nativeHandle, bitmap);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$input, this.this$0, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
        
            if (r2.emit(r4, r25) == r0) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00b0, code lost:
        
            if (r2.emit(r4, r25) == r0) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x010a, code lost:
        
            if (r7.emit(r4, r25) == r0) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x01ca, code lost:
        
            if (r7.emit(r5, r25) == r0) goto L92;
         */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00f5  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0111  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 484
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnFaceDetectModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends v6.d>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnFaceDetectModel", f = "MnnFaceDetectModel.kt", l = {ErrorCodes.API_VERSION_CODE_TOO_HIGH}, m = "doInitialize")
    /* renamed from: com.stepos.backend.mnn.MnnFaceDetectModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02101(qb.b<? super C02101> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MnnFaceDetectModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnFaceDetectModel", f = "MnnFaceDetectModel.kt", l = {71, 71}, m = "processImage")
    /* renamed from: com.stepos.backend.mnn.MnnFaceDetectModel$processImage$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02111 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02111(qb.b<? super C02111> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MnnFaceDetectModel.this.processImage(null, null, this);
        }
    }

    static {
        Object obj = e7.f.f8615a;
        e7.f.b(kotlin.jvm.internal.i.a(MnnFaceDetectModel.class), y.M(ProtocolType.f6379b));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MnnFaceDetectModel(k config) {
        super(config);
        kotlin.jvm.internal.g.f(config, "config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap compatBitmap(Bitmap bitmap) {
        if (!"RGBA_1010102".equals(String.valueOf(bitmap.getConfig()))) {
            return bitmap;
        }
        Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        if (bitmapCopy != null) {
            return bitmapCopy;
        }
        throw new IllegalStateException("compatBitmap: ARGB_8888 copy failed");
    }

    @Override // com.stepos.backend.mnn.MnnModelBase, com.stepos.base.model.ModelBase
    public Object doClose(qb.b<? super n> bVar) {
        long j10 = this.nativeHandle;
        if (j10 != 0) {
            FaceDetectJni.INSTANCE.nativeRelease(j10);
            this.nativeHandle = 0L;
        }
        Object objDoClose = super.doClose(bVar);
        return objDoClose == CoroutineSingletons.f10059a ? objDoClose : n.f10413a;
    }

    @Override // com.stepos.backend.mnn.MnnModelBase
    public Flow<Result<v6.d>> doInferInternal(Object input) {
        kotlin.jvm.internal.g.f(input, "input");
        return FlowKt.flow(new AnonymousClass1(input, this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.backend.mnn.MnnModelBase, com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInitialize(android.content.Context r5, b7.k r6, qb.b<? super lb.n> r7) {
        /*
            r4 = this;
            boolean r5 = r7 instanceof com.stepos.backend.mnn.MnnFaceDetectModel.C02101
            if (r5 == 0) goto L13
            r5 = r7
            com.stepos.backend.mnn.MnnFaceDetectModel$doInitialize$1 r5 = (com.stepos.backend.mnn.MnnFaceDetectModel.C02101) r5
            int r0 = r5.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r5.label = r0
            goto L18
        L13:
            com.stepos.backend.mnn.MnnFaceDetectModel$doInitialize$1 r5 = new com.stepos.backend.mnn.MnnFaceDetectModel$doInitialize$1
            r5.<init>(r7)
        L18:
            java.lang.Object r7 = r5.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r4 = r5.L$2
            com.stepos.backend.mnn.MnnFaceDetectModel r4 = (com.stepos.backend.mnn.MnnFaceDetectModel) r4
            java.lang.Object r6 = r5.L$1
            java.io.File r6 = (java.io.File) r6
            java.lang.Object r5 = r5.L$0
            com.stepos.backend.mnn.MnnFaceDetectModel r5 = (com.stepos.backend.mnn.MnnFaceDetectModel) r5
            kotlin.c.b(r7)
            goto L76
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.c.b(r7)
            com.stepos.backend.mnn.FaceDetectJni r7 = com.stepos.backend.mnn.FaceDetectJni.INSTANCE
            boolean r7 = r7.ensureLoaded()
            if (r7 != 0) goto L52
            java.lang.String r4 = r4.getTAG()
            java.lang.String r5 = "face_detect_mnn load failed"
            android.util.Log.w(r4, r5)
            lb.n r4 = lb.n.f10413a
            return r4
        L52:
            java.io.File r7 = b7.m.e(r6)     // Catch: java.lang.Throwable -> L57
            goto L5c
        L57:
            r7 = move-exception
            kotlin.Result$Failure r7 = kotlin.c.a(r7)
        L5c:
            java.lang.Throwable r1 = kotlin.Result.b(r7)
            if (r1 != 0) goto Lb8
            java.io.File r7 = (java.io.File) r7
            r5.L$0 = r4
            r5.L$1 = r7
            r5.L$2 = r4
            r5.label = r2
            java.lang.Object r5 = com.stepos.base.model.atrest.a.a(r6, r7, r5)
            if (r5 != r0) goto L73
            return r0
        L73:
            r6 = r7
            r7 = r5
            r5 = r4
        L76:
            java.lang.AutoCloseable r7 = (java.lang.AutoCloseable) r7
            r0 = r7
            c7.d r0 = (c7.d) r0     // Catch: java.lang.Throwable -> Lb1
            com.stepos.backend.mnn.FaceDetectJni r1 = com.stepos.backend.mnn.FaceDetectJni.INSTANCE     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r0 = r0.f3303a     // Catch: java.lang.Throwable -> Lb1
            long r0 = r1.nativeInit(r0)     // Catch: java.lang.Throwable -> Lb1
            r2 = 0
            xb.a.a(r7, r2)
            r4.nativeHandle = r0
            long r0 = r5.nativeHandle
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto La1
            java.lang.String r4 = r5.getTAG()
            java.lang.String r5 = r6.getAbsolutePath()
            java.lang.String r6 = "MNN face detect initialized: "
            a0.a.y(r6, r5, r4)
            lb.n r4 = lb.n.f10413a
            return r4
        La1:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = r6.getAbsolutePath()
            java.lang.String r6 = "FaceDetect nativeInit failed for "
            java.lang.String r5 = ai.onnxruntime.a.k(r6, r5)
            r4.<init>(r5)
            throw r4
        Lb1:
            r4 = move-exception
            throw r4     // Catch: java.lang.Throwable -> Lb3
        Lb3:
            r5 = move-exception
            xb.a.a(r7, r4)
            throw r5
        Lb8:
            java.lang.String r4 = r4.getTAG()
            java.lang.String r5 = r1.getMessage()
            java.lang.String r6 = "detect_face 权重未在 models 目录定位到: "
            a0.a.A(r6, r5, r4)
            lb.n r4 = lb.n.f10413a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnFaceDetectModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
    }

    @Override // e7.b
    public ProtocolType getType() {
        return ProtocolType.f6379b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b1, code lost:
    
        if (r1 == r4) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // e7.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object processImage(v6.c.C0155c r24, java.lang.Object r25, qb.b<? super v6.d> r26) {
        /*
            r23 = this;
            r0 = r25
            r1 = r26
            boolean r2 = r1 instanceof com.stepos.backend.mnn.MnnFaceDetectModel.C02111
            if (r2 == 0) goto L19
            r2 = r1
            com.stepos.backend.mnn.MnnFaceDetectModel$processImage$1 r2 = (com.stepos.backend.mnn.MnnFaceDetectModel.C02111) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r23
            goto L20
        L19:
            com.stepos.backend.mnn.MnnFaceDetectModel$processImage$1 r2 = new com.stepos.backend.mnn.MnnFaceDetectModel$processImage$1
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
            java.lang.String r10 = "face_detect"
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnFaceDetectModel.processImage(v6.c$c, java.lang.Object, qb.b):java.lang.Object");
    }
}
