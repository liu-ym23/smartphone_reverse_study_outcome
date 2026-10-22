package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import com.bytedanceos.appstore.utils.d;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class MyAppRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MyAppRepository f9031a = null;

    static {
        f9031a = new MyAppRepository();
    }

    public MyAppRepository() {
    }

    public final Object f(Continuation r10) {
        if (d.a() == false) goto L7;
        return e(new MyAppRepository$getMyApps$2(null), r10);
    L7:
        return e(new MyAppRepository$getMyApps$3(null), r10);
    }

    public final Object g(Continuation r10) {
        return e(new MyAppRepository$getMyAppsNum$2(null), r10);
    }
}
