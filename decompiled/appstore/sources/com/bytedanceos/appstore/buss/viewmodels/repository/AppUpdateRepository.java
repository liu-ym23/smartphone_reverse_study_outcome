package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class AppUpdateRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppUpdateRepository f9015a = null;

    static {
        f9015a = new AppUpdateRepository();
    }

    public AppUpdateRepository() {
    }

    public final Object f(Continuation r10) {
        return e(new AppUpdateRepository$getUpdateRecommendAppList$2(null), r10);
    }
}
