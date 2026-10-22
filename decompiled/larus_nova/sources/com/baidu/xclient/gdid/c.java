package com.baidu.xclient.gdid;

import android.content.Context;
import android.util.Base64;
import com.amap.api.col.s.ce;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f33588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f33589b;

    public c() {
    }

    public static c a() {
        if (f33588a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f33588a != null) goto L9;
        f33588a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f33588a;
    }

    public void a(Context r100) {
        this.f33589b = r100;
        b();
    }

    public void b() {
        long r100 = e.e().f();
        long r101 = e.e().g();
        if ((System.currentTimeMillis() - r100) >= r101) goto L5;
        return;
    L5:
        c();
    }

    public final void c() {
    L96:
        th = move-exception;
        com.baidu.xclient.gdid.j.d.a(th);
        return;
    L4:
        if (com.baidu.xclient.gdid.j.d.a(this.f33589b) == true) goto L7;
        return;
    L7:
        if (com.baidu.mshield.b.e.a.d(this.f33589b) == true) goto L9;
        return;
    L9:
        String r100 = new com.baidu.xclient.gdid.g.a(this.f33589b, null).b();     // Catch: Throwable -> L96
        if (r100 != null) goto L12;
        return;
    L12:
        e.e().a(System.currentTimeMillis());     // Catch: Throwable -> L96
        if ("".equals(r100) == false) goto L15;
        return;
    L15:
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L96
        int r102 = r101.optInt("1", 1);     // Catch: Throwable -> L96
        e.e().a(r102);     // Catch: Throwable -> L96
        JSONObject r103 = r101.optJSONObject("2");     // Catch: Throwable -> L96
        if (r103 == null) goto L84;
        long r110 = r103.optLong(ce.f26395j);     // Catch: Throwable -> L96
        if (r110 < 0) goto L21;
        e.e().d(r110 * com.baidu.xclient.gdid.d.a.f33600a);     // Catch: Throwable -> L96
    L21:
        int r111 = r103.optInt("m", -1);     // Catch: Throwable -> L96
        if (r111 == (-1)) goto L26;
        if (r111 != 1) goto L25;
        e.e().a(true);     // Catch: Throwable -> L96
        goto L26
    L25:
        e.e().a(false);     // Catch: Throwable -> L96
    L26:
        int r112 = r103.optInt("e", -1);     // Catch: Throwable -> L96
        if (r112 == (-1)) goto L31;
        if (r112 != 1) goto L30;
        e.e().b(true);     // Catch: Throwable -> L96
        goto L31
    L30:
        e.e().b(false);     // Catch: Throwable -> L96
    L31:
        int r113 = r103.optInt("d", -1);     // Catch: Throwable -> L96
        if (r113 != 1) goto L34;
        e.e().c(true);     // Catch: Throwable -> L96
    L36:
        int r114 = r103.optInt(RXScreenCaptureService.KEY_INDEX, -1);     // Catch: Throwable -> L96
        if (r114 == (-1)) goto L41;
        if (r114 != 1) goto L40;
        e.e().g(true);     // Catch: Throwable -> L96
        goto L41
    L40:
        e.e().g(false);     // Catch: Throwable -> L96
    L41:
        int r115 = r103.optInt("w", -1);     // Catch: Throwable -> L96
        if (r115 == (-1)) goto L46;
        if (r115 != 1) goto L45;
        e.e().i(true);     // Catch: Throwable -> L96
        goto L46
    L45:
        e.e().i(false);     // Catch: Throwable -> L96
    L46:
        String r116 = r103.optString("p", "-1");     // Catch: Throwable -> L96
        if (r116.equals("-1") == true) goto L49;
        e.e().f(r116);     // Catch: Throwable -> L96
    L49:
        String r104 = Base64.encodeToString(r103.toString().getBytes(), 1);     // Catch: Throwable -> L96
        e.e().b(r104);     // Catch: Throwable -> L96
        int r105 = r103.optInt("o", -1);     // Catch: Throwable -> L96
        if (r105 != 1) goto L52;
        e.e().h(true);     // Catch: Throwable -> L96
    L54:
        int r106 = r103.optInt(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, -1);     // Catch: Throwable -> L96
        if (r106 != 1) goto L57;
        e.e().j(true);     // Catch: Throwable -> L96
    L59:
        int r107 = r103.optInt("t", -1);     // Catch: Throwable -> L96
        if (r107 != 1) goto L62;
        e.e().k(true);     // Catch: Throwable -> L96
    L64:
        int r108 = r103.optInt(OfficeSDKRequestTag.KEY_NEW_USER, -1);     // Catch: Throwable -> L96
        if (r108 != 1) goto L67;
        e.e().l(true);     // Catch: Throwable -> L96
    L69:
        int r109 = r103.optInt("h", -1);     // Catch: Throwable -> L96
        if (r109 != 1) goto L72;
        e.e().e(true);     // Catch: Throwable -> L96
    L74:
        int r117 = r103.optInt("f", -1);     // Catch: Throwable -> L96
        if (r117 != 1) goto L77;
        e.e().f(true);     // Catch: Throwable -> L96
    L79:
        int r118 = r103.optInt("aa", -1);     // Catch: Throwable -> L96
        if (r118 != 1) goto L82;
        e.e().d(true);     // Catch: Throwable -> L96
        goto L84
    L82:
        if (r118 != 0) goto L84;
        e.e().d(false);     // Catch: Throwable -> L96
        goto L84
    L77:
        if (r117 != 0) goto L79;
        e.e().f(false);     // Catch: Throwable -> L96
        goto L79
    L72:
        if (r109 != 0) goto L74;
        e.e().e(false);     // Catch: Throwable -> L96
        goto L74
    L67:
        if (r108 != 0) goto L69;
        e.e().l(false);     // Catch: Throwable -> L96
        goto L69
    L62:
        if (r107 != 0) goto L64;
        e.e().k(false);     // Catch: Throwable -> L96
        goto L64
    L57:
        if (r106 != 0) goto L59;
        e.e().j(false);     // Catch: Throwable -> L96
        goto L59
    L52:
        if (r105 != 0) goto L54;
        e.e().h(false);     // Catch: Throwable -> L96
        goto L54
    L34:
        if (r113 != 0) goto L36;
        e.e().c(false);     // Catch: Throwable -> L96
    L84:
        JSONObject r119 = r101.optJSONObject("6");     // Catch: Throwable -> L96
        if (r119 == null) goto L88;
        long r120 = ((long) r119.optInt("1", 0)) * com.baidu.xclient.gdid.d.a.f33600a;     // Catch: Throwable -> L96
        e.e().b(r120);     // Catch: Throwable -> L96
        long r121 = ((long) r119.optInt("2", 0)) * com.baidu.xclient.gdid.d.a.f33600a;     // Catch: Throwable -> L96
        e.e().f(r121);     // Catch: Throwable -> L96
        long r122 = ((long) r119.optInt("4", 0)) * com.baidu.xclient.gdid.d.a.f33600a;     // Catch: Throwable -> L96
        e.e().h(r122);     // Catch: Throwable -> L96
    L88:
        JSONObject r123 = r101.optJSONObject("7");     // Catch: Throwable -> L96
        if (r123 == null) goto L91;
        int r124 = r123.optInt("s", -1);     // Catch: Throwable -> L96
        e.e().e(r124);     // Catch: Throwable -> L96
        int r125 = r123.optInt("d", -1);     // Catch: Throwable -> L96
        e.e().b(r125);     // Catch: Throwable -> L96
        int r126 = r123.optInt(ce.f26395j, -1);     // Catch: Throwable -> L96
        e.e().c(r126);     // Catch: Throwable -> L96
        int r127 = r123.optInt("c", -1);     // Catch: Throwable -> L96
        e.e().d(r127);     // Catch: Throwable -> L96
        int r128 = r123.optInt("o", -1);     // Catch: Throwable -> L96
        e.e().f(r128);     // Catch: Throwable -> L96
    L91:
        String r129 = r101.optString("5");     // Catch: Throwable -> L96
        if (e.e().j().equals(r129) == false) goto L94;
        return;
    L94:
        e.e().a(r129);     // Catch: Throwable -> L96
        String r130 = r101.optString("3", "");     // Catch: Throwable -> L96
        String r131 = r101.optString("4", "");     // Catch: Throwable -> L96
        String r132 = r101.optString("8", "");     // Catch: Throwable -> L96
        e.e().d(r130);     // Catch: Throwable -> L96
        e.e().e(r131);     // Catch: Throwable -> L96
        e.e().g(r132);     // Catch: Throwable -> L96
    }
}
