package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.ad.AdBaseRepository;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
public final class AppSplashRepository extends AdBaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppSplashRepository f9013a = null;

    static {
        f9013a = new AppSplashRepository();
    }

    public AppSplashRepository() {
    }

    public static final /* synthetic */ Object c(AppSplashRepository r10, Response r11, Continuation r12) {
        return r10.a(r11, r12);
    }

    public final Object d(RequestBody r10, Continuation r11) {
        return b(new AppSplashRepository$getAd$2(r10, null), r11);
    }
}
