package com.bytedance.android.live.effect.utils;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.ss.android.ugc.effectmanager.common.EffectRequest;
import com.ss.android.ugc.effectmanager.common.listener.IEffectNetWorker;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class d implements IEffectNetWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHostNetwork f68867a;

    public d() {
        this.f68867a = (IHostNetwork) jc1.k.f(IHostNetwork.class);
    }

    @Override // com.ss.android.ugc.effectmanager.common.listener.IEffectNetWorker
    public InputStream execute(EffectRequest r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r100.getHttpMethod()) == false) goto L8;
        return null;
    L8:
        if ("GET".equals(r100.getHttpMethod()) == true) goto L10;
        String r101 = r100.getUrl();
        String r102 = r100.getContentType();
        Map<String, String> r103 = r100.getHeaders();
        Map<String, Object> r104 = r100.getParams();
        return this.f68867a.doPost(r101, r102, r103, r104);
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    L10:
        return a(r100.getUrl(), r100.getHeaders());
    }

    public InputStream a(String r100, Map<String, String> r101) {
        ArrayList r102 = new ArrayList();
        if (r101 != null) goto L5;
    L20:
        LiveCall<HttpResponse> r103 = this.f68867a.get(r100, r102);     // Catch: Throwable -> L16
        if (r103 == null) goto L26;
        return new ByteArrayInputStream(r103.execute().getBody());
    L26:
        return null;
    L16:
        th = move-exception;
        th.printStackTrace();
        return null;
    L5:
        if (r101.size() <= 0) goto L20;
        Iterator<Map.Entry<String, String>> r104 = r101.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L20;
        Map.Entry<String, String> r105 = r104.next();
        if (r105 == null) goto L8;
        r102.add(new NameValuePair(r105.getKey(), r105.getValue()));
        goto L8
    }
}
