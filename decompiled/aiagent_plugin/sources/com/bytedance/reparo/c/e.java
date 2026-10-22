package com.bytedance.reparo.c;

import android.app.Application;
import android.util.Log;
import com.bytedance.reparo.core.j;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final j.a f9112a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashSet<String> f9113b = null;

    /* JADX INFO: compiled from: Logger.java */
    public static class a extends RuntimeException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9114a;

        public a(String r3, String r4) {
            super("on " + r3 + " " + r4);
            this.f9114a = r4;
        }

        public a a() {
            int r1 = this.f9114a.indexOf(40);     // Catch: Throwable -> L5
            String r2 = this.f9114a;     // Catch: Throwable -> L5
            String r3 = r2.substring(r2.indexOf(32) + 1, this.f9114a.lastIndexOf(".", r1));     // Catch: Throwable -> L5
            String r4 = this.f9114a;     // Catch: Throwable -> L5
            setStackTrace(new StackTraceElement[]{new StackTraceElement(r3, r4.substring(r4.lastIndexOf(".", r1) + 1, r1), "SourceFile", 1)});     // Catch: Throwable -> L5
        L4:
            return this;
        }
    }

    /* JADX INFO: compiled from: Logger.java */
    public static class b implements j.a {
        public b() {
        }

        @Override // com.bytedance.reparo.core.j.a
        public void a(String r2, String r3) {
            b("Reparo/" + r2, r3);
        }

        @Override // com.bytedance.reparo.core.j.a
        public void c(String r2, String r3) {
            d("Reparo/" + r2, r3);
        }

        @Override // com.bytedance.reparo.core.j.a
        public void e(String r2, String r3) {
            f("Reparo/" + r2, r3);
        }

        @Override // com.bytedance.reparo.core.j.a
        public void a(String r2, String r3, Throwable r4) {
            b("Reparo/" + r2, r3, r4);
        }

        @Override // com.bytedance.reparo.core.j.a
        public void g(String r3, String r4) {
            i("Reparo/" + r3, r4);
            h.a("Reparo/", "errorlog", e.a(new RuntimeException("\"" + r4 + "\"")));
        }

        @Override // com.bytedance.reparo.core.j.a
        public void c(String r4, String r5, Throwable r6) {
            if (r6 == null) goto L4;
            String r3 = (r5 + "\n") + com.bytedance.reparo.core.a.b.f.a(r6);
        L5:
            i("Reparo/" + r4, r3);
            if (e.b(r6) == false) goto L8;
            String r7 = "ignored";
        L9:
            h.a("Reparo/", r7, e.a(new RuntimeException("\"" + r5 + "\"", r6)));
            return;
        L8:
            r7 = "catched";
            goto L9
        L4:
            r3 = r5;
            goto L5
        }

        @Override // com.bytedance.reparo.core.j.a
        public void h(String r2, String r3) {
            i("Reparo/", "check for collide method " + r3);
            h.a("Reparo/", "collide", new a(r2, r3).a());
        }

        @Override // com.bytedance.reparo.core.j.a
        public void a(String r2) {
            i("Reparo/", "logForSymbolNotFound " + r2);
            h.a("Reparo/", "symbol", new c(r2));
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int d(String r1, String r2) {
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
        public static int b(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2, r3);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int i(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    /* JADX INFO: compiled from: Logger.java */
    public static class c extends RuntimeException {
        public c(String r6) {
            super("NotFoundSymbol " + r6);
            setStackTrace(new StackTraceElement[]{new StackTraceElement("SymbolNotFoundException", r6, "SourceFile", 1)});
        }
    }

    public e() {
    }

    static /* synthetic */ Throwable a(Throwable r0) {
        return c(r0);
    }

    static /* synthetic */ boolean b(Throwable r0) {
        return d(r0);
    }

    static {
        f9112a = new b();
        f9113b = new HashSet();
    }

    public static void a(Application r2) {
        Application r3 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
        HashSet<String> r4 = f9113b;
        r4.add(e.class.getName());
        r4.add(j.class.getName());
        r4.add(com.bytedance.reparo.core.f.a.class.getName());
        r4.add(b.class.getName());
        if (ZeusTransformUtils.instanceOf(j.a(), b.class) == true) goto L6;
        j.a(f9112a);
        return;
    }

    public static void a(String r1, String r2) {
        f9112a.c(r1, r2);
    }

    public static void b(String r1, String r2) {
        f9112a.g(r1, r2);     // Catch: Throwable -> L4
        return;
    }

    public static void a(String r1, String r2, Throwable r3) {
        f9112a.c(r1, r2, r3);     // Catch: Throwable -> L4
        return;
    }

    private static Throwable c(Throwable r5) {
        StackTraceElement[] r0 = r5.getStackTrace();
        int r1 = 0;
        int r2 = 0;
    L3:
        HashSet<String> r3 = f9113b;
        if (r1 >= r3.size()) goto L11;
        if (r1 >= r0.length) goto L11;
        if (r3.contains(r0[r1].getClassName()) == true) goto L10;
        r2 = r1;
    L10:
        r1 = r1 + 1;
    L11:
        r5.setStackTrace((StackTraceElement[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(r0, r2, r0.length), StackTraceElement[].class, "com.obric.aiagent.plugin"));
        return r5;
    }

    private static boolean d(Throwable r4) {
        Throwable r2 = r4;
        int r1 = 0;
    L4:
        if (r1 >= 10) goto L14;
        if (r2 == null) goto L14;
        if (ZeusTransformUtils.instanceOf(r2, IOException.class) == true) goto L8;
        if (r2.getCause() == r2) goto L14;
        r2 = r4.getCause();
        r1 = r1 + 1;
        goto L4
    L8:
        return true;
    L14:
        return false;
    }
}
