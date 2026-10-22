package com.stepos.core.ability.speech;

import com.stepos.core.ability.telemetry.ModelCallBridge;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrMultiFilesPipeline {
    private final AsrFileCloudClient cloudClient;
    private final int downloadUrlExpiresSeconds;
    private final p6.c fileParams;
    private final String tag;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrMultiFilesPipeline", f = "AsrMultiFilesPipeline.kt", l = {195, 214, 227}, m = "drainCloudPending")
    /* renamed from: com.stepos.core.ability.speech.AsrMultiFilesPipeline$drainCloudPending$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsrMultiFilesPipeline.this.drainCloudPending(null, null, null, null, 0, null, null, null, null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrMultiFilesPipeline$runCloudMultiFiles$1", f = "AsrMultiFilesPipeline.kt", l = {ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR, ErrorCodes.PRE_SERVICE_METHOD_INTERCEPT_ERROR, ErrorCodes.SERVICE_RECYCLE_ERROR, 83, 86, 90, 99, 101, 110, 113, 118}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrMultiFilesPipeline$runCloudMultiFiles$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03201 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ String $abilityId;
        final /* synthetic */ c.a $input;
        final /* synthetic */ String $modelId;
        final /* synthetic */ Object $record;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03201(c.a aVar, Object obj, String str, String str2, qb.b<? super C03201> bVar) {
            super(2, bVar);
            this.$input = aVar;
            this.$record = obj;
            this.$abilityId = str;
            this.$modelId = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final java.lang.Object invokeSuspend$drain(kotlin.jvm.internal.Ref$IntRef r16, com.stepos.core.ability.speech.AsrMultiFilesPipeline r17, com.stepos.core.ability.speech.AsrFileCloudClient r18, mb.k<kotlin.Pair<java.lang.Integer, java.lang.String>> r19, java.util.List<v6.c.b> r20, java.util.Map<java.lang.Integer, com.stepos.core.ability.speech.AsrFileResult> r21, java.lang.String r22, java.lang.Object r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, kotlinx.coroutines.flow.FlowCollector<? super kotlin.Result<v6.d.q>> r27, qb.b<? super lb.n> r28) {
            /*
                r0 = r16
                r1 = r28
                boolean r2 = r1 instanceof com.stepos.core.ability.speech.AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$1
                if (r2 == 0) goto L18
                r2 = r1
                com.stepos.core.ability.speech.AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$1 r2 = (com.stepos.core.ability.speech.AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$1) r2
                int r3 = r2.label
                r4 = -2147483648(0xffffffff80000000, float:-0.0)
                r5 = r3 & r4
                if (r5 == 0) goto L18
                int r3 = r3 - r4
                r2.label = r3
            L16:
                r15 = r2
                goto L1e
            L18:
                com.stepos.core.ability.speech.AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$1 r2 = new com.stepos.core.ability.speech.AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$1
                r2.<init>(r1)
                goto L16
            L1e:
                java.lang.Object r1 = r15.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r3 = r15.label
                r4 = 1
                if (r3 == 0) goto L39
                if (r3 != r4) goto L31
                java.lang.Object r0 = r15.L$0
                kotlin.jvm.internal.Ref$IntRef r0 = (kotlin.jvm.internal.Ref$IntRef) r0
                kotlin.c.b(r1)
                goto L65
            L31:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L39:
                kotlin.c.b(r1)
                int r8 = r0.f10074a
                com.stepos.core.ability.speech.AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$2 r14 = new com.stepos.core.ability.speech.AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$2
                r1 = 0
                r3 = r27
                r14.<init>(r3, r1)
                r15.L$0 = r0
                r15.label = r4
                r3 = r17
                r4 = r18
                r5 = r19
                r6 = r20
                r7 = r21
                r9 = r22
                r10 = r23
                r11 = r24
                r12 = r25
                r13 = r26
                java.lang.Object r1 = com.stepos.core.ability.speech.AsrMultiFilesPipeline.access$drainCloudPending(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
                if (r1 != r2) goto L65
                return r2
            L65:
                java.lang.Number r1 = (java.lang.Number) r1
                int r1 = r1.intValue()
                r0.f10074a = r1
                lb.n r0 = lb.n.f10413a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrMultiFilesPipeline.C03201.invokeSuspend$drain(kotlin.jvm.internal.Ref$IntRef, com.stepos.core.ability.speech.AsrMultiFilesPipeline, com.stepos.core.ability.speech.AsrFileCloudClient, mb.k, java.util.List, java.util.Map, java.lang.String, java.lang.Object, java.lang.String, java.lang.String, java.lang.String, kotlinx.coroutines.flow.FlowCollector, qb.b):java.lang.Object");
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C03201 c03201 = AsrMultiFilesPipeline.this.new C03201(this.$input, this.$record, this.$abilityId, this.$modelId, bVar);
            c03201.L$0 = obj;
            return c03201;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0223, code lost:
        
            if (r0.emit(r2, r12) == r13) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0244, code lost:
        
            if (r0.emit(r2, r12) == r13) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0260, code lost:
        
            if (r0.emit(r2, r12) == r13) goto L22;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x02c3  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0382  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0385  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0458  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0521  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0542  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x05f0  */
        /* JADX WARN: Type inference failed for: r11v13, types: [s6.a] */
        /* JADX WARN: Type inference failed for: r11v16, types: [s6.a] */
        /* JADX WARN: Type inference failed for: r11v4, types: [s6.a] */
        /* JADX WARN: Type inference failed for: r11v7, types: [s6.a] */
        /* JADX WARN: Type inference failed for: r14v12, types: [s6.a] */
        /* JADX WARN: Type inference failed for: r14v48, types: [s6.a] */
        /* JADX WARN: Type inference failed for: r6v12, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r6v14, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r6v3, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r6v6, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r7v12, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r8v40, types: [java.util.Map] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x05cb -> B:86:0x05d3). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r32) {
            /*
                Method dump skipped, instructions count: 1712
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrMultiFilesPipeline.C03201.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C03201) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrMultiFilesPipeline$runLocalMultiFiles$1", f = "AsrMultiFilesPipeline.kt", l = {127, 135, 138, 144, 149}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrMultiFilesPipeline$runLocalMultiFiles$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03211 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ c.a $input;
        final /* synthetic */ e7.a $protocol;
        final /* synthetic */ Object $record;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ AsrMultiFilesPipeline this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03211(c.a aVar, AsrMultiFilesPipeline asrMultiFilesPipeline, e7.a aVar2, Object obj, qb.b<? super C03211> bVar) {
            super(2, bVar);
            this.$input = aVar;
            this.this$0 = asrMultiFilesPipeline;
            this.$protocol = aVar2;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C03211 c03211 = new C03211(this.$input, this.this$0, this.$protocol, this.$record, bVar);
            c03211.L$0 = obj;
            return c03211;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x00a1, code lost:
        
            if (r0.emit(r2, r20) == r6) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x01b5, code lost:
        
            if (r15.emit(r7, r20) == r6) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x020d, code lost:
        
            if (r8.emit(r1, r20) == r6) goto L48;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00db  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0124  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0163  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x01c4  */
        /* JADX WARN: Type inference failed for: r13v1, types: [android.os.Bundle, java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r13v6 */
        /* JADX WARN: Type inference failed for: r13v7 */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v12, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r4v14, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.Map] */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x01b5 -> B:41:0x015d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 531
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrMultiFilesPipeline.C03211.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C03211) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    public AsrMultiFilesPipeline(AsrFileCloudClient asrFileCloudClient, p6.c fileParams, int i10) {
        kotlin.jvm.internal.g.f(fileParams, "fileParams");
        this.cloudClient = asrFileCloudClient;
        this.fileParams = fileParams;
        this.downloadUrlExpiresSeconds = i10;
        this.tag = "AsrMultiFilesPipeline";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:90|28|84|29|30|82|31|38|(1:40)|41|(2:43|73)(3:44|45|(6:47|(2:50|(2:53|(2:56|(1:58)(1:59))(1:55))(1:52))(1:49)|60|(1:64)|65|(1:93)(6:68|69|70|76|91|(1:19)))(2:71|(1:92)(6:74|75|70|76|91|(1:19))))) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x01aa, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x01ac, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01ad, code lost:
    
        r30 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01af, code lost:
    
        r0 = kotlin.c.a(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0392 -> B:75:0x039c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object drainCloudPending(com.stepos.core.ability.speech.AsrFileCloudClient r24, mb.k<kotlin.Pair<java.lang.Integer, java.lang.String>> r25, java.util.List<v6.c.b> r26, java.util.Map<java.lang.Integer, com.stepos.core.ability.speech.AsrFileResult> r27, int r28, java.lang.String r29, java.lang.Object r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, zb.p<? super java.lang.String, ? super qb.b<? super lb.n>, ? extends java.lang.Object> r34, qb.b<? super java.lang.Integer> r35) {
        /*
            Method dump skipped, instructions count: 972
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrMultiFilesPipeline.drainCloudPending(com.stepos.core.ability.speech.AsrFileCloudClient, mb.k, java.util.List, java.util.Map, int, java.lang.String, java.lang.Object, java.lang.String, java.lang.String, java.lang.String, zb.p, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n drainCloudPending$lambda$1(String str, CloudSessionCorrelationState it) {
        kotlin.jvm.internal.g.f(it, "it");
        ModelCallBridge.INSTANCE.logEstablished(str, it);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n drainCloudPending$lambda$2(String str) {
        ModelCallBridge.INSTANCE.recordFirstToken(str);
        return lb.n.f10413a;
    }

    public static /* synthetic */ Flow runCloudMultiFiles$default(AsrMultiFilesPipeline asrMultiFilesPipeline, c.a aVar, Object obj, String str, String str2, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            obj = null;
        }
        return asrMultiFilesPipeline.runCloudMultiFiles(aVar, obj, str, str2);
    }

    public static /* synthetic */ Flow runLocalMultiFiles$default(AsrMultiFilesPipeline asrMultiFilesPipeline, c.a aVar, e7.a aVar2, Object obj, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            obj = null;
        }
        return asrMultiFilesPipeline.runLocalMultiFiles(aVar, aVar2, obj);
    }

    public final Flow<Result<d.q>> runCloudMultiFiles(c.a input, Object obj, String abilityId, String modelId) {
        kotlin.jvm.internal.g.f(input, "input");
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        return FlowKt.flow(new C03201(input, obj, abilityId, modelId, null));
    }

    public final Flow<Result<d.q>> runLocalMultiFiles(c.a input, e7.a protocol, Object obj) {
        kotlin.jvm.internal.g.f(input, "input");
        kotlin.jvm.internal.g.f(protocol, "protocol");
        return FlowKt.flow(new C03211(input, this, protocol, obj, null));
    }
}
