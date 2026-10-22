package com.bytedance.apm.util;

import android.text.TextUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IHttpService;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class f {
    public static ff7.b a(String r100, List<File> r101, Map<String, String> r102) {
        IHttpService r103 = (IHttpService) ServiceManager.getService(IHttpService.class);     // Catch: Exception -> L30
        if (r103 != null) goto L6;
        r103 = com.bytedance.apm.d.f190522j;     // Catch: Exception -> L30
    L6:
        ff7.g r104 = r103.buildMultipartUpload(r100, "UTF-8", false);     // Catch: Exception -> L30
        if (r101 != null) goto L9;
    L16:
        if (r102 != null) goto L18;
    L23:
        ff7.b r105 = r104.finish();     // Catch: Exception -> L30
        String r106 = new String(r105.f476669c);     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r106) == true) goto L29;
        JSONObject r107 = new JSONObject(r106);     // Catch: JSONException -> L27 Exception -> L30
        return new ff7.b(r105.f476667a, r107.optString("message", "").getBytes());
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L30
        goto L29
    L18:
        if (r102.isEmpty() == true) goto L23;
        Iterator<Map.Entry<String, String>> r108 = r102.entrySet().iterator();     // Catch: Exception -> L30
    L21:
        if (r108.hasNext() == false) goto L23;
        Map.Entry<String, String> r109 = r108.next();     // Catch: Exception -> L30
        r104.a(r109.getKey(), r109.getValue());     // Catch: Exception -> L30
        goto L21
    L9:
        if (r101.isEmpty() == true) goto L16;
        Iterator<File> r110 = r101.iterator();     // Catch: Exception -> L30
    L12:
        if (r110.hasNext() == false) goto L16;
        File r111 = r110.next();     // Catch: Exception -> L30
        if (r111.exists() == false) goto L12;
        HashMap r112 = new HashMap();     // Catch: Exception -> L30
        r104.b(r111.getName(), r111, null, r112);     // Catch: Exception -> L30
    L29:
        return null;
    }
}
