package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class TopicRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TopicRepository f9038a = null;

    static {
        f9038a = new TopicRepository();
    }

    public TopicRepository() {
    }

    public final Object f(String r10, int r11, int r12, int r13, Continuation r14) {
        return e(new TopicRepository$getTopicApps$2(r10, r11, r12, r13, null), r14);
    }
}
