package com.bytedance.android.ec.search.host.impl;

import android.app.Application;
import com.larus.abtest.api.IAbTest;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostABService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements ITradeSearchHostABService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f48170a = null;

    static {
        f48170a = new b();
    }

    public b() {
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostABService
    public final <T> T a(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        T r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        ft9.k r104 = ft9.k.f478804a;     // Catch: Throwable -> L11
        Application r105 = AppHost.f326268a.getApplication();     // Catch: Throwable -> L11
        r104.getClass();     // Catch: Throwable -> L11
        JSONObject r106 = ft9.k.c(r105);     // Catch: Throwable -> L11
        if (r106 == null) goto L6;
        Object r107 = r106.opt(r100);     // Catch: Throwable -> L11
    L7:
        if (r107 != null) goto L9;
        r107 = null;
    L9:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r108) == true) goto L17;
        r102 = (T) r108;
    L17:
        if (r102 != null) goto L22;
        IAbTest.Companion r109 = IAbTest.f286085a;
        Class<?> r110 = r101.getClass();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type java.lang.Class<T of com.bytedance.android.ec.search.host.impl.ECSearchHostABService.getValue>");
        return (T) r109.r(r100, r110, r101);
    L22:
        return r102;
    L6:
        r107 = null;
    L11:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
