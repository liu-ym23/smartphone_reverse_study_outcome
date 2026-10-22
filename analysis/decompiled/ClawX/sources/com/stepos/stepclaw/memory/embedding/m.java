package com.stepos.stepclaw.memory.embedding;

import com.stepos.stepclaw.memory.embedding.EmbeddingStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1602a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1603b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1604c;

    public /* synthetic */ m(Object obj, int i8, Object obj2) {
        this.f1602a = i8;
        this.f1604c = obj;
        this.f1603b = obj2;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1602a) {
            case 0:
                return EmbeddingStorage.C00432.invokeSuspend$lambda$2((ArrayList) this.f1604c, (List) this.f1603b);
            case 1:
                return EmbeddingStorage.C00432.invokeSuspend$lambda$4((List) this.f1603b, (Exception) this.f1604c);
            case 2:
                return EmbeddingStorage.C00432.invokeSuspend$lambda$5((List) this.f1603b, (List) this.f1604c);
            case 3:
                return EmbeddingQueue.processTask$lambda$0((EmbeddingProvider) this.f1604c, (EmbeddingTask) this.f1603b);
            case 4:
                return EmbeddingQueue.processTask$lambda$3((EmbeddingTask) this.f1604c, (List) this.f1603b);
            case 5:
                return EmbeddingQueue.processTask$lambda$4((EmbeddingTask) this.f1604c, (Exception) this.f1603b);
            case 6:
                return EmbeddingStorage.wipeAll$lambda$2((w) this.f1604c, (EmbeddingStorage) this.f1603b);
            case 7:
                return EmbeddingStorage.deleteAll$lambda$1((w) this.f1604c, (Set) this.f1603b);
            default:
                return RemoteEmbeddingProvider.parseErrorResponse$lambda$2((RemoteEmbeddingProvider) this.f1604c, (String) this.f1603b);
        }
    }

    public /* synthetic */ m(List list, Object obj, int i8) {
        this.f1602a = i8;
        this.f1603b = list;
        this.f1604c = obj;
    }
}
