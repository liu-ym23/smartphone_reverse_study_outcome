package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.memory.storage.file.SingleMemoryFile;
import java.util.List;
import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1719a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1720b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1721c;

    public /* synthetic */ d(Object obj, int i8, Object obj2) {
        this.f1719a = i8;
        this.f1720b = obj;
        this.f1721c = obj2;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1719a) {
            case 0:
                return BM25Index.compactDynamic$lambda$0((w) this.f1720b, (BM25Index) this.f1721c);
            case 1:
                return MemoryIndexManager.loadPermanentIndexOptimized$lambda$2((String) this.f1720b, (SingleMemoryFile) this.f1721c);
            case 2:
                return MemoryIndexManager.loadDynamicIndexOptimized$lambda$7((String) this.f1720b, (String) this.f1721c);
            case 3:
                return MemoryIndexManager.indexSingleFileForced$lambda$2((SingleMemoryFile) this.f1720b, (List) this.f1721c);
            case 4:
                return MemoryIndexManager.indexSingleFileForced$lambda$3((IndexTier) this.f1721c, (w) this.f1720b);
            default:
                return MemoryIndexManager.indexSingleFileForced$lambda$6((SingleMemoryFile) this.f1721c, (w) this.f1720b);
        }
    }

    public /* synthetic */ d(Object obj, w wVar, int i8) {
        this.f1719a = i8;
        this.f1721c = obj;
        this.f1720b = wVar;
    }
}
