package com.stepos.backend.qnn;

import android.graphics.Bitmap;
import com.stepos.base.data.InpaintNativeResult;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.core.common.log.AiEngineAtrace;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
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
public final class QnnImageInpaintAigcModel extends QnnModelBase implements e7.d {
    private static final String ABILITY_ID = "image_inpaint_aigc";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "QnnImageInpaintAigcModel";
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
    @rb.c(c = "com.stepos.backend.qnn.QnnImageInpaintAigcModel", f = "QnnImageInpaintAigcModel.kt", l = {68}, m = "doClose")
    /* renamed from: com.stepos.backend.qnn.QnnImageInpaintAigcModel$doClose$1, reason: invalid class name */
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
            return QnnImageInpaintAigcModel.this.doClose(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnImageInpaintAigcModel$doInferInternal$1", f = "QnnImageInpaintAigcModel.kt", l = {123, 127, 132, 148, 151, 161, 176}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnImageInpaintAigcModel$doInferInternal$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02411 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends v6.d>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ Object $input;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        final /* synthetic */ QnnImageInpaintAigcModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02411(Object obj, QnnImageInpaintAigcModel qnnImageInpaintAigcModel, qb.b<? super C02411> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = qnnImageInpaintAigcModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InpaintNativeResult invokeSuspend$lambda$2(Bitmap bitmap, Bitmap bitmap2, long j10, boolean z) {
            return (InpaintNativeResult) AiEngineAtrace.section("qnn/call", QnnImageInpaintAigcModel.ABILITY_ID, new d(bitmap, bitmap2, j10, z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InpaintNativeResult invokeSuspend$lambda$2$lambda$1(Bitmap bitmap, Bitmap bitmap2, long j10, boolean z) {
            return ImageInpaintAigcQnnJni.INSTANCE.nativeInpaint(bitmap, bitmap2, j10, z);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C02411 c02411 = new C02411(this.$input, this.this$0, bVar);
            c02411.L$0 = obj;
            return c02411;
        }

        /* JADX WARN: Code restructure failed: missing block: B:105:0x024e, code lost:
        
            if (r2.emit(r5, r17) == r0) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x008f, code lost:
        
            if (r2.emit(r4, r17) == r0) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00e2, code lost:
        
            if (r2.emit(r4, r17) == r0) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x01be, code lost:
        
            if (r6.emit(r2, r17) == r0) goto L106;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x01f5  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0210 A[Catch: all -> 0x0016, TryCatch #1 {all -> 0x0016, blocks: (B:6:0x0011, B:9:0x0019, B:82:0x01f6, B:56:0x0168, B:58:0x016c, B:60:0x0172, B:61:0x0175, B:63:0x0179, B:65:0x017f, B:68:0x0185, B:71:0x018a, B:73:0x01a5, B:74:0x01a8, B:79:0x01d2, B:89:0x020c, B:91:0x0210, B:93:0x0216, B:94:0x0219, B:96:0x021d, B:98:0x0223, B:99:0x0226), top: B:111:0x0006 }] */
        /* JADX WARN: Removed duplicated region for block: B:96:0x021d A[Catch: all -> 0x0016, TryCatch #1 {all -> 0x0016, blocks: (B:6:0x0011, B:9:0x0019, B:82:0x01f6, B:56:0x0168, B:58:0x016c, B:60:0x0172, B:61:0x0175, B:63:0x0179, B:65:0x017f, B:68:0x0185, B:71:0x018a, B:73:0x01a5, B:74:0x01a8, B:79:0x01d2, B:89:0x020c, B:91:0x0210, B:93:0x0216, B:94:0x0219, B:96:0x021d, B:98:0x0223, B:99:0x0226), top: B:111:0x0006 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instructions count: 616
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnImageInpaintAigcModel.C02411.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends v6.d>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C02411) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnImageInpaintAigcModel", f = "QnnImageInpaintAigcModel.kt", l = {55}, m = "doInitialize")
    /* renamed from: com.stepos.backend.qnn.QnnImageInpaintAigcModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C02421(qb.b<? super C02421> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnImageInpaintAigcModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnImageInpaintAigcModel$doInitialize$2", f = "QnnImageInpaintAigcModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnImageInpaintAigcModel$doInitialize$2, reason: invalid class name */
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
            return ImageInpaintAigcQnnJni.INSTANCE.nativeInit(str, str2, str3, z);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(qb.b<?> bVar) {
            return QnnImageInpaintAigcModel.this.new AnonymousClass2(this.$modelDir, this.$systemLib, this.$backendLib, this.$lowMem, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            int iIntValue = ((Number) QnnImageInpaintAigcModel.this.withAtRestDecrypt(new File(this.$modelDir), new m(this.$systemLib, this.$backendLib, this.$modelDir, this.$lowMem))).intValue();
            if (iIntValue != 0) {
                throw new IllegalStateException(a0.a.g("SD inpaint AIGC nativeInit failed code=", iIntValue, " dir=", this.$modelDir));
            }
            QnnImageInpaintAigcModel.this.inited = true;
            return lb.n.f10413a;
        }

        @Override // zb.l
        public final Object invoke(qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnImageInpaintAigcModel", f = "QnnImageInpaintAigcModel.kt", l = {101, 101}, m = "processMixed")
    /* renamed from: com.stepos.backend.qnn.QnnImageInpaintAigcModel$processMixed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02431 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02431(qb.b<? super C02431> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnImageInpaintAigcModel.this.processMixed(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnImageInpaintAigcModel", f = "QnnImageInpaintAigcModel.kt", l = {118}, m = "processMixedStream")
    /* renamed from: com.stepos.backend.qnn.QnnImageInpaintAigcModel$processMixedStream$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02441 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02441(qb.b<? super C02441> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnImageInpaintAigcModel.this.processMixedStream(null, null, this);
        }
    }

    static {
        Object obj = e7.f.f8615a;
        e7.f.b(kotlin.jvm.internal.i.a(QnnImageInpaintAigcModel.class), mb.y.M(ProtocolType.f6382e));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QnnImageInpaintAigcModel(b7.k config) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<c.C0155c, c.C0155c> resolveInpaintSourceAndMask(List<c.C0155c> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!gc.q.t0(((c.C0155c) obj).f13406m)) {
                arrayList.add(obj);
            }
        }
        int iA0 = mb.v.a0(mb.m.Z(arrayList, 10));
        if (iA0 < 16) {
            iA0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            linkedHashMap.put(gc.q.L0(((c.C0155c) obj2).f13406m).toString(), obj2);
        }
        c.C0155c c0155c = (c.C0155c) linkedHashMap.get("image");
        if (c0155c == null) {
            c0155c = list.get(0);
        }
        c.C0155c c0155c2 = (c.C0155c) linkedHashMap.get(BundleContentBridge.ROLE_MASK);
        if (c0155c2 == null && (c0155c2 = (c.C0155c) kotlin.collections.a.w0(1, list)) == null) {
            throw new IllegalArgumentException("缺少 mask 图");
        }
        return new Pair<>(c0155c, c0155c2);
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
            boolean r0 = r6 instanceof com.stepos.backend.qnn.QnnImageInpaintAigcModel.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.backend.qnn.QnnImageInpaintAigcModel$doClose$1 r0 = (com.stepos.backend.qnn.QnnImageInpaintAigcModel.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.QnnImageInpaintAigcModel$doClose$1 r0 = new com.stepos.backend.qnn.QnnImageInpaintAigcModel$doClose$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            com.stepos.backend.qnn.QnnImageInpaintAigcModel r5 = (com.stepos.backend.qnn.QnnImageInpaintAigcModel) r5
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
            com.stepos.backend.qnn.ImageInpaintAigcQnnJni r0 = com.stepos.backend.qnn.ImageInpaintAigcQnnJni.INSTANCE     // Catch: java.lang.Throwable -> L6c
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnImageInpaintAigcModel.doClose(qb.b):java.lang.Object");
    }

    @Override // com.stepos.backend.qnn.QnnModelBase
    public Flow<Result<v6.d>> doInferInternal(Object input) {
        kotlin.jvm.internal.g.f(input, "input");
        return FlowKt.flow(new C02411(input, this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInitialize(android.content.Context r13, b7.k r14, qb.b<? super lb.n> r15) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnImageInpaintAigcModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
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
            boolean r2 = r1 instanceof com.stepos.backend.qnn.QnnImageInpaintAigcModel.C02431
            if (r2 == 0) goto L19
            r2 = r1
            com.stepos.backend.qnn.QnnImageInpaintAigcModel$processMixed$1 r2 = (com.stepos.backend.qnn.QnnImageInpaintAigcModel.C02431) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r23
            goto L20
        L19:
            com.stepos.backend.qnn.QnnImageInpaintAigcModel$processMixed$1 r2 = new com.stepos.backend.qnn.QnnImageInpaintAigcModel$processMixed$1
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
            java.lang.String r10 = "image_inpaint_aigc"
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnImageInpaintAigcModel.processMixed(v6.c$e, java.lang.Object, qb.b):java.lang.Object");
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
            boolean r2 = r1 instanceof com.stepos.backend.qnn.QnnImageInpaintAigcModel.C02441
            if (r2 == 0) goto L19
            r2 = r1
            com.stepos.backend.qnn.QnnImageInpaintAigcModel$processMixedStream$1 r2 = (com.stepos.backend.qnn.QnnImageInpaintAigcModel.C02441) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r22
            goto L20
        L19:
            com.stepos.backend.qnn.QnnImageInpaintAigcModel$processMixedStream$1 r2 = new com.stepos.backend.qnn.QnnImageInpaintAigcModel$processMixedStream$1
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
            java.lang.String r9 = "image_inpaint_aigc"
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
            com.stepos.backend.qnn.QnnImageInpaintAigcModel$processMixedStream$$inlined$map$1 r0 = new com.stepos.backend.qnn.QnnImageInpaintAigcModel$processMixedStream$$inlined$map$1
            r0.<init>()
            return r0
        La8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "ContextHolder must be initialized before use!"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnImageInpaintAigcModel.processMixedStream(v6.c$e, java.lang.Object, qb.b):java.lang.Object");
    }
}
