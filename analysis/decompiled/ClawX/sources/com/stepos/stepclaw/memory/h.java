package com.stepos.stepclaw.memory;

import com.stepos.stepclaw.memory.MemoryDumpCommandHandler;
import com.stepos.stepclaw.memory.MemoryEngine;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineSearchGroup;
import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1612a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1613b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1614c;

    public /* synthetic */ h(Object obj, int i8, int i9) {
        this.f1612a = i9;
        this.f1613b = i8;
        this.f1614c = obj;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1612a) {
            case 0:
                return MemoryDumpCommandHandler.AnonymousClass4.invokeSuspend$lambda$7$0(this.f1613b, (OfflineSearchGroup) this.f1614c);
            default:
                return MemoryEngine.AnonymousClass3.invokeSuspend$lambda$0$4(this.f1613b, (w) this.f1614c);
        }
    }
}
