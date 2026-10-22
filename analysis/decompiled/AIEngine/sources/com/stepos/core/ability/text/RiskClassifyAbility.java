package com.stepos.core.ability.text;

import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.scp.moderation.crypto.WordJsonCodec;
import com.scp.moderation.crypto.model.SensitiveWord;
import com.stepos.base.ability.AbilityBase;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import gc.q;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import v6.c;
import v6.d;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RiskClassifyAbility extends AbilityBase<c.g, d.q> {
    private final String tag;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ScpAuditRuntime {
        private static final String DECISION_BLOCK = "BLOCK";
        private static final String DECISION_PASS = "PASS";
        private static boolean initialized;
        public static final ScpAuditRuntime INSTANCE = new ScpAuditRuntime();
        private static final Object lock = new Object();

        private ScpAuditRuntime() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map checkText$lambda$2$lambda$0(l lVar, String str) {
            g.c(str);
            try {
                b3.d dVarF = r5.b.f11730a.g((String) lVar.invoke(str)).f("model_result");
                if (dVarF == null || !(dVarF instanceof ObjectNode)) {
                    throw new IllegalArgumentException("missing model_result object");
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator<Map.Entry<String, b3.d>> itD = dVarF.d();
                while (itD.hasNext()) {
                    Map.Entry<String, b3.d> next = itD.next();
                    b3.d value = next.getValue();
                    b3.d dVarF2 = value.f("pass");
                    b3.d dVarF3 = value.f("block");
                    if (dVarF2 != null && dVarF3 != null) {
                        JsonNodeType jsonNodeTypeG = dVarF2.g();
                        JsonNodeType jsonNodeType = JsonNodeType.h;
                        if (jsonNodeTypeG == jsonNodeType) {
                            if (dVarF3.g() == jsonNodeType) {
                                linkedHashMap.put(next.getKey(), new r5.a(dVarF2.e(), dVarF3.e()));
                            }
                        }
                    }
                    throw new IllegalArgumentException("invalid head score: head=" + next.getKey());
                }
                return linkedHashMap;
            } catch (IllegalArgumentException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new IllegalArgumentException("invalid model result json", e11);
            }
        }

        private final void ensureInitialized() throws Throwable {
            byte[] bArrA;
            if (initialized) {
                return;
            }
            InputStream resourceAsStream = n5.a.class.getResourceAsStream("/words.bin");
            if (resourceAsStream == null) {
                throw new IllegalStateException("words.bin not found in scp-audit jar");
            }
            try {
                byte[] bArrE = jd.b.E(resourceAsStream);
                resourceAsStream.close();
                ud.a aVar = n5.a.f10636a;
                long jNanoTime = System.nanoTime();
                try {
                    try {
                        bArrA = com.scp.moderation.crypto.a.a(bArrE);
                        try {
                            List<SensitiveWord> listA = WordJsonCodec.a(bArrA);
                            Arrays.fill(bArrA, (byte) 0);
                            s5.b bVarA = n5.a.a(listA);
                            synchronized (n5.a.f10638c) {
                                n5.a.f10639d = bVarA;
                                n5.a.f10640e = listA;
                            }
                            n5.a.f10636a.c(Integer.valueOf(listA.size()), Long.valueOf((System.nanoTime() - jNanoTime) / 1000000));
                            initialized = true;
                        } catch (Throwable th) {
                            th = th;
                            if (bArrA != null) {
                                Arrays.fill(bArrA, (byte) 0);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bArrA = null;
                    }
                } catch (Exception e10) {
                    n5.a.f10636a.a(e10.getClass().getSimpleName());
                    throw new IllegalStateException("ContentModerator.init failed");
                }
            } finally {
            }
        }

        public final String checkText(String text, l<? super String, String> modelInvoker) {
            String upperCase;
            g.f(text, "text");
            g.f(modelInvoker, "modelInvoker");
            synchronized (lock) {
                INSTANCE.ensureInitialized();
                r5.b.f11731b = new c(modelInvoker);
                try {
                    String string = q.L0(n5.a.b(text).f10641a).toString();
                    if (string != null) {
                        upperCase = string.toUpperCase(Locale.ROOT);
                        g.e(upperCase, "toUpperCase(...)");
                    } else {
                        upperCase = null;
                    }
                    if (upperCase == null) {
                        upperCase = "";
                    }
                    if (!upperCase.equals(DECISION_PASS) && !upperCase.equals(DECISION_BLOCK)) {
                        throw new IllegalArgumentException("unexpected risk decision: ".concat(upperCase).toString());
                    }
                } finally {
                    r5.b.f11731b = null;
                }
            }
            return upperCase;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.text.RiskClassifyAbility$doFlowInfer$2", f = "RiskClassifyAbility.kt", l = {ErrorCodes.CALLBACK_RECYCLE_ERROR, 60}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.text.RiskClassifyAbility$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super n>, Object> {
        final /* synthetic */ c.g $input;
        final /* synthetic */ Object $record;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ RiskClassifyAbility this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, RiskClassifyAbility riskClassifyAbility, c.g gVar, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$record = obj;
            this.this$0 = riskClassifyAbility;
            this.$input = gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$record, this.this$0, this.$input, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
        
            if (r7.emit(r1, r10) == r0) goto L34;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r10.label
                r2 = 0
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L2f
                if (r1 == r4) goto L1b
                if (r1 != r3) goto L13
                kotlin.c.b(r11)
                goto L98
            L13:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L1b:
                java.lang.Object r1 = r10.L$2
                java.util.concurrent.atomic.AtomicBoolean r1 = (java.util.concurrent.atomic.AtomicBoolean) r1
                java.lang.Object r6 = r10.L$1
                java.lang.String r6 = (java.lang.String) r6
                java.lang.Object r7 = r10.L$0
                kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                kotlin.c.b(r11)
                kotlin.Result r11 = (kotlin.Result) r11
                java.lang.Object r11 = r11.f9987a
                goto L73
            L2f:
                kotlin.c.b(r11)
                java.lang.Object r11 = r10.L$0
                r7 = r11
                kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                java.lang.Object r11 = r10.$record
                boolean r1 = r11 instanceof com.stepos.core.model.task.AITaskRecord
                if (r1 == 0) goto L40
                com.stepos.core.model.task.AITaskRecord r11 = (com.stepos.core.model.task.AITaskRecord) r11
                goto L41
            L40:
                r11 = r5
            L41:
                if (r11 == 0) goto L51
                java.lang.String r11 = r11.getId()
                if (r11 == 0) goto L51
                boolean r1 = gc.q.t0(r11)
                if (r1 != 0) goto L51
                r6 = r11
                goto L52
            L51:
                r6 = r5
            L52:
                if (r6 == 0) goto L59
                com.stepos.core.ability.telemetry.ModelCallBridge r11 = com.stepos.core.ability.telemetry.ModelCallBridge.INSTANCE
                r11.logModelReady(r6)
            L59:
                java.util.concurrent.atomic.AtomicBoolean r1 = new java.util.concurrent.atomic.AtomicBoolean
                r1.<init>(r2)
                com.stepos.core.ability.text.RiskClassifyAbility r11 = r10.this$0
                v6.c$g r8 = r10.$input
                java.lang.Object r9 = r10.$record
                r10.L$0 = r7
                r10.L$1 = r6
                r10.L$2 = r1
                r10.label = r4
                java.lang.Object r11 = com.stepos.core.ability.text.RiskClassifyAbility.m68access$moderate0E7RQCE(r11, r8, r9, r10)
                if (r11 != r0) goto L73
                goto L97
            L73:
                boolean r8 = r11 instanceof kotlin.Result.Failure
                if (r8 != 0) goto L84
                if (r6 == 0) goto L84
                boolean r1 = r1.compareAndSet(r2, r4)
                if (r1 == 0) goto L84
                com.stepos.core.ability.telemetry.ModelCallBridge r1 = com.stepos.core.ability.telemetry.ModelCallBridge.INSTANCE
                r1.recordFirstToken(r6)
            L84:
                kotlin.Result r1 = new kotlin.Result
                r1.<init>(r11)
                r10.L$0 = r5
                r10.L$1 = r5
                r10.L$2 = r5
                r10.label = r3
                java.lang.Object r10 = r7.emit(r1, r10)
                if (r10 != r0) goto L98
            L97:
                return r0
            L98:
                lb.n r10 = lb.n.f10413a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.RiskClassifyAbility.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.text.RiskClassifyAbility", f = "RiskClassifyAbility.kt", l = {95, 95}, m = "inferModel")
    /* renamed from: com.stepos.core.ability.text.RiskClassifyAbility$inferModel$1, reason: invalid class name */
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
            return RiskClassifyAbility.this.inferModel(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RiskClassifyAbility(p6.a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        g.f(abilityConfig, "abilityConfig");
        this.tag = "RiskClassifyAbility";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0071, code lost:
    
        if (((kotlinx.coroutines.flow.Flow) r9).collect(r7, r0) == r1) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object inferModel(v6.c.g r7, java.lang.Object r8, qb.b<? super java.lang.String> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.stepos.core.ability.text.RiskClassifyAbility.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.core.ability.text.RiskClassifyAbility$inferModel$1 r0 = (com.stepos.core.ability.text.RiskClassifyAbility.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.text.RiskClassifyAbility$inferModel$1 r0 = new com.stepos.core.ability.text.RiskClassifyAbility$inferModel$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref$ObjectRef) r6
            kotlin.c.b(r9)
            goto L74
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            java.lang.Object r6 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref$ObjectRef) r6
            kotlin.c.b(r9)
            goto L62
        L3e:
            kotlin.c.b(r9)
            e7.e r6 = r6.getProtocolManager()
            com.stepos.base.protocol.ProtocolType r9 = com.stepos.base.protocol.ProtocolType.f6378a
            e7.b r6 = r6.b(r9)
            e7.h r6 = (e7.h) r6
            if (r6 == 0) goto L83
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef
            r9.<init>()
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r6 = r6.processText(r7, r8, r0)
            if (r6 != r1) goto L5f
            goto L73
        L5f:
            r5 = r9
            r9 = r6
            r6 = r5
        L62:
            kotlinx.coroutines.flow.Flow r9 = (kotlinx.coroutines.flow.Flow) r9
            com.stepos.core.ability.text.RiskClassifyAbility$inferModel$2 r7 = new com.stepos.core.ability.text.RiskClassifyAbility$inferModel$2
            r7.<init>()
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r9.collect(r7, r0)
            if (r7 != r1) goto L74
        L73:
            return r1
        L74:
            T r6 = r6.f10076a
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L7b
            return r6
        L7b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "RiskClassify result is null"
            r6.<init>(r7)
            throw r6
        L83:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "RiskClassify text protocol is unavailable"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.RiskClassifyAbility.inferModel(v6.c$g, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: moderate-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m69moderate0E7RQCE(v6.c.g r11, java.lang.Object r12, qb.b<? super kotlin.Result<v6.d.q>> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.stepos.core.ability.text.RiskClassifyAbility$moderate$1
            if (r0 == 0) goto L13
            r0 = r13
            com.stepos.core.ability.text.RiskClassifyAbility$moderate$1 r0 = (com.stepos.core.ability.text.RiskClassifyAbility$moderate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.text.RiskClassifyAbility$moderate$1 r0 = new com.stepos.core.ability.text.RiskClassifyAbility$moderate$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r10 = r0.L$0
            com.stepos.core.ability.text.RiskClassifyAbility r10 = (com.stepos.core.ability.text.RiskClassifyAbility) r10
            kotlin.c.b(r13)     // Catch: java.lang.Exception -> L2b
            goto L88
        L2b:
            r0 = move-exception
        L2c:
            r11 = r0
            goto L99
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            kotlin.c.b(r13)
            java.lang.String r13 = r11.f13416b
            boolean r13 = gc.q.t0(r13)
            if (r13 == 0) goto L49
            java.lang.String r10 = "text is empty"
            kotlin.Result$Failure r10 = ai.onnxruntime.a.t(r10)
            return r10
        L49:
            kotlin.coroutines.d r13 = r0.getContext()     // Catch: java.lang.Exception -> L96
            com.stepos.base.concurrency.cpuset.a$a r2 = com.stepos.base.concurrency.cpuset.a.f6212b     // Catch: java.lang.Exception -> L96
            kotlin.coroutines.d$a r13 = r13.get(r2)     // Catch: java.lang.Exception -> L96
            com.stepos.base.concurrency.cpuset.a r13 = (com.stepos.base.concurrency.cpuset.a) r13     // Catch: java.lang.Exception -> L96
            kotlin.coroutines.d r2 = r0.getContext()     // Catch: java.lang.Exception -> L96
            com.stepos.core.common.telemetry.TrackerContext$Key r4 = com.stepos.core.common.telemetry.TrackerContext.Key     // Catch: java.lang.Exception -> L96
            kotlin.coroutines.d$a r2 = r2.get(r4)     // Catch: java.lang.Exception -> L96
            com.stepos.core.common.telemetry.TrackerContext r2 = (com.stepos.core.common.telemetry.TrackerContext) r2     // Catch: java.lang.Exception -> L96
            if (r13 == 0) goto L64
            goto L66
        L64:
            kotlin.coroutines.EmptyCoroutineContext r13 = kotlin.coroutines.EmptyCoroutineContext.f10057a     // Catch: java.lang.Exception -> L96
        L66:
            if (r2 == 0) goto L69
            goto L6b
        L69:
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.f10057a     // Catch: java.lang.Exception -> L96
        L6b:
            kotlin.coroutines.d r6 = r13.plus(r2)     // Catch: java.lang.Exception -> L96
            kotlinx.coroutines.CoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L96
            com.stepos.core.ability.text.RiskClassifyAbility$moderate$decision$1 r4 = new com.stepos.core.ability.text.RiskClassifyAbility$moderate$decision$1     // Catch: java.lang.Exception -> L96
            r9 = 0
            r7 = r10
            r5 = r11
            r8 = r12
            r4.<init>(r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L92
            r0.L$0 = r7     // Catch: java.lang.Exception -> L92
            r0.label = r3     // Catch: java.lang.Exception -> L92
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.withContext(r13, r4, r0)     // Catch: java.lang.Exception -> L92
            if (r13 != r1) goto L87
            return r1
        L87:
            r10 = r7
        L88:
            java.lang.String r13 = (java.lang.String) r13     // Catch: java.lang.Exception -> L2b
            v6.d$q r11 = new v6.d$q     // Catch: java.lang.Exception -> L2b
            r12 = 6
            r0 = 0
            r11.<init>(r13, r0, r0, r12)     // Catch: java.lang.Exception -> L2b
            return r11
        L92:
            r0 = move-exception
            r11 = r0
            r10 = r7
            goto L99
        L96:
            r0 = move-exception
            r7 = r10
            goto L2c
        L99:
            com.stepos.core.common.log.LogModule r12 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r10 = r10.tag
            java.lang.String r13 = "moderate failed"
            com.stepos.core.common.log.AIEngineLogger.e(r12, r10, r13, r11)
            kotlin.Result$Failure r10 = kotlin.c.a(r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.RiskClassifyAbility.m69moderate0E7RQCE(v6.c$g, java.lang.Object, qb.b):java.lang.Object");
    }

    @Override // com.stepos.base.ability.AbilityBase
    public /* bridge */ /* synthetic */ Object doFlowInfer(v6.c cVar, Object obj, qb.b bVar) {
        return doFlowInfer((c.g) cVar, obj, (qb.b<? super Flow<Result<d.q>>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-0E7RQCE */
    public /* bridge */ /* synthetic */ Object mo18doInfer0E7RQCE(v6.c cVar, Object obj, qb.b bVar) {
        return m70doInfer0E7RQCE((c.g) cVar, obj, (qb.b<? super Result<d.q>>) bVar);
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo19doInfergIAlus(v6.c cVar, qb.b bVar) {
        return m71doInfergIAlus((c.g) cVar, (qb.b<? super Result<d.q>>) bVar);
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.base.ability.AbilityBase
    public d.q defaultOutput() {
        return new d.q("", null, 0 == true ? 1 : 0, 6);
    }

    public Object doFlowInfer(c.g gVar, Object obj, qb.b<? super Flow<Result<d.q>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(obj, this, gVar, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m70doInfer0E7RQCE(v6.c.g r5, java.lang.Object r6, qb.b<? super kotlin.Result<v6.d.q>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.core.ability.text.RiskClassifyAbility$doInfer$2
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.core.ability.text.RiskClassifyAbility$doInfer$2 r0 = (com.stepos.core.ability.text.RiskClassifyAbility$doInfer$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.text.RiskClassifyAbility$doInfer$2 r0 = new com.stepos.core.ability.text.RiskClassifyAbility$doInfer$2
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.c.b(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r4 = r7.f9987a
            return r4
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.c.b(r7)
            r0.label = r3
            java.lang.Object r4 = r4.m69moderate0E7RQCE(r5, r6, r0)
            if (r4 != r1) goto L3f
            return r1
        L3f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.RiskClassifyAbility.m70doInfer0E7RQCE(v6.c$g, java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doInfer-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m71doInfergIAlus(v6.c.g r5, qb.b<? super kotlin.Result<v6.d.q>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.core.ability.text.RiskClassifyAbility$doInfer$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.core.ability.text.RiskClassifyAbility$doInfer$1 r0 = (com.stepos.core.ability.text.RiskClassifyAbility$doInfer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.text.RiskClassifyAbility$doInfer$1 r0 = new com.stepos.core.ability.text.RiskClassifyAbility$doInfer$1
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
            r0.label = r3
            r6 = 0
            java.lang.Object r4 = r4.m70doInfer0E7RQCE(r5, r6, r0)
            if (r4 != r1) goto L40
            return r1
        L40:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.RiskClassifyAbility.m71doInfergIAlus(v6.c$g, qb.b):java.lang.Object");
    }
}
