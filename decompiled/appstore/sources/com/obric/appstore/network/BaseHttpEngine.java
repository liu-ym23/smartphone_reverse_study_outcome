package com.obric.appstore.network;

import com.bytedanceos.common.toolbox.j;
import com.google.gson.Gson;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseHttpEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f10952a;

    public BaseHttpEngine() {
        this.f10952a = kotlin.b.b(BaseHttpEngine$gson$2.INSTANCE);
    }

    public static /* synthetic */ void a(String r10) {
        b(r10);
    }

    public static final void b(String r10) {
        j.o("[Retrofit] " + r10);
    }

    public final Gson c() {
        Object r10 = this.f10952a.getValue();
        q.f(r10, "getValue(...)");
        return (Gson) r10;
    }

    public final OkHttpClient d() {
        OkHttpClient.Builder r10 = new OkHttpClient.Builder();
        HttpLoggingInterceptor r11 = new HttpLoggingInterceptor(new e());
        r11.c(HttpLoggingInterceptor.Level.BASIC);
        TimeUnit r12 = TimeUnit.SECONDS;
        r10.e(15, r12);
        r10.n(15, r12);
        r10.q(15, r12);
        f(r10);
        r10.a(r11);
        r10.a(new wa.a());
        OkHttpClient r13 = r10.c();
        q.f(r13, "build(...)");
        return r13;
    }

    public final Object e(Class r10, String r11) {
        q.g(r10, "serviceClass");
        q.g(r11, "baseUrl");
        return new Retrofit.b().g(d()).c(r11).a(CoroutineCallAdapterFactory.f10953a.a()).b(retrofit2.converter.gson.a.d(c())).e().d(r10);
    }

    public void f(OkHttpClient.Builder r10) {
        q.g(r10, "builder");
    }
}
