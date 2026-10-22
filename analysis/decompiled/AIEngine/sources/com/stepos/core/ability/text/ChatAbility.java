package com.stepos.core.ability.text;

import com.stepos.base.ability.AbilityBase;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.model.bridge.NativeChatBridge;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import v6.d;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ChatAbility extends AbilityBase<v6.c, d.q> {
    public static final Companion Companion = new Companion(null);
    private final String TAG;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final void onSessionPurged(int i10, String name) {
            g.f(name, "name");
            LogModule logModule = LogModule.ABILITY;
            AIEngineLogger.d(logModule, "ChatAbility", a0.a.g("onSessionPurged: uid=", i10, ", name=", name));
            try {
                if (NativeChatBridge.INSTANCE.resetChat()) {
                    return;
                }
                AIEngineLogger.w(logModule, "ChatAbility", "nativeResetChat failed");
            } catch (Exception e10) {
                AIEngineLogger.e(LogModule.ABILITY, "ChatAbility", "nativeResetChat exception: " + e10.getMessage(), e10);
            }
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.text.ChatAbility$doFlowInfer$2", f = "ChatAbility.kt", l = {63, 65, 95, 99, 99, 138, 186, 191, 191, 239}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.text.ChatAbility$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super n>, Object> {
        final /* synthetic */ v6.c $input;
        final /* synthetic */ Object $record;
        int I$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ ChatAbility this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(v6.c cVar, ChatAbility chatAbility, Object obj, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$input = cVar;
            this.this$0 = chatAbility;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$input, this.this$0, this.$record, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:174:0x04f9, code lost:
        
            if (r0.collect(r5, r24) == r2) goto L207;
         */
        /* JADX WARN: Code restructure failed: missing block: B:190:0x05a7, code lost:
        
            if (r9.emit(r0, r24) == r2) goto L191;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x01ae, code lost:
        
            if (r9.emit(r0, r24) == r2) goto L191;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 3, insn: 0x00c7: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:200), block:B:41:0x00c7 */
        /* JADX WARN: Removed duplicated region for block: B:173:0x04e0 A[Catch: Exception -> 0x04fd, CancellationException -> 0x0503, TRY_LEAVE, TryCatch #18 {CancellationException -> 0x0503, Exception -> 0x04fd, blocks: (B:171:0x04dc, B:173:0x04e0), top: B:215:0x04dc }] */
        /* JADX WARN: Removed duplicated region for block: B:214:0x01b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x017b  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0284 A[Catch: all -> 0x00c6, Exception -> 0x00ca, CancellationException -> 0x00cd, TryCatch #2 {Exception -> 0x00ca, blocks: (B:95:0x02a2, B:97:0x02e1, B:88:0x0280, B:90:0x0284, B:38:0x00c1, B:81:0x0264), top: B:200:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:97:0x02e1 A[Catch: all -> 0x00c6, Exception -> 0x00ca, CancellationException -> 0x00cd, TRY_LEAVE, TryCatch #2 {Exception -> 0x00ca, blocks: (B:95:0x02a2, B:97:0x02e1, B:88:0x0280, B:90:0x0284, B:38:0x00c1, B:81:0x0264), top: B:200:0x000d }] */
        /* JADX WARN: Type inference failed for: r10v11 */
        /* JADX WARN: Type inference failed for: r10v32, types: [java.lang.Object, java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r10v33 */
        /* JADX WARN: Type inference failed for: r12v0 */
        /* JADX WARN: Type inference failed for: r12v18 */
        /* JADX WARN: Type inference failed for: r12v19 */
        /* JADX WARN: Type inference failed for: r12v2, types: [kotlin.jvm.internal.Ref$IntRef] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v11, types: [com.stepos.core.ability.text.ServerSession] */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v6, types: [com.stepos.core.ability.text.ServerSession] */
        /* JADX WARN: Type inference failed for: r1v7, types: [com.stepos.core.ability.text.ServerSession] */
        /* JADX WARN: Type inference failed for: r3v24 */
        /* JADX WARN: Type inference failed for: r3v25 */
        /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r3v58 */
        /* JADX WARN: Type inference failed for: r3v59 */
        /* JADX WARN: Type inference failed for: r3v61 */
        /* JADX WARN: Type inference failed for: r3v65 */
        /* JADX WARN: Type inference failed for: r3v69 */
        /* JADX WARN: Type inference failed for: r3v70 */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v1, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r6v24 */
        /* JADX WARN: Type inference failed for: r6v27 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 1524
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.ChatAbility.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatAbility(p6.a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        g.f(abilityConfig, "abilityConfig");
        this.TAG = "ChatAbility";
    }

    public static final void onSessionPurged(int i10, String str) {
        Companion.onSessionPurged(i10, str);
    }

    @Override // com.stepos.base.ability.AbilityBase
    public Object doFlowInfer(v6.c cVar, Object obj, qb.b<? super Flow<Result<d.q>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(cVar, this, obj, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public Object mo19doInfergIAlus(v6.c cVar, qb.b<? super Result<d.q>> bVar) {
        AIEngineLogger.d(LogModule.ABILITY, this.TAG, "doInfer: inputType=" + i.a(cVar.getClass()).c());
        return new d.q("ni hao", null, 0 == true ? 1 : 0, 6);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    @Override // com.stepos.base.ability.AbilityBase, p6.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execute(java.lang.String r6, java.lang.Object r7) {
        /*
            r5 = this;
            java.lang.String r0 = "action"
            kotlin.jvm.internal.g.f(r6, r0)
            java.lang.String r0 = "embedBatch"
            boolean r0 = r6.equals(r0)
            r1 = 0
            if (r0 == 0) goto L6e
            boolean r5 = r7 instanceof com.stepos.core.data.ListContent
            r6 = 0
            if (r5 == 0) goto L16
            com.stepos.core.data.ListContent r7 = (com.stepos.core.data.ListContent) r7
            goto L17
        L16:
            r7 = r6
        L17:
            if (r7 != 0) goto L1a
            return r6
        L1a:
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>()
            java.util.List r7 = r7.getItems()
            java.util.Iterator r7 = r7.iterator()
        L27:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L6d
            java.lang.Object r0 = r7.next()
            kotlin.Pair r0 = (kotlin.Pair) r0
            A r2 = r0.f9985a
            java.lang.String r2 = (java.lang.String) r2
            B r0 = r0.f9986b
            com.stepos.core.data.base.Content r0 = (com.stepos.core.data.base.Content) r0
            boolean r3 = r0 instanceof com.stepos.core.data.FileContent
            r4 = 2
            if (r3 == 0) goto L55
            com.stepos.core.data.FileContent r0 = (com.stepos.core.data.FileContent) r0
            boolean r3 = r0.validate()
            if (r3 == 0) goto L53
            com.stepos.core.ability.util.EmbedSessionImageMock r3 = com.stepos.core.ability.util.EmbedSessionImageMock.INSTANCE
            java.lang.String r0 = r0.getPath()
            float[] r0 = com.stepos.core.ability.util.EmbedSessionImageMock.fromPath$default(r3, r0, r1, r4, r6)
            goto L67
        L53:
            r0 = r6
            goto L67
        L55:
            boolean r3 = r0 instanceof com.stepos.core.data.ImageContent
            if (r3 == 0) goto L53
            com.stepos.core.data.ImageContent r0 = (com.stepos.core.data.ImageContent) r0
            boolean r3 = r0.validate()
            if (r3 == 0) goto L53
            com.stepos.core.ability.util.EmbedSessionImageMock r3 = com.stepos.core.ability.util.EmbedSessionImageMock.INSTANCE
            float[] r0 = com.stepos.core.ability.util.EmbedSessionImageMock.fromImageContent$default(r3, r0, r1, r4, r6)
        L67:
            if (r0 == 0) goto L27
            r5.put(r2, r0)
            goto L27
        L6d:
            return r5
        L6e:
            java.lang.String r0 = "session."
            boolean r0 = gc.o.k0(r6, r0, r1)
            if (r0 == 0) goto L81
            int r5 = android.os.Binder.getCallingUid()
            com.stepos.core.ability.text.SessionStore r0 = com.stepos.core.ability.text.SessionStore.INSTANCE
            java.lang.Object r5 = r0.dispatch(r5, r6, r7)
            return r5
        L81:
            java.lang.String r0 = "resetChat"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto La0
            e7.e r5 = r5.getProtocolManager()
            com.stepos.base.protocol.ProtocolType r6 = com.stepos.base.protocol.ProtocolType.f6378a
            e7.b r5 = r5.b(r6)
            e7.h r5 = (e7.h) r5
            if (r5 == 0) goto L9b
            boolean r1 = r5.resetContext()
        L9b:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            return r5
        La0:
            java.lang.Object r5 = super.execute(r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.ChatAbility.execute(java.lang.String, java.lang.Object):java.lang.Object");
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.base.ability.AbilityBase
    public d.q defaultOutput() {
        return new d.q("ni hao default", null, 0 == true ? 1 : 0, 6);
    }
}
