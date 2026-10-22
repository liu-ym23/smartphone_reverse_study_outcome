package fa;

import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;
import ta.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f8778a = Boolean.FALSE;

    public static int a(sa.a aVar) {
        String str = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        SharedPreferences sharedPreferences = aVar.f11898a;
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
