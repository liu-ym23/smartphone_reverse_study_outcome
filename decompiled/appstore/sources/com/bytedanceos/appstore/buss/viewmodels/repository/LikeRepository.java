package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.entity.netwrap.LikeEntity;
import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import com.google.gson.Gson;
import kotlin.coroutines.Continuation;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes2.dex */
public final class LikeRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LikeRepository f9029a = null;

    static {
        f9029a = new LikeRepository();
    }

    public LikeRepository() {
    }

    public final Object f(LikeEntity r10, Continuation r11) {
        String r12 = new Gson().toJson(r10);
        return e(new LikeRepository$cancelLike$2(RequestBody.c(MediaType.c("application/json; charset=utf-8"), r12), null), r11);
    }

    public final Object g(LikeEntity r10, Continuation r11) {
        String r12 = new Gson().toJson(r10);
        return e(new LikeRepository$like$2(RequestBody.c(MediaType.c("application/json; charset=utf-8"), r12), null), r11);
    }
}
