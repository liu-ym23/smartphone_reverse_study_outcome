package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* JADX INFO: loaded from: classes.dex */
public class OkHttp3Builder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static IOkHttpClientBuilderHook f7308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f7309c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OkHttpClient f7310a;

    public interface IOkHttpClientBuilderHook {
        void addBuilderConfig(OkHttpClient.Builder r10);
    }

    public class a implements Interceptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OkHttp3Builder f7311a;

        public a(OkHttp3Builder r10) {
            this.f7311a = r10;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain r10) {
            Request r11 = r10.request();
            InetSocketAddress r12 = null;
            Connection r13 = r10.connection();     // Catch: Throwable -> L27
            if (r13 == null) goto L6;
            Route r14 = r13.route();     // Catch: Throwable -> L27
        L7:
            if (r14 == null) goto L10;
            r12 = r14.d();     // Catch: Throwable -> L27
        L10:
            if (Logger.debug() == false) goto L33;
            Logger.d("OkHttp3Builder", "-call- get res -  req: " + r11.hashCode() + " conn: " + r13 + " route: " + r14 + " addr: " + r12);     // Catch: Throwable -> L27
            goto L33
        L6:
            r14 = null;
        L33:
            Response r15 = r10.proceed(r11);     // Catch: IOException -> L16
            if (r12 == null) goto L37;
            Response.Builder r16 = r15.n();     // Catch: Throwable -> L28
            r16.a("x-net-info.remoteaddr", r12.getAddress().getHostAddress());     // Catch: Throwable -> L28
            return r16.c();
        L38:
            return r15;
        L37:
            return r15;
        L16:
            e = move-exception;
            if (r12 != null) goto L31;
        L26:
            throw e;
        L31:
            String r17 = e.getMessage();     // Catch: Throwable -> L21
            StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L21
            r18.append(r12.getAddress().getHostAddress());     // Catch: Throwable -> L21
            r18.append("|");     // Catch: Throwable -> L21
            if (r17 != null) goto L23;
            r17 = "null";
        L23:
            r18.append(r17);     // Catch: Throwable -> L21
            Reflect.on(e).set("detailMessage", r18.toString());     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            th.printStackTrace();
            goto L26
        }
    }

    static {
    }

    public OkHttp3Builder() {
    }

    public static OkHttpClient b(OkHttpClient r10) {
        int r11 = f7309c;
        if (r11 > 0) goto L5;
        return r10;
    L5:
        if (r11 >= 4) goto L10;
        if (r10 == null) goto L11;
        OkHttpClient.Builder r12 = r10.p();
        e(r12);
        return r12.c();
    L11:
        return r10;
    L10:
        return r10;
    }

    public static void c(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        if (f7309c != 0) goto L8;
        f7309c = r10;
        return;
    }

    public static OkHttpClient.Builder d(OkHttpClient.Builder r10) {
        return r10;
    }

    public static void e(OkHttpClient.Builder r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ArrayList r11 = new ArrayList();
        int r12 = f7309c;
        if (r12 != 1) goto L7;
        r11.add(Protocol.HTTP_2);
    L13:
        f7309c = 4;
        r11.add(Protocol.HTTP_1_1);
        r10.m(Collections.unmodifiableList(r11));
        return;
    L7:
        if (r12 != 2) goto L9;
        r11.add(Protocol.SPDY_3);
        goto L13
    L9:
        if (r12 == 3) goto L13;
        r11.add(Protocol.HTTP_2);
        r11.add(Protocol.SPDY_3);
        goto L13
    }

    public OkHttpClient a(boolean r10) {
        if (r10 == false) goto L5;
        NetworkParams.J();
    L5:
        monitor-enter(NetworkParams.class);
        OkHttpClient r11 = this.f7310a;     // Catch: Throwable -> L11
        if (r11 == null) goto L13;
        b(r11);     // Catch: Throwable -> L11
        OkHttpClient r12 = this.f7310a;     // Catch: Throwable -> L11
        monitor-exit(NetworkParams.class);     // Catch: Throwable -> L11
        return r12;
    L13:
        OkHttpClient.Builder r13 = new OkHttpClient.Builder();     // Catch: Throwable -> L11
        int r14 = f7309c;     // Catch: Throwable -> L11
        if (r14 > 0) goto L16;
    L18:
        TimeUnit r15 = TimeUnit.MILLISECONDS;     // Catch: Throwable -> L11
        r13.f(new ConnectionPool(15, 180000, r15));     // Catch: Throwable -> L11
        r13.e(TraceStatsConsts.APP_START_MAX_LIMIT_MS, r15);     // Catch: Throwable -> L11
        r13.n(TraceStatsConsts.APP_START_MAX_LIMIT_MS, r15);     // Catch: Throwable -> L11
        r13.q(TraceStatsConsts.APP_START_MAX_LIMIT_MS, r15);     // Catch: Throwable -> L11
        r13.b(new a(this));     // Catch: Throwable -> L11
        r13.h(c.b());     // Catch: Throwable -> L11
        r13.g(CookieJar.NO_COOKIES);     // Catch: Throwable -> L11
        r13.b(new b());     // Catch: Throwable -> L11
        r13.a(new f());     // Catch: Throwable -> L11
        OkHttpClient.Builder r16 = d(r13);     // Catch: Throwable -> L11
        r16.k(true);     // Catch: Throwable -> L11
        IOkHttpClientBuilderHook r17 = f7308b;     // Catch: Throwable -> L11
        if (r17 == null) goto L21;
        r17.addBuilderConfig(r16);     // Catch: Throwable -> L11
    L21:
        OkHttpClient r18 = r16.c();     // Catch: Throwable -> L11
        this.f7310a = r18;     // Catch: Throwable -> L11
        monitor-exit(NetworkParams.class);     // Catch: Throwable -> L11
        return r18;
    L16:
        if (r14 >= 4) goto L18;
        e(r13);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
