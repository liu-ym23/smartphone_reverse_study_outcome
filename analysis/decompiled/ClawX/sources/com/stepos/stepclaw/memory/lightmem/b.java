package com.stepos.stepclaw.memory.lightmem;

import com.stepos.stepclaw.memory.search.QueryRewriteStage;
import com.stepos.stepclaw.memory.search.SearchPipeline;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1625a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1626b;

    public /* synthetic */ b(String str, int i8) {
        this.f1625a = i8;
        this.f1626b = str;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1625a;
        String str = this.f1626b;
        switch (i8) {
            case 0:
                return LightMemClient.postOfflineTrigger$lambda$3(str);
            case 1:
                return QueryRewriteStage.execute$lambda$0(str);
            case 2:
                return QueryRewriteStage.fallback$lambda$0(str);
            case 3:
                return QueryRewriteStage.resolveCategories$lambda$0(str);
            case 4:
                return QueryRewriteStage.tryRemote$lambda$2(str);
            default:
                return SearchPipeline.execute$lambda$5(str);
        }
    }
}
