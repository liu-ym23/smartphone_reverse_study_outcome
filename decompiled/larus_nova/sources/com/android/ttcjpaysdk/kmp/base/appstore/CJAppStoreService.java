package com.android.ttcjpaysdk.kmp.base.appstore;

import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/appstore/CJAppStoreService;", "Lcom/android/ttcjpaysdk/kmp/base/appstore/IKmpCJAppStoreService;", "<init>", "()V", "jumpToAppStore", "", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJAppStoreService implements IKmpCJAppStoreService {
    public static final int $stable = 0;
    public static final CJAppStoreService INSTANCE = null;

    static {
        INSTANCE = new CJAppStoreService();
    }

    private CJAppStoreService() {
    }

    @Override // com.android.ttcjpaysdk.kmp.base.appstore.IKmpCJAppStoreService
    public void jumpToAppStore() {
        b r100 = c.f528682a;
        IKmpCJAppStoreService r101 = (IKmpCJAppStoreService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJAppStoreService.class));
        if (r101 == null) goto L6;
        r101.jumpToAppStore();
        return;
    }
}
