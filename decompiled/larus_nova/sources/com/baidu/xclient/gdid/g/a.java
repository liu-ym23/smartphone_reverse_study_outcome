package com.baidu.xclient.gdid.g;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.f.e;
import com.baidu.xclient.gdid.j.d;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a extends com.baidu.mshield.b.d.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f33615c;

    public a(Context r100, Handler r101) {
        super(r100, r101);
        this.f32367b = r100;
        this.f33615c = b.a(r100);
    }

    public String a(String r100, String r101, boolean r102) {
        String r103 = "";
        byte[] r104 = d.a();     // Catch: Throwable -> L26
        String r105 = URLEncoder.encode(Base64.encodeToString(com.baidu.mshield.b.f.d.d(r104, e.a(com.baidu.mshield.b.b.a.a(this.f32367b)).getBytes()), 0));     // Catch: Throwable -> L7
        String r106 = this.f33615c.a(r100, r105);     // Catch: Throwable -> L7
    L10:
        if (TextUtils.isEmpty(r106) == false) goto L29;
        return null;
    L29:
        String r107 = a(r106, this.f33615c.a(r104, r101));     // Catch: Throwable -> L23
    L14:
        if (TextUtils.isEmpty(r107) == false) goto L16;
        return null;
    L16:
        if (r102 == true) goto L34;
        return r107;
    L34:
        JSONObject r108 = new JSONObject(r107);     // Catch: Throwable -> L20
        r108.optString("request_id");     // Catch: Throwable -> L20
        String r109 = r108.optString("skey");     // Catch: Throwable -> L20
        r103 = r108.optString("data");     // Catch: Throwable -> L20
        byte[] r110 = e.a(com.baidu.mshield.b.b.a.a(this.f32367b)).getBytes();     // Catch: Throwable -> L20
        byte[] r111 = com.baidu.mshield.b.f.d.c(Base64.decode(r109.getBytes(), 0), r110);     // Catch: Throwable -> L20
    L36:
        return new String(com.baidu.mshield.b.f.d.a(Base64.decode(r103.getBytes(), 0), r111));
    L20:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L26
        return r103;
    L23:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L26
        return null;
    L7:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L26
        r106 = "";
    L26:
        th = move-exception;
        d.a(th);
        return null;
    }

    public JSONObject a(JSONObject r100) {
        String r101 = a("gd/2/pin/", r100.toString(), true);     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return null;
    L6:
        return new JSONObject(r101);
    L8:
        th = move-exception;
        d.a(th);
        return null;
    }

    public boolean a(String r100) {
        String r101 = a("f/2/ejc/", r100, false);     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r101) == false) goto L18;
        return false;
    L18:
        if (new JSONObject(r101).has("err_code") == false) goto L9;
        return false;
    L9:
        return true;
    L11:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L14
    L16:
        return false;
    L14:
        th = move-exception;
        d.a(th);
        goto L16
    }

    public String b() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L8
        r100.put("2", com.baidu.xclient.gdid.e.e().j());     // Catch: Throwable -> L8
        r100.put("1", 2);     // Catch: Throwable -> L8
        return a("s/3/gd/", r100.toString(), true);
    L8:
        th = move-exception;
        d.a(th);
        return null;
    }
}
