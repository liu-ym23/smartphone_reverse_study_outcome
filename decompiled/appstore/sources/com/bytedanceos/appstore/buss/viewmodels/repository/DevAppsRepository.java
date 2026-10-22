package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class DevAppsRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DevAppsRepository f9026a = null;

    static {
        f9026a = new DevAppsRepository();
    }

    public DevAppsRepository() {
    }

    public final Object f(String r10, String r11, String r12, String r13, Continuation r14) {
        return e(new DevAppsRepository$getDevApps$2(r10, r11, r12, r13, null), r14);
    }
}
