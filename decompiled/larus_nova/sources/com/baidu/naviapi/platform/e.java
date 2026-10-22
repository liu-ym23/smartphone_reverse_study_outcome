package com.baidu.naviapi.platform;

import android.content.Context;
import android.os.Build;
import com.alipay.sdk.m.u.i;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.naviapi.okhttp.HttpConfig;
import com.baidu.naviapi.okhttp.log.BNLogUtil;
import com.baidu.naviapi.open.IAuthResult;
import java.io.File;

/* JADX INFO: loaded from: classes39.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f32670b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f32671c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f32672d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f32673e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f32674f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f32675g = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f32676a;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f32677a = null;

        static {
            f32677a = new e(null);
        }

        public static /* synthetic */ e a() {
            return f32677a;
        }
    }

    public static e b() {
        return b.a();
    }

    public e() {
    }

    public String a() {
        return f32674f;
    }

    public /* synthetic */ e(a r100) {
        this();
    }

    public void a(boolean r100) {
        LBSAuthManager.getInstance(this.f32676a).setPrivacyMode(r100);
        f32674f = LBSAuthManager.getInstance(this.f32676a).getCUID();
    }

    public void a(IAuthResult r100) {
        c.a().a(this.f32676a, r100);
    }

    public void a(Context r100, boolean r101) {
        d.a(r100.getApplicationContext());
        this.f32676a = r100.getApplicationContext();
        if (r101 == false) goto L10;
        f32670b = Build.BOARD;
        f32671c = Build.MODEL;
        f32672d = Build.VERSION.RELEASE;
        f32673e = r100.getPackageName();
        File r102 = r100.getExternalFilesDir(null);
        if (r102 == null) goto L7;
        f32675g = r102.getAbsolutePath();
        BNLogUtil.setWritable(r101);
        BNLogUtil.setLogable(r101);
        BNLogUtil.setLogPath(f32675g);
    L8:
        StringBuilder r103 = new StringBuilder("cuid:");
        r103.append(f32674f);
        r103.append(";board:");
        r103.append(f32670b);
        r103.append(";model:");
        r103.append(f32671c);
        r103.append(";osversion:");
        r103.append(f32672d);
        r103.append(";packageName:");
        r103.append(f32673e);
        r103.append(i.f25853b);
        HttpConfig.phoneInfo = r103.toString();
        BNLogUtil.logI("init " + r103 + " version 1770610953560");
        return;
    L7:
        BNLogUtil.logI("no path");
        goto L8
    }
}
