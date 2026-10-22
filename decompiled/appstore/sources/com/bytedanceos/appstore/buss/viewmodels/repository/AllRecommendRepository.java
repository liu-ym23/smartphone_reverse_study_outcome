package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class AllRecommendRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AllRecommendRepository f9004a = null;

    static {
        f9004a = new AllRecommendRepository();
    }

    public AllRecommendRepository() {
    }

    public final Object f(int r10, Continuation r11) {
        return e(new AllRecommendRepository$getAllRecommend$2(r10, null), r11);
    }
}
