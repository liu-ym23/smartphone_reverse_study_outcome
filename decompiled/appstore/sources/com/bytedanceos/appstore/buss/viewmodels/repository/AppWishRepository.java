package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class AppWishRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppWishRepository f9016a = null;

    static {
        f9016a = new AppWishRepository();
    }

    public AppWishRepository() {
    }

    public final Object f(Continuation r10) {
        return e(new AppWishRepository$getWishCollectAppList$2(null), r10);
    }

    public final Object g(Continuation r10) {
        return e(new AppWishRepository$getWishRecommendAppList$2(null), r10);
    }

    public final Object h(List r10, Continuation r11) {
        return e(new AppWishRepository$postWishApp$2(r10, null), r11);
    }
}
