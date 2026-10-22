package com.bytedance.android.gamecp.business.download;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.DownloadInsideHelper;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.appdownloader.depend.IAppInstallMonitorListener;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class k1 implements IAppInstallMonitorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppLifecycleObserver f52798a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f52799b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k1 f52800c = null;

    public k1() {
    }

    static {
        f52800c = new k1();
        f52798a = new AppLifecycleObserver();
        f52799b = new ArrayList();
    }

    public static Map a() {
        LinkedHashMap r100 = new LinkedHashMap();
        CopyOnWriteArrayList<String> r101 = com.bytedance.android.gamecp.business.download.installstatus.i.f52786a;
        Context r102 = com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext();
        CopyOnWriteArrayList<String> r103 = com.bytedance.android.gamecp.business.download.installstatus.i.f52786a;
        if ((!r103.isEmpty()) == false) goto L6;
        String r104 = r103.toString();
    L19:
        r100.put("installer_list", r104);
        String r105 = RomUtils.getSysPackageInstaller(com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext());
        if (r105 != null) goto L22;
        r105 = "";
    L22:
        r100.put("installer_used", r105);
        if (com.bytedance.android.gamecp.common.utils.e.a() == false) goto L25;
        String r106 = "1";
    L26:
        r100.put("is_app_foreground", r106);
        return r100;
    L25:
        r106 = "0";
        goto L26
    L6:
        if (r102 == null) goto L8;
        PackageManager r107 = r102.getPackageManager();
    L9:
        String[] r108 = RomUtils.PACKAGE_INSTALLERS;
        int r109 = r108.length;
        int r110 = 0;
    L10:
        if (r110 >= r109) goto L18;
        String r111 = r108[r110];
        if (r107 != null) goto L29;
        PackageInfo r112 = null;
    L15:
        if (r112 == null) goto L17;
        com.bytedance.android.gamecp.business.download.installstatus.i.f52786a.add(r111);     // Catch: Exception -> L28
    L17:
        r110 = r110 + 1;
        goto L10
    L29:
        r112 = r107.getPackageInfo(r111, 0);     // Catch: Exception -> L28
    L18:
        r104 = com.bytedance.android.gamecp.business.download.installstatus.i.f52786a.toString();
        goto L19
    L8:
        r107 = null;
        goto L9
    }

    public static Map b(p r100) {
        Map r101 = a();
        if (r100 == null) goto L5;
        boolean r102 = com.bytedance.android.gamecp.common.track.c.f56779a;
        r101.putAll(com.bytedance.android.gamecp.common.track.c.a(r100.f52859m, r100.f52851i, r100.f52869r, r100.f52855k));
    L5:
        return r101;
    }

    public static Map c(p r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        AtomicInteger r102 = DownloadInfoFactory.f52322a;
        r101.putAll(com.bytedance.android.gamecp.common.utils.e0.c(DownloadInfoFactory.d(r100)));
        r101.putAll(com.bytedance.android.gamecp.common.utils.e0.c(DownloadInfoFactory.c(r100)));
        return r101;
    }

    public static Map d(b r100) {
        HashMap r101 = new HashMap();
        JSONObject r102 = null;
        if (r100 == null) goto L5;
        Integer r103 = Integer.valueOf(r100.f52536e);
    L6:
        r101.put("call_scene", String.valueOf(r103));
        if (r100 == null) goto L9;
        Long r104 = Long.valueOf(r100.f52532a);
    L10:
        r101.put("download_id", String.valueOf(r104));
        String r105 = "";
        if (r100 == null) goto L14;
        String r106 = r100.f52538g;
        if (r106 == null) goto L14;
    L15:
        r101.put("download_url", r106);
        if (r100 == null) goto L18;
        JSONObject r107 = r100.f52537f;
    L19:
        String r108 = e(r107);
        if (r108 != null) goto L22;
        r108 = "";
    L22:
        r101.put("game_id", r108);
        if (r100 == null) goto L25;
        JSONObject r109 = r100.f52537f;
    L26:
        String r110 = DownloadInsideHelper.getGameNameFromExtra(r109);
        if (r110 == null) goto L30;
        r105 = r110;
    L30:
        r101.put(EventConstants.ExtraJson.GAME_NAME, r105);
        if (r100 == null) goto L33;
        r102 = r100.f52537f;
    L33:
        r101.putAll(com.bytedance.android.gamecp.common.utils.e0.c(r102));
        return r101;
    L25:
        r109 = null;
        goto L26
    L18:
        r107 = null;
    L14:
        r106 = "";
        goto L15
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public static String e(JSONObject r100) {
        String r101 = DownloadInsideHelper.getGameIdFromExtra(r100);     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r101) == false) goto L20;
        if (r100 == null) goto L16;
        String r102 = r100.optString("unified_game_id");     // Catch: Exception -> L10
        if (r102 == null) goto L16;
    L21:
        return r102;
    L16:
        return "";
    L20:
        return r101;
    L11:
        if (r100 == null) goto L16;
        r102 = r100.optString("unified_game_id");
        if (r102 != null) goto L21;
        goto L16
    }

    public static String f(JSONObject r100) {
        String r101 = null;
        if (r100 != null) goto L21;
        JSONObject r102 = null;
    L6:
        if (r100 == null) goto L9;
        String r103 = r100.optString("room_id");     // Catch: Exception -> L20
        if (r103 == null) goto L9;
    L12:
        if (r103 != null) goto L16;
        if (r102 == null) goto L17;
        r101 = r102.optString(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID);     // Catch: Exception -> L20
    L18:
        return "";
    L17:
        if (r101 == null) goto L18;
        return r101;
    L16:
        r101 = r103;
    L9:
        if (r100 == null) goto L11;
        r103 = r100.optString(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID);     // Catch: Exception -> L20
        goto L12
    L11:
        r103 = null;
        goto L12
    L21:
        r102 = r100.optJSONObject(EventConstants.ExtraJson.DY_GAME_INFO);     // Catch: Exception -> L20
        goto L6
    }

    public static String g(JSONObject r100) {
        String r101 = null;
        if (r100 != null) goto L17;
        JSONObject r102 = null;
    L6:
        if (r100 == null) goto L11;
        String r103 = r100.optString(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID);     // Catch: Exception -> L16
        if (r103 == null) goto L11;
        r101 = r103;
    L13:
        if (r101 != null) goto L19;
    L14:
        return "";
    L19:
        return r101;
    L11:
        if (r102 == null) goto L13;
        r101 = r102.optString(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID);     // Catch: Exception -> L16
    L17:
        r102 = r100.optJSONObject(EventConstants.ExtraJson.DY_GAME_INFO);     // Catch: Exception -> L16
        goto L6
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppInstallMonitorListener
    public final void onMonitorSend(JSONObject r100) {
        if (wu.o.f561359a.getValue().b() == true) goto L6;
        yr.c.a("gamecp_InstallChainReporter", "onMonitorSend not enable");
        return;
    L6:
        Map<String, String> r101 = com.bytedance.android.gamecp.common.utils.e0.c(r100);
        Iterator r102 = ((ArrayList) f52799b).iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        HashMap r103 = (HashMap) r101;
        if (r103.containsKey((String) r102.next()) == true) goto L11;
        r103.put("product_type", "other");
        goto L8
    L11:
        r103.put("product_type", BaseConstants.GAME_INFO_LIVE_UNION);
        r102.remove();
    L13:
        ((HashMap) r101).putAll(a());
        yr.c.a("gamecp_InstallChainReporter", "onMonitorSend statsMap = " + r101);
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("game_invoke_install_path", r101);
    }

    public static void h(String r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (wu.o.f561359a.getValue().b() == true) goto L6;
        yr.c.a("gamecp_InstallChainReporter", "onEventBuildDownloadInfoFail not enable");
        return;
    L6:
        yr.c.a("gamecp_InstallChainReporter", "onEventBuildDownloadInfoFail: ".concat(r100));
        Map<String, String> r102 = d(r101);
        ((HashMap) r102).put("build_msg", r100);
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("game_build_download_info", r102);
    }

    public static void j(p r100, String r101, String r102) {
        yr.c.a("gamecp_InstallChainReporter", "1500ms后触发是否调起安装成功检测.. launchSuc: " + r101);
        Map<String, String> r103 = c(r100);
        r103.put("game_launch_suc", r101);
        r103.put("top_ac", r102);
        r103.putAll(b(r100));
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("game_install_launch_suc", r103);
    }

    public static void k(p r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r101, "status");
        Intrinsics.checkNotNullParameter(r102, "extra");
        Map<String, String> r103 = c(r100);
        r103.putAll(b(r100));
        r103.putAll(r102);
        r103.put(MonitorConstants.APP_INSTALL_STATUS, r101);
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("game_after_jump_install", r103);
    }

    public static void i(b r100, boolean r101, boolean r102, boolean r103) {
        if (wu.o.f561359a.getValue().b() == true) goto L6;
        yr.c.a("gamecp_InstallChainReporter", "onEventCloudInterceptInstall not enable");
        return;
    L6:
        Map<String, String> r104 = a();
        String r105 = "1";
        if (r101 == false) goto L9;
        String r106 = "1";
    L10:
        r104.put("is_intercept", r106);
        if (r102 == false) goto L13;
        String r107 = "1";
    L14:
        r104.put("is_cloud_show", r107);
        if (r103 == true) goto L18;
        r105 = "0";
    L18:
        r104.put("user_exec_install", r105);
        r104.putAll(d(r100));
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("game_install_cloud_intercept", r104);
        return;
    L13:
        r107 = "0";
        goto L14
    L9:
        r106 = "0";
        goto L10
    }
}
