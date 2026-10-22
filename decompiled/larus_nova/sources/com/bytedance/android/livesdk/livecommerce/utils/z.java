package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class z {
    static {
    }

    public static void a(String r100, SsResponse r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "ssResponse");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L18
        List<Header> r103 = r101.headers();     // Catch: Throwable -> L18
        String r104 = null;
        if (r103 == null) goto L16;
        ArrayList r105 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<T> r106 = r103.iterator();     // Catch: Throwable -> L18
    L7:
        if (r106.hasNext() == false) goto L11;
        Object r107 = r106.next();     // Catch: Throwable -> L18
        if (StringsKt.equals(NetResponse.HEADER_KEY_LOG_ID, ((Header) r107).getName(), true) == false) goto L7;
        r105.add(r107);     // Catch: Throwable -> L18
        goto L7
    L11:
        Header r108 = (Header) CollectionsKt.firstOrNull(r105);     // Catch: Throwable -> L18
        if (r108 == null) goto L16;
        String r109 = r108.getValue();     // Catch: Throwable -> L18
        if (r109 == null) goto L16;
        xh.a r110 = xh.c.a("Live");     // Catch: Throwable -> L18
        Map r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("path", r100), TuplesKt.to("log_id", r109)});     // Catch: Throwable -> L18
        xh.b r112 = new xh.b();     // Catch: Throwable -> L18
        r112.c(null);     // Catch: Throwable -> L18
        r112.b("api_request_response");     // Catch: Throwable -> L18
        r112.a(r111);     // Catch: Throwable -> L18
        r110.f(4, r112);     // Catch: Throwable -> L18
        r104 = r109;
    L16:
        Result.m9449constructorimpl(r104);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void b(String r100, List r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "paramList");
        Intrinsics.checkNotNullParameter(r102, com.alipay.sdk.m.p.e.f25671s);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        xh.a r104 = xh.c.a("Live");     // Catch: Throwable -> L5
        xh.b.a r105 = new xh.b.a();     // Catch: Throwable -> L5
        r105.b(r100);     // Catch: Throwable -> L5
        r105.a(r102);     // Catch: Throwable -> L5
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L5
        r104.a(null, r105);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
