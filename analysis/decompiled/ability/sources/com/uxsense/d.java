package com.uxsense;

import S7.k;
import com.uxsense.ApexMetadataManager;
import java.util.function.Predicate;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4203a;
    public final /* synthetic */ k b;

    public /* synthetic */ d(k kVar, int i) {
        this.f4203a = i;
        this.b = kVar;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.f4203a;
        c cVar = (c) this.b;
        switch (i) {
            case 0:
                return ApexMetadataManager.C12031.C01691.invokeSuspend$lambda$2$lambda$1(cVar, obj);
            case 1:
                return ApexMetadataManager.C12041.C01701.invokeSuspend$lambda$2$lambda$1(cVar, obj);
            case 2:
                return ApexMetadataManager.AnonymousClass2.invokeSuspend$lambda$2$lambda$1(cVar, obj);
            case 3:
                return ApexMetadataManager.getCacheFileCount$lambda$13$lambda$11$lambda$10$lambda$9(cVar, obj);
            case 4:
                return ApexMetadataManager.getCacheFileCount$lambda$13$lambda$7(cVar, obj);
            case 5:
                return ApexMetadataManager.clearAppCache$lambda$23$lambda$15(cVar, obj);
            case 6:
                return ApexMetadataManager.clearAppCache$lambda$23$lambda$21$lambda$20$lambda$17(cVar, obj);
            default:
                return ApexMetadataManager.parseCacheDir$lambda$5$lambda$4(cVar, obj);
        }
    }
}
