package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class AppCategoryRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppCategoryRepository f9005a = null;

    static {
        f9005a = new AppCategoryRepository();
    }

    public AppCategoryRepository() {
    }

    public final Object f(int r10, Continuation r11) {
        return e(new AppCategoryRepository$getAppCategoryList$2(r10, null), r11);
    }
}
