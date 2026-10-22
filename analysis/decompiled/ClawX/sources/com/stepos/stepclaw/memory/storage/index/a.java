package com.stepos.stepclaw.memory.storage.index;

import java.io.File;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1714a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1715b;

    public /* synthetic */ a(int i8, Object obj) {
        this.f1714a = i8;
        this.f1715b = obj;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1714a;
        Object obj = this.f1715b;
        switch (i8) {
            case 0:
                return BM25Index.evictOneDynamic$lambda$5((DocMeta) obj);
            default:
                return MemoryIndexManager.extractLegacyRecords$lambda$1((File) obj);
        }
    }
}
