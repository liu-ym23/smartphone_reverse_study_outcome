package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1728a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1729b;

    public /* synthetic */ h(String str, int i8) {
        this.f1728a = i8;
        this.f1729b = str;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1728a;
        String str = this.f1729b;
        switch (i8) {
            case 0:
                return MemoryIndexManager.C00582.invokeSuspend$lambda$0$0(str);
            case 1:
                return BM25Index.indexDocument$lambda$1(str);
            case 2:
                return BM25Index.indexDocument$lambda$2(str);
            case 3:
                return MemoryIndexManager.loadPermanentIndexOptimized$lambda$3(str);
            case 4:
                return MemoryIndexManager.loadPermanentIndexOptimized$lambda$6(str);
            default:
                return MemoryIndexManager.indexSingleFileForced$lambda$5(str);
        }
    }
}
