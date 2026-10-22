package com.obric.capability.schedulekit.c;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31905a = null;

    static {
        f31905a = new a();
    }

    @Override // com.obric.capability.schedulekit.c.b
    public boolean isDebug() {
        return false;
    }

    private a() {
    }

    @Override // com.obric.capability.schedulekit.c.b
    public void d(String r1, String r2) {
        o.e(r1, "tag");
        a(r1, String.valueOf(r2));
    }

    @Override // com.obric.capability.schedulekit.c.b
    public void e(String r1, String r2) {
        o.e(r1, "tag");
        b(r1, String.valueOf(r2));
    }

    @Override // com.obric.capability.schedulekit.c.b
    public void i(String r1, String r2) {
        o.e(r1, "tag");
        c(r1, String.valueOf(r2));
    }

    @Override // com.obric.capability.schedulekit.c.b
    public void w(String r1, String r2) {
        o.e(r1, "tag");
        f(r1, String.valueOf(r2));
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
    public static int f(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
