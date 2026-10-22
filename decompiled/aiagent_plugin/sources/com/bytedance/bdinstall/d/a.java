package com.bytedance.bdinstall.d;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AliYunUUIDHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f6203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6204b;

    static {
    }

    private a() {
        if (e() == false) goto L8;
        String r0 = c();
        this.f6204b = r0;
        if (TextUtils.isEmpty(r0) == false) goto L9;
        this.f6204b = d();
        return;
    L9:
        return;
    }

    public static a a() {
        if (f6203a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6203a != null) goto L9;
        f6203a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f6203a;
    }

    public String b() {
        return this.f6204b;
    }

    private static String c() {
        return a("ro.aliyun.clouduuid", "false");
    }

    private static String d() {
        return a("ro.sys.aliyun.clouduuid", "false");
    }

    private static String a(String r8, String r9) {
        return (String) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{r8, r9}), String.class, "com.obric.aiagent.plugin");
    L5:
        return r9;
    }

    private static boolean e() {
        if (System.getProperty("java.vm.name") != null) goto L6;
    L7:
        if (System.getProperty("ro.yunos.version") != null) goto L16;
        return false;
    L16:
        return true;
    L6:
        if (System.getProperty("java.vm.name").toLowerCase().contains("lemur") == false) goto L7;
        return true;
    L17:
        return false;
    }
}
