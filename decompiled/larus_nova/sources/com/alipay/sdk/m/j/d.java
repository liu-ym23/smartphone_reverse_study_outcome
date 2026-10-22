package com.alipay.sdk.m.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.m.u.n;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f25373a = 1010;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f25374b;

    public interface a {
        void a(boolean r100, JSONObject r101, String r102);
    }

    public d() {
    }

    public static boolean a(com.alipay.sdk.m.s.a r100, Context r101) {
        return n.a(r100, r101, Collections.singletonList(new com.alipay.sdk.m.m.a.b("com.taobao.taobao", 0, "")), false);
    }

    public static boolean a(com.alipay.sdk.m.s.a r100, int r101, int r102, Intent r103) {
        if (r101 == 1010) goto L5;
        return false;
    L5:
        if (r103 != null) goto L7;
        return false;
    L7:
        a r104 = f25374b;
        if (r104 != null) goto L10;
        return true;
    L10:
        f25374b = null;
        if (r102 == (-1)) goto L15;
        if (r102 == 0) goto L14;
        com.alipay.sdk.m.k.a.b(r100, "biz", com.alipay.sdk.m.k.b.f25431w0, "" + r102);
    L16:
        return true;
    L14:
        com.alipay.sdk.m.k.a.a(r100, "biz", com.alipay.sdk.m.k.b.f25429v0, r103.toUri(1));
        r104.a(false, null, "CANCELED");
        goto L16
    L15:
        com.alipay.sdk.m.k.a.a(r100, "biz", com.alipay.sdk.m.k.b.f25433x0, r103.toUri(1));
        r104.a(true, n.a(r103), "OK");
        goto L16
    }

    public static boolean a(com.alipay.sdk.m.s.a r100, Activity r101, int r102, String r103, String r104, a r105) {
        com.alipay.sdk.m.k.a.a(r100, "biz", com.alipay.sdk.m.k.b.f25427u0);     // Catch: Throwable -> L6
        r101.startActivityForResult(new Intent(r104, Uri.parse(r103)), r102);     // Catch: Throwable -> L6
        f25374b = r105;     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        r105.a(false, null, "UNKNOWN_ERROR");
        com.alipay.sdk.m.k.a.a(r100, "biz", com.alipay.sdk.m.k.b.f25435y0, th);
        return false;
    }
}
