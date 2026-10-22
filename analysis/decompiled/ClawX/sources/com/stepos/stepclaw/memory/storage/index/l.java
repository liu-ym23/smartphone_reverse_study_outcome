package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;
import java.util.Set;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1736a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set f1737b;

    public /* synthetic */ l(int i8, Set set) {
        this.f1736a = i8;
        this.f1737b = set;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1736a;
        Set set = this.f1737b;
        switch (i8) {
            case 0:
                return MemoryIndexManager.C00582.invokeSuspend$lambda$0$7(set);
            default:
                return MemoryIndexManager.loadPermanentIndexOptimized$lambda$0(set);
        }
    }
}
