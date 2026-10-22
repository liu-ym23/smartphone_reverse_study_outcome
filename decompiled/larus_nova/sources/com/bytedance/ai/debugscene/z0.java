package com.bytedance.ai.debugscene;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f36569a = null;

    static {
        f36569a = PThreadExecutorsUtils.newCachedThreadPool(new x0());
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }
}
