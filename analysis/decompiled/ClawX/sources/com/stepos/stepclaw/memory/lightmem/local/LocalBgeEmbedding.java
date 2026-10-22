package com.stepos.stepclaw.memory.lightmem.local;

import a6.f0;
import a6.i0;
import a6.r0;
import android.content.Context;
import android.os.RemoteException;
import b5.a0;
import c5.l;
import c5.s;
import com.meizu.aiservice.api.bean.FloatMatrix;
import com.stepos.stepclaw.SecurePrefs;
import d3.b;
import h5.e;
import h5.i;
import h6.d;
import java.util.List;
import kotlin.Metadata;
import m0.f;
import p5.a;
import p5.p;
import q2.c;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017J$\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00132\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0004\b\u001b\u0010\u0017J\r\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\tR\u001c\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b-\u0010(R,\u00102\u001a\u001a\u0012\b\u0012\u00060\u000bj\u0002`\f0.j\f\u0012\b\u0012\u00060\u000bj\u0002`\f`/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0011\u00103\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b3\u0010\"¨\u00064"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/local/LocalBgeEmbedding;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/Function0;", "Landroid/content/Context;", "hostContext", "<init>", "(Lp5/a;)V", "Lb5/a0;", "invalidateCache", "()V", "context", "Lq2/c;", "Lcom/stepos/aiservice/algorithm/embedding/IEmbedding;", "obtainEmbedding", "(Landroid/content/Context;)Lq2/c;", "override", "requireContext", "(Landroid/content/Context;)Landroid/content/Context;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "texts", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "embed", "(Ljava/util/List;Landroid/content/Context;Lf5/c;)Ljava/lang/Object;", "text", "embedText", "(Ljava/lang/String;Landroid/content/Context;Lf5/c;)Ljava/lang/Object;", "embedAll", "release", "Lp5/a;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "embeddingEnabled", "Z", "getEmbeddingEnabled", "()Z", "setEmbeddingEnabled", "(Z)V", "cachedEmbedding", "Lq2/c;", "cachedLoadKey", "Ljava/lang/String;", "cachedLoadContext", "Landroid/content/Context;", "initLock", "Ljava/lang/Object;", "modelRelativePath", "Ld3/b;", "Lcom/stepos/aiservice/client/AlgorithmClient;", "getEmbeddingAlgorithmClient", "()Ld3/b;", "embeddingAlgorithmClient", "isLoaded", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LocalBgeEmbedding {
    private volatile c cachedEmbedding;
    private volatile Context cachedLoadContext;
    private volatile String cachedLoadKey;
    private volatile boolean embeddingEnabled;
    private final a hostContext;
    private final Object initLock;
    private final String modelRelativePath;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0014\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.memory.lightmem.local.LocalBgeEmbedding$embed$2", f = "LocalBgeEmbedding.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.local.LocalBgeEmbedding$embed$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ Context $context;
        final /* synthetic */ List<String> $texts;
        int label;
        final /* synthetic */ LocalBgeEmbedding this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<String> list, LocalBgeEmbedding localBgeEmbedding, Context context, f5.c cVar) {
            super(2, cVar);
            this.$texts = list;
            this.this$0 = localBgeEmbedding;
            this.$context = context;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new AnonymousClass2(this.$texts, this.this$0, this.$context, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass2) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) throws LocalInferenceException {
            g5.a aVar = g5.a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            if (this.$texts.isEmpty()) {
                return s.f1092a;
            }
            if (!this.this$0.getEmbeddingEnabled()) {
                throw new LocalInferenceException("端侧 BGE 向量化已关闭 (embeddingEnabled=false)", null, 2, null);
            }
            LocalBgeEmbedding localBgeEmbedding = this.this$0;
            c cVarObtainEmbedding = localBgeEmbedding.obtainEmbedding(localBgeEmbedding.requireContext(this.$context));
            try {
                if (this.$texts.size() == 1) {
                    return a.a.S(((q2.a) cVarObtainEmbedding).a(this.$texts.get(0)));
                }
                FloatMatrix floatMatrixB = ((q2.a) cVarObtainEmbedding).b(this.$texts);
                kotlin.jvm.internal.p.d(floatMatrixB, "embedAll(...)");
                float[][] matrix = floatMatrixB.getMatrix();
                kotlin.jvm.internal.p.d(matrix, "getMatrix(...)");
                return l.j0(matrix);
            } catch (RemoteException e9) {
                this.this$0.invalidateCache();
                throw new LocalInferenceException(f.c("BGE embed failed: ", e9.getMessage()), e9);
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.memory.lightmem.local.LocalBgeEmbedding", f = "LocalBgeEmbedding.kt", l = {82}, m = "embedText", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.local.LocalBgeEmbedding$embedText$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalBgeEmbedding.this.embedText(null, null, this);
        }
    }

    public LocalBgeEmbedding(a hostContext) {
        kotlin.jvm.internal.p.e(hostContext, "hostContext");
        this.hostContext = hostContext;
        this.embeddingEnabled = true;
        this.initLock = new Object();
        this.modelRelativePath = "models/embedding_bge";
    }

    public static /* synthetic */ Object embed$default(LocalBgeEmbedding localBgeEmbedding, List list, Context context, f5.c cVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            context = null;
        }
        return localBgeEmbedding.embed(list, context, cVar);
    }

    public static /* synthetic */ Object embedAll$default(LocalBgeEmbedding localBgeEmbedding, List list, Context context, f5.c cVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            context = null;
        }
        return localBgeEmbedding.embedAll(list, context, cVar);
    }

    public static /* synthetic */ Object embedText$default(LocalBgeEmbedding localBgeEmbedding, String str, Context context, f5.c cVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            context = null;
        }
        return localBgeEmbedding.embedText(str, context, cVar);
    }

    private final b getEmbeddingAlgorithmClient() {
        b embeddingBge = e3.e.f2363b;
        kotlin.jvm.internal.p.d(embeddingBge, "embeddingBge");
        return embeddingBge;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateCache() {
        synchronized (this.initLock) {
            this.cachedEmbedding = null;
            this.cachedLoadKey = null;
            this.cachedLoadContext = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0037 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:12:0x0024, B:14:0x0028, B:22:0x0037, B:24:0x0040, B:26:0x0047, B:28:0x0059, B:31:0x0061, B:32:0x0077, B:25:0x0044), top: B:35:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final q2.c obtainEmbedding(android.content.Context r8) {
        /*
            r7 = this;
            java.lang.String r0 = "BGE embedding algorithm not loaded (modelDir="
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "/data/data/com.stepos.superalgorithmservice/files"
            java.lang.String r3 = r7.modelRelativePath
            r1.<init>(r2, r3)
            java.lang.String r1 = r1.getAbsolutePath()
            q2.c r2 = r7.cachedEmbedding
            r3 = 0
            if (r2 == 0) goto L21
            java.lang.String r4 = r7.cachedLoadKey
            boolean r4 = kotlin.jvm.internal.p.a(r4, r1)
            if (r4 == 0) goto L1d
            goto L1e
        L1d:
            r2 = r3
        L1e:
            if (r2 == 0) goto L21
            return r2
        L21:
            java.lang.Object r2 = r7.initLock
            monitor-enter(r2)
            q2.c r4 = r7.cachedEmbedding     // Catch: java.lang.Throwable -> L35
            if (r4 == 0) goto L37
            java.lang.String r5 = r7.cachedLoadKey     // Catch: java.lang.Throwable -> L35
            boolean r5 = kotlin.jvm.internal.p.a(r5, r1)     // Catch: java.lang.Throwable -> L35
            if (r5 == 0) goto L31
            goto L32
        L31:
            r4 = r3
        L32:
            if (r4 == 0) goto L37
            goto L5f
        L35:
            r7 = move-exception
            goto L78
        L37:
            android.os.Bundle r4 = new android.os.Bundle     // Catch: java.lang.Throwable -> L35
            r4.<init>()     // Catch: java.lang.Throwable -> L35
            java.lang.String r5 = "path"
            if (r1 != 0) goto L44
            r4.remove(r5)     // Catch: java.lang.Throwable -> L35
            goto L47
        L44:
            r4.putString(r5, r1)     // Catch: java.lang.Throwable -> L35
        L47:
            java.lang.String r5 = "init_strategy"
            r6 = 2
            r4.putInt(r5, r6)     // Catch: java.lang.Throwable -> L35
            d3.b r5 = r7.getEmbeddingAlgorithmClient()     // Catch: java.lang.Throwable -> L35
            android.os.IInterface r4 = r5.d(r8, r4)     // Catch: java.lang.Throwable -> L35
            q2.c r4 = (q2.c) r4     // Catch: java.lang.Throwable -> L35
            if (r4 == 0) goto L61
            r7.cachedEmbedding = r4     // Catch: java.lang.Throwable -> L35
            r7.cachedLoadKey = r1     // Catch: java.lang.Throwable -> L35
            r7.cachedLoadContext = r8     // Catch: java.lang.Throwable -> L35
        L5f:
            monitor-exit(r2)
            return r4
        L61:
            com.stepos.stepclaw.memory.lightmem.local.LocalInferenceException r7 = new com.stepos.stepclaw.memory.lightmem.local.LocalInferenceException     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L35
            r8.append(r1)     // Catch: java.lang.Throwable -> L35
            java.lang.String r0 = ")"
            r8.append(r0)     // Catch: java.lang.Throwable -> L35
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L35
            r7.<init>(r8, r3, r6, r3)     // Catch: java.lang.Throwable -> L35
            throw r7     // Catch: java.lang.Throwable -> L35
        L78:
            monitor-exit(r2)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.lightmem.local.LocalBgeEmbedding.obtainEmbedding(android.content.Context):q2.c");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context requireContext(Context override) throws LocalInferenceException {
        if (override != null) {
            return override;
        }
        Context context = (Context) this.hostContext.invoke();
        if (context != null) {
            return context;
        }
        throw new LocalInferenceException("需要 Context：先调用 loadAlgorithm(application) 或向 embed* 显式传入 context", null, 2, null);
    }

    public final Object embed(List<String> list, Context context, f5.c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(d.f3059c, new AnonymousClass2(list, this, context, null), cVar);
    }

    public final Object embedAll(List<String> list, Context context, f5.c cVar) {
        return embed(list, context, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object embedText(java.lang.String r5, android.content.Context r6, f5.c r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.stepclaw.memory.lightmem.local.LocalBgeEmbedding.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.stepclaw.memory.lightmem.local.LocalBgeEmbedding$embedText$1 r0 = (com.stepos.stepclaw.memory.lightmem.local.LocalBgeEmbedding.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.stepclaw.memory.lightmem.local.LocalBgeEmbedding$embedText$1 r0 = new com.stepos.stepclaw.memory.lightmem.local.LocalBgeEmbedding$embedText$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            g5.a r1 = g5.a.f2984a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$1
            android.content.Context r4 = (android.content.Context) r4
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            a.a.c0(r7)
            goto L4c
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            a.a.c0(r7)
            java.util.List r5 = a.a.S(r5)
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r4.embed(r5, r6, r0)
            if (r7 != r1) goto L4c
            return r1
        L4c:
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r4 = c5.m.u0(r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.lightmem.local.LocalBgeEmbedding.embedText(java.lang.String, android.content.Context, f5.c):java.lang.Object");
    }

    public final boolean getEmbeddingEnabled() {
        return this.embeddingEnabled;
    }

    public final boolean isLoaded() {
        return this.cachedEmbedding != null;
    }

    public final void release() {
        synchronized (this.initLock) {
            try {
                Context context = this.cachedLoadContext;
                if (context != null) {
                    try {
                        getEmbeddingAlgorithmClient().e(context);
                    } catch (Throwable th) {
                        a.a.o(th);
                    }
                }
                this.cachedEmbedding = null;
                this.cachedLoadKey = null;
                this.cachedLoadContext = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void setEmbeddingEnabled(boolean z) {
        this.embeddingEnabled = z;
    }
}
