package com.stepos.stepclaw.memory;

import com.stepos.stepclaw.memory.MemoryEngine;
import com.stepos.stepclaw.memory.lightmem.remote.CatchMemoryItem;
import com.stepos.stepclaw.openclaw.memory.FsAppendMmrResult;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1749a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1750b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1751c;

    public /* synthetic */ t(Object obj, int i8, Object obj2) {
        this.f1749a = i8;
        this.f1750b = obj;
        this.f1751c = obj2;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1749a) {
            case 0:
                return MemoryEngine.AnonymousClass1.invokeSuspend$lambda$0((List) this.f1750b, (List) this.f1751c);
            case 1:
                return MemoryBridgeImpl.beforeSendMessage$lambda$0((p5.a) this.f1750b, (MemoryBridgeImpl) this.f1751c);
            case 2:
                return MemoryEngine.writeCategoryMemoryToDailyRemote$lambda$0((String) this.f1750b, (FsAppendMmrResult) this.f1751c);
            default:
                return MemoryEngine.writeCategoryMemoryToDaily$lambda$2((String) this.f1750b, (CatchMemoryItem) this.f1751c);
        }
    }
}
