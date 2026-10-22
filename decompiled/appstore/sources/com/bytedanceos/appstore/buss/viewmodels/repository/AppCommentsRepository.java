package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.entity.netwrap.PushAddCommentEntity;
import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import com.google.gson.Gson;
import kotlin.coroutines.Continuation;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes2.dex */
public final class AppCommentsRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppCommentsRepository f9007a = null;

    static {
        f9007a = new AppCommentsRepository();
    }

    public AppCommentsRepository() {
    }

    public final Object f(PushAddCommentEntity r10, Continuation r11) {
        String r12 = new Gson().toJson(r10);
        return e(new AppCommentsRepository$addComment$2(RequestBody.c(MediaType.c("application/json; charset=utf-8"), r12), null), r11);
    }

    public final Object g(String r10, Continuation r11) {
        return e(new AppCommentsRepository$checkComment$2(r10, null), r11);
    }

    public final Object h(String r10, int r11, int r12, Continuation r13) {
        return e(new AppCommentsRepository$getAppComments$2(r10, r11, r12, null), r13);
    }
}
