package com.bytedance.applog.log;

import android.util.Log;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ConsoleLogProcessor.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.c f5702a;

    public c(com.bytedance.applog.c r2) {
        this.f5702a = r2;
        a(h.a().a(r2.b()).a(1).b(Thread.currentThread().getName()).c("Console logger is ready.").a());
    }

    @Override // com.bytedance.applog.log.g
    public void a(h r3) {
        if (this.f5702a.am() == true) goto L5;
        return;
    L5:
        int r2 = r3.b();
        if (r2 != 0) goto L8;
        a("AppLog", r3.h());
        return;
    L8:
        if (r2 != 2) goto L10;
        b("AppLog", r3.h());
        return;
    L10:
        if (r2 != 3) goto L12;
        a("AppLog", r3.h(), r3.c());
        return;
    L12:
        if (r2 != 4) goto L14;
    L16:
        b("AppLog", r3.h(), r3.c());
        return;
    L14:
        if (r2 == 5) goto L16;
        c("AppLog", r3.toString());
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
