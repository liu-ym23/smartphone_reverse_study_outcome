package com.bytedance.android.livesdk.test.network;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.c;
import com.bytedance.retrofit2.Retrofit;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class TestHttpClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f158512a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f158513b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f158514c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final IHttpApi f158515d = null;

    static {
        f158512a = LazyKt.lazy(TestHttpClient$services$2.INSTANCE);
        f158513b = "https://livelab.web.bytedance.net";
        Lazy r100 = LazyKt.lazy(TestHttpClient$retrofit$2.INSTANCE);
        f158514c = r100;
        Retrofit r101 = (Retrofit) r100.getValue();     // Catch: Throwable -> L7
        if (r101 == null) goto L9;
        IHttpApi r102 = (IHttpApi) r101.create(IHttpApi.class);     // Catch: Throwable -> L7
    L10:
        if (r102 != null) goto L12;
        r102 = (IHttpApi) c.b().e(IHttpApi.class);
    L12:
        f158515d = r102;
        return;
    L9:
        r102 = null;
    L7:
        th = move-exception;
        ALogger.e("HttpClient", "create retrofit error", th);
        goto L9
    }
}
