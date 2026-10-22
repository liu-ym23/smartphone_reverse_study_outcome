package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class AppPermissionRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppPermissionRepository f9011a = null;

    static {
        f9011a = new AppPermissionRepository();
    }

    public AppPermissionRepository() {
    }

    public final Object f(String r10, Continuation r11) {
        return e(new AppPermissionRepository$getAppPermissions$2(r10, null), r11);
    }
}
