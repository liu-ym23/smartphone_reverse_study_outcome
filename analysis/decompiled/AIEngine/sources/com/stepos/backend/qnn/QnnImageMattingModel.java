package com.stepos.backend.qnn;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.stepos.backend.qnn.QnnImageMattingModel;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.common.log.AiEngineAtrace;
import com.stepos.core.data.base.Content;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import java.io.File;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import v6.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class QnnImageMattingModel extends QnnModelBase implements e7.i {
    public static final Companion Companion = new Companion(null);
    private static final String DEFAULT_MODEL_BIN = "matting_quantized.serialized.bin";
    private static final String IMAGE_MATTING_ABILITY_ID = "image_matting";
    private static final String TAG = "QnnImageMattingModel";
    private static final float TH_HIGH = 1.0f;
    private static final float TH_LOW = 0.02f;
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
    @rb.c(c = "com.stepos.backend.qnn.QnnImageMattingModel", f = "QnnImageMattingModel.kt", l = {66}, m = "doClose")
    /* renamed from: com.stepos.backend.qnn.QnnImageMattingModel$doClose$1, reason: invalid class name */
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
            return QnnImageMattingModel.this.doClose(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnImageMattingModel$doInferInternal$1", f = "QnnImageMattingModel.kt", l = {100, Content.Types.TYPE_BOOLEAN, Content.Types.TYPE_DOUBLE_ARRAY, 116, 125, 129, 136, 145}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnImageMattingModel$doInferInternal$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02451 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends v6.d>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ Object $input;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ QnnImageMattingModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02451(Object obj, QnnImageMattingModel qnnImageMattingModel, qb.b<? super C02451> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = qnnImageMattingModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ImageMattingNativeResult invokeSuspend$lambda$1(final Bitmap bitmap, final int i10, final Object obj) {
            return (ImageMattingNativeResult) AiEngineAtrace.section("qnn/call", QnnImageMattingModel.IMAGE_MATTING_ABILITY_ID, new zb.a() { // from class: com.stepos.backend.qnn.o
                @Override // zb.a
                public final Object invoke() {
                    return QnnImageMattingModel.C02451.invokeSuspend$lambda$1$lambda$0(bitmap, i10, obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ImageMattingNativeResult invokeSuspend$lambda$1$lambda$0(Bitmap bitmap, int i10, Object obj) {
            return ImageMattingQnnJni.INSTANCE.nativeCutImg(bitmap, i10, ((c.C0155c) obj).f13402i);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C02451 c02451 = new C02451(this.$input, this.this$0, bVar);
            c02451.L$0 = obj;
            return c02451;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
        
            if (r14.emit(r2, r13) == r1) goto L97;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x01f6, code lost:
        
            if (r4.emit(r14, r13) == r1) goto L97;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0239, code lost:
        
            if (r14.emit(r2, r13) == r1) goto L97;
         */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00e2 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:6:0x0012, B:9:0x001b, B:75:0x0191, B:10:0x0020, B:67:0x015f, B:11:0x0025, B:55:0x0103, B:47:0x00d6, B:49:0x00dc, B:52:0x00e2, B:58:0x0113, B:60:0x011b, B:62:0x0126, B:64:0x0130, B:68:0x0162, B:70:0x016a, B:72:0x0170, B:76:0x0195, B:78:0x01a4, B:80:0x01ba, B:81:0x01ca, B:89:0x020f, B:91:0x0215, B:92:0x0218, B:37:0x00a0), top: B:100:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0113 A[Catch: all -> 0x0017, TRY_ENTER, TryCatch #0 {all -> 0x0017, blocks: (B:6:0x0012, B:9:0x001b, B:75:0x0191, B:10:0x0020, B:67:0x015f, B:11:0x0025, B:55:0x0103, B:47:0x00d6, B:49:0x00dc, B:52:0x00e2, B:58:0x0113, B:60:0x011b, B:62:0x0126, B:64:0x0130, B:68:0x0162, B:70:0x016a, B:72:0x0170, B:76:0x0195, B:78:0x01a4, B:80:0x01ba, B:81:0x01ca, B:89:0x020f, B:91:0x0215, B:92:0x0218, B:37:0x00a0), top: B:100:0x0007 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 598
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnImageMattingModel.C02451.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends v6.d>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C02451) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnImageMattingModel", f = "QnnImageMattingModel.kt", l = {ErrorCodes.CALLER_PROTOCOL_VERSION_TOO_HIGH}, m = "doInitialize")
    /* renamed from: com.stepos.backend.qnn.QnnImageMattingModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C02461(qb.b<? super C02461> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnImageMattingModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnImageMattingModel$doInitialize$2", f = "QnnImageMattingModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnImageMattingModel$doInitialize$2, reason: invalid class name */
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
            ImageMattingQnnJni imageMattingQnnJni = ImageMattingQnnJni.INSTANCE;
            kotlin.jvm.internal.g.c(str3);
            return imageMattingQnnJni.nativeInit(str, str2, str3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(qb.b<?> bVar) {
            return QnnImageMattingModel.this.new AnonymousClass2(this.$modelDir, this.$systemLib, this.$backendLib, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            int iIntValue = ((Number) QnnImageMattingModel.this.withAtRestDecrypt(new File(this.$modelDir), new p(this.$systemLib, 0, this.$backendLib, this.$modelDir))).intValue();
            if (iIntValue != 0) {
                throw new IllegalStateException(a0.a.g("QNN matting nativeInit failed code=", iIntValue, " dir=", this.$modelDir));
            }
            QnnImageMattingModel.this.inited = true;
            return lb.n.f10413a;
        }

        @Override // zb.l
        public final Object invoke(qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnImageMattingModel", f = "QnnImageMattingModel.kt", l = {94, 94}, m = "processImage")
    /* renamed from: com.stepos.backend.qnn.QnnImageMattingModel$processImage$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02471 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02471(qb.b<? super C02471> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnImageMattingModel.this.processImage(null, null, this);
        }
    }

    static {
        Object obj = e7.f.f8615a;
        e7.f.b(kotlin.jvm.internal.i.a(QnnImageMattingModel.class), mb.y.M(ProtocolType.f6379b));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QnnImageMattingModel(b7.k config) {
        super(config);
        kotlin.jvm.internal.g.f(config, "config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap applyRotateAngle(Bitmap bitmap, int i10) {
        int i11 = ((i10 % 360) + 360) % 360;
        if (i11 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i11);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        kotlin.jvm.internal.g.e(bitmapCreateBitmap, "createBitmap(...)");
        if (bitmapCreateBitmap != bitmap && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap compatBitmapForMatting(Bitmap bitmap) {
        if (!"RGBA_1010102".equals(String.valueOf(bitmap.getConfig()))) {
            return bitmap;
        }
        Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        if (bitmapCopy != null) {
            return bitmapCopy;
        }
        throw new IllegalStateException("compatBitmap: ARGB_8888 copy failed");
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
            boolean r0 = r6 instanceof com.stepos.backend.qnn.QnnImageMattingModel.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.backend.qnn.QnnImageMattingModel$doClose$1 r0 = (com.stepos.backend.qnn.QnnImageMattingModel.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.QnnImageMattingModel$doClose$1 r0 = new com.stepos.backend.qnn.QnnImageMattingModel$doClose$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            com.stepos.backend.qnn.QnnImageMattingModel r5 = (com.stepos.backend.qnn.QnnImageMattingModel) r5
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
            goto L8a
        L6e:
            boolean r0 = r5.inited     // Catch: java.lang.Throwable -> L6c
            if (r0 == 0) goto L7a
            com.stepos.backend.qnn.ImageMattingQnnJni r0 = com.stepos.backend.qnn.ImageMattingQnnJni.INSTANCE     // Catch: java.lang.Throwable -> L6c
            r0.nativeRelease()     // Catch: java.lang.Throwable -> L6c
            r0 = 0
            r5.inited = r0     // Catch: java.lang.Throwable -> L6c
        L7a:
            if (r6 == 0) goto L87
            com.stepos.backend.qnn.QnnNative r6 = com.stepos.backend.qnn.QnnNative.INSTANCE
            b7.k r5 = r5.getConfig()
            java.lang.String r5 = r5.f3090a
            r6.releaseInferPermit(r5)
        L87:
            lb.n r5 = lb.n.f10413a
            return r5
        L8a:
            if (r6 == 0) goto L97
            com.stepos.backend.qnn.QnnNative r6 = com.stepos.backend.qnn.QnnNative.INSTANCE
            b7.k r5 = r5.getConfig()
            java.lang.String r5 = r5.f3090a
            r6.releaseInferPermit(r5)
        L97:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnImageMattingModel.doClose(qb.b):java.lang.Object");
    }

    @Override // com.stepos.backend.qnn.QnnModelBase
    public Flow<Result<v6.d>> doInferInternal(Object input) {
        kotlin.jvm.internal.g.f(input, "input");
        return FlowKt.flow(new C02451(input, this, null));
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
            boolean r0 = r14 instanceof com.stepos.backend.qnn.QnnImageMattingModel.C02461
            if (r0 == 0) goto L14
            r0 = r14
            com.stepos.backend.qnn.QnnImageMattingModel$doInitialize$1 r0 = (com.stepos.backend.qnn.QnnImageMattingModel.C02461) r0
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
            com.stepos.backend.qnn.QnnImageMattingModel$doInitialize$1 r0 = new com.stepos.backend.qnn.QnnImageMattingModel$doInitialize$1
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
            com.stepos.backend.qnn.QnnImageMattingModel r12 = (com.stepos.backend.qnn.QnnImageMattingModel) r12
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
            com.stepos.backend.qnn.QnnNative r1 = com.stepos.backend.qnn.QnnNative.INSTANCE
            r1.init(r12)
            com.stepos.backend.qnn.ImageMattingQnnJni r12 = com.stepos.backend.qnn.ImageMattingQnnJni.INSTANCE
            boolean r12 = r12.ensureLoaded()
            if (r12 == 0) goto L8b
            java.lang.String r12 = r11.getTAG()
            java.lang.String r13 = "doInitialize: systemLib=libQnnSystem.so backendLib=libQnnHtp.so"
            android.util.Log.i(r12, r13)
            com.stepos.backend.qnn.QnnImageMattingModel$doInitialize$2 r3 = new com.stepos.backend.qnn.QnnImageMattingModel$doInitialize$2
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
            java.lang.String r12 = "QNN matting initialized: "
            a0.a.y(r12, r7, r11)
            lb.n r11 = lb.n.f10413a
            return r11
        L8b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Missing libimagematting_qnn.so in APK; check native build and jniLibs (OpenCV, MNN)."
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnImageMattingModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
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
            boolean r2 = r1 instanceof com.stepos.backend.qnn.QnnImageMattingModel.C02471
            if (r2 == 0) goto L19
            r2 = r1
            com.stepos.backend.qnn.QnnImageMattingModel$processImage$1 r2 = (com.stepos.backend.qnn.QnnImageMattingModel.C02471) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r23
            goto L20
        L19:
            com.stepos.backend.qnn.QnnImageMattingModel$processImage$1 r2 = new com.stepos.backend.qnn.QnnImageMattingModel$processImage$1
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
            java.lang.String r10 = "image_matting"
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnImageMattingModel.processImage(v6.c$c, java.lang.Object, qb.b):java.lang.Object");
    }
}
