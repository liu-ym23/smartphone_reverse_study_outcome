package com.bytedance.librarian;

import android.util.Log;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: LibrarianMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public c() {
    }

    public void a(String r1) {
        a("librarian", r1);
    }

    public void b(String r1) {
        b("librarian", r1);
    }

    public void a(String r1, Throwable r2) {
        a("librarian", r1, r2);
    }

    public void c(String r1) {
        System.loadLibrary(r1);
    }

    public void d(String r1) {
        System.load(r1);
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
        return Log.w(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
