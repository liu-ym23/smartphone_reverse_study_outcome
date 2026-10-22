package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class AppDetailRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppDetailRepository f9009a = null;

    static {
        f9009a = new AppDetailRepository();
    }

    public AppDetailRepository() {
    }

    public final Object f(String r10, int r11, String r12, Continuation r13) {
        return e(new AppDetailRepository$getAppDetail$2(r12, r10, r11, null), r13);
    }
}
