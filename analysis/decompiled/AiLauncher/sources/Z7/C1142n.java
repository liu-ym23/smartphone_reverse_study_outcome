package Z7;

import android.content.Context;
import android.os.Process;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: Z7.n, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1142n {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f7552a = true;

    /* renamed from: b, reason: collision with root package name */
    public static SimpleDateFormat f7553b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f7554c = true;

    /* renamed from: d, reason: collision with root package name */
    public static StringBuilder f7555d = null;

    /* renamed from: e, reason: collision with root package name */
    public static StringBuilder f7556e = null;

    /* renamed from: f, reason: collision with root package name */
    public static String f7557f = null;

    /* renamed from: g, reason: collision with root package name */
    public static String f7558g = null;

    /* renamed from: h, reason: collision with root package name */
    public static Context f7559h = null;

    /* renamed from: i, reason: collision with root package name */
    public static String f7560i = null;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f7561j = false;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f7562k = false;

    /* renamed from: l, reason: collision with root package name */
    public static ExecutorService f7563l;

    /* renamed from: m, reason: collision with root package name */
    public static int f7564m;

    /* renamed from: n, reason: collision with root package name */
    public static final Object f7565n = new Object();

    static {
        try {
            f7553b = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            C1139k.g(th.getCause());
        }
    }

    public static synchronized void a(Context context) {
        if (f7561j || context == null || !f7554c) {
            return;
        }
        try {
            f7563l = Executors.newSingleThreadExecutor();
            f7556e = new StringBuilder(0);
            f7555d = new StringBuilder(0);
            f7559h = context;
            f7557f = C1130b.h(context).f7455f;
            f7558g = "";
            f7560i = f7559h.getFilesDir().getPath() + "/buglylog_" + f7557f + "_" + f7558g + ".txt";
            f7564m = Process.myPid();
        } catch (Throwable unused) {
        }
        f7561j = true;
    }

    public static byte[] b() {
        if (!f7552a) {
            return d();
        }
        if (f7554c) {
            return C1143o.x(f7556e.toString(), "BuglyLog.txt");
        }
        return null;
    }

    public static String c() {
        P p10;
        try {
            C1130b c1130bL = C1130b.l();
            if (c1130bL == null || (p10 = c1130bL.f7464j0) == null) {
                return null;
            }
            return p10.b();
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] d() {
        if (!f7554c) {
            return null;
        }
        if (f7562k) {
            C1139k.d("[LogUtil] Get user log from native.", new Object[0]);
            String strC = c();
            if (strC != null) {
                C1139k.d("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(strC.length()));
                return C1143o.x(strC, "BuglyNativeLog.txt");
            }
        }
        StringBuilder sb2 = new StringBuilder();
        synchronized (f7565n) {
            try {
                StringBuilder sb3 = f7556e;
                if (sb3 != null && sb3.length() > 0) {
                    sb2.append(f7556e.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return C1143o.x(sb2.toString(), "BuglyLog.txt");
    }
}
