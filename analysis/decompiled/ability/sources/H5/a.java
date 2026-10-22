package H5;

import W5.c;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f754a = Boolean.FALSE;

    public static int a(V5.a aVar) {
        String str = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        SharedPreferences sharedPreferences = aVar.f1385a;
        String string = sharedPreferences.getString("DAILY_ACTIVED_LAST", "");
        c.a("BootUpHelper", "beforeGetDailyActive ------------------ current states: today:" + str + ", last:" + string);
        if (str.equals(string)) {
            return 0;
        }
        c.d("BootUpHelper", "a new day");
        sharedPreferences.edit().putString("DAILY_ACTIVED_LAST", str).apply();
        return 1;
    }
}
