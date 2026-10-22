package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.entity.netwrap.AppFeedBackEntity;
import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class AppFeedBackRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppFeedBackRepository f9010a = null;

    static {
        f9010a = new AppFeedBackRepository();
    }

    public AppFeedBackRepository() {
    }

    public final Object f(AppFeedBackEntity r10, Continuation r11) {
        return e(new AppFeedBackRepository$postAppFeedBack$2(r10, null), r11);
    }
}
