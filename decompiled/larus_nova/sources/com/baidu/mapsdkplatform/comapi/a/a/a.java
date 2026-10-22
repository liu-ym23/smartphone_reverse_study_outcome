package com.baidu.mapsdkplatform.comapi.a.a;

import com.obric.sva.sdk.controller.Global;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes39.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f31966a = 10240;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f31967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f31968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f31969d;

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.a.a.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0639a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f31970a = null;

        static {
            f31970a = new a(null);
        }

        public static /* synthetic */ a a() {
            return f31970a;
        }
    }

    private a() {
        this.f31968c = "";
        this.f31969d = Thread.getDefaultUncaughtExceptionHandler();
    }

    public static a a() {
        return b.a();
    }

    public /* synthetic */ a(C0639a r100) {
        this();
    }

    private void a(Throwable r100) {
        if (r100 != null) goto L34;
        return;
    L34:
        StringWriter r101 = new StringWriter();     // Catch: Exception -> L33
        PrintWriter r102 = new PrintWriter(r101);     // Catch: Exception -> L33
        r100.printStackTrace(r102);     // Catch: Exception -> L33
        Throwable r103 = r100.getCause();     // Catch: Exception -> L33
        if (r103 == null) goto L7;
        r103.printStackTrace(r102);     // Catch: Exception -> L33
    L7:
        r102.close();     // Catch: Exception -> L33
        String r104 = r101.toString();     // Catch: Exception -> L33
        if (r104.isEmpty() == false) goto L10;
        return;
    L10:
        int r105 = r104.length();     // Catch: Exception -> L33
        int r106 = f31966a;     // Catch: Exception -> L33
        if (r105 <= r106) goto L14;
        r104 = r104.substring(0, r106);     // Catch: Exception -> L33
    L14:
        if (r104.contains("BDMapSDKException") == false) goto L16;
        return;
    L16:
        if (r104.contains("com.baidu.platform") == false) goto L18;
    L26:
        String r107 = this.f31968c;     // Catch: Exception -> L33
        if (r107 != null) goto L29;
        return;
    L29:
        if (r107.isEmpty() == true) goto L39;
        com.baidu.mapsdkplatform.comapi.a.a.b.c().a(this.f31968c + (System.currentTimeMillis() / 1000) + Global.SUFFIX_TXT_FILE, r104);     // Catch: Exception -> L33
        return;
    L39:
        return;
    L18:
        if (r104.contains("com.baidu.mapsdkplatform") == true) goto L26;
        if (r104.contains("com.baidu.baidunavis") == true) goto L26;
        if (r104.contains("com.baidu.navisdk") == true) goto L26;
        if (r104.contains("com.baidu.navcore") == true) goto L26;
        return;
    }

    public void a(String r100) {
        this.f31968c = r100;
        if ((Thread.getDefaultUncaughtExceptionHandler() instanceof a) == true) goto L6;
        Thread.setDefaultUncaughtExceptionHandler(this);
        return;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r100, Throwable r101) {
        if (f31967b == false) goto L5;
        return;
    L5:
        f31967b = true;
        a(r101);
        Thread.UncaughtExceptionHandler r102 = this.f31969d;
        if (r102 == null) goto L9;
        r102.uncaughtException(r100, r101);
        return;
    }
}
