package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class SearchBannerRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SearchBannerRepository f9036a = null;

    static {
        f9036a = new SearchBannerRepository();
    }

    public SearchBannerRepository() {
    }

    public final Object f(int r10, Continuation r11) {
        return e(new SearchBannerRepository$getSearchBanner$2(r10, null), r11);
    }
}
