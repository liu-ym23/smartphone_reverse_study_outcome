package com.baidu.mshield.x6.d;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.d.c;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x6.f.f;
import com.baidu.mshield.x6.f.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a extends com.baidu.mshield.b.d.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f32577c;

    public String a(String r110) {
        com.baidu.mshield.x6.b.b r100 = new com.baidu.mshield.x6.b.b(this.f32367b);     // Catch: Throwable -> L34
        String r101 = h.a(16);     // Catch: Throwable -> L24 InterruptedException -> L27 c -> L30
        String r102 = this.f32577c.c(r101);     // Catch: Throwable -> L24 InterruptedException -> L27 c -> L30
        if (TextUtils.isEmpty(r102) == false) goto L8;
        return "";
    L8:
        String r111 = a(r102, h.b(com.baidu.mshield.b.a.c.a(r110.getBytes()), r101.getBytes()));     // Catch: Throwable -> L24 InterruptedException -> L27 c -> L30
        com.baidu.mshield.b.c.a.a("getCheckZipResponse:" + r111);     // Catch: Throwable -> L24 InterruptedException -> L27 c -> L30
        if (TextUtils.isEmpty(r111) == false) goto L11;
        return "";
    L11:
        r100.j("");     // Catch: Throwable -> L24 InterruptedException -> L27 c -> L30
        r100.a(0);     // Catch: Throwable -> L24 InterruptedException -> L27 c -> L30
        r100.w("");     // Catch: Throwable -> L24 InterruptedException -> L27 c -> L30
        r100.i(0);     // Catch: Throwable -> L24 InterruptedException -> L27 c -> L30
        r100.x("");     // Catch: Throwable -> L24 InterruptedException -> L27 c -> L30
    L13:
        r100.m(1);     // Catch: Throwable -> L34
        JSONObject r103 = new JSONObject(r111);     // Catch: Throwable -> L19
        String r112 = r103.getString("data");     // Catch: Throwable -> L19
        com.baidu.mshield.b.c.a.a("dataStr:" + r112);     // Catch: Throwable -> L19
        String r104 = r103.getString("skey");     // Catch: Throwable -> L19
        if (r112 == null) goto L36;
        if (r104 == null) goto L36;
        String r105 = new String(h.a(Base64.decode(r112, 0), h.c(Base64.decode(r104.getBytes(), 0), e.a(com.baidu.mshield.utility.c.b(this.f32367b)).getBytes())));     // Catch: Throwable -> L19
        com.baidu.mshield.b.c.a.a("dataDecrypt:".concat(r105));     // Catch: Throwable -> L19
        return r105;
    L36:
        return "";
    L19:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L34
        if (r100.F() != 0) goto L23;
        r100.d(-3);     // Catch: Throwable -> L34
    L23:
        return "";
    L24:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L34
        return "";
    L30:
        com.baidu.mshield.b.c.a.a("getCheckZipResponse:NetworkErrorWrongResponseCodeException");     // Catch: Throwable -> L34
        if (r100.F() != 0) goto L33;
        r100.d(-3);     // Catch: Throwable -> L34
    L33:
        return "";
    L27:
        e = move-exception;
        r100.m(0);     // Catch: Throwable -> L34
        f.b(e);     // Catch: Throwable -> L34
        return "";
    L34:
        th = move-exception;
        f.b(th);
        goto L36
    }

    public String b(String r100) {
        String r101 = h.a(16);     // Catch: Throwable -> L17
        String r102 = this.f32577c.a(r101);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return "";
    L6:
        String r103 = a(r102, h.b(com.baidu.mshield.b.a.c.a(r100.getBytes()), r101.getBytes()));     // Catch: Throwable -> L17
        com.baidu.mshield.b.c.a.a("getBdid:" + r103);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r103) == false) goto L25;
        return "";
    L25:
        JSONObject r104 = new JSONObject(r103);     // Catch: Throwable -> L14
        String r105 = r104.getString("data");     // Catch: Throwable -> L14
        com.baidu.mshield.b.c.a.a("dataStr:" + r105);     // Catch: Throwable -> L14
        String r106 = r104.getString("skey");     // Catch: Throwable -> L14
        if (r105 == null) goto L22;
        if (r106 == null) goto L22;
        String r107 = new String(h.a(Base64.decode(r105, 0), h.c(Base64.decode(r106.getBytes(), 0), e.a(com.baidu.mshield.utility.c.b(this.f32367b)).getBytes())));     // Catch: Throwable -> L14
        com.baidu.mshield.b.c.a.a("dataDecrypt:".concat(r107));     // Catch: Throwable -> L14
        return r107;
    L22:
        return "";
    L14:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L20
        return "";
    L17:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L20
        return "";
    L20:
        th = move-exception;
        f.b(th);
        goto L22
    }

    public String c(String r100) {
        String r101 = h.a(16);     // Catch: Throwable -> L8
        String r102 = this.f32577c.b(r101);     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return "";
    L6:
        byte[] r103 = h.b(com.baidu.mshield.b.a.c.a(r100.getBytes()), r101.getBytes());     // Catch: Throwable -> L8
        com.baidu.mshield.b.c.a.a("getCharacter:" + r102);     // Catch: Throwable -> L8
        String r104 = a(r102, r103);     // Catch: Throwable -> L8
    L10:
        com.baidu.mshield.b.c.a.a("getCharacter resp:" + r104);     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r104) == false) goto L25;
        return "";
    L25:
        JSONObject r105 = new JSONObject(r104);     // Catch: Throwable -> L19
        String r106 = r105.optString("skey");     // Catch: Throwable -> L19
        String r107 = r105.optString("data");     // Catch: Throwable -> L19
        String r108 = new String(h.a(Base64.decode(r107.getBytes(), 0), h.c(Base64.decode(r106.getBytes(), 0), e.a(com.baidu.mshield.utility.c.b(this.f32367b)).getBytes())));     // Catch: Throwable -> L19
    L15:
        if (TextUtils.isEmpty(r108) == false) goto L17;
        return "";
    L17:
        com.baidu.mshield.b.c.a.a("getCharacter sdata:".concat(r108));     // Catch: Throwable -> L22
        return r108;
    L19:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L22
        return "";
    L22:
        th = move-exception;
        f.b(th);
        return "";
    L8:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L22
        r104 = "";
        goto L10
    }

    public a(Context r100, Handler r101) {
        super(r100, r101);
        this.f32367b = r100;
        this.f32577c = b.a(r100);
    }
}
