package com.bytedance.android.live.broadcastgame.opengame.network;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class y implements Interceptor {
    public y() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r110) {
        Intrinsics.checkNotNullParameter(r110, "chain");
        Request r100 = r110.request();
        long r101 = System.currentTimeMillis();
        String r102 = r100.getUrl();
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        Uri r104 = UriProtector.parse(r102);
        String r105 = r104.buildUpon().clearQuery().toString();
        String r106 = r100.getMethod();
        if (r106 == null) goto L22;
        String r107 = r106.toUpperCase();
        int r108 = r107.hashCode();
        if (r108 == 70454) goto L14;
        if (r108 != 2461856) goto L23;
        r107.equals("POST");
    L23:
        SsResponse<?> r111 = r110.proceed(r100);     // Catch: Exception -> L18
        String r109 = r103;
        k10.a.a(r105, "0", "", r109, System.currentTimeMillis() - r101);     // Catch: Exception -> L18
        return r111;
    L18:
        e = move-exception;
        long r112 = System.currentTimeMillis() - r101;
        int r113 = k10.a.f501345a;
        k10.a.a(r105, "-1", e.getMessage(), r103, r112);
        throw e;
    L14:
        if (r107.equals("GET") == false) goto L23;
        r103 = UriProtector.getQueryParameter(r104, "app_id");
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
