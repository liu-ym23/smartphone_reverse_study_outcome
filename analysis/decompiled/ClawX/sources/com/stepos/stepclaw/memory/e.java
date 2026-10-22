package com.stepos.stepclaw.memory;

import com.stepos.stepclaw.memory.MemoryDumpCommandHandler;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1576a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f1577b;

    public /* synthetic */ e(int i8, List list) {
        this.f1576a = i8;
        this.f1577b = list;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1576a;
        List list = this.f1577b;
        switch (i8) {
            case 0:
                return MemoryDumpCommandHandler.AnonymousClass4.invokeSuspend$lambda$3(list);
            default:
                return MemoryEngine.backfillEmbeddingsInternal$lambda$1(list);
        }
    }
}
