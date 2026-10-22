package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@c7(isSuperField = true, tableName = "update_item")
public class n1 extends q1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f27628o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Context f27629p;

    public void g() {
        this.f27878d = w3.a(this.f27629p) + this.f27888n + ".zip.tmp";
    }

    public void h() {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L59
        r101.put("title", this.f27875a);     // Catch: Throwable -> L59
        r101.put("code", this.f27877c);     // Catch: Throwable -> L59
        r101.put("url", this.f27876b);     // Catch: Throwable -> L59
        r101.put("fileName", this.f27878d);     // Catch: Throwable -> L59
        r101.put("lLocalLength", this.f27880f);     // Catch: Throwable -> L59
        r101.put("lRemoteLength", this.f27881g);     // Catch: Throwable -> L59
        r101.put("mState", this.f27887m);     // Catch: Throwable -> L59
        r101.put("version", this.f27879e);     // Catch: Throwable -> L59
        r101.put("localPath", this.f27882h);     // Catch: Throwable -> L59
        String r102 = this.f27628o;     // Catch: Throwable -> L59
        if (r102 == null) goto L26;
        r101.put("vMapFileNames", r102);     // Catch: Throwable -> L59
    L26:
        r101.put("isSheng", this.f27884j);     // Catch: Throwable -> L59
        r101.put("mCompleteCode", this.f27885k);     // Catch: Throwable -> L59
        r101.put("mCityCode", this.f27886l);     // Catch: Throwable -> L59
        r101.put("pinyin", this.f27888n);     // Catch: Throwable -> L59
        r100.put("file", r101);     // Catch: Throwable -> L59
        PolarisFileWrapper r103 = new PolarisFileWrapper(this.f27878d + ".dt");     // Catch: Throwable -> L59
        r103.delete();     // Catch: Throwable -> L59
        OutputStreamWriter r104 = null;
        OutputStreamWriter r105 = new OutputStreamWriter(new PolarisFileOutputStreamWrapper(r103, true), XML.CHARSET_UTF8);     // Catch: Throwable -> L44 IOException -> L46
        r105.write(r100.toString());     // Catch: Throwable -> L40 IOException -> L42
        r105.close();     // Catch: IOException -> L38 Throwable -> L59
    L68:
        return;
    L42:
        e = e;
        r104 = r105;
    L47:
        t6.a(e, "UpdateItem", "saveJSONObjectToFile");     // Catch: Throwable -> L44
        e.printStackTrace();     // Catch: Throwable -> L44
        if (r104 == null) goto L74;
        r104.close();     // Catch: IOException -> L38 Throwable -> L59
        goto L68
    L74:
        return;
    L40:
        th = th;
        r104 = r105;
    L53:
        if (r104 != null) goto L66;
    L58:
        throw th;     // Catch: Throwable -> L59
    L66:
        r104.close();     // Catch: IOException -> L56 Throwable -> L59
    L56:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L59
    L46:
        e = e;
    L44:
        th = th;
    L38:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L59
        return;
    L59:
        th = move-exception;
        t6.a(th, "UpdateItem", "saveJSONObjectToFile parseJson");
        th.printStackTrace();
    }

    public n1() {
        this.f27628o = "";
    }

    public String f() {
        return this.f27628o;
    }

    public void d(String r100) {
        if (r100 == null) goto L27;
    L22:
        th = move-exception;
        t6.a(th, "UpdateItem", "readFileToJSONObject");
        th.printStackTrace();
        return;
    L5:
        if ("".equals(r100) == true) goto L28;
        JSONObject r101 = new JSONObject(r100).getJSONObject("file");     // Catch: Throwable -> L22
        if (r101 != null) goto L10;
        return;
    L10:
        this.f27875a = r101.optString("title");     // Catch: Throwable -> L22
        this.f27877c = r101.optString("code");     // Catch: Throwable -> L22
        this.f27876b = r101.optString("url");     // Catch: Throwable -> L22
        this.f27878d = r101.optString("fileName");     // Catch: Throwable -> L22
        this.f27880f = r101.optLong("lLocalLength");     // Catch: Throwable -> L22
        this.f27881g = r101.optLong("lRemoteLength");     // Catch: Throwable -> L22
        this.f27887m = r101.optInt("mState");     // Catch: Throwable -> L22
        this.f27879e = r101.optString("version");     // Catch: Throwable -> L22
        this.f27882h = r101.optString("localPath");     // Catch: Throwable -> L22
        this.f27628o = r101.optString("vMapFileNames");     // Catch: Throwable -> L22
        this.f27884j = r101.optInt("isSheng");     // Catch: Throwable -> L22
        this.f27885k = r101.optInt("mCompleteCode");     // Catch: Throwable -> L22
        this.f27886l = r101.optString("mCityCode");     // Catch: Throwable -> L22
        if (r101.has("pinyin") == true) goto L15;
    L17:
        String r102 = "";
    L18:
        this.f27888n = r102;     // Catch: Throwable -> L22
        if ("".equals(r102) == false) goto L29;
        String r103 = this.f27876b;     // Catch: Throwable -> L22
        String r104 = r103.substring(r103.lastIndexOf(HTTP.URL_DEFAULT) + 1);     // Catch: Throwable -> L22
        this.f27888n = r104.substring(0, r104.lastIndexOf("."));     // Catch: Throwable -> L22
        return;
    L29:
        return;
    L15:
        if ("[]".equals(r101.getString("pinyin")) == true) goto L17;
        r102 = r101.optString("pinyin").trim();     // Catch: Throwable -> L22
        goto L18
    L28:
        return;
    }

    public void e(String r100) {
        this.f27628o = r100;
    }

    public n1(OfflineMapCity r100, Context r101) {
        this.f27628o = "";
        this.f27629p = r101;
        this.f27875a = r100.getCity();
        this.f27877c = r100.getAdcode();
        this.f27876b = r100.getUrl();
        this.f27881g = r100.getSize();
        this.f27879e = r100.getVersion();
        this.f27886l = r100.getCode();
        this.f27884j = 0;
        this.f27887m = r100.getState();
        this.f27885k = r100.getcompleteCode();
        this.f27888n = r100.getPinyin();
        g();
    }

    public n1(OfflineMapProvince r100, Context r101) {
        this.f27628o = "";
        this.f27629p = r101;
        this.f27875a = r100.getProvinceName();
        this.f27877c = r100.getProvinceCode();
        this.f27876b = r100.getUrl();
        this.f27881g = r100.getSize();
        this.f27879e = r100.getVersion();
        this.f27884j = 1;
        this.f27887m = r100.getState();
        this.f27885k = r100.getCompleteCode();
        this.f27888n = r100.getPinyin();
        g();
    }
}
