package com.bytedance.android.live.network.impl.interceptor;

import com.bytedance.android.livesdk.config.ge;
import com.bytedance.android.livesdk.model.s0;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f83865a = null;

    public d() {
    }

    static {
        f83865a = new d();
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r110) {
        Intrinsics.checkNotNullParameter(r110, "chain");
        Request r100 = r110.request();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(r110.proceed(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9456isSuccessimpl(r102) == true) goto L65;
        int r103 = com.bytedance.android.live.network.impl.utils.c.a(Result.m9452exceptionOrNullimpl(r102));
        int r104 = com.bytedance.android.live.network.impl.utils.b.f83923c;
        com.bytedance.android.live.network.impl.utils.b.a.a("error_code is " + r103);
        Integer r105 = Integer.valueOf(r103);
        String r106 = r100.getPath();
        ge r107 = ge.f120273a;
        boolean r108 = false;
        String r109 = null;
        if (r107.getValue().a() == false) goto L43;
        if (r105 == null) goto L43;
        if (r106 != null) goto L16;
    L19:
        boolean r111 = true;
    L20:
        if (r111 == true) goto L43;
        List<Integer> r112 = CollectionsKt.emptyList();
        ArrayList<s0> r113 = r107.getValue().c();
        if (r113 == null) goto L38;
        Iterator<s0> r114 = r113.iterator();
    L26:
        if (r114.hasNext() == false) goto L38;
        s0 r115 = r114.next();
        if (Intrinsics.areEqual(r115.a(), r106) == false) goto L26;
        List<Integer> r116 = r115.b();
        if (r116 != null) goto L32;
    L37:
        boolean r117 = true;
    L39:
        if (r117 == false) goto L43;
        if (r112.contains(r105) == false) goto L43;
        r108 = true;
        goto L43
    L32:
        if ((!r116.isEmpty()) == true) goto L35;
        r116 = null;
    L35:
        if (r116 == null) goto L37;
        r112 = r116;
    L38:
        r117 = false;
        goto L39
    L16:
        if (r106.length() == 0) goto L19;
        r111 = false;
    L43:
        if (r108 == false) goto L63;
        Iterator<T> r118 = r100.getHeaders().iterator();
    L46:
        if (r118.hasNext() == false) goto L50;
        Object r119 = r118.next();
        if (Intrinsics.areEqual("x-retry-type", ((Header) r119).getName()) == false) goto L46;
    L51:
        Header r120 = (Header) r119;
        if (r120 == null) goto L54;
        r109 = r120.getValue();
    L54:
        if (r109 != null) goto L63;
        int r121 = com.bytedance.android.live.network.impl.utils.b.f83923c;
        com.bytedance.android.live.network.impl.utils.b.a.a(r100.getPath() + " auto retry. error_code is " + r103);
        ArrayList r122 = new ArrayList(r100.getHeaders());
        Header r123 = new Header("x-retry-type", "1");
        Iterator r124 = r122.iterator();
    L57:
        if (r124.hasNext() == false) goto L61;
        if (Intrinsics.areEqual(((Header) r124.next()).getName(), r123.getName()) == false) goto L57;
        r124.remove();
        goto L57
    L61:
        r122.add(r123);
        return r110.proceed(r100.newBuilder().headers(r122).build());
    L50:
        r119 = null;
    L63:
        ResultKt.throwOnFailure(r102);
        return (SsResponse) r102;
    L65:
        ResultKt.throwOnFailure(r102);
        return (SsResponse) r102;
    L5:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
