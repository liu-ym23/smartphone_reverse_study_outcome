package com.bytedanceos.appstore.buss.network.base;

import com.bytedanceos.appstore.buss.network.CoroutineCallAdapterFactory;
import com.google.gson.Gson;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.internal.q;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseHttpEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f8796a;

    public BaseHttpEngine() {
        this.f8796a = b.b(BaseHttpEngine$gson$2.INSTANCE);
    }

    public final Gson a() {
        Object r10 = this.f8796a.getValue();
        q.f(r10, "getValue(...)");
        return (Gson) r10;
    }

    public final OkHttpClient b() {
        OkHttpClient.Builder r10 = new OkHttpClient.Builder();
        HttpLoggingInterceptor r11 = new HttpLoggingInterceptor();
        r11.c(HttpLoggingInterceptor.Level.BASIC);
        r10.e(5, TimeUnit.SECONDS);
        d(r10);
        r10.a(r11);
        OkHttpClient r12 = r10.c();
        q.f(r12, "build(...)");
        return r12;
    }

    public final Object c(Class r10, String r11) {
        q.g(r10, "serviceClass");
        q.g(r11, "baseUrl");
        return new Retrofit.b().g(b()).c(r11).a(CoroutineCallAdapterFactory.f8773a.a()).b(a.d(a())).e().d(r10);
    }

    public void d(OkHttpClient.Builder r10) {
        q.g(r10, "builder");
    }
}
