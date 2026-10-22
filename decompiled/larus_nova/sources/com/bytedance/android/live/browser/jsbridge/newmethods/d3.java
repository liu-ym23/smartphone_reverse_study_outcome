package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.network.impl.interceptor.RequestInterceptorConstants;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "fetchPb")
public final class d3 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f63346a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f63346a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public d3() {
    }

    public static List<NameValuePair> k(JSONObject r100) {
        ArrayList r101 = new ArrayList();
        if (r100 == null) goto L8;
        Iterator<String> r102 = r100.keys();
    L6:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();
        r101.add(new NameValuePair(r103, r100.optString(r103, "")));
    L8:
        return r101;
    }

    public static String j(String r100, JSONObject r101) {
        UrlBuilder r102 = new UrlBuilder(r100);
        Iterator r103 = ((ArrayList) RequestInterceptorConstants.b(k(r101))).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        NameValuePair r104 = (NameValuePair) r103.next();
        r102.addParam(r104.getName(), r104.getValue());
        goto L4
    L6:
        Logger.d("FetchPbMethod", "build url is " + r102.build());
        return r102.build();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = r100;
        final String r103 = r102.optString("url", "");
        String r104 = r102.optString(com.alipay.sdk.m.p.e.f25671s, MonitorConstants.CONNECT_TYPE_GET).toLowerCase();
        if (r102.optJSONObject("headers") == null) goto L5;
        final JSONObject r105 = r102.optJSONObject("headers");
    L6:
        final JSONObject r106 = r102.optJSONObject("params");
        final JSONObject r107 = r102.optJSONObject("data");
        if (r105 == null) goto L9;
        l30.i.b(r105, r101);
    L9:
        Single.just(r104).subscribeOn(Schedulers.io()).map(new b3(r103, r105, r106, r107)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c3(this));
        return;
    L5:
        r105 = new JSONObject();
        goto L6
    }
}
