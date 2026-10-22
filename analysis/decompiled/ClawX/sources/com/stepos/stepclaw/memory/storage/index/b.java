package com.stepos.stepclaw.memory.storage.index;

import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1716a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f1717b;

    public /* synthetic */ b(int i8, w wVar) {
        this.f1716a = i8;
        this.f1717b = wVar;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1716a;
        w wVar = this.f1717b;
        switch (i8) {
            case 0:
                return BM25Index.unloadDynamic$lambda$2(wVar);
            case 1:
                return MemoryIndexManager.loadPermanentIndexOptimized$lambda$1(wVar);
            case 2:
                return MemoryIndexManager.loadDynamicIndex$lambda$2(wVar);
            case 3:
                return MemoryIndexManager.loadDynamicIndexOptimized$lambda$4(wVar);
            default:
                return MemoryIndexManager.loadPermanentIndex$lambda$0(wVar);
        }
    }
}
