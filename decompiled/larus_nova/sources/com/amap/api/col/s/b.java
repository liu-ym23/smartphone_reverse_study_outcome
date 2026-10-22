package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public abstract class b<T, V> extends a<T, V> {
    @Override // com.amap.api.col.s.a
    public abstract V a(String r100) throws AMapException;

    @Override // com.amap.api.col.s.a
    public abstract String a();

    @Override // com.amap.api.col.s.a, com.amap.api.col.s.cy
    public Map<String, String> e() {
        return null;
    }

    @Override // com.amap.api.col.s.a, com.amap.api.col.s.cy
    public Map<String, String> f() {
        HashMap r100 = new HashMap();
        r100.put("Content-Type", "application/x-www-form-urlencoded");
        r100.put("Accept-Encoding", DownloadHelper.GZIP);
        r100.put("User-Agent", "AMAP SDK Android Search 7.7.0");
        r100.put("X-INFO", bl.a(this.f25994e));
        r100.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{"7.7.0", "sea"}));
        r100.put("logversion", "2.1");
        return r100;
    }

    @Override // com.amap.api.col.s.cy
    public byte[] g() {
        String r100 = a();     // Catch: Throwable -> L7
        StringBuffer r101 = new StringBuffer();     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r101.append(r100);     // Catch: Throwable -> L7
        r101.append("&");     // Catch: Throwable -> L7
    L5:
        r101.append("language=");     // Catch: Throwable -> L7
        r101.append(ServiceSettings.getInstance().getLanguage());     // Catch: Throwable -> L7
        String r102 = r101.toString();     // Catch: Throwable -> L7
        String r103 = c(r102);     // Catch: Throwable -> L7
        StringBuffer r104 = new StringBuffer();     // Catch: Throwable -> L7
        r104.append(r102);     // Catch: Throwable -> L7
        String r105 = bl.a();     // Catch: Throwable -> L7
        r104.append("&ts=".concat(String.valueOf(r105)));     // Catch: Throwable -> L7
        r104.append("&scode=" + bl.a(this.f25994e, r105, r103));     // Catch: Throwable -> L7
        return r104.toString().getBytes(XML.CHARSET_UTF8);
    L7:
        th = move-exception;
        i.a(th, "ProtocalHandler", "getEntity");
        return null;
    }

    public static String b(String r100) {
        if (r100 != null) goto L13;
        return r100;
    L13:
        return URLEncoder.encode(r100, XML.CHARSET_UTF8);
    L9:
        e = move-exception;
        i.a(e, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
        return "";
    L7:
        e = move-exception;
        i.a(e, "ProtocalHandler", "strEncoderException");
        return "";
    }

    private static String c(String r100) {
        String[] r101 = r100.split("&");
        Arrays.sort(r101);
        StringBuffer r102 = new StringBuffer();
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102.append(d(r101[r104]));
        r102.append("&");
        r104 = r104 + 1;
        goto L3
    L5:
        String r105 = r102.toString();
        if (r105.length() > 1) goto L8;
        return r100;
    L8:
        return (String) r105.subSequence(0, r105.length() - 1);
    }

    private static String d(String r100) {
        if (r100 != null) goto L13;
        return r100;
    L13:
        return URLDecoder.decode(r100, XML.CHARSET_UTF8);
    L9:
        e = move-exception;
        i.a(e, "ProtocalHandler", "strReEncoder");
        return "";
    L7:
        e = move-exception;
        i.a(e, "ProtocalHandler", "strReEncoderException");
        return "";
    }

    public b(Context r100, T r101) {
        super(r100, r101);
    }
}
