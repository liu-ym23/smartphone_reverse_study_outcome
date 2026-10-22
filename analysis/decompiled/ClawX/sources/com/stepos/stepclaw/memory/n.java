package com.stepos.stepclaw.memory;

import com.stepos.stepclaw.memory.embedding.EmbeddingClient;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1670a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EmbeddingClient f1671b;

    public /* synthetic */ n(EmbeddingClient embeddingClient, int i8) {
        this.f1670a = i8;
        this.f1671b = embeddingClient;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1670a;
        EmbeddingClient embeddingClient = this.f1671b;
        switch (i8) {
            case 0:
                return MemoryEngine.maybeTriggerDeferredBackfill$lambda$0(embeddingClient);
            case 1:
                return MemoryEngine.backfillEmbeddingsInternal$lambda$0(embeddingClient);
            default:
                return MemoryEngine.updateEmbeddingConfig$lambda$1(embeddingClient);
        }
    }
}
