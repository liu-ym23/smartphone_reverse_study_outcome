package com.stepos.backend.qnn;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.common.log.AiEngineAtrace;
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
public final class QnnImageExtendModel extends QnnModelBase implements e7.i {
    private static final String ABILITY_ID = "image_extend";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "QnnImageExtendModel";
    private static final String UNET_HINT = "unet";
    private boolean inited;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final String resolveBundleDir$qnn_release(b7.k config) {
            kotlin.jvm.internal.g.f(config, "config");
            File fileD = b7.m.d(config);
            File[] fileArrListFiles = fileD.listFiles();
            if (fileArrListFiles == null) {
                return null;
            }
            for (File file : fileArrListFiles) {
                String name = file.getName();
                kotlin.jvm.internal.g.e(name, "getName(...)");
                if (gc.q.l0(name, QnnImageExtendModel.UNET_HINT, true)) {
                    return fileD.getAbsolutePath();
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnImageExtendModel", f = "QnnImageExtendModel.kt", l = {96}, m = "doClose")
    /* renamed from: com.stepos.backend.qnn.QnnImageExtendModel$doClose$1, reason: invalid class name */
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
            return QnnImageExtendModel.this.doClose(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnImageExtendModel$doInferInternal$1", f = "QnnImageExtendModel.kt", l = {135, 139, 147, 156, 175, 180}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnImageExtendModel$doInferInternal$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02381 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends v6.d>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ Object $input;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ QnnImageExtendModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02381(Object obj, QnnImageExtendModel qnnImageExtendModel, qb.b<? super C02381> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = qnnImageExtendModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$2(Bitmap bitmap, long j10, Rect rect, Bitmap bitmap2, boolean z) {
            return ((Number) AiEngineAtrace.section("qnn/call", QnnImageExtendModel.ABILITY_ID, new j(bitmap, j10, rect, bitmap2, z))).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$2$lambda$1(Bitmap bitmap, long j10, Rect rect, Bitmap bitmap2, boolean z) {
            return ImageExtendQnnJni.INSTANCE.nativeExtendImage(bitmap, j10, rect.left, rect.top, rect.right, rect.bottom, bitmap2, z);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C02381 c02381 = new C02381(this.$input, this.this$0, bVar);
            c02381.L$0 = obj;
            return c02381;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0081, code lost:
        
            if (r14.emit(r2, r13) == r1) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x01c1, code lost:
        
            if (r10.emit(r14, r13) == r1) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0211, code lost:
        
            if (r14.emit(r2, r13) == r1) goto L85;
         */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00ff A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #1 {all -> 0x0017, blocks: (B:6:0x0012, B:9:0x001b, B:60:0x0187, B:48:0x0140, B:50:0x0148, B:52:0x014e, B:54:0x0153, B:56:0x0159, B:57:0x015c, B:63:0x0197, B:65:0x01a3, B:66:0x01a6, B:73:0x01d7, B:75:0x01df, B:77:0x01e5, B:78:0x01e8, B:40:0x00fb, B:42:0x00ff, B:79:0x01e9, B:80:0x01f0), top: B:90:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0153 A[Catch: all -> 0x0017, TryCatch #1 {all -> 0x0017, blocks: (B:6:0x0012, B:9:0x001b, B:60:0x0187, B:48:0x0140, B:50:0x0148, B:52:0x014e, B:54:0x0153, B:56:0x0159, B:57:0x015c, B:63:0x0197, B:65:0x01a3, B:66:0x01a6, B:73:0x01d7, B:75:0x01df, B:77:0x01e5, B:78:0x01e8, B:40:0x00fb, B:42:0x00ff, B:79:0x01e9, B:80:0x01f0), top: B:90:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0197 A[Catch: all -> 0x0017, TRY_ENTER, TryCatch #1 {all -> 0x0017, blocks: (B:6:0x0012, B:9:0x001b, B:60:0x0187, B:48:0x0140, B:50:0x0148, B:52:0x014e, B:54:0x0153, B:56:0x0159, B:57:0x015c, B:63:0x0197, B:65:0x01a3, B:66:0x01a6, B:73:0x01d7, B:75:0x01df, B:77:0x01e5, B:78:0x01e8, B:40:0x00fb, B:42:0x00ff, B:79:0x01e9, B:80:0x01f0), top: B:90:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01e9 A[Catch: all -> 0x0017, TryCatch #1 {all -> 0x0017, blocks: (B:6:0x0012, B:9:0x001b, B:60:0x0187, B:48:0x0140, B:50:0x0148, B:52:0x014e, B:54:0x0153, B:56:0x0159, B:57:0x015c, B:63:0x0197, B:65:0x01a3, B:66:0x01a6, B:73:0x01d7, B:75:0x01df, B:77:0x01e5, B:78:0x01e8, B:40:0x00fb, B:42:0x00ff, B:79:0x01e9, B:80:0x01f0), top: B:90:0x0007 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 554
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnImageExtendModel.C02381.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends v6.d>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C02381) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnImageExtendModel", f = "QnnImageExtendModel.kt", l = {74}, m = "doInitialize")
    /* renamed from: com.stepos.backend.qnn.QnnImageExtendModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02391 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C02391(qb.b<? super C02391> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnImageExtendModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnImageExtendModel$doInitialize$2", f = "QnnImageExtendModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnImageExtendModel$doInitialize$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.l<qb.b<? super lb.n>, Object> {
        final /* synthetic */ String $backendLib;
        final /* synthetic */ boolean $lowMem;
        final /* synthetic */ String $modelDir;
        final /* synthetic */ String $systemLib;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, String str2, String str3, boolean z, qb.b<? super AnonymousClass2> bVar) {
            super(1, bVar);
            this.$modelDir = str;
            this.$systemLib = str2;
            this.$backendLib = str3;
            this.$lowMem = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$0(String str, String str2, String str3, boolean z) {
            return ImageExtendQnnJni.INSTANCE.nativeInit(str, str2, str3, z);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(qb.b<?> bVar) {
            return QnnImageExtendModel.this.new AnonymousClass2(this.$modelDir, this.$systemLib, this.$backendLib, this.$lowMem, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            int iIntValue = ((Number) QnnImageExtendModel.this.withAtRestDecrypt(new File(this.$modelDir), new k(this.$systemLib, this.$backendLib, this.$modelDir, this.$lowMem))).intValue();
            if (iIntValue == 0) {
                QnnImageExtendModel.this.inited = true;
                return lb.n.f10413a;
            }
            String str = iIntValue != -5 ? iIntValue != -4 ? iIntValue != -3 ? iIntValue != -2 ? iIntValue != -1 ? "unknown error" : "vaeEncoder.load() failed" : "prompt_solver.load() failed" : "diffusion_solver.load() failed" : "vaeDecoder.load() failed" : "ultraSharp.load() failed";
            String tag = QnnImageExtendModel.this.getTAG();
            String str2 = this.$modelDir;
            StringBuilder sbE = h0.e.e("nativeInit failed: code=", iIntValue, " (", str, "), modelDir=");
            sbE.append(str2);
            Log.e(tag, sbE.toString());
            String str3 = this.$modelDir;
            StringBuilder sbE2 = h0.e.e("SD extend nativeInit failed code=", iIntValue, " (", str, ") dir=");
            sbE2.append(str3);
            throw new IllegalStateException(sbE2.toString());
        }

        @Override // zb.l
        public final Object invoke(qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnImageExtendModel", f = "QnnImageExtendModel.kt", l = {129, 129}, m = "processImage")
    /* renamed from: com.stepos.backend.qnn.QnnImageExtendModel$processImage$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02401 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02401(qb.b<? super C02401> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnImageExtendModel.this.processImage(null, null, this);
        }
    }

    static {
        Object obj = e7.f.f8615a;
        e7.f.b(kotlin.jvm.internal.i.a(QnnImageExtendModel.class), mb.y.M(ProtocolType.f6379b));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QnnImageExtendModel(b7.k config) {
        super(config);
        kotlin.jvm.internal.g.f(config, "config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] bitmapToRgbaBytes(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i10 = width * height;
        int[] iArr = new int[i10];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i10 * 4];
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = iArr[i12];
            bArr[i11] = (byte) ((i13 >> 16) & 255);
            bArr[i11 + 1] = (byte) ((i13 >> 8) & 255);
            int i14 = i11 + 3;
            bArr[i11 + 2] = (byte) (i13 & 255);
            i11 += 4;
            bArr[i14] = (byte) ((i13 >> 24) & 255);
        }
        return bArr;
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
        throw new IllegalStateException("compatBitmap failed");
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
            boolean r0 = r6 instanceof com.stepos.backend.qnn.QnnImageExtendModel.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.backend.qnn.QnnImageExtendModel$doClose$1 r0 = (com.stepos.backend.qnn.QnnImageExtendModel.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.QnnImageExtendModel$doClose$1 r0 = new com.stepos.backend.qnn.QnnImageExtendModel$doClose$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            com.stepos.backend.qnn.QnnImageExtendModel r5 = (com.stepos.backend.qnn.QnnImageExtendModel) r5
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
            goto Lae
        L6e:
            boolean r0 = r5.inited     // Catch: java.lang.Throwable -> L6c
            if (r0 == 0) goto L9e
            com.stepos.backend.qnn.ImageExtendQnnJni r0 = com.stepos.backend.qnn.ImageExtendQnnJni.INSTANCE     // Catch: java.lang.Throwable -> L6c
            boolean r1 = r0.ensureLoaded()     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L9e
            android.content.Context r1 = l7.a.f10344a     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L96
            java.lang.String r2 = "activity"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch: java.lang.Throwable -> L6c
            java.lang.String r2 = "null cannot be cast to non-null type android.app.ActivityManager"
            kotlin.jvm.internal.g.d(r1, r2)     // Catch: java.lang.Throwable -> L6c
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch: java.lang.Throwable -> L6c
            boolean r1 = r1.isLowRamDevice()     // Catch: java.lang.Throwable -> L6c
            r0.nativeRelease(r1)     // Catch: java.lang.Throwable -> L6c
            r0 = 0
            r5.inited = r0     // Catch: java.lang.Throwable -> L6c
            goto L9e
        L96:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L6c
            java.lang.String r1 = "ContextHolder must be initialized before use!"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L6c
            throw r0     // Catch: java.lang.Throwable -> L6c
        L9e:
            if (r6 == 0) goto Lab
            com.stepos.backend.qnn.QnnNative r6 = com.stepos.backend.qnn.QnnNative.INSTANCE
            b7.k r5 = r5.getConfig()
            java.lang.String r5 = r5.f3090a
            r6.releaseInferPermit(r5)
        Lab:
            lb.n r5 = lb.n.f10413a
            return r5
        Lae:
            if (r6 == 0) goto Lbb
            com.stepos.backend.qnn.QnnNative r6 = com.stepos.backend.qnn.QnnNative.INSTANCE
            b7.k r5 = r5.getConfig()
            java.lang.String r5 = r5.f3090a
            r6.releaseInferPermit(r5)
        Lbb:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnImageExtendModel.doClose(qb.b):java.lang.Object");
    }

    @Override // com.stepos.backend.qnn.QnnModelBase
    public Flow<Result<v6.d>> doInferInternal(Object input) {
        kotlin.jvm.internal.g.f(input, "input");
        return FlowKt.flow(new C02381(input, this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInitialize(android.content.Context r13, b7.k r14, qb.b<? super lb.n> r15) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnImageExtendModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
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
            boolean r2 = r1 instanceof com.stepos.backend.qnn.QnnImageExtendModel.C02401
            if (r2 == 0) goto L19
            r2 = r1
            com.stepos.backend.qnn.QnnImageExtendModel$processImage$1 r2 = (com.stepos.backend.qnn.QnnImageExtendModel.C02401) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r23
            goto L20
        L19:
            com.stepos.backend.qnn.QnnImageExtendModel$processImage$1 r2 = new com.stepos.backend.qnn.QnnImageExtendModel$processImage$1
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
            java.lang.String r10 = "image_extend"
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnImageExtendModel.processImage(v6.c$c, java.lang.Object, qb.b):java.lang.Object");
    }
}
