package com.stepos.stepclaw.memory.search;

import com.stepos.stepclaw.memory.storage.file.SingleMemoryFile;
import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;
import java.io.File;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1691a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1692b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1693c;

    public /* synthetic */ d(File file, int i8) {
        this.f1691a = 2;
        this.f1693c = file;
        this.f1692b = i8;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1691a) {
            case 0:
                return RerankStage.execute$lambda$0$0(this.f1692b, (RetrievalResult) this.f1693c);
            case 1:
                return RerankStage.execute$lambda$7(this.f1692b, (List) this.f1693c);
            case 2:
                return MemoryIndexManager.indexLegacyFiles$lambda$0((File) this.f1693c, this.f1692b);
            default:
                return MemoryIndexManager.indexSingleFileForced$lambda$0(this.f1692b, (SingleMemoryFile) this.f1693c);
        }
    }

    public /* synthetic */ d(Object obj, int i8, int i9) {
        this.f1691a = i9;
        this.f1692b = i8;
        this.f1693c = obj;
    }
}
