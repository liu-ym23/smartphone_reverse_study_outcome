package com.amap.api.mapcore.util;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class a7 extends s5 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public JSONObject f26885o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Context f26886p;

    @Override // com.amap.api.mapcore.util.y7
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.y7
    public final String getSDKName() {
        return "core";
    }

    @Override // com.amap.api.mapcore.util.y7
    public final byte[] getEntityBytes() {
        StringBuffer r100 = new StringBuffer();     // Catch: Throwable -> L17
        JSONObject r101 = this.f26885o;     // Catch: Throwable -> L17
        if (r101 == null) goto L9;
        Iterator<String> r102 = r101.keys();     // Catch: Throwable -> L17
    L7:
        if (r102.hasNext() == false) goto L9;
        String r103 = r102.next();     // Catch: Throwable -> L17
        r100.append(r103 + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(this.f26885o.get(r103).toString(), XML.CHARSET_UTF8) + "&");     // Catch: Throwable -> L17
    L9:
        r100.append("output=json");     // Catch: Throwable -> L17
        String r104 = l5.e(this.f26886p);     // Catch: Throwable -> L17
        r100.append("&key=".concat(String.valueOf(r104)));     // Catch: Throwable -> L17
        String r105 = n5.a();     // Catch: Throwable -> L17
        r100.append("&ts=".concat(String.valueOf(r105)));     // Catch: Throwable -> L17
        StringBuilder r106 = new StringBuilder("&scode=");     // Catch: Throwable -> L17
        r106.append(n5.a(this.f26886p, r105, "key=".concat(String.valueOf(r104))));     // Catch: Throwable -> L17
        r100.append(r106.toString());     // Catch: Throwable -> L17
        return r100.toString().getBytes(XML.CHARSET_UTF8);
    L17:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.amap.api.mapcore.util.y7
    public final Map<String, String> getRequestHead() {
        HashMap r100 = new HashMap();
        r100.put("Content-Type", "application/x-www-form-urlencoded");
        r100.put("Accept-Encoding", DownloadHelper.GZIP);
        r100.put("User-Agent", "AMAP SDK Android core 4.4.2.46");
        r100.put("X-INFO", n5.a(this.f26886p));
        r100.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{"4.4.2.46", "core"}));
        r100.put("logversion", "2.1");
        return r100;
    }

    @Override // com.amap.api.mapcore.util.y7
    public final String getURL() {
        if (r5.a.f27931a.b() == false) goto L6;
        return "https://restsdk.amap.com/sdk/compliance/params";
    L6:
        return "http://restsdk.amap.com/sdk/compliance/params";
    }

    public a7() {
        this.f26885o = null;
        this.f26886p = null;
    }
}
