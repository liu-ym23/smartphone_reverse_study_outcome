package com.bytedance.android.live.network.impl.interceptor;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdk.config.qc0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f83857b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f83858a;

    public a() {
        ArrayList r100 = new ArrayList();
        this.f83858a = r100;
        r100.add("https://aweme.snssdk.com/luckycat/aweme/v1/");
        r100.add("https://webcast-open.douyin.com/webcast/stamp/micro_app_entrance_permission");
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r100) throws Exception {
        Request r101 = r100.request();
        Iterator r102 = ((ArrayList) this.f83858a).iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        if (r101.getUrl().startsWith((String) r102.next()) == false) goto L4;
        return r100.proceed(r101);
    L10:
        if (qc0.f121044a.getValue().booleanValue() == false) goto L17;
        List<Header> r103 = r101.headers("skip_url_end_check");
        if (r103 == null) goto L17;
        if ("1".equals(((Header) ListProtector.get(r103, 0)).getValue()) == false) goto L17;
        return r100.proceed(r101);
    L17:
        String r104 = r101.getPath();
        if (r104 == null) goto L29;
        if (r104.isEmpty() == true) goto L29;
        if (r104.endsWith(HTTP.URL_DEFAULT) == true) goto L29;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L26;
        xs2.b r105 = xs2.b.a();
        r104.concat(HTTP.URL_DEFAULT);
        r105.post(new com.bytedance.android.livesdk.event.b());
    L26:
        int r106 = r101.getUrl().indexOf(r104) + r104.length();
        return r100.proceed(r101.newBuilder().url(r101.getUrl().substring(0, r106) + HTTP.URL_DEFAULT + r101.getUrl().substring(r106)).build());
    L29:
        return r100.proceed(r101);
    }
}
