package R2;

import Y2.f;
import android.content.Context;
import f3.C0720b;
import g3.C0742e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f4978a = Boolean.FALSE;

    private static int a(C0720b c0720b) {
        String str = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        String strM = c0720b.m("DAILY_ACTIVED_LAST", BuildConfig.FLAVOR);
        C0742e.c("BootUpHelper", "beforeGetDailyActive ------------------ current states: today:" + str + ", last:" + strM);
        if (str.equals(strM)) {
            return 0;
        }
        C0742e.i("BootUpHelper", "a new day");
        c0720b.a("DAILY_ACTIVED_LAST", str);
        return 1;
    }

    public static void b(Context context) {
        if (Q2.a.f4905a) {
            C0742e.l("BootUpHelper", "onBootUpEvent InitConfig.noBootUp is true");
            return;
        }
        if (f4978a.booleanValue()) {
            C0742e.l("BootUpHelper", "onBootUpEvent mBootUpEventComplete is true");
            return;
        }
        try {
            C0720b c0720b = new C0720b(context, "com.stepos.statsapp.v3.common");
            HashMap map = new HashMap();
            map.put("daily_actived", String.valueOf(a(c0720b)));
            map.put("global_actived", String.valueOf(c(c0720b)));
            f.m().o("_bootup_", map);
            f4978a = Boolean.TRUE;
        } catch (Exception e6) {
            C0742e.d("BootUpHelper", "onBootUpEvent error, " + e6);
        }
    }

    private static int c(C0720b c0720b) {
        if (!c0720b.n("GLOBAL_ACTIVED", true)) {
            return 0;
        }
        c0720b.f("GLOBAL_ACTIVED", false);
        return 1;
    }
}
