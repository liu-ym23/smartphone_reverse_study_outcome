package m2;

import android.content.Context;
import android.provider.Settings;
import org.libpag.BuildConfig;

/* renamed from: m2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0863f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f18813a;

    /* renamed from: b, reason: collision with root package name */
    private static String f18814b;

    /* renamed from: c, reason: collision with root package name */
    private static String f18815c;

    /* renamed from: d, reason: collision with root package name */
    private static String f18816d;

    /* renamed from: e, reason: collision with root package name */
    private static String f18817e;

    /* renamed from: f, reason: collision with root package name */
    private static String f18818f;

    /* renamed from: g, reason: collision with root package name */
    private static String f18819g;

    private C0863f() {
    }

    private static void a() {
        if (f18813a) {
            return;
        }
        f(P1.a.a());
    }

    public static String b() {
        a();
        return f18816d;
    }

    public static String c() {
        a();
        return f18819g;
    }

    static String d(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "net_env");
        return string == null ? BuildConfig.FLAVOR : string;
    }

    public static String e() {
        a();
        return f18817e;
    }

    public static void f(Context context) {
        if (f18813a) {
            return;
        }
        synchronized (C0863f.class) {
            try {
                if (f18813a) {
                    return;
                }
                f18814b = g(context.getApplicationContext());
                f18815c = "https://breakingscam." + f18814b + "/";
                StringBuilder sb = new StringBuilder();
                sb.append(f18815c);
                sb.append("v3/");
                f18816d = sb.toString();
                f18817e = "https://breakingscam." + f18814b;
                f18818f = "https://bs-res." + f18814b + "/t.html";
                f18819g = "https://resm-bs-res." + f18814b + "/app_icon/";
                f18813a = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static String g(Context context) {
        String strD = d(context);
        strD.getClass();
        switch (strD) {
            case "dev":
                return "d-stepos.com";
            case "stg":
                return "s-stepos.com";
            case "test":
                return "t-stepos.com";
            default:
                return "stepaos.com";
        }
    }
}
