package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class SearchRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SearchRepository f9037a = null;

    static {
        f9037a = new SearchRepository();
    }

    public SearchRepository() {
    }

    public final Object f(Continuation r10) {
        return e(new SearchRepository$getSearchRecommend$2(null), r10);
    }

    public final Object g(String r10, int r11, int r12, int r13, Continuation r14) {
        return e(new SearchRepository$getSearchResult$2(r11, r10, r12, r13, null), r14);
    }

    public final Object h(String r10, Continuation r11) {
        return e(new SearchRepository$getSearchTip$2(r10, null), r11);
    }
}
