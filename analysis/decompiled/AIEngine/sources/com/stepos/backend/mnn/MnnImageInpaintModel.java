package com.stepos.backend.mnn;

import android.graphics.Bitmap;
import b7.k;
import com.stepos.base.data.InpaintNativeResult;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.core.common.log.AiEngineAtrace;
import com.stepos.core.data.base.Content;
import com.stepos.core.ota.crypto.FekEnvelope;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import gc.q;
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
import lb.n;
import mb.m;
import mb.v;
import mb.y;
import v6.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MnnImageInpaintModel extends MnnModelBase implements e7.d {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "MnnImageInpaintModel";
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
    @rb.c(c = "com.stepos.backend.mnn.MnnImageInpaintModel$doInferInternal$1", f = "MnnImageInpaintModel.kt", l = {93, 102, Content.Types.TYPE_DOUBLE_ARRAY, FekEnvelope.EXPECTED_EPK_CHARS, 133, 147}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.mnn.MnnImageInpaintModel$doInferInternal$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<FlowCollector<? super Result<? extends v6.d>>, qb.b<? super n>, Object> {
        final /* synthetic */ Object $input;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ MnnImageInpaintModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Object obj, MnnImageInpaintModel mnnImageInpaintModel, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = mnnImageInpaintModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InpaintNativeResult invokeSuspend$lambda$2(MnnImageInpaintModel mnnImageInpaintModel, Bitmap bitmap, Bitmap bitmap2) {
            return (InpaintNativeResult) AiEngineAtrace.section("mnn/call", "image_inpaint", new j(mnnImageInpaintModel, bitmap, bitmap2, 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InpaintNativeResult invokeSuspend$lambda$2$lambda$1(MnnImageInpaintModel mnnImageInpaintModel, Bitmap bitmap, Bitmap bitmap2) {
            return ImageInpaintJni.INSTANCE.nativeInpaint(mnnImageInpaintModel.nativeHandle, bitmap, bitmap2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$input, this.this$0, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
        
            if (r14.emit(r2, r13) == r1) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00ae, code lost:
        
            if (r14.emit(r3, r13) == r1) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00ee, code lost:
        
            if (r14.emit(r2, r13) == r1) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x018f, code lost:
        
            if (r0.emit(r14, r13) == r1) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x01b1, code lost:
        
            if (r0.emit(r3, r13) != r1) goto L87;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 484
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnImageInpaintModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends v6.d>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnImageInpaintModel", f = "MnnImageInpaintModel.kt", l = {ErrorCodes.API_VERSION_CODE_TOO_HIGH}, m = "doInitialize")
    /* renamed from: com.stepos.backend.mnn.MnnImageInpaintModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02161(qb.b<? super C02161> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MnnImageInpaintModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnImageInpaintModel", f = "MnnImageInpaintModel.kt", l = {71, 71}, m = "processMixed")
    /* renamed from: com.stepos.backend.mnn.MnnImageInpaintModel$processMixed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02171 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02171(qb.b<? super C02171> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MnnImageInpaintModel.this.processMixed(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnImageInpaintModel", f = "MnnImageInpaintModel.kt", l = {88}, m = "processMixedStream")
    /* renamed from: com.stepos.backend.mnn.MnnImageInpaintModel$processMixedStream$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02181 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02181(qb.b<? super C02181> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MnnImageInpaintModel.this.processMixedStream(null, null, this);
        }
    }

    static {
        Object obj = e7.f.f8615a;
        e7.f.b(kotlin.jvm.internal.i.a(MnnImageInpaintModel.class), y.M(ProtocolType.f6382e));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MnnImageInpaintModel(k config) {
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
        throw new IllegalStateException("compatBitmap: ARGB_8888 copy failed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<c.C0155c, c.C0155c> resolveInpaintSourceAndMask(List<c.C0155c> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!q.t0(((c.C0155c) obj).f13406m)) {
                arrayList.add(obj);
            }
        }
        int iA0 = v.a0(m.Z(arrayList, 10));
        if (iA0 < 16) {
            iA0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            linkedHashMap.put(q.L0(((c.C0155c) obj2).f13406m).toString(), obj2);
        }
        c.C0155c c0155c = (c.C0155c) linkedHashMap.get("image");
        if (c0155c == null) {
            c0155c = list.get(0);
        }
        c.C0155c c0155c2 = (c.C0155c) linkedHashMap.get(BundleContentBridge.ROLE_MASK);
        if (c0155c2 == null && (c0155c2 = (c.C0155c) kotlin.collections.a.w0(1, list)) == null) {
            throw new IllegalArgumentException("Inpaint 缺少 mask 图");
        }
        return new Pair<>(c0155c, c0155c2);
    }

    private final String taskAbilityId() {
        return kotlin.jvm.internal.g.b(getConfig().f3090a, "mnn-inpaint-aigc") ? "image_inpaint_aigc" : "image_inpaint";
    }

    @Override // com.stepos.backend.mnn.MnnModelBase, com.stepos.base.model.ModelBase
    public Object doClose(qb.b<? super n> bVar) {
        long j10 = this.nativeHandle;
        if (j10 != 0) {
            ImageInpaintJni.INSTANCE.nativeRelease(j10);
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
            boolean r5 = r7 instanceof com.stepos.backend.mnn.MnnImageInpaintModel.C02161
            if (r5 == 0) goto L13
            r5 = r7
            com.stepos.backend.mnn.MnnImageInpaintModel$doInitialize$1 r5 = (com.stepos.backend.mnn.MnnImageInpaintModel.C02161) r5
            int r0 = r5.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r5.label = r0
            goto L18
        L13:
            com.stepos.backend.mnn.MnnImageInpaintModel$doInitialize$1 r5 = new com.stepos.backend.mnn.MnnImageInpaintModel$doInitialize$1
            r5.<init>(r7)
        L18:
            java.lang.Object r7 = r5.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r4 = r5.L$2
            com.stepos.backend.mnn.MnnImageInpaintModel r4 = (com.stepos.backend.mnn.MnnImageInpaintModel) r4
            java.lang.Object r6 = r5.L$1
            java.io.File r6 = (java.io.File) r6
            java.lang.Object r5 = r5.L$0
            com.stepos.backend.mnn.MnnImageInpaintModel r5 = (com.stepos.backend.mnn.MnnImageInpaintModel) r5
            kotlin.c.b(r7)
            goto L68
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.c.b(r7)
            com.stepos.backend.mnn.ImageInpaintJni r7 = com.stepos.backend.mnn.ImageInpaintJni.INSTANCE
            boolean r7 = r7.ensureLoaded()
            if (r7 != 0) goto L52
            java.lang.String r4 = r4.getTAG()
            java.lang.String r5 = "imageinpaint_mnn load failed"
            android.util.Log.w(r4, r5)
            lb.n r4 = lb.n.f10413a
            return r4
        L52:
            java.io.File r7 = b7.m.e(r6)
            r5.L$0 = r4
            r5.L$1 = r7
            r5.L$2 = r4
            r5.label = r2
            java.lang.Object r5 = com.stepos.base.model.atrest.a.a(r6, r7, r5)
            if (r5 != r0) goto L65
            return r0
        L65:
            r6 = r7
            r7 = r5
            r5 = r4
        L68:
            java.lang.AutoCloseable r7 = (java.lang.AutoCloseable) r7
            r0 = r7
            c7.d r0 = (c7.d) r0     // Catch: java.lang.Throwable -> La3
            com.stepos.backend.mnn.ImageInpaintJni r1 = com.stepos.backend.mnn.ImageInpaintJni.INSTANCE     // Catch: java.lang.Throwable -> La3
            java.lang.String r0 = r0.f3303a     // Catch: java.lang.Throwable -> La3
            long r0 = r1.nativeInit(r0)     // Catch: java.lang.Throwable -> La3
            r2 = 0
            xb.a.a(r7, r2)
            r4.nativeHandle = r0
            long r0 = r5.nativeHandle
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L93
            java.lang.String r4 = r5.getTAG()
            java.lang.String r5 = r6.getAbsolutePath()
            java.lang.String r6 = "MNN inpaint initialized: "
            a0.a.y(r6, r5, r4)
            lb.n r4 = lb.n.f10413a
            return r4
        L93:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = r6.getAbsolutePath()
            java.lang.String r6 = "Inpaint nativeInit failed for "
            java.lang.String r5 = ai.onnxruntime.a.k(r6, r5)
            r4.<init>(r5)
            throw r4
        La3:
            r4 = move-exception
            throw r4     // Catch: java.lang.Throwable -> La5
        La5:
            r5 = move-exception
            xb.a.a(r7, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnImageInpaintModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
    }

    @Override // e7.b
    public ProtocolType getType() {
        return ProtocolType.f6382e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b3, code lost:
    
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
            boolean r2 = r1 instanceof com.stepos.backend.mnn.MnnImageInpaintModel.C02171
            if (r2 == 0) goto L19
            r2 = r1
            com.stepos.backend.mnn.MnnImageInpaintModel$processMixed$1 r2 = (com.stepos.backend.mnn.MnnImageInpaintModel.C02171) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r23
            goto L20
        L19:
            com.stepos.backend.mnn.MnnImageInpaintModel$processMixed$1 r2 = new com.stepos.backend.mnn.MnnImageInpaintModel$processMixed$1
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
            goto Lb6
        L33:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3b:
            kotlin.c.b(r1)
            goto Lab
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
            java.lang.String r10 = r3.taskAbilityId()
            b7.k r1 = r3.getConfig()
            java.lang.String r11 = r1.f3090a
            r1 = 0
            if (r0 == 0) goto L61
            int r3 = r0.getCallerUid()
            r13 = r3
            goto L62
        L61:
            r13 = r1
        L62:
            if (r0 == 0) goto L68
            int r1 = r0.getCallerPid()
        L68:
            r14 = r1
            if (r0 == 0) goto L74
            java.lang.String r1 = r0.getCallerPackage()
            if (r1 != 0) goto L72
            goto L74
        L72:
            r15 = r1
            goto L77
        L74:
            java.lang.String r1 = ""
            goto L72
        L77:
            if (r0 == 0) goto L80
            boolean r1 = r0.isForeground()
            r17 = r1
            goto L82
        L80:
            r17 = r7
        L82:
            if (r0 == 0) goto L88
            java.lang.Object r5 = r0.getPowerTracker()
        L88:
            r18 = r5
            r21 = 0
            r22 = 6529(0x1981, float:9.149E-42)
            r9 = 0
            r16 = 0
            r19 = 0
            r12 = r24
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r21, r22)
            com.stepos.core.model.task.AITaskSupervisor$Companion r0 = com.stepos.core.model.task.AITaskSupervisor.Companion
            android.content.Context r1 = l7.a.f10344a
            if (r1 == 0) goto Lc5
            com.stepos.core.model.task.AITaskSupervisor r0 = r0.getInstance(r1)
            r2.label = r7
            java.lang.Object r1 = r0.submitTask(r8, r2)
            if (r1 != r4) goto Lab
            goto Lb5
        Lab:
            kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
            r2.label = r6
            java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.single(r1, r2)
            if (r1 != r4) goto Lb6
        Lb5:
            return r4
        Lb6:
            kotlin.Result r1 = (kotlin.Result) r1
            java.lang.Object r0 = r1.f9987a
            kotlin.c.b(r0)
            java.lang.String r1 = "null cannot be cast to non-null type com.stepos.base.data.Output"
            kotlin.jvm.internal.g.d(r0, r1)
            v6.d r0 = (v6.d) r0
            return r0
        Lc5:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "ContextHolder must be initialized before use!"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnImageInpaintModel.processMixed(v6.c$e, java.lang.Object, qb.b):java.lang.Object");
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
            boolean r2 = r1 instanceof com.stepos.backend.mnn.MnnImageInpaintModel.C02181
            if (r2 == 0) goto L19
            r2 = r1
            com.stepos.backend.mnn.MnnImageInpaintModel$processMixedStream$1 r2 = (com.stepos.backend.mnn.MnnImageInpaintModel.C02181) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r22
            goto L20
        L19:
            com.stepos.backend.mnn.MnnImageInpaintModel$processMixedStream$1 r2 = new com.stepos.backend.mnn.MnnImageInpaintModel$processMixedStream$1
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
            goto La2
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
            java.lang.String r9 = r3.taskAbilityId()
            b7.k r1 = r3.getConfig()
            java.lang.String r10 = r1.f3090a
            r1 = 0
            if (r0 == 0) goto L59
            int r3 = r0.getCallerUid()
            r12 = r3
            goto L5a
        L59:
            r12 = r1
        L5a:
            if (r0 == 0) goto L60
            int r1 = r0.getCallerPid()
        L60:
            r13 = r1
            if (r0 == 0) goto L6c
            java.lang.String r1 = r0.getCallerPackage()
            if (r1 != 0) goto L6a
            goto L6c
        L6a:
            r14 = r1
            goto L6f
        L6c:
            java.lang.String r1 = ""
            goto L6a
        L6f:
            if (r0 == 0) goto L78
            boolean r1 = r0.isForeground()
            r16 = r1
            goto L7a
        L78:
            r16 = r6
        L7a:
            if (r0 == 0) goto L80
            java.lang.Object r5 = r0.getPowerTracker()
        L80:
            r17 = r5
            r20 = 0
            r21 = 6529(0x1981, float:9.149E-42)
            r8 = 0
            r15 = 0
            r18 = 0
            r11 = r23
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r20, r21)
            com.stepos.core.model.task.AITaskSupervisor$Companion r0 = com.stepos.core.model.task.AITaskSupervisor.Companion
            android.content.Context r1 = l7.a.f10344a
            if (r1 == 0) goto Laa
            com.stepos.core.model.task.AITaskSupervisor r0 = r0.getInstance(r1)
            r2.label = r6
            java.lang.Object r1 = r0.submitTask(r7, r2)
            if (r1 != r4) goto La2
            return r4
        La2:
            kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
            com.stepos.backend.mnn.MnnImageInpaintModel$processMixedStream$$inlined$map$1 r0 = new com.stepos.backend.mnn.MnnImageInpaintModel$processMixedStream$$inlined$map$1
            r0.<init>()
            return r0
        Laa:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "ContextHolder must be initialized before use!"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnImageInpaintModel.processMixedStream(v6.c$e, java.lang.Object, qb.b):java.lang.Object");
    }
}
