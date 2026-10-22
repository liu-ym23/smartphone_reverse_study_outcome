package com.amap.api.mapcore.util;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public abstract class e5<T, V> extends d5<T, V> {
    @Override // com.amap.api.mapcore.util.d5
    public V e() {
        return null;
    }

    public abstract String f();

    @Override // com.amap.api.mapcore.util.c3, com.amap.api.mapcore.util.y7
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.d5, com.amap.api.mapcore.util.y7
    public Map<String, String> getRequestHead() {
        HashMap r100 = new HashMap(16);
        r100.put("Content-Type", " application/json");
        r100.put("Accept-Encoding", DownloadHelper.GZIP);
        r100.put("User-Agent", "AMAP SDK Android Trace 11.2.101");
        r100.put("x-INFO", n5.a(this.f27173q));
        r100.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{"11.2.101", "trace"}));
        r100.put("logversion", "2.1");
        return r100;
    }

    @Override // com.amap.api.mapcore.util.y7
    public byte[] getEntityBytes() {
        return f().getBytes(XML.CHARSET_UTF8);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public e5(Context r100, T r101) {
        super(r100, r101);
    }
}
