package com.ss.android.common.util;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TeaLog.java */
/* JADX INFO: loaded from: classes4.dex */
public class f {

    /* JADX INFO: compiled from: TeaLog.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f37296a = false;

        static {
        }

        public static void a(String r1) {
            if (f37296a == false) goto L6;
            a("TeaLog_Task", r1);
            return;
        }

        public static void b(String r1) {
            if (f37296a == false) goto L6;
            b("TeaLog_Task", r1);
            return;
        }

        public static void c(String r1) {
            if (f37296a == false) goto L6;
            c("TeaLog_Task", r1);
            return;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int c(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }
}
