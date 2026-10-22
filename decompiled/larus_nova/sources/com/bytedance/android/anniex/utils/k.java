package com.bytedance.android.anniex.utils;

import android.net.Uri;
import com.bytedance.bdinstall.Level;
import com.bytedance.ies.bullet.secure.HybridSecureUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.c0;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class k {
    public static final String a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = c(r100);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        boolean r102 = true;
        if (r101.length() != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L36;
        String r104 = a36.b.e(r100, "channel");
        String r105 = a36.b.e(r100, "bundle");
        if (r104 != null) goto L13;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == true) goto L28;
        if (r105 != null) goto L20;
    L23:
        boolean r107 = true;
    L24:
        if (r107 == true) goto L28;
        return r104 + '_' + r105;
    L20:
        if (r105.length() == 0) goto L23;
        r107 = false;
    L28:
        if (r101.length() == 0) goto L31;
        r102 = false;
    L31:
        if (r102 == true) goto L33;
        return r101;
    L33:
        return r100.toString();
    L13:
        if (r104.length() == 0) goto L16;
        r106 = false;
        goto L17
    L36:
        return UriProtector.parse(r101).buildUpon().clearQuery().toString();
    L8:
        r103 = false;
        goto L9
    }

    public static final String c(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(r100.getScheme(), "http") == true) goto L13;
        if (Intrinsics.areEqual(r100.getScheme(), "https") == true) goto L13;
        String r101 = a36.b.e(r100, "a_surl");
        if (r101 != null) goto L14;
        String r102 = a36.b.e(r100, "surl");
        if (r102 == null) goto L16;
        return r102;
    L16:
        return a36.b.e(r100, "url");
    L14:
        return r101;
    L13:
        return r100.toString();
    }

    public static final String b(Uri r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Intrinsics.checkNotNullParameter(r211, "bid");
        Intrinsics.checkNotNullParameter(r212, "sessionId");
        String r100 = a36.b.e(r210, "ssr_url");
        Object r101 = null;
        if (r100 != null) goto L56;
        return null;
    L56:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L45
        Uri r103 = UriProtector.parse(r100);     // Catch: Throwable -> L45
        Uri.Builder r104 = r103.buildUpon();     // Catch: Throwable -> L45
        boolean r110 = true;
        if (a36.b.e(r103, "appended_global_props") != null) goto L30;
        String r111 = a36.b.e(r210, "append_global_props");     // Catch: Throwable -> L45
        if (r111 != null) goto L10;
    L18:
        List r112 = null;
    L19:
        List r113 = r112;     // Catch: Throwable -> L45
        if (r113 != null) goto L22;
    L25:
        boolean r114 = true;
    L26:
        if (r114 == true) goto L30;
        if (HybridSecureUtil.a(r103) == false) goto L30;
        ConcurrentHashMap<String, Object> r115 = com.bytedance.android.anniex.ability.f.f40204a;     // Catch: Throwable -> L45
        r104.appendQueryParameter("appended_global_props", new JSONObject(com.bytedance.android.anniex.ability.f.r(r210, r211, r212, r112)).toString());     // Catch: Throwable -> L45
        goto L30
    L22:
        if (r113.isEmpty() == true) goto L25;
        r114 = false;
        goto L26
    L10:
        if (r111.length() <= 0) goto L12;
        boolean r116 = true;
    L13:
        if (r116 == false) goto L15;
        String r117 = r111;
    L16:
        if (r117 == null) goto L18;
        r112 = StringsKt.split$default(r117, new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L45
        goto L19
    L15:
        r117 = null;
        goto L16
    L12:
        r116 = false;
    L30:
        r104.appendQueryParameter("disable_offline", "1");     // Catch: Throwable -> L45
        if (Intrinsics.areEqual(a36.b.e(r103, "append_common_params"), "0") == false) goto L33;
    L35:
        r110 = false;
    L36:
        String r105 = r104.build().toString();     // Catch: Throwable -> L45
        if (r110 == false) goto L43;
        StringBuilder r106 = new StringBuilder(r105);     // Catch: Throwable -> L45
        Lazy r107 = HybridSecureUtil.f247745a;     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r103, "uri");     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r106, "sb");     // Catch: Throwable -> L45
        if (HybridSecureUtil.a(r103) == false) goto L42;
        boolean r108 = AppLog.L;     // Catch: Throwable -> L45
        eta.b r109 = c0.f408079a;     // Catch: Throwable -> L45
        c0.d(r106, false, Level.L0);     // Catch: Throwable -> L45
    L42:
        r105 = r106.toString();     // Catch: Throwable -> L45
    L43:
        Object r118 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L45
    L48:
        if (Result.m9455isFailureimpl(r118) == true) goto L51;
        r101 = r118;
    L51:
        String r119 = (String) r101;
        if (r119 != null) goto L55;
        return r100;
    L55:
        return r119;
    L33:
        if (Intrinsics.areEqual(a36.b.e(r210, "append_common_params"), "1") == false) goto L35;
    L45:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L48
    }
}
