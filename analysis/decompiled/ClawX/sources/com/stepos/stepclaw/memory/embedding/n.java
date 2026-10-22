package com.stepos.stepclaw.memory.embedding;

import java.util.List;
import kotlinx.serialization.json.JsonArrayBuilder;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements p5.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1605a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1606b;

    public /* synthetic */ n(int i8, Object obj) {
        this.f1605a = i8;
        this.f1606b = obj;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        int i8 = this.f1605a;
        Object obj2 = this.f1606b;
        switch (i8) {
            case 0:
                return RemoteEmbeddingProvider.httpClient$lambda$0$0((RemoteEmbeddingProvider) obj2, (b4.c) obj);
            case 1:
                return RemoteEmbeddingProvider.httpClient$lambda$0((RemoteEmbeddingProvider) obj2, (t3.d) obj);
            default:
                return RemoteEmbeddingProvider.embed$lambda$0$0((List) obj2, (JsonArrayBuilder) obj);
        }
    }
}
