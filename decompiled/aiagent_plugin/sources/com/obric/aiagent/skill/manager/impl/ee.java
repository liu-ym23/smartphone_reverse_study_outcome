package com.obric.aiagent.skill.manager.impl;

import android.util.Log;
import com.obric.aiagent.platform.depend.IAppContext;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SkillSafeLog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ee {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ee f19808a = null;

    static {
        f19808a = new ee();
    }

    private ee() {
    }

    public final void a(String r1, String r2, String r3) {
        d.h.b.o.e(r1, "tag");
        d.h.b.o.e(r2, "releaseMessage");
        d.h.b.o.e(r3, "debugMessage");
        if (IAppContext.Companion.isDebug() == false) goto L5;
        r2 = r3;
    L5:
        a(r1, r2);
    }

    public static /* synthetic */ void a(ee r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = r2;
    L5:
        r0.b(r1, r2, r3);
    }

    public final void b(String r1, String r2, String r3) {
        d.h.b.o.e(r1, "tag");
        d.h.b.o.e(r2, "releaseMessage");
        d.h.b.o.e(r3, "debugMessage");
        if (IAppContext.Companion.isDebug() == false) goto L5;
        r2 = r3;
    L5:
        b(r1, r2);
    }

    public static /* synthetic */ void b(ee r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = r2;
    L5:
        r0.c(r1, r2, r3);
    }

    public final void c(String r1, String r2, String r3) {
        d.h.b.o.e(r1, "tag");
        d.h.b.o.e(r2, "releaseMessage");
        d.h.b.o.e(r3, "debugMessage");
        if (IAppContext.Companion.isDebug() == false) goto L5;
        r2 = r3;
    L5:
        c(r1, r2);
    }

    public final void a(String r1, String r2, String r3, Throwable r4) {
        d.h.b.o.e(r1, "tag");
        d.h.b.o.e(r2, "releaseMessage");
        d.h.b.o.e(r3, "debugMessage");
        if (IAppContext.Companion.isDebug() == false) goto L7;
        if (r4 == null) goto L7;
        a(r1, r3, r4);
        return;
    L7:
        if (IAppContext.Companion.isDebug() == false) goto L9;
        r2 = r3;
    L9:
        d(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
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
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int d(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
