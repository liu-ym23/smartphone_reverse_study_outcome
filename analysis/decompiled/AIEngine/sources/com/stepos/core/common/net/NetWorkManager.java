package com.stepos.core.common.net;

import a9.a;
import ad.h;
import ad.n;
import java.util.concurrent.TimeUnit;
import kotlin.b;
import kotlin.jvm.internal.g;
import lb.d;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NetWorkManager {
    public static final NetWorkManager INSTANCE = new NetWorkManager();
    private static final d base$delegate;
    private static final okhttp3.d connectionPool;
    private static final h dispatcher;
    private static final d transport$delegate;

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        connectionPool = new okhttp3.d();
        h hVar = new h();
        synchronized (hVar) {
            hVar.f90a = 8;
            n nVar = n.f10413a;
        }
        hVar.d();
        dispatcher = hVar;
        int i10 = 11;
        base$delegate = b.b(new a9.b(i10));
        transport$delegate = b.b(new a(i10));
    }

    private NetWorkManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ad.n base_delegate$lambda$1() {
        n.a aVar = new n.a();
        okhttp3.d connectionPool2 = connectionPool;
        g.f(connectionPool2, "connectionPool");
        aVar.f141b = connectionPool2;
        h dispatcher2 = dispatcher;
        g.f(dispatcher2, "dispatcher");
        aVar.f140a = dispatcher2;
        aVar.a(new CtaNetworkInterceptor());
        return new ad.n(aVar);
    }

    private final ad.n getBase() {
        return (ad.n) base$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ad.n rawOkHttpClient$default(NetWorkManager netWorkManager, long j10, long j11, long j12, l lVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j12 = j11;
        }
        if ((i10 & 8) != 0) {
            lVar = new com.stepos.core.common.cloud.d(4);
        }
        return netWorkManager.rawOkHttpClient(j10, j11, j12, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n rawOkHttpClient$lambda$3(n.a aVar) {
        g.f(aVar, "<this>");
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpTransport transport_delegate$lambda$2() {
        return new OkHttpTransport(INSTANCE.getBase());
    }

    public final HttpTransport getTransport() {
        return (HttpTransport) transport$delegate.getValue();
    }

    public final ad.n rawOkHttpClient(long j10, long j11, long j12, l<? super n.a, lb.n> configure) {
        g.f(configure, "configure");
        n.a aVarB = getBase().b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        aVarB.b(j10, timeUnit);
        aVarB.c(j11, timeUnit);
        aVarB.d(j12, timeUnit);
        configure.invoke(aVarB);
        return new ad.n(aVarB);
    }
}
