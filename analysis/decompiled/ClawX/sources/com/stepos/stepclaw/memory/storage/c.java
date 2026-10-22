package com.stepos.stepclaw.memory.storage;

import com.stepos.stepclaw.memory.storage.MemoryStorage;
import java.io.Serializable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1701a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Serializable f1702b;

    public /* synthetic */ c(int i8, Serializable serializable) {
        this.f1701a = i8;
        this.f1702b = serializable;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1701a;
        Serializable serializable = this.f1702b;
        switch (i8) {
            case 0:
                return MemoryStorage.AnonymousClass2.invokeSuspend$lambda$0((String) serializable);
            case 1:
                return MemoryStorage.C00542.invokeSuspend$lambda$0((String) serializable);
            case 2:
                return MemoryStorage.C00542.invokeSuspend$lambda$1((String) serializable);
            case 3:
                return MemoryStorage.C00542.invokeSuspend$lambda$2((String) serializable);
            case 4:
                return MemoryStorage.C00542.invokeSuspend$lambda$3((String) serializable);
            case 5:
                return MemoryStorage.C00542.invokeSuspend$lambda$4((String) serializable);
            case 6:
                return MemoryStorage.parseIso8601ToMillis$lambda$0((String) serializable);
            default:
                return MemoryStorage.C00552.invokeSuspend$lambda$5((Exception) serializable);
        }
    }
}
