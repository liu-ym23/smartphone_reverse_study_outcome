package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class AppRankRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppRankRepository f9012a = null;

    static {
        f9012a = new AppRankRepository();
    }

    public AppRankRepository() {
    }

    public final Object f(int r10, int r11, int r12, int r13, String r14, Continuation r15) {
        return e(new AppRankRepository$getAppRank$2(r10, r11, r12, r13, r14, null), r15);
    }
}
