package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class PageAppsRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PageAppsRepository f9035a = null;

    static {
        f9035a = new PageAppsRepository();
    }

    public PageAppsRepository() {
    }

    public final Object f(int r10, int r11, Continuation r12) {
        return e(new PageAppsRepository$getPageApps$2(r10, r11, null), r12);
    }
}
