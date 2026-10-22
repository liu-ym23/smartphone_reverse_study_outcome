package com.stepos.backend.mnn;

import b7.k;
import com.stepos.backend.mnn.MnnChineseClipModel;
import com.stepos.backend.onnx.SmsParseCpuModel;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.common.log.AiEngineAtrace;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.data.base.Content;
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
import v6.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MnnChineseClipModel extends MnnModelBase implements e7.d {
    private static final String CLIP_ABILITY_ID = "chinese_clip";
    private static final int CLIP_EMBEDDING_DIM = 1024;
    public static final Companion Companion = new Companion(null);
    private static final String IMG_HINT = "img";
    private static final String KEY_IMAGES_FEATURE = "images_feature";
    private static final String KEY_IMAGE_COUNT = "image_count";
    private static final String KEY_TEXT_FEATURE = "text_feature";
    private static final String TAG = "MnnChineseClipModel";
    private static final String TXT_HINT = "txt";
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
    @rb.c(c = "com.stepos.backend.mnn.MnnChineseClipModel$doInferInternal$1", f = "MnnChineseClipModel.kt", l = {Content.Types.TYPE_DOUBLE_ARRAY, 114, 119, 120, 123, TraceIdKeys.MAX_LENGTH, 129, 138, 142, 149, SmsParseCpuModel.MAX_SEQ_LEN, 156, 161, 162, 165, 170, 171, 173, 181}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.mnn.MnnChineseClipModel$doInferInternal$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<FlowCollector<? super Result<? extends v6.d>>, qb.b<? super n>, Object> {
        final /* synthetic */ Object $input;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Object obj, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$input = obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$10(MnnChineseClipModel mnnChineseClipModel, c.C0155c c0155c, float[] fArr) {
            return ((Number) AiEngineAtrace.section("mnn/call", "clip_image_encode", new a(mnnChineseClipModel, c0155c, fArr, 0))).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$10$lambda$9(MnnChineseClipModel mnnChineseClipModel, c.C0155c c0155c, float[] fArr) {
            return ChineseClipJni.INSTANCE.nativeExtractImageFeature(mnnChineseClipModel.nativeHandle, c0155c.f13396b, fArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$2(MnnChineseClipModel mnnChineseClipModel, Object obj, float[] fArr) {
            return ((Number) AiEngineAtrace.section("mnn/call", "clip_text_encode", new d(mnnChineseClipModel, obj, fArr, 1))).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$2$lambda$1(MnnChineseClipModel mnnChineseClipModel, Object obj, float[] fArr) {
            return ChineseClipJni.INSTANCE.nativeExtractTextFeature(mnnChineseClipModel.nativeHandle, ((c.g) obj).f13416b, fArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$4(MnnChineseClipModel mnnChineseClipModel, Object obj, float[] fArr) {
            return ((Number) AiEngineAtrace.section("mnn/call", "clip_image_encode", new c(mnnChineseClipModel, obj, fArr, 1))).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$4$lambda$3(MnnChineseClipModel mnnChineseClipModel, Object obj, float[] fArr) {
            return ChineseClipJni.INSTANCE.nativeExtractImageFeature(mnnChineseClipModel.nativeHandle, ((c.C0155c) obj).f13396b, fArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$6(final MnnChineseClipModel mnnChineseClipModel, final float[] fArr, final float[] fArr2, final int i10, final float[] fArr3) {
            return ((Number) AiEngineAtrace.section("mnn/call", "clip_select_best_image", new zb.a() { // from class: com.stepos.backend.mnn.f
                @Override // zb.a
                public final Object invoke() {
                    return Integer.valueOf(MnnChineseClipModel.AnonymousClass1.invokeSuspend$lambda$6$lambda$5(mnnChineseClipModel, fArr, fArr2, i10, fArr3));
                }
            })).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$6$lambda$5(MnnChineseClipModel mnnChineseClipModel, float[] fArr, float[] fArr2, int i10, float[] fArr3) {
            return ChineseClipJni.INSTANCE.nativeSelectBestImage(mnnChineseClipModel.nativeHandle, fArr, fArr2, i10, fArr3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$8(MnnChineseClipModel mnnChineseClipModel, c.g gVar, float[] fArr) {
            return ((Number) AiEngineAtrace.section("mnn/call", "clip_text_encode", new b(mnnChineseClipModel, gVar, fArr, 0))).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$8$lambda$7(MnnChineseClipModel mnnChineseClipModel, c.g gVar, float[] fArr) {
            return ChineseClipJni.INSTANCE.nativeExtractTextFeature(mnnChineseClipModel.nativeHandle, gVar.f13416b, fArr);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = MnnChineseClipModel.this.new AnonymousClass1(this.$input, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:103:0x02d0, code lost:
        
            if (r8.emit(r3, r18) == r2) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x02f2, code lost:
        
            if (r8.emit(r0, r18) == r2) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x033a, code lost:
        
            if (r8.emit(r3, r18) == r2) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x035b, code lost:
        
            if (r8.emit(r0, r18) == r2) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x0371, code lost:
        
            if (r8.emit(r3, r18) == r2) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x0387, code lost:
        
            if (r8.emit(r3, r18) == r2) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00d5, code lost:
        
            if (r8.emit(r3, r18) == r2) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0124, code lost:
        
            if (r8.emit(r3, r18) == r2) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0145, code lost:
        
            if (r8.emit(r0, r18) == r2) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x018b, code lost:
        
            if (r8.emit(r3, r18) == r2) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x01ac, code lost:
        
            if (r8.emit(r0, r18) == r2) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0223, code lost:
        
            if (r8.emit(r3, r18) == r2) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x023f, code lost:
        
            if (r8.emit(r0, r18) == r2) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0256, code lost:
        
            if (r8.emit(r3, r18) == r2) goto L126;
         */
        /* JADX WARN: Removed duplicated region for block: B:102:0x02b2  */
        /* JADX WARN: Removed duplicated region for block: B:105:0x02d4  */
        /* JADX WARN: Removed duplicated region for block: B:115:0x031c  */
        /* JADX WARN: Removed duplicated region for block: B:118:0x033d  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x016e  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x018f  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0203  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0227  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 954
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnChineseClipModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends v6.d>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnChineseClipModel", f = "MnnChineseClipModel.kt", l = {ErrorCodes.API_VERSION_CODE_TOO_HIGH, ErrorCodes.NOT_SET_VERSION_CODE_ERROR}, m = "doInitialize")
    /* renamed from: com.stepos.backend.mnn.MnnChineseClipModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C02071(qb.b<? super C02071> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MnnChineseClipModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnChineseClipModel", f = "MnnChineseClipModel.kt", l = {77, 77}, m = "processMixed")
    /* renamed from: com.stepos.backend.mnn.MnnChineseClipModel$processMixed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02081 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02081(qb.b<? super C02081> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MnnChineseClipModel.this.processMixed(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.mnn.MnnChineseClipModel", f = "MnnChineseClipModel.kt", l = {94}, m = "processMixedStream")
    /* renamed from: com.stepos.backend.mnn.MnnChineseClipModel$processMixedStream$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02091 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02091(qb.b<? super C02091> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MnnChineseClipModel.this.processMixedStream(null, null, this);
        }
    }

    static {
        Object obj = e7.f.f8615a;
        e7.f.b(kotlin.jvm.internal.i.a(MnnChineseClipModel.class), y.M(ProtocolType.f6382e));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MnnChineseClipModel(k config) {
        super(config);
        kotlin.jvm.internal.g.f(config, "config");
    }

    @Override // com.stepos.backend.mnn.MnnModelBase, com.stepos.base.model.ModelBase
    public Object doClose(qb.b<? super n> bVar) {
        long j10 = this.nativeHandle;
        if (j10 != 0) {
            ChineseClipJni.INSTANCE.nativeRelease(j10);
            this.nativeHandle = 0L;
        }
        Object objDoClose = super.doClose(bVar);
        return objDoClose == CoroutineSingletons.f10059a ? objDoClose : n.f10413a;
    }

    @Override // com.stepos.backend.mnn.MnnModelBase
    public Flow<Result<v6.d>> doInferInternal(Object input) {
        kotlin.jvm.internal.g.f(input, "input");
        return FlowKt.flow(new AnonymousClass1(input, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.backend.mnn.MnnModelBase, com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInitialize(android.content.Context r11, b7.k r12, qb.b<? super lb.n> r13) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnChineseClipModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
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
            boolean r2 = r1 instanceof com.stepos.backend.mnn.MnnChineseClipModel.C02081
            if (r2 == 0) goto L19
            r2 = r1
            com.stepos.backend.mnn.MnnChineseClipModel$processMixed$1 r2 = (com.stepos.backend.mnn.MnnChineseClipModel.C02081) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r23
            goto L20
        L19:
            com.stepos.backend.mnn.MnnChineseClipModel$processMixed$1 r2 = new com.stepos.backend.mnn.MnnChineseClipModel$processMixed$1
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
            java.lang.String r10 = "chinese_clip"
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnChineseClipModel.processMixed(v6.c$e, java.lang.Object, qb.b):java.lang.Object");
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
            boolean r2 = r1 instanceof com.stepos.backend.mnn.MnnChineseClipModel.C02091
            if (r2 == 0) goto L19
            r2 = r1
            com.stepos.backend.mnn.MnnChineseClipModel$processMixedStream$1 r2 = (com.stepos.backend.mnn.MnnChineseClipModel.C02091) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r22
            goto L20
        L19:
            com.stepos.backend.mnn.MnnChineseClipModel$processMixedStream$1 r2 = new com.stepos.backend.mnn.MnnChineseClipModel$processMixedStream$1
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
            java.lang.String r9 = "chinese_clip"
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
            com.stepos.backend.mnn.MnnChineseClipModel$processMixedStream$$inlined$map$1 r0 = new com.stepos.backend.mnn.MnnChineseClipModel$processMixedStream$$inlined$map$1
            r0.<init>()
            return r0
        La8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "ContextHolder must be initialized before use!"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.mnn.MnnChineseClipModel.processMixedStream(v6.c$e, java.lang.Object, qb.b):java.lang.Object");
    }
}
