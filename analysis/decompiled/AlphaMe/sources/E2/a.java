package E2;

import T2.d;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f409a = Boolean.FALSE;

    public static int a(S2.a aVar) {
        String str = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        SharedPreferences sharedPreferences = aVar.f1791a;
        String string = sharedPreferences.getString("DAILY_ACTIVED_LAST", "");
        d.a("BootUpHelper", "beforeGetDailyActive ------------------ current states: today:" + str + ", last:" + string);
        if (str.equals(string)) {
            return 0;
        }
        d.d("BootUpHelper", "a new day");
        sharedPreferences.edit().putString("DAILY_ACTIVED_LAST", str).apply();
        return 1;
    }
}
