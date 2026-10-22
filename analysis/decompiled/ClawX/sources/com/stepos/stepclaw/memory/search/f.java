package com.stepos.stepclaw.memory.search;

import com.stepos.stepclaw.memory.embedding.EmbeddingProvider;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1697a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1698b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Serializable f1699c;
    public final /* synthetic */ Object d;

    public /* synthetic */ f(Object obj, Serializable serializable, Object obj2, int i8) {
        this.f1697a = i8;
        this.f1698b = obj;
        this.f1699c = serializable;
        this.d = obj2;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1697a) {
            case 0:
                return RetrievalStage$execute$2$jobs$1$1$1.invokeSuspend$lambda$1((MemoryRetriever) this.f1698b, (String) this.f1699c, (Exception) this.d);
            case 1:
                return FormatStage.execute$lambda$4((ArrayList) this.f1698b, (w) this.f1699c, (FormatStage) this.d);
            default:
                return VectorRetriever.retrieve$lambda$1((String) this.f1699c, (EmbeddingProvider) this.f1698b, (Exception) this.d);
        }
    }

    public /* synthetic */ f(String str, EmbeddingProvider embeddingProvider, Exception exc) {
        this.f1697a = 2;
        this.f1699c = str;
        this.f1698b = embeddingProvider;
        this.d = exc;
    }
}
