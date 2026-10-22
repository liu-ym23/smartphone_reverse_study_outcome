package com.uxsense;

import S7.k;
import com.uxsense.ApexMetadataManager;
import java.nio.file.Path;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4196a;

    public /* synthetic */ c(int i) {
        this.f4196a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f4196a) {
            case 0:
                return Boolean.valueOf(ApexMetadataManager.C12031.C01691.invokeSuspend$lambda$2$lambda$0((Path) obj));
            case 1:
                return Boolean.valueOf(ApexMetadataManager.C12041.C01701.invokeSuspend$lambda$2$lambda$0((Path) obj));
            case 2:
                return Boolean.valueOf(ApexMetadataManager.AnonymousClass2.invokeSuspend$lambda$2$lambda$0((Path) obj));
            case 3:
                return Boolean.valueOf(ApexMetadataManager.clearAppCache$lambda$23$lambda$14((Path) obj));
            case 4:
                return Boolean.valueOf(ApexMetadataManager.getCacheFileCount$lambda$13$lambda$11$lambda$10$lambda$8((Path) obj));
            case 5:
                return Boolean.valueOf(ApexMetadataManager.getCacheFileCount$lambda$13$lambda$6((Path) obj));
            case 6:
                return Boolean.valueOf(ApexMetadataManager.clearAppCache$lambda$23$lambda$21$lambda$20$lambda$16((Path) obj));
            case 7:
                return ApexMetadataManager.clearAppCache$lambda$23$lambda$21$lambda$20$lambda$18((Path) obj);
            case 8:
                return Boolean.valueOf(ApexMetadataManager.parseCacheDir$lambda$5$lambda$3((Path) obj));
            default:
                return ApexSDK.addOnTriggerEventListener$lambda$0((String) obj);
        }
    }
}
