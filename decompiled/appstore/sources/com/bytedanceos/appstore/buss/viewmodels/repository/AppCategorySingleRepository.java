package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class AppCategorySingleRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppCategorySingleRepository f9006a = null;

    static {
        f9006a = new AppCategorySingleRepository();
    }

    public AppCategorySingleRepository() {
    }

    public final Object f(int r10, int r11, int r12, String r13, Continuation r14) {
        return e(new AppCategorySingleRepository$getOneCategoryList$2(r10, r11, r12, r13, null), r14);
    }
}
