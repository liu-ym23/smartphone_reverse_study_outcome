package com.stepos.stepclaw.memory.embedding;

import kotlinx.serialization.json.JsonBuilder;
import z3.r0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements p5.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1584a;

    public /* synthetic */ d(int i8) {
        this.f1584a = i8;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        switch (this.f1584a) {
            case 0:
                return EmbeddingStorage.loadTombstones$lambda$0$0((String) obj);
            case 1:
                return Boolean.valueOf(EmbeddingStorage.loadTombstones$lambda$0$1((String) obj));
            case 2:
                return RemoteEmbeddingProvider.httpClient$lambda$0$1((r0) obj);
            default:
                return RemoteEmbeddingProvider.json$lambda$0((JsonBuilder) obj);
        }
    }
}
