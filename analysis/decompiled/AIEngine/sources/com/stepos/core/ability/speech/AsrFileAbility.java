package com.stepos.core.ability.speech;

import android.content.Context;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.stepos.base.ability.AbilityBase;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.base.strategy.ExecutionPreference;
import com.stepos.base.strategy.OrchestrationRejectedException;
import com.stepos.core.ability.converter.AsrAudioFileDecoder;
import com.stepos.core.ability.speech.AsrLocalChunkedInferencer;
import com.stepos.core.ability.telemetry.ModelCallBridge;
import com.stepos.core.common.cloud.AccountLoginState;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import com.stepos.core.ota.process.OtaIdleExitPolicy;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import s6.b;
import v6.c;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrFileAbility extends AbilityBase<c.a, d.q> {
    public static final Companion Companion = new Companion(null);
    private static final String EVENT_RECOGNIZED = "asr.recognized";
    private static final String EXTRA_EVENT_TYPE = "asr.event_type";
    private static final String EXTRA_SEGMENT_END_MS = "asr.segment.end_ms";
    private static final String EXTRA_SEGMENT_INDEX = "asr.segment.index";
    private static final String EXTRA_SEGMENT_SPEAKER_ID = "asr.segment.speaker_id";
    private static final String EXTRA_SEGMENT_START_MS = "asr.segment.start_ms";
    private static final long VAD_GATE_MAX_DURATION_MS = 30000;
    private final String TAG;
    private final lb.d vadGate$delegate;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final long timeoutForDurationMs(long j10, long j11) {
            return j10 <= 0 ? j11 : dc.h.b0(j10 + HysteresisStrategy.DEFAULT_DWELL_MS, j11, OtaIdleExitPolicy.PAUSED_EXIT_MS);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.core.ability.speech.AsrFileAbility$buildOrchestrator$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements zb.a<Boolean> {
        public AnonymousClass1(Object obj) {
            super(0, obj, AccountLoginState.class, "isLoggedIn", "isLoggedIn()Z", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // zb.a
        public final Boolean invoke() {
            return Boolean.valueOf(((AccountLoginState) this.receiver).isLoggedIn());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrFileAbility$doFlowCloudInfer$2", f = "AsrFileAbility.kt", l = {208}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrFileAbility$doFlowCloudInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Result result = new Result(kotlin.c.a(new OrchestrationRejectedException(AIEngineError.CLOUD_ENDPOINT_NOT_CONFIGURED, "Cloud ASR not configured: cloud.enable is false in abilities.json")));
                this.label = 1;
                if (flowCollector.emit(result, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return lb.n.f10413a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrFileAbility$doFlowCloudInfer$3", f = "AsrFileAbility.kt", l = {226}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrFileAbility$doFlowCloudInfer$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ OrchestrationRejectedException $e;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(OrchestrationRejectedException orchestrationRejectedException, qb.b<? super AnonymousClass3> bVar) {
            super(2, bVar);
            this.$e = orchestrationRejectedException;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$e, bVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Result result = new Result(kotlin.c.a(this.$e));
                this.label = 1;
                if (flowCollector.emit(result, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return lb.n.f10413a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass3) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrFileAbility$doFlowCloudInfer$4", f = "AsrFileAbility.kt", l = {248, 248}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrFileAbility$doFlowCloudInfer$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ c.a $input;
        final /* synthetic */ Object $record;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(c.a aVar, Object obj, qb.b<? super AnonymousClass4> bVar) {
            super(2, bVar);
            this.$input = aVar;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass4 anonymousClass4 = AsrFileAbility.this.new AnonymousClass4(this.$input, this.$record, bVar);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
        
            if (r1.emit(r3, r6) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.c.b(r7)
                goto L4e
            L10:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L18:
                java.lang.Object r1 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r7)
                kotlin.Result r7 = (kotlin.Result) r7
                java.lang.Object r7 = r7.f9987a
                goto L3d
            L24:
                kotlin.c.b(r7)
                java.lang.Object r7 = r6.L$0
                r1 = r7
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                com.stepos.core.ability.speech.AsrFileAbility r7 = com.stepos.core.ability.speech.AsrFileAbility.this
                v6.c$a r4 = r6.$input
                java.lang.Object r5 = r6.$record
                r6.L$0 = r1
                r6.label = r3
                java.lang.Object r7 = r7.m42doCloudInfer0E7RQCE(r4, r5, r6)
                if (r7 != r0) goto L3d
                goto L4d
            L3d:
                kotlin.Result r3 = new kotlin.Result
                r3.<init>(r7)
                r7 = 0
                r6.L$0 = r7
                r6.label = r2
                java.lang.Object r6 = r1.emit(r3, r6)
                if (r6 != r0) goto L4e
            L4d:
                return r0
            L4e:
                lb.n r6 = lb.n.f10413a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFileAbility.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass4) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrFileAbility$doFlowCloudInfer$5", f = "AsrFileAbility.kt", l = {254}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrFileAbility$doFlowCloudInfer$5, reason: invalid class name */
    public static final class AnonymousClass5 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass5(qb.b<? super AnonymousClass5> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(bVar);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Result result = new Result(a0.a.r("stepos-asr-file accepts file path, audio URL, or multi-file batch only"));
                this.label = 1;
                if (flowCollector.emit(result, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return lb.n.f10413a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass5) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrFileAbility$doFlowInfer$2", f = "AsrFileAbility.kt", l = {TraceIdKeys.MAX_LENGTH, 137, 145, 146, 151, 158, 164, 169, 185}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrFileAbility$doFlowInfer$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03102 extends SuspendLambda implements zb.p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ c.a $input;
        final /* synthetic */ Object $record;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ AsrFileAbility this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03102(c.a aVar, AsrFileAbility asrFileAbility, Object obj, qb.b<? super C03102> bVar) {
            super(2, bVar);
            this.$input = aVar;
            this.this$0 = asrFileAbility;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C03102 c03102 = new C03102(this.$input, this.this$0, this.$record, bVar);
            c03102.L$0 = obj;
            return c03102;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x00bc, code lost:
        
            if (r9.emit(r3, r19) == r2) goto L99;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00ea, code lost:
        
            if (r0.collect(r3, r19) == r2) goto L99;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x028c, code lost:
        
            if (r4.emit(r3, r19) != r2) goto L100;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 11, insn: 0x006e: MOVE (r4 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:111), block:B:25:0x006e */
        /* JADX WARN: Removed duplicated region for block: B:56:0x014b  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x014d A[Catch: Exception -> 0x01a7, PHI: r0 r9 r10 r11 r12
          0x014d: PHI (r0v36 java.lang.String) = (r0v23 java.lang.String), (r0v46 java.lang.String) binds: [B:55:0x0149, B:23:0x0065] A[DONT_GENERATE, DONT_INLINE]
          0x014d: PHI (r9v10 kotlinx.coroutines.flow.FlowCollector) = (r9v3 kotlinx.coroutines.flow.FlowCollector), (r9v13 kotlinx.coroutines.flow.FlowCollector) binds: [B:55:0x0149, B:23:0x0065] A[DONT_GENERATE, DONT_INLINE]
          0x014d: PHI (r10v11 java.lang.String) = (r10v5 java.lang.String), (r10v16 java.lang.String) binds: [B:55:0x0149, B:23:0x0065] A[DONT_GENERATE, DONT_INLINE]
          0x014d: PHI (r11v9 v6.c$a) = (r11v4 v6.c$a), (r11v14 v6.c$a) binds: [B:55:0x0149, B:23:0x0065] A[DONT_GENERATE, DONT_INLINE]
          0x014d: PHI (r12v9 java.lang.Object) = (r12v7 java.lang.Object), (r12v15 java.lang.Object) binds: [B:55:0x0149, B:23:0x0065] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {Exception -> 0x01a7, blocks: (B:57:0x014d, B:59:0x0155, B:69:0x01b2, B:71:0x01ba, B:77:0x01de, B:81:0x01e8, B:87:0x0209, B:54:0x0130, B:45:0x00f1, B:48:0x0104, B:50:0x0112), top: B:104:0x00f1 }] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0155 A[Catch: Exception -> 0x01a7, TRY_LEAVE, TryCatch #1 {Exception -> 0x01a7, blocks: (B:57:0x014d, B:59:0x0155, B:69:0x01b2, B:71:0x01ba, B:77:0x01de, B:81:0x01e8, B:87:0x0209, B:54:0x0130, B:45:0x00f1, B:48:0x0104, B:50:0x0112), top: B:104:0x00f1 }] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01ab  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01ba A[Catch: Exception -> 0x01a7, TRY_LEAVE, TryCatch #1 {Exception -> 0x01a7, blocks: (B:57:0x014d, B:59:0x0155, B:69:0x01b2, B:71:0x01ba, B:77:0x01de, B:81:0x01e8, B:87:0x0209, B:54:0x0130, B:45:0x00f1, B:48:0x0104, B:50:0x0112), top: B:104:0x00f1 }] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x01de A[Catch: Exception -> 0x01a7, TRY_ENTER, TryCatch #1 {Exception -> 0x01a7, blocks: (B:57:0x014d, B:59:0x0155, B:69:0x01b2, B:71:0x01ba, B:77:0x01de, B:81:0x01e8, B:87:0x0209, B:54:0x0130, B:45:0x00f1, B:48:0x0104, B:50:0x0112), top: B:104:0x00f1 }] */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v2, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r4v21 */
        /* JADX WARN: Type inference failed for: r4v22 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v6 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instructions count: 682
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFileAbility.C03102.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C03102) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrFileAbility(p6.a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        kotlin.jvm.internal.g.f(abilityConfig, "abilityConfig");
        this.TAG = "AsrFileAbility";
        this.vadGate$delegate = kotlin.b.b(new a(2));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.core.ability.speech.AsrCloudConfig buildCloudConfig(java.lang.String r19) {
        /*
            r18 = this;
            r0 = r19
            p6.a r1 = r18.getAbilityConfig()
            boolean r2 = r1.f11424j
            java.util.Map<java.lang.String, p6.c> r3 = r1.f11426l
            r4 = 0
            if (r2 != 0) goto Le
            return r4
        Le:
            if (r0 == 0) goto L2a
            boolean r2 = gc.q.t0(r0)
            if (r2 != 0) goto L20
            java.lang.String r2 = "unknown"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L20
            r2 = r0
            goto L21
        L20:
            r2 = r4
        L21:
            if (r2 == 0) goto L2a
            boolean r5 = r3.containsKey(r2)
            if (r5 == 0) goto L2a
            goto L2b
        L2a:
            r2 = r4
        L2b:
            if (r2 == 0) goto L34
            java.lang.Object r2 = r3.get(r2)
            r4 = r2
            p6.c r4 = (p6.c) r4
        L34:
            com.stepos.core.ability.speech.AsrCloudConfig r5 = new com.stepos.core.ability.speech.AsrCloudConfig
            long r6 = r1.f11423i
            p6.c r2 = r1.f11425k
            p6.c r13 = r2.c(r4)
            java.lang.String r2 = ""
            java.lang.String r15 = r1.d(r0, r2)
            r16 = 46
            r17 = 0
            r8 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            r5.<init>(r6, r8, r10, r12, r13, r14, r15, r16, r17)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFileAbility.buildCloudConfig(java.lang.String):com.stepos.core.ability.speech.AsrCloudConfig");
    }

    public static /* synthetic */ AsrCloudConfig buildCloudConfig$default(AsrFileAbility asrFileAbility, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        return asrFileAbility.buildCloudConfig(str);
    }

    private final AsrFileCloudClient buildFileClient(String str) {
        AsrCloudConfig asrCloudConfigBuildCloudConfig = buildCloudConfig(str);
        if (asrCloudConfigBuildCloudConfig != null) {
            return new AsrFileCloudClient(asrCloudConfigBuildCloudConfig);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p6.c cloudFileParams() {
        return getAbilityConfig().f11425k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n doCloudInfer_0E7RQCE$lambda$14(String str, CloudSessionCorrelationState it) {
        kotlin.jvm.internal.g.f(it, "it");
        ModelCallBridge.INSTANCE.logEstablished(str, it);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n doCloudInfer_0E7RQCE$lambda$15(String str) {
        ModelCallBridge.INSTANCE.recordFirstToken(str);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c.a ensurePcmBuffer(c.a aVar) throws IOException {
        String str = aVar.f13389e;
        if (aVar.f13386b.length != 0) {
            return aVar;
        }
        if (str == null || gc.q.t0(str)) {
            return aVar;
        }
        ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(new File(str), 268435456);
        try {
            AsrAudioFileDecoder asrAudioFileDecoder = AsrAudioFileDecoder.INSTANCE;
            kotlin.jvm.internal.g.c(parcelFileDescriptorOpen);
            short[] sArrDecodeFromPfd = asrAudioFileDecoder.decodeFromPfd(parcelFileDescriptorOpen);
            parcelFileDescriptorOpen.close();
            return c.a.c(aVar, sArrDecodeFromPfd, null, null, null, null, 510);
        } finally {
        }
    }

    private final long fileLengthOf(String str) {
        Object objA;
        if (str == null) {
            return 0L;
        }
        try {
            objA = Long.valueOf(new File(str).length());
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = 0L;
        }
        return ((Number) objA).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VadGate getVadGate() {
        return (VadGate) this.vadGate$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01a8, code lost:
    
        if (r0 == r3) goto L70;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fc A[Catch: Exception -> 0x0122, TRY_LEAVE, TryCatch #6 {Exception -> 0x0122, blocks: (B:46:0x00f4, B:48:0x00fc), top: B:86:0x00f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0148 A[Catch: Exception -> 0x0154, TryCatch #4 {Exception -> 0x0154, blocks: (B:71:0x01ab, B:58:0x0142, B:60:0x0148, B:64:0x0157, B:66:0x0164, B:68:0x016c), top: B:83:0x0142 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0157 A[Catch: Exception -> 0x0154, TryCatch #4 {Exception -> 0x0154, blocks: (B:71:0x01ab, B:58:0x0142, B:60:0x0148, B:64:0x0157, B:66:0x0164, B:68:0x016c), top: B:83:0x0142 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* renamed from: inferSingleLocal-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m40inferSingleLocalgIAlus(v6.c.a r19, qb.b<? super kotlin.Result<v6.d.q>> r20) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFileAbility.m40inferSingleLocalgIAlus(v6.c$a, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* renamed from: recognizeLocalFileOnce-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m41recognizeLocalFileOnceyxL6bBk(v6.c.a r9, java.lang.String r10, java.lang.Object r11, e7.a r12, qb.b<? super kotlin.Result<com.stepos.core.ability.speech.AsrFileResult>> r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof com.stepos.core.ability.speech.AsrFileAbility$recognizeLocalFileOnce$1
            if (r0 == 0) goto L14
            r0 = r13
            com.stepos.core.ability.speech.AsrFileAbility$recognizeLocalFileOnce$1 r0 = (com.stepos.core.ability.speech.AsrFileAbility$recognizeLocalFileOnce$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r13 = r0
            goto L1a
        L14:
            com.stepos.core.ability.speech.AsrFileAbility$recognizeLocalFileOnce$1 r0 = new com.stepos.core.ability.speech.AsrFileAbility$recognizeLocalFileOnce$1
            r0.<init>(r8, r13)
            goto L12
        L1a:
            java.lang.Object r8 = r13.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r13.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L38
            if (r1 == r3) goto L28
            if (r1 != r2) goto L30
        L28:
            kotlin.c.b(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r8 = r8.f9987a
            return r8
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            kotlin.c.b(r8)
            r5 = r10
            java.lang.String r10 = r9.f13389e
            if (r10 == 0) goto L46
            boolean r8 = gc.q.t0(r10)
            if (r8 == 0) goto L4a
        L46:
            r8 = r2
            r2 = r12
            r12 = r11
            goto L59
        L4a:
            com.stepos.core.ability.speech.AsrLocalFileInferencer r8 = com.stepos.core.ability.speech.AsrLocalFileInferencer.INSTANCE
            r13.label = r3
            r9 = r12
            r12 = r11
            r11 = r5
            java.lang.Object r8 = r8.m54recognizeFileyxL6bBk(r9, r10, r11, r12, r13)
            if (r8 != r0) goto L58
            goto L69
        L58:
            return r8
        L59:
            com.stepos.core.ability.speech.AsrLocalFileInferencer r1 = com.stepos.core.ability.speech.AsrLocalFileInferencer.INSTANCE
            short[] r3 = r9.f13386b
            int r4 = r9.f13387c
            r13.label = r8
            r6 = r12
            r7 = r13
            java.lang.Object r8 = r1.m55recognizePcmSegmentshUnOzRk(r2, r3, r4, r5, r6, r7)
            if (r8 != r0) goto L6a
        L69:
            return r0
        L6a:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFileAbility.m41recognizeLocalFileOnceyxL6bBk(v6.c$a, java.lang.String, java.lang.Object, e7.a, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e7.a requireAudioProtocol() {
        return (e7.a) getProtocolManager().b(ProtocolType.f6380c);
    }

    private final String sanitizeUrl(String str) {
        return gc.q.K0(str, "?");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldRunVadGate(c.a aVar, c.a aVar2) {
        String str;
        int i10;
        if (aVar.d()) {
            return false;
        }
        String str2 = aVar2.f13389e;
        if ((str2 != null && !gc.q.t0(str2)) || ((str = aVar.f13389e) != null && !gc.q.t0(str))) {
            return false;
        }
        short[] sArr = aVar2.f13386b;
        return sArr.length != 0 && (i10 = aVar2.f13387c) > 0 && (((long) sArr.length) * 1000) / ((long) i10) <= 30000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.q toRecognizedSegmentOutput(AsrLocalChunkedInferencer.ChunkEvent chunkEvent) {
        Bundle bundle = new Bundle();
        bundle.putString("asr.event_type", "asr.recognized");
        bundle.putInt("asr.segment.index", chunkEvent.getSegmentIndex());
        bundle.putLong("asr.segment.start_ms", chunkEvent.getStartMs());
        bundle.putLong("asr.segment.end_ms", chunkEvent.getEndMs());
        bundle.putString("asr.segment.speaker_id", "");
        return new d.q(chunkEvent.getText(), null, bundle, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VadGate vadGate_delegate$lambda$8() {
        Context context = l7.a.f10344a;
        if (context != null) {
            return new VadGate(context);
        }
        throw new IllegalStateException("ContextHolder must be initialized before use!");
    }

    @Override // com.stepos.base.ability.AbilityBase, p6.d
    public Object acquire(qb.b<? super Boolean> bVar) {
        if (!getAbilityConfig().f11424j) {
            return super.acquire(bVar);
        }
        AIEngineLogger.i(LogModule.ABILITY, this.TAG, "acquire: defer on-device model load (cloud-first, lazy per S4)");
        return Boolean.TRUE;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public h7.d buildOrchestrator() {
        return new AsrOrchestrator(getAbilityConfig().c(), getAbilityConfig().f11424j, new AnonymousClass1(AccountLoginState.INSTANCE));
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doCloudInfer-0E7RQCE */
    public /* bridge */ /* synthetic */ Object mo17doCloudInfer0E7RQCE(v6.c cVar, Object obj, qb.b bVar) {
        return m42doCloudInfer0E7RQCE((c.a) cVar, obj, (qb.b<? super Result<d.q>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowCloudInfer(v6.c cVar, Object obj, qb.b bVar) {
        return doFlowCloudInfer((c.a) cVar, obj, (qb.b<? super Flow<Result<d.q>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(v6.c cVar, Object obj, qb.b bVar) {
        return doFlowInfer((c.a) cVar, obj, (qb.b<? super Flow<Result<d.q>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(v6.c cVar, qb.b bVar) {
        return m43doInfergIAlus((c.a) cVar, (qb.b<? super Result<d.q>>) bVar);
    }

    public final Object ensureLocalReady(qb.b<? super Boolean> bVar) {
        if (requireAudioProtocol() != null) {
            return Boolean.TRUE;
        }
        Context context = l7.a.f10344a;
        if (context != null) {
            return internalPrepare(context, bVar);
        }
        throw new IllegalStateException("ContextHolder must be initialized before use!");
    }

    @Override // com.stepos.base.ability.AbilityBase
    public h7.b getExecutionConstraints(v6.c input) {
        String str;
        kotlin.jvm.internal.g.f(input, "input");
        c.a aVar = input instanceof c.a ? (c.a) input : null;
        if (aVar == null) {
            return h7.b.f9362d;
        }
        h7.b bVar = h7.b.f9362d;
        String str2 = aVar.f13388d;
        return (str2 == null || gc.q.t0(str2) || !(((str = aVar.f13389e) == null || gc.q.t0(str)) && aVar.f13386b.length == 0)) ? h7.b.a(bVar, aVar.f13391g) : h7.b.a(bVar, ExecutionPreference.f6388c);
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return true;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public long cloudExecutionTimeoutMs(c.a input) {
        kotlin.jvm.internal.g.f(input, "input");
        String str = input.f13389e;
        List<c.b> list = input.f13390f;
        long j10 = 0;
        if (list == null || list.isEmpty()) {
            return (str == null || gc.q.t0(str)) ? b.a.a(0L).f11896c : b.a.a(fileLengthOf(str)).f11896c;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            j10 += b.a.a(fileLengthOf(((c.b) it.next()).f13394a)).f11896c;
        }
        return j10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.base.ability.AbilityBase
    public d.q defaultOutput() {
        return new d.q("", null, 0 == true ? 1 : 0, 6);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* renamed from: doCloudInfer-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m42doCloudInfer0E7RQCE(v6.c.a r34, java.lang.Object r35, qb.b<? super kotlin.Result<v6.d.q>> r36) {
        /*
            Method dump skipped, instructions count: 892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFileAbility.m42doCloudInfer0E7RQCE(v6.c$a, java.lang.Object, qb.b):java.lang.Object");
    }

    public Object doFlowCloudInfer(c.a aVar, Object obj, qb.b<? super Flow<Result<d.q>>> bVar) {
        String str = aVar.f13393j;
        String str2 = aVar.f13388d;
        String str3 = aVar.f13389e;
        if (str.length() == 0) {
            str = "?";
        }
        List<c.b> list = aVar.f13390f;
        int size = (list == null || list.isEmpty()) ? ((str3 == null || gc.q.t0(str3)) && (str2 == null || gc.q.t0(str2))) ? 0 : 1 : list.size();
        LogModule logModule = LogModule.ABILITY;
        String str4 = this.TAG;
        boolean zD = aVar.d();
        boolean z = !(str2 == null || gc.q.t0(str2));
        String strS0 = str3 != null ? gc.r.S0(48, str3) : null;
        StringBuilder sbM = com.stepos.core.ota.d.m("[ASR-FILE] inferId=", str, " stage=ROUTE enter isMultiFiles=", " fileCount=", zD);
        sbM.append(size);
        sbM.append(" hasAudioUrl=");
        sbM.append(z);
        sbM.append(" localPath=");
        a0.a.z(sbM, strS0, logModule, str4);
        if (buildCloudConfig$default(this, null, 1, null) == null) {
            AIEngineLogger.w(logModule, this.TAG, "[ASR-FILE] inferId=" + str + " stage=ROUTE reject reason=cloud.enable=false");
            return FlowKt.flow(new AnonymousClass2(null));
        }
        if (!aVar.d()) {
            if ((str3 == null || gc.q.t0(str3)) && (str2 == null || gc.q.t0(str2))) {
                AIEngineLogger.w(logModule, this.TAG, "[ASR-FILE] inferId=" + str + " stage=ROUTE reject reason=not_a_file_input");
                return FlowKt.flow(new AnonymousClass5(null));
            }
            AIEngineLogger.i(logModule, this.TAG, "[ASR-FILE] inferId=" + str + " stage=ROUTE route=FileAPI");
            return FlowKt.flow(new AnonymousClass4(aVar, obj, null));
        }
        AIEngineLogger.i(logModule, this.TAG, "[ASR-FILE] inferId=" + str + " stage=ROUTE route=AsrMultiFilesPipeline");
        String str5 = ModelCallBridge.INSTANCE.callerFromRecord(obj).f9986b;
        try {
            CloudSceneTypeGuard.require$default(CloudSceneTypeGuard.INSTANCE, getAbilityConfig(), str5, null, 4, null);
            AsrFileCloudClient asrFileCloudClientBuildFileClient = buildFileClient(str5);
            if (asrFileCloudClientBuildFileClient == null) {
                return FlowKt.flow(new AsrFileAbility$doFlowCloudInfer$client$1(null));
            }
            AsrMultiFilesPipeline asrMultiFilesPipeline = new AsrMultiFilesPipeline(asrFileCloudClientBuildFileClient, cloudFileParams(), getAbilityConfig().f11428n);
            String str6 = getAbilityConfig().f11416a;
            b7.k kVar = (b7.k) kotlin.collections.a.v0(getAbilityConfig().f11419d);
            String str7 = kVar != null ? kVar.f3090a : null;
            if (str7 == null) {
                str7 = "";
            }
            return asrMultiFilesPipeline.runCloudMultiFiles(aVar, obj, str6, str7);
        } catch (OrchestrationRejectedException e10) {
            return FlowKt.flow(new AnonymousClass3(e10, null));
        }
    }

    public Object doFlowInfer(c.a aVar, Object obj, qb.b<? super Flow<Result<d.q>>> bVar) {
        return FlowKt.flow(new C03102(aVar, this, obj, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m43doInfergIAlus(v6.c.a r5, qb.b<? super kotlin.Result<v6.d.q>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.core.ability.speech.AsrFileAbility$doInfer$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.core.ability.speech.AsrFileAbility$doInfer$1 r0 = (com.stepos.core.ability.speech.AsrFileAbility$doInfer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.AsrFileAbility$doInfer$1 r0 = new com.stepos.core.ability.speech.AsrFileAbility$doInfer$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.c.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r4 = r6.f9987a
            return r4
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.c.b(r6)
            boolean r6 = r5.d()
            if (r6 == 0) goto L43
            java.lang.String r4 = "Multi-file ASR must use streaming infer() Flow path"
            kotlin.Result$Failure r4 = a0.a.r(r4)
            return r4
        L43:
            r0.label = r3
            java.lang.Object r4 = r4.m40inferSingleLocalgIAlus(r5, r0)
            if (r4 != r1) goto L4c
            return r1
        L4c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFileAbility.m43doInfergIAlus(v6.c$a, qb.b):java.lang.Object");
    }

    @Override // com.stepos.base.ability.AbilityBase
    public long localExecutionTimeoutMs(c.a input, long j10) {
        kotlin.jvm.internal.g.f(input, "input");
        List<c.b> list = input.f13390f;
        String str = input.f13389e;
        long jProbeDurationMs = 0;
        if (list != null && !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                jProbeDurationMs += AsrAudioFileDecoder.INSTANCE.probeDurationMs(((c.b) it.next()).f13394a);
            }
        } else if (str != null && !gc.q.t0(str)) {
            jProbeDurationMs = AsrAudioFileDecoder.INSTANCE.probeDurationMs(str);
        }
        return Companion.timeoutForDurationMs(jProbeDurationMs, j10);
    }
}
