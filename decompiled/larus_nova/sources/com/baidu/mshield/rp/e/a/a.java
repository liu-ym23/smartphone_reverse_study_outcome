package com.baidu.mshield.rp.e.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.utility.d;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f32414a;

    public void a() {
        JSONObject r100 = new JSONObject(d.a(this.f32414a, com.baidu.mshield.utility.a.f(this.f32414a) + "p/1/rs", false, true)).getJSONObject("c");     // Catch: Throwable -> L31
        com.baidu.mshield.sharedpreferences.a r101 = com.baidu.mshield.sharedpreferences.a.a(this.f32414a);     // Catch: Throwable -> L31
        int r102 = r100.optInt(OfficeSDKRequestTag.KEY_NEW_USER);     // Catch: Throwable -> L31
        if (r102 <= 0) goto L6;
        r101.i(r102);     // Catch: Throwable -> L31
    L6:
        int r103 = r100.optInt(RXScreenCaptureService.KEY_INDEX);     // Catch: Throwable -> L31
        if (r103 <= 0) goto L9;
        r101.m(r103);     // Catch: Throwable -> L31
    L9:
        int r104 = r100.optInt("i2");     // Catch: Throwable -> L31
        if (r104 <= 0) goto L12;
        r101.l(r104);     // Catch: Throwable -> L31
    L12:
        int r105 = r100.optInt("w");     // Catch: Throwable -> L31
        if (r105 <= 0) goto L16;
        r101.h(r105);     // Catch: Throwable -> L31
    L16:
        if (r100.optInt("s1") <= 0) goto L18;
        r101.j(r100.optInt("s1"));     // Catch: Throwable -> L31
    L18:
        int r106 = r100.optInt("s2");     // Catch: Throwable -> L31
        if (r106 <= 0) goto L21;
        r101.f(r106);     // Catch: Throwable -> L31
    L21:
        int r107 = r100.optInt("t");     // Catch: Throwable -> L31
        if (r107 <= 0) goto L24;
        r101.k(r107);     // Catch: Throwable -> L31
    L24:
        int r108 = r100.optInt("l1");     // Catch: Throwable -> L31
        if (r108 <= 0) goto L27;
        r101.n(r108);     // Catch: Throwable -> L31
    L27:
        int r109 = r100.optInt("l2");     // Catch: Throwable -> L31
        if (r109 <= 0) goto L36;
        r101.o(r109);     // Catch: Throwable -> L31
        return;
    L36:
        return;
    L31:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    public a(Context r100) {
        this.f32414a = r100;
    }

    public boolean a(String r110, String r111, String r112) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return true;
    L5:
        com.baidu.mshield.b.c.a.b("report from" + r112);
        com.baidu.mshield.b.c.a.b("sj-trigger report" + r110);
    L17:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return true;
    L7:
        if (TextUtils.isEmpty(r111) == true) goto L9;
        String r113 = "&topic=" + r111;     // Catch: Throwable -> L17
    L10:
        String r100 = com.baidu.mshield.utility.a.f(this.f32414a) + "p/1/r";     // Catch: Throwable -> L17
        com.baidu.mshield.b.c.a.b("sj-trigger report" + r100);     // Catch: Throwable -> L17
        String r114 = d.a(this.f32414a, r100, r110, false, false, r113);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r114) == false) goto L13;
        return false;
    L13:
        if (new JSONObject(r114).getInt("response") != 1) goto L16;
        return true;
    L16:
        return false;
    L9:
        r113 = null;
        goto L10
    }
}
