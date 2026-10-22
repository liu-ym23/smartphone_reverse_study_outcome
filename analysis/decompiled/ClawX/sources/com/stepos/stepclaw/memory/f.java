package com.stepos.stepclaw.memory;

import com.stepos.stepclaw.memory.MemoryDumpCommandHandler;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineTriggerResponse;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateResponse;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1607a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f1608b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1609c;

    public /* synthetic */ f(int i8, long j4, Object obj) {
        this.f1607a = i8;
        this.f1608b = j4;
        this.f1609c = obj;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1607a) {
            case 0:
                return MemoryDumpCommandHandler.AnonymousClass4.invokeSuspend$lambda$4(this.f1608b, (OfflineTriggerResponse) this.f1609c);
            case 1:
                return MemoryDumpCommandHandler.AnonymousClass4.invokeSuspend$lambda$8(this.f1608b, (Exception) this.f1609c);
            default:
                return MemoryDumpCommandHandler.AnonymousClass3.invokeSuspend$lambda$0(this.f1608b, (OfflineUpdateResponse) this.f1609c);
        }
    }
}
