package com.stepos.backend.llama;

import android.llama.cpp.LLamaAndroid;
import android.util.Log;
import androidx.datastore.preferences.protobuf.b1;
import b7.k;
import com.stepos.base.model.ModelBase;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.core.ability.factory.AIEngineAbilityId;
import com.stepos.core.ability.speech.AsrSseEvent;
import com.stepos.core.data.base.Content;
import com.stepos.core.ota.crypto.FekEnvelope;
import e7.f;
import e7.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import mb.l;
import mb.m;
import rb.c;
import v6.c;
import v6.d;
import zb.p;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LLMModel extends ModelBase implements h {
    public static final Companion Companion = new Companion(null);
    private final String TAG;
    private volatile String activeSessionId;
    private boolean first;
    private final boolean isEmbeddingMode;
    private final LLamaAndroid lLamaAndroid;
    private List<? extends Map<String, String>> messages;
    private final String modelId;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.llama.LLMModel", f = "LLMModel.kt", l = {160}, m = "clearSession")
    /* renamed from: com.stepos.backend.llama.LLMModel$clearSession$1, reason: invalid class name */
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
            return LLMModel.this.clearSession(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.llama.LLMModel", f = "LLMModel.kt", l = {170, 173, 175}, m = "doClose")
    /* renamed from: com.stepos.backend.llama.LLMModel$doClose$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01961 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C01961(qb.b<? super C01961> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LLMModel.this.doClose(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.llama.LLMModel$doFlowInfer$2", f = "LLMModel.kt", l = {Content.Types.TYPE_DOUBLE, Content.Types.TYPE_STRING, Content.Types.TYPE_INT_ARRAY, 110, 117, 117, FekEnvelope.EXPECTED_EPK_CHARS, 127}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.llama.LLMModel$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends Object>>, qb.b<? super n>, Object> {
        final /* synthetic */ Object $input;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @c(c = "com.stepos.backend.llama.LLMModel$doFlowInfer$2$1", f = "LLMModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.stepos.backend.llama.LLMModel$doFlowInfer$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements q<FlowCollector<? super String>, Throwable, qb.b<? super n>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LLMModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(LLMModel lLMModel, qb.b<? super AnonymousClass1> bVar) {
                super(3, bVar);
                this.this$0 = lLMModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
                Throwable th = (Throwable) this.L$0;
                Log.e(this.this$0.TAG, "send() failed for modelId=" + this.this$0.modelId, th);
                LLMModel lLMModel = this.this$0;
                String message = th.getMessage();
                if (message == null) {
                    message = "";
                }
                lLMModel.addMessage(AsrSseEvent.TYPE_ERROR, message);
                return n.f10413a;
            }

            @Override // zb.q
            public final Object invoke(FlowCollector<? super String> flowCollector, Throwable th, qb.b<? super n> bVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, bVar);
                anonymousClass1.L$0 = th;
                return anonymousClass1.invokeSuspend(n.f10413a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$input = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = LLMModel.this.new AnonymousClass2(this.$input, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b3, code lost:
        
            if (r1.emit(r2, r12) == r0) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00c9, code lost:
        
            if (r1.emit(r2, r12) != r0) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x013f, code lost:
        
            if (r13.collect(r2, r12) != r0) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0159, code lost:
        
            if (r1.emit(r2, r12) != r0) goto L65;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0088 A[Catch: Exception -> 0x004c, TryCatch #0 {Exception -> 0x004c, blocks: (B:21:0x0047, B:26:0x0052, B:33:0x0084, B:35:0x0088, B:38:0x009a, B:30:0x0066), top: B:67:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x009a A[Catch: Exception -> 0x004c, TRY_LEAVE, TryCatch #0 {Exception -> 0x004c, blocks: (B:21:0x0047, B:26:0x0052, B:33:0x0084, B:35:0x0088, B:38:0x009a, B:30:0x0066), top: B:67:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0110  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0121  */
        /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r1v10 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 374
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.LLMModel.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends Object>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.llama.LLMModel", f = "LLMModel.kt", l = {93, 95}, m = "doInfer")
    /* renamed from: com.stepos.backend.llama.LLMModel$doInfer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01971 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C01971(qb.b<? super C01971> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LLMModel.this.doInfer(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.llama.LLMModel", f = "LLMModel.kt", l = {62, 65, 70, 74}, m = "doInitialize")
    /* renamed from: com.stepos.backend.llama.LLMModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01981 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C01981(qb.b<? super C01981> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LLMModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.llama.LLMModel$processText$2", f = "LLMModel.kt", l = {197, 199, 201, 204, 212, 212, 220}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.llama.LLMModel$processText$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01992 extends SuspendLambda implements p<FlowCollector<? super d>, qb.b<? super n>, Object> {
        final /* synthetic */ c.g $input;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01992(c.g gVar, qb.b<? super C01992> bVar) {
            super(2, bVar);
            this.$input = gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            C01992 c01992 = LLMModel.this.new C01992(this.$input, bVar);
            c01992.L$0 = obj;
            return c01992;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x00be, code lost:
        
            if (r0.emit(r10, r9) == r2) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00e2, code lost:
        
            if (r0.emit(r1, r9) != r2) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x012d, code lost:
        
            if (((kotlinx.coroutines.flow.Flow) r10).collect(r1, r9) != r2) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x014c, code lost:
        
            if (r0.emit(r1, r9) != r2) goto L54;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0095 A[Catch: Exception -> 0x003a, TryCatch #2 {Exception -> 0x003a, blocks: (B:16:0x0035, B:21:0x0041, B:29:0x0091, B:31:0x0095, B:34:0x00aa), top: B:58:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00aa A[Catch: Exception -> 0x003a, TRY_LEAVE, TryCatch #2 {Exception -> 0x003a, blocks: (B:16:0x0035, B:21:0x0041, B:29:0x0091, B:31:0x0095, B:34:0x00aa), top: B:58:0x000c }] */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v2, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r0v4 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instructions count: 358
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.LLMModel.C01992.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super d> flowCollector, qb.b<? super n> bVar) {
            return ((C01992) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.llama.LLMModel$setSessionId$1", f = "LLMModel.kt", l = {143}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.llama.LLMModel$setSessionId$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02001 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        int label;

        public C02001(qb.b<? super C02001> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return LLMModel.this.new C02001(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                LLamaAndroid lLamaAndroid = LLMModel.this.lLamaAndroid;
                String str = LLMModel.this.modelId;
                this.label = 1;
                if (lLamaAndroid.clearKvCacheForModel(str, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C02001) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    static {
        Object obj = f.f8615a;
        f.b(i.a(LLMModel.class), l.s0(new ProtocolType[]{ProtocolType.f6378a, ProtocolType.f6379b}));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LLMModel(k config) {
        super(config);
        g.f(config, "config");
        this.TAG = "LLMModel";
        this.messages = EmptyList.f10001a;
        this.first = true;
        this.lLamaAndroid = LLamaAndroid.Companion.instance();
        this.modelId = config.f3090a;
        this.isEmbeddingMode = config.h.contains(AIEngineAbilityId.EMBEDDING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addMessage(String str, String str2) {
        ArrayList arrayListD0;
        Map mapG0 = kotlin.collections.b.g0(new Pair(BundleContentBridge.KEY_ROLE, str), new Pair("content", str2));
        if (this.messages.isEmpty() || !g.b(((Map) kotlin.collections.a.A0(this.messages)).get(BundleContentBridge.KEY_ROLE), str)) {
            arrayListD0 = kotlin.collections.a.D0(this.messages, b1.P(mapG0));
        } else {
            String str3 = (String) ((Map) kotlin.collections.a.A0(this.messages)).get("content");
            if (str3 == null) {
                str3 = "";
            }
            Map mapK0 = kotlin.collections.b.k0((Map) kotlin.collections.a.A0(this.messages), new Pair("content", a0.a.j(str3, str2)));
            arrayListD0 = kotlin.collections.a.P0(this.messages);
            arrayListD0.set(m.a0(this.messages), mapK0);
        }
        this.messages = arrayListD0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void buildMessage(String str) {
        String string = gc.q.L0(new Regex("\\s+").d(str, " ")).toString();
        if (string.length() > 0) {
            if (this.first) {
                addMessage("system", "This is a conversation between User and Iris, a friendly chatbot.");
                addMessage("user", "Hi");
                addMessage("assistant", "How may I help You?");
                this.first = false;
            }
            addMessage("user", string);
        }
    }

    public final Object batchEmbed(List<String> list, qb.b<? super float[][]> bVar) {
        if (this.isEmbeddingMode) {
            return this.lLamaAndroid.batchEmbedding(this.modelId, list, bVar);
        }
        throw new IllegalArgumentException("Not in embedding mode");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object clearSession(qb.b<? super lb.n> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.stepos.backend.llama.LLMModel.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.backend.llama.LLMModel$clearSession$1 r0 = (com.stepos.backend.llama.LLMModel.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.llama.LLMModel$clearSession$1 r0 = new com.stepos.backend.llama.LLMModel$clearSession$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r7 = r0.L$0
            com.stepos.backend.llama.LLMModel r7 = (com.stepos.backend.llama.LLMModel) r7
            kotlin.c.b(r8)
            goto L64
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.c.b(r8)
            java.lang.String r8 = r7.TAG
            java.lang.String r2 = r7.modelId
            java.lang.String r4 = r7.activeSessionId
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "clearSession: modelId="
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r2 = ", sessionId="
            r5.append(r2)
            r5.append(r4)
            java.lang.String r2 = r5.toString()
            android.util.Log.d(r8, r2)
            android.llama.cpp.LLamaAndroid r8 = r7.lLamaAndroid
            java.lang.String r2 = r7.modelId
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r8.clearKvCacheForModel(r2, r0)
            if (r8 != r1) goto L64
            return r1
        L64:
            r8 = 0
            r7.activeSessionId = r8
            kotlin.collections.EmptyList r8 = kotlin.collections.EmptyList.f10001a
            r7.messages = r8
            r7.first = r3
            lb.n r7 = lb.n.f10413a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.LLMModel.clearSession(qb.b):java.lang.Object");
    }

    public final float cosineSimilarity(float[] emb1, float[] emb2) {
        g.f(emb1, "emb1");
        g.f(emb2, "emb2");
        return this.lLamaAndroid.cosineSimilarity(emb1, emb2);
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doCleanup(qb.b<? super n> bVar) {
        return n.f10413a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
    
        if (r8.unloadEmbedding(r7, r0) == r1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
    
        if (r8.unload(r7, r0) == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doClose(qb.b<? super lb.n> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.stepos.backend.llama.LLMModel.C01961
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.backend.llama.LLMModel$doClose$1 r0 = (com.stepos.backend.llama.LLMModel.C01961) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.llama.LLMModel$doClose$1 r0 = new com.stepos.backend.llama.LLMModel$doClose$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L39
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.c.b(r8)
            goto L86
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.c.b(r8)
            goto L74
        L39:
            java.lang.Object r7 = r0.L$0
            com.stepos.backend.llama.LLMModel r7 = (com.stepos.backend.llama.LLMModel) r7
            kotlin.c.b(r8)
            goto L60
        L41:
            kotlin.c.b(r8)
            java.lang.String r8 = r7.TAG
            java.lang.String r2 = r7.modelId
            java.lang.String r6 = "doClose: modelId="
            a0.a.v(r6, r2, r8)
            boolean r8 = r7.isEmbeddingMode
            if (r8 != 0) goto L60
            android.llama.cpp.LLamaAndroid r8 = r7.lLamaAndroid
            java.lang.String r2 = r7.modelId
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = r8.clearKvCacheForModel(r2, r0)
            if (r8 != r1) goto L60
            goto L85
        L60:
            boolean r8 = r7.isEmbeddingMode
            r2 = 0
            if (r8 == 0) goto L77
            android.llama.cpp.LLamaAndroid r8 = r7.lLamaAndroid
            java.lang.String r7 = r7.modelId
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r8.unloadEmbedding(r7, r0)
            if (r7 != r1) goto L74
            goto L85
        L74:
            lb.n r7 = lb.n.f10413a
            return r7
        L77:
            android.llama.cpp.LLamaAndroid r8 = r7.lLamaAndroid
            java.lang.String r7 = r7.modelId
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r8.unload(r7, r0)
            if (r7 != r1) goto L86
        L85:
            return r1
        L86:
            lb.n r7 = lb.n.f10413a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.LLMModel.doClose(qb.b):java.lang.Object");
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doFlowInfer(Object obj, qb.b<? super Flow<? extends Result<? extends Object>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(obj, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        if (r10 == r0) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInfer(java.lang.Object r9, qb.b<java.lang.Object> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.stepos.backend.llama.LLMModel.C01971
            if (r0 == 0) goto L14
            r0 = r10
            com.stepos.backend.llama.LLMModel$doInfer$1 r0 = (com.stepos.backend.llama.LLMModel.C01971) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            com.stepos.backend.llama.LLMModel$doInfer$1 r0 = new com.stepos.backend.llama.LLMModel$doInfer$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r5.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L38
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2c
            kotlin.c.b(r10)
            return r10
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            kotlin.c.b(r10)
            goto L50
        L38:
            kotlin.c.b(r10)
            boolean r10 = r8.isEmbeddingMode
            if (r10 == 0) goto L59
            android.llama.cpp.LLamaAndroid r10 = r8.lLamaAndroid
            java.lang.String r8 = r8.modelId
            java.lang.String r9 = r9.toString()
            r5.label = r3
            java.lang.Object r10 = r10.embedding(r8, r9, r5)
            if (r10 != r0) goto L50
            goto L6d
        L50:
            float[] r10 = (float[]) r10
            if (r10 != 0) goto L58
            r8 = 0
            float[] r8 = new float[r8]
            return r8
        L58:
            return r10
        L59:
            android.llama.cpp.LLamaAndroid r1 = r8.lLamaAndroid
            java.lang.String r8 = r8.modelId
            java.lang.String r3 = r9.toString()
            r5.label = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r8
            java.lang.Object r8 = android.llama.cpp.LLamaAndroid.send$default(r1, r2, r3, r4, r5, r6, r7)
            if (r8 != r0) goto L6e
        L6d:
            return r0
        L6e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.LLMModel.doInfer(java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009a, code lost:
    
        if (r15 == r1) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r12v2, types: [com.stepos.backend.llama.LLMModel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r14v7, types: [android.llama.cpp.LLamaAndroid] */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInitialize(android.content.Context r13, b7.k r14, qb.b<? super lb.n> r15) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.LLMModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doWarmup(qb.b<? super n> bVar) {
        a0.a.v("doWarmup: modelId=", this.modelId, this.TAG);
        return n.f10413a;
    }

    public final Object embed(String str, qb.b<? super float[]> bVar) {
        if (this.isEmbeddingMode) {
            return this.lLamaAndroid.embedding(this.modelId, str, bVar);
        }
        throw new IllegalArgumentException("Not in embedding mode");
    }

    @Override // e7.b
    public ProtocolType getType() {
        return ProtocolType.f6378a;
    }

    @Override // e7.h
    public Object processText(c.g gVar, Object obj, qb.b<? super Flow<? extends d>> bVar) {
        return FlowKt.flow(new C01992(gVar, null));
    }

    @Override // e7.h
    public boolean resetContext() {
        return false;
    }

    public final void setSessionId(String str) {
        if (g.b(this.activeSessionId, str)) {
            return;
        }
        String str2 = this.TAG;
        String str3 = this.activeSessionId;
        String str4 = this.modelId;
        StringBuilder sbS = ai.onnxruntime.a.s("Session changed: ", str3, " → ", str, " (modelId=");
        sbS.append(str4);
        sbS.append(")");
        Log.d(str2, sbS.toString());
        if (this.activeSessionId != null && str != null) {
            BuildersKt__BuildersKt.runBlocking$default(null, new C02001(null), 1, null);
        }
        this.activeSessionId = str;
        if (str != null) {
            this.messages = EmptyList.f10001a;
            this.first = true;
        }
    }
}
