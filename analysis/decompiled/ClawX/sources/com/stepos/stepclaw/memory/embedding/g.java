package com.stepos.stepclaw.memory.embedding;

import com.stepos.stepclaw.memory.storage.MemoryStorage;
import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1587a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1588b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1589c;
    public final /* synthetic */ Object d;

    public /* synthetic */ g(RemoteEmbeddingProvider remoteEmbeddingProvider, List list, String str) {
        this.f1587a = 1;
        this.f1589c = remoteEmbeddingProvider;
        this.d = list;
        this.f1588b = str;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1587a) {
            case 0:
                return EmbeddingStorage.append$lambda$3((String) this.f1588b, (String) this.f1589c, (Exception) this.d);
            case 1:
                return RemoteEmbeddingProvider.embed$lambda$2((RemoteEmbeddingProvider) this.f1589c, (List) this.d, (String) this.f1588b);
            case 2:
                return MemoryStorage.migrateMdToJsonl$lambda$3((File) this.f1588b, (File) this.f1589c, (ArrayList) this.d);
            case 3:
                return MemoryIndexManager.loadDynamicIndexOptimized$lambda$3((String) this.f1588b, (List) this.f1589c, (ArrayList) this.d);
            default:
                n6.e eVar = (n6.e) this.f1588b;
                n6.j jVar = (n6.j) this.f1589c;
                n6.a aVar = (n6.a) this.d;
                z6.d dVar = eVar.f4012b;
                p.b(dVar);
                return dVar.clean(jVar.a(), aVar.f3992h.d);
        }
    }

    public /* synthetic */ g(Object obj, Object obj2, Object obj3, int i8) {
        this.f1587a = i8;
        this.f1588b = obj;
        this.f1589c = obj2;
        this.d = obj3;
    }
}
