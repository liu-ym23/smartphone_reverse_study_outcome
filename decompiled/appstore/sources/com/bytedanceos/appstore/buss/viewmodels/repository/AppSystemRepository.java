package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class AppSystemRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppSystemRepository f9014a = null;

    static {
        f9014a = new AppSystemRepository();
    }

    public AppSystemRepository() {
    }

    public final Object f(Continuation r10) {
        return e(new AppSystemRepository$getSystemRecommendAppList$2(null), r10);
    }

    public final Object g(int r10, int r11, int r12, Continuation r13) {
        return e(new AppSystemRepository$getSystemUninstalledAppList$2(r10, r11, r12, null), r13);
    }
}
