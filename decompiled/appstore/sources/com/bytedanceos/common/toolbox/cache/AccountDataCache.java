package com.bytedanceos.common.toolbox.cache;

import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.b0;
import java.util.Observable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AccountDataCache extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AccountDataCache f9997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f9998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f9999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f10000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f10001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f10002f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f10003g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f10004h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f10005i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f10006j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f10007k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f10008l;

    static {
    }

    public AccountDataCache() {
    }

    public static synchronized AccountDataCache b() {
        monitor-enter(AccountDataCache.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f9997a != null) goto L9;
        f9997a = new AccountDataCache();     // Catch: Throwable -> L7
    L9:
        AccountDataCache r10 = f9997a;     // Catch: Throwable -> L7
        monitor-exit(AccountDataCache.class);
        return r10;
    }

    public void a() {
        f9998b = null;
        f9999c = null;
        f10000d = null;
        f10001e = null;
        f10002f = null;
        f10003g = null;
        f10004h = null;
        f10005i = null;
        f10006j = null;
        f10007k = null;
        f10008l = null;
        String r10 = g();
        b0.n().j("com.bytedanceos.appstore.account", BaseApplication.c());
        if (TextUtils.isEmpty(r10) == true) goto L6;
        t(r10);
        return;
    }

    public String c() {
        if (TextUtils.isEmpty(f10004h) == false) goto L7;
        return h("accountname");
    L7:
        return f10004h;
    }

    public String d() {
        if (TextUtils.isEmpty(f10008l) == false) goto L7;
        return h("imgurl");
    L7:
        return f10008l;
    }

    public final boolean e(String r10) {
        return b0.n().l(r10, "com.bytedanceos.appstore.account", BaseApplication.c()).booleanValue();
    }

    public String f() {
        if (TextUtils.isEmpty(f10005i) == false) goto L7;
        return h(ServerElements.NICKNAME);
    L7:
        return f10005i;
    }

    public String g() {
        if (TextUtils.isEmpty(f9999c) == false) goto L7;
        return h("retainToken");
    L7:
        return f9999c;
    }

    public final String h(String r10) {
        return b0.n().s(r10, "com.bytedanceos.appstore.account", BaseApplication.c());
    }

    public String i() {
        if (TextUtils.isEmpty(f9998b) == false) goto L7;
        return h("ticket");
    L7:
        return f9998b;
    }

    public String j() {
        if (TextUtils.isEmpty(f10000d) == false) goto L7;
        return h("token");
    L7:
        return f10000d;
    }

    public String k() {
        if (TextUtils.isEmpty(f10007k) == false) goto L7;
        return h("id");
    L7:
        return f10007k;
    }

    public String l() {
        if (TextUtils.isEmpty(f10006j) == false) goto L7;
        return h("username");
    L7:
        return f10006j;
    }

    public String m() {
        if (TextUtils.isEmpty(f10003g) == false) goto L7;
        return h("captcha");
    L7:
        return f10003g;
    }

    public boolean n() {
        return e("isLogin");
    }

    public final void o(String r10, Boolean r11) {
        b0.n().C(r10, r11.booleanValue(), "com.bytedanceos.appstore.account", BaseApplication.c());
    }

    public final void p(String r10, String r11) {
        b0.n().H(r10, r11, "com.bytedanceos.appstore.account", BaseApplication.c());
    }

    public void q(String r10) {
        f10008l = r10;
        p("imgurl", r10);
    }

    public void r(boolean r10) {
        o("isLogin", Boolean.valueOf(r10));
    }

    public void s(String r10) {
        f10005i = r10;
        p(ServerElements.NICKNAME, r10);
    }

    public void t(String r10) {
        f9999c = r10;
        p("retainToken", r10);
    }

    public void u(String r10) {
        f9998b = r10;
        p("ticket", r10);
    }

    public void v(String r10) {
        f10004h = r10;
        p("id", r10);
    }

    public void w(String r10) {
        f10006j = r10;
        p("username", r10);
    }

    public void x(String r10) {
        f10003g = r10;
        p("captcha", r10);
    }

    public void y(JSONObject r10) {
        String r11 = r10.optString("email");
        String r12 = r10.optString("cellphone");
        String r13 = r10.optString(ServerElements.NICKNAME);
        f10005i = r13;
        if (TextUtils.isEmpty(r13) == false) goto L5;
        f10005i = r10.optString("nick_name");
    L5:
        f10007k = r10.optString("uid");
        f10008l = r10.optString("avatar_url");
        boolean r14 = true;
        if (TextUtils.isEmpty(r11) == true) goto L12;
        if (r10.optInt("active") > 1) goto L12;
        r14 = false;
    L12:
        if (TextUtils.isEmpty(r11) == false) goto L15;
        r11 = r12;
    L15:
        f10004h = r11;
        if (TextUtils.isEmpty(f10005i) == true) goto L18;
        String r15 = f10005i;
    L19:
        f10006j = r15;
        p("accountname", f10004h);
        p(ServerElements.NICKNAME, f10005i);
        p("username", f10006j);
        p("id", f10007k);
        p("imgurl", f10008l);
        o("isActived", Boolean.valueOf(r14));
        o("isEncrypt", Boolean.TRUE);
        return;
    L18:
        r15 = f10004h;
        goto L19
    }
}
