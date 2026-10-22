package android.llama.cpp;

import android.llama.cpp.LLamaAndroid;
import android.util.Log;
import com.stepos.core.ability.factory.AIEngineAbilityId;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.cloud.FileStorageUploader;
import com.stepos.core.common.log.AiEngineAtrace;
import gc.q;
import java.lang.Thread;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import mb.y;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LLamaAndroid {
    private static final String DEFAULT_MODEL_ID = "default";
    private final int contextSize;
    private volatile String nativeLibError;
    private volatile boolean nativeLibLoaded;
    private final int nlen;
    private final CoroutineDispatcher runLoop;
    public static final Companion Companion = new Companion(null);
    private static final LLamaAndroid _instance = new LLamaAndroid();
    private final String tag = "LLamaAndroid";
    private final ConcurrentHashMap<String, Companion.State> modelStates = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Boolean> stopFlags = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Boolean> sendingFlags = new ConcurrentHashMap<>();
    private final CountDownLatch initLatch = new CountDownLatch(1);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class IntVar {
            private volatile int value;

            public IntVar(int i10) {
                this.value = i10;
            }

            public final int getValue() {
                return this.value;
            }

            public final void inc() {
                synchronized (this) {
                    this.value++;
                    n nVar = n.f10413a;
                }
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public interface State {

            /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
            public static final class EmbeddingLoaded implements State {
                private final long embeddingContext;
                private final long model;
                private final int nEmbd;

                public EmbeddingLoaded(long j10, long j11, int i10) {
                    this.model = j10;
                    this.embeddingContext = j11;
                    this.nEmbd = i10;
                }

                public static /* synthetic */ EmbeddingLoaded copy$default(EmbeddingLoaded embeddingLoaded, long j10, long j11, int i10, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        j10 = embeddingLoaded.model;
                    }
                    long j12 = j10;
                    if ((i11 & 2) != 0) {
                        j11 = embeddingLoaded.embeddingContext;
                    }
                    long j13 = j11;
                    if ((i11 & 4) != 0) {
                        i10 = embeddingLoaded.nEmbd;
                    }
                    return embeddingLoaded.copy(j12, j13, i10);
                }

                public final long component1() {
                    return this.model;
                }

                public final long component2() {
                    return this.embeddingContext;
                }

                public final int component3() {
                    return this.nEmbd;
                }

                public final EmbeddingLoaded copy(long j10, long j11, int i10) {
                    return new EmbeddingLoaded(j10, j11, i10);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof EmbeddingLoaded)) {
                        return false;
                    }
                    EmbeddingLoaded embeddingLoaded = (EmbeddingLoaded) obj;
                    return this.model == embeddingLoaded.model && this.embeddingContext == embeddingLoaded.embeddingContext && this.nEmbd == embeddingLoaded.nEmbd;
                }

                public final long getEmbeddingContext() {
                    return this.embeddingContext;
                }

                public final long getModel() {
                    return this.model;
                }

                public final int getNEmbd() {
                    return this.nEmbd;
                }

                public int hashCode() {
                    return Integer.hashCode(this.nEmbd) + a0.a.c(Long.hashCode(this.model) * 31, this.embeddingContext, 31);
                }

                public String toString() {
                    long j10 = this.model;
                    long j11 = this.embeddingContext;
                    int i10 = this.nEmbd;
                    StringBuilder sbQ = ai.onnxruntime.a.q(j10, "EmbeddingLoaded(model=", ", embeddingContext=");
                    sbQ.append(j11);
                    sbQ.append(", nEmbd=");
                    sbQ.append(i10);
                    sbQ.append(")");
                    return sbQ.toString();
                }
            }

            /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
            public static final class Loaded implements State {
                private final long batch;
                private final long context;
                private final long model;
                private final String modelEotStr;
                private final long sampler;

                public Loaded(long j10, long j11, long j12, long j13, String modelEotStr) {
                    g.f(modelEotStr, "modelEotStr");
                    this.model = j10;
                    this.context = j11;
                    this.batch = j12;
                    this.sampler = j13;
                    this.modelEotStr = modelEotStr;
                }

                public static /* synthetic */ Loaded copy$default(Loaded loaded, long j10, long j11, long j12, long j13, String str, int i10, Object obj) {
                    if ((i10 & 1) != 0) {
                        j10 = loaded.model;
                    }
                    long j14 = j10;
                    if ((i10 & 2) != 0) {
                        j11 = loaded.context;
                    }
                    return loaded.copy(j14, j11, (i10 & 4) != 0 ? loaded.batch : j12, (i10 & 8) != 0 ? loaded.sampler : j13, (i10 & 16) != 0 ? loaded.modelEotStr : str);
                }

                public final long component1() {
                    return this.model;
                }

                public final long component2() {
                    return this.context;
                }

                public final long component3() {
                    return this.batch;
                }

                public final long component4() {
                    return this.sampler;
                }

                public final String component5() {
                    return this.modelEotStr;
                }

                public final Loaded copy(long j10, long j11, long j12, long j13, String modelEotStr) {
                    g.f(modelEotStr, "modelEotStr");
                    return new Loaded(j10, j11, j12, j13, modelEotStr);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Loaded)) {
                        return false;
                    }
                    Loaded loaded = (Loaded) obj;
                    return this.model == loaded.model && this.context == loaded.context && this.batch == loaded.batch && this.sampler == loaded.sampler && g.b(this.modelEotStr, loaded.modelEotStr);
                }

                public final long getBatch() {
                    return this.batch;
                }

                public final long getContext() {
                    return this.context;
                }

                public final long getModel() {
                    return this.model;
                }

                public final String getModelEotStr() {
                    return this.modelEotStr;
                }

                public final long getSampler() {
                    return this.sampler;
                }

                public int hashCode() {
                    return this.modelEotStr.hashCode() + a0.a.c(a0.a.c(a0.a.c(Long.hashCode(this.model) * 31, this.context, 31), this.batch, 31), this.sampler, 31);
                }

                public String toString() {
                    long j10 = this.model;
                    long j11 = this.context;
                    long j12 = this.batch;
                    long j13 = this.sampler;
                    String str = this.modelEotStr;
                    StringBuilder sbQ = ai.onnxruntime.a.q(j10, "Loaded(model=", ", context=");
                    sbQ.append(j11);
                    a0.a.s(j12, ", batch=", ", sampler=", sbQ);
                    ai.onnxruntime.a.u(j13, ", modelEotStr=", str, sbQ);
                    sbQ.append(")");
                    return sbQ.toString();
                }
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final LLamaAndroid instance() {
            return LLamaAndroid._instance;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "android.llama.cpp.LLamaAndroid$batchEmbedding$2", f = "LLamaAndroid.kt", l = {}, m = "invokeSuspend")
    /* renamed from: android.llama.cpp.LLamaAndroid$batchEmbedding$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super float[][]>, Object> {
        final /* synthetic */ String $modelId;
        final /* synthetic */ List<String> $texts;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, List<String> list, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$modelId = str;
            this.$texts = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float[][] invokeSuspend$lambda$0(LLamaAndroid lLamaAndroid, Companion.State.EmbeddingLoaded embeddingLoaded, List list) {
            return lLamaAndroid.batch_do_embeddings(embeddingLoaded.getEmbeddingContext(), embeddingLoaded.getModel(), (String[]) list.toArray(new String[0]));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return LLamaAndroid.this.new AnonymousClass2(this.$modelId, this.$texts, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            Object obj2 = LLamaAndroid.this.modelStates.get(this.$modelId);
            Companion.State.EmbeddingLoaded embeddingLoaded = obj2 instanceof Companion.State.EmbeddingLoaded ? (Companion.State.EmbeddingLoaded) obj2 : null;
            if (embeddingLoaded != null) {
                return AiEngineAtrace.section("llama/call", "batch_embedding", new d(LLamaAndroid.this, embeddingLoaded, this.$texts, 0));
            }
            throw new IllegalStateException(a0.a.k("Model ", this.$modelId, " not loaded or not in Embedding mode"));
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super float[][]> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "android.llama.cpp.LLamaAndroid$bench$2", f = "LLamaAndroid.kt", l = {}, m = "invokeSuspend")
    /* renamed from: android.llama.cpp.LLamaAndroid$bench$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01832 extends SuspendLambda implements p<CoroutineScope, qb.b<? super String>, Object> {
        final /* synthetic */ String $modelId;
        final /* synthetic */ int $nr;
        final /* synthetic */ int $pl;
        final /* synthetic */ int $pp;
        final /* synthetic */ int $tg;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01832(String str, int i10, int i11, int i12, int i13, qb.b<? super C01832> bVar) {
            super(2, bVar);
            this.$modelId = str;
            this.$pp = i10;
            this.$tg = i11;
            this.$pl = i12;
            this.$nr = i13;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return LLamaAndroid.this.new C01832(this.$modelId, this.$pp, this.$tg, this.$pl, this.$nr, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            Object obj2 = LLamaAndroid.this.modelStates.get(this.$modelId);
            Companion.State.Loaded loaded = obj2 instanceof Companion.State.Loaded ? (Companion.State.Loaded) obj2 : null;
            if (loaded != null) {
                return LLamaAndroid.this.bench_model(loaded.getContext(), loaded.getModel(), loaded.getBatch(), this.$pp, this.$tg, this.$pl, this.$nr);
            }
            throw new IllegalStateException(a0.a.k("Model ", this.$modelId, " not loaded or not in LLM mode"));
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super String> bVar) {
            return ((C01832) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "android.llama.cpp.LLamaAndroid$clearKvCacheForModel$2", f = "LLamaAndroid.kt", l = {}, m = "invokeSuspend")
    /* renamed from: android.llama.cpp.LLamaAndroid$clearKvCacheForModel$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01842 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ String $modelId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01842(String str, qb.b<? super C01842> bVar) {
            super(2, bVar);
            this.$modelId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return LLamaAndroid.this.new C01842(this.$modelId, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            Object obj2 = LLamaAndroid.this.modelStates.get(this.$modelId);
            Companion.State.Loaded loaded = obj2 instanceof Companion.State.Loaded ? (Companion.State.Loaded) obj2 : null;
            if (loaded == null) {
                return n.f10413a;
            }
            LLamaAndroid.this.kv_cache_clear(loaded.getContext());
            a0.a.v("KV cache cleared for model: ", this.$modelId, LLamaAndroid.this.tag);
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C01842) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "android.llama.cpp.LLamaAndroid$embedding$2", f = "LLamaAndroid.kt", l = {}, m = "invokeSuspend")
    /* renamed from: android.llama.cpp.LLamaAndroid$embedding$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01852 extends SuspendLambda implements p<CoroutineScope, qb.b<? super float[]>, Object> {
        final /* synthetic */ String $modelId;
        final /* synthetic */ String $text;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01852(String str, String str2, qb.b<? super C01852> bVar) {
            super(2, bVar);
            this.$modelId = str;
            this.$text = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float[] invokeSuspend$lambda$0(LLamaAndroid lLamaAndroid, Companion.State.EmbeddingLoaded embeddingLoaded, String str) {
            return lLamaAndroid.do_embedding(embeddingLoaded.getEmbeddingContext(), embeddingLoaded.getModel(), str);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return LLamaAndroid.this.new C01852(this.$modelId, this.$text, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            Object obj2 = LLamaAndroid.this.modelStates.get(this.$modelId);
            Companion.State.EmbeddingLoaded embeddingLoaded = obj2 instanceof Companion.State.EmbeddingLoaded ? (Companion.State.EmbeddingLoaded) obj2 : null;
            if (embeddingLoaded != null) {
                return AiEngineAtrace.section("llama/call", AIEngineAbilityId.EMBEDDING, new d(LLamaAndroid.this, embeddingLoaded, this.$text, 1));
            }
            throw new IllegalStateException(a0.a.k("Model ", this.$modelId, " not loaded or not in Embedding mode"));
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super float[]> bVar) {
            return ((C01852) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "android.llama.cpp.LLamaAndroid$ensureNativeLibReady$1", f = "LLamaAndroid.kt", l = {147}, m = "invokeSuspend")
    /* renamed from: android.llama.cpp.LLamaAndroid$ensureNativeLibReady$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        int label;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @rb.c(c = "android.llama.cpp.LLamaAndroid$ensureNativeLibReady$1$1", f = "LLamaAndroid.kt", l = {}, m = "invokeSuspend")
        /* renamed from: android.llama.cpp.LLamaAndroid$ensureNativeLibReady$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00001 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
            int label;

            public C00001(qb.b<? super C00001> bVar) {
                super(2, bVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final qb.b<n> create(Object obj, qb.b<?> bVar) {
                return new C00001(bVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
                return n.f10413a;
            }

            @Override // zb.p
            public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
                return ((C00001) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
            }
        }

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return LLamaAndroid.this.new AnonymousClass1(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                CoroutineDispatcher coroutineDispatcher = LLamaAndroid.this.runLoop;
                C00001 c00001 = new C00001(null);
                this.label = 1;
                if (BuildersKt.withContext(coroutineDispatcher, c00001, this) == coroutineSingletons) {
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
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "android.llama.cpp.LLamaAndroid$getEmbeddingDimension$2", f = "LLamaAndroid.kt", l = {}, m = "invokeSuspend")
    /* renamed from: android.llama.cpp.LLamaAndroid$getEmbeddingDimension$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01862 extends SuspendLambda implements p<CoroutineScope, qb.b<? super Integer>, Object> {
        final /* synthetic */ String $modelId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01862(String str, qb.b<? super C01862> bVar) {
            super(2, bVar);
            this.$modelId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return LLamaAndroid.this.new C01862(this.$modelId, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int nEmbd;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            Companion.State state = (Companion.State) LLamaAndroid.this.modelStates.get(this.$modelId);
            if (state instanceof Companion.State.EmbeddingLoaded) {
                nEmbd = ((Companion.State.EmbeddingLoaded) state).getNEmbd();
            } else {
                if (!(state instanceof Companion.State.Loaded)) {
                    throw new IllegalStateException(a0.a.k("Model ", this.$modelId, " not loaded"));
                }
                nEmbd = LLamaAndroid.this.get_n_embd(((Companion.State.Loaded) state).getModel());
            }
            return new Integer(nEmbd);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super Integer> bVar) {
            return ((C01862) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "android.llama.cpp.LLamaAndroid$getTemplate$2", f = "LLamaAndroid.kt", l = {}, m = "invokeSuspend")
    /* renamed from: android.llama.cpp.LLamaAndroid$getTemplate$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01872 extends SuspendLambda implements p<CoroutineScope, qb.b<? super String>, Object> {
        final /* synthetic */ List<Map<String, String>> $messages;
        final /* synthetic */ String $modelId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C01872(String str, List<? extends Map<String, String>> list, qb.b<? super C01872> bVar) {
            super(2, bVar);
            this.$modelId = str;
            this.$messages = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return LLamaAndroid.this.new C01872(this.$modelId, this.$messages, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            Object obj2 = LLamaAndroid.this.modelStates.get(this.$modelId);
            Companion.State.Loaded loaded = obj2 instanceof Companion.State.Loaded ? (Companion.State.Loaded) obj2 : null;
            if (loaded != null) {
                return LLamaAndroid.this.oaicompat_completion_param_parse((Map[]) this.$messages.toArray(new Map[0]), loaded.getModel());
            }
            throw new IllegalStateException(a0.a.k("Model ", this.$modelId, " not loaded or not in LLM mode"));
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super String> bVar) {
            return ((C01872) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "android.llama.cpp.LLamaAndroid$load$2", f = "LLamaAndroid.kt", l = {}, m = "invokeSuspend")
    /* renamed from: android.llama.cpp.LLamaAndroid$load$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01882 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ String $modelId;
        final /* synthetic */ String $pathToModel;
        final /* synthetic */ float $temp;
        final /* synthetic */ int $topK;
        final /* synthetic */ float $topP;
        final /* synthetic */ int $userThreads;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01882(String str, String str2, int i10, float f8, int i11, float f9, qb.b<? super C01882> bVar) {
            super(2, bVar);
            this.$modelId = str;
            this.$pathToModel = str2;
            this.$userThreads = i10;
            this.$topP = f8;
            this.$topK = i11;
            this.$temp = f9;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return LLamaAndroid.this.new C01882(this.$modelId, this.$pathToModel, this.$userThreads, this.$topP, this.$topK, this.$temp, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            if (LLamaAndroid.this.modelStates.containsKey(this.$modelId)) {
                ai.onnxruntime.a.x("Model ", this.$modelId, " already loaded, skip", LLamaAndroid.this.tag);
                return n.f10413a;
            }
            Log.d(LLamaAndroid.this.tag, "Loading LLM model: " + this.$modelId + " from " + this.$pathToModel);
            long jLoad_model = LLamaAndroid.this.load_model(this.$pathToModel);
            if (jLoad_model == 0) {
                throw new IllegalStateException(ai.onnxruntime.a.k("load_model() failed for ", this.$modelId));
            }
            long jNew_context = LLamaAndroid.this.new_context(jLoad_model, this.$userThreads);
            if (jNew_context == 0) {
                LLamaAndroid.this.free_model(jLoad_model);
                throw new IllegalStateException(ai.onnxruntime.a.k("new_context() failed for ", this.$modelId));
            }
            long jNew_batch = LLamaAndroid.this.new_batch(4096, 0, 1);
            if (jNew_batch == 0) {
                LLamaAndroid.this.free_context(jNew_context);
                LLamaAndroid.this.free_model(jLoad_model);
                throw new IllegalStateException(ai.onnxruntime.a.k("new_batch() failed for ", this.$modelId));
            }
            long jNew_sampler = LLamaAndroid.this.new_sampler(this.$topP, this.$topK, this.$temp);
            if (jNew_sampler == 0) {
                LLamaAndroid.this.free_batch(jNew_batch);
                LLamaAndroid.this.free_context(jNew_context);
                LLamaAndroid.this.free_model(jLoad_model);
                throw new IllegalStateException(ai.onnxruntime.a.k("new_sampler() failed for ", this.$modelId));
            }
            LLamaAndroid.this.modelStates.put(this.$modelId, new Companion.State.Loaded(jLoad_model, jNew_context, jNew_batch, jNew_sampler, LLamaAndroid.this.get_eot_str(jLoad_model)));
            ConcurrentHashMap concurrentHashMap = LLamaAndroid.this.stopFlags;
            String str = this.$modelId;
            Boolean bool = Boolean.FALSE;
            concurrentHashMap.put(str, bool);
            LLamaAndroid.this.sendingFlags.put(this.$modelId, bool);
            a0.a.y("Loaded LLM model: ", this.$modelId, LLamaAndroid.this.tag);
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C01882) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "android.llama.cpp.LLamaAndroid$loadForEmbedding$2", f = "LLamaAndroid.kt", l = {}, m = "invokeSuspend")
    /* renamed from: android.llama.cpp.LLamaAndroid$loadForEmbedding$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01892 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ String $modelId;
        final /* synthetic */ int $nCtx;
        final /* synthetic */ String $pathToModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01892(String str, String str2, int i10, qb.b<? super C01892> bVar) {
            super(2, bVar);
            this.$modelId = str;
            this.$pathToModel = str2;
            this.$nCtx = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return LLamaAndroid.this.new C01892(this.$modelId, this.$pathToModel, this.$nCtx, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            if (LLamaAndroid.this.modelStates.containsKey(this.$modelId)) {
                ai.onnxruntime.a.x("Model ", this.$modelId, " already loaded, skip", LLamaAndroid.this.tag);
                return n.f10413a;
            }
            Log.d(LLamaAndroid.this.tag, "Loading Embedding model: " + this.$modelId + " from " + this.$pathToModel);
            long jLoad_model = LLamaAndroid.this.load_model(this.$pathToModel);
            if (jLoad_model == 0) {
                throw new IllegalStateException(ai.onnxruntime.a.k("load_model() failed for ", this.$modelId));
            }
            long jNew_embedding_context = LLamaAndroid.this.new_embedding_context(jLoad_model, this.$nCtx);
            if (jNew_embedding_context == 0) {
                LLamaAndroid.this.free_model(jLoad_model);
                throw new IllegalStateException(ai.onnxruntime.a.k("new_embedding_context() failed for ", this.$modelId));
            }
            int i10 = LLamaAndroid.this.get_n_embd(jLoad_model);
            LLamaAndroid.this.modelStates.put(this.$modelId, new Companion.State.EmbeddingLoaded(jLoad_model, jNew_embedding_context, i10));
            Log.i(LLamaAndroid.this.tag, "Loaded Embedding model: " + this.$modelId + ", dimension: " + i10);
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C01892) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "android.llama.cpp.LLamaAndroid$send$2", f = "LLamaAndroid.kt", l = {295}, m = "invokeSuspend")
    /* renamed from: android.llama.cpp.LLamaAndroid$send$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01902 extends SuspendLambda implements p<FlowCollector<? super String>, qb.b<? super n>, Object> {
        final /* synthetic */ boolean $keepKvCache;
        final /* synthetic */ String $message;
        final /* synthetic */ String $modelId;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01902(String str, boolean z, String str2, qb.b<? super C01902> bVar) {
            super(2, bVar);
            this.$modelId = str;
            this.$keepKvCache = z;
            this.$message = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$0(LLamaAndroid lLamaAndroid, Companion.State.Loaded loaded, String str) {
            return lLamaAndroid.completion_init(loaded.getContext(), loaded.getBatch(), str, lLamaAndroid.nlen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1(LLamaAndroid lLamaAndroid, Companion.State.Loaded loaded, Companion.IntVar intVar) {
            return lLamaAndroid.completion_loop(loaded.getContext(), loaded.getBatch(), loaded.getSampler(), lLamaAndroid.nlen, intVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            C01902 c01902 = LLamaAndroid.this.new C01902(this.$modelId, this.$keepKvCache, this.$message, bVar);
            c01902.L$0 = obj;
            return c01902;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            Companion.State.Loaded loaded;
            int i10;
            String strSubstring;
            Companion.IntVar intVar;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i11 = this.label;
            try {
                if (i11 == 0) {
                    kotlin.c.b(obj);
                    FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                    ConcurrentHashMap concurrentHashMap = LLamaAndroid.this.stopFlags;
                    String str = this.$modelId;
                    Boolean bool = Boolean.FALSE;
                    concurrentHashMap.put(str, bool);
                    LLamaAndroid.this.sendingFlags.put(this.$modelId, Boolean.TRUE);
                    Object obj2 = LLamaAndroid.this.modelStates.get(this.$modelId);
                    final Companion.State.Loaded loaded2 = obj2 instanceof Companion.State.Loaded ? (Companion.State.Loaded) obj2 : null;
                    if (loaded2 == null) {
                        LLamaAndroid.this.sendingFlags.put(this.$modelId, bool);
                        throw new IllegalStateException(a0.a.k("Model ", this.$modelId, " not loaded or not in LLM mode"));
                    }
                    final LLamaAndroid lLamaAndroid = LLamaAndroid.this;
                    final String str2 = this.$message;
                    Companion.IntVar intVar2 = new Companion.IntVar(((Number) AiEngineAtrace.section("llama/call", "llm_prefill", new zb.a() { // from class: android.llama.cpp.e
                        @Override // zb.a
                        public final Object invoke() {
                            return Integer.valueOf(LLamaAndroid.C01902.invokeSuspend$lambda$0(lLamaAndroid, loaded2, str2));
                        }
                    })).intValue());
                    flowCollector = flowCollector2;
                    loaded = loaded2;
                    i10 = 0;
                    strSubstring = "";
                    intVar = intVar2;
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i10 = this.I$0;
                    String str3 = (String) this.L$3;
                    intVar = (Companion.IntVar) this.L$2;
                    loaded = (Companion.State.Loaded) this.L$1;
                    flowCollector = (FlowCollector) this.L$0;
                    kotlin.c.b(obj);
                    strSubstring = str3;
                }
                while (i10 <= LLamaAndroid.this.nlen && intVar.getValue() < LLamaAndroid.this.contextSize && !g.b(LLamaAndroid.this.stopFlags.get(this.$modelId), Boolean.TRUE)) {
                    String str4 = (String) AiEngineAtrace.section("llama/call", "llm_decode", new d(LLamaAndroid.this, loaded, intVar, 2));
                    i10++;
                    if (str4 == null) {
                        break;
                    }
                    strSubstring = strSubstring + str4;
                    if (strSubstring.length() > loaded.getModelEotStr().length() && q.l0(strSubstring, loaded.getModelEotStr(), false)) {
                        break;
                    }
                    if (strSubstring.length() / 2 > loaded.getModelEotStr().length()) {
                        strSubstring = strSubstring.substring(strSubstring.length() / 2);
                        g.e(strSubstring, "substring(...)");
                    }
                    this.L$0 = flowCollector;
                    this.L$1 = loaded;
                    this.L$2 = intVar;
                    this.L$3 = strSubstring;
                    this.I$0 = i10;
                    this.label = 1;
                    if (flowCollector.emit(str4, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                if (!this.$keepKvCache) {
                    LLamaAndroid.this.kv_cache_clear(loaded.getContext());
                }
                LLamaAndroid.this.sendingFlags.put(this.$modelId, Boolean.FALSE);
                return n.f10413a;
            } catch (Throwable th) {
                LLamaAndroid.this.sendingFlags.put(this.$modelId, Boolean.FALSE);
                throw th;
            }
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super String> flowCollector, qb.b<? super n> bVar) {
            return ((C01902) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "android.llama.cpp.LLamaAndroid$unload$2", f = "LLamaAndroid.kt", l = {}, m = "invokeSuspend")
    /* renamed from: android.llama.cpp.LLamaAndroid$unload$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01912 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ String $modelId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01912(String str, qb.b<? super C01912> bVar) {
            super(2, bVar);
            this.$modelId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return LLamaAndroid.this.new C01912(this.$modelId, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            Object objRemove = LLamaAndroid.this.modelStates.remove(this.$modelId);
            Companion.State.Loaded loaded = objRemove instanceof Companion.State.Loaded ? (Companion.State.Loaded) objRemove : null;
            if (loaded == null) {
                return n.f10413a;
            }
            LLamaAndroid.this.free_sampler(loaded.getSampler());
            LLamaAndroid.this.free_batch(loaded.getBatch());
            LLamaAndroid.this.free_context(loaded.getContext());
            LLamaAndroid.this.free_model(loaded.getModel());
            LLamaAndroid.this.stopFlags.remove(this.$modelId);
            LLamaAndroid.this.sendingFlags.remove(this.$modelId);
            a0.a.y("Unloaded LLM model: ", this.$modelId, LLamaAndroid.this.tag);
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C01912) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "android.llama.cpp.LLamaAndroid$unloadAll$2", f = "LLamaAndroid.kt", l = {}, m = "invokeSuspend")
    /* renamed from: android.llama.cpp.LLamaAndroid$unloadAll$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01922 extends SuspendLambda implements p<CoroutineScope, qb.b<? super Integer>, Object> {
        int label;

        public C01922(qb.b<? super C01922> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return LLamaAndroid.this.new C01922(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            Set setKeySet = LLamaAndroid.this.modelStates.keySet();
            g.e(setKeySet, "<get-keys>(...)");
            Iterator it = kotlin.collections.a.O0(setKeySet).iterator();
            while (it.hasNext()) {
                Companion.State state = (Companion.State) LLamaAndroid.this.modelStates.remove((String) it.next());
                if (state instanceof Companion.State.Loaded) {
                    Companion.State.Loaded loaded = (Companion.State.Loaded) state;
                    LLamaAndroid.this.free_sampler(loaded.getSampler());
                    LLamaAndroid.this.free_batch(loaded.getBatch());
                    LLamaAndroid.this.free_context(loaded.getContext());
                    LLamaAndroid.this.free_model(loaded.getModel());
                } else if (state instanceof Companion.State.EmbeddingLoaded) {
                    Companion.State.EmbeddingLoaded embeddingLoaded = (Companion.State.EmbeddingLoaded) state;
                    LLamaAndroid.this.free_context(embeddingLoaded.getEmbeddingContext());
                    LLamaAndroid.this.free_model(embeddingLoaded.getModel());
                }
            }
            LLamaAndroid.this.stopFlags.clear();
            LLamaAndroid.this.sendingFlags.clear();
            return new Integer(Log.i(LLamaAndroid.this.tag, "Unloaded all models"));
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super Integer> bVar) {
            return ((C01922) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "android.llama.cpp.LLamaAndroid$unloadEmbedding$2", f = "LLamaAndroid.kt", l = {}, m = "invokeSuspend")
    /* renamed from: android.llama.cpp.LLamaAndroid$unloadEmbedding$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01932 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ String $modelId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01932(String str, qb.b<? super C01932> bVar) {
            super(2, bVar);
            this.$modelId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return LLamaAndroid.this.new C01932(this.$modelId, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            Object objRemove = LLamaAndroid.this.modelStates.remove(this.$modelId);
            Companion.State.EmbeddingLoaded embeddingLoaded = objRemove instanceof Companion.State.EmbeddingLoaded ? (Companion.State.EmbeddingLoaded) objRemove : null;
            if (embeddingLoaded == null) {
                return n.f10413a;
            }
            LLamaAndroid.this.free_context(embeddingLoaded.getEmbeddingContext());
            LLamaAndroid.this.free_model(embeddingLoaded.getModel());
            a0.a.y("Unloaded Embedding model: ", this.$modelId, LLamaAndroid.this.tag);
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C01932) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    private LLamaAndroid() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new a(this, 0));
        g.e(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.runLoop = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
        this.nlen = 1024;
        this.contextSize = 4096;
    }

    private final native void backend_free();

    private final native void backend_init(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public final native float[][] batch_do_embeddings(long j10, long j11, String[] strArr);

    public static /* synthetic */ Object bench$default(LLamaAndroid lLamaAndroid, String str, int i10, int i11, int i12, int i13, qb.b bVar, int i14, Object obj) {
        if ((i14 & 16) != 0) {
            i13 = 1;
        }
        return lLamaAndroid.bench(str, i10, i11, i12, i13, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native String bench_model(long j10, long j11, long j12, int i10, int i11, int i12, int i13);

    /* JADX INFO: Access modifiers changed from: private */
    public final native int completion_init(long j10, long j11, String str, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public final native String completion_loop(long j10, long j11, long j12, int i10, Companion.IntVar intVar);

    /* JADX INFO: Access modifiers changed from: private */
    public final native float[] do_embedding(long j10, long j11, String str);

    private final void ensureNativeLibReady(long j10) {
        if (this.initLatch.getCount() > 0) {
            BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(null), 1, null);
        }
        if (!this.initLatch.await(j10, TimeUnit.MILLISECONDS)) {
            throw new IllegalStateException(ai.onnxruntime.a.h(j10, "Native library initialization timeout after ", "ms"));
        }
        if (this.nativeLibLoaded) {
            return;
        }
        String str = this.nativeLibError;
        if (str == null) {
            str = "Native library failed to load";
        }
        throw new IllegalStateException(str);
    }

    public static /* synthetic */ void ensureNativeLibReady$default(LLamaAndroid lLamaAndroid, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = FileStorageUploader.LOG_HEARTBEAT_MS;
        }
        lLamaAndroid.ensureNativeLibReady(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native void free_batch(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void free_context(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void free_model(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void free_sampler(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public final native String get_eot_str(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public final native int get_n_embd(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void kv_cache_clear(long j10);

    public static /* synthetic */ Object load$default(LLamaAndroid lLamaAndroid, String str, String str2, int i10, int i11, float f8, float f9, qb.b bVar, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = 40;
        }
        int i14 = i11;
        if ((i12 & 16) != 0) {
            f8 = 0.9f;
        }
        float f10 = f8;
        if ((i12 & 32) != 0) {
            f9 = 0.7f;
        }
        return lLamaAndroid.load(str, str2, i13, i14, f10, f9, bVar);
    }

    public static /* synthetic */ Object loadForEmbedding$default(LLamaAndroid lLamaAndroid, String str, String str2, int i10, qb.b bVar, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = VadSessionManager.FRAME_BYTES;
        }
        return lLamaAndroid.loadForEmbedding(str, str2, i10, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long load_model(String str);

    private final native void log_to_android();

    /* JADX INFO: Access modifiers changed from: private */
    public final native long new_batch(int i10, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long new_context(long j10, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long new_embedding_context(long j10, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long new_sampler(float f8, int i10, float f9);

    /* JADX INFO: Access modifiers changed from: private */
    public final native String oaicompat_completion_param_parse(Map<String, String>[] mapArr, long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread runLoop$lambda$3(final LLamaAndroid lLamaAndroid, Runnable runnable) {
        pb.a aVarN = y.N("Llm-RunLoop", new b(0, lLamaAndroid, runnable), 22);
        aVarN.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: android.llama.cpp.c
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                LLamaAndroid.runLoop$lambda$3$lambda$2$lambda$1(this.f189a, thread, th);
            }
        });
        return aVarN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.concurrent.CountDownLatch] */
    public static final n runLoop$lambda$3$lambda$0(LLamaAndroid lLamaAndroid, Runnable runnable) {
        a0.a.v("Dedicated thread for native code: ", Thread.currentThread().getName(), lLamaAndroid.tag);
        try {
            try {
                System.loadLibrary("llama-android");
                lLamaAndroid.log_to_android();
                lLamaAndroid.backend_init(false);
                Log.d(lLamaAndroid.tag, lLamaAndroid.system_info());
                lLamaAndroid.nativeLibLoaded = true;
                Log.i(lLamaAndroid.tag, "Native library loaded successfully");
            } catch (Exception e10) {
                lLamaAndroid.nativeLibLoaded = false;
                lLamaAndroid.nativeLibError = "Failed to initialize native library: " + e10.getMessage();
                Log.e(lLamaAndroid.tag, lLamaAndroid.nativeLibError, e10);
            } catch (UnsatisfiedLinkError e11) {
                lLamaAndroid.nativeLibLoaded = false;
                lLamaAndroid.nativeLibError = "Failed to load native library: " + e11.getMessage();
                Log.e(lLamaAndroid.tag, lLamaAndroid.nativeLibError, e11);
            }
            runnable.run();
            return n.f10413a;
        } finally {
            lLamaAndroid.initLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runLoop$lambda$3$lambda$2$lambda$1(LLamaAndroid lLamaAndroid, Thread thread, Throwable exception) {
        g.f(exception, "exception");
        Log.e(lLamaAndroid.tag, "Unhandled exception", exception);
    }

    public static /* synthetic */ Object send$default(LLamaAndroid lLamaAndroid, String str, String str2, boolean z, qb.b bVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z = false;
        }
        return lLamaAndroid.send(str, str2, z, bVar);
    }

    private final native String system_info();

    public final Object batchEmbedding(String str, List<String> list, qb.b<? super float[][]> bVar) {
        return BuildersKt.withContext(this.runLoop, new AnonymousClass2(str, list, null), bVar);
    }

    public final Object bench(String str, int i10, int i11, int i12, int i13, qb.b<? super String> bVar) {
        return BuildersKt.withContext(this.runLoop, new C01832(str, i10, i11, i12, i13, null), bVar);
    }

    public final Object clearKvCacheForModel(String str, qb.b<? super n> bVar) {
        Object objWithContext = BuildersKt.withContext(this.runLoop, new C01842(str, null), bVar);
        return objWithContext == CoroutineSingletons.f10059a ? objWithContext : n.f10413a;
    }

    public final float cosineSimilarity(float[] embedding1, float[] embedding2) {
        g.f(embedding1, "embedding1");
        g.f(embedding2, "embedding2");
        if (embedding1.length != embedding2.length) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int length = embedding1.length;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < length; i10++) {
            float f11 = embedding1[i10];
            float f12 = embedding2[i10];
            f10 += f11 * f12;
            f8 += f11 * f11;
            f9 += f12 * f12;
        }
        float fSqrt = ((float) Math.sqrt(f8)) * ((float) Math.sqrt(f9));
        if (fSqrt > 0.0f) {
            return f10 / fSqrt;
        }
        return 0.0f;
    }

    public final Object embedding(String str, String str2, qb.b<? super float[]> bVar) {
        return BuildersKt.withContext(this.runLoop, new C01852(str, str2, null), bVar);
    }

    public final Object getEmbeddingDimension(String str, qb.b<? super Integer> bVar) {
        return BuildersKt.withContext(this.runLoop, new C01862(str, null), bVar);
    }

    public final String getEotStr(String modelId) {
        String modelEotStr;
        g.f(modelId, "modelId");
        Companion.State state = this.modelStates.get(modelId);
        Companion.State.Loaded loaded = state instanceof Companion.State.Loaded ? (Companion.State.Loaded) state : null;
        return (loaded == null || (modelEotStr = loaded.getModelEotStr()) == null) ? "<|im_end|>" : modelEotStr;
    }

    public final boolean getIsCompleteEOT() {
        return true;
    }

    public final boolean getIsMarked() {
        return false;
    }

    public final boolean getIsSending() {
        return isSending("default");
    }

    public final int getLoadedCount() {
        return this.modelStates.size();
    }

    public final Set<String> getLoadedModelIds() {
        Set<String> setKeySet = this.modelStates.keySet();
        g.e(setKeySet, "<get-keys>(...)");
        return kotlin.collections.a.R0(setKeySet);
    }

    public final String getNativeLibError() {
        return this.nativeLibError;
    }

    public final Object getTemplate(String str, List<? extends Map<String, String>> list, qb.b<? super String> bVar) {
        return BuildersKt.withContext(this.runLoop, new C01872(str, list, null), bVar);
    }

    public final boolean isEmbeddingMode(String modelId) {
        g.f(modelId, "modelId");
        return this.modelStates.get(modelId) instanceof Companion.State.EmbeddingLoaded;
    }

    public final boolean isLLMMode(String modelId) {
        g.f(modelId, "modelId");
        return this.modelStates.get(modelId) instanceof Companion.State.Loaded;
    }

    public final boolean isLoaded(String modelId) {
        g.f(modelId, "modelId");
        return this.modelStates.containsKey(modelId);
    }

    public final boolean isNativeLibAvailable() {
        if (this.initLatch.getCount() == 0) {
            return this.nativeLibLoaded;
        }
        return false;
    }

    public final boolean isSending(String modelId) {
        g.f(modelId, "modelId");
        Boolean bool = this.sendingFlags.get(modelId);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final Object load(String str, String str2, int i10, int i11, float f8, float f9, qb.b<? super n> bVar) {
        ensureNativeLibReady$default(this, 0L, 1, null);
        Object objWithContext = BuildersKt.withContext(this.runLoop, new C01882(str, str2, i10, f8, i11, f9, null), bVar);
        return objWithContext == CoroutineSingletons.f10059a ? objWithContext : n.f10413a;
    }

    public final Object loadForEmbedding(String str, String str2, int i10, qb.b<? super n> bVar) {
        ensureNativeLibReady$default(this, 0L, 1, null);
        Object objWithContext = BuildersKt.withContext(this.runLoop, new C01892(str, str2, i10, null), bVar);
        return objWithContext == CoroutineSingletons.f10059a ? objWithContext : n.f10413a;
    }

    public final Object send(String str, String str2, boolean z, qb.b<? super Flow<String>> bVar) {
        return FlowKt.flowOn(FlowKt.flow(new C01902(str, z, str2, null)), this.runLoop);
    }

    public final String send_eot_str() {
        return getEotStr("default");
    }

    public final void stopGeneration(String modelId) {
        g.f(modelId, "modelId");
        this.stopFlags.put(modelId, Boolean.TRUE);
        this.sendingFlags.put(modelId, Boolean.FALSE);
    }

    public final void stopTextGeneration() {
        stopGeneration("default");
    }

    public final Object unload(String str, qb.b<? super n> bVar) {
        Object objWithContext = BuildersKt.withContext(this.runLoop, new C01912(str, null), bVar);
        return objWithContext == CoroutineSingletons.f10059a ? objWithContext : n.f10413a;
    }

    public final Object unloadAll(qb.b<? super n> bVar) {
        Object objWithContext = BuildersKt.withContext(this.runLoop, new C01922(null), bVar);
        return objWithContext == CoroutineSingletons.f10059a ? objWithContext : n.f10413a;
    }

    public final Object unloadEmbedding(String str, qb.b<? super n> bVar) {
        Object objWithContext = BuildersKt.withContext(this.runLoop, new C01932(str, null), bVar);
        return objWithContext == CoroutineSingletons.f10059a ? objWithContext : n.f10413a;
    }

    public static /* synthetic */ Object loadForEmbedding$default(LLamaAndroid lLamaAndroid, String str, int i10, qb.b bVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = VadSessionManager.FRAME_BYTES;
        }
        return lLamaAndroid.loadForEmbedding(str, i10, bVar);
    }

    public static /* synthetic */ Object send$default(LLamaAndroid lLamaAndroid, String str, boolean z, qb.b bVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        return lLamaAndroid.send(str, z, bVar);
    }

    public final Object batchEmbedding(List<String> list, qb.b<? super float[][]> bVar) {
        return batchEmbedding("default", list, bVar);
    }

    public final Object embedding(String str, qb.b<? super float[]> bVar) {
        return embedding("default", str, bVar);
    }

    public final Object getEmbeddingDimension(qb.b<? super Integer> bVar) {
        return getEmbeddingDimension("default", bVar);
    }

    public final Object getTemplate(List<? extends Map<String, String>> list, qb.b<? super String> bVar) {
        return getTemplate("default", list, bVar);
    }

    public final boolean isEmbeddingMode() {
        return isEmbeddingMode("default");
    }

    public final Object unload(qb.b<? super n> bVar) {
        Object objUnload = unload("default", bVar);
        return objUnload == CoroutineSingletons.f10059a ? objUnload : n.f10413a;
    }

    public final Object unloadEmbedding(qb.b<? super n> bVar) {
        Object objUnloadEmbedding = unloadEmbedding("default", bVar);
        return objUnloadEmbedding == CoroutineSingletons.f10059a ? objUnloadEmbedding : n.f10413a;
    }

    public final Object load(String str, int i10, int i11, float f8, float f9, qb.b<? super n> bVar) {
        Object objLoad = load("default", str, i10, i11, f8, f9, bVar);
        return objLoad == CoroutineSingletons.f10059a ? objLoad : n.f10413a;
    }

    public final Object loadForEmbedding(String str, int i10, qb.b<? super n> bVar) {
        Object objLoadForEmbedding = loadForEmbedding("default", str, i10, bVar);
        return objLoadForEmbedding == CoroutineSingletons.f10059a ? objLoadForEmbedding : n.f10413a;
    }

    public final Object send(String str, boolean z, qb.b<? super Flow<String>> bVar) {
        return send("default", str, z, bVar);
    }
}
