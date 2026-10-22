package com.bytedance.ai.bridge.method.system;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.ai.api.navi.AppletNaviRideType;
import com.bytedance.ai.bridge.service.Location;
import com.bytedance.ai.bridge.service.NavigateMode;
import com.bytedance.ai.bridge.service.UserAction;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.locationmessage.ui.navigation.MapRouteService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f35947a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f35948b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f35949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f35950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f35951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AlertDialog f35952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<Pair<UserAction, Function0<Unit>>> f35953g = null;

    public b() {
    }

    static {
        f35947a = new b();
        f35948b = b.class.getSimpleName();
        f35953g = new ArrayList();
    }

    public static boolean b(Context r100, String r101) {
        boolean r102 = true;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L15;
        return false;
    L15:
        if (r100.getPackageManager().getPackageInfo(r101, 0) != null) goto L13;
        r102 = false;
    L13:
        return r102;
    L17:
        return false;
    L5:
        r103 = false;
        goto L6
    }

    public static void c(Context r100, String r101) {
        Intent r102 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(BaseConstants.MARKET_PREFIX.concat(r101)));
        if (r102.resolveActivity(r100.getPackageManager()) == null) goto L5;
        r100.startActivity(r102);
        return;
    L5:
        g.f37637a.e(f35948b, "can not find market app to install ".concat(r101));
    }

    public static void a(Context r100, Location r101, NavigateMode r102, Location r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dest");
        Intrinsics.checkNotNullParameter(r102, "mode");
        if (f35949c == true) goto L33;
        c(r100, MapRouteService.MapPackageName.PACKAGE_NAME_AMAP);
        return;
    L33:
    L27:
        e = move-exception;
        g.f37637a.e(f35948b, "[callUpAMapApp] with error msg:" + e.getMessage());
        return;
    L29:
        e = move-exception;
        g.f37637a.e(f35948b, "[callUpAMapApp] with error msg:" + e.getMessage());
        return;
    L5:
        if (r101.getLat() != null) goto L7;
        return;
    L7:
        if (r101.getLng() == null) goto L35;
        int r103 = f4.d.f475445a;     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        f4.a r104 = f4.d.a(r101.getLat().doubleValue(), r101.getLng().doubleValue());     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        Intent r105 = new Intent();     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        r105.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        r105.addCategory("android.intent.category.DEFAULT");     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        Uri.Builder r106 = new Uri.Builder().scheme("androidamap").authority(CloudControlInf.ROUTE).path("plan").appendQueryParameter("sourceApplication", BytedCertConstant.CertKey.FLOW).appendQueryParameter("dev", "1").appendQueryParameter("t", String.valueOf(r4.g.a(r102))).appendQueryParameter("dlat", String.valueOf(r104.f475432a)).appendQueryParameter("dlon", String.valueOf(r104.f475433b));     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        if (f.g(r101.getName()) == false) goto L12;
        r106.appendQueryParameter("dname", r101.getName());     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
    L12:
        if (r110 == null) goto L22;
        if (f.g(r110.getName()) == false) goto L17;
        r106.appendQueryParameter("sname", r110.getName());     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
    L17:
        if (r110.getLat() == null) goto L22;
        if (r110.getLng() == null) goto L22;
        f4.a r107 = f4.d.a(r110.getLat().doubleValue(), r110.getLng().doubleValue());     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        r106.appendQueryParameter("slat", String.valueOf(r107.f475432a));     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        r106.appendQueryParameter("slon", String.valueOf(r107.f475433b));     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
    L22:
        if (r102 != NavigateMode.RIDING) goto L24;
        r106.appendQueryParameter("rideType", AppletNaviRideType.BIKE);     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
    L24:
        r105.setData(r106.build());     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        r100.startActivity(r105);     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
    L38:
        return;
    }
}
