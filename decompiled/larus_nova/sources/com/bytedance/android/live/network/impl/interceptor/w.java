package com.bytedance.android.live.network.impl.interceptor;

import android.net.Uri;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class w implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f83905a;

    public w(boolean r100) {
        this.f83905a = r100;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        Request r101 = r100.request();
        SsResponse<?> r102 = r100.proceed(r101);     // Catch: Exception -> L5
        a(r101, r102);     // Catch: Exception -> L5
        return r102;
    L5:
        e = move-exception;
        Spm.Companion.getClass();
        Spm r103 = Spm.a.a("a100.b4000").result(100);
        String r104 = e.getMessage();
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        vw2.a.a(r103.reason(r104).addArg("path", r101.getPath()), "network");
        throw e;
    }

    public final void a(Request r100, SsResponse<?> r101) {
        Iterator<T> r102 = r101.headers().iterator();
        String r103 = null;
    L4:
        if (r102.hasNext() == false) goto L8;
        Header r104 = (Header) r102.next();
        if (Intrinsics.areEqual(r104.getName(), NetResponse.HEADER_KEY_LOG_ID) == false) goto L4;
        r103 = r104.getValue();
        goto L4
    L8:
        boolean r105 = true;
        if (this.f83905a == true) goto L35;
    L20:
        String r106 = "-";
    L21:
        int r107 = 0;
        if (r103 != null) goto L24;
    L27:
        if (r105 == true) goto L43;
        Spm.Companion.getClass();
        Spm r108 = Spm.a.a("a100.b4000").result(r101.code()).addArg(CronetDataStorageAccess.LOGID, r103).addArg("param", r106).addArg("request_size", Integer.valueOf(r106.length()));
        Object r109 = r101.body();
        if (r109 == null) goto L33;
        String r110 = r109.toString();
        if (r110 == null) goto L33;
        r107 = r110.length();
    L33:
        vw2.a.a(r108.addArg("response_size", Integer.valueOf(r107)).addArg("path", r100.getPath()), "network");
        return;
    L43:
        return;
    L24:
        if (r103.length() == 0) goto L27;
        r105 = false;
        goto L27
    L35:
        Uri r111 = UriProtector.parse(r100.getUrl());     // Catch: Exception -> L18
        Set<String> r112 = UriProtector.getQueryParameterNames(r111);     // Catch: Exception -> L18
        JSONObject r113 = new JSONObject();     // Catch: Exception -> L18
        if ((!r112.isEmpty()) == false) goto L16;
        Iterator<String> r114 = r112.iterator();     // Catch: Exception -> L18
    L14:
        if (r114.hasNext() == false) goto L16;
        String r115 = r114.next();     // Catch: Exception -> L18
        r113.put(r115, UriProtector.getQueryParameter(r111, r115));     // Catch: Exception -> L18
    L16:
        r106 = r113.toString();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.getLocalizedMessage();
        goto L20
    }
}
