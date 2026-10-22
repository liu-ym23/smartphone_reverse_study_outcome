package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.ee.plugin.common.ttreader.ITTReaderViewWrapper;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public abstract class d5<T, V> extends c3 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected T f27171o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f27172p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected Context f27173q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected String f27174r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected boolean f27175s;

    private V d() throws c5 {
        V r100 = null;
        int r101 = 0;
    L4:
        if (r101 >= this.f27172p) goto L49;
        setProxy(t5.b(this.f27173q));     // Catch: Throwable -> L11 c5 -> L13 k5 -> L19
        goto L12
    L6:
        if (this.f27175s == false) goto L8;
        r100 = a(makeHttpRequestNeedHeader());     // Catch: Throwable -> L11 c5 -> L13 k5 -> L19
    L9:
        r101 = this.f27172p;     // Catch: Throwable -> L11 c5 -> L13 k5 -> L19
        goto L4
    L8:
        r100 = a(makeHttpRequest());     // Catch: Throwable -> L11 c5 -> L13 k5 -> L19
    L13:
        e = move-exception;
        r101 = r101 + 1;
        if (r101 < this.f27172p) goto L4;
        throw new c5(e.a());
    L19:
        e = move-exception;
        r101 = r101 + 1;
        if (r101 >= this.f27172p) goto L36;
        Thread.sleep(1000);     // Catch: InterruptedException -> L25
    L26:
        if ("http连接失败 - ConnectionException".equals(e.getMessage()) == true) goto L35;
        if ("socket 连接异常 - SocketException".equals(e.getMessage()) == true) goto L35;
        if ("服务器连接失败 - UnknownServiceException".equals(e.getMessage()) == true) goto L35;
        throw new c5(e.d());
    L35:
        throw new c5(c5.A);
    L36:
        e();
        if ("http连接失败 - ConnectionException".equals(e.getMessage()) == true) goto L48;
        if ("socket 连接异常 - SocketException".equals(e.getMessage()) == true) goto L48;
        if ("未知的错误".equals(e.d()) == true) goto L48;
        if ("服务器连接失败 - UnknownServiceException".equals(e.getMessage()) == true) goto L48;
        throw new c5(e.d());
    L48:
        throw new c5(c5.A);
    L12:
        throw new c5(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
    L49:
        return r100;
    }

    public V a(z7 r100) throws c5 {
        return null;
    }

    public abstract V b(String r100) throws c5;

    public V e() {
        return null;
    }

    public V c() throws c5 {
        if (this.f27171o != null) goto L11;
        return null;
    L11:
        return d();
    L6:
        e = move-exception;
        w3.a(e);
        throw e;
    }

    @Override // com.amap.api.mapcore.util.y7
    public Map<String, String> getRequestHead() {
        w5 r100 = w3.b();
        if (r100 == null) goto L5;
        String r101 = r100.e();
    L6:
        Hashtable r102 = new Hashtable(16);
        r102.put("User-Agent", w.f28256c);
        r102.put("Accept-Encoding", DownloadHelper.GZIP);
        r102.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{r101, "3dmap"}));
        r102.put("X-INFO", n5.a(this.f27173q));
        r102.put("key", l5.e(this.f27173q));
        r102.put("logversion", "2.1");
        return r102;
    L5:
        r101 = null;
        goto L6
    }

    public V a(byte[] r100) throws c5 {
        String r101 = new String(r100, XML.CHARSET_UTF8);     // Catch: Exception -> L5
    L7:
        if (r101 != null) goto L9;
    L29:
        return null;
    L9:
        if ("".equals(r101) == true) goto L29;
        JSONObject r102 = new JSONObject(r101);     // Catch: JSONException -> L27
        if (r102.has("errcode") == false) goto L15;
        f5.a(JSONObjectProtectorUtils.getInt(r102, "errcode"), JSONObjectProtectorUtils.getString(r102, ITTReaderViewWrapper.ERROR_MSG_KEY));     // Catch: JSONException -> L27
    L26:
        return b(r101);
    L15:
        if (r102.has("status") == false) goto L26;
        if (r102.has("infocode") == false) goto L26;
        String r103 = JSONObjectProtectorUtils.getString(r102, "status");     // Catch: JSONException -> L27
        int r104 = JSONObjectProtectorUtils.getInt(r102, "infocode");     // Catch: JSONException -> L27
        if ("1".equals(r103) == true) goto L26;
        String r105 = JSONObjectProtectorUtils.getString(r102, "info");     // Catch: JSONException -> L27
        if ("0".equals(r103) == false) goto L26;
        f5.a(r104, r105);     // Catch: JSONException -> L27
        goto L26
    L28:
        throw new c5(c5.f27136w);
    L5:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
        goto L7
    }

    public d5(Context r100, T r101) {
        this.f27172p = 1;
        this.f27175s = false;
        a(r100, r101);
    }

    private void a(Context r100, T r101) {
        this.f27173q = r100;
        this.f27171o = r101;
        this.f27172p = 1;
        setSoTimeout(30000);
        setConnectionTimeout(30000);
    }
}
