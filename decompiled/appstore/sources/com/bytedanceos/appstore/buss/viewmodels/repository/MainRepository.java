package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class MainRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MainRepository f9030a = null;

    static {
        f9030a = new MainRepository();
    }

    public MainRepository() {
    }

    public final Object f(int r10, Continuation r11) {
        return e(new MainRepository$getFirstRecommend$2(r10, null), r11);
    }
}
