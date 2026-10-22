package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class GameSubRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GameSubRepository f9027a = null;

    static {
        f9027a = new GameSubRepository();
    }

    public GameSubRepository() {
    }

    public final Object f(String r10, int r11, int r12, Continuation r13) {
        return e(new GameSubRepository$gameSub$2(r10, r11, r12, null), r13);
    }

    public final Object g(int r10, Continuation r11) {
        return e(new GameSubRepository$getGameSubscribe$2(r10, null), r11);
    }

    public final Object h(int r10, Continuation r11) {
        return e(new GameSubRepository$getMySub$2(r10, null), r11);
    }

    public final Object i(Continuation r10) {
        return e(new GameSubRepository$getMySubNotSub$2(null), r10);
    }

    public final Object j(int r10, String r11, Continuation r12) {
        return e(new GameSubRepository$getSubInfo$2(r10, r11, null), r12);
    }

    public final Object k(int r10, int r11, String r12, int r13, Continuation r14) {
        return e(new GameSubRepository$getSubInfoRecommend$2(r10, r11, r12, r13, null), r14);
    }
}
