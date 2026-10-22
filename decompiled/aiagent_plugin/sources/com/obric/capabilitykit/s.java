package com.obric.capabilitykit;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.capabilitykit.logger.ILogger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements ILogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f32225a = null;

    static {
        f32225a = new s();
    }

    private s() {
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void d(String r1, String r2) {
        d.h.b.o.e(r1, "tag");
        a(r1, String.valueOf(r2));
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void e(String r1, String r2) {
        d.h.b.o.e(r1, "tag");
        b(r1, String.valueOf(r2));
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void e(String r1, String r2, Throwable r3) {
        d.h.b.o.e(r1, "tag");
        a(r1, String.valueOf(r2), r3);
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void i(String r1, String r2) {
        d.h.b.o.e(r1, "tag");
        c(r1, String.valueOf(r2));
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public boolean isDebug() {
        return false;
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void v(String r1, String r2) {
        d.h.b.o.e(r1, "tag");
        f(r1, String.valueOf(r2));
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void w(String r1, String r2) {
        d.h.b.o.e(r1, "tag");
        g(r1, String.valueOf(r2));
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void w(String r1, String r2, Throwable r3) {
        d.h.b.o.e(r1, "tag");
        b(r1, String.valueOf(r2), r3);
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void w(String r1, Throwable r2) {
        d.h.b.o.e(r1, "tag");
        a(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int f(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int g(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, Throwable r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
