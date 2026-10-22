package com.stepos.stepclaw.memory.search;

import com.stepos.stepclaw.memory.storage.persist.IndexPersistence;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1687a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Exception f1688b;

    public /* synthetic */ b(Exception exc, int i8) {
        this.f1687a = i8;
        this.f1688b = exc;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1687a;
        Exception exc = this.f1688b;
        switch (i8) {
            case 0:
                return QueryRewriteStage.tryRemote$lambda$5(exc);
            case 1:
                return QueryRewriteStage.tryLocalInfer$lambda$4(exc);
            case 2:
                return SearchPipeline.execute$lambda$6(exc);
            default:
                return IndexPersistence.peekPersistedVersion$lambda$0(exc);
        }
    }
}
