package u5;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import com.stepos.agentbus.config.EnvProvider;
import j1.j2;
import m.x;

/* loaded from: classes.dex */
public final class f implements EnvProvider {

    /* renamed from: b, reason: collision with root package name */
    public static volatile String f10122b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f10123c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile Context f10124d;

    /* renamed from: a, reason: collision with root package name */
    public static final f f10121a = new f();

    /* renamed from: e, reason: collision with root package name */
    public static final Object f10125e = new Object();

    public static String a(Context context) {
        Context applicationContext;
        String str = f10122b;
        if (str != null) {
            return str;
        }
        Context context2 = f10124d;
        if (context2 == null) {
            if (context == null || (applicationContext = context.getApplicationContext()) == null) {
                applicationContext = null;
            } else {
                f10124d = applicationContext;
            }
            context2 = applicationContext;
            if (context2 == null) {
                return "prod";
            }
        }
        synchronized (f10125e) {
            String str2 = f10122b;
            if (str2 != null) {
                return str2;
            }
            String str3 = "prod";
            try {
                if (q7.k.a(Settings.Secure.getString(context2.getContentResolver(), "net_env"), "test")) {
                    str3 = "test";
                }
            } catch (Throwable th) {
                Log.e("EnvManager", "read net_env failed", th);
            }
            f10122b = str3;
            b(context2);
            Log.i("EnvManager", "Current environment: " + str3 + " (cached)");
            return str3;
        }
    }

    public static void b(Context context) {
        if (f10123c) {
            return;
        }
        try {
            context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("net_env"), false, new j2(new Handler(Looper.getMainLooper()), context));
            f10123c = true;
        } catch (Throwable th) {
            x.v("register net_env observer failed: ", th.getMessage(), "EnvManager");
        }
    }

    @Override // com.stepos.agentbus.config.EnvProvider
    public final String currentEnv() {
        return a(null);
    }

    @Override // com.stepos.agentbus.config.EnvProvider
    public final boolean isTestEnv() {
        return a(null).equals("test");
    }
}
