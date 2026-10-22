package com.amap.api.mapcore.util;

import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public abstract class f3 extends c3 {
    @Override // com.amap.api.mapcore.util.c3, com.amap.api.mapcore.util.y7
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.y7
    public Map<String, String> getRequestHead() {
        Hashtable r100 = new Hashtable(16);
        r100.put("User-Agent", w.f28256c);
        r100.put("Accept-Encoding", DownloadHelper.GZIP);
        r100.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{"11.2.101", "3dmap"}));
        r100.put("x-INFO", n5.a(b0.f27047f));
        r100.put("key", l5.e(b0.f27047f));
        r100.put("logversion", "2.1");
        return r100;
    }

    public f3() {
        setProxy(t5.b(b0.f27047f));
        setConnectionTimeout(5000);
        setSoTimeout(50000);
    }

    @Override // com.amap.api.mapcore.util.y7
    public String getIPV6URL() {
        String r100 = getURL();
        String r101 = "http://" + p5.b(b0.f27047f).a(27);
        if (r100 != null) goto L5;
        return r100;
    L5:
        if (r100.contains(r101 + "/v4/gridmap?") == true) goto L7;
        return r100;
    L7:
        return w3.a(r100, b0.f27047f);
    }

    @Override // com.amap.api.mapcore.util.y7
    public boolean isSupportIPV6() {
        String r100 = getURL();
        String r101 = "http://" + p5.b(b0.f27047f).a(27);
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.contains(r101 + "/v4/gridmap?") == false) goto L10;
        return true;
    L10:
        return false;
    }

    public String appendTsScode(String r110) {
        String[] r100 = r110.split("&");
        Arrays.sort(r100);
        StringBuffer r101 = new StringBuffer();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L15;
        String r104 = r100[r103];
        if (r104 == null) goto L14;
        r104 = URLDecoder.decode(r104, XML.CHARSET_UTF8);     // Catch: Exception -> L9 UnsupportedEncodingException -> L11
    L11:
        e = move-exception;
        t6.a(e, "AbstractProtocalHandler", "strReEncoder");
    L13:
        r104 = "";
    L9:
        e = move-exception;
        t6.a(e, "AbstractProtocalHandler", "strReEncoderException");
    L14:
        r101.append(r104);
        r101.append("&");
        r103 = r103 + 1;
        goto L3
    L15:
        String r105 = r101.toString();
        if (r105.length() <= 1) goto L18;
        String r106 = (String) r105.subSequence(0, r105.length() - 1);
    L19:
        StringBuffer r107 = new StringBuffer();
        r107.append(r110);
        String r111 = n5.a();
        r107.append("&ts=" + r111);
        r107.append("&scode=" + n5.a(b0.f27047f, r111, r106));
        return r107.toString();
    L18:
        r106 = r110;
        goto L19
    }
}
