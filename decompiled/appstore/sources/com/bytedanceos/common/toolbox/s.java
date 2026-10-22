package com.bytedanceos.common.toolbox;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s {
    public static void A(Context r10, boolean r11) {
        if (BaseApplication.c().o() == false) goto L5;
        String r12 = "com.bytedanceos.appstore.setting";
    L6:
        g0.a().i(r11);
        b0.n().C("isShowUpdateCount", r11, r12, r10);
        return;
    L5:
        r12 = "com.bytedanceos.gamestore.setting";
        goto L6
    }

    public static /* synthetic */ void a(boolean r10) {
        p(r10);
    }

    public static boolean b(String r10) {
        String r11 = e(BaseApplication.c());
        if (TextUtils.isEmpty(r11) == true) goto L11;
        String[] r12 = r11.split(";");
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L11;
        if (TextUtils.equals(r12[r14], r10) == true) goto L8;
        r14 = r14 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    public static String c(Context r10) {
        return b0.n().s("hide_app_package_name", null, r10);
    }

    public static boolean d(Context r10) {
        return b0.n().l("isactive_network_prompt", null, r10).booleanValue();
    }

    public static String e(Context r10) {
        return b0.n().s("overwrite_install_apps", null, r10);
    }

    public static String f() {
        if (BaseApplication.c().o() == false) goto L5;
        return "appstore_show_recommend_apps";
    L5:
        return "gamestore_show_recommend_apps";
    }

    public static boolean g(Context r10) {
        if (BaseApplication.c().o() == false) goto L5;
        String r11 = "com.bytedanceos.appstore.setting";
    L7:
        return b0.n().m("isAutoUpdate", r11, r10, false).booleanValue();
    L5:
        r11 = "com.bytedanceos.gamestore.setting";
        goto L7
    }

    public static boolean h(Context r10) {
        if (TextUtils.equals(Settings.Global.getString(r10.getContentResolver(), f()), "true") == false) goto L9;
        return false;
    L9:
        if (BaseApplication.c().o() == false) goto L11;
        String r11 = "com.bytedanceos.appstore.setting";
    L12:
        String r12 = b0.n().r(CommonKey.KEY_OS_VERSION, r11);
        if (TextUtils.isEmpty(r12) == true) goto L16;
        w(r10);
        j.e("reset fist show apps," + r12);
        return false;
    L16:
        return true;
    L11:
        r11 = "com.bytedanceos.gamestore.setting";
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static boolean i(Context r10) {
        if (BaseApplication.c().o() == false) goto L5;
        String r11 = "com.bytedanceos.appstore.setting";
    L7:
        return b0.n().m("show_update_notification", r11, r10, true).booleanValue();
    L5:
        r11 = "com.bytedanceos.gamestore.setting";
        goto L7
    }

    public static boolean j(String r10) {
        long r11 = b0.n().p(r10, null, BaseApplication.c());
        if (r11 != 0) goto L5;
        return true;
    L5:
        if ((r11 + 3600000) < System.currentTimeMillis()) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean k(Context r10) {
        if (BaseApplication.c().o() == false) goto L5;
        String r11 = "com.bytedanceos.appstore.setting";
    L7:
        return b0.n().l("isShowImageOnlyWlan", r11, r10).booleanValue();
    L5:
        r11 = "com.bytedanceos.gamestore.setting";
        goto L7
    }

    public static boolean l(Context r10) {
        if (BaseApplication.c().o() == false) goto L5;
        String r11 = "com.bytedanceos.appstore.setting";
    L7:
        return b0.n().m("isShowRecommendMessage", r11, r10, true).booleanValue();
    L5:
        r11 = "com.bytedanceos.gamestore.setting";
        goto L7
    }

    public static boolean m(Context r10) {
        if (BaseApplication.c().o() == false) goto L5;
        String r11 = "com.bytedanceos.appstore.setting";
    L7:
        return b0.n().m("isShowTabBottomUpdateCount", r11, r10, true).booleanValue();
    L5:
        r11 = "com.bytedanceos.gamestore.setting";
        goto L7
    }

    public static boolean n(Context r10) {
        if (BaseApplication.c().o() == false) goto L5;
        String r11 = "com.bytedanceos.appstore.setting";
    L7:
        return b0.n().m("isShowUpdateCount", r11, r10, true).booleanValue();
    L5:
        r11 = "com.bytedanceos.gamestore.setting";
        goto L7
    }

    public static boolean o(Context r10) {
        if (g(r10) == false) goto L6;
        return false;
    L6:
        if (b0.n().o("switch_update", null, r10) <= (-1)) goto L8;
        return false;
    L8:
        return true;
    }

    public static /* synthetic */ void p(boolean r10) {
        com.bytedanceos.common.utils.v.a(r10);
    }

    public static void q(Context r10, String r11) {
        b0.n().H("hide_app_package_name", r11, null, r10);
    }

    public static void r(Context r10, final boolean r11) {
        if (BaseApplication.c().o() == false) goto L6;
        String r12 = "com.bytedanceos.appstore.setting";
    L5:
        String r13 = r12;
        g0.a().e(r11);
        b0.n().D("isAutoUpdate", r11, r13, r10, new r(r11));
        return;
    L6:
        r12 = "com.bytedanceos.gamestore.setting";
        goto L5
    }

    public static void s(AppInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Settings.Global.putInt(BaseApplication.c().getContentResolver(), "last_gamestore_version_code", r10.appVersionCode);
    }

    public static void t(String r10) {
        b0.n().F(r10, System.currentTimeMillis(), null, BaseApplication.c());
    }

    public static void u(Context r10) {
        b0.n().C("isactive_network_prompt", true, null, r10);
    }

    public static void v(Context r10, boolean r11) {
        if (BaseApplication.c().o() == false) goto L5;
        String r12 = "com.bytedanceos.appstore.setting";
    L6:
        g0.a().j(r11);
        b0.n().C("show_update_notification", r11, r12, r10);
        return;
    L5:
        r12 = "com.bytedanceos.gamestore.setting";
        goto L6
    }

    public static void w(Context r10) {
        String r11 = f();
        Settings.Global.putString(r10.getContentResolver(), r11, "true");
    }

    public static void x(Context r10, boolean r11) {
        if (BaseApplication.c().o() == false) goto L5;
        String r12 = "com.bytedanceos.appstore.setting";
    L6:
        b0.n().C("isShowImageOnlyWlan", r11, r12, r10);
        return;
    L5:
        r12 = "com.bytedanceos.gamestore.setting";
        goto L6
    }

    public static void y(Context r10, boolean r11) {
        if (BaseApplication.c().o() == false) goto L5;
        String r12 = "com.bytedanceos.appstore.setting";
    L6:
        g0.a().h(r11);
        b0.n().C("isShowRecommendMessage", r11, r12, r10);
        return;
    L5:
        r12 = "com.bytedanceos.gamestore.setting";
        goto L6
    }

    public static void z(Context r10, boolean r11) {
        if (BaseApplication.c().o() == false) goto L5;
        String r12 = "com.bytedanceos.appstore.setting";
    L6:
        g0.a().g(r11);
        b0.n().C("isShowTabBottomUpdateCount", r11, r12, r10);
        return;
    L5:
        r12 = "com.bytedanceos.gamestore.setting";
        goto L6
    }
}
