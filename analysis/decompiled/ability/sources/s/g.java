package s;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import e2.C1406c;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5973a;
    public final C1406c b;
    public final SharedPreferences c;
    public final SharedPreferences d;
    public final SharedPreferences e;
    public final HashSet f;
    public final HashSet g;
    public int h = 0;
    public int i = 27;

    /* renamed from: j, reason: collision with root package name */
    public long f5974j = 0;
    public int k = 0;
    public long l = 0;
    public final String m;
    public final boolean n;

    public g(Application application, C1406c c1406c) {
        this.m = null;
        this.f5973a = application;
        this.b = c1406c;
        c1406c.getClass();
        StringBuilder sbF = M.a.f("applog_stats_");
        sbF.append(c1406c.f4335a);
        this.e = application.getSharedPreferences(sbF.toString(), 0);
        StringBuilder sbF2 = M.a.f("header_custom_");
        sbF2.append(c1406c.f4335a);
        this.c = application.getSharedPreferences(sbF2.toString(), 0);
        StringBuilder sbF3 = M.a.f("last_sp_session_");
        sbF3.append(c1406c.f4335a);
        this.d = application.getSharedPreferences(sbF3.toString(), 0);
        this.f = new HashSet();
        this.g = new HashSet();
        this.m = c1406c.l;
        this.n = c1406c.m;
    }

    public final String a() {
        Context context = this.f5973a;
        C1406c c1406c = this.b;
        String str = c1406c.c;
        if (TextUtils.isEmpty(str)) {
            c1406c.getClass();
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("UMENG_CHANNEL");
            } catch (Throwable th) {
                w.h.a("getChannel", th);
            }
        }
        return str;
    }

    public final boolean b() {
        C1406c c1406c = this.b;
        if (c1406c.e == 0) {
            String str = U7.a.c;
            if (TextUtils.isEmpty(str)) {
                U7.a.c = D2.b.a();
                if (w.h.b) {
                    StringBuilder sbF = M.a.f("getProcessName, ");
                    sbF.append(U7.a.c);
                    w.h.a(sbF.toString(), null);
                }
                str = U7.a.c;
            }
            if (TextUtils.isEmpty(str)) {
                c1406c.e = 0;
            } else {
                c1406c.e = str.contains(":") ? 2 : 1;
            }
        }
        return c1406c.e == 1;
    }
}
