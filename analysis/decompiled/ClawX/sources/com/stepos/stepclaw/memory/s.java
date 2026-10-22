package com.stepos.stepclaw.memory;

import com.stepos.stepclaw.memory.MemoryEngine;
import com.stepos.stepclaw.memory.lightmem.LightMemClient;
import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class s implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1680a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1681b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1682c;
    public final /* synthetic */ Object d;

    public /* synthetic */ s(Object obj, Object obj2, Object obj3, int i8) {
        this.f1680a = i8;
        this.f1681b = obj;
        this.f1682c = obj2;
        this.d = obj3;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1680a) {
            case 0:
                return MemoryEngine.AnonymousClass3.invokeSuspend$lambda$0$2$1((String) this.f1681b, (List) this.f1682c, (w) this.d);
            default:
                return MemoryDumpCommandHandler.dumpOfflineTrigger$lambda$2((LightMemClient) this.f1681b, (File) this.f1682c, (OfflineEvolutionService) this.d);
        }
    }
}
