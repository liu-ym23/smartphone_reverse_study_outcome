package com.stepos.stepclaw.memory;

import com.stepos.stepclaw.memory.MemoryDumpCommandHandler;
import com.stepos.stepclaw.memory.upload.UploadBatchResult;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1668a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UploadBatchResult f1669b;

    public /* synthetic */ m(UploadBatchResult uploadBatchResult, int i8) {
        this.f1668a = i8;
        this.f1669b = uploadBatchResult;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1668a;
        UploadBatchResult uploadBatchResult = this.f1669b;
        switch (i8) {
            case 0:
                return MemoryDumpCommandHandler.C00321.invokeSuspend$lambda$1(uploadBatchResult);
            default:
                return MemoryDumpCommandHandler.AnonymousClass2.invokeSuspend$lambda$1(uploadBatchResult);
        }
    }
}
