package com.bytedance.apm6.util.c;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.bytedance.apm6.util.c.a f5460a;

    /* JADX INFO: compiled from: Logger.java */
    public static class a implements com.bytedance.apm6.util.c.a {
        public a() {
        }

        @Override // com.bytedance.apm6.util.c.a
        public void b(String r1, String r2) {
            if (com.bytedance.apm6.util.a.u() == false) goto L6;
            e(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.c.a
        public void c(String r1, String r2) {
            if (com.bytedance.apm6.util.a.u() == false) goto L6;
            f(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.c.a
        public void d(String r1, String r2) {
            if (com.bytedance.apm6.util.a.u() == false) goto L6;
            g(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.c.a
        public void b(String r1, String r2, Throwable r3) {
            if (com.bytedance.apm6.util.a.u() == false) goto L6;
            c(r1, r2, r3);
            return;
        }

        @Override // com.bytedance.apm6.util.c.a
        public void a(String r1, String r2) {
            if (com.bytedance.apm6.util.a.u() == false) goto L6;
            h(r1, r2);
            return;
        }

        @Override // com.bytedance.apm6.util.c.a
        public void a(String r1, String r2, Throwable r3) {
            if (com.bytedance.apm6.util.a.u() == false) goto L6;
            d(r1, r2, r3);
            return;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int e(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int f(String r1, String r2) {
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
        public static int c(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2, r3);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int h(String r0, String r1) {
            return Log.e(r0, r1);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int d(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    static {
        f5460a = new a();
    }

    public static void a(com.bytedance.apm6.util.c.a r2) {
        f5460a = (com.bytedance.apm6.util.c.a) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.apm6.util.c.a.class, "com.obric.aiagent.plugin");
    }

    public static void a(String r1, String r2) {
        com.bytedance.apm6.util.c.a r0 = f5460a;
        if (r0 == null) goto L6;
        r0.b(r1, r2);
        return;
    }

    public static void b(String r1, String r2) {
        com.bytedance.apm6.util.c.a r0 = f5460a;
        if (r0 == null) goto L6;
        r0.c(r1, r2);
        return;
    }

    public static void c(String r1, String r2) {
        com.bytedance.apm6.util.c.a r0 = f5460a;
        if (r0 == null) goto L6;
        r0.d(r1, r2);
        return;
    }

    public static void a(String r1, String r2, Throwable r3) {
        com.bytedance.apm6.util.c.a r0 = f5460a;
        if (r0 == null) goto L6;
        r0.b(r1, r2, r3);
        return;
    }

    public static void d(String r1, String r2) {
        com.bytedance.apm6.util.c.a r0 = f5460a;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public static void b(String r1, String r2, Throwable r3) {
        com.bytedance.apm6.util.c.a r0 = f5460a;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }
}
