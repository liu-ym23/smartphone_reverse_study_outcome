package com.bytedanceos.common.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ApplicationInfoEx;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.smt.obric.appstore.domain.sysapp.SysAppUtilKt;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f10202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f10203b;

    static {
    }

    public static void a(int r10) {
        b r11 = f10202a;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.b() != 0) goto L8;
        f10202a.h(r10);
        return;
    L8:
        if (f10202a.b() == r10) goto L10;
        return;
    L10:
        if (f10203b != null) goto L16;
        f10203b = b.a(f10202a);
        return;
    }

    public static void b() {
        f10202a = null;
        f10203b = null;
    }

    public static boolean c(Activity r10, Intent r11) {
        byte r12 = 1;
        boolean r13 = false;
        if (r11 != null) goto L5;
        return false;
    L5:
        String r14 = l(r10);
        com.bytedanceos.common.toolbox.j.e("call package = " + r14);
        boolean r15 = h(r14);
        if (r15 == false) goto L8;
    L10:
        if (r15 == true) goto L12;
    L13:
        q(r10, !r15);
    L14:
        com.bytedanceos.common.toolbox.j.a("toJumpByIntent handle intent: " + r11);
        String r16 = r11.getStringExtra("from_package");     // Catch: Exception -> L17
    L20:
        if (TextUtils.isEmpty(r16) == false) goto L22;
        r16 = "source_other";
    L22:
        String r17 = r11.getAction();
        if (TextUtils.isEmpty(r17) == true) goto L46;
        r17.hashCode();
        switch(r17.hashCode()) {
            case -1440625748: goto L35;
            case -1173171990: goto L32;
            case 2068413101: goto L28;
            default: goto L26;
        };
    L26:
        r12 = -1;
    L38:
        switch(r12) {
            case 0: goto L45;
            case 1: goto L44;
            case 2: goto L41;
            default: goto L46;
        };
    L44:
        r13 = d(r10, r11, r16);
        goto L46
    L45:
        r13 = g(r10, r11, r16);
        goto L46
    L41:
        if (b.g(r16) == false) goto L43;
        r16 = "com.bytedanceos.quicksearch";
    L43:
        r13 = d(r10, r11, r16);
        goto L46
    L28:
        if (r17.equals("android.intent.action.SEARCH") == false) goto L50;
        r12 = 2;
        goto L38
    L50:
        r12 = -1;
        goto L38
    L32:
        if (r17.equals("android.intent.action.VIEW") == true) goto L38;
        r12 = -1;
        goto L38
    L35:
        if (r17.equals("bytedanceos.appstore.recommend.app.detail.internal") == false) goto L52;
        r12 = 0;
        goto L38
    L52:
        r12 = -1;
    L46:
        b r18 = new b();
        r18.k(r16).l(r11.getStringExtra("from_position")).i(r11.getStringExtra("push_id")).j(r11.getStringExtra("push_source"));
        f(r18);
        return r13;
    L17:
        e = move-exception;
        e.printStackTrace();
        r16 = null;
        goto L20
    L12:
        if (r10.isTaskRoot() == false) goto L14;
    L8:
        if (d.a(r11) == true) goto L10;
        return false;
    }

    public static boolean d(Activity r10, Intent r11, String r12) {
        if (r11 != null) goto L4;
        return false;
    L4:
        if (r11.getData() != null) goto L7;
        return false;
    L7:
        if (k(r10, r11.getData(), r12) == false) goto L11;
        return true;
    L11:
        return i(r10, r11.getData(), r12);
    }

    public static b e() {
        return f10203b;
    }

    public static void f(b r10) {
        f10202a = r10;
        f10203b = b.a(r10);
    }

    public static boolean g(Activity r10, Intent r11, String r12) {
        if (r11 == null) goto L21;
        String r13 = r11.getStringExtra("type");
        if (TextUtils.isEmpty(r13) == true) goto L21;
        r13.hashCode();
        if (r13.equals(AppInfo.SEARCH_SOURCE_EXTENAL) == false) goto L9;
        String r14 = r11.getStringExtra(AppPermissionActivity.EXTRA_APP_PKG);
        String r15 = r11.getStringExtra("from_position");
        com.bytedanceos.common.toolbox.j.e("show fragment by [bytedanceos.appstore.recommend.app.detail.internal] now show the UI");
        boolean r16 = TextUtils.isEmpty(r14);
        if (TextUtils.equals(r15, "source_position_notification") == false) goto L18;
        if (r16 == true) goto L17;
        d9.a.e().o(3);
        goto L18
    L17:
        d9.a.e().o(0);
    L18:
        if (r16 == true) goto L21;
        m(r10, r14, r12, r11.getIntExtra("flag", 0));
        return true;
    L9:
        if (r13.equals("topic") == false) goto L21;
        u(r10, r11);
        return true;
    L21:
        return false;
    }

    public static boolean h(String r10) {
        PackageManager r11 = BaseApplication.c().getPackageManager();     // Catch: Exception -> L7
        if (r11 != null) goto L9;
        com.bytedanceos.common.toolbox.j.b("pm is null!");     // Catch: Exception -> L7
        return false;
    L9:
        PackageInfo r12 = r11.getPackageInfo(r10, 0);     // Catch: Exception -> L7
        if (r12 != null) goto L12;
        return false;
    L12:
        ApplicationInfo r13 = r12.applicationInfo;     // Catch: Exception -> L7
        if ((r13.flags & 129) == 0) goto L16;
        return true;
    L16:
        if (ApplicationInfoEx.isObricApp(r13) == false) goto L18;
        return true;
    L18:
        return false;
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean i(Activity r10, Uri r11, String r12) {
        if (r11 != null) goto L5;
    L47:
        return false;
    L5:
        if (TextUtils.isEmpty(r11.getAuthority()) == true) goto L47;
        String r13 = r11.getAuthority();
        r13.hashCode();
        byte r14 = -1;
        switch(r13.hashCode()) {
            case -906336856: goto L23;
            case 230662864: goto L19;
            case 1186311008: goto L15;
            case 1557721666: goto L11;
            default: goto L26;
        };
    L26:
        switch(r14) {
            case 0: goto L33;
            case 1: goto L31;
            case 2: goto L31;
            case 3: goto L28;
            default: goto L47;
        };
    L28:
        com.bytedanceos.common.toolbox.j.o("show detail fragment, uri = " + r11);
        return n(r10, r11.getQueryParameter("id"), r12, 0, TextUtils.equals(r11.getQueryParameter("i"), "1"));
    L31:
        return j(r10, r11, r12);
    L33:
        if ("1".equals(r11.getQueryParameter("s")) == false) goto L36;
        com.bytedanceos.common.e.f9820a.openAppManager(r10, com.bytedanceos.common.f.f9823a.b());
        com.bytedanceos.common.toolbox.j.o("AppJumpUtil jumpByAuthority openAppManager");
        return true;
    L36:
        String r15 = r11.getQueryParameter("q");
        if (TextUtils.isEmpty(r15) == true) goto L47;
        if (r15.startsWith("pname:") == false) goto L43;
        String r16 = r15.replaceFirst("pname:", "");
        com.bytedanceos.common.toolbox.j.e("show detail fragment by [" + r16 + "]");
        return m(r10, r16, r12, 0);
    L43:
        if (r15.startsWith("pub:") == false) goto L45;
        com.bytedanceos.common.toolbox.j.a("There is no method to deal this search with [pub]");
        goto L47
    L45:
        com.bytedanceos.common.toolbox.j.e("show search fragment by [" + r15 + "]");
        return s(r10, r15, r12, 3, r11.getQueryParameter("isid"));
    L11:
        if (r13.equals("details") == false) goto L26;
        r14 = 3;
        goto L26
    L15:
        if (r13.equals("appstore") == false) goto L26;
        r14 = 2;
        goto L26
    L19:
        if (r13.equals("market.android.com") == false) goto L26;
        r14 = 1;
        goto L26
    L23:
        if (r13.equals("search") == false) goto L26;
        r14 = 0;
        goto L26
    }

    public static boolean j(Activity r10, Uri r11, String r12) {
        if (r11 != null) goto L5;
    L36:
        return false;
    L5:
        if (r11.getPath() == null) goto L36;
        String r13 = r11.getPath();
        r13.hashCode();
        byte r14 = -1;
        switch(r13.hashCode()) {
            case -2143336809: goto L23;
            case -860539195: goto L19;
            case 1456116320: goto L15;
            case 1865428787: goto L11;
            default: goto L26;
        };
    L26:
        switch(r14) {
            case 0: goto L35;
            case 1: goto L33;
            case 2: goto L31;
            case 3: goto L29;
            default: goto L27;
        };
    L27:
        return false;
    L29:
        return m(r10, r11.getQueryParameter("id"), r12, 0);
    L31:
        return v(r10, r11.getQueryParameter("id"), "");
    L33:
        return s(r10, r11.getQueryParameter("id"), r12, 3, null);
    L35:
        return r(r10, r12, 3);
    L11:
        if (r13.equals("/details") == false) goto L26;
        r14 = 3;
        goto L26
    L15:
        if (r13.equals("/topic") == false) goto L26;
        r14 = 2;
        goto L26
    L19:
        if (r13.equals("/search_result") == false) goto L26;
        r14 = 1;
        goto L26
    L23:
        if (r13.equals("/search") == false) goto L26;
        r14 = 0;
        goto L26
    }

    public static boolean k(Activity r10, Uri r11, String r12) {
        if (r11 != null) goto L5;
    L26:
        return false;
    L5:
        if (r11.getScheme() == null) goto L26;
        String r13 = r11.getScheme();
        r13.hashCode();
        if (r13.equals("geo") == true) goto L25;
        if (r13.equals("file") == true) goto L12;
        return false;
    L12:
        String r14 = r11.getLastPathSegment();
        if (r14 != null) goto L15;
    L21:
        String r15 = "";
    L23:
        return t(r10, r15, r12, 0);
    L15:
        if (r14.length() <= 0) goto L21;
        int r16 = r14.lastIndexOf(46);
        if (r16 <= (-1)) goto L21;
        if (r16 >= (r14.length() - 1)) goto L21;
        r15 = r14.substring(r16 + 1);
        goto L23
    L25:
        return t(r10, r10.getString(R$string.search_app_map_suffix), r12, 0);
    }

    public static String l(Activity r10) {
        Field r11 = Class.forName("android.app.Activity").getDeclaredField("mReferrer");     // Catch: Throwable -> L4
        r11.setAccessible(true);     // Catch: Throwable -> L4
        return (String) r11.get(r10);
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static boolean m(Activity r10, String r11, String r12, int r13) {
        n(r10, r11, r12, r13, false);
        return true;
    }

    public static boolean n(Activity r10, String r11, String r12, int r13, boolean r14) {
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return false;
    L7:
        if (TextUtils.equals(r11, "com.bytedanceos.googleinstaller") == false) goto L10;
        r11 = "com.lbt.gms";
    L10:
        if (SysAppUtilKt.c().contains(r11) == false) goto L13;
        com.bytedanceos.common.e.f9820a.openAppManager(r10, com.bytedanceos.common.f.f9823a.b());
        return true;
    L13:
        AppInfo r15 = new AppInfo();
        r15.appPackageName = r11;
        r15.mSourcePkgName = r12;
        r15.mPageTitle = r10.getString(R$string.info);
        com.bytedanceos.common.toolbox.e.f1(r10, r15, r13, null, null, r14);
        return true;
    }

    public static boolean o(Activity r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        Intent r11 = r10.getIntent();
        if (r11 != null) goto L8;
        return false;
    L8:
        com.bytedanceos.common.toolbox.j.a("handle intent: " + r11);
        return c(r10, r11);
    }

    public static boolean p(Activity r10, Intent r11) {
        return c(r10, r11);
    }

    public static void q(Activity r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        Intent r12 = new Intent();
        Intent r13 = r10.getIntent();
        if (r13 == null) goto L10;
        if (r11 == false) goto L10;
        r12.setFlags(r13.getFlags());
        if (r13.getExtras() == null) goto L10;
        r12.putExtras(r13.getExtras());
    L10:
        r12.setAction(r10.getString(R$string.action_main));
        r12.setPackage(r10.getPackageName());
        if (r11 == true) goto L13;
        r12.addFlags(603979776);
    L14:
        r10.startActivity(r12);
        return;
    L13:
        r12.addFlags(268468224);
        goto L14
    }

    public static boolean r(Activity r10, String r11, int r12) {
        com.bytedanceos.common.toolbox.e.p1(r10, null, 0, r11, r12, null);
        return true;
    }

    public static boolean s(Activity r10, String r11, String r12, int r13, String r14) {
        if (TextUtils.isEmpty(r11) == true) goto L6;
        com.bytedanceos.common.toolbox.e.p1(r10, r11, 8, r12, r13, r14);
        return true;
    L6:
        return false;
    }

    public static boolean t(Activity r10, String r11, String r12, int r13) {
        if (TextUtils.isEmpty(r11) == true) goto L6;
        com.bytedanceos.common.toolbox.e.p1(r10, r11, 9, r12, r13, null);
        return true;
    L6:
        return false;
    }

    public static boolean u(Activity r10, Intent r11) {
        String r12 = r11.getStringExtra(ServerElements.TOPIC_ID);
        String r13 = r11.getStringExtra("topic_name");
        r11.getStringExtra("type");
        if (TextUtils.equals(r11.getStringExtra("from_position"), "source_position_notification") == false) goto L11;
        String r14 = r11.getStringExtra(ServerElements.TOPIC_ID);
        String r15 = r11.getStringExtra("topic_name");
        if (TextUtils.isEmpty(r14) == false) goto L7;
    L9:
        d9.a.e().o(0);
        goto L11
    L7:
        if (TextUtils.isEmpty(r15) == true) goto L9;
        d9.a.e().o(2);
    L11:
        return v(r10, r12, r13);
    }

    public static boolean v(Activity r10, String r11, String r12) {
        if (TextUtils.isEmpty(r11) == true) goto L6;
        Topic r13 = new Topic();
        r13.setId(r11);
        r13.setTitle(r12);
        r13.setTabSource("external_jump");
        com.bytedanceos.common.toolbox.e.L0(r10, r13);
        return true;
    L6:
        return false;
    }

    public static void w(int r10) {
        b r11 = f10202a;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.b() != r10) goto L9;
        f10203b = null;
        return;
    }
}
