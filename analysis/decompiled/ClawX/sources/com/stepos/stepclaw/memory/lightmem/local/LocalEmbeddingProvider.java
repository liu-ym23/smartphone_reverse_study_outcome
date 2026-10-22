package com.stepos.stepclaw.memory.lightmem.local;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.embedding.EmbeddingProvider;
import h5.c;
import h5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096@¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\n8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\n8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/local/LocalEmbeddingProvider;", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingProvider;", "Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferenceEngine;", "engine", "<init>", "(Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferenceEngine;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isAvailable", "()Z", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "texts", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "embed", "(Ljava/util/List;Lf5/c;)Ljava/lang/Object;", "Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferenceEngine;", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "displayName", "getDisplayName", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LocalEmbeddingProvider implements EmbeddingProvider {
    public static final String ID = "local-stepinfer-emb";
    private final String displayName;
    private final LocalInferenceEngine engine;
    private final String id;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.memory.lightmem.local.LocalEmbeddingProvider", f = "LocalEmbeddingProvider.kt", l = {37}, m = "embed", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.local.LocalEmbeddingProvider$embed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalEmbeddingProvider.this.embed(null, this);
        }
    }

    public LocalEmbeddingProvider(LocalInferenceEngine engine) {
        p.e(engine, "engine");
        this.engine = engine;
        this.id = "local-stepinfer-emb";
        this.displayName = "Local StepOS BGE Embedding";
        EmbeddingProvider.INSTANCE.requireValidId(getId());
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.stepclaw.memory.embedding.EmbeddingProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object embed(java.util.List<java.lang.String> r11, f5.c r12) throws com.stepos.stepclaw.memory.embedding.EmbeddingException {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.stepos.stepclaw.memory.lightmem.local.LocalEmbeddingProvider.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r12
            com.stepos.stepclaw.memory.lightmem.local.LocalEmbeddingProvider$embed$1 r0 = (com.stepos.stepclaw.memory.lightmem.local.LocalEmbeddingProvider.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.stepos.stepclaw.memory.lightmem.local.LocalEmbeddingProvider$embed$1 r0 = new com.stepos.stepclaw.memory.lightmem.local.LocalEmbeddingProvider$embed$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r4.result
            g5.a r0 = g5.a.f2984a
            int r1 = r4.label
            r7 = 2
            java.lang.String r8 = "LocalEmbeddingProvider("
            r2 = 1
            r9 = 0
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L37
            java.lang.Object r11 = r4.L$0
            java.util.List r11 = (java.util.List) r11
            a.a.c0(r12)     // Catch: java.lang.Exception -> L31 com.stepos.stepclaw.memory.lightmem.local.LocalInferenceException -> L34
            goto L5c
        L31:
            r0 = move-exception
            r11 = r0
            goto L5f
        L34:
            r0 = move-exception
            r11 = r0
            goto L84
        L37:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3f:
            a.a.c0(r12)
            boolean r12 = r11.isEmpty()
            if (r12 == 0) goto L4b
            c5.s r10 = c5.s.f1092a
            return r10
        L4b:
            com.stepos.stepclaw.memory.lightmem.local.LocalInferenceEngine r1 = r10.engine     // Catch: java.lang.Exception -> L31 com.stepos.stepclaw.memory.lightmem.local.LocalInferenceException -> L34
            r4.L$0 = r9     // Catch: java.lang.Exception -> L31 com.stepos.stepclaw.memory.lightmem.local.LocalInferenceException -> L34
            r4.label = r2     // Catch: java.lang.Exception -> L31 com.stepos.stepclaw.memory.lightmem.local.LocalInferenceException -> L34
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r11
            java.lang.Object r12 = com.stepos.stepclaw.memory.lightmem.local.LocalInferenceEngine.embedAllTexts$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L31 com.stepos.stepclaw.memory.lightmem.local.LocalInferenceException -> L34
            if (r12 != r0) goto L5c
            return r0
        L5c:
            java.util.List r12 = (java.util.List) r12     // Catch: java.lang.Exception -> L31 com.stepos.stepclaw.memory.lightmem.local.LocalInferenceException -> L34
            return r12
        L5f:
            com.stepos.stepclaw.memory.embedding.EmbeddingException r12 = new com.stepos.stepclaw.memory.embedding.EmbeddingException
            java.lang.String r10 = r10.getId()
            java.lang.Class r0 = r11.getClass()
            java.lang.String r0 = r0.getSimpleName()
            java.lang.String r11 = r11.getMessage()
            java.lang.String r1 = ") embed failed ("
            java.lang.String r2 = "): "
            java.lang.StringBuilder r10 = a8.b.v(r8, r10, r1, r0, r2)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r12.<init>(r10, r9, r7, r9)
            throw r12
        L84:
            com.stepos.stepclaw.memory.embedding.EmbeddingException r12 = new com.stepos.stepclaw.memory.embedding.EmbeddingException
            java.lang.String r10 = r10.getId()
            java.lang.String r11 = r11.getMessage()
            java.lang.String r0 = ") embed failed: "
            java.lang.String r10 = a8.b.p(r8, r10, r0, r11)
            r12.<init>(r10, r9, r7, r9)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.lightmem.local.LocalEmbeddingProvider.embed(java.util.List, f5.c):java.lang.Object");
    }

    @Override // com.stepos.stepclaw.memory.embedding.EmbeddingProvider
    public String getDisplayName() {
        return this.displayName;
    }

    @Override // com.stepos.stepclaw.memory.embedding.EmbeddingProvider
    public String getId() {
        return this.id;
    }

    @Override // com.stepos.stepclaw.memory.embedding.EmbeddingProvider
    public boolean isAvailable() {
        return this.engine.isReady() && this.engine.getEmbeddingEnabled();
    }
}
