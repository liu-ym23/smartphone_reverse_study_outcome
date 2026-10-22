package com.bytedance.applet.impl;

import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f191876a = null;

    static {
        f191876a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r110) {
        Intrinsics.checkNotNullParameter(r110, "chain");
        Request r100 = r110.request();
        String r101 = UriProtector.parse(r100.getUrl()).getHost();
        Header r102 = null;
        if (r101 == null) goto L28;
        String r103 = r101.toLowerCase(Locale.ROOT);
        if (r103 == null) goto L28;
        List<String> r104 = com.larus.platform.api.b2.f364870a.i();
        if ((r104 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L28;
        String r106 = StringsKt.trim((String) r105.next()).toString().toLowerCase(Locale.ROOT);
        if (r106.length() <= 0) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == true) goto L21;
        r106 = null;
    L21:
        if (r106 != null) goto L23;
    L25:
        boolean r108 = false;
    L26:
        if (r108 == false) goto L13;
        boolean r109 = true;
    L30:
        if (r109 == false) goto L38;
        Map<String, String> r111 = com.larus.platform.api.b2.f364870a.f();
        String r112 = a(r111, "X-Aweme-Visitor-Session-Id");
        if (r112 == null) goto L35;
        r102 = new Header("X-Aweme-Visitor-Session-Id", r112);
        goto L38
    L35:
        String r113 = a(r111, "X-Doubao-Access-Token");
        if (r113 == null) goto L38;
        r102 = new Header("X-Doubao-Access-Token", r113);
    L38:
        if (r102 == null) goto L40;
        Intrinsics.checkNotNull(r100);
        List<Header> r114 = r100.getHeaders();
        ArrayList r115 = new ArrayList();
        Iterator<T> r116 = r114.iterator();
    L43:
        if (r116.hasNext() == false) goto L53;
        Object r117 = r116.next();
        Header r118 = (Header) r117;
        if (StringsKt.equals(r118.getName(), "X-Aweme-Visitor-Session-Id", true) == false) goto L47;
    L50:
        boolean r119 = true;
    L51:
        if (r119 == true) goto L43;
        r115.add(r117);
        goto L43
    L47:
        if (StringsKt.equals(r118.getName(), "X-Doubao-Access-Token", true) == true) goto L50;
        r119 = false;
        goto L51
    L53:
        List<Header> r120 = CollectionsKt.toMutableList(r115);
        r120.add(r102);
        return r110.proceed(r100.newBuilder().headers(r120).build());
    L40:
        return r110.proceed(r100);
    L23:
        if (StringsKt.contains$default(r103, r106, false, 2, null) != true) goto L25;
        r108 = true;
        goto L26
    L17:
        r107 = false;
        goto L18
    L9:
        if (r104.isEmpty() == false) goto L11;
    L28:
        r109 = false;
        goto L30
    }

    public static String a(Map r100, String r101) {
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (StringsKt.equals((String) ((Map.Entry) r103).getKey(), r101, true) == false) goto L4;
    L9:
        Map.Entry r104 = (Map.Entry) r103;
        if (r104 == null) goto L20;
        String r105 = (String) r104.getValue();
        if (r105 != null) goto L14;
        return null;
    L14:
        if ((!StringsKt.isBlank(r105)) == true) goto L16;
        return null;
    L16:
        return r105;
    L20:
        return null;
    L8:
        r103 = null;
        goto L9
    }
}
