package com.stepos.stepclaw.memory.storage;

import com.stepos.stepclaw.memory.storage.MemoryStorage;
import com.stepos.stepclaw.memory.storage.file.DailyMemoryFile;
import com.stepos.stepclaw.memory.storage.file.SingleMemoryFile;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1707a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1708b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1709c;

    public /* synthetic */ e(Object obj, int i8, Object obj2) {
        this.f1707a = i8;
        this.f1708b = obj;
        this.f1709c = obj2;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1707a) {
            case 0:
                return MemoryStorage.AnonymousClass2.invokeSuspend$lambda$2((String) this.f1708b, (String) this.f1709c);
            case 1:
                return MemoryStorage.C00552.invokeSuspend$lambda$1((DailyMemoryFile) this.f1708b, (Exception) this.f1709c);
            case 2:
                return MemoryStorage.C00552.invokeSuspend$lambda$4((SingleMemoryFile) this.f1708b, (Exception) this.f1709c);
            case 3:
                return MemoryStorage.migrateMdToJsonl$lambda$4((File) this.f1708b, (Exception) this.f1709c);
            case 4:
                return MemoryStorage.migrateMdToJsonl$lambda$5((w) this.f1708b, (w) this.f1709c);
            default:
                return MemoryStorage.migrateAgentToAgentIdentity$lambda$3((w) this.f1708b, (List) this.f1709c);
        }
    }
}
