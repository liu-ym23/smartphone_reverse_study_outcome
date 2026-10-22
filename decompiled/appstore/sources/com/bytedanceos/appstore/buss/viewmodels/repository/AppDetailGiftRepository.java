package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class AppDetailGiftRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppDetailGiftRepository f9008a = null;

    static {
        f9008a = new AppDetailGiftRepository();
    }

    public AppDetailGiftRepository() {
    }

    public final Object f(String r10, String r11, Continuation r12) {
        return e(new AppDetailGiftRepository$getAppGift$2(r10, r11, null), r12);
    }
}
