package com.stepos.stepclaw.memory.embedding;

import com.stepos.stepclaw.memory.embedding.EmbeddingStorage;
import java.util.List;
import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1600a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1601b;

    public /* synthetic */ l(int i8, Object obj) {
        this.f1600a = i8;
        this.f1601b = obj;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1600a;
        Object obj = this.f1601b;
        switch (i8) {
            case 0:
                return EmbeddingStorage.C00432.invokeSuspend$lambda$1((List) obj);
            case 1:
                return EmbeddingStorage.C00432.invokeSuspend$lambda$7((w) obj);
            case 2:
                return EmbeddingQueue.processTask$lambda$1((EmbeddingTask) obj);
            case 3:
                return EmbeddingStorage.delete$lambda$0((String) obj);
            default:
                return EmbeddingStorage.parseEntry$lambda$2((IllegalArgumentException) obj);
        }
    }
}
