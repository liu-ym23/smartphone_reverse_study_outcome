package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1733a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1734b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1735c;
    public final /* synthetic */ int d;

    public /* synthetic */ k(int i8, int i9, String str, String str2) {
        this.f1733a = i9;
        this.f1734b = str;
        this.f1735c = str2;
        this.d = i8;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1733a) {
            case 0:
                return MemoryIndexManager.C00582.invokeSuspend$lambda$0$6(this.d, this.f1734b, (String) this.f1735c);
            case 1:
                return MemoryIndexManager.loadDynamicIndexOptimized$lambda$5(this.f1734b, (String) this.f1735c, this.d);
            case 2:
                return MemoryIndexManager.loadDynamicIndexOptimized$lambda$6(this.f1734b, (String) this.f1735c, this.d);
            default:
                return BM25Index.indexDocument$lambda$0((IndexTier) this.f1735c, this.f1734b, this.d);
        }
    }

    public /* synthetic */ k(int i8, String str, String str2) {
        this.f1733a = 0;
        this.d = i8;
        this.f1734b = str;
        this.f1735c = str2;
    }

    public /* synthetic */ k(IndexTier indexTier, String str, int i8) {
        this.f1733a = 3;
        this.f1735c = indexTier;
        this.f1734b = str;
        this.d = i8;
    }
}
