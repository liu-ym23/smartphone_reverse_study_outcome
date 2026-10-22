package Z7;

import Z7.C1131c.a;
import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class O {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f7339a = true;

    /* renamed from: b, reason: collision with root package name */
    public static List<N> f7340b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static boolean f7341c;

    /* renamed from: d, reason: collision with root package name */
    public static V f7342d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f7343e;

    public static synchronized void a(N n10) {
        if (!f7340b.contains(n10)) {
            f7340b.add(n10);
        }
    }

    public static synchronized void b(Context context, String str, boolean z10, V7.a aVar) {
        if (f7343e) {
            C1139k.i("[init] initial Multi-times, ignore this.", new Object[0]);
            return;
        }
        if (context == null) {
            Log.w(C1139k.f7547b, "[init] context is null, check it.");
            return;
        }
        if (str == null) {
            Log.e(C1139k.f7547b, "init arg 'crashReportAppID' should not be null!");
            return;
        }
        f7343e = true;
        if (z10) {
            f7341c = true;
            C1139k.f7548c = true;
            C1139k.i("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
            C1139k.j("--------------------------------------------------------------------------------------------", new Object[0]);
            C1139k.i("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
            C1139k.i("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
            C1139k.i("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
            C1139k.i("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
            C1139k.j("--------------------------------------------------------------------------------------------", new Object[0]);
            C1139k.f("[init] Open debug mode of Bugly.", new Object[0]);
        }
        C1139k.d(" crash report start initializing...", new Object[0]);
        C1139k.f("[init] Bugly start initializing...", new Object[0]);
        C1139k.d("[init] Bugly complete version: v%s", "4.1.9.3");
        Context contextA = C1143o.a(context);
        C1130b c1130bH = C1130b.h(contextA);
        c1130bH.C();
        C1142n.a(contextA);
        f7342d = V.g(contextA, f7340b);
        C1136h.d(contextA);
        C1131c.b(contextA, f7340b);
        T tB = T.b(contextA);
        if (c(c1130bH)) {
            f7339a = false;
            return;
        }
        c1130bH.f7425G = str;
        c1130bH.m("APP_ID", str);
        C1139k.d("[param] Set APP ID:%s", str);
        for (int i10 = 0; i10 < f7340b.size(); i10++) {
            try {
                if (tB.j(f7340b.get(i10).f7336a)) {
                    f7340b.get(i10).b(contextA, z10, aVar);
                }
            } catch (Throwable th) {
                if (!C1139k.e(th)) {
                    th.printStackTrace();
                }
            }
        }
        S.b(contextA, aVar);
        C1131c c1131cA = C1131c.a();
        c1131cA.f7498b.c(c1131cA.new a(), 0L);
        C1139k.f("[init] Bugly initialization finished.", new Object[0]);
    }

    public static boolean c(C1130b c1130b) {
        List<String> list = c1130b.f7433O;
        return list != null && list.contains("bugly");
    }
}
